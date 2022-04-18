package entidades;

public class Jefe extends Personajes {
    private Personajes pFinal;

    public Jefe(int vida, int daño, Personajes pFinal) {
        this.vida=vida;
        this.tipo="Jefe Final";
        this.daño=daño;
        this.dañoMin=daño;
        this.dañoMax=daño+30;
        this.pFinal=pFinal;
    }

    @Override
    //Si tiene el arma indicada, habra una posibilidad de 3 que active su poder, y cause un 30 de daño extra
    public int dañar() {
        int alearotio= this.dañoMax-this.dañoMin;
        this.daño=(int) (Math.random()*alearotio +1)+this.dañoMin;
        if(this.critico()) {
            System.out.println("El ataque ha sido critico. +20 de daño en este ataque");
            this.daño+=20;
            return this.daño+20;
        }
        else
            return this.daño;
    }

    @Override
    public void esDañado(int x) {
        this.vida-=x;
        if(this.vida<0)
            this.vida=0;

    }

    public void setArma(Arma arma) {
        if(arma!=null) {
            this.daño=0;
            this.arma = arma;
            this.daño= arma.getDaño();
            this.dañoMin=arma.getDañoMin();
            this.dañoMax=arma.getDañoMax();
        }
    }

    public Personajes getpFinal() {
        return pFinal;
    }
    public void setpFinal(Personajes pFinal) {
        this.pFinal = pFinal;
    }

}
