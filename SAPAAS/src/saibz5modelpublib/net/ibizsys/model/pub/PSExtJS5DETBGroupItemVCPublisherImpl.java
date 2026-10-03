package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDETBGroupItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;

public class PSExtJS5DETBGroupItemVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	protected IPSDETBGroupItem iPSDETBGroupItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSDETBGroupItem = (IPSDETBGroupItem)object;
		return super.generateCode( iPSControl, object);
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
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( this.iPSControl,iPSDEToolbarItem);
				if(iPSGenerateCodeResult!=null)
					itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
		
	}
	
	
	
}
