package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.service.SampleService;

@Controller
@RequestMapping("/sample/")
public class SampleController {

	@Resource
	private SampleService sampleService;
	
	@GetMapping("list")
	public String sampleList(Model model) throws Exception {
		List<SampleDTO> list = sampleService.findAll();
		model.addAttribute("list", list);
		return "sample/list";
	}
	
	@GetMapping("detail")
	public String getSample(@RequestParam("id") String id, Model model) throws Exception {
		SampleDTO sample = sampleService.getSample(id);
		model.addAttribute("sample", sample);
		return "sample/detail";
	}
	
}
