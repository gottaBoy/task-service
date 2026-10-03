package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Data.PSDEFormDetail;

public class PSIonic4DEFormViewCodePublisherImpl extends PSIonic4CtrlCodePublisherImpl
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
			ArrayList<IPSGenerateCodeResult> hiddenList = new ArrayList<IPSGenerateCodeResult> ();
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
			//输出所有的隐藏项
			Iterator<IPSDEFormItem> psDEFormItems =  iPSDEForm.getPSDEFormItems();
			while(psDEFormItems.hasNext())
			{
				IPSDEFormItem iPSDEFormItem  = psDEFormItems.next();
				if(!iPSDEFormItem.isHidden())
				{
					continue;
				}
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEForm,iPSDEFormItem);
				hiddenList.add(iPSGenerateCodeResult);
				
			}
			iPSPFCtrlPartCodePublisher.close();
			params.put("hiddens", hiddenList);
		}
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> formPageList = new ArrayList<IPSGenerateCodeResult> ();
			IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(PSDEFormDetail.DETAILTYPE_FORMPAGE).getPSPFCtrlPartCodePublisher();
			//输出所有的隐藏项
			Iterator<IPSDEFormPage> psDEFormPages =  iPSDEForm.getPSDEFormPages();
			while(psDEFormPages.hasNext())
			{
				IPSDEFormPage iPSDEFormPage  = psDEFormPages.next();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEForm,iPSDEFormPage);
				formPageList.add(iPSGenerateCodeResult);
				
			}
			
			iPSPFCtrlPartCodePublisher.close();
			params.put("formpages", formPageList);
		}
		
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> formDetailList = new ArrayList<IPSGenerateCodeResult> ();
			IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(PSDEFormDetail.DETAILTYPE_FORMPAGE).getPSPFCtrlPartCodePublisher();
			//输出所有的隐藏项
			Iterator<IPSDEFormPage> psDEFormPages =  iPSDEForm.getPSDEFormPages();
			while(psDEFormPages.hasNext())
			{
				IPSDEFormPage iPSDEFormPage  = psDEFormPages.next();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEForm,iPSDEFormPage);
				formDetailList.add(iPSGenerateCodeResult);
				
			}
			iPSPFCtrlPartCodePublisher.close();
			
			psDEFormPages =  iPSDEForm.getPSDEFormPages();
			while(psDEFormPages.hasNext())
			{
				IPSDEFormPage iPSDEFormPage  = psDEFormPages.next();
				fillPSDEFormDetails(iPSDEFormPage,formDetailList);				
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
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEForm,childPSDEFormDetail);
				formDetailList.add(iPSGenerateCodeResult);
				iPSPFCtrlPartCodePublisher.close();
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
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, iPSDEForm,iPSDEFormTabPage);
				formDetailList.add(iPSGenerateCodeResult);
				iPSPFCtrlPartCodePublisher.close();
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

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEForm = null;
		super.onClose();
	}
	
}
