/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDETEIUDetail;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDETEIUpdate
extends BaseDataEntity {
    public static final String TAG_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String TAG_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDETREENODEID = "PSDETREENODEID";
    public static final String TAG_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String TAG_PSDEID = "PSDEID";
    private ArrayList<PSDETEIUDetail> childPSDETEIUDetailList = null;

    public final boolean isPSDETEIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDETEIUPDATEID);
    }

    public final String getPSDETEIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATEID, "");
    }

    public final void setPSDETEIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATEID, strValue);
    }

    public final boolean isPSDETEIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDETEIUPDATENAME);
    }

    public final String getPSDETEIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATENAME, "");
    }

    public final void setPSDETEIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATENAME, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
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

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public ArrayList<PSDETEIUDetail> getPSDETEIUDetails(boolean bCreated) {
        if (this.childPSDETEIUDetailList != null) {
            return this.childPSDETEIUDetailList;
        }
        if (bCreated) {
            this.childPSDETEIUDetailList = new ArrayList();
        }
        return this.childPSDETEIUDetailList;
    }

    public void resetChildDatas() {
        if (this.childPSDETEIUDetailList != null) {
            this.childPSDETEIUDetailList.clear();
            this.childPSDETEIUDetailList = null;
        }
    }
}

