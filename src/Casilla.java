public class Casilla {
    public int estado; //0 agua, 1 barco, 2 hundido
    public boolean revelada;

            public Casilla() {
                this.estado = 0;
                this.revelada = false;
            }

            public void setEstado(int estado) {
                this.estado = estado;
            }

            public int getEstado() {
            	return estado;
            }

            public boolean getRevelada() {
                return revelada;
            }

            public void setRevelada() {
                revelada = true;
            }


}