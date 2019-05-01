package com.maciejg.TaskScheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {

	private static final SimpleDateFormat dateformat = new SimpleDateFormat(
			"mm//dd/yyyy hh:mm:ss");
	
	@Scheduled(fixedRate = 10000)
	public void performTask() {
		System.out.println("NORMAL TASK at time: " + dateformat.format(new Date()));
	}
	
	@Scheduled(initialDelay = 5000, fixedRate = 10000)
	public void deleyedTask() {
		System.out.println("DELAYED task performed at: "+ dateformat.format(new Date()));
	}
	
	//Cron expression is represented bys six fields
	//second, minute, hour, day of month, month, day(s) of week
	// * means match any
	// */6 means every 6 second 
	@Scheduled(cron = "*/6 * * * * *")
	public void performTaskWithCron() {
		System.out.println("Regular time with Cron at: "+ dateformat.format(new Date()));
	}
}
