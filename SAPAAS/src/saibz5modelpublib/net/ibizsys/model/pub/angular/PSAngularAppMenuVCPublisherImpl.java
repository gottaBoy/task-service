package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;


public class PSAngularAppMenuVCPublisherImpl extends PSAngularCtrlCodePublisherImpl
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
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType())).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSAppMenu,iPSAppMenuItem);
				itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
		
	}

	
}
