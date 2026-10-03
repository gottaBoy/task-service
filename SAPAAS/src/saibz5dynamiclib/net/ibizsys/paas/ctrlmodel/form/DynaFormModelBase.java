package net.ibizsys.paas.ctrlmodel.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.FormModelBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态表单模型对象接口
 * @author Administrator
 *
 */
public abstract class DynaFormModelBase extends FormModelBase implements IDynaFormModel{

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaFormModelBase.class);
	
	private ArrayList<IDynaFormPageModel> dynaFormPageModelList = new ArrayList<IDynaFormPageModel>();
	private IDynaViewControllerInst iDynaViewControllerInst = null;
	private ObjectNode modelJsonObject = null;
	private IFormModel sourceFormModel = null;
	private String strLayoutMode = null;
	private String strFormStyle = null;
	private String strFormFuncMode = null;
	private IDynaFormModel sourceDynaFormModel = null;
	
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
	 * @see net.ibizsys.paas.ctrlmodel.form.IDynaFormModel#getSourceFormModel()
	 */
	@Override
	public IFormModel getSourceFormModel() {
		return this.sourceFormModel;
	}

	/**
	 * 获取源动态表单模型对象
	 * @return
	 */
	public IDynaFormModel getSourceDynaFormModel() {
		return this.sourceDynaFormModel;
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
			if(iCtrlModel!=null && (iCtrlModel instanceof IFormModel)){
				this.sourceFormModel = (IFormModel)iCtrlModel;	
				if(this.sourceFormModel instanceof IDynaFormModel){
					this.sourceDynaFormModel = (IDynaFormModel)this.sourceFormModel;
				}
			}
		}
		
		this.setLayoutMode(JsonNodeHelper.getString(jsonObject, ATTR_LAYOUTMODE, null));
		this.setFormFuncMode(JsonNodeHelper.getString(jsonObject, ATTR_FORMFUNCMODE, null));
		this.setFormStyle(JsonNodeHelper.getString(jsonObject, ATTR_FORMSTYLE, null));
		
		//加载项集合
		if(true){
			ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, ATTR_PAGES);
			if(arrayNode!=null){
				int nSize = arrayNode.size();
				for(int i =0;i<nSize;i++){
					ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
					DynaFormPageModel iDynaFormPageModel = new DynaFormPageModel();
					iDynaFormPageModel.init(this, null, itemNode);
					this.addPageModel(iDynaFormPageModel);
				}
			}
		}
	}
	
	
	public void addPageModel(IDynaFormPageModel iDynaFormPageModel)throws Exception{
		this.dynaFormPageModelList.add(iDynaFormPageModel);
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
		
		java.util.Iterator<IDynaFormPageModel> pageModels = this.getPageModels();
		ArrayList<IDynaFormItemModel> dynaFormItemModelList = new ArrayList<IDynaFormItemModel>();
		if(pageModels!=null){
			ArrayList<ObjectNode> list = new ArrayList<ObjectNode>();
			while(pageModels.hasNext()){
				IDynaFormPageModel iDynaFormPageModel = pageModels.next();
				ObjectNode pageJo = iDynaFormPageModel.toJsonObject(null);
				list.add(pageJo);
				iDynaFormPageModel.fillDynaFormItemModels(dynaFormItemModelList);
			}
			JsonNodeHelper.put(jo, ATTR_PAGES, list);
			HashMap<String ,IDynaFormItemModel> dynaFormItemModelMap = new HashMap<String ,IDynaFormItemModel> ();
			for(IDynaFormItemModel iDynaFormItemModel:dynaFormItemModelList){
				dynaFormItemModelMap.put(iDynaFormItemModel.getName(), iDynaFormItemModel);
			}
			ArrayList<String> hiddenlist = new ArrayList<String>();
			//枚举隐藏项
			if(this.getSourceDynaFormModel()!=null){
				java.util.Iterator<IFormItem> formItems = this.getSourceDynaFormModel().getFormItems();
				if(formItems!=null){
					while(formItems.hasNext()){
						IFormItem iFormItem = formItems.next();
						if(iFormItem instanceof IDynaFormItemModel){
							IDynaFormItemModel iDynaFormItemModel = (IDynaFormItemModel)iFormItem;
							if(dynaFormItemModelMap.containsKey(iDynaFormItemModel.getName()))
								continue;
							//补回额外的表单项
							hiddenlist.add(iDynaFormItemModel.getName());
						}
					}
				}
			}
			
			JsonNodeHelper.put(jo, ATTR_HIDDENS, hiddenlist);
		}
	}

	@Override
	public Iterator<IDynaFormPageModel> getPageModels() {
		if(this.dynaFormPageModelList.size()==0)
			return null;
		return this.dynaFormPageModelList.iterator();
	}


	@Override
	public IDynaFormDetailModel createDynaFormDetailModel(String strType) throws Exception {
		if(StringHelper.compare(strType, IDynaFormDetailModel.DETAILTYPE_BUTTON, true) == 0){
			return new DynaFormButtonModel();
		}
		if(StringHelper.compare(strType, IDynaFormDetailModel.DETAILTYPE_GROUPPANEL, true) == 0){
			return new DynaFormGroupModel();
		}
		if(StringHelper.compare(strType, IDynaFormDetailModel.DETAILTYPE_FORMITEM, true) == 0){
			return new DynaFormItemModel();
		}
		if(StringHelper.compare(strType, IDynaFormDetailModel.DETAILTYPE_DRUIPART, true) == 0){
			return new DynaFormDRUIPartModel();
		}
		throw new Exception(StringHelper.format("无法识别的表单成员类型[%1$s]",strType));
	}


	@Override
	public String getLayoutMode() {
		if(StringHelper.isNullOrEmpty(this.strLayoutMode) && getSourceDynaFormModel()!=null){
			return getSourceDynaFormModel().getLayoutMode();
		}
		return this.strLayoutMode;
	}


	@Override
	public String getFormFuncMode() {
		if(StringHelper.isNullOrEmpty(this.strFormFuncMode) && getSourceDynaFormModel()!=null){
			return getSourceDynaFormModel().getFormFuncMode();
		}
		return this.strFormFuncMode;
	}


	@Override
	public String getFormStyle() {
		if(StringHelper.isNullOrEmpty(this.strFormStyle) && getSourceDynaFormModel()!=null){
			return getSourceDynaFormModel().getFormStyle();
		}
		return this.strFormStyle;
	}


	/**
	 * 设置表单布局模式
	 * @param strLayoutMode
	 */
	protected void setLayoutMode(String strLayoutMode) {
		this.strLayoutMode = strLayoutMode;
	}


	/**
	 * 设置表单样式
	 * @param strFormStyle
	 */
	protected void setFormStyle(String strFormStyle) {
		this.strFormStyle = strFormStyle;
	}


	/**
	 * 设置表单功能模式
	 * @param strFormFuncMode
	 */
	protected void setFormFuncMode(String strFormFuncMode) {
		this.strFormFuncMode = strFormFuncMode;
	}


	
	
}
