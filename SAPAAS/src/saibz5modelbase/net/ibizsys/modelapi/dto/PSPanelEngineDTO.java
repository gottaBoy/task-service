/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSPanelEngineDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENGINEPARAM = "engineparam";
    public static final String FIELD_ENGINEPARAM10 = "engineparam10";
    public static final String FIELD_ENGINEPARAM10FLAG = "engineparam10flag";
    public static final String FIELD_ENGINEPARAM10LABEL = "engineparam10label";
    public static final String FIELD_ENGINEPARAM2 = "engineparam2";
    public static final String FIELD_ENGINEPARAM2FLAG = "engineparam2flag";
    public static final String FIELD_ENGINEPARAM2LABEL = "engineparam2label";
    public static final String FIELD_ENGINEPARAM3 = "engineparam3";
    public static final String FIELD_ENGINEPARAM3FLAG = "engineparam3flag";
    public static final String FIELD_ENGINEPARAM3LABEL = "engineparam3label";
    public static final String FIELD_ENGINEPARAM4 = "engineparam4";
    public static final String FIELD_ENGINEPARAM4FLAG = "engineparam4flag";
    public static final String FIELD_ENGINEPARAM4LABEL = "engineparam4label";
    public static final String FIELD_ENGINEPARAM5 = "engineparam5";
    public static final String FIELD_ENGINEPARAM5FLAG = "engineparam5flag";
    public static final String FIELD_ENGINEPARAM5LABEL = "engineparam5label";
    public static final String FIELD_ENGINEPARAM6 = "engineparam6";
    public static final String FIELD_ENGINEPARAM6FLAG = "engineparam6flag";
    public static final String FIELD_ENGINEPARAM6LABEL = "engineparam6label";
    public static final String FIELD_ENGINEPARAM7 = "engineparam7";
    public static final String FIELD_ENGINEPARAM7FLAG = "engineparam7flag";
    public static final String FIELD_ENGINEPARAM7LABEL = "engineparam7label";
    public static final String FIELD_ENGINEPARAM8 = "engineparam8";
    public static final String FIELD_ENGINEPARAM8FLAG = "engineparam8flag";
    public static final String FIELD_ENGINEPARAM8LABEL = "engineparam8label";
    public static final String FIELD_ENGINEPARAM9 = "engineparam9";
    public static final String FIELD_ENGINEPARAM9FLAG = "engineparam9flag";
    public static final String FIELD_ENGINEPARAM9LABEL = "engineparam9label";
    public static final String FIELD_ENGINEPARAMFLAG = "engineparamflag";
    public static final String FIELD_ENGINEPARAMLABEL = "engineparamlabel";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NO2PANELITEMFLAG = "no2panelitemflag";
    public static final String FIELD_NO2PANELITEMLABEL = "no2panelitemlabel";
    public static final String FIELD_NO2PANELLOGICFLAG = "no2panellogicflag";
    public static final String FIELD_NO2PANELLOGICLABEL = "no2panellogiclabel";
    public static final String FIELD_NO2PSPANELITEMID = "no2pspanelitemid";
    public static final String FIELD_NO2PSPANELITEMNAME = "no2pspanelitemname";
    public static final String FIELD_NO2PSPANELLOGICID = "no2pspanellogicid";
    public static final String FIELD_NO2PSPANELLOGICNAME = "no2pspanellogicname";
    public static final String FIELD_NO3PANELITEMFLAG = "no3panelitemflag";
    public static final String FIELD_NO3PANELITEMLABEL = "no3panelitemlabel";
    public static final String FIELD_NO3PANELLOGICFLAG = "no3panellogicflag";
    public static final String FIELD_NO3PANELLOGICLABEL = "no3panellogiclabel";
    public static final String FIELD_NO3PSPANELITEMID = "no3pspanelitemid";
    public static final String FIELD_NO3PSPANELITEMNAME = "no3pspanelitemname";
    public static final String FIELD_NO3PSPANELLOGICID = "no3pspanellogicid";
    public static final String FIELD_NO3PSPANELLOGICNAME = "no3pspanellogicname";
    public static final String FIELD_NO4PANELITEMFLAG = "no4panelitemflag";
    public static final String FIELD_NO4PANELITEMLABEL = "no4panelitemlabel";
    public static final String FIELD_NO4PANELLOGICFLAG = "no4panellogicflag";
    public static final String FIELD_NO4PANELLOGICLABEL = "no4panellogiclabel";
    public static final String FIELD_NO4PSPANELITEMID = "no4pspanelitemid";
    public static final String FIELD_NO4PSPANELITEMNAME = "no4pspanelitemname";
    public static final String FIELD_NO4PSPANELLOGICID = "no4pspanellogicid";
    public static final String FIELD_NO4PSPANELLOGICNAME = "no4pspanellogicname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PANELITEMFLAG = "panelitemflag";
    public static final String FIELD_PANELITEMLABEL = "panelitemlabel";
    public static final String FIELD_PANELLOGICFLAG = "panellogicflag";
    public static final String FIELD_PANELLOGICLABEL = "panellogiclabel";
    public static final String FIELD_PSPANELENGINEID = "pspanelengineid";
    public static final String FIELD_PSPANELENGINENAME = "pspanelenginename";
    public static final String FIELD_PSPANELITEMID = "pspanelitemid";
    public static final String FIELD_PSPANELITEMNAME = "pspanelitemname";
    public static final String FIELD_PSPANELLOGICID = "pspanellogicid";
    public static final String FIELD_PSPANELLOGICNAME = "pspanellogicname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_PSUIENGINETYPEID = "psuienginetypeid";
    public static final String FIELD_PSUIENGINETYPENAME = "psuienginetypename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWPARAM = "viewparam";
    public static final String FIELD_VIEWPARAM10 = "viewparam10";
    public static final String FIELD_VIEWPARAM2 = "viewparam2";
    public static final String FIELD_VIEWPARAM3 = "viewparam3";
    public static final String FIELD_VIEWPARAM4 = "viewparam4";
    public static final String FIELD_VIEWPARAM5 = "viewparam5";
    public static final String FIELD_VIEWPARAM6 = "viewparam6";
    public static final String FIELD_VIEWPARAM7 = "viewparam7";
    public static final String FIELD_VIEWPARAM8 = "viewparam8";
    public static final String FIELD_VIEWPARAM9 = "viewparam9";
    public static final String FIELD_WFVIEWPARAM = "wfviewparam";
    public static final String FIELD_WFVIEWPARAM2 = "wfviewparam2";
    public static final String FIELD_WFVIEWPARAM3 = "wfviewparam3";
    public static final String FIELD_WFVIEWPARAM4 = "wfviewparam4";

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public String getEngineParam() {
        Object objValue = this.get(FIELD_ENGINEPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam")
    public void setEngineParam(String engineParam) {
        this.set(FIELD_ENGINEPARAM, engineParam);
    }

    @JsonIgnore
    public boolean isEngineParamDirty() {
        return this.contains(FIELD_ENGINEPARAM);
    }

    @JsonIgnore
    public Integer getEngineParam10() {
        Object objValue = this.get(FIELD_ENGINEPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam10")
    public void setEngineParam10(Integer engineParam10) {
        this.set(FIELD_ENGINEPARAM10, engineParam10);
    }

    @JsonIgnore
    public boolean isEngineParam10Dirty() {
        return this.contains(FIELD_ENGINEPARAM10);
    }

    @JsonIgnore
    public Integer getEngineParam10Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM10FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam10flag")
    public void setEngineParam10Flag(Integer engineParam10Flag) {
        this.set(FIELD_ENGINEPARAM10FLAG, engineParam10Flag);
    }

    @JsonIgnore
    public boolean isEngineParam10FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM10FLAG);
    }

    @JsonIgnore
    public String getEngineParam10Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM10LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam10label")
    public void setEngineParam10Label(String engineParam10Label) {
        this.set(FIELD_ENGINEPARAM10LABEL, engineParam10Label);
    }

    @JsonIgnore
    public boolean isEngineParam10LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM10LABEL);
    }

    @JsonIgnore
    public String getEngineParam2() {
        Object objValue = this.get(FIELD_ENGINEPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam2")
    public void setEngineParam2(String engineParam2) {
        this.set(FIELD_ENGINEPARAM2, engineParam2);
    }

    @JsonIgnore
    public boolean isEngineParam2Dirty() {
        return this.contains(FIELD_ENGINEPARAM2);
    }

    @JsonIgnore
    public Integer getEngineParam2Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM2FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam2flag")
    public void setEngineParam2Flag(Integer engineParam2Flag) {
        this.set(FIELD_ENGINEPARAM2FLAG, engineParam2Flag);
    }

    @JsonIgnore
    public boolean isEngineParam2FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM2FLAG);
    }

    @JsonIgnore
    public String getEngineParam2Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM2LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam2label")
    public void setEngineParam2Label(String engineParam2Label) {
        this.set(FIELD_ENGINEPARAM2LABEL, engineParam2Label);
    }

    @JsonIgnore
    public boolean isEngineParam2LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM2LABEL);
    }

    @JsonIgnore
    public String getEngineParam3() {
        Object objValue = this.get(FIELD_ENGINEPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam3")
    public void setEngineParam3(String engineParam3) {
        this.set(FIELD_ENGINEPARAM3, engineParam3);
    }

    @JsonIgnore
    public boolean isEngineParam3Dirty() {
        return this.contains(FIELD_ENGINEPARAM3);
    }

    @JsonIgnore
    public Integer getEngineParam3Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM3FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam3flag")
    public void setEngineParam3Flag(Integer engineParam3Flag) {
        this.set(FIELD_ENGINEPARAM3FLAG, engineParam3Flag);
    }

    @JsonIgnore
    public boolean isEngineParam3FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM3FLAG);
    }

    @JsonIgnore
    public String getEngineParam3Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM3LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam3label")
    public void setEngineParam3Label(String engineParam3Label) {
        this.set(FIELD_ENGINEPARAM3LABEL, engineParam3Label);
    }

    @JsonIgnore
    public boolean isEngineParam3LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM3LABEL);
    }

    @JsonIgnore
    public String getEngineParam4() {
        Object objValue = this.get(FIELD_ENGINEPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam4")
    public void setEngineParam4(String engineParam4) {
        this.set(FIELD_ENGINEPARAM4, engineParam4);
    }

    @JsonIgnore
    public boolean isEngineParam4Dirty() {
        return this.contains(FIELD_ENGINEPARAM4);
    }

    @JsonIgnore
    public Integer getEngineParam4Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM4FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam4flag")
    public void setEngineParam4Flag(Integer engineParam4Flag) {
        this.set(FIELD_ENGINEPARAM4FLAG, engineParam4Flag);
    }

    @JsonIgnore
    public boolean isEngineParam4FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM4FLAG);
    }

    @JsonIgnore
    public String getEngineParam4Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM4LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam4label")
    public void setEngineParam4Label(String engineParam4Label) {
        this.set(FIELD_ENGINEPARAM4LABEL, engineParam4Label);
    }

    @JsonIgnore
    public boolean isEngineParam4LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM4LABEL);
    }

    @JsonIgnore
    public Integer getEngineParam5() {
        Object objValue = this.get(FIELD_ENGINEPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam5")
    public void setEngineParam5(Integer engineParam5) {
        this.set(FIELD_ENGINEPARAM5, engineParam5);
    }

    @JsonIgnore
    public boolean isEngineParam5Dirty() {
        return this.contains(FIELD_ENGINEPARAM5);
    }

    @JsonIgnore
    public Integer getEngineParam5Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM5FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam5flag")
    public void setEngineParam5Flag(Integer engineParam5Flag) {
        this.set(FIELD_ENGINEPARAM5FLAG, engineParam5Flag);
    }

    @JsonIgnore
    public boolean isEngineParam5FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM5FLAG);
    }

    @JsonIgnore
    public String getEngineParam5Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM5LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam5label")
    public void setEngineParam5Label(String engineParam5Label) {
        this.set(FIELD_ENGINEPARAM5LABEL, engineParam5Label);
    }

    @JsonIgnore
    public boolean isEngineParam5LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM5LABEL);
    }

    @JsonIgnore
    public Integer getEngineParam6() {
        Object objValue = this.get(FIELD_ENGINEPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam6")
    public void setEngineParam6(Integer engineParam6) {
        this.set(FIELD_ENGINEPARAM6, engineParam6);
    }

    @JsonIgnore
    public boolean isEngineParam6Dirty() {
        return this.contains(FIELD_ENGINEPARAM6);
    }

    @JsonIgnore
    public Integer getEngineParam6Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM6FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam6flag")
    public void setEngineParam6Flag(Integer engineParam6Flag) {
        this.set(FIELD_ENGINEPARAM6FLAG, engineParam6Flag);
    }

    @JsonIgnore
    public boolean isEngineParam6FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM6FLAG);
    }

    @JsonIgnore
    public String getEngineParam6Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM6LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam6label")
    public void setEngineParam6Label(String engineParam6Label) {
        this.set(FIELD_ENGINEPARAM6LABEL, engineParam6Label);
    }

    @JsonIgnore
    public boolean isEngineParam6LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM6LABEL);
    }

    @JsonIgnore
    public Integer getEngineParam7() {
        Object objValue = this.get(FIELD_ENGINEPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam7")
    public void setEngineParam7(Integer engineParam7) {
        this.set(FIELD_ENGINEPARAM7, engineParam7);
    }

    @JsonIgnore
    public boolean isEngineParam7Dirty() {
        return this.contains(FIELD_ENGINEPARAM7);
    }

    @JsonIgnore
    public Integer getEngineParam7Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM7FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam7flag")
    public void setEngineParam7Flag(Integer engineParam7Flag) {
        this.set(FIELD_ENGINEPARAM7FLAG, engineParam7Flag);
    }

    @JsonIgnore
    public boolean isEngineParam7FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM7FLAG);
    }

    @JsonIgnore
    public String getEngineParam7Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM7LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam7label")
    public void setEngineParam7Label(String engineParam7Label) {
        this.set(FIELD_ENGINEPARAM7LABEL, engineParam7Label);
    }

    @JsonIgnore
    public boolean isEngineParam7LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM7LABEL);
    }

    @JsonIgnore
    public Integer getEngineParam8() {
        Object objValue = this.get(FIELD_ENGINEPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam8")
    public void setEngineParam8(Integer engineParam8) {
        this.set(FIELD_ENGINEPARAM8, engineParam8);
    }

    @JsonIgnore
    public boolean isEngineParam8Dirty() {
        return this.contains(FIELD_ENGINEPARAM8);
    }

    @JsonIgnore
    public Integer getEngineParam8Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM8FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam8flag")
    public void setEngineParam8Flag(Integer engineParam8Flag) {
        this.set(FIELD_ENGINEPARAM8FLAG, engineParam8Flag);
    }

    @JsonIgnore
    public boolean isEngineParam8FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM8FLAG);
    }

    @JsonIgnore
    public String getEngineParam8Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM8LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam8label")
    public void setEngineParam8Label(String engineParam8Label) {
        this.set(FIELD_ENGINEPARAM8LABEL, engineParam8Label);
    }

    @JsonIgnore
    public boolean isEngineParam8LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM8LABEL);
    }

    @JsonIgnore
    public Integer getEngineParam9() {
        Object objValue = this.get(FIELD_ENGINEPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam9")
    public void setEngineParam9(Integer engineParam9) {
        this.set(FIELD_ENGINEPARAM9, engineParam9);
    }

    @JsonIgnore
    public boolean isEngineParam9Dirty() {
        return this.contains(FIELD_ENGINEPARAM9);
    }

    @JsonIgnore
    public Integer getEngineParam9Flag() {
        Object objValue = this.get(FIELD_ENGINEPARAM9FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparam9flag")
    public void setEngineParam9Flag(Integer engineParam9Flag) {
        this.set(FIELD_ENGINEPARAM9FLAG, engineParam9Flag);
    }

    @JsonIgnore
    public boolean isEngineParam9FlagDirty() {
        return this.contains(FIELD_ENGINEPARAM9FLAG);
    }

    @JsonIgnore
    public String getEngineParam9Label() {
        Object objValue = this.get(FIELD_ENGINEPARAM9LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparam9label")
    public void setEngineParam9Label(String engineParam9Label) {
        this.set(FIELD_ENGINEPARAM9LABEL, engineParam9Label);
    }

    @JsonIgnore
    public boolean isEngineParam9LabelDirty() {
        return this.contains(FIELD_ENGINEPARAM9LABEL);
    }

    @JsonIgnore
    public Integer getEngineParamFlag() {
        Object objValue = this.get(FIELD_ENGINEPARAMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="engineparamflag")
    public void setEngineParamFlag(Integer engineParamFlag) {
        this.set(FIELD_ENGINEPARAMFLAG, engineParamFlag);
    }

    @JsonIgnore
    public boolean isEngineParamFlagDirty() {
        return this.contains(FIELD_ENGINEPARAMFLAG);
    }

    @JsonIgnore
    public String getEngineParamLabel() {
        Object objValue = this.get(FIELD_ENGINEPARAMLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="engineparamlabel")
    public void setEngineParamLabel(String engineParamLabel) {
        this.set(FIELD_ENGINEPARAMLABEL, engineParamLabel);
    }

    @JsonIgnore
    public boolean isEngineParamLabelDirty() {
        return this.contains(FIELD_ENGINEPARAMLABEL);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getNo2PanelItemFlag() {
        Object objValue = this.get(FIELD_NO2PANELITEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no2panelitemflag")
    public void setNo2PanelItemFlag(Integer no2PanelItemFlag) {
        this.set(FIELD_NO2PANELITEMFLAG, no2PanelItemFlag);
    }

    @JsonIgnore
    public boolean isNo2PanelItemFlagDirty() {
        return this.contains(FIELD_NO2PANELITEMFLAG);
    }

    @JsonIgnore
    public String getNo2PanelItemLabel() {
        Object objValue = this.get(FIELD_NO2PANELITEMLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2panelitemlabel")
    public void setNo2PanelItemLabel(String no2PanelItemLabel) {
        this.set(FIELD_NO2PANELITEMLABEL, no2PanelItemLabel);
    }

    @JsonIgnore
    public boolean isNo2PanelItemLabelDirty() {
        return this.contains(FIELD_NO2PANELITEMLABEL);
    }

    @JsonIgnore
    public Integer getNo2PanelLogicFlag() {
        Object objValue = this.get(FIELD_NO2PANELLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no2panellogicflag")
    public void setNo2PanelLogicFlag(Integer no2PanelLogicFlag) {
        this.set(FIELD_NO2PANELLOGICFLAG, no2PanelLogicFlag);
    }

    @JsonIgnore
    public boolean isNo2PanelLogicFlagDirty() {
        return this.contains(FIELD_NO2PANELLOGICFLAG);
    }

    @JsonIgnore
    public String getNo2PanelLogicLabel() {
        Object objValue = this.get(FIELD_NO2PANELLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2panellogiclabel")
    public void setNo2PanelLogicLabel(String no2PanelLogicLabel) {
        this.set(FIELD_NO2PANELLOGICLABEL, no2PanelLogicLabel);
    }

    @JsonIgnore
    public boolean isNo2PanelLogicLabelDirty() {
        return this.contains(FIELD_NO2PANELLOGICLABEL);
    }

    @JsonIgnore
    public String getNo2PSPanelItemId() {
        Object objValue = this.get(FIELD_NO2PSPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2pspanelitemid")
    public void setNo2PSPanelItemId(String no2PSPanelItemId) {
        this.set(FIELD_NO2PSPANELITEMID, no2PSPanelItemId);
    }

    @JsonIgnore
    public boolean isNo2PSPanelItemIdDirty() {
        return this.contains(FIELD_NO2PSPANELITEMID);
    }

    @JsonIgnore
    public String getNo2PSPanelItemName() {
        Object objValue = this.get(FIELD_NO2PSPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2pspanelitemname")
    public void setNo2PSPanelItemName(String no2PSPanelItemName) {
        this.set(FIELD_NO2PSPANELITEMNAME, no2PSPanelItemName);
    }

    @JsonIgnore
    public boolean isNo2PSPanelItemNameDirty() {
        return this.contains(FIELD_NO2PSPANELITEMNAME);
    }

    @JsonIgnore
    public String getNo2PSPanelLogicId() {
        Object objValue = this.get(FIELD_NO2PSPANELLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2pspanellogicid")
    public void setNo2PSPanelLogicId(String no2PSPanelLogicId) {
        this.set(FIELD_NO2PSPANELLOGICID, no2PSPanelLogicId);
    }

    @JsonIgnore
    public boolean isNo2PSPanelLogicIdDirty() {
        return this.contains(FIELD_NO2PSPANELLOGICID);
    }

    @JsonIgnore
    public String getNo2PSPanelLogicName() {
        Object objValue = this.get(FIELD_NO2PSPANELLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2pspanellogicname")
    public void setNo2PSPanelLogicName(String no2PSPanelLogicName) {
        this.set(FIELD_NO2PSPANELLOGICNAME, no2PSPanelLogicName);
    }

    @JsonIgnore
    public boolean isNo2PSPanelLogicNameDirty() {
        return this.contains(FIELD_NO2PSPANELLOGICNAME);
    }

    @JsonIgnore
    public Integer getNo3PanelItemFlag() {
        Object objValue = this.get(FIELD_NO3PANELITEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no3panelitemflag")
    public void setNo3PanelItemFlag(Integer no3PanelItemFlag) {
        this.set(FIELD_NO3PANELITEMFLAG, no3PanelItemFlag);
    }

    @JsonIgnore
    public boolean isNo3PanelItemFlagDirty() {
        return this.contains(FIELD_NO3PANELITEMFLAG);
    }

    @JsonIgnore
    public String getNo3PanelItemLabel() {
        Object objValue = this.get(FIELD_NO3PANELITEMLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3panelitemlabel")
    public void setNo3PanelItemLabel(String no3PanelItemLabel) {
        this.set(FIELD_NO3PANELITEMLABEL, no3PanelItemLabel);
    }

    @JsonIgnore
    public boolean isNo3PanelItemLabelDirty() {
        return this.contains(FIELD_NO3PANELITEMLABEL);
    }

    @JsonIgnore
    public Integer getNo3PanelLogicFlag() {
        Object objValue = this.get(FIELD_NO3PANELLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no3panellogicflag")
    public void setNo3PanelLogicFlag(Integer no3PanelLogicFlag) {
        this.set(FIELD_NO3PANELLOGICFLAG, no3PanelLogicFlag);
    }

    @JsonIgnore
    public boolean isNo3PanelLogicFlagDirty() {
        return this.contains(FIELD_NO3PANELLOGICFLAG);
    }

    @JsonIgnore
    public String getNo3PanelLogicLabel() {
        Object objValue = this.get(FIELD_NO3PANELLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3panellogiclabel")
    public void setNo3PanelLogicLabel(String no3PanelLogicLabel) {
        this.set(FIELD_NO3PANELLOGICLABEL, no3PanelLogicLabel);
    }

    @JsonIgnore
    public boolean isNo3PanelLogicLabelDirty() {
        return this.contains(FIELD_NO3PANELLOGICLABEL);
    }

    @JsonIgnore
    public String getNo3PSPanelItemId() {
        Object objValue = this.get(FIELD_NO3PSPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3pspanelitemid")
    public void setNo3PSPanelItemId(String no3PSPanelItemId) {
        this.set(FIELD_NO3PSPANELITEMID, no3PSPanelItemId);
    }

    @JsonIgnore
    public boolean isNo3PSPanelItemIdDirty() {
        return this.contains(FIELD_NO3PSPANELITEMID);
    }

    @JsonIgnore
    public String getNo3PSPanelItemName() {
        Object objValue = this.get(FIELD_NO3PSPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3pspanelitemname")
    public void setNo3PSPanelItemName(String no3PSPanelItemName) {
        this.set(FIELD_NO3PSPANELITEMNAME, no3PSPanelItemName);
    }

    @JsonIgnore
    public boolean isNo3PSPanelItemNameDirty() {
        return this.contains(FIELD_NO3PSPANELITEMNAME);
    }

    @JsonIgnore
    public String getNo3PSPanelLogicId() {
        Object objValue = this.get(FIELD_NO3PSPANELLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3pspanellogicid")
    public void setNo3PSPanelLogicId(String no3PSPanelLogicId) {
        this.set(FIELD_NO3PSPANELLOGICID, no3PSPanelLogicId);
    }

    @JsonIgnore
    public boolean isNo3PSPanelLogicIdDirty() {
        return this.contains(FIELD_NO3PSPANELLOGICID);
    }

    @JsonIgnore
    public String getNo3PSPanelLogicName() {
        Object objValue = this.get(FIELD_NO3PSPANELLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3pspanellogicname")
    public void setNo3PSPanelLogicName(String no3PSPanelLogicName) {
        this.set(FIELD_NO3PSPANELLOGICNAME, no3PSPanelLogicName);
    }

    @JsonIgnore
    public boolean isNo3PSPanelLogicNameDirty() {
        return this.contains(FIELD_NO3PSPANELLOGICNAME);
    }

    @JsonIgnore
    public Integer getNo4PanelItemFlag() {
        Object objValue = this.get(FIELD_NO4PANELITEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no4panelitemflag")
    public void setNo4PanelItemFlag(Integer no4PanelItemFlag) {
        this.set(FIELD_NO4PANELITEMFLAG, no4PanelItemFlag);
    }

    @JsonIgnore
    public boolean isNo4PanelItemFlagDirty() {
        return this.contains(FIELD_NO4PANELITEMFLAG);
    }

    @JsonIgnore
    public String getNo4PanelItemLabel() {
        Object objValue = this.get(FIELD_NO4PANELITEMLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4panelitemlabel")
    public void setNo4PanelItemLabel(String no4PanelItemLabel) {
        this.set(FIELD_NO4PANELITEMLABEL, no4PanelItemLabel);
    }

    @JsonIgnore
    public boolean isNo4PanelItemLabelDirty() {
        return this.contains(FIELD_NO4PANELITEMLABEL);
    }

    @JsonIgnore
    public Integer getNo4PanelLogicFlag() {
        Object objValue = this.get(FIELD_NO4PANELLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no4panellogicflag")
    public void setNo4PanelLogicFlag(Integer no4PanelLogicFlag) {
        this.set(FIELD_NO4PANELLOGICFLAG, no4PanelLogicFlag);
    }

    @JsonIgnore
    public boolean isNo4PanelLogicFlagDirty() {
        return this.contains(FIELD_NO4PANELLOGICFLAG);
    }

    @JsonIgnore
    public String getNo4PanelLogicLabel() {
        Object objValue = this.get(FIELD_NO4PANELLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4panellogiclabel")
    public void setNo4PanelLogicLabel(String no4PanelLogicLabel) {
        this.set(FIELD_NO4PANELLOGICLABEL, no4PanelLogicLabel);
    }

    @JsonIgnore
    public boolean isNo4PanelLogicLabelDirty() {
        return this.contains(FIELD_NO4PANELLOGICLABEL);
    }

    @JsonIgnore
    public String getNo4PSPanelItemId() {
        Object objValue = this.get(FIELD_NO4PSPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4pspanelitemid")
    public void setNo4PSPanelItemId(String no4PSPanelItemId) {
        this.set(FIELD_NO4PSPANELITEMID, no4PSPanelItemId);
    }

    @JsonIgnore
    public boolean isNo4PSPanelItemIdDirty() {
        return this.contains(FIELD_NO4PSPANELITEMID);
    }

    @JsonIgnore
    public String getNo4PSPanelItemName() {
        Object objValue = this.get(FIELD_NO4PSPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4pspanelitemname")
    public void setNo4PSPanelItemName(String no4PSPanelItemName) {
        this.set(FIELD_NO4PSPANELITEMNAME, no4PSPanelItemName);
    }

    @JsonIgnore
    public boolean isNo4PSPanelItemNameDirty() {
        return this.contains(FIELD_NO4PSPANELITEMNAME);
    }

    @JsonIgnore
    public String getNo4PSPanelLogicId() {
        Object objValue = this.get(FIELD_NO4PSPANELLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4pspanellogicid")
    public void setNo4PSPanelLogicId(String no4PSPanelLogicId) {
        this.set(FIELD_NO4PSPANELLOGICID, no4PSPanelLogicId);
    }

    @JsonIgnore
    public boolean isNo4PSPanelLogicIdDirty() {
        return this.contains(FIELD_NO4PSPANELLOGICID);
    }

    @JsonIgnore
    public String getNo4PSPanelLogicName() {
        Object objValue = this.get(FIELD_NO4PSPANELLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4pspanellogicname")
    public void setNo4PSPanelLogicName(String no4PSPanelLogicName) {
        this.set(FIELD_NO4PSPANELLOGICNAME, no4PSPanelLogicName);
    }

    @JsonIgnore
    public boolean isNo4PSPanelLogicNameDirty() {
        return this.contains(FIELD_NO4PSPANELLOGICNAME);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public Integer getPanelItemFlag() {
        Object objValue = this.get(FIELD_PANELITEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panelitemflag")
    public void setPanelItemFlag(Integer panelItemFlag) {
        this.set(FIELD_PANELITEMFLAG, panelItemFlag);
    }

    @JsonIgnore
    public boolean isPanelItemFlagDirty() {
        return this.contains(FIELD_PANELITEMFLAG);
    }

    @JsonIgnore
    public String getPanelItemLabel() {
        Object objValue = this.get(FIELD_PANELITEMLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="panelitemlabel")
    public void setPanelItemLabel(String panelItemLabel) {
        this.set(FIELD_PANELITEMLABEL, panelItemLabel);
    }

    @JsonIgnore
    public boolean isPanelItemLabelDirty() {
        return this.contains(FIELD_PANELITEMLABEL);
    }

    @JsonIgnore
    public Integer getPanelLogicFlag() {
        Object objValue = this.get(FIELD_PANELLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panellogicflag")
    public void setPanelLogicFlag(Integer panelLogicFlag) {
        this.set(FIELD_PANELLOGICFLAG, panelLogicFlag);
    }

    @JsonIgnore
    public boolean isPanelLogicFlagDirty() {
        return this.contains(FIELD_PANELLOGICFLAG);
    }

    @JsonIgnore
    public String getPanelLogicLabel() {
        Object objValue = this.get(FIELD_PANELLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="panellogiclabel")
    public void setPanelLogicLabel(String panelLogicLabel) {
        this.set(FIELD_PANELLOGICLABEL, panelLogicLabel);
    }

    @JsonIgnore
    public boolean isPanelLogicLabelDirty() {
        return this.contains(FIELD_PANELLOGICLABEL);
    }

    @JsonIgnore
    public String getPSPanelEngineId() {
        Object objValue = this.get(FIELD_PSPANELENGINEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelengineid")
    public void setPSPanelEngineId(String pSPanelEngineId) {
        this.set(FIELD_PSPANELENGINEID, pSPanelEngineId);
    }

    @JsonIgnore
    public boolean isPSPanelEngineIdDirty() {
        return this.contains(FIELD_PSPANELENGINEID);
    }

    @JsonIgnore
    public String getPSPanelEngineName() {
        Object objValue = this.get(FIELD_PSPANELENGINENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelenginename")
    public void setPSPanelEngineName(String pSPanelEngineName) {
        this.set(FIELD_PSPANELENGINENAME, pSPanelEngineName);
    }

    @JsonIgnore
    public boolean isPSPanelEngineNameDirty() {
        return this.contains(FIELD_PSPANELENGINENAME);
    }

    @JsonIgnore
    public String getPSPanelItemId() {
        Object objValue = this.get(FIELD_PSPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelitemid")
    public void setPSPanelItemId(String pSPanelItemId) {
        this.set(FIELD_PSPANELITEMID, pSPanelItemId);
    }

    @JsonIgnore
    public boolean isPSPanelItemIdDirty() {
        return this.contains(FIELD_PSPANELITEMID);
    }

    @JsonIgnore
    public String getPSPanelItemName() {
        Object objValue = this.get(FIELD_PSPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanelitemname")
    public void setPSPanelItemName(String pSPanelItemName) {
        this.set(FIELD_PSPANELITEMNAME, pSPanelItemName);
    }

    @JsonIgnore
    public boolean isPSPanelItemNameDirty() {
        return this.contains(FIELD_PSPANELITEMNAME);
    }

    @JsonIgnore
    public String getPSPanelLogicId() {
        Object objValue = this.get(FIELD_PSPANELLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanellogicid")
    public void setPSPanelLogicId(String pSPanelLogicId) {
        this.set(FIELD_PSPANELLOGICID, pSPanelLogicId);
    }

    @JsonIgnore
    public boolean isPSPanelLogicIdDirty() {
        return this.contains(FIELD_PSPANELLOGICID);
    }

    @JsonIgnore
    public String getPSPanelLogicName() {
        Object objValue = this.get(FIELD_PSPANELLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspanellogicname")
    public void setPSPanelLogicName(String pSPanelLogicName) {
        this.set(FIELD_PSPANELLOGICNAME, pSPanelLogicName);
    }

    @JsonIgnore
    public boolean isPSPanelLogicNameDirty() {
        return this.contains(FIELD_PSPANELLOGICNAME);
    }

    @JsonIgnore
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelid")
    public void setPSSysViewPanelId(String pSSysViewPanelId) {
        this.set(FIELD_PSSYSVIEWPANELID, pSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelname")
    public void setPSSysViewPanelName(String pSSysViewPanelName) {
        this.set(FIELD_PSSYSVIEWPANELNAME, pSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELNAME);
    }

    @JsonIgnore
    public String getPSUIEngineTypeId() {
        Object objValue = this.get(FIELD_PSUIENGINETYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psuienginetypeid")
    public void setPSUIEngineTypeId(String pSUIEngineTypeId) {
        this.set(FIELD_PSUIENGINETYPEID, pSUIEngineTypeId);
    }

    @JsonIgnore
    public boolean isPSUIEngineTypeIdDirty() {
        return this.contains(FIELD_PSUIENGINETYPEID);
    }

    @JsonIgnore
    public String getPSUIEngineTypeName() {
        Object objValue = this.get(FIELD_PSUIENGINETYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psuienginetypename")
    public void setPSUIEngineTypeName(String pSUIEngineTypeName) {
        this.set(FIELD_PSUIENGINETYPENAME, pSUIEngineTypeName);
    }

    @JsonIgnore
    public boolean isPSUIEngineTypeNameDirty() {
        return this.contains(FIELD_PSUIENGINETYPENAME);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
    }

    @JsonIgnore
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @JsonIgnore
    public Integer getValidFlag() {
        Object objValue = this.get(FIELD_VALIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="validflag")
    public void setValidFlag(Integer validFlag) {
        this.set(FIELD_VALIDFLAG, validFlag);
    }

    @JsonIgnore
    public boolean isValidFlagDirty() {
        return this.contains(FIELD_VALIDFLAG);
    }

    @JsonIgnore
    public String getViewParam() {
        Object objValue = this.get(FIELD_VIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam")
    public void setViewParam(String viewParam) {
        this.set(FIELD_VIEWPARAM, viewParam);
    }

    @JsonIgnore
    public boolean isViewParamDirty() {
        return this.contains(FIELD_VIEWPARAM);
    }

    @JsonIgnore
    public Integer getViewParam10() {
        Object objValue = this.get(FIELD_VIEWPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam10")
    public void setViewParam10(Integer viewParam10) {
        this.set(FIELD_VIEWPARAM10, viewParam10);
    }

    @JsonIgnore
    public boolean isViewParam10Dirty() {
        return this.contains(FIELD_VIEWPARAM10);
    }

    @JsonIgnore
    public String getViewParam2() {
        Object objValue = this.get(FIELD_VIEWPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam2")
    public void setViewParam2(String viewParam2) {
        this.set(FIELD_VIEWPARAM2, viewParam2);
    }

    @JsonIgnore
    public boolean isViewParam2Dirty() {
        return this.contains(FIELD_VIEWPARAM2);
    }

    @JsonIgnore
    public Integer getViewParam3() {
        Object objValue = this.get(FIELD_VIEWPARAM3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam3")
    public void setViewParam3(Integer viewParam3) {
        this.set(FIELD_VIEWPARAM3, viewParam3);
    }

    @JsonIgnore
    public boolean isViewParam3Dirty() {
        return this.contains(FIELD_VIEWPARAM3);
    }

    @JsonIgnore
    public Integer getViewParam4() {
        Object objValue = this.get(FIELD_VIEWPARAM4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam4")
    public void setViewParam4(Integer viewParam4) {
        this.set(FIELD_VIEWPARAM4, viewParam4);
    }

    @JsonIgnore
    public boolean isViewParam4Dirty() {
        return this.contains(FIELD_VIEWPARAM4);
    }

    @JsonIgnore
    public Integer getViewParam5() {
        Object objValue = this.get(FIELD_VIEWPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam5")
    public void setViewParam5(Integer viewParam5) {
        this.set(FIELD_VIEWPARAM5, viewParam5);
    }

    @JsonIgnore
    public boolean isViewParam5Dirty() {
        return this.contains(FIELD_VIEWPARAM5);
    }

    @JsonIgnore
    public Integer getViewParam6() {
        Object objValue = this.get(FIELD_VIEWPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam6")
    public void setViewParam6(Integer viewParam6) {
        this.set(FIELD_VIEWPARAM6, viewParam6);
    }

    @JsonIgnore
    public boolean isViewParam6Dirty() {
        return this.contains(FIELD_VIEWPARAM6);
    }

    @JsonIgnore
    public String getViewParam7() {
        Object objValue = this.get(FIELD_VIEWPARAM7);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam7")
    public void setViewParam7(String viewParam7) {
        this.set(FIELD_VIEWPARAM7, viewParam7);
    }

    @JsonIgnore
    public boolean isViewParam7Dirty() {
        return this.contains(FIELD_VIEWPARAM7);
    }

    @JsonIgnore
    public String getViewParam8() {
        Object objValue = this.get(FIELD_VIEWPARAM8);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam8")
    public void setViewParam8(String viewParam8) {
        this.set(FIELD_VIEWPARAM8, viewParam8);
    }

    @JsonIgnore
    public boolean isViewParam8Dirty() {
        return this.contains(FIELD_VIEWPARAM8);
    }

    @JsonIgnore
    public Integer getViewParam9() {
        Object objValue = this.get(FIELD_VIEWPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam9")
    public void setViewParam9(Integer viewParam9) {
        this.set(FIELD_VIEWPARAM9, viewParam9);
    }

    @JsonIgnore
    public boolean isViewParam9Dirty() {
        return this.contains(FIELD_VIEWPARAM9);
    }

    @JsonIgnore
    public Integer getWFViewParam() {
        Object objValue = this.get(FIELD_WFVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfviewparam")
    public void setWFViewParam(Integer wFViewParam) {
        this.set(FIELD_WFVIEWPARAM, wFViewParam);
    }

    @JsonIgnore
    public boolean isWFViewParamDirty() {
        return this.contains(FIELD_WFVIEWPARAM);
    }

    @JsonIgnore
    public Integer getWFViewParam2() {
        Object objValue = this.get(FIELD_WFVIEWPARAM2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfviewparam2")
    public void setWFViewParam2(Integer wFViewParam2) {
        this.set(FIELD_WFVIEWPARAM2, wFViewParam2);
    }

    @JsonIgnore
    public boolean isWFViewParam2Dirty() {
        return this.contains(FIELD_WFVIEWPARAM2);
    }

    @JsonIgnore
    public String getWFViewParam3() {
        Object objValue = this.get(FIELD_WFVIEWPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfviewparam3")
    public void setWFViewParam3(String wFViewParam3) {
        this.set(FIELD_WFVIEWPARAM3, wFViewParam3);
    }

    @JsonIgnore
    public boolean isWFViewParam3Dirty() {
        return this.contains(FIELD_WFVIEWPARAM3);
    }

    @JsonIgnore
    public String getWFViewParam4() {
        Object objValue = this.get(FIELD_WFVIEWPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfviewparam4")
    public void setWFViewParam4(String wFViewParam4) {
        this.set(FIELD_WFVIEWPARAM4, wFViewParam4);
    }

    @JsonIgnore
    public boolean isWFViewParam4Dirty() {
        return this.contains(FIELD_WFVIEWPARAM4);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSPanelEngineId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSPanelEngineId(strValue);
    }
}

