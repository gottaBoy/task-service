package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

public class PSPreviewDEListStoreVCPublisherImpl extends PSPreviewCtrlPartCodePublisherImpl
{
	public final static String CTRLPART_RECORD = "RECORD";

	
	protected IPSDEList iPSDEList = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEList = (IPSDEList)iPSControl;
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
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSListDataItem> psListDataItems = 	iPSDEList.getPSListDataItems();
			while(psListDataItems.hasNext())
			{
				IPSListDataItem iPSListDataItem = psListDataItems.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDEList, iPSListDataItem);
				gridRecordList.add(iPSGenerateCodeResult);
			}
			
			iPSPFCtrlPartCodePublisher.close();
			
			params.put("records", gridRecordList);
		}
		
	}
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEList= null;
		super.onClose();
	}

	
	
}
