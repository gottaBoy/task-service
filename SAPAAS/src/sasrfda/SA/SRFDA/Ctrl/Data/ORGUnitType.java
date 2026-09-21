/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ORGUnitType
extends BaseDataEntity {
    public static final String TAG_ORGUNITTYPEID = "ORGUNITTYPEID";
    public static final String TAG_ORGUNITTYPENAME = "ORGUNITTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORGUCTEMPLID = "ORGUCTEMPLID";
    public static final String TAG_ORGUCTEMPLNAME = "ORGUCTEMPLNAME";
    public static final String TAG_LEAFUNIT = "LEAFUNIT";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TYPEHELPER = "TYPEHELPER";

    public boolean isORGUNITTYPEIDNull() {
        return this.IsParamNull(TAG_ORGUNITTYPEID);
    }

    public String getORGUNITTYPEID() {
        return this.GetParamStringValue(TAG_ORGUNITTYPEID, "");
    }

    public void setORGUNITTYPEID(String strValue) {
        this.SetParamValue(TAG_ORGUNITTYPEID, strValue);
    }

    public boolean isORGUNITTYPENAMENull() {
        return this.IsParamNull(TAG_ORGUNITTYPENAME);
    }

    public String getORGUNITTYPENAME() {
        return this.GetParamStringValue(TAG_ORGUNITTYPENAME, "");
    }

    public void setORGUNITTYPENAME(String strValue) {
        this.SetParamValue(TAG_ORGUNITTYPENAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isORGUCTEMPLIDNull() {
        return this.IsParamNull(TAG_ORGUCTEMPLID);
    }

    public String getORGUCTEMPLID() {
        return this.GetParamStringValue(TAG_ORGUCTEMPLID, "");
    }

    public void setORGUCTEMPLID(String strValue) {
        this.SetParamValue(TAG_ORGUCTEMPLID, strValue);
    }

    public boolean isORGUCTEMPLNAMENull() {
        return this.IsParamNull(TAG_ORGUCTEMPLNAME);
    }

    public String getORGUCTEMPLNAME() {
        return this.GetParamStringValue(TAG_ORGUCTEMPLNAME, "");
    }

    public void setORGUCTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_ORGUCTEMPLNAME, strValue);
    }

    public boolean isLEAFUNITNull() {
        return this.IsParamNull(TAG_LEAFUNIT);
    }

    public boolean getLEAFUNIT() {
        return this.GetParamIntValue(TAG_LEAFUNIT, 0) == 1;
    }

    public void setLEAFUNIT(boolean bValue) {
        this.SetParamValue(TAG_LEAFUNIT, bValue ? 1 : 0);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public final boolean isTYPEHELPERNull() {
        return this.IsParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.GetParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.SetParamValue(TAG_TYPEHELPER, strValue);
    }
}

