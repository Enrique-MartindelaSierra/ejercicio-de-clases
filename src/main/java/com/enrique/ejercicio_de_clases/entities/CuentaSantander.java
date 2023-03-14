package com.enrique.ejercicio_de_clases.entities;

import java.util.Objects;

public class CuentaSantander extends Cuenta{

	private boolean residente;
	private static int contador;

	public CuentaSantander() {
		super();
		residente=false;
		contador++;
	}

	public CuentaSantander(String dni, String nombre, String fecha, String pais, double saldo,
			boolean residente) {
		super( dni,  nombre,  fecha,  pais,  saldo);
		this.residente = residente;
		contador++;
	}
	
	public CuentaSantander(CuentaSantander c) {
		super(c);
		this.residente = c.residente;
		contador++;
	}

	public boolean isResidente() {
		return residente;
	}

	public void setResidente(boolean residente) {
		this.residente = residente;
	}

	public static int getContador() {
		return contador;
	}
	
	public static void setContador(int contador) {
		CuentaSantander.contador = contador;
	}

	@Override
	public String toString() {
		return "CuentaSantander [residente=" + residente + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getFecha()=" + getFecha() + ", getPais()=" + getPais() + ", getSaldo()=" + getSaldo() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(residente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaSantander other = (CuentaSantander) obj;
		return residente == other.residente;
	}
	
	


}
