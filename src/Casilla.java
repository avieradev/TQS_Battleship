public class Casilla {
    public int estado; //0 agua, 1 barco, 2 hundido
    public boolean revelada;

            public Casilla() {
                estado = 0;
                revelada = false;
            }

            public void setEstado(int m_estado) {
                estado = m_estado;
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