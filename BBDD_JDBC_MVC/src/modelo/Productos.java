package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Productos {

	public Productos() {

		codigo_articulo = null;
		nombre_articulo = null;
		pais_articulo = null;
		seccion_articulo = null;
		precio_articulo = null;
		fecha_articulo = null;

	}

	public String getCodigo_articulo() {
		return codigo_articulo;
	}
	public String getNombre_articulo() {
		return nombre_articulo;
	}
	public String getPais_articulo() {
		return pais_articulo;
	}
	public String getSeccion_articulo() {
		return seccion_articulo;
	}
	public BigDecimal getPrecio_articulo() {
		return precio_articulo;
	}
	public Date getFecha_articulo() {
		return fecha_articulo;
	}
	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}
	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}
	public void setPais_articulo(String pais_articulo) {
		this.pais_articulo = pais_articulo;
	}
	public void setSeccion_articulo(String seccion_articulo) {
		this.seccion_articulo = seccion_articulo;
	}
	public void setPrecio_articulo(BigDecimal precio_articulo) {
		this.precio_articulo = precio_articulo;
	}
	public void setFecha_articulo(Date fecha_articulo) {
		this.fecha_articulo = fecha_articulo;
	}

	private String codigo_articulo;
	private String nombre_articulo;
	private String pais_articulo;
	private String seccion_articulo;
	private BigDecimal precio_articulo;
	private Date fecha_articulo;

}
