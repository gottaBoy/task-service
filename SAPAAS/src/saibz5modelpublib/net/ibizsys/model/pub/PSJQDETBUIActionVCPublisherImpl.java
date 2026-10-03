package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;

public class PSJQDETBUIActionVCPublisherImpl extends PSJQCtrlPartCodePublisherImpl
{
	protected IPSDETBUIActionItem iPSDETBUIActionItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDETBUIActionItem = (IPSDETBUIActionItem)object;
		
//		//判断类型，进一步获取
//		IPSUIAction iPSUIAction = iPSDETBUIActionItem.getPSUIAction();
//		if(iPSUIAction.isUIActionGroup())
//		{
//			//行为组
//		}
		
		
		return super.generateCode(iPSControl, object);
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
			java.util.Iterator<IPSDEToolbarItem> psDEToolbarItems = 	iPSDETBUIActionItem.getPSDEToolbarItems();
			while(psDEToolbarItems.hasNext())
			{
				IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEToolbarItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSControl,iPSDEToolbarItem);
				itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
		
	}
	

}
