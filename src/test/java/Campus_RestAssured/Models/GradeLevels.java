package Campus_RestAssured.Models;

public class GradeLevels {
    private String name;
    private String shortName;
    private String order;
    private String id;

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GradeLevels{" +
                "name='" + name + '\'' +
                ", shotName='" + shortName + '\'' +
                ", order='" + order + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
