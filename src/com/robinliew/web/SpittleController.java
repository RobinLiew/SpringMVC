package com.robinliew.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robinliew.data.SpittleRepository;
import com.robinliew.domain.Spittle;

@Controller
//@RequestMapping("/spittles")  该注解可以加在这里，实现路径与请求方式的分离
public class SpittleController {
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository=spittleRepository;
	}
	
	@RequestMapping(value="/spittles",method=RequestMethod.GET)
	public String spittles(Model model){
		/* 
		 * Model实际上是一个Map，它会传递给视图，这样数据就能渲染到客户端了。当调用addAttribute方法
		 * 而不指定key的时候，key会根据值的对象类型推断确定。本例中因为它是一个List<spittle>,因此，
		 * 键会推断为spittleList。当然你可以显示的指定key（推荐）
		 */
		model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));//将spittle添加到模型当中
		return "spittles";//返回视图名
	}
	
   /**
	 * 处理查询参数（翻页功能的实现）
	 * 
	 * 该控制器方法与上面的不同，它没有返回视图名称，也没有显示地设定模型，这个方法返回的是Spittle集合列表。
	 * 当处理器方法像这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出（本例中是spittleList）。
	 * 逻辑视图的名称将会根据请求路径推断得出。因为这个方法处理针对"/spittles"的GET请求，因而视图的名称将会是spittles。
	 * 
	 * RequestParam注解用来接收客户端传递过来的值。例如，"/spittles?max=240000"&count=50" ，value指定了参数值，
	 * defaultValue指定了默认值
	 */
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value="max",defaultValue=Long.MAX_VALUE+"") long max,
			@RequestParam(value="count",defaultValue="20") int count){
		
		return spittleRepository.findSpittles(max, count);
	}
	*/
	
	/**
	 * 通过路径参数接收输入
	 * 
	 * 注意：对"/spittles/12345"发起GET请求要优于对"/spittles/show?spittle_id=12345"发起请求。
	 * 前者能够识别要查询的资源，而后者描述的是带有参数的一个操作--本质上是通过HTTP发起的RPC。
	 * 
	 * @param spittleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showSpittle(@RequestParam("spittle_id") long spittleId,Model model){
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	/**
	 * 上面所有的方法都映射到了（通过@RequestMapping）静态定义好的路径上。
	 * 我们可以通过在@RequestMapping路径中添加占位符来增加变量部分.
	 * 
	 * 下面的例子就可以处理"/spittles/12345"这种路径
	 * 
	 * @param spittleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/spittles/{spittleId}" ,method=RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId,Model model){
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	
}
