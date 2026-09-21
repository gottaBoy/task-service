/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.QueryGroupModelConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.KPI.Ctrl.Data;

import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import java.util.TreeMap;

public class KPISet
extends BaseDataEntity {
    public static final String TAG_KPISETID = "KPISETID";
    public static final String TAG_KPISETNAME = "KPISETNAME";
    public static final String TAG_KPISETTYPE = "KPISETTYPE";
    public static final String TAG_KPISTATE = "KPISTATE";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_KPISETPARAM = "KPISETPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESULTMPSN = "RESULTMPSN";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_KPISETOBJECT = "KPISETOBJECT";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_UPDATECMD = "UPDATECMD";
    public static final String TAG_MAXSCORE = "MAXSCORE";
    public static final String TAG_MINSCORE = "MINSCORE";
    public static final int TAG_KPISTATE_NORMAL = 1;
    public static final int TAG_KPISTATE_PAUSE = 2;
    public static final String TAG_KPISETPARAM_TOPCOUNT = "TOPCOUNT";
    public static final String TAG_KPISETPARAM_X = "X";
    public static final String TAG_KPISETPARAM_X_LIST = "X.LIST";
    public static final String TAG_KPISETPARAM_X_FORMAT = "X.FORMAT";
    public static final String TAG_KPISETPARAM_Y = "Y";
    public static final String TAG_KPISETPARAM_Y_VALUE = "Y.VALUE";
    public static final String TAG_KPISETPARAM_Y_VISIBLE = "Y.VISIBLE";
    public static final String TAG_KPISETPARAM_Z = "Z";
    public static final String TAG_KPISETPARAM_Y_DEFAULT = "Y.DEFAULT";
    public static final String TAG_KPISETPARAM_Z_DEFAULT = "Z.DEFAULT";
    public static final String TAG_KPISETPARAM_LINK = "LINK";
    public static final String TAG_KPIVERSION = "KPIVERSION";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_KPISETTYPE_3DPIE = "3DPIE";
    public static final String TAG_KPISETTYPE_2DPIE = "2DPIE";
    public static final String TAG_KPISETTYPE_FUNNEL = "FUNNEL";
    public static final String TAG_KPISETTYPE_3DCOLUMN = "3DCOLUMN";
    public static final String TAG_KPISETTYPE_2DCOLUMN = "2DCOLUMN";
    public static final String TAG_KPISETTYPE_MS2DCOLUMN = "MS2DCOLUMN";
    public static final String TAG_KPISETTYPE_MS3DCOLUMN = "MS3DCOLUMN";
    public static final String TAG_KPISETTYPE_LINE = "LINE";
    public static final String TAG_KPISETTYPE_MSLINE = "MSLINE";
    protected QueryGroupModelConfig queryGroupModelConfig = null;
    private Properties chartProperties = null;
    private boolean bParseUserMode = false;
    private TreeMap<String, String> userModeMap = null;

    public String getKPISETNAME() {
        return this.GetParamStringValue(TAG_KPISETNAME, "");
    }

    public String getKPISETID() {
        return this.GetParamStringValue(TAG_KPISETID, "");
    }

    public String getKPISETTYPE() {
        return this.GetParamStringValue(TAG_KPISETTYPE, "");
    }

    public String getKPISETPARAM() {
        return this.GetParamStringValue(TAG_KPISETPARAM, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getRESULTMPSN() {
        return this.GetParamStringValue(TAG_RESULTMPSN, "");
    }

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public String getKPISETOBJECT() {
        return this.GetParamStringValue(TAG_KPISETOBJECT, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public String getUPDATECMD() {
        return this.GetParamStringValue(TAG_UPDATECMD, "");
    }

    public void setKPISETID(String strValue) {
        this.SetParamValue(TAG_KPISETID, strValue);
    }

    public void setKPISETNAME(String strValue) {
        this.SetParamValue(TAG_KPISETNAME, strValue);
    }

    public void setKPISETTYPE(String strValue) {
        this.SetParamValue(TAG_KPISETTYPE, strValue);
    }

    public void setKPISETPARAM(String strValue) {
        this.SetParamValue(TAG_KPISETPARAM, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setRESULTMPSN(String strValue) {
        this.SetParamValue(TAG_RESULTMPSN, strValue);
    }

    public void setGROUPMODEL(String strValue) {
        this.SetParamValue(TAG_GROUPMODEL, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getKPISTATE() {
        return this.GetParamIntValue(TAG_KPISTATE, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setKPISETTYPE(int nValue) {
        this.SetParamValue(TAG_KPISETTYPE, nValue);
    }

    public void setKPISTATE(int nValue) {
        this.SetParamValue(TAG_KPISTATE, nValue);
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

    public double getMAXSCORE() {
        return this.GetParamDoubleValue(TAG_MAXSCORE, 0.0);
    }

    public double getMINSCORE() {
        return this.GetParamDoubleValue(TAG_MINSCORE, 0.0);
    }

    public int getKPIVERSION() {
        return this.GetParamIntValue(TAG_KPIVERSION, 0);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setKPIVERSION(int nValue) {
        this.SetParamValue(TAG_KPIVERSION, nValue);
    }

    public void setIMPORTANCEFLAG(int nValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, nValue);
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
            String strChartParam = this.getKPISETPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strChartParam)) {
                this.chartProperties = PropertiesHelper.Load((String)strChartParam);
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

