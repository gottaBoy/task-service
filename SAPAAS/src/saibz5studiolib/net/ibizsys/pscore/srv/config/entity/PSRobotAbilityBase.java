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
import net.ibizsys.pscore.srv.config.entity.PSRobotWork;
import net.ibizsys.pscore.srv.config.service.PSRobotWorkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotAbilityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotAbilityBase.class);
    public static final String FIELD_ABILITYTAG = "ABILITYTAG";
    public static final String FIELD_ABILITYTAG2 = "ABILITYTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSROBOTABILITYID = "PSROBOTABILITYID";
    public static final String FIELD_PSROBOTABILITYNAME = "PSROBOTABILITYNAME";
    public static final String FIELD_PSROBOTWORKID = "PSROBOTWORKID";
    public static final String FIELD_PSROBOTWORKNAME = "PSROBOTWORKNAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ABILITYTAG = 0;
    private static final int INDEX_ABILITYTAG2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSROBOTABILITYID = 6;
    private static final int INDEX_PSROBOTABILITYNAME = 7;
    private static final int INDEX_PSROBOTWORKID = 8;
    private static final int INDEX_PSROBOTWORKNAME = 9;
    private static final int INDEX_TYPEOBJ = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotAbilityBase proxyPSRobotAbilityBase = null;
    private boolean abilitytagDirtyFlag = false;
    private boolean abilitytag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrobotabilityidDirtyFlag = false;
    private boolean psrobotabilitynameDirtyFlag = false;
    private boolean psrobotworkidDirtyFlag = false;
    private boolean psrobotworknameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="abilitytag")
    private String abilitytag;
    @Column(name="abilitytag2")
    private String abilitytag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psrobotabilityid")
    private String psrobotabilityid;
    @Column(name="psrobotabilityname")
    private String psrobotabilityname;
    @Column(name="psrobotworkid")
    private String psrobotworkid;
    @Column(name="psrobotworkname")
    private String psrobotworkname;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSRobotWorkLock = new Integer(1);
    private PSRobotWork psrobotwork = null;

    public void setAbilityTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAbilityTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.abilitytag = string;
        this.abilitytagDirtyFlag = true;
    }

    public String getAbilityTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAbilityTag();
        }
        return this.abilitytag;
    }

    public boolean isAbilityTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAbilityTagDirty();
        }
        return this.abilitytagDirtyFlag;
    }

    public void resetAbilityTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAbilityTag();
            return;
        }
        this.abilitytagDirtyFlag = false;
        this.abilitytag = null;
    }

    public void setAbilityTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAbilityTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.abilitytag2 = string;
        this.abilitytag2DirtyFlag = true;
    }

    public String getAbilityTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAbilityTag2();
        }
        return this.abilitytag2;
    }

    public boolean isAbilityTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAbilityTag2Dirty();
        }
        return this.abilitytag2DirtyFlag;
    }

    public void resetAbilityTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAbilityTag2();
            return;
        }
        this.abilitytag2DirtyFlag = false;
        this.abilitytag2 = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSRobotAbilityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotAbilityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotabilityid = string;
        this.psrobotabilityidDirtyFlag = true;
    }

    public String getPSRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotAbilityId();
        }
        return this.psrobotabilityid;
    }

    public boolean isPSRobotAbilityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotAbilityIdDirty();
        }
        return this.psrobotabilityidDirtyFlag;
    }

    public void resetPSRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotAbilityId();
            return;
        }
        this.psrobotabilityidDirtyFlag = false;
        this.psrobotabilityid = null;
    }

    public void setPSRobotAbilityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotAbilityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotabilityname = string;
        this.psrobotabilitynameDirtyFlag = true;
    }

    public String getPSRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotAbilityName();
        }
        return this.psrobotabilityname;
    }

    public boolean isPSRobotAbilityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotAbilityNameDirty();
        }
        return this.psrobotabilitynameDirtyFlag;
    }

    public void resetPSRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotAbilityName();
            return;
        }
        this.psrobotabilitynameDirtyFlag = false;
        this.psrobotabilityname = null;
    }

    public void setPSRobotWorkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworkid = string;
        this.psrobotworkidDirtyFlag = true;
    }

    public String getPSRobotWorkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkId();
        }
        return this.psrobotworkid;
    }

    public boolean isPSRobotWorkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkIdDirty();
        }
        return this.psrobotworkidDirtyFlag;
    }

    public void resetPSRobotWorkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkId();
            return;
        }
        this.psrobotworkidDirtyFlag = false;
        this.psrobotworkid = null;
    }

    public void setPSRobotWorkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworkname = string;
        this.psrobotworknameDirtyFlag = true;
    }

    public String getPSRobotWorkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkName();
        }
        return this.psrobotworkname;
    }

    public boolean isPSRobotWorkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkNameDirty();
        }
        return this.psrobotworknameDirtyFlag;
    }

    public void resetPSRobotWorkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkName();
            return;
        }
        this.psrobotworknameDirtyFlag = false;
        this.psrobotworkname = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSRobotAbilityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotAbilityBase pSRobotAbilityBase) {
        pSRobotAbilityBase.resetAbilityTag();
        pSRobotAbilityBase.resetAbilityTag2();
        pSRobotAbilityBase.resetCreateDate();
        pSRobotAbilityBase.resetCreateMan();
        pSRobotAbilityBase.resetDefaultFlag();
        pSRobotAbilityBase.resetMemo();
        pSRobotAbilityBase.resetPSRobotAbilityId();
        pSRobotAbilityBase.resetPSRobotAbilityName();
        pSRobotAbilityBase.resetPSRobotWorkId();
        pSRobotAbilityBase.resetPSRobotWorkName();
        pSRobotAbilityBase.resetTypeObj();
        pSRobotAbilityBase.resetUpdateDate();
        pSRobotAbilityBase.resetUpdateMan();
        pSRobotAbilityBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAbilityTagDirty()) {
            hashMap.put(FIELD_ABILITYTAG, this.getAbilityTag());
        }
        if (!bl || this.isAbilityTag2Dirty()) {
            hashMap.put(FIELD_ABILITYTAG2, this.getAbilityTag2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSRobotAbilityIdDirty()) {
            hashMap.put(FIELD_PSROBOTABILITYID, this.getPSRobotAbilityId());
        }
        if (!bl || this.isPSRobotAbilityNameDirty()) {
            hashMap.put(FIELD_PSROBOTABILITYNAME, this.getPSRobotAbilityName());
        }
        if (!bl || this.isPSRobotWorkIdDirty()) {
            hashMap.put(FIELD_PSROBOTWORKID, this.getPSRobotWorkId());
        }
        if (!bl || this.isPSRobotWorkNameDirty()) {
            hashMap.put(FIELD_PSROBOTWORKNAME, this.getPSRobotWorkName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSRobotAbilityBase.get(this, n);
    }

    private static Object get(PSRobotAbilityBase pSRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotAbilityBase.getAbilityTag();
            }
            case 1: {
                return pSRobotAbilityBase.getAbilityTag2();
            }
            case 2: {
                return pSRobotAbilityBase.getCreateDate();
            }
            case 3: {
                return pSRobotAbilityBase.getCreateMan();
            }
            case 4: {
                return pSRobotAbilityBase.getDefaultFlag();
            }
            case 5: {
                return pSRobotAbilityBase.getMemo();
            }
            case 6: {
                return pSRobotAbilityBase.getPSRobotAbilityId();
            }
            case 7: {
                return pSRobotAbilityBase.getPSRobotAbilityName();
            }
            case 8: {
                return pSRobotAbilityBase.getPSRobotWorkId();
            }
            case 9: {
                return pSRobotAbilityBase.getPSRobotWorkName();
            }
            case 10: {
                return pSRobotAbilityBase.getTypeObj();
            }
            case 11: {
                return pSRobotAbilityBase.getUpdateDate();
            }
            case 12: {
                return pSRobotAbilityBase.getUpdateMan();
            }
            case 13: {
                return pSRobotAbilityBase.getValidFlag();
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
        PSRobotAbilityBase.set(this, n, object);
    }

    private static void set(PSRobotAbilityBase pSRobotAbilityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotAbilityBase.setAbilityTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSRobotAbilityBase.setAbilityTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotAbilityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSRobotAbilityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRobotAbilityBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSRobotAbilityBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRobotAbilityBase.setPSRobotAbilityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRobotAbilityBase.setPSRobotAbilityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRobotAbilityBase.setPSRobotWorkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRobotAbilityBase.setPSRobotWorkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRobotAbilityBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSRobotAbilityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSRobotAbilityBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRobotAbilityBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRobotAbilityBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotAbilityBase pSRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotAbilityBase.getAbilityTag() == null;
            }
            case 1: {
                return pSRobotAbilityBase.getAbilityTag2() == null;
            }
            case 2: {
                return pSRobotAbilityBase.getCreateDate() == null;
            }
            case 3: {
                return pSRobotAbilityBase.getCreateMan() == null;
            }
            case 4: {
                return pSRobotAbilityBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSRobotAbilityBase.getMemo() == null;
            }
            case 6: {
                return pSRobotAbilityBase.getPSRobotAbilityId() == null;
            }
            case 7: {
                return pSRobotAbilityBase.getPSRobotAbilityName() == null;
            }
            case 8: {
                return pSRobotAbilityBase.getPSRobotWorkId() == null;
            }
            case 9: {
                return pSRobotAbilityBase.getPSRobotWorkName() == null;
            }
            case 10: {
                return pSRobotAbilityBase.getTypeObj() == null;
            }
            case 11: {
                return pSRobotAbilityBase.getUpdateDate() == null;
            }
            case 12: {
                return pSRobotAbilityBase.getUpdateMan() == null;
            }
            case 13: {
                return pSRobotAbilityBase.getValidFlag() == null;
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
        return PSRobotAbilityBase.contains(this, n);
    }

    private static boolean contains(PSRobotAbilityBase pSRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotAbilityBase.isAbilityTagDirty();
            }
            case 1: {
                return pSRobotAbilityBase.isAbilityTag2Dirty();
            }
            case 2: {
                return pSRobotAbilityBase.isCreateDateDirty();
            }
            case 3: {
                return pSRobotAbilityBase.isCreateManDirty();
            }
            case 4: {
                return pSRobotAbilityBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSRobotAbilityBase.isMemoDirty();
            }
            case 6: {
                return pSRobotAbilityBase.isPSRobotAbilityIdDirty();
            }
            case 7: {
                return pSRobotAbilityBase.isPSRobotAbilityNameDirty();
            }
            case 8: {
                return pSRobotAbilityBase.isPSRobotWorkIdDirty();
            }
            case 9: {
                return pSRobotAbilityBase.isPSRobotWorkNameDirty();
            }
            case 10: {
                return pSRobotAbilityBase.isTypeObjDirty();
            }
            case 11: {
                return pSRobotAbilityBase.isUpdateDateDirty();
            }
            case 12: {
                return pSRobotAbilityBase.isUpdateManDirty();
            }
            case 13: {
                return pSRobotAbilityBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotAbilityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotAbilityBase pSRobotAbilityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotAbilityBase.getAbilityTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"abilitytag", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getAbilityTag()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getAbilityTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"abilitytag2", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getAbilityTag2()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getPSRobotAbilityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotabilityid", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getPSRobotAbilityId()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getPSRobotAbilityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotabilityname", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getPSRobotAbilityName()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getPSRobotWorkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworkid", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getPSRobotWorkId()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getPSRobotWorkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworkname", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getPSRobotWorkName()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotAbilityBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotAbilityBase.getJSONValue((Object)pSRobotAbilityBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotAbilityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotAbilityBase pSRobotAbilityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotAbilityBase.getAbilityTag() != null) {
            object = pSRobotAbilityBase.getAbilityTag();
            xmlNode.setAttribute(FIELD_ABILITYTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSRobotAbilityBase.getAbilityTag2() != null) {
            object = pSRobotAbilityBase.getAbilityTag2();
            xmlNode.setAttribute(FIELD_ABILITYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getCreateDate() != null) {
            object = pSRobotAbilityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotAbilityBase.getCreateMan() != null) {
            object = pSRobotAbilityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getDefaultFlag() != null) {
            object = pSRobotAbilityBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotAbilityBase.getMemo() != null) {
            object = pSRobotAbilityBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getPSRobotAbilityId() != null) {
            object = pSRobotAbilityBase.getPSRobotAbilityId();
            xmlNode.setAttribute(FIELD_PSROBOTABILITYID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getPSRobotAbilityName() != null) {
            object = pSRobotAbilityBase.getPSRobotAbilityName();
            xmlNode.setAttribute(FIELD_PSROBOTABILITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getPSRobotWorkId() != null) {
            object = pSRobotAbilityBase.getPSRobotWorkId();
            xmlNode.setAttribute(FIELD_PSROBOTWORKID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getPSRobotWorkName() != null) {
            object = pSRobotAbilityBase.getPSRobotWorkName();
            xmlNode.setAttribute(FIELD_PSROBOTWORKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getTypeObj() != null) {
            object = pSRobotAbilityBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getUpdateDate() != null) {
            object = pSRobotAbilityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotAbilityBase.getUpdateMan() != null) {
            object = pSRobotAbilityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotAbilityBase.getValidFlag() != null) {
            object = pSRobotAbilityBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotAbilityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotAbilityBase pSRobotAbilityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotAbilityBase.isAbilityTagDirty() && (bl || pSRobotAbilityBase.getAbilityTag() != null)) {
            iDataObject.set(FIELD_ABILITYTAG, (Object)pSRobotAbilityBase.getAbilityTag());
        }
        if (pSRobotAbilityBase.isAbilityTag2Dirty() && (bl || pSRobotAbilityBase.getAbilityTag2() != null)) {
            iDataObject.set(FIELD_ABILITYTAG2, (Object)pSRobotAbilityBase.getAbilityTag2());
        }
        if (pSRobotAbilityBase.isCreateDateDirty() && (bl || pSRobotAbilityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotAbilityBase.getCreateDate());
        }
        if (pSRobotAbilityBase.isCreateManDirty() && (bl || pSRobotAbilityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotAbilityBase.getCreateMan());
        }
        if (pSRobotAbilityBase.isDefaultFlagDirty() && (bl || pSRobotAbilityBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSRobotAbilityBase.getDefaultFlag());
        }
        if (pSRobotAbilityBase.isMemoDirty() && (bl || pSRobotAbilityBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotAbilityBase.getMemo());
        }
        if (pSRobotAbilityBase.isPSRobotAbilityIdDirty() && (bl || pSRobotAbilityBase.getPSRobotAbilityId() != null)) {
            iDataObject.set(FIELD_PSROBOTABILITYID, (Object)pSRobotAbilityBase.getPSRobotAbilityId());
        }
        if (pSRobotAbilityBase.isPSRobotAbilityNameDirty() && (bl || pSRobotAbilityBase.getPSRobotAbilityName() != null)) {
            iDataObject.set(FIELD_PSROBOTABILITYNAME, (Object)pSRobotAbilityBase.getPSRobotAbilityName());
        }
        if (pSRobotAbilityBase.isPSRobotWorkIdDirty() && (bl || pSRobotAbilityBase.getPSRobotWorkId() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKID, (Object)pSRobotAbilityBase.getPSRobotWorkId());
        }
        if (pSRobotAbilityBase.isPSRobotWorkNameDirty() && (bl || pSRobotAbilityBase.getPSRobotWorkName() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKNAME, (Object)pSRobotAbilityBase.getPSRobotWorkName());
        }
        if (pSRobotAbilityBase.isTypeObjDirty() && (bl || pSRobotAbilityBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSRobotAbilityBase.getTypeObj());
        }
        if (pSRobotAbilityBase.isUpdateDateDirty() && (bl || pSRobotAbilityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotAbilityBase.getUpdateDate());
        }
        if (pSRobotAbilityBase.isUpdateManDirty() && (bl || pSRobotAbilityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotAbilityBase.getUpdateMan());
        }
        if (pSRobotAbilityBase.isValidFlagDirty() && (bl || pSRobotAbilityBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotAbilityBase.getValidFlag());
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
        return PSRobotAbilityBase.remove(this, n);
    }

    private static boolean remove(PSRobotAbilityBase pSRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotAbilityBase.resetAbilityTag();
                return true;
            }
            case 1: {
                pSRobotAbilityBase.resetAbilityTag2();
                return true;
            }
            case 2: {
                pSRobotAbilityBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSRobotAbilityBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSRobotAbilityBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSRobotAbilityBase.resetMemo();
                return true;
            }
            case 6: {
                pSRobotAbilityBase.resetPSRobotAbilityId();
                return true;
            }
            case 7: {
                pSRobotAbilityBase.resetPSRobotAbilityName();
                return true;
            }
            case 8: {
                pSRobotAbilityBase.resetPSRobotWorkId();
                return true;
            }
            case 9: {
                pSRobotAbilityBase.resetPSRobotWorkName();
                return true;
            }
            case 10: {
                pSRobotAbilityBase.resetTypeObj();
                return true;
            }
            case 11: {
                pSRobotAbilityBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSRobotAbilityBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSRobotAbilityBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRobotWork getPSRobotWork() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWork();
        }
        if (this.getPSRobotWorkId() == null) {
            return null;
        }
        Integer n = this.objPSRobotWorkLock;
        synchronized (n) {
            if (this.psrobotwork != null && DataTypeHelper.compare((int)25, (Object)this.getPSRobotWorkId(), (Object)this.psrobotwork.getPSRobotWorkId()) != 0L) {
                this.psrobotwork = null;
            }
            if (this.psrobotwork == null) {
                PSRobotWork pSRobotWork = new PSRobotWork();
                pSRobotWork.setPSRobotWorkId(this.getPSRobotWorkId());
                PSRobotWorkService pSRobotWorkService = (PSRobotWorkService)ServiceGlobal.getService(PSRobotWorkService.class, (SessionFactory)this.getSessionFactory());
                pSRobotWorkService.autoGet((IEntity)pSRobotWork);
                this.psrobotwork = pSRobotWork;
            }
            return this.psrobotwork;
        }
    }

    private PSRobotAbilityBase getProxyEntity() {
        return this.proxyPSRobotAbilityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotAbilityBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotAbilityBase) {
            this.proxyPSRobotAbilityBase = (PSRobotAbilityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotAbilityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ABILITYTAG, 0);
        fieldIndexMap.put(FIELD_ABILITYTAG2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSROBOTABILITYID, 6);
        fieldIndexMap.put(FIELD_PSROBOTABILITYNAME, 7);
        fieldIndexMap.put(FIELD_PSROBOTWORKID, 8);
        fieldIndexMap.put(FIELD_PSROBOTWORKNAME, 9);
        fieldIndexMap.put(FIELD_TYPEOBJ, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

