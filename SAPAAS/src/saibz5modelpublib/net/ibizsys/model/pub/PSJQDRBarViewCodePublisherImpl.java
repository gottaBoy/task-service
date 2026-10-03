package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.drctrl.IPSDRBar;

/**
 * 关系栏
 * @author lionlau
 *
 */
public class PSJQDRBarViewCodePublisherImpl extends PSJQCtrlCodePublisherImpl
{
	protected IPSDRBar iPSDRBar = null;
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDRBar = (IPSDRBar)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		
		
	}

	

	
}
