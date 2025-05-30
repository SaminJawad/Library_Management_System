import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        this.userList = new ArrayList<>();
    }

    public void loadUsersFromCSV(String filePath, String userType) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String userId = data[0].trim();
                    String name = data[1].trim();
                    String additional = data[2].trim();

                    User user;
                    if (userType.equals("student")) {
                        user = new Student(userId, name, additional);
                    } else {
                        user = new Teacher(userId, name, additional);
                    }
                    userList.add(user);
                }
            }
        }
    }

    public User getUserById(String id) throws UserNotFoundException {
        for (User user : userList) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with ID " + id + " not found");
    }

    public boolean authenticateUser(String id) {
        try {
            getUserById(id);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }
    }

    public void displayAllUsers() {
        System.out.println("All Users:");
        for (User user : userList) {
            if (user instanceof Student) {
                ((Student) user).displayInfo();
            } else if (user instanceof Teacher) {
                ((Teacher) user).displayInfo();
            }
        }
    }

    public List<User> getUserList() {
        return userList;
    }
}