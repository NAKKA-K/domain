package domain_models;

import domain_models.Cost;

public class Todo {
    int id;
    String body;
    boolean done;
    Cost cost;

    public Todo(String body, Cost cost) {
        this.body = body;
        this.cost = cost;
    }

    public String getTodoInfo() {
        return this.id + ": " + this.body;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setCost() {
        // example !!!
        this.cost = new Cost();
        // find cost from todo_id by repository
    }
}
