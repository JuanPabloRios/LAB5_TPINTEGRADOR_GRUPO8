package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

@Controller
public class ABMClienteController {

    @RequestMapping("redirigirListadoClientes.html")
    public ModelAndView irAListadoClientes(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("listaClientes",UsuarioSelector.obtenerTodosLosClientes());
        mv.setViewName("AdministradorHome");
        return mv;
    }

    @RequestMapping("redirigirListadoCuentasAdmin.html")
    public ModelAndView isAListadoCuentas(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);
        //ACA BUSCAR TODAS LAS CUENTAS Y AGREGARLAS AL MODELO
        mv.setViewName("ACA VA EL NOMBRE DE LA VISTA PARA LISTAR CENTAS");
        return mv;
    }

    //eliminarCliente.html nombreCuenta y idUsuario

    //guardarCliente.html 

    //editarCuenta.html idUsuario, idCuenta, nombreCuenta
}