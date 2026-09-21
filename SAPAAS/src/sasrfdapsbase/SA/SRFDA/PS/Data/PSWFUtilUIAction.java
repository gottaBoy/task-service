/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWFUtilUIAction
extends BaseDataEntity {
    public static final String UTILTYPE_SENDBACK = "SENDBACK";
    public static final String UTILTYPE_SUPPLYINFO = "SUPPLYINFO";
    public static final String UTILTYPE_ADDSTEPBEFORE = "ADDSTEPBEFORE";
    public static final String UTILTYPE_ADDSTEPAFTER = "ADDSTEPAFTER";
    public static final String TAG_PSWFUTILUIACTIONID = "PSWFUTILUIACTIONID";
    public static final String TAG_PSWFUTILUIACTIONNAME = "PSWFUTILUIACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSWFSETTINGID = "PSSYSWFSETTINGID";
    public static final String TAG_PSSYSWFSETTINGNAME = "PSSYSWFSETTINGNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UTILTYPE = "UTILTYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String TAG_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";

    public final boolean isPSWFUTILUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSWFUTILUIACTIONID);
    }

    public final String getPSWFUTILUIACTIONID() {
        return this.GetParamStringValue(TAG_PSWFUTILUIACTIONID, "");
    }

    public final void setPSWFUTILUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSWFUTILUIACTIONID, strValue);
    }

    public final boolean isPSWFUTILUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSWFUTILUIACTIONNAME);
    }

    public final String getPSWFUTILUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSWFUTILUIACTIONNAME, "");
    }

    public final void setPSWFUTILUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFUTILUIACTIONNAME, strValue);
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

    public final boolean isPSSYSWFSETTINGIDNull() {
        return this.IsParamNull(TAG_PSSYSWFSETTINGID);
    }

    public final String getPSSYSWFSETTINGID() {
        return this.GetParamStringValue(TAG_PSSYSWFSETTINGID, "");
    }

    public final void setPSSYSWFSETTINGID(String strValue) {
        this.SetParamValue(TAG_PSSYSWFSETTINGID, strValue);
    }

    public final boolean isPSSYSWFSETTINGNAMENull() {
        return this.IsParamNull(TAG_PSSYSWFSETTINGNAME);
    }

    public final String getPSSYSWFSETTINGNAME() {
        return this.GetParamStringValue(TAG_PSSYSWFSETTINGNAME, "");
    }

    public final void setPSSYSWFSETTINGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSWFSETTINGNAME, strValue);
    }

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
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

    public final boolean isUTILTYPENull() {
        return this.IsParamNull(TAG_UTILTYPE);
    }

    public final String getUTILTYPE() {
        return this.GetParamStringValue(TAG_UTILTYPE, "");
    }

    public final void setUTILTYPE(String strValue) {
        this.SetParamValue(TAG_UTILTYPE, strValue);
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

    public final boolean isPSWORKFLOWIDNull() {
        return this.IsParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.GetParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.IsParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }
}

