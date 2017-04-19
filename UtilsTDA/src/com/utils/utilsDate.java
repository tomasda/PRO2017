package com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utilsDate {

	/**
	 * M�todo que devuelve la fecha actual en distintos formatos seg�n se especifique en la petici�n.
	 * 
	 * @param tipo
	 * @return
	 */
	public static String fecha(String tipo) {
		String fecha = null;
		DateFormat dateFormat = null;
		/*
		 * Este c�digo se sustituye por el abajo descrito debido a que java 1.6 no lo soporta. switch (tipo){ case "1": dateFormat = new
		 * SimpleDateFormat("dd/MM/yy HH:mm:ss"); break; case "2": dateFormat = new SimpleDateFormat("dd-MM-yyyy"); break; case "3": dateFormat = new
		 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); break; }
		 */
		if (tipo.equals("1")) {
			dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		} else if (tipo.equals("2")) {
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		} else if (tipo.equals("3")) {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		}
		Calendar cal = Calendar.getInstance();
		fecha = dateFormat.format(cal.getTime());
		return fecha;
	}

	public static String parseRangeDate(String Start_End, String fechasDesdeHasta) {
		Pattern pattern = Pattern.compile("^(\\d{1,2})[/]([0-9]{2,})[/]([0-9]{4,})[\\s][-][\\s](\\d{1,2})[/]([0-9]{2,})[/]([0-9]{4,})$");
		Matcher matcher = pattern.matcher(fechasDesdeHasta);
		String start = "";
		String end = "";
		String fecha = "";
		if (matcher.matches()) {// Verifico el Formato entregado por el DatePicker 23/08/2016 - 21/09/2016
			pattern = Pattern.compile("([0-9]{1,2})[/]([0-9]{2,})[/]([0-9]{4,})");
			matcher = pattern.matcher(fechasDesdeHasta);
			int cont = 1;
			while (matcher.find()) {
				String aa = matcher.group(3);
				String bb = aa.substring(2);
				if (cont == 1) {
					start = (matcher.group(1) + "/" + matcher.group(2) + "/" + bb);
				}
				if (cont == 2) {
					end = (matcher.group(1) + "/" + matcher.group(2) + "/" + bb);
				}
				cont++;
			}
			switch (Start_End) {
			case "Start":
				fecha = start;
				break;
			case "End":
				fecha = end;
				break;
			}
		}
		return fecha;
	}

	public static String parseDate(String inputType, String outputType, String fecha) {
		DateFormat inputDateFormat = null;
		DateFormat dateFormat = null;
		if (null != fecha) {
			switch (inputType) {
			case "1":
				inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
				break;
			}

			switch (outputType) {
			case "1":
				dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				break;
			case "2":
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				break;
			case "3":
				dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				break;
			case "4":
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				break;
			case "day":
				dateFormat = new SimpleDateFormat("dd");
				break;
			case "month":
				dateFormat = new SimpleDateFormat("MMM");
				break;
			case "year":
				dateFormat = new SimpleDateFormat("yyyy");
				break;
			}

			try {
				fecha = dateFormat.format(inputDateFormat.parse(fecha));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return fecha;
	}

}