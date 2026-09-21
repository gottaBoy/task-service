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
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjb;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPubObjParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPubObjParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAME = "OBJNAME";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PSSFPUBOBJID = "PSSFPUBOBJID";
    public static final String FIELD_PSSFPUBOBJNAME = "PSSFPUBOBJNAME";
    public static final String FIELD_PSSFPUBOBJPARAMID = "PSSFPUBOBJPARAMID";
    public static final String FIELD_PSSFPUBOBJPARAMNAME = "PSSFPUBOBJPARAMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OBJNAME = 4;
    private static final int INDEX_PARAMTYPE = 5;
    private static final int INDEX_PSSFPUBOBJID = 6;
    private static final int INDEX_PSSFPUBOBJNAME = 7;
    private static final int INDEX_PSSFPUBOBJPARAMID = 8;
    private static final int INDEX_PSSFPUBOBJPARAMNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPubObjParamBase proxyPSSFPubObjParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnameDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean pssfpubobjidDirtyFlag = false;
    private boolean pssfpubobjnameDirtyFlag = false;
    private boolean pssfpubobjparamidDirtyFlag = false;
    private boolean pssfpubobjparamnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="objname")
    private String objname;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="pssfpubobjid")
    private String pssfpubobjid;
    @Column(name="pssfpubobjname")
    private String pssfpubobjname;
    @Column(name="pssfpubobjparamid")
    private String pssfpubobjparamid;
    @Column(name="pssfpubobjparamname")
    private String pssfpubobjparamname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPssfpubobjLock = new Integer(1);
    private PSSFPubOjb pssfpubobj = null;

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

    public void setObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objname = string;
        this.objnameDirtyFlag = true;
    }

    public String getObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjName();
        }
        return this.objname;
    }

    public boolean isObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjNameDirty();
        }
        return this.objnameDirtyFlag;
    }

    public void resetObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjName();
            return;
        }
        this.objnameDirtyFlag = false;
        this.objname = null;
    }

    public void setParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtype = string;
        this.paramtypeDirtyFlag = true;
    }

    public String getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setPSSFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjid = string;
        this.pssfpubobjidDirtyFlag = true;
    }

    public String getPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjId();
        }
        return this.pssfpubobjid;
    }

    public boolean isPSSFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjIdDirty();
        }
        return this.pssfpubobjidDirtyFlag;
    }

    public void resetPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjId();
            return;
        }
        this.pssfpubobjidDirtyFlag = false;
        this.pssfpubobjid = null;
    }

    public void setPSSFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjname = string;
        this.pssfpubobjnameDirtyFlag = true;
    }

    public String getPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjName();
        }
        return this.pssfpubobjname;
    }

    public boolean isPSSFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjNameDirty();
        }
        return this.pssfpubobjnameDirtyFlag;
    }

    public void resetPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjName();
            return;
        }
        this.pssfpubobjnameDirtyFlag = false;
        this.pssfpubobjname = null;
    }

    public void setPSSFPubObjParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjparamid = string;
        this.pssfpubobjparamidDirtyFlag = true;
    }

    public String getPSSFPubObjParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjParamId();
        }
        return this.pssfpubobjparamid;
    }

    public boolean isPSSFPubObjParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjParamIdDirty();
        }
        return this.pssfpubobjparamidDirtyFlag;
    }

    public void resetPSSFPubObjParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjParamId();
            return;
        }
        this.pssfpubobjparamidDirtyFlag = false;
        this.pssfpubobjparamid = null;
    }

    public void setPSSFPubObjParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjparamname = string;
        this.pssfpubobjparamnameDirtyFlag = true;
    }

    public String getPSSFPubObjParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjParamName();
        }
        return this.pssfpubobjparamname;
    }

    public boolean isPSSFPubObjParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjParamNameDirty();
        }
        return this.pssfpubobjparamnameDirtyFlag;
    }

    public void resetPSSFPubObjParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjParamName();
            return;
        }
        this.pssfpubobjparamnameDirtyFlag = false;
        this.pssfpubobjparamname = null;
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

    protected void onReset() {
        PSSFPubObjParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPubObjParamBase pSSFPubObjParamBase) {
        pSSFPubObjParamBase.resetCreateDate();
        pSSFPubObjParamBase.resetCreateMan();
        pSSFPubObjParamBase.resetLogicName();
        pSSFPubObjParamBase.resetMemo();
        pSSFPubObjParamBase.resetObjName();
        pSSFPubObjParamBase.resetParamType();
        pSSFPubObjParamBase.resetPSSFPubObjId();
        pSSFPubObjParamBase.resetPSSFPubObjName();
        pSSFPubObjParamBase.resetPSSFPubObjParamId();
        pSSFPubObjParamBase.resetPSSFPubObjParamName();
        pSSFPubObjParamBase.resetUpdateDate();
        pSSFPubObjParamBase.resetUpdateMan();
        pSSFPubObjParamBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isObjNameDirty()) {
            hashMap.put(FIELD_OBJNAME, this.getObjName());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPSSFPubObjIdDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJID, this.getPSSFPubObjId());
        }
        if (!bl || this.isPSSFPubObjNameDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJNAME, this.getPSSFPubObjName());
        }
        if (!bl || this.isPSSFPubObjParamIdDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJPARAMID, this.getPSSFPubObjParamId());
        }
        if (!bl || this.isPSSFPubObjParamNameDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJPARAMNAME, this.getPSSFPubObjParamName());
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
        return PSSFPubObjParamBase.get(this, n);
    }

    private static Object get(PSSFPubObjParamBase pSSFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubObjParamBase.getCreateDate();
            }
            case 1: {
                return pSSFPubObjParamBase.getCreateMan();
            }
            case 2: {
                return pSSFPubObjParamBase.getLogicName();
            }
            case 3: {
                return pSSFPubObjParamBase.getMemo();
            }
            case 4: {
                return pSSFPubObjParamBase.getObjName();
            }
            case 5: {
                return pSSFPubObjParamBase.getParamType();
            }
            case 6: {
                return pSSFPubObjParamBase.getPSSFPubObjId();
            }
            case 7: {
                return pSSFPubObjParamBase.getPSSFPubObjName();
            }
            case 8: {
                return pSSFPubObjParamBase.getPSSFPubObjParamId();
            }
            case 9: {
                return pSSFPubObjParamBase.getPSSFPubObjParamName();
            }
            case 10: {
                return pSSFPubObjParamBase.getUpdateDate();
            }
            case 11: {
                return pSSFPubObjParamBase.getUpdateMan();
            }
            case 12: {
                return pSSFPubObjParamBase.getValidFlag();
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
        PSSFPubObjParamBase.set(this, n, object);
    }

    private static void set(PSSFPubObjParamBase pSSFPubObjParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPubObjParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPubObjParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPubObjParamBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPubObjParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPubObjParamBase.setObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPubObjParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPubObjParamBase.setPSSFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPubObjParamBase.setPSSFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPubObjParamBase.setPSSFPubObjParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPubObjParamBase.setPSSFPubObjParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPubObjParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSFPubObjParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPubObjParamBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFPubObjParamBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPubObjParamBase pSSFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubObjParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPubObjParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPubObjParamBase.getLogicName() == null;
            }
            case 3: {
                return pSSFPubObjParamBase.getMemo() == null;
            }
            case 4: {
                return pSSFPubObjParamBase.getObjName() == null;
            }
            case 5: {
                return pSSFPubObjParamBase.getParamType() == null;
            }
            case 6: {
                return pSSFPubObjParamBase.getPSSFPubObjId() == null;
            }
            case 7: {
                return pSSFPubObjParamBase.getPSSFPubObjName() == null;
            }
            case 8: {
                return pSSFPubObjParamBase.getPSSFPubObjParamId() == null;
            }
            case 9: {
                return pSSFPubObjParamBase.getPSSFPubObjParamName() == null;
            }
            case 10: {
                return pSSFPubObjParamBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSFPubObjParamBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSFPubObjParamBase.getValidFlag() == null;
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
        return PSSFPubObjParamBase.contains(this, n);
    }

    private static boolean contains(PSSFPubObjParamBase pSSFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubObjParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPubObjParamBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPubObjParamBase.isLogicNameDirty();
            }
            case 3: {
                return pSSFPubObjParamBase.isMemoDirty();
            }
            case 4: {
                return pSSFPubObjParamBase.isObjNameDirty();
            }
            case 5: {
                return pSSFPubObjParamBase.isParamTypeDirty();
            }
            case 6: {
                return pSSFPubObjParamBase.isPSSFPubObjIdDirty();
            }
            case 7: {
                return pSSFPubObjParamBase.isPSSFPubObjNameDirty();
            }
            case 8: {
                return pSSFPubObjParamBase.isPSSFPubObjParamIdDirty();
            }
            case 9: {
                return pSSFPubObjParamBase.isPSSFPubObjParamNameDirty();
            }
            case 10: {
                return pSSFPubObjParamBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSFPubObjParamBase.isUpdateManDirty();
            }
            case 12: {
                return pSSFPubObjParamBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPubObjParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPubObjParamBase pSSFPubObjParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPubObjParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objname", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getObjName()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjid", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getPSSFPubObjId()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjname", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getPSSFPubObjName()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjparamid", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getPSSFPubObjParamId()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjparamname", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getPSSFPubObjParamName()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFPubObjParamBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFPubObjParamBase.getJSONValue((Object)pSSFPubObjParamBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPubObjParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPubObjParamBase pSSFPubObjParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPubObjParamBase.getCreateDate() != null) {
            object = pSSFPubObjParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPubObjParamBase.getCreateMan() != null) {
            object = pSSFPubObjParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getLogicName() != null) {
            object = pSSFPubObjParamBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getMemo() != null) {
            object = pSSFPubObjParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getObjName() != null) {
            object = pSSFPubObjParamBase.getObjName();
            xmlNode.setAttribute(FIELD_OBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getParamType() != null) {
            object = pSSFPubObjParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjId() != null) {
            object = pSSFPubObjParamBase.getPSSFPubObjId();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjName() != null) {
            object = pSSFPubObjParamBase.getPSSFPubObjName();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjParamId() != null) {
            object = pSSFPubObjParamBase.getPSSFPubObjParamId();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getPSSFPubObjParamName() != null) {
            object = pSSFPubObjParamBase.getPSSFPubObjParamName();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getUpdateDate() != null) {
            object = pSSFPubObjParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPubObjParamBase.getUpdateMan() != null) {
            object = pSSFPubObjParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubObjParamBase.getValidFlag() != null) {
            object = pSSFPubObjParamBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPubObjParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPubObjParamBase pSSFPubObjParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPubObjParamBase.isCreateDateDirty() && (bl || pSSFPubObjParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPubObjParamBase.getCreateDate());
        }
        if (pSSFPubObjParamBase.isCreateManDirty() && (bl || pSSFPubObjParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPubObjParamBase.getCreateMan());
        }
        if (pSSFPubObjParamBase.isLogicNameDirty() && (bl || pSSFPubObjParamBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSFPubObjParamBase.getLogicName());
        }
        if (pSSFPubObjParamBase.isMemoDirty() && (bl || pSSFPubObjParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPubObjParamBase.getMemo());
        }
        if (pSSFPubObjParamBase.isObjNameDirty() && (bl || pSSFPubObjParamBase.getObjName() != null)) {
            iDataObject.set(FIELD_OBJNAME, (Object)pSSFPubObjParamBase.getObjName());
        }
        if (pSSFPubObjParamBase.isParamTypeDirty() && (bl || pSSFPubObjParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSSFPubObjParamBase.getParamType());
        }
        if (pSSFPubObjParamBase.isPSSFPubObjIdDirty() && (bl || pSSFPubObjParamBase.getPSSFPubObjId() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJID, (Object)pSSFPubObjParamBase.getPSSFPubObjId());
        }
        if (pSSFPubObjParamBase.isPSSFPubObjNameDirty() && (bl || pSSFPubObjParamBase.getPSSFPubObjName() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJNAME, (Object)pSSFPubObjParamBase.getPSSFPubObjName());
        }
        if (pSSFPubObjParamBase.isPSSFPubObjParamIdDirty() && (bl || pSSFPubObjParamBase.getPSSFPubObjParamId() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJPARAMID, (Object)pSSFPubObjParamBase.getPSSFPubObjParamId());
        }
        if (pSSFPubObjParamBase.isPSSFPubObjParamNameDirty() && (bl || pSSFPubObjParamBase.getPSSFPubObjParamName() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJPARAMNAME, (Object)pSSFPubObjParamBase.getPSSFPubObjParamName());
        }
        if (pSSFPubObjParamBase.isUpdateDateDirty() && (bl || pSSFPubObjParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPubObjParamBase.getUpdateDate());
        }
        if (pSSFPubObjParamBase.isUpdateManDirty() && (bl || pSSFPubObjParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPubObjParamBase.getUpdateMan());
        }
        if (pSSFPubObjParamBase.isValidFlagDirty() && (bl || pSSFPubObjParamBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFPubObjParamBase.getValidFlag());
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
        return PSSFPubObjParamBase.remove(this, n);
    }

    private static boolean remove(PSSFPubObjParamBase pSSFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPubObjParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPubObjParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPubObjParamBase.resetLogicName();
                return true;
            }
            case 3: {
                pSSFPubObjParamBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFPubObjParamBase.resetObjName();
                return true;
            }
            case 5: {
                pSSFPubObjParamBase.resetParamType();
                return true;
            }
            case 6: {
                pSSFPubObjParamBase.resetPSSFPubObjId();
                return true;
            }
            case 7: {
                pSSFPubObjParamBase.resetPSSFPubObjName();
                return true;
            }
            case 8: {
                pSSFPubObjParamBase.resetPSSFPubObjParamId();
                return true;
            }
            case 9: {
                pSSFPubObjParamBase.resetPSSFPubObjParamName();
                return true;
            }
            case 10: {
                pSSFPubObjParamBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSFPubObjParamBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSFPubObjParamBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPubOjb getPssfpubobj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssfpubobj();
        }
        if (this.getPSSFPubObjId() == null) {
            return null;
        }
        Integer n = this.objPssfpubobjLock;
        synchronized (n) {
            if (this.pssfpubobj != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPubObjId(), (Object)this.pssfpubobj.getPSSFPubObjId()) != 0L) {
                this.pssfpubobj = null;
            }
            if (this.pssfpubobj == null) {
                PSSFPubOjb pSSFPubOjb = new PSSFPubOjb();
                pSSFPubOjb.setPSSFPubObjId(this.getPSSFPubObjId());
                PSSFPubOjbService pSSFPubOjbService = (PSSFPubOjbService)ServiceGlobal.getService(PSSFPubOjbService.class, (SessionFactory)this.getSessionFactory());
                pSSFPubOjbService.autoGet((IEntity)pSSFPubOjb);
                this.pssfpubobj = pSSFPubOjb;
            }
            return this.pssfpubobj;
        }
    }

    private PSSFPubObjParamBase getProxyEntity() {
        return this.proxyPSSFPubObjParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPubObjParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPubObjParamBase) {
            this.proxyPSSFPubObjParamBase = (PSSFPubObjParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPubObjParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OBJNAME, 4);
        fieldIndexMap.put(FIELD_PARAMTYPE, 5);
        fieldIndexMap.put(FIELD_PSSFPUBOBJID, 6);
        fieldIndexMap.put(FIELD_PSSFPUBOBJNAME, 7);
        fieldIndexMap.put(FIELD_PSSFPUBOBJPARAMID, 8);
        fieldIndexMap.put(FIELD_PSSFPUBOBJPARAMNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

