/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSCodeList
extends BaseDataEntity {
    public static final String CLTYPE_STATIC = "STATIC";
    public static final String CLTYPE_DYNAMIC = "DYNAMIC";
    public static final String CLTYPE_PREDEFINED = "PREDEFINED";
    public static final String ORMODE_NUMBERORMODE = "NUMBERORMODE";
    public static final String ORMODE_STRINGORMODE = "STRINGORMODE";
    public static final String PREDEFINEDTYPE_OPERATOR = "OPERATOR";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String TAG_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String TAG_CODELISTSN = "CODELISTSN";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CLMODEL = "CLMODEL";
    public static final String TAG_CLTYPE = "CLTYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERSCOPE = "USERSCOPE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_SYSREFFLAG = "SYSREFFLAG";
    public static final String TAG_USERREFFLAG = "USERREFFLAG";
    public static final String TAG_ORMODE = "ORMODE";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_SEPERATOR = "SEPERATOR";
    public static final String TAG_VALUESEPERATOR = "VALUESEPERATOR";
    public static final String TAG_NOVALUEEMPTY = "NOVALUEEMPTY";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_NUMBERITEM = "NUMBERITEM";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_ICONCLSPSDEFID = "ICONCLSPSDEFID";
    public static final String TAG_ICONCLSPSDEFNAME = "ICONCLSPSDEFNAME";
    public static final String TAG_ICONPATHPSDEFID = "ICONPATHPSDEFID";
    public static final String TAG_ICONPATHPSDEFNAME = "ICONPATHPSDEFNAME";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_ICONCLSXPSDEFID = "ICONCLSXPSDEFID";
    public static final String TAG_ICONCLSXPSDEFNAME = "ICONCLSXPSDEFNAME";
    public static final String TAG_ICONPATHXPSDEFID = "ICONPATHXPSDEFID";
    public static final String TAG_ICONPATHXPSDEFNAME = "ICONPATHXPSDEFNAME";
    public static final String TAG_DSCONDITIONS = "DSCONDITIONS";
    public static final String TAG_PVALUEPSDEFID = "PVALUEPSDEFID";
    public static final String TAG_PVALUEPSDEFNAME = "PVALUEPSDEFNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_DYNASYSREFMODE = "DYNASYSREFMODE";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String TAG_PSDYNACODELISTID = "PSDYNACODELISTID";
    public static final String TAG_PSDYNACODELISTNAME = "PSDYNACODELISTNAME";
    public static final String TAG_DISABLEPSDEFID = "DISABLEPSDEFID";
    public static final String TAG_DISABLEPSDEFNAME = "DISABLEPSDEFNAME";

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSCODELISTTEMPLIDNull() {
        return this.isParamNull(TAG_PSCODELISTTEMPLID);
    }

    public final String getPSCODELISTTEMPLID() {
        return this.getParamStringValue(TAG_PSCODELISTTEMPLID, "");
    }

    public final void setPSCODELISTTEMPLID(String strValue) {
        this.setParamValue(TAG_PSCODELISTTEMPLID, strValue);
    }

    public final boolean isPSCODELISTTEMPLNAMENull() {
        return this.isParamNull(TAG_PSCODELISTTEMPLNAME);
    }

    public final String getPSCODELISTTEMPLNAME() {
        return this.getParamStringValue(TAG_PSCODELISTTEMPLNAME, "");
    }

    public final void setPSCODELISTTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTTEMPLNAME, strValue);
    }

    public final boolean isCODELISTSNNull() {
        return this.isParamNull(TAG_CODELISTSN);
    }

    public final String getCODELISTSN() {
        return this.getParamStringValue(TAG_CODELISTSN, "");
    }

    public final void setCODELISTSN(String strValue) {
        this.setParamValue(TAG_CODELISTSN, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCLMODELNull() {
        return this.isParamNull(TAG_CLMODEL);
    }

    public final String getCLMODEL() {
        return this.getParamStringValue(TAG_CLMODEL, "");
    }

    public final void setCLMODEL(String strValue) {
        this.setParamValue(TAG_CLMODEL, strValue);
    }

    public final boolean isCLTYPENull() {
        return this.isParamNull(TAG_CLTYPE);
    }

    public final String getCLTYPE() {
        return this.getParamStringValue(TAG_CLTYPE, "");
    }

    public final void setCLTYPE(String strValue) {
        this.setParamValue(TAG_CLTYPE, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUSERSCOPENull() {
        return this.isParamNull(TAG_USERSCOPE);
    }

    public final boolean getUSERSCOPE() {
        return this.getParamIntValue(TAG_USERSCOPE, 0) == 1;
    }

    public final void setUSERSCOPE(boolean bValue) {
        this.setParamValue(TAG_USERSCOPE, bValue ? 1 : 0);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isSYSREFFLAGNull() {
        return this.isParamNull(TAG_SYSREFFLAG);
    }

    public final boolean getSYSREFFLAG() {
        return this.getParamIntValue(TAG_SYSREFFLAG, 0) == 1;
    }

    public final void setSYSREFFLAG(boolean bValue) {
        this.setParamValue(TAG_SYSREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isUSERREFFLAGNull() {
        return this.isParamNull(TAG_USERREFFLAG);
    }

    public final boolean getUSERREFFLAG() {
        return this.getParamIntValue(TAG_USERREFFLAG, 0) == 1;
    }

    public final void setUSERREFFLAG(boolean bValue) {
        this.setParamValue(TAG_USERREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isORMODENull() {
        return this.isParamNull(TAG_ORMODE);
    }

    public final String getORMODE() {
        return this.getParamStringValue(TAG_ORMODE, "");
    }

    public final void setORMODE(String strValue) {
        this.setParamValue(TAG_ORMODE, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.isParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.getParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.setParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isSEPERATORNull() {
        return this.isParamNull(TAG_SEPERATOR);
    }

    public final String getSEPERATOR() {
        return this.getParamStringValue(TAG_SEPERATOR, "");
    }

    public final void setSEPERATOR(String strValue) {
        this.setParamValue(TAG_SEPERATOR, strValue);
    }

    public final boolean isVALUESEPERATORNull() {
        return this.isParamNull(TAG_VALUESEPERATOR);
    }

    public final String getVALUESEPERATOR() {
        return this.getParamStringValue(TAG_VALUESEPERATOR, "");
    }

    public final void setVALUESEPERATOR(String strValue) {
        this.setParamValue(TAG_VALUESEPERATOR, strValue);
    }

    public final boolean isNOVALUEEMPTYNull() {
        return this.isParamNull(TAG_NOVALUEEMPTY);
    }

    public final boolean getNOVALUEEMPTY() {
        return this.getParamIntValue(TAG_NOVALUEEMPTY, 0) == 1;
    }

    public final void setNOVALUEEMPTY(boolean bValue) {
        this.setParamValue(TAG_NOVALUEEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPSDEDSIDNull() {
        return this.isParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.getParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.setParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.isParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.getParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isNUMBERITEMNull() {
        return this.isParamNull(TAG_NUMBERITEM);
    }

    public final boolean getNUMBERITEM() {
        return this.getParamIntValue(TAG_NUMBERITEM, 0) == 1;
    }

    public final void setNUMBERITEM(boolean bValue) {
        this.setParamValue(TAG_NUMBERITEM, bValue ? 1 : 0);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.isParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.getParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.setParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.isParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.getParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.setParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.isParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.getParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.setParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.isParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.getParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.setParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.isParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.getParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.isParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.getParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.setParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.isParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.getParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.isParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.getParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.setParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.isParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.isParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isICONCLSPSDEFIDNull() {
        return this.isParamNull(TAG_ICONCLSPSDEFID);
    }

    public final String getICONCLSPSDEFID() {
        return this.getParamStringValue(TAG_ICONCLSPSDEFID, "");
    }

    public final void setICONCLSPSDEFID(String strValue) {
        this.setParamValue(TAG_ICONCLSPSDEFID, strValue);
    }

    public final boolean isICONCLSPSDEFNAMENull() {
        return this.isParamNull(TAG_ICONCLSPSDEFNAME);
    }

    public final String getICONCLSPSDEFNAME() {
        return this.getParamStringValue(TAG_ICONCLSPSDEFNAME, "");
    }

    public final void setICONCLSPSDEFNAME(String strValue) {
        this.setParamValue(TAG_ICONCLSPSDEFNAME, strValue);
    }

    public final boolean isICONPATHPSDEFIDNull() {
        return this.isParamNull(TAG_ICONPATHPSDEFID);
    }

    public final String getICONPATHPSDEFID() {
        return this.getParamStringValue(TAG_ICONPATHPSDEFID, "");
    }

    public final void setICONPATHPSDEFID(String strValue) {
        this.setParamValue(TAG_ICONPATHPSDEFID, strValue);
    }

    public final boolean isICONPATHPSDEFNAMENull() {
        return this.isParamNull(TAG_ICONPATHPSDEFNAME);
    }

    public final String getICONPATHPSDEFNAME() {
        return this.getParamStringValue(TAG_ICONPATHPSDEFNAME, "");
    }

    public final void setICONPATHPSDEFNAME(String strValue) {
        this.setParamValue(TAG_ICONPATHPSDEFNAME, strValue);
    }

    public final boolean isICONCLSXPSDEFIDNull() {
        return this.isParamNull(TAG_ICONCLSXPSDEFID);
    }

    public final String getICONCLSXPSDEFID() {
        return this.getParamStringValue(TAG_ICONCLSXPSDEFID, "");
    }

    public final void setICONCLSXPSDEFID(String strValue) {
        this.setParamValue(TAG_ICONCLSXPSDEFID, strValue);
    }

    public final boolean isICONCLSXPSDEFNAMENull() {
        return this.isParamNull(TAG_ICONCLSXPSDEFNAME);
    }

    public final String getICONCLSXPSDEFNAME() {
        return this.getParamStringValue(TAG_ICONCLSXPSDEFNAME, "");
    }

    public final void setICONCLSXPSDEFNAME(String strValue) {
        this.setParamValue(TAG_ICONCLSXPSDEFNAME, strValue);
    }

    public final boolean isICONPATHXPSDEFIDNull() {
        return this.isParamNull(TAG_ICONPATHXPSDEFID);
    }

    public final String getICONPATHXPSDEFID() {
        return this.getParamStringValue(TAG_ICONPATHXPSDEFID, "");
    }

    public final void setICONPATHXPSDEFID(String strValue) {
        this.setParamValue(TAG_ICONPATHXPSDEFID, strValue);
    }

    public final boolean isICONPATHXPSDEFNAMENull() {
        return this.isParamNull(TAG_ICONPATHXPSDEFNAME);
    }

    public final String getICONPATHXPSDEFNAME() {
        return this.getParamStringValue(TAG_ICONPATHXPSDEFNAME, "");
    }

    public final void setICONPATHXPSDEFNAME(String strValue) {
        this.setParamValue(TAG_ICONPATHXPSDEFNAME, strValue);
    }

    public final boolean isDSCONDITIONSNull() {
        return this.isParamNull(TAG_DSCONDITIONS);
    }

    public final String getDSCONDITIONS() {
        return this.getParamStringValue(TAG_DSCONDITIONS, "");
    }

    public final void setDSCONDITIONS(String strValue) {
        this.setParamValue(TAG_DSCONDITIONS, strValue);
    }

    public final boolean isPVALUEPSDEFIDNull() {
        return this.isParamNull(TAG_PVALUEPSDEFID);
    }

    public final String getPVALUEPSDEFID() {
        return this.getParamStringValue(TAG_PVALUEPSDEFID, "");
    }

    public final void setPVALUEPSDEFID(String strValue) {
        this.setParamValue(TAG_PVALUEPSDEFID, strValue);
    }

    public final boolean isPVALUEPSDEFNAMENull() {
        return this.isParamNull(TAG_PVALUEPSDEFNAME);
    }

    public final String getPVALUEPSDEFNAME() {
        return this.getParamStringValue(TAG_PVALUEPSDEFNAME, "");
    }

    public final void setPVALUEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PVALUEPSDEFNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isDYNASYSREFMODENull() {
        return this.isParamNull(TAG_DYNASYSREFMODE);
    }

    public final int getDYNASYSREFMODE() {
        return this.getParamIntValue(TAG_DYNASYSREFMODE, 0);
    }

    public final void setDYNASYSREFMODE(int nValue) {
        this.setParamValue(TAG_DYNASYSREFMODE, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.isParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.getParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.setParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSDYNAINSTNAMENull() {
        return this.isParamNull(TAG_PSDYNAINSTNAME);
    }

    public final String getPSDYNAINSTNAME() {
        return this.getParamStringValue(TAG_PSDYNAINSTNAME, "");
    }

    public final void setPSDYNAINSTNAME(String strValue) {
        this.setParamValue(TAG_PSDYNAINSTNAME, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.isParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.getParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.setParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }

    public final boolean isPSDYNACODELISTIDNull() {
        return this.isParamNull(TAG_PSDYNACODELISTID);
    }

    public final String getPSDYNACODELISTID() {
        return this.getParamStringValue(TAG_PSDYNACODELISTID, "");
    }

    public final void setPSDYNACODELISTID(String strValue) {
        this.setParamValue(TAG_PSDYNACODELISTID, strValue);
    }

    public final boolean isPSDYNACODELISTNAMENull() {
        return this.isParamNull(TAG_PSDYNACODELISTNAME);
    }

    public final String getPSDYNACODELISTNAME() {
        return this.getParamStringValue(TAG_PSDYNACODELISTNAME, "");
    }

    public final void setPSDYNACODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSDYNACODELISTNAME, strValue);
    }

    public final boolean isDISABLEPSDEFIDNull() {
        return this.isParamNull(TAG_DISABLEPSDEFID);
    }

    public final String getDISABLEPSDEFID() {
        return this.getParamStringValue(TAG_DISABLEPSDEFID, "");
    }

    public final void setDISABLEPSDEFID(String strValue) {
        this.setParamValue(TAG_DISABLEPSDEFID, strValue);
    }

    public final boolean isDISABLEPSDEFNAMENull() {
        return this.isParamNull(TAG_DISABLEPSDEFNAME);
    }

    public final String getDISABLEPSDEFNAME() {
        return this.getParamStringValue(TAG_DISABLEPSDEFNAME, "");
    }

    public final void setDISABLEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_DISABLEPSDEFNAME, strValue);
    }
}

