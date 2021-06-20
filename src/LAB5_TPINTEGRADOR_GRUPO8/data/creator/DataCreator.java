package LAB5_TPINTEGRADOR_GRUPO8.data.creator;
import java.util.Date;
import java.util.List;

import org.hibernate.Session; 
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;

public class DataCreator {
    
    public static void createData() {
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion();  
        se.beginTransaction(); 
        List<Usuario> usuarios = UsuarioSelector.obtenerTodosLosUsarios();
        if(usuarios.isEmpty()) {
            //TIPOS DE USUARIO----------------------------------------
            TiposDeUsuarios TUAdmin = new TiposDeUsuarios();
            TUAdmin.setDescripcion("Administrador");
            se.save(TUAdmin);
            TiposDeUsuarios TUCliente = new TiposDeUsuarios();
            TUCliente.setDescripcion("Cliente");
            se.save(TUCliente);
            //--------------------------------------------------------
            
            //USUARIO ADMINISTRADOR-----------------------------------
            Usuario usAdmin = new Usuario();
            usAdmin.setNombre("Homero");
            usAdmin.setApellido("Simpson");
            usAdmin.setContrasenia("admin");
            usAdmin.setUsuario("admin");   
            usAdmin.setDireccion("Av. Siempreviva 123");
            usAdmin.setDNI(12312312);
            usAdmin.setEstado(true);
            usAdmin.setNacionalidad("Estados Unidos");
            usAdmin.setSexo("M");
            usAdmin.setFecha_de_nacimiento(new Date(1816,9,9));  
            usAdmin.setTipoDeUsuario(TUAdmin);  
            se.save(usAdmin); 
            //--------------------------------------------------------
            
            //USUARIOS CLIENTES---------------------------------------
            Usuario cliente1 = new Usuario();
            cliente1.setNombre("Ezequiel");
            cliente1.setApellido("Rios");
            cliente1.setUsuario("Ezequiel");   
            cliente1.setContrasenia("Rios");
            cliente1.setDireccion("Callao 1425");
            cliente1.setDNI(32444555);
            cliente1.setEstado(true);
            cliente1.setNacionalidad("Argentina");
            cliente1.setSexo("M");
            cliente1.setFecha_de_nacimiento(new Date(1991,03,27));  
            cliente1.setTipoDeUsuario(TUCliente);  
            se.save(cliente1); 
            
            Usuario cliente2 = new Usuario();
            cliente2.setNombre("Rocio");
            cliente2.setApellido("Favre");
            cliente2.setUsuario("Rocio");   
            cliente2.setContrasenia("Favre");
            cliente2.setDireccion("Rivadavia 3541");
            cliente2.setDNI(34253492);
            cliente2.setEstado(true);
            cliente2.setNacionalidad("Argentina");
            cliente2.setSexo("M");
            cliente2.setFecha_de_nacimiento(new Date(1990,5,5));  
            cliente2.setTipoDeUsuario(TUCliente);  
            se.save(cliente2); 
            //-------------------------------------------------------- 
            
            //TIPOS DE CUENTA-----------------------------------------
            TiposDeCuentas dolares = new TiposDeCuentas();
            dolares.setDescripcion("Caja de Ahorro en Dolares");
            se.save(dolares); 
            TiposDeCuentas pesos = new TiposDeCuentas();
            pesos.setDescripcion("Caja de Ahorro en Pesos");
            se.save(pesos);
            //--------------------------------------------------------
            
            //CUENTAS-------------------------------------------------
            Cuentas cuenta1 = new Cuentas();
            cuenta1.setTipoCuenta(dolares);
            cuenta1.setCBU("3254039485938472"); 
            cuenta1.setFechaCreacion(new Date(System.currentTimeMillis()));
            cuenta1.setUsuario(cliente1);
            cuenta1.setSaldo(10000.00);
            se.save(cuenta1);
            //--------------------------------------------------------
            
            se.getTransaction().commit(); 
        }
        ch.cerrarSession();
        
    }
}