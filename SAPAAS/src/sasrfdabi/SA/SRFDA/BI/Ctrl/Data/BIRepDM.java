/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepDM
extends BaseDataEntity {
    public static final String PLACEMENT_COLHEADER = "COLHEADER";
    public static final String PLACEMENT_ROWHEADER = "ROWHEADER";
    public static final String PLACETYPE_FROZEN = "FROZEN";
    public static final String PLACETYPE_SHOW = "SHOW";
    public static final String PLACETYPE_HIDDEN = "HIDDEN";
    public static final String TAG_BIREPDMID = "BIREPDMID";
    public static final String TAG_BIREPDMNAME = "BIREPDMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPORTEXNAME = "BIREPORTEXNAME";
    public static final String TAG_BIREPORTEXID = "BIREPORTEXID";
    public static final String TAG_BICUBEDIMENSIONID = "BICUBEDIMENSIONID";
    public static final String TAG_BICUBEDIMENSIONNAME = "BICUBEDIMENSIONNAME";
    public static final String TAG_PLACEMENT = "PLACEMENT";
    public static final String TAG_PLACEPOS = "PLACEPOS";
    public static final String TAG_PLACEDEFAULT = "PLACEDEFAULT";
    public static final String TAG_ENABLEFILTER = "ENABLEFILTER";
    public static final String TAG_DEFAULTFILTER = "DEFAULTFILTER";
    public static final String TAG_FILTERCONVERT = "FILTERCONVERT";
    public static final String TAG_BIHIERARCHYID = "BIHIERARCHYID";
    public static final String TAG_BIHIERARCHYNAME = "BIHIERARCHYNAME";
    public static final String TAG_FILTERPOS = "FILTERPOS";
    public static final String TAG_PLACETYPE = "PLACETYPE";
    public static final String TAG_ALLDATAFLAG = "ALLDATAFLAG";

    public boolean isBIREPDMIDNull() {
        return this.IsParamNull(TAG_BIREPDMID);
    }

    public String getBIREPDMID() {
        return this.GetParamStringValue(TAG_BIREPDMID, "");
    }

    public void setBIREPDMID(String strValue) {
        this.SetParamValue(TAG_BIREPDMID, strValue);
    }

    public boolean isBIREPDMNAMENull() {
        return this.IsParamNull(TAG_BIREPDMNAME);
    }

    public String getBIREPDMNAME() {
        return this.GetParamStringValue(TAG_BIREPDMNAME, "");
    }

    public void setBIREPDMNAME(String strValue) {
        this.SetParamValue(TAG_BIREPDMNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isBIREPORTEXNAMENull() {
        return this.IsParamNull(TAG_BIREPORTEXNAME);
    }

    public String getBIREPORTEXNAME() {
        return this.GetParamStringValue(TAG_BIREPORTEXNAME, "");
    }

    public void setBIREPORTEXNAME(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXNAME, strValue);
    }

    public boolean isBIREPORTEXIDNull() {
        return this.IsParamNull(TAG_BIREPORTEXID);
    }

    public String getBIREPORTEXID() {
        return this.GetParamStringValue(TAG_BIREPORTEXID, "");
    }

    public void setBIREPORTEXID(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXID, strValue);
    }

    public boolean isBICUBEDIMENSIONIDNull() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONID);
    }

    public String getBICUBEDIMENSIONID() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONID, "");
    }

    public void setBICUBEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONID, strValue);
    }

    public boolean isBICUBEDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONNAME);
    }

    public String getBICUBEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONNAME, "");
    }

    public void setBICUBEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONNAME, strValue);
    }

    public boolean isPLACEMENTNull() {
        return this.IsParamNull(TAG_PLACEMENT);
    }

    public String getPLACEMENT() {
        return this.GetParamStringValue(TAG_PLACEMENT, "");
    }

    public void setPLACEMENT(String strValue) {
        this.SetParamValue(TAG_PLACEMENT, strValue);
    }

    public boolean isPLACEPOSNull() {
        return this.IsParamNull(TAG_PLACEPOS);
    }

    public int getPLACEPOS() {
        return this.GetParamIntValue(TAG_PLACEPOS, 0);
    }

    public void setPLACEPOS(int strValue) {
        this.SetParamValue(TAG_PLACEPOS, strValue);
    }

    public boolean isPLACEDEFAULTNull() {
        return this.IsParamNull(TAG_PLACEDEFAULT);
    }

    public boolean getPLACEDEFAULT() {
        return this.GetParamIntValue(TAG_PLACEDEFAULT, 0) == 1;
    }

    public void setPLACEDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_PLACEDEFAULT, bValue ? 1 : 0);
    }

    public boolean isENABLEFILTERNull() {
        return this.IsParamNull(TAG_ENABLEFILTER);
    }

    public boolean getENABLEFILTER() {
        return this.GetParamIntValue(TAG_ENABLEFILTER, 0) == 1;
    }

    public void setENABLEFILTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFILTER, bValue ? 1 : 0);
    }

    public boolean isDEFAULTFILTERNull() {
        return this.IsParamNull(TAG_DEFAULTFILTER);
    }

    public String getDEFAULTFILTER() {
        return this.GetParamStringValue(TAG_DEFAULTFILTER, "");
    }

    public void setDEFAULTFILTER(String strValue) {
        this.SetParamValue(TAG_DEFAULTFILTER, strValue);
    }

    public boolean isFILTERCONVERTNull() {
        return this.IsParamNull(TAG_FILTERCONVERT);
    }

    public String getFILTERCONVERT() {
        return this.GetParamStringValue(TAG_FILTERCONVERT, "");
    }

    public void setFILTERCONVERT(String strValue) {
        this.SetParamValue(TAG_FILTERCONVERT, strValue);
    }

    public boolean isBIHIERARCHYIDNull() {
        return this.IsParamNull(TAG_BIHIERARCHYID);
    }

    public String getBIHIERARCHYID() {
        return this.GetParamStringValue(TAG_BIHIERARCHYID, "");
    }

    public void setBIHIERARCHYID(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYID, strValue);
    }

    public boolean isBIHIERARCHYNAMENull() {
        return this.IsParamNull(TAG_BIHIERARCHYNAME);
    }

    public String getBIHIERARCHYNAME() {
        return this.GetParamStringValue(TAG_BIHIERARCHYNAME, "");
    }

    public void setBIHIERARCHYNAME(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYNAME, strValue);
    }

    public boolean isFILTERPOSNull() {
        return this.IsParamNull(TAG_FILTERPOS);
    }

    public int getFILTERPOS() {
        return this.GetParamIntValue(TAG_FILTERPOS, 0);
    }

    public void setFILTERPOS(int strValue) {
        this.SetParamValue(TAG_FILTERPOS, strValue);
    }

    public boolean isPLACETYPENull() {
        return this.IsParamNull(TAG_PLACETYPE);
    }

    public String getPLACETYPE() {
        return this.GetParamStringValue(TAG_PLACETYPE, "");
    }

    public void setPLACETYPE(String strValue) {
        this.SetParamValue(TAG_PLACETYPE, strValue);
    }

    public boolean isALLDATAFLAGNull() {
        return this.IsParamNull(TAG_ALLDATAFLAG);
    }

    public boolean getALLDATAFLAG() {
        return this.GetParamIntValue(TAG_ALLDATAFLAG, 0) == 1;
    }

    public void setALLDATAFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLDATAFLAG, bValue ? 1 : 0);
    }
}

