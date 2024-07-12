package com.jsp.ads.jdbc.hospital;

public class JDBC_Hospital_App {
	public static void main(String[] args) {
		System.out.println("1.Add Client   2.Display All Client   3.Update Client   4.Delete Client By Id\nEnter Your Choice");
		int choice = JDBC_Hospital_Service.scanner.nextInt();
		switch(choice) {
		case 1: {
			JDBC_Hospital_Service.addClient();
		}
		break;
		case 2: {
			JDBC_Hospital_Service.findAllClient();
		}
		break;
		case 3: {
			JDBC_Hospital_Service.updateClient();
		}
		break;
		case 4: {
			JDBC_Hospital_Service.deleteClient();
		}
		break;
		default : System.err.println("Select Only Above Choice");
		}
	}

}
