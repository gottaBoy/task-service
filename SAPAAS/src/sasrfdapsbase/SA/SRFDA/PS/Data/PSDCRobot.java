/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCRobot
extends BaseDataEntity {
    public static final String ROBOTTYPE_C_A = "C_A";
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final String TAG_PSDCROBOTID = "PSDCROBOTID";
    public static final String TAG_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSROBOTID = "PSROBOTID";
    public static final String TAG_PSROBOTNAME = "PSROBOTNAME";
    public static final String TAG_MAXENERGY = "MAXENERGY";
    public static final String TAG_ROBOTTYPE = "ROBOTTYPE";
    public static final String TAG_ROBOTLEVEL = "ROBOTLEVEL";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_CURENERGY = "CURENERGY";
    public static final String TAG_LASTCALCTIME = "LASTCALCTIME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ENERGYRATE = "ENERGYRATE";
    public static final String TAG_LASTENERGY = "LASTENERGY";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_REFOBJNAME = "REFOBJNAME";
    public static final String TAG_REFOBJTYPE = "REFOBJTYPE";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_RESSTATE = "RESSTATE";

    public final boolean isPSDCROBOTIDNull() {
        return this.IsParamNull(TAG_PSDCROBOTID);
    }

    public final String getPSDCROBOTID() {
        return this.GetParamStringValue(TAG_PSDCROBOTID, "");
    }

    public final void setPSDCROBOTID(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTID, strValue);
    }

    public final boolean isPSDCROBOTNAMENull() {
        return this.IsParamNull(TAG_PSDCROBOTNAME);
    }

    public final String getPSDCROBOTNAME() {
        return this.GetParamStringValue(TAG_PSDCROBOTNAME, "");
    }

    public final void setPSDCROBOTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTNAME, strValue);
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

    public final boolean isPSROBOTIDNull() {
        return this.IsParamNull(TAG_PSROBOTID);
    }

    public final String getPSROBOTID() {
        return this.GetParamStringValue(TAG_PSROBOTID, "");
    }

    public final void setPSROBOTID(String strValue) {
        this.SetParamValue(TAG_PSROBOTID, strValue);
    }

    public final boolean isPSROBOTNAMENull() {
        return this.IsParamNull(TAG_PSROBOTNAME);
    }

    public final String getPSROBOTNAME() {
        return this.GetParamStringValue(TAG_PSROBOTNAME, "");
    }

    public final void setPSROBOTNAME(String strValue) {
        this.SetParamValue(TAG_PSROBOTNAME, strValue);
    }

    public final boolean isMAXENERGYNull() {
        return this.IsParamNull(TAG_MAXENERGY);
    }

    public final int getMAXENERGY() {
        return this.GetParamIntValue(TAG_MAXENERGY, 0);
    }

    public final void setMAXENERGY(int nValue) {
        this.SetParamValue(TAG_MAXENERGY, nValue);
    }

    public final boolean isROBOTTYPENull() {
        return this.IsParamNull(TAG_ROBOTTYPE);
    }

    public final String getROBOTTYPE() {
        return this.GetParamStringValue(TAG_ROBOTTYPE, "");
    }

    public final void setROBOTTYPE(String strValue) {
        this.SetParamValue(TAG_ROBOTTYPE, strValue);
    }

    public final boolean isROBOTLEVELNull() {
        return this.IsParamNull(TAG_ROBOTLEVEL);
    }

    public final int getROBOTLEVEL() {
        return this.GetParamIntValue(TAG_ROBOTLEVEL, 0);
    }

    public final void setROBOTLEVEL(int nValue) {
        this.SetParamValue(TAG_ROBOTLEVEL, nValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isCURENERGYNull() {
        return this.IsParamNull(TAG_CURENERGY);
    }

    public final int getCURENERGY() {
        return this.GetParamIntValue(TAG_CURENERGY, 0);
    }

    public final void setCURENERGY(int nValue) {
        this.SetParamValue(TAG_CURENERGY, nValue);
    }

    public final boolean isLASTCALCTIMENull() {
        return this.IsParamNull(TAG_LASTCALCTIME);
    }

    public final Date getLASTCALCTIME() {
        return this.GetParamDateValue(TAG_LASTCALCTIME, null);
    }

    public final void setLASTCALCTIME(Date dtValue) {
        this.SetParamValue(TAG_LASTCALCTIME, dtValue);
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

    public final boolean isENERGYRATENull() {
        return this.IsParamNull(TAG_ENERGYRATE);
    }

    public final float getENERGYRATE() {
        return this.GetParamFloatValue(TAG_ENERGYRATE, 0.0f);
    }

    public final void setENERGYRATE(float fValue) {
        this.SetParamValue(TAG_ENERGYRATE, Float.valueOf(fValue));
    }

    public final boolean isLASTENERGYNull() {
        return this.IsParamNull(TAG_LASTENERGY);
    }

    public final int getLASTENERGY() {
        return this.GetParamIntValue(TAG_LASTENERGY, 0);
    }

    public final void setLASTENERGY(int nValue) {
        this.SetParamValue(TAG_LASTENERGY, nValue);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isREFOBJNAMENull() {
        return this.IsParamNull(TAG_REFOBJNAME);
    }

    public final String getREFOBJNAME() {
        return this.GetParamStringValue(TAG_REFOBJNAME, "");
    }

    public final void setREFOBJNAME(String strValue) {
        this.SetParamValue(TAG_REFOBJNAME, strValue);
    }

    public final boolean isREFOBJTYPENull() {
        return this.IsParamNull(TAG_REFOBJTYPE);
    }

    public final String getREFOBJTYPE() {
        return this.GetParamStringValue(TAG_REFOBJTYPE, "");
    }

    public final void setREFOBJTYPE(String strValue) {
        this.SetParamValue(TAG_REFOBJTYPE, strValue);
    }

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
    }
}

