package net.ibizsys.paas.ctrlmodel;

/**
 * 实体数据集合树节点模型接口
 * 
 * @author Administrator
 *
 */
public interface ITreeDEDataSetNodeModel extends ITreeNodeModel {
	
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体数据集合名称
	 * 
	 * @return
	 */
	String getDEDataSetName();

	/**
	 * 获取用于过滤实体数据集合名称
	 * 
	 * @return
	 */
	String getFilterDEDataSetName();

	/**
	 * 获取ID属性
	 * 
	 * @return
	 */
	String getIdField();

	/**
	 * 获取文本属性
	 * 
	 * @return
	 */
	String getTextField();

	/**
	 * 获取图标属性
	 * 
	 * @return
	 */
	String getIconField();

	/**
	 * 获取排序属性
	 * 
	 * @return
	 */
	String getSortField();

	/**
	 * 获取排序方向
	 * 
	 * @return
	 */
	String getSortDir();
	

	/**
	 * 对值进行Distinct处理
	 * 
	 * @return
	 */
	boolean isDistinctMode();

	/**
	 * 获取子节点数量属性
	 * 
	 * @return
	 */
	String getChildCntField();

	/**
	 * 获取删除的实体行为名称
	 * 
	 * @return
	 */
	String getRemoveDEActionName();

	/**
	 * 获取删除的数据访问行为
	 * 
	 * @return
	 */
	String getRemoveDataAccessAction();

	
	
	/**
	 * 获取上下文数据计算逻辑标识
	 * @return
	 */
	String getActiveDataDELogicId();
	
	
	/**
	 * 获取数据类型标记属性
	 * @return
	 */
	String getDataTypeField();
	
	
	
	/**
	 * 获取页节点标记属性
	 * @return
	 */
	String getLeafFlagField();
	
	
	/**
	 * 获取最大节点数量
	 * @return
	 */
	int getMaxSize();
}
