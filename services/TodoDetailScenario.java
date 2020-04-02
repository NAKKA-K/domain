package services;

import domain_models.Todo;
import domain_models.TodoRepository;

@Service
class TodoDetailScenario {
    @Autowired
    TodoDetailService queryService;
    @Autowired
    TodoUpdateService updateService;

    public Todo update(Todo todo) {
        if(!queryService.canUpdate(todo)) {
            throw new IllegalStateException("完了したTodoは変更することができません");
        }

        return updateService.update(todo);
    }
}
