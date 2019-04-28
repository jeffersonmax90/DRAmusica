from urllib.request import urlopen
import sys
sys.path.append('c:\python36\lib\site-packages')
from bs4 import BeautifulSoup
import html5lib
from array import array
import requests

html = urlopen("https://www.elportaldemusica.es/lists/top-100-streaming/2019/13")
 
res = BeautifulSoup(html.read(),"html5lib")

posiciones = res.find_all("p",{"class":"single-list-entry-rank-position"})
titulos = res.find_all("div",{"class":"name"})
artistas = res.find_all("div",{"class":"related"})
imagenes = res.find_all("div",{"class":"thumbnail default cover"})


for i in range (len(posiciones)):
   posiccionCancion = posiciones[i].text
   titulo = str(titulos[i].text).lstrip().rstrip()
   artista = str(artistas[i].text).lstrip().rstrip()
   imagen = imagenes[i].attrs['style'].replace('background-image:url(', '').replace(');','')
   print(posiccionCancion + " - " + titulo +" - "+ artista +" - "+ imagen)
   
   data = {
      'posiccionCancion': posiccionCancion,
      'titulo': titulo,
      'artista':artista,
      'imagen': imagen
            }

   uri = "http://localhost:9188/api/addCancion2"

   print(uri)
   requests.post(uri,json=data)

  



