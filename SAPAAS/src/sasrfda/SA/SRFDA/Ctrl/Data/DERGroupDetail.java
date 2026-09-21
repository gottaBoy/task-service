/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DERGroupDetail
extends BaseDataEntity {
    public static final String DETAILTYPE_PAGE = "PAGE";
    public static final String DETAILTYPE_PAGEPATH = "PAGEPATH";
    public static final String DETAILTYPE_DER1N = "DER1N";
    public static final String DETAILTYPE_DER11 = "DER11";
    public static final String DETAILTYPE_WFSTEP = "WFSTEP";
    public static final String DETAILTYPE_WFSTEPACTOR = "WFSTEPACTOR";
    public static final String DETAILTYPE_FILELIST = "FILELIST";
    public static final String DETAILTYPE_DATAAUDIT = "DATAAUDIT";
    public static final String DETAILTYPE_DERTYPE = "DERTYPE";
    public static final String TAG_DERGROUPDETAILID = "DERGROUPDETAILID";
    public static final String TAG_DERGROUPDETAILNAME = "DERGROUPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DERGROUPNAME = "DERGROUPNAME";
    public static final String TAG_DETAILTYPE = "DETAILTYPE";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_DERGROUPID = "DERGROUPID";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_URLPARAM = "URLPARAM";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_DERGROUPFOLDERID = "DERGROUPFOLDERID";
    public static final String TAG_DERGROUPFOLDERNAME = "DERGROUPFOLDERNAME";
    public static final String TAG_DER1NID = "DER1NID";
    public static final String TAG_DER1NNAME = "DER1NNAME";
    public static final String TAG_DER11ID = "DER11ID";
    public static final String TAG_DER11NAME = "DER11NAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_RESOURCEID = "RESOURCEID";

    public boolean isDERGROUPDETAILIDNull() {
        return this.IsParamNull(TAG_DERGROUPDETAILID);
    }

    public String getDERGROUPDETAILID() {
        return this.GetParamStringValue(TAG_DERGROUPDETAILID, "");
    }

    public void setDERGROUPDETAILID(String strValue) {
        this.SetParamValue(TAG_DERGROUPDETAILID, strValue);
    }

    public boolean isDERGROUPDETAILNAMENull() {
        return this.IsParamNull(TAG_DERGROUPDETAILNAME);
    }

    public String getDERGROUPDETAILNAME() {
        return this.GetParamStringValue(TAG_DERGROUPDETAILNAME, "");
    }

    public void setDERGROUPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPDETAILNAME, strValue);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isDERGROUPNAMENull() {
        return this.IsParamNull(TAG_DERGROUPNAME);
    }

    public String getDERGROUPNAME() {
        return this.GetParamStringValue(TAG_DERGROUPNAME, "");
    }

    public void setDERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPNAME, strValue);
    }

    public boolean isDETAILTYPENull() {
        return this.IsParamNull(TAG_DETAILTYPE);
    }

    public String getDETAILTYPE() {
        return this.GetParamStringValue(TAG_DETAILTYPE, "");
    }

    public void setDETAILTYPE(String strValue) {
        this.SetParamValue(TAG_DETAILTYPE, strValue);
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

    public boolean isPAGEPATHNull() {
        return this.IsParamNull("PAGEPATH");
    }

    public String getPAGEPATH() {
        return this.GetParamStringValue("PAGEPATH", "");
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue("PAGEPATH", strValue);
    }

    public boolean isDERGROUPIDNull() {
        return this.IsParamNull(TAG_DERGROUPID);
    }

    public String getDERGROUPID() {
        return this.GetParamStringValue(TAG_DERGROUPID, "");
    }

    public void setDERGROUPID(String strValue) {
        this.SetParamValue(TAG_DERGROUPID, strValue);
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

    public boolean isURLPARAMNull() {
        return this.IsParamNull(TAG_URLPARAM);
    }

    public String getURLPARAM() {
        return this.GetParamStringValue(TAG_URLPARAM, "");
    }

    public void setURLPARAM(String strValue) {
        this.SetParamValue(TAG_URLPARAM, strValue);
    }

    public boolean isSHOWORDERNull() {
        return this.IsParamNull(TAG_SHOWORDER);
    }

    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public void setSHOWORDER(int nValue) {
        this.SetParamValue(TAG_SHOWORDER, nValue);
    }

    public boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public boolean isSMALLICONNull() {
        return this.IsParamNull(TAG_SMALLICON);
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public boolean isDERGROUPFOLDERIDNull() {
        return this.IsParamNull(TAG_DERGROUPFOLDERID);
    }

    public String getDERGROUPFOLDERID() {
        return this.GetParamStringValue(TAG_DERGROUPFOLDERID, "");
    }

    public void setDERGROUPFOLDERID(String strValue) {
        this.SetParamValue(TAG_DERGROUPFOLDERID, strValue);
    }

    public boolean isDERGROUPFOLDERNAMENull() {
        return this.IsParamNull(TAG_DERGROUPFOLDERNAME);
    }

    public String getDERGROUPFOLDERNAME() {
        return this.GetParamStringValue(TAG_DERGROUPFOLDERNAME, "");
    }

    public void setDERGROUPFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPFOLDERNAME, strValue);
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

    public boolean isDER1NNAMENull() {
        return this.IsParamNull(TAG_DER1NNAME);
    }

    public String getDER1NNAME() {
        return this.GetParamStringValue(TAG_DER1NNAME, "");
    }

    public void setDER1NNAME(String strValue) {
        this.SetParamValue(TAG_DER1NNAME, strValue);
    }

    public boolean isDER11IDNull() {
        return this.IsParamNull(TAG_DER11ID);
    }

    public String getDER11ID() {
        return this.GetParamStringValue(TAG_DER11ID, "");
    }

    public void setDER11ID(String strValue) {
        this.SetParamValue(TAG_DER11ID, strValue);
    }

    public boolean isDER11NAMENull() {
        return this.IsParamNull(TAG_DER11NAME);
    }

    public String getDER11NAME() {
        return this.GetParamStringValue(TAG_DER11NAME, "");
    }

    public void setDER11NAME(String strValue) {
        this.SetParamValue(TAG_DER11NAME, strValue);
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

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
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

    public final boolean isRESOURCEIDNull() {
        return this.IsParamNull(TAG_RESOURCEID);
    }

    public final String getRESOURCEID() {
        return this.GetParamStringValue(TAG_RESOURCEID, "");
    }

    public final void setRESOURCEID(String strValue) {
        this.SetParamValue(TAG_RESOURCEID, strValue);
    }
}

