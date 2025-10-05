package main;

import java.util.InputMismatchException;
import java.util.Scanner;




public class Principal {

	public static void main(String[] args) {
		
		int productos[][] = new int [50][3];
		Scanner s = new Scanner(System.in);
	
		int opc;
		

		System.out.println("Opcion 1: Ingresar producto");
		System.out.println("Opcion 2: Consultar producto");
		System.out.println("Opcion 3: Salir del programa");	
		opc = ingreseEntero(s, "Ingrese la opcion que quiera:  ", 1,3);
		
		mostrarMenu(s, opc, productos);
		
		

		
		
		
		s.close();

	}
	public static int ingreseEntero(Scanner s, String mensaje, int MIN, int MAX) {
	    int n = 0;
	    boolean flag = false;
	    do {
	    	
            System.out.println(mensaje);

	        try {
	            n = s.nextInt();
	            flag = true;
	            if(n>MAX || n<MIN) {
	            	System.out.println("no esta dentro del rango ingrese denuevo");
	            	flag=false;
	            }
	            
	        } catch(InputMismatchException e) {
	            System.out.println("Escribi un numero válido");
	            s.nextLine(); 
	            flag = false;
	        }catch(Exception e) {
			System.out.println("intente de nuevo");
			s.nextLine();
			flag=false;
		}
	    } while(!flag);
	    return n;
	}
	public static void ingresarProducto(Scanner s, int[][] productos) {
		int cod;
		int vacio=0;

		do {
			
			cod= ingreseEntero(s, "Ingrese codigo del producto o 0 para salir", 0, 500);
			s.nextLine();
			if(cod!=0) {
				vacio = buscarVacio(productos);
				productos[vacio][0] = cod;
				System.out.println("Ingrese el precio: ");
				productos[vacio][1] = s.nextInt();
				s.nextLine();
				System.out.println("Ingrese la cantidad: ");
				productos[vacio][2] = s.nextInt();
				s.nextLine();
				vacio++;

			}else {
				System.out.println("Usted salio del programa");
			}
			
		}while(cod!=0);
		
		
	}
	
	public static void consultarProducto(Scanner s, int[][] productos) {
		
		int consulta;
		
		consulta = ingreseEntero(s, "Que producto quiere consultar (Ingrese el codigo) ", 0, 500);
		s.nextLine();
		boolean flag = false;
		int i=0;
		do {
			
			if(productos[i][0]==consulta){
				System.out.println("Su producto es el codigo " + productos[i][0]);
				System.out.println("Su precio es " + productos[i][1]);
				System.out.println("La cantidad disponible de stock es " + productos[i][2]);
				flag=true;
			}else {
				i++;
			}
			
		}while(!flag || productos.length>i);
		if(!flag) {
			System.out.println("codigo de producto no encontrado");
			
		}
	}
	public static void mostrarMenu(Scanner s, int opc, int[][] productos) {
		do {
			
			
			switch(opc) {
			
			case 1: 
				ingresarProducto(s, productos);
			break;
			
			case 2:
				consultarProducto(s, productos);
				
			break;	
			case 3:
				System.out.println("Saliendo");
			break;
			
			
			}
			
			System.out.println("Opcion 1: Ingresar producto");
			System.out.println("Opcion 2: Consultar producto");
			System.out.println("Opcion 3: Salir del programa");
			opc = ingreseEntero(s, "Ingrese la opcion que quiere", 1, 3);
			
		}while(opc!=3);
		
	}
	public static int buscarVacio(int[][] productos) {
		
		boolean flag= false;
		int i = 0;
		do {
			if(productos[i][0]==0) {
				flag = false;
				return i;
				
			}else {
			
				i++;
				flag=true;
		}
		}while(flag);
		
		return -1;
		

	}
	


			

}
	

