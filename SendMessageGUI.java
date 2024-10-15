import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMessageGUI {

    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Send Message");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        // Create labels
        JLabel fromLabel = new JLabel("From:");
        JLabel toLabel = new JLabel("To:");
        JLabel subjectLabel = new JLabel("Subject:");

        // Create text fields
        JTextField fromField = new JTextField(15);
        JTextField toField = new JTextField(15);
        JTextField subjectField = new JTextField(15);

        // Create Browse buttons
        JButton fromBrowseButton = new JButton("Browse");
        JButton toBrowseButton = new JButton("Browse");

        // Create a Send button
        JButton sendButton = new JButton("Send");

        // Set up layout with GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add "From" label and input
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(fromLabel, gbc);

        gbc.gridx = 1;
        frame.add(fromField, gbc);

        gbc.gridx = 2;
        frame.add(fromBrowseButton, gbc);

        // Add "To" label and input
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(toLabel, gbc);

        gbc.gridx = 1;
        frame.add(toField, gbc);

        gbc.gridx = 2;
        frame.add(toBrowseButton, gbc);

        // Add "Subject" label and input
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(subjectLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        frame.add(subjectField, gbc);

        // Add "Send" button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame.add(sendButton, gbc);

        // Browse button actions (just dummy actions for demonstration)
        fromBrowseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    fromField.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });

        toBrowseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    toField.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });

        // Send button action
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String from = fromField.getText();
                String to = toField.getText();
                String subject = subjectField.getText();

                if (from.isEmpty() || to.isEmpty() || subject.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Message Sent Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}
