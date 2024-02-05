import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Clock extends JFrame {

    private Calendar calendar;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private JButton closeButton;

    Clock() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(" Clock");
        this.setLayout(new BorderLayout());
        this.setSize(400, 250);
        this.setResizable(false);

        // Set background color
        this.getContentPane().setBackground(new Color(45, 52, 54));

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1, 10, 10));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(45, 52, 54));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayLabel.setForeground(new Color(253, 253, 150));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
        dateLabel.setForeground(new Color(253, 253, 150));

        contentPanel.add(timeLabel);
        contentPanel.add(dayLabel);
        contentPanel.add(dateLabel);

        this.add(contentPanel, BorderLayout.CENTER);

        closeButton = new JButton("CLOSE");
        closeButton.setFocusPainted(false);
        closeButton.setBackground(new Color(230, 57, 70));
        closeButton.setForeground(Color.white);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBorder(new LineBorder(new Color(230, 57, 70), 2));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(45, 52, 54));
        buttonPanel.add(closeButton);

        this.add(buttonPanel, BorderLayout.SOUTH);

        // Set up Timer to update time at regular intervals
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTime();
            }
        });
        timer.start();

        // Set visibility after setting up components and timer
        this.setVisible(true);
    }

    public void setTime() {
        calendar = Calendar.getInstance();
        timeLabel.setText(timeFormat.format(calendar.getTime()));
        dayLabel.setText(dayFormat.format(calendar.getTime()));
        dateLabel.setText(dateFormat.format(calendar.getTime()));
    }

  /*  public static void main(String[] args) {
        new Clock();
    }*/
}
