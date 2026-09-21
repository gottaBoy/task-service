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
import net.ibizsys.pscore.srv.config.entity.PSPFPubObj;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubObjParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPubObjParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAME = "OBJNAME";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PSPFPUBOBJID = "PSPFPUBOBJID";
    public static final String FIELD_PSPFPUBOBJNAME = "PSPFPUBOBJNAME";
    public static final String FIELD_PSPFPUBOBJPARAMID = "PSPFPUBOBJPARAMID";
    public static final String FIELD_PSPFPUBOBJPARAMNAME = "PSPFPUBOBJPARAMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OBJNAME = 4;
    private static final int INDEX_PARAMTYPE = 5;
    private static final int INDEX_PSPFPUBOBJID = 6;
    private static final int INDEX_PSPFPUBOBJNAME = 7;
    private static final int INDEX_PSPFPUBOBJPARAMID = 8;
    private static final int INDEX_PSPFPUBOBJPARAMNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPubObjParamBase proxyPSPFPubObjParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnameDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean pspfpubobjidDirtyFlag = false;
    private boolean pspfpubobjnameDirtyFlag = false;
    private boolean pspfpubobjparamidDirtyFlag = false;
    private boolean pspfpubobjparamnameDirtyFlag = false;
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
    @Column(name="pspfpubobjid")
    private String pspfpubobjid;
    @Column(name="pspfpubobjname")
    private String pspfpubobjname;
    @Column(name="pspfpubobjparamid")
    private String pspfpubobjparamid;
    @Column(name="pspfpubobjparamname")
    private String pspfpubobjparamname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPspfpubobjLock = new Integer(1);
    private PSPFPubObj pspfpubobj = null;

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

    public void setPSPFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjid = string;
        this.pspfpubobjidDirtyFlag = true;
    }

    public String getPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjId();
        }
        return this.pspfpubobjid;
    }

    public boolean isPSPFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjIdDirty();
        }
        return this.pspfpubobjidDirtyFlag;
    }

    public void resetPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjId();
            return;
        }
        this.pspfpubobjidDirtyFlag = false;
        this.pspfpubobjid = null;
    }

    public void setPSPFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjname = string;
        this.pspfpubobjnameDirtyFlag = true;
    }

    public String getPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjName();
        }
        return this.pspfpubobjname;
    }

    public boolean isPSPFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjNameDirty();
        }
        return this.pspfpubobjnameDirtyFlag;
    }

    public void resetPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjName();
            return;
        }
        this.pspfpubobjnameDirtyFlag = false;
        this.pspfpubobjname = null;
    }

    public void setPSPFPubObjParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjparamid = string;
        this.pspfpubobjparamidDirtyFlag = true;
    }

    public String getPSPFPubObjParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjParamId();
        }
        return this.pspfpubobjparamid;
    }

    public boolean isPSPFPubObjParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjParamIdDirty();
        }
        return this.pspfpubobjparamidDirtyFlag;
    }

    public void resetPSPFPubObjParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjParamId();
            return;
        }
        this.pspfpubobjparamidDirtyFlag = false;
        this.pspfpubobjparamid = null;
    }

    public void setPSPFPubObjParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjparamname = string;
        this.pspfpubobjparamnameDirtyFlag = true;
    }

    public String getPSPFPubObjParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjParamName();
        }
        return this.pspfpubobjparamname;
    }

    public boolean isPSPFPubObjParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjParamNameDirty();
        }
        return this.pspfpubobjparamnameDirtyFlag;
    }

    public void resetPSPFPubObjParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjParamName();
            return;
        }
        this.pspfpubobjparamnameDirtyFlag = false;
        this.pspfpubobjparamname = null;
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
        PSPFPubObjParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPubObjParamBase pSPFPubObjParamBase) {
        pSPFPubObjParamBase.resetCreateDate();
        pSPFPubObjParamBase.resetCreateMan();
        pSPFPubObjParamBase.resetLogicName();
        pSPFPubObjParamBase.resetMemo();
        pSPFPubObjParamBase.resetObjName();
        pSPFPubObjParamBase.resetParamType();
        pSPFPubObjParamBase.resetPSPFPubObjId();
        pSPFPubObjParamBase.resetPSPFPubObjName();
        pSPFPubObjParamBase.resetPSPFPubObjParamId();
        pSPFPubObjParamBase.resetPSPFPubObjParamName();
        pSPFPubObjParamBase.resetUpdateDate();
        pSPFPubObjParamBase.resetUpdateMan();
        pSPFPubObjParamBase.resetValidFlag();
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
        if (!bl || this.isPSPFPubObjIdDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJID, this.getPSPFPubObjId());
        }
        if (!bl || this.isPSPFPubObjNameDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJNAME, this.getPSPFPubObjName());
        }
        if (!bl || this.isPSPFPubObjParamIdDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJPARAMID, this.getPSPFPubObjParamId());
        }
        if (!bl || this.isPSPFPubObjParamNameDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJPARAMNAME, this.getPSPFPubObjParamName());
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
        return PSPFPubObjParamBase.get(this, n);
    }

    private static Object get(PSPFPubObjParamBase pSPFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjParamBase.getCreateDate();
            }
            case 1: {
                return pSPFPubObjParamBase.getCreateMan();
            }
            case 2: {
                return pSPFPubObjParamBase.getLogicName();
            }
            case 3: {
                return pSPFPubObjParamBase.getMemo();
            }
            case 4: {
                return pSPFPubObjParamBase.getObjName();
            }
            case 5: {
                return pSPFPubObjParamBase.getParamType();
            }
            case 6: {
                return pSPFPubObjParamBase.getPSPFPubObjId();
            }
            case 7: {
                return pSPFPubObjParamBase.getPSPFPubObjName();
            }
            case 8: {
                return pSPFPubObjParamBase.getPSPFPubObjParamId();
            }
            case 9: {
                return pSPFPubObjParamBase.getPSPFPubObjParamName();
            }
            case 10: {
                return pSPFPubObjParamBase.getUpdateDate();
            }
            case 11: {
                return pSPFPubObjParamBase.getUpdateMan();
            }
            case 12: {
                return pSPFPubObjParamBase.getValidFlag();
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
        PSPFPubObjParamBase.set(this, n, object);
    }

    private static void set(PSPFPubObjParamBase pSPFPubObjParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubObjParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPubObjParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPubObjParamBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPubObjParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPubObjParamBase.setObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPubObjParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPubObjParamBase.setPSPFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPubObjParamBase.setPSPFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPubObjParamBase.setPSPFPubObjParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPubObjParamBase.setPSPFPubObjParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPubObjParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSPFPubObjParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPubObjParamBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFPubObjParamBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPubObjParamBase pSPFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPubObjParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPubObjParamBase.getLogicName() == null;
            }
            case 3: {
                return pSPFPubObjParamBase.getMemo() == null;
            }
            case 4: {
                return pSPFPubObjParamBase.getObjName() == null;
            }
            case 5: {
                return pSPFPubObjParamBase.getParamType() == null;
            }
            case 6: {
                return pSPFPubObjParamBase.getPSPFPubObjId() == null;
            }
            case 7: {
                return pSPFPubObjParamBase.getPSPFPubObjName() == null;
            }
            case 8: {
                return pSPFPubObjParamBase.getPSPFPubObjParamId() == null;
            }
            case 9: {
                return pSPFPubObjParamBase.getPSPFPubObjParamName() == null;
            }
            case 10: {
                return pSPFPubObjParamBase.getUpdateDate() == null;
            }
            case 11: {
                return pSPFPubObjParamBase.getUpdateMan() == null;
            }
            case 12: {
                return pSPFPubObjParamBase.getValidFlag() == null;
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
        return PSPFPubObjParamBase.contains(this, n);
    }

    private static boolean contains(PSPFPubObjParamBase pSPFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPubObjParamBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPubObjParamBase.isLogicNameDirty();
            }
            case 3: {
                return pSPFPubObjParamBase.isMemoDirty();
            }
            case 4: {
                return pSPFPubObjParamBase.isObjNameDirty();
            }
            case 5: {
                return pSPFPubObjParamBase.isParamTypeDirty();
            }
            case 6: {
                return pSPFPubObjParamBase.isPSPFPubObjIdDirty();
            }
            case 7: {
                return pSPFPubObjParamBase.isPSPFPubObjNameDirty();
            }
            case 8: {
                return pSPFPubObjParamBase.isPSPFPubObjParamIdDirty();
            }
            case 9: {
                return pSPFPubObjParamBase.isPSPFPubObjParamNameDirty();
            }
            case 10: {
                return pSPFPubObjParamBase.isUpdateDateDirty();
            }
            case 11: {
                return pSPFPubObjParamBase.isUpdateManDirty();
            }
            case 12: {
                return pSPFPubObjParamBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPubObjParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPubObjParamBase pSPFPubObjParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPubObjParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objname", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getObjName()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjid", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getPSPFPubObjId()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjname", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getPSPFPubObjName()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjparamid", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getPSPFPubObjParamId()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjparamname", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getPSPFPubObjParamName()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPubObjParamBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFPubObjParamBase.getJSONValue((Object)pSPFPubObjParamBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPubObjParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPubObjParamBase pSPFPubObjParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPubObjParamBase.getCreateDate() != null) {
            object = pSPFPubObjParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubObjParamBase.getCreateMan() != null) {
            object = pSPFPubObjParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getLogicName() != null) {
            object = pSPFPubObjParamBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getMemo() != null) {
            object = pSPFPubObjParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getObjName() != null) {
            object = pSPFPubObjParamBase.getObjName();
            xmlNode.setAttribute(FIELD_OBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getParamType() != null) {
            object = pSPFPubObjParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjId() != null) {
            object = pSPFPubObjParamBase.getPSPFPubObjId();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjName() != null) {
            object = pSPFPubObjParamBase.getPSPFPubObjName();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjParamId() != null) {
            object = pSPFPubObjParamBase.getPSPFPubObjParamId();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getPSPFPubObjParamName() != null) {
            object = pSPFPubObjParamBase.getPSPFPubObjParamName();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getUpdateDate() != null) {
            object = pSPFPubObjParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubObjParamBase.getUpdateMan() != null) {
            object = pSPFPubObjParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjParamBase.getValidFlag() != null) {
            object = pSPFPubObjParamBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPubObjParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPubObjParamBase pSPFPubObjParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPubObjParamBase.isCreateDateDirty() && (bl || pSPFPubObjParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPubObjParamBase.getCreateDate());
        }
        if (pSPFPubObjParamBase.isCreateManDirty() && (bl || pSPFPubObjParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPubObjParamBase.getCreateMan());
        }
        if (pSPFPubObjParamBase.isLogicNameDirty() && (bl || pSPFPubObjParamBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPFPubObjParamBase.getLogicName());
        }
        if (pSPFPubObjParamBase.isMemoDirty() && (bl || pSPFPubObjParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPubObjParamBase.getMemo());
        }
        if (pSPFPubObjParamBase.isObjNameDirty() && (bl || pSPFPubObjParamBase.getObjName() != null)) {
            iDataObject.set(FIELD_OBJNAME, (Object)pSPFPubObjParamBase.getObjName());
        }
        if (pSPFPubObjParamBase.isParamTypeDirty() && (bl || pSPFPubObjParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSPFPubObjParamBase.getParamType());
        }
        if (pSPFPubObjParamBase.isPSPFPubObjIdDirty() && (bl || pSPFPubObjParamBase.getPSPFPubObjId() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJID, (Object)pSPFPubObjParamBase.getPSPFPubObjId());
        }
        if (pSPFPubObjParamBase.isPSPFPubObjNameDirty() && (bl || pSPFPubObjParamBase.getPSPFPubObjName() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJNAME, (Object)pSPFPubObjParamBase.getPSPFPubObjName());
        }
        if (pSPFPubObjParamBase.isPSPFPubObjParamIdDirty() && (bl || pSPFPubObjParamBase.getPSPFPubObjParamId() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJPARAMID, (Object)pSPFPubObjParamBase.getPSPFPubObjParamId());
        }
        if (pSPFPubObjParamBase.isPSPFPubObjParamNameDirty() && (bl || pSPFPubObjParamBase.getPSPFPubObjParamName() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJPARAMNAME, (Object)pSPFPubObjParamBase.getPSPFPubObjParamName());
        }
        if (pSPFPubObjParamBase.isUpdateDateDirty() && (bl || pSPFPubObjParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPubObjParamBase.getUpdateDate());
        }
        if (pSPFPubObjParamBase.isUpdateManDirty() && (bl || pSPFPubObjParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPubObjParamBase.getUpdateMan());
        }
        if (pSPFPubObjParamBase.isValidFlagDirty() && (bl || pSPFPubObjParamBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFPubObjParamBase.getValidFlag());
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
        return PSPFPubObjParamBase.remove(this, n);
    }

    private static boolean remove(PSPFPubObjParamBase pSPFPubObjParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubObjParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPubObjParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPubObjParamBase.resetLogicName();
                return true;
            }
            case 3: {
                pSPFPubObjParamBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFPubObjParamBase.resetObjName();
                return true;
            }
            case 5: {
                pSPFPubObjParamBase.resetParamType();
                return true;
            }
            case 6: {
                pSPFPubObjParamBase.resetPSPFPubObjId();
                return true;
            }
            case 7: {
                pSPFPubObjParamBase.resetPSPFPubObjName();
                return true;
            }
            case 8: {
                pSPFPubObjParamBase.resetPSPFPubObjParamId();
                return true;
            }
            case 9: {
                pSPFPubObjParamBase.resetPSPFPubObjParamName();
                return true;
            }
            case 10: {
                pSPFPubObjParamBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSPFPubObjParamBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSPFPubObjParamBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubObj getPspfpubobj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPspfpubobj();
        }
        if (this.getPSPFPubObjId() == null) {
            return null;
        }
        Integer n = this.objPspfpubobjLock;
        synchronized (n) {
            if (this.pspfpubobj != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubObjId(), (Object)this.pspfpubobj.getPSPFPubObjId()) != 0L) {
                this.pspfpubobj = null;
            }
            if (this.pspfpubobj == null) {
                PSPFPubObj pSPFPubObj = new PSPFPubObj();
                pSPFPubObj.setPSPFPubObjId(this.getPSPFPubObjId());
                PSPFPubObjService pSPFPubObjService = (PSPFPubObjService)ServiceGlobal.getService(PSPFPubObjService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubObjService.autoGet((IEntity)pSPFPubObj);
                this.pspfpubobj = pSPFPubObj;
            }
            return this.pspfpubobj;
        }
    }

    private PSPFPubObjParamBase getProxyEntity() {
        return this.proxyPSPFPubObjParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPubObjParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPubObjParamBase) {
            this.proxyPSPFPubObjParamBase = (PSPFPubObjParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubObjParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSPFPUBOBJID, 6);
        fieldIndexMap.put(FIELD_PSPFPUBOBJNAME, 7);
        fieldIndexMap.put(FIELD_PSPFPUBOBJPARAMID, 8);
        fieldIndexMap.put(FIELD_PSPFPUBOBJPARAMNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

