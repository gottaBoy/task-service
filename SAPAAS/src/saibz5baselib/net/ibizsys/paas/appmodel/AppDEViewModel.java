package net.ibizsys.paas.appmodel;

/**
 * 实体应用视图模型
 * 
 * @author Administrator
 *
 */
public class AppDEViewModel extends AppViewModel implements IAppDEViewModel {
	private String strDEViewId = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IAppDEViewModel#getDEViewId()
	 */
	@Override
	public String getDEViewId() {
		return this.strDEViewId;
	}

	/**
	 * 设置实体视图标识
	 * 
	 * @param strDEViewId
	 */
	public void setDEViewId(String strDEViewId) {
		this.strDEViewId = strDEViewId;
	}

}
