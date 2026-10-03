package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

public class PSVue2DEGridViewCodePublisherImpl extends PSVue2CtrlCodePublisherImpl
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
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEGrid, null);
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
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEGrid,iPSDEGridColumn);
				gridColumnList.add(iPSGenerateCodeResult);
			}
			params.put("columns", gridColumnList);
		}
		
	}

	
}
