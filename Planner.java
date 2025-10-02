// DigitalPlanner.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DigitalPlanner {

    private JFrame frame;
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, deleteButton;

    public DigitalPlanner() {
        frame = new JFrame("✨ Digital Planner ✨");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Header
        JLabel header = new JLabel("My Daily Planner", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(50, 50, 200));
        frame.add(header, BorderLayout.NORTH);

        // Task list
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        
        taskInput = new JTextField();
        taskInput.setFont(new Font("Arial", Font.PLAIN, 16));
        bottomPanel.add(taskInput, BorderLayout.CENTER);
        
        addButton = new JButton("Add Task");
        addButton.setBackground(new Color(50, 200, 50));
        addButton.setForeground(Color.WHITE);
        bottomPanel.add(addButton, BorderLayout.EAST);
        
        deleteButton = new JButton("Delete Task");
        deleteButton.setBackground(new Color(200, 50, 50));
        deleteButton.setForeground(Color.WHITE);
        bottomPanel.add(deleteButton, BorderLayout.SOUTH);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        taskInput.addActionListener(e -> addTask()); // Press Enter to add

        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            taskModel.addElement(task);
            taskInput.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalPlanner::new);
    }
}
