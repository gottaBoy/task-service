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

public class PSSysPFPITempl
extends PSModelBase {
    public static final String FIELD_CODEMAP = "codemap";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSPFPUBCODEID = "pspfpubcodeid";
    public static final String FIELD_PSPFPUBCODENAME = "pspfpubcodename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPITEMPLID = "pssyspfpitemplid";
    public static final String FIELD_PSSYSPFPITEMPLNAME = "pssyspfpitemplname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_TEMPLCODE = "templcode";
    public static final String FIELD_TEMPLCODE2 = "templcode2";
    public static final String FIELD_TEMPLCODE2EX = "templcode2ex";
    public static final String FIELD_TEMPLCODE2FLAG = "templcode2flag";
    public static final String FIELD_TEMPLCODE2INFO = "templcode2info";
    public static final String FIELD_TEMPLCODE3 = "templcode3";
    public static final String FIELD_TEMPLCODE3FLAG = "templcode3flag";
    public static final String FIELD_TEMPLCODE3INFO = "templcode3info";
    public static final String FIELD_TEMPLCODE4 = "templcode4";
    public static final String FIELD_TEMPLCODE4FLAG = "templcode4flag";
    public static final String FIELD_TEMPLCODE4INFO = "templcode4info";
    public static final String FIELD_TEMPLCODE5 = "templcode5";
    public static final String FIELD_TEMPLCODE6 = "templcode6";
    public static final String FIELD_TEMPLCODEFLAG = "templcodeflag";
    public static final String FIELD_TEMPLCODEINFO = "templcodeinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

    @JsonIgnore
    public String getCodeMap() {
        Object objValue = this.get(FIELD_CODEMAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codemap")
    public void setCodeMap(String codeMap) {
        this.set(FIELD_CODEMAP, codeMap);
    }

    @JsonIgnore
    public boolean isCodeMapDirty() {
        return this.contains(FIELD_CODEMAP);
    }

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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
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
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
    }

    @JsonIgnore
    public String getPSPFPubCodeId() {
        Object objValue = this.get(FIELD_PSPFPUBCODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfpubcodeid")
    public void setPSPFPubCodeId(String pSPFPubCodeId) {
        this.set(FIELD_PSPFPUBCODEID, pSPFPubCodeId);
    }

    @JsonIgnore
    public boolean isPSPFPubCodeIdDirty() {
        return this.contains(FIELD_PSPFPUBCODEID);
    }

    @JsonIgnore
    public String getPSPFPubCodeName() {
        Object objValue = this.get(FIELD_PSPFPUBCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfpubcodename")
    public void setPSPFPubCodeName(String pSPFPubCodeName) {
        this.set(FIELD_PSPFPUBCODENAME, pSPFPubCodeName);
    }

    @JsonIgnore
    public boolean isPSPFPubCodeNameDirty() {
        return this.contains(FIELD_PSPFPUBCODENAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysPFPITemplId() {
        Object objValue = this.get(FIELD_PSSYSPFPITEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpitemplid")
    public void setPSSysPFPITemplId(String pSSysPFPITemplId) {
        this.set(FIELD_PSSYSPFPITEMPLID, pSSysPFPITemplId);
    }

    @JsonIgnore
    public boolean isPSSysPFPITemplIdDirty() {
        return this.contains(FIELD_PSSYSPFPITEMPLID);
    }

    @JsonIgnore
    public String getPSSysPFPITemplName() {
        Object objValue = this.get(FIELD_PSSYSPFPITEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpitemplname")
    public void setPSSysPFPITemplName(String pSSysPFPITemplName) {
        this.set(FIELD_PSSYSPFPITEMPLNAME, pSSysPFPITemplName);
    }

    @JsonIgnore
    public boolean isPSSysPFPITemplNameDirty() {
        return this.contains(FIELD_PSSYSPFPITEMPLNAME);
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
    public String getTemplCode() {
        Object objValue = this.get(FIELD_TEMPLCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode")
    public void setTemplCode(String templCode) {
        this.set(FIELD_TEMPLCODE, templCode);
    }

    @JsonIgnore
    public boolean isTemplCodeDirty() {
        return this.contains(FIELD_TEMPLCODE);
    }

    @JsonIgnore
    public String getTemplCode2() {
        Object objValue = this.get(FIELD_TEMPLCODE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode2")
    public void setTemplCode2(String templCode2) {
        this.set(FIELD_TEMPLCODE2, templCode2);
    }

    @JsonIgnore
    public boolean isTemplCode2Dirty() {
        return this.contains(FIELD_TEMPLCODE2);
    }

    @JsonIgnore
    public String getTemplCode2Ex() {
        Object objValue = this.get(FIELD_TEMPLCODE2EX);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode2ex")
    public void setTemplCode2Ex(String templCode2Ex) {
        this.set(FIELD_TEMPLCODE2EX, templCode2Ex);
    }

    @JsonIgnore
    public boolean isTemplCode2ExDirty() {
        return this.contains(FIELD_TEMPLCODE2EX);
    }

    @JsonIgnore
    public Integer getTemplCode2Flag() {
        Object objValue = this.get(FIELD_TEMPLCODE2FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templcode2flag")
    public void setTemplCode2Flag(Integer templCode2Flag) {
        this.set(FIELD_TEMPLCODE2FLAG, templCode2Flag);
    }

    @JsonIgnore
    public boolean isTemplCode2FlagDirty() {
        return this.contains(FIELD_TEMPLCODE2FLAG);
    }

    @JsonIgnore
    public String getTemplCode2Info() {
        Object objValue = this.get(FIELD_TEMPLCODE2INFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode2info")
    public void setTemplCode2Info(String templCode2Info) {
        this.set(FIELD_TEMPLCODE2INFO, templCode2Info);
    }

    @JsonIgnore
    public boolean isTemplCode2InfoDirty() {
        return this.contains(FIELD_TEMPLCODE2INFO);
    }

    @JsonIgnore
    public String getTemplCode3() {
        Object objValue = this.get(FIELD_TEMPLCODE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode3")
    public void setTemplCode3(String templCode3) {
        this.set(FIELD_TEMPLCODE3, templCode3);
    }

    @JsonIgnore
    public boolean isTemplCode3Dirty() {
        return this.contains(FIELD_TEMPLCODE3);
    }

    @JsonIgnore
    public Integer getTemplCode3Flag() {
        Object objValue = this.get(FIELD_TEMPLCODE3FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templcode3flag")
    public void setTemplCode3Flag(Integer templCode3Flag) {
        this.set(FIELD_TEMPLCODE3FLAG, templCode3Flag);
    }

    @JsonIgnore
    public boolean isTemplCode3FlagDirty() {
        return this.contains(FIELD_TEMPLCODE3FLAG);
    }

    @JsonIgnore
    public String getTemplCode3Info() {
        Object objValue = this.get(FIELD_TEMPLCODE3INFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode3info")
    public void setTemplCode3Info(String templCode3Info) {
        this.set(FIELD_TEMPLCODE3INFO, templCode3Info);
    }

    @JsonIgnore
    public boolean isTemplCode3InfoDirty() {
        return this.contains(FIELD_TEMPLCODE3INFO);
    }

    @JsonIgnore
    public String getTemplCode4() {
        Object objValue = this.get(FIELD_TEMPLCODE4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode4")
    public void setTemplCode4(String templCode4) {
        this.set(FIELD_TEMPLCODE4, templCode4);
    }

    @JsonIgnore
    public boolean isTemplCode4Dirty() {
        return this.contains(FIELD_TEMPLCODE4);
    }

    @JsonIgnore
    public Integer getTemplCode4Flag() {
        Object objValue = this.get(FIELD_TEMPLCODE4FLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templcode4flag")
    public void setTemplCode4Flag(Integer templCode4Flag) {
        this.set(FIELD_TEMPLCODE4FLAG, templCode4Flag);
    }

    @JsonIgnore
    public boolean isTemplCode4FlagDirty() {
        return this.contains(FIELD_TEMPLCODE4FLAG);
    }

    @JsonIgnore
    public String getTemplCode4Info() {
        Object objValue = this.get(FIELD_TEMPLCODE4INFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode4info")
    public void setTemplCode4Info(String templCode4Info) {
        this.set(FIELD_TEMPLCODE4INFO, templCode4Info);
    }

    @JsonIgnore
    public boolean isTemplCode4InfoDirty() {
        return this.contains(FIELD_TEMPLCODE4INFO);
    }

    @JsonIgnore
    public String getTemplCode5() {
        Object objValue = this.get(FIELD_TEMPLCODE5);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode5")
    public void setTemplCode5(String templCode5) {
        this.set(FIELD_TEMPLCODE5, templCode5);
    }

    @JsonIgnore
    public boolean isTemplCode5Dirty() {
        return this.contains(FIELD_TEMPLCODE5);
    }

    @JsonIgnore
    public String getTemplCode6() {
        Object objValue = this.get(FIELD_TEMPLCODE6);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode6")
    public void setTemplCode6(String templCode6) {
        this.set(FIELD_TEMPLCODE6, templCode6);
    }

    @JsonIgnore
    public boolean isTemplCode6Dirty() {
        return this.contains(FIELD_TEMPLCODE6);
    }

    @JsonIgnore
    public Integer getTemplCodeFlag() {
        Object objValue = this.get(FIELD_TEMPLCODEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templcodeflag")
    public void setTemplCodeFlag(Integer templCodeFlag) {
        this.set(FIELD_TEMPLCODEFLAG, templCodeFlag);
    }

    @JsonIgnore
    public boolean isTemplCodeFlagDirty() {
        return this.contains(FIELD_TEMPLCODEFLAG);
    }

    @JsonIgnore
    public String getTemplCodeInfo() {
        Object objValue = this.get(FIELD_TEMPLCODEINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcodeinfo")
    public void setTemplCodeInfo(String templCodeInfo) {
        this.set(FIELD_TEMPLCODEINFO, templCodeInfo);
    }

    @JsonIgnore
    public boolean isTemplCodeInfoDirty() {
        return this.contains(FIELD_TEMPLCODEINFO);
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
    public String getSrfkey() {
        return this.getPSSysPFPITemplId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysPFPITemplId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSPFPITEMPL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysPFPITempl item = (PSSysPFPITempl)MAPPER.readValue(new File(strJsonFilePath), PSSysPFPITempl.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysPFPITempl) {
            PSSysPFPITempl pSSysPFPITempl = (PSSysPFPITempl)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysPFPITempl) {
            PSSysPFPITempl pSSysPFPITempl = (PSSysPFPITempl)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

