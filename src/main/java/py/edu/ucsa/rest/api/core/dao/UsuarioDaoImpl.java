package py.edu.ucsa.rest.api.core.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.rest.api.core.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	@Override
	public Usuario getById(int id) {
		Usuario u = getById(id);
		if (u!=null) {
			initializedCollection(u.getPerfiles());
		}
		return u;
	}

	@Override
	public Usuario getByUsuario(String usuario) {
		loger.debug("Usuario"+usuario);
		try {
			Usuario u = (Usuario) getEntityManager()
			.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
			.setParameter("usuario", usuario)
			.getSingleResult();
			if (u!=null) {
				initializedCollection(u.getPerfiles());
			}
			return u; 
		}catch (NoResultException ex) {
			return null;
		}
		
	}

	@Override
	public void insertar(Usuario usuario) {
		super.persistir(usuario);

	}

	@Override
	public void actualizar(Usuario usuario) {
		super.actualizar(usuario);

	}

	@Override
	public void borrarPorUsuario(String usuario) {
		Usuario u = (Usuario) getEntityManager()
		.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
		.setParameter("usuario", usuario)
		.getSingleResult();
		eliminar(u);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		List<Usuario>usuarios = getEntityManager()
		.createQuery("SELECT u FROM usuario u ORDER BY u.nombre ASC")
		.getResultList();
		return usuarios;
	}
	
	protected void initializedCollection (Collection<?> collection) {
		if (collection==null) {
			return;
		}
		collection.iterator().hasNext();
	}
	
}
