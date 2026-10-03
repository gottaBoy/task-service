package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态表格模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaGridModelBase extends GridModelBase implements IDynaGridModel {

private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaGridModelBase.class);
	
	private IDynaViewControllerInst iDynaViewControllerInst = null;
	private ObjectNode modelJsonObject = null;
	private IGridModel sourceGridModel = null;
	private IDynaGridModel sourceDynaGridModel = null;
	
	@Override
	public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
		this.setEnableDynaCtrl(true);
		super.init(iDynaViewControllerInst);
		if(modelObject!=null){
			if(modelObject instanceof ObjectNode){
				this.loadJsonObject((ObjectNode)modelObject);
			}
		}
		
	}


	@Override
	protected void onInit() throws Exception {
		if(this.getViewController() instanceof IDynaViewControllerInst){
			iDynaViewControllerInst = (IDynaViewControllerInst)this.getViewController();
		}
		super.onInit();
	}

	@Override
	public IDynaViewControllerInst getDynaViewControllerInst() {
		return this.iDynaViewControllerInst;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.IDynaGridModel#getSourceGridModel()
	 */
	@Override
	public IGridModel getSourceGridModel() {
		return this.sourceGridModel;
	}

	/**
	 * 获取源动态表格模型对象
	 * @return
	 */
	public IDynaGridModel getSourceDynaGridModel() {
		return this.sourceDynaGridModel;
	}
	
	@Override
	public void loadJsonObject(ObjectNode jsonObject) throws Exception {
		this.modelJsonObject = jsonObject;
		onLoadJsonObject(jsonObject);
	}
	
	
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		String strName = JsonNodeHelper.getString(jsonObject, ATTR_NAME, null);
		if(StringHelper.isNullOrEmpty(strName)){
			throw new Exception("部件模型中没有指定部件名称");
		}
		this.setName(strName);
		if(!StringHelper.isNullOrEmpty(this.getName()) && getDynaViewControllerInst()!=null){
			IDynaViewController iDynaViewController = this.getDynaViewControllerInst().getDynaViewController();
			ICtrlModel iCtrlModel = iDynaViewController.getCtrlModel(this.getName());
			if(iCtrlModel!=null && (iCtrlModel instanceof IGridModel)){
				this.sourceGridModel = (IGridModel)iCtrlModel;	
				if(this.sourceGridModel instanceof IDynaGridModel){
					this.sourceDynaGridModel = (IDynaGridModel)this.sourceGridModel;
				}
			}
		}
	}
	

	@Override
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		
		DynaCtrlModelBase.fillJsonObject(this,jo);
		onFillJsonObject(jo);
		return jo;
	}
	
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		
	}

	
}
