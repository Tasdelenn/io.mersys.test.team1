package Campus_RestAssured.Models;

public class Fees {
    private String id;
    private String budgetAccountIntegrationCode;
    private String name;
    private String code;
    private int priority;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBudgetAccountIntegrationCode() {
        return budgetAccountIntegrationCode;
    }

    public void setBudgetAccountIntegrationCode(String budgetAccountIntegrationCode) {
        this.budgetAccountIntegrationCode = budgetAccountIntegrationCode;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Fees{" +
                "id='" + id + '\'' +
                ", budgetAccountIntegrationCode='" + budgetAccountIntegrationCode + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", priority=" + priority +
                '}';
    }
}
