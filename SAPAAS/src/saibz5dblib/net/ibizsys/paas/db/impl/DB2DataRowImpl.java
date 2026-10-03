package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.ibizsys.paas.db.IDataTable;

/**
 * DB2 数据行记录对象
 * 
 * @author Administrator
 *
 */
public class DB2DataRowImpl extends DataRowImpl {

	/**
	 * 初始化行记录
	 * 
	 * @param dt
	 * @param rs
	 * @throws SQLException
	 */
	public DB2DataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
		super(dt, rs);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.impl.DataRowImpl#getRealObject(java.lang.Object)
	 */
	@Override
	protected Object getRealObject(Object obj) throws Exception {

		if (obj != null && obj instanceof java.sql.Clob) {
			boolean bFirst = true;
			Clob clob = (Clob) obj;
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
