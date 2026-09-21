/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBValueFuncCode
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String TAG_PSSYSDBVFCODEID = "PSSYSDBVFCODEID";
    public static final String TAG_PSSYSDBVFCODENAME = "PSSYSDBVFCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_FUNCCODE = "FUNCCODE";
    public static final String TAG_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String TAG_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CALLCODE = "CALLCODE";

    public final boolean isPSSYSDBVFCODEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBVFCODEID);
    }

    public final String getPSSYSDBVFCODEID() {
        return this.GetParamStringValue(TAG_PSSYSDBVFCODEID, "");
    }

    public final void setPSSYSDBVFCODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFCODEID, strValue);
    }

    public final boolean isPSSYSDBVFCODENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBVFCODENAME);
    }

    public final String getPSSYSDBVFCODENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBVFCODENAME, "");
    }

    public final void setPSSYSDBVFCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFCODENAME, strValue);
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

    public final boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isFUNCCODENull() {
        return this.IsParamNull(TAG_FUNCCODE);
    }

    public final String getFUNCCODE() {
        return this.GetParamStringValue(TAG_FUNCCODE, "");
    }

    public final void setFUNCCODE(String strValue) {
        this.SetParamValue(TAG_FUNCCODE, strValue);
    }

    public final boolean isPSSYSDBVFIDNull() {
        return this.IsParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.GetParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFNAME, strValue);
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

    public final boolean isCALLCODENull() {
        return this.IsParamNull(TAG_CALLCODE);
    }

    public final String getCALLCODE() {
        return this.GetParamStringValue(TAG_CALLCODE, "");
    }

    public final void setCALLCODE(String strValue) {
        this.SetParamValue(TAG_CALLCODE, strValue);
    }
}

