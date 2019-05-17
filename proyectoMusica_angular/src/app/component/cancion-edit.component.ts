import { Cancion } from '../models/cancion';
import { CancionesService } from '../services/cancion.services';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Component } from '@angular/core';

@Component({
    selector:'cancion-edit',
    templateUrl: '../views/cancion-add.html',
    providers: [CancionesService]
})


export class CancionEditComponent{

    public title: string;
    public cancion: Cancion;


    constructor(
        private _route: ActivatedRoute,
        private _router: Router,
        private _cancionService: CancionesService
    ){
        this.title='Editar Cancion';

    }

    ngOnInit(){
      console.log(  this.title);
      //this.cancion= new Cancion('1','','1','','')
      this.getCancion();
    }

    getCancion() {
        //Recoger el parametro de la url
        this._route.params.forEach((params: Params) => {
            let id = params['id'];
            // alert(id);

            this._cancionService.getCancion(id).subscribe(
                response => {
                    console.log(response);
                    this.cancion = response[0];
                },
                error => {
                    console.log(<any>error);
                }
             );
        });



    }




}