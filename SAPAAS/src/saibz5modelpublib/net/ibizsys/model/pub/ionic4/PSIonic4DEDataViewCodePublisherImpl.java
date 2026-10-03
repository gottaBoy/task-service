package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

public class PSIonic4DEDataViewCodePublisherImpl extends PSIonic4CtrlCodePublisherImpl
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
		this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
		if(this.iPSDEDataView.getItemPSSysLayoutPanel()!=null){
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(this.iPSDEDataView.getItemPSSysLayoutPanel().getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				HashMap<String,Object> panelParams = new HashMap<String,Object>();
				panelParams.put("srfctrl", params.get("srfctrl"));
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, this.iPSDEDataView.getItemPSSysLayoutPanel(),panelParams);
				if(iPSGenerateCodeResult!=null)
				{
					params.put(this.iPSDEDataView.getItemPSSysLayoutPanel().getName(), iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
			}
		}
		
		super.onFillGenerateCodeParams(params);
		
		
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
