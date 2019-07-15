package com.zavada.cinema;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	private Set<Seance> s;
	private static int hours = 0;
	private static int mins = 0;

	public Schedule() {
		this.s = new TreeSet<>();
	}

	public int getHours() {
		return hours;
	}

	public int getMins() {
		return mins;
	}

	public void addSeance() {
		Seance seance = new Seance();
		if (seance.getMovie().getDuration().getHour() > Cinema.getLeavesTimes()) {
			System.out.println("Time is over working time.");
			return;
		}
		s.add(seance);
		hours += seance.getMovie().getDuration().getHour();
		mins += seance.getMovie().getDuration().getMin();
	}

	public Set<Seance> getS() {
		return s;
	}

	public synchronized void removeSeance(Seance s) {
		this.s.remove(s);
	}

	@Override
	public String toString() {
		return "Schedule [" + ", " + "seances: \n" + s + "]\n";
	}

}
