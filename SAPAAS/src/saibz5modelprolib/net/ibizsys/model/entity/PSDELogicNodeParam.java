/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDELNPARAMIDNull() {
        return this.isParamNull(TAG_PSDELNPARAMID);
    }

    public final String getPSDELNPARAMID() {
        return this.getParamStringValue(TAG_PSDELNPARAMID, "");
    }

    public final void setPSDELNPARAMID(String strValue) {
        this.setParamValue(TAG_PSDELNPARAMID, strValue);
    }

    public final boolean isPSDELNPARAMNAMENull() {
        return this.isParamNull(TAG_PSDELNPARAMNAME);
    }

    public final String getPSDELNPARAMNAME() {
        return this.getParamStringValue(TAG_PSDELNPARAMNAME, "");
    }

    public final void setPSDELNPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSDELNPARAMNAME, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.isParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.getParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.setParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isPSDELOGICNODEIDNull() {
        return this.isParamNull(TAG_PSDELOGICNODEID);
    }

    public final String getPSDELOGICNODEID() {
        return this.getParamStringValue(TAG_PSDELOGICNODEID, "");
    }

    public final void setPSDELOGICNODEID(String strValue) {
        this.setParamValue(TAG_PSDELOGICNODEID, strValue);
    }

    public final boolean isPSDELOGICNODENAMENull() {
        return this.isParamNull(TAG_PSDELOGICNODENAME);
    }

    public final String getPSDELOGICNODENAME() {
        return this.getParamStringValue(TAG_PSDELOGICNODENAME, "");
    }

    public final void setPSDELOGICNODENAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNODENAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.isParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.isParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMNAME, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.isParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.getParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.setParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEFNAMENull() {
        return this.isParamNull(TAG_DSTPSDEFNAME);
    }

    public final String getDSTPSDEFNAME() {
        return this.getParamStringValue(TAG_DSTPSDEFNAME, "");
    }

    public final void setDSTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDEFNAME, strValue);
    }

    public final boolean isSRCVALUETYPENull() {
        return this.isParamNull(TAG_SRCVALUETYPE);
    }

    public final String getSRCVALUETYPE() {
        return this.getParamStringValue(TAG_SRCVALUETYPE, "");
    }

    public final void setSRCVALUETYPE(String strValue) {
        this.setParamValue(TAG_SRCVALUETYPE, strValue);
    }

    public final boolean isSRCPSDLPARAMIDNull() {
        return this.isParamNull(TAG_SRCPSDLPARAMID);
    }

    public final String getSRCPSDLPARAMID() {
        return this.getParamStringValue(TAG_SRCPSDLPARAMID, "");
    }

    public final void setSRCPSDLPARAMID(String strValue) {
        this.setParamValue(TAG_SRCPSDLPARAMID, strValue);
    }

    public final boolean isSRCPSDLPARAMNAMENull() {
        return this.isParamNull(TAG_SRCPSDLPARAMNAME);
    }

    public final String getSRCPSDLPARAMNAME() {
        return this.getParamStringValue(TAG_SRCPSDLPARAMNAME, "");
    }

    public final void setSRCPSDLPARAMNAME(String strValue) {
        this.setParamValue(TAG_SRCPSDLPARAMNAME, strValue);
    }

    public final boolean isSRCPSDEFIDNull() {
        return this.isParamNull(TAG_SRCPSDEFID);
    }

    public final String getSRCPSDEFID() {
        return this.getParamStringValue(TAG_SRCPSDEFID, "");
    }

    public final void setSRCPSDEFID(String strValue) {
        this.setParamValue(TAG_SRCPSDEFID, strValue);
    }

    public final boolean isSRCPSDEFNAMENull() {
        return this.isParamNull(TAG_SRCPSDEFNAME);
    }

    public final String getSRCPSDEFNAME() {
        return this.getParamStringValue(TAG_SRCPSDEFNAME, "");
    }

    public final void setSRCPSDEFNAME(String strValue) {
        this.setParamValue(TAG_SRCPSDEFNAME, strValue);
    }

    public final boolean isCUSTOMSRCPARAMNull() {
        return this.isParamNull(TAG_CUSTOMSRCPARAM);
    }

    public final String getCUSTOMSRCPARAM() {
        return this.getParamStringValue(TAG_CUSTOMSRCPARAM, "");
    }

    public final void setCUSTOMSRCPARAM(String strValue) {
        this.setParamValue(TAG_CUSTOMSRCPARAM, strValue);
    }

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.isParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.getParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.setParamValue(TAG_CUSTOMDSTPARAM, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isDSTPARAMPSDEIDNull() {
        return this.isParamNull(TAG_DSTPARAMPSDEID);
    }

    public final String getDSTPARAMPSDEID() {
        return this.getParamStringValue(TAG_DSTPARAMPSDEID, "");
    }

    public final void setDSTPARAMPSDEID(String strValue) {
        this.setParamValue(TAG_DSTPARAMPSDEID, strValue);
    }

    public final boolean isSRCPARAMPSDEIDNull() {
        return this.isParamNull(TAG_SRCPARAMPSDEID);
    }

    public final String getSRCPARAMPSDEID() {
        return this.getParamStringValue(TAG_SRCPARAMPSDEID, "");
    }

    public final void setSRCPARAMPSDEID(String strValue) {
        this.setParamValue(TAG_SRCPARAMPSDEID, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.isParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.getParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.setParamValue(TAG_SRCVALUE, strValue);
    }
}

