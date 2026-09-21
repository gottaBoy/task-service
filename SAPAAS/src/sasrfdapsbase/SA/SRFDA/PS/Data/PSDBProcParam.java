/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBProcParam
extends BaseDataEntity {
    public static final String PSDESPCODENAME_MYSQL5 = "MYSQL5";
    public static final String PSDESPCODENAME_DB2 = "DB2";
    public static final int PARAMDIR_Input = 1;
    public static final int PARAMDIR_Output = 2;
    public static final int PARAMDIR_InputOutput = 3;
    public static final int PARAMDIR_ReturnValue = 4;
    public static final int PARAMDIR_None = 5;
    public static final String TAG_PSDBPROCPARAMID = "PSDBPROCPARAMID";
    public static final String TAG_PSDBPROCPARAMNAME = "PSDBPROCPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDESPCODEID = "PSDESPCODEID";
    public static final String TAG_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String TAG_JDBCTYPE = "JDBCTYPE";
    public static final String TAG_PARAMDIR = "PARAMDIR";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDBPROCPARAMIDNull() {
        return this.IsParamNull(TAG_PSDBPROCPARAMID);
    }

    public final String getPSDBPROCPARAMID() {
        return this.GetParamStringValue(TAG_PSDBPROCPARAMID, "");
    }

    public final void setPSDBPROCPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDBPROCPARAMID, strValue);
    }

    public final boolean isPSDBPROCPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDBPROCPARAMNAME);
    }

    public final String getPSDBPROCPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDBPROCPARAMNAME, "");
    }

    public final void setPSDBPROCPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDBPROCPARAMNAME, strValue);
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

    public final boolean isPSDESPCODEIDNull() {
        return this.IsParamNull(TAG_PSDESPCODEID);
    }

    public final String getPSDESPCODEID() {
        return this.GetParamStringValue(TAG_PSDESPCODEID, "");
    }

    public final void setPSDESPCODEID(String strValue) {
        this.SetParamValue(TAG_PSDESPCODEID, strValue);
    }

    public final boolean isPSDESPCODENAMENull() {
        return this.IsParamNull(TAG_PSDESPCODENAME);
    }

    public final String getPSDESPCODENAME() {
        return this.GetParamStringValue(TAG_PSDESPCODENAME, "");
    }

    public final void setPSDESPCODENAME(String strValue) {
        this.SetParamValue(TAG_PSDESPCODENAME, strValue);
    }

    public final boolean isJDBCTYPENull() {
        return this.IsParamNull(TAG_JDBCTYPE);
    }

    public final int getJDBCTYPE() {
        return this.GetParamIntValue(TAG_JDBCTYPE, 0);
    }

    public final void setJDBCTYPE(int nValue) {
        this.SetParamValue(TAG_JDBCTYPE, nValue);
    }

    public final boolean isPARAMDIRNull() {
        return this.IsParamNull(TAG_PARAMDIR);
    }

    public final int getPARAMDIR() {
        return this.GetParamIntValue(TAG_PARAMDIR, 0);
    }

    public final void setPARAMDIR(int nValue) {
        this.SetParamValue(TAG_PARAMDIR, nValue);
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
}

