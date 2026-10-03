package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.List;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
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
public class PSPreviewLogicNodeMethod implements TemplateMethodModelEx
{
	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.Format("");
		Object objCtrl = null;
		if(arg0.get(0) instanceof StringModel){
			objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
		}
		if(objCtrl instanceof IPSPanelLogicNode) {
			IPSPanelLogicNode iPSPanelLogicNode = (IPSPanelLogicNode)objCtrl;
			return PSPreviewLogicNodeMethod.getPSLogicNodeCode(iPSPanelLogicNode);
		}
		return "";
	}
	public static String getPSLogicNodeCode(IPSPanelLogicNode iPSPanelLogicNode) 
	{
		java.util.Iterator<IPSPanelLogicNodeParam> nodeParams= iPSPanelLogicNode.getPSPanelLogicNodeParams();
		ArrayList<String> codeList = new  ArrayList<String>();
		if(nodeParams != null) {
			while(nodeParams.hasNext()) {
				IPSPanelLogicNodeParam iPSPanelLogicNodeParam = nodeParams.next();
				String strCode = PSPreviewLogicNodeMethod.getPSLogicNodeParamCode(iPSPanelLogicNodeParam);
				codeList.add(strCode);
			}
		}
		if(codeList.size() == 0)
			return "";
		StringBuilderEx sb = new StringBuilderEx();
		for(String str : codeList) {
			sb.Append(str);
		}
		return sb.toString();
	}
	public static String getPSLogicNodeParamCode(IPSPanelLogicNodeParam nodeParam) 
	{
		try {
			String strDstName = PSPreviewLogicNodeMethod.getLogicParamName(nodeParam.getDstPSPanelLogicParam(), nodeParam.getDstFieldName());
			String strSrcValue = "";
			if(StringHelper.Compare(nodeParam.getSrcValueType(), "SRCMODEL", true) == 0) {
				strSrcValue = PSPreviewLogicNodeMethod.getLogicParamName(nodeParam.getSrcPSPanelLogicParam(), nodeParam.getSrcFieldName());
			} else if (StringHelper.Compare(nodeParam.getSrcValueType(), "SRCVALUE", true) == 0){
				strSrcValue = "'" + nodeParam.getSrcValue() + "'";
			}
			if(StringHelper.Compare(nodeParam.getLogicNodeParamType(), "SETMODEL", true) == 0) {
				return strDstName + " = " + strSrcValue + ";\n";
			} else if(StringHelper.Compare(nodeParam.getLogicNodeParamType(), "PUSHARRAY", true) == 0) {
				return StringHelper.Format("%1$s = IBiz.addToArray(%2$s, %3$s);\n",strDstName, strDstName, strSrcValue);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	public static String getLogicParamName(IPSPanelLogicParam logicParam, String strFieldName) 
	{
		if (!StringHelper.IsNullOrEmpty(strFieldName)) {
			strFieldName = "." + strFieldName;
		}
		if(StringHelper.Compare(logicParam.getType(), "TEMP", true) == 0 || StringHelper.Compare(logicParam.getType(), "INPUT", true) == 0) {
			return logicParam.getCodeName() + strFieldName;
		} else if(StringHelper.Compare(logicParam.getType(), "PANELMODEL", true) == 0) {
			IPSPanelModel iPSPanelModel = logicParam.getPSPanelModel();
			if(StringHelper.Compare(iPSPanelModel.getType(), "CTRLMODEL", true) == 0) {
				return iPSPanelModel.getCodeName() + (StringHelper.IsNullOrEmpty(strFieldName)? ".value" : strFieldName);
			} else {
				return "model." + iPSPanelModel.getCodeName() + strFieldName;
			}
		}
		return "";
	}
}
