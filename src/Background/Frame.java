package Background;
import Background.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

public class Frame
{
    JTextField outgoing;
    Server connect = new Server();


    public void go() {
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SentButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        connect.setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    public class SentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev)
        {
            try
            {
                connect.writer.println(outgoing.getText());
                connect.writer.flush();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
}
