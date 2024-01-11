//word Counter using java language.
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {  

    private JTextField textField;

    public WordCounterApp() {
        setTitle("Word Counter App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter text:");

        textField = new JTextField(50);
        JButton countButton = new JButton("Count Words");
         label.setFont(new Font("Serif", Font.BOLD, 25));
         textField.setFont(new Font("Serif",Font.BOLD,15));
 
         countButton.setSize(20, 10);
         countButton.setFont(new Font("Serif",Font.BOLD,25));
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(countButton);

        add(panel);
    }

    private void countWords() {
        String text = textField.getText();
        String[] words = text.split("[\\s\\p{Punct}]+");

        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
            else
            {
            	JOptionPane.showMessageDialog(this, "Please Enter a word!!: ");
            }
        }
        
        JOptionPane.showMessageDialog(this, "Total number of words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp().setVisible(true);
            }
        });
    }
}
