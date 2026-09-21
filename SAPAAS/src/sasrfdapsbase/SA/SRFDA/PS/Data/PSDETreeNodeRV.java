/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETreeNodeRV
extends BaseDataEntity {
    public static final String TAG_PSDETREENODERVID = "PSDETREENODERVID";
    public static final String TAG_PSDETREENODERVNAME = "PSDETREENODERVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDETREENODEID = "PSDETREENODEID";
    public static final String TAG_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

    public final boolean isPSDETREENODERVIDNull() {
        return this.IsParamNull(TAG_PSDETREENODERVID);
    }

    public final String getPSDETREENODERVID() {
        return this.GetParamStringValue(TAG_PSDETREENODERVID, "");
    }

    public final void setPSDETREENODERVID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODERVID, strValue);
    }

    public final boolean isPSDETREENODERVNAMENull() {
        return this.IsParamNull(TAG_PSDETREENODERVNAME);
    }

    public final String getPSDETREENODERVNAME() {
        return this.GetParamStringValue(TAG_PSDETREENODERVNAME, "");
    }

    public final void setPSDETREENODERVNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODERVNAME, strValue);
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

    public final boolean isPSDETREENODEIDNull() {
        return this.IsParamNull(TAG_PSDETREENODEID);
    }

    public final String getPSDETREENODEID() {
        return this.GetParamStringValue(TAG_PSDETREENODEID, "");
    }

    public final void setPSDETREENODEID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODEID, strValue);
    }

    public final boolean isPSDETREENODENAMENull() {
        return this.IsParamNull(TAG_PSDETREENODENAME);
    }

    public final String getPSDETREENODENAME() {
        return this.GetParamStringValue(TAG_PSDETREENODENAME, "");
    }

    public final void setPSDETREENODENAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODENAME, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
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

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }
}

