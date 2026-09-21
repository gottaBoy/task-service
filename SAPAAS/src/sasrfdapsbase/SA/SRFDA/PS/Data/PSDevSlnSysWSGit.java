/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysWSGit
extends BaseDataEntity {
    public static final String TAG_PSDEVSLNSYSWSGITID = "PSDEVSLNSYSWSGITID";
    public static final String TAG_PSDEVSLNSYSWSGITNAME = "PSDEVSLNSYSWSGITNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String TAG_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_GITUSERNAME = "GITUSERNAME";
    public static final String TAG_GITPASSWORD = "GITPASSWORD";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEVSLNSYSWSGITIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSWSGITID);
    }

    public final String getPSDEVSLNSYSWSGITID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSWSGITID, "");
    }

    public final void setPSDEVSLNSYSWSGITID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSWSGITID, strValue);
    }

    public final boolean isPSDEVSLNSYSWSGITNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSWSGITNAME);
    }

    public final String getPSDEVSLNSYSWSGITNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSWSGITNAME, "");
    }

    public final void setPSDEVSLNSYSWSGITNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSWSGITNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isPSDCWORKSHOPSERVERIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSHOPSERVERID);
    }

    public final String getPSDCWORKSHOPSERVERID() {
        return this.GetParamStringValue(TAG_PSDCWORKSHOPSERVERID, "");
    }

    public final void setPSDCWORKSHOPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSHOPSERVERID, strValue);
    }

    public final boolean isPSDCWORKSHOPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSHOPSERVERNAME);
    }

    public final String getPSDCWORKSHOPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSHOPSERVERNAME, "");
    }

    public final void setPSDCWORKSHOPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSHOPSERVERNAME, strValue);
    }

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
    }

    public final boolean isGITUSERNAMENull() {
        return this.IsParamNull(TAG_GITUSERNAME);
    }

    public final String getGITUSERNAME() {
        return this.GetParamStringValue(TAG_GITUSERNAME, "");
    }

    public final void setGITUSERNAME(String strValue) {
        this.SetParamValue(TAG_GITUSERNAME, strValue);
    }

    public final boolean isGITPASSWORDNull() {
        return this.IsParamNull(TAG_GITPASSWORD);
    }

    public final String getGITPASSWORD() {
        return this.GetParamStringValue(TAG_GITPASSWORD, "");
    }

    public final void setGITPASSWORD(String strValue) {
        this.SetParamValue(TAG_GITPASSWORD, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

