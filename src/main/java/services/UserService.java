package services;

import models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "admin", "alex", 21, "alex@test.com", 1);
        User user2 = new User(2, "user", "test2", 25, "test2@test.com", 1);
        User user3 = new User(3, "super-user", "test3", 27, "test3@test.com", 2);
        User user4 = new User(4, "user", "test4", 30, "test4@test.com", 2);
        User user5 = new User(5, "super-user", "test4", 30, "test5@test.com", 3);

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    // Method to return all users belonging to a specific company
    public List<User> getUsersByCompanyId(int companyId) {
        return userList.stream()
                .filter(user -> user.getCompanyId() == companyId)
                .collect(Collectors.toList());
    }

    public Optional<User> getUser(String role) {
        return userList.stream().filter(user -> role.equals(user.getRole())).findFirst();
    }
}
