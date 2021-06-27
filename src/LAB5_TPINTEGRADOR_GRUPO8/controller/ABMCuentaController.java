package LAB5_TPINTEGRADOR_GRUPO8.controller;

import java.util.List; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody; 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector; 
 

@Controller
public class ABMCuentaController {
	
    //Convertimos la lista a JSON y la usamos en el modal para seleccionar el cliente
	@RequestMapping(value="obtenerClientes.html", method = RequestMethod.GET) 
	public @ResponseBody String obtenerClientes() throws JsonProcessingException  {  
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    List<Usuario> res = UsuarioSelector.obtenerTodosLosClientes();
        return mapper.writeValueAsString(res);
    }
	
	
}
