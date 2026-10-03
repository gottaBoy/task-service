package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDSingleLogic;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

/**
 * AngularJS表单成员视图代码发布器
 * @author Administrator
 *
 */
public class PSNGDEFormDetailVCPublisherImpl extends PSNGCtrlPartCodePublisherImpl
{
	protected IPSDEFormDetail iPSDEFormDetail = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormDetail = (IPSDEFormDetail)object;
		return super.generateCode( iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		if(iPSDEFormDetail.getParentPSDEFormDetail()!=null)
		{
			params.put("parent", iPSDEFormDetail.getParentPSDEFormDetail());
		}
		
		
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_ITEMBLANK);
			if(iPSDEFDGroupLogic!=null)
			{
				HashMap<String, String> relatedFormDetailMap = new HashMap<String, String> ();
				String strCode = getPSDEFDLogicCode(iPSDEFDGroupLogic,relatedFormDetailMap);
				if(!StringHelper.isNullOrEmpty(strCode))
				{
					params.put("emptycond", strCode);
				}
			}
		}
		
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_ITEMENABLE);
			if(iPSDEFDGroupLogic!=null)
			{
				HashMap<String, String> relatedFormDetailMap = new HashMap<String, String> ();
				String strCode = getPSDEFDLogicCode(iPSDEFDGroupLogic,relatedFormDetailMap);
				if(!StringHelper.isNullOrEmpty(strCode))
				{
					params.put("enablecond", strCode);
				}
			}
		}
		
		if(true)
		{
			IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic(PSDEFDLogic.LOGICCAT_PANELVISIBLE);
			if(iPSDEFDGroupLogic!=null)
			{
				HashMap<String, String> relatedFormDetailMap = new HashMap<String, String> ();
				String strCode = getPSDEFDLogicCode(iPSDEFDGroupLogic,relatedFormDetailMap);
				if(!StringHelper.isNullOrEmpty(strCode))
				{
					params.put("visiblecond", strCode);
				}
			}
		}
		
		if(iPSDEFormDetail instanceof IPSDEFormItem ){
			
			String strCode = getPSDEFIResetLogicCode((IPSDEFormItem)iPSDEFormDetail);
			if(!StringHelper.isNullOrEmpty(strCode))
			{
				params.put("resetcond", strCode);
			}
		}
	}
	
	protected String getPSDEFIResetLogicCode(IPSDEFormItem iPSDEFormItem)throws Exception
	{
		StringBuilderEx sb = new StringBuilderEx();
		java.util.Iterator<String> resetItemNames = iPSDEFormItem.getResetItemNames();
		boolean bFirst = true;
		sb.append("if( ");
		while(resetItemNames.hasNext())
		{
			if(bFirst)
			{
				bFirst =false;
			}
			else
			{
				sb.append("|| ");
			}
			String strName = resetItemNames.next();
			sb.append("(fieldname=='%1$s') ",strName);
		}
		sb.append(") ");
		sb.append("form.setFieldValue('%1$s','');\r\n",iPSDEFormItem.getName());
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
					if(!StringHelper.isNullOrEmpty(strCode))
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
				sb.append("!");
			}
			sb.append("(");
			for(int i=0;i<codeList.size();i++)
			{
				if(i!=0)
				{
					if(StringHelper.compare(iPSDEFDGroupLogic.getGroupOP(),PSDEFDLogic.GROUPOP_AND,true) == 0)
					{
						sb.append("&&");
					}
					else
						sb.append("||");
				}
				String strCode =codeList.get(i);
				sb.append(strCode);
			}
			sb.append(")");
			return sb.toString();
		}
		
		
		if(iPSDEFDLogic instanceof IPSDEFDSingleLogic)
		{
			IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
			relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
			return StringHelper.format("IBiz.testCond(_%1$s,'%2$s','%3$s')",iPSDEFDSingleLogic.getDEFDName().toLowerCase(),
					iPSDEFDSingleLogic.getPSDBValueOPId(),iPSDEFDSingleLogic.getValue());
			
		}
		
		throw new Exception("无法获取逻辑代码");
	}
	
	
}
