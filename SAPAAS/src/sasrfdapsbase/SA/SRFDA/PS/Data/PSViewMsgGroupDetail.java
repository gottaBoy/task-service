/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewMsgGroupDetail
extends BaseDataEntity {
    public static final String MSGPOS_TOP = "TOP";
    public static final String MSGPOS_BOTTOM = "BOTTOM";
    public static final String MSGPOS_POPUP = "POPUP";
    public static final String TAG_PSVIEWMSGGRPDETAILID = "PSVIEWMSGGRPDETAILID";
    public static final String TAG_PSVIEWMSGGRPDETAILNAME = "PSVIEWMSGGRPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String TAG_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String TAG_MSGPOS = "MSGPOS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSVIEWMSGGRPDETAILIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGRPDETAILID);
    }

    public final String getPSVIEWMSGGRPDETAILID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGRPDETAILID, "");
    }

    public final void setPSVIEWMSGGRPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGRPDETAILID, strValue);
    }

    public final boolean isPSVIEWMSGGRPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGRPDETAILNAME);
    }

    public final String getPSVIEWMSGGRPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGRPDETAILNAME, "");
    }

    public final void setPSVIEWMSGGRPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGRPDETAILNAME, strValue);
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

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
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

    public final boolean isPSVIEWMSGIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGID);
    }

    public final String getPSVIEWMSGID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGID, "");
    }

    public final void setPSVIEWMSGID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGID, strValue);
    }

    public final boolean isPSVIEWMSGNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGNAME);
    }

    public final String getPSVIEWMSGNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGNAME, "");
    }

    public final void setPSVIEWMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGNAME, strValue);
    }

    public final boolean isMSGPOSNull() {
        return this.IsParamNull(TAG_MSGPOS);
    }

    public final String getMSGPOS() {
        return this.GetParamStringValue(TAG_MSGPOS, "");
    }

    public final void setMSGPOS(String strValue) {
        this.SetParamValue(TAG_MSGPOS, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

