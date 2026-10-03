package net.ibizsys.model.control.tree;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel;

/**
 * 视图树代码表节点对象接口
 * @author Administrator
 *
 */
public interface IPSDETreeCodeListNode extends IPSDETreeNode,ITreeCodeListNodeModel
{
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();
}
