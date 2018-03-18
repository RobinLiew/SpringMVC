package com.robinliew.data;

import java.util.List;

import com.robinliew.domain.Spitter;
import com.robinliew.domain.Spittle;

/**
 * 定义一个数据访问的Repository
 * 这是一个我们能获取Spittle列表的Repository
 * @author RobinLiew
 *
 */
public interface SpittleRepository {
	/**
	 * 
	 * @param max  该参数代表所返回的Spittle中SpittleID属性的最大值
	 * @param count  表明要返回多少个spittle对象
	 * @return
	 */
	List<Spittle> findSpittles(long max,int count);

	Spittle findOne(long spittleId);

	void save(Spitter spitter);

	Spitter findByUsername(String username);
}
