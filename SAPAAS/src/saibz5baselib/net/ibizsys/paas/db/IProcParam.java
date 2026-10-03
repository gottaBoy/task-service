package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IModelBase;

/**
 * 存储过程变量
 * 
 * @author Administrator
 *
 */
public interface IProcParam extends IModelBase {
	/**
	 * 数据草稿标志
	 */
	final static String TAG_DRAFTFLAG = "SRF_DRAFTFLAG";

	/**
	 * 操作用户标识
	 */
	final static String TAG_PERSONID = "SRF_PERSONID";
	
	
	/**
	 * 操作用户登录名称
	 */
	final static String TAG_LOGINNAME = "SRF_LOGINNAME";
	
	
	/**
	 * 操作用户名称
	 */
	final static String TAG_PERSONNAME = "SRF_PERSONNAME";
	

	/**
	 * 当前时间
	 */
	final static String TAG_CURTIME = "SRF_CURTIME";

	/**
	 * 组织机构标识
	 */
	final static String TAG_ORGID = "SRF_ORGID";

	/**
	 * 组织机构名称
	 */
	final static String TAG_ORGNAME = "SRF_ORGNAME";

	/**
	 * 组织部门标识
	 */
	final static String TAG_ORGSECTORID = "SRF_ORGSECTORID";

	/**
	 * 组织部门名称
	 */
	final static String TAG_ORGSECTORNAME = "SRF_ORGSECTORNAME";

	/**
	 * 对输入的键值做检查
	 */
	final static String TAG_CHECKKEY = "SRF_CHECKKEY";

	/**
	 * 存储DALOG
	 */
	final static String TAG_DALOG = "SRF_DALOG";
	
	
	/**
	 * SaaS 中心标识
	 */
	final static String TAG_SAASDCID = "SRF_SAASDCID";
	

	/**
	 * 返回插入或更新的数据
	 */
	final static String TAG_RETDATA = "SRF_RETDATA";

	final static String TAG_RETCODE = "SRF_RETCODE";

	final static String TAG_RETINFO = "SRF_RETINFO";

	final static String TAG_RETINFORES = "SRF_RETINFORES";

	final static String TAG_RETINFORESARG = "SRF_RETINFORESARG";

	final static String TAG_TAG = "SRF_TAG";

	final static String TAG_ACTIONMODE = "SRF_ACTIONMODE";

	final static String TAG_ACTIONARG = "SRF_ACTIONARG";

	final static String TAG_RD = "SRF_RD";

	/**
	 * 变量
	 */
	public final static String TAG_VAR = "VAR_";

	/**
	 * 变量有效标志
	 */
	public final static String TAG_VF = "VF_";
	
	
	/**
	 * 创建时间
	 */
	final static String TAG_CREATEDATE = "SRF_CREATEDATE";
	
	
	/**
	 * 更新时间
	 */
	final static String TAG_UPDATEDATE = "SRF_UPDATEDATE";
	
	
	/**
	 * 创建人标识
	 */
	final static String TAG_CREATEMAN = "SRF_CREATEMAN";
	
	
	/**
	 * 更新人标识
	 */
	final static String TAG_UPDATEMAN = "SRF_UPDATEMAN";
	
	
	/**
	 * 创建人名称
	 */
	final static String TAG_CREATEMANNAME = "SRF_CREATEMANNAME";
	
	
	/**
	 * 更新人名称
	 */
	final static String TAG_UPDATEMANNAME = "SRF_UPDATEMANNAME";
	
	

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	Object getDefaultValue();

	/**
	 * 获取参数方向
	 * 
	 * @return
	 */
	int getDirection();

	/**
	 * 获取输出的参数名称
	 * 
	 * @return the strOutputParamName
	 */
	String getOutputParamName();

	/**
	 * 获取标准数据类型
	 * 
	 * @return the nDataType
	 */
	int getDataType();

	/**
	 * 获取参数名称
	 * 
	 * @return the strParamName
	 */
	String getParamName();

}
