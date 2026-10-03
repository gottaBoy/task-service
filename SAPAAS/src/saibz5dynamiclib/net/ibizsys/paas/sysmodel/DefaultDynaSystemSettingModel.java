package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.view.DefaultDynaViewSettingModel;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import net.ibizsys.pswf.core.DefaultDynaWFSettingModel;
import net.ibizsys.pswf.core.IDynaWFSetting;
import net.ibizsys.pswf.core.IDynaWFSettingModel;

/**
 * 默认动态系统设置模型对象
 * @author Administrator
 *
 */
public class DefaultDynaSystemSettingModel extends DynaSystemSettingModelBase {

	private IDynaWFSettingModel iDynaWFSettingModel = null;
	private IDynaViewSettingModel iDynaViewSettingModel =  null;
	private IDynaSystemStorage  iDynaSystemStorage = null;
	
	public DefaultDynaSystemSettingModel(){
		
	}
	
	@Override
	protected void onInit() throws Exception {
		this.iDynaSystemStorage = createDynaSystemStorage();
		this.iDynaViewSettingModel = createDynaViewSettingModel();
		this.iDynaWFSettingModel = createDynaWFSettingModel();
		this.iDynaSystemStorage.init(this);
		this.iDynaViewSettingModel.init(this);
		this.iDynaWFSettingModel.init(this);
		super.onInit();
	}
	
	
	
	@Override
	protected IDynaSystemStorage getDynaSystemStorage() throws Exception {
		return this.iDynaSystemStorage;
	}

	@Override
	public IDynaViewSetting getDynaViewSetting() {
		return this.iDynaViewSettingModel;
	}
	


	@Override
	public IDynaWFSetting getDynaWFSetting() {
		return this.iDynaWFSettingModel;
	}
	
	/**
	 * 创建动态系统存储模型
	 * @return
	 */
	protected IDynaSystemStorage createDynaSystemStorage(){
		return new DefaultDynaSystemStorage();
	}
	
	/**
	 * 创建动态视图设置模型
	 * @return
	 */
	protected IDynaViewSettingModel createDynaViewSettingModel(){
		return new DefaultDynaViewSettingModel();
	}

	/**
	 * 创建动态工作流设置模型
	 * @return
	 */
	protected IDynaWFSettingModel createDynaWFSettingModel(){
		return new DefaultDynaWFSettingModel();
	}

}
