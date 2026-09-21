/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class CallParamList {
    protected Vector<CallParam> list = new Vector();
    public static final String TAG_PERSONID = "SRF_PERSONID";
    public static final String TAG_RETCODE = "SRF_RETCODE";
    public static final String TAG_RETINFO = "SRF_RETINFO";
    public static final String TAG_RETINFORES = "SRF_RETINFORES";
    public static final String TAG_RETINFORESARG = "SRF_RETINFORESARG";
    public static final String TAG_TAG = "SRF_TAG";
    public static final String TAG_ACTIONMODE = "SRF_ACTIONMODE";
    public static final String TAG_ACTIONARG = "SRF_ACTIONARG";
    public static final String TAG_RD = "SRF_RD";

    public void Reset() {
        this.list.clear();
    }

    public synchronized void Add(Object objValue) {
        CallParam callParam = new CallParam(objValue);
        this.list.add(callParam);
    }

    public synchronized void Add(Object objValue, int nDataType) {
        CallParam callParam = new CallParam(objValue, nDataType);
        this.list.add(callParam);
    }

    public Vector<CallParam> GetList() {
        return this.list;
    }

    public synchronized void AddDateTime(Object objValue) {
        if (objValue instanceof Timestamp) {
            this.Add(objValue, 5);
            return;
        }
        if (objValue instanceof Date) {
            this.Add(new Timestamp(((Date)objValue).getTime()), 5);
            return;
        }
        if (objValue instanceof java.sql.Date) {
            this.Add(new Timestamp(((java.sql.Date)objValue).getTime()), 5);
            return;
        }
        if (objValue instanceof String) {
            this.Add(DataTypeParse.TestDateTime((String)objValue), 5);
            return;
        }
        this.Add(objValue, 5);
    }

    public synchronized void AddDate(Object objValue) {
        if (objValue instanceof Timestamp) {
            this.Add(new java.sql.Date(((Timestamp)objValue).getTime()), 27);
            return;
        }
        if (objValue instanceof Date) {
            this.Add(new java.sql.Date(((Date)objValue).getTime()), 27);
            return;
        }
        if (objValue instanceof String) {
            this.Add(DataTypeParse.TestDate((String)objValue), 27);
            return;
        }
        this.Add(objValue, 27);
    }

    public synchronized void AddString(String objValue) {
        this.Add(objValue, 25);
    }

    public synchronized void AddRetCode() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setDataType(9);
        callParam.setOutputParamName(TAG_RETCODE);
        this.list.add(callParam);
    }

    public synchronized void AddRetInfo() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFO);
        this.list.add(callParam);
    }

    public synchronized void AddRetInfoRes() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFORES);
        this.list.add(callParam);
    }

    public synchronized void AddRetInfoResArg() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_RETINFORESARG);
        this.list.add(callParam);
    }

    public synchronized void AddRecordset() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setOutputParamName(TAG_RD);
        this.list.add(callParam);
    }

    public synchronized void AddOutputTag() {
        CallParam callParam = new CallParam();
        callParam.setDirection(2);
        callParam.setDataType(25);
        callParam.setOutputParamName(TAG_TAG);
        this.list.add(callParam);
    }

    public String toDebugInfo() {
        return CallParamList.toDebugInfo(this.list);
    }

    public static String toDebugInfo(Vector<CallParam> list) {
        String strInfo = "";
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                CallParam callParam = list.get(i);
                strInfo = String.valueOf(strInfo) + StringHelper.Format("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
                ++i;
            }
        }
        return strInfo;
    }
}

