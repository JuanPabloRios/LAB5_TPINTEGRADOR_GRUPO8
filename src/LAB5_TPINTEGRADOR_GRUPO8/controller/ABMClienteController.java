package LAB5_TPINTEGRADOR_GRUPO8.controller;


import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;
import LAB5_TPINTEGRADOR_GRUPO8.service.UsuarioService;

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
    
    @RequestMapping("eliminarCliente.html")
    public ModelAndView eliminarCliente(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);
        UsuarioService.eliminarUsuarioPorId(idUsuario);
        
        
		mv.addObject("listaClientes",UsuarioSelector.obtenerTodosLosClientes());

        mv.addObject("informarEliminadoCorrecto",true);
		mv.setViewName("AdministradorHome");
        return mv;
    }
    
    //guardarCliente.html 
    @RequestMapping("guardarCliente.html")
    public ModelAndView guardarCliente(String nombreCuenta, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
    									String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
    									String nombreUsuario, String contrasenia) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);

        UsuarioService.crearUsuario(nombreCliente, apellidoCliente, dniCliente, fechaNacimientoCliente, 
				nacionalidadCliente, direccionCliente, sexoCliente, provinciaCliente, localidadCliente,
				nombreUsuario, contrasenia);
    
		mv.addObject("listaClientes",UsuarioSelector.obtenerTodosLosClientes());
        mv.addObject("informarUsuarioCreado",true);
		mv.setViewName("AdministradorHome");
        return mv;
    }
    
    //editarCuenta.html idUsuario, idCuenta, nombreCuenta  
    
    //editarCliente.html Usuario completo.
    @RequestMapping("editCliente.html")
    public ModelAndView editarCliente(String nombreCuenta,Integer idUsuario, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
										String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
										String nombreUsuario, String contrasenia) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);

        UsuarioService.editarUsuario(idUsuario, nombreCliente, apellidoCliente, dniCliente, fechaNacimientoCliente, 
				nacionalidadCliente, direccionCliente, sexoCliente, provinciaCliente, localidadCliente,
				nombreUsuario, contrasenia);
    
		mv.addObject("listaClientes",UsuarioSelector.obtenerTodosLosClientes());
        mv.addObject("informarUsuarioEditado",true);
		mv.setViewName("AdministradorHome");
        return mv;
    }
    
    
}