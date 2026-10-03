package net.ibizsys.ssdyna.ctrlmodel;


import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditForm;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 动态编辑表单模型对象基类
 * @author Administrator
 *
 */
public abstract class EditFormModelBase extends net.ibizsys.paas.ctrlmodel.EditFormModelBase  implements IDynaCtrlModel{

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(EditFormModelBase.class);
	private IDynaViewModel iDynaViewModel = null;
	private IPSDEEditForm iPSDEEditForm = null; 
	
	
	@Override
	public void init(IViewController iViewController) throws Exception {
		if(iViewController instanceof IDynaViewModel){
			iDynaViewModel = (IDynaViewModel)iViewController;
			IPSControl iPSControl = null;
			if(iDynaViewModel.getPSAppView().hasPSControl(this.getName())){
				iPSControl = iDynaViewModel.getPSAppView().getPSControl(this.getName());
				if(!(iPSControl instanceof IPSDEEditForm)){
					iPSControl = null;
				}
			}
			
			if(iPSDEEditForm == null){
				log.error(StringHelper.format("无法从视图[%1$s][%2$s]获取表单对象[%3$s]",iViewController.getId(),((IDynaViewModel) iViewController).getName(),this.getName()));
			}
		}
		
		super.init(iViewController);
	}

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iDynaViewModel = iDynaViewModel;
		this.iPSDEEditForm = (IPSDEEditForm)iPSControl;
		super.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return iPSDEEditForm;
	}
	
	
	@Override
	protected void prepareCtrlModel() throws Exception {
		if(this.getPSControl()!=null && this.getPSControl().isDynamicCtrl()){
			//注册动态模型
			return;
		}
		super.prepareCtrlModel();
	}
	
	/**
	 * 获取实体表单对象
	 * @return
	 */
	public IPSDEEditForm getPSDEEditForm(){
		return this.iPSDEEditForm;
	}
	
	
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
	
	protected boolean isOutputDynaViewContent(){
		return true;
	}
}
