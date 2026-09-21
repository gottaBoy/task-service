/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DER1NEx
extends BaseDataEntity {
    public static final String TAG_DER1NEXID = "DER1NEXID";
    public static final String TAG_DER1NEXNAME = "DER1NEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DER1NNAME = "DER1NNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DER1NID = "DER1NID";
    public static final String TAG_DEACMODEID = "DEACMODEID";
    public static final String TAG_DEACMODENAME = "DEACMODENAME";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_MAJORDEID = "MAJORDEID";
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_PICKUPPAGENAME = "PICKUPPAGENAME";
    public static final String TAG_RELATEDPAGEID = "RELATEDPAGEID";
    public static final String TAG_RELATEDPAGENAME = "RELATEDPAGENAME";
    public static final String TAG_SHOWNAMELANRESID = "SHOWNAMELANRESID";
    public static final String TAG_SHOWNAMELANRESNAME = "SHOWNAMELANRESNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_MPICKUPPAGEID = "MPICKUPPAGEID";
    public static final String TAG_MPICKUPPAGENAME = "MPICKUPPAGENAME";
    public static final String TAG_DERINDEXID = "DERINDEXID";
    public static final String TAG_DERINDEXNAME = "DERINDEXNAME";
    public static final String TAG_INDEXDEID = "INDEXDEID";

    public boolean isDER1NEXIDNull() {
        return this.IsParamNull(TAG_DER1NEXID);
    }

    public String getDER1NEXID() {
        return this.GetParamStringValue(TAG_DER1NEXID, "");
    }

    public void setDER1NEXID(String strValue) {
        this.SetParamValue(TAG_DER1NEXID, strValue);
    }

    public boolean isDER1NEXNAMENull() {
        return this.IsParamNull(TAG_DER1NEXNAME);
    }

    public String getDER1NEXNAME() {
        return this.GetParamStringValue(TAG_DER1NEXNAME, "");
    }

    public void setDER1NEXNAME(String strValue) {
        this.SetParamValue(TAG_DER1NEXNAME, strValue);
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

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isDER1NNAMENull() {
        return this.IsParamNull(TAG_DER1NNAME);
    }

    public String getDER1NNAME() {
        return this.GetParamStringValue(TAG_DER1NNAME, "");
    }

    public void setDER1NNAME(String strValue) {
        this.SetParamValue(TAG_DER1NNAME, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDER1NIDNull() {
        return this.IsParamNull(TAG_DER1NID);
    }

    public String getDER1NID() {
        return this.GetParamStringValue(TAG_DER1NID, "");
    }

    public void setDER1NID(String strValue) {
        this.SetParamValue(TAG_DER1NID, strValue);
    }

    public boolean isDEACMODEIDNull() {
        return this.IsParamNull(TAG_DEACMODEID);
    }

    public String getDEACMODEID() {
        return this.GetParamStringValue(TAG_DEACMODEID, "");
    }

    public void setDEACMODEID(String strValue) {
        this.SetParamValue(TAG_DEACMODEID, strValue);
    }

    public boolean isDEACMODENAMENull() {
        return this.IsParamNull(TAG_DEACMODENAME);
    }

    public String getDEACMODENAME() {
        return this.GetParamStringValue(TAG_DEACMODENAME, "");
    }

    public void setDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_DEACMODENAME, strValue);
    }

    public boolean isDERTYPEIDNull() {
        return this.IsParamNull(TAG_DERTYPEID);
    }

    public String getDERTYPEID() {
        return this.GetParamStringValue(TAG_DERTYPEID, "");
    }

    public void setDERTYPEID(String strValue) {
        this.SetParamValue(TAG_DERTYPEID, strValue);
    }

    public boolean isDERTYPENAMENull() {
        return this.IsParamNull(TAG_DERTYPENAME);
    }

    public String getDERTYPENAME() {
        return this.GetParamStringValue(TAG_DERTYPENAME, "");
    }

    public void setDERTYPENAME(String strValue) {
        this.SetParamValue(TAG_DERTYPENAME, strValue);
    }

    public boolean isMAJORDEIDNull() {
        return this.IsParamNull(TAG_MAJORDEID);
    }

    public String getMAJORDEID() {
        return this.GetParamStringValue(TAG_MAJORDEID, "");
    }

    public void setMAJORDEID(String strValue) {
        this.SetParamValue(TAG_MAJORDEID, strValue);
    }

    public boolean isPICKUPPAGEIDNull() {
        return this.IsParamNull(TAG_PICKUPPAGEID);
    }

    public String getPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_PICKUPPAGEID, "");
    }

    public void setPICKUPPAGEID(String strValue) {
        this.SetParamValue(TAG_PICKUPPAGEID, strValue);
    }

    public boolean isPICKUPPAGENAMENull() {
        return this.IsParamNull(TAG_PICKUPPAGENAME);
    }

    public String getPICKUPPAGENAME() {
        return this.GetParamStringValue(TAG_PICKUPPAGENAME, "");
    }

    public void setPICKUPPAGENAME(String strValue) {
        this.SetParamValue(TAG_PICKUPPAGENAME, strValue);
    }

    public boolean isRELATEDPAGEIDNull() {
        return this.IsParamNull(TAG_RELATEDPAGEID);
    }

    public String getRELATEDPAGEID() {
        return this.GetParamStringValue(TAG_RELATEDPAGEID, "");
    }

    public void setRELATEDPAGEID(String strValue) {
        this.SetParamValue(TAG_RELATEDPAGEID, strValue);
    }

    public boolean isRELATEDPAGENAMENull() {
        return this.IsParamNull(TAG_RELATEDPAGENAME);
    }

    public String getRELATEDPAGENAME() {
        return this.GetParamStringValue(TAG_RELATEDPAGENAME, "");
    }

    public void setRELATEDPAGENAME(String strValue) {
        this.SetParamValue(TAG_RELATEDPAGENAME, strValue);
    }

    public boolean isSHOWNAMELANRESIDNull() {
        return this.IsParamNull(TAG_SHOWNAMELANRESID);
    }

    public String getSHOWNAMELANRESID() {
        return this.GetParamStringValue(TAG_SHOWNAMELANRESID, "");
    }

    public void setSHOWNAMELANRESID(String strValue) {
        this.SetParamValue(TAG_SHOWNAMELANRESID, strValue);
    }

    public boolean isSHOWNAMELANRESNAMENull() {
        return this.IsParamNull(TAG_SHOWNAMELANRESNAME);
    }

    public String getSHOWNAMELANRESNAME() {
        return this.GetParamStringValue(TAG_SHOWNAMELANRESNAME, "");
    }

    public void setSHOWNAMELANRESNAME(String strValue) {
        this.SetParamValue(TAG_SHOWNAMELANRESNAME, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isSHOWORDERNull() {
        return this.IsParamNull(TAG_SHOWORDER);
    }

    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public void setSHOWORDER(int strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }

    public boolean isMPICKUPPAGEIDNull() {
        return this.IsParamNull(TAG_MPICKUPPAGEID);
    }

    public String getMPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_MPICKUPPAGEID, "");
    }

    public void setMPICKUPPAGEID(String strValue) {
        this.SetParamValue(TAG_MPICKUPPAGEID, strValue);
    }

    public boolean isMPICKUPPAGENAMENull() {
        return this.IsParamNull(TAG_MPICKUPPAGENAME);
    }

    public String getMPICKUPPAGENAME() {
        return this.GetParamStringValue(TAG_MPICKUPPAGENAME, "");
    }

    public void setMPICKUPPAGENAME(String strValue) {
        this.SetParamValue(TAG_MPICKUPPAGENAME, strValue);
    }

    public boolean isDERINDEXIDNull() {
        return this.IsParamNull(TAG_DERINDEXID);
    }

    public String getDERINDEXID() {
        return this.GetParamStringValue(TAG_DERINDEXID, "");
    }

    public void setDERINDEXID(String strValue) {
        this.SetParamValue(TAG_DERINDEXID, strValue);
    }

    public boolean isDERINDEXNAMENull() {
        return this.IsParamNull(TAG_DERINDEXNAME);
    }

    public String getDERINDEXNAME() {
        return this.GetParamStringValue(TAG_DERINDEXNAME, "");
    }

    public void setDERINDEXNAME(String strValue) {
        this.SetParamValue(TAG_DERINDEXNAME, strValue);
    }

    public boolean isINDEXDEIDNull() {
        return this.IsParamNull(TAG_INDEXDEID);
    }

    public String getINDEXDEID() {
        return this.GetParamStringValue(TAG_INDEXDEID, "");
    }

    public void setINDEXDEID(String strValue) {
        this.SetParamValue(TAG_INDEXDEID, strValue);
    }
}

