package domain_models;

public interface TodoRepository {
    public boolean register(Todo todo);
    public Todo viewBy(int id);
}
