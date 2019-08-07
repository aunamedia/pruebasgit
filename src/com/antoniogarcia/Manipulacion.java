package com.antoniogarcia;

import java.util.Scanner;

public class Manipulacion {
	
	private double _int;
	public Manipulacion(double _int) {
		this._int = _int;
	}
	public Manipulacion() {
		Scanner sc = new Scanner(System.in);
		this._int = sc.nextDouble();
		sc.close();
	}
	
	public double doble() {
		return this._int*2;
	}
	
	public double mitad() {
		return this._int/2;
	}
}
