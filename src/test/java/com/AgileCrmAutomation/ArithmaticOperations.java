package com.AgileCrmAutomation;

public class ArithmaticOperations {
	public static void main(String[] args) {
		Mathematics obj = new Mathematics() {
			public void add() {
				System.out.println(a + b);

			}

			public void sub() {
				System.out.println(a - b);

			}

			public void mul() {
				System.out.println(a * b);

			}

			public void div() {
				System.out.println(a / b);

			}
		};
		obj.add();
		obj.sub();
		obj.mul();
		obj.div();

	}

}
