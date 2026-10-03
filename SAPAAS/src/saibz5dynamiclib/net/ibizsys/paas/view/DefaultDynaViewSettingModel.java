package net.ibizsys.paas.view;

import java.util.HashMap;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.controller.DefaultDynaGridViewControllerInst;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaSearchFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.ctrlmodel.form.DefaultDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DefaultDynaToolbarModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.pswf.controller.DefaultDynaMobWFEditViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFEditViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFExpViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFGridViewControllerInst;

/**
 * 默认的动态视图设置模型对象
 * @author Administrator
 *
 */
public class DefaultDynaViewSettingModel extends DynaViewSettingModelBase {

	private HashMap<String, String> dynaViewControllerInstMap = new HashMap<String, String>();
	private HashMap<String, String> dynaCtrlModelMap = new HashMap<String, String>();
	private HashMap<String, String> dynaCtrlHandlerMap = new HashMap<String, String>();
	
	public DefaultDynaViewSettingModel(){
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEWFEDITVIEW, DefaultDynaWFEditViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEWFEDITVIEW2, DefaultDynaWFEditViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEWFEDITVIEW3, DefaultDynaWFEditViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEWFEXPVIEW, DefaultDynaWFExpViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEMOBWFEDITVIEW, DefaultDynaMobWFEditViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEMOBWFEDITVIEW3, DefaultDynaMobWFEditViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEWFGRIDVIEW, DefaultDynaWFGridViewControllerInst.class.getName());
		dynaViewControllerInstMap.put(DynaViewTypeCodeListModel.DEGRIDVIEW, DefaultDynaGridViewControllerInst.class.getName());
		
		dynaCtrlModelMap.put(ControlTypes.EditForm, DefaultDynaEditFormModel.class.getName());
		dynaCtrlModelMap.put(ControlTypes.Toolbar, DefaultDynaToolbarModel.class.getName());
		
		
	}
	
	
	@Override
	protected void onInit() throws Exception {
		
		super.onInit();
	}
	
	@Override
	public IDynaToolbarModel createDynaToolbarModel() {
		return new DefaultDynaToolbarModel();
	}

	@Override
	public IDynaEditFormModel createDynaEditFormModel() {
		return new DefaultDynaEditFormModel();				
	}

	@Override
	public IDynaSearchFormModel createDynaSearchFormModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IDynaViewControllerInst createDynaViewControllerInst(DSDynaViewInst dsDynaViewInst) throws Exception {
		String strViewInstObj = dsDynaViewInst.getViewInstObj();
		if(StringHelper.isNullOrEmpty(strViewInstObj)){
			strViewInstObj = dynaViewControllerInstMap.get(dsDynaViewInst.getViewType());
		}
		if(!StringHelper.isNullOrEmpty(strViewInstObj)){
			Object objViewInst = ObjectHelper.create(strViewInstObj);
			if(objViewInst == null){
				throw new Exception(StringHelper.format("无法创建对象[%1$s]",strViewInstObj));
			}
			if(!(objViewInst instanceof IDynaViewControllerInst)){
				throw new Exception(StringHelper.format("对象[%1$s]类型不正确",strViewInstObj));
			}
			return (IDynaViewControllerInst)objViewInst;
		}
		return super.createDynaViewControllerInst(dsDynaViewInst);
	}

	@Override
	public IDynaCtrlModel createDynaCtrlModel(String strCtrlType, Object ctrlParam) throws Exception {
		String strCtrlModelObj = dynaCtrlModelMap.get(strCtrlType);
		if(StringHelper.isNullOrEmpty(strCtrlModelObj))
			return null;
		Object objCtrlModel = ObjectHelper.create(strCtrlModelObj);
		if(objCtrlModel == null){
			throw new Exception(StringHelper.format("无法创建对象[%1$s]",strCtrlModelObj));
		}
		if(!(objCtrlModel instanceof IDynaCtrlModel)){
			throw new Exception(StringHelper.format("对象[%1$s]类型不正确",strCtrlModelObj));
		}	
		return (IDynaCtrlModel)objCtrlModel;
	}

	@Override
	public IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel iDynaCtrlModel) throws Exception {
		String strCtrlHandlerObj = dynaCtrlHandlerMap.get(iDynaCtrlModel.getControlType());
		if(StringHelper.isNullOrEmpty(strCtrlHandlerObj))
			return null;
		Object objCtrlHandler = ObjectHelper.create(strCtrlHandlerObj);
		if(objCtrlHandler == null){
			throw new Exception(StringHelper.format("无法创建对象[%1$s]",strCtrlHandlerObj));
		}
		if(!(objCtrlHandler instanceof IDynaCtrlHandler)){
			throw new Exception(StringHelper.format("对象[%1$s]类型不正确",strCtrlHandlerObj));
		}	
		return (IDynaCtrlHandler)objCtrlHandler;
	}

	
	
	
}
