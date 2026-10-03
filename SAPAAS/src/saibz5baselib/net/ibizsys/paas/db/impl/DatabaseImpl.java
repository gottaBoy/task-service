package net.ibizsys.paas.db.impl;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.db.IDatabase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数据库对象实现基类
 * 
 * @author Administrator
 *
 */
public abstract class DatabaseImpl extends ModelBaseImpl implements IDatabase {
	public final static String PROPERTY_DBTYPE = "DBTYPE";
	public final static String PROPERTY_DSN = "DSN";

	protected String strDBType = "";

	protected String strDSN = "";

	protected boolean bUnicodeChar = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDatabase#getDBType()
	 */
	@Override
	public String getDBType() {
		return strDBType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDatabase#getConnection()
	 */
	@Override
	public Connection getConnection() throws Exception {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(getDSN());
		return ds.getConnection();
	}

	/**
	 * 设置数据库类型
	 * 
	 * @param strDBType
	 */
	protected void setDBType(String strDBType) {
		this.strDBType = strDBType;
	}

	/**
	 * 设置数据连接
	 * 
	 * @param strDSN
	 */
	protected void setDSN(String strDSN) {
		this.strDSN = strDSN;
	}

	/**
	 * 获取数据连接
	 * 
	 * @return
	 */
	protected String getDSN() {
		return this.strDSN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDatabase#getCountSQL(java.lang.String)
	 */
	@Override
	public String getCountSQL(String strSQL) {
		return StringHelper.format("select count(*) as TOTALROW from (%1$s) m1", strSQL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDatabase#getJDBCType(int)
	 */
	@Override
	public int getJDBCType(int dataType) {
		if (dataType == DataTypes.BIGINT) {
			return java.sql.Types.BIGINT;
		} else if (dataType == DataTypes.BINARY) {
			return java.sql.Types.BINARY;
		} else if (dataType == DataTypes.BIT) {
			return java.sql.Types.BIT;
		} else if (dataType == DataTypes.CHAR || dataType == DataTypes.NCHAR || dataType == DataTypes.UNIQUEIDENTIFIER) {
			return java.sql.Types.CHAR;
		} else if (dataType == DataTypes.TIME || dataType == DataTypes.DATETIME || dataType == DataTypes.SMALLDATETIME || dataType == DataTypes.TIMESTAMP) {
			return java.sql.Types.TIMESTAMP;
		} else if (dataType == DataTypes.DECIMAL ||dataType == DataTypes.BIGDECIMAL || dataType == DataTypes.MONEY || dataType == DataTypes.SMALLMONEY) {
			return java.sql.Types.DECIMAL;
		} else if (dataType == DataTypes.FLOAT) {
			return java.sql.Types.FLOAT;
		} else if (dataType == DataTypes.IMAGE) {
			return java.sql.Types.LONGVARBINARY;
		}

		else if (dataType == DataTypes.INT) {
			return java.sql.Types.INTEGER;
		} else if (dataType == DataTypes.NTEXT || dataType == DataTypes.TEXT) {
			return java.sql.Types.LONGVARCHAR;
		} else if (dataType == DataTypes.NUMERIC) {
			return java.sql.Types.NUMERIC;
		} else if (dataType == DataTypes.NVARCHAR || dataType == DataTypes.SQL_VARIANT || dataType == DataTypes.SYSNAME || dataType == DataTypes.VARCHAR) {
			return java.sql.Types.VARCHAR;
		} else if (dataType == DataTypes.REAL) {
			return java.sql.Types.REAL;
		} else if (dataType == DataTypes.SMALLINT) {
			return java.sql.Types.SMALLINT;
		} else if (dataType == DataTypes.TINYINT) {
			return java.sql.Types.TINYINT;
		} else if (dataType == DataTypes.VARBINARY) {
			return java.sql.Types.VARBINARY;
		}
		return java.sql.Types.VARCHAR;

	}

	/**
	 * 是否使用Unicode存储字符
	 * 
	 * @return
	 */
	public boolean isUnicodeChar() {
		return this.bUnicodeChar;
	}

	/**
	 * 设置是否使用Unicode存储字符
	 * 
	 * @param bUnicodeChar
	 */
	public void setUnicodeChar(boolean bUnicodeChar) {
		this.bUnicodeChar = bUnicodeChar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDatabase#getDBObjStandardName(java.lang.String)
	 */
	@Override
	public String getDBObjStandardName(String strOriginName) {
		return strOriginName;
	}
}
