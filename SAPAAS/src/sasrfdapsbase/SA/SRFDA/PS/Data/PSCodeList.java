/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_ENABLECACHE = "ENABLECACHE";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_DATAPSDEFID = "DATAPSDEFID";
    public static final String TAG_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_CLSPSDEFID = "CLSPSDEFID";
    public static final String TAG_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String TAG_BEGINVALUEPSDEFID = "BEGINVALUEPSDEFID";
    public static final String TAG_BEGINVALUEPSDEFNAME = "BEGINVALUEPSDEFNAME";
    public static final String TAG_ENDVALUEPSDEFID = "ENDVALUEPSDEFID";
    public static final String TAG_ENDVALUEPSDEFNAME = "ENDVALUEPSDEFNAME";
    public static final String TAG_THRESHOLDGROUPFLAG = "THRESHOLDGROUPFLAG";
    public static final String TAG_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String TAG_INCENDVALUE = "INCENDVALUE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_CACHECAT = "CACHECAT";
    public static final String TAG_CACHETAG = "CACHETAG";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_PSDEMSLOGICID = "PSDEMSLOGICID";
    public static final String TAG_PSDEMSLOGICNAME = "PSDEMSLOGICNAME";
    public static final String TAG_COLORPSDEFID = "COLORPSDEFID";
    public static final String TAG_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String TAG_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String TAG_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String TAG_ALLTEXT = "ALLTEXT";
    public static final String TAG_ALLTEXTPSLANRESID = "ALLTEXTPSLANRESID";
    public static final String TAG_ALLTEXTPSLANRESNAME = "ALLTEXTPSLANRESNAME";

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

    public final boolean isPSCODELISTTEMPLIDNull() {
        return this.IsParamNull(TAG_PSCODELISTTEMPLID);
    }

    public final String getPSCODELISTTEMPLID() {
        return this.GetParamStringValue(TAG_PSCODELISTTEMPLID, "");
    }

    public final void setPSCODELISTTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTTEMPLID, strValue);
    }

    public final boolean isPSCODELISTTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTTEMPLNAME);
    }

    public final String getPSCODELISTTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTTEMPLNAME, "");
    }

    public final void setPSCODELISTTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTTEMPLNAME, strValue);
    }

    public final boolean isCODELISTSNNull() {
        return this.IsParamNull(TAG_CODELISTSN);
    }

    public final String getCODELISTSN() {
        return this.GetParamStringValue(TAG_CODELISTSN, "");
    }

    public final void setCODELISTSN(String strValue) {
        this.SetParamValue(TAG_CODELISTSN, strValue);
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

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isCLMODELNull() {
        return this.IsParamNull(TAG_CLMODEL);
    }

    public final String getCLMODEL() {
        return this.GetParamStringValue(TAG_CLMODEL, "");
    }

    public final void setCLMODEL(String strValue) {
        this.SetParamValue(TAG_CLMODEL, strValue);
    }

    public final boolean isCLTYPENull() {
        return this.IsParamNull(TAG_CLTYPE);
    }

    public final String getCLTYPE() {
        return this.GetParamStringValue(TAG_CLTYPE, "");
    }

    public final void setCLTYPE(String strValue) {
        this.SetParamValue(TAG_CLTYPE, strValue);
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

    public final boolean isUSERSCOPENull() {
        return this.IsParamNull(TAG_USERSCOPE);
    }

    public final boolean getUSERSCOPE() {
        return this.GetParamIntValue(TAG_USERSCOPE, 0) == 1;
    }

    public final void setUSERSCOPE(boolean bValue) {
        this.SetParamValue(TAG_USERSCOPE, bValue ? 1 : 0);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isSYSREFFLAGNull() {
        return this.IsParamNull(TAG_SYSREFFLAG);
    }

    public final boolean getSYSREFFLAG() {
        return this.GetParamIntValue(TAG_SYSREFFLAG, 0) == 1;
    }

    public final void setSYSREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isUSERREFFLAGNull() {
        return this.IsParamNull(TAG_USERREFFLAG);
    }

    public final boolean getUSERREFFLAG() {
        return this.GetParamIntValue(TAG_USERREFFLAG, 0) == 1;
    }

    public final void setUSERREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isORMODENull() {
        return this.IsParamNull(TAG_ORMODE);
    }

    public final String getORMODE() {
        return this.GetParamStringValue(TAG_ORMODE, "");
    }

    public final void setORMODE(String strValue) {
        this.SetParamValue(TAG_ORMODE, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.IsParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.GetParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isSEPERATORNull() {
        return this.IsParamNull(TAG_SEPERATOR);
    }

    public final String getSEPERATOR() {
        return this.GetParamStringValue(TAG_SEPERATOR, "");
    }

    public final void setSEPERATOR(String strValue) {
        this.SetParamValue(TAG_SEPERATOR, strValue);
    }

    public final boolean isVALUESEPERATORNull() {
        return this.IsParamNull(TAG_VALUESEPERATOR);
    }

    public final String getVALUESEPERATOR() {
        return this.GetParamStringValue(TAG_VALUESEPERATOR, "");
    }

    public final void setVALUESEPERATOR(String strValue) {
        this.SetParamValue(TAG_VALUESEPERATOR, strValue);
    }

    public final boolean isNOVALUEEMPTYNull() {
        return this.IsParamNull(TAG_NOVALUEEMPTY);
    }

    public final boolean getNOVALUEEMPTY() {
        return this.GetParamIntValue(TAG_NOVALUEEMPTY, 0) == 1;
    }

    public final void setNOVALUEEMPTY(boolean bValue) {
        this.SetParamValue(TAG_NOVALUEEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isNUMBERITEMNull() {
        return this.IsParamNull(TAG_NUMBERITEM);
    }

    public final boolean getNUMBERITEM() {
        return this.GetParamIntValue(TAG_NUMBERITEM, 0) == 1;
    }

    public final void setNUMBERITEM(boolean bValue) {
        this.SetParamValue(TAG_NUMBERITEM, bValue ? 1 : 0);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.IsParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.GetParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isICONCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONCLSPSDEFID);
    }

    public final String getICONCLSPSDEFID() {
        return this.GetParamStringValue(TAG_ICONCLSPSDEFID, "");
    }

    public final void setICONCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONCLSPSDEFID, strValue);
    }

    public final boolean isICONCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONCLSPSDEFNAME);
    }

    public final String getICONCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONCLSPSDEFNAME, "");
    }

    public final void setICONCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONCLSPSDEFNAME, strValue);
    }

    public final boolean isICONPATHPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONPATHPSDEFID);
    }

    public final String getICONPATHPSDEFID() {
        return this.GetParamStringValue(TAG_ICONPATHPSDEFID, "");
    }

    public final void setICONPATHPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONPATHPSDEFID, strValue);
    }

    public final boolean isICONPATHPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONPATHPSDEFNAME);
    }

    public final String getICONPATHPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONPATHPSDEFNAME, "");
    }

    public final void setICONPATHPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONPATHPSDEFNAME, strValue);
    }

    public final boolean isICONCLSXPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONCLSXPSDEFID);
    }

    public final String getICONCLSXPSDEFID() {
        return this.GetParamStringValue(TAG_ICONCLSXPSDEFID, "");
    }

    public final void setICONCLSXPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONCLSXPSDEFID, strValue);
    }

    public final boolean isICONCLSXPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONCLSXPSDEFNAME);
    }

    public final String getICONCLSXPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONCLSXPSDEFNAME, "");
    }

    public final void setICONCLSXPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONCLSXPSDEFNAME, strValue);
    }

    public final boolean isICONPATHXPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONPATHXPSDEFID);
    }

    public final String getICONPATHXPSDEFID() {
        return this.GetParamStringValue(TAG_ICONPATHXPSDEFID, "");
    }

    public final void setICONPATHXPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONPATHXPSDEFID, strValue);
    }

    public final boolean isICONPATHXPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONPATHXPSDEFNAME);
    }

    public final String getICONPATHXPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONPATHXPSDEFNAME, "");
    }

    public final void setICONPATHXPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONPATHXPSDEFNAME, strValue);
    }

    public final boolean isDSCONDITIONSNull() {
        return this.IsParamNull(TAG_DSCONDITIONS);
    }

    public final String getDSCONDITIONS() {
        return this.GetParamStringValue(TAG_DSCONDITIONS, "");
    }

    public final void setDSCONDITIONS(String strValue) {
        this.SetParamValue(TAG_DSCONDITIONS, strValue);
    }

    public final boolean isPVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_PVALUEPSDEFID);
    }

    public final String getPVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_PVALUEPSDEFID, "");
    }

    public final void setPVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_PVALUEPSDEFID, strValue);
    }

    public final boolean isPVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_PVALUEPSDEFNAME);
    }

    public final String getPVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_PVALUEPSDEFNAME, "");
    }

    public final void setPVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PVALUEPSDEFNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isDYNASYSREFMODENull() {
        return this.IsParamNull(TAG_DYNASYSREFMODE);
    }

    public final int getDYNASYSREFMODE() {
        return this.GetParamIntValue(TAG_DYNASYSREFMODE, 0);
    }

    public final void setDYNASYSREFMODE(int nValue) {
        this.SetParamValue(TAG_DYNASYSREFMODE, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSDYNAINSTNAMENull() {
        return this.IsParamNull(TAG_PSDYNAINSTNAME);
    }

    public final String getPSDYNAINSTNAME() {
        return this.GetParamStringValue(TAG_PSDYNAINSTNAME, "");
    }

    public final void setPSDYNAINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTNAME, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }

    public final boolean isPSDYNACODELISTIDNull() {
        return this.IsParamNull(TAG_PSDYNACODELISTID);
    }

    public final String getPSDYNACODELISTID() {
        return this.GetParamStringValue(TAG_PSDYNACODELISTID, "");
    }

    public final void setPSDYNACODELISTID(String strValue) {
        this.SetParamValue(TAG_PSDYNACODELISTID, strValue);
    }

    public final boolean isPSDYNACODELISTNAMENull() {
        return this.IsParamNull(TAG_PSDYNACODELISTNAME);
    }

    public final String getPSDYNACODELISTNAME() {
        return this.GetParamStringValue(TAG_PSDYNACODELISTNAME, "");
    }

    public final void setPSDYNACODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNACODELISTNAME, strValue);
    }

    public final boolean isDISABLEPSDEFIDNull() {
        return this.IsParamNull(TAG_DISABLEPSDEFID);
    }

    public final String getDISABLEPSDEFID() {
        return this.GetParamStringValue(TAG_DISABLEPSDEFID, "");
    }

    public final void setDISABLEPSDEFID(String strValue) {
        this.SetParamValue(TAG_DISABLEPSDEFID, strValue);
    }

    public final boolean isDISABLEPSDEFNAMENull() {
        return this.IsParamNull(TAG_DISABLEPSDEFNAME);
    }

    public final String getDISABLEPSDEFNAME() {
        return this.GetParamStringValue(TAG_DISABLEPSDEFNAME, "");
    }

    public final void setDISABLEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DISABLEPSDEFNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isCACHETIMEOUTNull() {
        return this.IsParamNull(TAG_CACHETIMEOUT);
    }

    public final int getCACHETIMEOUT() {
        return this.GetParamIntValue(TAG_CACHETIMEOUT, 0);
    }

    public final void setCACHETIMEOUT(int nValue) {
        this.SetParamValue(TAG_CACHETIMEOUT, nValue);
    }

    public final boolean isENABLECACHENull() {
        return this.IsParamNull(TAG_ENABLECACHE);
    }

    public final boolean getENABLECACHE() {
        return this.GetParamIntValue(TAG_ENABLECACHE, 0) == 1;
    }

    public final void setENABLECACHE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECACHE, bValue ? 1 : 0);
    }

    public final boolean isDATAPSDEFIDNull() {
        return this.IsParamNull(TAG_DATAPSDEFID);
    }

    public final String getDATAPSDEFID() {
        return this.GetParamStringValue(TAG_DATAPSDEFID, "");
    }

    public final void setDATAPSDEFID(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFID, strValue);
    }

    public final boolean isDATAPSDEFNAMENull() {
        return this.IsParamNull(TAG_DATAPSDEFNAME);
    }

    public final String getDATAPSDEFNAME() {
        return this.GetParamStringValue(TAG_DATAPSDEFNAME, "");
    }

    public final void setDATAPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFNAME, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_CLSPSDEFID);
    }

    public final String getCLSPSDEFID() {
        return this.GetParamStringValue(TAG_CLSPSDEFID, "");
    }

    public final void setCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFID, strValue);
    }

    public final boolean isCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_CLSPSDEFNAME);
    }

    public final String getCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_CLSPSDEFNAME, "");
    }

    public final void setCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFNAME, strValue);
    }

    public final boolean isBEGINVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_BEGINVALUEPSDEFID);
    }

    public final String getBEGINVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_BEGINVALUEPSDEFID, "");
    }

    public final void setBEGINVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_BEGINVALUEPSDEFID, strValue);
    }

    public final boolean isBEGINVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_BEGINVALUEPSDEFNAME);
    }

    public final String getBEGINVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_BEGINVALUEPSDEFNAME, "");
    }

    public final void setBEGINVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BEGINVALUEPSDEFNAME, strValue);
    }

    public final boolean isENDVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_ENDVALUEPSDEFID);
    }

    public final String getENDVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_ENDVALUEPSDEFID, "");
    }

    public final void setENDVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_ENDVALUEPSDEFID, strValue);
    }

    public final boolean isENDVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_ENDVALUEPSDEFNAME);
    }

    public final String getENDVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_ENDVALUEPSDEFNAME, "");
    }

    public final void setENDVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ENDVALUEPSDEFNAME, strValue);
    }

    public final boolean isTHRESHOLDGROUPFLAGNull() {
        return this.IsParamNull(TAG_THRESHOLDGROUPFLAG);
    }

    public final boolean getTHRESHOLDGROUPFLAG() {
        return this.GetParamIntValue(TAG_THRESHOLDGROUPFLAG, 0) == 1;
    }

    public final void setTHRESHOLDGROUPFLAG(boolean bValue) {
        this.SetParamValue(TAG_THRESHOLDGROUPFLAG, bValue ? 1 : 0);
    }

    public final boolean isINCBEGINVALUENull() {
        return this.IsParamNull(TAG_INCBEGINVALUE);
    }

    public final int getINCBEGINVALUE() {
        return this.GetParamIntValue(TAG_INCBEGINVALUE, 0);
    }

    public final void setINCBEGINVALUE(int nValue) {
        this.SetParamValue(TAG_INCBEGINVALUE, nValue);
    }

    public final boolean isINCENDVALUENull() {
        return this.IsParamNull(TAG_INCENDVALUE);
    }

    public final int getINCENDVALUE() {
        return this.GetParamIntValue(TAG_INCENDVALUE, 0);
    }

    public final void setINCENDVALUE(int nValue) {
        this.SetParamValue(TAG_INCENDVALUE, nValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final String getCACHECAT() {
        return this.GetParamStringValue(TAG_CACHECAT, "");
    }

    public final void setCACHECAT(String strValue) {
        this.SetParamValue(TAG_CACHECAT, strValue);
    }

    public final boolean isCACHETAGNull() {
        return this.IsParamNull(TAG_CACHETAG);
    }

    public final String getCACHETAG() {
        return this.GetParamStringValue(TAG_CACHETAG, "");
    }

    public final void setCACHETAG(String strValue) {
        this.SetParamValue(TAG_CACHETAG, strValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isPSDEMSLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEMSLOGICID);
    }

    public final String getPSDEMSLOGICID() {
        return this.GetParamStringValue(TAG_PSDEMSLOGICID, "");
    }

    public final void setPSDEMSLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEMSLOGICID, strValue);
    }

    public final boolean isPSDEMSLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEMSLOGICNAME);
    }

    public final String getPSDEMSLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEMSLOGICNAME, "");
    }

    public final void setPSDEMSLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMSLOGICNAME, strValue);
    }

    public final boolean isCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_COLORPSDEFID);
    }

    public final String getCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_COLORPSDEFID, "");
    }

    public final void setCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFID, strValue);
    }

    public final boolean isCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_COLORPSDEFNAME);
    }

    public final String getCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_COLORPSDEFNAME, "");
    }

    public final void setCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFNAME, strValue);
    }

    public final boolean isBKCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFID);
    }

    public final String getBKCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFID, "");
    }

    public final void setBKCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFID, strValue);
    }

    public final boolean isBKCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFNAME);
    }

    public final String getBKCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFNAME, "");
    }

    public final void setBKCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFNAME, strValue);
    }

    public final boolean isALLTEXTNull() {
        return this.IsParamNull(TAG_ALLTEXT);
    }

    public final String getALLTEXT() {
        return this.GetParamStringValue(TAG_ALLTEXT, "");
    }

    public final void setALLTEXT(String strValue) {
        this.SetParamValue(TAG_ALLTEXT, strValue);
    }

    public final boolean isALLTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_ALLTEXTPSLANRESID);
    }

    public final String getALLTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_ALLTEXTPSLANRESID, "");
    }

    public final void setALLTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_ALLTEXTPSLANRESID, strValue);
    }

    public final boolean isALLTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_ALLTEXTPSLANRESNAME);
    }

    public final String getALLTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_ALLTEXTPSLANRESNAME, "");
    }

    public final void setALLTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_ALLTEXTPSLANRESNAME, strValue);
    }
}

