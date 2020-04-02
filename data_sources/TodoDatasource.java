package data_sources;

import domain_models.Todo;
import domain_models.TodoRepository;

class TodoDatasource implements TodoRepository {
    @Autowired
    Connection connector;

    public boolean register(Todo todo) {
        try (
            PreparedStatement todoStmt =
                connector.preparedStatement("INSERT INTO todos(description) VALUES (?)", new String[]{"id"});
            PreparedStatement costStmt =
                connector.preparedStatement("INSERT INTO todo_costs(cost, todo_id) VALUES (?, ?)");
        ) {
            todoStmt.setString(1, todo.description);
            todoStmt.executeUpdate();
            int todoId = this.getGeneratedIdFrom(stmt);

            // Todoをルートとした集約に含まれるCostオブジェクトもTodoRepositoryの責任で登録する
            costStmt.setString(1, todo.cost);
            costStmt.setString(2, todoId);
            costStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getGeneratedIdFrom(PreparedStatement stmt) {
        ResultSet generatedKeys = this.getGeneratedKeysFrom(stmt);
        return generatedKeys.getInt("id");
    }

    private ResultSet getGeneratedKeysFrom(PreparedStatement stmt) {
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys == null || !generatedKeys.next()) {
            throw new SQLException("自動採番IDを正常に生成、又は取得できませんでした");
        }
        return generatedKeys;
    }

    public Todo viewBy(int id) {

    }

    public Todo update(Todo todo) {

    }
}
