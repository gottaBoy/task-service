package net.ibizsys.model.control.list;



/**
 * 实体列表项对象接口
 * @author lionlau
 *
 */
public interface IPSDEListItem extends IPSListItem
{

	
	
	/**
	 * 获取实体列表
	 * @return
	 */
	IPSDEList getPSDEList();
	
	

	/**
	 * 获取宽度
	 * @return
	 */
	int getWidth();
	
	
	
	
	
	/**
	 * 获取数据项名称
	 * @return
	 */
	String getDataItemName();
	
	
	
	/**
	 * 获取值格式化
	 * @return
	 */
	String getValueFormat();

	
	

	
}
