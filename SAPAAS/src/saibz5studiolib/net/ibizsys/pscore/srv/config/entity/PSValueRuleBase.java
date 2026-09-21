/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSValueRuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSValueRuleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMOBJ = "CUSTOMOBJ";
    public static final String FIELD_CUSTOMPARAMS = "CUSTOMPARAMS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSVALUERULEID = "PSVALUERULEID";
    public static final String FIELD_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String FIELD_REGEXPCODE = "REGEXPCODE";
    public static final String FIELD_RULEINFO = "RULEINFO";
    public static final String FIELD_RULETYPE = "RULETYPE";
    public static final String FIELD_SCRIPT = "SCRIPT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CUSTOMOBJ = 2;
    private static final int INDEX_CUSTOMPARAMS = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSVALUERULEID = 5;
    private static final int INDEX_PSVALUERULENAME = 6;
    private static final int INDEX_REGEXPCODE = 7;
    private static final int INDEX_RULEINFO = 8;
    private static final int INDEX_RULETYPE = 9;
    private static final int INDEX_SCRIPT = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSValueRuleBase proxyPSValueRuleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customobjDirtyFlag = false;
    private boolean customparamsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psvalueruleidDirtyFlag = false;
    private boolean psvaluerulenameDirtyFlag = false;
    private boolean regexpcodeDirtyFlag = false;
    private boolean ruleinfoDirtyFlag = false;
    private boolean ruletypeDirtyFlag = false;
    private boolean scriptDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customobj")
    private String customobj;
    @Column(name="customparams")
    private String customparams;
    @Column(name="memo")
    private String memo;
    @Column(name="psvalueruleid")
    private String psvalueruleid;
    @Column(name="psvaluerulename")
    private String psvaluerulename;
    @Column(name="regexpcode")
    private String regexpcode;
    @Column(name="ruleinfo")
    private String ruleinfo;
    @Column(name="ruletype")
    private String ruletype;
    @Column(name="script")
    private String script;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCustomObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customobj = string;
        this.customobjDirtyFlag = true;
    }

    public String getCustomObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomObj();
        }
        return this.customobj;
    }

    public boolean isCustomObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomObjDirty();
        }
        return this.customobjDirtyFlag;
    }

    public void resetCustomObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomObj();
            return;
        }
        this.customobjDirtyFlag = false;
        this.customobj = null;
    }

    public void setCustomParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customparams = string;
        this.customparamsDirtyFlag = true;
    }

    public String getCustomParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomParams();
        }
        return this.customparams;
    }

    public boolean isCustomParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomParamsDirty();
        }
        return this.customparamsDirtyFlag;
    }

    public void resetCustomParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomParams();
            return;
        }
        this.customparamsDirtyFlag = false;
        this.customparams = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setPSValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvalueruleid = string;
        this.psvalueruleidDirtyFlag = true;
    }

    public String getPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleId();
        }
        return this.psvalueruleid;
    }

    public boolean isPSValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleIdDirty();
        }
        return this.psvalueruleidDirtyFlag;
    }

    public void resetPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleId();
            return;
        }
        this.psvalueruleidDirtyFlag = false;
        this.psvalueruleid = null;
    }

    public void setPSValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvaluerulename = string;
        this.psvaluerulenameDirtyFlag = true;
    }

    public String getPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleName();
        }
        return this.psvaluerulename;
    }

    public boolean isPSValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleNameDirty();
        }
        return this.psvaluerulenameDirtyFlag;
    }

    public void resetPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleName();
            return;
        }
        this.psvaluerulenameDirtyFlag = false;
        this.psvaluerulename = null;
    }

    public void setRegExpCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode = string;
        this.regexpcodeDirtyFlag = true;
    }

    public String getRegExpCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode();
        }
        return this.regexpcode;
    }

    public boolean isRegExpCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCodeDirty();
        }
        return this.regexpcodeDirtyFlag;
    }

    public void resetRegExpCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode();
            return;
        }
        this.regexpcodeDirtyFlag = false;
        this.regexpcode = null;
    }

    public void setRuleInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruleinfo = string;
        this.ruleinfoDirtyFlag = true;
    }

    public String getRuleInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleInfo();
        }
        return this.ruleinfo;
    }

    public boolean isRuleInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleInfoDirty();
        }
        return this.ruleinfoDirtyFlag;
    }

    public void resetRuleInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleInfo();
            return;
        }
        this.ruleinfoDirtyFlag = false;
        this.ruleinfo = null;
    }

    public void setRuleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletype = string;
        this.ruletypeDirtyFlag = true;
    }

    public String getRuleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleType();
        }
        return this.ruletype;
    }

    public boolean isRuleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTypeDirty();
        }
        return this.ruletypeDirtyFlag;
    }

    public void resetRuleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleType();
            return;
        }
        this.ruletypeDirtyFlag = false;
        this.ruletype = null;
    }

    public void setScript(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScript(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.script = string;
        this.scriptDirtyFlag = true;
    }

    public String getScript() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScript();
        }
        return this.script;
    }

    public boolean isScriptDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScriptDirty();
        }
        return this.scriptDirtyFlag;
    }

    public void resetScript() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScript();
            return;
        }
        this.scriptDirtyFlag = false;
        this.script = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    protected void onReset() {
        PSValueRuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSValueRuleBase pSValueRuleBase) {
        pSValueRuleBase.resetCreateDate();
        pSValueRuleBase.resetCreateMan();
        pSValueRuleBase.resetCustomObj();
        pSValueRuleBase.resetCustomParams();
        pSValueRuleBase.resetMemo();
        pSValueRuleBase.resetPSValueRuleId();
        pSValueRuleBase.resetPSValueRuleName();
        pSValueRuleBase.resetRegExpCode();
        pSValueRuleBase.resetRuleInfo();
        pSValueRuleBase.resetRuleType();
        pSValueRuleBase.resetScript();
        pSValueRuleBase.resetUpdateDate();
        pSValueRuleBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomObjDirty()) {
            hashMap.put(FIELD_CUSTOMOBJ, this.getCustomObj());
        }
        if (!bl || this.isCustomParamsDirty()) {
            hashMap.put(FIELD_CUSTOMPARAMS, this.getCustomParams());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSValueRuleIdDirty()) {
            hashMap.put(FIELD_PSVALUERULEID, this.getPSValueRuleId());
        }
        if (!bl || this.isPSValueRuleNameDirty()) {
            hashMap.put(FIELD_PSVALUERULENAME, this.getPSValueRuleName());
        }
        if (!bl || this.isRegExpCodeDirty()) {
            hashMap.put(FIELD_REGEXPCODE, this.getRegExpCode());
        }
        if (!bl || this.isRuleInfoDirty()) {
            hashMap.put(FIELD_RULEINFO, this.getRuleInfo());
        }
        if (!bl || this.isRuleTypeDirty()) {
            hashMap.put(FIELD_RULETYPE, this.getRuleType());
        }
        if (!bl || this.isScriptDirty()) {
            hashMap.put(FIELD_SCRIPT, this.getScript());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSValueRuleBase.get(this, n);
    }

    private static Object get(PSValueRuleBase pSValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSValueRuleBase.getCreateDate();
            }
            case 1: {
                return pSValueRuleBase.getCreateMan();
            }
            case 2: {
                return pSValueRuleBase.getCustomObj();
            }
            case 3: {
                return pSValueRuleBase.getCustomParams();
            }
            case 4: {
                return pSValueRuleBase.getMemo();
            }
            case 5: {
                return pSValueRuleBase.getPSValueRuleId();
            }
            case 6: {
                return pSValueRuleBase.getPSValueRuleName();
            }
            case 7: {
                return pSValueRuleBase.getRegExpCode();
            }
            case 8: {
                return pSValueRuleBase.getRuleInfo();
            }
            case 9: {
                return pSValueRuleBase.getRuleType();
            }
            case 10: {
                return pSValueRuleBase.getScript();
            }
            case 11: {
                return pSValueRuleBase.getUpdateDate();
            }
            case 12: {
                return pSValueRuleBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSValueRuleBase.set(this, n, object);
    }

    private static void set(PSValueRuleBase pSValueRuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSValueRuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSValueRuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSValueRuleBase.setCustomObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSValueRuleBase.setCustomParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSValueRuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSValueRuleBase.setPSValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSValueRuleBase.setPSValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSValueRuleBase.setRegExpCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSValueRuleBase.setRuleInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSValueRuleBase.setRuleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSValueRuleBase.setScript(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSValueRuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSValueRuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSValueRuleBase.isNull(this, n);
    }

    private static boolean isNull(PSValueRuleBase pSValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSValueRuleBase.getCreateDate() == null;
            }
            case 1: {
                return pSValueRuleBase.getCreateMan() == null;
            }
            case 2: {
                return pSValueRuleBase.getCustomObj() == null;
            }
            case 3: {
                return pSValueRuleBase.getCustomParams() == null;
            }
            case 4: {
                return pSValueRuleBase.getMemo() == null;
            }
            case 5: {
                return pSValueRuleBase.getPSValueRuleId() == null;
            }
            case 6: {
                return pSValueRuleBase.getPSValueRuleName() == null;
            }
            case 7: {
                return pSValueRuleBase.getRegExpCode() == null;
            }
            case 8: {
                return pSValueRuleBase.getRuleInfo() == null;
            }
            case 9: {
                return pSValueRuleBase.getRuleType() == null;
            }
            case 10: {
                return pSValueRuleBase.getScript() == null;
            }
            case 11: {
                return pSValueRuleBase.getUpdateDate() == null;
            }
            case 12: {
                return pSValueRuleBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSValueRuleBase.contains(this, n);
    }

    private static boolean contains(PSValueRuleBase pSValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSValueRuleBase.isCreateDateDirty();
            }
            case 1: {
                return pSValueRuleBase.isCreateManDirty();
            }
            case 2: {
                return pSValueRuleBase.isCustomObjDirty();
            }
            case 3: {
                return pSValueRuleBase.isCustomParamsDirty();
            }
            case 4: {
                return pSValueRuleBase.isMemoDirty();
            }
            case 5: {
                return pSValueRuleBase.isPSValueRuleIdDirty();
            }
            case 6: {
                return pSValueRuleBase.isPSValueRuleNameDirty();
            }
            case 7: {
                return pSValueRuleBase.isRegExpCodeDirty();
            }
            case 8: {
                return pSValueRuleBase.isRuleInfoDirty();
            }
            case 9: {
                return pSValueRuleBase.isRuleTypeDirty();
            }
            case 10: {
                return pSValueRuleBase.isScriptDirty();
            }
            case 11: {
                return pSValueRuleBase.isUpdateDateDirty();
            }
            case 12: {
                return pSValueRuleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSValueRuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSValueRuleBase pSValueRuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSValueRuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getCustomObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customobj", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getCustomObj()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getCustomParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customparams", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getCustomParams()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getPSValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvalueruleid", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getPSValueRuleId()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getPSValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvaluerulename", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getPSValueRuleName()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getRegExpCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getRegExpCode()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getRuleInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleinfo", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getRuleInfo()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getRuleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletype", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getRuleType()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getScript() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"script", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getScript()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSValueRuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSValueRuleBase.getJSONValue((Object)pSValueRuleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSValueRuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSValueRuleBase pSValueRuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSValueRuleBase.getCreateDate() != null) {
            object = pSValueRuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSValueRuleBase.getCreateMan() != null) {
            object = pSValueRuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getCustomObj() != null) {
            object = pSValueRuleBase.getCustomObj();
            xmlNode.setAttribute(FIELD_CUSTOMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getCustomParams() != null) {
            object = pSValueRuleBase.getCustomParams();
            xmlNode.setAttribute(FIELD_CUSTOMPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getMemo() != null) {
            object = pSValueRuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getPSValueRuleId() != null) {
            object = pSValueRuleBase.getPSValueRuleId();
            xmlNode.setAttribute(FIELD_PSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getPSValueRuleName() != null) {
            object = pSValueRuleBase.getPSValueRuleName();
            xmlNode.setAttribute(FIELD_PSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getRegExpCode() != null) {
            object = pSValueRuleBase.getRegExpCode();
            xmlNode.setAttribute(FIELD_REGEXPCODE, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getRuleInfo() != null) {
            object = pSValueRuleBase.getRuleInfo();
            xmlNode.setAttribute(FIELD_RULEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getRuleType() != null) {
            object = pSValueRuleBase.getRuleType();
            xmlNode.setAttribute(FIELD_RULETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getScript() != null) {
            object = pSValueRuleBase.getScript();
            xmlNode.setAttribute(FIELD_SCRIPT, object == null ? "" : (String)object);
        }
        if (bl || pSValueRuleBase.getUpdateDate() != null) {
            object = pSValueRuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSValueRuleBase.getUpdateMan() != null) {
            object = pSValueRuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSValueRuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSValueRuleBase pSValueRuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSValueRuleBase.isCreateDateDirty() && (bl || pSValueRuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSValueRuleBase.getCreateDate());
        }
        if (pSValueRuleBase.isCreateManDirty() && (bl || pSValueRuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSValueRuleBase.getCreateMan());
        }
        if (pSValueRuleBase.isCustomObjDirty() && (bl || pSValueRuleBase.getCustomObj() != null)) {
            iDataObject.set(FIELD_CUSTOMOBJ, (Object)pSValueRuleBase.getCustomObj());
        }
        if (pSValueRuleBase.isCustomParamsDirty() && (bl || pSValueRuleBase.getCustomParams() != null)) {
            iDataObject.set(FIELD_CUSTOMPARAMS, (Object)pSValueRuleBase.getCustomParams());
        }
        if (pSValueRuleBase.isMemoDirty() && (bl || pSValueRuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSValueRuleBase.getMemo());
        }
        if (pSValueRuleBase.isPSValueRuleIdDirty() && (bl || pSValueRuleBase.getPSValueRuleId() != null)) {
            iDataObject.set(FIELD_PSVALUERULEID, (Object)pSValueRuleBase.getPSValueRuleId());
        }
        if (pSValueRuleBase.isPSValueRuleNameDirty() && (bl || pSValueRuleBase.getPSValueRuleName() != null)) {
            iDataObject.set(FIELD_PSVALUERULENAME, (Object)pSValueRuleBase.getPSValueRuleName());
        }
        if (pSValueRuleBase.isRegExpCodeDirty() && (bl || pSValueRuleBase.getRegExpCode() != null)) {
            iDataObject.set(FIELD_REGEXPCODE, (Object)pSValueRuleBase.getRegExpCode());
        }
        if (pSValueRuleBase.isRuleInfoDirty() && (bl || pSValueRuleBase.getRuleInfo() != null)) {
            iDataObject.set(FIELD_RULEINFO, (Object)pSValueRuleBase.getRuleInfo());
        }
        if (pSValueRuleBase.isRuleTypeDirty() && (bl || pSValueRuleBase.getRuleType() != null)) {
            iDataObject.set(FIELD_RULETYPE, (Object)pSValueRuleBase.getRuleType());
        }
        if (pSValueRuleBase.isScriptDirty() && (bl || pSValueRuleBase.getScript() != null)) {
            iDataObject.set(FIELD_SCRIPT, (Object)pSValueRuleBase.getScript());
        }
        if (pSValueRuleBase.isUpdateDateDirty() && (bl || pSValueRuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSValueRuleBase.getUpdateDate());
        }
        if (pSValueRuleBase.isUpdateManDirty() && (bl || pSValueRuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSValueRuleBase.getUpdateMan());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSValueRuleBase.remove(this, n);
    }

    private static boolean remove(PSValueRuleBase pSValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSValueRuleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSValueRuleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSValueRuleBase.resetCustomObj();
                return true;
            }
            case 3: {
                pSValueRuleBase.resetCustomParams();
                return true;
            }
            case 4: {
                pSValueRuleBase.resetMemo();
                return true;
            }
            case 5: {
                pSValueRuleBase.resetPSValueRuleId();
                return true;
            }
            case 6: {
                pSValueRuleBase.resetPSValueRuleName();
                return true;
            }
            case 7: {
                pSValueRuleBase.resetRegExpCode();
                return true;
            }
            case 8: {
                pSValueRuleBase.resetRuleInfo();
                return true;
            }
            case 9: {
                pSValueRuleBase.resetRuleType();
                return true;
            }
            case 10: {
                pSValueRuleBase.resetScript();
                return true;
            }
            case 11: {
                pSValueRuleBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSValueRuleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSValueRuleBase getProxyEntity() {
        return this.proxyPSValueRuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSValueRuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSValueRuleBase) {
            this.proxyPSValueRuleBase = (PSValueRuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSValueRuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CUSTOMOBJ, 2);
        fieldIndexMap.put(FIELD_CUSTOMPARAMS, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSVALUERULEID, 5);
        fieldIndexMap.put(FIELD_PSVALUERULENAME, 6);
        fieldIndexMap.put(FIELD_REGEXPCODE, 7);
        fieldIndexMap.put(FIELD_RULEINFO, 8);
        fieldIndexMap.put(FIELD_RULETYPE, 9);
        fieldIndexMap.put(FIELD_SCRIPT, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

