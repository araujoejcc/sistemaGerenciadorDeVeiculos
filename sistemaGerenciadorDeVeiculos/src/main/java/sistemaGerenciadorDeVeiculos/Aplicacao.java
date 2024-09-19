package sistemaGerenciadorDeVeiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		
		
//		testar com IP do desktop para inserir a partir do notebook
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usuario = "postgres";
		String senha = "123";

		try {
			Connection myConnection = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!?");

			String cpf = "01346430462";
			int idade = 38;

			Scanner scan = new Scanner(System.in);

			System.out.println("Digite seu CPF: ");
			
			cpf = scan.nextLine();

			System.out.println("Digite sua idade: ");

			idade = scan.nextInt();
			
			System.out.println("Dados inseridos com sucesso!");
			
			String comandoSQL = "insert into usuario (cpf, idade) values (?, ?)";

			PreparedStatement pstm = myConnection.prepareStatement(comandoSQL);

			pstm.setString(1, cpf);
			pstm.setInt(2, idade);
			pstm.execute();
			
			myConnection.close();
			scan.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}