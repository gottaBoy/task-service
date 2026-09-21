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
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import java.util.TreeMap;

public class Chart
extends BaseDataEntity {
    public static final String TAG_CHARTID = "CHARTID";
    public static final String TAG_CHARTNAME = "CHARTNAME";
    public static final String TAG_CHARTTYPE = "CHARTTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_CHARTPARAM = "CHARTPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_CHARTOBJECT = "CHARTOBJECT";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_CHARTPARAM_TOPCOUNT = "TOPCOUNT";
    public static final String TAG_CHARTPARAM_X = "X";
    public static final String TAG_CHARTPARAM_X_LIST = "X.LIST";
    public static final String TAG_CHARTPARAM_X_FORMAT = "X.FORMAT";
    public static final String TAG_CHARTPARAM_Y = "Y";
    public static final String TAG_CHARTPARAM_Y_VALUE = "Y.VALUE";
    public static final String TAG_CHARTPARAM_Z = "Z";
    public static final String TAG_CHARTPARAM_Y_DEFAULT = "Y.DEFAULT";
    public static final String TAG_CHARTPARAM_Z_DEFAULT = "Z.DEFAULT";
    public static final String TAG_CHARTPARAM_LINK = "LINK";
    public static final String TAG_GRIDPOS = "GRIDPOS";
    public static final String TAG_GRIDWIDTH = "GRIDWIDTH";
    public static final String GRIDPOS_NONE = "NONE";
    public static final String GRIDPOS_LEFT = "LEFT";
    public static final String GRIDPOS_RIGHT = "RIGHT";
    public static final String GRIDPOS_TOP = "TOP";
    public static final String GRIDPOS_BOTTOM = "BOTTOM";
    public static final String GRIDPOS_LEFTTOP = "LEFTTOP";
    public static final String GRIDPOS_LEFTBOTTOM = "LEFTBOTTOM";
    public static final String GRIDPOS_RIGHTTOP = "RIGHTTOP";
    public static final String GRIDPOS_RIGHTBOTTOM = "RIGHTBOTTOM";
    public static final String GRIDPOS_TOPLEFT = "TOPLEFT";
    public static final String GRIDPOS_BOTTOMLEFT = "BOTTOMLEFT";
    public static final String GRIDPOS_TOPRIGHT = "TOPRIGHT";
    public static final String GRIDPOS_BOTTOMRIGHT = "BOTTOMRIGHT";
    public static final String TAG_CHARTTYPE_3DPIE = "3DPIE";
    public static final String TAG_CHARTTYPE_2DPIE = "2DPIE";
    public static final String TAG_CHARTTYPE_FUNNEL = "FUNNEL";
    public static final String TAG_CHARTTYPE_3DCOLUMN = "3DCOLUMN";
    public static final String TAG_CHARTTYPE_2DCOLUMN = "2DCOLUMN";
    public static final String TAG_CHARTTYPE_MS2DCOLUMN = "MS2DCOLUMN";
    public static final String TAG_CHARTTYPE_MS3DCOLUMN = "MS3DCOLUMN";
    public static final String TAG_CHARTTYPE_LINE = "LINE";
    public static final String TAG_CHARTTYPE_MSLINE = "MSLINE";
    public static final String TAG_ISENABLEDP = "ISENABLEDP";
    public static final String TAG_SPCONFIG = "SPCONFIG";
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_TIMEGROUPFIELD = "TIMEGROUPFIELD";
    public static final String TAG_DEFAULTTIMEGROUP = "DEFAULTTIMEGROUP";
    protected QueryGroupModelConfig queryGroupModelConfig = null;
    private Properties chartProperties = null;
    private boolean bParseUserMode = false;
    private TreeMap<String, String> userModeMap = null;

    public String getCHARTNAME() {
        return this.GetParamStringValue(TAG_CHARTNAME, "");
    }

    public String getCHARTID() {
        return this.GetParamStringValue(TAG_CHARTID, "");
    }

    public String getCHARTTYPE() {
        return this.GetParamStringValue(TAG_CHARTTYPE, "");
    }

    public String getCHARTPARAM() {
        return this.GetParamStringValue(TAG_CHARTPARAM, "");
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

    public String getCHARTOBJECT() {
        return this.GetParamStringValue(TAG_CHARTOBJECT, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public void setCHARTID(String strValue) {
        this.SetParamValue(TAG_CHARTID, strValue);
    }

    public void setCHARTNAME(String strValue) {
        this.SetParamValue(TAG_CHARTNAME, strValue);
    }

    public void setCHARTTYPE(String strValue) {
        this.SetParamValue(TAG_CHARTTYPE, strValue);
    }

    public void setCHARTPARAM(String strValue) {
        this.SetParamValue(TAG_CHARTPARAM, strValue);
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

    public void setCHARTTYPE(int nValue) {
        this.SetParamValue(TAG_CHARTTYPE, nValue);
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

    public boolean isENABLEDP() {
        return this.GetParamIntValue(TAG_ISENABLEDP, 0) == 1;
    }

    public String getGRIDPOS() {
        return this.GetParamStringValue(TAG_GRIDPOS, GRIDPOS_NONE);
    }

    public void setGRIDPOS(String strValue) {
        this.SetParamValue(TAG_GRIDPOS, strValue);
    }

    public int getGRIDWIDTH() {
        return this.GetParamIntValue(TAG_GRIDWIDTH, 0);
    }

    public void setGRIDWIDTH(int strValue) {
        this.SetParamValue(TAG_GRIDWIDTH, strValue);
    }

    public String getSPCONFIG() {
        return this.GetParamStringValue(TAG_SPCONFIG, "");
    }

    public void setSPCONFIG(String strValue) {
        this.SetParamValue(TAG_SPCONFIG, strValue);
    }

    public String getSEARCHFORMID() {
        return this.GetParamStringValue(TAG_SEARCHFORMID, "");
    }

    public void setSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMID, strValue);
    }

    public String getSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_SEARCHFORMNAME, "");
    }

    public void setSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMNAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getTIMEGROUPFIELD() {
        return this.GetParamStringValue(TAG_TIMEGROUPFIELD, "");
    }

    public void setTIMEGROUPFIELD(String strValue) {
        this.SetParamValue(TAG_TIMEGROUPFIELD, strValue);
    }

    public String getDEFAULTTIMEGROUP() {
        return this.GetParamStringValue(TAG_DEFAULTTIMEGROUP, "");
    }

    public void setDEFAULTTIMEGROUP(String strValue) {
        this.SetParamValue(TAG_DEFAULTTIMEGROUP, strValue);
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
            if (this.chartProperties != null) {
                return;
            }
            String strChartParam = this.getCHARTPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strChartParam)) {
                this.chartProperties = PropertiesHelper.Load((Properties)this.chartProperties, (String)strChartParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getChartProperties() {
        return this.chartProperties;
    }

    public String GetChartProperty(String strName, String strDefault) {
        if (this.chartProperties == null) {
            return strDefault;
        }
        return PropertiesHelper.GetProperty((Properties)this.chartProperties, (String)strName, (String)strDefault);
    }

    public String GetChartProperty(String strFolder, String strName, String strDefault) {
        if (this.chartProperties == null) {
            return strDefault;
        }
        String strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)strFolder, (Object)strName);
        return PropertiesHelper.GetProperty((Properties)this.chartProperties, (String)strKey.toUpperCase(), (String)strDefault);
    }

    public synchronized boolean CheckUserMode(String strUserMode) {
        if (!this.bParseUserMode) {
            String strPageUserMode = this.getUSERMODE();
            if (StringHelper.IsNullOrEmpty((String)(strPageUserMode = strPageUserMode.trim()))) {
                this.bParseUserMode = true;
            } else {
                this.userModeMap = new TreeMap();
                strPageUserMode = strPageUserMode.replace(";", "|");
                String[] usermodes = strPageUserMode.split("[|]");
                int i = 0;
                while (i < usermodes.length) {
                    this.userModeMap.put(usermodes[i].toUpperCase(), "");
                    ++i;
                }
            }
        }
        if (this.userModeMap == null) {
            return true;
        }
        return this.userModeMap.containsKey(strUserMode.toUpperCase());
    }
}

