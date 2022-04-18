package Main;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.*;
public class main {
	static ArrayList<Personajes> listaP= new ArrayList<>();
	static ArrayList<Arma> listaA= new ArrayList<>();
	static ArrayList<String> listaDañar= new ArrayList<>();
	static ArrayList<String> listaAccion= new ArrayList<>();
	
	
	 static void crearLista() {

		 Arma e1= new Espada("Claymore",30);
		 listaA.add(e1);
		 Arma e2= new Espada("Dagas", 25);
		 listaA.add(e2);
		 Arma e3= new Espada("Uchigatana", 40);
		 listaA.add(e3);
		 
		 Arma ar1= new Arco("Arco del León", 30);
		 listaA.add(ar1);
		 Arma ar2= new Arco("Arco ligero", 15);
		 listaA.add(ar2); 
		 Arma ar3= new Arco("Arco pesado", 20);
		 listaA.add(ar3);
		 
		 Arma h1= new Hechizos("Llama Frenética", 20);
		 listaA.add(h1);
		 Arma h2= new Hechizos("Magia Gravitacional", 25);
		 listaA.add(h2);
		 
		 Arma r1= new Rezos("Ley Dorada", 10);
		 listaA.add(r1);
		 Arma r2= new Rezos("Singularidad", 12);
		 listaA.add(r2);
		 
		 
		Personajes p1= new Guerrero();
		p1.setNombre("Sinluz");
		
		listaP.add(p1);
		
		Personajes p2= new Mago();
		p2.setNombre("Rennala");
		listaP.add(p2);
		
		Personajes p3= new Curandero();
		p3.setNombre("D");
		listaP.add(p3);
		
		listaDañar.add(" ha dañado");
		listaDañar.add(" ha herido");

	}
	 
	 static ArrayList<Personajes> elegirPersonaje(){
		 int x=0, y=0;
		 ArrayList<Personajes> listaP2= new ArrayList<>();
		 while(x==y) {
			 x= (int) (Math.random()*listaP.size());
			 y=(int) (Math.random()*listaP.size());
		 }
		 listaP2.add(listaP.get(x));
		 listaP2.add(listaP.get(y));
		 x=0;
		 y=0;
		 while(x==y) {
			 x= (int) (Math.random()*listaA.size());
			 y=(int) (Math.random()*listaA.size());
		 }
		 listaP2.get(0).setArma(listaA.get(x));
		 listaP2.get(1).setArma(listaA.get(y));
		 return listaP2;
	 }
	 
	 
	 
	 public static String stats(Personajes p) {
		 return p.getNombre()+"("+p.getVida()+")";
	 }
	 

	 public static void jugar(Personajes p1, Personajes p2) {
		 System.out.println("");
		 System.out.println(stats(p1)+"  VS  "+stats(p2));
		 System.out.println("");
		 int opcion=(int) (Math.random()*4+1);
		 if(opcion==1) {
			 p1.esDañado(p2.dañar());
			 System.out.println(stats(p2)+listaDañar.get((int) (Math.random()*listaDañar.size()))+" (-"+p2.getDaño()+ 
					 " puntos) a "+ stats(p1));
		 }
		 else if(opcion==2) {
			 p2.esDañado(p1.dañar());
			 System.out.println(stats(p1)+listaDañar.get((int) (Math.random()*listaDañar.size()))+" (-"+p1.getDaño()+ 
					 " puntos) a "+ stats(p2));
		 }
		 else if(opcion==3)
		 System.out.println( p1.getNombre()+" fallo el ataque");

		 else if(opcion==4)
			 System.out.println( p2.getNombre()+" fallo el ataque");
	 }

	static ArrayList<Personajes> elegirJefe(int num){
		ArrayList<Personajes> listaP2= new ArrayList<>();
		ArrayList<Arma> listaA2= new ArrayList<>();
		for(int i=0; i<num;i++) {
			int x=(int)(Math.random()*listaP.size());
			int y=(int)(Math.random()*listaA.size());
			while(listaP2.indexOf(listaP.get(x))>=0) {
				x=(int)(Math.random()*listaP.size());
			}
			y=(int)(Math.random()*listaA.size());
			listaP.get(x).setArma(listaA.get(y));
			listaP2.add(listaP.get(x));
		}
		return listaP2;
	}
	 
	 static void inicio(Personajes p1) {
		 System.out.println(p1.getNombre() + " empuñando "+p1.getArma().getNombre());
	 }

	public static void main(String[] args) {

		crearLista();
		System.out.println("Elige el numero de jugadores");
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		if(num>listaP.size())
			num=listaP.size();
		int muertos=0;
		ArrayList<Personajes> personajes= elegirJefe(num);

			System.out.println("Los personajes que lucharan son:");
		for(Personajes p : personajes) {
			System.out.println(" -"+p.getNombre());
			inicio(p);
		}

		Personajes jefe= new Jefe(300,50, personajes.get(num-1));
		jefe.setNombre(" Clérigo bestia");
		Castillo castillo= new Castillo("Caelid", jefe);
		System.out.println("");
		System.out.println("El jefe será " + jefe.getNombre()+" del castillo " + castillo.getNombre());

		Personajes pActual= personajes.get(muertos);
		pActual.setCastillo(castillo);
		System.out.println("");

		while(muertos<num) {
			if(muertos<num) {
				pActual=personajes.get(muertos);
				pActual.setCastillo(castillo);
			}
			Thread t1 = new Thread(pActual);
			t1.start();
			muertos++;

		}
	}

	 
}
