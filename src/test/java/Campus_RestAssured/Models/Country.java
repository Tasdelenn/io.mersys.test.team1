package Campus_RestAssured.Models;

public class Country {
    private String name;
    private String code;
    private String id;
    private boolean hasState;

    public boolean isHasState() {
        return hasState;
    }

    public void setHasState(boolean hasState) {
        this.hasState = hasState;
    }

    public Country() {
    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
