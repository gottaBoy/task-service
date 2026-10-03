package net.ibizsys.paas.appmodel;

import java.util.Map;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 应用框架辅助对象
 * 
 * @author Administrator
 *
 */
public abstract class AppPFHelperBase implements IAppPFHelper {
	

	private IApplicationModel iApplicationModel = null;
	private String strImagesPath = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IAppPFHelper#init(net.ibizsys.paas.appmodel.IApplicationModel)
	 */
	@Override
	public void init(IApplicationModel iApplicationModel) throws Exception {
		this.iApplicationModel = iApplicationModel;
	}

	/**
	 * 获取应用程序模型
	 * 
	 * @return
	 */
	public IApplicationModel getAppModel() {
		return this.iApplicationModel;
	}

	/**
	 * 设置应用图标放置路径
	 * 
	 * @param strImagesPath
	 */
	public void setImagesPath(String strImagesPath) {
		this.strImagesPath = strImagesPath;
	}

	/**
	 * 获取应用图标放置路径
	 * 
	 * @return
	 */
	public String getImagesPath() {
		return this.strImagesPath;
	}

	/**
	 * 获取应用视图的JSON对象
	 * 
	 * @param iAppViewModel 应用视图模型对象
	 * @return
	 */
	public JSONObject getAppViewJSONObject(IAppViewModel iAppViewModel) throws Exception {
		JSONObject jsonObj = new JSONObject();
		onFillAppViewJSONObject(iAppViewModel, jsonObj);
		return jsonObj;
	}

	/**
	 * 填充应用视图JSONObject对象
	 * 
	 * @param iAppViewModel 应用视图模型对象
	 * @param jsonObj 填充的JSON对象
	 * @throws Exception
	 */
	protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IAppPFHelper#mapRealUrl(java.lang.String)
	 */

	/**
	 * 映射实际Url
	 * <p>
	 * 空字符串或者以 / ../ 开头的直接返回，绝对路径直接返回
	 * <p>
	 * 其他情况返回 {@link net.ibizsys.paas.appmodel.AppPFHelperBase#mapRealAppUrl(java.lang.String)}
	 * 
	 * @param strUrl 地址
	 * @return
	 * @throws Exception
	 */
	@Override
	public String mapRealUrl(String strUrl) throws Exception {
		if (StringHelper.isNullOrEmpty(strUrl)) {
			return strUrl;
		}

		// 当前绝对地址
		if ((strUrl.indexOf('/') == 0) || (strUrl.indexOf("../") == 0) || (strUrl.indexOf("://") != -1)) {
			return strUrl;
		}

		return mapRealAppUrl(strUrl);

	}

	/**
	 * 映射实际的应用路径
	 * 
	 * @param strUrl
	 * @return
	 * @throws Exception
	 */
	protected abstract String mapRealAppUrl(String strUrl) throws Exception;

	/**
	 * 映射图片实际Url
	 * <p>
	 * 空字符串或者以 / ../ 开头的直接返回，绝对路径直接返回
	 * <p>
	 * 其他情况返回'默认图片路径'下的位置 {@link net.ibizsys.paas.appmodel.AppPFHelperBase#mapRealAppUrl(java.lang.String)}
	 * 
	 * @param strUrl 地址
	 * @return
	 * @throws Exception
	 */
	@Override
	public String mapImageRealUrl(String strImageUrl) throws Exception {
		if (StringHelper.isNullOrEmpty(strImageUrl)) {
			return strImageUrl;
		}

		// 当前绝对地址
		if ((strImageUrl.indexOf('/') == 0) || (strImageUrl.indexOf("../") == 0) || (strImageUrl.indexOf("://") != -1)) {
			return strImageUrl;
		}

		return mapRealAppUrl(this.getImagesPath() + strImageUrl);

	}

	@Override
	public int getAppType() {
		return IApplication.APPTYPE_UNKNOWN;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IAppPFHelper#getAppViewUrl(net.ibizsys.paas.appmodel.IAppViewModel, java.util.Map)
	 */
	@Override
	public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
		throw new Exception("没有实现");
	}

}
