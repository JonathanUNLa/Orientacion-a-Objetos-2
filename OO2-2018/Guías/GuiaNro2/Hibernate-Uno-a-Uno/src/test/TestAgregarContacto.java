package test;
import dao.ClienteDao;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;
public class TestAgregarContacto {
	public static void main(String[] args) {
		ClienteDao dao= new ClienteDao();
		long idCliente=1;
		Cliente c=dao.traerCliente(idCliente);
		System. out .println(c);
		Contacto con = new Contacto("joni@unla.edu.ar","15-2637-1158","011-4264-2701", c);
		ContactoDao dao1= new ContactoDao();
		dao1.agregar(con);
	}
}