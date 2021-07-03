package LAB5_TPINTEGRADOR_GRUPO8.entidad;
import java.io.Serializable;
import java.sql.Date; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//declarar que es una tabla y una entidad.
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	//implementar serializable.
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int idusuario;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private String usuario;
	private String contrasenia;
	private Date fecha_de_nacimiento;
	private int DNI;
	private String direccion;
	private Boolean estado;
	@OneToOne 
	@JoinColumn(name="idTipoUsuario_c")
	private TiposDeUsuarios tipoDeUsuario;

	@OneToOne
	@JoinColumn(name="idLocalidad_c")
	private Localidad localidad;
	

	
	//constructor
	public Usuario() {
		
	}

	public int getIdusuario() {
		return idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public TiposDeUsuarios getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TiposDeUsuarios tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", nacionalidad=" + nacionalidad + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", fecha_de_nacimiento=" + fecha_de_nacimiento + ", DNI=" + DNI + ", direccion=" + direccion
				+ ", estado=" + estado + ", localidad="+localidad+"]";
	}




}
