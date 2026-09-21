/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEViewEngine
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEVIEWCTRLFLAG = "deviewctrlflag";
    public static final String FIELD_DEVIEWCTRLLABEL = "deviewctrllabel";
    public static final String FIELD_DEVIEWLOGICFLAG = "deviewlogicflag";
    public static final String FIELD_DEVIEWLOGICLABEL = "deviewlogiclabel";
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
    public static final String FIELD_NO2DEVIEWCTRLFLAG = "no2deviewctrlflag";
    public static final String FIELD_NO2DEVIEWCTRLLABEL = "no2deviewctrllabel";
    public static final String FIELD_NO2DEVIEWLOGICFLAG = "no2deviewlogicflag";
    public static final String FIELD_NO2DEVIEWLOGICLABEL = "no2deviewlogiclabel";
    public static final String FIELD_NO2PSDEVIEWCTRLID = "no2psdeviewctrlid";
    public static final String FIELD_NO2PSDEVIEWCTRLNAME = "no2psdeviewctrlname";
    public static final String FIELD_NO2PSDEVIEWLOGICID = "no2psdeviewlogicid";
    public static final String FIELD_NO2PSDEVIEWLOGICNAME = "no2psdeviewlogicname";
    public static final String FIELD_NO3DEVIEWCTRLFLAG = "no3deviewctrlflag";
    public static final String FIELD_NO3DEVIEWCTRLLABEL = "no3deviewctrllabel";
    public static final String FIELD_NO3DEVIEWLOGICFLAG = "no3deviewlogicflag";
    public static final String FIELD_NO3DEVIEWLOGICLABEL = "no3deviewlogiclabel";
    public static final String FIELD_NO3PSDEVIEWCTRLID = "no3psdeviewctrlid";
    public static final String FIELD_NO3PSDEVIEWCTRLNAME = "no3psdeviewctrlname";
    public static final String FIELD_NO3PSDEVIEWLOGICID = "no3psdeviewlogicid";
    public static final String FIELD_NO3PSDEVIEWLOGICNAME = "no3psdeviewlogicname";
    public static final String FIELD_NO4DEVIEWCTRLFLAG = "no4deviewctrlflag";
    public static final String FIELD_NO4DEVIEWCTRLLABEL = "no4deviewctrllabel";
    public static final String FIELD_NO4DEVIEWLOGICFLAG = "no4deviewlogicflag";
    public static final String FIELD_NO4DEVIEWLOGICLABEL = "no4deviewlogiclabel";
    public static final String FIELD_NO4PSDEVIEWCTRLID = "no4psdeviewctrlid";
    public static final String FIELD_NO4PSDEVIEWCTRLNAME = "no4psdeviewctrlname";
    public static final String FIELD_NO4PSDEVIEWLOGICID = "no4psdeviewlogicid";
    public static final String FIELD_NO4PSDEVIEWLOGICNAME = "no4psdeviewlogicname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEVIEWCTRLID = "psdeviewctrlid";
    public static final String FIELD_PSDEVIEWCTRLNAME = "psdeviewctrlname";
    public static final String FIELD_PSDEVIEWENGINEID = "psdeviewengineid";
    public static final String FIELD_PSDEVIEWENGINENAME = "psdeviewenginename";
    public static final String FIELD_PSDEVIEWLOGICID = "psdeviewlogicid";
    public static final String FIELD_PSDEVIEWLOGICNAME = "psdeviewlogicname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
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
    public Integer getDEViewCtrlFlag() {
        Object objValue = this.get(FIELD_DEVIEWCTRLFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deviewctrlflag")
    public void setDEViewCtrlFlag(Integer dEViewCtrlFlag) {
        this.set(FIELD_DEVIEWCTRLFLAG, dEViewCtrlFlag);
    }

    @JsonIgnore
    public boolean isDEViewCtrlFlagDirty() {
        return this.contains(FIELD_DEVIEWCTRLFLAG);
    }

    @JsonIgnore
    public String getDEViewCtrlLabel() {
        Object objValue = this.get(FIELD_DEVIEWCTRLLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewctrllabel")
    public void setDEViewCtrlLabel(String dEViewCtrlLabel) {
        this.set(FIELD_DEVIEWCTRLLABEL, dEViewCtrlLabel);
    }

    @JsonIgnore
    public boolean isDEViewCtrlLabelDirty() {
        return this.contains(FIELD_DEVIEWCTRLLABEL);
    }

    @JsonIgnore
    public Integer getDEViewLogicFlag() {
        Object objValue = this.get(FIELD_DEVIEWLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deviewlogicflag")
    public void setDEViewLogicFlag(Integer dEViewLogicFlag) {
        this.set(FIELD_DEVIEWLOGICFLAG, dEViewLogicFlag);
    }

    @JsonIgnore
    public boolean isDEViewLogicFlagDirty() {
        return this.contains(FIELD_DEVIEWLOGICFLAG);
    }

    @JsonIgnore
    public String getDEViewLogicLabel() {
        Object objValue = this.get(FIELD_DEVIEWLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewlogiclabel")
    public void setDEViewLogicLabel(String dEViewLogicLabel) {
        this.set(FIELD_DEVIEWLOGICLABEL, dEViewLogicLabel);
    }

    @JsonIgnore
    public boolean isDEViewLogicLabelDirty() {
        return this.contains(FIELD_DEVIEWLOGICLABEL);
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
    public Integer getNo2DEViewCtrlFlag() {
        Object objValue = this.get(FIELD_NO2DEVIEWCTRLFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no2deviewctrlflag")
    public void setNo2DEViewCtrlFlag(Integer no2DEViewCtrlFlag) {
        this.set(FIELD_NO2DEVIEWCTRLFLAG, no2DEViewCtrlFlag);
    }

    @JsonIgnore
    public boolean isNo2DEViewCtrlFlagDirty() {
        return this.contains(FIELD_NO2DEVIEWCTRLFLAG);
    }

    @JsonIgnore
    public String getNo2DEViewCtrlLabel() {
        Object objValue = this.get(FIELD_NO2DEVIEWCTRLLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2deviewctrllabel")
    public void setNo2DEViewCtrlLabel(String no2DEViewCtrlLabel) {
        this.set(FIELD_NO2DEVIEWCTRLLABEL, no2DEViewCtrlLabel);
    }

    @JsonIgnore
    public boolean isNo2DEViewCtrlLabelDirty() {
        return this.contains(FIELD_NO2DEVIEWCTRLLABEL);
    }

    @JsonIgnore
    public Integer getNo2DEViewLogicFlag() {
        Object objValue = this.get(FIELD_NO2DEVIEWLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no2deviewlogicflag")
    public void setNo2DEViewLogicFlag(Integer no2DEViewLogicFlag) {
        this.set(FIELD_NO2DEVIEWLOGICFLAG, no2DEViewLogicFlag);
    }

    @JsonIgnore
    public boolean isNo2DEViewLogicFlagDirty() {
        return this.contains(FIELD_NO2DEVIEWLOGICFLAG);
    }

    @JsonIgnore
    public String getNo2DEViewLogicLabel() {
        Object objValue = this.get(FIELD_NO2DEVIEWLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2deviewlogiclabel")
    public void setNo2DEViewLogicLabel(String no2DEViewLogicLabel) {
        this.set(FIELD_NO2DEVIEWLOGICLABEL, no2DEViewLogicLabel);
    }

    @JsonIgnore
    public boolean isNo2DEViewLogicLabelDirty() {
        return this.contains(FIELD_NO2DEVIEWLOGICLABEL);
    }

    @JsonIgnore
    public String getNo2PSDEViewCtrlId() {
        Object objValue = this.get(FIELD_NO2PSDEVIEWCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeviewctrlid")
    public void setNo2PSDEViewCtrlId(String no2PSDEViewCtrlId) {
        this.set(FIELD_NO2PSDEVIEWCTRLID, no2PSDEViewCtrlId);
    }

    @JsonIgnore
    public boolean isNo2PSDEViewCtrlIdDirty() {
        return this.contains(FIELD_NO2PSDEVIEWCTRLID);
    }

    @JsonIgnore
    public String getNo2PSDEViewCtrlName() {
        Object objValue = this.get(FIELD_NO2PSDEVIEWCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeviewctrlname")
    public void setNo2PSDEViewCtrlName(String no2PSDEViewCtrlName) {
        this.set(FIELD_NO2PSDEVIEWCTRLNAME, no2PSDEViewCtrlName);
    }

    @JsonIgnore
    public boolean isNo2PSDEViewCtrlNameDirty() {
        return this.contains(FIELD_NO2PSDEVIEWCTRLNAME);
    }

    @JsonIgnore
    public String getNo2PSDEViewLogicId() {
        Object objValue = this.get(FIELD_NO2PSDEVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeviewlogicid")
    public void setNo2PSDEViewLogicId(String no2PSDEViewLogicId) {
        this.set(FIELD_NO2PSDEVIEWLOGICID, no2PSDEViewLogicId);
    }

    @JsonIgnore
    public boolean isNo2PSDEViewLogicIdDirty() {
        return this.contains(FIELD_NO2PSDEVIEWLOGICID);
    }

    @JsonIgnore
    public String getNo2PSDEViewLogicName() {
        Object objValue = this.get(FIELD_NO2PSDEVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeviewlogicname")
    public void setNo2PSDEViewLogicName(String no2PSDEViewLogicName) {
        this.set(FIELD_NO2PSDEVIEWLOGICNAME, no2PSDEViewLogicName);
    }

    @JsonIgnore
    public boolean isNo2PSDEViewLogicNameDirty() {
        return this.contains(FIELD_NO2PSDEVIEWLOGICNAME);
    }

    @JsonIgnore
    public Integer getNo3DEViewCtrlFlag() {
        Object objValue = this.get(FIELD_NO3DEVIEWCTRLFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no3deviewctrlflag")
    public void setNo3DEViewCtrlFlag(Integer no3DEViewCtrlFlag) {
        this.set(FIELD_NO3DEVIEWCTRLFLAG, no3DEViewCtrlFlag);
    }

    @JsonIgnore
    public boolean isNo3DEViewCtrlFlagDirty() {
        return this.contains(FIELD_NO3DEVIEWCTRLFLAG);
    }

    @JsonIgnore
    public String getNo3DEViewCtrlLabel() {
        Object objValue = this.get(FIELD_NO3DEVIEWCTRLLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3deviewctrllabel")
    public void setNo3DEViewCtrlLabel(String no3DEViewCtrlLabel) {
        this.set(FIELD_NO3DEVIEWCTRLLABEL, no3DEViewCtrlLabel);
    }

    @JsonIgnore
    public boolean isNo3DEViewCtrlLabelDirty() {
        return this.contains(FIELD_NO3DEVIEWCTRLLABEL);
    }

    @JsonIgnore
    public Integer getNo3DEViewLogicFlag() {
        Object objValue = this.get(FIELD_NO3DEVIEWLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no3deviewlogicflag")
    public void setNo3DEViewLogicFlag(Integer no3DEViewLogicFlag) {
        this.set(FIELD_NO3DEVIEWLOGICFLAG, no3DEViewLogicFlag);
    }

    @JsonIgnore
    public boolean isNo3DEViewLogicFlagDirty() {
        return this.contains(FIELD_NO3DEVIEWLOGICFLAG);
    }

    @JsonIgnore
    public String getNo3DEViewLogicLabel() {
        Object objValue = this.get(FIELD_NO3DEVIEWLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3deviewlogiclabel")
    public void setNo3DEViewLogicLabel(String no3DEViewLogicLabel) {
        this.set(FIELD_NO3DEVIEWLOGICLABEL, no3DEViewLogicLabel);
    }

    @JsonIgnore
    public boolean isNo3DEViewLogicLabelDirty() {
        return this.contains(FIELD_NO3DEVIEWLOGICLABEL);
    }

    @JsonIgnore
    public String getNo3PSDEViewCtrlId() {
        Object objValue = this.get(FIELD_NO3PSDEVIEWCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeviewctrlid")
    public void setNo3PSDEViewCtrlId(String no3PSDEViewCtrlId) {
        this.set(FIELD_NO3PSDEVIEWCTRLID, no3PSDEViewCtrlId);
    }

    @JsonIgnore
    public boolean isNo3PSDEViewCtrlIdDirty() {
        return this.contains(FIELD_NO3PSDEVIEWCTRLID);
    }

    @JsonIgnore
    public String getNo3PSDEViewCtrlName() {
        Object objValue = this.get(FIELD_NO3PSDEVIEWCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeviewctrlname")
    public void setNo3PSDEViewCtrlName(String no3PSDEViewCtrlName) {
        this.set(FIELD_NO3PSDEVIEWCTRLNAME, no3PSDEViewCtrlName);
    }

    @JsonIgnore
    public boolean isNo3PSDEViewCtrlNameDirty() {
        return this.contains(FIELD_NO3PSDEVIEWCTRLNAME);
    }

    @JsonIgnore
    public String getNo3PSDEViewLogicId() {
        Object objValue = this.get(FIELD_NO3PSDEVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeviewlogicid")
    public void setNo3PSDEViewLogicId(String no3PSDEViewLogicId) {
        this.set(FIELD_NO3PSDEVIEWLOGICID, no3PSDEViewLogicId);
    }

    @JsonIgnore
    public boolean isNo3PSDEViewLogicIdDirty() {
        return this.contains(FIELD_NO3PSDEVIEWLOGICID);
    }

    @JsonIgnore
    public String getNo3PSDEViewLogicName() {
        Object objValue = this.get(FIELD_NO3PSDEVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeviewlogicname")
    public void setNo3PSDEViewLogicName(String no3PSDEViewLogicName) {
        this.set(FIELD_NO3PSDEVIEWLOGICNAME, no3PSDEViewLogicName);
    }

    @JsonIgnore
    public boolean isNo3PSDEViewLogicNameDirty() {
        return this.contains(FIELD_NO3PSDEVIEWLOGICNAME);
    }

    @JsonIgnore
    public Integer getNo4DEViewCtrlFlag() {
        Object objValue = this.get(FIELD_NO4DEVIEWCTRLFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no4deviewctrlflag")
    public void setNo4DEViewCtrlFlag(Integer no4DEViewCtrlFlag) {
        this.set(FIELD_NO4DEVIEWCTRLFLAG, no4DEViewCtrlFlag);
    }

    @JsonIgnore
    public boolean isNo4DEViewCtrlFlagDirty() {
        return this.contains(FIELD_NO4DEVIEWCTRLFLAG);
    }

    @JsonIgnore
    public String getNo4DEViewCtrlLabel() {
        Object objValue = this.get(FIELD_NO4DEVIEWCTRLLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4deviewctrllabel")
    public void setNo4DEViewCtrlLabel(String no4DEViewCtrlLabel) {
        this.set(FIELD_NO4DEVIEWCTRLLABEL, no4DEViewCtrlLabel);
    }

    @JsonIgnore
    public boolean isNo4DEViewCtrlLabelDirty() {
        return this.contains(FIELD_NO4DEVIEWCTRLLABEL);
    }

    @JsonIgnore
    public Integer getNo4DEViewLogicFlag() {
        Object objValue = this.get(FIELD_NO4DEVIEWLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="no4deviewlogicflag")
    public void setNo4DEViewLogicFlag(Integer no4DEViewLogicFlag) {
        this.set(FIELD_NO4DEVIEWLOGICFLAG, no4DEViewLogicFlag);
    }

    @JsonIgnore
    public boolean isNo4DEViewLogicFlagDirty() {
        return this.contains(FIELD_NO4DEVIEWLOGICFLAG);
    }

    @JsonIgnore
    public String getNo4DEViewLogicLabel() {
        Object objValue = this.get(FIELD_NO4DEVIEWLOGICLABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4deviewlogiclabel")
    public void setNo4DEViewLogicLabel(String no4DEViewLogicLabel) {
        this.set(FIELD_NO4DEVIEWLOGICLABEL, no4DEViewLogicLabel);
    }

    @JsonIgnore
    public boolean isNo4DEViewLogicLabelDirty() {
        return this.contains(FIELD_NO4DEVIEWLOGICLABEL);
    }

    @JsonIgnore
    public String getNo4PSDEViewCtrlId() {
        Object objValue = this.get(FIELD_NO4PSDEVIEWCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeviewctrlid")
    public void setNo4PSDEViewCtrlId(String no4PSDEViewCtrlId) {
        this.set(FIELD_NO4PSDEVIEWCTRLID, no4PSDEViewCtrlId);
    }

    @JsonIgnore
    public boolean isNo4PSDEViewCtrlIdDirty() {
        return this.contains(FIELD_NO4PSDEVIEWCTRLID);
    }

    @JsonIgnore
    public String getNo4PSDEViewCtrlName() {
        Object objValue = this.get(FIELD_NO4PSDEVIEWCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeviewctrlname")
    public void setNo4PSDEViewCtrlName(String no4PSDEViewCtrlName) {
        this.set(FIELD_NO4PSDEVIEWCTRLNAME, no4PSDEViewCtrlName);
    }

    @JsonIgnore
    public boolean isNo4PSDEViewCtrlNameDirty() {
        return this.contains(FIELD_NO4PSDEVIEWCTRLNAME);
    }

    @JsonIgnore
    public String getNo4PSDEViewLogicId() {
        Object objValue = this.get(FIELD_NO4PSDEVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeviewlogicid")
    public void setNo4PSDEViewLogicId(String no4PSDEViewLogicId) {
        this.set(FIELD_NO4PSDEVIEWLOGICID, no4PSDEViewLogicId);
    }

    @JsonIgnore
    public boolean isNo4PSDEViewLogicIdDirty() {
        return this.contains(FIELD_NO4PSDEVIEWLOGICID);
    }

    @JsonIgnore
    public String getNo4PSDEViewLogicName() {
        Object objValue = this.get(FIELD_NO4PSDEVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeviewlogicname")
    public void setNo4PSDEViewLogicName(String no4PSDEViewLogicName) {
        this.set(FIELD_NO4PSDEVIEWLOGICNAME, no4PSDEViewLogicName);
    }

    @JsonIgnore
    public boolean isNo4PSDEViewLogicNameDirty() {
        return this.contains(FIELD_NO4PSDEVIEWLOGICNAME);
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
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getPSDEViewCtrlId() {
        Object objValue = this.get(FIELD_PSDEVIEWCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewctrlid")
    public void setPSDEViewCtrlId(String pSDEViewCtrlId) {
        this.set(FIELD_PSDEVIEWCTRLID, pSDEViewCtrlId);
    }

    @JsonIgnore
    public boolean isPSDEViewCtrlIdDirty() {
        return this.contains(FIELD_PSDEVIEWCTRLID);
    }

    @JsonIgnore
    public String getPSDEViewCtrlName() {
        Object objValue = this.get(FIELD_PSDEVIEWCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewctrlname")
    public void setPSDEViewCtrlName(String pSDEViewCtrlName) {
        this.set(FIELD_PSDEVIEWCTRLNAME, pSDEViewCtrlName);
    }

    @JsonIgnore
    public boolean isPSDEViewCtrlNameDirty() {
        return this.contains(FIELD_PSDEVIEWCTRLNAME);
    }

    @JsonIgnore
    public String getPSDEViewEngineId() {
        Object objValue = this.get(FIELD_PSDEVIEWENGINEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewengineid")
    public void setPSDEViewEngineId(String pSDEViewEngineId) {
        this.set(FIELD_PSDEVIEWENGINEID, pSDEViewEngineId);
    }

    @JsonIgnore
    public boolean isPSDEViewEngineIdDirty() {
        return this.contains(FIELD_PSDEVIEWENGINEID);
    }

    @JsonIgnore
    public String getPSDEViewEngineName() {
        Object objValue = this.get(FIELD_PSDEVIEWENGINENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewenginename")
    public void setPSDEViewEngineName(String pSDEViewEngineName) {
        this.set(FIELD_PSDEVIEWENGINENAME, pSDEViewEngineName);
    }

    @JsonIgnore
    public boolean isPSDEViewEngineNameDirty() {
        return this.contains(FIELD_PSDEVIEWENGINENAME);
    }

    @JsonIgnore
    public String getPSDEViewLogicId() {
        Object objValue = this.get(FIELD_PSDEVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewlogicid")
    public void setPSDEViewLogicId(String pSDEViewLogicId) {
        this.set(FIELD_PSDEVIEWLOGICID, pSDEViewLogicId);
    }

    @JsonIgnore
    public boolean isPSDEViewLogicIdDirty() {
        return this.contains(FIELD_PSDEVIEWLOGICID);
    }

    @JsonIgnore
    public String getPSDEViewLogicName() {
        Object objValue = this.get(FIELD_PSDEVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewlogicname")
    public void setPSDEViewLogicName(String pSDEViewLogicName) {
        this.set(FIELD_PSDEVIEWLOGICNAME, pSDEViewLogicName);
    }

    @JsonIgnore
    public boolean isPSDEViewLogicNameDirty() {
        return this.contains(FIELD_PSDEVIEWLOGICNAME);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEViewEngineId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEViewEngineId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEVIEWENGINE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEViewEngine item = (PSDEViewEngine)MAPPER.readValue(new File(strJsonFilePath), PSDEViewEngine.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEViewEngine) {
            PSDEViewEngine pSDEViewEngine = (PSDEViewEngine)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEViewEngine) {
            PSDEViewEngine pSDEViewEngine = (PSDEViewEngine)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

