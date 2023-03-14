package com.enrique.ejercicio_de_clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.enrique.ejercicio_de_clases.entities.Cuenta;
import com.enrique.ejercicio_de_clases.entities.CuentaCaixa;
import com.enrique.ejercicio_de_clases.enums.NivelCatalan;

/**
 * A partir de los archivos de las cuentas que viste en el ejercicio anterior,
 * realiza las siguientes tareas:
 * 
 * 1. Crea una clase genérica Cuenta que no se pueda instanciar con los campos
 * comunes de todos los archivos. Crea todos los métodos básicos de dicha
 * cuenta.
 * 
 * 2. Crea tantas clases heredadas como de bancos tienes información. Llámalas
 * CuentaSantander ...
 * 
 * 3. En las Clases de bancos catalanes (caixa y sabadell) cada vez que se cree
 * una cuenta deberá introducirse el nivel de catalán que tiene el titular de la
 * cuenta admitiendo solo tres opciones (alto, medio o bajo).
 * 
 * 4. En las cuentas del banco Santander queremos saber si el titular de la
 * cuenta es residente en Santander. Además queremos un contador interno en la
 * clase que almacene el número de cuentas que se crean de ese banco.
 * 
 * 5. Las cuentas de bancos catalanes no pueden ser heredadas por ninguna otra
 * clase.
 * 
 * 6. Crea un toString diferente para cada Cuenta de banco.
 * 
 * 7. Crea un proceso que lea los ficheros y cree una lista de objetos por cada
 * uno de los tipos de cuenta.
 * 
 * 8. Une todas las listas en una sola lista.
 * 
 * 9. Recorre esa lista agrupada y antes de mostrar sus datos indica el banco al
 * que pertenece.
 * 
 * 10. Crea un método que borre al azar un elemento de esta nueva lista.
 * 
 * 11. Busca en las listas de las cuentas de los diferentes bancos para
 * descubrir cuál de sus elementos no está en la lista agrupada.
 * 
 * 12. Sobre la lista del banco Santander saca la suma total de los saldos de
 * todos los clientes, el número de Cuentas que hay y aquella Cuenta con el
 * saldo más alto.
 *
 */
public class App {
	
	static Path ficheros = Paths.get("ficheros");
	private static Scanner sc;
	private static List<Cuenta> cuentas = new ArrayList<Cuenta>();
	private static List<CuentaCaixa> cuentasCaixa = new ArrayList<CuentaCaixa>();
	
	public static List<String> devolverLineasJava8(Path ruta){
		try {
			List<String> lineas = Files.readAllLines(ruta,Charset.forName("UTF-8"));
			return lineas;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("No se puede acceder al fichero. Error en devolverLineasJava8");
			return null;
		}
	}
	
	//cuenta abstract con metodos basicos
	//clases que heredan (cuentabanco)
	
	//filtro nivel de catalan para banco caixa y sabadell
	//filtro residente santender y contador static de cuentas
	
	//caixa y sabadell final class
	//toString distinto pa cada uno
	public static void anyadirCuentasCaixa() {
    	List<String> listaccstring = devolverLineasJava8(ficheros);
    	
    	for(String cuenta : listaccstring) {  // a partir de las líneas del fichero las añado a la lista de cuentas de la caixa
    		String[] partes = cuenta.split(";");
    		cuentasCaixa.add(new CuentaCaixa(
    				partes[0],
    				partes[1],
    				partes[2], 
    				partes[3],
    				Double.parseDouble(partes[4]),
    				NivelCatalan.Medio
    				));
    	}
    	
    	// probamos que la lista está rellena
    	
    	/*cuentasCaixa.stream()
    	.filter(e->e.getSaldo()>30000)
    	.forEach(e->System.out.println(e));*/
    	
    	cuentas.addAll(cuentasCaixa);  // esto añade todas las cuentas de la caixa dentro de la lista de cuentas
 
	}
	
//	
//	public static Cuenta leerFicherosEnCarpetaTodasLasLineasAClaseCuenta(String dnicif) {
//
//		CuentaCaixa elegida = new CuentaCaixa();
//		
//		if (Files.isDirectory(ficheros)) {
//			try {
//				Files.list(ficheros).filter(Files::isRegularFile).forEach(archivo -> {
//					if (Files.isRegularFile(archivo)) {
//						try (BufferedReader lector = new BufferedReader(new FileReader(archivo.toFile()))) {
//							String linea;
//							while ((linea = lector.readLine()) != null) {
//								Pattern patron = Pattern.compile(
//										"^(?<dni>[^;]+);(?<nombre>[^;]+);(?<fecha>[^;]+);(?<pais>[^;]+);(?<saldo>[^;]+)$");
//								Matcher matcher = patron.matcher(linea);
//								if (matcher.matches()) {
//									String dni = matcher.group("dni");
//									String nombre = matcher.group("nombre");
//									String fecha = matcher.group("fecha");
//									String pais = matcher.group("pais");
//									double saldo = Double.parseDouble(matcher.group("saldo"));
//
//									if (dni.equals(dnicif)) {
//
//										Cuenta cuenta = new Cuenta(dni, nombre, fecha, pais, saldo);
//										
//										if (archivo.getFileName().toString().equals("caixa.txt")) {
//											caixa.add(cuenta);
//										} else if (archivo.getFileName().toString().equals("sabadell.txt")) {
//											sabadell.add(cuenta);
//										} else if (archivo.getFileName().toString().equals("santander.txt")) {
//											santander.add(cuenta);
//										} 
//									}	
//									
//									
//								}
//							}		
//						
//						} catch (FileNotFoundException e) {
//
//							caixa.add(error);
//							sabadell.add(error);
//							santander.add(error);
//							
//							e.printStackTrace();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				});
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//			if(caixa.get(0).getNombre().equals("error")) {
//				System.out.println("Cuenta con DNI: "+ dnicif + " no existente");
//			}
//		
//	
//		/*dni*/elegida.setDni(dnicif);
//		/*nombre*/if(caixa.get(0).getNombre().equals(sabadell.get(0).getNombre())&&
//				   caixa.get(0).getNombre().equals(santander.get(0).getNombre())) 
//				{
//					elegida.setNombre(caixa.get(0).getNombre());
//				}
//		LocalDateTime fechaHora = LocalDateTime.now();
//		/*pais*/if(caixa.get(0).getPais().equals("ES")||
//				sabadell.get(0).getPais().equals("ES")||
//				santander.get(0).getPais().equals("ES"))
//				{
//					elegida.setPais("ES");
//					System.out.println(elegida.getNombre()+"\nBienvenido a nuestro sistema de gestion de cuentas");
//			        System.out.println(fechaHora.format(DateTimeFormatter.ofPattern("HH:mm EEEE dd/MM/yyyy")));
//
//				}else if(caixa.get(0).getNombre()!="error") {
//					elegida.setPais("EX");//extranjera
//					System.out.println(elegida.getNombre()+"\nWelcome to our account management system");	
//					System.out.println(fechaHora.format(DateTimeFormatter.ofPattern("HH:mm EEEE MM/dd/yyyy", new Locale("en", "US"))));
//				}
//	
//		/*fecha*/if(caixa.get(0).getFecha().equals(sabadell.get(0).getFecha())&&
//				caixa.get(0).getFecha().equals(santander.get(0).getFecha())) 
//		{
//			elegida.setFecha(caixa.get(0).getFecha());
//		}else {
////			Scanner sc = new Scanner(System.in);
//			if(elegida.getPais().equals("ES")) {
//				System.out.println("Indique que fecha de nacimiento es correcta: "+
//					"1) "+caixa.get(0).getFecha()+" "+
//					"2) "+sabadell.get(0).getFecha()+" "+
//					"3) "+santander.get(0).getFecha());
//			}else {
//				System.out.println("Point us which birthdate is correct: "+
//					"1) "+caixa.get(0).getFecha()+" "+
//					"2) "+sabadell.get(0).getFecha()+" "+
//					"3) "+santander.get(0).getFecha());
//			}
//			
//			int opcion;
//			do {
//				opcion = Integer.parseInt(sc.nextLine());
//				switch(opcion) {
//				case 1 -> elegida.setFecha(caixa.get(0).getFecha());
//				case 2 -> elegida.setFecha(sabadell.get(0).getFecha());
//				case 3 -> elegida.setFecha(santander.get(0).getFecha());
//				default -> System.out.printf("Esa no es una opción, por favor indique que fecha es correcta: \n"+
//						"1) "+caixa.get(0).getFecha()+" "+
//						"2) "+sabadell.get(0).getFecha()+" "+
//						"3) "+santander.get(0).getFecha()+"\n");
//				}
//			}while(opcion<1 || opcion>3);
////			sc.close();
//		}
//		
//		/*saldo*/elegida.setSaldo(caixa.get(0).getSaldo()+sabadell.get(0).getSaldo()+santander.get(0).getSaldo());
//				
//					
//		
//		
//	
//		}
//		return elegida;
//
//	}

	
	//proceso para leer ficheros que cree objetos por tipo de cuenta
	
	//une todas las listas en una sola
	//recorrela y muestra el banco y los datos
	
	//metodo que borre al azar un elemento de la lista agrupada
	//metodo que busque en las listas independientes que elemento falta en la lista agrupada
	
	//Santander, suma de todos los saldos, cantidad de cuentas y cuenta con mayor saldo
	
	public static void main(String[] args) {
//		Cuenta c = new Cuenta();
		CuentaCaixa cc = new CuentaCaixa();
		CuentaCaixa cc2 = new CuentaCaixa("111", "fran", LocalDate.now().toString(), "ES", 10000, NivelCatalan.Alto);
		CuentaCaixa cc3 = new CuentaCaixa(cc2);
		System.out.println(cc2);
	}
}
