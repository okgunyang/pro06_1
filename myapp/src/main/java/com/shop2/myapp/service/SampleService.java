package com.shop2.myapp.service;

import java.util.List;
import com.shop2.myapp.dto.SampleDTO;

public interface SampleService {
	public List<SampleDTO> findAll() throws Exception;
	public SampleDTO getSample(String id) throws Exception;
}
