package com.zavada.cinema;

import java.util.Scanner;

public class Movie {

	private String title;
	private Time duration;

	public Movie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter film name: ");
		title = sc.nextLine();
		System.out.println("Enter duration for film: ");
		duration = new Time();
	}

	public String getTitle() {
		return title;
	}

	public Time getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Movie title=" + title + ", duration=" + duration;
	}

}
