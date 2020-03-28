package services;

import domain_models.Todo;

@Service
class TodoRegisterService {
    @Autowired
    TodoRepository repository;

    void register(Todo todo) {
        repository.register(todo);
    }
}
