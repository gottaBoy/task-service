package net.ibizsys.model.pub.angularga;

import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

public class PSAngularDEFormDetailVCPublisherImpl extends PSAngularCtrlPartCodePublisherImpl
{
	protected IPSDEFormDetail iPSDEFormDetail = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormDetail = (IPSDEFormDetail)object;
		return super.generateCode(iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		if(iPSDEFormDetail.getParentPSDEFormDetail()!=null)
		{
			params.put("parent", iPSDEFormDetail.getParentPSDEFormDetail());
		}
	}
	



}
