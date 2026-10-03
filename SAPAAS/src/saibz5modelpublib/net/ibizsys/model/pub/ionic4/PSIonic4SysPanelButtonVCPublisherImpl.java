package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelButton;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

/**
 * ExtJS 5.0 系统面板成员视图代码发布器对象
 * @author Administrator
 *
 */
public class PSIonic4SysPanelButtonVCPublisherImpl extends PSIonic4CtrlPartCodePublisherImpl
{
	protected IPSSysPanelButton iPSSysPanelButton = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSSysPanelButton = (IPSSysPanelButton)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		iPSSysPanelButton = (IPSSysPanelButton)object;
		super.onFillGenerateCodeParams(params);
	}
	
	
	@Override
	protected void onClose() {
		this.iPSSysPanelButton = null;
		super.onClose();
	}


}
