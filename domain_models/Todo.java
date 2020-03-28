package domain_models;

public class Todo {
    int id;
    String body;
    boolean done;

    public Todo(String body) {
        this.body = body;
    }

    public String getTodoInfo() {
        return this.id + ": " + this.body;
    }

    public boolean isDone() {
        return this.done;
    }
}
