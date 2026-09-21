/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PageLog
extends BaseDataEntity {
    public static final String TAG_PAGELOGID = "PAGELOGID";
    public static final String TAG_PAGELOGNAME = "PAGELOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_CALLSTACKINFO = "CALLSTACKINFO";
    public static final String TAG_FRONTCALL = "FRONTCALL";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_LOGINNAME = "LOGINNAME";
    public static final String TAG_QUERYSTRING = "QUERYSTRING";
    public static final String TAG_LOGLEVEL = "LOGLEVEL";

    public String getPAGELOGID() {
        return this.GetParamStringValue(TAG_PAGELOGID, "");
    }

    public void setPAGELOGID(String strValue) {
        this.SetParamValue(TAG_PAGELOGID, strValue);
    }

    public String getPAGELOGNAME() {
        return this.GetParamStringValue(TAG_PAGELOGNAME, "");
    }

    public void setPAGELOGNAME(String strValue) {
        this.SetParamValue(TAG_PAGELOGNAME, strValue);
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

    public String getPAGEPATH() {
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
    }

    public String getCALLSTACKINFO() {
        return this.GetParamStringValue(TAG_CALLSTACKINFO, "");
    }

    public void setCALLSTACKINFO(String strValue) {
        this.SetParamValue(TAG_CALLSTACKINFO, strValue);
    }

    public boolean getFRONTCALL() {
        return this.GetParamIntValue(TAG_FRONTCALL, 0) == 1;
    }

    public void setFRONTCALL(boolean bValue) {
        this.SetParamValue(TAG_FRONTCALL, bValue ? 1 : 0);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
    }

    public String getLOGINNAME() {
        return this.GetParamStringValue(TAG_LOGINNAME, "");
    }

    public void setLOGINNAME(String strValue) {
        this.SetParamValue(TAG_LOGINNAME, strValue);
    }

    public String getQUERYSTRING() {
        return this.GetParamStringValue(TAG_QUERYSTRING, "");
    }

    public void setQUERYSTRING(String strValue) {
        this.SetParamValue(TAG_QUERYSTRING, strValue);
    }

    public int getLOGLEVEL() {
        return this.GetParamIntValue(TAG_LOGLEVEL, 0);
    }

    public void setLOGLEVEL(int strValue) {
        this.SetParamValue(TAG_LOGLEVEL, strValue);
    }
}

