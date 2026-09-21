/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

public class DataRowImpl
implements IDataRow,
ISimpleDataObject {
    protected Object[] fields = null;
    protected IDataTable dataTable = null;

    public DataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        if (dt == null || rs == null) {
            return;
        }
        this.dataTable = dt;
        int nColumnCount = dt.getColumnCount();
        this.fields = new Object[nColumnCount];
        int i = 1;
        while (i <= nColumnCount) {
            Object objOrigin = null;
            try {
                objOrigin = rs.getObject(i);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                String strColumnClassName = dt.getDataColumn(i - 1).getColumnClassName();
                if (StringHelper.compare(strColumnClassName, String.class.getName(), true) == 0) {
                    objOrigin = null;
                }
                throw ex;
            }
            try {
                Object obj = this.getRealObject(objOrigin);
                if (obj != null && obj instanceof Date) {
                    Timestamp ti = rs.getTimestamp(i);
                    obj = null;
                    obj = ti;
                }
                this.fields[i - 1] = obj;
            }
            catch (Exception ex) {
                throw new SQLException(ex);
            }
            ++i;
        }
    }

    protected Object getRealObject(Object obj) throws Exception {
        if (obj != null && obj instanceof Blob) {
            Blob blob = (Blob)obj;
            InputStream is = null;
            ByteArrayOutputStream baos = null;
            try {
                int b;
                is = blob.getBinaryStream();
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                while ((b = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, b);
                }
                byte[] ret = baos.toByteArray();
                is.close();
                baos.close();
                return ret;
            }
            catch (Exception ex) {
                try {
                    if (is != null) {
                        is.close();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    if (baos != null) {
                        baos.close();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                throw ex;
            }
        }
        return obj;
    }

    @Override
    public IDataTable getDataTable() {
        return this.dataTable;
    }

    @Override
    public Object get(int nIndex) throws Exception {
        return this.fields[nIndex];
    }

    @Override
    public Object get(String strColumnName) throws Exception {
        int nIndex = this.dataTable.getColumnIndex(strColumnName);
        if (nIndex == -1) {
            throw new Exception("\u65e0\u6548\u7684\u5217\u540d\u79f0[" + strColumnName + "]");
        }
        return this.get(nIndex);
    }

    @Override
    public boolean isDBNull(int nIndex) throws Exception {
        return this.get(nIndex) == null;
    }

    @Override
    public boolean isDBNull(String strColumnName) throws Exception {
        return this.get(strColumnName) == null;
    }

    @Override
    public void reset() {
        if (this.fields != null) {
            this.fields = null;
        }
        if (this.dataTable != null) {
            this.dataTable = null;
        }
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        return this.isDBNull(strParamName);
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        int nIndex = this.dataTable.getColumnIndex(strParamName);
        return nIndex != -1;
    }
}

