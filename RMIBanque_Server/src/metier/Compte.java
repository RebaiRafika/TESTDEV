package metier;

	import java.io.Serializable;
	import java.util.Date;

	public class Compte implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 8001442444246637320L;
		private int code;
	    private double solde;
	    private Date dateCreation;

	    public Compte(int code, double solde, Date dateCreation) {
	        this.code = code;
	        this.solde = solde;
	        this.dateCreation = dateCreation;
	    }

	    // Getters and Setters (You can generate these using IDE shortcuts)
	    // ...

	    @Override
	    public String toString() {
	        return "Compte{" +
	                "code=" + code +
	                ", solde=" + solde +
	                ", dateCreation=" + dateCreation +
	                '}';
	    }
	

	public static void main(String[] args) {
		System.out.println("solde est :");
		System.out.println("code est :");
		System.out.println("dateCreation est :");

	}

}
