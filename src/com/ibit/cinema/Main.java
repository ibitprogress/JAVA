package com.zavada.cinema;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Cinema cinema = Cinema.getInstance();
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			switch (sc.nextInt()) {
			case 1:
				cinema.addMovie();
				break;
			case 2:
				cinema.removeMovie();
				break;
			case 3:
				cinema.removeSeance();
				break;
			case 4:
				System.out.println(cinema);
				break;
			}
		}
	}

	public static void menu() {
		System.out.println("1. Add movie");
		System.out.println("2. Remove movie");
		System.out.println("3. Remove seance in day");
		System.out.println("4. Print cinema schedules");
	}

}
