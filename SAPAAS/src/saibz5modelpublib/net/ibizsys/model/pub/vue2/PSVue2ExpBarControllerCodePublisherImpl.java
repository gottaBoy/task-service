package net.ibizsys.model.pub.vue2;

import java.util.HashMap;

import net.ibizsys.model.control.expbar.IPSExpBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 导航栏
 * @author lionlau
 *
 */
public class PSVue2ExpBarControllerCodePublisherImpl extends PSVue2CtrlCodePublisherImpl
{
	protected IPSExpBar iPSExpBar = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSExpBar = (IPSExpBar)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		//输出结果集合代码
	
		
	}

	

	
}
