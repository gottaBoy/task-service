package net.ibizsys.model.pub.angular;

import java.util.HashMap;

import net.ibizsys.model.control.drctrl.IPSDRBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 关系栏
 * @author lionlau
 *
 */
public class PSAngularDRBarViewCodePublisherImpl extends PSAngularCtrlCodePublisherImpl
{
	protected IPSDRBar iPSDRBar = null;
	public final static String CTRLPART_STORE = "STORE";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDRBar = (IPSDRBar)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDRBar = (IPSDRBar)this.iPSControl;
		
		//输出结果集合代码
		if(true)
		{
			/*IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDRBar, null);
			iPSPFCtrlPartCodePublisher.close();
			params.put("store", iPSGenerateCodeResult);*/
		}
		
		
	}

	
}
