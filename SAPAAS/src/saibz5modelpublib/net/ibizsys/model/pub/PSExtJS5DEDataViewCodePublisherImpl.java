package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.dataview.IPSDEDataView;

public class PSExtJS5DEDataViewCodePublisherImpl extends PSExtJS5CtrlCodePublisherImpl
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
		
		//输出结果集合代码
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEDataView, null);
			params.put("store", iPSGenerateCodeResult);
		}
	}


}
