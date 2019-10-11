/**
 * @author nikgupta
 *
 */
import java.util.*;


public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Map<String, Double> data = new HashMap<String, Double>();
//		data.put("China", 1500.0);
//		data.put("India", 1300.0);
//		data.put("USA", 300.0);
//		data.put("Russia", 140.0);
//		
//		CountryVsPopulation countryVsPopulation = new CountryVsPopulation(data);
//		for(int i=0; i<10; i++) {
//			System.out.println(countryVsPopulation.GetRandomCountry());
//		}
		
		Set<String> allSequence= GeneratePossibleDNASequence(3);
		
		for(String sequence : allSequence) {
			System.out.println(sequence);
		}
	}
	
	public static Set<String> GeneratePossibleDNASequence(int length) {
		Set<String> output = new HashSet<String>();
		
		if(length == 1) {
			output.add("A");
			output.add("C");
			output.add("G");
			output.add("T");
		} else {
			Set<String> subOutput = GeneratePossibleDNASequence(length-1);
			for(String subString : subOutput) {
				output.add(String.format("%s%s", "A", subString));
				output.add(String.format("%s%s", "C", subString));
				output.add(String.format("%s%s", "G", subString));
				output.add(String.format("%s%s", "T", subString));
			}
		}
		
		return output;
	}

}
