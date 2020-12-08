import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        jTextArea.setVisible(true);
        super.add(button);
        super.add(jTextArea);
        super.setSize(300,100);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("Try to connect");
                try {
                    Socket socket =new Socket("localhost",8080);
                    jTextArea.setText("Connected succesfully!!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    jTextArea.setText("Cannot connect to the server");
                }
            }
        });
    }

}
