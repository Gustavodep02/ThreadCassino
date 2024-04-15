package view;

import controller.ThreadCassino;

public class Principal {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadCassino(i + 1);
			t.start();
		}

	}

}
