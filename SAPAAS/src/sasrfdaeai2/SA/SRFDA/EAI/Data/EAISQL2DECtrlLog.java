/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAISQL2DECtrlLog
extends BaseDataEntity {
    public static final String TAG_EAISQL2DECTRLLOGID = "EAISQL2DECTRLLOGID";
    public static final String TAG_EAISQL2DECTRLLOGNAME = "EAISQL2DECTRLLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAISQL2DECTRLID = "EAISQL2DECTRLID";
    public static final String TAG_EAISQL2DECTRLNAME = "EAISQL2DECTRLNAME";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_ROWCOUNT = "ROWCOUNT";
    public static final String TAG_RETCODE = "RETCODE";
    public static final String TAG_RETINFO = "RETINFO";
    public static final String TAG_LASTRUNTAG = "LASTRUNTAG";
    public static final String TAG_LASTRUNTAG2 = "LASTRUNTAG2";
    public static final String TAG_LASTRUNTAG3 = "LASTRUNTAG3";

    public final boolean isEAISQL2DECTRLLOGIDNull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLLOGID);
    }

    public final String getEAISQL2DECTRLLOGID() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLLOGID, "");
    }

    public final void setEAISQL2DECTRLLOGID(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLLOGID, strValue);
    }

    public final boolean isEAISQL2DECTRLLOGNAMENull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLLOGNAME);
    }

    public final String getEAISQL2DECTRLLOGNAME() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLLOGNAME, "");
    }

    public final void setEAISQL2DECTRLLOGNAME(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLLOGNAME, strValue);
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

    public final boolean isEAISQL2DECTRLIDNull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLID);
    }

    public final String getEAISQL2DECTRLID() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLID, "");
    }

    public final void setEAISQL2DECTRLID(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLID, strValue);
    }

    public final boolean isEAISQL2DECTRLNAMENull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLNAME);
    }

    public final String getEAISQL2DECTRLNAME() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLNAME, "");
    }

    public final void setEAISQL2DECTRLNAME(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLNAME, strValue);
    }

    public final boolean isSTARTTIMENull() {
        return this.IsParamNull(TAG_STARTTIME);
    }

    public final Date getSTARTTIME() {
        return this.GetParamDateValue(TAG_STARTTIME, null);
    }

    public final void setSTARTTIME(Date dtValue) {
        this.SetParamValue(TAG_STARTTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public final boolean isROWCOUNTNull() {
        return this.IsParamNull(TAG_ROWCOUNT);
    }

    public final int getROWCOUNT() {
        return this.GetParamIntValue(TAG_ROWCOUNT, 0);
    }

    public final void setROWCOUNT(int nValue) {
        this.SetParamValue(TAG_ROWCOUNT, nValue);
    }

    public final boolean isRETCODENull() {
        return this.IsParamNull(TAG_RETCODE);
    }

    public final int getRETCODE() {
        return this.GetParamIntValue(TAG_RETCODE, 0);
    }

    public final void setRETCODE(int nValue) {
        this.SetParamValue(TAG_RETCODE, nValue);
    }

    public final boolean isRETINFONull() {
        return this.IsParamNull(TAG_RETINFO);
    }

    public final String getRETINFO() {
        return this.GetParamStringValue(TAG_RETINFO, "");
    }

    public final void setRETINFO(String strValue) {
        this.SetParamValue(TAG_RETINFO, strValue);
    }

    public final boolean isLASTRUNTAGNull() {
        return this.IsParamNull(TAG_LASTRUNTAG);
    }

    public final String getLASTRUNTAG() {
        return this.GetParamStringValue(TAG_LASTRUNTAG, "");
    }

    public final void setLASTRUNTAG(String strValue) {
        this.SetParamValue(TAG_LASTRUNTAG, strValue);
    }

    public final boolean isLASTRUNTAG2Null() {
        return this.IsParamNull(TAG_LASTRUNTAG2);
    }

    public final Date getLASTRUNTAG2() {
        return this.GetParamDateValue(TAG_LASTRUNTAG2, null);
    }

    public final void setLASTRUNTAG2(Date dtValue) {
        this.SetParamValue(TAG_LASTRUNTAG2, dtValue);
    }

    public final boolean isLASTRUNTAG3Null() {
        return this.IsParamNull(TAG_LASTRUNTAG3);
    }

    public final int getLASTRUNTAG3() {
        return this.GetParamIntValue(TAG_LASTRUNTAG3, 0);
    }

    public final void setLASTRUNTAG3(int nValue) {
        this.SetParamValue(TAG_LASTRUNTAG3, nValue);
    }
}

