package net.ibizsys.model.pub.reactmob;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;


public class PSReactMobAppMenuVCPublisherImpl extends PSReactMobCtrlCodePublisherImpl
{
	protected IPSAppMenu iPSAppMenu = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSAppMenuItem> psAppMenuItems = 	iPSAppMenu.getPSAppMenuItems();
			while(psAppMenuItems.hasNext())
			{
				IPSAppMenuItem iPSAppMenuItem = psAppMenuItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSAppMenu,iPSAppMenuItem);
				itemList.add(iPSGenerateCodeResult);
				iPSPFCtrlPartCodePublisher.close();
			}		
			
			params.put("items", itemList);
		}
		
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSAppMenu = null;
		super.onClose();
	}
	
}
