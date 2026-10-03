package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;

import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

public class PSVueMobDEDataViewCodePublisherImpl extends PSVueMobCtrlCodePublisherImpl
{
	protected IPSDEDataView iPSDEDataView = null;
	
	public final static String CTRLPART_RECORD = "RECORD";
	
	public final static String CTRLPART_STORE = "STORE";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
		
		//输出结果集合代码
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEDataView, null);
			params.put("store", iPSGenerateCodeResult);
		}
		
		
	}

	

	
}
