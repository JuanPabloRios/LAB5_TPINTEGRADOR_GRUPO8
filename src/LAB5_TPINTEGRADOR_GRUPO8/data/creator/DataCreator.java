package LAB5_TPINTEGRADOR_GRUPO8.data.creator;
import java.sql.Date;
import java.util.List; 
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;  
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TipoMovimiento;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;

public class DataCreator {
    
    public static void createData() {
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion();  
        se.beginTransaction(); 
        List<Usuario> usuarios = UsuarioSelector.obtenerTodosLosUsarios();
        if(usuarios.isEmpty()) {
        	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
        	
            //TIPOS DE USUARIO----------------------------------------
            TiposDeUsuarios TUAdmin = (TiposDeUsuarios)appContext.getBean("TipoDeUsuarioAdministrador"); 
            se.save(TUAdmin);
            TiposDeUsuarios TUCliente = (TiposDeUsuarios)appContext.getBean("TipoDeUsuarioCliente"); 
            se.save(TUCliente);
            //--------------------------------------------------------
            
            //USUARIO ADMINISTRADOR-----------------------------------
            Usuario usAdmin = (Usuario)appContext.getBean("UsuarioAdministrador"); 
            usAdmin.setNombre("Homero");
            usAdmin.setApellido("Simpson");
            usAdmin.setContrasenia("admin");
            usAdmin.setUsuario("admin");   
            usAdmin.setDireccion("Av. Siempreviva 123");
            usAdmin.setDNI(12312312); 
            usAdmin.setNacionalidad("Estados Unidos");
            usAdmin.setSexo("M");  
            usAdmin.setFecha_de_nacimiento(Date.valueOf("1987-04-08")); 
            se.save(usAdmin); 
            //--------------------------------------------------------
            
            //USUARIOS CLIENTES---------------------------------------
            Usuario cliente1 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente1.setNombre("Ezequiel");
            cliente1.setApellido("Rios");
            cliente1.setUsuario("Ezequiel");   
            cliente1.setContrasenia("Rios");
            cliente1.setDireccion("Callao 1425");
            cliente1.setDNI(32444555); 
            cliente1.setNacionalidad("Argentina");
            cliente1.setSexo("M");
            cliente1.setFecha_de_nacimiento(Date.valueOf("1991-03-27"));
            se.save(cliente1); 
            
            Usuario cliente2 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente2.setNombre("Rocio");
            cliente2.setApellido("Favre");
            cliente2.setUsuario("Rocio");   
            cliente2.setContrasenia("Favre");
            cliente2.setDireccion("Rivadavia 3541");
            cliente2.setDNI(34253492); 
            cliente2.setNacionalidad("Argentina");
            cliente2.setSexo("M");
            cliente2.setFecha_de_nacimiento(Date.valueOf("1990-05-05")); 
            se.save(cliente2); 
            
            Usuario cliente3 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente3.setNombre("Nicolas");
            cliente3.setApellido("Azpiazu");
            cliente3.setUsuario("Nicolas");   
            cliente3.setContrasenia("Azpiazu");
            cliente3.setDireccion("Av. San Martin 3323");
            cliente3.setDNI(43456343); 
            cliente3.setNacionalidad("Argentina");
            cliente3.setSexo("M");
            cliente3.setFecha_de_nacimiento(Date.valueOf("1989-04-10")); 
            se.save(cliente3); 
            
            Usuario cliente4 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente4.setNombre("Matías");
            cliente4.setApellido("Saura");
            cliente4.setUsuario("Matías");   
            cliente4.setContrasenia("Saura");
            cliente4.setDireccion("Los Alamos 879B");
            cliente4.setDNI(4597080); 
            cliente4.setNacionalidad("Argentina");
            cliente4.setSexo("M");
            cliente4.setFecha_de_nacimiento(Date.valueOf("1987-01-29")); 
            se.save(cliente4); 
            
            Usuario cliente5 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente5.setNombre("Alfredo Modesto");
            cliente5.setApellido("Gomez");
            cliente5.setUsuario("Alfredo");   
            cliente5.setContrasenia("Gomez");
            cliente5.setDireccion("Ayacucho 132 ");
            cliente5.setDNI(97834659); 
            cliente5.setNacionalidad("Paraguay");
            cliente5.setSexo("M");
            cliente5.setFecha_de_nacimiento(Date.valueOf("1952-11-10")); 
            se.save(cliente5); 
            
            Usuario cliente6 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente6.setNombre("Carla");
            cliente6.setApellido("Coello Rodriguez");
            cliente6.setUsuario("Carla");   
            cliente6.setContrasenia("Coello Rodriguez");
            cliente6.setDireccion("Av F De L Cruz 3469 PB 5");
            cliente6.setDNI(23456975); 
            cliente6.setNacionalidad("Colombia");
            cliente6.setSexo("F");
            cliente6.setFecha_de_nacimiento(Date.valueOf("1985-04-11")); 
            se.save(cliente6); 
            
            Usuario cliente7 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente7.setNombre("Vanesa");
            cliente7.setApellido("Echenique Rivadeneira");
            cliente7.setUsuario("Vanesa");   
            cliente7.setContrasenia("Echenique Rivadeneira");
            cliente7.setDireccion("Sesquicent 1185 ");
            cliente7.setDNI(56834984); 
            cliente7.setNacionalidad("Argentina");
            cliente7.setSexo("F");
            cliente7.setFecha_de_nacimiento(Date.valueOf("1977-10-03")); 
            se.save(cliente7); 
            
            Usuario cliente8 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente8.setNombre("Roman");
            cliente8.setApellido("Andueza Aramburu");
            cliente8.setUsuario("Roman");   
            cliente8.setContrasenia("Andueza Aramburu");
            cliente8.setDireccion("Cjal Tribulato 1867");
            cliente8.setDNI(41234987); 
            cliente8.setNacionalidad("Brasil");
            cliente8.setSexo("M");
            cliente8.setFecha_de_nacimiento(Date.valueOf("1973-03-10")); 
            se.save(cliente8); 
            
            Usuario cliente9 = (Usuario)appContext.getBean("UsuarioCliente"); 
            cliente9.setNombre("Antonio");
            cliente9.setApellido("Lopez");
            cliente9.setUsuario("Antonio");   
            cliente9.setContrasenia("Lopez");
            cliente9.setDireccion("11 De Set 4376 PB B");
            cliente9.setDNI(23947586); 
            cliente9.setNacionalidad("Argentina");
            cliente9.setSexo("M");
            cliente9.setFecha_de_nacimiento(Date.valueOf("1988-05-12")); 
            se.save(cliente9); 
            
            //-------------------------------------------------------- 
            
            //TIPOS DE CUENTA-----------------------------------------
            TiposDeCuentas dolares = (TiposDeCuentas)appContext.getBean("TipoCuentaDolares"); 
            se.save(dolares); 
            
            TiposDeCuentas pesos = (TiposDeCuentas)appContext.getBean("TipoCuentaPesos"); 
            se.save(pesos);
            //--------------------------------------------------------
            
            //CUENTAS-------------------------------------------------
            Cuentas cuenta1 = (Cuentas)appContext.getBean("NuevaCuentaDolares"); 
            cuenta1.setCBU("3254039485938472");  
            cuenta1.setUsuario(cliente1);
            cuenta1.setSaldo(10000.00);
            se.save(cuenta1);
            
            Cuentas cuenta2 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta2.setCBU("3254039485938473");  
            cuenta2.setUsuario(cliente1);
            cuenta2.setSaldo(10000.00);
            se.save(cuenta2);
            
            Cuentas cuenta3 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta3.setCBU("3254039485938474");  
            cuenta3.setUsuario(cliente1);
            cuenta3.setSaldo(10000.00);
            se.save(cuenta3);
            
            Cuentas cuenta4 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta4.setCBU("3254039485938475");  
            cuenta4.setUsuario(cliente2);
            cuenta4.setSaldo(10000.00);
            se.save(cuenta4);
            
            Cuentas cuenta5 = (Cuentas)appContext.getBean("NuevaCuentaDolares"); 
            cuenta5.setCBU("3254039485938476");  
            cuenta5.setUsuario(cliente3);
            cuenta5.setSaldo(10000.00);
            se.save(cuenta5);
            
            Cuentas cuenta6 = (Cuentas)appContext.getBean("NuevaCuentaDolares"); 
            cuenta6.setCBU("3254039485938477");  
            cuenta6.setUsuario(cliente4);
            cuenta6.setSaldo(10000.00);
            se.save(cuenta6);
            
            Cuentas cuenta7 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta7.setCBU("3254039485938478");  
            cuenta7.setUsuario(cliente4);
            cuenta7.setSaldo(10000.00);
            se.save(cuenta7);
            
            Cuentas cuenta8 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta8.setCBU("3254039485938479");  
            cuenta8.setUsuario(cliente5);
            cuenta8.setSaldo(10000.00);
            se.save(cuenta8);
            
            Cuentas cuenta9 = (Cuentas)appContext.getBean("NuevaCuentaDolares"); 
            cuenta9.setCBU("3254039485938480");  
            cuenta9.setUsuario(cliente5);
            cuenta9.setSaldo(10000.00);
            se.save(cuenta9);
            
            Cuentas cuenta10 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta10.setCBU("3254039485938481");  
            cuenta10.setUsuario(cliente5);
            cuenta10.setSaldo(10000.00);
            se.save(cuenta10);
            
            Cuentas cuenta11 = (Cuentas)appContext.getBean("NuevaCuentaPesos"); 
            cuenta11.setCBU("3254039485938482");  
            cuenta11.setUsuario(cliente6);
            cuenta11.setSaldo(10000.00);
            se.save(cuenta11);
            //--------------------------------------------------------
            
            //TIPOS DE CUENTA-----------------------------------------
            TipoMovimiento debito = (TipoMovimiento)appContext.getBean("TipoMovimientoDebito");
            se.save(debito); 
            
            TipoMovimiento credito = (TipoMovimiento)appContext.getBean("TipoMovimientoCredito");
            se.save(credito);
            //--------------------------------------------------------
            
            Movimientos movimiento1 = (Movimientos)appContext.getBean("MovimientoDebito");
            movimiento1.setDescripcion("movimiento1"); 
            movimiento1.setImporte(123.2);
            movimiento1.setFecha(new Date(System.currentTimeMillis()));
            movimiento1.setDetalle("detalle movimiento1");
            movimiento1.setUsuario(cuenta1);
            se.save(movimiento1);
            
            Movimientos movimiento2 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento2.setDescripcion("movimiento2"); 
            movimiento2.setImporte(1232.2);
            movimiento2.setFecha(new Date(System.currentTimeMillis()));
            movimiento2.setDetalle("detalle movimiento2");
            movimiento2.setUsuario(cuenta1);
            se.save(movimiento2);
            
            Movimientos movimiento3 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento3.setDescripcion("movimiento3"); 
            movimiento3.setImporte(2323.1);
            movimiento3.setFecha(new Date(System.currentTimeMillis()));
            movimiento3.setDetalle("detalle movimiento3");
            movimiento3.setUsuario(cuenta2);
            se.save(movimiento3);
            
            Movimientos movimiento4 = (Movimientos)appContext.getBean("MovimientoDebito");
            movimiento4.setDescripcion("movimiento4"); 
            movimiento4.setImporte(1000000.1);
            movimiento4.setFecha(new Date(System.currentTimeMillis()));
            movimiento4.setDetalle("detalle movimiento4");
            movimiento4.setUsuario(cuenta3);
            se.save(movimiento4);
            
            Movimientos movimiento5 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento5.setDescripcion("movimiento5"); 
            movimiento5.setImporte(10000.0);
            movimiento5.setFecha(new Date(System.currentTimeMillis()));
            movimiento5.setDetalle("detalle movimiento5");
            movimiento5.setUsuario(cuenta4);
            se.save(movimiento5);
            
            Movimientos movimiento6 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento6.setDescripcion("movimiento6"); 
            movimiento6.setImporte(20000.0);
            movimiento6.setFecha(new Date(System.currentTimeMillis()));
            movimiento6.setDetalle("detalle movimiento6");
            movimiento6.setUsuario(cuenta4);
            se.save(movimiento6);
            
            Movimientos movimiento7 = (Movimientos)appContext.getBean("MovimientoDebito");
            movimiento7.setDescripcion("movimiento7"); 
            movimiento7.setImporte(5342.5);
            movimiento7.setFecha(new Date(System.currentTimeMillis()));
            movimiento7.setDetalle("detalle movimiento7");
            movimiento7.setUsuario(cuenta5);
            se.save(movimiento7);
            
            Movimientos movimiento8 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento8.setDescripcion("movimiento8"); 
            movimiento8.setImporte(2000.5);
            movimiento8.setFecha(new Date(System.currentTimeMillis()));
            movimiento8.setDetalle("detalle movimiento8");
            movimiento8.setUsuario(cuenta6);
            se.save(movimiento8);
            
            Movimientos movimiento9 = (Movimientos)appContext.getBean("MovimientoDebito");
            movimiento9.setDescripcion("movimiento9"); 
            movimiento9.setImporte(1000.5);
            movimiento9.setFecha(new Date(System.currentTimeMillis()));
            movimiento9.setDetalle("detalle movimiento9");
            movimiento9.setUsuario(cuenta6);
            se.save(movimiento9);
            
            Movimientos movimiento10 = (Movimientos)appContext.getBean("MovimientoCredito");
            movimiento10.setDescripcion("movimiento10"); 
            movimiento10.setImporte(1000.5);
            movimiento10.setFecha(new Date(System.currentTimeMillis()));
            movimiento10.setDetalle("detalle movimiento10");
            movimiento10.setUsuario(cuenta7);
            se.save(movimiento10);
            
            se.getTransaction().commit(); 

        	((ConfigurableApplicationContext)appContext).close();
        }
        ch.cerrarSession(); 
    }
}