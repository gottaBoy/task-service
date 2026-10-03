package net.ibizsys.paas.view;


/**
 * 默认动态界面行为对象实现
 * @author Administrator
 *
 */
public class DefaultDynaFrontUIActionModel extends DynaUIActionModelBase implements IDynaFrontUIActionModel{

	private String strFrontProcessType = null;
	private String strFrontViewId = null;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDynaFrontUIAction#getFrontProcessType()
	 */
	@Override
	public String getFrontProcessType() {
		return this.strFrontProcessType;
	}
	
	/**
	 * 设置前端处理类型
	 * @param strFrontProcessType
	 */
	public void setFrontProcessType(String strFrontProcessType){
		this.strFrontProcessType = strFrontProcessType;
	}
	
	
	@Override
	public String getFrontViewId() {
		return this.strFrontViewId;
	}

	
	/**
	 * 设置前端视图标识
	 * @param strFrontViewId
	 */
	public void setFrontViewId(String strFrontViewId){
		this.strFrontViewId = strFrontViewId;
	}

}
