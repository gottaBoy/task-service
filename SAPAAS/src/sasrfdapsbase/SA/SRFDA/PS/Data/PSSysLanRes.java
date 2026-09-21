/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysLanRes
extends BaseDataEntity {
    public static final String LANRESTYPE_DE_LNAME = "DE.LNAME";
    public static final String LANRESTYPE_DEF_LNAME = "DEF.LNAME";
    public static final String LANRESTYPE_CL_ITEM_LNAME = "CL.ITEM.LNAME";
    public static final String LANRESTYPE_TBB_TEXT = "TBB.TEXT";
    public static final String LANRESTYPE_TBB_TOOLTIP = "TBB.TOOLTIP";
    public static final String LANRESTYPE_MENUITEM_CAPTION = "MENUITEM.CAPTION";
    public static final String LANRESTYPE_PAGE_HEADER = "PAGE.HEADER";
    public static final String LANRESTYPE_PAGE_COMMON = "PAGE.COMMON";
    public static final String LANRESTYPE_PAGE = "PAGE";
    public static final String LANRESTYPE_CONTROL = "CONTROL";
    public static final String LANRESTYPE_ERROR_STD = "ERROR.STD";
    public static final String LANRESTYPE_CTRL = "CTRL";
    public static final String LANRESTYPE_COMMON = "COMMON";
    public static final String LANRESTYPE_OTHER = "OTHER";
    public static final String TAG_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String TAG_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LANRESTYPE = "LANRESTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSSYSLANRESIDNull() {
        return this.IsParamNull(TAG_PSSYSLANRESID);
    }

    public final String getPSSYSLANRESID() {
        return this.GetParamStringValue(TAG_PSSYSLANRESID, "");
    }

    public final void setPSSYSLANRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESID, strValue);
    }

    public final boolean isPSSYSLANRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSLANRESNAME);
    }

    public final String getPSSYSLANRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSLANRESNAME, "");
    }

    public final void setPSSYSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESNAME, strValue);
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

    public final boolean isLANRESTYPENull() {
        return this.IsParamNull(TAG_LANRESTYPE);
    }

    public final String getLANRESTYPE() {
        return this.GetParamStringValue(TAG_LANRESTYPE, "");
    }

    public final void setLANRESTYPE(String strValue) {
        this.SetParamValue(TAG_LANRESTYPE, strValue);
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

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
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
}

