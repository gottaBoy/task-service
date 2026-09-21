/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class BaseDER
extends BaseDataEntity {
    public static final int TAG_DERTYPE_1N = 1;
    public static final int TAG_DERTYPE_NN = 2;
    public static final int TAG_DERSUBTYPE_PARENT = 1;
    public static final int TAG_DERSUBTYPE_ATTACHED = 2;
    public static final int TAG_DERSUBTYPE_RELATECOPY = 4;
    public static final int TAG_DERSUBTYPE_RELATE = 8;
    public static final int TAG_DERSUBTYPE_NODATAMGR = 16;
    public static final int TAG_DERSUBTYPE_FEWDATA = 32;
    public static final String TAG_DERID = "DERID";
    public static final String TAG_DERTYPE = "DERTYPE";
    public static final String TAG_DERNAME = "DERNAME";
    public static final String TAG_DERLOGICNAME = "DERLOGICNAME";
    public static final String TAG_MAJORDEID = "MAJORDEID";
    public static final String TAG_MINORDEID = "MINORDEID";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_MAJORDENAME = "MAJORDENAME";
    public static final String TAG_MAJORDELOGICNAME = "MAJORDELOGICNAME";
    public static final String TAG_MINORDENAME = "MINORDENAME";
    public static final String TAG_MINORDELOGICNAME = "MINORDELOGICNAME";
    public static final String TAG_MAJORKEYDEFNAME = "MAJORKEYDEFNAME";
    public static final String TAG_MAJORTEXTDEFNAME = "MAJORTEXTDEFNAME";
    public static final String TAG_DERSUBTYPE = "DERSUBTYPE";
    public static final String TAG_ISNULLABLE = "ISNULLABLE";
    public static final String TAG_ISMTFIELD = "ISMTFIELD";
    public static final String TAG_TABVIEWBARCOND = "TABVIEWBARCOND";
    public static final int REMOVETYPE_NONE = 0;
    public static final int REMOVETYPE_DELETE = 1;
    public static final int REMOVETYPE_RESET = 2;
    public static final int REMOVETYPE_REJECTDELETE = 3;
    public static final String TAG_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String TAG_SHOWNAMELANRESID = "SHOWNAMELANRESID";
    public static final String TAG_SHOWNAMELANRESNAME = "SHOWNAMELANRESNAME";

    public String getDERID() {
        return this.GetParamStringValue(TAG_DERID, "").trim();
    }

    public String getDERNAME() {
        return this.GetParamStringValue(TAG_DERNAME, "");
    }

    public String getDERLOGICNAME() {
        return this.GetParamStringValue(TAG_DERLOGICNAME, "");
    }

    public String getMAJORDEID() {
        return this.GetParamStringValue(TAG_MAJORDEID, "");
    }

    public String getMINORDEID() {
        return this.GetParamStringValue(TAG_MINORDEID, "");
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

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getDERTYPEID() {
        return this.GetParamStringValue(TAG_DERTYPEID, "");
    }

    public String getDERTYPENAME() {
        return this.GetParamStringValue(TAG_DERTYPENAME, "");
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getMAJORDENAME() {
        return this.GetParamStringValue(TAG_MAJORDENAME, "");
    }

    public String getMAJORDELOGICNAME() {
        return this.GetParamStringValue(TAG_MAJORDELOGICNAME, "");
    }

    public String getMINORDENAME() {
        return this.GetParamStringValue(TAG_MINORDENAME, "");
    }

    public String getMINORDELOGICNAME() {
        return this.GetParamStringValue(TAG_MINORDELOGICNAME, "");
    }

    public String getMAJORKEYDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORKEYDEFNAME, "");
    }

    public String getMAJORTEXTDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORTEXTDEFNAME, "");
    }

    public void setDERID(String strValue) {
        this.SetParamValue(TAG_DERID, strValue);
    }

    public void setDERNAME(String strValue) {
        this.SetParamValue(TAG_DERNAME, strValue);
    }

    public void setDERLOGICNAME(String strValue) {
        this.SetParamValue(TAG_DERLOGICNAME, strValue);
    }

    public void setMAJORDEID(String strValue) {
        this.SetParamValue(TAG_MAJORDEID, strValue);
    }

    public void setMINORDEID(String strValue) {
        this.SetParamValue(TAG_MINORDEID, strValue);
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

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setDERTYPEID(String strValue) {
        this.SetParamValue(TAG_DERTYPEID, strValue);
    }

    public void setDERTYPENAME(String strValue) {
        this.SetParamValue(TAG_DERTYPENAME, strValue);
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setMAJORDENAME(String strValue) {
        this.SetParamValue(TAG_MAJORDENAME, strValue);
    }

    public void setMAJORDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_MAJORDELOGICNAME, strValue);
    }

    public void setMINORDENAME(String strValue) {
        this.SetParamValue(TAG_MINORDENAME, strValue);
    }

    public void setMINORDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_MINORDELOGICNAME, strValue);
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

    public int getDERTYPE() {
        return this.GetParamIntValue(TAG_DERTYPE, 0);
    }

    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public int getDERSUBTYPE() {
        return this.GetParamIntValue(TAG_DERSUBTYPE, 0);
    }

    public String getTABVIEWBARCOND() {
        return this.GetParamStringValue(TAG_TABVIEWBARCOND, "");
    }

    public boolean isMTFIELD() {
        return this.GetParamIntValue(TAG_ISMTFIELD, 0) == 1;
    }

    public void setISMTFIELD(boolean bValue) {
        this.SetParamValue(TAG_ISMTFIELD, bValue ? 1 : 0);
    }

    public int getREMOVEACTIONTYPE() {
        return this.GetParamIntValue(TAG_REMOVEACTIONTYPE, 0);
    }

    public void setREMOVEACTIONTYPE(int nValue) {
        this.SetParamValue(TAG_REMOVEACTIONTYPE, nValue);
    }

    public String getSHOWNAMELANRESID() {
        return this.GetParamStringValue(TAG_SHOWNAMELANRESID, "");
    }

    public void setSHOWNAMELANRESID(String strValue) {
        this.SetParamValue(TAG_SHOWNAMELANRESID, strValue);
    }

    public String getSHOWNAMELANRESNAME() {
        return this.GetParamStringValue(TAG_SHOWNAMELANRESNAME, "");
    }

    public void setSHOWNAMELANRESNAME(String strValue) {
        this.SetParamValue(TAG_SHOWNAMELANRESNAME, strValue);
    }
}

