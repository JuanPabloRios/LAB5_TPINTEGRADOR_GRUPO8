package LAB5_TPINTEGRADOR_GRUPO8.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimientos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idMovimiento", updatable = false, nullable = false)
	private int idMovimiento;
	
	private String descripcion;
	private Date fecha;
	private String detalle;
	private Double importe;
	
	@OneToOne
	@JoinColumn(name="idNroDeCuenta_c")
	private Cuentas cuenta;
	
	
	@OneToOne
	@JoinColumn(name="idTipoMovimiento_c")
	private TipoMovimiento tipoMovimiento;
	
	
	public Movimientos() {
		
	}
	
	
	public int getIdMovimiento() {
		return idMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Cuentas getUsuario() {
		return cuenta;
	}
	public void setUsuario(Cuentas usuario) {
		this.cuenta = usuario;
	}
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Movimientos [idMovimiento=" + idMovimiento + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", detalle=" + detalle + ", importe=" + importe + ", usuario=" + cuenta + ", tipoMovimiento="
				+ tipoMovimiento + "]";
	}
	
	
}
