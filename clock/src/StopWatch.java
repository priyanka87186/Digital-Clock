import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener {
    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel("00:00:00");
    int elapsedTime = 0;
    Timer timer;

    StopWatch() {
        // Set the Look and Feel to Nimbus for a modern appearance
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setTitle("Stopwatch");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        centerPanel.setBackground(new Color(236, 240, 241));

        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        centerPanel.add(timeLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(52, 152, 219));

        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(46, 204, 113));
        startButton.setForeground(Color.white);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setBackground(new Color(231, 76, 60));
        resetButton.setForeground(Color.white);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (timer == null) {
                startButton.setText("STOP");
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateTimer();
                    }
                });
                timer.start();
            } else {
                startButton.setText("START");
                timer.stop();
                timer = null;
            }
        } else if (e.getSource() == resetButton) {
            reset();
        }
    }

    private void updateTimer() {
        elapsedTime += 1000;
        int seconds = (elapsedTime / 1000) % 60;
        int minutes = (elapsedTime / 60000) % 60;
        int hours = (elapsedTime / 3600000);
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private void reset() {
        if (timer != null) {
            timer.stop();
            timer = null;
            startButton.setText("START");
        }
        elapsedTime = 0;
        timeLabel.setText("00:00:00");
    }

    /*public static void main(String[] args) {
        new StopWatch();
    }*/
}
