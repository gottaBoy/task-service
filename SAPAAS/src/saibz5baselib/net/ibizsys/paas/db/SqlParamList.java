/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class SqlParamList
extends ArrayList<SqlParam> {
    private static final long serialVersionUID = 1L;
    public static final String TAG_PERSONID = "SRF_PERSONID";
    public static final String TAG_PERSONNAME = "SRF_PERSONNAME";
    public static final String TAG_LOGINNAME = "SRF_LOGINNAME";
    public static final String TAG_RETCODE = "SRF_RETCODE";
    public static final String TAG_RETINFO = "SRF_RETINFO";
    public static final String TAG_RETINFORES = "SRF_RETINFORES";
    public static final String TAG_RETINFORESARG = "SRF_RETINFORESARG";
    public static final String TAG_TAG = "SRF_TAG";
    public static final String TAG_ACTIONMODE = "SRF_ACTIONMODE";
    public static final String TAG_ACTIONARG = "SRF_ACTIONARG";
    public static final String TAG_RD = "SRF_RD";

    public void reset() {
        this.clear();
    }

    public void addObject(Object objValue) throws Exception {
        int nDataType = DataTypeHelper.getObjectDataType(objValue);
        SqlParam callParam = new SqlParam(objValue, nDataType);
        this.add(callParam);
    }

    public void add(Object objValue, int nDataType) throws Exception {
        SqlParam callParam = new SqlParam(objValue, nDataType);
        this.add(callParam);
    }

    public void addSqlParam(SqlParam sqlParam) throws Exception {
        this.add(sqlParam);
    }

    public void addDateTime(Object objValue) throws Exception {
        if (objValue instanceof Timestamp) {
            this.add(objValue, 5);
            return;
        }
        if (objValue instanceof Date) {
            this.add(new Timestamp(((Date)objValue).getTime()), 5);
            return;
        }
        if (objValue instanceof java.sql.Date) {
            this.add(new Timestamp(((java.sql.Date)objValue).getTime()), 5);
            return;
        }
        if (objValue instanceof String) {
            this.add(DataTypeHelper.testDateTime((String)objValue), 5);
            return;
        }
        this.add(objValue, 5);
    }

    public void addBinary(Object objValue) throws Exception {
        if (objValue instanceof String) {
            String strValue = (String)objValue;
            this.add(Base64Helper.decode(strValue), 2);
            return;
        }
        this.add(objValue, 2);
    }

    public void addDate(Object objValue) throws Exception {
        if (objValue instanceof Timestamp) {
            this.add(new java.sql.Date(((Timestamp)objValue).getTime()), 27);
            return;
        }
        if (objValue instanceof Date) {
            this.add(new java.sql.Date(((Date)objValue).getTime()), 27);
            return;
        }
        if (objValue instanceof String) {
            this.add(DataTypeHelper.testDate((String)objValue), 27);
            return;
        }
        this.add(objValue, 27);
    }

    public void addString(String objValue) throws Exception {
        this.add(objValue, 25);
    }

    public void addRetCode() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setDataType(9);
        callParam.setOutputParamName(TAG_RETCODE);
        this.add(callParam);
    }

    public void addRetInfo() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFO);
        this.add(callParam);
    }

    public void addRetInfoRes() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFORES);
        this.add(callParam);
    }

    public void addRetInfoResArg() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFORESARG);
        this.add(callParam);
    }

    public void addRecordset() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setOutputParamName(TAG_RD);
        this.add(callParam);
    }

    public void addOutputTag() throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_TAG);
        this.add(callParam);
    }

    public String toDebugInfo() {
        return SqlParamList.toDebugInfo(this);
    }

    public static String toDebugInfo(ArrayList<SqlParam> list) {
        String strInfo = "";
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                SqlParam callParam = list.get(i);
                strInfo = String.valueOf(strInfo) + StringHelper.format("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
                ++i;
            }
        }
        return strInfo;
    }
}

