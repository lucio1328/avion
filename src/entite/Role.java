package entite;

public class Role {
    Integer id;
    String type;

    //==============================================
    public Role(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
    public Role() {
    }
    //==============================================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
