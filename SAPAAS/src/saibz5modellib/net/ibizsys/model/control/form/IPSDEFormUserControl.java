package net.ibizsys.model.control.form;



/**
 * 表单用户自定义部件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormUserControl extends IPSDEFormDetail
{
	/**
	 * 获取直接内容
	 * @return
	 */
	String getRawContent();
	
	
//	/**
//	 * 获取绘制插件对象
//	 * @return
//	 */
//	IPSSysPFPlugin getRenderPSSysPFPlugin();
}
