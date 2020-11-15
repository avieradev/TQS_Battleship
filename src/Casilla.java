public class Casilla {
    public int estado; //0 agua, 1 barco, 2 hundido
    public boolean revelada;
    public boolean visitada;

            public Casilla() {
                this.estado = 0;
                this.revelada = false;
                this.visitada = false;
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

            public boolean getVisitada() {
                return visitada;
            }

            public void setVisitada() {
                visitada = true;
            }
            
            public void reset(){
            	this.revelada = false;
                this.visitada = false;
                this.estado = 0;
            }
            
            
        

}