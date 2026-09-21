/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUCMapNode
extends BaseDataEntity {
    public static final String NODETYPE_ACTOR = "ACTOR";
    public static final String NODETYPE_USECASE = "USECASE";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSUCMAPNODEID = "PSSYSUCMAPNODEID";
    public static final String TAG_PSSYSUCMAPNODENAME = "PSSYSUCMAPNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_NODETYPE = "NODETYPE";
    public static final String TAG_PSSYSUCMAPID = "PSSYSUCMAPID";
    public static final String TAG_PSSYSUCMAPNAME = "PSSYSUCMAPNAME";
    public static final String TAG_PSSYSACTORID = "PSSYSACTORID";
    public static final String TAG_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String TAG_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String TAG_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";

    public final boolean isPSSYSUCMAPNODEIDNull() {
        return this.IsParamNull(TAG_PSSYSUCMAPNODEID);
    }

    public final String getPSSYSUCMAPNODEID() {
        return this.GetParamStringValue(TAG_PSSYSUCMAPNODEID, "");
    }

    public final void setPSSYSUCMAPNODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUCMAPNODEID, strValue);
    }

    public final boolean isPSSYSUCMAPNODENAMENull() {
        return this.IsParamNull(TAG_PSSYSUCMAPNODENAME);
    }

    public final String getPSSYSUCMAPNODENAME() {
        return this.GetParamStringValue(TAG_PSSYSUCMAPNODENAME, "");
    }

    public final void setPSSYSUCMAPNODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUCMAPNODENAME, strValue);
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

    public final boolean isNODETYPENull() {
        return this.IsParamNull(TAG_NODETYPE);
    }

    public final String getNODETYPE() {
        return this.GetParamStringValue(TAG_NODETYPE, "");
    }

    public final void setNODETYPE(String strValue) {
        this.SetParamValue(TAG_NODETYPE, strValue);
    }

    public final boolean isPSSYSUCMAPIDNull() {
        return this.IsParamNull(TAG_PSSYSUCMAPID);
    }

    public final String getPSSYSUCMAPID() {
        return this.GetParamStringValue(TAG_PSSYSUCMAPID, "");
    }

    public final void setPSSYSUCMAPID(String strValue) {
        this.SetParamValue(TAG_PSSYSUCMAPID, strValue);
    }

    public final boolean isPSSYSUCMAPNAMENull() {
        return this.IsParamNull(TAG_PSSYSUCMAPNAME);
    }

    public final String getPSSYSUCMAPNAME() {
        return this.GetParamStringValue(TAG_PSSYSUCMAPNAME, "");
    }

    public final void setPSSYSUCMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUCMAPNAME, strValue);
    }

    public final boolean isPSSYSACTORIDNull() {
        return this.IsParamNull(TAG_PSSYSACTORID);
    }

    public final String getPSSYSACTORID() {
        return this.GetParamStringValue(TAG_PSSYSACTORID, "");
    }

    public final void setPSSYSACTORID(String strValue) {
        this.SetParamValue(TAG_PSSYSACTORID, strValue);
    }

    public final boolean isPSSYSACTORNAMENull() {
        return this.IsParamNull(TAG_PSSYSACTORNAME);
    }

    public final String getPSSYSACTORNAME() {
        return this.GetParamStringValue(TAG_PSSYSACTORNAME, "");
    }

    public final void setPSSYSACTORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSACTORNAME, strValue);
    }

    public final boolean isPSSYSUSERCASEIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERCASEID);
    }

    public final String getPSSYSUSERCASEID() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASEID, "");
    }

    public final void setPSSYSUSERCASEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASEID, strValue);
    }

    public final boolean isPSSYSUSERCASENAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERCASENAME);
    }

    public final String getPSSYSUSERCASENAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASENAME, "");
    }

    public final void setPSSYSUSERCASENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASENAME, strValue);
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

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }
}

