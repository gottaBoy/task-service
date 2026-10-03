package net.ibizsys.model.pub.vue;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 列表控制代码
 * @author Administrator
 *
 */
public class PSVueDEListControllerCodePublisherImpl extends PSVueCtrlCodePublisherImpl
{
	protected IPSDEList iPSDEList = null;
	
	public final static String CTRLPART_RECORD = "RECORD";
	
	public final static String CTRLPART_COLUMN = "COLUMN";
	
	public final static String CTRLPART_STORE = "STORE";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEList = (IPSDEList)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEList = (IPSDEList)this.iPSControl;
		
		//输出结果集合代码
		if(false)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDEList, null);
			iPSPFCtrlPartCodePublisher.close();
			params.put("store", iPSGenerateCodeResult);
		}
		
		
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_COLUMN).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDEListItem> psDEListItems = 	iPSDEList.getPSDEListItems();
			while(psDEListItems.hasNext())
			{
				IPSDEListItem iPSDEListItem = psDEListItems.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEList,iPSDEListItem);
				gridColumnList.add(iPSGenerateCodeResult);
			}
			
			iPSPFCtrlPartCodePublisher.close();
			
			params.put("columns", gridColumnList);
		}
		
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEList = null;
		super.onClose();
	}
	
}
