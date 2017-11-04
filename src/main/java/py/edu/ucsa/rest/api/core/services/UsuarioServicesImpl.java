package py.edu.ucsa.rest.api.core.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.ucsa.rest.api.core.dao.UsuarioDao;
import py.edu.ucsa.rest.api.core.model.Usuario;

@Service("usuarioService")
@Transactional
public class UsuarioServicesImpl implements UsuarioService{
	@Autowired
	private UsuarioDao dao;
	
	public List<Usuario> listarTodos(){
		return dao.listarTodos();
	}
	
	public Usuario getById(long id) {
		return dao.getById((int) id);
			
	}
	
	public Usuario getByUsuario(String usuario) {
		return dao.getByUsuario(usuario);
	}
	
	public void guardarUsuario(Usuario usuario) {
		if (usuario.getId()!=null)
			dao.insertar(usuario);
		else
			dao.actualizar(usuario);
	}
	
	public void eliminarTodos() {
	}
	
	@Override	
	public boolean isExisteUsuario(Usuario usuario) {
		return getByUsuario(usuario.getUsuario())!=null;
	}

	public void eliminarById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarById(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarTodos() {
		// TODO Auto-generated method stub
		
	}
	
}
