package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.media.*;

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
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing Media");
                    dialog.setModal(true); // Tùy chọn: chặn parent JFrame khi dialog đang mở

                    // Nội dung hiển thị
                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());

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

                    // Gọi play thật sự
                    ((Playable) media).play();  // vẫn in ra console
                }
            });
            this.add(playButton);
        }
    }
}
