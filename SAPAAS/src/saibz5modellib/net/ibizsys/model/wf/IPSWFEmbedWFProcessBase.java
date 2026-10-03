package net.ibizsys.model.wf;

import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;

/**
 * 工作流嵌入流程处理基对象接口
 * @author Administrator
 *
 */
public interface IPSWFEmbedWFProcessBase extends IPSWFProcess ,IWFEmbedWFProcessModelBase
{
	/**
	 * 获取处理子流程对象集合
	 * @return
	 */
	java.util.Iterator<IPSWFProcessSubWF> getPSWFProcessSubWFs();
	
	
	/**
	 * 获取处理子流程计数
	 * @return
	 */
	int getPSWFProcessSubWFCount();
}
