import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.Socket;

public class Fx extends JFrame {
    JTextArea jTextArea;
    public Fx() throws HeadlessException {
        super("Midas Fx");
        JButton button = new JButton("Connect");
        button.setSize(100,30);
        button.setVisible(true);
        jTextArea = new JTextArea();
        jTextArea.setText("Not connected");
        jTextArea.setSize(100,30);
        jTextArea.setEditable(false);
        jTextArea.setVisible(true);
        super.add(button);
        super.add(jTextArea);
        super.setSize(300,100);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextArea.setText("Ti leei bro?");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jTextArea.setText("Pou pas?");
            }
        });
        button.addActionListener(e -> {
            jTextArea.setText("Trying to connect...");
            try {
                Socket socket =new Socket("localhost",8080);
                jTextArea.setText("Connected successfully!!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                jTextArea.setText("Cannot connect to the server.");
            }
        });
    }

}
