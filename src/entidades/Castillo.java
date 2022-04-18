package entidades;

import Main.main;

public class Castillo {
    private String nombre;
    private Personajes jefe;
    public Castillo(String nombre, Personajes jefe) {
        this.nombre = nombre;
        this.jefe=jefe;
    }

    public synchronized void entrar(Personajes p1){
        if(p1.getVida()>0)
            System.out.println(p1.getNombre()+ " va a luchar");
        while(p1.getVida()>0 && jefe.getVida()>0) {
            main.jugar(p1, jefe);

            if(jefe.getVida()<=0) {
                if(jefe.getVida()<=0) {
                    System.out.println("Ha derrotado a "+jefe.getNombre());
                }
            }
            if(p1.getVida()<=0) {
                if(this.jefe instanceof Jefe) {
                    Personajes x= ((Jefe) this.jefe).getpFinal();
                    if(x.getNombre().equals(p1.getNombre())) {
                        System.out.println(jefe.getNombre()+ " ha derrotado a los heroes");
                    }
                }
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Personajes getJefe() {
        return jefe;
    }

    public void setJefe(Personajes jefe) {
        this.jefe = jefe;
    }


}
