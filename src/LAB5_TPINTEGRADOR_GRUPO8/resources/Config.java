package LAB5_TPINTEGRADOR_GRUPO8.resources; 
import java.sql.Date; 
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Provincia;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TipoMovimiento;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
//ESTA ES LA CLASE DE CONFIGURACION QUE USAMOS CON SPRINGCORE
//Seria nuesto IoC Container. Es el encargado de instanciar los elementos.

//Con el tag configuration le decimos a Spring Core que este va a ser un config file
@Configuration
public class Config { 

	@Bean @Scope(scopeName= ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TiposDeUsuarios TipoDeUsuarioAdministrador() {
		TiposDeUsuarios tipoAdmin = new TiposDeUsuarios();
		tipoAdmin.setDescripcion("Administrador");
		return tipoAdmin;
	}
	
	
	@Bean @Scope(scopeName= ConfigurableBeanFactory.SCOPE_SINGLETON) 
	public TiposDeUsuarios TipoDeUsuarioCliente() {
		TiposDeUsuarios tipoAdmin = new TiposDeUsuarios();
		tipoAdmin.setDescripcion("Cliente"); 
		return tipoAdmin;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario UsuarioAdministrador() {
		Usuario admin = new Usuario();
		admin.setTipoDeUsuario(TipoDeUsuarioAdministrador());
		admin.setEstado(true);
		return admin;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Provincia nuevaProvincia() {
		Provincia prov = new Provincia(); 
		return prov;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Localidad nuevaLocalidad() {
		Localidad loc = new Localidad(); 
		return loc;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario UsuarioCliente() {
		Usuario cliente = new Usuario();
		cliente.setTipoDeUsuario(TipoDeUsuarioCliente());
		cliente.setEstado(true);
		return cliente;
	}
	
	@Bean //con el tag Bean le decimos a spring core que esto va a ser un bean
	public TiposDeCuentas TipoCuentaDolares() {
		TiposDeCuentas tipocuentadolares = new TiposDeCuentas();
		tipocuentadolares.setDescripcion("Caja de Ahorro en Dolares");
		return tipocuentadolares;
	}
	
	@Bean
	public TiposDeCuentas TipoCuentaPesos() {
		TiposDeCuentas tipocuentapesos = new TiposDeCuentas();
		tipocuentapesos.setDescripcion("Caja de Ahorro en Pesos");
		return tipocuentapesos;
	}
	
	@Bean
	public TipoMovimiento TipoMovimientoDebito() {
		TipoMovimiento movimientoDebito = new TipoMovimiento();
		movimientoDebito.setDescripcion("DEBITO");
		return movimientoDebito;
	}
	
	@Bean
	public TipoMovimiento TipoMovimientoCredito() {
		TipoMovimiento movimientoCredito = new TipoMovimiento();
		movimientoCredito.setDescripcion("CREDITO");
		return movimientoCredito;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Movimientos MovimientoDebito() {
		Movimientos movimientoCredito = new Movimientos();
		movimientoCredito.setTipoMovimiento(TipoMovimientoDebito());
		return movimientoCredito;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Movimientos MovimientoCredito() {
		Movimientos movimientoCredito = new Movimientos();
		movimientoCredito.setTipoMovimiento(TipoMovimientoCredito());
		return movimientoCredito;
	}
	
	//El agregado del tag scope nos permite crear multiples instancias del mismo bean, util para crear muchos datos con pequenias diferencias.
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuentas NuevaCuentaDolares() {
		Cuentas cuentaDolares = new Cuentas();
		cuentaDolares.setFechaCreacion(new Date(System.currentTimeMillis()));
		cuentaDolares.setTipoCuenta(TipoCuentaDolares());
		cuentaDolares.setEstado(true);
		return cuentaDolares;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuentas NuevaCuentaPesos() {
		Cuentas cuentaPesos = new Cuentas();
		cuentaPesos.setFechaCreacion(new Date(System.currentTimeMillis()));
		cuentaPesos.setTipoCuenta(TipoCuentaPesos());
		cuentaPesos.setEstado(true);
		return cuentaPesos;
	}
	
	@Bean @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuentas cuenta() {
		Cuentas cuenta = new Cuentas();
		return cuenta;
	}
}
