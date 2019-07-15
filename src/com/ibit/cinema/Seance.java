package com.zavada.cinema;

public class Seance implements Comparable<Seance> {

	private static int count = 0;
	private Movie movie;
	private Time startTime;
	private Time endTime;
	private Integer id;

	public Seance() {
		movie = new Movie();
		System.out.println("Enter start time: ");
		startTime = new Time();
		endTime = new Time(startTime.getHour() + movie.getDuration().getHour(),
				startTime.getMin() + movie.getDuration().getMin());
		id = count++;
	}

	public Movie getMovie() {
		return movie;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int compareTo(Seance o) {
		return id.compareTo(o.getId());
	}

	@Override
	public String toString() {
		return "Seance id " + id + " movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "\n";
	}

}
