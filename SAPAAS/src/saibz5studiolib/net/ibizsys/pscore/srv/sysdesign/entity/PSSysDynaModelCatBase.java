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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDynaModelCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDynaModelCatBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELCATID = "PSSYSDYNAMODELCATID";
    public static final String FIELD_PSSYSDYNAMODELCATNAME = "PSSYSDYNAMODELCATNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSDYNAMODELCATID = 7;
    private static final int INDEX_PSSYSDYNAMODELCATNAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_PSSYSTEMNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDynaModelCatBase proxyPSSysDynaModelCatBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelcatidDirtyFlag = false;
    private boolean pssysdynamodelcatnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelcatid")
    private String pssysdynamodelcatid;
    @Column(name="pssysdynamodelcatname")
    private String pssysdynamodelcatname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDynaModelsLock = new Integer(1);
    private ArrayList<PSSysDynaModel> pssysdynamodels = null;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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

    public void setPSSysDynaModelCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelcatid = string;
        this.pssysdynamodelcatidDirtyFlag = true;
    }

    public String getPSSysDynaModelCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelCatId();
        }
        return this.pssysdynamodelcatid;
    }

    public boolean isPSSysDynaModelCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelCatIdDirty();
        }
        return this.pssysdynamodelcatidDirtyFlag;
    }

    public void resetPSSysDynaModelCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelCatId();
            return;
        }
        this.pssysdynamodelcatidDirtyFlag = false;
        this.pssysdynamodelcatid = null;
    }

    public void setPSSysDynaModelCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelcatname = string;
        this.pssysdynamodelcatnameDirtyFlag = true;
    }

    public String getPSSysDynaModelCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelCatName();
        }
        return this.pssysdynamodelcatname;
    }

    public boolean isPSSysDynaModelCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelCatNameDirty();
        }
        return this.pssysdynamodelcatnameDirtyFlag;
    }

    public void resetPSSysDynaModelCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelCatName();
            return;
        }
        this.pssysdynamodelcatnameDirtyFlag = false;
        this.pssysdynamodelcatname = null;
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

    protected void onReset() {
        PSSysDynaModelCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDynaModelCatBase pSSysDynaModelCatBase) {
        pSSysDynaModelCatBase.resetCodeName();
        pSSysDynaModelCatBase.resetCreateDate();
        pSSysDynaModelCatBase.resetCreateMan();
        pSSysDynaModelCatBase.resetMemo();
        pSSysDynaModelCatBase.resetOrderValue();
        pSSysDynaModelCatBase.resetPSModuleId();
        pSSysDynaModelCatBase.resetPSModuleName();
        pSSysDynaModelCatBase.resetPSSysDynaModelCatId();
        pSSysDynaModelCatBase.resetPSSysDynaModelCatName();
        pSSysDynaModelCatBase.resetPSSystemId();
        pSSysDynaModelCatBase.resetPSSystemName();
        pSSysDynaModelCatBase.resetUpdateDate();
        pSSysDynaModelCatBase.resetUpdateMan();
        pSSysDynaModelCatBase.resetUserCat();
        pSSysDynaModelCatBase.resetUserTag();
        pSSysDynaModelCatBase.resetUserTag2();
        pSSysDynaModelCatBase.resetUserTag3();
        pSSysDynaModelCatBase.resetUserTag4();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELCATID, this.getPSSysDynaModelCatId());
        }
        if (!bl || this.isPSSysDynaModelCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELCATNAME, this.getPSSysDynaModelCatName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysDynaModelCatBase.get(this, n);
    }

    private static Object get(PSSysDynaModelCatBase pSSysDynaModelCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelCatBase.getCodeName();
            }
            case 1: {
                return pSSysDynaModelCatBase.getCreateDate();
            }
            case 2: {
                return pSSysDynaModelCatBase.getCreateMan();
            }
            case 3: {
                return pSSysDynaModelCatBase.getMemo();
            }
            case 4: {
                return pSSysDynaModelCatBase.getOrderValue();
            }
            case 5: {
                return pSSysDynaModelCatBase.getPSModuleId();
            }
            case 6: {
                return pSSysDynaModelCatBase.getPSModuleName();
            }
            case 7: {
                return pSSysDynaModelCatBase.getPSSysDynaModelCatId();
            }
            case 8: {
                return pSSysDynaModelCatBase.getPSSysDynaModelCatName();
            }
            case 9: {
                return pSSysDynaModelCatBase.getPSSystemId();
            }
            case 10: {
                return pSSysDynaModelCatBase.getPSSystemName();
            }
            case 11: {
                return pSSysDynaModelCatBase.getUpdateDate();
            }
            case 12: {
                return pSSysDynaModelCatBase.getUpdateMan();
            }
            case 13: {
                return pSSysDynaModelCatBase.getUserCat();
            }
            case 14: {
                return pSSysDynaModelCatBase.getUserTag();
            }
            case 15: {
                return pSSysDynaModelCatBase.getUserTag2();
            }
            case 16: {
                return pSSysDynaModelCatBase.getUserTag3();
            }
            case 17: {
                return pSSysDynaModelCatBase.getUserTag4();
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
        PSSysDynaModelCatBase.set(this, n, object);
    }

    private static void set(PSSysDynaModelCatBase pSSysDynaModelCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDynaModelCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDynaModelCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDynaModelCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDynaModelCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysDynaModelCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDynaModelCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDynaModelCatBase.setPSSysDynaModelCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDynaModelCatBase.setPSSysDynaModelCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDynaModelCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDynaModelCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDynaModelCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysDynaModelCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDynaModelCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDynaModelCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDynaModelCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDynaModelCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDynaModelCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDynaModelCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDynaModelCatBase pSSysDynaModelCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelCatBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDynaModelCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDynaModelCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDynaModelCatBase.getMemo() == null;
            }
            case 4: {
                return pSSysDynaModelCatBase.getOrderValue() == null;
            }
            case 5: {
                return pSSysDynaModelCatBase.getPSModuleId() == null;
            }
            case 6: {
                return pSSysDynaModelCatBase.getPSModuleName() == null;
            }
            case 7: {
                return pSSysDynaModelCatBase.getPSSysDynaModelCatId() == null;
            }
            case 8: {
                return pSSysDynaModelCatBase.getPSSysDynaModelCatName() == null;
            }
            case 9: {
                return pSSysDynaModelCatBase.getPSSystemId() == null;
            }
            case 10: {
                return pSSysDynaModelCatBase.getPSSystemName() == null;
            }
            case 11: {
                return pSSysDynaModelCatBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysDynaModelCatBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysDynaModelCatBase.getUserCat() == null;
            }
            case 14: {
                return pSSysDynaModelCatBase.getUserTag() == null;
            }
            case 15: {
                return pSSysDynaModelCatBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysDynaModelCatBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysDynaModelCatBase.getUserTag4() == null;
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
        return PSSysDynaModelCatBase.contains(this, n);
    }

    private static boolean contains(PSSysDynaModelCatBase pSSysDynaModelCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelCatBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDynaModelCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDynaModelCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDynaModelCatBase.isMemoDirty();
            }
            case 4: {
                return pSSysDynaModelCatBase.isOrderValueDirty();
            }
            case 5: {
                return pSSysDynaModelCatBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSSysDynaModelCatBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSSysDynaModelCatBase.isPSSysDynaModelCatIdDirty();
            }
            case 8: {
                return pSSysDynaModelCatBase.isPSSysDynaModelCatNameDirty();
            }
            case 9: {
                return pSSysDynaModelCatBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSSysDynaModelCatBase.isPSSystemNameDirty();
            }
            case 11: {
                return pSSysDynaModelCatBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysDynaModelCatBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysDynaModelCatBase.isUserCatDirty();
            }
            case 14: {
                return pSSysDynaModelCatBase.isUserTagDirty();
            }
            case 15: {
                return pSSysDynaModelCatBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysDynaModelCatBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysDynaModelCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDynaModelCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDynaModelCatBase pSSysDynaModelCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDynaModelCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelcatid", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSSysDynaModelCatId()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelcatname", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSSysDynaModelCatName()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDynaModelCatBase.getJSONValue((Object)pSSysDynaModelCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDynaModelCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDynaModelCatBase pSSysDynaModelCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDynaModelCatBase.getCodeName() != null) {
            object = pSSysDynaModelCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getCreateDate() != null) {
            object = pSSysDynaModelCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelCatBase.getCreateMan() != null) {
            object = pSSysDynaModelCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getMemo() != null) {
            object = pSSysDynaModelCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getOrderValue() != null) {
            object = pSSysDynaModelCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelCatBase.getPSModuleId() != null) {
            object = pSSysDynaModelCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getPSModuleName() != null) {
            object = pSSysDynaModelCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatId() != null) {
            object = pSSysDynaModelCatBase.getPSSysDynaModelCatId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatName() != null) {
            object = pSSysDynaModelCatBase.getPSSysDynaModelCatName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getPSSystemId() != null) {
            object = pSSysDynaModelCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getPSSystemName() != null) {
            object = pSSysDynaModelCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUpdateDate() != null) {
            object = pSSysDynaModelCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelCatBase.getUpdateMan() != null) {
            object = pSSysDynaModelCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUserCat() != null) {
            object = pSSysDynaModelCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag() != null) {
            object = pSSysDynaModelCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag2() != null) {
            object = pSSysDynaModelCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag3() != null) {
            object = pSSysDynaModelCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelCatBase.getUserTag4() != null) {
            object = pSSysDynaModelCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDynaModelCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDynaModelCatBase pSSysDynaModelCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDynaModelCatBase.isCodeNameDirty() && (bl || pSSysDynaModelCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDynaModelCatBase.getCodeName());
        }
        if (pSSysDynaModelCatBase.isCreateDateDirty() && (bl || pSSysDynaModelCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDynaModelCatBase.getCreateDate());
        }
        if (pSSysDynaModelCatBase.isCreateManDirty() && (bl || pSSysDynaModelCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDynaModelCatBase.getCreateMan());
        }
        if (pSSysDynaModelCatBase.isMemoDirty() && (bl || pSSysDynaModelCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDynaModelCatBase.getMemo());
        }
        if (pSSysDynaModelCatBase.isOrderValueDirty() && (bl || pSSysDynaModelCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDynaModelCatBase.getOrderValue());
        }
        if (pSSysDynaModelCatBase.isPSModuleIdDirty() && (bl || pSSysDynaModelCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDynaModelCatBase.getPSModuleId());
        }
        if (pSSysDynaModelCatBase.isPSModuleNameDirty() && (bl || pSSysDynaModelCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDynaModelCatBase.getPSModuleName());
        }
        if (pSSysDynaModelCatBase.isPSSysDynaModelCatIdDirty() && (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELCATID, (Object)pSSysDynaModelCatBase.getPSSysDynaModelCatId());
        }
        if (pSSysDynaModelCatBase.isPSSysDynaModelCatNameDirty() && (bl || pSSysDynaModelCatBase.getPSSysDynaModelCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELCATNAME, (Object)pSSysDynaModelCatBase.getPSSysDynaModelCatName());
        }
        if (pSSysDynaModelCatBase.isPSSystemIdDirty() && (bl || pSSysDynaModelCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDynaModelCatBase.getPSSystemId());
        }
        if (pSSysDynaModelCatBase.isPSSystemNameDirty() && (bl || pSSysDynaModelCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDynaModelCatBase.getPSSystemName());
        }
        if (pSSysDynaModelCatBase.isUpdateDateDirty() && (bl || pSSysDynaModelCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDynaModelCatBase.getUpdateDate());
        }
        if (pSSysDynaModelCatBase.isUpdateManDirty() && (bl || pSSysDynaModelCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDynaModelCatBase.getUpdateMan());
        }
        if (pSSysDynaModelCatBase.isUserCatDirty() && (bl || pSSysDynaModelCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDynaModelCatBase.getUserCat());
        }
        if (pSSysDynaModelCatBase.isUserTagDirty() && (bl || pSSysDynaModelCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDynaModelCatBase.getUserTag());
        }
        if (pSSysDynaModelCatBase.isUserTag2Dirty() && (bl || pSSysDynaModelCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDynaModelCatBase.getUserTag2());
        }
        if (pSSysDynaModelCatBase.isUserTag3Dirty() && (bl || pSSysDynaModelCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDynaModelCatBase.getUserTag3());
        }
        if (pSSysDynaModelCatBase.isUserTag4Dirty() && (bl || pSSysDynaModelCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDynaModelCatBase.getUserTag4());
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
        return PSSysDynaModelCatBase.remove(this, n);
    }

    private static boolean remove(PSSysDynaModelCatBase pSSysDynaModelCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelCatBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDynaModelCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDynaModelCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDynaModelCatBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysDynaModelCatBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSSysDynaModelCatBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSSysDynaModelCatBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSSysDynaModelCatBase.resetPSSysDynaModelCatId();
                return true;
            }
            case 8: {
                pSSysDynaModelCatBase.resetPSSysDynaModelCatName();
                return true;
            }
            case 9: {
                pSSysDynaModelCatBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSSysDynaModelCatBase.resetPSSystemName();
                return true;
            }
            case 11: {
                pSSysDynaModelCatBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysDynaModelCatBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysDynaModelCatBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysDynaModelCatBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysDynaModelCatBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysDynaModelCatBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysDynaModelCatBase.resetUserTag4();
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
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDynaModel> getPSSysDynaModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModels();
        }
        if (this.getPSSysDynaModelCatId() == null) {
            return null;
        }
        PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDynaModelsLock;
        synchronized (n) {
            if (this.pssysdynamodels == null) {
                this.pssysdynamodels = pSSysDynaModelService.selectByPSSysDynaModel(this);
            }
            return this.pssysdynamodels;
        }
    }

    private PSSysDynaModelCatBase getProxyEntity() {
        return this.proxyPSSysDynaModelCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDynaModelCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDynaModelCatBase) {
            this.proxyPSSysDynaModelCatBase = (PSSysDynaModelCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELCATID, 7);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELCATNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

