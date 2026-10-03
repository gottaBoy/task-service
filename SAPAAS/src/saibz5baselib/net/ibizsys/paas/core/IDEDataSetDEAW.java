package net.ibizsys.paas.core;

/**
 * 实体操作向导对象接口(实体数据集合)
 * @author Administrator
 *
 */
public interface IDEDataSetDEAW extends IDEActionWizard {

	/**
	 * 获取操作向导实体名称
	 * @return
	 */
	String getAWDEName();
	
	
	/**
	 * 获取操作向导实体数据集合名称
	 * @return
	 */
	String getAWDEDataSetName();
	
	
	
	/**
	 * 获取操作向导名称属性
	 * @return
	 */
	String getAWNameField();
	
	
	/**
	 * 获取操作向导关键字属性
	 * @return
	 */
	String getAWKeywordField();
	
	
	
	
	/**
	 * 获取操作向导排序属性
	 * @return
	 */
	String getAWSortField();
	

	
	
	/**
	 * 获取操作向导项实体名称
	 * @return
	 */
	String getAWIDEName();
	
	
	
	/**
	 * 获取操作向导项实体数据集合名称
	 * @return
	 */
	String getAWIDEDataSetName();
	
	
	

	/**
	 * 获取操作向导项名称属性
	 * @return
	 */
	String getAWINameField();
	
	
	
	/**
	 * 获取操作向导项值属性
	 * @return
	 */
	String getAWIValueField();
	
	
	
	/**
	 * 获取操作向导项外键属性
	 * @return
	 */
	String getAWIFKeyField();
	
	
	
	/**
	 * 获取操作向导项内容属性
	 * @return
	 */
	String getAWIContentField();
	
	
	/**
	 * 获取操作向导项Url属性
	 * @return
	 */
	String getAWIUrlField();
	
	
	
	/**
	 * 获取操作向导项排序属性
	 * @return
	 */
	String getAWISortField();
}
