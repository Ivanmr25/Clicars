package model;

public class Coche {
	private int id;
	private int marca;
	private String marcanombre;
	private String foto;
	private String nombre;
	private String modelo;
	private long precio;
	private long precioantes;
	private int anio;
	private long km;
	private int cv;
	private int fav;
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coche(int id, int marca, String marcanombre, String foto, String nombre, String modelo, long precio,
			long precioantes, int anio, long km, int cv, int fav) {
		super();
		this.id = id;
		this.marca = marca;
		this.marcanombre = marcanombre;
		this.foto = foto;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precio = precio;
		this.precioantes = precioantes;
		this.anio = anio;
		this.km = km;
		this.cv = cv;
		this.fav = fav;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public String getMarcanombre() {
		return marcanombre;
	}
	public void setMarcanombre(String marcanombre) {
		this.marcanombre = marcanombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	public long getPrecioantes() {
		return precioantes;
	}
	public void setPrecioantes(long precioantes) {
		this.precioantes = precioantes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public long getKm() {
		return km;
	}
	public void setKm(long km) {
		this.km = km;
	}
	public int getCv() {
		return cv;
	}
	public void setCv(int cv) {
		this.cv = cv;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", marcanombre=" + marcanombre + ", foto=" + foto + ", nombre="
				+ nombre + ", modelo=" + modelo + ", precio=" + precio + ", precioantes=" + precioantes + ", anio="
				+ anio + ", km=" + km + ", cv=" + cv + ", fav=" + fav + "]";
	}
	
	

}
