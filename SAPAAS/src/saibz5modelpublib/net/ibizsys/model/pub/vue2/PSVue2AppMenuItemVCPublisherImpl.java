package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;

public class PSVue2AppMenuItemVCPublisherImpl extends PSVue2CtrlPartCodePublisherImpl
{
	protected IPSAppMenuItem iPSAppMenuItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSAppMenuItem = (IPSAppMenuItem)object;
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
			java.util.Iterator<IPSAppMenuItem> psAppMenuItems = 	iPSAppMenuItem.getPSAppMenuItems();
			if(psAppMenuItems!=null)
			{
				while(psAppMenuItems.hasNext())
				{
					IPSAppMenuItem iPSAppMenuItem = psAppMenuItems.next();
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( this.iPSControl,iPSAppMenuItem);
					itemList.add(iPSGenerateCodeResult);
				}		
				params.put("items", itemList);
			}
			
		}
		
	}


	
	
}
