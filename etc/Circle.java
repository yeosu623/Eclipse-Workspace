package etc;

public class Circle {
	private int x;
	private int y;
	private int r;
	
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void printCircle() {
		System.out.printf("Circle(%d,%d)반지름%d\n", x, y, r);
	}
	
	@Override
	public boolean equals(Object obj) {
		Circle c = (Circle)obj;
		return x == c.x && y == c.y; 
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle(1,2,5);
		Circle c2 = new Circle(2,2,3);
		
		System.out.print("원 a : ");
		c1.printCircle();
		System.out.print("원 b : ");
		c2.printCircle();
		
		if(c1.equals(c2))
			System.out.println("같은 원");
		else
			System.out.println("다른 원");
	}
}