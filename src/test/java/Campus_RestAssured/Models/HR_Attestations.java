package Campus_RestAssured.Models;

public class HR_Attestations {

    private String name;
    private String id;

    public HR_Attestations() {
    }

    public HR_Attestations(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "Attestation{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
