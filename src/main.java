import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;

import java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CharSequence html01 = "<";
		CharSequence html02 = ">";
		CharSequence html03 = "td";
		CharSequence html04 = "\"1\"";
		CharSequence html05 = "\"2\"";
		CharSequence html06 = "\"3\"";
		CharSequence html07 = "/";
		CharSequence html08 = "rowspan=";
		CharSequence html09 ="&nbsp";
		CharSequence html10 = "bgcolor=#D9E6F4";
		
		File arquivo = new File("ResultadosMegaSena.html");
		
		ArrayList<String> dados = new ArrayList<String>();
		ArrayList<ArrayList<String>> dados2 = new ArrayList<>();

		try {
			FileReader leitor = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha;

			//ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
			while ((linha = buffer.readLine()) != null) {
				
				CharSequence empty = "";
				
				String x = linha.replace(html01, empty);
				x = x.replace(html02, "");
				x = x.replace(html03, empty);
				x = x.replace(html04, empty);
				x = x.replace(html05, empty);
				x = x.replace(html06, empty);
				x = x.replace(html07, empty);
				x = x.replace(html08, empty);
				x = x.replace(html09, "-");
				x = x.replace(html10, empty);
				x = x.trim();
				
				if(!x.isEmpty()) {
					
					if(!x.equals("tr")) {
						dados.add(x);
					} else if (!dados.isEmpty()){
						dados2.add(dados);
						
						System.out.println(dados);
						
						dados.clear();
					}
				}
				
			}
			
			
		} catch (IOException e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();
		}
	
	}
	
}
