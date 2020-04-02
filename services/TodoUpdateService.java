package services;

import domain_models.Todo;
import domain_models.TodoRepository;

@Service
class TodoUpdateService {
    @Autowired
    TodoRepository repository;

    public void update(Todo todo) {
        return repository.update(todo);
    }

    // example !!!
    public void mainUpdate(Request req) {
        Todo reqestedTodo =
            new Todo(req.todo.description, new Cost(req.todo.cost));
        this.update(reqestedTodo);
    }
}
