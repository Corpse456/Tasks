package pvt.notebook1.maks;

///стандартно принято вверху все переменные-члены объявить, после них конструкторы, после 
///все содержательные методы, 
public class cityUnit {
	public	String getFullName() {
		return fullName;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public int getRegion() {
		return region;
	}
	
	public void setRegion(int region) {
		this.region = region;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	private String shortName, fullName, FullName;
	private int population, region;
	private double latitude, longitude;


	cityUnit(String shortName, String fullName, String FullName, int region, int population, double latitude,
			double longitude) {
		this.shortName = shortName;
		this.fullName = fullName;
		this.FullName = fullName;
		this.region = region;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
	}

    ///Не стоило ради отсуттвия населения делать второй такой конструктор. Передавал бы просто ноль. 
    ///Тем более у тебя население
    ///всё равно будет иметь значение равное 0. (для инта по умолчанию 0).
    ///Если уж ты хотел, чтобы население в принципе отуствовало, если не известно - то 
    ///вместо int можно использовать Integer, так как Integer может быть равен null.
	cityUnit(String shortName, String fullName, String FullName, int region, double latitude, double longitude) {
		this.shortName = shortName;
		this.fullName = fullName;
		this.FullName = fullName;
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return shortName + "," + fullName + "," + FullName + "," + region + "," + population + "," + latitude + ","
				+ longitude;
	}

}
