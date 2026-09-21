/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnASItem
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNASITEMID = "PSDEPSLNASITEMID";
    public static final String TAG_PSDEPSLNASITEMNAME = "PSDEPSLNASITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNASID = "PSDEPSLNASID";
    public static final String TAG_PSDEPSLNASNAME = "PSDEPSLNASNAME";
    public static final String TAG_PSDEPSLNASGRPID = "PSDEPSLNASGRPID";
    public static final String TAG_PSDEPSLNASGRPNAME = "PSDEPSLNASGRPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_BACKUPMODE = "BACKUPMODE";
    public static final String TAG_WEIGHT = "WEIGHT";
    public static final String TAG_MAXFAILS = "MAXFAILS";
    public static final String TAG_FAILTIMEOUT = "FAILTIMEOUT";

    public final boolean isPSDEPSLNASITEMIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNASITEMID);
    }

    public final String getPSDEPSLNASITEMID() {
        return this.GetParamStringValue(TAG_PSDEPSLNASITEMID, "");
    }

    public final void setPSDEPSLNASITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASITEMID, strValue);
    }

    public final boolean isPSDEPSLNASITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNASITEMNAME);
    }

    public final String getPSDEPSLNASITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNASITEMNAME, "");
    }

    public final void setPSDEPSLNASITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASITEMNAME, strValue);
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

    public final boolean isPSDEPSLNASIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNASID);
    }

    public final String getPSDEPSLNASID() {
        return this.GetParamStringValue(TAG_PSDEPSLNASID, "");
    }

    public final void setPSDEPSLNASID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASID, strValue);
    }

    public final boolean isPSDEPSLNASNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNASNAME);
    }

    public final String getPSDEPSLNASNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNASNAME, "");
    }

    public final void setPSDEPSLNASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASNAME, strValue);
    }

    public final boolean isPSDEPSLNASGRPIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNASGRPID);
    }

    public final String getPSDEPSLNASGRPID() {
        return this.GetParamStringValue(TAG_PSDEPSLNASGRPID, "");
    }

    public final void setPSDEPSLNASGRPID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASGRPID, strValue);
    }

    public final boolean isPSDEPSLNASGRPNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNASGRPNAME);
    }

    public final String getPSDEPSLNASGRPNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNASGRPNAME, "");
    }

    public final void setPSDEPSLNASGRPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASGRPNAME, strValue);
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

    public final boolean isBACKUPMODENull() {
        return this.IsParamNull(TAG_BACKUPMODE);
    }

    public final boolean getBACKUPMODE() {
        return this.GetParamIntValue(TAG_BACKUPMODE, 0) == 1;
    }

    public final void setBACKUPMODE(boolean bValue) {
        this.SetParamValue(TAG_BACKUPMODE, bValue ? 1 : 0);
    }

    public final boolean isWEIGHTNull() {
        return this.IsParamNull(TAG_WEIGHT);
    }

    public final int getWEIGHT() {
        return this.GetParamIntValue(TAG_WEIGHT, 0);
    }

    public final void setWEIGHT(int nValue) {
        this.SetParamValue(TAG_WEIGHT, nValue);
    }

    public final boolean isMAXFAILSNull() {
        return this.IsParamNull(TAG_MAXFAILS);
    }

    public final int getMAXFAILS() {
        return this.GetParamIntValue(TAG_MAXFAILS, 0);
    }

    public final void setMAXFAILS(int nValue) {
        this.SetParamValue(TAG_MAXFAILS, nValue);
    }

    public final boolean isFAILTIMEOUTNull() {
        return this.IsParamNull(TAG_FAILTIMEOUT);
    }

    public final int getFAILTIMEOUT() {
        return this.GetParamIntValue(TAG_FAILTIMEOUT, 0);
    }

    public final void setFAILTIMEOUT(int nValue) {
        this.SetParamValue(TAG_FAILTIMEOUT, nValue);
    }
}

