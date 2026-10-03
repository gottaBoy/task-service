package net.ibizsys.paas.web.util;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.util.StringHelper;

/**
 * 远程注销Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class LogoutServlet extends HttpRedirectServlet {
	private static final long serialVersionUID = 7486761561445169301L;

	private static final Log log = LogFactory.getLog(LogoutServlet.class);
	
	private String strDefalutURL = "/index.html";
	private String strApplicationId = "";
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.strApplicationId = this.getInitParameter("APPLICATIONID");
	}

	@Override
	protected String getRedirectUrl() {
		//获取默认重定向路径
		String strUrl = super.getRedirectUrl();
		if(StringHelper.isNullOrEmpty(strUrl))
			strUrl = this.strDefalutURL;
		
		try {
			// 执行登出
			this.getWebContext().logout(true);
			
			//获取注销重定向路径
			if(!StringHelper.isNullOrEmpty(this.strApplicationId)){
				IApplicationModel appModel = this.getApplicationModel();
				strUrl = StringHelper.format("/%1$s%2$s", appModel.getName().toLowerCase(), appModel.getUtilPageUrl(IApplicationModel.UTILPAGE_LOGIN));
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("获取注销重定向地址错误：%1$s",ex.getMessage()));
		}

		return strUrl;
	}
	

	/**
	 * 获取当前应用程序
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IApplicationModel getApplicationModel() throws Exception {
		if(StringHelper.isNullOrEmpty(this.strApplicationId)){
			return (IApplicationModel) AppModelGlobal.getDefaultApplication();
		}else{
			return (IApplicationModel) AppModelGlobal.getApplication(this.strApplicationId);
		}
	}
	
}
