package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente(long idCliente)throws Exception{
		Cliente c= dao.traerCliente(idCliente);
		if(c==null)
			throw new Exception("El cliente no existe");
		return c;
	}
	public Cliente traerCliente(int dni)throws Exception{
		Cliente c = dao.traerCliente(dni);
		if(c==null)
			throw new Exception("El cliente no existe");
		return c;
	}
	public int agregar(String apellido,String nombre,int dni,GregorianCalendar fechaDeNacimiento)throws Exception{
		if(dao.traerCliente(dni)!=null)
			throw new Exception("Ya existe un cliente con el mismo dni");
		Cliente c= new Cliente(apellido, nombre, dni,fechaDeNacimiento);
		return dao .agregar(c);
	}
	public void modificar(Cliente c)throws Exception{
		if(dao.traerCliente(c.getDni())!=null  &&  dao.traerCliente(c.getIdCliente())!=null )
			throw new Exception("Ya existe un cliente con el mismo dni");
		/* implementar antes de actualizar que no exista un cliente
		 * con el mismo documento a modificar
		 * y con el mismo id, lanzar la Exception */
		dao.actualizar(c);
	}
	public void eliminar(long idCliente)throws Exception{/*en este caso es física en gral. no se se aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga dependencias*/
		Cliente c= dao.traerCliente(idCliente);
		if(c==null)
			throw new Exception("El cliente no existe");
		dao.eliminar(c);
	}
	public List<Cliente> traerCliente(){
		return dao.traerCliente();
	}
}