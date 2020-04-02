/* ValueObject -------------------------------------------------- */
public class UserId {
    int id;

    public UserId(int userId) {
        if(!validate(userId)) throw new IllegalUserId();

        this.id = userId;
    }

    boolean validate(int userId) {
        if(userId < 1) return false;
        if(userId > 1000) return false;

        return true;
	}
}

public class User {
    UserId userId;
}

/* Repository -------------------------------------------------- */
public interface UserRepository {
    User findBy(UserId userId);
}

public class ImplementedUserRepository implements UserRepository {
    public User findBy(UserId userId) {
        stmt.executeQuery("SELECT * FROM users WHERE id = ?", userId.getId());
        // ValueObjectはgetter/setterを作らないという条項がある。
        // しかし、これは*原則*でしかないためgetterに関しては何故作りたくないのかを理解した上でなら作っても良い。
        // setterに関してはValueObjectの重要な点である不変を保つために必ず作ってはいけない。
        // 例えば金額の足算をしたいときなどは関数的に新たなObjectを返す形で実装する。
    }
}

/* Application -------------------------------------------------- */
public class UserService {
    public void find(UserRepository userRepository) {
        UserId userId = new UserId(1);
        User user = userRepository.findBy(userId);

        // Use user ......
    }
}
