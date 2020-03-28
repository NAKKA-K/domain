import domain_models.Todo;

public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo("hello");
        System.out.print(todo.getTodoInfo());
    }
}
