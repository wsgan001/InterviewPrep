package org.practice.javaFundas.miscellaneous.scheduleQuartzJob;

//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//public class MyQuartzJob {
//	public static void main( String[] args ) throws Exception
//	{
//		JobDetail job = JobBuilder.newJob(HelloJob.class)
//				.withIdentity("helloJob")
//				.build();
//
//
//
//		// CronTrigger the job to run on the every 10th seconds
//		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
//				.withIdentity("crontrigger","crontriggergroup1")
//				.withSchedule(CronScheduleBuilder.cronSchedule("10 * * * * ?"))
//				.build();
//
//
//		// Start the schedule
//		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//		scheduler.start();
//
//		// Tell quartz to schedule the job using the trigger
//		scheduler.scheduleJob(job, cronTrigger);
//
//	}
//}
//

