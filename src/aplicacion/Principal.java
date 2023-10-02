package aplicacion;
import presentacion.*;
public class Principal{
	public static void main(String[] args){ 
		InterfazUsuario IU=new InterfazUsuario();
		String peticion;
		IU.ejecutar("ayuda");// para que muestre la ayuda al principio
		do {
			peticion=IU.leerPeticion();
		} while (IU.ejecutar(peticion));
		System.out.print("fin. Guardando la libreta");
	}
}
