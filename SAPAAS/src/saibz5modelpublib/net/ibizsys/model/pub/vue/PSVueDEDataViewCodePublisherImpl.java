package net.ibizsys.model.pub.vue;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

public class PSVueDEDataViewCodePublisherImpl extends PSVueCtrlCodePublisherImpl
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
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDEDataView, null);
			iPSPFCtrlPartCodePublisher.close();
			params.put("store", iPSGenerateCodeResult);
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEDataView = null;
		super.onClose();
	}
	
}
