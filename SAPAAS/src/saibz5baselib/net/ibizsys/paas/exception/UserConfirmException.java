package net.ibizsys.paas.exception;

import java.util.ArrayList;

import net.sf.json.JSONObject;

/**
 * 用户确认异常对象
 * @author Administrator
 *
 */
public class UserConfirmException extends Exception {
	
	/**
	 * 确认参数标识
	 */
	private String strConfirmKey = null;


	/**
	 * 确认信息标题
	 */
	private String strConfirmTitle = null;

	/**
	 * 确认选项
	 */
	private ArrayList confirmOptions = null;

	/**
	 * 确认操作后调用自定义操作的参数
	 */
	private JSONObject confirmActionParam = null;
	
	
	public UserConfirmException(String strConfirmMsg,String strConfirmKey,String strConfirmTitle,ArrayList confirmOptions,JSONObject confirmActionParam) {
		super(strConfirmMsg);
		this.strConfirmKey = strConfirmKey;
		this.strConfirmTitle = strConfirmTitle;
		this.confirmOptions = confirmOptions;
		this.confirmActionParam = confirmActionParam;
	}

	
	
	/**
	 * 获取确认操作的参数名字
	 * 
	 * @return
	 */
	public String getConfirmKey() {
		return strConfirmKey;
	}




	/**
	 * 获取确认的选项清单
	 * @return
	 */
	public ArrayList getConfirmOptions() {
		return confirmOptions;
	}

	/**
	 * 获取确认后续操作的提交参数
	 * 
	 * @return
	 */
	public JSONObject getConfirmActionParam() {
		return confirmActionParam;
	}


	/**
	 * 获取确认提示标题
	 * 
	 * @return
	 */
	public String getConfirmTitle() {
		return strConfirmTitle;
	}


}
