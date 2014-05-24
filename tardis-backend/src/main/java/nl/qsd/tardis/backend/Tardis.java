package nl.qsd.tardis.backend;

import java.util.Arrays;
import java.util.List;

public class Tardis {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Erik", "Alex", "Barre", "Jeroen", "Ivo");
		names.parallelStream().forEach(name -> System.out.println(name));
	}
	
}
