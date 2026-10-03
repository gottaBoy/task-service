package net.ibizsys.model.control.tree;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlMDataContainer;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 实体树节点对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDETreeNode extends IPSModelObject, ITreeNodeModel, IPSControlXDataContainer, IPSControlMDataContainer {
	/**
	 * 计数器模式：无模式
	 */
	public final static int COUNTERMODE_NONE = 0;

	/**
	 * 计数器模式：0 值时隐藏
	 */
	public final static int COUNTERMODE_HIDEZERO = 1;

	

	/**
	 * 获取实体树视图
	 * @return
	 */
	IPSDETree getPSDETree();
	
	/**
	 * 获取实体
	 * 
	 * @return
	 */
	IPSDataEntity getPSDataEntity();

	/**
	 * 获取嵌入视图编号
	 * 
	 * @return
	 */
	String getEmbedViewId();

	/**
	 * 获取导航实体视图
	 * 
	 * @return
	 */
	String getNavPSDEViewId();

	/**
	 * 获取导航视图
	 * 
	 * @return
	 */
	IPSAppView getNavPSAppView();

	/**
	 * 获取导航视图参数
	 * 
	 * @return
	 */
	ObjectNode getNavViewParam();

	/**
	 * 获取系统图标
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

//	/**
//	 * 获取上下文菜单对象
//	 * 
//	 * @return
//	 */
//	IPSDEContextMenu getPSDEContextMenu();

	

	/**
	 * 获取树节点关系视图集合
	 * 
	 * @return
	 * 
	 */
	java.util.Iterator<IPSDETreeNodeRV> getPSDETreeNodeRVs();

	/**
	 * 获取树节点删除行为名称
	 * 
	 * @return
	 */
	String getRemovePSDEActionName();

	/**
	 * 获取输节点删除权限名称
	 * 
	 * @return
	 */
	String getRemovePSDEOPPrivName();

//	/**
//	 * 获取名称的语言资源
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getNamePSLanguageRes();

	/**
	 * 获取导航视图关系标识
	 * 
	 * @return
	 */
	String getNavPSDERId();

	/**
	 * 获取导航关系对象
	 * 
	 * @return
	 */
	IPSDERBase getNavPSDER();
	
	
	/**
	 * 获取计数器标识
	 * @return
	 * 
	 */
	String getCounterId();

	
	
	/**
	 * 获取计数器模式
	 * @return
	 */
	int getCounterMode();
	
	
	
	/**
	 * 获取树节点数据项集合
	 * @return
	 */
	java.util.Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems();
	
	
	/**
	 * 获取用户标记
	 * @return
	 */
	String getUserTag();
	
	
	/**
	 * 获取用户标记2
	 * @return
	 */
	String getUserTag2();
	
	
	
	/**
	 * 获取树节点模型对象
	 * @return
	 */
	String getModelObj();
}
