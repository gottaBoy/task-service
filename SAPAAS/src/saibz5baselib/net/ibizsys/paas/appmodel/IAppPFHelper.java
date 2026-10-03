package net.ibizsys.paas.appmodel;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 应用框架辅助对象
 * 
 * @author Administrator
 *
 */
public interface IAppPFHelper {
	
	
	
	/**
	 * 初始化
	 * 
	 * @param iApplicationModel 应用模型
	 */
	void init(IApplicationModel iApplicationModel) throws Exception;

	/**
	 * 获取视图JSON对象
	 * 
	 * @param iAppViewModel 应用视图模型
	 * @return
	 * @throws Exception
	 */
	JSONObject getAppViewJSONObject(IAppViewModel iAppViewModel) throws Exception;

	/**
	 * 映射实际Url
	 * 
	 * @param strUrl /=WEB根;http://=绝对地址;目录=应用根目录，转换应用根目录
	 * @return
	 * @throws Exception
	 */
	String mapRealUrl(String strUrl) throws Exception;

	/**
	 * 映射实际图标Url 默认路径按照放在应用图标目录中进行
	 * 
	 * @param strUrl /=WEB根;http://=绝对地址;目录=应用根目录，转换应用根目录
	 * @return
	 * @throws Exception
	 */
	String mapImageRealUrl(String strImageUrl) throws Exception;
	
	
	/**
	 * 获取应用程序类型，值参考 net.ibizsys.paas.core.IApplication.APPTYPE_XXX 定义
	 * @return
	 */
	int getAppType();
	
	
	/**
	 * 获取视图标识
	 * 
	 * @param iAppViewModel 应用视图模型
	 * @return
	 * @throws Exception
	 */
	String getAppViewTag(IAppViewModel iAppViewModel) throws Exception;
	
	
	
	/**
	 * 获取应用视图路径
	 * @param iAppViewModel
	 * @param params
	 * @return
	 * @throws Exception
	 */
	String getAppViewUrl(IAppViewModel iAppViewModel,Map<String, String> params)throws Exception;
}
