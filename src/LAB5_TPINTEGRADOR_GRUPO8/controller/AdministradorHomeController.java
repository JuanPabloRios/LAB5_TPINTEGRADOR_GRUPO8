package LAB5_TPINTEGRADOR_GRUPO8.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

//Controlador de la vista AdministradorHome
@Controller
public class AdministradorHomeController {

    @RequestMapping("editarCliente.html")
    public ModelAndView editarCliente(Integer idUsuario, String nombreCuenta) { 
        ModelAndView mv = new ModelAndView();
        mv.addObject("idUsuario",idUsuario);
        Usuario cliente = UsuarioSelector.obtenerUsuarioPorID(idUsuario);
        System.out.println("Cliente " + cliente.toString());
        mv.addObject("cliente", UsuarioSelector.obtenerUsuarioPorID(idUsuario));
        List<Cuentas> cuentasCliente = CuentaSelector.obtenerTodasLasCuentasDeClientePorId(idUsuario);
        System.out.println("CUENTAS C " + cuentasCliente);
        mv.addObject("listaCuentas", CuentaSelector.obtenerTodasLasCuentasDeClientePorId(idUsuario)); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.setViewName("ABMCliente");
        return mv;
    }

    @RequestMapping("crearNuevoCliente.html")
    public ModelAndView crearNuevoCliente(String nombreCuenta) { 
        ModelAndView mv = new ModelAndView();
        mv.addObject("nombreCuenta",nombreCuenta);
        mv.setViewName("ABMCliente");
        return mv;
    }

    @RequestMapping("redirigirListadoCuentas.html")
    public ModelAndView redirigirAABMCuentas(String nombreCuenta) { 
        ModelAndView mv = new ModelAndView();
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.setViewName("ACA VA LA VISTA DE LISTADO DE CUENTAS");
        return mv;
    }

}