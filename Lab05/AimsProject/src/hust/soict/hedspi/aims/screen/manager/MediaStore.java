package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.exception.PlayerException;
public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tạo dialog thông báo
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing Media");
                    dialog.setModal(true); // chặn parent JFrame khi dialog mở

                    // Nội dung dialog
                    JPanel panel = new JPanel(new BorderLayout());

                    JLabel label = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                    label.setFont(new Font("Arial", Font.PLAIN, 16));
                    panel.add(label, BorderLayout.CENTER);

                    JButton closeBtn = new JButton("Close");
                    closeBtn.addActionListener(ev -> dialog.dispose());
                    panel.add(closeBtn, BorderLayout.SOUTH);

                    dialog.setContentPane(panel);
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null); // Hiển thị giữa màn hình
                    dialog.setVisible(true);

                    // Gọi play() trong try-catch xử lý PlayerException
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException ex) {
                        System.err.println("Cannot play media: " + ex.getMessage());
                        // Có thể thêm JOptionPane để thông báo lỗi người dùng:
                        // JOptionPane.showMessageDialog(null, ex.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            this.add(playButton);
        }
    }
}
