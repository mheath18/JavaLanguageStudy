
package langstudygui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Mehki
 */
public class Main {

    protected static int Endex = 0;
    protected static int Sndex = 0;
    protected static ArrayList<String> englishWords = new ArrayList<>();
    protected static ArrayList<String> spanishWords = new ArrayList<>();
    protected static String correctAnswer;
    protected static Timer myTimer;
    protected static Timer secondTimer;
    static int count;
    static int count2;
    static int rword;
    static int rnum;

    public static void main(String[] args) throws FileNotFoundException {

        LSGui gui = new LSGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        Image image = new ImageIcon("mehki.JPG").getImage();
        gui.setIconImage(image);


        Scanner scanEng = new Scanner(new File("english.txt"));
        Scanner scanSpa = new Scanner(new File("spanish.txt"));

        while (scanEng.hasNext()) {

            englishWords.add(scanEng.next());
        }

        while (scanSpa.hasNext()) {
            spanishWords.add(scanSpa.next());

        }

        rword = (int) (Math.random() * (englishWords.size() - 1 + 1 ) + 1);

        rnum = (int) (Math.random() * 100);

        if (rnum <= 50) {
            gui.word.setText(englishWords.get(rword));

            Endex = englishWords.indexOf(gui.word.getText());
            correctAnswer = spanishWords.get(rword);

        } else {
            gui.word.setText(spanishWords.get(rword));
            Sndex = spanishWords.indexOf(gui.word.getText());
            correctAnswer = englishWords.get(rword);

        }

        myTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count == 5) {
                    gui.answer.setEnabled(false);
                    gui.flashcards();
                    secondTimer.start();
                }

            }
        });

        myTimer.start();

        secondTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count2++;

                if (count2 == 3) {
                    gui.instructions.setText("Type the translation into the field below");
                    gui.answer.setText(null);
                    gui.answer.setEnabled(true);

                    rword = (int) (Math.random() * (englishWords.size() -1 +1 ) +1);
                    rnum = (int) (Math.random() * 100);

                    if (rnum <= 50) {
                        gui.word.setText(englishWords.get(rword));

                        Endex = englishWords.indexOf(gui.word.getText());
                        correctAnswer = spanishWords.get(rword);

                    } else {
                        gui.word.setText(spanishWords.get(rword));
                        Sndex = spanishWords.indexOf(gui.word.getText());
                        correctAnswer = englishWords.get(rword);

                    }

                    count2 = 0;
                    count = 0;
                    secondTimer.stop();
                    myTimer.restart();

                }

            }

        });

    }
}
