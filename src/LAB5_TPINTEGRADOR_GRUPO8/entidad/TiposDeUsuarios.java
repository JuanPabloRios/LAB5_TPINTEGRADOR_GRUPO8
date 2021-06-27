package LAB5_TPINTEGRADOR_GRUPO8.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 
@Entity
@Table(name="tiposDeUsuarios")
public class TiposDeUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTipoUsuario", updatable = false, nullable = false)
	private int idTipoUsuario;
	
	private String descripcion;
	
	public TiposDeUsuarios() { 
	}
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "TiposDeUsuarios [idTipoUsuario=" + idTipoUsuario + ", descripcion=" + descripcion + "]";
	} 
	
}
