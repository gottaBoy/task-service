package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkSingleCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * 转为为js字符串
 * @author Administrator
 *
 */
public class PSIonic4LogicMethod implements TemplateMethodModelEx
{
	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.Format("");
		Object objCtrl = null;
		if(arg0.get(0) instanceof StringModel){
			objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
		}
		if(objCtrl instanceof IPSPanelLogicLinkGroupCond) {
			HashMap<String, String> relatedLogicDetailMap = new HashMap<String, String> ();
			IPSPanelLogicLinkGroupCond iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)objCtrl;
			String strCode = PSIonic4LogicMethod.getPSLogicCode(iPSPanelLogicLinkGroupCond, relatedLogicDetailMap);
			if(!StringHelper.IsNullOrEmpty(strCode)) {
				return strCode;
			}
		}
		return "true";
	}
	public static String getPSLogicCode(IPSPanelLogicLinkCond iPSPanelLogicLinkCond, HashMap<String, String> relatedLogicDetailMap) 
	{
		if(iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkGroupCond) {
			IPSPanelLogicLinkGroupCond iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)iPSPanelLogicLinkCond;
			ArrayList<String> codeList = new  ArrayList<String>();
			java.util.Iterator<IPSPanelLogicLinkCond> iPSPanelLogicLinkConds = iPSPanelLogicLinkGroupCond.getPSPanelLogicLinkConds();
			if(iPSPanelLogicLinkConds != null) {
				while(iPSPanelLogicLinkConds.hasNext()) {
					IPSPanelLogicLinkCond childLogicLinkCond = iPSPanelLogicLinkConds.next();
					String strCode = PSIonic4LogicMethod.getPSLogicCode(childLogicLinkCond,relatedLogicDetailMap);
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
				if(iPSPanelLogicLinkGroupCond.isNotMode())
				{
					return "!"+codeList.get(0);
				}
				else
				{
					return codeList.get(0);
				}
			}
			StringBuilderEx sb = new StringBuilderEx();
			if(iPSPanelLogicLinkGroupCond.isNotMode())
			{
				sb.Append("!");
			}
			sb.Append("(");
			for(int i=0;i<codeList.size();i++)
			{
				if(i!=0)
				{
					if(StringHelper.Compare(iPSPanelLogicLinkGroupCond.getGroupOP(),PSDEFDLogic.GROUPOP_AND,true) == 0)
					{
						sb.Append("&&");
					}
					else
						sb.Append("||");
				}
				String strCode =codeList.get(i);
				sb.Append(strCode);
			}
			sb.Append(")");
			return sb.toString();
		}
		if(iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkSingleCond) {
			String strCode = "";
			try {
			IPSPanelLogicLinkSingleCond iPSPanelLogicLinkSingleCond = (IPSPanelLogicLinkSingleCond)iPSPanelLogicLinkCond;
			relatedLogicDetailMap.put(iPSPanelLogicLinkSingleCond.getDstFieldName().toLowerCase(), "");
			String dstParamName = "";
			if(!StringHelper.IsNullOrEmpty(iPSPanelLogicLinkSingleCond.getDstFieldName())) {
				dstParamName = "." + iPSPanelLogicLinkSingleCond.getDstFieldName();
			}
			
			if(StringHelper.Compare(iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getType(), "PANELMODEL", true) == 0) {
				IPSPanelModel model = iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getPSPanelModel();
				if(StringHelper.Compare(model.getType(), "CTRLMODEL", true) == 0) {
					dstParamName = model.getCodeName() + (StringHelper.IsNullOrEmpty(dstParamName)?".value":dstParamName);
				} else {
					dstParamName = "model." + model.getCodeName() + dstParamName;
				}
			} else {
				dstParamName = iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getCodeName() + dstParamName;
			}
			
			strCode = StringHelper.Format("IBiz.testCond(%1$s,'%2$s','%3$s')",dstParamName,iPSPanelLogicLinkSingleCond.getCondOp(),iPSPanelLogicLinkSingleCond.getValue());
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return strCode;
		}
		return "";
		
	}
}
