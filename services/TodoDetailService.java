package services;

import domain_models.Todo;
import domain_models.TodoRepository;

@Service
class TodoDetailService {
    @Autowired
    TodoRepository repository;

    Todo viewBy(int id) {
        return repository.viewBy(id);
    }

    // if todo is not done, it can update todo
    // * this method is domain
    boolean canUpdate(Todo todo) {
        return !todo.isDone();
    }
}
