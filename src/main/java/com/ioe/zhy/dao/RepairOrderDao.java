/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.RepairOrder;

/**
 * @author hq
 *
 */

public interface RepairOrderDao {
	public int addOrder(RepairOrder repairOrder);
	public String getTodayLastOrder(@Param("zeroTime")Date zeroTime,@Param("twelve")Date twelve);
	public int changeOrder(RepairOrder repairOrder);
	public List<RepairOrder> getTodoOrder(String powerClient_id);
	public String getOrderStatusById(String order_id);
	public RepairOrder getOrderById(String order_id);
	public List<RepairOrder>   getHistoryBypowerClientId(@Param("powerClientId")String powerClientId,
			@Param("createTime")long createTime,@Param("completeTime")long completeTime,@Param("startNumber")Integer startNumber,@Param("PageCount")Integer PageCount);
	public int  getHistoryCountsBypowerClientId(@Param("powerClientId")String powerClientId,
			@Param("createTime")long createTime,@Param("completeTime")long completeTime);
}
