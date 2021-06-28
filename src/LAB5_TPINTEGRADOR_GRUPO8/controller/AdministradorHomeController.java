package LAB5_TPINTEGRADOR_GRUPO8.controller; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;

//Controlador de la vista AdministradorHome
@Controller
public class AdministradorHomeController {

    @RequestMapping("editarCliente.html")
    public ModelAndView editarCliente(Integer idUsuario, String nombreCuenta) { 
        ModelAndView mv = new ModelAndView();
        mv.addObject("idUsuario",idUsuario); 
        mv.addObject("cliente", UsuarioDao.obtenerUsuarioPorID(idUsuario)); 
        mv.addObject("listaCuentas", CuentaDao.obtenerTodasLasCuentasDeClientePorId(idUsuario)); 
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
        mv.addObject("listaCuentas",CuentaDao.obtenerTodasLasCuentas()); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.setViewName("ListarCuentas");
        return mv;
    }
    
    @RequestMapping("regirigirAListadoDeClientes.html")
    public ModelAndView regirigirAListadoDeClientes(String nombreCuenta) { 
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("listaClientes",UsuarioDao.obtenerTodosLosClientes()); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.setViewName("AdministradorHome");
        return mv;
    }

}