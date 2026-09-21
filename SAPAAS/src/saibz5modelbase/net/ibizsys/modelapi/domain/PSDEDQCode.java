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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQCodeCond;
import net.ibizsys.modelapi.domain.PSDEDQCodeExp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDQCode
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DBTYPE = "dbtype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEDQCODEID = "psdedqcodeid";
    public static final String FIELD_PSDEDQCODENAME = "psdedqcodename";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_QUERYCODE = "querycode";
    public static final String FIELD_QUERYCODETEMP = "querycodetemp";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERQUERYCODE = "userquerycode";
    public static final String FIELD_USERQUERYCODE2 = "userquerycode2";
    private List<PSDEDQCodeExp> psdedqcodeexps;
    private List<PSDEDQCodeCond> psdedqcodeconds;

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
    public String getDBType() {
        Object objValue = this.get(FIELD_DBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtype")
    public void setDBType(String dBType) {
        this.set(FIELD_DBTYPE, dBType);
    }

    @JsonIgnore
    public boolean isDBTypeDirty() {
        return this.contains(FIELD_DBTYPE);
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
    public String getPSDEDQCodeId() {
        Object objValue = this.get(FIELD_PSDEDQCODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodeid")
    public void setPSDEDQCodeId(String pSDEDQCodeId) {
        this.set(FIELD_PSDEDQCODEID, pSDEDQCodeId);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeIdDirty() {
        return this.contains(FIELD_PSDEDQCODEID);
    }

    @JsonIgnore
    public String getPSDEDQCodeName() {
        Object objValue = this.get(FIELD_PSDEDQCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodename")
    public void setPSDEDQCodeName(String pSDEDQCodeName) {
        this.set(FIELD_PSDEDQCODENAME, pSDEDQCodeName);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeNameDirty() {
        return this.contains(FIELD_PSDEDQCODENAME);
    }

    @JsonIgnore
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
    }

    @JsonIgnore
    public String getQueryCode() {
        Object objValue = this.get(FIELD_QUERYCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="querycode")
    public void setQueryCode(String queryCode) {
        this.set(FIELD_QUERYCODE, queryCode);
    }

    @JsonIgnore
    public boolean isQueryCodeDirty() {
        return this.contains(FIELD_QUERYCODE);
    }

    @JsonIgnore
    public String getQueryCodeTemp() {
        Object objValue = this.get(FIELD_QUERYCODETEMP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="querycodetemp")
    public void setQueryCodeTemp(String queryCodeTemp) {
        this.set(FIELD_QUERYCODETEMP, queryCodeTemp);
    }

    @JsonIgnore
    public boolean isQueryCodeTempDirty() {
        return this.contains(FIELD_QUERYCODETEMP);
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
    public String getUserQueryCode() {
        Object objValue = this.get(FIELD_USERQUERYCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userquerycode")
    public void setUserQueryCode(String userQueryCode) {
        this.set(FIELD_USERQUERYCODE, userQueryCode);
    }

    @JsonIgnore
    public boolean isUserQueryCodeDirty() {
        return this.contains(FIELD_USERQUERYCODE);
    }

    @JsonIgnore
    public String getUserQueryCode2() {
        Object objValue = this.get(FIELD_USERQUERYCODE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userquerycode2")
    public void setUserQueryCode2(String userQueryCode2) {
        this.set(FIELD_USERQUERYCODE2, userQueryCode2);
    }

    @JsonIgnore
    public boolean isUserQueryCode2Dirty() {
        return this.contains(FIELD_USERQUERYCODE2);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDQCodeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDQCodeId(strValue);
    }

    public List<PSDEDQCodeExp> getPsdedqcodeexps() {
        return this.psdedqcodeexps;
    }

    public void setPsdedqcodeexps(List<PSDEDQCodeExp> psdedqcodeexps) {
        this.psdedqcodeexps = psdedqcodeexps;
    }

    public List<PSDEDQCodeCond> getPsdedqcodeconds() {
        return this.psdedqcodeconds;
    }

    public void setPsdedqcodeconds(List<PSDEDQCodeCond> psdedqcodeconds) {
        this.psdedqcodeconds = psdedqcodeconds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdedqcodeexps")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedqcodeconds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedqcodeexps")) {
            this.init();
            return this.psdedqcodeexps;
        }
        if (strName.equalsIgnoreCase("psdedqcodeconds")) {
            this.init();
            return this.psdedqcodeconds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDQCODE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDQCode item = (PSDEDQCode)MAPPER.readValue(new File(strJsonFilePath), PSDEDQCode.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDQCode) {
            PSDEDQCode dst = (PSDEDQCode)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdedqcodeexps() != null) {
                    ArrayList<PSDEDQCodeExp> psdedqcodeexps = new ArrayList<PSDEDQCodeExp>();
                    for (PSDEDQCodeExp pSDEDQCodeExp : this.getPsdedqcodeexps()) {
                        if (bDeepMode) {
                            newitem = new PSDEDQCodeExp();
                            pSDEDQCodeExp.to(newitem, false, bDeepMode);
                            psdedqcodeexps.add((PSDEDQCodeExp)newitem);
                            continue;
                        }
                        psdedqcodeexps.add(pSDEDQCodeExp);
                    }
                    dst.setPsdedqcodeexps(psdedqcodeexps);
                }
                if (this.getPsdedqcodeconds() != null) {
                    ArrayList<PSDEDQCodeCond> psdedqcodeconds = new ArrayList<PSDEDQCodeCond>();
                    for (PSDEDQCodeCond pSDEDQCodeCond : this.getPsdedqcodeconds()) {
                        if (bDeepMode) {
                            newitem = new PSDEDQCodeCond();
                            pSDEDQCodeCond.to(newitem, false, bDeepMode);
                            psdedqcodeconds.add((PSDEDQCodeCond)newitem);
                            continue;
                        }
                        psdedqcodeconds.add(pSDEDQCodeCond);
                    }
                    dst.setPsdedqcodeconds(psdedqcodeconds);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDQCode) {
            PSDEDQCode src = (PSDEDQCode)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdedqcodeexps() != null) {
                    ArrayList<PSDEDQCodeExp> psdedqcodeexps = new ArrayList<PSDEDQCodeExp>();
                    for (PSDEDQCodeExp pSDEDQCodeExp : src.getPsdedqcodeexps()) {
                        if (bDeepMode) {
                            newItem = new PSDEDQCodeExp();
                            ((PSDEDQCodeExp)newItem).from(pSDEDQCodeExp, false, bDeepMode);
                            psdedqcodeexps.add((PSDEDQCodeExp)newItem);
                            continue;
                        }
                        psdedqcodeexps.add(pSDEDQCodeExp);
                    }
                    this.setPsdedqcodeexps(psdedqcodeexps);
                }
                if (src.getPsdedqcodeconds() != null) {
                    ArrayList<PSDEDQCodeCond> psdedqcodeconds = new ArrayList<PSDEDQCodeCond>();
                    for (PSDEDQCodeCond pSDEDQCodeCond : src.getPsdedqcodeconds()) {
                        if (bDeepMode) {
                            newItem = new PSDEDQCodeCond();
                            ((PSDEDQCodeCond)newItem).from(pSDEDQCodeCond, false, bDeepMode);
                            psdedqcodeconds.add((PSDEDQCodeCond)newItem);
                            continue;
                        }
                        psdedqcodeconds.add(pSDEDQCodeCond);
                    }
                    this.setPsdedqcodeconds(psdedqcodeconds);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

