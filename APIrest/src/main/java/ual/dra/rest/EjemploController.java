package ual.dra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class EjemploController {
	@Autowired
	private CancionRepository cancionRepository;
	
	@GetMapping("/hola")
	@ResponseBody
	public String hola(){
		return "hola";
	}
	
	
	@PostMapping("/addCancion/{posicion}/{titulo}/{artista}/{imagen}")
	public  void saveCancion(@PathVariable String posicion,
			@PathVariable String titulo,
			@PathVariable String artista,
			@PathVariable String imagen){
		
		Cancion cancion = new Cancion(posicion,titulo,artista,imagen);
		cancionRepository.save(cancion);
	}
	
	@PostMapping("/addCancion2")
	@ResponseBody
	public String addCancion(@RequestBody Cancion cancion) {
		cancionRepository.save(cancion);
	  return "OK";
	}
	
	@GetMapping("/getCanciones")
	@ResponseBody
	public List<Cancion> getAllCanciones(){
		return (List<Cancion>)cancionRepository.findAll();
	}
	
	@PostMapping("/borrarCancion/{idCancion}")
	public String borrarCancion(@PathVariable Long idCancion){
		cancionRepository.deleteById(idCancion);
		return "OK";
	}
	
	
}
