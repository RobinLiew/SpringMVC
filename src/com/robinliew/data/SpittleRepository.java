package com.robinliew.data;

import java.util.List;

import com.robinliew.Spittle;

/**
 * 定义一个数据访问的Repository
 * 这是一个我们能获取Spittle列表的Repository
 * @author RobinLiew
 *
 */
public interface SpittleRepository {
	List<Spittle> findSpittles(long max,int count);
}
