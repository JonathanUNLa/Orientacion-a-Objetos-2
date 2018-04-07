package funciones;

import java.util.*;

public class Funciones {
	
	public static boolean esBisiesto(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}	
	public static int traerAnio (GregorianCalendar date){
		return date.get(Calendar.YEAR);
	}	
	public static int traerMes (GregorianCalendar date){
		return date.get(Calendar.MONTH)+1;
	}	
	public static int traerDia (GregorianCalendar date){
		return date.get(Calendar.DAY_OF_MONTH);
	}	
	public static boolean esFechaValida (int year,int month,int day) {
		boolean validDate=true;		
		
		if (month > 12 || month < 1  ||  year<0)
			validDate=false;
		
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (day > 31 || day < 1)
					validDate=false;
				break;
				
			case 4: case 6: case 9: case 11:
				if (day > 30 || day < 1)
					validDate=false;
				break;
			case 2:
				if (day > 29 || day < 1 && esBisiesto(year)==true) 
					validDate=false;
				else if (day > 28 || day < 1)
						validDate=false;
				break;
		}
		return validDate;
	}
	public static GregorianCalendar traerFecha(int year, int month, int day){
		GregorianCalendar date=null;
		
		if (esFechaValida(year,month,day))
			date =new GregorianCalendar(year, month-1, day);
		
		return date;
	}
	public static GregorianCalendar traerFecha (String strDate) {
		GregorianCalendar date = null;
		
		int firstBackslash  = strDate.indexOf("/");
		int secondBackslash = strDate.lastIndexOf("/");
		
		int year,month,day;		String strDay,strMonth,strYear;
		
		strDay   = strDate.substring(0, firstBackslash);
		strMonth = strDate.substring(firstBackslash+1, secondBackslash);
		strYear  = strDate.substring(secondBackslash+1, secondBackslash+5);
		day   = Integer.parseInt(strDay);
		month = Integer.parseInt(strMonth);
		year  = Integer.parseInt(strYear);
		
		if (esFechaValida(year,month,day))
			date=new GregorianCalendar(year, month-1, day);
		
		return date;
	}
	public static String traerFechaCorta(GregorianCalendar date){
		String strDate = traerDia(date)+"/"+traerMes(date)+"/"+traerAnio(date);
		return strDate;
	}
	public static String traerFechaCortaHora(GregorianCalendar date){
		int hour   = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);
		
		String strHour = hour+":"+minute+":"+second;
		String strDate = traerFechaCorta(date);
		String strDateHour = strDate+" "+strHour;
		
		return strDateHour;
	}
	public static GregorianCalendar traerFechaProximo(GregorianCalendar date, int days){
		GregorianCalendar nextDate = (GregorianCalendar) date.clone();
		nextDate.add(Calendar.DAY_OF_MONTH, days);
		
		return nextDate;
	}
	
	public static boolean esDiaHabil (GregorianCalendar date) {
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		int Sunday    = 1;
		int Saturday  = 7;
		boolean afterSunday    = dayOfWeek > Sunday; 
		boolean beforeSaturday = dayOfWeek < Saturday;
		boolean businessDay = false;
		
		if(afterSunday && beforeSaturday)
			businessDay=true;

		return businessDay;
	}
	public static String traerDiaDeLaSemana (GregorianCalendar date) {
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		String strDay = null;
		
		switch(dayOfWeek){
			case 1:
				strDay = "Domingo";
				break;
			case 2:
				strDay = "Lunes";
				break;
			case 3:
				strDay = "Martes";
				break;
			case 4:
				strDay = "Miércoles";
				break;
			case 5:
				strDay = "Jueves";
				break;
			case 6:
				strDay = "Viernes";
				break;
			case 7:
				strDay = "Sábado";
				break;
		}
		return strDay;
	}
	public static String traerMesEnLetras(GregorianCalendar date) {
		String strMonth = null;
		int month = traerMes(date);  
		
		switch(month) {
			case 0:
				strMonth = "Enero";
				break;
			case 1:
				strMonth = "Febrero";
				break;
			case 2:
				strMonth = "Marzo";
				break;
			case 3:
				strMonth = "Abril";
				break;
			case 4:
				strMonth = "Mayo";
				break;
			case 5:
				strMonth = "Junio";
				break;
			case 6:
				strMonth = "Julio";
				break;
			case 7:
				strMonth = "Agosto";
				break;
			case 8:
				strMonth = "Septiembre";
				break;
			case 9:
				strMonth = "Octubre";
				break;
			case 10:
				strMonth = "Noviembre";
				break;
			case 11:
				strMonth = "Diciembre";
				break;
		}
		return strMonth;
	}
	public static String traerFechaLarga (GregorianCalendar date) {
		int day = traerDia(date);
		int year =traerAnio(date);
		String month =traerMesEnLetras(date);
		String dayOfWeek = traerDiaDeLaSemana(date);
		String longDate = dayOfWeek+" "+day+" de "+month+" del "+year;
		
		return longDate;
	}
	public static boolean sonFechasIguales(GregorianCalendar date1, GregorianCalendar date2){
		String strDate1=traerFechaCorta(date1);
		String strDate2=traerFechaCorta(date2);
		
		return (strDate1.compareTo(strDate2)==0);
	}
	public static boolean sonFechasHorasIguales(GregorianCalendar date1, GregorianCalendar date2){
		String strFecha1=traerFechaCortaHora(date1);
		String strFecha2=traerFechaCortaHora(date2);
		
		return (strFecha1.compareTo(strFecha2)==0);
	}
	public static int traerCantDiasDeUnMes (int year,int month) {
		GregorianCalendar date = new GregorianCalendar(year,month-1,1);
		//GregorianCalendar date = new GregorianCalendar(year,month,0);
		int daysOfMonth=date.getActualMaximum(Calendar.DAY_OF_MONTH);
	
		return (daysOfMonth);
	}
	public static double aproximar2Decimal (double value) {
		return Math.rint(value * 100) / 100;
	}	
	public static boolean esNumero (char c) {
		return Character.isDigit(c);
	}
	public static boolean esLetra (char c) {
		return Character.isLetter(c);
	}
	public static boolean esCadenaNros(String str) {
		boolean isNumber = true;
		int i = 0;
		
		while (isNumber && i < str.length()) {
			isNumber = esNumero(str.charAt(i));
			i++;
		}
		
		return isNumber;
	}
	
	public static boolean esCadenaLetras(String str) {
		boolean isLetter = true;
		int i = 0;
		
		while (isLetter && i < str.length()) {
			isLetter = esLetra(str.charAt(i));
			i++;
		}
		
		return isLetter;
	}
}