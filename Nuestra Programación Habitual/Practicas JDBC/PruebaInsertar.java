class PruebaInsertar{

public static void main (String arg []){
Alumno alumno;
ProcesosBD inv;
alumno= new Alumno();
inv= new ProcesosBD();
alumno.setCuenta (2051750);

alumno.setPaterno("Pineda");
alumno.setMaterno("Ruiz");
alumno.setNombre("Sergio");
alumno.setDireccion("Dalias 27");
alumno.setTelefono(57892610);
alumno.setLicenciatura("LIA");
alumno.setSemestre(3);
try{
inv.setAlumno(alumno);
inv.toCrearAlumno();
System.out.println ("Datos guardados con exito");
}
catch(Exception e){
System.out.println ("No se pudo guardar los datos");
}
}
}