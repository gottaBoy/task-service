package net.ibizsys.psuac.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 远程登录页面
 * 
 * @author Administrator
 * 
 */
public class RemoteLoginPage extends LoginPageBase
{
	private static final Log log = LogFactory.getLog(RemoteLoginPage.class);
	
	public RemoteLoginPage()
	{
		
	}
	
	@Override
	protected void onInit() throws Exception
	{
		super.onInit();
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see SA.SRFramework.WebEx.SRFExPage#OnInitComponents()
//	 */
//	@Override
//	protected void OnInitComponents()
//	{
//		super.OnInitComponents();
//
//		try
//		{
//			if(!StringHelper.IsNullOrEmpty(this.getWebContext().getCurUserId()))
//			{
//				SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
//				actionResult.setRetCode(Errors.OK);
//				String strSessionKeys = this.getWebContext().GetParamValue("SESSIONKEYS");
//				OnFillExtLoginInfo(actionResult,strSessionKeys);
//				try
//				{
//					this.getResponse().getWriter().print(actionResult.ToJSONString());
//				}
//				catch (IOException e)
//				{
//					e.printStackTrace();
//				}
//				
//				return;
//			}
//		//	String strLoginName = "admin";
//			String strLoginName = "";
//			String strLoginKey = this.getWebContext().GetParamValue("LOGINKEY");
//			if(!StringHelper.IsNullOrEmpty(strLoginKey))
//			{
//				LoginKey loginKey = new LoginKey();
//				loginKey.setLOINGKEYID(strLoginKey);
//				
//				CallResult callResult = GetLoginKeyDataCtrl().Get(loginKey);
//				if(callResult.IsError())
//				{
//					return;
//				}
//				
//				//判断限制登录次数
//				if(loginKey.getLIMITCNT()==0)
//				{
//					GetLoginKeyDataCtrl().Remove(loginKey);
//					return;
//				}
//				
//				strLoginName = "";
//				//判断IP受限
//				if(!StringHelper.IsNullOrEmpty(loginKey.getIPADDRESS()))
//				{
//					String strIpAddr = this.getWebContext().getRemoteAddr();
//					if(loginKey.getIPADDRESS().indexOf(strIpAddr) != -1)
//					{
//						strLoginName =loginKey.getLOINGKEYNAME();
//					}
//				}
//				else
//				{
//					strLoginName =loginKey.getLOINGKEYNAME();
//				}
//				
//				//判断时间
//				if(!loginKey.IsParamNull(LoginKey.TAG_EXPIREDTIME))
//				{
//					if((new Date()).getTime()>loginKey.getEXPIREDTIME().getTime())
//						strLoginName = "";
//				}
//				
//				int nCnt = loginKey.getLIMITCNT();
//				if(nCnt!=-1)
//				{
//					nCnt--;
//					if(nCnt == 0)
//					{
//						GetLoginKeyDataCtrl().Remove(loginKey);
//					}
//					else
//					{
//						loginKey.setLIMITCNT(nCnt);
//						GetLoginKeyDataCtrl().Save(false,loginKey);
//					}
//				}
//			}
//			
//			if(!StringHelper.IsNullOrEmpty(strLoginName))
//				OnLoginUserName(strLoginName);
//			
//			return;
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//		}
//	}
//
//	
//	protected synchronized IDEDataCtrl GetLoginKeyDataCtrl()
//	{
//		if (loginKeyDataCtrl == null)
//		{
//			loginKeyDataCtrl = this.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_LOINGKEY, SRFDAGlobal.USER_SYSTEM, null);
//		}
//		return loginKeyDataCtrl;
//	}
//
//	/* (non-Javadoc)
//	 * @see SA.SRFDA.UAC.Client.Web.BaseLoginPage#OnLoginUserName(java.lang.String)
//	 */
//	@Override
//	protected CallResult OnLoginUserName(String strLoginName)
//	{
//		SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
//		
//		CallResult callResult = super.OnLoginUserName(strLoginName);
//		actionResult.From(callResult);
//		if(callResult.IsOk())
//		{
//			String strSessionKeys = this.getWebContext().GetParamValue("SESSIONKEYS");
//			OnFillExtLoginInfo(actionResult,strSessionKeys);
//			try
//			{
//				this.getResponse().getWriter().print(actionResult.ToJSONString());
//			}
//			catch (IOException e)
//			{
//				e.printStackTrace();
//			}
//		}
//		return callResult;
//	}
//	
//	protected void OnFillExtLoginInfo(SRFExAjaxActionResult actionResult,String strSessionKeys)
//	{
//		actionResult.setExtInfo("userid",this.getWebContext().getCurUserId());
//		actionResult.setExtInfo("username",this.getWebContext().getCurUserName());
//		actionResult.setExtInfo("usermode",this.getWebContext().getCurUserMode());
//		actionResult.setExtInfo("loginname",this.getWebContext().getCurLoginName());
//		actionResult.setExtInfo("language",this.getWebContext().getLocalization());
//		
//		
//		if(!StringHelper.IsNullOrEmpty(strSessionKeys))
//		{
//			String []items = StringHelper.SplitEx(strSessionKeys);
//			if(items == null)
//			{
//				return;
//			}
//			
//			for(int i=0;i<items.length;i++)
//			{
//				Object objValue = this.getWebContext().GetSessionValue(items[i]);
//				if(objValue == null)
//				{
//					continue;
//				}
//				
//				actionResult.setExtInfo(items[i],objValue.toString());
//			}
//		}
//	}
}
