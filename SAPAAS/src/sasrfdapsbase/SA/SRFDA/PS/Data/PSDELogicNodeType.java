/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDELogicNodeType
extends BaseDataEntity {
    public static final String TAG_PSDELNTYPEID = "PSDELNTYPEID";
    public static final String TAG_PSDELNTYPENAME = "PSDELNTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_ITEMOBJ2 = "ITEMOBJ2";
    public static final String TAG_LOGICHOLDER = "LOGICHOLDER";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_ITEMOBJ3 = "ITEMOBJ3";
    public static final String TAG_ITEMOBJ4 = "ITEMOBJ4";
    public static final String TAG_ITEMOBJ5 = "ITEMOBJ5";
    public static final String TAG_ITEMOBJ6 = "ITEMOBJ6";

    public final boolean isPSDELNTYPEIDNull() {
        return this.IsParamNull(TAG_PSDELNTYPEID);
    }

    public final String getPSDELNTYPEID() {
        return this.GetParamStringValue(TAG_PSDELNTYPEID, "");
    }

    public final void setPSDELNTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDELNTYPEID, strValue);
    }

    public final boolean isPSDELNTYPENAMENull() {
        return this.IsParamNull(TAG_PSDELNTYPENAME);
    }

    public final String getPSDELNTYPENAME() {
        return this.GetParamStringValue(TAG_PSDELNTYPENAME, "");
    }

    public final void setPSDELNTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDELNTYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isITEMOBJNull() {
        return this.IsParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.GetParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ, strValue);
    }

    public final boolean isITEMOBJ2Null() {
        return this.IsParamNull(TAG_ITEMOBJ2);
    }

    public final String getITEMOBJ2() {
        return this.GetParamStringValue(TAG_ITEMOBJ2, "");
    }

    public final void setITEMOBJ2(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ2, strValue);
    }

    public final boolean isLOGICHOLDERNull() {
        return this.IsParamNull(TAG_LOGICHOLDER);
    }

    public final int getLOGICHOLDER() {
        return this.GetParamIntValue(TAG_LOGICHOLDER, 0);
    }

    public final void setLOGICHOLDER(int nValue) {
        this.SetParamValue(TAG_LOGICHOLDER, nValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.IsParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
    }

    public final boolean isITEMOBJ3Null() {
        return this.IsParamNull(TAG_ITEMOBJ3);
    }

    public final String getITEMOBJ3() {
        return this.GetParamStringValue(TAG_ITEMOBJ3, "");
    }

    public final void setITEMOBJ3(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ3, strValue);
    }

    public final boolean isITEMOBJ4Null() {
        return this.IsParamNull(TAG_ITEMOBJ4);
    }

    public final String getITEMOBJ4() {
        return this.GetParamStringValue(TAG_ITEMOBJ4, "");
    }

    public final void setITEMOBJ4(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ4, strValue);
    }

    public final boolean isITEMOBJ5Null() {
        return this.IsParamNull(TAG_ITEMOBJ5);
    }

    public final String getITEMOBJ5() {
        return this.GetParamStringValue(TAG_ITEMOBJ5, "");
    }

    public final void setITEMOBJ5(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ5, strValue);
    }

    public final boolean isITEMOBJ6Null() {
        return this.IsParamNull(TAG_ITEMOBJ6);
    }

    public final String getITEMOBJ6() {
        return this.GetParamStringValue(TAG_ITEMOBJ6, "");
    }

    public final void setITEMOBJ6(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ6, strValue);
    }
}

