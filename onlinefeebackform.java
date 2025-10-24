// OnlineFeedbackForm.java
// A simple Feedback Form using Java Swing components.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineFeedbackForm extends JFrame implements ActionListener {

    // Declare UI components
    JLabel titleLabel, ratingLabel, commentLabel;
    JRadioButton star1, star2, star3, star4, star5;
    JTextArea commentArea;
    JButton submitButton;
    ButtonGroup ratingGroup;

    // Constructor to set up the GUI
    OnlineFeedbackForm() {
        // Set title of the window
        setTitle("Online Feedback Form");

        // Set layout manager
        setLayout(new BorderLayout(10, 10));

        // ---------- NORTH SECTION ----------
        titleLabel = new JLabel("Service Feedback Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // ---------- CENTER SECTION ----------
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1, 5, 5));

        // Rating section
        ratingLabel = new JLabel("Rate our service (1 to 5 stars):");
        centerPanel.add(ratingLabel);

        // Create radio buttons for star ratings
        star1 = new JRadioButton("★☆☆☆☆ (1 Star)");
        star2 = new JRadioButton("★★☆☆☆ (2 Stars)");
        star3 = new JRadioButton("★★★☆☆ (3 Stars)");
        star4 = new JRadioButton("★★★★☆ (4 Stars)");
        star5 = new JRadioButton("★★★★★ (5 Stars)");

        // Group radio buttons to allow only one selection
        ratingGroup = new ButtonGroup();
        ratingGroup.add(star1);
        ratingGroup.add(star2);
        ratingGroup.add(star3);
        ratingGroup.add(star4);
        ratingGroup.add(star5);

        // Add radio buttons to the panel
        centerPanel.add(star1);
        centerPanel.add(star2);
        centerPanel.add(star3);
        centerPanel.add(star4);
        centerPanel.add(star5);

        add(centerPanel, BorderLayout.CENTER);

        // ---------- SOUTH SECTION ----------
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));

        // Comment label and text area
        commentLabel = new JLabel("Your Comments:");
        bottomPanel.add(commentLabel, BorderLayout.NORTH);

        commentArea = new JTextArea(4, 20);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(commentArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        bottomPanel.add(submitButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // ---------- FRAME SETTINGS ----------
        setSize(350, 400);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Handle button click event
    public void actionPerformed(ActionEvent e) {
        int rating = 0;

        // Determine which rating was selected
        if (star1.isSelected()) rating = 1;
        else if (star2.isSelected()) rating = 2;
        else if (star3.isSelected()) rating = 3;
        else if (star4.isSelected()) rating = 4;
        else if (star5.isSelected()) rating = 5;

        // Get comments
        String comments = commentArea.getText().trim();

        // Check if a rating was given
        if (rating == 0) {
            JOptionPane.showMessageDialog(this, "Please select a rating before submitting.",
                                          "Incomplete Feedback", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Display thank-you message
        String message = "Thank you for your feedback!\n\n"
                       + "Rating: " + rating + " Star(s)\n"
                       + "Comments: " + (comments.isEmpty() ? "No additional comments." : comments);

        JOptionPane.showMessageDialog(this, message, "Feedback Received", JOptionPane.INFORMATION_MESSAGE);

        // Reset form after submission
        ratingGroup.clearSelection();
        commentArea.setText("");
    }

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineFeedbackForm());
    }
}
