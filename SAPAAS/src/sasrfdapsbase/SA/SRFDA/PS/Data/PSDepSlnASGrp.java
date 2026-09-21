/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDepSlnASGrp
extends BaseDataEntity {
    public static final String ASTYPE_TOMCAT7 = "TOMCAT7";
    public static final String GROUPMODE_RR = "RR";
    public static final String GROUPMODE_ip_hash = "ip_hash";
    public static final String TAG_PSDEPSLNASGRPID = "PSDEPSLNASGRPID";
    public static final String TAG_PSDEPSLNASGRPNAME = "PSDEPSLNASGRPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ASTYPE = "ASTYPE";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String TAG_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String TAG_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String TAG_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String TAG_PSDCASGROUPID = "PSDCASGROUPID";
    public static final String TAG_PSDCASGROUPNAME = "PSDCASGROUPNAME";
    public static final String TAG_GROUPMODE = "GROUPMODE";
    private ArrayList<PSDepSlnASItem> childPSDepSlnASItemList = null;

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

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
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

    public final boolean isASTYPENull() {
        return this.IsParamNull(TAG_ASTYPE);
    }

    public final String getASTYPE() {
        return this.GetParamStringValue(TAG_ASTYPE, "");
    }

    public final void setASTYPE(String strValue) {
        this.SetParamValue(TAG_ASTYPE, strValue);
    }

    public final boolean isHTTPPORTNull() {
        return this.IsParamNull(TAG_HTTPPORT);
    }

    public final int getHTTPPORT() {
        return this.GetParamIntValue(TAG_HTTPPORT, 0);
    }

    public final void setHTTPPORT(int nValue) {
        this.SetParamValue(TAG_HTTPPORT, nValue);
    }

    public final boolean isHTTPSPORTNull() {
        return this.IsParamNull(TAG_HTTPSPORT);
    }

    public final int getHTTPSPORT() {
        return this.GetParamIntValue(TAG_HTTPSPORT, 0);
    }

    public final void setHTTPSPORT(int nValue) {
        this.SetParamValue(TAG_HTTPSPORT, nValue);
    }

    public final boolean isPSDEPSLNHOSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTID);
    }

    public final String getPSDEPSLNHOSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTID, "");
    }

    public final void setPSDEPSLNHOSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTID, strValue);
    }

    public final boolean isPSDEPSLNHOSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTNAME);
    }

    public final String getPSDEPSLNHOSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTNAME, "");
    }

    public final void setPSDEPSLNHOSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTNAME, strValue);
    }

    public final boolean isENABLELOCALMODENull() {
        return this.IsParamNull(TAG_ENABLELOCALMODE);
    }

    public final boolean getENABLELOCALMODE() {
        return this.GetParamIntValue(TAG_ENABLELOCALMODE, 0) == 1;
    }

    public final void setENABLELOCALMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLELOCALMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEREMOTEMODENull() {
        return this.IsParamNull(TAG_ENABLEREMOTEMODE);
    }

    public final boolean getENABLEREMOTEMODE() {
        return this.GetParamIntValue(TAG_ENABLEREMOTEMODE, 0) == 1;
    }

    public final void setENABLEREMOTEMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEREMOTEMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDCASGROUPIDNull() {
        return this.IsParamNull(TAG_PSDCASGROUPID);
    }

    public final String getPSDCASGROUPID() {
        return this.GetParamStringValue(TAG_PSDCASGROUPID, "");
    }

    public final void setPSDCASGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDCASGROUPID, strValue);
    }

    public final boolean isPSDCASGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDCASGROUPNAME);
    }

    public final String getPSDCASGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDCASGROUPNAME, "");
    }

    public final void setPSDCASGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDCASGROUPNAME, strValue);
    }

    public final boolean isGROUPMODENull() {
        return this.IsParamNull(TAG_GROUPMODE);
    }

    public final String getGROUPMODE() {
        return this.GetParamStringValue(TAG_GROUPMODE, "");
    }

    public final void setGROUPMODE(String strValue) {
        this.SetParamValue(TAG_GROUPMODE, strValue);
    }

    public ArrayList<PSDepSlnASItem> getPSDepSlnASItems(boolean bCreated) {
        if (this.childPSDepSlnASItemList != null) {
            return this.childPSDepSlnASItemList;
        }
        if (bCreated) {
            this.childPSDepSlnASItemList = new ArrayList();
        }
        return this.childPSDepSlnASItemList;
    }

    public void resetChildDatas() {
        if (this.childPSDepSlnASItemList != null) {
            this.childPSDepSlnASItemList.clear();
            this.childPSDepSlnASItemList = null;
        }
    }
}

