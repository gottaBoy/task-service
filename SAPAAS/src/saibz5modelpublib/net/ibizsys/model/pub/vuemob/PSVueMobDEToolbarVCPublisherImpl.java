package net.ibizsys.model.pub.vuemob;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;


public class PSVueMobDEToolbarVCPublisherImpl extends PSVueMobCtrlCodePublisherImpl
{
	protected IPSDEToolbar iPSDEToolbar = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEToolbar = (IPSDEToolbar)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEToolbar = (IPSDEToolbar)this.iPSControl;
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDEToolbarItem> psDEToolbarItems = 	iPSDEToolbar.getPSDEToolbarItems();
			while(psDEToolbarItems.hasNext())
			{
				IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEToolbarItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEToolbar,iPSDEToolbarItem);
				if(iPSGenerateCodeResult!=null)
					itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
		
	}

	

	
}
