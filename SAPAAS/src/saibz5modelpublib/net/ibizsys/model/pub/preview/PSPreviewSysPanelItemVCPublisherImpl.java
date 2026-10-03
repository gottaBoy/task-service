package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

/**
 * ExtJS 5.0 系统面板成员视图代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewSysPanelItemVCPublisherImpl extends PSPreviewCtrlPartCodePublisherImpl
{
	protected IPSSysPanelItem iPSSysPanelItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSSysPanelItem = (IPSSysPanelItem)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		iPSSysPanelItem = (IPSSysPanelItem)object;
		if(iPSSysPanelItem.getParentPSSysPanelItem()!=null)
		{
			params.put("parent", iPSSysPanelItem.getParentPSSysPanelItem());
		}
	}
	
	
	@Override
	protected void onClose() {
		this.iPSSysPanelItem = null;
		super.onClose();
	}


}
