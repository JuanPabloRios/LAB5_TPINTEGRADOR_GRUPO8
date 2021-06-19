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
@Table(name="cuentas")
public class Cuentas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "NroDeCuenta", updatable = false, nullable = false)
	private int idNroDeCuenta;
	
	@OneToOne
	@JoinColumn(name="idtipoCuenta_c")
	private TiposDeCuentas tipoCuenta;
	
	private Date fechaCreacion;
	
	private String CBU;
	
	private Double saldo;
	
	
	@OneToOne
	@JoinColumn(name="idUsuario_c")
	private Usuario usuario;
	
	public Cuentas() {
		
	}
	
	public int getIdNroDeCuenta() {
		return idNroDeCuenta;
	}

	public TiposDeCuentas getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TiposDeCuentas tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getCBU() {
		return CBU;
	}
	public void setCBU(String cBU) {
		CBU = cBU;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cuentas [idNroDeCuenta=" + idNroDeCuenta + ", tipoCuenta=" + tipoCuenta + ", fechaCreacion="
				+ fechaCreacion + ", CBU=" + CBU + ", saldo=" + saldo + "]";
	}	
	
	
}
