/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSWPInfoList
extends BaseDataEntity {
    public static final String TAG_WSWPINFOLISTID = "WSWPINFOLISTID";
    public static final String TAG_WSWPINFOLISTNAME = "WSWPINFOLISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISTOP = "ISTOP";
    public static final String TAG_ISPAGING = "ISPAGING";
    public static final String TAG_TOPNUM = "TOPNUM";
    public static final String TAG_HREFTYPE = "HREFTYPE";
    public static final String TAG_INFOFOLDER = "INFOFOLDER";
    public static final String TAG_PAGINGSIZE = "PAGINGSIZE";
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_WSWBTYPEID = "WSWBTYPEID";
    public static final String TAG_WSWBTYPENAME = "WSWBTYPENAME";
    public static final String TAG_WSPAGEID = "WSPAGEID";
    public static final String TAG_WSPAGENAME = "WSPAGENAME";
    public static final String TAG_LISTTYPE = "LISTTYPE";
    public static final String TAG_WSMOREPAGEID = "WSMOREPAGEID";
    public static final String TAG_WSMOREPAGENAME = "WSMOREPAGENAME";

    public boolean isWSWPINFOLISTIDNull() {
        return this.IsParamNull(TAG_WSWPINFOLISTID);
    }

    public String getWSWPINFOLISTID() {
        return this.GetParamStringValue(TAG_WSWPINFOLISTID, "");
    }

    public void setWSWPINFOLISTID(String strValue) {
        this.SetParamValue(TAG_WSWPINFOLISTID, strValue);
    }

    public boolean isWSWPINFOLISTNAMENull() {
        return this.IsParamNull(TAG_WSWPINFOLISTNAME);
    }

    public String getWSWPINFOLISTNAME() {
        return this.GetParamStringValue(TAG_WSWPINFOLISTNAME, "");
    }

    public void setWSWPINFOLISTNAME(String strValue) {
        this.SetParamValue(TAG_WSWPINFOLISTNAME, strValue);
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

    public boolean isISTOPNull() {
        return this.IsParamNull(TAG_ISTOP);
    }

    public boolean getISTOP() {
        return this.GetParamIntValue(TAG_ISTOP, 0) == 1;
    }

    public void setISTOP(boolean bValue) {
        this.SetParamValue(TAG_ISTOP, bValue ? 1 : 0);
    }

    public boolean isISPAGINGNull() {
        return this.IsParamNull(TAG_ISPAGING);
    }

    public boolean getISPAGING() {
        return this.GetParamIntValue(TAG_ISPAGING, 0) == 1;
    }

    public void setISPAGING(boolean bValue) {
        this.SetParamValue(TAG_ISPAGING, bValue ? 1 : 0);
    }

    public boolean isTOPNUMNull() {
        return this.IsParamNull(TAG_TOPNUM);
    }

    public int getTOPNUM() {
        return this.GetParamIntValue(TAG_TOPNUM, 0);
    }

    public void setTOPNUM(int strValue) {
        this.SetParamValue(TAG_TOPNUM, strValue);
    }

    public boolean isHREFTYPENull() {
        return this.IsParamNull(TAG_HREFTYPE);
    }

    public String getHREFTYPE() {
        return this.GetParamStringValue(TAG_HREFTYPE, "");
    }

    public void setHREFTYPE(String strValue) {
        this.SetParamValue(TAG_HREFTYPE, strValue);
    }

    public boolean isINFOFOLDERNull() {
        return this.IsParamNull(TAG_INFOFOLDER);
    }

    public String getINFOFOLDER() {
        return this.GetParamStringValue(TAG_INFOFOLDER, "");
    }

    public void setINFOFOLDER(String strValue) {
        this.SetParamValue(TAG_INFOFOLDER, strValue);
    }

    public boolean isPAGINGSIZENull() {
        return this.IsParamNull(TAG_PAGINGSIZE);
    }

    public int getPAGINGSIZE() {
        return this.GetParamIntValue(TAG_PAGINGSIZE, 0);
    }

    public void setPAGINGSIZE(int strValue) {
        this.SetParamValue(TAG_PAGINGSIZE, strValue);
    }

    public boolean isWSWEBSITEIDNull() {
        return this.IsParamNull(TAG_WSWEBSITEID);
    }

    public String getWSWEBSITEID() {
        return this.GetParamStringValue(TAG_WSWEBSITEID, "");
    }

    public void setWSWEBSITEID(String strValue) {
        this.SetParamValue(TAG_WSWEBSITEID, strValue);
    }

    public boolean isWSWEBSITENAMENull() {
        return this.IsParamNull(TAG_WSWEBSITENAME);
    }

    public String getWSWEBSITENAME() {
        return this.GetParamStringValue(TAG_WSWEBSITENAME, "");
    }

    public void setWSWEBSITENAME(String strValue) {
        this.SetParamValue(TAG_WSWEBSITENAME, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isWSWBTYPEIDNull() {
        return this.IsParamNull(TAG_WSWBTYPEID);
    }

    public String getWSWBTYPEID() {
        return this.GetParamStringValue(TAG_WSWBTYPEID, "");
    }

    public void setWSWBTYPEID(String strValue) {
        this.SetParamValue(TAG_WSWBTYPEID, strValue);
    }

    public boolean isWSWBTYPENAMENull() {
        return this.IsParamNull(TAG_WSWBTYPENAME);
    }

    public String getWSWBTYPENAME() {
        return this.GetParamStringValue(TAG_WSWBTYPENAME, "");
    }

    public void setWSWBTYPENAME(String strValue) {
        this.SetParamValue(TAG_WSWBTYPENAME, strValue);
    }

    public boolean isWSPAGEIDNull() {
        return this.IsParamNull(TAG_WSPAGEID);
    }

    public String getWSPAGEID() {
        return this.GetParamStringValue(TAG_WSPAGEID, "");
    }

    public void setWSPAGEID(String strValue) {
        this.SetParamValue(TAG_WSPAGEID, strValue);
    }

    public boolean isWSPAGENAMENull() {
        return this.IsParamNull(TAG_WSPAGENAME);
    }

    public String getWSPAGENAME() {
        return this.GetParamStringValue(TAG_WSPAGENAME, "");
    }

    public void setWSPAGENAME(String strValue) {
        this.SetParamValue(TAG_WSPAGENAME, strValue);
    }

    public boolean isLISTTYPENull() {
        return this.IsParamNull(TAG_LISTTYPE);
    }

    public String getLISTTYPE() {
        return this.GetParamStringValue(TAG_LISTTYPE, "");
    }

    public void setLISTTYPE(String strValue) {
        this.SetParamValue(TAG_LISTTYPE, strValue);
    }

    public boolean isWSMOREPAGEIDNull() {
        return this.IsParamNull(TAG_WSMOREPAGEID);
    }

    public String getWSMOREPAGEID() {
        return this.GetParamStringValue(TAG_WSMOREPAGEID, "");
    }

    public void setWSMOREPAGEID(String strValue) {
        this.SetParamValue(TAG_WSMOREPAGEID, strValue);
    }

    public boolean isWSMOREPAGENAMENull() {
        return this.IsParamNull(TAG_WSMOREPAGENAME);
    }

    public String getWSMOREPAGENAME() {
        return this.GetParamStringValue(TAG_WSMOREPAGENAME, "");
    }

    public void setWSMOREPAGENAME(String strValue) {
        this.SetParamValue(TAG_WSMOREPAGENAME, strValue);
    }
}

