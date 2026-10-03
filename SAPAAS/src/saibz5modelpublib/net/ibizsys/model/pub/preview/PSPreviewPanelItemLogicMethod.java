package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemSingleLogic;
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
public class PSPreviewPanelItemLogicMethod implements TemplateMethodModelEx
{
	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.Format("");
		Object objCtrl = null;
		if(arg0.get(0) instanceof StringModel){
			objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
		}
		if(objCtrl instanceof IPSPanelItemGroupLogic) {
			HashMap<String, String> relatedPanelItemDetailMap = new HashMap<String, String> ();
			IPSPanelItemGroupLogic iPSPanelItemGroupLogic = (IPSPanelItemGroupLogic)objCtrl;
			String strCode = PSPreviewPanelItemLogicMethod.getPSLogicCode(iPSPanelItemGroupLogic, relatedPanelItemDetailMap);
			if(!StringHelper.IsNullOrEmpty(strCode)) {
				return strCode;
			}
		}
		return "";
	}
	public static String getPSLogicCode(IPSPanelItemLogic iPSPanelItemLogic, HashMap<String, String> relatedPanelItemDetailMap) 
	{
		if(iPSPanelItemLogic instanceof IPSPanelItemGroupLogic) {
			IPSPanelItemGroupLogic iPSPanelItemGroupLogic = (IPSPanelItemGroupLogic)iPSPanelItemLogic;
			ArrayList<String> codeList = new  ArrayList<String>();
			java.util.Iterator<IPSPanelItemLogic> iPSPanelItemLogics = iPSPanelItemGroupLogic.getPSPanelItemLogics();
			if(iPSPanelItemLogics != null) {
				while(iPSPanelItemLogics.hasNext()) {
					IPSPanelItemLogic childPanelItemLogic = iPSPanelItemLogics.next();
					String strCode = PSPreviewPanelItemLogicMethod.getPSLogicCode(childPanelItemLogic,relatedPanelItemDetailMap);
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
				if(iPSPanelItemGroupLogic.isNotMode())
				{
					return "!"+codeList.get(0);
				}
				else
				{
					return codeList.get(0);
				}
			}
			StringBuilderEx sb = new StringBuilderEx();
			if(iPSPanelItemGroupLogic.isNotMode())
			{
				sb.Append("!");
			}
			sb.Append("(");
			for(int i=0;i<codeList.size();i++)
			{
				if(i!=0)
				{
					if(StringHelper.Compare(iPSPanelItemGroupLogic.getGroupOP(),PSDEFDLogic.GROUPOP_AND,true) == 0)
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
		if(iPSPanelItemLogic instanceof IPSPanelItemSingleLogic) {
			String strCode = "";
			try {
				IPSPanelItemSingleLogic iPSPanelItemSingleLogic = (IPSPanelItemSingleLogic)iPSPanelItemLogic;
				relatedPanelItemDetailMap.put(iPSPanelItemSingleLogic.getDstModelField().toLowerCase(), "");
				String dstParamName = "";
				if(!StringHelper.IsNullOrEmpty(iPSPanelItemSingleLogic.getDstModelField())) {
					dstParamName = "." + iPSPanelItemSingleLogic.getDstModelField();
				}
				IPSPanelModel model = iPSPanelItemSingleLogic.getDstPSPanelModel();
				String logicName = "model." + model.getCodeName() + dstParamName;
				
				String strScope = "";
				IPSPanel panel = model.getPSPanel();
				if(!panel.isLayoutPanel()) {
					if(StringHelper.Compare(model.getType(), "CTRLMODEL", true) == 0) {
						logicName = model.getCodeName() + (StringHelper.IsNullOrEmpty(dstParamName)?".value":dstParamName);
					}
					strScope = StringHelper.Format("ctrl.%1$s.", panel.getName());
				} 
				strCode = StringHelper.Format("ctrl.testCond(%1$s%2$s,'%3$s','%4$s')", strScope,logicName,iPSPanelItemSingleLogic.getCondOp(),iPSPanelItemSingleLogic.getValue());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				return strCode;
		}
		return "";
		
	}
}
