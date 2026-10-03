package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 树导航栏控制代码
 * @author Administrator
 *
 */
public class PSPreviewTreeExpBarControllerCodePublisherImpl extends PSPreviewExpBarControllerCodePublisherImpl {

	protected IPSTreeExpBar iPSTreeExpBar = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSTreeExpBar = (IPSTreeExpBar)this.iPSControl;
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

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSTreeExpBar = null;
		super.onClose();
	}
}
