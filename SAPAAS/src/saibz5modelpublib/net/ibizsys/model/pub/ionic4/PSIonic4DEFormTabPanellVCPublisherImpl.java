package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDEFormDetail;

public class PSIonic4DEFormTabPanellVCPublisherImpl extends PSIonic4DEFormDetailVCPublisherImpl
{
	
	protected IPSDEFormTabPanel iPSDEFormTabPanel = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormTabPanel = (IPSDEFormTabPanel)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		

		if(true)
		{
			ArrayList<IPSGenerateCodeResult> formPageList = new ArrayList<IPSGenerateCodeResult> ();
			IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(PSDEFormDetail.DETAILTYPE_FORMPAGE).getPSPFCtrlPartCodePublisher();
			Iterator<IPSDEFormTabPage> psDEFormTabPages =  iPSDEFormTabPanel.getPSDEFormTabPages();
			while(psDEFormTabPages.hasNext())
			{
				IPSDEFormTabPage iPSDEFormTabPage  = psDEFormTabPages.next();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEFormTabPage);
				formPageList.add(iPSGenerateCodeResult);
				
			}
			
			iPSPFCtrlPartCodePublisher.close();
			params.put("tabpages", formPageList);
		}
		
	}
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEFormTabPanel = null;
		super.onClose();
	}
}
