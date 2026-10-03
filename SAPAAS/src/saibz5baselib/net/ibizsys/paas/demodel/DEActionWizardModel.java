package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDEActionWizardItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.ViewWizard;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 实体操作向导组模型
 * @author Administrator
 *
 */
public class DEActionWizardModel extends ModelBase3Impl implements IDEActionWizardModel{

	private IDataEntityModel iDataEntity = null;
	private ArrayList<IDEActionWizardItem> deActionWizardItemList = new ArrayList<IDEActionWizardItem>();
	private String strKeywords = null;
	private String strWizardUrl = null;
	
	/**
	 * 初始化
	 * @param iDataEntity
	 * @throws Exception
	 */
	public void init(IDataEntity iDataEntity)throws Exception{
		this.iDataEntity = (IDataEntityModel)iDataEntity;
		this.onInit();
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntityObject#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	@Override
	public String getKeywords() {
		return this.strKeywords;
	}

	@Override
	public String getWizardUrl() {
		return this.strWizardUrl;
	}

	/**
	 * 设置关键字
	 * @param strKeywords
	 */
	public void setKeywords(String strKeywords){
		this.strKeywords = strKeywords;
	}
	
	
	/**
	 * 设置向导Url
	 * @param strWizardUrl
	 */
	public void setWizardUrl(String strWizardUrl){
		this.strWizardUrl = strWizardUrl;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizard#getDEActionWizardItems()
	 */
	@Override
	public Iterator<IDEActionWizardItem> getDEActionWizardItems() {
		return this.deActionWizardItemList.iterator();
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEActionWizardModel#registerDEActionWizardItemModel(net.ibizsys.paas.demodel.IDEActionWizardItemModel)
	 */
	@Override
	public void registerDEActionWizardItemModel(IDEActionWizardItemModel iDEActionWizardItemModel) throws Exception {
		this.deActionWizardItemList.add(iDEActionWizardItemModel);
	}

	@Override
	public int fillViewWizards(IViewController iViewController,String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
		
		if(StringHelper.isNullOrEmpty(strQuery)){
			viewWizardList.add(this);
			return 1;
		}
		if(this.getName().indexOf(strQuery)!=-1){
			viewWizardList.add(this);
			return 1;
		}
		
		if(!StringHelper.isNullOrEmpty(this.getKeywords()) && this.getKeywords().indexOf(strQuery)!=-1){
			viewWizardList.add(this);
			return 1;
		}
		return 0;
	}

	@Override
	public JSONObject toJSONObject(boolean bDetailMode) throws Exception {
		JSONObject jsonObject = new JSONObject();
		if(!bDetailMode){
			return ViewWizard.toJSONObject(jsonObject, this);
		}
		else{
			//填充明细
			ArrayList list = new ArrayList();
			for(IDEActionWizardItem iDEActionWizardItem:deActionWizardItemList){
				JSONObject item = new JSONObject();
				item.put("name",JSONObjectHelper.stripQuotes(iDEActionWizardItem.getName(),true));
				item.put("value",JSONObjectHelper.stripQuotes(iDEActionWizardItem.getActionValue(),true));
				item.put("content",JSONObjectHelper.stripQuotes(iDEActionWizardItem.getContent(),true));
				item.put("url",JSONObjectHelper.stripQuotes(iDEActionWizardItem.getMoreUrl(),true));
				list.add(item);
			}
			jsonObject.put("items", JSONArray.fromArray(list.toArray()));
			return jsonObject;
		}
	}

	
	
	
}
