import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TaskManager {

    // Add Task
    public void addTask(String task) {
        String sql = "INSERT INTO tasks (task, status) VALUES (?, false)";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
            System.out.println("Task added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // List Tasks
    public void listTasks() {
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                boolean status = rs.getBoolean("status");
                System.out.println("ID: " + id + ", Task: " + task + ", Completed: " + status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Task
    public void updateTask(int id, String newTask, boolean newStatus) {
        String sql = "UPDATE tasks SET task = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTask);
            pstmt.setBoolean(2, newStatus);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Task updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Task
    public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Task deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
