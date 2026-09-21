/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSPanelLogicLink
extends BaseDataEntity {
    public static final String LINKTYPE_ROUTE = "ROUTE";
    public static final String LINKTYPE_CALLBACK = "CALLBACK";
    public static final String TAG_PSPANELLOGICLINKID = "PSPANELLOGICLINKID";
    public static final String TAG_PSPANELLOGICLINKNAME = "PSPANELLOGICLINKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LINKINFO = "LINKINFO";
    public static final String TAG_DSTENDPOINT = "DSTENDPOINT";
    public static final String TAG_SRCENDPOINT = "SRCENDPOINT";
    public static final String TAG_CONDMODEL = "CONDMODEL";
    public static final String TAG_DEFAULTLINK = "DEFAULTLINK";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String TAG_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String TAG_SRCPSPANELLOGICNODEID = "SRCPSPANELLOGICNODEID";
    public static final String TAG_SRCPSPANELLOGICNODENAME = "SRCPSPANELLOGICNODENAME";
    public static final String TAG_DSTPSPANELLOGICNODEID = "DSTPSPANELLOGICNODEID";
    public static final String TAG_DSTPSPANELLOGICNODENAME = "DSTPSPANELLOGICNODENAME";
    public static final String TAG_CALLBACKNAME = "CALLBACKNAME";
    public static final String TAG_LINKTYPE = "LINKTYPE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    private ArrayList<PSPanelLogicLinkCond> childPSPanelLogicLinkCondList = null;

    public final boolean isPSPANELLOGICLINKIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICLINKID);
    }

    public final String getPSPANELLOGICLINKID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICLINKID, "");
    }

    public final void setPSPANELLOGICLINKID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICLINKID, strValue);
    }

    public final boolean isPSPANELLOGICLINKNAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICLINKNAME);
    }

    public final String getPSPANELLOGICLINKNAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICLINKNAME, "");
    }

    public final void setPSPANELLOGICLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICLINKNAME, strValue);
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

    public final boolean isLINKINFONull() {
        return this.IsParamNull(TAG_LINKINFO);
    }

    public final String getLINKINFO() {
        return this.GetParamStringValue(TAG_LINKINFO, "");
    }

    public final void setLINKINFO(String strValue) {
        this.SetParamValue(TAG_LINKINFO, strValue);
    }

    public final boolean isDSTENDPOINTNull() {
        return this.IsParamNull(TAG_DSTENDPOINT);
    }

    public final String getDSTENDPOINT() {
        return this.GetParamStringValue(TAG_DSTENDPOINT, "");
    }

    public final void setDSTENDPOINT(String strValue) {
        this.SetParamValue(TAG_DSTENDPOINT, strValue);
    }

    public final boolean isSRCENDPOINTNull() {
        return this.IsParamNull(TAG_SRCENDPOINT);
    }

    public final String getSRCENDPOINT() {
        return this.GetParamStringValue(TAG_SRCENDPOINT, "");
    }

    public final void setSRCENDPOINT(String strValue) {
        this.SetParamValue(TAG_SRCENDPOINT, strValue);
    }

    public final boolean isCONDMODELNull() {
        return this.IsParamNull(TAG_CONDMODEL);
    }

    public final String getCONDMODEL() {
        return this.GetParamStringValue(TAG_CONDMODEL, "");
    }

    public final void setCONDMODEL(String strValue) {
        this.SetParamValue(TAG_CONDMODEL, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isPSSYSVIEWPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICID);
    }

    public final String getPSSYSVIEWPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICID, "");
    }

    public final void setPSSYSVIEWPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICNAME);
    }

    public final String getPSSYSVIEWPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICNAME, "");
    }

    public final void setPSSYSVIEWPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICNAME, strValue);
    }

    public final boolean isSRCPSPANELLOGICNODEIDNull() {
        return this.IsParamNull(TAG_SRCPSPANELLOGICNODEID);
    }

    public final String getSRCPSPANELLOGICNODEID() {
        return this.GetParamStringValue(TAG_SRCPSPANELLOGICNODEID, "");
    }

    public final void setSRCPSPANELLOGICNODEID(String strValue) {
        this.SetParamValue(TAG_SRCPSPANELLOGICNODEID, strValue);
    }

    public final boolean isSRCPSPANELLOGICNODENAMENull() {
        return this.IsParamNull(TAG_SRCPSPANELLOGICNODENAME);
    }

    public final String getSRCPSPANELLOGICNODENAME() {
        return this.GetParamStringValue(TAG_SRCPSPANELLOGICNODENAME, "");
    }

    public final void setSRCPSPANELLOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_SRCPSPANELLOGICNODENAME, strValue);
    }

    public final boolean isDSTPSPANELLOGICNODEIDNull() {
        return this.IsParamNull(TAG_DSTPSPANELLOGICNODEID);
    }

    public final String getDSTPSPANELLOGICNODEID() {
        return this.GetParamStringValue(TAG_DSTPSPANELLOGICNODEID, "");
    }

    public final void setDSTPSPANELLOGICNODEID(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLOGICNODEID, strValue);
    }

    public final boolean isDSTPSPANELLOGICNODENAMENull() {
        return this.IsParamNull(TAG_DSTPSPANELLOGICNODENAME);
    }

    public final String getDSTPSPANELLOGICNODENAME() {
        return this.GetParamStringValue(TAG_DSTPSPANELLOGICNODENAME, "");
    }

    public final void setDSTPSPANELLOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLOGICNODENAME, strValue);
    }

    public final boolean isCALLBACKNAMENull() {
        return this.IsParamNull(TAG_CALLBACKNAME);
    }

    public final String getCALLBACKNAME() {
        return this.GetParamStringValue(TAG_CALLBACKNAME, "");
    }

    public final void setCALLBACKNAME(String strValue) {
        this.SetParamValue(TAG_CALLBACKNAME, strValue);
    }

    public final boolean isLINKTYPENull() {
        return this.IsParamNull(TAG_LINKTYPE);
    }

    public final String getLINKTYPE() {
        return this.GetParamStringValue(TAG_LINKTYPE, "");
    }

    public final void setLINKTYPE(String strValue) {
        this.SetParamValue(TAG_LINKTYPE, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public ArrayList<PSPanelLogicLinkCond> getPSPanelLogicLinkConds(boolean bCreated) {
        if (this.childPSPanelLogicLinkCondList != null) {
            return this.childPSPanelLogicLinkCondList;
        }
        if (bCreated) {
            this.childPSPanelLogicLinkCondList = new ArrayList();
        }
        return this.childPSPanelLogicLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSPanelLogicLinkCondList != null) {
            this.childPSPanelLogicLinkCondList.clear();
            this.childPSPanelLogicLinkCondList = null;
        }
    }
}

