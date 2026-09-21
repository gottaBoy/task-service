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

public class PSSysToolbarItem
extends BaseDataEntity {
    public static final String TBITEMTYPE_DEUIACTION = "DEUIACTION";
    public static final String TBITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String TBITEMTYPE_ITEMS = "ITEMS";
    public static final String TAG_PSSYSTBITEMID = "PSSYSTBITEMID";
    public static final String TAG_PSSYSTBITEMNAME = "PSSYSTBITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String TAG_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String TAG_PPSSYSTBITEMID = "PPSSYSTBITEMID";
    public static final String TAG_PPSSYSTBITEMNAME = "PPSSYSTBITEMNAME";
    public static final String TAG_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String TAG_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_TBITEMTYPE = "TBITEMTYPE";
    private ArrayList<PSSysToolbarItem> childPSSysToolbarItemList = null;

    public final boolean isPSSYSTBITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTBITEMID);
    }

    public final String getPSSYSTBITEMID() {
        return this.GetParamStringValue(TAG_PSSYSTBITEMID, "");
    }

    public final void setPSSYSTBITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTBITEMID, strValue);
    }

    public final boolean isPSSYSTBITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTBITEMNAME);
    }

    public final String getPSSYSTBITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTBITEMNAME, "");
    }

    public final void setPSSYSTBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTBITEMNAME, strValue);
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

    public final boolean isPSSYSTOOLBARIDNull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARID);
    }

    public final String getPSSYSTOOLBARID() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARID, "");
    }

    public final void setPSSYSTOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARID, strValue);
    }

    public final boolean isPSSYSTOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARNAME);
    }

    public final String getPSSYSTOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARNAME, "");
    }

    public final void setPSSYSTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARNAME, strValue);
    }

    public final boolean isPPSSYSTBITEMIDNull() {
        return this.IsParamNull(TAG_PPSSYSTBITEMID);
    }

    public final String getPPSSYSTBITEMID() {
        return this.GetParamStringValue(TAG_PPSSYSTBITEMID, "");
    }

    public final void setPPSSYSTBITEMID(String strValue) {
        this.SetParamValue(TAG_PPSSYSTBITEMID, strValue);
    }

    public final boolean isPPSSYSTBITEMNAMENull() {
        return this.IsParamNull(TAG_PPSSYSTBITEMNAME);
    }

    public final String getPPSSYSTBITEMNAME() {
        return this.GetParamStringValue(TAG_PPSSYSTBITEMNAME, "");
    }

    public final void setPPSSYSTBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSTBITEMNAME, strValue);
    }

    public final boolean isPSSYSUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONID);
    }

    public final String getPSSYSUIACTIONID() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONID, "");
    }

    public final void setPSSYSUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONID, strValue);
    }

    public final boolean isPSSYSUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONNAME);
    }

    public final String getPSSYSUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONNAME, "");
    }

    public final void setPSSYSUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isTBITEMTYPENull() {
        return this.IsParamNull(TAG_TBITEMTYPE);
    }

    public final String getTBITEMTYPE() {
        return this.GetParamStringValue(TAG_TBITEMTYPE, "");
    }

    public final void setTBITEMTYPE(String strValue) {
        this.SetParamValue(TAG_TBITEMTYPE, strValue);
    }

    public ArrayList<PSSysToolbarItem> getChildPSSysToolbarItems(boolean bCreated) {
        if (this.childPSSysToolbarItemList != null) {
            return this.childPSSysToolbarItemList;
        }
        if (bCreated) {
            this.childPSSysToolbarItemList = new ArrayList();
        }
        return this.childPSSysToolbarItemList;
    }

    public void resetChildDatas() {
        if (this.childPSSysToolbarItemList != null) {
            this.childPSSysToolbarItemList.clear();
            this.childPSSysToolbarItemList = null;
        }
    }
}

