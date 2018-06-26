package com.example.demo.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Batch;
import com.example.demo.mapper.BankbatchMapper;
import com.example.demo.mapper.StuserMapper;
import com.example.demo.service.BatchService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/batch")
public class BatchController extends BaseController{
	@Resource
	private BatchService batchService;	
	
	// ��ѯ
	@RequestMapping("/addBatchTest")
	public String viewAll10() {
		Batch batch = new Batch();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ 
		
		batch.setAppid(12);
		batch.setAppid(13);
		batch.setAddtime(df.format(new Date()));
		
		batchService.insert(batch);
		return "test";
	}
}
