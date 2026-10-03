package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.FormItemModel;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态表单项模型对象
 * @author Administrator
 *
 */
public class DynaFormItemModel extends FormItemModel implements IDynaFormItemModel {

	private IDynaFormModel iDynaFormModel = null;
	private IDynaFormDetailModel parentModel = null;
	private ObjectNode modelJsonObject = null;
	private IDynaFormItemModel sourceDynaFormItemModel = null;
	private boolean bShowCaption = true;
	private int nColXS = -1;
	private int nColSM = -1;
	private int nColMD = -1;
	private int nColLG = -1;
	private int nColXSOffset = -1;
	private int nColSMOffset = -1;
	private int nColMDOffset = -1;
	private int nColLGOffset = -1;
	protected double fContentWidth = -1;
	protected double fWidth = -1;
	protected double fContentHeight = -1;
	protected double fHeight = -1;
	private boolean bEditable = true;
	protected String strEditorType = "";
	protected String strEditorStyle = "";
	protected boolean bHidden = false;
	protected String strLabelPos = IDynaFormItemModel.LABELPOS_LEFT;
	protected double fEditorWidth = -1;
	protected double fEditorHeight = -1;
	private boolean bEmptyCaption = false;
	private int nLabelWidth = -1;
	
	private String strPlaceHolder = null;
	
	@Override
	public void init(IDynaFormModel iDynaFormModel, IDynaFormDetailModel parentModel, Object modelObject) throws Exception {
		this.iDynaFormModel = iDynaFormModel;
		this.parentModel = parentModel;
		this.setForm(iDynaFormModel);
		//获取原始表单项
		if(modelObject!=null){
			if(modelObject instanceof ObjectNode){
				this.loadJsonObject((ObjectNode)modelObject);
			}
		}
		
	}

	@Override
	public String getDetailType() {
		return IDynaFormDetailModel.DETAILTYPE_FORMITEM;
	}

	@Override
	public IDynaFormModel getDynaFormModel() {
		return this.iDynaFormModel;
	}

	@Override
	public IDynaFormDetailModel getParentModel() {
		return this.parentModel;
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
			throw new Exception("表单项模型中没有指定表单项名称");
		}
		this.setName(strName);
		
		if(!StringHelper.isNullOrEmpty(this.getName()) &&   this.getDynaFormModel().getSourceFormModel()!=null){
			IFormItem iFormItem = this.getDynaFormModel().getSourceFormModel().getFormItem(this.getName(), true);
			if(iFormItem!=null && iFormItem instanceof IDynaFormItemModel){
				this.sourceDynaFormItemModel = (IDynaFormItemModel)iFormItem;
			}
		}
		
		
		String strEditorType = JsonNodeHelper.getString(jsonObject, ATTR_EDITORTYPE, null);
		if(!StringHelper.isNullOrEmpty(strEditorType)){
			this.setEditorType(strEditorType);
		}
		String strEditorStyle = JsonNodeHelper.getString(jsonObject, ATTR_EDITORSTYLE, null);
		if(!StringHelper.isNullOrEmpty(strEditorStyle)){
			this.setEditorStyle(strEditorStyle);
		}
	}
	
	

	@Override
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		
		onFillJsonObject(jo);
		return jo;
	}
	
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		DynaFormDetailModelBase.fillJsonObject(this, jo);
		if(this.getModelJsonObject()!=null){
			JsonNodeHelper.copy(jo, getModelJsonObject(),true);
		}
		if(jo.has(IDynaFormItemModel.ATTR_EDITORTYPE)){
			if(StringHelper.isNullOrEmpty(jo.get(IDynaFormItemModel.ATTR_EDITORTYPE).asText())){
				if(!StringHelper.isNullOrEmpty(this.getEditorType()))
					JsonNodeHelper.put(jo, IDynaFormItemModel.ATTR_EDITORTYPE, this.getEditorType());
			}
		}
		else
			if(!StringHelper.isNullOrEmpty(this.getEditorType()))
				JsonNodeHelper.put(jo, IDynaFormItemModel.ATTR_EDITORTYPE, this.getEditorType());
		if(jo.has(IDynaFormItemModel.ATTR_EDITORSTYLE)){
			if(StringHelper.isNullOrEmpty(jo.get(IDynaFormItemModel.ATTR_EDITORSTYLE).asText())){
				if(!StringHelper.isNullOrEmpty(this.getEditorStyle()))
					JsonNodeHelper.put(jo, IDynaFormItemModel.ATTR_EDITORSTYLE, this.getEditorStyle());
			}
		}
		else
			if(!StringHelper.isNullOrEmpty(this.getEditorStyle()))
				JsonNodeHelper.put(jo, IDynaFormItemModel.ATTR_EDITORSTYLE, this.getEditorStyle());
		if(jo.has(IDynaCtrlModel.ATTR_CAPTION)){
			if(StringHelper.isNullOrEmpty(jo.get(IDynaCtrlModel.ATTR_CAPTION).asText())){
				if(!StringHelper.isNullOrEmpty(this.getCaption()))
					JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_CAPTION, this.getCaption());
			}
		}
		else
			if(!StringHelper.isNullOrEmpty(this.getCaption()))
				JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_CAPTION, this.getCaption());
	}
	
	
	/**
	 * 获取源动态表单项模型
	 * @return
	 */
	protected IDynaFormItemModel getSourceDynaFormItemModel(){
		return this.sourceDynaFormItemModel;
	}
	
	


	@Override
	public int getColXS() {
		return this.nColXS;
	}


	@Override
	public int getColSM() {
		return this.nColSM;
	}


	@Override
	public int getColMD() {
		return this.nColMD;
	}


	@Override
	public int getColLG() {
		return this.nColLG;
	}


	@Override
	public int getColXSOffset() {
		return this.nColXSOffset;
	}

	
	@Override
	public int getColSMOffset() {
		return this.nColSMOffset;
	}

	
	@Override
	public int getColMDOffset() {
		return this.nColMDOffset;
	}

	
	@Override
	public int getColLGOffset() {
		return this.nColLGOffset;
	}



	@Override
	public boolean isShowCaption() {
		return this.bShowCaption;
	}
	
	
	
//	@Override
//	public double getContentWidth() {
//		return this.fContentWidth;
//	}
//
//
//	@Override
//	public double getContentHeight() {
//		return this.fContentHeight;
//	}


	@Override
	public double getWidth() {
		return this.fWidth;
	}


	@Override
	public double getHeight() {
		return this.fHeight;
	}
	
	
	
	@Override
	public double getEditorWidth()
	{
		return fEditorWidth;
	}


	@Override
	public double getEditorHeight()
	{
		return fEditorHeight;
	}


	@Override
	public boolean isAllowEmpty()
	{
		if (isEditable())
			return super.isAllowEmpty();
		return true;
	}
	
	/**
	 * 是否支持编辑
	 * 
	 * @return
	 */
	@Override
	public boolean isEditable()
	{
		return bEditable;
	}

	@Override
	public String getLabelPos()
	{
		return this.strLabelPos;
	}


	@Override
	public int getLabelWidth()
	{
		if (this.isShowCaption())
		{
			return nLabelWidth;
		}
		else
		{
			return 0;
		}
	}


	@Override
	public boolean isHidden()
	{
		return bHidden;
	}


	@Override
	public String getEditorType()
	{
		if(StringHelper.isNullOrEmpty(strEditorType) && this.getSourceDynaFormItemModel()!=null)
			return this.getSourceDynaFormItemModel().getEditorType();
		return strEditorType;
	}


	@Override
	public String getEditorStyle()
	{
		if(StringHelper.isNullOrEmpty(strEditorStyle) && this.getSourceDynaFormItemModel()!=null)
			return this.getSourceDynaFormItemModel().getEditorStyle();
		return strEditorStyle;
	}
	
	@Override
	public String getCaption()
	{
		if(StringHelper.isNullOrEmpty(super.getCaption()) && this.getSourceDynaFormItemModel()!=null)
			return this.getSourceDynaFormItemModel().getCaption();
		return super.getCaption();
	}

	

	@Override
	public boolean isEmptyCaption() {
		return this.bEmptyCaption;
	}

	/**
	 * 设置是否显示标题
	 * @param bShowCaption
	 */
	public void setShowCaption(boolean bShowCaption) {
		this.bShowCaption = bShowCaption;
	}


	public void setColXS(int nColXS) {
		this.nColXS = nColXS;
	}

	public void setColSM(int nColSM) {
		this.nColSM = nColSM;
	}

	public void setColMD(int nColMD) {
		this.nColMD = nColMD;
	}

	public void setColLG(int nColLG) {
		this.nColLG = nColLG;
	}

	public void setColXSOffset(int nColXSOffset) {
		this.nColXSOffset = nColXSOffset;
	}

	public void setColSMOffset(int nColSMOffset) {
		this.nColSMOffset = nColSMOffset;
	}

	public void setColMDOffset(int nColMDOffset) {
		this.nColMDOffset = nColMDOffset;
	}

	public void setColLGOffset(int nColLGOffset) {
		this.nColLGOffset = nColLGOffset;
	}

	public void setWidth(double fWidth) {
		this.fWidth = fWidth;
	}

	public void setHeight(double fHeight) {
		this.fHeight = fHeight;
	}

	public void setEditable(boolean bEditable) {
		this.bEditable = bEditable;
	}

	/**
	 * 设置编辑器类型
	 * @param strEditorType
	 */
	public void setEditorType(String strEditorType) {
		this.strEditorType = strEditorType;
	}

	/**
	 * 设置编辑器样式
	 * @param strEditorStyle
	 */
	public void setEditorStyle(String strEditorStyle) {
		this.strEditorStyle = strEditorStyle;
	}

	/**
	 * 设置是否隐藏
	 * @param bHidden
	 */
	public void setHidden(boolean bHidden) {
		this.bHidden = bHidden;
	}


	/**
	 * 设置标签位置
	 * @param strLabelPos
	 */
	public void setLabelPos(String strLabelPos) {
		this.strLabelPos = strLabelPos;
	}

	/**
	 * 设置编辑器宽度 
	 * @param fEditorWidth
	 */
	public void setEditorWidth(double fEditorWidth) {
		this.fEditorWidth = fEditorWidth;
	}

	/**
	 * 设置编辑器高度
	 * @param fEditorHeight
	 */
	public void setEditorHeight(double fEditorHeight) {
		this.fEditorHeight = fEditorHeight;
	}

	/**
	 * 设置是否空白标题
	 * @param bEmptyCaption
	 */
	public void setEmptyCaption(boolean bEmptyCaption) {
		this.bEmptyCaption = bEmptyCaption;
	}

	/**
	 * 设置标题宽度
	 * @param nLabelWidth
	 */
	public void setLabelWidth(int nLabelWidth) {
		this.nLabelWidth = nLabelWidth;
	}

	/**
	 * 设置输入提示
	 * @param strPlaceHolder
	 */
	public void setPlaceHolder(String strPlaceHolder) {
		this.strPlaceHolder = strPlaceHolder;
	}
	
	
	/**
	 * 获取最后导入的模型对象（json）
	 * @return
	 */
	protected ObjectNode getModelJsonObject(){
		return this.modelJsonObject;
	}

	@Override
	public String getPlaceHolder() {
		return this.strPlaceHolder;
	}

	


}
