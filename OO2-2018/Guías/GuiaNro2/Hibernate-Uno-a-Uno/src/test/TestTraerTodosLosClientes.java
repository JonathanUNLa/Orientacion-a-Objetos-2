package test;

import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerTodosLosClientes {
	public static void main(String[] args){
		ClienteABM abm = new ClienteABM();
		List<Cliente> lstClientes=new ArrayList<Cliente>();
		lstClientes=abm.traerCliente();
		for(Cliente cliente: lstClientes){
			System.out.println(cliente);
		}
	}
}
