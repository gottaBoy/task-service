package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 界面行为模型对象基类
 * @author Administrator
 *
 */
public abstract class UIActionModelBase extends ModelBase3Impl implements IUIActionModel {

	private String strUIActionTag = null;
	private String strUIActionType = null;
	private String strUIActionMode = null;
	private String strCaption = null;
	private String strTooltip = null;
	private String strCapLanResTag = null;
	private String strTooltipLanResTag = null;
	private String strActionTarget = null;
	private String strIconCls = null;
	private String strIconPath = null;
	private String strIconClsX = null;
	private String strIconPathX = null;
	private boolean bEnableRuntimeModel = false;
	private boolean bClosePopupView = false; 
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getUIActionTag()
	 */
	@Override
	public String getUIActionTag() {
		return this.strUIActionTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getUIActionType()
	 */
	@Override
	public String getUIActionType() {
		return this.strUIActionType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getUIActionMode()
	 */
	@Override
	public String getUIActionMode() {
		return this.strUIActionMode;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getCaption()
	 */
	@Override
	public String getCaption() {
		return this.strCaption;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getTooltip()
	 */
	@Override
	public String getTooltip() {
		return this.strTooltip;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getCapLanResTag()
	 */
	@Override
	public String getCapLanResTag() {
		return this.strCapLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getTooltipLanResTag()
	 */
	@Override
	public String getTooltipLanResTag() {
		return this.strTooltipLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getActionTarget()
	 */
	@Override
	public String getActionTarget() {
		return this.strActionTarget;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return this.strIconCls;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getIconPath()
	 */
	@Override
	public String getIconPath() {
		return this.strIconPath;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getIconClsX()
	 */
	@Override
	public String getIconClsX() {
		return this.strIconClsX;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#getIconPathX()
	 */
	@Override
	public String getIconPathX() {
		return this.strIconPathX;
	}

	/**
	 * 设置界面行为标记
	 * @param strUIActionTag
	 */
	public void setUIActionTag(String strUIActionTag) {
		this.strUIActionTag = strUIActionTag;
	}

	/**
	 * 设置界面行为类型
	 * @param strUIActionType
	 */
	public void setUIActionType(String strUIActionType) {
		this.strUIActionType = strUIActionType;
	}

	/**
	 * 设置界面行为模式
	 * @param strUIActionMode
	 */
	public void setUIActionMode(String strUIActionMode) {
		this.strUIActionMode = strUIActionMode;
	}

	/**
	 * 设置标题
	 * @param strCaption
	 */
	public void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}

	/**
	 * 设置工具提示
	 * @param strTooltip
	 */
	public void setTooltip(String strTooltip) {
		this.strTooltip = strTooltip;
	}

	/**
	 * 设置标题语言资源标记
	 * @param strCapLanResTag
	 */
	public void setCapLanResTag(String strCapLanResTag) {
		this.strCapLanResTag = strCapLanResTag;
	}

	/**
	 * 设置工具提示语言资源标记
	 * @param strTooltipLanResTag
	 */
	public void setTooltipLanResTag(String strTooltipLanResTag) {
		this.strTooltipLanResTag = strTooltipLanResTag;
	}

	/**
	 * 设置操作模板
	 * @param strActionTarget
	 */
	public void setActionTarget(String strActionTarget) {
		this.strActionTarget = strActionTarget;
	}

	/**
	 * 设置图标样式
	 * @param strIconCls
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/**
	 * 设置图标路径
	 * @param strIconPath
	 */
	public void setIconPath(String strIconPath) {
		this.strIconPath = strIconPath;
	}

	/**
	 * 设置图标样式（X）
	 * @param strIconClsX
	 */
	public void setIconClsX(String strIconClsX) {
		this.strIconClsX = strIconClsX;
	}

	/**
	 * 设置图标路径（X）
	 * @param strIconPathX
	 */
	public void setIconPathX(String strIconPathX) {
		this.strIconPathX = strIconPathX;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#isEnableRuntimeModel()
	 */
	@Override
	public boolean isEnableRuntimeModel() {
		return this.bEnableRuntimeModel;
	}
	
	/**
	 * 设置是否启用运行模型
	 * @param bEnableRuntimeModel
	 */
	public void setEnableRuntimeModel(boolean bEnableRuntimeModel){
		this.bEnableRuntimeModel = bEnableRuntimeModel;
	}

	@Override
	public boolean isClosePopupView() {
		return this.bClosePopupView;
	}
	
	/**
	 * 设置行为结束后是否关闭弹出视图
	 * @param bClosePopupView
	 */
	public void setClosePopupView(boolean bClosePopupView){
		this.bClosePopupView = bClosePopupView;
	}

	
	
}
