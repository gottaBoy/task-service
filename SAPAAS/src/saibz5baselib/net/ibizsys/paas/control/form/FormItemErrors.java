package net.ibizsys.paas.control.form;

/**
 * 表单项错误集合<无效类，不建议使用>
 * 
 * @author Enmaai
 *
 */
@Deprecated
public class FormItemErrors {
	// protected Vector formItemErrors = null;
	//
	// protected int nRetCode = Errors.OK;
	// protected String strErrorInfo = "";
	// /**
	// * 注册错误信息
	// * @param strFormItemId
	// * @param nErrorType
	// * @param strErrorInfo
	// */
	// public void Register(String strFormItemId,String strFormErrorId, int nErrorType,String strErrorInfo)
	// {
	// if(formItemErrors == null)
	// formItemErrors = new Vector();
	//
	// FormItemError formItemError = FindFormItemError(strFormItemId,true);
	// formItemError.setFormErrorId(strFormErrorId);
	// formItemError.setErrorType(nErrorType);
	// formItemError.setErrorInfo(strErrorInfo);
	// formItemErrors.add(formItemError);
	// }
	//
	//
	// /**
	// * 注册表单项错误
	// * @param childControl
	// * @param nErrorType
	// * @param strErrorInfo
	// */
	// public void Register(SRFExControl childControl,int nErrorType,String strErrorInfo)
	// {
	// if(childControl == null)
	// return;
	//
	// if(childControl instanceof ISRFExFormItem)
	// {
	// ISRFExFormItem formItem = (ISRFExFormItem)childControl;
	// if(formItem.getFormItemConfig() == null)
	// return;
	//
	// FormItemConfig formItemConfig = (FormItemConfig)formItem.getFormItemConfig();
	// String strError = StringHelper.Format(
	// childControl.getPage().GetLocalization(SRFExLanguageRes.ERROR_STD_FORM_INVALIDVALUE2, "【%1$s】 输入内容不正确，原因为:%2$s"),
	// formItemConfig.getName(),strErrorInfo);
	//
	// this.Register(childControl.getUniqueID(),formItemConfig.getErrorRegionId(), nErrorType, strError);
	// }
	// }
	//
	//
	// /**
	// * 查找表单错误项
	// * @param strFormItemId
	// * @return
	// */
	// public FormItemError FindFormItemError(String strFormItemId)
	// {
	// return FindFormItemError(strFormItemId,false);
	// }
	//
	//
	//
	// /**
	// * 查找错误项
	// * @param strFormItemId
	// * @param bNew
	// * @return
	// */
	// protected FormItemError FindFormItemError(String strFormItemId,boolean bNew)
	// {
	// if(formItemErrors != null)
	// {
	// int nCount = formItemErrors.size();
	// for(int i=0;i<nCount;i++)
	// {
	// FormItemError formItemError = (FormItemError)formItemErrors.get(i);
	// if(StringHelper.Compare(strFormItemId, formItemError.getFormItemId(), true) == 0)
	// {
	// return formItemError;
	// }
	// }
	// }
	//
	//
	// if(!bNew)
	// return null;
	//
	// FormItemError formItemError = new FormItemError();
	// formItemError.setFormItemId(strFormItemId);
	// return formItemError;
	// }
	//
	// /**
	// * 注销一个表单错误
	// * @param strFormItemId
	// */
	// public void Unregister(String strFormItemId)
	// {
	// if(formItemErrors == null)
	// return;
	//
	//
	// int nCount = formItemErrors.size();
	// for(int i=0;i<nCount;i++)
	// {
	// FormItemError formItemError = (FormItemError)formItemErrors.get(i);
	// if(StringHelper.Compare(strFormItemId, formItemError.getFormItemId(), true) == 0)
	// {
	// formItemErrors.remove(i);
	// return;
	// }
	// }
	// }
	//
	// /**
	// * 重置表单错误
	// */
	// public void Reset()
	// {
	// if(formItemErrors == null)
	// return;
	// formItemErrors.clear();
	// }
	//
	//
	// /**
	// * 填充错误对象集合
	// * @param items
	// */
	// public void FillJSONs(Vector items)
	// {
	// if(formItemErrors == null)
	// return ;
	// int nCount = formItemErrors.size();
	// for(int i=0;i<nCount;i++)
	// {
	// FormItemError formItemError = (FormItemError)formItemErrors.get(i);
	// formItemError.FillJSONs(items);
	// }
	// }
	//
	//
	// /**
	// * @return the nRetCode
	// */
	// public int getRetCode()
	// {
	// return nRetCode;
	// }
	//
	//
	// /**
	// * @return the strErrorInfo
	// */
	// public String getErrorInfo()
	// {
	// return strErrorInfo;
	// }
	//
	//
	// /**
	// * @param nRetCode the nRetCode to set
	// */
	// public void setRetCode(int nRetCode)
	// {
	// this.nRetCode = nRetCode;
	// }
	//
	//
	// /**
	// * @param strErrorInfo the strErrorInfo to set
	// */
	// public void setErrorInfo(String strErrorInfo)
	// {
	// this.strErrorInfo = strErrorInfo;
	// }
	//
	// /**
	// * 获取全部错误信息
	// * @return
	// */
	// public String GetTotalError()
	// {
	// if(formItemErrors == null)
	// return "";
	// String strMessage = "";
	// int nCount = formItemErrors.size();
	// for(int i=0;i<nCount;i++)
	// {
	// FormItemError formItemError = (FormItemError)formItemErrors.get(i);
	// if(!StringHelper.IsNullOrEmpty(strMessage))
	// strMessage+= "\r\n";
	// strMessage += formItemError.getErrorInfo();
	// }
	// return strMessage;
	// }
	//

}
