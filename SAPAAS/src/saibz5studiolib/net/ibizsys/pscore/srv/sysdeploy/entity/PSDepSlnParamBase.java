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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNPARAMID = "PSDEPSLNPARAMID";
    public static final String FIELD_PSDEPSLNPARAMNAME = "PSDEPSLNPARAMNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNID = 3;
    private static final int INDEX_PSDEPSLNNAME = 4;
    private static final int INDEX_PSDEPSLNPARAMID = 5;
    private static final int INDEX_PSDEPSLNPARAMNAME = 6;
    private static final int INDEX_PSDEPSLNSYSID = 7;
    private static final int INDEX_PSDEPSLNSYSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final int INDEX_VALUE = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnParamBase proxyPSDepSlnParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnparamidDirtyFlag = false;
    private boolean psdepslnparamnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnparamid")
    private String psdepslnparamid;
    @Column(name="psdepslnparamname")
    private String psdepslnparamname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnparamid = string;
        this.psdepslnparamidDirtyFlag = true;
    }

    public String getPSDepSlnParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnParamId();
        }
        return this.psdepslnparamid;
    }

    public boolean isPSDepSlnParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnParamIdDirty();
        }
        return this.psdepslnparamidDirtyFlag;
    }

    public void resetPSDepSlnParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnParamId();
            return;
        }
        this.psdepslnparamidDirtyFlag = false;
        this.psdepslnparamid = null;
    }

    public void setPSDepSlnParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnparamname = string;
        this.psdepslnparamnameDirtyFlag = true;
    }

    public String getPSDepSlnParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnParamName();
        }
        return this.psdepslnparamname;
    }

    public boolean isPSDepSlnParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnParamNameDirty();
        }
        return this.psdepslnparamnameDirtyFlag;
    }

    public void resetPSDepSlnParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnParamName();
            return;
        }
        this.psdepslnparamnameDirtyFlag = false;
        this.psdepslnparamname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    protected void onReset() {
        PSDepSlnParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnParamBase pSDepSlnParamBase) {
        pSDepSlnParamBase.resetCreateDate();
        pSDepSlnParamBase.resetCreateMan();
        pSDepSlnParamBase.resetMemo();
        pSDepSlnParamBase.resetPSDepSlnId();
        pSDepSlnParamBase.resetPSDepSlnName();
        pSDepSlnParamBase.resetPSDepSlnParamId();
        pSDepSlnParamBase.resetPSDepSlnParamName();
        pSDepSlnParamBase.resetPSDepSlnSysId();
        pSDepSlnParamBase.resetPSDepSlnSysName();
        pSDepSlnParamBase.resetUpdateDate();
        pSDepSlnParamBase.resetUpdateMan();
        pSDepSlnParamBase.resetValidFlag();
        pSDepSlnParamBase.resetValue();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnParamIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPARAMID, this.getPSDepSlnParamId());
        }
        if (!bl || this.isPSDepSlnParamNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPARAMNAME, this.getPSDepSlnParamName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
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
        return PSDepSlnParamBase.get(this, n);
    }

    private static Object get(PSDepSlnParamBase pSDepSlnParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnParamBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnParamBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnParamBase.getMemo();
            }
            case 3: {
                return pSDepSlnParamBase.getPSDepSlnId();
            }
            case 4: {
                return pSDepSlnParamBase.getPSDepSlnName();
            }
            case 5: {
                return pSDepSlnParamBase.getPSDepSlnParamId();
            }
            case 6: {
                return pSDepSlnParamBase.getPSDepSlnParamName();
            }
            case 7: {
                return pSDepSlnParamBase.getPSDepSlnSysId();
            }
            case 8: {
                return pSDepSlnParamBase.getPSDepSlnSysName();
            }
            case 9: {
                return pSDepSlnParamBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnParamBase.getUpdateMan();
            }
            case 11: {
                return pSDepSlnParamBase.getValidFlag();
            }
            case 12: {
                return pSDepSlnParamBase.getValue();
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
        PSDepSlnParamBase.set(this, n, object);
    }

    private static void set(PSDepSlnParamBase pSDepSlnParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnParamBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnParamBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnParamBase.setPSDepSlnParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnParamBase.setPSDepSlnParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnParamBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnParamBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnParamBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnParamBase.setValue(DataObject.getStringValue((Object)object));
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
        return PSDepSlnParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnParamBase pSDepSlnParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnParamBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnParamBase.getPSDepSlnId() == null;
            }
            case 4: {
                return pSDepSlnParamBase.getPSDepSlnName() == null;
            }
            case 5: {
                return pSDepSlnParamBase.getPSDepSlnParamId() == null;
            }
            case 6: {
                return pSDepSlnParamBase.getPSDepSlnParamName() == null;
            }
            case 7: {
                return pSDepSlnParamBase.getPSDepSlnSysId() == null;
            }
            case 8: {
                return pSDepSlnParamBase.getPSDepSlnSysName() == null;
            }
            case 9: {
                return pSDepSlnParamBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnParamBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDepSlnParamBase.getValidFlag() == null;
            }
            case 12: {
                return pSDepSlnParamBase.getValue() == null;
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
        return PSDepSlnParamBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnParamBase pSDepSlnParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnParamBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnParamBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnParamBase.isPSDepSlnIdDirty();
            }
            case 4: {
                return pSDepSlnParamBase.isPSDepSlnNameDirty();
            }
            case 5: {
                return pSDepSlnParamBase.isPSDepSlnParamIdDirty();
            }
            case 6: {
                return pSDepSlnParamBase.isPSDepSlnParamNameDirty();
            }
            case 7: {
                return pSDepSlnParamBase.isPSDepSlnSysIdDirty();
            }
            case 8: {
                return pSDepSlnParamBase.isPSDepSlnSysNameDirty();
            }
            case 9: {
                return pSDepSlnParamBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnParamBase.isUpdateManDirty();
            }
            case 11: {
                return pSDepSlnParamBase.isValidFlagDirty();
            }
            case 12: {
                return pSDepSlnParamBase.isValueDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnParamBase pSDepSlnParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnparamid", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnParamId()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnparamname", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnParamName()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDepSlnParamBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSDepSlnParamBase.getJSONValue((Object)pSDepSlnParamBase.getValue()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnParamBase pSDepSlnParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnParamBase.getCreateDate() != null) {
            object = pSDepSlnParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnParamBase.getCreateMan() != null) {
            object = pSDepSlnParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getMemo() != null) {
            object = pSDepSlnParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnId() != null) {
            object = pSDepSlnParamBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnName() != null) {
            object = pSDepSlnParamBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnParamId() != null) {
            object = pSDepSlnParamBase.getPSDepSlnParamId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnParamName() != null) {
            object = pSDepSlnParamBase.getPSDepSlnParamName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnParamBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnParamBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getUpdateDate() != null) {
            object = pSDepSlnParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnParamBase.getUpdateMan() != null) {
            object = pSDepSlnParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnParamBase.getValidFlag() != null) {
            object = pSDepSlnParamBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnParamBase.getValue() != null) {
            object = pSDepSlnParamBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnParamBase pSDepSlnParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnParamBase.isCreateDateDirty() && (bl || pSDepSlnParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnParamBase.getCreateDate());
        }
        if (pSDepSlnParamBase.isCreateManDirty() && (bl || pSDepSlnParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnParamBase.getCreateMan());
        }
        if (pSDepSlnParamBase.isMemoDirty() && (bl || pSDepSlnParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnParamBase.getMemo());
        }
        if (pSDepSlnParamBase.isPSDepSlnIdDirty() && (bl || pSDepSlnParamBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnParamBase.getPSDepSlnId());
        }
        if (pSDepSlnParamBase.isPSDepSlnNameDirty() && (bl || pSDepSlnParamBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnParamBase.getPSDepSlnName());
        }
        if (pSDepSlnParamBase.isPSDepSlnParamIdDirty() && (bl || pSDepSlnParamBase.getPSDepSlnParamId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPARAMID, (Object)pSDepSlnParamBase.getPSDepSlnParamId());
        }
        if (pSDepSlnParamBase.isPSDepSlnParamNameDirty() && (bl || pSDepSlnParamBase.getPSDepSlnParamName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPARAMNAME, (Object)pSDepSlnParamBase.getPSDepSlnParamName());
        }
        if (pSDepSlnParamBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnParamBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnParamBase.getPSDepSlnSysId());
        }
        if (pSDepSlnParamBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnParamBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnParamBase.getPSDepSlnSysName());
        }
        if (pSDepSlnParamBase.isUpdateDateDirty() && (bl || pSDepSlnParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnParamBase.getUpdateDate());
        }
        if (pSDepSlnParamBase.isUpdateManDirty() && (bl || pSDepSlnParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnParamBase.getUpdateMan());
        }
        if (pSDepSlnParamBase.isValidFlagDirty() && (bl || pSDepSlnParamBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnParamBase.getValidFlag());
        }
        if (pSDepSlnParamBase.isValueDirty() && (bl || pSDepSlnParamBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSDepSlnParamBase.getValue());
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
        return PSDepSlnParamBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnParamBase pSDepSlnParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnParamBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnParamBase.resetPSDepSlnId();
                return true;
            }
            case 4: {
                pSDepSlnParamBase.resetPSDepSlnName();
                return true;
            }
            case 5: {
                pSDepSlnParamBase.resetPSDepSlnParamId();
                return true;
            }
            case 6: {
                pSDepSlnParamBase.resetPSDepSlnParamName();
                return true;
            }
            case 7: {
                pSDepSlnParamBase.resetPSDepSlnSysId();
                return true;
            }
            case 8: {
                pSDepSlnParamBase.resetPSDepSlnSysName();
                return true;
            }
            case 9: {
                pSDepSlnParamBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnParamBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDepSlnParamBase.resetValidFlag();
                return true;
            }
            case 12: {
                pSDepSlnParamBase.resetValue();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnParamBase getProxyEntity() {
        return this.proxyPSDepSlnParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnParamBase) {
            this.proxyPSDepSlnParamBase = (PSDepSlnParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNPARAMID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNPARAMNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
        fieldIndexMap.put(FIELD_VALUE, 12);
    }
}

