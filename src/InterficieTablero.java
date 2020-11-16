
public interface InterficieTablero {
	public int getEstadoCasilla(int f, int c);
	public void setEstadoCasilla(int f, int c, int estado) ;
	public void resetCasilla(int f, int c) ;
	public void setCasillaRevelada(int f, int c);
	public boolean getCasillaRevelada(int f, int c);
	public void printTablero();
	public boolean compruebaHundida(int f, int c) ;
	public void revelaZona(int f, int c);
	public void setBarcosAleatorios();
	public boolean setBarcos(int f, int c, int o, int b);
	public boolean compruebaPosicionValida(int f, int c);
	public boolean compruebaAislada(int f, int c);
	public boolean compruebaCasillaVacia(int f, int c);
	public int generarRandom(int max);
}
