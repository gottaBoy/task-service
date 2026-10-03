package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import net.ibizsys.paas.logic.ICondition;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRRegExCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSimpleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSingleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRStringLengthCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSysValueRuleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRValueRange2Condition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class PSIonic4ViewControllerCodePublisherImpl extends PSIonic4ViewCodePublisherImpl
{
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		java.util.Iterator<IPSControl> psControls =iPSAppView.getAllPSControls().iterator(); //iPSAppView.getPSControls();
		
		//找到对应的发布器
		while(psControls.hasNext())
		{
			IPSControl iPSControl = psControls.next();
			if(iPSControl instanceof IPSDEForm)
			{
				IPSDEForm iPSDEForm = (IPSDEForm)iPSControl;
				//枚举所有的逻辑项
				Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
				
				java.util.Iterator<IPSDEFormPage> psDEFormPages = iPSDEForm.getPSDEFormPages();
				if(psDEFormPages!=null)
				{
					while(psDEFormPages.hasNext())
					{
						IPSDEFormPage iPSDEFormPage = psDEFormPages.next();
						fillPSDEFDGroupLogicList(iPSDEFormPage,psDEFDGroupLogicList);
					}
				}
				ArrayList<String> formFDLogicCodeList = new  ArrayList<String> ();
				for(IPSDEFDGroupLogic iPSDEFDGroupLogic:psDEFDGroupLogicList)
				{
					formFDLogicCodeList.add(this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic));
				}
				

				java.util.Iterator<IPSDEFormItem> psDEFormItems = iPSDEForm.getPSDEFormItems();
				while(psDEFormItems.hasNext())
				{
					IPSDEFormItem iPSDEFormItem = psDEFormItems.next();
					if(!StringHelper.IsNullOrEmpty(iPSDEFormItem.getResetItemName()))
					{
						formFDLogicCodeList.add(this.getPSDEFIResetLogicCode(iPSDEFormItem));
					}
				}
				
				
				params.put(iPSDEForm.getName()+"_fdlogics", formFDLogicCodeList);
				
				
				
				//表单值规则校验
				java.util.Iterator<IPSDEFormItemVR> psDEFormItemVRs = iPSDEForm.getPSDEFormItemVRs();
				
				ArrayList<String> formItemVRLogicCodeList = new  ArrayList<String> ();
				while(psDEFormItemVRs.hasNext())
				{
					IPSDEFormItemVR iPSDEFormItemVR = psDEFormItemVRs.next();
					// 只处理前端验证模式
					if (iPSDEFormItemVR.getCheckMode() == IPSDEFormItemVR.CHECKMODE_FRONT || iPSDEFormItemVR.getCheckMode() == IPSDEFormItemVR.CHECKMODE_ALL) {
						formItemVRLogicCodeList.add(this.getPSDEFIVRLogicCode(iPSDEFormItemVR));
					}
				}
				
				params.put(iPSDEForm.getName()+"_vrlogics", formItemVRLogicCodeList);
			}
		}
	}
	
	/**
	 * 获取关联表单项
	 * 
	 * @param iPSDEFormItemVR
	 * @return
	 * @throws Exception
	 */
	protected String getPSDEFIVRLogicCode(IPSDEFormItemVR iPSDEFormItemVR)throws Exception
	{
		IPSDEFValueRule iPSDEFValueRule = iPSDEFormItemVR.getPSDEFValueRule();
		IPSDEFVRGroupCondition psDEFVRGroupCondition = iPSDEFValueRule.getPSDEFVRGroupCondition();
//		java.util.Iterator<IPSDEFVRCondition> psDEFVRConditions =  psDEFVRGroupCondition.getPSDEFVRConditions();

		StringBuilderEx sb = new StringBuilderEx();
		HashMap<String, String> relatedFormDetailMap = new HashMap<String, String>();
		
		String IVRcontent = this.getPSDEFIVRLogicCode(iPSDEFormItemVR, psDEFVRGroupCondition, relatedFormDetailMap);
				
		sb.Append("	if (Object.is(name, '%1$s')) {  \r\n"
				  +"    let hasError = false;  \r\n"
				  +"    try {  \r\n"
				  +"        if (%2$s) {  \r\n"
				  +"            hasError = true;  \r\n"
				  +"        }  \r\n"
				  +"              form.setFormFieldChecked('%3$s', hasError, IBizUtil.errorInfo);  \r\n"
				  +"    } catch (error) {  \r\n"
				  +"        if (error) {  \r\n"
				  +"            form.setFormFieldChecked('%4$s', true, error.message); \r\n"
				  +"        }  \r\n"
				  +"    }  \r\n"
				  +"}  \r\n",
				   relatedFormDetailMap.get("ruleFieldName"), IVRcontent, relatedFormDetailMap.get("ruleFieldName"), relatedFormDetailMap.get("ruleFieldName"));
		
		
		return sb.toString();
		
	}
	
	/**
	 * 获取表单项逻辑值规则
	 * 
	 * @param iPSDEFormItemVR
	 * @param iPSDEFVRCondition
	 * @param relatedFormDetailMap
	 * @return
	 * @throws Exception
	 */
	protected String getPSDEFIVRLogicCode(IPSDEFormItemVR iPSDEFormItemVR,IPSDEFVRCondition iPSDEFVRCondition,HashMap<String, String> relatedFormDetailMap)throws Exception {
		StringBuilderEx sb = new StringBuilderEx();
		if (iPSDEFVRCondition instanceof IPSDEFVRGroupCondition) {
			IPSDEFVRGroupCondition iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition;
			if (iPSDEFVRGroupCondition.isNotMode()) {
				sb.Append("!(");
			}
			
			boolean bFirst = true;
			java.util.Iterator<IPSDEFVRCondition> psDEFVRConditions =  iPSDEFVRGroupCondition.getPSDEFVRConditions();
			while(psDEFVRConditions.hasNext()) {
				IPSDEFVRCondition childPSDEFVRCondition = psDEFVRConditions.next();
				if (bFirst) {
					bFirst = false;
				} else {
					if (iPSDEFVRGroupCondition.getCondOp().equals(ICondition.CONDOP_AND)) {
						sb.Append(" && ");
					} else {
						sb.Append(" || ");
					}
				}
				
				sb.Append("(%1$s)",getPSDEFIVRLogicCode(iPSDEFormItemVR, childPSDEFVRCondition, relatedFormDetailMap));
			}
			
			if (iPSDEFVRGroupCondition.isNotMode()) {
				sb.Append(")");
			}
		} else {
			IPSDEFVRSingleCondition iPSDEFVRSingleCondition = (IPSDEFVRSingleCondition)iPSDEFVRCondition;
			if (iPSDEFVRSingleCondition.isNotMode()) {
				sb.Append("!(");
			}
			
			relatedFormDetailMap.put("ruleFieldName",iPSDEFVRSingleCondition.getDEFName().toLowerCase());
			
			if (iPSDEFVRCondition instanceof IPSDEFVRSimpleCondition) {
				// 检查属性常规条件
				IPSDEFVRSimpleCondition iPSDEFVRSimpleCondition = (IPSDEFVRSimpleCondition)iPSDEFVRCondition;
				sb.Append(
						"IBizUtil.checkFieldSimpleRule(value, '%1$s', '%2$s', '%3$s', '%4$s', form, %5$s)",
						iPSDEFVRSimpleCondition.getPSDBValueOPId(), iPSDEFVRSimpleCondition.getParamValue(),
						iPSDEFVRSimpleCondition.getRuleInfo(), iPSDEFVRSimpleCondition.getParamType(), 
						iPSDEFVRSimpleCondition.isKeyCond());
				
			} else if (iPSDEFVRCondition instanceof IPSDEFVRSysValueRuleCondition) {
				// 检查属性值系统值范围规则   暂时支持正则表达式
				IPSDEFVRSysValueRuleCondition iPSDEFVRSysValueRuleCondition = (IPSDEFVRSysValueRuleCondition)iPSDEFVRCondition;
				IPSSysValueRule iPSSysValueRule = iPSDEFVRSysValueRuleCondition.getPSSysValueRule();
				if (StringHelper.Compare(iPSSysValueRule.getRuleType(), IPSSysValueRule.RULETYPE_REGEX, true) == 0 || StringHelper.Compare(iPSSysValueRule.getRuleType(), IPSSysValueRule.RULETYPE_REG, true) == 0) {
					sb.Append(
							"IBizUtil.checkFieldRegExRule(value, %1$s, '%2$s',%3$s)",
							iPSSysValueRule.getRegExCode(), iPSSysValueRule.getRuleInfo(), iPSDEFVRSysValueRuleCondition.isKeyCond());
				}
			} else if (iPSDEFVRCondition instanceof IPSDEFVRStringLengthCondition) {
				// 检查属性字符长度规则
				IPSDEFVRStringLengthCondition iPSDEFVRStringLengthCondition = (IPSDEFVRStringLengthCondition) iPSDEFVRCondition;
				sb.Append(
						"IBizUtil.checkFieldStringLengthRule(value, %1$s, %2$s, %3$s, %4$s, '%5$s', %6$s)",
						iPSDEFVRStringLengthCondition.getMinValue(), iPSDEFVRStringLengthCondition.isIncludeMinValue(),
						iPSDEFVRStringLengthCondition.getMaxValue(), iPSDEFVRStringLengthCondition.isIncludeMaxValue(),
						iPSDEFVRStringLengthCondition.getRuleInfo(), iPSDEFVRStringLengthCondition.isKeyCond());
			} else if (iPSDEFVRCondition instanceof IPSDEFVRRegExCondition) {
				// 检查属性值正则式规则
				IPSDEFVRRegExCondition iPSDEFVRRegExCondition = (IPSDEFVRRegExCondition) iPSDEFVRCondition;
				sb.Append(
						"IBizUtil.checkFieldRegExRule(value, %1$s, '%2$s',%3$s)",
						iPSDEFVRRegExCondition.getRegExCode(), iPSDEFVRRegExCondition.getRuleInfo(), iPSDEFVRRegExCondition.isKeyCond());
			} else if (iPSDEFVRCondition instanceof IPSDEFVRValueRange2Condition) {
				// 检查属性值范围规则
				IPSDEFVRValueRange2Condition iPSDEFVRValueRange2Condition = (IPSDEFVRValueRange2Condition) iPSDEFVRCondition;
				sb.Append(
						"IBizUtil.checkFieldValueRangeRule(value, %1$s, %2$s, %3$s, %4$s, '%5$s', %6$s)",
						iPSDEFVRValueRange2Condition.getMinValue(), iPSDEFVRValueRange2Condition.isIncludeMinValue(),
						iPSDEFVRValueRange2Condition.getMaxValue(), iPSDEFVRValueRange2Condition.isIncludeMaxValue(),
						iPSDEFVRValueRange2Condition.getRuleInfo(), iPSDEFVRValueRange2Condition.isKeyCond());
			} else {
				sb.Append("false");
			}
			
			if (iPSDEFVRSingleCondition.isNotMode()) {
				sb.Append(")");
			}
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 填充关系分组逻辑列表
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
	

	protected String getPSDEFDGroupLogicCode(IPSDEFDGroupLogic iPSDEFDGroupLogic)throws Exception
	{
		HashMap<String, String> relatedFormDetailMap = new HashMap<String, String> ();
		String strCode = getPSDEFDLogicCode(iPSDEFDGroupLogic,relatedFormDetailMap);
		if(StringHelper.IsNullOrEmpty(strCode))
			return "";
		
		if(relatedFormDetailMap.size()==0)
		{
			return StringHelper.Format("/*%1$s没有任何单项条件*/",iPSDEFDGroupLogic.getPSDEFormDetail().getName());
		}
		
		//判断类型，重新格式化
		StringBuilderEx sb = new StringBuilderEx();
		sb.Append("if(Object.is(fieldname, '')");
		for(String strKey:relatedFormDetailMap.keySet())
		{
			sb.Append(" || Object.is(fieldname, '%1$s')",strKey);
		}
		sb.Append("){\r\n");
		
		for(String strKey:relatedFormDetailMap.keySet())
		{
			sb.Append("const _%1$s = form.getFieldValue('%1$s');\r\n",strKey);
		}
		sb.Append("let ret = false;\r\n if(%1$s){\r\n ret=true; \r\n}\r\n",strCode);
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_PANELVISIBLE, true)==0)
		{
			sb.Append("form.setPanelVisible('%1$s',ret);\r\n",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		}
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_ITEMBLANK, true)==0)
		{
			sb.Append("form.setFieldAllowBlank('%1$s',ret);\r\n",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		}
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_ITEMENABLE, true)==0)
		{
			sb.Append("form.setFieldDisabled('%1$s',!ret);\r\n",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		}
		
		sb.Append("}\r\n");
		return sb.toString();
	}
	
	
	protected String getPSDEFIResetLogicCode(IPSDEFormItem iPSDEFormItem)throws Exception
	{
//		StringBuilderEx sb = new StringBuilderEx();
//		sb.Append("if( fieldname=='%1$s')",iPSDEFormItem.getResetItemName());
//		sb.Append("form.setFieldValue('%1$s','');\r\n",iPSDEFormItem.getName());
//		return sb.toString();
		StringBuilderEx sb = new StringBuilderEx();
		java.util.Iterator<String> resetItemNames = iPSDEFormItem.getResetItemNames();
		boolean bFirst = true;
		sb.Append("if( ");
		while(resetItemNames.hasNext())
		{
			if(bFirst)
			{
				bFirst =false;
			}
			else
			{
				sb.Append(" || ");
			}
			String strName = resetItemNames.next();
			sb.Append("(Object.is(fieldname, '%1$s')) ",strName);
		}
		sb.Append(") ");
		sb.Append("{ form.setFieldValue('%1$s',''); }\r\n",iPSDEFormItem.getName());
		return sb.toString();
	}
	
	
	protected String getPSDEFDLogicCode(IPSDEFDLogic iPSDEFDLogic,HashMap<String, String> relatedFormDetailMap)throws Exception
	{
		if(iPSDEFDLogic instanceof IPSDEFDGroupLogic)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
			ArrayList<String> codeList = new  ArrayList<String>();
			java.util.Iterator<IPSDEFDLogic> psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
			if(psDEFDLogics!=null)
			{
				while(psDEFDLogics.hasNext())
				{
					IPSDEFDLogic childPSDEFDLogic = psDEFDLogics.next();
					String strCode = getPSDEFDLogicCode(childPSDEFDLogic,relatedFormDetailMap);
					if(!StringHelper.IsNullOrEmpty(strCode))
					{
						codeList.add(strCode);
					}
				}
			}
			
			if(codeList.size() == 0)
				return "";
			
			if(codeList.size() == 1)
			{
				if(iPSDEFDGroupLogic.isNotMode())
				{
					return "!"+codeList.get(0);
				}
				else
				{
					return codeList.get(0);
				}
			}
			
			StringBuilderEx sb = new StringBuilderEx();
			if(iPSDEFDGroupLogic.isNotMode())
			{
				sb.Append("!");
			}
			sb.Append("(");
			for(int i=0;i<codeList.size();i++)
			{
				if(i!=0)
				{
					if(StringHelper.Compare(iPSDEFDGroupLogic.getGroupOP(),PSDEFDLogic.GROUPOP_AND,true) == 0)
					{
						sb.Append(" && ");
					}
					else
						sb.Append(" || ");
				}
				String strCode =codeList.get(i);
				sb.Append(strCode);
			}
			sb.Append(")");
			return sb.toString();
		}
		
		
		if(iPSDEFDLogic instanceof IPSDEFDSingleLogic)
		{
			IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
			relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
			return StringHelper.Format("IBizUtil.testCond(_%1$s,'%2$s','%3$s')",iPSDEFDSingleLogic.getDEFDName().toLowerCase(),
					iPSDEFDSingleLogic.getPSDBValueOPId(),iPSDEFDSingleLogic.getValue());
			
		}
		
		throw new Exception("无法获取逻辑代码");
	}

}
