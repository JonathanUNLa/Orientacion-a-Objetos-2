package test;
import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		long id=1;
		Cliente c=abm.traerCliente(id);
		System.out.println( "Cliente a Modificar -->" +c);
		c.setDni(35000001);
		abm.modificar(c);
		int dni=35000001;
		Cliente cModif=abm.traerCliente(dni);
		System.out.println( "Cliente Modificado -->" +cModif);
	}
}