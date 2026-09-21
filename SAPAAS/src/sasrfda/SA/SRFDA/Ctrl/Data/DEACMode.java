/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class DEACMode
extends BaseDataEntity {
    public static final String TAG_DEACMODEID = "DEACMODEID";
    public static final String TAG_DEACMODENAME = "DEACMODENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ACINFOFORMAT = "ACINFOFORMAT";
    public static final String TAG_ACINFOPARAM = "ACINFOPARAM";
    public static final String TAG_ACEXTINFO = "ACEXTINFO";
    public static final String TAG_ACOBJECT = "ACOBJECT";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_ISENABLEDP = "ISENABLEDP";
    public static final String TAG_ACSORTFIELD = "ACSORTFIELD";
    public static final String TAG_ACSORTDIR = "ACSORTDIR";
    public static final String TAG_ACREALTEXTFORMAT = "ACREALTEXTFORMAT";
    public static final String TAG_ACREALTEXTPARAM = "ACREALTEXTPARAM";
    public static final String TAG_ACMAXCNT = "ACMAXCNT";
    private Properties acExtInfo = null;

    public String getDEACMODEID() {
        return this.GetParamStringValue(TAG_DEACMODEID, "").trim();
    }

    public String getDEACMODENAME() {
        return this.GetParamStringValue(TAG_DEACMODENAME, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getACINFOFORMAT() {
        return this.GetParamStringValue(TAG_ACINFOFORMAT, "");
    }

    public String getACINFOPARAM() {
        return this.GetParamStringValue(TAG_ACINFOPARAM, "");
    }

    public String getACEXTINFO() {
        return this.GetParamStringValue(TAG_ACEXTINFO, "");
    }

    public String getACOBJECT() {
        return this.GetParamStringValue(TAG_ACOBJECT, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setDEACMODEID(String strValue) {
        this.SetParamValue(TAG_DEACMODEID, strValue);
    }

    public void setDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_DEACMODENAME, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public int getDENAME() {
        return this.GetParamIntValue(TAG_DENAME, 0);
    }

    public boolean isENABLEDP() {
        return this.GetParamIntValue(TAG_ISENABLEDP, 0) == 1;
    }

    public String getACSORTFIELD() {
        return this.GetParamStringValue(TAG_ACSORTFIELD, "");
    }

    public String getACSORTDIR() {
        return this.GetParamStringValue(TAG_ACSORTDIR, "");
    }

    public String getACREALTEXTFORMAT() {
        return this.GetParamStringValue(TAG_ACREALTEXTFORMAT, "");
    }

    public void setACREALTEXTFORMAT(String strValue) {
        this.SetParamValue(TAG_ACREALTEXTFORMAT, strValue);
    }

    public String getACREALTEXTPARAM() {
        return this.GetParamStringValue(TAG_ACREALTEXTPARAM, "");
    }

    public void setACREALTEXTPARAM(String strValue) {
        this.SetParamValue(TAG_ACREALTEXTPARAM, strValue);
    }

    public boolean isACMAXCNTNull() {
        return this.IsParamNull(TAG_ACMAXCNT);
    }

    public int getACMAXCNT() {
        return this.GetParamIntValue(TAG_ACMAXCNT, 0);
    }

    public void setACMAXCNT(int strValue) {
        this.SetParamValue(TAG_ACMAXCNT, strValue);
    }

    private synchronized void BuildACExtInfo() {
        try {
            if (this.acExtInfo != null) {
                return;
            }
            String strExtInfo = this.getACEXTINFO();
            if (!StringHelper.IsNullOrEmpty((String)strExtInfo)) {
                this.acExtInfo = new Properties();
                this.acExtInfo = PropertiesHelper.Load((Properties)this.acExtInfo, (String)strExtInfo);
            } else {
                this.acExtInfo = new Properties();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getACExtInfo() {
        if (this.acExtInfo == null) {
            this.BuildACExtInfo();
        }
        return this.acExtInfo;
    }
}

