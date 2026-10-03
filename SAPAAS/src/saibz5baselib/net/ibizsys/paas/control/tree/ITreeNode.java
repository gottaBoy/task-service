package net.ibizsys.paas.control.tree;

import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

/**
 * 树节点接口
 * 
 * @author Administrator
 *
 */
public interface ITreeNode extends IModelBase {
	/**
	 * 获取树节点类型
	 * 
	 * @return
	 */
	String getTreeNodeType();

	/**
	 * 查找指定树节点
	 * 
	 * @param strTreeNodeId
	 * @return
	 */
	ITreeNode findTreeNode(String strTreeNodeId);

	/**
	 * 获取异步加载模式
	 * 
	 * @return
	 */
	boolean isAsyncMode();

	/**
	 * 获取是否一直为异步加载模式
	 * 
	 * @return
	 */
	boolean isAlwaysAsyncMode();

	/**
	 * 获取是否展开显示
	 * 
	 * @return
	 */
	boolean isExpanded();

	/**
	 * 获取是否禁用
	 * 
	 * @return
	 */
	boolean isDisabled();

	/**
	 * 获取是否为叶子节点
	 * 
	 * @return
	 */
	boolean isLeaf();

	/**
	 * 获取样式
	 * 
	 * @return
	 */
	String getCssClass();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCssClass();

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	String getIcon();

	/**
	 * 获取链接
	 * 
	 * @return
	 */
	String getHref();

	/**
	 * 获取链接目标
	 * 
	 * @return
	 */
	String getHrefTarget();

	/**
	 * 获取节点提示信息
	 * 
	 * @return
	 */
	String getTips();

	/**
	 * 获取节点文本
	 * 
	 * @return
	 */
	String getText();

	/**
	 * 获取节点是否可以拖拽
	 * 
	 * @return the bDraggable
	 */
	boolean isDraggable();

	/**
	 * 获取节点是否被选中
	 * 
	 * @return the bChecked
	 */
	boolean isChecked();

	/**
	 * 获取节点是否支持选中
	 * 
	 * @return the bEnableCheck
	 */
	boolean isEnableCheck();

	/**
	 * 判断是否存在节点
	 * 
	 * @param strTreeNodeId
	 * @return
	 */
	boolean containsTreeNode(String strTreeNodeId);

	/**
	 * 增加树节点的子节点
	 * 
	 * @param childNodeConfig
	 */
	void addChildNode(ITreeNode childNodeConfig);

	/**
	 * 重置子节点
	 */
	void resetChildNodes();

	/**
	 * 获取节点的标记值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getTagValue(String strKey);

	/**
	 * 获取标记对象
	 * 
	 * @return
	 */
	JSONObject getTag();

	/**
	 * 获取子节点集合
	 * 
	 * @return
	 */
	java.util.Iterator<ITreeNode> getChildNodes();

	/**
	 * 设置是否为叶子节点
	 * 
	 * @param bLeaf
	 */
	void setLeaf(boolean bLeaf);

	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	String getCounterId();

	/**
	 * 获取计数器模式
	 * 
	 * @return
	 */
	int getCounterMode();

	/**
	 * 获取树节点的数据源
	 * 
	 * @return
	 */
	Object getDataSource();
	
	
	
	/**
	 * 获取节点数据的类型
	 * @return
	 */
	String getNodeDataType();
}
