package com.shop2.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.model.SampleMapper;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	SampleMapper sampleMapper;
	
	@Override
	public List<SampleDTO> findAll() throws Exception {
		return sampleMapper.findAll();
	}

	@Override
	public SampleDTO getSample(String id) throws Exception {
		return sampleMapper.getSample(id);
	}	
}
