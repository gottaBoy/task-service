package net.ibizsys.psuac.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.web.Page;

/**
 * 注销页面
 * 
 * @author Administrator
 * 
 */
public class LogoutPage extends Page
{
	private static final Log log = LogFactory.getLog(LogoutPage.class);
	protected String strServerPath = "";

	public LogoutPage()
	{
		
	}
	
	@Override
	protected void onInit() throws Exception
	{
		super.onInit();
		
		try
		{
			this.getWebContext().logout(true);
			this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
			return;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
