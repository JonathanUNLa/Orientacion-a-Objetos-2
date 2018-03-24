package test;
import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		String apellido= "Yañez" ;
		String nombre= "Jonathan" ;
		int documento=45188238;
		GregorianCalendar fechaDeNacimiento= new GregorianCalendar(1998,0,10);
		ClienteABM abm= new ClienteABM();
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento,fechaDeNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}