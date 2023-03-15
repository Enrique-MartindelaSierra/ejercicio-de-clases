package com.enrique.ejercicio_de_clases.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.enrique.ejercicio_de_clases.entities.Cuenta;
import com.enrique.ejercicio_de_clases.entities.CuentaCaixa;
import com.enrique.ejercicio_de_clases.entities.CuentaSabadell;
import com.enrique.ejercicio_de_clases.entities.CuentaSantander;
import com.enrique.ejercicio_de_clases.enums.NivelCatalan;

public class CuentaUtils {

	public static List<String> devolverLineasJava8(Path ruta) {
		try {
			List<String> lineas = Files.readAllLines(ruta, Charset.forName("UTF-8"));
			return lineas;
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("No se puede acceder al fichero. Error en devolverLineasJava8");
			return null;
		}
	}
	public static List<CuentaCaixa> ListaCuentasCaixa(Path ruta) {
    	List<String> listaccstring = devolverLineasJava8(ruta);
    	List<CuentaCaixa> cuentasCaixa = new ArrayList<CuentaCaixa>();

    	
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
    	return cuentasCaixa;
	}
	
	public static List<CuentaSabadell> ListaCuentasSabadell(Path ruta) {
    	List<String> listaccstring = devolverLineasJava8(ruta);
    	List<CuentaSabadell> cuentasSabadell = new ArrayList<CuentaSabadell>();

    	
    	for(String cuenta : listaccstring) {  // a partir de las líneas del fichero las añado a la lista de cuentas de la caixa
    		String[] partes = cuenta.split(";");
    		cuentasSabadell.add(new CuentaSabadell(
    				partes[0],
    				partes[1],
    				partes[2], 
    				partes[3],
    				Double.parseDouble(partes[4]),
    				NivelCatalan.Medio
    				));
    	}
    	return cuentasSabadell;
	}
	
	public static List<CuentaSantander> ListaCuentasSantander(Path ruta) {
		List<String> listaccstring = devolverLineasJava8(ruta);
		List<CuentaSantander> cuentasSantander = new ArrayList<CuentaSantander>();
		
		
		for(String cuenta : listaccstring) {  // a partir de las líneas del fichero las añado a la lista de cuentas de la caixa
			String[] partes = cuenta.split(";");
			cuentasSantander.add(new CuentaSantander(
					partes[0],
					partes[1],
					partes[2], 
					partes[3],
					Double.parseDouble(partes[4]),
					false
					));
		}
		return cuentasSantander;
	}
	
	public static List<Cuenta> fileToList(Path ruta) throws IOException {
		List<Cuenta> resultado = new ArrayList<Cuenta>();
		if (Files.isDirectory(ruta)) {
			List<Path> archivos = Files.list(ruta).filter(Files::isRegularFile).toList();
			resultado.addAll(ListaCuentasCaixa(archivos.get(0)));
			resultado.addAll(ListaCuentasSabadell(archivos.get(1)));
			resultado.addAll(ListaCuentasSantander(archivos.get(2)));
		}
		return resultado;

	}
	
	public static void eliminarAleatorio(List<Cuenta> cuentas) {
		Random random = new Random();
		int posicion = random.nextInt(cuentas.size());
//		Class clase = cuentas.get(posicion);
		cuentas.remove(posicion);
//		cuentas.add(posicion, new clase);
	}
	
}
