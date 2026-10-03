package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 视图信息对象
 * 
 * @author Administrator
 *
 */
public class ViewMessage extends ModelBase2Impl implements IViewMessage {

	/**
	 * 标题
	 */
	public final static String TITLE = "title";

	/**
	 * 位置
	 */
	public final static String POS = "pos";

	/**
	 * 类型
	 */
	public final static String TYPE = "type";

	/**
	 * 消息
	 */
	public final static String MESSAGE = "msg";
	
	
	/**
	 * 消息是否支持删除
	 */
	public final static String REMOVE = "remove";
	

	private String strPosition = null;

	private String strMessage = null;

	private String strMessageType = null;

	private String strTitle = null;
	
	private boolean bEnableRemove = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMessage#getPosition()
	 */
	@Override
	public String getPosition() {
		return this.strPosition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMessage#getMessage()
	 */
	@Override
	public String getMessage() {
		return this.strMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMessage#getMessageType()
	 */
	@Override
	public String getMessageType() {
		return this.strMessageType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMessage#getTitle()
	 */
	@Override
	public String getTitle() {
		return this.strTitle;
	}

	/**
	 * 设置显示位置
	 * 
	 * @param strPosition
	 */
	public void setPosition(String strPosition) {
		this.strPosition = strPosition;
	}

	/**
	 * 设置消息内容
	 * 
	 * @param strMessage
	 */
	public void setMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	/**
	 * 设置消息类型
	 * 
	 * @param strMessageType
	 */
	public void setMessageType(String strMessageType) {
		this.strMessageType = strMessageType;
	}

	/**
	 * 设置消息标题
	 * 
	 * @param strTitle
	 */
	public void setTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	@Override
	public boolean isEnableRemove() {
		return bEnableRemove;
	}

	
	/**
	 * 设置是否支持删除
	 * @param bEnableRemove
	 */
	public void setEnableRemove(boolean bEnableRemove){
		this.bEnableRemove = 	bEnableRemove;
	}
	
	/**
	 * 导出JSON对象
	 * 
	 * @param jsonObject
	 * @param iViewMessage
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(JSONObject jsonObject, IViewMessage iViewMessage) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();

		jsonObject.put(TITLE, JSONObjectHelper.stripQuotes(iViewMessage.getTitle(),true));
		jsonObject.put(POS, JSONObjectHelper.stripQuotes(iViewMessage.getPosition(),true));
		jsonObject.put(TYPE, JSONObjectHelper.stripQuotes(iViewMessage.getMessageType(),true));
		jsonObject.put(MESSAGE, JSONObjectHelper.stripQuotes(iViewMessage.getMessage(),true));
		jsonObject.put(REMOVE, iViewMessage.isEnableRemove());
		return jsonObject;
	}

	
	
	
	
}
