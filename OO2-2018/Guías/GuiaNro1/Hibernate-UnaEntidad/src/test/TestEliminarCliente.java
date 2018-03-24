package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {
	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		long id=1;		
		try {
			Cliente c=abm.traerCliente(id);
			System.out.println("Cliente a eliminar -->" +c);
			abm.eliminar(c.getIdCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}