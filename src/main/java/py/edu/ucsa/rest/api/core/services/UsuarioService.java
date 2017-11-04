package py.edu.ucsa.rest.api.core.services;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Usuario;

public interface UsuarioService {
	Usuario getById (long id);
	Usuario getByUsuario (String usuario);
	void guardarUsuario (Usuario usuario);
	void eliminarById (Usuario usuario);
	List<Usuario> listarTodos();
	void EliminarTodos();
	boolean isExisteUsuario (Usuario usuario);
}
