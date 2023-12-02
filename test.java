import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class test {

    private JProgressBar progressBar;

    public test() {
        // 프레임 생성
        JFrame frame = new JFrame("Progress Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 프로그레스 바 생성
        progressBar = new JProgressBar();
        progressBar.setSize(100, 20);
        progressBar.setMinimum(0); // 최소값 설정
        progressBar.setMaximum(100); // 최대값 설정
        progressBar.setStringPainted(true); // 퍼센트 표시 설정

        // 프레임에 프로그레스 바 추가
        frame.getContentPane().add(progressBar);

        // 프레임을 가운데에 표시
        frame.setLocationRelativeTo(null);

        // 프레임 표시
        frame.setVisible(true);

        // 프로그레스 바 업데이트 예제
        updateProgressBar();
    }

    private void updateProgressBar() {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                final int progressValue = i;
                SwingUtilities.invokeLater(() -> {
                    progressBar.setValue(progressValue);
                });

                try {
                    Thread.sleep(100); // 일시 중지하여 업데이트 속도를 늦춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test::new);
    }
}
