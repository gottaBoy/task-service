/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysERMapNode
extends BaseDataEntity {
    public static final String TAG_PSSYSERMAPNODEID = "PSSYSERMAPNODEID";
    public static final String TAG_PSSYSERMAPNODENAME = "PSSYSERMAPNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSERMAPID = "PSSYSERMAPID";
    public static final String TAG_PSSYSERMAPNAME = "PSSYSERMAPNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSERMAPNODEIDNull() {
        return this.IsParamNull(TAG_PSSYSERMAPNODEID);
    }

    public final String getPSSYSERMAPNODEID() {
        return this.GetParamStringValue(TAG_PSSYSERMAPNODEID, "");
    }

    public final void setPSSYSERMAPNODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPNODEID, strValue);
    }

    public final boolean isPSSYSERMAPNODENAMENull() {
        return this.IsParamNull(TAG_PSSYSERMAPNODENAME);
    }

    public final String getPSSYSERMAPNODENAME() {
        return this.GetParamStringValue(TAG_PSSYSERMAPNODENAME, "");
    }

    public final void setPSSYSERMAPNODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPNODENAME, strValue);
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

    public final boolean isPSSYSERMAPIDNull() {
        return this.IsParamNull(TAG_PSSYSERMAPID);
    }

    public final String getPSSYSERMAPID() {
        return this.GetParamStringValue(TAG_PSSYSERMAPID, "");
    }

    public final void setPSSYSERMAPID(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPID, strValue);
    }

    public final boolean isPSSYSERMAPNAMENull() {
        return this.IsParamNull(TAG_PSSYSERMAPNAME);
    }

    public final String getPSSYSERMAPNAME() {
        return this.GetParamStringValue(TAG_PSSYSERMAPNAME, "");
    }

    public final void setPSSYSERMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPNAME, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
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

