/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEAppCustom
extends BaseDataEntity {
    public static final String CUSTOMACTION_REPLACE = "REPLACE";
    public static final String CUSTOMACTION_REMOVE = "REMOVE";
    public static final String CUSTOMACTION_UPDATE = "UPDATE";
    public static final String CUSTOMACTION_SQL = "SQL";
    public static final String TAG_DEAPPCUSTOMID = "DEAPPCUSTOMID";
    public static final String TAG_DEAPPCUSTOMNAME = "DEAPPCUSTOMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_CUSTOMACTION = "CUSTOMACTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DATAID = "DATAID";
    public static final String TAG_SRCDATAID = "SRCDATAID";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_USEOLDNAME = "USEOLDNAME";

    public final boolean isDEAPPCUSTOMIDNull() {
        return this.IsParamNull(TAG_DEAPPCUSTOMID);
    }

    public final String getDEAPPCUSTOMID() {
        return this.GetParamStringValue(TAG_DEAPPCUSTOMID, "");
    }

    public final void setDEAPPCUSTOMID(String strValue) {
        this.SetParamValue(TAG_DEAPPCUSTOMID, strValue);
    }

    public final boolean isDEAPPCUSTOMNAMENull() {
        return this.IsParamNull(TAG_DEAPPCUSTOMNAME);
    }

    public final String getDEAPPCUSTOMNAME() {
        return this.GetParamStringValue(TAG_DEAPPCUSTOMNAME, "");
    }

    public final void setDEAPPCUSTOMNAME(String strValue) {
        this.SetParamValue(TAG_DEAPPCUSTOMNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isCUSTOMACTIONNull() {
        return this.IsParamNull(TAG_CUSTOMACTION);
    }

    public final String getCUSTOMACTION() {
        return this.GetParamStringValue(TAG_CUSTOMACTION, "");
    }

    public final void setCUSTOMACTION(String strValue) {
        this.SetParamValue(TAG_CUSTOMACTION, strValue);
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

    public final boolean isDATAIDNull() {
        return this.IsParamNull(TAG_DATAID);
    }

    public final String getDATAID() {
        return this.GetParamStringValue(TAG_DATAID, "");
    }

    public final void setDATAID(String strValue) {
        this.SetParamValue(TAG_DATAID, strValue);
    }

    public final boolean isSRCDATAIDNull() {
        return this.IsParamNull(TAG_SRCDATAID);
    }

    public final String getSRCDATAID() {
        return this.GetParamStringValue(TAG_SRCDATAID, "");
    }

    public final void setSRCDATAID(String strValue) {
        this.SetParamValue(TAG_SRCDATAID, strValue);
    }

    public final boolean isACTIONPARAMNull() {
        return this.IsParamNull(TAG_ACTIONPARAM);
    }

    public final String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public final void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public final boolean isUSEOLDNAMENull() {
        return this.IsParamNull(TAG_USEOLDNAME);
    }

    public final boolean getUSEOLDNAME() {
        return this.GetParamIntValue(TAG_USEOLDNAME, 0) == 1;
    }

    public final void setUSEOLDNAME(boolean bValue) {
        this.SetParamValue(TAG_USEOLDNAME, bValue ? 1 : 0);
    }
}

