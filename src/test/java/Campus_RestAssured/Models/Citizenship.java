package Campus_RestAssured.Models;

public class Citizenship {
    private String id;
    private String name;
    private String shortName;

    public Citizenship(String name, String shortName) {
        //this.name = name;
        //this.shortName = shortName;
        setName(name);
        setShortName(shortName);
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Citizenship{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
