/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTUserGroup
extends BaseDataEntity {
    public static final String WTUSEROBJECTTYPE_USER = "USER";
    public static final String WTUSEROBJECTTYPE_USERGROUP = "USERGROUP";
    public static final String VALIDFLAG_1 = "1";
    public static final String VALIDFLAG_0 = "0";
    public static final String TAG_WTUSERGROUPID = "WTUSERGROUPID";
    public static final String TAG_WTUSERGROUPNAME = "WTUSERGROUPNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_WTUSEROBJECTTYPE = "WTUSEROBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_WTUSEROBJECTNO = "WTUSEROBJECTNO";
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_USERCOUNT = "USERCOUNT";

    public final boolean isWTUSERGROUPIDNull() {
        return this.IsParamNull(TAG_WTUSERGROUPID);
    }

    public final String getWTUSERGROUPID() {
        return this.GetParamStringValue(TAG_WTUSERGROUPID, "");
    }

    public final void setWTUSERGROUPID(String strValue) {
        this.SetParamValue(TAG_WTUSERGROUPID, strValue);
    }

    public final boolean isWTUSERGROUPNAMENull() {
        return this.IsParamNull(TAG_WTUSERGROUPNAME);
    }

    public final String getWTUSERGROUPNAME() {
        return this.GetParamStringValue(TAG_WTUSERGROUPNAME, "");
    }

    public final void setWTUSERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_WTUSERGROUPNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isWTUSEROBJECTTYPENull() {
        return this.IsParamNull(TAG_WTUSEROBJECTTYPE);
    }

    public final String getWTUSEROBJECTTYPE() {
        return this.GetParamStringValue(TAG_WTUSEROBJECTTYPE, "");
    }

    public final void setWTUSEROBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_WTUSEROBJECTTYPE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isWTUSEROBJECTNONull() {
        return this.IsParamNull(TAG_WTUSEROBJECTNO);
    }

    public final String getWTUSEROBJECTNO() {
        return this.GetParamStringValue(TAG_WTUSEROBJECTNO, "");
    }

    public final void setWTUSEROBJECTNO(String strValue) {
        this.SetParamValue(TAG_WTUSEROBJECTNO, strValue);
    }

    public final boolean isWTACCOUNTIDNull() {
        return this.IsParamNull(TAG_WTACCOUNTID);
    }

    public final String getWTACCOUNTID() {
        return this.GetParamStringValue(TAG_WTACCOUNTID, "");
    }

    public final void setWTACCOUNTID(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTID, strValue);
    }

    public final boolean isWTACCOUNTNAMENull() {
        return this.IsParamNull(TAG_WTACCOUNTNAME);
    }

    public final String getWTACCOUNTNAME() {
        return this.GetParamStringValue(TAG_WTACCOUNTNAME, "");
    }

    public final void setWTACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTNAME, strValue);
    }

    public final boolean isUSERCOUNTNull() {
        return this.IsParamNull(TAG_USERCOUNT);
    }

    public final int getUSERCOUNT() {
        return this.GetParamIntValue(TAG_USERCOUNT, 0);
    }

    public final void setUSERCOUNT(int nValue) {
        this.SetParamValue(TAG_USERCOUNT, nValue);
    }
}

