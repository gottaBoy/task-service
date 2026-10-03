package net.ibizsys.paas.core;

import net.ibizsys.paas.util.StringHelper;

/**
 * V5 调用结果对象
 * @author lionlau
 *
 */
public class CallResult {
	/**
	 * 返回代码
	 */
	protected int nRetCode = Errors.OK;

	/**
	 * 错误信息
	 */
	protected String strErrorInfo = "";

	/**
	 * 错误信息语言资源编号
	 */
	protected String strErrorInfoRes = "";

	/**
	 * 错误信息语言资源参数
	 */
	protected String strErrorInfoResArg = "";

	/**
	 * 用户对象
	 */
	protected Object userObject = null;

	public CallResult() {
	}

	/**
	 * 获取返回值
	 * 
	 * @return
	 */
	public int getRetCode() {
		return nRetCode;
	}

	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setRetCode(int value) {
		nRetCode = value;
		if (nRetCode == -1) {
			nRetCode = Errors.INTERNALERROR;
		}
	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getErrorInfo() {
		if (nRetCode == 0) return "";
		if (StringHelper.length(strErrorInfo) == 0){
			return Errors.getErrorInfo(nRetCode,null);
		}
		return strErrorInfo;
	}

	/**
	 * 设置返回信息
	 * 
	 * @param strRetInfo
	 */
	public void setRetInfo(String strRetInfo) {
		this.strErrorInfo = strRetInfo;
	}

	/**
	 * 设置错误信息
	 * 
	 * @param value
	 */
	public void setErrorInfo(String value) {
		strErrorInfo = value;
	}

	/**
	 * 判断结果是否为用户错误
	 * 
	 * @return
	 */
	public boolean isUserError() {
		return Errors.isUserError(nRetCode);
	}

	/**
	 * 判断结果是否为错误
	 * 
	 * @return
	 */
	public boolean isError() {
		return nRetCode != Errors.OK;
	}

	/**
	 * 判断结果是否为正确
	 * 
	 * @return
	 */
	public boolean isOk() {
		return nRetCode == Errors.OK;
	}

	/**
	 * 填充结果
	 * 
	 * @param result
	 */
	public void fill(CallResult result) {
		result.setRetCode(nRetCode);
		result.setErrorInfo(strErrorInfo);
		result.setUserObject(userObject);
	}

	/**
	 * 从其它结果对象填充
	 * 
	 * @param result
	 */
	public void from(CallResult result) {
		this.setRetCode(result.getRetCode());
		this.setErrorInfo(result.getErrorInfo());
		this.setUserObject(result.getUserObject());
		this.setErrorInfoRes(result.getErrorInfoRes());
		this.setErrorInfoResArg(result.getErrorInfoResArg());
	}

	/**
	 * 获取用户自定义对象
	 * 
	 * @return
	 */
	public Object getUserObject() {
		return this.userObject;
	}

	/**
	 * 设置用户自定义对象
	 * 
	 * @param userObject
	 */
	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	/**
	 * 获取错误信息语言资源
	 * 
	 * @return the strErrorInfoRes
	 */
	public String getErrorInfoRes() {
		return strErrorInfoRes;
	}

	/**
	 * 获取错误信息语言资源参数
	 * 
	 * @return the strErrorInfoResArg
	 */
	public String getErrorInfoResArg() {
		return strErrorInfoResArg;
	}

	/**
	 * 设置错误信息语言资源
	 * 
	 * @param strErrorInfoRes the strErrorInfoRes to set
	 */
	public void setErrorInfoRes(String strErrorInfoRes) {
		this.strErrorInfoRes = strErrorInfoRes;
	}

	/**
	 * 设置错误信息语言资源参数
	 * 
	 * @param strErrorInfoResArg the strErrorInfoResArg to set
	 */
	public void setErrorInfoResArg(String strErrorInfoResArg) {
		this.strErrorInfoResArg = strErrorInfoResArg;
	}

	/**
	 * 重新格式化错误信息
	 * 
	 * @param strFormat
	 */
	public void reformatErrorInfo(String strFormat) {
		strErrorInfo = StringHelper.format(strFormat, strErrorInfo);
	}

	/**
	 * 重置返回结果，错误代码设置为 Errors.OK
	 */
	public void reset() {
		nRetCode = Errors.OK;
		strErrorInfo = "";
		strErrorInfoRes = "";
		strErrorInfoResArg = "";
		userObject = null;
	}

	/**
	 * 建立调用结果对象
	 * 
	 * @param nCode 错误代码
	 * @return
	 */
	public static CallResult create(int nCode) {
		CallResult callResult = new CallResult();
		callResult.setRetCode(nCode);
		return callResult;
	}

	/**
	 * 建立调用结果对象
	 * 
	 * @param nCode 错误代码
	 * @param strErrorInfo 错误信息
	 * @return
	 */
	public static CallResult create(int nCode, String strErrorInfo) {
		CallResult callResult = new CallResult();
		callResult.setRetCode(nCode);
		callResult.setErrorInfo(strErrorInfo);
		return callResult;
	}

	/**
	 * 建立调用结果对象
	 * 
	 * @param nCode 错误代码
	 * @param strErrorInfo 错误信息
	 * @param objUserObject 自定义对象
	 * @return
	 */
	public static CallResult create(int nCode, String strErrorInfo, Object objUserObject) {
		CallResult callResult = new CallResult();
		callResult.setRetCode(nCode);
		callResult.setErrorInfo(strErrorInfo);
		callResult.setUserObject(objUserObject);
		return callResult;
	}

	/**
	 * 转换结果对象
	 * 
	 * @param callResult
	 * @return
	 */
	public static CallResult toCallResult(CallResult callResult) {
		if (callResult != null) return callResult;

		CallResult cr = new CallResult();
		cr.setRetCode(Errors.INTERNALERROR);
		cr.setErrorInfo("处理异常，返回空结果");
		return cr;
	}

}
