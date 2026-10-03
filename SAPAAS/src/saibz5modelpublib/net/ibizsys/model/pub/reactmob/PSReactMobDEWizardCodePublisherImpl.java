package net.ibizsys.model.pub.reactmob;


import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanel;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 实体向导部件代码发布器
 * @author lionlau
 *
 */
public class PSReactMobDEWizardCodePublisherImpl extends PSReactMobCtrlCodePublisherImpl
{
	protected IPSDEWizardPanel iPSDEWizardPanel = null;

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEWizardPanel = (IPSDEWizardPanel)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEWizardPanel = (IPSDEWizardPanel)this.iPSControl;

		//杈撳嚭缁撴灉闆嗗悎浠ｇ爜
		java.util.Iterator<IPSDEEditForm> psDEEditForms = this.iPSDEWizardPanel.getPSDEEditForms();
		if(psDEEditForms!=null)
		{
			ArrayList<IPSGenerateCodeResult> wizardFormList = new ArrayList<IPSGenerateCodeResult> ();
			while(psDEEditForms.hasNext()){
				IPSDEEditForm iPSDEEditForm = psDEEditForms.next();
				IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSDEEditForm.getPSControlType(), this.getPSPFPubCode());
				if(iPSPFCtrlTempl!=null)
				{
					IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSDEEditForm);
					if(iPSGenerateCodeResult!=null)
					{
						wizardFormList.add(iPSGenerateCodeResult);
					}
					iPSPFCtrlCodePublisher.close();
				}
			}
			
			params.put("wizardforms", wizardFormList);
		}

	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEWizardPanel = null;
		super.onClose();
	}
	
}
