package entidades;

public abstract class Personajes implements Runnable {
	protected String nombre;
	protected Arma arma;
	protected int da�o;
	protected int da�oMin;
	protected int da�oMax;
	protected int vida=100;
	protected Castillo castillo;
	public int getDa�o() {
		return da�o;
	}
	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}
	
	protected String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public abstract int da�ar();
	public abstract void esDa�ado(int x);
	public boolean critico() {
		int x=(int) (Math.random()*10 +1);
		if(x<3)
			return true;
		else
			return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDa�oMin() {
		return da�oMin;
	}
	public void setDa�oMin(int da�oMin) {
		this.da�oMin = da�oMin;
	}
	public int getDa�oMax() {
		return da�oMax;
	}
	public void setDa�oMax(int da�oMax) {
		this.da�oMax = da�oMax;
	}

	public Castillo getCastillo() {
		return castillo;
	}
	public void setCastillo(Castillo fortaleza) {
		this.castillo = fortaleza;
	}
	@Override
	public void run() {
		castillo.entrar(this);

	}
	
}
