package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDSingleLogic;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * PreViewPCuery表单控制器代码发布对象
 * @author Administrator
 *
 */
public class PSVue2DEFormControllerCodePublisherImpl extends PSVue2CtrlCodePublisherImpl
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
			
			if (StringHelper.compare(this.getPSPFPubCode().getName(), "MODEL", true)==0) {
				//枚举所有的逻辑项
				Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
				
				java.util.Iterator<IPSDEFormPage> psDEFormPages = iPSDEForm.getPSDEFormPages();
				if(psDEFormPages!=null)
				{
					while(psDEFormPages.hasNext())
					{
						IPSDEFormPage iPSDEFormPage = psDEFormPages.next();
						this.fillPSDEFDGroupLogicList(iPSDEFormPage, psDEFDGroupLogicList);
					}
				}
				
				// 表单逻辑
				ArrayList<JSONObject> groupLogin = new  ArrayList<JSONObject>();
				for(IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList)
				{
					JSONObject Obj = this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic);
					if (Obj != null) {
						groupLogin.add(Obj);
					}
				}
				params.put("groupLogic", groupLogin.toString());
				
				// 表单更新项
				ArrayList<JSONObject> formItemUpdates = new ArrayList<JSONObject>();
				Iterator<IPSDEFormItem> items = iPSDEForm.getPSDEFormItems();
				while(items.hasNext()) {
					IPSDEFormItem item = items.next();
					if (item != null && item.getPSDEFormItemUpdate() != null) {
						JSONObject obj = new JSONObject();
						obj.put(item.getName().toLowerCase(), item.getPSDEFormItemUpdate().getCodeName());
						formItemUpdates.add(obj);
					}
				}
				params.put("formItemUpdates", formItemUpdates.toString());
			}
		}
	}
	
	/**
	 * 填充表单详情
	 * 
	 * @param iPSDEFormDetail
	 * @param formDetailList
	 * @throws Exception
	 */
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
	
	/**
	 *  填充关系分组逻辑列表
	 * 
	 * @param iPSDEFormDetail
	 * @param psDEFDGroupLogicList
	 * @throws Exception
	 */
	protected void fillPSDEFDGroupLogicList(IPSDEFormDetail iPSDEFormDetail,Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception
	{
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_ITEMBLANK);
			if(iPSDEFDGroupLogic!=null)
			{
				psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
			}
		}
		
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_ITEMENABLE);
			if(iPSDEFDGroupLogic!=null)
			{
				psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
			}
		}
		
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_PANELVISIBLE);
			if(iPSDEFDGroupLogic!=null)
			{
				psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
			}
		}
		
		
		if(iPSDEFormDetail instanceof IPSDEFormGroupPanel)
		{
			IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
			java.util.Iterator<IPSDEFormDetail> psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
			if(psDEFormDetails!=null)
			{
				while(psDEFormDetails.hasNext())
				{
					IPSDEFormDetail iPSDEFormDetail2 = psDEFormDetails.next();
					fillPSDEFDGroupLogicList(iPSDEFormDetail2,psDEFDGroupLogicList);
				}
			}
		}else
			if(iPSDEFormDetail instanceof IPSDEFormTabPanel)
			{
				IPSDEFormTabPanel iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail;
				java.util.Iterator<IPSDEFormTabPage> psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
				if(psDEFormTabPages!=null)
				{
					while(psDEFormTabPages.hasNext())
					{
						IPSDEFormTabPage iPSDEFormTabPage = psDEFormTabPages.next();
						fillPSDEFDGroupLogicList(iPSDEFormTabPage,psDEFDGroupLogicList);
					}
				}
			}
	}
	
	/**
	 * 获取分组逻辑
	 * 
	 * @param iPSDEFDGroupLogic
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getPSDEFDGroupLogicCode(IPSDEFDGroupLogic iPSDEFDGroupLogic) throws Exception {
		JSONObject obj = new JSONObject();
		HashMap<String, String> relatedFormDetailMap = new HashMap<String, String> ();
		ArrayList<JSONObject> conditions = new ArrayList<JSONObject>();
		JSONObject condition = getPSDEFDLogicCode(iPSDEFDGroupLogic, relatedFormDetailMap);
		if(condition == null) {
			return null;
		}
		conditions.add(condition);
		
		if(relatedFormDetailMap.size()==0)
		{
			return null;
		}
		ArrayList<String> relatedFormDetailLists = new ArrayList<>();
		for(String name : relatedFormDetailMap.keySet()) {
			relatedFormDetailLists.add(name);
		}
		
		obj.put("names", relatedFormDetailLists);
		obj.put("logiccat", iPSDEFDGroupLogic.getLogicCat());
		obj.put("formname", iPSDEForm.getName());
		obj.put("conditions", conditions.toString());
		obj.put("itemname", iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		return obj;
	}
	
	/**
	 * 获取逻辑关系
	 * 
	 * @param iPSDEFDLogic
	 * @param relatedFormDetailMap
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getPSDEFDLogicCode(IPSDEFDLogic iPSDEFDLogic, HashMap<String, String> relatedFormDetailMap ) throws Exception
	{
		if(iPSDEFDLogic instanceof IPSDEFDGroupLogic)
		{
			JSONObject condition = new JSONObject();
			IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
			ArrayList<JSONObject> _childList = new  ArrayList<JSONObject>();
			java.util.Iterator<IPSDEFDLogic> psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
			if(psDEFDLogics!=null)
			{
				while(psDEFDLogics.hasNext())
				{
					IPSDEFDLogic childPSDEFDLogic = psDEFDLogics.next();
					JSONObject _child = getPSDEFDLogicCode(childPSDEFDLogic, relatedFormDetailMap);
					if(_child != null)
					{
						_childList.add(_child);
					}
				}
			}
			
			if(_childList.size() == 0) {
				return null;
			}
			
			condition.put("isnotmode", iPSDEFDGroupLogic.isNotMode()? true : false);
			condition.put("gruopop", iPSDEFDGroupLogic.getGroupOP());
			condition.put("items", _childList);
			condition.put("type", "group");
			
			return condition;
		}
		
		
		if(iPSDEFDLogic instanceof IPSDEFDSingleLogic)
		{
			IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
			relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), iPSDEFDSingleLogic.getDEFDName().toLowerCase());
			JSONObject obj = new JSONObject();
			obj.put("name", iPSDEFDSingleLogic.getDEFDName().toLowerCase());
			obj.put("dbvalueop", iPSDEFDSingleLogic.getPSDBValueOPId());
			obj.put("value", iPSDEFDSingleLogic.getValue());
			return obj;
			
		}
		
		throw new Exception("无法获取逻辑代码");
	}
	
}
