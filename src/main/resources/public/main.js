$(document).ready(function(){
alert("Consulta cliente")
consultarclientes();

function consultarclientes(){
$.ajax({
url:"http://localhost:8080/cliente",
type:"GET",
dataType:"JSON",
success:function(respuesta){
console.log(respuesta)
mostrartabla(respuesta)
}

});

}
function mostrartabla(filas){
let tabla="<table>";
for(i=0;i<filas.length;i++){
tabla+="<tr>";
tabla+="<td>"+filas[i].documento+"</td>"
tabla+="<td>"+filas[i].nombre+"</td>"
tabla+="<td>"+filas[i].apellido+"</td>"
tabla+="<td>"+filas[i].correo+"</td>"
tabla+="<td>"+filas[i].celular+"</td>"
tabla+="</tr>"

}

tabla+="</table>"
$("#contenedor").append(tabla)
}



function guardarCliente(){
 let datos={
 documento:$("#doc").val(),
 nombre:$("#nom").val(),
 apellido:$("#ape").val(),
 correo:$("#cor").val(),
 celular:$("#cel").val()
 }

 let datosEnvio=JSON.stringify(datos);
 $.ajax({
 url:"http://localhost:8080/cliente",
 type:"POST",
 data:datosEnvio,
 contentType:"application/JSON",
 dataType:"JSON",
 success:function(respuesta){
 if(respuesta!=null){
 alert("Datos guardados")
 }
 else{
 alert("Los datos no se guardaron")
 }
 }

 });

}

$("#btnguardar").on('click',function(){
  alert("en guardar")
  guardarCliente()
  consultarclientes()
});

function actualizarCliente(){
 let datos={
 documento:$("#doc").val(),
 nombre:$("#nom").val(),
 apellido:$("#ape").val(),
 correo:$("#cor").val(),
 celular:$("#cel").val()
 }

 let datosEnvio=JSON.stringify(datos);
 $.ajax({
 url:"http://localhost:8080/cliente",
 type:"PUT",
 data:datosEnvio,
 contentType:"application/JSON",
 dataType:"JSON",
 success:function(respuesta){
 if(respuesta!=null){
 alert("Datos actualizados")
 }
 else{
 alert("Los datos no se actualizaron")
 }
 }

 });

}

$("#btnactualizar").on('click',function(){
actualizarCliente()
consultarclientes()
})
});