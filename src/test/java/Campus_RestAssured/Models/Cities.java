package Campus_RestAssured.Models;

public class Cities {

    private String id;
    private String name;
    private Country country;
    private States state;

    public Cities(String name, Country country) {
        //this.name = name;
        //this.country = country;
        setName(name);
        setCountry(country);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", state=" + state +
                '}';
    }
}





/**

 {
 "id": "63c11d3f0b56945bf5198d63",
 "name": "Anycit2",
 "country": {
 "id": "63a45bdbcb75ee5c2199a8cf"
 },
 "state": {
 "id": "63bfc7202bb4c301d4119745"
 },
 "translateName": null
 }

*/