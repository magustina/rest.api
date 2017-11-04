package py.edu.ucsa.rest.api.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.rest.api.core.model.Usuario;
import py.edu.ucsa.rest.api.core.services.UsuarioService;

@Controller
@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	public static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("rawtypes")
		@RequestMapping (value="/", method = RequestMethod.GET)
	
	public ResponseEntity <?> listarUsuarios() {
		List<Usuario> usuarios= usuarioService.listarTodos();
		if (usuarios.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity <List<Usuario>>(usuarios, HttpStatus.OK);
	}
	

		//RECUPERAMOS UN USUARIO A PARTIR DE SU ID//
//		@RequestMapping(value="/{id}", method=RequestMethod.GET)
//		public ResponseEntity<?>getUsuario (@PathVariable("id")long id){
//			logger.info("Vamos a obtener el usuario con ID{}",id);
//			UsuarioDTO usuario = usuarioService.getById(id);
//			if (usuario== null) {
//				logger.error("no se encontró ningún usuario con id{}", id);
//				return new ResponseEntity<ErrorDTO>(new ErrorDTO("no se encontrço ningún usuario con ID" + id), HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
//		}
//		
//		//CREAMOS UN USUARIO//
//		@RequestMapping(value="/", method=RequestMethod.POST)
//		public ResponseEntity<?> crearUsuario (@RequestBody UsuarioDTO usuario, UriComponentsBuilder ucBuilder){
//			logger.info("Creando el Usuario: {}",usuario);
//			if (usuarioService.isExisteUsuario(usuario)) {
//				logger.error("Inserción fallida. Ya existe un registro con el Usuario{}", usuario.getUsuario());
//				return new ResponseEntity<ErrorDTO>(new ErrorDTO("Inserción fallida. Ya existe un registro con el Usuario" + usuario.getUsuario()), HttpStatus.CONFLICT);
//			}
//			usuarioService.crearUsuario(usuario);
//			
//			HttpHeaders headers = new HttpHeaders();
//			headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
//			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//		}
//		
//		//ACTUALIZAMOS DATOS DE UN USUARIO//
}



