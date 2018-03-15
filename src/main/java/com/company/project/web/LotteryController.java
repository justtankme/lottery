package com.company.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.domain.vo.LotteryAwardVO;
import com.company.project.service.LotteryService;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
	@Autowired
	private LotteryService lotteryService;
	
	@PostMapping("/tryit")
	public LotteryAwardVO lottery(@RequestBody LotteryAwardVO lotteryAwardVO) {
		return lotteryService.lottery(lotteryAwardVO);
	}
}
