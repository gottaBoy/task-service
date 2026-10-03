package net.ibizsys.paas.sysmodel;

/**
 * 系统设置模型对象接口实现
 * @author Administrator
 *
 */
public class SystemSettingModel implements ISystemSettingModel {

	private boolean bEnableDBValueInsertUpdateMode = false;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.ISystemSetting#isEnableDBValueInsertUpdateMode()
	 */
	@Override
	public boolean isEnableDBValueInsertUpdateMode() {
		return this.bEnableDBValueInsertUpdateMode;
	}
	
	
	/**
	 * 设置是否启用属性数据库值新建更新模式，取代原来的值函数模式
	 * @param bEnableDBValueInsertUpdateMode
	 */
	public void setEnableDBValueInsertUpdateMode(boolean bEnableDBValueInsertUpdateMode){
		this.bEnableDBValueInsertUpdateMode = bEnableDBValueInsertUpdateMode;
	}

}
