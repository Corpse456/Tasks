package techCup.teamName;

public class Team {
    String name;
    String city;
    
    public Team(String name, String city) {
	this.name = name;
	this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
	return name + " " + city;
    } 
}