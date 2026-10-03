package net.ibizsys.paas.appmodel;


/**
 * 应用程序模式模型对象接口
 * @author Administrator
 *
 */
public interface IAppModeModel extends IApplicationModel {

	/**
	 * 初始化
	 * @param iApplicationModel
	 * @throws Exception
	 */
	void init(IApplicationModel iApplicationModel)throws Exception;
	
	
	/**
	 * 获取应用程序模型对象
	 * @return
	 */
	IApplicationModel getAppModel();
	
	/**
	 * 获取模式标记
	 * @return
	 */
	String getMode();
	
}
