package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 关系栏
 * @author lionlau
 *
 */
public class PSPreviewDRBarViewCodePublisherImpl extends PSPreviewCtrlCodePublisherImpl
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

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDRBar = null;
		super.onClose();
	}
	
}
