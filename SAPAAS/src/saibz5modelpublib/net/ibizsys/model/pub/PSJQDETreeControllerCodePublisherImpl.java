package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.tree.IPSDETree;

/**
 * 树部件控制代码
 * @author Administrator
 *
 */
public class PSJQDETreeControllerCodePublisherImpl extends PSJQCtrlCodePublisherImpl
{
	protected IPSDETree iPSDETree = null;
	

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDETree = (IPSDETree)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		//计算上下文菜单
		
		
	}

}
