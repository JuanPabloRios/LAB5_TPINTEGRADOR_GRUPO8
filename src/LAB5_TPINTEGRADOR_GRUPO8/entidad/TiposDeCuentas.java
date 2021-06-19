package LAB5_TPINTEGRADOR_GRUPO8.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiposDeCuentas")
public class TiposDeCuentas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTipoCuenta", updatable = false, nullable = false)
	private int idTipoCuenta;
	
	private String descripcion;

	
	public TiposDeCuentas() {
		
	}
	
	public int getIdTipoCuenta() {
		return idTipoCuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TiposDeCuentas [idTipoCuenta=" + idTipoCuenta + ", descripcion=" + descripcion + "]";
	}

	
	
}
