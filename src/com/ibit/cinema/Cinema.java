package com.zavada.cinema;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {

	private static Cinema instance;
	private TreeMap<Days, Schedule> work;
	private Time open;
	private Time close;
	private int generalWorkingHours;
	private static int leavesTimes;

	private Cinema() {
		work = new TreeMap<>();
		Days weekdays[] = Days.values();
		for (int i = 0; i < weekdays.length; i++) {
			work.put(weekdays[i], new Schedule());
		}
		System.out.println("Set cinema working time: ");
		open = new Time();
		System.out.println("Set cinema closes time: ");
		close = new Time();
		generalWorkingHours = close.getHour() - open.getHour();
		leavesTimes = generalWorkingHours;
	}

	public static Cinema getInstance() {
		if (instance == null)
			return new Cinema();
		return instance;
	}

	public static int getLeavesTimes() {
		return leavesTimes;
	}

	public TreeMap<Days, Schedule> getWork() {
		return work;
	}

	public void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter weekday to add movie: ");
		String weekday = sc.nextLine();
		Days weekdays[] = Days.values();
		Days day = null;
		for (int i = 0; i < weekdays.length; i++) {
			if (weekday.toUpperCase().equals(weekdays[i].toString())) {
				day = weekdays[i];
			}
		}
		if (day == null) {
			System.out.println("That weekday not exist.");
			return;
		}
		if (day != null) {
			work.get(day).addSeance();
			leavesTimes -= work.get(day).getHours();
		}
	}

	public void removeMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie title: ");
		String movieName = sc.nextLine();
		Set<Seance> seances;
		for (Map.Entry<Days, Schedule> element : work.entrySet()) {
			seances = element.getValue().getS();
			for (Seance seance : seances) {
				if (seance.getMovie().getTitle().equals(movieName)) {
					seances.remove(seance);
					return;
				} 
			}
		}
		System.out.println("Film not found.");
	}

	public void removeSeance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter weekday to remove seance: ");
		String weekday = sc.nextLine();
		System.out.println("Enter film name: ");
		String fName = sc.nextLine();
		Days weekdays[] = Days.values();
		for (int i = 0; i < weekdays.length; i++) {
			if (weekday.toUpperCase().equals(weekdays[i].toString())) {
				Schedule schedule = work.get(weekdays[i]);
				Set<Seance> seances = schedule.getS();
				for (Seance seance : seances) {
					if (seance.getMovie().getTitle().equals(fName)) {
						seances.remove(seance);
						return;
					}
				}
			}
		}
		System.out.println("Seance not found.");
	}

	@Override
	public String toString() {
		return "Cinema will work " + generalWorkingHours + " hours\n" + work + "\nOpen " + open + ", \nClose " + close;
	}

}
