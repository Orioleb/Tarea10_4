package Aplicacion;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepcion.ForaRang;

public class Main {
	static Scanner teclat= new Scanner(System.in);

	public static void main(String[] args) {
		boolean llegit=false;
		int opcio=0;
		while(llegit==false) {
			try {
				menu();
				opcio=Integer.parseInt(teclat.nextLine());
				llegit=true;
			}catch(NumberFormatException e) {
				System.out.println("Tienen que ser numeros");
			}
		}
		boolean trobat=false;
		while (trobat==false) {
			try {
				if((opcio<1)||(opcio>6)) {
					throw new ForaRang();
				}
				trobat=true;
			}catch(ForaRang e) {
				System.out.println(e);
			}
		}
		trobat=false;
		while(opcio!=7) {
			switch(opcio) {
			case 1:
				Suma();
				break;
			case 2:
				Resta();
				break;
			
			case 3:
				Multiplicacion();
				break;
			case 4:
				Division();
				break;
			case 5:
				Potencia();
				break;
			case 6:
				Raiz();
				break;
			
			}
			menu();
			opcio=teclat.nextInt();
		}
		teclat.close();
	}
	
	private static void menu() {
		//Menu de opciones que visualizaremos y tendremos que seleccionar una opcion
		System.out.println("\nOperaciones\n");
		System.out.println("1.Suma\n");
		System.out.println("2.Resta\n");
		System.out.println("3.Multiplicacion\n");
		System.out.println("4.Division\n");
		System.out.println("5.Potencia\n");
		System.out.println("6.Raiz\n");
	}
	
	private static int[] leernumeros() {
		//Leemos numeros que el usuario pase por teclado. Usaremos este metodo con suma resta multiplicacion y division
		boolean repetir;
		int valor1=0;
		int valor2=0;
		//Usamos InputMismatchException
		do{
			repetir=false;
			try {
				
				System.out.println("Introduzca el primer entero");
				valor1=teclat.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("Tiene que ser un entero");
				teclat.nextLine();
				repetir=true;
			}
		}while(repetir);
		do{
			repetir=false;
			try {
				
				System.out.println("Introduzca el segundo entero");
				valor2=teclat.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("Tiene que ser un entero");
				teclat.nextLine();
				repetir=true;
			}
		}while(repetir);
		int[] res;
		res=new int[2];
		res[0]=valor1;
		res[1]=valor2;
		return res;
		
	}
	private static int leernumero() {
		//Leemos numero, usamos este metodo para potencia y raiz
		boolean repetir;
		int valor=0;
		//Usamos InputmismatchException
		do{
			repetir=false;
			try {
				
				System.out.println("Introduzca el primer entero");
				valor=teclat.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("Tiene que ser un entero");
				teclat.nextLine();
				repetir=true;
			}
		}while(repetir);
		return valor;
	}
	
	private static void Suma() {
		int[] taula;
		taula=new int[2];
		taula=leernumeros();
		int suma=taula[0]+taula[1];
		System.out.println("El resultado de la suma es "+suma);
		
	}

	private static void Resta() {
		int[] taula;
		taula=new int[2];
		taula=leernumeros();
		int resta=taula[0]-taula[1];
		System.out.println("El resultado de la resta es "+resta);
		
	}
	private static void Multiplicacion() {
		int[] taula;
		taula=new int[2];
		taula=leernumeros();
		int multiplicacion=taula[0]*taula[1];
		System.out.println("El resultado de la multiplicacion es "+multiplicacion);
	}
	private static void Division() {
		int[] taula;
		taula=new int[2];
		taula=leernumeros();
		double division;
		//Excepcion en el caso que sea 0
		try {
			division=taula[0]/taula[1];
		}catch(ArithmeticException e) {
			division=0;
		}
		System.out.println("El resultado de la division es "+division);
	}
	private static void Potencia() {
		int valor=leernumero();
		int res=valor*valor;
		System.out.println("El resultado de la potencia es "+res);
		
	}
	private static void Raiz() {
		int valor=leernumero();
		double res=Math.sqrt(valor);
		System.out.println("El valor de la raiz de "+valor+" es "+res);
	}
}
