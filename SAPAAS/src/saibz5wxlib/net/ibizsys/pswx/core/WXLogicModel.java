package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 微信响应逻辑模型
 * 
 * @author Administrator
 * 
 */
public class WXLogicModel extends ModelBaseImpl implements IWXLogicModel {

	private IWXAccountModel iWXAccountModel = null;
	private IWXEntAppModel iWXEntAppModel = null;
	private String strDEName = null;
	private String strDEActionName = null;
	private String strEventType = null;
	private String strWXFunc = null;
	private String strClickTag = null;
	private String strUserTag = null;

	/**
	 * 初始化微信响应逻辑
	 * 
	 * @param iWXAccountModel
	 * @param iWXEntAppModel
	 * @throws Exception
	 */
	public void init(IWXAccountModel iWXAccountModel, IWXEntAppModel iWXEntAppModel) throws Exception {
		this.iWXAccountModel = iWXAccountModel;
		this.iWXEntAppModel = iWXEntAppModel;
		this.onInit();
	}

	@Override
	public IWXAccount getWXAccount() {
		return this.iWXAccountModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getDEName()
	 */
	@Override
	public String getDEName() {
		return strDEName;
	}

	/**
	 * 设置实体名称
	 * 
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getDEActionName()
	 */
	@Override
	public String getDEActionName() {
		return strDEActionName;
	}

	/**
	 * 设置实体行为名称
	 * 
	 * @param strDEActionName
	 */
	public void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getEventType()
	 */
	@Override
	public String getEventType() {
		return strEventType;
	}

	/**
	 * 设置事件类型
	 * 
	 * @param strEventType
	 */
	public void setEventType(String strEventType) {
		this.strEventType = strEventType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getWXFunc()
	 */
	@Override
	public String getWXFunc() {
		return strWXFunc;
	}

	/**
	 * 设置微信功能
	 * 
	 * @param strWXFunc
	 */
	public void setWXFunc(String strWXFunc) {
		this.strWXFunc = strWXFunc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getClickTag()
	 */
	@Override
	public String getClickTag() {
		return strClickTag;
	}

	/**
	 * 设置点击标识
	 * 
	 * @param strClickTag
	 */
	public void setClickTag(String strClickTag) {
		this.strClickTag = strClickTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogicModel#getWXAccountModel()
	 */
	@Override
	public IWXAccountModel getWXAccountModel() {
		return this.iWXAccountModel;
	}

	/**
	 * 设置响应逻辑标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置响应逻辑名称
	 * 
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogicModel#getWXEntAppModel()
	 */
	@Override
	public IWXEntAppModel getWXEntAppModel() {
		return this.iWXEntAppModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getWXEntApp()
	 */
	@Override
	public IWXEntApp getWXEntApp() {
		return this.getWXEntAppModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswx.core.IWXLogic#getUserTag()
	 */
	@Override
	public String getUserTag() {
		return strUserTag;
	}

	/**
	 * 设置用户标记
	 * 
	 * @param strUserTag
	 */
	public void setUserTag(String strUserTag) {
		this.strUserTag = strUserTag;

	}

}
