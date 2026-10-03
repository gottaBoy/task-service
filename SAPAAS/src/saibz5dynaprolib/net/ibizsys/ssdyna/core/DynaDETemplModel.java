package net.ibizsys.ssdyna.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.StringHelper;

/**
 * 动态实体模板模型对象实现
 * @author Administrator
 *
 */
public class DynaDETemplModel extends ModelBase2Impl implements IDynaDETemplModel {

	private HashMap<String,IDynaDEViewTemplModel> dynaDEViewTemplModelMap = new HashMap<String,IDynaDEViewTemplModel>();
	private ArrayList<IDynaDEViewTemplModel> dynaDEViewTemplModelList = new ArrayList<IDynaDEViewTemplModel>();
	
	
	private HashMap<String,IDynaDEFormTemplModel> dynaDEFormTemplModelMap = new HashMap<String,IDynaDEFormTemplModel>();
	private ArrayList<IDynaDEFormTemplModel> dynaDEFormTemplModelList = new ArrayList<IDynaDEFormTemplModel>();
	
	
	
	private String strTemplDEId = null;
	private String strTemplDEName = null;

	/**
	 * 设置动态实体模板标识
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}
	
	/**
	 * 设置动态实体模板名称
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}
	
	public void setTemplDEId(String strTemplDEId) {
		this.strTemplDEId = strTemplDEId;
	}

	public void setTemplDEName(String strTemplDEName) {
		this.strTemplDEName = strTemplDEName;
	}

	
	@Override
	public String getTemplDEId() {
		return strTemplDEId;
	}

	@Override
	public String getTemplDEName() {
		return strTemplDEName;
	}


	@Override
	public void registerDynaDEViewTemplModel(IDynaDEViewTemplModel iDynaDEViewTemplModel) throws Exception {
		this.dynaDEViewTemplModelMap.put(iDynaDEViewTemplModel.getId(),iDynaDEViewTemplModel);
		this.dynaDEViewTemplModelList.add(iDynaDEViewTemplModel);
	}

	
	@Override
	public IDynaDEViewTemplModel getDynaDEViewTemplModel(String strDynaDEViewTemplModelId) throws Exception {
		IDynaDEViewTemplModel iDynaDEViewTemplModel = this.dynaDEViewTemplModelMap.get(strDynaDEViewTemplModelId);
		if(iDynaDEViewTemplModel == null) {
			throw new Exception(StringHelper.format("无法获取指定动态实体视图模板对象[%1$s]",strDynaDEViewTemplModelId));
		}
		return iDynaDEViewTemplModel;
	}



	@Override
	public Iterator<IDynaDEViewTemplModel> getDynaDEViewTemplModels() {
		return this.dynaDEViewTemplModelList.iterator();
	}

	
	@Override
	public void registerDynaDEFormTemplModel(IDynaDEFormTemplModel iDynaDEFormTemplModel) throws Exception {
		this.dynaDEFormTemplModelMap.put(iDynaDEFormTemplModel.getId(),iDynaDEFormTemplModel);
		this.dynaDEFormTemplModelList.add(iDynaDEFormTemplModel);
	}

	
	@Override
	public IDynaDEFormTemplModel getDynaDEFormTemplModel(String strDynaDEFormTemplModelId) throws Exception {
		IDynaDEFormTemplModel iDynaDEFormTemplModel = this.dynaDEFormTemplModelMap.get(strDynaDEFormTemplModelId);
		if(iDynaDEFormTemplModel == null) {
			throw new Exception(StringHelper.format("无法获取指定动态实体表单模板对象[%1$s]",strDynaDEFormTemplModelId));
		}
		return iDynaDEFormTemplModel;
	}



	@Override
	public Iterator<IDynaDEFormTemplModel> getDynaDEFormTemplModels() {
		return this.dynaDEFormTemplModelList.iterator();
	}

	
}
