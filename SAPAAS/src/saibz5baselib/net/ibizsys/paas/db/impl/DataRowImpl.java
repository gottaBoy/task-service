package net.ibizsys.paas.db.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数据库行记录对象
 * 
 * @author Administrator
 *
 */
public class DataRowImpl implements IDataRow, ISimpleDataObject {
	protected Object[] fields = null; // 数据数组
	protected IDataTable dataTable = null;

	/**
	 * 初始化行记录
	 * 
	 * @param dt
	 * @param rs
	 * @throws SQLException
	 */
	public DataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
		if (dt == null || rs == null) return;

		dataTable = dt;
		int nColumnCount = dt.getColumnCount();
		fields = new Object[nColumnCount];
		for (int i = 1; i <= nColumnCount; i++) {
			Object objOrigin = null;
			try {
				objOrigin = rs.getObject(i);

			} catch (SQLException ex) {
				ex.printStackTrace();
				String strColumnClassName = dt.getDataColumn(i - 1).getColumnClassName();
				if (StringHelper.compare(strColumnClassName, String.class.getName(), true) == 0) {
					objOrigin = null;

				} else
					throw ex;
				// if(dt.GetDataColumn(i-0).
			}
			try {
				Object obj = getRealObject(objOrigin);
				if (obj != null && obj instanceof java.sql.Date) {
					java.sql.Timestamp ti = rs.getTimestamp(i);
					obj = null;
					obj = ti;
				}

				fields[i - 1] = obj;
			} catch (Exception ex) {
				throw new SQLException(ex);
			}
		}
	}

	/**
	 * 获取实际的数据类型值
	 * 
	 * @param obj
	 * @return
	 */
	protected Object getRealObject(Object obj) throws Exception {
		
		if (obj != null && obj instanceof java.sql.Blob) {
			Blob blob = (Blob) obj;
			InputStream is = null;
			java.io.ByteArrayOutputStream baos = null;
			try{
				is = blob.getBinaryStream();
				baos = new java.io.ByteArrayOutputStream();
				int b;
			    byte[] buffer = new byte[1024];
			    while( (b=is.read(buffer)) != -1){
			    	baos.write(buffer,0,b);
			    }
			    
			    byte[] ret = baos.toByteArray();
			    is.close();
			    baos.close();
			    return ret;
			}
			catch(Exception ex){
				try{
					if(is!=null)
						is.close();
				}
				catch(Exception e){
					
				}
				try{
					if(baos!=null)
						baos.close();
				}
				catch(Exception e){
					
				}
				throw ex;
			}
		}
		
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#getDataTable()
	 */
	public IDataTable getDataTable() {
		return dataTable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#get(int)
	 */
	public Object get(int nIndex) throws Exception {
		return fields[nIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#get(java.lang.String)
	 */
	public Object get(String strColumnName) throws Exception {
		int nIndex = dataTable.getColumnIndex(strColumnName);
		if (nIndex == -1) {
			throw new Exception("无效的列名称[" + strColumnName + "]");
		}
		return get(nIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#isDBNull(int)
	 */
	public boolean isDBNull(int nIndex) throws Exception {
		return (get(nIndex) == null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#isDBNull(java.lang.String)
	 */
	public boolean isDBNull(String strColumnName) throws Exception {
		return (get(strColumnName) == null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IDataRow#reset()
	 */
	public void reset() {
		if (fields != null) {
			fields = null;
		}
		if (dataTable != null) {
			dataTable = null;
		}
	}

	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.data.ISimpleDataObject#getValue(java.lang.String)
	// */
	// @Override
	// public Object getValue(String strParamName) throws Exception
	// {
	// return this.get(strParamName);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.ISimpleDataObject#isParamNull(java.lang.String)
	 */
	@Override
	public boolean isNull(String strParamName) throws Exception {
		return this.isDBNull(strParamName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.ISimpleDataObject#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String strParamName) throws Exception {
		int nIndex = dataTable.getColumnIndex(strParamName);
		if (nIndex == -1) {
			return false;
		}
		return true;
	}

}
