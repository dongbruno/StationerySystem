package citi.controller;
import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.store.fs.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import citi.hibernate.entity.Orders;
import citi.service.OrdersService;
@Controller
public class OrdersController {
	private static final Log logger = LogFactory.getLog(OrdersController.class);
	
	@Resource(name = "OrdersServiceImpl")
	OrdersService ordersServiceImpl;
	@RequestMapping(value = "/getOrders", method = RequestMethod.GET)
	@ResponseBody
	public Object getOrders(){
		List<Orders> result = ordersServiceImpl.getOrders();
		if(logger.isDebugEnabled()){
			logger.debug("getOrders="+result);
		}
		return result;
	}
	
	@RequestMapping(value = "/saveOrders", method = RequestMethod.GET)
	@ResponseBody
	public String saveOrders(){
		String result = ordersServiceImpl.saveOrders();
		if(logger.isDebugEnabled()){
			logger.debug("saveOrders="+result);
		}
		return result;
	}
	@RequestMapping(value = "/submitOrders", method = RequestMethod.GET)
	@ResponseBody
	public String submitOrders(){
		String result = ordersServiceImpl.submitOrders();
		if(logger.isDebugEnabled()){
			logger.debug("submitOrders="+result);
		}
		return result;
	}
	

}
