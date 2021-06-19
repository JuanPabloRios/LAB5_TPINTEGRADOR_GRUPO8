package LAB5_TPINTEGRADOR_GRUPO8.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoMovimientos")
public class TipoMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTipoMovimiento", updatable = false, nullable = false)
	private int idTipoMovimiento;
	
	private String descripcion;

	
	public TipoMovimiento() {
		
	}
	
	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoMovimiento [idTipoMovimiento=" + idTipoMovimiento + ", descripcion=" + descripcion + "]";
	}
	

	
	
}
