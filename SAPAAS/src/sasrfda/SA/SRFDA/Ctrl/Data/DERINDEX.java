/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DERINDEX
extends BaseDataEntity {
    public static final int TAG_DERINDEXTYPE_1N = 1;
    public static final int TAG_DERINDEXTYPE_NN = 2;
    public static final int TAG_DERINDEXSUBTYPE_PARENT = 1;
    public static final int TAG_DERINDEXSUBTYPE_SETNULL = 2;
    public static final int TAG_DERINDEXSUBTYPE_NOTREMOVE = 3;
    public static final String TAG_DERINDEXID = "DERINDEXID";
    public static final String TAG_DERINDEXTYPE = "DERINDEXTYPE";
    public static final String TAG_DERINDEXNAME = "DERINDEXNAME";
    public static final String TAG_DERINDEXLOGICNAME = "DERINDEXLOGICNAME";
    public static final String TAG_INDEXDEID = "INDEXDEID";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEFIELDMAP = "DEFIELDMAP";
    public static final String TAG_DEFIELDMAP2 = "DEFIELDMAP2";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DERINDEXTYPEID = "DERINDEXTYPEID";
    public static final String TAG_DERINDEXTYPENAME = "DERINDEXTYPENAME";
    public static final String TAG_TYPEVALUE = "TYPEVALUE";
    public static final String TAG_ORDERINDEXFLAG = "ORDERINDEXFLAG";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_INDEXDENAME = "INDEXDENAME";
    public static final String TAG_INDEXDELOGICNAME = "INDEXDELOGICNAME";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DELOGICNAME = "DELOGICNAME";
    public static final String TAG_MAJORKEYDEFNAME = "MAJORKEYDEFNAME";
    public static final String TAG_MAJORTEXTDEFNAME = "MAJORTEXTDEFNAME";
    public static final String TAG_DERINDEXSUBTYPE = "DERINDEXSUBTYPE";
    public static final String TAG_INHERITMODE = "INHERITMODE";
    public static final String TAG_ISNULLABLE = "ISNULLABLE";
    public static final String TAG_ISMTFIELD = "ISMTFIELD";
    public static final int REMOVETYPE_NONE = 0;
    public static final int REMOVETYPE_DELETE = 1;
    public static final int REMOVETYPE_RESET = 2;
    public static final int REMOVETYPE_REJECTDELETE = 3;
    public static final String TAG_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String TAG_IGNOREINHERIT = "IGNOREINHERIT";
    public static final String TAG_SHOWORDER = "SHOWORDER";

    public String getDERINDEXID() {
        return this.GetParamStringValue(TAG_DERINDEXID, "").trim();
    }

    public String getDERINDEXNAME() {
        return this.GetParamStringValue(TAG_DERINDEXNAME, "");
    }

    public String getDERINDEXLOGICNAME() {
        return this.GetParamStringValue(TAG_DERINDEXLOGICNAME, "");
    }

    public String getINDEXDEID() {
        return this.GetParamStringValue(TAG_INDEXDEID, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getDEFIELDMAP() {
        return this.GetParamStringValue(TAG_DEFIELDMAP, "");
    }

    public String getDEFIELDMAP2() {
        return this.GetParamStringValue(TAG_DEFIELDMAP2, "");
    }

    public String getDERINDEXTYPEID() {
        return this.GetParamStringValue(TAG_DERINDEXTYPEID, "");
    }

    public String getDERINDEXTYPENAME() {
        return this.GetParamStringValue(TAG_DERINDEXTYPENAME, "");
    }

    public String getTYPEVALUE() {
        return this.GetParamStringValue(TAG_TYPEVALUE, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getINDEXDENAME() {
        return this.GetParamStringValue(TAG_INDEXDENAME, "");
    }

    public String getINDEXDELOGICNAME() {
        return this.GetParamStringValue(TAG_INDEXDELOGICNAME, "");
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public String getDELOGICNAME() {
        return this.GetParamStringValue(TAG_DELOGICNAME, "");
    }

    public String getMAJORKEYDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORKEYDEFNAME, "");
    }

    public String getMAJORTEXTDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORTEXTDEFNAME, "");
    }

    public void setDERINDEXID(String strValue) {
        this.SetParamValue(TAG_DERINDEXID, strValue);
    }

    public void setDERINDEXNAME(String strValue) {
        this.SetParamValue(TAG_DERINDEXNAME, strValue);
    }

    public void setDERINDEXLOGICNAME(String strValue) {
        this.SetParamValue(TAG_DERINDEXLOGICNAME, strValue);
    }

    public void setINDEXDEID(String strValue) {
        this.SetParamValue(TAG_INDEXDEID, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setDEFIELDMAP(String strValue) {
        this.SetParamValue(TAG_DEFIELDMAP, strValue);
    }

    public void setDEFIELDMAP2(String strValue) {
        this.SetParamValue(TAG_DEFIELDMAP2, strValue);
    }

    public void setDERINDEXTYPEID(String strValue) {
        this.SetParamValue(TAG_DERINDEXTYPEID, strValue);
    }

    public void setDERINDEXTYPENAME(String strValue) {
        this.SetParamValue(TAG_DERINDEXTYPENAME, strValue);
    }

    public void setTYPEVALUE(String strValue) {
        this.SetParamValue(TAG_TYPEVALUE, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setINDEXDENAME(String strValue) {
        this.SetParamValue(TAG_INDEXDENAME, strValue);
    }

    public void setINDEXDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_INDEXDELOGICNAME, strValue);
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public void setDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DELOGICNAME, strValue);
    }

    public void setMAJORKEYDEFNAME(String strValue) {
        this.SetParamValue(TAG_MAJORKEYDEFNAME, strValue);
    }

    public void setMAJORTEXTDEFNAME(String strValue) {
        this.SetParamValue(TAG_MAJORTEXTDEFNAME, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isNULLABLE() {
        return this.GetParamIntValue(TAG_ISNULLABLE, 0) == 1;
    }

    public int getREMOVEACTIONTYPE() {
        return this.GetParamIntValue(TAG_REMOVEACTIONTYPE, 0);
    }

    public void setREMOVEACTIONTYPE(int nValue) {
        this.SetParamValue(TAG_REMOVEACTIONTYPE, nValue);
    }

    public boolean isINHERITMODE() {
        return this.GetParamIntValue(TAG_INHERITMODE, 0) == 1;
    }

    public void setINHERITMODE(boolean bValue) {
        this.SetParamValue(TAG_INHERITMODE, bValue ? 1 : 0);
    }

    public String getIGNOREINHERIT() {
        return this.GetParamStringValue(TAG_IGNOREINHERIT, "");
    }

    public void setIGNOREINHERIT(String strValue) {
        this.SetParamValue(TAG_IGNOREINHERIT, strValue);
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
}

