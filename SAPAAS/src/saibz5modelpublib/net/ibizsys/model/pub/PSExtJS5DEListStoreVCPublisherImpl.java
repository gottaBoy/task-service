package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSListDataItem;

public class PSExtJS5DEListStoreVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	public final static String CTRLPART_RECORD = "RECORD";

	
	protected IPSDEList iPSDEList = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEList = (IPSDEList)iPSControl;
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
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSListDataItem> psListDataItems = 	iPSDEList.getPSListDataItems();
			while(psListDataItems.hasNext())
			{
				IPSListDataItem iPSListDataItem = psListDataItems.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEList, iPSListDataItem);
				gridRecordList.add(iPSGenerateCodeResult);
			}
			params.put("records", gridRecordList);
		}
		
	}
	




	
	
}
