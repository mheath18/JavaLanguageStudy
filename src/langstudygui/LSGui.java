
package langstudygui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import static langstudygui.Main.Endex;
import static langstudygui.Main.Sndex;
import static langstudygui.Main.correctAnswer;
import static langstudygui.Main.englishWords;
import static langstudygui.Main.spanishWords;

/**
 *
 * @author Mehki
 */
public class LSGui extends JFrame implements ActionListener {

    protected JLabel instructions;
    protected JLabel word;
    protected JTextField answer;
    protected JButton okay;

    public LSGui() {
        setTitle("Language Study");
        Dimension prefferedSize = new Dimension(500, 50);
        this.setSize(450, 150);
        this.setLayout(new GridBagLayout());

        instructions = new JLabel("Type the translation into the field below");

        GridBagConstraints position = new GridBagConstraints();

        position.gridx = 1;
        position.gridy = 0;
        position.insets = new Insets(10, 10, 10, 10);

        add(instructions, position);

        word = new JLabel("");
        position.gridx = 0;
        position.gridy = 1;
        add(word, position);

        answer = new JTextField(15);
        position.gridx = 1;
        position.gridy = 1;
        position.insets = new Insets(10, 10, 10, 10);

        answer.addActionListener(this);

        add(answer, position);

        okay = new JButton("Ok");
        position.gridx = 2;
        position.gridy = 1;
        okay.addActionListener(this);

        add(okay, position);
        
    }

    public void actionPerformed(ActionEvent e) {

        flashcards();

    }

    public void flashcards() {
        for (String spanishWord : spanishWords) {

            if (spanishWord.equalsIgnoreCase(answer.getText())) {
                Sndex = spanishWords.indexOf(spanishWord);
            }

        }

        for (String englishWord : englishWords) {

            if (englishWord.equalsIgnoreCase(answer.getText())) {
                Endex = englishWords.indexOf(englishWord);
            }
        }

        if (Sndex == Endex || Endex == Sndex) {
            instructions.setText("Correct!");

        } else if (Sndex == Sndex || Endex == Endex) {
            instructions.setText("Incorrect! Answer: " + correctAnswer);
        }

        answer.setEnabled(false);
    }

}
