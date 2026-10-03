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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWFVer;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppWFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSAPPWFID = "PSAPPWFID";
    public static final String FIELD_PSAPPWFNAME = "PSAPPWFNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String FIELD_PSWORKFLOWNAME = "PSWORKFLOWNAME";
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
    private static final int INDEX_PSAPPMODULEID = 3;
    private static final int INDEX_PSAPPMODULENAME = 4;
    private static final int INDEX_PSAPPWFID = 5;
    private static final int INDEX_PSAPPWFNAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSWORKFLOWID = 9;
    private static final int INDEX_PSWORKFLOWNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppWFBase proxyPSAppWFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psappwfidDirtyFlag = false;
    private boolean psappwfnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean psworkflowidDirtyFlag = false;
    private boolean psworkflownameDirtyFlag = false;
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
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psappwfid")
    private String psappwfid;
    @Column(name="psappwfname")
    private String psappwfname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="psworkflowid")
    private String psworkflowid;
    @Column(name="psworkflowname")
    private String psworkflowname;
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
    private Integer objPSAppModuleLock = new Integer(1);
    private PSAppModule psappmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSWorkflowLock = new Integer(1);
    private PSWorkflow psworkflow = null;
    private Integer objPSAppWFVersLock = new Integer(1);
    private ArrayList<PSAppWFVer> psappwfvers = null;

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

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSAppWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfid = string;
        this.psappwfidDirtyFlag = true;
    }

    public String getPSAppWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFId();
        }
        return this.psappwfid;
    }

    public boolean isPSAppWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFIdDirty();
        }
        return this.psappwfidDirtyFlag;
    }

    public void resetPSAppWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFId();
            return;
        }
        this.psappwfidDirtyFlag = false;
        this.psappwfid = null;
    }

    public void setPSAppWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfname = string;
        this.psappwfnameDirtyFlag = true;
    }

    public String getPSAppWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFName();
        }
        return this.psappwfname;
    }

    public boolean isPSAppWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFNameDirty();
        }
        return this.psappwfnameDirtyFlag;
    }

    public void resetPSAppWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFName();
            return;
        }
        this.psappwfnameDirtyFlag = false;
        this.psappwfname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowid = string;
        this.psworkflowidDirtyFlag = true;
    }

    public String getPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowId();
        }
        return this.psworkflowid;
    }

    public boolean isPSWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowIdDirty();
        }
        return this.psworkflowidDirtyFlag;
    }

    public void resetPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowId();
            return;
        }
        this.psworkflowidDirtyFlag = false;
        this.psworkflowid = null;
    }

    public void setPSWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowname = string;
        this.psworkflownameDirtyFlag = true;
    }

    public String getPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowName();
        }
        return this.psworkflowname;
    }

    public boolean isPSWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowNameDirty();
        }
        return this.psworkflownameDirtyFlag;
    }

    public void resetPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowName();
            return;
        }
        this.psworkflownameDirtyFlag = false;
        this.psworkflowname = null;
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
        PSAppWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppWFBase pSAppWFBase) {
        pSAppWFBase.resetCreateDate();
        pSAppWFBase.resetCreateMan();
        pSAppWFBase.resetMemo();
        pSAppWFBase.resetPSAppModuleId();
        pSAppWFBase.resetPSAppModuleName();
        pSAppWFBase.resetPSAppWFId();
        pSAppWFBase.resetPSAppWFName();
        pSAppWFBase.resetPSSysAppId();
        pSAppWFBase.resetPSSysAppName();
        pSAppWFBase.resetPSWorkflowId();
        pSAppWFBase.resetPSWorkflowName();
        pSAppWFBase.resetUpdateDate();
        pSAppWFBase.resetUpdateMan();
        pSAppWFBase.resetUserCat();
        pSAppWFBase.resetUserTag();
        pSAppWFBase.resetUserTag2();
        pSAppWFBase.resetUserTag3();
        pSAppWFBase.resetUserTag4();
        pSAppWFBase.resetValidFlag();
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
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSAppWFIdDirty()) {
            hashMap.put(FIELD_PSAPPWFID, this.getPSAppWFId());
        }
        if (!bl || this.isPSAppWFNameDirty()) {
            hashMap.put(FIELD_PSAPPWFNAME, this.getPSAppWFName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWORKFLOWID, this.getPSWorkflowId());
        }
        if (!bl || this.isPSWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWORKFLOWNAME, this.getPSWorkflowName());
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
        return PSAppWFBase.get(this, n);
    }

    private static Object get(PSAppWFBase pSAppWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFBase.getCreateDate();
            }
            case 1: {
                return pSAppWFBase.getCreateMan();
            }
            case 2: {
                return pSAppWFBase.getMemo();
            }
            case 3: {
                return pSAppWFBase.getPSAppModuleId();
            }
            case 4: {
                return pSAppWFBase.getPSAppModuleName();
            }
            case 5: {
                return pSAppWFBase.getPSAppWFId();
            }
            case 6: {
                return pSAppWFBase.getPSAppWFName();
            }
            case 7: {
                return pSAppWFBase.getPSSysAppId();
            }
            case 8: {
                return pSAppWFBase.getPSSysAppName();
            }
            case 9: {
                return pSAppWFBase.getPSWorkflowId();
            }
            case 10: {
                return pSAppWFBase.getPSWorkflowName();
            }
            case 11: {
                return pSAppWFBase.getUpdateDate();
            }
            case 12: {
                return pSAppWFBase.getUpdateMan();
            }
            case 13: {
                return pSAppWFBase.getUserCat();
            }
            case 14: {
                return pSAppWFBase.getUserTag();
            }
            case 15: {
                return pSAppWFBase.getUserTag2();
            }
            case 16: {
                return pSAppWFBase.getUserTag3();
            }
            case 17: {
                return pSAppWFBase.getUserTag4();
            }
            case 18: {
                return pSAppWFBase.getValidFlag();
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
        PSAppWFBase.set(this, n, object);
    }

    private static void set(PSAppWFBase pSAppWFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppWFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppWFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppWFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppWFBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppWFBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppWFBase.setPSAppWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppWFBase.setPSAppWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppWFBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppWFBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppWFBase.setPSWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppWFBase.setPSWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppWFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSAppWFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppWFBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppWFBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppWFBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppWFBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppWFBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppWFBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppWFBase.isNull(this, n);
    }

    private static boolean isNull(PSAppWFBase pSAppWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppWFBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppWFBase.getMemo() == null;
            }
            case 3: {
                return pSAppWFBase.getPSAppModuleId() == null;
            }
            case 4: {
                return pSAppWFBase.getPSAppModuleName() == null;
            }
            case 5: {
                return pSAppWFBase.getPSAppWFId() == null;
            }
            case 6: {
                return pSAppWFBase.getPSAppWFName() == null;
            }
            case 7: {
                return pSAppWFBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppWFBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppWFBase.getPSWorkflowId() == null;
            }
            case 10: {
                return pSAppWFBase.getPSWorkflowName() == null;
            }
            case 11: {
                return pSAppWFBase.getUpdateDate() == null;
            }
            case 12: {
                return pSAppWFBase.getUpdateMan() == null;
            }
            case 13: {
                return pSAppWFBase.getUserCat() == null;
            }
            case 14: {
                return pSAppWFBase.getUserTag() == null;
            }
            case 15: {
                return pSAppWFBase.getUserTag2() == null;
            }
            case 16: {
                return pSAppWFBase.getUserTag3() == null;
            }
            case 17: {
                return pSAppWFBase.getUserTag4() == null;
            }
            case 18: {
                return pSAppWFBase.getValidFlag() == null;
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
        return PSAppWFBase.contains(this, n);
    }

    private static boolean contains(PSAppWFBase pSAppWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppWFBase.isCreateManDirty();
            }
            case 2: {
                return pSAppWFBase.isMemoDirty();
            }
            case 3: {
                return pSAppWFBase.isPSAppModuleIdDirty();
            }
            case 4: {
                return pSAppWFBase.isPSAppModuleNameDirty();
            }
            case 5: {
                return pSAppWFBase.isPSAppWFIdDirty();
            }
            case 6: {
                return pSAppWFBase.isPSAppWFNameDirty();
            }
            case 7: {
                return pSAppWFBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppWFBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppWFBase.isPSWorkflowIdDirty();
            }
            case 10: {
                return pSAppWFBase.isPSWorkflowNameDirty();
            }
            case 11: {
                return pSAppWFBase.isUpdateDateDirty();
            }
            case 12: {
                return pSAppWFBase.isUpdateManDirty();
            }
            case 13: {
                return pSAppWFBase.isUserCatDirty();
            }
            case 14: {
                return pSAppWFBase.isUserTagDirty();
            }
            case 15: {
                return pSAppWFBase.isUserTag2Dirty();
            }
            case 16: {
                return pSAppWFBase.isUserTag3Dirty();
            }
            case 17: {
                return pSAppWFBase.isUserTag4Dirty();
            }
            case 18: {
                return pSAppWFBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppWFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppWFBase pSAppWFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppWFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppWFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppWFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSAppWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfid", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSAppWFId()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSAppWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfname", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSAppWFName()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowid", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSWorkflowId()), (boolean)false);
        }
        if (bl || pSAppWFBase.getPSWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowname", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getPSWorkflowName()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppWFBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppWFBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppWFBase.getJSONValue((Object)pSAppWFBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppWFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppWFBase pSAppWFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppWFBase.getCreateDate() != null) {
            object = pSAppWFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppWFBase.getCreateMan() != null) {
            object = pSAppWFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getMemo() != null) {
            object = pSAppWFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSAppModuleId() != null) {
            object = pSAppWFBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSAppModuleName() != null) {
            object = pSAppWFBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSAppWFId() != null) {
            object = pSAppWFBase.getPSAppWFId();
            xmlNode.setAttribute(FIELD_PSAPPWFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSAppWFName() != null) {
            object = pSAppWFBase.getPSAppWFName();
            xmlNode.setAttribute(FIELD_PSAPPWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSSysAppId() != null) {
            object = pSAppWFBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSSysAppName() != null) {
            object = pSAppWFBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSWorkflowId() != null) {
            object = pSAppWFBase.getPSWorkflowId();
            xmlNode.setAttribute(FIELD_PSWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getPSWorkflowName() != null) {
            object = pSAppWFBase.getPSWorkflowName();
            xmlNode.setAttribute(FIELD_PSWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUpdateDate() != null) {
            object = pSAppWFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppWFBase.getUpdateMan() != null) {
            object = pSAppWFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUserCat() != null) {
            object = pSAppWFBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUserTag() != null) {
            object = pSAppWFBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUserTag2() != null) {
            object = pSAppWFBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUserTag3() != null) {
            object = pSAppWFBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getUserTag4() != null) {
            object = pSAppWFBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFBase.getValidFlag() != null) {
            object = pSAppWFBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppWFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppWFBase pSAppWFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppWFBase.isCreateDateDirty() && (bl || pSAppWFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppWFBase.getCreateDate());
        }
        if (pSAppWFBase.isCreateManDirty() && (bl || pSAppWFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppWFBase.getCreateMan());
        }
        if (pSAppWFBase.isMemoDirty() && (bl || pSAppWFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppWFBase.getMemo());
        }
        if (pSAppWFBase.isPSAppModuleIdDirty() && (bl || pSAppWFBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSAppWFBase.getPSAppModuleId());
        }
        if (pSAppWFBase.isPSAppModuleNameDirty() && (bl || pSAppWFBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSAppWFBase.getPSAppModuleName());
        }
        if (pSAppWFBase.isPSAppWFIdDirty() && (bl || pSAppWFBase.getPSAppWFId() != null)) {
            iDataObject.set(FIELD_PSAPPWFID, (Object)pSAppWFBase.getPSAppWFId());
        }
        if (pSAppWFBase.isPSAppWFNameDirty() && (bl || pSAppWFBase.getPSAppWFName() != null)) {
            iDataObject.set(FIELD_PSAPPWFNAME, (Object)pSAppWFBase.getPSAppWFName());
        }
        if (pSAppWFBase.isPSSysAppIdDirty() && (bl || pSAppWFBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppWFBase.getPSSysAppId());
        }
        if (pSAppWFBase.isPSSysAppNameDirty() && (bl || pSAppWFBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppWFBase.getPSSysAppName());
        }
        if (pSAppWFBase.isPSWorkflowIdDirty() && (bl || pSAppWFBase.getPSWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWID, (Object)pSAppWFBase.getPSWorkflowId());
        }
        if (pSAppWFBase.isPSWorkflowNameDirty() && (bl || pSAppWFBase.getPSWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWNAME, (Object)pSAppWFBase.getPSWorkflowName());
        }
        if (pSAppWFBase.isUpdateDateDirty() && (bl || pSAppWFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppWFBase.getUpdateDate());
        }
        if (pSAppWFBase.isUpdateManDirty() && (bl || pSAppWFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppWFBase.getUpdateMan());
        }
        if (pSAppWFBase.isUserCatDirty() && (bl || pSAppWFBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppWFBase.getUserCat());
        }
        if (pSAppWFBase.isUserTagDirty() && (bl || pSAppWFBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppWFBase.getUserTag());
        }
        if (pSAppWFBase.isUserTag2Dirty() && (bl || pSAppWFBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppWFBase.getUserTag2());
        }
        if (pSAppWFBase.isUserTag3Dirty() && (bl || pSAppWFBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppWFBase.getUserTag3());
        }
        if (pSAppWFBase.isUserTag4Dirty() && (bl || pSAppWFBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppWFBase.getUserTag4());
        }
        if (pSAppWFBase.isValidFlagDirty() && (bl || pSAppWFBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppWFBase.getValidFlag());
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
        return PSAppWFBase.remove(this, n);
    }

    private static boolean remove(PSAppWFBase pSAppWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppWFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppWFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppWFBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppWFBase.resetPSAppModuleId();
                return true;
            }
            case 4: {
                pSAppWFBase.resetPSAppModuleName();
                return true;
            }
            case 5: {
                pSAppWFBase.resetPSAppWFId();
                return true;
            }
            case 6: {
                pSAppWFBase.resetPSAppWFName();
                return true;
            }
            case 7: {
                pSAppWFBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppWFBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppWFBase.resetPSWorkflowId();
                return true;
            }
            case 10: {
                pSAppWFBase.resetPSWorkflowName();
                return true;
            }
            case 11: {
                pSAppWFBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSAppWFBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSAppWFBase.resetUserCat();
                return true;
            }
            case 14: {
                pSAppWFBase.resetUserTag();
                return true;
            }
            case 15: {
                pSAppWFBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSAppWFBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSAppWFBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSAppWFBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppModule getPSAppModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModule();
        }
        if (this.getPSAppModuleId() == null) {
            return null;
        }
        Integer n = this.objPSAppModuleLock;
        synchronized (n) {
            if (this.psappmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppModuleId(), (Object)this.psappmodule.getPSAppModuleId()) != 0L) {
                this.psappmodule = null;
            }
            if (this.psappmodule == null) {
                PSAppModule pSAppModule = new PSAppModule();
                pSAppModule.setPSAppModuleId(this.getPSAppModuleId());
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                pSAppModuleService.autoGet(pSAppModule);
                this.psappmodule = pSAppModule;
            }
            return this.psappmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWorkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflow();
        }
        if (this.getPSWorkflowId() == null) {
            return null;
        }
        Integer n = this.objPSWorkflowLock;
        synchronized (n) {
            if (this.psworkflow != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkflowId(), (Object)this.psworkflow.getPSWorkflowId()) != 0L) {
                this.psworkflow = null;
            }
            if (this.psworkflow == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWorkflowId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet(pSWorkflow);
                this.psworkflow = pSWorkflow;
            }
            return this.psworkflow;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppWFVer> getPSAppWFVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFVers();
        }
        if (this.getPSAppWFId() == null) {
            return null;
        }
        PSAppWFVerService pSAppWFVerService = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppWFVersLock;
        synchronized (n) {
            if (this.psappwfvers == null) {
                this.psappwfvers = pSAppWFVerService.selectByPSAppWF(this);
            }
            return this.psappwfvers;
        }
    }

    private PSAppWFBase getProxyEntity() {
        return this.proxyPSAppWFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppWFBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppWFBase) {
            this.proxyPSAppWFBase = (PSAppWFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppWFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 3);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 4);
        fieldIndexMap.put(FIELD_PSAPPWFID, 5);
        fieldIndexMap.put(FIELD_PSAPPWFNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSWORKFLOWID, 9);
        fieldIndexMap.put(FIELD_PSWORKFLOWNAME, 10);
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

