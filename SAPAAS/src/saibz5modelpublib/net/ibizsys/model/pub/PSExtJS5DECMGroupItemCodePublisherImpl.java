package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDECMGroupItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;

public class PSExtJS5DECMGroupItemCodePublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	protected IPSDECMGroupItem iPSDECMGroupItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSDECMGroupItem = (IPSDECMGroupItem)object;
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
			java.util.Iterator<IPSDEContextMenuItem> psDEContextMenuItems = 	iPSDECMGroupItem.getPSDEContextMenuItems();
			while(psDEContextMenuItems.hasNext())
			{
				IPSDEContextMenuItem iPSDEContextMenuItem = psDEContextMenuItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEContextMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( this.iPSControl,iPSDEContextMenuItem);
				if(iPSGenerateCodeResult!=null)
					itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
		
	}
	

	
	
}
