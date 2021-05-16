package rest.model;

public class ResponseMsg {

    private String message;

    public ResponseMsg(String name) {
        this.message = name;
    }

    public String getName() {
        return message;
    }

    public void setName(String name) {
        this.message = name;
    }
}
