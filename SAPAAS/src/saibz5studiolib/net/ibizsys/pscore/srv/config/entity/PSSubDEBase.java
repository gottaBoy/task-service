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
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubDEBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULECODENAME = "MODULECODENAME";
    public static final String FIELD_MODULENAME = "MODULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSUBDEID = "PSSUBDEID";
    public static final String FIELD_PSSUBDENAME = "PSSUBDENAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODULECODENAME = 5;
    private static final int INDEX_MODULENAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSSUBDEID = 8;
    private static final int INDEX_PSSUBDENAME = 9;
    private static final int INDEX_PSSUBSYSID = 10;
    private static final int INDEX_PSSUBSYSNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubDEBase proxyPSSubDEBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modulecodenameDirtyFlag = false;
    private boolean modulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssubdeidDirtyFlag = false;
    private boolean pssubdenameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modulecodename")
    private String modulecodename;
    @Column(name="modulename")
    private String modulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssubdeid")
    private String pssubdeid;
    @Column(name="pssubdename")
    private String pssubdename;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setModuleCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulecodename = string;
        this.modulecodenameDirtyFlag = true;
    }

    public String getModuleCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleCodeName();
        }
        return this.modulecodename;
    }

    public boolean isModuleCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleCodeNameDirty();
        }
        return this.modulecodenameDirtyFlag;
    }

    public void resetModuleCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleCodeName();
            return;
        }
        this.modulecodenameDirtyFlag = false;
        this.modulecodename = null;
    }

    public void setModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulename = string;
        this.modulenameDirtyFlag = true;
    }

    public String getModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleName();
        }
        return this.modulename;
    }

    public boolean isModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleNameDirty();
        }
        return this.modulenameDirtyFlag;
    }

    public void resetModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleName();
            return;
        }
        this.modulenameDirtyFlag = false;
        this.modulename = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSSubDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeid = string;
        this.pssubdeidDirtyFlag = true;
    }

    public String getPSSubDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEId();
        }
        return this.pssubdeid;
    }

    public boolean isPSSubDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEIdDirty();
        }
        return this.pssubdeidDirtyFlag;
    }

    public void resetPSSubDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEId();
            return;
        }
        this.pssubdeidDirtyFlag = false;
        this.pssubdeid = null;
    }

    public void setPSSubDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdename = string;
        this.pssubdenameDirtyFlag = true;
    }

    public String getPSSubDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEName();
        }
        return this.pssubdename;
    }

    public boolean isPSSubDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDENameDirty();
        }
        return this.pssubdenameDirtyFlag;
    }

    public void resetPSSubDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEName();
            return;
        }
        this.pssubdenameDirtyFlag = false;
        this.pssubdename = null;
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
        PSSubDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubDEBase pSSubDEBase) {
        pSSubDEBase.resetCodeName();
        pSSubDEBase.resetCreateDate();
        pSSubDEBase.resetCreateMan();
        pSSubDEBase.resetLogicName();
        pSSubDEBase.resetMemo();
        pSSubDEBase.resetModuleCodeName();
        pSSubDEBase.resetModuleName();
        pSSubDEBase.resetPSDEId();
        pSSubDEBase.resetPSSubDEId();
        pSSubDEBase.resetPSSubDEName();
        pSSubDEBase.resetPSSubSysId();
        pSSubDEBase.resetPSSubSysName();
        pSSubDEBase.resetUpdateDate();
        pSSubDEBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModuleCodeNameDirty()) {
            hashMap.put(FIELD_MODULECODENAME, this.getModuleCodeName());
        }
        if (!bl || this.isModuleNameDirty()) {
            hashMap.put(FIELD_MODULENAME, this.getModuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSubDEIdDirty()) {
            hashMap.put(FIELD_PSSUBDEID, this.getPSSubDEId());
        }
        if (!bl || this.isPSSubDENameDirty()) {
            hashMap.put(FIELD_PSSUBDENAME, this.getPSSubDEName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
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
        return PSSubDEBase.get(this, n);
    }

    private static Object get(PSSubDEBase pSSubDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEBase.getCodeName();
            }
            case 1: {
                return pSSubDEBase.getCreateDate();
            }
            case 2: {
                return pSSubDEBase.getCreateMan();
            }
            case 3: {
                return pSSubDEBase.getLogicName();
            }
            case 4: {
                return pSSubDEBase.getMemo();
            }
            case 5: {
                return pSSubDEBase.getModuleCodeName();
            }
            case 6: {
                return pSSubDEBase.getModuleName();
            }
            case 7: {
                return pSSubDEBase.getPSDEId();
            }
            case 8: {
                return pSSubDEBase.getPSSubDEId();
            }
            case 9: {
                return pSSubDEBase.getPSSubDEName();
            }
            case 10: {
                return pSSubDEBase.getPSSubSysId();
            }
            case 11: {
                return pSSubDEBase.getPSSubSysName();
            }
            case 12: {
                return pSSubDEBase.getUpdateDate();
            }
            case 13: {
                return pSSubDEBase.getUpdateMan();
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
        PSSubDEBase.set(this, n, object);
    }

    private static void set(PSSubDEBase pSSubDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubDEBase.setModuleCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubDEBase.setModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubDEBase.setPSSubDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubDEBase.setPSSubDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubDEBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubDEBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSubDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSubDEBase.isNull(this, n);
    }

    private static boolean isNull(PSSubDEBase pSSubDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEBase.getCodeName() == null;
            }
            case 1: {
                return pSSubDEBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubDEBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubDEBase.getLogicName() == null;
            }
            case 4: {
                return pSSubDEBase.getMemo() == null;
            }
            case 5: {
                return pSSubDEBase.getModuleCodeName() == null;
            }
            case 6: {
                return pSSubDEBase.getModuleName() == null;
            }
            case 7: {
                return pSSubDEBase.getPSDEId() == null;
            }
            case 8: {
                return pSSubDEBase.getPSSubDEId() == null;
            }
            case 9: {
                return pSSubDEBase.getPSSubDEName() == null;
            }
            case 10: {
                return pSSubDEBase.getPSSubSysId() == null;
            }
            case 11: {
                return pSSubDEBase.getPSSubSysName() == null;
            }
            case 12: {
                return pSSubDEBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSubDEBase.getUpdateMan() == null;
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
        return PSSubDEBase.contains(this, n);
    }

    private static boolean contains(PSSubDEBase pSSubDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEBase.isCodeNameDirty();
            }
            case 1: {
                return pSSubDEBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubDEBase.isCreateManDirty();
            }
            case 3: {
                return pSSubDEBase.isLogicNameDirty();
            }
            case 4: {
                return pSSubDEBase.isMemoDirty();
            }
            case 5: {
                return pSSubDEBase.isModuleCodeNameDirty();
            }
            case 6: {
                return pSSubDEBase.isModuleNameDirty();
            }
            case 7: {
                return pSSubDEBase.isPSDEIdDirty();
            }
            case 8: {
                return pSSubDEBase.isPSSubDEIdDirty();
            }
            case 9: {
                return pSSubDEBase.isPSSubDENameDirty();
            }
            case 10: {
                return pSSubDEBase.isPSSubSysIdDirty();
            }
            case 11: {
                return pSSubDEBase.isPSSubSysNameDirty();
            }
            case 12: {
                return pSSubDEBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSubDEBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubDEBase pSSubDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubDEBase.getModuleCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulecodename", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getModuleCodeName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulename", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getModuleName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSubDEBase.getPSSubDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeid", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getPSSubDEId()), (boolean)false);
        }
        if (bl || pSSubDEBase.getPSSubDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdename", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getPSSubDEName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubDEBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubDEBase.getJSONValue((Object)pSSubDEBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubDEBase pSSubDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubDEBase.getCodeName() != null) {
            object = pSSubDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getCreateDate() != null) {
            object = pSSubDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEBase.getCreateMan() != null) {
            object = pSSubDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getLogicName() != null) {
            object = pSSubDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getMemo() != null) {
            object = pSSubDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getModuleCodeName() != null) {
            object = pSSubDEBase.getModuleCodeName();
            xmlNode.setAttribute(FIELD_MODULECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getModuleName() != null) {
            object = pSSubDEBase.getModuleName();
            xmlNode.setAttribute(FIELD_MODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getPSDEId() != null) {
            object = pSSubDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getPSSubDEId() != null) {
            object = pSSubDEBase.getPSSubDEId();
            xmlNode.setAttribute(FIELD_PSSUBDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getPSSubDEName() != null) {
            object = pSSubDEBase.getPSSubDEName();
            xmlNode.setAttribute(FIELD_PSSUBDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getPSSubSysId() != null) {
            object = pSSubDEBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getPSSubSysName() != null) {
            object = pSSubDEBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEBase.getUpdateDate() != null) {
            object = pSSubDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEBase.getUpdateMan() != null) {
            object = pSSubDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubDEBase pSSubDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubDEBase.isCodeNameDirty() && (bl || pSSubDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubDEBase.getCodeName());
        }
        if (pSSubDEBase.isCreateDateDirty() && (bl || pSSubDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubDEBase.getCreateDate());
        }
        if (pSSubDEBase.isCreateManDirty() && (bl || pSSubDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubDEBase.getCreateMan());
        }
        if (pSSubDEBase.isLogicNameDirty() && (bl || pSSubDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSubDEBase.getLogicName());
        }
        if (pSSubDEBase.isMemoDirty() && (bl || pSSubDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubDEBase.getMemo());
        }
        if (pSSubDEBase.isModuleCodeNameDirty() && (bl || pSSubDEBase.getModuleCodeName() != null)) {
            iDataObject.set(FIELD_MODULECODENAME, (Object)pSSubDEBase.getModuleCodeName());
        }
        if (pSSubDEBase.isModuleNameDirty() && (bl || pSSubDEBase.getModuleName() != null)) {
            iDataObject.set(FIELD_MODULENAME, (Object)pSSubDEBase.getModuleName());
        }
        if (pSSubDEBase.isPSDEIdDirty() && (bl || pSSubDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSubDEBase.getPSDEId());
        }
        if (pSSubDEBase.isPSSubDEIdDirty() && (bl || pSSubDEBase.getPSSubDEId() != null)) {
            iDataObject.set(FIELD_PSSUBDEID, (Object)pSSubDEBase.getPSSubDEId());
        }
        if (pSSubDEBase.isPSSubDENameDirty() && (bl || pSSubDEBase.getPSSubDEName() != null)) {
            iDataObject.set(FIELD_PSSUBDENAME, (Object)pSSubDEBase.getPSSubDEName());
        }
        if (pSSubDEBase.isPSSubSysIdDirty() && (bl || pSSubDEBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubDEBase.getPSSubSysId());
        }
        if (pSSubDEBase.isPSSubSysNameDirty() && (bl || pSSubDEBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubDEBase.getPSSubSysName());
        }
        if (pSSubDEBase.isUpdateDateDirty() && (bl || pSSubDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubDEBase.getUpdateDate());
        }
        if (pSSubDEBase.isUpdateManDirty() && (bl || pSSubDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubDEBase.getUpdateMan());
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
        return PSSubDEBase.remove(this, n);
    }

    private static boolean remove(PSSubDEBase pSSubDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSubDEBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubDEBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubDEBase.resetLogicName();
                return true;
            }
            case 4: {
                pSSubDEBase.resetMemo();
                return true;
            }
            case 5: {
                pSSubDEBase.resetModuleCodeName();
                return true;
            }
            case 6: {
                pSSubDEBase.resetModuleName();
                return true;
            }
            case 7: {
                pSSubDEBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSSubDEBase.resetPSSubDEId();
                return true;
            }
            case 9: {
                pSSubDEBase.resetPSSubDEName();
                return true;
            }
            case 10: {
                pSSubDEBase.resetPSSubSysId();
                return true;
            }
            case 11: {
                pSSubDEBase.resetPSSubSysName();
                return true;
            }
            case 12: {
                pSSubDEBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSubDEBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet(pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSubDEBase getProxyEntity() {
        return this.proxyPSSubDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubDEBase) {
            this.proxyPSSubDEBase = (PSSubDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODULECODENAME, 5);
        fieldIndexMap.put(FIELD_MODULENAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSSUBDEID, 8);
        fieldIndexMap.put(FIELD_PSSUBDENAME, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

