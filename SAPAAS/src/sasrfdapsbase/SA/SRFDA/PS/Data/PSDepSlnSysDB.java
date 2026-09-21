/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnSysDB
extends BaseDataEntity {
    public static final String PSDEPSLNSYSDBNAME_DEFAULT = "DEFAULT";
    public static final String PSDEPSLNSYSDBNAME_DB2 = "DB2";
    public static final String PSDEPSLNSYSDBNAME_DB3 = "DB3";
    public static final String PSDEPSLNSYSDBNAME_DB4 = "DB4";
    public static final String PSDEPSLNDBINSTNAME_DEFAULT = "DEFAULT";
    public static final String PSDEPSLNDBINSTNAME_DB2 = "DB2";
    public static final String PSDEPSLNDBINSTNAME_DB3 = "DB3";
    public static final String PSDEPSLNDBINSTNAME_DB4 = "DB4";
    public static final String TAG_PSDEPSLNSYSDBID = "PSDEPSLNSYSDBID";
    public static final String TAG_PSDEPSLNSYSDBNAME = "PSDEPSLNSYSDBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNDBINSTID = "PSDEPSLNDBINSTID";
    public static final String TAG_PSDEPSLNDBINSTNAME = "PSDEPSLNDBINSTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String TAG_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";

    public final boolean isPSDEPSLNSYSDBIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSDBID);
    }

    public final String getPSDEPSLNSYSDBID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSDBID, "");
    }

    public final void setPSDEPSLNSYSDBID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSDBID, strValue);
    }

    public final boolean isPSDEPSLNSYSDBNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSDBNAME);
    }

    public final String getPSDEPSLNSYSDBNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSDBNAME, "");
    }

    public final void setPSDEPSLNSYSDBNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSDBNAME, strValue);
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

    public final boolean isPSDEPSLNDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNDBINSTID);
    }

    public final String getPSDEPSLNDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNDBINSTID, "");
    }

    public final void setPSDEPSLNDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNDBINSTID, strValue);
    }

    public final boolean isPSDEPSLNDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNDBINSTNAME);
    }

    public final String getPSDEPSLNDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNDBINSTNAME, "");
    }

    public final void setPSDEPSLNDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNDBINSTNAME, strValue);
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

    public final boolean isPSDEPSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSID);
    }

    public final String getPSDEPSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSID, "");
    }

    public final void setPSDEPSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSID, strValue);
    }

    public final boolean isPSDEPSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSNAME);
    }

    public final String getPSDEPSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSNAME, "");
    }

    public final void setPSDEPSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSNAME, strValue);
    }

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
    }
}

