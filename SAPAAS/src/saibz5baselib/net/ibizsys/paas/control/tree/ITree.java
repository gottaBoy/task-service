package net.ibizsys.paas.control.tree;

import java.util.Iterator;

import net.ibizsys.paas.control.IControl;

/**
 * 树控件接口
 * 
 * @author lionlau
 *
 */
public interface ITree extends IControl {

	/**
	 * 搜索数据
	 */
	final static String FetchAction = "fetch";

	/**
	 * 获取树节点集合
	 * 
	 * @return
	 */
	Iterator<ITreeNode> getTreeNodes();
}
