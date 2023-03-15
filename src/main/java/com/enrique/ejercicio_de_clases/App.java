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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

import com.enrique.ejercicio_de_clases.entities.Cuenta;
import com.enrique.ejercicio_de_clases.entities.CuentaCaixa;
import com.enrique.ejercicio_de_clases.entities.CuentaSabadell;
import com.enrique.ejercicio_de_clases.entities.CuentaSantander;
import com.enrique.ejercicio_de_clases.enums.NivelCatalan;
import com.enrique.ejercicio_de_clases.utils.CuentaUtils;


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

	static Path ficheros = Paths.get("assets/ficheros");
	private static List<Cuenta> cuentas = new ArrayList<Cuenta>();
	private static List<CuentaCaixa> cuentasCaixa = CuentaUtils
			.ListaCuentasCaixa(Paths.get("assets/ficheros/caixa.txt"));
	private static List<CuentaSabadell> cuentasSabadell = CuentaUtils
			.ListaCuentasSabadell(Paths.get("assets/ficheros/Sabadell.txt"));
	private static List<CuentaSantander> cuentasSantander = CuentaUtils
			.ListaCuentasSantander(Paths.get("assets/ficheros/Santander.txt"));
	// cuenta abstract con metodos basicos
	// clases que heredan (cuentabanco)

	// filtro nivel de catalan para banco caixa y sabadell
	// filtro residente santender y contador static de cuentas

	// caixa y sabadell final class
	// toString distinto pa cada uno

	// proceso para leer ficheros que cree objetos por tipo de cuenta

	// une todas las listas en una sola
	// recorrela y muestra el banco y los datos

	// metodo que borre al azar un elemento de la lista agrupada
	// metodo que busque en las listas independientes que elemento falta en la lista
	// agrupada

	// Santander, suma de todos los saldos, cantidad de cuentas y cuenta con mayor
	// saldo

	public static void main(String[] args) {
		try {
			cuentas = CuentaUtils.fileToList(ficheros);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//hacer aqui genericos en el CuentaUtils y llamarlos
//			System.out.println("Banco La Caixa");
//		for(Cuenta c : cuentas) {
//			for (int i = 0; i<cuentasCaixa.size();i++) {
//				if(c.equals(cuentasCaixa.get(i))){
//				System.out.println(c);
//				}
//			}
//		}
//			System.out.println("Banco Sabadell");
//		for(Cuenta c : cuentas) {
//			for (int i = 0; i<cuentasSabadell.size();i++) {
//				if(c.equals(cuentasSabadell.get(i))){
//				System.out.println(c);
//				}
//			}
//		}
//			System.out.println("Banco Santander");
//		for(Cuenta c : cuentas) {
//			for (int i = 0; i<cuentasSantander.size();i++) {
//				if(c.equals(cuentasSantander.get(i))){
//				System.out.println(c);
//				}
//			}
//		}
//			
		
			
		CuentaUtils.eliminarAleatorio(cuentas);
		System.out.println(cuentas.stream().filter(e->e.getNombre().equals(null)).findAny().isPresent());
		
	}

}
