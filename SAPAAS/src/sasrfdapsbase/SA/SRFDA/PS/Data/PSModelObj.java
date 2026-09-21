/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModelObj
extends BaseDataEntity {
    public static final int DYNAMODELFLAG_0 = 0;
    public static final int DYNAMODELFLAG_1 = 1;
    public static final int DYNAMODELFLAG_2 = 2;
    public static final String TAG_PSMODELOBJID = "PSMODELOBJID";
    public static final String TAG_PSMODELOBJNAME = "PSMODELOBJNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSMODELTYPE = "PSMODELTYPE";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_REALMODELOBJID = "REALMODELOBJID";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PPSMODELOBJID = "PPSMODELOBJID";
    public static final String TAG_PATHNAME = "PATHNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MODELDATA = "MODELDATA";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_MODELDATA2 = "MODELDATA2";
    public static final String TAG_MODELTAG = "MODELTAG";
    public static final String TAG_MODELTAG2 = "MODELTAG2";
    public static final String TAG_PSMODELSUBTYPE = "PSMODELSUBTYPE";

    public final boolean isPSMODELOBJIDNull() {
        return this.IsParamNull(TAG_PSMODELOBJID);
    }

    public final String getPSMODELOBJID() {
        return this.GetParamStringValue(TAG_PSMODELOBJID, "");
    }

    public final void setPSMODELOBJID(String strValue) {
        this.SetParamValue(TAG_PSMODELOBJID, strValue);
    }

    public final boolean isPSMODELOBJNAMENull() {
        return this.IsParamNull(TAG_PSMODELOBJNAME);
    }

    public final String getPSMODELOBJNAME() {
        return this.GetParamStringValue(TAG_PSMODELOBJNAME, "");
    }

    public final void setPSMODELOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELOBJNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSMODELTYPENull() {
        return this.IsParamNull(TAG_PSMODELTYPE);
    }

    public final String getPSMODELTYPE() {
        return this.GetParamStringValue(TAG_PSMODELTYPE, "");
    }

    public final void setPSMODELTYPE(String strValue) {
        this.SetParamValue(TAG_PSMODELTYPE, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isREALMODELOBJIDNull() {
        return this.IsParamNull(TAG_REALMODELOBJID);
    }

    public final String getREALMODELOBJID() {
        return this.GetParamStringValue(TAG_REALMODELOBJID, "");
    }

    public final void setREALMODELOBJID(String strValue) {
        this.SetParamValue(TAG_REALMODELOBJID, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPPSMODELOBJIDNull() {
        return this.IsParamNull(TAG_PPSMODELOBJID);
    }

    public final String getPPSMODELOBJID() {
        return this.GetParamStringValue(TAG_PPSMODELOBJID, "");
    }

    public final void setPPSMODELOBJID(String strValue) {
        this.SetParamValue(TAG_PPSMODELOBJID, strValue);
    }

    public final boolean isPATHNAMENull() {
        return this.IsParamNull(TAG_PATHNAME);
    }

    public final String getPATHNAME() {
        return this.GetParamStringValue(TAG_PATHNAME, "");
    }

    public final void setPATHNAME(String strValue) {
        this.SetParamValue(TAG_PATHNAME, strValue);
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

    public final boolean isMODELDATANull() {
        return this.IsParamNull(TAG_MODELDATA);
    }

    public final String getMODELDATA() {
        return this.GetParamStringValue(TAG_MODELDATA, "");
    }

    public final void setMODELDATA(String strValue) {
        this.SetParamValue(TAG_MODELDATA, strValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isMODELDATA2Null() {
        return this.IsParamNull(TAG_MODELDATA2);
    }

    public final String getMODELDATA2() {
        return this.GetParamStringValue(TAG_MODELDATA2, "");
    }

    public final void setMODELDATA2(String strValue) {
        this.SetParamValue(TAG_MODELDATA2, strValue);
    }

    public final boolean isMODELTAGNull() {
        return this.IsParamNull(TAG_MODELTAG);
    }

    public final String getMODELTAG() {
        return this.GetParamStringValue(TAG_MODELTAG, "");
    }

    public final void setMODELTAG(String strValue) {
        this.SetParamValue(TAG_MODELTAG, strValue);
    }

    public final boolean isMODELTAG2Null() {
        return this.IsParamNull(TAG_MODELTAG2);
    }

    public final String getMODELTAG2() {
        return this.GetParamStringValue(TAG_MODELTAG2, "");
    }

    public final void setMODELTAG2(String strValue) {
        this.SetParamValue(TAG_MODELTAG2, strValue);
    }

    public final boolean isPSMODELSUBTYPENull() {
        return this.IsParamNull(TAG_PSMODELSUBTYPE);
    }

    public final String getPSMODELSUBTYPE() {
        return this.GetParamStringValue(TAG_PSMODELSUBTYPE, "");
    }

    public final void setPSMODELSUBTYPE(String strValue) {
        this.SetParamValue(TAG_PSMODELSUBTYPE, strValue);
    }
}

