package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;

/**
 * 实体操作向导组模型
 * @author Administrator
 *
 */
public class DEActionWizardGroupModel extends ModelBase3Impl implements IDEActionWizardGroupModel{

	private IDataEntityModel iDataEntity = null;
	private ArrayList<IDEActionWizard> deActionWizardList = new ArrayList<IDEActionWizard>();
	private ArrayList<IViewWizard> viewWizardList = new ArrayList<IViewWizard>();
	
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


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEActionWizardGroup#getDEActionWizards()
	 */
	@Override
	public Iterator<IDEActionWizard> getDEActionWizards() {
		return this.deActionWizardList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IViewWizardGroup#getViewWizards()
	 */
	@Override
	public Iterator<IViewWizard> getViewWizards() {
		return this.viewWizardList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEActionWizardGroupModel#registerDEActionWizardModel(net.ibizsys.paas.demodel.IDEActionWizardModel)
	 */
	@Override
	public void registerDEActionWizardModel(IDEActionWizardModel iDEActionWizardModel) throws Exception {
		this.deActionWizardList.add(iDEActionWizardModel);
		this.viewWizardList.add(iDEActionWizardModel);
	}

	@Override
	public void fillViewWizards(IViewController iViewController,String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
		for(IDEActionWizard iDEActionWizard:deActionWizardList){
			((IDEActionWizardModel)iDEActionWizard).fillViewWizards(iViewController,strQuery, viewWizardList);
		}
	}

	@Override
	public IViewWizard getViewWizard(String strViewWizardId) throws Exception {
		for(IDEActionWizard iDEActionWizard:deActionWizardList){
			if(StringHelper.compare(iDEActionWizard.getId(),strViewWizardId,false)==0)
				return iDEActionWizard;
		}
		throw new Exception(StringHelper.format("无法获取指定实体操作向导，标识为[%1$s]",strViewWizardId));
	}

	
	
	
	

}
