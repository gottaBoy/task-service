package net.ibizsys.paas.appmodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;

/**
 * 应用程序模型对象实现基类
 * 
 * @author lionlau
 */
public abstract class AppModelBase extends AppModelBaseBase implements ApplicationListener<ContextRefreshedEvent>,IApplicationRuntime{



	private static final Log log = LogFactory.getLog(AppModelBase.class);
	
	
	/**
	 * 应用模式对象Map
	 */
	private HashMap<String, IAppModeModel> appModeModelMap = new HashMap<String, IAppModeModel>(); 
	
	private String strApplicationUrl = null;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	}

	/**
	 * 准备应用模式
	 * 
	 * @throws Exception
	 */
	protected void prepareAppModes() throws Exception {
	}
	
	
	/**
	 * 注册应用模式模型对象
	 * @param iAppModeModel
	 * @throws Exception
	 */
	protected void registerAppModeModel(IAppModeModel iAppModeModel) throws Exception {
		this.appModeModelMap.put(iAppModeModel.getMode(),iAppModeModel);
	}
	
	
	/**
	 * 创建应用程序模式模型对象
	 * @param strMode
	 * @return
	 * @throws Exception
	 */
	protected IAppModeModel createAppModeModel(String strMode)throws Exception{
		return null;
	}

	
	/**
	 * 获取应用模型模型对象
	 * @return
	 */
	protected IAppModeModel getAppModeModel(){
		if(WebContext.getCurrent()!=null){
			String strAppMode = WebContext.getAppMode(WebContext.getCurrent());
			return appModeModelMap.get(strAppMode);
		}
		return null;
	}
	
	
	
	@Override
	public IAppPFHelper getAppPFHelper() {
		IAppModeModel iAppModeModel =  getAppModeModel();
		if(iAppModeModel!=null){
			return iAppModeModel.getAppPFHelper();
		}
		return super.getAppPFHelper();
	}
	
	
	@Override
	public ICtrlRender getCtrlRender(String strCtrlType, String strRender) {
		IAppModeModel iAppModeModel =  getAppModeModel();
		if(iAppModeModel!=null){
			return iAppModeModel.getCtrlRender(strCtrlType, strRender);
		}
		return super.getCtrlRender(strCtrlType, strRender);
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationRuntime#getApplicationUrl()
	 */
	@Override
	public String getApplicationUrl() {
		
		if(this.strApplicationUrl == null) {
			String strUrlTag = WebConfig.APPURL+this.getName().toUpperCase();
			this.strApplicationUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
			if(StringHelper.isNullOrEmpty(this.strApplicationUrl) && this.getAppPFHelper()!=null) {
				if(this.getAppPFHelper().getAppType() == IApplication.APPTYPE_MOBILE) {
					this.strApplicationUrl = WebConfig.getCurrent().getDefaultMobAppUrl();
				}
				else {
					this.strApplicationUrl = WebConfig.getCurrent().getDefaultWebAppUrl();
				}
			}
		}
		return this.strApplicationUrl;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationRuntime#getHtmlUrl(java.lang.String)
	 */
	@Override
	public String getHtmlUrl(String strTag) {
		String strUrlTag = WebConfig.HTMLURL+this.getName().toUpperCase()+"_"+strTag;
		String strHtmlUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
		if(StringHelper.isNullOrEmpty(strHtmlUrl)) {
			strUrlTag = WebConfig.HTMLURL+strTag;
			strHtmlUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
		}
		return strHtmlUrl;
	}

}
