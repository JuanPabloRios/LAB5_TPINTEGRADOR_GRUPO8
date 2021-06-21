package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscarClienteModalController {

    @RequestMapping("clienteSeleccionado.html")
    public ModelAndView clienteSeleccionado(Integer idUsuario, String nombreCuenta) { 
        ModelAndView mv = new ModelAndView();
        mv.addObject("nombreCuenta",nombreCuenta);
        mv.addObject("idClienteSeleccionado",idUsuario);
        mv.addObject("mostrarModal",false); 
        //FALTARIA VER QUE OTROS DATOS NECESITA PARA REENVIARLOS
        mv.setViewName("Aca va la vista de editar cuenta");
        return mv;
    }
}