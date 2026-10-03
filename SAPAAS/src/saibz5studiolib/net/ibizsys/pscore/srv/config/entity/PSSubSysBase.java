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
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubSysSF;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEMODELS = "DEMODELS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SFFWFLAG = "SFFWFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEMODELS = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVSLNSYSID = 4;
    private static final int INDEX_PSSFID = 5;
    private static final int INDEX_PSSFNAME = 6;
    private static final int INDEX_PSSUBSYSID = 7;
    private static final int INDEX_PSSUBSYSNAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_SFFWFLAG = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final int INDEX_VERSION = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysBase proxyPSSubSysBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean demodelsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean sffwflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="demodels")
    private String demodels;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="sffwflag")
    private Integer sffwflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="version")
    private Integer version;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSubAppsLock = new Integer(1);
    private ArrayList<PSSubApp> pssubapps = null;
    private Integer objPSSubSysSFsLock = new Integer(1);
    private ArrayList<PSSubSysSF> pssubsyssfs = null;

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

    public void setDEModels(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEModels(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.demodels = string;
        this.demodelsDirtyFlag = true;
    }

    public String getDEModels() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEModels();
        }
        return this.demodels;
    }

    public boolean isDEModelsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEModelsDirty();
        }
        return this.demodelsDirtyFlag;
    }

    public void resetDEModels() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEModels();
            return;
        }
        this.demodelsDirtyFlag = false;
        this.demodels = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setSFFWFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFFWFlag(n);
            return;
        }
        this.sffwflag = n;
        this.sffwflagDirtyFlag = true;
    }

    public Integer getSFFWFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFFWFlag();
        }
        return this.sffwflag;
    }

    public boolean isSFFWFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFFWFlagDirty();
        }
        return this.sffwflagDirtyFlag;
    }

    public void resetSFFWFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFFWFlag();
            return;
        }
        this.sffwflagDirtyFlag = false;
        this.sffwflag = null;
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

    public void setVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(n);
            return;
        }
        this.version = n;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSSubSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysBase pSSubSysBase) {
        pSSubSysBase.resetCreateDate();
        pSSubSysBase.resetCreateMan();
        pSSubSysBase.resetDEModels();
        pSSubSysBase.resetMemo();
        pSSubSysBase.resetPSDevSlnSysId();
        pSSubSysBase.resetPSSFId();
        pSSubSysBase.resetPSSFName();
        pSSubSysBase.resetPSSubSysId();
        pSSubSysBase.resetPSSubSysName();
        pSSubSysBase.resetPSSystemId();
        pSSubSysBase.resetSFFWFlag();
        pSSubSysBase.resetUpdateDate();
        pSSubSysBase.resetUpdateMan();
        pSSubSysBase.resetValidFlag();
        pSSubSysBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEModelsDirty()) {
            hashMap.put(FIELD_DEMODELS, this.getDEModels());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isSFFWFlagDirty()) {
            hashMap.put(FIELD_SFFWFLAG, this.getSFFWFlag());
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
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSSubSysBase.get(this, n);
    }

    private static Object get(PSSubSysBase pSSubSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysBase.getCreateDate();
            }
            case 1: {
                return pSSubSysBase.getCreateMan();
            }
            case 2: {
                return pSSubSysBase.getDEModels();
            }
            case 3: {
                return pSSubSysBase.getMemo();
            }
            case 4: {
                return pSSubSysBase.getPSDevSlnSysId();
            }
            case 5: {
                return pSSubSysBase.getPSSFId();
            }
            case 6: {
                return pSSubSysBase.getPSSFName();
            }
            case 7: {
                return pSSubSysBase.getPSSubSysId();
            }
            case 8: {
                return pSSubSysBase.getPSSubSysName();
            }
            case 9: {
                return pSSubSysBase.getPSSystemId();
            }
            case 10: {
                return pSSubSysBase.getSFFWFlag();
            }
            case 11: {
                return pSSubSysBase.getUpdateDate();
            }
            case 12: {
                return pSSubSysBase.getUpdateMan();
            }
            case 13: {
                return pSSubSysBase.getValidFlag();
            }
            case 14: {
                return pSSubSysBase.getVersion();
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
        PSSubSysBase.set(this, n, object);
    }

    private static void set(PSSubSysBase pSSubSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysBase.setDEModels(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysBase.setSFFWFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysBase.setVersion(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysBase pSSubSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysBase.getCreateDate() == null;
            }
            case 1: {
                return pSSubSysBase.getCreateMan() == null;
            }
            case 2: {
                return pSSubSysBase.getDEModels() == null;
            }
            case 3: {
                return pSSubSysBase.getMemo() == null;
            }
            case 4: {
                return pSSubSysBase.getPSDevSlnSysId() == null;
            }
            case 5: {
                return pSSubSysBase.getPSSFId() == null;
            }
            case 6: {
                return pSSubSysBase.getPSSFName() == null;
            }
            case 7: {
                return pSSubSysBase.getPSSubSysId() == null;
            }
            case 8: {
                return pSSubSysBase.getPSSubSysName() == null;
            }
            case 9: {
                return pSSubSysBase.getPSSystemId() == null;
            }
            case 10: {
                return pSSubSysBase.getSFFWFlag() == null;
            }
            case 11: {
                return pSSubSysBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSubSysBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSubSysBase.getValidFlag() == null;
            }
            case 14: {
                return pSSubSysBase.getVersion() == null;
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
        return PSSubSysBase.contains(this, n);
    }

    private static boolean contains(PSSubSysBase pSSubSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysBase.isCreateDateDirty();
            }
            case 1: {
                return pSSubSysBase.isCreateManDirty();
            }
            case 2: {
                return pSSubSysBase.isDEModelsDirty();
            }
            case 3: {
                return pSSubSysBase.isMemoDirty();
            }
            case 4: {
                return pSSubSysBase.isPSDevSlnSysIdDirty();
            }
            case 5: {
                return pSSubSysBase.isPSSFIdDirty();
            }
            case 6: {
                return pSSubSysBase.isPSSFNameDirty();
            }
            case 7: {
                return pSSubSysBase.isPSSubSysIdDirty();
            }
            case 8: {
                return pSSubSysBase.isPSSubSysNameDirty();
            }
            case 9: {
                return pSSubSysBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSSubSysBase.isSFFWFlagDirty();
            }
            case 11: {
                return pSSubSysBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSubSysBase.isUpdateManDirty();
            }
            case 13: {
                return pSSubSysBase.isValidFlagDirty();
            }
            case 14: {
                return pSSubSysBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysBase pSSubSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysBase.getDEModels() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demodels", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getDEModels()), (boolean)false);
        }
        if (bl || pSSubSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubSysBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSubSysBase.getSFFWFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sffwflag", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getSFFWFlag()), (boolean)false);
        }
        if (bl || pSSubSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSubSysBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSubSysBase.getJSONValue((Object)pSSubSysBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysBase pSSubSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysBase.getCreateDate() != null) {
            object = pSSubSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysBase.getCreateMan() != null) {
            object = pSSubSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getDEModels() != null) {
            object = pSSubSysBase.getDEModels();
            xmlNode.setAttribute(FIELD_DEMODELS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getMemo() != null) {
            object = pSSubSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSDevSlnSysId() != null) {
            object = pSSubSysBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSSFId() != null) {
            object = pSSubSysBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSSFName() != null) {
            object = pSSubSysBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSSubSysId() != null) {
            object = pSSubSysBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSSubSysName() != null) {
            object = pSSubSysBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getPSSystemId() != null) {
            object = pSSubSysBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getSFFWFlag() != null) {
            object = pSSubSysBase.getSFFWFlag();
            xmlNode.setAttribute(FIELD_SFFWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysBase.getUpdateDate() != null) {
            object = pSSubSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysBase.getUpdateMan() != null) {
            object = pSSubSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysBase.getValidFlag() != null) {
            object = pSSubSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysBase.getVersion() != null) {
            object = pSSubSysBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysBase pSSubSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysBase.isCreateDateDirty() && (bl || pSSubSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysBase.getCreateDate());
        }
        if (pSSubSysBase.isCreateManDirty() && (bl || pSSubSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysBase.getCreateMan());
        }
        if (pSSubSysBase.isDEModelsDirty() && (bl || pSSubSysBase.getDEModels() != null)) {
            iDataObject.set(FIELD_DEMODELS, (Object)pSSubSysBase.getDEModels());
        }
        if (pSSubSysBase.isMemoDirty() && (bl || pSSubSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysBase.getMemo());
        }
        if (pSSubSysBase.isPSDevSlnSysIdDirty() && (bl || pSSubSysBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSubSysBase.getPSDevSlnSysId());
        }
        if (pSSubSysBase.isPSSFIdDirty() && (bl || pSSubSysBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSubSysBase.getPSSFId());
        }
        if (pSSubSysBase.isPSSFNameDirty() && (bl || pSSubSysBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSubSysBase.getPSSFName());
        }
        if (pSSubSysBase.isPSSubSysIdDirty() && (bl || pSSubSysBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubSysBase.getPSSubSysId());
        }
        if (pSSubSysBase.isPSSubSysNameDirty() && (bl || pSSubSysBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubSysBase.getPSSubSysName());
        }
        if (pSSubSysBase.isPSSystemIdDirty() && (bl || pSSubSysBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSubSysBase.getPSSystemId());
        }
        if (pSSubSysBase.isSFFWFlagDirty() && (bl || pSSubSysBase.getSFFWFlag() != null)) {
            iDataObject.set(FIELD_SFFWFLAG, (Object)pSSubSysBase.getSFFWFlag());
        }
        if (pSSubSysBase.isUpdateDateDirty() && (bl || pSSubSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysBase.getUpdateDate());
        }
        if (pSSubSysBase.isUpdateManDirty() && (bl || pSSubSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysBase.getUpdateMan());
        }
        if (pSSubSysBase.isValidFlagDirty() && (bl || pSSubSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysBase.getValidFlag());
        }
        if (pSSubSysBase.isVersionDirty() && (bl || pSSubSysBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSubSysBase.getVersion());
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
        return PSSubSysBase.remove(this, n);
    }

    private static boolean remove(PSSubSysBase pSSubSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSubSysBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSubSysBase.resetDEModels();
                return true;
            }
            case 3: {
                pSSubSysBase.resetMemo();
                return true;
            }
            case 4: {
                pSSubSysBase.resetPSDevSlnSysId();
                return true;
            }
            case 5: {
                pSSubSysBase.resetPSSFId();
                return true;
            }
            case 6: {
                pSSubSysBase.resetPSSFName();
                return true;
            }
            case 7: {
                pSSubSysBase.resetPSSubSysId();
                return true;
            }
            case 8: {
                pSSubSysBase.resetPSSubSysName();
                return true;
            }
            case 9: {
                pSSubSysBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSSubSysBase.resetSFFWFlag();
                return true;
            }
            case 11: {
                pSSubSysBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSubSysBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSubSysBase.resetValidFlag();
                return true;
            }
            case 14: {
                pSSubSysBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubApp> getPSSubApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubApps();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        PSSubAppService pSSubAppService = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubAppsLock;
        synchronized (n) {
            if (this.pssubapps == null) {
                this.pssubapps = pSSubAppService.selectByPSSubSys(this);
            }
            return this.pssubapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSF> getPSSubSysSFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSFs();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        PSSubSysSFService pSSubSysSFService = (PSSubSysSFService)ServiceGlobal.getService(PSSubSysSFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSFsLock;
        synchronized (n) {
            if (this.pssubsyssfs == null) {
                this.pssubsyssfs = pSSubSysSFService.selectByPSSubSys(this);
            }
            return this.pssubsyssfs;
        }
    }

    private PSSubSysBase getProxyEntity() {
        return this.proxyPSSubSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysBase) {
            this.proxyPSSubSysBase = (PSSubSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEMODELS, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSSFID, 5);
        fieldIndexMap.put(FIELD_PSSFNAME, 6);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 7);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_SFFWFLAG, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
        fieldIndexMap.put(FIELD_VERSION, 14);
    }
}

