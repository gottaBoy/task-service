package net.ibizsys.model.pub.angularga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.entity.PSDEFormDetail;

public class PSAngularDEFormControllerCodePublisherImpl extends PSAngularCtrlCodePublisherImpl
{
	protected IPSDEForm iPSDEForm = null;
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEForm = (IPSDEForm)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDEForm = (IPSDEForm)this.iPSControl;
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> formDetailList = new ArrayList<IPSGenerateCodeResult> ();
			if(true)
			{
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
				//输出所有的隐藏项
				Iterator<IPSDEFormItem> psDEFormItems =  iPSDEForm.getPSDEFormItems();
				while(psDEFormItems.hasNext())
				{
					IPSDEFormItem iPSDEFormItem  = psDEFormItems.next();
					if(!iPSDEFormItem.isHidden())
					{
						continue;
					}
					
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEForm,iPSDEFormItem);
					formDetailList.add(iPSGenerateCodeResult);
					
				}
			}
			if(true)
			{
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(PSDEFormDetail.DETAILTYPE_FORMPAGE).getPSPFCtrlPartCodePublisher();
				Iterator<IPSDEFormPage> psDEFormPages =  iPSDEForm.getPSDEFormPages();
				while(psDEFormPages.hasNext())
				{
					IPSDEFormPage iPSDEFormPage  = psDEFormPages.next();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEForm,iPSDEFormPage);
					formDetailList.add(iPSGenerateCodeResult);
					
				}
				
				psDEFormPages =  iPSDEForm.getPSDEFormPages();
				while(psDEFormPages.hasNext())
				{
					IPSDEFormPage iPSDEFormPage  = psDEFormPages.next();
					fillPSDEFormDetails(iPSDEFormPage,formDetailList);				
				}
			}
			params.put("formdetails", formDetailList);
		}
	}
	
	protected void fillPSDEFormDetails(IPSDEFormDetail iPSDEFormDetail,ArrayList<IPSGenerateCodeResult> formDetailList)throws Exception
	{
		if(iPSDEFormDetail instanceof IPSDEFormGroupPanel)
		{
			IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
			java.util.Iterator<IPSDEFormDetail> psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
			while(psDEFormDetails.hasNext())
			{
				IPSDEFormDetail childPSDEFormDetail = psDEFormDetails.next();
				if(childPSDEFormDetail instanceof  IPSDEFormItem){
					if(((IPSDEFormItem)childPSDEFormDetail).isHidden())
						continue;
				}
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEForm,childPSDEFormDetail);
				formDetailList.add(iPSGenerateCodeResult);
			}
			
			psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
			while(psDEFormDetails.hasNext())
			{
				IPSDEFormDetail childPSDEFormDetail = psDEFormDetails.next();
				fillPSDEFormDetails(childPSDEFormDetail,formDetailList);
			}
			return;
		}
		
		if(iPSDEFormDetail instanceof IPSDEFormTabPanel)
		{
			IPSDEFormTabPanel iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail;
			java.util.Iterator<IPSDEFormTabPage> psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
			while(psDEFormTabPages.hasNext())
			{
				IPSDEFormTabPage iPSDEFormTabPage = psDEFormTabPages.next();
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEFormTabPage.getDetailType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEForm,iPSDEFormTabPage);
				formDetailList.add(iPSGenerateCodeResult);
			}
			
			psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
			while(psDEFormTabPages.hasNext())
			{
				IPSDEFormTabPage iPSDEFormTabPage = psDEFormTabPages.next();
				fillPSDEFormDetails(iPSDEFormTabPage,formDetailList);
			}
			return;
		}
	}

	

	
}
