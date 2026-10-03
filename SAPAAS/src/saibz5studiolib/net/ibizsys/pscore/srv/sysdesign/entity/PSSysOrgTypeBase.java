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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOrgTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysOrgTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSORGTYPEID = "PSSYSORGTYPEID";
    public static final String FIELD_PSSYSORGTYPENAME = "PSSYSORGTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODULEID = 3;
    private static final int INDEX_PSMODULENAME = 4;
    private static final int INDEX_PSSYSORGTYPEID = 5;
    private static final int INDEX_PSSYSORGTYPENAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_TYPECODE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysOrgTypeBase proxyPSSysOrgTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysorgtypeidDirtyFlag = false;
    private boolean pssysorgtypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysorgtypeid")
    private String pssysorgtypeid;
    @Column(name="pssysorgtypename")
    private String pssysorgtypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="typecode")
    private String typecode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPssystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysOrgTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOrgTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysorgtypeid = string;
        this.pssysorgtypeidDirtyFlag = true;
    }

    public String getPSSysOrgTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOrgTypeId();
        }
        return this.pssysorgtypeid;
    }

    public boolean isPSSysOrgTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOrgTypeIdDirty();
        }
        return this.pssysorgtypeidDirtyFlag;
    }

    public void resetPSSysOrgTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOrgTypeId();
            return;
        }
        this.pssysorgtypeidDirtyFlag = false;
        this.pssysorgtypeid = null;
    }

    public void setPSSysOrgTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOrgTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysorgtypename = string;
        this.pssysorgtypenameDirtyFlag = true;
    }

    public String getPSSysOrgTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOrgTypeName();
        }
        return this.pssysorgtypename;
    }

    public boolean isPSSysOrgTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOrgTypeNameDirty();
        }
        return this.pssysorgtypenameDirtyFlag;
    }

    public void resetPSSysOrgTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOrgTypeName();
            return;
        }
        this.pssysorgtypenameDirtyFlag = false;
        this.pssysorgtypename = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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
        PSSysOrgTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysOrgTypeBase pSSysOrgTypeBase) {
        pSSysOrgTypeBase.resetCreateDate();
        pSSysOrgTypeBase.resetCreateMan();
        pSSysOrgTypeBase.resetMemo();
        pSSysOrgTypeBase.resetPSModuleId();
        pSSysOrgTypeBase.resetPSModuleName();
        pSSysOrgTypeBase.resetPSSysOrgTypeId();
        pSSysOrgTypeBase.resetPSSysOrgTypeName();
        pSSysOrgTypeBase.resetPSSystemId();
        pSSysOrgTypeBase.resetPSSystemName();
        pSSysOrgTypeBase.resetTypeCode();
        pSSysOrgTypeBase.resetUpdateDate();
        pSSysOrgTypeBase.resetUpdateMan();
        pSSysOrgTypeBase.resetUserCat();
        pSSysOrgTypeBase.resetUserTag();
        pSSysOrgTypeBase.resetUserTag2();
        pSSysOrgTypeBase.resetUserTag3();
        pSSysOrgTypeBase.resetUserTag4();
        pSSysOrgTypeBase.resetValidFlag();
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysOrgTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSORGTYPEID, this.getPSSysOrgTypeId());
        }
        if (!bl || this.isPSSysOrgTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSORGTYPENAME, this.getPSSysOrgTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSSysOrgTypeBase.get(this, n);
    }

    private static Object get(PSSysOrgTypeBase pSSysOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOrgTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysOrgTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysOrgTypeBase.getMemo();
            }
            case 3: {
                return pSSysOrgTypeBase.getPSModuleId();
            }
            case 4: {
                return pSSysOrgTypeBase.getPSModuleName();
            }
            case 5: {
                return pSSysOrgTypeBase.getPSSysOrgTypeId();
            }
            case 6: {
                return pSSysOrgTypeBase.getPSSysOrgTypeName();
            }
            case 7: {
                return pSSysOrgTypeBase.getPSSystemId();
            }
            case 8: {
                return pSSysOrgTypeBase.getPSSystemName();
            }
            case 9: {
                return pSSysOrgTypeBase.getTypeCode();
            }
            case 10: {
                return pSSysOrgTypeBase.getUpdateDate();
            }
            case 11: {
                return pSSysOrgTypeBase.getUpdateMan();
            }
            case 12: {
                return pSSysOrgTypeBase.getUserCat();
            }
            case 13: {
                return pSSysOrgTypeBase.getUserTag();
            }
            case 14: {
                return pSSysOrgTypeBase.getUserTag2();
            }
            case 15: {
                return pSSysOrgTypeBase.getUserTag3();
            }
            case 16: {
                return pSSysOrgTypeBase.getUserTag4();
            }
            case 17: {
                return pSSysOrgTypeBase.getValidFlag();
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
        PSSysOrgTypeBase.set(this, n, object);
    }

    private static void set(PSSysOrgTypeBase pSSysOrgTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysOrgTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysOrgTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysOrgTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysOrgTypeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysOrgTypeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysOrgTypeBase.setPSSysOrgTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysOrgTypeBase.setPSSysOrgTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysOrgTypeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysOrgTypeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysOrgTypeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysOrgTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysOrgTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysOrgTypeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysOrgTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysOrgTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysOrgTypeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysOrgTypeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysOrgTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysOrgTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysOrgTypeBase pSSysOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOrgTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysOrgTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysOrgTypeBase.getMemo() == null;
            }
            case 3: {
                return pSSysOrgTypeBase.getPSModuleId() == null;
            }
            case 4: {
                return pSSysOrgTypeBase.getPSModuleName() == null;
            }
            case 5: {
                return pSSysOrgTypeBase.getPSSysOrgTypeId() == null;
            }
            case 6: {
                return pSSysOrgTypeBase.getPSSysOrgTypeName() == null;
            }
            case 7: {
                return pSSysOrgTypeBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysOrgTypeBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysOrgTypeBase.getTypeCode() == null;
            }
            case 10: {
                return pSSysOrgTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysOrgTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysOrgTypeBase.getUserCat() == null;
            }
            case 13: {
                return pSSysOrgTypeBase.getUserTag() == null;
            }
            case 14: {
                return pSSysOrgTypeBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysOrgTypeBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysOrgTypeBase.getUserTag4() == null;
            }
            case 17: {
                return pSSysOrgTypeBase.getValidFlag() == null;
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
        return PSSysOrgTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysOrgTypeBase pSSysOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOrgTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysOrgTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysOrgTypeBase.isMemoDirty();
            }
            case 3: {
                return pSSysOrgTypeBase.isPSModuleIdDirty();
            }
            case 4: {
                return pSSysOrgTypeBase.isPSModuleNameDirty();
            }
            case 5: {
                return pSSysOrgTypeBase.isPSSysOrgTypeIdDirty();
            }
            case 6: {
                return pSSysOrgTypeBase.isPSSysOrgTypeNameDirty();
            }
            case 7: {
                return pSSysOrgTypeBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysOrgTypeBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysOrgTypeBase.isTypeCodeDirty();
            }
            case 10: {
                return pSSysOrgTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysOrgTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysOrgTypeBase.isUserCatDirty();
            }
            case 13: {
                return pSSysOrgTypeBase.isUserTagDirty();
            }
            case 14: {
                return pSSysOrgTypeBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysOrgTypeBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysOrgTypeBase.isUserTag4Dirty();
            }
            case 17: {
                return pSSysOrgTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysOrgTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysOrgTypeBase pSSysOrgTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysOrgTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSSysOrgTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysorgtypeid", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSSysOrgTypeId()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSSysOrgTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysorgtypename", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSSysOrgTypeName()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysOrgTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysOrgTypeBase.getJSONValue((Object)pSSysOrgTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysOrgTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysOrgTypeBase pSSysOrgTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysOrgTypeBase.getCreateDate() != null) {
            object = pSSysOrgTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOrgTypeBase.getCreateMan() != null) {
            object = pSSysOrgTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getMemo() != null) {
            object = pSSysOrgTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSModuleId() != null) {
            object = pSSysOrgTypeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSModuleName() != null) {
            object = pSSysOrgTypeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSSysOrgTypeId() != null) {
            object = pSSysOrgTypeBase.getPSSysOrgTypeId();
            xmlNode.setAttribute(FIELD_PSSYSORGTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSSysOrgTypeName() != null) {
            object = pSSysOrgTypeBase.getPSSysOrgTypeName();
            xmlNode.setAttribute(FIELD_PSSYSORGTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSSystemId() != null) {
            object = pSSysOrgTypeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getPSSystemName() != null) {
            object = pSSysOrgTypeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getTypeCode() != null) {
            object = pSSysOrgTypeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUpdateDate() != null) {
            object = pSSysOrgTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOrgTypeBase.getUpdateMan() != null) {
            object = pSSysOrgTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUserCat() != null) {
            object = pSSysOrgTypeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUserTag() != null) {
            object = pSSysOrgTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUserTag2() != null) {
            object = pSSysOrgTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUserTag3() != null) {
            object = pSSysOrgTypeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getUserTag4() != null) {
            object = pSSysOrgTypeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysOrgTypeBase.getValidFlag() != null) {
            object = pSSysOrgTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysOrgTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysOrgTypeBase pSSysOrgTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysOrgTypeBase.isCreateDateDirty() && (bl || pSSysOrgTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysOrgTypeBase.getCreateDate());
        }
        if (pSSysOrgTypeBase.isCreateManDirty() && (bl || pSSysOrgTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysOrgTypeBase.getCreateMan());
        }
        if (pSSysOrgTypeBase.isMemoDirty() && (bl || pSSysOrgTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysOrgTypeBase.getMemo());
        }
        if (pSSysOrgTypeBase.isPSModuleIdDirty() && (bl || pSSysOrgTypeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysOrgTypeBase.getPSModuleId());
        }
        if (pSSysOrgTypeBase.isPSModuleNameDirty() && (bl || pSSysOrgTypeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysOrgTypeBase.getPSModuleName());
        }
        if (pSSysOrgTypeBase.isPSSysOrgTypeIdDirty() && (bl || pSSysOrgTypeBase.getPSSysOrgTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSORGTYPEID, (Object)pSSysOrgTypeBase.getPSSysOrgTypeId());
        }
        if (pSSysOrgTypeBase.isPSSysOrgTypeNameDirty() && (bl || pSSysOrgTypeBase.getPSSysOrgTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSORGTYPENAME, (Object)pSSysOrgTypeBase.getPSSysOrgTypeName());
        }
        if (pSSysOrgTypeBase.isPSSystemIdDirty() && (bl || pSSysOrgTypeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysOrgTypeBase.getPSSystemId());
        }
        if (pSSysOrgTypeBase.isPSSystemNameDirty() && (bl || pSSysOrgTypeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysOrgTypeBase.getPSSystemName());
        }
        if (pSSysOrgTypeBase.isTypeCodeDirty() && (bl || pSSysOrgTypeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSSysOrgTypeBase.getTypeCode());
        }
        if (pSSysOrgTypeBase.isUpdateDateDirty() && (bl || pSSysOrgTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysOrgTypeBase.getUpdateDate());
        }
        if (pSSysOrgTypeBase.isUpdateManDirty() && (bl || pSSysOrgTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysOrgTypeBase.getUpdateMan());
        }
        if (pSSysOrgTypeBase.isUserCatDirty() && (bl || pSSysOrgTypeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysOrgTypeBase.getUserCat());
        }
        if (pSSysOrgTypeBase.isUserTagDirty() && (bl || pSSysOrgTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysOrgTypeBase.getUserTag());
        }
        if (pSSysOrgTypeBase.isUserTag2Dirty() && (bl || pSSysOrgTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysOrgTypeBase.getUserTag2());
        }
        if (pSSysOrgTypeBase.isUserTag3Dirty() && (bl || pSSysOrgTypeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysOrgTypeBase.getUserTag3());
        }
        if (pSSysOrgTypeBase.isUserTag4Dirty() && (bl || pSSysOrgTypeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysOrgTypeBase.getUserTag4());
        }
        if (pSSysOrgTypeBase.isValidFlagDirty() && (bl || pSSysOrgTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysOrgTypeBase.getValidFlag());
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
        return PSSysOrgTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysOrgTypeBase pSSysOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysOrgTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysOrgTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysOrgTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysOrgTypeBase.resetPSModuleId();
                return true;
            }
            case 4: {
                pSSysOrgTypeBase.resetPSModuleName();
                return true;
            }
            case 5: {
                pSSysOrgTypeBase.resetPSSysOrgTypeId();
                return true;
            }
            case 6: {
                pSSysOrgTypeBase.resetPSSysOrgTypeName();
                return true;
            }
            case 7: {
                pSSysOrgTypeBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysOrgTypeBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysOrgTypeBase.resetTypeCode();
                return true;
            }
            case 10: {
                pSSysOrgTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysOrgTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysOrgTypeBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysOrgTypeBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysOrgTypeBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysOrgTypeBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysOrgTypeBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSSysOrgTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPssystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPssystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysOrgTypeBase getProxyEntity() {
        return this.proxyPSSysOrgTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysOrgTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysOrgTypeBase) {
            this.proxyPSSysOrgTypeBase = (PSSysOrgTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOrgTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODULEID, 3);
        fieldIndexMap.put(FIELD_PSMODULENAME, 4);
        fieldIndexMap.put(FIELD_PSSYSORGTYPEID, 5);
        fieldIndexMap.put(FIELD_PSSYSORGTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_TYPECODE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

