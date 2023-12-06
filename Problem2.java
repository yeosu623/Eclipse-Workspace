import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Problem2 extends JFrame {
	
	JButton button;
	ImagePanel imagePanel = new ImagePanel();
	boolean drawImage = false;
	
	public Problem2() {
		super("Problem2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		button = new JButton("Hide/Show");
		button.addActionListener(new ButtonActionListener());
		imagePanel.add(button);
		
		setContentPane(imagePanel);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class ImagePanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/image0.jpg");
		Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(drawImage) g.drawImage(img, 20, 20, this);
			else ;
			
			repaint();
		}
	}
	
	class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawImage = !drawImage;
		}
	}

	public static void main(String[] args) {
		new Problem2();
	}

}
