package com.project.algocomparator.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.algocomparator.services.ThreadRunnerService;

@Component
public class ThreadJoinScheduler {

	@Scheduled(fixedRate = 1000)
	public void threadJoinScheduler() {
		CommonMappings.THREAD_LOCK.lock();
		if (!CommonMappings.THREAD_RUNNER_CACHE.isEmpty()) {
			List<ThreadRunnerService> tempCache = new ArrayList<ThreadRunnerService>();
			for (ThreadRunnerService th : CommonMappings.THREAD_RUNNER_CACHE) {
				if (!th.isAlive()) {
					try {
						th.join();
					} catch (InterruptedException e) {
						System.out.println("Error in joining thread.");
					} finally {
						tempCache.add(th);
					}
				}
			}
			if (!tempCache.isEmpty()) {
				tempCache.forEach((th) -> {
					CommonMappings.THREAD_RUNNER_CACHE.remove(th);
				});
			}
		}
		CommonMappings.THREAD_LOCK.unlock();
	}
}
