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
package net.ibizsys.pscore.srv.wfdesign.entity;

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

public abstract class PSSysWFCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysWFCatBase.class);
    public static final String FIELD_CATCODE = "CATCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSWFCATID = "PSSYSWFCATID";
    public static final String FIELD_PSSYSWFCATNAME = "PSSYSWFCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CATCODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_PSSYSWFCATID = 9;
    private static final int INDEX_PSSYSWFCATNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysWFCatBase proxyPSSysWFCatBase = null;
    private boolean catcodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssyswfcatidDirtyFlag = false;
    private boolean pssyswfcatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="catcode")
    private String catcode;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssyswfcatid")
    private String pssyswfcatid;
    @Column(name="pssyswfcatname")
    private String pssyswfcatname;
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
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCatCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catcode = string;
        this.catcodeDirtyFlag = true;
    }

    public String getCatCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatCode();
        }
        return this.catcode;
    }

    public boolean isCatCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatCodeDirty();
        }
        return this.catcodeDirtyFlag;
    }

    public void resetCatCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatCode();
            return;
        }
        this.catcodeDirtyFlag = false;
        this.catcode = null;
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

    public void setPSSysWFCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfcatid = string;
        this.pssyswfcatidDirtyFlag = true;
    }

    public String getPSSysWFCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCatId();
        }
        return this.pssyswfcatid;
    }

    public boolean isPSSysWFCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFCatIdDirty();
        }
        return this.pssyswfcatidDirtyFlag;
    }

    public void resetPSSysWFCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFCatId();
            return;
        }
        this.pssyswfcatidDirtyFlag = false;
        this.pssyswfcatid = null;
    }

    public void setPSSysWFCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfcatname = string;
        this.pssyswfcatnameDirtyFlag = true;
    }

    public String getPSSysWFCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCatName();
        }
        return this.pssyswfcatname;
    }

    public boolean isPSSysWFCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFCatNameDirty();
        }
        return this.pssyswfcatnameDirtyFlag;
    }

    public void resetPSSysWFCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFCatName();
            return;
        }
        this.pssyswfcatnameDirtyFlag = false;
        this.pssyswfcatname = null;
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
        PSSysWFCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysWFCatBase pSSysWFCatBase) {
        pSSysWFCatBase.resetCatCode();
        pSSysWFCatBase.resetCreateDate();
        pSSysWFCatBase.resetCreateMan();
        pSSysWFCatBase.resetMemo();
        pSSysWFCatBase.resetOrderValue();
        pSSysWFCatBase.resetPSModuleId();
        pSSysWFCatBase.resetPSModuleName();
        pSSysWFCatBase.resetPSSystemId();
        pSSysWFCatBase.resetPSSystemName();
        pSSysWFCatBase.resetPSSysWFCatId();
        pSSysWFCatBase.resetPSSysWFCatName();
        pSSysWFCatBase.resetUpdateDate();
        pSSysWFCatBase.resetUpdateMan();
        pSSysWFCatBase.resetUserCat();
        pSSysWFCatBase.resetUserTag();
        pSSysWFCatBase.resetUserTag2();
        pSSysWFCatBase.resetUserTag3();
        pSSysWFCatBase.resetUserTag4();
        pSSysWFCatBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatCodeDirty()) {
            hashMap.put(FIELD_CATCODE, this.getCatCode());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysWFCatIdDirty()) {
            hashMap.put(FIELD_PSSYSWFCATID, this.getPSSysWFCatId());
        }
        if (!bl || this.isPSSysWFCatNameDirty()) {
            hashMap.put(FIELD_PSSYSWFCATNAME, this.getPSSysWFCatName());
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
        return PSSysWFCatBase.get(this, n);
    }

    private static Object get(PSSysWFCatBase pSSysWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFCatBase.getCatCode();
            }
            case 1: {
                return pSSysWFCatBase.getCreateDate();
            }
            case 2: {
                return pSSysWFCatBase.getCreateMan();
            }
            case 3: {
                return pSSysWFCatBase.getMemo();
            }
            case 4: {
                return pSSysWFCatBase.getOrderValue();
            }
            case 5: {
                return pSSysWFCatBase.getPSModuleId();
            }
            case 6: {
                return pSSysWFCatBase.getPSModuleName();
            }
            case 7: {
                return pSSysWFCatBase.getPSSystemId();
            }
            case 8: {
                return pSSysWFCatBase.getPSSystemName();
            }
            case 9: {
                return pSSysWFCatBase.getPSSysWFCatId();
            }
            case 10: {
                return pSSysWFCatBase.getPSSysWFCatName();
            }
            case 11: {
                return pSSysWFCatBase.getUpdateDate();
            }
            case 12: {
                return pSSysWFCatBase.getUpdateMan();
            }
            case 13: {
                return pSSysWFCatBase.getUserCat();
            }
            case 14: {
                return pSSysWFCatBase.getUserTag();
            }
            case 15: {
                return pSSysWFCatBase.getUserTag2();
            }
            case 16: {
                return pSSysWFCatBase.getUserTag3();
            }
            case 17: {
                return pSSysWFCatBase.getUserTag4();
            }
            case 18: {
                return pSSysWFCatBase.getValidFlag();
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
        PSSysWFCatBase.set(this, n, object);
    }

    private static void set(PSSysWFCatBase pSSysWFCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFCatBase.setCatCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysWFCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysWFCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysWFCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysWFCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysWFCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysWFCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysWFCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysWFCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysWFCatBase.setPSSysWFCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysWFCatBase.setPSSysWFCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysWFCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysWFCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysWFCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysWFCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysWFCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysWFCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysWFCatBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysWFCatBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysWFCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysWFCatBase pSSysWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFCatBase.getCatCode() == null;
            }
            case 1: {
                return pSSysWFCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysWFCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysWFCatBase.getMemo() == null;
            }
            case 4: {
                return pSSysWFCatBase.getOrderValue() == null;
            }
            case 5: {
                return pSSysWFCatBase.getPSModuleId() == null;
            }
            case 6: {
                return pSSysWFCatBase.getPSModuleName() == null;
            }
            case 7: {
                return pSSysWFCatBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysWFCatBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysWFCatBase.getPSSysWFCatId() == null;
            }
            case 10: {
                return pSSysWFCatBase.getPSSysWFCatName() == null;
            }
            case 11: {
                return pSSysWFCatBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysWFCatBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysWFCatBase.getUserCat() == null;
            }
            case 14: {
                return pSSysWFCatBase.getUserTag() == null;
            }
            case 15: {
                return pSSysWFCatBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysWFCatBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysWFCatBase.getUserTag4() == null;
            }
            case 18: {
                return pSSysWFCatBase.getValidFlag() == null;
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
        return PSSysWFCatBase.contains(this, n);
    }

    private static boolean contains(PSSysWFCatBase pSSysWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFCatBase.isCatCodeDirty();
            }
            case 1: {
                return pSSysWFCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysWFCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysWFCatBase.isMemoDirty();
            }
            case 4: {
                return pSSysWFCatBase.isOrderValueDirty();
            }
            case 5: {
                return pSSysWFCatBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSSysWFCatBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSSysWFCatBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysWFCatBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysWFCatBase.isPSSysWFCatIdDirty();
            }
            case 10: {
                return pSSysWFCatBase.isPSSysWFCatNameDirty();
            }
            case 11: {
                return pSSysWFCatBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysWFCatBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysWFCatBase.isUserCatDirty();
            }
            case 14: {
                return pSSysWFCatBase.isUserTagDirty();
            }
            case 15: {
                return pSSysWFCatBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysWFCatBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysWFCatBase.isUserTag4Dirty();
            }
            case 18: {
                return pSSysWFCatBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysWFCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysWFCatBase pSSysWFCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysWFCatBase.getCatCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catcode", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getCatCode()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSSysWFCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatid", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSSysWFCatId()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getPSSysWFCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatname", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getPSSysWFCatName()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysWFCatBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysWFCatBase.getJSONValue((Object)pSSysWFCatBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysWFCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysWFCatBase pSSysWFCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysWFCatBase.getCatCode() != null) {
            object = pSSysWFCatBase.getCatCode();
            xmlNode.setAttribute(FIELD_CATCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getCreateDate() != null) {
            object = pSSysWFCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFCatBase.getCreateMan() != null) {
            object = pSSysWFCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getMemo() != null) {
            object = pSSysWFCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getOrderValue() != null) {
            object = pSSysWFCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysWFCatBase.getPSModuleId() != null) {
            object = pSSysWFCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getPSModuleName() != null) {
            object = pSSysWFCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getPSSystemId() != null) {
            object = pSSysWFCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getPSSystemName() != null) {
            object = pSSysWFCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getPSSysWFCatId() != null) {
            object = pSSysWFCatBase.getPSSysWFCatId();
            xmlNode.setAttribute(FIELD_PSSYSWFCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getPSSysWFCatName() != null) {
            object = pSSysWFCatBase.getPSSysWFCatName();
            xmlNode.setAttribute(FIELD_PSSYSWFCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUpdateDate() != null) {
            object = pSSysWFCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFCatBase.getUpdateMan() != null) {
            object = pSSysWFCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUserCat() != null) {
            object = pSSysWFCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUserTag() != null) {
            object = pSSysWFCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUserTag2() != null) {
            object = pSSysWFCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUserTag3() != null) {
            object = pSSysWFCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getUserTag4() != null) {
            object = pSSysWFCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFCatBase.getValidFlag() != null) {
            object = pSSysWFCatBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysWFCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysWFCatBase pSSysWFCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysWFCatBase.isCatCodeDirty() && (bl || pSSysWFCatBase.getCatCode() != null)) {
            iDataObject.set(FIELD_CATCODE, (Object)pSSysWFCatBase.getCatCode());
        }
        if (pSSysWFCatBase.isCreateDateDirty() && (bl || pSSysWFCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysWFCatBase.getCreateDate());
        }
        if (pSSysWFCatBase.isCreateManDirty() && (bl || pSSysWFCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysWFCatBase.getCreateMan());
        }
        if (pSSysWFCatBase.isMemoDirty() && (bl || pSSysWFCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysWFCatBase.getMemo());
        }
        if (pSSysWFCatBase.isOrderValueDirty() && (bl || pSSysWFCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysWFCatBase.getOrderValue());
        }
        if (pSSysWFCatBase.isPSModuleIdDirty() && (bl || pSSysWFCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysWFCatBase.getPSModuleId());
        }
        if (pSSysWFCatBase.isPSModuleNameDirty() && (bl || pSSysWFCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysWFCatBase.getPSModuleName());
        }
        if (pSSysWFCatBase.isPSSystemIdDirty() && (bl || pSSysWFCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysWFCatBase.getPSSystemId());
        }
        if (pSSysWFCatBase.isPSSystemNameDirty() && (bl || pSSysWFCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysWFCatBase.getPSSystemName());
        }
        if (pSSysWFCatBase.isPSSysWFCatIdDirty() && (bl || pSSysWFCatBase.getPSSysWFCatId() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATID, (Object)pSSysWFCatBase.getPSSysWFCatId());
        }
        if (pSSysWFCatBase.isPSSysWFCatNameDirty() && (bl || pSSysWFCatBase.getPSSysWFCatName() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATNAME, (Object)pSSysWFCatBase.getPSSysWFCatName());
        }
        if (pSSysWFCatBase.isUpdateDateDirty() && (bl || pSSysWFCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysWFCatBase.getUpdateDate());
        }
        if (pSSysWFCatBase.isUpdateManDirty() && (bl || pSSysWFCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysWFCatBase.getUpdateMan());
        }
        if (pSSysWFCatBase.isUserCatDirty() && (bl || pSSysWFCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysWFCatBase.getUserCat());
        }
        if (pSSysWFCatBase.isUserTagDirty() && (bl || pSSysWFCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysWFCatBase.getUserTag());
        }
        if (pSSysWFCatBase.isUserTag2Dirty() && (bl || pSSysWFCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysWFCatBase.getUserTag2());
        }
        if (pSSysWFCatBase.isUserTag3Dirty() && (bl || pSSysWFCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysWFCatBase.getUserTag3());
        }
        if (pSSysWFCatBase.isUserTag4Dirty() && (bl || pSSysWFCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysWFCatBase.getUserTag4());
        }
        if (pSSysWFCatBase.isValidFlagDirty() && (bl || pSSysWFCatBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysWFCatBase.getValidFlag());
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
        return PSSysWFCatBase.remove(this, n);
    }

    private static boolean remove(PSSysWFCatBase pSSysWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFCatBase.resetCatCode();
                return true;
            }
            case 1: {
                pSSysWFCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysWFCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysWFCatBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysWFCatBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSSysWFCatBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSSysWFCatBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSSysWFCatBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysWFCatBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysWFCatBase.resetPSSysWFCatId();
                return true;
            }
            case 10: {
                pSSysWFCatBase.resetPSSysWFCatName();
                return true;
            }
            case 11: {
                pSSysWFCatBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysWFCatBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysWFCatBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysWFCatBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysWFCatBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysWFCatBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysWFCatBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSSysWFCatBase.resetValidFlag();
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
                pSModuleService.autoGet((IEntity)pSModule);
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysWFCatBase getProxyEntity() {
        return this.proxyPSSysWFCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysWFCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysWFCatBase) {
            this.proxyPSSysWFCatBase = (PSSysWFCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATCODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSWFCATID, 9);
        fieldIndexMap.put(FIELD_PSSYSWFCATNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

