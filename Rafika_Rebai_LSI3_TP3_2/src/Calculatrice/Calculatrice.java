package Calculatrice;

	import java.io.Serializable;

	@SuppressWarnings("serial")
	public class Calculatrice implements Serializable {
	    public int addition(int a, int b) {
	        return a + b;
	    }

	    public int soustraction(int a, int b) {
	        return a - b;
	    }

	    public int multiplication(int a, int b) {
	        return a * b;
	    }

	    public int division(int a, int b) {
	        if (b != 0) {
	            return a / b;
	        } else {
	            throw new ArithmeticException("Division par zéro !");
	        }
	    }

	    public static void main(String[] args) {
	        Calculatrice calculatrice = new Calculatrice();
	        int a = 10;
	        int b = 5;

	        int resultatAddition = calculatrice.addition(a, b);
	        int resultatSoustraction = calculatrice.soustraction(a, b);
	        int resultatMultiplication = calculatrice.multiplication(a, b);

	        System.out.println("Résultat de l'addition : " + resultatAddition);
	        System.out.println("Résultat de la soustraction : " + resultatSoustraction);
	        System.out.println("Résultat de la multiplication : " + resultatMultiplication);

	        try {
	            int resultatDivision = calculatrice.division(a, b);
	            System.out.println("Résultat de la division : " + resultatDivision);
	        } catch (ArithmeticException e) {
	            System.err.println(e.getMessage());
	        }

	    }  }


