package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.FormException;
import net.ibizsys.paas.control.form.FormItemError;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.i18n.LanResTags;
import net.ibizsys.paas.security.PrivilegeAbilities;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 表单模型基类
 * 
 * @author lionlau
 *
 */
public abstract class FormModelBase extends CtrlModelBase implements IFormModel {
	private static final Log log = LogFactory.getLog(FormModelBase.class);

	protected ArrayList<IFormItem> formItemList = new ArrayList<IFormItem>();
	protected HashMap<String, IFormItem> formItemMap = new HashMap<String, IFormItem>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.ControlImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();
		prepareFormItems();
	}

	/**
	 * 建立表单项
	 * 
	 * @param strFormItemName
	 * @return
	 */
	protected IFormItem createFormItem(String strFormItemName) {
		return null;
	}

	/**
	 * 准备表单项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareFormItems() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGrid#getGridDataItems()
	 */
	@Override
	public Iterator<IFormItem> getFormItems() {
		return formItemList.iterator();
	}

	/**
	 * 获取指定表单项
	 * 
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	public IFormItem getFormItem(String strName) throws Exception {
		return getFormItem(strName, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IForm#getFormItem(java.lang.String, boolean)
	 */
	@Override
	public IFormItem getFormItem(String strName, boolean bTryMode) throws Exception {
		IFormItem iFormItem = this.formItemMap.get(strName.toLowerCase());
		if (iFormItem == null) {
			if (bTryMode) return null;

			throw new Exception(StringHelper.format("无法获取表单项[%1$s]", strName));
		}
		return iFormItem;
	}

	/**
	 * 注册表单项
	 * 
	 * @param iFormItem
	 */
	protected void registerFormItem(IFormItem iFormItem) {
		formItemMap.put(iFormItem.getName().toLowerCase(), iFormItem);
		formItemList.add(iFormItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IFormModel#fillOutputDatas(net.ibizsys.paas.data.IDataObject, boolean, net.sf.json.JSONObject, net.sf.json.JSONObject, net.sf.json.JSONObject)
	 */
	public void fillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		onFillOutputDatas(iDataObject,  bUpdate,  data,  state,  config);
	}
	
	protected void onFillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
		ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
		ISDCtrlHandler iSDCtrlHandler = null;
		boolean bEnableItemPriv = false;
		if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
			iSDCtrlHandler = (ISDCtrlHandler) iCtrlHandler;
			bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
		}

		java.util.Iterator<IFormItem> formItems = this.getFormItems();

		// 值预处理
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			String strPrivilegeId = iFormItem.getPrivilegeId();
			if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
				String strHiddenItemId = StringHelper.format("%1$s%2$s", IFormItem.ITEMPRIV_PREFIX, iFormItem.getPrivFieldName());
				if (bEnableItemPriv) {
					int nItemPriv = this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId);
					// 判断是否有权限
					if ((nItemPriv & PrivilegeAbilities.READ) == 0) {
						iDataObject.set(strHiddenItemId, 0);
					} else {
						if(this.isOutputFormItemUpdatePrivTag()) {
							if ((nItemPriv & PrivilegeAbilities.UPDATE) != PrivilegeAbilities.UPDATE) {
								iDataObject.set(strHiddenItemId, 1);
							}
							else {
								//2为权限控制，并允许修改
								iDataObject.set(strHiddenItemId, 2);
							}
						}
						else {
							iDataObject.set(strHiddenItemId, 1);
						}
					}
				} else {
					iDataObject.set(strHiddenItemId, 1);
				}
			}
		}

		formItems = this.getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();

			boolean bItemReadOk = true;
			if (bEnableItemPriv) {
				String strPrivilegeId = iFormItem.getPrivilegeId();
				if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
					// 判断是否有权限
					if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
						bItemReadOk = false;
					}
				}
			}

			Object objValue = null;
			if (bItemReadOk) {
				boolean bSetValue = true;
				//判断表单项是否忽略设置值
				if((iFormItem.getIgnoreInput() & IFormItem.IGNOREINPUT_DISABLE_AND_NOTSETOUTPUT) == IFormItem.IGNOREINPUT_DISABLE_AND_NOTSETOUTPUT ){
					//判断表单
					Boolean bRet = onTestFormItemEnabled(iFormItem,iDataObject,bUpdate);
					if(bRet!=null){
						if(bRet!=true){
							bSetValue = false;
						}
					}
					else{
						if (bUpdate) {
							if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_UPDATE) == 0) {
								//不启用
								bSetValue = false;
							}
						} else {
							if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_CREATE) == 0) {
								//不启用
								bSetValue = false;
							}
						}
					}
				}
				
				if(bSetValue){
					objValue = iFormItem.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
					if (objValue == null){
						objValue = "";
					}
				}
				else {
					objValue = "";
				}
				
			} else {
				// 没有权限
				objValue = "";
			}
			
			JSONObjectHelper.putRaw(data, iFormItem.getName(), objValue);
			//data.put(iFormItem.getName(), objValue);
			if (state != null) {
				int nState = 0;
				if (bItemReadOk) {
					if (bUpdate) {
						if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_UPDATE) == IFormItem.ENABLECOND_UPDATE) {
							nState = 1;
						}
					} else {
						if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_CREATE) == IFormItem.ENABLECOND_CREATE) {
							nState = 1;
						}
					}
				}

				state.put(iFormItem.getName(), nState);
			}
			if (config != null) {
				JSONObject itemConfig = iFormItem.getConfig(this.getViewController().getWebContext(), iDataObject, bUpdate);
				if (itemConfig != null) {
					config.put(iFormItem.getName(), itemConfig);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IFormModel#fillInputValues(net.ibizsys.paas.data.IDataObject, boolean, boolean)
	 */
	public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
		if (iDataObject == null){
			throw new Exception(StringHelper.format("数据对象无效"));
		}

		/**
		 * 20171208修改：修改获取原值的方式
		 */
		IEntity originEntity = null;
		if(iDataObject instanceof IEntity){
			originEntity = EntityBase.getLast((IEntity)iDataObject);
		}
		
		/**
		 * 20171208 修改结束
		 */
		
		FormError formError = new FormError();
		this.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, formError);
		if (formError.getFormItemErrorList().size() > 0) {
			throw new FormException(formError);
		}
		
		

		// 移除忽略输入的值
		java.util.Iterator<IFormItem> formItems = this.getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if (bUpdate) {
				if ((iFormItem.getIgnoreInput() & IFormItem.IGNOREINPUT_UPDATE) == IFormItem.IGNOREINPUT_UPDATE) {
					iDataObject.remove(iFormItem.getName());
					if ((iFormItem.getIgnoreInput() & IFormItem.IGNOREINPUT_UPDATE_AND_SETORIGIN) == IFormItem.IGNOREINPUT_UPDATE_AND_SETORIGIN){
						/**
						 * 20171124 修改：将原值设置回数据对象
						 */
						if(originEntity == null || !originEntity.contains(iFormItem.getName())){
							throw new Exception(StringHelper.format("无法获取数据对象属性[%1$s]原值",iFormItem.getName()));
						}
						iDataObject.set(iFormItem.getName(), originEntity.get(iFormItem.getName()));
						/**
						 * 20171124 修改结束
						 */
					}
					else{
						Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
						if(!StringHelper.isNullOrEmpty(objValue)){
							iDataObject.set(iFormItem.getName(), objValue);
						}
					}
				}
			} else {
				if ((iFormItem.getIgnoreInput() & IFormItem.ENABLECOND_CREATE) == IFormItem.ENABLECOND_CREATE) {
					iDataObject.remove(iFormItem.getName());
					Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
					if(!StringHelper.isNullOrEmpty(objValue)){
						iDataObject.set(iFormItem.getName(), objValue);
					}
				}
			}
		}
		
		//进一步判断未启用的属性
		formItems = this.getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if((iFormItem.getIgnoreInput() & IFormItem.IGNOREINPUT_DISABLE) == IFormItem.IGNOREINPUT_DISABLE ){
				//判断表单
				boolean bSetValue = true;
				Boolean bRet = onTestFormItemEnabled(iFormItem,iDataObject,bUpdate);
				if(bRet!=null){
					if(bRet!=true){
						bSetValue = false;
					}
				}
				else{
					if (bUpdate) {
						if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_UPDATE) == 0) {
							//不启用
							bSetValue = false;
						}
					} else {
						if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_CREATE) == 0) {
							//不启用
							bSetValue = false;
						}
					}
				}
				
				if(!bSetValue){
					iDataObject.remove(iFormItem.getName());
					Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
					if(!StringHelper.isNullOrEmpty(objValue)){
						iDataObject.set(iFormItem.getName(), objValue);
					}
				}
			}
		}
		
		//回写属性
		formItems = this.getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if(StringHelper.compare(iFormItem.getName(), iFormItem.getDEFName(), true)!=0){
				switch (iFormItem.getWriteBackDEFMode()) {
				case IFormItem.WRITEBACKDEFMODE_ALWAYS:{
					iDataObject.set(iFormItem.getDEFName(),iDataObject.get(iFormItem.getName()));
					break;
				}
				case IFormItem.WRITEBACKDEFMODE_ENABLED:{
					//判断表单
					boolean bSetValue = true;
					Boolean bRet = onTestFormItemEnabled(iFormItem,iDataObject,bUpdate);
					if(bRet!=null){
						if(bRet!=true){
							bSetValue = false;
						}
					}
					else{
						if (bUpdate) {
							if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_UPDATE) == 0) {
								//不启用
								bSetValue = false;
							}
						} else {
							if ((iFormItem.getEnableCond() & IFormItem.ENABLECOND_CREATE) == 0) {
								//不启用
								bSetValue = false;
							}
						}
					}
					if(bSetValue){
						iDataObject.set(iFormItem.getDEFName(),iDataObject.get(iFormItem.getName()));
					}
					break;
				}
				case IFormItem.WRITEBACKDEFMODE_NONE:
				default:
					break;
				}
			}
		}

		return;
	}

	/**
	 * 填充表单值
	 * 
	 * @param iDataObject
	 * @param bUpdate
	 * @param bIgnoreEmpty
	 * @param formError
	 * @throws Exception
	 */
	protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, FormError formError) throws Exception {
		ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
		ISDCtrlHandler iSDCtrlHandler = null;
		boolean bEnableItemPriv = false;
		if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
			iSDCtrlHandler = (ISDCtrlHandler) iCtrlHandler;
			bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
		}

		java.util.Iterator<IFormItem> formItems = this.getFormItems();

		// 值预处理
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if (bEnableItemPriv) {
				String strPrivilegeId = iFormItem.getPrivilegeId();
				if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
					// 判断是否有权限
					if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.UPDATE) == 0) {
						// 没有权限
						continue;
					}
				}
			}

			try {
				Object objValue = iFormItem.getInputValue(this.getViewController().getWebContext());
				if (objValue != null && (objValue instanceof String)) {
					String strValue = (String) objValue;
					strValue = StringHelper.trimRight(strValue);
					if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
				}
				if (!bIgnoreEmpty && objValue == null && !iFormItem.isAllowEmpty()) {
					formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), FormItemError.ERROR_EMPTY, getFormItemErrorInfo(iFormItem, FormItemError.ERROR_EMPTY));
					continue;
				}
				iDataObject.set(iFormItem.getName(), objValue);
			} catch (Exception ex) {
				log.error(StringHelper.format("获取表单项[%1$s]值发生异常，%2$s", iFormItem.getName(), ex.getMessage()), ex);
				formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), FormItemError.ERROR_DATATYPE, getFormItemErrorInfo(iFormItem, FormItemError.ERROR_DATATYPE));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IFormModel#getItemInputValue(java.lang.String, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public Object getItemInputValue(String strFormItem, IWebContext iWebContext) throws Exception {
		IFormItem iFormItem = this.getFormItem(strFormItem, false);
		Object objKeyValue = iFormItem.getInputValue(iWebContext);
		return objKeyValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IFormModel#fillDefaultValues(net.ibizsys.paas.data.IDataObject, boolean)
	 */
	public void fillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		if (iDataObject == null){
			throw new Exception(StringHelper.format("数据对象无效"));
		}

		this.onFillDefaultValues(iDataObject, bUpdate);

	}

	/**
	 * 填充表单默认值
	 * 
	 * @param iDataObject 当前数据对象
	 * @param bUpdate 是否为更新模式
	 * @throws Exception
	 */
	protected void onFillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		java.util.Iterator<IFormItem> formItems = this.getFormItems();

		// 值预处理
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if (iDataObject.get(iFormItem.getName()) != null) continue;

			Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
			if (objValue != null && (objValue instanceof String)) {
				String strValue = (String) objValue;
				if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
			}
			if (objValue == null) continue;
			iDataObject.set(iFormItem.getName(), objValue);
		}
	}

	/**
	 * 获取表单项的错误信息
	 * 
	 * @param iFormItem
	 * @param nErrorType
	 * @return
	 * @throws Exception
	 */
	protected String getFormItemErrorInfo(IFormItem iFormItem, int nErrorType) throws Exception {
		String strErrorInfo = null;
		IWebContext iWebContext = WebContext.getCurrent();
		String strCaption = iFormItem.getCaption();
		if(iWebContext!=null && !StringHelper.isNullOrEmpty(iFormItem.getCapLanResTag())){
			strCaption = iWebContext.getLocalization(iFormItem.getCapLanResTag(), strCaption);
		}
		
		switch (nErrorType) {
		case FormItemError.ERROR_EMPTY:
			strErrorInfo =  StringHelper.format("【%1$s】 不能输入为空，必须为其指定值",strCaption);
			break;
		case FormItemError.ERROR_DATATYPE:
			strErrorInfo =  StringHelper.format("【%1$s】 输入内容不正确，必须输入类型为[%2$s]的值",strCaption, DataTypeHelper.getTypeName(iFormItem.getDataItem().getDataType()));
			break;
		default:
			strErrorInfo =  StringHelper.format("【%1$s】 输入不正确", strCaption);
			break;
		}
		
		if(iWebContext!=null){
			switch (nErrorType) {
			case FormItemError.ERROR_EMPTY:
				strErrorInfo = iWebContext.getLocalization(LanResTags.ERROR_STD_FORM_NOTALLOWEMPTY, new Object[]{strCaption}, strErrorInfo);
				break;
			case FormItemError.ERROR_DATATYPE:
				strErrorInfo = iWebContext.getLocalization(LanResTags.ERROR_STD_FORM_INVALIDDATATYPE, new Object[]{strCaption,DataTypeHelper.getTypeName(iFormItem.getDataItem().getDataType(),iWebContext.getLocale())}, strErrorInfo);
				break;
			default:
				strErrorInfo =  iWebContext.getLocalization(LanResTags.ERROR_STD_FORM_INVALIDVALUE, new Object[]{strCaption}, strErrorInfo);
				break;
			}
		}
		return strErrorInfo;
	}

	
   
	/**
	 * 测试表单项是否处于启用状态
	 * @param iFormItem
	 * @param iDataObject
	 * @param bUpdate
	 * @return
	 * @throws Exception
	 */
	protected Boolean onTestFormItemEnabled(IFormItem iFormItem,IDataObject iDataObject, boolean bUpdate)throws Exception{
		return null;
	}
	
	/**
	 * 是否输出表单项权限控制更新标记（默认为false）
	 * @return
	 */
	protected boolean isOutputFormItemUpdatePrivTag() {
		return this.getViewController().getAppModel().isOutputFormItemUpdatePrivTag();
	}
}
