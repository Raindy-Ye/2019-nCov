package com.raindy.ncov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronavirusController {
	@Autowired
	private CoronavirusService service;
	@GetMapping("/ncov/overall")
	public Object getOverallStatistics() {
		return service.getOverallStatistics();
	}
	
	@GetMapping("/ncov/history/overall")
	public Object getHistoricalOverallStatistics() {
		return service.getHistoricalOverallStatistics();
	}
}
