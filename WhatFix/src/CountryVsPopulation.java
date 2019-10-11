import java.util.*;

/*
 * Class which for storing country and population mapping
 */
public class CountryVsPopulation {
	private List<String> countries;
	private List<Double> cumulativePopulation;
	private Double totalPopulation;
	private Random random;
	
	public CountryVsPopulation(Map<String, Double> data) {
		this.countries = new ArrayList<String>();
		this.cumulativePopulation = new ArrayList<Double>();
		this.random = new Random();
		
		this.Initialize(data);
	}
	
	public String GetRandomCountry() {
		String randomCountry = null;
		Double randomNumber = this.GetRandomNumber();
		
		for(int i=0; i<this.cumulativePopulation.size(); i++) {
			if(randomNumber < this.cumulativePopulation.get(i)) {
				randomCountry = this.countries.get(i);
				break;
			}
		}
		
		return randomCountry;
	}
	
	private void Initialize(Map<String, Double> data) {
		this.totalPopulation = 0.0;
		for(String country : data.keySet()) {
			this.countries.add(country);
			this.totalPopulation += data.get(country);
			this.cumulativePopulation.add(this.totalPopulation);
		}
	}
	
	private Double GetRandomNumber() {
		double randomNumber = this.random.nextDouble();
		return (randomNumber*this.totalPopulation);
	}
}
