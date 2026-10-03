package net.ibizsys.paas.db.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamDirections;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DM数据库对象
 * @author Administrator
 *
 */
public class DMDBImpl extends DatabaseImpl
{
	private static final Log log = LogFactory.getLog(DMDBImpl.class);


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDatabase#getPagingSQL(java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection)
	{
		// 重新生成排序字段
				if (StringHelper.isNullOrEmpty(strMajor) && !StringHelper.isNullOrEmpty(strMinor)) {
					strMajor = strMinor;
					strMajorDirection = strMinorDirection;
					
					strMinor = "";
					strMinorDirection = "";
				}
				
				StringBuilderEx script = new StringBuilderEx();
				if (!StringHelper.isNullOrEmpty(strMinor)) {
					script.append("SELECT * FROM (Select m1.* from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s,pagetemp.%4$s %5$s) m1 ", strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
				} else if (!StringHelper.isNullOrEmpty(strMajor)) {
					script.append("SELECT * FROM (Select m1.* from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s) m1 ", strSQL, strMajor, strMajorDirection);
				} else {
					script.append("SELECT * FROM (Select m1.* from (%1$s) m1 ", strSQL);
				}
				
				script.append(" ) a1 limit %2$s offset %1$s ", nStartPos, nPageSize);
				return script.toString();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDatabase#callSql(java.sql.Connection, java.lang.String, net.ibizsys.paas.db.SqlParamList, int)
	 */
	public DBCallResult callSql(java.sql.Connection connection,String strCommand, SqlParamList list, int nTimeOut)
	{
		DBCallResult dbResult = new DBCallResult();
		dbResult.setRetCode(Errors.OK);

		Connection conn = null;
		PreparedStatement cstmt = null;

		try
		{
			if(connection==null)
			{
				conn = this.getConnection();
				if (conn == null)
				{
					throw new Exception("打开数据库连接失败");
				}
				connection = conn;
			}

			// 设置调用参数
			cstmt = connection.prepareStatement(strCommand);

			if (list != null)
			{
				for (int i = 0; i < list.size(); i++)
				{
					SqlParam callParam = list.get(i);
					if (callParam.getDataType() != DataTypes.UNKNOWN)
						cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
					else
						cstmt.setObject(i + 1, callParam.getValue());
				}
			}

			// 进行数据集填充
			cstmt.execute();

			DMDataSetImpl dataSet = new DMDataSetImpl(conn,cstmt);
			while (true)
			{
				int updateCount = cstmt.getUpdateCount();
				if (updateCount >= 0)
				{
					// report update count ...
				}
				else
				{
					ResultSet rs = cstmt.getResultSet();
					if (rs == null)
					{
						break;
					}
					dataSet.addResultSet(rs);
					// rs.close();
					break;
				}
				cstmt.getMoreResults();
			}

			// 获取返回值
			dbResult.setRetCode(Errors.OK);
			if(dataSet.getDataTableCount()>0)
			{
				dbResult.setDataSet(dataSet);
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			dbResult.setErrorInfo(ex.toString());
			dbResult.setRetCode(Errors.INTERNALERROR);
		}
		finally
		{
			try
			{
				if(dbResult.getDataSet()==null)
				{
					if (cstmt != null)
					{
						cstmt.close();
					}
				}
			}
			catch (Exception ex)
			{
				log.error(ex.getMessage(), ex);
			}

			try
			{
				if(dbResult.getDataSet()==null)
				{
					if (conn != null)
					{
						conn.close();
					}
				}
			}
			catch (Exception ex)
			{
				log.error(ex.getMessage(), ex);
			}

		}
		return dbResult;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDatabase#callProc(java.sql.Connection, java.lang.String, net.ibizsys.paas.db.SqlParamList, int)
	 */
	public DBCallResult callProc(Connection connection, String strProcName, SqlParamList list, int nTimeOut) throws Exception
	{
		HashMap<Integer, SqlParam> outputParamMap = new HashMap<Integer, SqlParam>();

		DBCallResult dbResult = new DBCallResult();
		dbResult.setRetCode(Errors.OK);

		CallableStatement cstmt = null;

		try
		{
			if (connection == null)
			{
				throw new Exception("打开数据库连接失败");
			}

			int nParamCount = 0;
			int nParamReturnRS = -1;
			if (list != null)
				nParamCount = list.size();
			// 需要注册返回值
			String strCall = formatProcCall(strProcName, nParamCount);
			
			// 设置调用参数
			cstmt = connection.prepareCall(strCall);
//			if(nTimeOut>0)
//			{
//				cstmt.setQueryTimeout(5*60);
//			}
			if (list != null)
			{
				for (int i = 0; i < list.size(); i++)
				{
					SqlParam callParam = list.get(i);

					if (StringHelper.compare(callParam.getOutputParamName(), "SRF_RD", true) == 0)
					{
						cstmt.registerOutParameter(i + 1,  dm.jdbc.driver.DmdbType.CURSOR);
						nParamReturnRS = i + 1;
						continue;
					}
					
					if (callParam.getDirection() == SqlParamDirections.Input)
					{
						cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
					}
					else if (callParam.getDirection() == SqlParamDirections.Output)
					{
						cstmt.registerOutParameter(i + 1, getJDBCType(callParam.getDataType()));
						outputParamMap.put(i + 1, callParam);
					}
					else if (callParam.getDirection() == SqlParamDirections.InputOutput)
					{
						cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
						cstmt.registerOutParameter(i + 1, getJDBCType(callParam.getDataType()));
						outputParamMap.put(i + 1, callParam);
					}
				}
			}

			// 进行数据集填充
			cstmt.execute();

			DMDataSetImpl dataSet = new DMDataSetImpl(null, cstmt);
			// 进行系统数据集填充
			if (nParamReturnRS >= 0)
			{
				ResultSet rsSystem = (ResultSet) cstmt.getObject(nParamReturnRS);
				dataSet.addResultSet(rsSystem);
			}
			
			// 获取需要输出的参数
			for (int nIndex : outputParamMap.keySet())
			{
				SqlParam sqlParam = outputParamMap.get(nIndex);
				dbResult.getOutputValues(true).put(sqlParam.getOutputParamName(), cstmt.getObject(nIndex));
			}

			while (true)
			{
				int updateCount = cstmt.getUpdateCount();
				if (updateCount >= 0)
				{
					// report update count ...
				}
				else
				{
					ResultSet rs = cstmt.getResultSet();
					if (rs == null)
					{
						break;
					}
					dataSet.addResultSet(rs);
					// rs.close();
					break;
				}
				cstmt.getMoreResults();
			}

			// 获取返回值
			dbResult.setRetCode(Errors.OK);
			if (dataSet.getDataTableCount() > 0)
			{
				dbResult.setDataSet(dataSet);
			}
			else
			{
				dataSet.close();
				cstmt = null;
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			dbResult.setErrorInfo(ex.toString());
			dbResult.setRetCode(Errors.INTERNALERROR);
		}
		finally
		{
			try
			{
				if (dbResult.getDataSet() == null)
				{
					if (cstmt != null)
					{
						cstmt.close();
					}
				}
			}
			catch (Exception ex)
			{
				log.error(ex.getMessage(), ex);
			}

//			try
//			{
//				if (dbResult.getDataSet() == null)
//				{
//					if (connection != null)
//					{
//						connection.close();
//					}
//				}
//			}
//			catch (Exception ex)
//			{
//				log.error(ex.getMessage(), ex);
//			}

		}
		return dbResult;
	}
	
	/**
     * 格式化存储过程调用命令
     * @param strProcName
     * @param nParamCount
     * @return
     */
    protected static String formatProcCall(String strProcName, int nParamCount)
    {
    	String strCall = "call ";
        strCall = strCall + strProcName;
        strCall = strCall + " ";
        if (nParamCount > 0)
        {
            strCall = strCall + "(";
            for (int i = 0; i < nParamCount; i++)
            {
                if (i != 0)
                {
                    strCall = strCall + ",";
                }
                strCall = strCall + "?";
            }
            strCall = strCall + ")";
        }
        strCall = strCall + " ;";
        return strCall;
    }

    
    /* (non-Javadoc)
	 * @see net.ibizsys.paas.db.IDatabase#getConditionSQL(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, net.ibizsys.paas.db.SqlParamList)
	 */
	public String getConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception
	{
		if (StringHelper.compare(strCondOp, ICondition.CONDOP_TESTNULL, true) == 0)
		{
			if(StringHelper.compare(strValue, "1",true) == 0)
			{
				return StringHelper.format("%1$s IS NULL", strFieldName);
			}
			else
			{
				return StringHelper.format("%1$s IS NOT NULL", strFieldName);
			}
		}
		
		if (StringHelper.compare(strCondOp, ICondition.CONDOP_ISNULL, true) == 0)
		{
			return StringHelper.format("%1$s IS NULL", strFieldName);
		}

		if (StringHelper.compare(strCondOp, ICondition.CONDOP_ISNOTNULL, true) == 0)
		{
			return StringHelper.format("%1$s IS NOT NULL", strFieldName);
		}

//		if (!!bParam)
//		{
//			if (MacroHelper.isSRFFunc(strParamName))
//			{
//				Vector<String> argList = new Vector<String>();
//				String strFuncName = MacroHelper.ParseSRFFunc(strParamName, argList);
//				if (StringHelper.compare(strFuncName, MacroHelper.TAG_SRFUVEX, true) == 0)
//				{
//					if (argList.size() == 0)
//					{
//						log.error(StringHelper.format("无法失败扩展URL参数[%1$s]", strParamName));
//						return "";
//					}
//
//					String strMacroIndex = StringHelper.format("_MACRO_%1$s_", this.nMacroIndex);
//					this.nMacroIndex++;
//
//					URLCondPair urlCondPair = new URLCondPair();
//					urlCondPair.strFieldName = strFieldName;
//					urlCondPair.strDataType = strDataType;
//					urlCondPair.strCondOp = strCondOp;
//					urlCondPair.strURLParam = argList.get(0);
//					urlCondPair.strMacro = strMacroIndex;
//					if (argList.size() >= 2)
//					{
//						urlCondPair.bAll = (StringHelper.compare(argList.get(1), "ALL", true) == 0);
//					}
//					urlCondPairList.add(urlCondPair);
//					return strMacroIndex;
//				}
//			}
//		}

		if (DataTypeHelper.isStringType(nStdDataType))
		{
			return getStringConditionSQL(strFieldName, nStdDataType, strCondOp, strValue,  bParam,  sqlParamList);
		}

		if (DataTypeHelper.isIntType(nStdDataType))
		{
			return getIntConditionSQL(strFieldName, nStdDataType, strCondOp, strValue,   bParam,  sqlParamList);
		}

		if (DataTypeHelper.isDoubleType(nStdDataType))
		{
			return getDoubleConditionSQL(strFieldName, nStdDataType, strCondOp, strValue,  bParam,  sqlParamList);
		}

		if (DataTypeHelper.isDateTimeType(nStdDataType))
		{
			return getDateTimeConditionSQL(strFieldName, nStdDataType, strCondOp, strValue,   bParam,  sqlParamList);
		}
	
		throw new Exception(StringHelper.format("无法获取数据库查询条件"));
	}

	
	

	/**
	 * 获取字符串条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	public String getStringConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue)throws Exception
	{
		return getStringConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false,null);
	}
	

	/**
	 * 获取字符串条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	protected String getStringConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList)throws Exception
	{
	    if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0) 
		{
			strValue = strValue.replace("'", "''");
			return StringHelper.format("%1$s = '%2$s'", strFieldName, strValue);
		}

		if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
		{
			strValue = strValue.replace("'", "''");
			return StringHelper.format("%1$s <> '%2$s'", strFieldName, strValue);
		}

		if (StringHelper.compare(strCondOp, ICondition.CONDOP_LIKE, true) == 0)
		{
			strValue = strValue.replace("'", "''");
			strValue = "%" + strValue + "%";
			return StringHelper.format("%1$s LIKE '%2$s'", strFieldName, strValue);
		}
		
		if (StringHelper.compare(strCondOp, ICondition.CONDOP_LEFTLIKE, true) == 0)
		{
			strValue = strValue.replace("'", "''");
			strValue =  strValue + "%";
			return StringHelper.format("%1$s LIKE '%2$s'", strFieldName, strValue);
		}
		
		if (StringHelper.compare(strCondOp, ICondition.CONDOP_RIGHTLIKE, true) == 0)
		{
			strValue = strValue.replace("'", "''");
			strValue = "%" + strValue ;
			return StringHelper.format("%1$s LIKE '%2$s'", strFieldName, strValue);
		}
		
		if (StringHelper.compare(strCondOp, ICondition.CONDOP_USERLIKE, true) == 0)
		{
			strValue = strValue.replace("'", "''");
			return StringHelper.format("%1$s LIKE '%2$s'", strFieldName, strValue);
		}

		throw new Exception(StringHelper.format("无法识别的条件操作符[%1$s]",strCondOp));
	}

	/**
	 * 获取INT条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	public String getIntConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue)throws Exception
	{
		return getIntConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false,null);
	}

	/**
	 * 获取INT条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	protected String getIntConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList)throws Exception
	{
		if (!bParam)
		{
			// 判断值是否正确
			Object objValue = null;
			if (!((StringHelper.compare(strCondOp, ICondition.CONDOP_IN, true) == 0) || (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTIN, true) == 0)))
			{
				objValue = DataTypeHelper.testBigInt(strValue);
				if (objValue == null)
				{
					throw new Exception(StringHelper.format("值[%1$s]非整数值", strValue));
				}	
			}
			
			//if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0) 
			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0)
			{
				return StringHelper.format("%1$s = %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				return StringHelper.format("%1$s <> %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				return StringHelper.format("%1$s > %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s >= %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				return StringHelper.format("%1$s < %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s <= %2$s", strFieldName, strValue);
			}

			if ((StringHelper.compare(strCondOp, ICondition.CONDOP_IN, true) == 0) || (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTIN, true) == 0))
			{
				if (StringHelper.isNullOrEmpty(strValue))
				{
					if (StringHelper.compare(strCondOp, ICondition.CONDOP_IN, true) == 0)
						return "1<>1";
					else
						return "1=1";
				}

				String[] items = strValue.split("[;]");
				String strSQL = "";
				if (StringHelper.compare(strCondOp, ICondition.CONDOP_IN, true) == 0)
				{
					strSQL = StringHelper.format("%1$s IN (", strFieldName);
				}
				else
				{
					strSQL = StringHelper.format("%1$s NOT IN (", strFieldName);
				}
				for (int i = 0; i < items.length; i++)
				{
					if (i != 0)
						strSQL += ",";
					strSQL += StringHelper.format("%1$s", items[i]);
				}
				strSQL += ")";
				return strSQL;
			}

			return "";
		}
		else
		{
			SqlParam sqlParam = new SqlParam();
			sqlParam.setParamName(strValue);
			//callParam.setValue(objValue);

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0) 
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s = ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <> ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s > ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s >=?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s < ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <= ?", strFieldName);
			}
			return "";
		}
	}

	/**
	 * 获取DOUBLE条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	public String getDoubleConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue)throws Exception
	{
		return getDoubleConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false,null);
	}

	/**
	 * 获取DOUBLE条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	protected String getDoubleConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList)throws Exception
	{
		if (!bParam)
		{
			// 判断值是否正确
			Object objValue = DataTypeHelper.testDouble(strValue);
			if (objValue == null)
			{
				if (!((StringHelper.compare(strCondOp, ICondition.CONDOP_IN, true) == 0) || (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTIN, true) == 0)))
				{
					throw new Exception(StringHelper.format("值[%1$s]非浮点值", strValue));
				}	
			}
			
			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0) 

			{
				return StringHelper.format("%1$s = %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				return StringHelper.format("%1$s <> %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				return StringHelper.format("%1$s > %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s >= %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				return StringHelper.format("%1$s < %2$s", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s <= %2$s", strFieldName, strValue);
			}
			return "";
		}
		else
		{
			SqlParam sqlParam = new SqlParam();
			sqlParam.setParamName(strValue);
			//callParam.setValue(objValue);

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0) 
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s = ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <> ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s > ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s >=?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s < ?", strFieldName);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <= ?", strFieldName);
			}
			return "";
		}
	}

	/**
	 * 获取DATETIME条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	public String getDateTimeConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue)throws Exception
	{
		return getDateTimeConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false,null);
	}

	/**
	 * 获取DATETIME条件SQL 语句
	 * @param strFieldName
	 * @param nStdDataType
	 * @param strCondOp
	 * @param strValue
	 * @param bParam
	 * @param sqlParamList
	 * @return
	 * @throws Exception
	 */
	protected String getDateTimeConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception
	{
		if (!bParam)
		{
			// 判断值是否正确
			Object objValue = null;
			if (!StringHelper.isNullOrEmpty(strValue))
			{
				// 判断值是否正确
				objValue = DataTypeHelper.testDateTime(strValue);
				if (objValue == null)
				{
					throw new Exception(StringHelper.format("值[%1$s]非日期时间性", strValue));
				}

				java.sql.Timestamp ts = (java.sql.Timestamp) objValue;
				strValue = StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ts);

				if ((StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0) || (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0))
				{

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date(ts.getTime()));

					if (calendar.get(Calendar.HOUR_OF_DAY) == 0 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.SECOND) == 0)
					{
						strValue = StringHelper.format("%1$tY-%1$tm-%1$td 23:59:59", ts);
						objValue = DataTypeHelper.testDateTime(strValue);
					}
				}
			}
			
			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0)
			{
				return StringHelper.format("%1$s = '%2$s'", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				return StringHelper.format("%1$s <> '%2$s'", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				return StringHelper.format("%1$s > '%2$s'", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s >= '%2$s'", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				return StringHelper.format("%1$s < '%2$s'", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				return StringHelper.format("%1$s <= '%2$s'", strFieldName, strValue);
			}
			return "";
		}
		else
		{
			SqlParam sqlParam = new SqlParam();
			sqlParam.setParamName(strValue);
			//callParam.setValue(objValue);

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_EQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s = ?", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_NOTEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <> ?", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s > ?", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_GTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s >= ?", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LT, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s < ?", strFieldName, strValue);
			}

			if (StringHelper.compare(strCondOp, ICondition.CONDOP_LTANDEQ, true) == 0)
			{
				sqlParamList.add(sqlParam);
				return StringHelper.format("%1$s <= ?", strFieldName, strValue);
			}
			return "";
		}
	}
}
