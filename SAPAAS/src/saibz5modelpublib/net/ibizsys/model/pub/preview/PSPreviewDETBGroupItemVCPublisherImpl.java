package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBGroupItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

public class PSPreviewDETBGroupItemVCPublisherImpl extends PSPreviewCtrlPartCodePublisherImpl
{
	protected IPSDETBGroupItem iPSDETBGroupItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDETBGroupItem = (IPSDETBGroupItem)object;
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
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDEToolbarItem> psDEToolbarItems = 	iPSDETBGroupItem.getPSDEToolbarItems();
			while(psDEToolbarItems.hasNext())
			{
				IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEToolbarItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEToolbarItem);
				if(iPSGenerateCodeResult!=null)
					itemList.add(iPSGenerateCodeResult);
				iPSPFCtrlPartCodePublisher.close();
			}		
			
			params.put("items", itemList);
		}
		
	}
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDETBGroupItem = null;
		super.onClose();
	}

	
	
}
