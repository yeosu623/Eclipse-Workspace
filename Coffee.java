import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Coffee extends JFrame {
	
	/**
	 * 전역 변수 및 컴포넌트
	 */
	int cup = 5;
	int coffee = 5;
	int water = 5;
	int sugar = 5;
	int cream = 5;
	int currentMoney = 0;
	JLabel labelCurrentMoney = new JLabel("잔액 : " + currentMoney);
	
	
	/**
	 * JFrame
	 */
	public Coffee() {
		super("Coffee Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new EastPanel(), BorderLayout.EAST);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		setSize(600, 500);
		setResizable(false); // 창 크기 고정
		setVisible(true);
	}
	
	
	
	/**
	 * JPanel
	 */
	class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.GREEN);
			add(new JLabel("Welcome, Hot Coffee!!"));
		}
	}

	class CenterPanel extends JPanel {
		public CenterPanel() {
			setBackground(Color.WHITE);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 원재료 틀 그리기
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 70, 200);
			g.fillRect(110, 10, 70, 200);
			g.fillRect(210, 10, 70, 200);
			g.fillRect(310, 10, 70, 200);
			g.fillRect(410, 10, 70, 200);
			
			// 원재료 이름 그리기
			ImageIcon labelIcon = new ImageIcon("C:\\Users\\yeosu\\eclipse-workspace\\univ_study\\src\\image\\labelImg.png");
			Image labelImg = labelIcon.getImage();
			g.drawImage(labelImg, 0, 220, 500, 50, this);
			
			// 원재료가 비어있는 것을 그리기
			g.setColor(Color.WHITE);
			g.fillRect(10, 10, 70, 40 * (5 - cup));
			g.fillRect(110, 10, 70, 40 * (5 - coffee));
			g.fillRect(210, 10, 70, 40 * (5 - water));
			g.fillRect(310, 10, 70, 40 * (5 - sugar)); 
			g.fillRect(410, 10, 70, 40 * (5 - cream));
			
			// 커피컵 이미지 그리기
			ImageIcon cupIcon = new ImageIcon("C:\\Users\\yeosu\\eclipse-workspace\\univ_study\\src\\image\\cupImg.jpg");
			Image cupImg = cupIcon.getImage();
			g.drawImage(cupImg, 180, 280, 120, 120, this);
		}
	}
	
	class EastPanel extends JPanel {
		public EastPanel() {
			setBackground(Color.WHITE);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // JLabel, JButton을 세로로 배치하도록 레이아웃 설정
			
			JButton buttonAdd1000won = new JButton("1000");
			JButton buttonAdd500won  = new JButton("500");
			JButton buttonAdd100won  = new JButton("100");
			JButton buttonAdd50won   = new JButton("50");
			JButton buttonAdd10won   = new JButton("10");
			
			buttonAdd1000won.addActionListener(new ButtonAdd1000wonActionListener());
			buttonAdd500won .addActionListener(new ButtonAdd500wonActionListener());
			buttonAdd100won .addActionListener(new ButtonAdd100wonActionListener());
			buttonAdd50won  .addActionListener(new ButtonAdd50wonActionListener());
			buttonAdd10won  .addActionListener(new ButtonAdd10wonActionListener());
			
			add(Box.createVerticalStrut(30)); // 빈 공간 생성
			add(labelCurrentMoney);
			add(buttonAdd1000won);
			add(buttonAdd500won);
			add(buttonAdd100won);
			add(buttonAdd50won);
			add(buttonAdd10won);
		}
	}

	class SouthPanel extends JPanel {
		public SouthPanel() {
			setBackground(Color.YELLOW);
			
			JButton buttonNormalCoffee = new JButton("Normal Coffee");
			JButton buttonSugarCoffee  = new JButton("Sugar Coffee");
			JButton buttonDabangCoffee = new JButton("Dabang Coffee");
			JButton buttonReset        = new JButton("Reset");
			
			buttonNormalCoffee.addActionListener(new ButtonNormalCoffeeActionListener());
			buttonSugarCoffee. addActionListener(new ButtonSugarCoffeeActionListener());
			buttonDabangCoffee.addActionListener(new ButtonDabangCoffeeActionListener());
			buttonReset.       addActionListener(new ButtonResetActionListener());
			
			add(buttonNormalCoffee);
			add(buttonSugarCoffee);
			add(buttonDabangCoffee);
			add(buttonReset);
		}
	}
	
	
	/**
	 * ActionListeners
	 */
	class ButtonAdd1000wonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentMoney += 1000;
			labelCurrentMoney.setText("잔액 : " + currentMoney);
		}
	}
	
	class ButtonAdd500wonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentMoney += 500;
			labelCurrentMoney.setText("잔액 : " + currentMoney);
		}
	}
	
	class ButtonAdd100wonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentMoney += 100;
			labelCurrentMoney.setText("잔액 : " + currentMoney);
		}
	}
	
	class ButtonAdd50wonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentMoney += 50;
			labelCurrentMoney.setText("잔액 : " + currentMoney);
		}
	}
	
	class ButtonAdd10wonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentMoney += 10;
			labelCurrentMoney.setText("잔액 : " + currentMoney);
		}
	}
	
	
	
	class ButtonNormalCoffeeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(isIngredientsFilled() && isEnoughMoney()) {
				JOptionPane.showMessageDialog(null, "일반 커피 나왔습니다.");
				cup--; coffee--; water--;
				repaint();	
				
				currentMoney -= 300;
				labelCurrentMoney.setText("잔액 : " + currentMoney);
			}
		}
	}
	
	class ButtonSugarCoffeeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(isIngredientsFilled() && isEnoughMoney()) {
				JOptionPane.showMessageDialog(null, "설탕 커피 나왔습니다.");
				cup--; coffee--; water--; sugar--;
				repaint();
				
				currentMoney -= 300;
				labelCurrentMoney.setText("잔액 : " + currentMoney);
			}
		}
	}
	
	class ButtonDabangCoffeeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(isIngredientsFilled() && isEnoughMoney()) {
				JOptionPane.showMessageDialog(null, "다방 커피 나왔습니다.");
				cup--; coffee--; water--; sugar--; cream--;
				repaint();	
				
				currentMoney -= 300;
				labelCurrentMoney.setText("잔액 : " + currentMoney);
			}
		}
	}
	
	class ButtonResetActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String password = JOptionPane.showInputDialog(null, "자판기 비밀번호(4자리 숫자)", "");
			
			if(password.equals("1234")) {
				JOptionPane.showMessageDialog(null, "리셋");
				cup = 5; coffee = 5; water = 5; sugar = 5; cream = 5;
				repaint();
				
				currentMoney = 0;
				labelCurrentMoney.setText("잔액 : " + currentMoney);
			}
			else JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
		}
	}
	
	
	/**
	 * 기타 함수
	 */
	public boolean isIngredientsFilled() {
		if(cup == 0 || coffee == 0 || water == 0 || sugar == 0 || cream == 0) {
			JOptionPane.showMessageDialog(null, "부족한 재료가 있습니다.");
			return false;
		}
		else return true;
	}
	
	public boolean isEnoughMoney() {
		if(currentMoney < 300) {
			JOptionPane.showMessageDialog(null, "잔액이 모자랍니다.");
			return false;
		}
		else return true;
	}
	
	/**
	 * main 함수
	 */
	public static void main(String[] args) {
		new Coffee();
	}
}

