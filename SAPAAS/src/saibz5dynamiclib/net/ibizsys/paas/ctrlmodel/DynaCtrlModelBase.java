package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态部件模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaCtrlModelBase extends CtrlModelBase implements IDynaCtrlModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	private IDynaViewControllerInst iDynaViewControllerInst = null;
	private ObjectNode modelJsonObject = null;
	
	
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


	@Override
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		
		fillJsonObject(this,jo);
		onFillJsonObject(jo);
		return jo;
	}
	

	/**
	 * 填充JSON对象
	 * @param jo
	 * @throws Exception
	 */
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		
	}


	
	public static void fillJsonObject(IDynaCtrlModel iDynaCtrlModel,ObjectNode jo) throws Exception {
		JsonNodeHelper.put(jo, ATTR_TYPE, iDynaCtrlModel.getControlType());
		JsonNodeHelper.put(jo, ATTR_NAME, iDynaCtrlModel.getName());
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
	}
	
	/**
	 * 获取最后导入的模型对象（json）
	 * @return
	 */
	protected ObjectNode getModelJsonObject(){
		return this.modelJsonObject;
	}
}
