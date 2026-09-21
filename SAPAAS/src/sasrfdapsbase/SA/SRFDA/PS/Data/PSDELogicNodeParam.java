/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDELogicNodeParam
extends BaseDataEntity {
    public static final String PARAMTYPE_SETPARAMVALUE = "SETPARAMVALUE";
    public static final String PARAMTYPE_RESETPARAM = "RESETPARAM";
    public static final String PARAMTYPE_COPYPARAM = "COPYPARAM";
    public static final String PARAMTYPE_SQLPARAM = "SQLPARAM";
    public static final String SRCVALUETYPE_SRCDLPARAM = "SRCDLPARAM";
    public static final String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";
    public static final String SRCVALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String SRCVALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String TAG_PSDELNPARAMID = "PSDELNPARAMID";
    public static final String TAG_PSDELNPARAMNAME = "PSDELNPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_PSDELOGICNODEID = "PSDELOGICNODEID";
    public static final String TAG_PSDELOGICNODENAME = "PSDELOGICNODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String TAG_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String TAG_DSTPSDEFID = "DSTPSDEFID";
    public static final String TAG_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String TAG_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String TAG_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String TAG_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    public static final String TAG_SRCPSDEFID = "SRCPSDEFID";
    public static final String TAG_SRCPSDEFNAME = "SRCPSDEFNAME";
    public static final String TAG_CUSTOMSRCPARAM = "CUSTOMSRCPARAM";
    public static final String TAG_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_DSTPARAMPSDEID = "DSTPARAMPSDEID";
    public static final String TAG_SRCPARAMPSDEID = "SRCPARAMPSDEID";
    public static final String TAG_SRCVALUE = "SRCVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DIRECTCODE = "DIRECTCODE";
    public static final String TAG_AGGMODE = "AGGMODE";
    public static final String TAG_DSTINDEX = "DSTINDEX";
    public static final String TAG_SRCINDEX = "SRCINDEX";
    public static final String TAG_SRCSIZE = "SRCSIZE";
    public static final String TAG_DSTSORTDIR = "DSTSORTDIR";
    public static final String TAG_SRCVALUESTDDATATYPE = "SRCVALUESTDDATATYPE";
    public static final String TAG_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String TAG_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_INOUTFLAG = "INOUTFLAG";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_PARAMS = "PARAMS";

    public final boolean isPSDELNPARAMIDNull() {
        return this.IsParamNull(TAG_PSDELNPARAMID);
    }

    public final String getPSDELNPARAMID() {
        return this.GetParamStringValue(TAG_PSDELNPARAMID, "");
    }

    public final void setPSDELNPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDELNPARAMID, strValue);
    }

    public final boolean isPSDELNPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDELNPARAMNAME);
    }

    public final String getPSDELNPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDELNPARAMNAME, "");
    }

    public final void setPSDELNPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDELNPARAMNAME, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isPSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSDELOGICNODEID);
    }

    public final String getPSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_PSDELOGICNODEID, "");
    }

    public final void setPSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNODEID, strValue);
    }

    public final boolean isPSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNODENAME);
    }

    public final String getPSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNODENAME, "");
    }

    public final void setPSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNODENAME, strValue);
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

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMNAME, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.GetParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEFNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFNAME);
    }

    public final String getDSTPSDEFNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFNAME, "");
    }

    public final void setDSTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFNAME, strValue);
    }

    public final boolean isSRCVALUETYPENull() {
        return this.IsParamNull(TAG_SRCVALUETYPE);
    }

    public final String getSRCVALUETYPE() {
        return this.GetParamStringValue(TAG_SRCVALUETYPE, "");
    }

    public final void setSRCVALUETYPE(String strValue) {
        this.SetParamValue(TAG_SRCVALUETYPE, strValue);
    }

    public final boolean isSRCPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMID);
    }

    public final String getSRCPSDLPARAMID() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMID, "");
    }

    public final void setSRCPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_SRCPSDLPARAMID, strValue);
    }

    public final boolean isSRCPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMNAME);
    }

    public final String getSRCPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMNAME, "");
    }

    public final void setSRCPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSDLPARAMNAME, strValue);
    }

    public final boolean isSRCPSDEFIDNull() {
        return this.IsParamNull(TAG_SRCPSDEFID);
    }

    public final String getSRCPSDEFID() {
        return this.GetParamStringValue(TAG_SRCPSDEFID, "");
    }

    public final void setSRCPSDEFID(String strValue) {
        this.SetParamValue(TAG_SRCPSDEFID, strValue);
    }

    public final boolean isSRCPSDEFNAMENull() {
        return this.IsParamNull(TAG_SRCPSDEFNAME);
    }

    public final String getSRCPSDEFNAME() {
        return this.GetParamStringValue(TAG_SRCPSDEFNAME, "");
    }

    public final void setSRCPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSDEFNAME, strValue);
    }

    public final boolean isCUSTOMSRCPARAMNull() {
        return this.IsParamNull(TAG_CUSTOMSRCPARAM);
    }

    public final String getCUSTOMSRCPARAM() {
        return this.GetParamStringValue(TAG_CUSTOMSRCPARAM, "");
    }

    public final void setCUSTOMSRCPARAM(String strValue) {
        this.SetParamValue(TAG_CUSTOMSRCPARAM, strValue);
    }

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.IsParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.GetParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.SetParamValue(TAG_CUSTOMDSTPARAM, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isDSTPARAMPSDEIDNull() {
        return this.IsParamNull(TAG_DSTPARAMPSDEID);
    }

    public final String getDSTPARAMPSDEID() {
        return this.GetParamStringValue(TAG_DSTPARAMPSDEID, "");
    }

    public final void setDSTPARAMPSDEID(String strValue) {
        this.SetParamValue(TAG_DSTPARAMPSDEID, strValue);
    }

    public final boolean isSRCPARAMPSDEIDNull() {
        return this.IsParamNull(TAG_SRCPARAMPSDEID);
    }

    public final String getSRCPARAMPSDEID() {
        return this.GetParamStringValue(TAG_SRCPARAMPSDEID, "");
    }

    public final void setSRCPARAMPSDEID(String strValue) {
        this.SetParamValue(TAG_SRCPARAMPSDEID, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.IsParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.GetParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.SetParamValue(TAG_SRCVALUE, strValue);
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

    public final boolean isDIRECTCODENull() {
        return this.IsParamNull(TAG_DIRECTCODE);
    }

    public final String getDIRECTCODE() {
        return this.GetParamStringValue(TAG_DIRECTCODE, "");
    }

    public final void setDIRECTCODE(String strValue) {
        this.SetParamValue(TAG_DIRECTCODE, strValue);
    }

    public final boolean isAGGMODENull() {
        return this.IsParamNull(TAG_AGGMODE);
    }

    public final String getAGGMODE() {
        return this.GetParamStringValue(TAG_AGGMODE, "");
    }

    public final void setAGGMODE(String strValue) {
        this.SetParamValue(TAG_AGGMODE, strValue);
    }

    public final boolean isDSTINDEXNull() {
        return this.IsParamNull(TAG_DSTINDEX);
    }

    public final int getDSTINDEX() {
        return this.GetParamIntValue(TAG_DSTINDEX, 0);
    }

    public final void setDSTINDEX(int nValue) {
        this.SetParamValue(TAG_DSTINDEX, nValue);
    }

    public final boolean isSRCINDEXNull() {
        return this.IsParamNull(TAG_SRCINDEX);
    }

    public final int getSRCINDEX() {
        return this.GetParamIntValue(TAG_SRCINDEX, 0);
    }

    public final void setSRCINDEX(int nValue) {
        this.SetParamValue(TAG_SRCINDEX, nValue);
    }

    public final boolean isSRCSIZENull() {
        return this.IsParamNull(TAG_SRCSIZE);
    }

    public final int getSRCSIZE() {
        return this.GetParamIntValue(TAG_SRCSIZE, 0);
    }

    public final void setSRCSIZE(int nValue) {
        this.SetParamValue(TAG_SRCSIZE, nValue);
    }

    public final boolean isDSTSORTDIRNull() {
        return this.IsParamNull(TAG_DSTSORTDIR);
    }

    public final String getDSTSORTDIR() {
        return this.GetParamStringValue(TAG_DSTSORTDIR, "");
    }

    public final void setDSTSORTDIR(String strValue) {
        this.SetParamValue(TAG_DSTSORTDIR, strValue);
    }

    public final boolean isSRCVALUESTDDATATYPENull() {
        return this.IsParamNull(TAG_SRCVALUESTDDATATYPE);
    }

    public final int getSRCVALUESTDDATATYPE() {
        return this.GetParamIntValue(TAG_SRCVALUESTDDATATYPE, 0);
    }

    public final void setSRCVALUESTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_SRCVALUESTDDATATYPE, nValue);
    }

    public final boolean isPSSYSSEQUENCEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCEID);
    }

    public final String getPSSYSSEQUENCEID() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCEID, "");
    }

    public final void setPSSYSSEQUENCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCEID, strValue);
    }

    public final boolean isPSSYSSEQUENCENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCENAME);
    }

    public final String getPSSYSSEQUENCENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCENAME, "");
    }

    public final void setPSSYSSEQUENCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCENAME, strValue);
    }

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
    }

    public final boolean isINOUTFLAGNull() {
        return this.IsParamNull(TAG_INOUTFLAG);
    }

    public final boolean getINOUTFLAG() {
        return this.GetParamIntValue(TAG_INOUTFLAG, 0) == 1;
    }

    public final void setINOUTFLAG(boolean bValue) {
        this.SetParamValue(TAG_INOUTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isPARAMSNull() {
        return this.IsParamNull(TAG_PARAMS);
    }

    public final String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public final void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }
}

