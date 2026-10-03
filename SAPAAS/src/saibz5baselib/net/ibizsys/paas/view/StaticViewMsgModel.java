package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;

/**
 * 视图消息模型基类
 * 
 * @author Administrator
 *
 */
public class StaticViewMsgModel extends ViewMessage implements IStaticViewMsgModel {

	private String strMsgTemplateId = null;
	private String strTitleLanResTag  = null;
	private ISystemModel iSystemModel = null;
	private String strUniqueTag = null;
	private int nOrderValue = 99999999;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMsgModel#fillViewMessages(IViewController,java.util.ArrayList)
	 */
	@Override
	public int fillViewMessages(IViewController iViewController,ArrayList<IViewMsgModel> viewMessageList) throws Exception {
		viewMessageList.add(this);
		return 1;
	}
	
	
	
	@Override
	public String getMsgTemplateId() {
		return strMsgTemplateId;
	}



	/**
	 * 设置消息模板标识
	 * @param strMsgTemplateId
	 */
	public void setMsgTemplateId(String strMsgTemplateId) {
		this.strMsgTemplateId = strMsgTemplateId;
	}

	
	
	@Override
	public String getTitleLanResTag() {
		return strTitleLanResTag;
	}



	/**
	 * 设置标题语言资源标识
	 * @param strTitleLanResTag
	 */
	public void setTitleLanResTagId(String strTitleLanResTag) {
		this.strTitleLanResTag = strTitleLanResTag;
	}



	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.iSystemModel = iSystemModel;
		if(!StringHelper.isNullOrEmpty(this.getUserTag())&&!StringHelper.isNullOrEmpty(this.getUserTag2())){
			strUniqueTag = StringHelper.format("%1$s||%2$s",this.getUserTag(),this.getUserTag2());
		}
		else
			if(!StringHelper.isNullOrEmpty(this.getUserTag())){
				strUniqueTag = this.getUserTag();
			}
			else
				if(!StringHelper.isNullOrEmpty(this.getUserTag2())){
					strUniqueTag = this.getUserTag2();
				}
		this.onInit();
	}



	@Override
	public String getUniqueTag() {
		return strUniqueTag;
	}



	@Override
	public ISystemModel getSystemModel() {
		return this.iSystemModel;
	}



	@Override
	public ISystem getSystem() {
		return getSystemModel();
	}



	@Override
	public int getOrderValue() {
		return nOrderValue;
	}



	/**
	 * 设置消息排序值
	 * @param nOrderValue
	 */
	public void setOrderValue(int nOrderValue) {
		this.nOrderValue = nOrderValue;
	}
	
	

}
