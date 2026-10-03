/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Report.List.ListConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import java.util.TreeMap;

public class List
extends BaseDataEntity {
    public static final String TAG_LISTID = "LISTID";
    public static final String TAG_LISTNAME = "LISTNAME";
    public static final String TAG_LISTTYPE = "LISTTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_LISTPARAM = "LISTPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_LISTOBJECT = "LISTOBJECT";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ISENABLEDP = "ISENABLEDP";
    public static final String TAG_LISTPARAM_TOPCOUNT = "TOPCOUNT";
    public static final String TAG_LISTPARAM_ORDERFIELD = "ORDERFIELD";
    public static final String TAG_LISTPARAM_ORDERDIR = "ORDERDIR";
    public static final String TAG_LISTPARAM_LIST_ITEMCOUNT = "LIST.ITEMCOUNT";
    public static final String TAG_LISTPARAM_LIST_HIDEHEADER = "LIST.HIDEHEADER";
    public static final String TAG_LISTPARAM_LIST_ITEM = "LIST.ITEM";
    public static final String TAG_LISTPARAM_LIST_EMTPYMSG = "LIST.EMTPYMSG";
    public static final String TAG_LISTTYPE_NORMAL = "NORMAL";
    public static final String TAG_WRITEROBJECT = "WRITEROBJECT";
    protected QueryGroupModelConfig queryGroupModelConfig = null;
    private Properties listParams = null;
    private static TreeMap<String, String> listColumnAttrMap = new TreeMap();
    private ListConfig listConfig = null;

    static {
        listColumnAttrMap.put(TAG_WIDTH, "0");
        listColumnAttrMap.put("PARAMS", "");
        listColumnAttrMap.put("ALIGN", "");
        listColumnAttrMap.put("CAPTION", "");
        listColumnAttrMap.put("CAPLANRESID", "");
        listColumnAttrMap.put("FORMAT", "");
        listColumnAttrMap.put("DEFAULT", "");
        listColumnAttrMap.put("GROUP", "FALSE");
        listColumnAttrMap.put("CUSTOM", "");
        listColumnAttrMap.put("CUSTOMTAG", "");
    }

    public String getLISTNAME() {
        return this.GetParamStringValue(TAG_LISTNAME, "");
    }

    public String getLISTID() {
        return this.GetParamStringValue(TAG_LISTID, "");
    }

    public String getLISTTYPE() {
        return this.GetParamStringValue(TAG_LISTTYPE, "");
    }

    public String getLISTPARAM() {
        return this.GetParamStringValue(TAG_LISTPARAM, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public String getLISTOBJECT() {
        return this.GetParamStringValue(TAG_LISTOBJECT, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setLISTID(String strValue) {
        this.SetParamValue(TAG_LISTID, strValue);
    }

    public void setLISTNAME(String strValue) {
        this.SetParamValue(TAG_LISTNAME, strValue);
    }

    public void setLISTTYPE(String strValue) {
        this.SetParamValue(TAG_LISTTYPE, strValue);
    }

    public void setLISTPARAM(String strValue) {
        this.SetParamValue(TAG_LISTPARAM, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public void setGROUPMODEL(String strValue) {
        this.SetParamValue(TAG_GROUPMODEL, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getROWID() {
        return this.GetParamIntValue(TAG_ROWID, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setLISTTYPE(int nValue) {
        this.SetParamValue(TAG_LISTTYPE, nValue);
    }

    public void setROWID(int nValue) {
        this.SetParamValue(TAG_ROWID, nValue);
    }

    public void setCOLUMNID(int nValue) {
        this.SetParamValue(TAG_COLUMNID, nValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public String getWRITEROBJECT() {
        return this.GetParamStringValue(TAG_WRITEROBJECT, "");
    }

    public void setWRITEROBJECT(String strValue) {
        this.SetParamValue(TAG_WRITEROBJECT, strValue);
    }

    public boolean isENABLEDP() {
        return this.GetParamIntValue(TAG_ISENABLEDP, 0) == 1;
    }

    public QueryGroupModelConfig getQueryGroupModelConfig() {
        if (this.queryGroupModelConfig != null) {
            return this.queryGroupModelConfig;
        }
        String strGroupModelXML = this.getGROUPMODEL();
        if (StringHelper.Length((String)strGroupModelXML) > 0) {
            this.queryGroupModelConfig = new QueryGroupModelConfig();
            if (!XMLConfig.LoadFromXML((String)strGroupModelXML, (XMLConfig)this.queryGroupModelConfig)) {
                return null;
            }
        }
        return this.queryGroupModelConfig;
    }

    public void BuildProperties() {
        try {
            if (this.listParams != null) {
                return;
            }
            String strChartParam = this.getLISTPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strChartParam)) {
                this.listParams = new Properties();
                this.listParams = PropertiesHelper.Load((Properties)this.listParams, (String)strChartParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getListProperties() {
        return this.listParams;
    }

    public String GetListProperty(String strName, String strDefault) {
        if (this.listParams == null) {
            return strDefault;
        }
        return PropertiesHelper.GetProperty((Properties)this.listParams, (String)strName, (String)strDefault);
    }

    public ListConfig GetListConfig() {
        if (this.listConfig != null) {
            return this.listConfig;
        }
        this.listConfig = new ListConfig();
        this.listConfig.SetProperty("HIDEHEADER", this.GetListProperty(TAG_LISTPARAM_LIST_HIDEHEADER, ""));
        String strEmptyMsg = this.GetListProperty(TAG_LISTPARAM_LIST_EMTPYMSG, "");
        if (!StringHelper.IsNullOrEmpty((String)strEmptyMsg)) {
            this.listConfig.SetProperty(TAG_LISTPARAM_LIST_EMTPYMSG, strEmptyMsg);
        }
        String strListItemCount = this.GetListProperty(TAG_LISTPARAM_LIST_ITEMCOUNT, "0");
        int nCount = Integer.parseInt(strListItemCount);
        int i = 0;
        while (i < nCount) {
            ListColumnConfig listColumnConfig = new ListColumnConfig();
            for (String strColumnAttr : listColumnAttrMap.keySet()) {
                String strKey = StringHelper.Format((String)"%1$s.%2$s.%3$s", (Object)TAG_LISTPARAM_LIST_ITEM, (Object)(i + 1), (Object)strColumnAttr);
                listColumnConfig.SetProperty(strColumnAttr, this.GetListProperty(strKey, listColumnAttrMap.get(strColumnAttr)));
            }
            this.listConfig.getListColumnsConfig().add(listColumnConfig);
            ++i;
        }
        return this.listConfig;
    }
}
