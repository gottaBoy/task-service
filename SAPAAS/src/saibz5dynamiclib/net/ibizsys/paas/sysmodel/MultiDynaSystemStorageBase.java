package net.ibizsys.paas.sysmodel;

import java.util.HashMap;

import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 多动态系统存储对象基类
 * @author Administrator
 *
 */
public class MultiDynaSystemStorageBase extends ModelBase3Impl implements IDynaSystemStorage {

	private HashMap<String,IDynaSystemStorage> dynaSystemStorageMap = new HashMap<String,IDynaSystemStorage>();
	private IDynaSystemSetting iDynaSystemSetting = null;
	
	@Override
	public void init(IDynaSystemSetting iDynaSystemSetting) throws Exception {
		this.iDynaSystemSetting = iDynaSystemSetting;
	}

	@Override
	public IDynaSystemSetting getDynaSystemSetting() {
		return this.iDynaSystemSetting;
	}

	@Override
	public void installAll() throws Exception {
		
	}

	@Override
	public void installAllWorkflows() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installAllCodeLists() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncAllViews() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncAllWorkflows() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncAllCodeLists() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncView(String strViewId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncWorkflow(String strWorkflowId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncCodeList(String strCodeListId) throws Exception {
		// TODO Auto-generated method stub
	}

}
