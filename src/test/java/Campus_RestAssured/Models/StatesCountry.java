package Campus_RestAssured.Models;

public class StatesCountry {
    private String id;

    public StatesCountry(String id) {
        this.id = id;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String getId() {
        return id;
    }


}
