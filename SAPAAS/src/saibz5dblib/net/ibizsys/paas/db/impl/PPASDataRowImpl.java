package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;

/**
 * PostgreSQL 数据行记录实现
 * @author Administrator
 *
 */
public class PPASDataRowImpl extends DataRowImpl
{
	public PPASDataRowImpl(IDataTable dt, ResultSet rs) throws SQLException
	{
		super(dt, rs);
	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.impl.DataRowImpl#getRealObject(java.lang.Object)
	 */
	@Override
	protected Object getRealObject(Object obj) throws Exception
	{
		/*if(obj !=null && obj instanceof oracle.sql.CLOB)
		{
			boolean bFirst = true;
			 oracle.sql.CLOB clob = ( oracle.sql.CLOB)obj;
		    BufferedReader br = new BufferedReader(clob.getCharacterStream()); 
		    String s = br.readLine(); 
		    StringBuffer sb = new StringBuffer(); 
		    while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING 
		    if(bFirst)
		    	bFirst =false;
		    else
		    	sb.append("\r\n"); 
		    sb.append(s); 
		    s = br.readLine(); 
		    } 
		    return sb.toString(); 
		}
		
		if(obj !=null && obj instanceof java.sql.Clob )
		{
			boolean bFirst = true;
			Clob clob = (Clob)obj;
		    BufferedReader br = new BufferedReader(clob.getCharacterStream()); 
		    String s = br.readLine(); 
		    StringBuffer sb = new StringBuffer(); 
		    while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING 
		    if(bFirst)
		    	bFirst =false;
		    else
		    	sb.append("\r\n"); 
		    sb.append(s); 
		    s = br.readLine(); 
		    } 
		    return sb.toString(); 
		}
		
		if(obj !=null && obj instanceof TIMESTAMP)
		{
			TIMESTAMP ts = (TIMESTAMP)obj;
			java.sql.Timestamp ts2 = TIMESTAMP.toTimestamp(ts.toBytes());
			//ts2.setNanos(6);
			return ts2;
			
		}
		 */
		if(obj !=null && obj instanceof org.postgresql.jdbc.PgClob ){
			boolean bFirst = true;
			org.postgresql.jdbc.PgClob clob = (org.postgresql.jdbc.PgClob)obj;
			 BufferedReader br = new BufferedReader(clob.getCharacterStream()); 
			    String s = br.readLine(); 
			    StringBuffer sb = new StringBuffer(); 
			    while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING 
			    if(bFirst)
			    	bFirst =false;
			    else
			    	sb.append("\r\n"); 
			    sb.append(s); 
			    s = br.readLine(); 
			    } 
			    return sb.toString(); 
		}

		return super.getRealObject(obj);
	}
	
}
