package com.enrique.ejercicio_de_clases.entities;

import java.util.Objects;

import com.enrique.ejercicio_de_clases.enums.NivelCatalan;

public final class CuentaSabadell extends Cuenta{
	
	private NivelCatalan nivelCatalan;
	

	public CuentaSabadell(String dni, String nombre, String fecha, String pais, double saldo,
			NivelCatalan nivelCatalan) {
		super(dni,  nombre,  fecha,  pais, saldo);
		this.nivelCatalan = nivelCatalan;
	}
	
	public CuentaSabadell(CuentaSabadell c) {
		super(c);
		this.nivelCatalan = c.nivelCatalan;
	}

	public NivelCatalan getNivelCatalan() {
		return nivelCatalan;
	}

	public void setNivelCatalan(NivelCatalan nivelCatalan) {
		this.nivelCatalan = nivelCatalan;
	}

	@Override
	public String toString() {
		return "CuentaSabadell {nivelCatalan=" + nivelCatalan + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", getFecha()=" + getFecha() + ", getPais()=" + getPais() + ", getSaldo()=" + getSaldo()
				+ "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nivelCatalan);
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
		CuentaSabadell other = (CuentaSabadell) obj;
		return nivelCatalan == other.nivelCatalan;
	}


	
	
	
}

	
	
