package net.ibizsys.model.pub.ionic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class PSIonicViewControllerCodePublisherImpl extends PSIonicViewCodePublisherImpl
{
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
	//	java.util.Iterator<IPSControl> psControls = iPSAppView.getPSControls();
		ArrayList<IPSControl> list = iPSAppView.getAllPSControls();
		if(list != null){
			java.util.Iterator<IPSControl> psControls = list.iterator();
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
				}
			}
		}
		
	}
	
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
		}
		else
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
		sb.Append("if(fieldname==''");
		for(String strKey:relatedFormDetailMap.keySet())
		{
			sb.Append("|| fieldname=='%1$s'",strKey);
		}
		sb.Append("){");
		
		for(String strKey:relatedFormDetailMap.keySet())
		{
			sb.Append("let _%1$s=form.getFieldValue('%1$s');",strKey);
		}
		sb.Append("let ret=false;if(%1$s){ret=true;}",strCode);
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_PANELVISIBLE, true)==0)
		{
			sb.Append("form.setPanelVisible('%1$s',ret);",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		}
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_ITEMBLANK, true)==0)
		{
			sb.Append("form.setFieldAllowBlank('%1$s',ret);",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
		}
		if(StringHelper.Compare(iPSDEFDGroupLogic.getLogicCat(), PSDEFDLogic.LOGICCAT_ITEMENABLE, true)==0)
		{
			sb.Append("form.setFieldDisabled('%1$s',!ret);",iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
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
				sb.Append("|| ");
			}
			String strName = resetItemNames.next();
			sb.Append("(fieldname=='%1$s') ",strName);
		}
		sb.Append(") ");
		sb.Append("form.setFieldValue('%1$s','');\r\n",iPSDEFormItem.getName());
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
		
		
		if(iPSDEFDLogic instanceof IPSDEFDSingleLogic)
		{
			IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
			relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
			return StringHelper.Format("this.IBizUtil.testCond(_%1$s,'%2$s','%3$s')",iPSDEFDSingleLogic.getDEFDName().toLowerCase(),
					iPSDEFDSingleLogic.getPSDBValueOPId(),iPSDEFDSingleLogic.getValue());
			
		}
		
		throw new Exception("无法获取逻辑代码");
	}

}
