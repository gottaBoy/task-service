package net.ibizsys.pswf.ctrlhandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;

/**
 * 工作流操作表单后台处理对象
 * 
 * @author lionlau
 * @version 5.0.18.5
 */
public abstract class WFActionFormHandlerBase extends WFEditFormHandlerBase implements IWFActionFormHandler {
	private static final Log log = LogFactory.getLog(WFActionFormHandlerBase.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.EditFormHandlerBase#onLoad()
	 */
	@Override
	protected AjaxActionResult onLoad() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取键值
		Object objKeyValue = getEditFormModel().getItemInputValue(IFormItem.KEY, this.getWebContext());
		if (objKeyValue == null) {
			// 出现错误
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		String strKeyValue = objKeyValue.toString();
		
		String[] keys = StringHelper.splitEx(strKeyValue);
		String strFirstKey = keys[0];
		IEntity iEntity = getEntity(strFirstKey);
		// 获取数据
		fillDefaultValues(iEntity, true);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		iEntity.set(IFormItem.KEY, strKeyValue);
		iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);

		this.fillOutputDatas(iEntity, true, formAjaxActionResult);

		return formAjaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase#onWFSubmit()
	 */
	@Override
	protected AjaxActionResult onWFSubmit() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		String strKey = WebContext.getKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKey)) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		Object objKeyValue = getEditFormModel().getItemInputValue(IFormItem.KEY, this.getWebContext());
		if (objKeyValue == null) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		IEntity srcEntity = this.getDEModel().createEntity();
		this.fillInputValues(srcEntity, true, false);

		// 实体为继承主实体时，要进一步计算真实实体，但模式还需要进一步清晰
		IDataEntityModel realDEModel = this.getDEModel();
		if (StringHelper.compare(realDEModel.getIndexDEType(), IDataEntity.INDEXDETYPE_INHERIT, true) == 0) {
			IService realService = ((IInheritDEServiceProxy) this.getService()).getRealService(srcEntity);
			realDEModel = realService.getDEModel();

			// 重新填充表单属性值
			this.fillInputValues(srcEntity, true, false);
		}

		// 判断权限
		String[] keys = strKey.split("[;]");

		String strIATag = WebContext.getWFIATag(this.getWebContext());
		String strSubmitMemo = "";
		String strWFRet = "";
		
		// 获取默认备注
		if (srcEntity.contains("srfwfmemo")) {
			strSubmitMemo = DataObject.getStringValue(srcEntity, "srfwfmemo", "");
		}
		// 获取操作结果（多实例模式）
		if (srcEntity.contains("srfwfret")) {
			strWFRet = DataObject.getStringValue(srcEntity, "srfwfret", "");
		}

		// 表格视图多项数据操作时，移除表单最后更新时间
		srcEntity.remove(IFormItem.LASTUPDATEDATE);

		IWFService iWFService = this.getWFModel().getWFService();
		for (String strKey2 : keys) {
			try {
				SessionFactoryManager.addRef();
				int nVer = -1;
				
				String strWFStepValue = this.getWFStepValue();
				if (StringHelper.isNullOrEmpty(strWFStepValue) || !StringHelper.isNullOrEmpty(this.getDEWF().getWFVerField())) {
					IEntity curEntity = this.getEntity(strKey2);
					if(!StringHelper.isNullOrEmpty(this.getDEWF().getWFVerField())) {
						nVer = DataObject.getIntegerValue(curEntity, this.getDEWF().getWFVerField(), 1);
					}
					if(StringHelper.isNullOrEmpty(strWFStepValue)) {
						strWFStepValue = DataObject.getStringValue(curEntity, this.getDEWF().getWFStepField(),"");
					}
				}
				String strMemoField = "";
				// 根据版本处理
				
				IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
				if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
					IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel) iWFProcessModel;
					IWFInteractiveLinkModel iWFInteractiveLinkModel = iWFInteractiveProcessModel.getWFInteractiveLinkModel(strIATag, true);
					if (iWFInteractiveLinkModel != null) {
						strMemoField = iWFInteractiveLinkModel.getMemoField();
					}
					if (StringHelper.isNullOrEmpty(strMemoField)) {
						strMemoField = iWFInteractiveProcessModel.getMemoField();
					}
				}
				
				IEntity iEntity = this.getDEModel().createEntity();
				srcEntity.copyTo(iEntity, false);

				String strLastSubmitMemo = "";
				if (!StringHelper.isNullOrEmpty(strMemoField)) {
					// 有处理意见属性
					IEntity iEntity2 = this.getEntity(strKey2);
					strLastSubmitMemo = DataObject.getStringValue(iEntity2, strMemoField, "");
					// if(!srcEntity.contains("srfwfmemo"))
					// {
					// strSubmitMemo = DataObject.getStringValue(srcEntity, strMemoField, "");
					// }
					if (!StringHelper.isNullOrEmpty(strLastSubmitMemo)) {
						strLastSubmitMemo += "\r\n\r\n";
					}
					strLastSubmitMemo += StringHelper.format("%1$s %2$s 处理:\r\n%3$s", this.getWebContext().getCurUserName(), DateHelper.getCurTimeString(), strSubmitMemo);
					iEntity.set(strMemoField, strLastSubmitMemo);
					
			//		EntityBase.setLastUpdateDate(iEntity,DataObject.getTimestampValue(iEntity2.get(this.getDEModel().getUpdateDateDEField().getName())));
					
				}

				iEntity.set(this.getDEModel().getKeyDEField().getName(), strKey2);
				iEntity = this.updateEntity(iEntity);
				

				WFActionParam wfActionParam = this.createWFActionParam(iEntity, srcEntity);
				wfActionParam.setUserData(strKey2);
				// wfActionParam.setUserData4(this.getDEModel().getId());
				wfActionParam.setUserData4(realDEModel.getId());

				wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
				wfActionParam.setStepId(iWFProcessModel.getId());
				wfActionParam.setConnection(strIATag);
				wfActionParam.setActionResult(strWFRet);
				wfActionParam.setDescription(strSubmitMemo);
				wfActionParam.setWFMode(this.getWebContext().getWFMode());
				iWFService.submit(wfActionParam);
				SessionFactoryManager.releaseRef(true);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				SessionFactoryManager.releaseRef(false);
				throw ex;
			}
		}

		// 重新获取数据
		// 获取数据
		IEntity iEntity = this.getDEModel().createEntity();
		fillDefaultValues(iEntity, true);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, true, formAjaxActionResult);

		return formAjaxActionResult;
	}

	protected WFActionParam createWFActionParam(IEntity entity, IEntity srcEntity) throws Exception {
		return new WFActionParam();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase#getWFStepValue()
	 */
	@Override
	protected String getWFStepValue() {
		return WebContext.getWFStep(this.getWebContext());
	}

}
