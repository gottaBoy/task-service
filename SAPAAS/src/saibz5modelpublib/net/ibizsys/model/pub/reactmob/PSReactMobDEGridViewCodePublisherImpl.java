package net.ibizsys.model.pub.reactmob;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

public class PSReactMobDEGridViewCodePublisherImpl extends PSReactMobCtrlCodePublisherImpl
{
	protected IPSDEGrid iPSDEGrid = null;
	
	public final static String CTRLPART_RECORD = "RECORD";
	
	public final static String CTRLPART_COLUMN = "COLUMN";
	
	public final static String CTRLPART_STORE = "STORE";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEGrid = (IPSDEGrid)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEGrid = (IPSDEGrid)this.iPSControl;
		
		//输出结果集合代码
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDEGrid, null);
			iPSPFCtrlPartCodePublisher.close();
			params.put("store", iPSGenerateCodeResult);
		}
		
		
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_COLUMN).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDEGridColumn> psDEGridColumns = 	iPSDEGrid.getPSDEGridColumns();
			while(psDEGridColumns.hasNext())
			{
				IPSDEGridColumn iPSDEGridColumn = psDEGridColumns.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEGrid,iPSDEGridColumn);
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
		this.iPSDEGrid = null;
		super.onClose();
	}
	
}
