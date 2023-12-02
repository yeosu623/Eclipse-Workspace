import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coffee22 extends JFrame {

    private JProgressBar cupProgress, coffeeProgress, waterProgress, latteProgress, creamProgress;
    private JButton americanoCoffeeButton, latteCoffeeButton, mochaCoffeeButton, resetButton;

    public Coffee22() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
      setTitle("Java Programming Report");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 500);
      Container c = getContentPane();
      
      // 배경 패널
      ImageIcon backgroundIcon = new ImageIcon("images/background.jpg");   
      JPanel backgroundPanel = new JPanel(new BorderLayout()) {
          public void paintComponent(Graphics g) {
              g.drawImage(backgroundIcon.getImage(), 0, 0, null);
              setOpaque(false); //그림을 표시하게 설정,투명하게 조절
              super.paintComponent(g);
          }
      };
      
        // 로고 패널
        JPanel LogoPanel = new JPanel(new FlowLayout());
        LogoPanel.setBackground(Color.GRAY);
        
        LogoPanel.add(new JLabel("Welcome, StarBucks !!"));

	    // 프로그레스 바 패널
	    JPanel progressPanel = new JPanel(new GridLayout(1, 5, 4, 4));
	    cupProgress = new JProgressBar();
	    coffeeProgress = new JProgressBar();
	    waterProgress = new JProgressBar();
	    latteProgress = new JProgressBar();
	    creamProgress = new JProgressBar();
	
	    progressPanel.add(createProgressBarPanel(cupProgress, "Cup"));
	    progressPanel.add(createProgressBarPanel(coffeeProgress, "Coffee"));
	    progressPanel.add(createProgressBarPanel(waterProgress, "Water"));
	    progressPanel.add(createProgressBarPanel(latteProgress, "Sugar"));
	    progressPanel.add(createProgressBarPanel(creamProgress, "Cream"));
	    progressPanel.setOpaque(false);
	    
	    // 로고 + 프로그레스 바 패널
	    JPanel LogoAndProgressPanel = new JPanel(new BorderLayout(5, 5));
	    LogoAndProgressPanel.add(LogoPanel, BorderLayout.NORTH);
	    LogoAndProgressPanel.add(progressPanel, BorderLayout.SOUTH);
	    
	    LogoAndProgressPanel.setOpaque(false);
	    backgroundPanel.add(LogoAndProgressPanel, BorderLayout.NORTH);
        
        // 사진 패널
//        JPanel ImagePanel = new JPanel(new BorderLayout());
//        ImageIcon imageIcon = new ImageIcon("images/cup.jpg");
//        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
//        ImagePanel.add(imageLabel);
//        
//        ImagePanel.setOpaque(false);
//        backgroundPanel.add(ImagePanel, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        americanoCoffeeButton = new JButton("Americano Coffee");
        latteCoffeeButton = new JButton("Latte Coffee");
        mochaCoffeeButton = new JButton("Mocha Coffee");
        resetButton = new JButton("Reset");

        americanoCoffeeButton.addActionListener(new CoffeeActionListener());
        latteCoffeeButton.addActionListener(new CoffeeActionListener());
        mochaCoffeeButton.addActionListener(new CoffeeActionListener());
        resetButton.addActionListener(e -> resetProgressBars());

        buttonPanel.add(americanoCoffeeButton);
        buttonPanel.add(latteCoffeeButton);
        buttonPanel.add(mochaCoffeeButton);
        buttonPanel.add(resetButton);

        buttonPanel.setOpaque(false);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 배경 패널 설정
        JScrollPane scrollPane = new JScrollPane(backgroundPanel);
        setContentPane(scrollPane);
        
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createProgressBarPanel(JProgressBar progressBar, String label) {
        progressBar.setOrientation(SwingConstants.VERTICAL); // 프로그레스바를 세로로 설정
        progressBar.setValue(100); // 초깃값을 100으로 설정
        progressBar.setStringPainted(false);
        progressBar.setPreferredSize(new Dimension(50, 150)); // 프로그레스바의 선호 크기 설정
        progressBar.setMaximumSize(new Dimension(50, 150)); // 프로그레스바의 최대 크기 설정
        progressBar.setOpaque(false);

        JPanel wrapperPanel = new JPanel(new GridBagLayout()); // wrapperPanel에 GridBagLayout 설정

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL; // 세로로만 채우도록 설정
        gbc.anchor = GridBagConstraints.NORTH; // 프로그레스바를 패널의 위쪽으로 정렬
        gbc.insets = new Insets(0, 0, 0, 0); // 여백 제거

        wrapperPanel.setOpaque(false);
        wrapperPanel.add(progressBar, gbc);

        JPanel panel = new JPanel(new BorderLayout()); // 전체 패널에 BorderLayout 설정
        panel.add(wrapperPanel, BorderLayout.CENTER); // wrapperPanel을 가운데에 추가

        JLabel labelBelow = new JLabel(label, SwingConstants.CENTER);
        labelBelow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // 레이블의 테두리 여백을 0으로 설정
        panel.setOpaque(false);
        panel.add(labelBelow, BorderLayout.SOUTH);

        return panel;
    }

    int cup = 100;
    int coffee = 100;
    int water = 100;
    int sugar = 100;
    int cream = 100;

    private void resetProgressBars() {
    	cup = 100; coffee = 100; water = 100; sugar = 100; cream = 100;
    	
        cupProgress.setValue(cup);
        coffeeProgress.setValue(coffee);
        waterProgress.setValue(water);
        latteProgress.setValue(sugar);
        creamProgress.setValue(cream);
       
    }
    
    private class CoffeeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == americanoCoffeeButton) {
                // 아메리카노 만들기 로직
            	if(isIngredientsFilled()) {
	                cup -= 10; coffee -= 10; water -= 20;
	                
	                cupProgress.setValue(cup);
	                coffeeProgress.setValue(coffee);
	                waterProgress.setValue(water);    
	                
	                JOptionPane.showMessageDialog(null, "아메리카노 나왔습니다.");
            	}
                
            } else if (source == latteCoffeeButton) {
                // 라뗴 만들기 로직
            	if(isIngredientsFilled()) {
	                cup -= 10; coffee -= 10; water -= 20; sugar -= 5;
	                
	                cupProgress.setValue(cup);
	                coffeeProgress.setValue(coffee);
	                waterProgress.setValue(water);
	                latteProgress.setValue(sugar);
	                
	                JOptionPane.showMessageDialog(null, "라뗴 나왔습니다.");
            	}
                
            } else if (source == mochaCoffeeButton) {
                // 모카 만들기 로직
            	if(isIngredientsFilled()) {
	                cup -= 10; coffee -= 10; water -= 20; sugar -= 5; cream -= 5;
	                
	                cupProgress.setValue(cup);
	                coffeeProgress.setValue(coffee);
	                waterProgress.setValue(water);
	                latteProgress.setValue(sugar);
	                creamProgress.setValue(cream);
	                
	                JOptionPane.showMessageDialog(null, "모카 나왔습니다.");
            	}
            }
        }
    }
    
    public boolean isIngredientsFilled() {
		if(cup <= 0 || coffee <= 0 || water <= 0 || sugar <= 0 || cream <= 0) {
			JOptionPane.showMessageDialog(null, "부족한 재료가 있습니다.");
			return false;
		}
		else return true;
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Coffee22::new);
    }
}