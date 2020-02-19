package com.raindy.ncov;

import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoronavirusService {

	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000,multiplier = 1.5))
	public Object getOverallStatistics() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://lab.isaaclin.cn/nCoV/api/overall", Object.class);
	}
	
	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000,multiplier = 1.5))
	public Object getHistoricalOverallStatistics() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://lab.isaaclin.cn/nCoV/api/overall?latest=0", Object.class);
	}
	
}
