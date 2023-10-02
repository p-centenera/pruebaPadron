package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;
public class InterfazUsuario
{
	OficinaPadron padron;
	public InterfazUsuario(){
		padron=new OficinaPadron();
	}

	public  boolean ejecutar(String instruccionS){ 
		String [] instruccion=instruccionS.split(" ");
		if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1){
 			mostrarOficinaPadron(padron);
		}else if (instruccion[0].equalsIgnoreCase("anadir") && instruccion.length == 4){
			padron.annadir(new Habitante(instruccion[1], instruccion[2], instruccion[3]));
			System.out.println("Habitante añadido correctamente");
		}else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1)
			System.out.print("introduzca una de las siguientes peticiones: \n anadir nombre apellido1 apellido2: añadir contacto a la agenda\n mostrar: listar la agenda\n exit: salir\n");
		else if (instruccion[0].equals("exit")){
			padron.volcarContactos();
			return false;
		}
		else{
			System.out.println("Error en la instrucción");
		}
		return true;
	}

	private  void mostrarOficinaPadron(OficinaPadron padron){
		ArrayList<Habitante> habitantes = padron.getHabitantesPadron();
		for(Habitante habitante : habitantes){ 
			System.out.println(habitante.getNombre() + " " +habitante.getApellido1() + " " +habitante.getApellido2());
		}
		System.out.println("El numero total de habitantes es " + padron.calcularNumeroHabitantes());

	}
	public String leerPeticion(){
		Scanner sc = new Scanner(System.in);
  		System.out.print("?>");
		String cadena = sc.nextLine();
		return cadena;
	}
}


