package net.ibizsys.model.pub.preview;

import java.util.ArrayList;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond;
import SA.SRFDA.PS.Core.Pub.PSPFViewLogicCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

/**
 * PreViewPC 视图逻辑代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewViewLogicCodePublisherImpl extends PSPFViewLogicCodePublisherImpl 
{
	
	public String getDEViewLogicLinkCode(IPSDELogicLink iPSDELogicLink)throws Exception
	{
		return getPSDELogicLinkGroupCondCode(iPSDELogicLink.getPSDELogicLinkGroupCond());
	}
	
	protected String getPSDELogicLinkGroupCondCode(IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond)throws Exception
	{
		if(iPSDELogicLinkGroupCond == null)
			return "true";
		String strCode = getPSDELogicLinkCondCode(iPSDELogicLinkGroupCond);
		if(StringHelper.IsNullOrEmpty(strCode))
			return "true";
		return strCode;
	}
	
	
	protected String getPSDELogicLinkCondCode(IPSDELogicLinkCond iPSDELogicLinkCond)throws Exception
	{
		if(iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond)
		{
			IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
			ArrayList<String> codeList = new  ArrayList<String>();
			java.util.Iterator<? extends IPSDELogicLinkCond> psDEFDLogics = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
			if(psDEFDLogics!=null)
			{
				while(psDEFDLogics.hasNext())
				{
					IPSDELogicLinkCond childPSDELogicLinkCond = psDEFDLogics.next();
					String strCode = getPSDELogicLinkCondCode(childPSDELogicLinkCond);
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
				if(iPSDELogicLinkGroupCond.isNotMode())
				{
					return "!"+codeList.get(0);
				}
				else
				{
					return codeList.get(0);
				}
			}
			
			StringBuilderEx sb = new StringBuilderEx();
			if(iPSDELogicLinkGroupCond.isNotMode())
			{
				sb.Append("!");
			}
			sb.Append("(");
			for(int i=0;i<codeList.size();i++)
			{
				if(i!=0)
				{
					if(StringHelper.Compare(iPSDELogicLinkGroupCond.getGroupOP(),PSDELogicLinkCond.GROUPOP_AND,true) == 0)
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
		
		
		if(iPSDELogicLinkCond instanceof IPSDELogicLinkSingleCond)
		{
			IPSDELogicLinkSingleCond iPSDELogicLinkSingleCond = (IPSDELogicLinkSingleCond)iPSDELogicLinkCond;
			String strParamName = PSParamNameMethod.getValue(iPSDELogicLinkSingleCond.getDstLogicParam().getCodeName());
			if(StringHelper.IsNullOrEmpty(iPSDELogicLinkSingleCond.getDstFieldName())){
				return StringHelper.Format("IBiz.testCond(%1$s,\"%3$s\",\"%4$s\")",strParamName,iPSDELogicLinkSingleCond.getDstFieldName(),
						iPSDELogicLinkSingleCond.getPSDBValueOPId(),iPSDELogicLinkSingleCond.getValue());
			}
			else
			{
				return StringHelper.Format("IBiz.testCond(%1$s.%2$s,\"%3$s\",\"%4$s\")",strParamName,iPSDELogicLinkSingleCond.getDstFieldName(),
						iPSDELogicLinkSingleCond.getPSDBValueOPId(),iPSDELogicLinkSingleCond.getValue());
			}
			
			
		}
		
		throw new Exception("无法获取逻辑代码");
	}
}
