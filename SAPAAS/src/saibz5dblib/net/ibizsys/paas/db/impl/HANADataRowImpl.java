package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;
/**
 * HANA 数据行记录实现
 * @author wuhui
 *
 */
public class HANADataRowImpl extends DataRowImpl  {

	public HANADataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
		super(dt, rs);
	}

	@Override
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
		

		if (obj != null && obj instanceof java.sql.Clob) {
			boolean bFirst = true;
			java.sql.Clob clob = (java.sql.Clob) obj;
			BufferedReader br = new BufferedReader(clob.getCharacterStream());
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
				if (bFirst)
					bFirst = false;
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
