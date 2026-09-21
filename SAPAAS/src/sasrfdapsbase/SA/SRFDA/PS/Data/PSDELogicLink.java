/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDELogicLink
extends BaseDataEntity {
    public static final String TAG_PSDELOGICLINKID = "PSDELOGICLINKID";
    public static final String TAG_PSDELOGICLINKNAME = "PSDELOGICLINKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SRCPSDELOGICNODEID = "SRCPSDELOGICNODEID";
    public static final String TAG_SRCPSDELOGICNODENAME = "SRCPSDELOGICNODENAME";
    public static final String TAG_DSTPSDELOGICNODEID = "DSTPSDELOGICNODEID";
    public static final String TAG_DSTPSDELOGICNODENAME = "DSTPSDELOGICNODENAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_DEFAULTLINK = "DEFAULTLINK";
    public static final String TAG_LINKCOND = "LINKCOND";
    public static final String TAG_LINKCOND2 = "LINKCOND2";
    private ArrayList<PSDELogicLinkCond> childPSDELogicLinkCondList = null;

    public final boolean isPSDELOGICLINKIDNull() {
        return this.IsParamNull(TAG_PSDELOGICLINKID);
    }

    public final String getPSDELOGICLINKID() {
        return this.GetParamStringValue(TAG_PSDELOGICLINKID, "");
    }

    public final void setPSDELOGICLINKID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICLINKID, strValue);
    }

    public final boolean isPSDELOGICLINKNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICLINKNAME);
    }

    public final String getPSDELOGICLINKNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICLINKNAME, "");
    }

    public final void setPSDELOGICLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICLINKNAME, strValue);
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

    public final boolean isSRCPSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_SRCPSDELOGICNODEID);
    }

    public final String getSRCPSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_SRCPSDELOGICNODEID, "");
    }

    public final void setSRCPSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_SRCPSDELOGICNODEID, strValue);
    }

    public final boolean isSRCPSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_SRCPSDELOGICNODENAME);
    }

    public final String getSRCPSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_SRCPSDELOGICNODENAME, "");
    }

    public final void setSRCPSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_SRCPSDELOGICNODENAME, strValue);
    }

    public final boolean isDSTPSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_DSTPSDELOGICNODEID);
    }

    public final String getDSTPSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICNODEID, "");
    }

    public final void setDSTPSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICNODEID, strValue);
    }

    public final boolean isDSTPSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_DSTPSDELOGICNODENAME);
    }

    public final String getDSTPSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICNODENAME, "");
    }

    public final void setDSTPSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICNODENAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isDEFAULTLINKNull() {
        return this.IsParamNull(TAG_DEFAULTLINK);
    }

    public final boolean getDEFAULTLINK() {
        return this.GetParamIntValue(TAG_DEFAULTLINK, 0) == 1;
    }

    public final void setDEFAULTLINK(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTLINK, bValue ? 1 : 0);
    }

    public final boolean isLINKCONDNull() {
        return this.IsParamNull(TAG_LINKCOND);
    }

    public final String getLINKCOND() {
        return this.GetParamStringValue(TAG_LINKCOND, "");
    }

    public final void setLINKCOND(String strValue) {
        this.SetParamValue(TAG_LINKCOND, strValue);
    }

    public final boolean isLINKCOND2Null() {
        return this.IsParamNull(TAG_LINKCOND2);
    }

    public final String getLINKCOND2() {
        return this.GetParamStringValue(TAG_LINKCOND2, "");
    }

    public final void setLINKCOND2(String strValue) {
        this.SetParamValue(TAG_LINKCOND2, strValue);
    }

    public ArrayList<PSDELogicLinkCond> getPSDELogicLinkConds(boolean bCreated) {
        if (this.childPSDELogicLinkCondList != null) {
            return this.childPSDELogicLinkCondList;
        }
        if (bCreated) {
            this.childPSDELogicLinkCondList = new ArrayList();
        }
        return this.childPSDELogicLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDELogicLinkCondList != null) {
            this.childPSDELogicLinkCondList.clear();
            this.childPSDELogicLinkCondList = null;
        }
    }
}

