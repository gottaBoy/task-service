package net.ibizsys.model.control.tree;

import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel;

/**
 * 视图树实体数据集合节点对象接口
 * @author Administrator
 *
 */
public interface IPSDETreeDataSetNode extends IPSDETreeNode,ITreeDEDataSetNodeModel
{
	
	/**
	 * 获取数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	
	/**
	 * 获取过滤数据集合
	 * @return
	 */
	IPSDEDataSet getFilterPSDEDataSet();
	
	
	
	/**
	 * 获取删除实体行为
	 * @return
	 */
	IPSDEAction getRemovePSDEAction();
	
	
	
	/**
	 * 获取删除实体行为权限标识
	 * @return
	 */
	IPSDEOPPriv getRemovePSDEOPPriv();
	
	
	/**
	 * 获取更新实体行为
	 * @return
	 */
	IPSDEAction getUpdatePSDEAction();
	
	
	
	/**
	 * 获取更新实体行为权限标识
	 * @return
	 */
	IPSDEOPPriv getUpdatePSDEOPPriv();
	
	
	
	/**
	 * 获取上下文数据转化逻辑
	 * @return
	 */
	IPSDELogic getActiveDataPSDELogic();
	
	
	
	/**
	 * 获取ID属性对象
	 * 
	 * @return
	 */
	IPSDEField getIdPSDEField();

	/**
	 * 获取文本属性对象
	 * 
	 * @return
	 */
	IPSDEField getTextPSDEField();

	/**
	 * 获取图标属性对象
	 * 
	 * @return
	 */
	IPSDEField getIconPSDEField();

	/**
	 * 获取排序属性对象
	 * 
	 * @return
	 */
	IPSDEField getSortPSDEField();



	/**
	 * 获取子节点数量属性对象
	 * 
	 * @return
	 */
	IPSDEField getChildCntPSDEField();

		
	
	/**
	 * 获取页节点标记属性对象
	 * @return
	 */
	IPSDEField getLeafFlagPSDEField();
	
	

	
	 
}
