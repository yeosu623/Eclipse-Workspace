import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Problem1 extends JFrame {
	
	JButton button;
	
	public Problem1() {
		super("Problem1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		button = new JButton("New Button");
		button.setBackground(new Color(get0To255() ,get0To255() ,get0To255()));
		button.addActionListener(new ButtonActionListener());
		c.add(button);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button.setBackground(new Color(get0To255() ,get0To255() ,get0To255()));
		}
	}
	
	int get0To255() {
		return (int)(Math.random() * 255);
	}

	public static void main(String[] args) {
		new Problem1();
	}

}
