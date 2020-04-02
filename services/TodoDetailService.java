package services;

import domain_models.Todo;
import domain_models.TodoRepository;

@Service
class TodoDetailService {
    @Autowired
    TodoRepository repository;

    public Todo viewBy(int id) {
        return repository.viewBy(id);
    }

    // if todo is not done, it can update todo
    // * Is this method domain ?
    boolean canUpdate(Todo todo) {
        return !todo.isDone();
    }
}
