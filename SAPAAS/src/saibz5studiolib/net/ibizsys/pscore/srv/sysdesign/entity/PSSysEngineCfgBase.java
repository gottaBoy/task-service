/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEngineCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEngineCfgBase.class);
    public static final String FIELD_CFGVER = "CFGVER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GLOBALFLAG = "GLOBALFLAG";
    public static final String FIELD_IMPDEFRULE = "IMPDEFRULE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSYSENGINECFGID = "PSSYSENGINECFGID";
    public static final String FIELD_PSSYSENGINECFGNAME = "PSSYSENGINECFGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWCTRLAJAXMODE = "VIEWCTRLAJAXMODE";
    public static final String FIELD_VIEWCTRLHANDLERFIRST = "VIEWCTRLHANDLERFIRST";
    public static final String FIELD_VIEWUAREGMODE = "VIEWUAREGMODE";
    private static final int INDEX_CFGVER = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_GLOBALFLAG = 3;
    private static final int INDEX_IMPDEFRULE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSSYSENGINECFGID = 8;
    private static final int INDEX_PSSYSENGINECFGNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final int INDEX_VIEWCTRLAJAXMODE = 13;
    private static final int INDEX_VIEWCTRLHANDLERFIRST = 14;
    private static final int INDEX_VIEWUAREGMODE = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEngineCfgBase proxyPSSysEngineCfgBase = null;
    private boolean cfgverDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean globalflagDirtyFlag = false;
    private boolean impdefruleDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssysenginecfgidDirtyFlag = false;
    private boolean pssysenginecfgnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewctrlajaxmodeDirtyFlag = false;
    private boolean viewctrlhandlerfirstDirtyFlag = false;
    private boolean viewuaregmodeDirtyFlag = false;
    @Column(name="cfgver")
    private Integer cfgver;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="globalflag")
    private Integer globalflag;
    @Column(name="impdefrule")
    private Integer impdefrule;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssysenginecfgid")
    private String pssysenginecfgid;
    @Column(name="pssysenginecfgname")
    private String pssysenginecfgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewctrlajaxmode")
    private Integer viewctrlajaxmode;
    @Column(name="viewctrlhandlerfirst")
    private Integer viewctrlhandlerfirst;
    @Column(name="viewuaregmode")
    private Integer viewuaregmode;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setCfgVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgVer(n);
            return;
        }
        this.cfgver = n;
        this.cfgverDirtyFlag = true;
    }

    public Integer getCfgVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgVer();
        }
        return this.cfgver;
    }

    public boolean isCfgVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgVerDirty();
        }
        return this.cfgverDirtyFlag;
    }

    public void resetCfgVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgVer();
            return;
        }
        this.cfgverDirtyFlag = false;
        this.cfgver = null;
    }

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

    public void setGlobalFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalFlag(n);
            return;
        }
        this.globalflag = n;
        this.globalflagDirtyFlag = true;
    }

    public Integer getGlobalFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalFlag();
        }
        return this.globalflag;
    }

    public boolean isGlobalFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalFlagDirty();
        }
        return this.globalflagDirtyFlag;
    }

    public void resetGlobalFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalFlag();
            return;
        }
        this.globalflagDirtyFlag = false;
        this.globalflag = null;
    }

    public void setImpDEFRule(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpDEFRule(n);
            return;
        }
        this.impdefrule = n;
        this.impdefruleDirtyFlag = true;
    }

    public Integer getImpDEFRule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpDEFRule();
        }
        return this.impdefrule;
    }

    public boolean isImpDEFRuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpDEFRuleDirty();
        }
        return this.impdefruleDirtyFlag;
    }

    public void resetImpDEFRule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpDEFRule();
            return;
        }
        this.impdefruleDirtyFlag = false;
        this.impdefrule = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSSysEngineCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEngineCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysenginecfgid = string;
        this.pssysenginecfgidDirtyFlag = true;
    }

    public String getPSSysEngineCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEngineCfgId();
        }
        return this.pssysenginecfgid;
    }

    public boolean isPSSysEngineCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEngineCfgIdDirty();
        }
        return this.pssysenginecfgidDirtyFlag;
    }

    public void resetPSSysEngineCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEngineCfgId();
            return;
        }
        this.pssysenginecfgidDirtyFlag = false;
        this.pssysenginecfgid = null;
    }

    public void setPSSysEngineCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEngineCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysenginecfgname = string;
        this.pssysenginecfgnameDirtyFlag = true;
    }

    public String getPSSysEngineCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEngineCfgName();
        }
        return this.pssysenginecfgname;
    }

    public boolean isPSSysEngineCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEngineCfgNameDirty();
        }
        return this.pssysenginecfgnameDirtyFlag;
    }

    public void resetPSSysEngineCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEngineCfgName();
            return;
        }
        this.pssysenginecfgnameDirtyFlag = false;
        this.pssysenginecfgname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setViewCtrlAjaxMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCtrlAjaxMode(n);
            return;
        }
        this.viewctrlajaxmode = n;
        this.viewctrlajaxmodeDirtyFlag = true;
    }

    public Integer getViewCtrlAjaxMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCtrlAjaxMode();
        }
        return this.viewctrlajaxmode;
    }

    public boolean isViewCtrlAjaxModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCtrlAjaxModeDirty();
        }
        return this.viewctrlajaxmodeDirtyFlag;
    }

    public void resetViewCtrlAjaxMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCtrlAjaxMode();
            return;
        }
        this.viewctrlajaxmodeDirtyFlag = false;
        this.viewctrlajaxmode = null;
    }

    public void setViewCtrlHandlerFirst(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCtrlHandlerFirst(n);
            return;
        }
        this.viewctrlhandlerfirst = n;
        this.viewctrlhandlerfirstDirtyFlag = true;
    }

    public Integer getViewCtrlHandlerFirst() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCtrlHandlerFirst();
        }
        return this.viewctrlhandlerfirst;
    }

    public boolean isViewCtrlHandlerFirstDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCtrlHandlerFirstDirty();
        }
        return this.viewctrlhandlerfirstDirtyFlag;
    }

    public void resetViewCtrlHandlerFirst() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCtrlHandlerFirst();
            return;
        }
        this.viewctrlhandlerfirstDirtyFlag = false;
        this.viewctrlhandlerfirst = null;
    }

    public void setViewUARegMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewUARegMode(n);
            return;
        }
        this.viewuaregmode = n;
        this.viewuaregmodeDirtyFlag = true;
    }

    public Integer getViewUARegMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewUARegMode();
        }
        return this.viewuaregmode;
    }

    public boolean isViewUARegModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewUARegModeDirty();
        }
        return this.viewuaregmodeDirtyFlag;
    }

    public void resetViewUARegMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewUARegMode();
            return;
        }
        this.viewuaregmodeDirtyFlag = false;
        this.viewuaregmode = null;
    }

    protected void onReset() {
        PSSysEngineCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEngineCfgBase pSSysEngineCfgBase) {
        pSSysEngineCfgBase.resetCfgVer();
        pSSysEngineCfgBase.resetCreateDate();
        pSSysEngineCfgBase.resetCreateMan();
        pSSysEngineCfgBase.resetGlobalFlag();
        pSSysEngineCfgBase.resetImpDEFRule();
        pSSysEngineCfgBase.resetMemo();
        pSSysEngineCfgBase.resetPSDevCenterId();
        pSSysEngineCfgBase.resetPSDevCenterName();
        pSSysEngineCfgBase.resetPSSysEngineCfgId();
        pSSysEngineCfgBase.resetPSSysEngineCfgName();
        pSSysEngineCfgBase.resetUpdateDate();
        pSSysEngineCfgBase.resetUpdateMan();
        pSSysEngineCfgBase.resetValidFlag();
        pSSysEngineCfgBase.resetViewCtrlAjaxMode();
        pSSysEngineCfgBase.resetViewCtrlHandlerFirst();
        pSSysEngineCfgBase.resetViewUARegMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCfgVerDirty()) {
            hashMap.put(FIELD_CFGVER, this.getCfgVer());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGlobalFlagDirty()) {
            hashMap.put(FIELD_GLOBALFLAG, this.getGlobalFlag());
        }
        if (!bl || this.isImpDEFRuleDirty()) {
            hashMap.put(FIELD_IMPDEFRULE, this.getImpDEFRule());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSysEngineCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSENGINECFGID, this.getPSSysEngineCfgId());
        }
        if (!bl || this.isPSSysEngineCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSENGINECFGNAME, this.getPSSysEngineCfgName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isViewCtrlAjaxModeDirty()) {
            hashMap.put(FIELD_VIEWCTRLAJAXMODE, this.getViewCtrlAjaxMode());
        }
        if (!bl || this.isViewCtrlHandlerFirstDirty()) {
            hashMap.put(FIELD_VIEWCTRLHANDLERFIRST, this.getViewCtrlHandlerFirst());
        }
        if (!bl || this.isViewUARegModeDirty()) {
            hashMap.put(FIELD_VIEWUAREGMODE, this.getViewUARegMode());
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
        return PSSysEngineCfgBase.get(this, n);
    }

    private static Object get(PSSysEngineCfgBase pSSysEngineCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEngineCfgBase.getCfgVer();
            }
            case 1: {
                return pSSysEngineCfgBase.getCreateDate();
            }
            case 2: {
                return pSSysEngineCfgBase.getCreateMan();
            }
            case 3: {
                return pSSysEngineCfgBase.getGlobalFlag();
            }
            case 4: {
                return pSSysEngineCfgBase.getImpDEFRule();
            }
            case 5: {
                return pSSysEngineCfgBase.getMemo();
            }
            case 6: {
                return pSSysEngineCfgBase.getPSDevCenterId();
            }
            case 7: {
                return pSSysEngineCfgBase.getPSDevCenterName();
            }
            case 8: {
                return pSSysEngineCfgBase.getPSSysEngineCfgId();
            }
            case 9: {
                return pSSysEngineCfgBase.getPSSysEngineCfgName();
            }
            case 10: {
                return pSSysEngineCfgBase.getUpdateDate();
            }
            case 11: {
                return pSSysEngineCfgBase.getUpdateMan();
            }
            case 12: {
                return pSSysEngineCfgBase.getValidFlag();
            }
            case 13: {
                return pSSysEngineCfgBase.getViewCtrlAjaxMode();
            }
            case 14: {
                return pSSysEngineCfgBase.getViewCtrlHandlerFirst();
            }
            case 15: {
                return pSSysEngineCfgBase.getViewUARegMode();
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
        PSSysEngineCfgBase.set(this, n, object);
    }

    private static void set(PSSysEngineCfgBase pSSysEngineCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEngineCfgBase.setCfgVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysEngineCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEngineCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEngineCfgBase.setGlobalFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysEngineCfgBase.setImpDEFRule(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysEngineCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEngineCfgBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEngineCfgBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEngineCfgBase.setPSSysEngineCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEngineCfgBase.setPSSysEngineCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEngineCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysEngineCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEngineCfgBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysEngineCfgBase.setViewCtrlAjaxMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysEngineCfgBase.setViewCtrlHandlerFirst(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysEngineCfgBase.setViewUARegMode(DataObject.getIntegerValue((Object)object));
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
        return PSSysEngineCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEngineCfgBase pSSysEngineCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEngineCfgBase.getCfgVer() == null;
            }
            case 1: {
                return pSSysEngineCfgBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEngineCfgBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEngineCfgBase.getGlobalFlag() == null;
            }
            case 4: {
                return pSSysEngineCfgBase.getImpDEFRule() == null;
            }
            case 5: {
                return pSSysEngineCfgBase.getMemo() == null;
            }
            case 6: {
                return pSSysEngineCfgBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSSysEngineCfgBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSSysEngineCfgBase.getPSSysEngineCfgId() == null;
            }
            case 9: {
                return pSSysEngineCfgBase.getPSSysEngineCfgName() == null;
            }
            case 10: {
                return pSSysEngineCfgBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysEngineCfgBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysEngineCfgBase.getValidFlag() == null;
            }
            case 13: {
                return pSSysEngineCfgBase.getViewCtrlAjaxMode() == null;
            }
            case 14: {
                return pSSysEngineCfgBase.getViewCtrlHandlerFirst() == null;
            }
            case 15: {
                return pSSysEngineCfgBase.getViewUARegMode() == null;
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
        return PSSysEngineCfgBase.contains(this, n);
    }

    private static boolean contains(PSSysEngineCfgBase pSSysEngineCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEngineCfgBase.isCfgVerDirty();
            }
            case 1: {
                return pSSysEngineCfgBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEngineCfgBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEngineCfgBase.isGlobalFlagDirty();
            }
            case 4: {
                return pSSysEngineCfgBase.isImpDEFRuleDirty();
            }
            case 5: {
                return pSSysEngineCfgBase.isMemoDirty();
            }
            case 6: {
                return pSSysEngineCfgBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSSysEngineCfgBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSSysEngineCfgBase.isPSSysEngineCfgIdDirty();
            }
            case 9: {
                return pSSysEngineCfgBase.isPSSysEngineCfgNameDirty();
            }
            case 10: {
                return pSSysEngineCfgBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysEngineCfgBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysEngineCfgBase.isValidFlagDirty();
            }
            case 13: {
                return pSSysEngineCfgBase.isViewCtrlAjaxModeDirty();
            }
            case 14: {
                return pSSysEngineCfgBase.isViewCtrlHandlerFirstDirty();
            }
            case 15: {
                return pSSysEngineCfgBase.isViewUARegModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEngineCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEngineCfgBase pSSysEngineCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEngineCfgBase.getCfgVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgver", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getCfgVer()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getGlobalFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globalflag", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getGlobalFlag()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getImpDEFRule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impdefrule", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getImpDEFRule()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getPSSysEngineCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysenginecfgid", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getPSSysEngineCfgId()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getPSSysEngineCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysenginecfgname", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getPSSysEngineCfgName()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getViewCtrlAjaxMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewctrlajaxmode", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getViewCtrlAjaxMode()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getViewCtrlHandlerFirst() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewctrlhandlerfirst", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getViewCtrlHandlerFirst()), (boolean)false);
        }
        if (bl || pSSysEngineCfgBase.getViewUARegMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewuaregmode", (Object)PSSysEngineCfgBase.getJSONValue((Object)pSSysEngineCfgBase.getViewUARegMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEngineCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEngineCfgBase pSSysEngineCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEngineCfgBase.getCfgVer() != null) {
            object = pSSysEngineCfgBase.getCfgVer();
            xmlNode.setAttribute(FIELD_CFGVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getCreateDate() != null) {
            object = pSSysEngineCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getCreateMan() != null) {
            object = pSSysEngineCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getGlobalFlag() != null) {
            object = pSSysEngineCfgBase.getGlobalFlag();
            xmlNode.setAttribute(FIELD_GLOBALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getImpDEFRule() != null) {
            object = pSSysEngineCfgBase.getImpDEFRule();
            xmlNode.setAttribute(FIELD_IMPDEFRULE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getMemo() != null) {
            object = pSSysEngineCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getPSDevCenterId() != null) {
            object = pSSysEngineCfgBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getPSDevCenterName() != null) {
            object = pSSysEngineCfgBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getPSSysEngineCfgId() != null) {
            object = pSSysEngineCfgBase.getPSSysEngineCfgId();
            xmlNode.setAttribute(FIELD_PSSYSENGINECFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getPSSysEngineCfgName() != null) {
            object = pSSysEngineCfgBase.getPSSysEngineCfgName();
            xmlNode.setAttribute(FIELD_PSSYSENGINECFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getUpdateDate() != null) {
            object = pSSysEngineCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getUpdateMan() != null) {
            object = pSSysEngineCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEngineCfgBase.getValidFlag() != null) {
            object = pSSysEngineCfgBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getViewCtrlAjaxMode() != null) {
            object = pSSysEngineCfgBase.getViewCtrlAjaxMode();
            xmlNode.setAttribute(FIELD_VIEWCTRLAJAXMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getViewCtrlHandlerFirst() != null) {
            object = pSSysEngineCfgBase.getViewCtrlHandlerFirst();
            xmlNode.setAttribute(FIELD_VIEWCTRLHANDLERFIRST, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEngineCfgBase.getViewUARegMode() != null) {
            object = pSSysEngineCfgBase.getViewUARegMode();
            xmlNode.setAttribute(FIELD_VIEWUAREGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEngineCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEngineCfgBase pSSysEngineCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEngineCfgBase.isCfgVerDirty() && (bl || pSSysEngineCfgBase.getCfgVer() != null)) {
            iDataObject.set(FIELD_CFGVER, (Object)pSSysEngineCfgBase.getCfgVer());
        }
        if (pSSysEngineCfgBase.isCreateDateDirty() && (bl || pSSysEngineCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEngineCfgBase.getCreateDate());
        }
        if (pSSysEngineCfgBase.isCreateManDirty() && (bl || pSSysEngineCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEngineCfgBase.getCreateMan());
        }
        if (pSSysEngineCfgBase.isGlobalFlagDirty() && (bl || pSSysEngineCfgBase.getGlobalFlag() != null)) {
            iDataObject.set(FIELD_GLOBALFLAG, (Object)pSSysEngineCfgBase.getGlobalFlag());
        }
        if (pSSysEngineCfgBase.isImpDEFRuleDirty() && (bl || pSSysEngineCfgBase.getImpDEFRule() != null)) {
            iDataObject.set(FIELD_IMPDEFRULE, (Object)pSSysEngineCfgBase.getImpDEFRule());
        }
        if (pSSysEngineCfgBase.isMemoDirty() && (bl || pSSysEngineCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEngineCfgBase.getMemo());
        }
        if (pSSysEngineCfgBase.isPSDevCenterIdDirty() && (bl || pSSysEngineCfgBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSysEngineCfgBase.getPSDevCenterId());
        }
        if (pSSysEngineCfgBase.isPSDevCenterNameDirty() && (bl || pSSysEngineCfgBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSysEngineCfgBase.getPSDevCenterName());
        }
        if (pSSysEngineCfgBase.isPSSysEngineCfgIdDirty() && (bl || pSSysEngineCfgBase.getPSSysEngineCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSENGINECFGID, (Object)pSSysEngineCfgBase.getPSSysEngineCfgId());
        }
        if (pSSysEngineCfgBase.isPSSysEngineCfgNameDirty() && (bl || pSSysEngineCfgBase.getPSSysEngineCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSENGINECFGNAME, (Object)pSSysEngineCfgBase.getPSSysEngineCfgName());
        }
        if (pSSysEngineCfgBase.isUpdateDateDirty() && (bl || pSSysEngineCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEngineCfgBase.getUpdateDate());
        }
        if (pSSysEngineCfgBase.isUpdateManDirty() && (bl || pSSysEngineCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEngineCfgBase.getUpdateMan());
        }
        if (pSSysEngineCfgBase.isValidFlagDirty() && (bl || pSSysEngineCfgBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEngineCfgBase.getValidFlag());
        }
        if (pSSysEngineCfgBase.isViewCtrlAjaxModeDirty() && (bl || pSSysEngineCfgBase.getViewCtrlAjaxMode() != null)) {
            iDataObject.set(FIELD_VIEWCTRLAJAXMODE, (Object)pSSysEngineCfgBase.getViewCtrlAjaxMode());
        }
        if (pSSysEngineCfgBase.isViewCtrlHandlerFirstDirty() && (bl || pSSysEngineCfgBase.getViewCtrlHandlerFirst() != null)) {
            iDataObject.set(FIELD_VIEWCTRLHANDLERFIRST, (Object)pSSysEngineCfgBase.getViewCtrlHandlerFirst());
        }
        if (pSSysEngineCfgBase.isViewUARegModeDirty() && (bl || pSSysEngineCfgBase.getViewUARegMode() != null)) {
            iDataObject.set(FIELD_VIEWUAREGMODE, (Object)pSSysEngineCfgBase.getViewUARegMode());
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
        return PSSysEngineCfgBase.remove(this, n);
    }

    private static boolean remove(PSSysEngineCfgBase pSSysEngineCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEngineCfgBase.resetCfgVer();
                return true;
            }
            case 1: {
                pSSysEngineCfgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEngineCfgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEngineCfgBase.resetGlobalFlag();
                return true;
            }
            case 4: {
                pSSysEngineCfgBase.resetImpDEFRule();
                return true;
            }
            case 5: {
                pSSysEngineCfgBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysEngineCfgBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSSysEngineCfgBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSSysEngineCfgBase.resetPSSysEngineCfgId();
                return true;
            }
            case 9: {
                pSSysEngineCfgBase.resetPSSysEngineCfgName();
                return true;
            }
            case 10: {
                pSSysEngineCfgBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysEngineCfgBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysEngineCfgBase.resetValidFlag();
                return true;
            }
            case 13: {
                pSSysEngineCfgBase.resetViewCtrlAjaxMode();
                return true;
            }
            case 14: {
                pSSysEngineCfgBase.resetViewCtrlHandlerFirst();
                return true;
            }
            case 15: {
                pSSysEngineCfgBase.resetViewUARegMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSSysEngineCfgBase getProxyEntity() {
        return this.proxyPSSysEngineCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEngineCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEngineCfgBase) {
            this.proxyPSSysEngineCfgBase = (PSSysEngineCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CFGVER, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_GLOBALFLAG, 3);
        fieldIndexMap.put(FIELD_IMPDEFRULE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSENGINECFGID, 8);
        fieldIndexMap.put(FIELD_PSSYSENGINECFGNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
        fieldIndexMap.put(FIELD_VIEWCTRLAJAXMODE, 13);
        fieldIndexMap.put(FIELD_VIEWCTRLHANDLERFIRST, 14);
        fieldIndexMap.put(FIELD_VIEWUAREGMODE, 15);
    }
}

