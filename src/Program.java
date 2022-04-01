import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String path = "c:/in.txt";
		Map<String, Integer> map = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] file = line.split(",");
				String valor = file[0];
				Integer key = Integer.parseInt(file[1]);

				if (map.containsKey(valor)) {
					int votosqnt = map.get(valor);
					map.put(valor, key + votosqnt);
				} else {
					map.put(valor, key);
				}

				line = br.readLine();
			}

			for (String list : map.keySet()) {
				System.out.println(list + " " + map.get(list));
			}

		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());

		}

	}

}
