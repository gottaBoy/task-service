package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 列表控制代码
 * @author Administrator
 *
 */
public class PSAngularDEListControllerCodePublisherImpl extends PSAngularCtrlCodePublisherImpl
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
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEList, null);
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
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEList,iPSDEListItem);
				gridColumnList.add(iPSGenerateCodeResult);
			}
			params.put("columns", gridColumnList);
		}
		
	}

	
}
