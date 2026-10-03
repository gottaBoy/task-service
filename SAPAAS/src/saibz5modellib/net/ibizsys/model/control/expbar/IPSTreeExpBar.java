package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.tree.IPSDETree;



/**
 * 树导航栏接口对象
 * @author Administrator
 *
 */
public interface IPSTreeExpBar extends IPSExpBar
{
	/**
	 * 获取树部件对象
	 * @return
	 */
	IPSDETree getPSDETree();
}
