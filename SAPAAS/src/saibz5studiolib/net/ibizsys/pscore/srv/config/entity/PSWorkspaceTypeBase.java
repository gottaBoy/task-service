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

public abstract class PSWorkspaceTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkspaceTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENTITYLIST = "ENTITYLIST";
    public static final String FIELD_EXP = "EXP";
    public static final String FIELD_EXP2 = "EXP2";
    public static final String FIELD_MAXDEVUSER = "MAXDEVUSER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELLIMITS = "PSMODELLIMITS";
    public static final String FIELD_PSWORKSPACETYPEID = "PSWORKSPACETYPEID";
    public static final String FIELD_PSWORKSPACETYPENAME = "PSWORKSPACETYPENAME";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKSPACEMODE = "WORKSPACEMODE";
    public static final String FIELD_WORKSPACEUSAGE = "WORKSPACEUSAGE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENTITYLIST = 2;
    private static final int INDEX_EXP = 3;
    private static final int INDEX_EXP2 = 4;
    private static final int INDEX_MAXDEVUSER = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSMODELLIMITS = 7;
    private static final int INDEX_PSWORKSPACETYPEID = 8;
    private static final int INDEX_PSWORKSPACETYPENAME = 9;
    private static final int INDEX_TYPEPARAMS = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final int INDEX_WORKSPACEMODE = 16;
    private static final int INDEX_WORKSPACEUSAGE = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkspaceTypeBase proxyPSWorkspaceTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean entitylistDirtyFlag = false;
    private boolean expDirtyFlag = false;
    private boolean exp2DirtyFlag = false;
    private boolean maxdevuserDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodellimitsDirtyFlag = false;
    private boolean psworkspacetypeidDirtyFlag = false;
    private boolean psworkspacetypenameDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workspacemodeDirtyFlag = false;
    private boolean workspaceusageDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="entitylist")
    private String entitylist;
    @Column(name="exp")
    private Double exp;
    @Column(name="exp2")
    private Double exp2;
    @Column(name="maxdevuser")
    private Integer maxdevuser;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodellimits")
    private String psmodellimits;
    @Column(name="psworkspacetypeid")
    private String psworkspacetypeid;
    @Column(name="psworkspacetypename")
    private String psworkspacetypename;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="workspacemode")
    private String workspacemode;
    @Column(name="workspaceusage")
    private String workspaceusage;

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

    public void setEntityList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEntityList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.entitylist = string;
        this.entitylistDirtyFlag = true;
    }

    public String getEntityList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEntityList();
        }
        return this.entitylist;
    }

    public boolean isEntityListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEntityListDirty();
        }
        return this.entitylistDirtyFlag;
    }

    public void resetEntityList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEntityList();
            return;
        }
        this.entitylistDirtyFlag = false;
        this.entitylist = null;
    }

    public void setExp(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp(d);
            return;
        }
        this.exp = d;
        this.expDirtyFlag = true;
    }

    public Double getExp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp();
        }
        return this.exp;
    }

    public boolean isExpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpDirty();
        }
        return this.expDirtyFlag;
    }

    public void resetExp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp();
            return;
        }
        this.expDirtyFlag = false;
        this.exp = null;
    }

    public void setExp2(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp2(d);
            return;
        }
        this.exp2 = d;
        this.exp2DirtyFlag = true;
    }

    public Double getExp2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp2();
        }
        return this.exp2;
    }

    public boolean isExp2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp2Dirty();
        }
        return this.exp2DirtyFlag;
    }

    public void resetExp2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp2();
            return;
        }
        this.exp2DirtyFlag = false;
        this.exp2 = null;
    }

    public void setMaxDevUser(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevUser(n);
            return;
        }
        this.maxdevuser = n;
        this.maxdevuserDirtyFlag = true;
    }

    public Integer getMaxDevUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevUser();
        }
        return this.maxdevuser;
    }

    public boolean isMaxDevUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevUserDirty();
        }
        return this.maxdevuserDirtyFlag;
    }

    public void resetMaxDevUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevUser();
            return;
        }
        this.maxdevuserDirtyFlag = false;
        this.maxdevuser = null;
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

    public void setPSModelLimits(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelLimits(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodellimits = string;
        this.psmodellimitsDirtyFlag = true;
    }

    public String getPSModelLimits() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelLimits();
        }
        return this.psmodellimits;
    }

    public boolean isPSModelLimitsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelLimitsDirty();
        }
        return this.psmodellimitsDirtyFlag;
    }

    public void resetPSModelLimits() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelLimits();
            return;
        }
        this.psmodellimitsDirtyFlag = false;
        this.psmodellimits = null;
    }

    public void setPSWorkspaceTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacetypeid = string;
        this.psworkspacetypeidDirtyFlag = true;
    }

    public String getPSWorkspaceTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceTypeId();
        }
        return this.psworkspacetypeid;
    }

    public boolean isPSWorkspaceTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceTypeIdDirty();
        }
        return this.psworkspacetypeidDirtyFlag;
    }

    public void resetPSWorkspaceTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceTypeId();
            return;
        }
        this.psworkspacetypeidDirtyFlag = false;
        this.psworkspacetypeid = null;
    }

    public void setPSWorkspaceTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacetypename = string;
        this.psworkspacetypenameDirtyFlag = true;
    }

    public String getPSWorkspaceTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceTypeName();
        }
        return this.psworkspacetypename;
    }

    public boolean isPSWorkspaceTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceTypeNameDirty();
        }
        return this.psworkspacetypenameDirtyFlag;
    }

    public void resetPSWorkspaceTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceTypeName();
            return;
        }
        this.psworkspacetypenameDirtyFlag = false;
        this.psworkspacetypename = null;
    }

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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

    public void setWorkspaceMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspacemode = string;
        this.workspacemodeDirtyFlag = true;
    }

    public String getWorkspaceMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceMode();
        }
        return this.workspacemode;
    }

    public boolean isWorkspaceModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceModeDirty();
        }
        return this.workspacemodeDirtyFlag;
    }

    public void resetWorkspaceMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceMode();
            return;
        }
        this.workspacemodeDirtyFlag = false;
        this.workspacemode = null;
    }

    public void setWorkspaceUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspaceusage = string;
        this.workspaceusageDirtyFlag = true;
    }

    public String getWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceUsage();
        }
        return this.workspaceusage;
    }

    public boolean isWorkspaceUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceUsageDirty();
        }
        return this.workspaceusageDirtyFlag;
    }

    public void resetWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceUsage();
            return;
        }
        this.workspaceusageDirtyFlag = false;
        this.workspaceusage = null;
    }

    protected void onReset() {
        PSWorkspaceTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkspaceTypeBase pSWorkspaceTypeBase) {
        pSWorkspaceTypeBase.resetCreateDate();
        pSWorkspaceTypeBase.resetCreateMan();
        pSWorkspaceTypeBase.resetEntityList();
        pSWorkspaceTypeBase.resetExp();
        pSWorkspaceTypeBase.resetExp2();
        pSWorkspaceTypeBase.resetMaxDevUser();
        pSWorkspaceTypeBase.resetMemo();
        pSWorkspaceTypeBase.resetPSModelLimits();
        pSWorkspaceTypeBase.resetPSWorkspaceTypeId();
        pSWorkspaceTypeBase.resetPSWorkspaceTypeName();
        pSWorkspaceTypeBase.resetTypeParams();
        pSWorkspaceTypeBase.resetUpdateDate();
        pSWorkspaceTypeBase.resetUpdateMan();
        pSWorkspaceTypeBase.resetUserTag();
        pSWorkspaceTypeBase.resetUserTag2();
        pSWorkspaceTypeBase.resetValidFlag();
        pSWorkspaceTypeBase.resetWorkspaceMode();
        pSWorkspaceTypeBase.resetWorkspaceUsage();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEntityListDirty()) {
            hashMap.put(FIELD_ENTITYLIST, this.getEntityList());
        }
        if (!bl || this.isExpDirty()) {
            hashMap.put(FIELD_EXP, this.getExp());
        }
        if (!bl || this.isExp2Dirty()) {
            hashMap.put(FIELD_EXP2, this.getExp2());
        }
        if (!bl || this.isMaxDevUserDirty()) {
            hashMap.put(FIELD_MAXDEVUSER, this.getMaxDevUser());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModelLimitsDirty()) {
            hashMap.put(FIELD_PSMODELLIMITS, this.getPSModelLimits());
        }
        if (!bl || this.isPSWorkspaceTypeIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACETYPEID, this.getPSWorkspaceTypeId());
        }
        if (!bl || this.isPSWorkspaceTypeNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACETYPENAME, this.getPSWorkspaceTypeName());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWorkspaceModeDirty()) {
            hashMap.put(FIELD_WORKSPACEMODE, this.getWorkspaceMode());
        }
        if (!bl || this.isWorkspaceUsageDirty()) {
            hashMap.put(FIELD_WORKSPACEUSAGE, this.getWorkspaceUsage());
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
        return PSWorkspaceTypeBase.get(this, n);
    }

    private static Object get(PSWorkspaceTypeBase pSWorkspaceTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceTypeBase.getCreateDate();
            }
            case 1: {
                return pSWorkspaceTypeBase.getCreateMan();
            }
            case 2: {
                return pSWorkspaceTypeBase.getEntityList();
            }
            case 3: {
                return pSWorkspaceTypeBase.getExp();
            }
            case 4: {
                return pSWorkspaceTypeBase.getExp2();
            }
            case 5: {
                return pSWorkspaceTypeBase.getMaxDevUser();
            }
            case 6: {
                return pSWorkspaceTypeBase.getMemo();
            }
            case 7: {
                return pSWorkspaceTypeBase.getPSModelLimits();
            }
            case 8: {
                return pSWorkspaceTypeBase.getPSWorkspaceTypeId();
            }
            case 9: {
                return pSWorkspaceTypeBase.getPSWorkspaceTypeName();
            }
            case 10: {
                return pSWorkspaceTypeBase.getTypeParams();
            }
            case 11: {
                return pSWorkspaceTypeBase.getUpdateDate();
            }
            case 12: {
                return pSWorkspaceTypeBase.getUpdateMan();
            }
            case 13: {
                return pSWorkspaceTypeBase.getUserTag();
            }
            case 14: {
                return pSWorkspaceTypeBase.getUserTag2();
            }
            case 15: {
                return pSWorkspaceTypeBase.getValidFlag();
            }
            case 16: {
                return pSWorkspaceTypeBase.getWorkspaceMode();
            }
            case 17: {
                return pSWorkspaceTypeBase.getWorkspaceUsage();
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
        PSWorkspaceTypeBase.set(this, n, object);
    }

    private static void set(PSWorkspaceTypeBase pSWorkspaceTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWorkspaceTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWorkspaceTypeBase.setEntityList(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkspaceTypeBase.setExp(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSWorkspaceTypeBase.setExp2(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 5: {
                pSWorkspaceTypeBase.setMaxDevUser(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSWorkspaceTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWorkspaceTypeBase.setPSModelLimits(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWorkspaceTypeBase.setPSWorkspaceTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWorkspaceTypeBase.setPSWorkspaceTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWorkspaceTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWorkspaceTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSWorkspaceTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWorkspaceTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWorkspaceTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWorkspaceTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSWorkspaceTypeBase.setWorkspaceMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWorkspaceTypeBase.setWorkspaceUsage(DataObject.getStringValue((Object)object));
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
        return PSWorkspaceTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkspaceTypeBase pSWorkspaceTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSWorkspaceTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSWorkspaceTypeBase.getEntityList() == null;
            }
            case 3: {
                return pSWorkspaceTypeBase.getExp() == null;
            }
            case 4: {
                return pSWorkspaceTypeBase.getExp2() == null;
            }
            case 5: {
                return pSWorkspaceTypeBase.getMaxDevUser() == null;
            }
            case 6: {
                return pSWorkspaceTypeBase.getMemo() == null;
            }
            case 7: {
                return pSWorkspaceTypeBase.getPSModelLimits() == null;
            }
            case 8: {
                return pSWorkspaceTypeBase.getPSWorkspaceTypeId() == null;
            }
            case 9: {
                return pSWorkspaceTypeBase.getPSWorkspaceTypeName() == null;
            }
            case 10: {
                return pSWorkspaceTypeBase.getTypeParams() == null;
            }
            case 11: {
                return pSWorkspaceTypeBase.getUpdateDate() == null;
            }
            case 12: {
                return pSWorkspaceTypeBase.getUpdateMan() == null;
            }
            case 13: {
                return pSWorkspaceTypeBase.getUserTag() == null;
            }
            case 14: {
                return pSWorkspaceTypeBase.getUserTag2() == null;
            }
            case 15: {
                return pSWorkspaceTypeBase.getValidFlag() == null;
            }
            case 16: {
                return pSWorkspaceTypeBase.getWorkspaceMode() == null;
            }
            case 17: {
                return pSWorkspaceTypeBase.getWorkspaceUsage() == null;
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
        return PSWorkspaceTypeBase.contains(this, n);
    }

    private static boolean contains(PSWorkspaceTypeBase pSWorkspaceTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSWorkspaceTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSWorkspaceTypeBase.isEntityListDirty();
            }
            case 3: {
                return pSWorkspaceTypeBase.isExpDirty();
            }
            case 4: {
                return pSWorkspaceTypeBase.isExp2Dirty();
            }
            case 5: {
                return pSWorkspaceTypeBase.isMaxDevUserDirty();
            }
            case 6: {
                return pSWorkspaceTypeBase.isMemoDirty();
            }
            case 7: {
                return pSWorkspaceTypeBase.isPSModelLimitsDirty();
            }
            case 8: {
                return pSWorkspaceTypeBase.isPSWorkspaceTypeIdDirty();
            }
            case 9: {
                return pSWorkspaceTypeBase.isPSWorkspaceTypeNameDirty();
            }
            case 10: {
                return pSWorkspaceTypeBase.isTypeParamsDirty();
            }
            case 11: {
                return pSWorkspaceTypeBase.isUpdateDateDirty();
            }
            case 12: {
                return pSWorkspaceTypeBase.isUpdateManDirty();
            }
            case 13: {
                return pSWorkspaceTypeBase.isUserTagDirty();
            }
            case 14: {
                return pSWorkspaceTypeBase.isUserTag2Dirty();
            }
            case 15: {
                return pSWorkspaceTypeBase.isValidFlagDirty();
            }
            case 16: {
                return pSWorkspaceTypeBase.isWorkspaceModeDirty();
            }
            case 17: {
                return pSWorkspaceTypeBase.isWorkspaceUsageDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkspaceTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkspaceTypeBase pSWorkspaceTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkspaceTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getEntityList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"entitylist", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getEntityList()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getExp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getExp()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getExp2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp2", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getExp2()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getMaxDevUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevuser", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getMaxDevUser()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getPSModelLimits() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodellimits", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getPSModelLimits()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacetypeid", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getPSWorkspaceTypeId()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacetypename", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getPSWorkspaceTypeName()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getWorkspaceMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacemode", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getWorkspaceMode()), (boolean)false);
        }
        if (bl || pSWorkspaceTypeBase.getWorkspaceUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspaceusage", (Object)PSWorkspaceTypeBase.getJSONValue((Object)pSWorkspaceTypeBase.getWorkspaceUsage()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkspaceTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkspaceTypeBase pSWorkspaceTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkspaceTypeBase.getCreateDate() != null) {
            object = pSWorkspaceTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getCreateMan() != null) {
            object = pSWorkspaceTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getEntityList() != null) {
            object = pSWorkspaceTypeBase.getEntityList();
            xmlNode.setAttribute(FIELD_ENTITYLIST, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getExp() != null) {
            object = pSWorkspaceTypeBase.getExp();
            xmlNode.setAttribute(FIELD_EXP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getExp2() != null) {
            object = pSWorkspaceTypeBase.getExp2();
            xmlNode.setAttribute(FIELD_EXP2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getMaxDevUser() != null) {
            object = pSWorkspaceTypeBase.getMaxDevUser();
            xmlNode.setAttribute(FIELD_MAXDEVUSER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getMemo() != null) {
            object = pSWorkspaceTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getPSModelLimits() != null) {
            object = pSWorkspaceTypeBase.getPSModelLimits();
            xmlNode.setAttribute(FIELD_PSMODELLIMITS, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeId() != null) {
            object = pSWorkspaceTypeBase.getPSWorkspaceTypeId();
            xmlNode.setAttribute(FIELD_PSWORKSPACETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeName() != null) {
            object = pSWorkspaceTypeBase.getPSWorkspaceTypeName();
            xmlNode.setAttribute(FIELD_PSWORKSPACETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getTypeParams() != null) {
            object = pSWorkspaceTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getUpdateDate() != null) {
            object = pSWorkspaceTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getUpdateMan() != null) {
            object = pSWorkspaceTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getUserTag() != null) {
            object = pSWorkspaceTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getUserTag2() != null) {
            object = pSWorkspaceTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getValidFlag() != null) {
            object = pSWorkspaceTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceTypeBase.getWorkspaceMode() != null) {
            object = pSWorkspaceTypeBase.getWorkspaceMode();
            xmlNode.setAttribute(FIELD_WORKSPACEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceTypeBase.getWorkspaceUsage() != null) {
            object = pSWorkspaceTypeBase.getWorkspaceUsage();
            xmlNode.setAttribute(FIELD_WORKSPACEUSAGE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkspaceTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkspaceTypeBase pSWorkspaceTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkspaceTypeBase.isCreateDateDirty() && (bl || pSWorkspaceTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkspaceTypeBase.getCreateDate());
        }
        if (pSWorkspaceTypeBase.isCreateManDirty() && (bl || pSWorkspaceTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkspaceTypeBase.getCreateMan());
        }
        if (pSWorkspaceTypeBase.isEntityListDirty() && (bl || pSWorkspaceTypeBase.getEntityList() != null)) {
            iDataObject.set(FIELD_ENTITYLIST, (Object)pSWorkspaceTypeBase.getEntityList());
        }
        if (pSWorkspaceTypeBase.isExpDirty() && (bl || pSWorkspaceTypeBase.getExp() != null)) {
            iDataObject.set(FIELD_EXP, (Object)pSWorkspaceTypeBase.getExp());
        }
        if (pSWorkspaceTypeBase.isExp2Dirty() && (bl || pSWorkspaceTypeBase.getExp2() != null)) {
            iDataObject.set(FIELD_EXP2, (Object)pSWorkspaceTypeBase.getExp2());
        }
        if (pSWorkspaceTypeBase.isMaxDevUserDirty() && (bl || pSWorkspaceTypeBase.getMaxDevUser() != null)) {
            iDataObject.set(FIELD_MAXDEVUSER, (Object)pSWorkspaceTypeBase.getMaxDevUser());
        }
        if (pSWorkspaceTypeBase.isMemoDirty() && (bl || pSWorkspaceTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWorkspaceTypeBase.getMemo());
        }
        if (pSWorkspaceTypeBase.isPSModelLimitsDirty() && (bl || pSWorkspaceTypeBase.getPSModelLimits() != null)) {
            iDataObject.set(FIELD_PSMODELLIMITS, (Object)pSWorkspaceTypeBase.getPSModelLimits());
        }
        if (pSWorkspaceTypeBase.isPSWorkspaceTypeIdDirty() && (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACETYPEID, (Object)pSWorkspaceTypeBase.getPSWorkspaceTypeId());
        }
        if (pSWorkspaceTypeBase.isPSWorkspaceTypeNameDirty() && (bl || pSWorkspaceTypeBase.getPSWorkspaceTypeName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACETYPENAME, (Object)pSWorkspaceTypeBase.getPSWorkspaceTypeName());
        }
        if (pSWorkspaceTypeBase.isTypeParamsDirty() && (bl || pSWorkspaceTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSWorkspaceTypeBase.getTypeParams());
        }
        if (pSWorkspaceTypeBase.isUpdateDateDirty() && (bl || pSWorkspaceTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkspaceTypeBase.getUpdateDate());
        }
        if (pSWorkspaceTypeBase.isUpdateManDirty() && (bl || pSWorkspaceTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkspaceTypeBase.getUpdateMan());
        }
        if (pSWorkspaceTypeBase.isUserTagDirty() && (bl || pSWorkspaceTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWorkspaceTypeBase.getUserTag());
        }
        if (pSWorkspaceTypeBase.isUserTag2Dirty() && (bl || pSWorkspaceTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWorkspaceTypeBase.getUserTag2());
        }
        if (pSWorkspaceTypeBase.isValidFlagDirty() && (bl || pSWorkspaceTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWorkspaceTypeBase.getValidFlag());
        }
        if (pSWorkspaceTypeBase.isWorkspaceModeDirty() && (bl || pSWorkspaceTypeBase.getWorkspaceMode() != null)) {
            iDataObject.set(FIELD_WORKSPACEMODE, (Object)pSWorkspaceTypeBase.getWorkspaceMode());
        }
        if (pSWorkspaceTypeBase.isWorkspaceUsageDirty() && (bl || pSWorkspaceTypeBase.getWorkspaceUsage() != null)) {
            iDataObject.set(FIELD_WORKSPACEUSAGE, (Object)pSWorkspaceTypeBase.getWorkspaceUsage());
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
        return PSWorkspaceTypeBase.remove(this, n);
    }

    private static boolean remove(PSWorkspaceTypeBase pSWorkspaceTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWorkspaceTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWorkspaceTypeBase.resetEntityList();
                return true;
            }
            case 3: {
                pSWorkspaceTypeBase.resetExp();
                return true;
            }
            case 4: {
                pSWorkspaceTypeBase.resetExp2();
                return true;
            }
            case 5: {
                pSWorkspaceTypeBase.resetMaxDevUser();
                return true;
            }
            case 6: {
                pSWorkspaceTypeBase.resetMemo();
                return true;
            }
            case 7: {
                pSWorkspaceTypeBase.resetPSModelLimits();
                return true;
            }
            case 8: {
                pSWorkspaceTypeBase.resetPSWorkspaceTypeId();
                return true;
            }
            case 9: {
                pSWorkspaceTypeBase.resetPSWorkspaceTypeName();
                return true;
            }
            case 10: {
                pSWorkspaceTypeBase.resetTypeParams();
                return true;
            }
            case 11: {
                pSWorkspaceTypeBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSWorkspaceTypeBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSWorkspaceTypeBase.resetUserTag();
                return true;
            }
            case 14: {
                pSWorkspaceTypeBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSWorkspaceTypeBase.resetValidFlag();
                return true;
            }
            case 16: {
                pSWorkspaceTypeBase.resetWorkspaceMode();
                return true;
            }
            case 17: {
                pSWorkspaceTypeBase.resetWorkspaceUsage();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSWorkspaceTypeBase getProxyEntity() {
        return this.proxyPSWorkspaceTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkspaceTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkspaceTypeBase) {
            this.proxyPSWorkspaceTypeBase = (PSWorkspaceTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSWorkspaceTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENTITYLIST, 2);
        fieldIndexMap.put(FIELD_EXP, 3);
        fieldIndexMap.put(FIELD_EXP2, 4);
        fieldIndexMap.put(FIELD_MAXDEVUSER, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSMODELLIMITS, 7);
        fieldIndexMap.put(FIELD_PSWORKSPACETYPEID, 8);
        fieldIndexMap.put(FIELD_PSWORKSPACETYPENAME, 9);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
        fieldIndexMap.put(FIELD_WORKSPACEMODE, 16);
        fieldIndexMap.put(FIELD_WORKSPACEUSAGE, 17);
    }
}

