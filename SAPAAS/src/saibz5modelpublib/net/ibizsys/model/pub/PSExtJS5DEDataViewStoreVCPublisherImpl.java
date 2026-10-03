package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.control.dataview.IPSDEDataViewDataItem;

public class PSExtJS5DEDataViewStoreVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	public final static String CTRLPART_RECORD = "RECORD";

	
	protected IPSDEDataView iPSDEDataView = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEDataView = (IPSDEDataView)iPSControl;
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
			java.util.Iterator<IPSDEDataViewDataItem> psDEDataViewDataItems = 	iPSDEDataView.getPSDEDataViewDataItems();
			while(psDEDataViewDataItems.hasNext())
			{
				IPSDEDataViewDataItem iPSDEDataViewDataItem = psDEDataViewDataItems.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEDataView, iPSDEDataViewDataItem);
				gridRecordList.add(iPSGenerateCodeResult);
			}
			params.put("records", gridRecordList);
		}
		
	}

	
}
