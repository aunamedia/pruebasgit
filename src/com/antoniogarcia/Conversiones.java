package com.antoniogarcia;

public class Conversiones {

	public String HEX_IP(String x) {
		
		if (x.length()%2 != 0) x = "0"+x;
		int posiciones = x.length();
		//System.out.println("Vamos a convertir a IP "+x+" de " + posiciones + " posiciones:");
		String xxxx = "";
		//String xx = x.substring(posiciones-3, posiciones-1);
		//System.out.println(xx);
		for(int i = posiciones-2; i >=-1; i-=2) {
			String xx = (x.substring(i, i+2));
			int xxx;
			try {
				xxx = Integer.parseInt(xx, 16);
			} catch(Exception e) {
				return "ERROR";
			}
			//System.out.println(xx);
			if(xxx > 0 || xxxx != "")
			xxxx += xxx+".";
		}
		
		return xxxx.substring(0, xxxx.length()-1);
		//return "YA";
	}
	
	public int DEC(String x) {
		System.out.println("Vamos a convertir a DECIMAL "+x+" de " + x.length() + " posiciones:");
		return Integer.parseInt(x, 16);
	}
}
