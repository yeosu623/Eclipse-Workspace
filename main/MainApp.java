package main;

import etc.Calc;

public class MainApp {
	public static void main(String[] args) {
		Calc c = new Calc(10, 50);
		System.out.println(c.sum());
	}
}
