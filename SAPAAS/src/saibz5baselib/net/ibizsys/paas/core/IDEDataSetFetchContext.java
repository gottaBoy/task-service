package net.ibizsys.paas.core;

import java.util.ArrayList;

import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.SqlParamList;

/**
 * 实体数据集合获取操作上下文对象
 * 
 * @author lionlau
 *
 */
public interface IDEDataSetFetchContext extends IActionContext {
	
	/**
	 * 开始行数
	 * 
	 * @return
	 */
	int getStartRow();

	/**
	 * 分页大小
	 * 
	 * @return
	 */
	int getPageSize();

	/**
	 * 排序字段
	 * 
	 * @return
	 */
	String getSort();

	/**
	 * 排序字段方向
	 * 
	 * @return
	 */
	String getSortDir();

	/**
	 * 排序字段2
	 * 
	 * @return
	 */
	String getSort2();

	/**
	 * 排序字段2方向
	 * 
	 * @return
	 */
	String getSort2Dir();

	/**
	 * 获取用户条件集合
	 * 
	 * @return
	 */
	ArrayList<IDEDataSetCond> getConditionList();

	/**
	 * 获取SQL定义代码
	 * 
	 * @return
	 */
	String getDeclareScript();

	/**
	 * 填充定义代码参数集合
	 * 
	 * @param list
	 * @throws Exception
	 */
	void fillDeclareParams(SqlParamList list) throws Exception;

	/**
	 * 获取当前数据对象
	 * 
	 * @return
	 */
	ISimpleDataObject getActiveDataObject();

	
	
	/**
	 * 设置当前数据对象
	 * @param iSimpleDataObject
	 */
	void setActiveDataObject(ISimpleDataObject iSimpleDataObject);
	
	/**
	 * 设置连接代码
	 * 
	 * @return
	 */
	String getJoinScript();

	/**
	 * 获取分组的前部记录数
	 * 
	 * @return
	 */
	int getGroupTopCount();

	/**
	 * 是否查询数据
	 * 
	 * @return
	 */
	boolean isFetchData();

	/**
	 * 是否返回数据行总数
	 * 
	 * @return
	 */
	boolean isFetchTotalRow();

	/**
	 * 是否取消查询
	 * 
	 * @return
	 */
	boolean isCancel();

	/**
	 * 设置取消
	 * 
	 * @param bCancel
	 */
	void setCancel(boolean bCancel);

	/**
	 * 获取操作信息
	 * 
	 * @return
	 */
	String getFetchInfo();

	/**
	 * 是否缓存结果集合
	 * 
	 * @return
	 */
	boolean isCacheDataSet();
	
	
	/**
	 * 设置连接代码
	 * 
	 * @param strJoinScript the strJoinScript to set
	 */
	void setJoinScript(String strJoinScript);
	
	
	
	/**
	 * 是否支持分页
	  * @return
	 */
	boolean isPaging();
}
