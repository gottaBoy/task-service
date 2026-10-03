package net.ibizsys.model.pub.angular;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.pub.IPSGenerateCodeResult;

public class PSAngularDEFormDRUIPartVCPublisherImpl extends PSAngularDEFormDetailVCPublisherImpl
{
	protected IPSDEFormDRUIPart iPSDEFormDRUIPart = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormDRUIPart = (IPSDEFormDRUIPart)object;
		return super.generateCode( iPSControl, object);
	}
	

}
