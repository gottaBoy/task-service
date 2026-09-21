/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerConfig
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SearchCondition {
    protected Hashtable paramList = null;
    private Hashtable nullParamList = null;
    private static final Log log = LogFactory.getLog(SearchCondition.class);
    protected int nStartRow = 0;
    protected int nPageSize = 20;
    protected String strSortParam = "";
    protected String strSortDirection = "";

    public void Reset() {
        if (this.paramList != null) {
            this.paramList.clear();
        }
        this.OnReset();
    }

    protected void OnReset() {
    }

    public void SetMaxPageSize() {
        this.nPageSize = Integer.MAX_VALUE;
    }

    public Hashtable getParamList() {
        if (this.paramList == null) {
            this.paramList = new Hashtable();
        }
        this.OnFillParamList();
        return this.paramList;
    }

    protected void OnFillParamList() {
    }

    public boolean From(SRFExWebContext webContext, DBCallerConfig searchCallConfig) {
        this.Reset();
        boolean bRet = true;
        for (Object objParam : searchCallConfig.getParams()) {
            String strParamValue;
            DBCallerParam param = (DBCallerParam)objParam;
            String strParamName = param.getParamName();
            if (StringHelper.Length((String)param.getID()) > 0) {
                strParamName = param.getID();
            }
            if (StringHelper.Length((String)strParamName) == 0) {
                strParamName = param.getParamValue();
            }
            if (StringHelper.Length((String)(strParamValue = webContext.GetParamValue(strParamName))) == 0) {
                strParamValue = webContext.getPage().getRequest().getParameter(strParamName.toLowerCase());
            }
            if (StringHelper.Length((String)strParamValue) == 0) continue;
            Object objValue = null;
            objValue = DataTypeParse.Parse((int)param.getDBType(), (String)strParamValue);
            if (objValue == null) {
                bRet = false;
                continue;
            }
            this.SetParamValue(strParamName, objValue);
            if (!param.getEndOfDay()) continue;
            this.SetParamEndOfDay(strParamName);
        }
        String strTemp = webContext.getPage().getRequest().getParameter("start");
        if (StringHelper.Length((String)strTemp) != 0) {
            try {
                this.nStartRow = Integer.parseInt(strTemp);
            }
            catch (Exception ex) {
                this.nStartRow = 0;
            }
        }
        if (StringHelper.Length((String)(strTemp = webContext.getPage().getRequest().getParameter("limit"))) != 0) {
            try {
                this.nPageSize = Integer.parseInt(strTemp);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                this.nPageSize = 0;
            }
        }
        this.strSortParam = webContext.getPage().getRequest().getParameter("sort");
        String strRealSortParam = webContext.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            this.strSortParam = strRealSortParam;
        }
        this.strSortDirection = webContext.getPage().getRequest().getParameter("dir");
        return bRet;
    }

    public int getStartRow() {
        return this.nStartRow;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
        if (this.nStartRow < 0) {
            this.nStartRow = 0;
        }
    }

    public int getPageSize() {
        return this.nPageSize;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
        if (this.nPageSize <= 0) {
            this.nPageSize = 20;
        }
    }

    public String getSortParam() {
        return this.strSortParam;
    }

    public void setSortParam(String strSortParam) {
        this.strSortParam = strSortParam;
    }

    public String getSortDirection() {
        return this.strSortDirection;
    }

    public void setSortDirection(String strSortDirection) {
        this.strSortDirection = strSortDirection;
    }

    public int getSort() {
        if (StringHelper.Length((String)this.strSortDirection) == 0) {
            return 0;
        }
        return StringHelper.Compare((String)this.strSortDirection, (String)"ASC", (boolean)true) == 0 ? 0 : 1;
    }

    public int getPageNO() {
        return this.nStartRow / this.nPageSize + 1;
    }

    public Object GetParamValue(String strParamName) {
        if (this.paramList == null) {
            log.warn((Object)StringHelper.Format((String)"\u53c2\u6570\u5217\u8868\u65e0\u6548"));
            return null;
        }
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            Object objValue = this.paramList.get(strParamName.toUpperCase());
            return objValue;
        }
        if (this.nullParamList != null && !this.nullParamList.containsKey(strParamName.toUpperCase())) {
            log.warn((Object)StringHelper.Format((String)"\u6570\u636e\u5b9e\u4f53\u4e0d\u5b58\u5728[%1$s]\u5c5e\u6027", (Object)strParamName));
        }
        return null;
    }

    public void SetParamValue(String strParamName, Object objParamValue) {
        if (objParamValue == null) {
            if (this.nullParamList == null) {
                this.nullParamList = new Hashtable();
            }
            this.nullParamList.put(strParamName.toUpperCase(), 0);
        } else {
            if (this.paramList == null) {
                this.paramList = new Hashtable();
            }
            if (objParamValue instanceof String) {
                String strValue = (String)objParamValue;
                strValue = strValue.replace("'", "''");
                objParamValue = strValue;
            }
            this.paramList.put(strParamName.toUpperCase(), objParamValue);
        }
    }

    public int GetParamIntValue(String strParamName, int nDefault) {
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public boolean GetParamBoolValue(String strParamName, boolean bDefault) {
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(objValue.toString());
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public String GetParamStringValue(String strParamName, String strDefault) {
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            return objValue.toString();
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public Date GetParamDateValue(String strParamName, Date dtDefault) {
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return dtDefault;
        }
        try {
            if (objValue instanceof Date) {
                return (Date)objValue;
            }
            return null;
        }
        catch (Exception ex) {
            return dtDefault;
        }
    }

    public boolean ContainCondition(String strCondition) {
        Object objValue = this.GetParamValue(strCondition);
        if (objValue == null) {
            return false;
        }
        return !(objValue instanceof String) || objValue.toString().length() != 0;
    }

    public void SetParamEndOfDay(String strParamName) {
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return;
        }
        if (objValue instanceof Timestamp) {
            Timestamp endTime = (Timestamp)objValue;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            Calendar endofday = Calendar.getInstance();
            endofday.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
            Timestamp tempDate = new Timestamp(endofday.getTime().getTime());
            this.SetParamValue(strParamName, tempDate);
        } else if (objValue instanceof Date) {
            Date endTime = (Date)objValue;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            Calendar endofday = Calendar.getInstance();
            endofday.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
            Date tempDate = new Date(endofday.getTime().getTime());
            this.SetParamValue(strParamName, tempDate);
        } else if (objValue instanceof Time) {
            Time endTime = (Time)objValue;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            Calendar endofday = Calendar.getInstance();
            endofday.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
            Time tempDate = new Time(endofday.getTime().getTime());
            this.SetParamValue(strParamName, tempDate);
        }
    }
}

