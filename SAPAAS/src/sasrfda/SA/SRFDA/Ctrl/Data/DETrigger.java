/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DETrigger
extends BaseDataEntity {
    public static final String TRIGGERACTION_BEFORE = "BEFORE";
    public static final String TRIGGERACTION_AFTER = "AFTER";
    public static final String TRIGGERACTION_INSTEADOF = "INSTEADOF";
    public static final String TRIGGEREVENT_INSERT = "INSERT";
    public static final String TRIGGEREVENT_UPDATE = "UPDATE";
    public static final String TRIGGEREVENT_DELETE = "DELETE";
    public static final String TRIGGERTARGET_TABLE = "TABLE";
    public static final String TRIGGERTARGET_VIEW = "VIEW";
    public static final String TAG_DETRIGGERID = "DETRIGGERID";
    public static final String TAG_DETRIGGERNAME = "DETRIGGERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TGACTION = "TGACTION";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_TGEVENT = "TGEVENT";
    public static final String TAG_COLUMNS = "COLUMNS";
    public static final String TAG_TGVERSION = "TGVERSION";
    public static final String TAG_TGTARGET = "TGTARGET";
    public static final String TAG_NEWROWALIAS = "NEWROWALIAS";
    public static final String TAG_OLDROWALIAS = "OLDROWALIAS";
    public static final String TAG_OLDTABLEALIAS = "OLDTABLEALIAS";
    public static final String TAG_NEWTABLEALIAS = "NEWTABLEALIAS";

    public String getDETRIGGERID() {
        return this.GetParamStringValue(TAG_DETRIGGERID, "");
    }

    public void setDETRIGGERID(String strValue) {
        this.SetParamValue(TAG_DETRIGGERID, strValue);
    }

    public String getDETRIGGERNAME() {
        return this.GetParamStringValue(TAG_DETRIGGERNAME, "");
    }

    public void setDETRIGGERNAME(String strValue) {
        this.SetParamValue(TAG_DETRIGGERNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getTGACTION() {
        return this.GetParamStringValue(TAG_TGACTION, "");
    }

    public void setTGACTION(String strValue) {
        this.SetParamValue(TAG_TGACTION, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getTGEVENT() {
        return this.GetParamStringValue(TAG_TGEVENT, "");
    }

    public void setTGEVENT(String strValue) {
        this.SetParamValue(TAG_TGEVENT, strValue);
    }

    public String getCOLUMNS() {
        return this.GetParamStringValue(TAG_COLUMNS, "");
    }

    public void setCOLUMNS(String strValue) {
        this.SetParamValue(TAG_COLUMNS, strValue);
    }

    public int getTGVERSION() {
        return this.GetParamIntValue(TAG_TGVERSION, 0);
    }

    public void setTGVERSION(int strValue) {
        this.SetParamValue(TAG_TGVERSION, strValue);
    }

    public String getTGTARGET() {
        return this.GetParamStringValue(TAG_TGTARGET, "");
    }

    public void setTGTARGET(String strValue) {
        this.SetParamValue(TAG_TGTARGET, strValue);
    }

    public String getNEWROWALIAS() {
        return this.GetParamStringValue(TAG_NEWROWALIAS, "");
    }

    public void setNEWROWALIAS(String strValue) {
        this.SetParamValue(TAG_NEWROWALIAS, strValue);
    }

    public String getOLDROWALIAS() {
        return this.GetParamStringValue(TAG_OLDROWALIAS, "");
    }

    public void setOLDROWALIAS(String strValue) {
        this.SetParamValue(TAG_OLDROWALIAS, strValue);
    }

    public String getOLDTABLEALIAS() {
        return this.GetParamStringValue(TAG_OLDTABLEALIAS, "");
    }

    public void setOLDTABLEALIAS(String strValue) {
        this.SetParamValue(TAG_OLDTABLEALIAS, strValue);
    }

    public String getNEWTABLEALIAS() {
        return this.GetParamStringValue(TAG_NEWTABLEALIAS, "");
    }

    public void setNEWTABLEALIAS(String strValue) {
        this.SetParamValue(TAG_NEWTABLEALIAS, strValue);
    }
}

