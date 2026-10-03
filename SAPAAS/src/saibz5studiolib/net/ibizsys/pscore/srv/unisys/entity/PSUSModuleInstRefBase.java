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
package net.ibizsys.pscore.srv.unisys.entity;

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
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSModuleInstRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUSMODULEINSTID = "PSUSMODULEINSTID";
    public static final String FIELD_PSUSMODULEINSTNAME = "PSUSMODULEINSTNAME";
    public static final String FIELD_PSUSMODULEINSTREFID = "PSUSMODULEINSTREFID";
    public static final String FIELD_PSUSMODULEINSTREFNAME = "PSUSMODULEINSTREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPSUSMODULEINSTID = "REFPSUSMODULEINSTID";
    public static final String FIELD_REFPSUSMODULEINSTNAME = "REFPSUSMODULEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSUSMODULEINSTID = 3;
    private static final int INDEX_PSUSMODULEINSTNAME = 4;
    private static final int INDEX_PSUSMODULEINSTREFID = 5;
    private static final int INDEX_PSUSMODULEINSTREFNAME = 6;
    private static final int INDEX_REFMODE = 7;
    private static final int INDEX_REFPSUSMODULEINSTID = 8;
    private static final int INDEX_REFPSUSMODULEINSTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSModuleInstRefBase proxyPSUSModuleInstRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psusmoduleinstidDirtyFlag = false;
    private boolean psusmoduleinstnameDirtyFlag = false;
    private boolean psusmoduleinstrefidDirtyFlag = false;
    private boolean psusmoduleinstrefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refpsusmoduleinstidDirtyFlag = false;
    private boolean refpsusmoduleinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psusmoduleinstid")
    private String psusmoduleinstid;
    @Column(name="psusmoduleinstname")
    private String psusmoduleinstname;
    @Column(name="psusmoduleinstrefid")
    private String psusmoduleinstrefid;
    @Column(name="psusmoduleinstrefname")
    private String psusmoduleinstrefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refpsusmoduleinstid")
    private String refpsusmoduleinstid;
    @Column(name="refpsusmoduleinstname")
    private String refpsusmoduleinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSUSModuleInstLock = new Integer(1);
    private PSUSModuleInst psusmoduleinst = null;
    private Integer objRefPSUSModuleInstLock = new Integer(1);
    private PSUSModuleInst refpsusmoduleinst = null;

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

    public void setPSUSModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstid = string;
        this.psusmoduleinstidDirtyFlag = true;
    }

    public String getPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstId();
        }
        return this.psusmoduleinstid;
    }

    public boolean isPSUSModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstIdDirty();
        }
        return this.psusmoduleinstidDirtyFlag;
    }

    public void resetPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstId();
            return;
        }
        this.psusmoduleinstidDirtyFlag = false;
        this.psusmoduleinstid = null;
    }

    public void setPSUSModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstname = string;
        this.psusmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstName();
        }
        return this.psusmoduleinstname;
    }

    public boolean isPSUSModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstNameDirty();
        }
        return this.psusmoduleinstnameDirtyFlag;
    }

    public void resetPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstName();
            return;
        }
        this.psusmoduleinstnameDirtyFlag = false;
        this.psusmoduleinstname = null;
    }

    public void setPSUSModuleInstRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstrefid = string;
        this.psusmoduleinstrefidDirtyFlag = true;
    }

    public String getPSUSModuleInstRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstRefId();
        }
        return this.psusmoduleinstrefid;
    }

    public boolean isPSUSModuleInstRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstRefIdDirty();
        }
        return this.psusmoduleinstrefidDirtyFlag;
    }

    public void resetPSUSModuleInstRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstRefId();
            return;
        }
        this.psusmoduleinstrefidDirtyFlag = false;
        this.psusmoduleinstrefid = null;
    }

    public void setPSUSModuleInstRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstrefname = string;
        this.psusmoduleinstrefnameDirtyFlag = true;
    }

    public String getPSUSModuleInstRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstRefName();
        }
        return this.psusmoduleinstrefname;
    }

    public boolean isPSUSModuleInstRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstRefNameDirty();
        }
        return this.psusmoduleinstrefnameDirtyFlag;
    }

    public void resetPSUSModuleInstRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstRefName();
            return;
        }
        this.psusmoduleinstrefnameDirtyFlag = false;
        this.psusmoduleinstrefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefPSUSModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSUSModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsusmoduleinstid = string;
        this.refpsusmoduleinstidDirtyFlag = true;
    }

    public String getRefPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSModuleInstId();
        }
        return this.refpsusmoduleinstid;
    }

    public boolean isRefPSUSModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSUSModuleInstIdDirty();
        }
        return this.refpsusmoduleinstidDirtyFlag;
    }

    public void resetRefPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSUSModuleInstId();
            return;
        }
        this.refpsusmoduleinstidDirtyFlag = false;
        this.refpsusmoduleinstid = null;
    }

    public void setRefPSUSModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSUSModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsusmoduleinstname = string;
        this.refpsusmoduleinstnameDirtyFlag = true;
    }

    public String getRefPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSModuleInstName();
        }
        return this.refpsusmoduleinstname;
    }

    public boolean isRefPSUSModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSUSModuleInstNameDirty();
        }
        return this.refpsusmoduleinstnameDirtyFlag;
    }

    public void resetRefPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSUSModuleInstName();
            return;
        }
        this.refpsusmoduleinstnameDirtyFlag = false;
        this.refpsusmoduleinstname = null;
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
        PSUSModuleInstRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSModuleInstRefBase pSUSModuleInstRefBase) {
        pSUSModuleInstRefBase.resetCreateDate();
        pSUSModuleInstRefBase.resetCreateMan();
        pSUSModuleInstRefBase.resetMemo();
        pSUSModuleInstRefBase.resetPSUSModuleInstId();
        pSUSModuleInstRefBase.resetPSUSModuleInstName();
        pSUSModuleInstRefBase.resetPSUSModuleInstRefId();
        pSUSModuleInstRefBase.resetPSUSModuleInstRefName();
        pSUSModuleInstRefBase.resetRefMode();
        pSUSModuleInstRefBase.resetRefPSUSModuleInstId();
        pSUSModuleInstRefBase.resetRefPSUSModuleInstName();
        pSUSModuleInstRefBase.resetUpdateDate();
        pSUSModuleInstRefBase.resetUpdateMan();
        pSUSModuleInstRefBase.resetValidFlag();
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
        if (!bl || this.isPSUSModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTID, this.getPSUSModuleInstId());
        }
        if (!bl || this.isPSUSModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTNAME, this.getPSUSModuleInstName());
        }
        if (!bl || this.isPSUSModuleInstRefIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTREFID, this.getPSUSModuleInstRefId());
        }
        if (!bl || this.isPSUSModuleInstRefNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTREFNAME, this.getPSUSModuleInstRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefPSUSModuleInstIdDirty()) {
            hashMap.put(FIELD_REFPSUSMODULEINSTID, this.getRefPSUSModuleInstId());
        }
        if (!bl || this.isRefPSUSModuleInstNameDirty()) {
            hashMap.put(FIELD_REFPSUSMODULEINSTNAME, this.getRefPSUSModuleInstName());
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
        return PSUSModuleInstRefBase.get(this, n);
    }

    private static Object get(PSUSModuleInstRefBase pSUSModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstRefBase.getCreateDate();
            }
            case 1: {
                return pSUSModuleInstRefBase.getCreateMan();
            }
            case 2: {
                return pSUSModuleInstRefBase.getMemo();
            }
            case 3: {
                return pSUSModuleInstRefBase.getPSUSModuleInstId();
            }
            case 4: {
                return pSUSModuleInstRefBase.getPSUSModuleInstName();
            }
            case 5: {
                return pSUSModuleInstRefBase.getPSUSModuleInstRefId();
            }
            case 6: {
                return pSUSModuleInstRefBase.getPSUSModuleInstRefName();
            }
            case 7: {
                return pSUSModuleInstRefBase.getRefMode();
            }
            case 8: {
                return pSUSModuleInstRefBase.getRefPSUSModuleInstId();
            }
            case 9: {
                return pSUSModuleInstRefBase.getRefPSUSModuleInstName();
            }
            case 10: {
                return pSUSModuleInstRefBase.getUpdateDate();
            }
            case 11: {
                return pSUSModuleInstRefBase.getUpdateMan();
            }
            case 12: {
                return pSUSModuleInstRefBase.getValidFlag();
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
        PSUSModuleInstRefBase.set(this, n, object);
    }

    private static void set(PSUSModuleInstRefBase pSUSModuleInstRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSModuleInstRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSModuleInstRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSModuleInstRefBase.setPSUSModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSModuleInstRefBase.setPSUSModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSModuleInstRefBase.setPSUSModuleInstRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSModuleInstRefBase.setPSUSModuleInstRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSModuleInstRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSModuleInstRefBase.setRefPSUSModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSModuleInstRefBase.setRefPSUSModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUSModuleInstRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSUSModuleInstRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUSModuleInstRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUSModuleInstRefBase.isNull(this, n);
    }

    private static boolean isNull(PSUSModuleInstRefBase pSUSModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSModuleInstRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSModuleInstRefBase.getMemo() == null;
            }
            case 3: {
                return pSUSModuleInstRefBase.getPSUSModuleInstId() == null;
            }
            case 4: {
                return pSUSModuleInstRefBase.getPSUSModuleInstName() == null;
            }
            case 5: {
                return pSUSModuleInstRefBase.getPSUSModuleInstRefId() == null;
            }
            case 6: {
                return pSUSModuleInstRefBase.getPSUSModuleInstRefName() == null;
            }
            case 7: {
                return pSUSModuleInstRefBase.getRefMode() == null;
            }
            case 8: {
                return pSUSModuleInstRefBase.getRefPSUSModuleInstId() == null;
            }
            case 9: {
                return pSUSModuleInstRefBase.getRefPSUSModuleInstName() == null;
            }
            case 10: {
                return pSUSModuleInstRefBase.getUpdateDate() == null;
            }
            case 11: {
                return pSUSModuleInstRefBase.getUpdateMan() == null;
            }
            case 12: {
                return pSUSModuleInstRefBase.getValidFlag() == null;
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
        return PSUSModuleInstRefBase.contains(this, n);
    }

    private static boolean contains(PSUSModuleInstRefBase pSUSModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSModuleInstRefBase.isCreateManDirty();
            }
            case 2: {
                return pSUSModuleInstRefBase.isMemoDirty();
            }
            case 3: {
                return pSUSModuleInstRefBase.isPSUSModuleInstIdDirty();
            }
            case 4: {
                return pSUSModuleInstRefBase.isPSUSModuleInstNameDirty();
            }
            case 5: {
                return pSUSModuleInstRefBase.isPSUSModuleInstRefIdDirty();
            }
            case 6: {
                return pSUSModuleInstRefBase.isPSUSModuleInstRefNameDirty();
            }
            case 7: {
                return pSUSModuleInstRefBase.isRefModeDirty();
            }
            case 8: {
                return pSUSModuleInstRefBase.isRefPSUSModuleInstIdDirty();
            }
            case 9: {
                return pSUSModuleInstRefBase.isRefPSUSModuleInstNameDirty();
            }
            case 10: {
                return pSUSModuleInstRefBase.isUpdateDateDirty();
            }
            case 11: {
                return pSUSModuleInstRefBase.isUpdateManDirty();
            }
            case 12: {
                return pSUSModuleInstRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSModuleInstRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSModuleInstRefBase pSUSModuleInstRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSModuleInstRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstid", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getPSUSModuleInstId()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstname", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getPSUSModuleInstName()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstrefid", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getPSUSModuleInstRefId()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstrefname", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getPSUSModuleInstRefName()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsusmoduleinstid", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getRefPSUSModuleInstId()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsusmoduleinstname", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getRefPSUSModuleInstName()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUSModuleInstRefBase.getJSONValue((Object)pSUSModuleInstRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSModuleInstRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSModuleInstRefBase pSUSModuleInstRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSModuleInstRefBase.getCreateDate() != null) {
            object = pSUSModuleInstRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstRefBase.getCreateMan() != null) {
            object = pSUSModuleInstRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getMemo() != null) {
            object = pSUSModuleInstRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstId() != null) {
            object = pSUSModuleInstRefBase.getPSUSModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstName() != null) {
            object = pSUSModuleInstRefBase.getPSUSModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefId() != null) {
            object = pSUSModuleInstRefBase.getPSUSModuleInstRefId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTREFID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefName() != null) {
            object = pSUSModuleInstRefBase.getPSUSModuleInstRefName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getRefMode() != null) {
            object = pSUSModuleInstRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstId() != null) {
            object = pSUSModuleInstRefBase.getRefPSUSModuleInstId();
            xmlNode.setAttribute(FIELD_REFPSUSMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstName() != null) {
            object = pSUSModuleInstRefBase.getRefPSUSModuleInstName();
            xmlNode.setAttribute(FIELD_REFPSUSMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getUpdateDate() != null) {
            object = pSUSModuleInstRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstRefBase.getUpdateMan() != null) {
            object = pSUSModuleInstRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstRefBase.getValidFlag() != null) {
            object = pSUSModuleInstRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSModuleInstRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSModuleInstRefBase pSUSModuleInstRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSModuleInstRefBase.isCreateDateDirty() && (bl || pSUSModuleInstRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSModuleInstRefBase.getCreateDate());
        }
        if (pSUSModuleInstRefBase.isCreateManDirty() && (bl || pSUSModuleInstRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSModuleInstRefBase.getCreateMan());
        }
        if (pSUSModuleInstRefBase.isMemoDirty() && (bl || pSUSModuleInstRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSModuleInstRefBase.getMemo());
        }
        if (pSUSModuleInstRefBase.isPSUSModuleInstIdDirty() && (bl || pSUSModuleInstRefBase.getPSUSModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTID, (Object)pSUSModuleInstRefBase.getPSUSModuleInstId());
        }
        if (pSUSModuleInstRefBase.isPSUSModuleInstNameDirty() && (bl || pSUSModuleInstRefBase.getPSUSModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTNAME, (Object)pSUSModuleInstRefBase.getPSUSModuleInstName());
        }
        if (pSUSModuleInstRefBase.isPSUSModuleInstRefIdDirty() && (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTREFID, (Object)pSUSModuleInstRefBase.getPSUSModuleInstRefId());
        }
        if (pSUSModuleInstRefBase.isPSUSModuleInstRefNameDirty() && (bl || pSUSModuleInstRefBase.getPSUSModuleInstRefName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTREFNAME, (Object)pSUSModuleInstRefBase.getPSUSModuleInstRefName());
        }
        if (pSUSModuleInstRefBase.isRefModeDirty() && (bl || pSUSModuleInstRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSUSModuleInstRefBase.getRefMode());
        }
        if (pSUSModuleInstRefBase.isRefPSUSModuleInstIdDirty() && (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstId() != null)) {
            iDataObject.set(FIELD_REFPSUSMODULEINSTID, (Object)pSUSModuleInstRefBase.getRefPSUSModuleInstId());
        }
        if (pSUSModuleInstRefBase.isRefPSUSModuleInstNameDirty() && (bl || pSUSModuleInstRefBase.getRefPSUSModuleInstName() != null)) {
            iDataObject.set(FIELD_REFPSUSMODULEINSTNAME, (Object)pSUSModuleInstRefBase.getRefPSUSModuleInstName());
        }
        if (pSUSModuleInstRefBase.isUpdateDateDirty() && (bl || pSUSModuleInstRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSModuleInstRefBase.getUpdateDate());
        }
        if (pSUSModuleInstRefBase.isUpdateManDirty() && (bl || pSUSModuleInstRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSModuleInstRefBase.getUpdateMan());
        }
        if (pSUSModuleInstRefBase.isValidFlagDirty() && (bl || pSUSModuleInstRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUSModuleInstRefBase.getValidFlag());
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
        return PSUSModuleInstRefBase.remove(this, n);
    }

    private static boolean remove(PSUSModuleInstRefBase pSUSModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSModuleInstRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSModuleInstRefBase.resetMemo();
                return true;
            }
            case 3: {
                pSUSModuleInstRefBase.resetPSUSModuleInstId();
                return true;
            }
            case 4: {
                pSUSModuleInstRefBase.resetPSUSModuleInstName();
                return true;
            }
            case 5: {
                pSUSModuleInstRefBase.resetPSUSModuleInstRefId();
                return true;
            }
            case 6: {
                pSUSModuleInstRefBase.resetPSUSModuleInstRefName();
                return true;
            }
            case 7: {
                pSUSModuleInstRefBase.resetRefMode();
                return true;
            }
            case 8: {
                pSUSModuleInstRefBase.resetRefPSUSModuleInstId();
                return true;
            }
            case 9: {
                pSUSModuleInstRefBase.resetRefPSUSModuleInstName();
                return true;
            }
            case 10: {
                pSUSModuleInstRefBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSUSModuleInstRefBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSUSModuleInstRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModuleInst getPSUSModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInst();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        Integer n = this.objPSUSModuleInstLock;
        synchronized (n) {
            if (this.psusmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSModuleInstId(), (Object)this.psusmoduleinst.getPSUSModuleInstId()) != 0L) {
                this.psusmoduleinst = null;
            }
            if (this.psusmoduleinst == null) {
                PSUSModuleInst pSUSModuleInst = new PSUSModuleInst();
                pSUSModuleInst.setPSUSModuleInstId(this.getPSUSModuleInstId());
                PSUSModuleInstService pSUSModuleInstService = (PSUSModuleInstService)ServiceGlobal.getService(PSUSModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleInstService.autoGet(pSUSModuleInst);
                this.psusmoduleinst = pSUSModuleInst;
            }
            return this.psusmoduleinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModuleInst getRefPSUSModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSModuleInst();
        }
        if (this.getRefPSUSModuleInstId() == null) {
            return null;
        }
        Integer n = this.objRefPSUSModuleInstLock;
        synchronized (n) {
            if (this.refpsusmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSUSModuleInstId(), (Object)this.refpsusmoduleinst.getPSUSModuleInstId()) != 0L) {
                this.refpsusmoduleinst = null;
            }
            if (this.refpsusmoduleinst == null) {
                PSUSModuleInst pSUSModuleInst = new PSUSModuleInst();
                pSUSModuleInst.setPSUSModuleInstId(this.getRefPSUSModuleInstId());
                PSUSModuleInstService pSUSModuleInstService = (PSUSModuleInstService)ServiceGlobal.getService(PSUSModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleInstService.autoGet(pSUSModuleInst);
                this.refpsusmoduleinst = pSUSModuleInst;
            }
            return this.refpsusmoduleinst;
        }
    }

    private PSUSModuleInstRefBase getProxyEntity() {
        return this.proxyPSUSModuleInstRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSModuleInstRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSModuleInstRefBase) {
            this.proxyPSUSModuleInstRefBase = (PSUSModuleInstRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTID, 3);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTREFID, 5);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTREFNAME, 6);
        fieldIndexMap.put(FIELD_REFMODE, 7);
        fieldIndexMap.put(FIELD_REFPSUSMODULEINSTID, 8);
        fieldIndexMap.put(FIELD_REFPSUSMODULEINSTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

