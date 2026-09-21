/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WF.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPWFWorkTreeNode
extends BaseDataEntity {
    public static final String TAG_PPWFWORKTREENODEID = "PPWFWORKTREENODEID";
    public static final String TAG_PPWFWORKTREENODENAME = "PPWFWORKTREENODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PPWFWORKTREEBARID = "PPWFWORKTREEBARID";
    public static final String TAG_PPWFWORKTREEBARNAME = "PPWFWORKTREEBARNAME";
    public static final String TAG_WFDATAGROUP = "WFDATAGROUP";
    public static final String TAG_NODEVALUE = "NODEVALUE";
    public static final String TAG_OUTPUTFLAG = "OUTPUTFLAG";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_NODENAME = "NODENAME";

    public boolean isPPWFWORKTREENODEIDNull() {
        return this.IsParamNull(TAG_PPWFWORKTREENODEID);
    }

    public String getPPWFWORKTREENODEID() {
        return this.GetParamStringValue(TAG_PPWFWORKTREENODEID, "");
    }

    public void setPPWFWORKTREENODEID(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREENODEID, strValue);
    }

    public boolean isPPWFWORKTREENODENAMENull() {
        return this.IsParamNull(TAG_PPWFWORKTREENODENAME);
    }

    public String getPPWFWORKTREENODENAME() {
        return this.GetParamStringValue(TAG_PPWFWORKTREENODENAME, "");
    }

    public void setPPWFWORKTREENODENAME(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREENODENAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isPPWFWORKTREEBARIDNull() {
        return this.IsParamNull(TAG_PPWFWORKTREEBARID);
    }

    public String getPPWFWORKTREEBARID() {
        return this.GetParamStringValue(TAG_PPWFWORKTREEBARID, "");
    }

    public void setPPWFWORKTREEBARID(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREEBARID, strValue);
    }

    public boolean isPPWFWORKTREEBARNAMENull() {
        return this.IsParamNull(TAG_PPWFWORKTREEBARNAME);
    }

    public String getPPWFWORKTREEBARNAME() {
        return this.GetParamStringValue(TAG_PPWFWORKTREEBARNAME, "");
    }

    public void setPPWFWORKTREEBARNAME(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREEBARNAME, strValue);
    }

    public boolean isWFDATAGROUPNull() {
        return this.IsParamNull(TAG_WFDATAGROUP);
    }

    public String getWFDATAGROUP() {
        return this.GetParamStringValue(TAG_WFDATAGROUP, "");
    }

    public void setWFDATAGROUP(String strValue) {
        this.SetParamValue(TAG_WFDATAGROUP, strValue);
    }

    public boolean isNODEVALUENull() {
        return this.IsParamNull(TAG_NODEVALUE);
    }

    public String getNODEVALUE() {
        return this.GetParamStringValue(TAG_NODEVALUE, "");
    }

    public void setNODEVALUE(String strValue) {
        this.SetParamValue(TAG_NODEVALUE, strValue);
    }

    public boolean isOUTPUTFLAGNull() {
        return this.IsParamNull(TAG_OUTPUTFLAG);
    }

    public boolean getOUTPUTFLAG() {
        return this.GetParamIntValue(TAG_OUTPUTFLAG, 0) == 1;
    }

    public void setOUTPUTFLAG(boolean bValue) {
        this.SetParamValue(TAG_OUTPUTFLAG, bValue ? 1 : 0);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public boolean isNODENAMENull() {
        return this.IsParamNull(TAG_NODENAME);
    }

    public String getNODENAME() {
        return this.GetParamStringValue(TAG_NODENAME, "");
    }

    public void setNODENAME(String strValue) {
        this.SetParamValue(TAG_NODENAME, strValue);
    }
}

