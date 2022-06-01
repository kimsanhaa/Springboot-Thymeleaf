package hello.springmvc.event;

public class RegisterdEvent {
    private String name;

    public RegisterdEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
