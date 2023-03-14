package com.enrique.ejercicio_de_clases.entities;

import java.util.Objects;

import com.enrique.ejercicio_de_clases.enums.NivelCatalan;

public final class CuentaCaixa extends Cuenta{

	private NivelCatalan nivelCatalan;
	
	public CuentaCaixa() {
		super();
		nivelCatalan=NivelCatalan.Medio; //por defecto
	}

	public CuentaCaixa(String dni, String nombre, String fecha, String pais, double saldo,
			NivelCatalan nivelCatalan) {
		super(dni,  nombre,  fecha,  pais, saldo);
		this.nivelCatalan = nivelCatalan;
	}
	
	public CuentaCaixa(CuentaCaixa c) {
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
		return "CuentaCaixa (nivelCatalan=" + nivelCatalan + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", getFecha()=" + getFecha() + ", getPais()=" + getPais() + ", getSaldo()=" + getSaldo()
				+ ")";
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
		CuentaCaixa other = (CuentaCaixa) obj;
		return nivelCatalan == other.nivelCatalan;
	}


	
	
	
}