package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

/**
 * ExtJS 5.0 系统面板成员视图代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewSysPanelControlVCPublisherImpl extends PSPreviewSysPanelItemVCPublisherImpl
{
	protected IPSSysPanelControl iPSSysPanelControl = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSSysPanelControl = (IPSSysPanelControl)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
	}
	
	
	@Override
	protected void onClose() {
		this.iPSSysPanelControl = null;
		super.onClose();
	}


}
