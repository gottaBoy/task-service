package net.ibizsys.paas.sysmodel;

/**
 * 用户范围的代码表集合对象
 * 
 * @author lionlau
 *
 */
public abstract class UserScopeDynamicCodeListModelBase extends DynamicCodeListModelBase implements IUserCodeListModel {
	private String strUserId = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IUserCodeListModel#setCurUserId(java.lang.String)
	 */
	@Override
	public void setCurUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IUserCodeListModel#getCurUserId()
	 */
	@Override
	public String getCurUserId() {
		return this.strUserId;
	}

}
