/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFStepActor
extends BaseDataEntity {
    public static final int VERSION_12 = 12;
    public static final String TAG_WFSTEPACTORID = "WFSTEPACTORID";
    public static final String TAG_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    public static final String TAG_WFSTEPID = "WFSTEPID";
    public static final String TAG_ACTORTYPE = "ACTORTYPE";
    public static final String TAG_ACTORID = "ACTORID";
    public static final String TAG_ISREADONLY = "ISREADONLY";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ROLEID = "ROLEID";
    public static final String TAG_READFLAG = "READFLAG";
    public static final String TAG_FIRSTREADTIME = "FIRSTREADTIME";
    public static final int ACTORTYPE_WFACTOR = 1;
    public static final int ACTORTYPE_UDACTOR = 2;
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IAACTIONS = "IAACTIONS";

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getACTORID() {
        return this.GetParamStringValue(TAG_ACTORID, "");
    }

    public String getROLEID() {
        return this.GetParamStringValue(TAG_ROLEID, "");
    }

    public String getWFSTEPID() {
        return this.GetParamStringValue(TAG_WFSTEPID, "");
    }

    public String getWFSTEPACTORID() {
        return this.GetParamStringValue(TAG_WFSTEPACTORID, "");
    }

    public String getWFSTEPACTORNAME() {
        return this.GetParamStringValue(TAG_WFSTEPACTORNAME, "");
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setACTORID(String strValue) {
        this.SetParamValue(TAG_ACTORID, strValue);
    }

    public void setROLEID(String strValue) {
        this.SetParamValue(TAG_ROLEID, strValue);
    }

    public void setWFSTEPID(String strValue) {
        this.SetParamValue(TAG_WFSTEPID, strValue);
    }

    public void setWFSTEPACTORID(String strValue) {
        this.SetParamValue(TAG_WFSTEPACTORID, strValue);
    }

    public void setWFSTEPACTORNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPACTORNAME, strValue);
    }

    public boolean isISREADONLY() {
        return this.GetParamIntValue(TAG_ISREADONLY, 0) == 1;
    }

    public int getACTORTYPE() {
        return this.GetParamIntValue(TAG_ACTORTYPE, 0);
    }

    public void setACTORTYPE(int nValue) {
        this.SetParamValue(TAG_ACTORTYPE, nValue);
    }

    public void setISREADONLY(boolean bValue) {
        this.SetParamValue(TAG_ISREADONLY, bValue ? 1 : 0);
    }

    public final boolean isREADFLAGNull() {
        return this.IsParamNull(TAG_READFLAG);
    }

    public final boolean getREADFLAG() {
        return this.GetParamIntValue(TAG_READFLAG, 0) == 1;
    }

    public final void setREADFLAG(boolean bValue) {
        this.SetParamValue(TAG_READFLAG, bValue ? 1 : 0);
    }

    public final boolean isFIRSTREADTIMENull() {
        return this.IsParamNull(TAG_FIRSTREADTIME);
    }

    public final Date getFIRSTREADTIME() {
        return this.GetParamDateValue(TAG_FIRSTREADTIME, null);
    }

    public final void setFIRSTREADTIME(Date dtValue) {
        this.SetParamValue(TAG_FIRSTREADTIME, dtValue);
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

    public final boolean isIAACTIONSNull() {
        return this.IsParamNull(TAG_IAACTIONS);
    }

    public final String getIAACTIONS() {
        return this.GetParamStringValue(TAG_IAACTIONS, "");
    }

    public final void setIAACTIONS(String strValue) {
        this.SetParamValue(TAG_IAACTIONS, strValue);
    }
}

