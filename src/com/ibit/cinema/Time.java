package com.zavada.cinema;

import java.util.Scanner;

public class Time {

	private int hour;
	private int min;

	public Time() {
		Scanner sc = new Scanner(System.in);
		int hour = 0;
		int mins = 0;
		boolean b = false;
		while (b == false) {
			System.out.println("Enter hours (0-23): ");
			hour = sc.nextInt();
			if (hour >= 0 && hour <= 23) {
				this.hour = hour;
				b = true;
			}
		}
		b = false;
		while (b == false) {
			System.out.println("Enter minutes (0-59): ");
			mins = sc.nextInt();
			if (mins >= 0 && mins <= 59) {
				this.min = mins;
				b = true;
			}
		}
	}

	public Time(int i, int y) {
		hour = i;
		min = y;
	}

	public int getMin() {
		return min;
	}

	public int getHour() {
		return hour;
	}

	public void setMin(int min) {
		if (min >= 0 && min <= 59)
			this.min = min;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour <= 23) {
			this.hour = hour;
		}
	}

	@Override
	public String toString() {
		return "time hours=" + hour + ", minutes=" + min;
	}

}
