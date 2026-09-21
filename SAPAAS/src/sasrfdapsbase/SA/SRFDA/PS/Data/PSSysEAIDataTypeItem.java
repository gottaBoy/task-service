/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEAIDataTypeItem
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSEAIDATATYPEITEMID = "PSSYSEAIDATATYPEITEMID";
    public static final String TAG_PSSYSEAIDATATYPEITEMNAME = "PSSYSEAIDATATYPEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String TAG_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_EAIDATATYPEITEMTAG2 = "EAIDATATYPEITEMTAG2";
    public static final String TAG_EAIDATATYPEITEMTAG = "EAIDATATYPEITEMTAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSEAIDATATYPEITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPEITEMID);
    }

    public final String getPSSYSEAIDATATYPEITEMID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPEITEMID, "");
    }

    public final void setPSSYSEAIDATATYPEITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPEITEMID, strValue);
    }

    public final boolean isPSSYSEAIDATATYPEITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPEITEMNAME);
    }

    public final String getPSSYSEAIDATATYPEITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPEITEMNAME, "");
    }

    public final void setPSSYSEAIDATATYPEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPEITEMNAME, strValue);
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

    public final boolean isPSSYSEAIDATATYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPEID);
    }

    public final String getPSSYSEAIDATATYPEID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPEID, "");
    }

    public final void setPSSYSEAIDATATYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPEID, strValue);
    }

    public final boolean isPSSYSEAIDATATYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPENAME);
    }

    public final String getPSSYSEAIDATATYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPENAME, "");
    }

    public final void setPSSYSEAIDATATYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPENAME, strValue);
    }

    public final boolean isVALUENull() {
        return this.IsParamNull(TAG_VALUE);
    }

    public final String getVALUE() {
        return this.GetParamStringValue(TAG_VALUE, "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue(TAG_VALUE, strValue);
    }

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isEAIDATATYPEITEMTAG2Null() {
        return this.IsParamNull(TAG_EAIDATATYPEITEMTAG2);
    }

    public final String getEAIDATATYPEITEMTAG2() {
        return this.GetParamStringValue(TAG_EAIDATATYPEITEMTAG2, "");
    }

    public final void setEAIDATATYPEITEMTAG2(String strValue) {
        this.SetParamValue(TAG_EAIDATATYPEITEMTAG2, strValue);
    }

    public final boolean isEAIDATATYPEITEMTAGNull() {
        return this.IsParamNull(TAG_EAIDATATYPEITEMTAG);
    }

    public final String getEAIDATATYPEITEMTAG() {
        return this.GetParamStringValue(TAG_EAIDATATYPEITEMTAG, "");
    }

    public final void setEAIDATATYPEITEMTAG(String strValue) {
        this.SetParamValue(TAG_EAIDATATYPEITEMTAG, strValue);
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
}

