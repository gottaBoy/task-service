package net.ibizsys.paas.db;

import java.util.ArrayList;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * SQL参数列表
 * 
 * @author Administrator
 *
 */
public class SqlParamList extends ArrayList<SqlParam> {
	private static final long serialVersionUID = 1L;

	/**
	 * 当前操作用户标识
	 */
	public final static String TAG_PERSONID = "SRF_PERSONID";
	
	/**
	 * 当前操作用户名称
	 */
	public final static String TAG_PERSONNAME = "SRF_PERSONNAME";

	/**
	 * 操作用户登录名称
	 */
	public final static String TAG_LOGINNAME = "SRF_LOGINNAME";

	/**
	 * 操作返回代码
	 */
	public final static String TAG_RETCODE = "SRF_RETCODE";

	/**
	 * 操作返回信息
	 */
	public final static String TAG_RETINFO = "SRF_RETINFO";

	/**
	 * 返回信息语言资源，用于支持多语言
	 */
	public final static String TAG_RETINFORES = "SRF_RETINFORES";

	/**
	 * 返回信息语言资源参数，用于支持多语言
	 */
	public final static String TAG_RETINFORESARG = "SRF_RETINFORESARG";

	/**
	 * 操作返回标志
	 */
	public final static String TAG_TAG = "SRF_TAG";

	/**
	 * 附加操作模式
	 */
	public final static String TAG_ACTIONMODE = "SRF_ACTIONMODE";

	/**
	 * 附加操作参数
	 */
	public final static String TAG_ACTIONARG = "SRF_ACTIONARG";

	/**
	 * 返回结果集
	 */
	public final static String TAG_RD = "SRF_RD";

	public SqlParamList() {

	}

	/**
	 * 重置
	 */
	public void reset() {
		this.clear();
	}

	// public void add(Object objValue)
	// {
	// SqlParam callParam = new SqlParam(objValue);
	// this.add(callParam);
	// }

	/**
	 * 增加对象参数
	 * 
	 * @param objValue
	 * @throws Exception
	 */
	public void addObject(Object objValue) throws Exception {
		int nDataType = DataTypeHelper.getObjectDataType(objValue);
		SqlParam callParam = new SqlParam(objValue, nDataType);
		this.add(callParam);
	}

	/**
	 * 增加参数
	 * 
	 * @param objValue
	 * @param nDataType 数据类型
	 * @throws Exception
	 */
	public void add(Object objValue, int nDataType) throws Exception {
		SqlParam callParam = new SqlParam(objValue, nDataType);
		this.add(callParam);
	}

	/**
	 * 添加Sql参数
	 * 
	 * @param sqlParam
	 * @throws Exception
	 */
	public void addSqlParam(SqlParam sqlParam) throws Exception {
		this.add(sqlParam);
	}

	/**
	 * 增加日期时间参数
	 * 
	 * @param objValue
	 */
	public void addDateTime(Object objValue) throws Exception {
		if (objValue instanceof java.sql.Timestamp) {
			add(objValue, DataTypes.DATETIME);
			return;
		}

		if (objValue instanceof java.util.Date) {
			add(new java.sql.Timestamp(((java.util.Date) objValue).getTime()), DataTypes.DATETIME);
			return;
		}

		if (objValue instanceof java.sql.Date) {
			add(new java.sql.Timestamp(((java.sql.Date) objValue).getTime()), DataTypes.DATETIME);
			return;
		}

		if (objValue instanceof String) {
			add(DataTypeHelper.testDateTime((String) objValue), DataTypes.DATETIME);
			return;
		}

		add(objValue, DataTypes.DATETIME);
		return;
	}
	
	/**
	 * 增加二进制流参数
	 * 
	 * @param objValue
	 */
	public void addBinary(Object objValue) throws Exception {
		
		if (objValue instanceof String) {
			String strValue = (String) objValue;
			add(Base64Helper.decode(strValue), DataTypes.BINARY);
			return;
		}
		
		add(objValue, DataTypes.BINARY);
		return;
	}
	

	/**
	 * 添加日期变量
	 * 
	 * @param objValue
	 * @throws Exception
	 */
	public void addDate(Object objValue) throws Exception {

		if (objValue instanceof java.sql.Timestamp) {
			add(new java.sql.Date(((java.sql.Timestamp) objValue).getTime()), DataTypes.DATE);
			return;
		}

		if (objValue instanceof java.util.Date) {
			add(new java.sql.Date(((java.util.Date) objValue).getTime()), DataTypes.DATE);
			return;
		}

		if (objValue instanceof String) {
			add(DataTypeHelper.testDate((String) objValue), DataTypes.DATE);
			return;
		}

		add(objValue, DataTypes.DATE);
		return;
	}

	/**
	 * 增加字符串变量
	 * 
	 * @param objValue
	 * @throws Exception
	 */
	public void addString(String objValue) throws Exception {
		add(objValue, DataTypes.VARCHAR);
	}

	/**
	 * 添加返回值参数（输出）
	 * 
	 * @throws Exception
	 */
	public void addRetCode() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setDataType(DataTypes.INT);
		callParam.setOutputParamName(TAG_RETCODE);
		this.add(callParam);
	}

	/**
	 * 添加返回信息（输出）
	 * 
	 * @throws Exception
	 */
	public void addRetInfo() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setDataType(DataTypes.VARCHAR);
		callParam.setOutputParamName(TAG_RETINFO);
		this.add(callParam);
	}

	/**
	 * 添加返回信息资源（输出）
	 * 
	 * @throws Exception
	 */
	public void addRetInfoRes() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setDataType(DataTypes.VARCHAR);
		callParam.setOutputParamName(TAG_RETINFORES);
		this.add(callParam);
	}

	/**
	 * 添加返回信息资源参数（输出）
	 * 
	 * @throws Exception
	 */
	public void addRetInfoResArg() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setDataType(DataTypes.VARCHAR);
		callParam.setOutputParamName(TAG_RETINFORESARG);
		this.add(callParam);
	}

	/**
	 * 添加返回结果集信息（输出）
	 * 
	 * @throws Exception
	 */
	public void addRecordset() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setOutputParamName(TAG_RD);
		this.add(callParam);
	}

	/**
	 * 添加返回标记值（输出）
	 * 
	 * @throws Exception
	 */
	public void addOutputTag() throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setDirection(SqlParamDirections.Output);
		callParam.setDataType(DataTypes.VARCHAR);
		callParam.setOutputParamName(TAG_TAG);
		this.add(callParam);
	}

	/**
	 * 输出调试信息
	 * 
	 * @return
	 */
	public String toDebugInfo() {
		return toDebugInfo(this);
	}

	/**
	 * 输出调试信息
	 * 
	 * @param list
	 * @return
	 */
	public static String toDebugInfo(ArrayList<SqlParam> list) {
		String strInfo = "";
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				SqlParam callParam = list.get(i);
				strInfo += StringHelper.format("参数[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
			}
		}
		return strInfo;
	}

}
