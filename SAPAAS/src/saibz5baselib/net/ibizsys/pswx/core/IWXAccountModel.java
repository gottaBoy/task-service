package net.ibizsys.pswx.core;

import java.util.Collection;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;

/**
 * 微信公众号运行时
 * 
 * @author Administrator
 * 
 */
public interface IWXAccountModel extends IWXAccount {

	/**
	 * 获取企业编号
	 * 
	 * @return
	 */
	String getCorpId();

	/**
	 * 设置企业编号
	 * 
	 * @param strCropId
	 */
	void setCropId(String strCropId);

	/**
	 * 获取企业凭证密钥
	 * 
	 * @return
	 */
	String getCorpSecret();

	/**
	 * 设置企业凭证密钥
	 * 
	 * @param strCropSecret
	 */
	void setCropSecret(String strCropSecret);

	/**
	 * 获取系统模型对象
	 * 
	 * @return
	 */
	ISystemModel getSystemModel();

	/**
	 * 处理微信消息
	 * 
	 * @param wxMessage
	 * @throws Exception
	 */
	void processWXMessage(WXMessage wxMessage) throws Exception;

	/**
	 * 获取微信应用模型，通过agentid
	 * 
	 * @param nAgentId
	 * @return
	 */
	IWXEntAppModel getWXEntAppModel(int nAgentId) throws Exception;

	
	/**
	 * 获取微信应用模型
	 * @param strWXEntAppId
	 * @return
	 * @throws Exception
	 */
	IWXEntAppModel getWXEntAppModel(String strWXEntAppId) throws Exception;
	
	
	/**
	 * 同步微信部门数据
	 * 
	 * @param depts
	 * @return
	 */
	CallResult syncWXDept(Collection<WXDept> depts);

	/**
	 * 同步微信用户数据
	 * 
	 * @param users
	 * @return
	 */
	CallResult syncWXUsers(Collection<WXUser> users);

	/**
	 * 刷新数据
	 * 
	 * @throws Exception
	 */
	void refresh() throws Exception;
	
	
	
	/**
	 * 设置微信企业应用模型运行时标识
	 * @param strWXEntAppModelId
	 * @param runtimeId
	 * @throws Exception
	 */
	void setWXEntAppModelRuntimeId(String strWXEntAppModelId,Object runtimeId)throws Exception;
	
	
	/**
	 * 通过运行时标识获取微信企业应用模型
	 * @param runtimeId
	 * @return
	 * @throws Exception
	 */
	IWXEntAppModel getWXEntAppModelByRuntimeId(Object runtimeId) throws Exception;
}
