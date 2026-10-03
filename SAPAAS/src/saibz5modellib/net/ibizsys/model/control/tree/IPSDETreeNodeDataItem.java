package net.ibizsys.model.control.tree;

import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;


/**
 * 实体树节点数据项对象接口
 * @author lionlau
 *
 */
public interface IPSDETreeNodeDataItem extends IPSDataItem,ITreeNodeDataItem
{
	

	
	/**
	 * 获取实体树节点对象
	 * @return
	 */
	IPSDETreeNode getPSDETreeNode();
	
	
	
	/**
	 * 获取实体树表格列对象
	 * @return
	 */
	IPSDETreeColumn getPSDETreeColumn();
	
	
	
	/**
	 * 获取绑定的实体属性对象
	 * @return
	 */
	IPSDEField getPSDEField();
	
	
	/**
	 * 获取代码表输出模式
	 * @return
	 */
	String getCLConvertMode();
	
	
	
	/**
	 * 获取代码表对象标识
	 * @return
	 */
	String getPSCodeListId();
	
	
	
	
	/**
	 * 是否启用项权限控制
	 * @return
	 */
	boolean isEnableItemPriv();	
	
	
	
	/**
	 * 获取项权限标识
	 * @return
	 */
	String getItemPrivId();
}
