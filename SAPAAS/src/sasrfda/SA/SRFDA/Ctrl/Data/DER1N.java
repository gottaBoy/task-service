/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.BaseDER;
import SA.SRFramework.Utility.StringHelper;

public class DER1N
extends BaseDER {
    public static final int REMOVETYPE_NONE = 0;
    public static final int REMOVETYPE_DELETE = 1;
    public static final int REMOVETYPE_RESET = 2;
    public static final int REMOVETYPE_REJECTDELETE = 3;
    public static final String PHYSICALUPDATEMODE_UPDATEWHENMODIFY = "UPDATEWHENMODIFY";
    public static final String TAG_DERID = "DERID";
    public static final String TAG_DERNAME = "DERNAME";
    public static final String TAG_DERLOGICNAME = "DERLOGICNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISNULLABLE = "ISNULLABLE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_DERTYPE = "DERTYPE";
    public static final String TAG_MAJORDENAME = "MAJORDENAME";
    public static final String TAG_MINORDENAME = "MINORDENAME";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_MAJORKEYDEFNAME = "MAJORKEYDEFNAME";
    public static final String TAG_MAJORTEXTDEFNAME = "MAJORTEXTDEFNAME";
    public static final String TAG_MAJORDEID = "MAJORDEID";
    public static final String TAG_MINORDEID = "MINORDEID";
    public static final String TAG_DERSUBTYPE = "DERSUBTYPE";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_MAJORDELOGICNAME = "MAJORDELOGICNAME";
    public static final String TAG_MINORDELOGICNAME = "MINORDELOGICNAME";
    public static final String TAG_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String TAG_ISMTFIELD = "ISMTFIELD";
    public static final String TAG_RANGECOND = "RANGECOND";
    public static final String TAG_SHOWNAME1N = "SHOWNAME1N";
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_PICKUPPAGENAME = "PICKUPPAGENAME";
    public static final String TAG_RELATEDPAGEID = "RELATEDPAGEID";
    public static final String TAG_RELATEDPAGENAME = "RELATEDPAGENAME";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_MPICKUPPAGEID = "MPICKUPPAGEID";
    public static final String TAG_MPICKUPPAGENAME = "MPICKUPPAGENAME";
    public static final String TAG_TABVIEWBARCOND = "TABVIEWBARCOND";
    public static final String TAG_PHYSICALMODE = "PHYSICALMODE";
    public static final String TAG_PHYSICALUPDATEMODE = "PHYSICALUPDATEMODE";
    public static final String TAG_DEACMODEID = "DEACMODEID";
    public static final String TAG_DEACMODENAME = "DEACMODENAME";
    public static final String TAG_FOREIGNKEY = "FOREIGNKEY";
    public static final String TAG_EXPORTORDER = "EXPORTORDER";
    public static final String TAG_SHOWNAMELANRESID = "SHOWNAMELANRESID";
    public static final String TAG_SHOWNAMELANRESNAME = "SHOWNAMELANRESNAME";
    public static final String TAG_SYNCMODEL = "SYNCMODEL";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_RELATEDTEXTDEFID = "RELATEDTEXTDEFID";
    public static final String TAG_RELATEDTEXTDEFNAME = "RELATEDTEXTDEFNAME";

    @Override
    public int getDERTYPE() {
        return 1;
    }

    @Override
    public int getREMOVEACTIONTYPE() {
        return this.GetParamIntValue(TAG_REMOVEACTIONTYPE, 0);
    }

    @Override
    public void setREMOVEACTIONTYPE(int nValue) {
        this.SetParamValue(TAG_REMOVEACTIONTYPE, nValue);
    }

    public void setRANGECOND(String strValue) {
        this.SetParamValue(TAG_RANGECOND, strValue);
    }

    public String getRANGECOND() {
        return this.GetParamStringValue(TAG_RANGECOND, "");
    }

    public void setSHOWNAME1N(String strValue) {
        this.SetParamValue(TAG_SHOWNAME1N, strValue);
    }

    public String getSHOWNAME1N() {
        String strShowName1N = this.GetParamStringValue(TAG_SHOWNAME1N, "");
        if (!StringHelper.IsNullOrEmpty((String)strShowName1N)) {
            return strShowName1N;
        }
        return this.getDERLOGICNAME();
    }

    public String getPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_PICKUPPAGEID, "");
    }

    public String getMPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_MPICKUPPAGEID, "");
    }

    public String getRELATEDPAGEID() {
        return this.GetParamStringValue(TAG_RELATEDPAGEID, "");
    }

    public boolean getPHYSICALMODE() {
        return this.GetParamIntValue(TAG_PHYSICALMODE, 0) == 1;
    }

    public void setPHYSICALMODE(boolean bValue) {
        this.SetParamValue(TAG_PHYSICALMODE, bValue ? 1 : 0);
    }

    public String getPHYSICALUPDATEMODE() {
        return this.GetParamStringValue(TAG_PHYSICALUPDATEMODE, "");
    }

    public void setPHYSICALUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_PHYSICALUPDATEMODE, strValue);
    }

    public String getDEACMODEID() {
        return this.GetParamStringValue(TAG_DEACMODEID, "");
    }

    public void setDEACMODEID(String strValue) {
        this.SetParamValue(TAG_DEACMODEID, strValue);
    }

    public String getDEACMODENAME() {
        return this.GetParamStringValue(TAG_DEACMODENAME, "");
    }

    public void setDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_DEACMODENAME, strValue);
    }

    public boolean getFOREIGNKEY() {
        return this.GetParamIntValue(TAG_FOREIGNKEY, 1) == 1;
    }

    public void setFOREIGNKEY(boolean bValue) {
        this.SetParamValue(TAG_FOREIGNKEY, bValue ? 1 : 0);
    }

    public int getEXPORTORDER() {
        return this.GetParamIntValue(TAG_EXPORTORDER, -1);
    }

    public void setEXPORTORDER(int strValue) {
        this.SetParamValue(TAG_EXPORTORDER, strValue);
    }

    public boolean isSYNCMODELNull() {
        return this.IsParamNull(TAG_SYNCMODEL);
    }

    public boolean getSYNCMODEL() {
        return this.GetParamIntValue(TAG_SYNCMODEL, 0) == 1;
    }

    public void setSYNCMODEL(boolean bValue) {
        this.SetParamValue(TAG_SYNCMODEL, bValue ? 1 : 0);
    }

    public boolean isISNULLABLENull() {
        return this.IsParamNull(TAG_ISNULLABLE);
    }

    public boolean getISNULLABLE() {
        return this.GetParamIntValue(TAG_ISNULLABLE, 0) == 1;
    }

    public void setISNULLABLE(boolean bValue) {
        this.SetParamValue(TAG_ISNULLABLE, bValue ? 1 : 0);
    }

    public boolean isISSYSTEMNull() {
        return this.IsParamNull(TAG_ISSYSTEM);
    }

    public boolean getISSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public void setISSYSTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYSTEM, bValue ? 1 : 0);
    }

    public boolean isISMTFIELDNull() {
        return this.IsParamNull(TAG_ISMTFIELD);
    }

    public boolean getISMTFIELD() {
        return this.GetParamIntValue(TAG_ISMTFIELD, 0) == 1;
    }

    @Override
    public void setISMTFIELD(boolean bValue) {
        this.SetParamValue(TAG_ISMTFIELD, bValue ? 1 : 0);
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

    public boolean isRELATEDPAGENAMENull() {
        return this.IsParamNull(TAG_RELATEDPAGENAME);
    }

    public String getRELATEDPAGENAME() {
        return this.GetParamStringValue(TAG_RELATEDPAGENAME, "");
    }

    public void setRELATEDPAGENAME(String strValue) {
        this.SetParamValue(TAG_RELATEDPAGENAME, strValue);
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

    public final boolean isQUERYMODELIDNull() {
        return this.IsParamNull(TAG_QUERYMODELID);
    }

    public final String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public final void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public final boolean isQUERYMODELNAMENull() {
        return this.IsParamNull(TAG_QUERYMODELNAME);
    }

    public final String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public final void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public final boolean isRELATEDTEXTDEFIDNull() {
        return this.IsParamNull(TAG_RELATEDTEXTDEFID);
    }

    public final String getRELATEDTEXTDEFID() {
        return this.GetParamStringValue(TAG_RELATEDTEXTDEFID, "");
    }

    public final void setRELATEDTEXTDEFID(String strValue) {
        this.SetParamValue(TAG_RELATEDTEXTDEFID, strValue);
    }

    public final boolean isRELATEDTEXTDEFNAMENull() {
        return this.IsParamNull(TAG_RELATEDTEXTDEFNAME);
    }

    public final String getRELATEDTEXTDEFNAME() {
        return this.GetParamStringValue(TAG_RELATEDTEXTDEFNAME, "");
    }

    public final void setRELATEDTEXTDEFNAME(String strValue) {
        this.SetParamValue(TAG_RELATEDTEXTDEFNAME, strValue);
    }
}

