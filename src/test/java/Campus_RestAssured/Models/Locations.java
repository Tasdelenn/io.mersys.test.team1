package Campus_RestAssured.Models;

public class Locations {

    private String id;
    private String name;
    private String shortName;
    private Boolean active;
    private int capacity;
    private String type;
    private String school;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    //{
    //  "id": null,
    //  "name": "{{$randomInt}} ->Team1School<- {{$randomInt}}",
    //  "shortName": "T1S",
    //  "active": {{$randomBoolean}},
    //  "capacity": {{$randomInt}},
    //  "type": "LABORATORY",
    //  "school": "6390f3207a3bcb6a7ac977f9"
    //}
    //
    ////  "type": "LABORATORY", kısmına bunlarda -->  CLASS , OTHER   <-- eklenebilir
}
