/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSHelpSection
extends BaseDataEntity {
    public static final String SECTIONTYPE_DECONCEPT = "DECONCEPT";
    public static final String SECTIONTYPE_DEFDESC = "DEFDESC";
    public static final String SECTIONTYPE_MANUAL = "MANUAL";
    public static final String SECTIONTYPE_EXAMPLE = "EXAMPLE";
    public static final String TAG_CONTENTASCODE = "CONTENTASCODE";
    public static final String TAG_PSHELPSECTIONID = "PSHELPSECTIONID";
    public static final String TAG_PSHELPSECTIONNAME = "PSHELPSECTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String TAG_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String TAG_SECTIONTYPE = "SECTIONTYPE";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_HEADERCONTENT = "HEADERCONTENT";
    public static final String TAG_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String TAG_PSHELPRESOURCEID = "PSHELPRESOURCEID";
    public static final String TAG_PSHELPRESOURCENAME = "PSHELPRESOURCENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSDEFIELDID = "PSDEFIELDID";
    public static final String TAG_PSDEFIELDNAME = "PSDEFIELDNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_CONTENT2 = "CONTENT2";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PPSHELPSECTIONID = "PPSHELPSECTIONID";
    public static final String TAG_PPSHELPSECTIONNAME = "PPSHELPSECTIONNAME";
    public static final String TAG_REFPSHELPARTICLECATID = "REFPSHELPARTICLECATID";
    public static final String TAG_REFPSHELPARTICLECATNAME = "REFPSHELPARTICLECATNAME";
    public static final String TAG_REFPSHELPARTICLEID = "REFPSHELPARTICLEID";
    public static final String TAG_REFPSHELPARTICLENAME = "REFPSHELPARTICLENAME";
    public static final String TAG_OUTPUTDIR = "OUTPUTDIR";
    public static final String TAG_PSHELPSECTIONTEMPLID = "PSHELPSECTIONTEMPLID";
    public static final String TAG_PSHELPSECTIONTEMPLNAME = "PSHELPSECTIONTEMPLNAME";
    public static final String TAG_LINKPSHELPRESOURCEID = "LINKPSHELPRESOURCEID";
    public static final String TAG_LINKPSHELPRESOURCENAME = "LINKPSHELPRESOURCENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_SECTIONPARAM = "SECTIONPARAM";
    public static final String TAG_SECTIONPARAM2 = "SECTIONPARAM2";
    private ArrayList<PSHelpSection> childPSHelpSectionList = null;

    public final boolean isPSHELPSECTIONIDNull() {
        return this.IsParamNull(TAG_PSHELPSECTIONID);
    }

    public final String getPSHELPSECTIONID() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONID, "");
    }

    public final void setPSHELPSECTIONID(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONID, strValue);
    }

    public final boolean isPSHELPSECTIONNAMENull() {
        return this.IsParamNull(TAG_PSHELPSECTIONNAME);
    }

    public final String getPSHELPSECTIONNAME() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONNAME, "");
    }

    public final void setPSHELPSECTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONNAME, strValue);
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

    public final boolean isPSHELPARTICLEIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLEID);
    }

    public final String getPSHELPARTICLEID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLEID, "");
    }

    public final void setPSHELPARTICLEID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLEID, strValue);
    }

    public final boolean isPSHELPARTICLENAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLENAME);
    }

    public final String getPSHELPARTICLENAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLENAME, "");
    }

    public final void setPSHELPARTICLENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLENAME, strValue);
    }

    public final boolean isSECTIONTYPENull() {
        return this.IsParamNull(TAG_SECTIONTYPE);
    }

    public final String getSECTIONTYPE() {
        return this.GetParamStringValue(TAG_SECTIONTYPE, "");
    }

    public final void setSECTIONTYPE(String strValue) {
        this.SetParamValue(TAG_SECTIONTYPE, strValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isHEADERCONTENTNull() {
        return this.IsParamNull(TAG_HEADERCONTENT);
    }

    public final String getHEADERCONTENT() {
        return this.GetParamStringValue(TAG_HEADERCONTENT, "");
    }

    public final void setHEADERCONTENT(String strValue) {
        this.SetParamValue(TAG_HEADERCONTENT, strValue);
    }

    public final boolean isBOTTOMCONTENTNull() {
        return this.IsParamNull(TAG_BOTTOMCONTENT);
    }

    public final String getBOTTOMCONTENT() {
        return this.GetParamStringValue(TAG_BOTTOMCONTENT, "");
    }

    public final void setBOTTOMCONTENT(String strValue) {
        this.SetParamValue(TAG_BOTTOMCONTENT, strValue);
    }

    public final boolean isPSHELPRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSHELPRESOURCEID);
    }

    public final String getPSHELPRESOURCEID() {
        return this.GetParamStringValue(TAG_PSHELPRESOURCEID, "");
    }

    public final void setPSHELPRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSHELPRESOURCEID, strValue);
    }

    public final boolean isPSHELPRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSHELPRESOURCENAME);
    }

    public final String getPSHELPRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSHELPRESOURCENAME, "");
    }

    public final void setPSHELPRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPRESOURCENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSDEFIELDIDNull() {
        return this.IsParamNull(TAG_PSDEFIELDID);
    }

    public final String getPSDEFIELDID() {
        return this.GetParamStringValue(TAG_PSDEFIELDID, "");
    }

    public final void setPSDEFIELDID(String strValue) {
        this.SetParamValue(TAG_PSDEFIELDID, strValue);
    }

    public final boolean isPSDEFIELDNAMENull() {
        return this.IsParamNull(TAG_PSDEFIELDNAME);
    }

    public final String getPSDEFIELDNAME() {
        return this.GetParamStringValue(TAG_PSDEFIELDNAME, "");
    }

    public final void setPSDEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIELDNAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isCONTENT2Null() {
        return this.IsParamNull(TAG_CONTENT2);
    }

    public final String getCONTENT2() {
        return this.GetParamStringValue(TAG_CONTENT2, "");
    }

    public final void setCONTENT2(String strValue) {
        this.SetParamValue(TAG_CONTENT2, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isPPSHELPSECTIONIDNull() {
        return this.IsParamNull(TAG_PPSHELPSECTIONID);
    }

    public final String getPPSHELPSECTIONID() {
        return this.GetParamStringValue(TAG_PPSHELPSECTIONID, "");
    }

    public final void setPPSHELPSECTIONID(String strValue) {
        this.SetParamValue(TAG_PPSHELPSECTIONID, strValue);
    }

    public final boolean isPPSHELPSECTIONNAMENull() {
        return this.IsParamNull(TAG_PPSHELPSECTIONNAME);
    }

    public final String getPPSHELPSECTIONNAME() {
        return this.GetParamStringValue(TAG_PPSHELPSECTIONNAME, "");
    }

    public final void setPPSHELPSECTIONNAME(String strValue) {
        this.SetParamValue(TAG_PPSHELPSECTIONNAME, strValue);
    }

    public final boolean isREFPSHELPARTICLECATIDNull() {
        return this.IsParamNull(TAG_REFPSHELPARTICLECATID);
    }

    public final String getREFPSHELPARTICLECATID() {
        return this.GetParamStringValue(TAG_REFPSHELPARTICLECATID, "");
    }

    public final void setREFPSHELPARTICLECATID(String strValue) {
        this.SetParamValue(TAG_REFPSHELPARTICLECATID, strValue);
    }

    public final boolean isREFPSHELPARTICLECATNAMENull() {
        return this.IsParamNull(TAG_REFPSHELPARTICLECATNAME);
    }

    public final String getREFPSHELPARTICLECATNAME() {
        return this.GetParamStringValue(TAG_REFPSHELPARTICLECATNAME, "");
    }

    public final void setREFPSHELPARTICLECATNAME(String strValue) {
        this.SetParamValue(TAG_REFPSHELPARTICLECATNAME, strValue);
    }

    public final boolean isREFPSHELPARTICLEIDNull() {
        return this.IsParamNull(TAG_REFPSHELPARTICLEID);
    }

    public final String getREFPSHELPARTICLEID() {
        return this.GetParamStringValue(TAG_REFPSHELPARTICLEID, "");
    }

    public final void setREFPSHELPARTICLEID(String strValue) {
        this.SetParamValue(TAG_REFPSHELPARTICLEID, strValue);
    }

    public final boolean isREFPSHELPARTICLENAMENull() {
        return this.IsParamNull(TAG_REFPSHELPARTICLENAME);
    }

    public final String getREFPSHELPARTICLENAME() {
        return this.GetParamStringValue(TAG_REFPSHELPARTICLENAME, "");
    }

    public final void setREFPSHELPARTICLENAME(String strValue) {
        this.SetParamValue(TAG_REFPSHELPARTICLENAME, strValue);
    }

    public final boolean isOUTPUTDIRNull() {
        return this.IsParamNull(TAG_OUTPUTDIR);
    }

    public final boolean getOUTPUTDIR() {
        return this.GetParamIntValue(TAG_OUTPUTDIR, 0) == 1;
    }

    public final void setOUTPUTDIR(boolean bValue) {
        this.SetParamValue(TAG_OUTPUTDIR, bValue ? 1 : 0);
    }

    public final boolean isCONTENTASCODENull() {
        return this.IsParamNull(TAG_CONTENTASCODE);
    }

    public final boolean getCONTENTASCODE() {
        return this.GetParamIntValue(TAG_CONTENTASCODE, 0) == 1;
    }

    public final void setCONTENTASCODE(boolean bValue) {
        this.SetParamValue(TAG_CONTENTASCODE, bValue ? 1 : 0);
    }

    public final boolean isPSHELPSECTIONTEMPLIDNull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTEMPLID);
    }

    public final String getPSHELPSECTIONTEMPLID() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTEMPLID, "");
    }

    public final void setPSHELPSECTIONTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTEMPLID, strValue);
    }

    public final boolean isPSHELPSECTIONTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTEMPLNAME);
    }

    public final String getPSHELPSECTIONTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTEMPLNAME, "");
    }

    public final void setPSHELPSECTIONTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTEMPLNAME, strValue);
    }

    public final boolean isLINKPSHELPRESOURCEIDNull() {
        return this.IsParamNull(TAG_LINKPSHELPRESOURCEID);
    }

    public final String getLINKPSHELPRESOURCEID() {
        return this.GetParamStringValue(TAG_LINKPSHELPRESOURCEID, "");
    }

    public final void setLINKPSHELPRESOURCEID(String strValue) {
        this.SetParamValue(TAG_LINKPSHELPRESOURCEID, strValue);
    }

    public final boolean isLINKPSHELPRESOURCENAMENull() {
        return this.IsParamNull(TAG_LINKPSHELPRESOURCENAME);
    }

    public final String getLINKPSHELPRESOURCENAME() {
        return this.GetParamStringValue(TAG_LINKPSHELPRESOURCENAME, "");
    }

    public final void setLINKPSHELPRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_LINKPSHELPRESOURCENAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isSECTIONPARAMNull() {
        return this.IsParamNull(TAG_SECTIONPARAM);
    }

    public final String getSECTIONPARAM() {
        return this.GetParamStringValue(TAG_SECTIONPARAM, "");
    }

    public final void setSECTIONPARAM(String strValue) {
        this.SetParamValue(TAG_SECTIONPARAM, strValue);
    }

    public final boolean isSECTIONPARAM2Null() {
        return this.IsParamNull(TAG_SECTIONPARAM2);
    }

    public final String getSECTIONPARAM2() {
        return this.GetParamStringValue(TAG_SECTIONPARAM2, "");
    }

    public final void setSECTIONPARAM2(String strValue) {
        this.SetParamValue(TAG_SECTIONPARAM2, strValue);
    }

    public ArrayList<PSHelpSection> getChildPSHelpSections(boolean bCreated) {
        if (this.childPSHelpSectionList != null) {
            return this.childPSHelpSectionList;
        }
        if (bCreated) {
            this.childPSHelpSectionList = new ArrayList();
        }
        return this.childPSHelpSectionList;
    }

    public void resetChildDatas() {
        if (this.childPSHelpSectionList != null) {
            this.childPSHelpSectionList.clear();
            this.childPSHelpSectionList = null;
        }
    }
}

