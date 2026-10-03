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
package net.ibizsys.pscore.srv.wxdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogic;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXAccountBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPSCNT = "PSWXENTAPPSCNT";
    public static final String FIELD_PSWXLOGICSCNT = "PSWXLOGICSCNT";
    public static final String FIELD_PSWXMENUFUNCSCNT = "PSWXMENUFUNCSCNT";
    public static final String FIELD_PSWXMENUSCNT = "PSWXMENUSCNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WXACCOUNTPARAMS = "WXACCOUNTPARAMS";
    public static final String FIELD_WXACCOUNTTYPE = "WXACCOUNTTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSRESOURCEID = 7;
    private static final int INDEX_PSSYSRESOURCENAME = 8;
    private static final int INDEX_PSSYSSFPLUGINID = 9;
    private static final int INDEX_PSSYSSFPLUGINNAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_PSWXACCOUNTID = 13;
    private static final int INDEX_PSWXACCOUNTNAME = 14;
    private static final int INDEX_PSWXENTAPPSCNT = 15;
    private static final int INDEX_PSWXLOGICSCNT = 16;
    private static final int INDEX_PSWXMENUFUNCSCNT = 17;
    private static final int INDEX_PSWXMENUSCNT = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_WXACCOUNTPARAMS = 26;
    private static final int INDEX_WXACCOUNTTYPE = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXAccountBase proxyPSWXAccountBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappscntDirtyFlag = false;
    private boolean pswxlogicscntDirtyFlag = false;
    private boolean pswxmenufuncscntDirtyFlag = false;
    private boolean pswxmenuscntDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wxaccountparamsDirtyFlag = false;
    private boolean wxaccounttypeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappscnt")
    private Integer pswxentappscnt;
    @Column(name="pswxlogicscnt")
    private Integer pswxlogicscnt;
    @Column(name="pswxmenufuncscnt")
    private Integer pswxmenufuncscnt;
    @Column(name="pswxmenuscnt")
    private Integer pswxmenuscnt;
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
    @Column(name="wxaccountparams")
    private String wxaccountparams;
    @Column(name="wxaccounttype")
    private String wxaccounttype;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSWXEntAppsLock = new Integer(1);
    private ArrayList<PSWXEntApp> pswxentapps = null;
    private Integer objPSWXLogicsLock = new Integer(1);
    private ArrayList<PSWXLogic> pswxlogics = null;
    private Integer objPSWXMenuFuncsLock = new Integer(1);
    private ArrayList<PSWXMenuFunc> pswxmenufuncs = null;
    private Integer objPSWXMenusLock = new Integer(1);
    private ArrayList<PSWXMenu> pswxmenus = null;

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

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPSWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountid = string;
        this.pswxaccountidDirtyFlag = true;
    }

    public String getPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountId();
        }
        return this.pswxaccountid;
    }

    public boolean isPSWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountIdDirty();
        }
        return this.pswxaccountidDirtyFlag;
    }

    public void resetPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountId();
            return;
        }
        this.pswxaccountidDirtyFlag = false;
        this.pswxaccountid = null;
    }

    public void setPSWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountname = string;
        this.pswxaccountnameDirtyFlag = true;
    }

    public String getPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountName();
        }
        return this.pswxaccountname;
    }

    public boolean isPSWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountNameDirty();
        }
        return this.pswxaccountnameDirtyFlag;
    }

    public void resetPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountName();
            return;
        }
        this.pswxaccountnameDirtyFlag = false;
        this.pswxaccountname = null;
    }

    public void setPSWXEntAppsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppsCnt(n);
            return;
        }
        this.pswxentappscnt = n;
        this.pswxentappscntDirtyFlag = true;
    }

    public Integer getPSWXEntAppsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppsCnt();
        }
        return this.pswxentappscnt;
    }

    public boolean isPSWXEntAppsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppsCntDirty();
        }
        return this.pswxentappscntDirtyFlag;
    }

    public void resetPSWXEntAppsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppsCnt();
            return;
        }
        this.pswxentappscntDirtyFlag = false;
        this.pswxentappscnt = null;
    }

    public void setPSWXLogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXLogicsCnt(n);
            return;
        }
        this.pswxlogicscnt = n;
        this.pswxlogicscntDirtyFlag = true;
    }

    public Integer getPSWXLogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogicsCnt();
        }
        return this.pswxlogicscnt;
    }

    public boolean isPSWXLogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXLogicsCntDirty();
        }
        return this.pswxlogicscntDirtyFlag;
    }

    public void resetPSWXLogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXLogicsCnt();
            return;
        }
        this.pswxlogicscntDirtyFlag = false;
        this.pswxlogicscnt = null;
    }

    public void setPSWXMenuFuncsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncsCnt(n);
            return;
        }
        this.pswxmenufuncscnt = n;
        this.pswxmenufuncscntDirtyFlag = true;
    }

    public Integer getPSWXMenuFuncsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncsCnt();
        }
        return this.pswxmenufuncscnt;
    }

    public boolean isPSWXMenuFuncsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncsCntDirty();
        }
        return this.pswxmenufuncscntDirtyFlag;
    }

    public void resetPSWXMenuFuncsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncsCnt();
            return;
        }
        this.pswxmenufuncscntDirtyFlag = false;
        this.pswxmenufuncscnt = null;
    }

    public void setPSWXMenusCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenusCnt(n);
            return;
        }
        this.pswxmenuscnt = n;
        this.pswxmenuscntDirtyFlag = true;
    }

    public Integer getPSWXMenusCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenusCnt();
        }
        return this.pswxmenuscnt;
    }

    public boolean isPSWXMenusCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenusCntDirty();
        }
        return this.pswxmenuscntDirtyFlag;
    }

    public void resetPSWXMenusCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenusCnt();
            return;
        }
        this.pswxmenuscntDirtyFlag = false;
        this.pswxmenuscnt = null;
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

    public void setWXAccountParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxaccountparams = string;
        this.wxaccountparamsDirtyFlag = true;
    }

    public String getWXAccountParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountParams();
        }
        return this.wxaccountparams;
    }

    public boolean isWXAccountParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountParamsDirty();
        }
        return this.wxaccountparamsDirtyFlag;
    }

    public void resetWXAccountParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountParams();
            return;
        }
        this.wxaccountparamsDirtyFlag = false;
        this.wxaccountparams = null;
    }

    public void setWXAccountType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxaccounttype = string;
        this.wxaccounttypeDirtyFlag = true;
    }

    public String getWXAccountType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountType();
        }
        return this.wxaccounttype;
    }

    public boolean isWXAccountTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountTypeDirty();
        }
        return this.wxaccounttypeDirtyFlag;
    }

    public void resetWXAccountType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountType();
            return;
        }
        this.wxaccounttypeDirtyFlag = false;
        this.wxaccounttype = null;
    }

    protected void onReset() {
        PSWXAccountBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXAccountBase pSWXAccountBase) {
        pSWXAccountBase.resetCodeName();
        pSWXAccountBase.resetCreateDate();
        pSWXAccountBase.resetCreateMan();
        pSWXAccountBase.resetLockFlag();
        pSWXAccountBase.resetMemo();
        pSWXAccountBase.resetPSModuleId();
        pSWXAccountBase.resetPSModuleName();
        pSWXAccountBase.resetPSSysResourceId();
        pSWXAccountBase.resetPSSysResourceName();
        pSWXAccountBase.resetPSSysSFPluginId();
        pSWXAccountBase.resetPSSysSFPluginName();
        pSWXAccountBase.resetPSSystemId();
        pSWXAccountBase.resetPSSystemName();
        pSWXAccountBase.resetPSWXAccountId();
        pSWXAccountBase.resetPSWXAccountName();
        pSWXAccountBase.resetPSWXEntAppsCnt();
        pSWXAccountBase.resetPSWXLogicsCnt();
        pSWXAccountBase.resetPSWXMenuFuncsCnt();
        pSWXAccountBase.resetPSWXMenusCnt();
        pSWXAccountBase.resetUpdateDate();
        pSWXAccountBase.resetUpdateMan();
        pSWXAccountBase.resetUserCat();
        pSWXAccountBase.resetUserTag();
        pSWXAccountBase.resetUserTag2();
        pSWXAccountBase.resetUserTag3();
        pSWXAccountBase.resetUserTag4();
        pSWXAccountBase.resetWXAccountParams();
        pSWXAccountBase.resetWXAccountType();
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
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
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
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSWXAccountIdDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTID, this.getPSWXAccountId());
        }
        if (!bl || this.isPSWXAccountNameDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTNAME, this.getPSWXAccountName());
        }
        if (!bl || this.isPSWXEntAppsCntDirty()) {
            hashMap.put(FIELD_PSWXENTAPPSCNT, this.getPSWXEntAppsCnt());
        }
        if (!bl || this.isPSWXLogicsCntDirty()) {
            hashMap.put(FIELD_PSWXLOGICSCNT, this.getPSWXLogicsCnt());
        }
        if (!bl || this.isPSWXMenuFuncsCntDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCSCNT, this.getPSWXMenuFuncsCnt());
        }
        if (!bl || this.isPSWXMenusCntDirty()) {
            hashMap.put(FIELD_PSWXMENUSCNT, this.getPSWXMenusCnt());
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
        if (!bl || this.isWXAccountParamsDirty()) {
            hashMap.put(FIELD_WXACCOUNTPARAMS, this.getWXAccountParams());
        }
        if (!bl || this.isWXAccountTypeDirty()) {
            hashMap.put(FIELD_WXACCOUNTTYPE, this.getWXAccountType());
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
        return PSWXAccountBase.get(this, n);
    }

    private static Object get(PSWXAccountBase pSWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXAccountBase.getCodeName();
            }
            case 1: {
                return pSWXAccountBase.getCreateDate();
            }
            case 2: {
                return pSWXAccountBase.getCreateMan();
            }
            case 3: {
                return pSWXAccountBase.getLockFlag();
            }
            case 4: {
                return pSWXAccountBase.getMemo();
            }
            case 5: {
                return pSWXAccountBase.getPSModuleId();
            }
            case 6: {
                return pSWXAccountBase.getPSModuleName();
            }
            case 7: {
                return pSWXAccountBase.getPSSysResourceId();
            }
            case 8: {
                return pSWXAccountBase.getPSSysResourceName();
            }
            case 9: {
                return pSWXAccountBase.getPSSysSFPluginId();
            }
            case 10: {
                return pSWXAccountBase.getPSSysSFPluginName();
            }
            case 11: {
                return pSWXAccountBase.getPSSystemId();
            }
            case 12: {
                return pSWXAccountBase.getPSSystemName();
            }
            case 13: {
                return pSWXAccountBase.getPSWXAccountId();
            }
            case 14: {
                return pSWXAccountBase.getPSWXAccountName();
            }
            case 15: {
                return pSWXAccountBase.getPSWXEntAppsCnt();
            }
            case 16: {
                return pSWXAccountBase.getPSWXLogicsCnt();
            }
            case 17: {
                return pSWXAccountBase.getPSWXMenuFuncsCnt();
            }
            case 18: {
                return pSWXAccountBase.getPSWXMenusCnt();
            }
            case 19: {
                return pSWXAccountBase.getUpdateDate();
            }
            case 20: {
                return pSWXAccountBase.getUpdateMan();
            }
            case 21: {
                return pSWXAccountBase.getUserCat();
            }
            case 22: {
                return pSWXAccountBase.getUserTag();
            }
            case 23: {
                return pSWXAccountBase.getUserTag2();
            }
            case 24: {
                return pSWXAccountBase.getUserTag3();
            }
            case 25: {
                return pSWXAccountBase.getUserTag4();
            }
            case 26: {
                return pSWXAccountBase.getWXAccountParams();
            }
            case 27: {
                return pSWXAccountBase.getWXAccountType();
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
        PSWXAccountBase.set(this, n, object);
    }

    private static void set(PSWXAccountBase pSWXAccountBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXAccountBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXAccountBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWXAccountBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWXAccountBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWXAccountBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWXAccountBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXAccountBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWXAccountBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXAccountBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXAccountBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXAccountBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXAccountBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXAccountBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWXAccountBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWXAccountBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXAccountBase.setPSWXEntAppsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSWXAccountBase.setPSWXLogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSWXAccountBase.setPSWXMenuFuncsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSWXAccountBase.setPSWXMenusCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSWXAccountBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSWXAccountBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWXAccountBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWXAccountBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWXAccountBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWXAccountBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWXAccountBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWXAccountBase.setWXAccountParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWXAccountBase.setWXAccountType(DataObject.getStringValue((Object)object));
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
        return PSWXAccountBase.isNull(this, n);
    }

    private static boolean isNull(PSWXAccountBase pSWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXAccountBase.getCodeName() == null;
            }
            case 1: {
                return pSWXAccountBase.getCreateDate() == null;
            }
            case 2: {
                return pSWXAccountBase.getCreateMan() == null;
            }
            case 3: {
                return pSWXAccountBase.getLockFlag() == null;
            }
            case 4: {
                return pSWXAccountBase.getMemo() == null;
            }
            case 5: {
                return pSWXAccountBase.getPSModuleId() == null;
            }
            case 6: {
                return pSWXAccountBase.getPSModuleName() == null;
            }
            case 7: {
                return pSWXAccountBase.getPSSysResourceId() == null;
            }
            case 8: {
                return pSWXAccountBase.getPSSysResourceName() == null;
            }
            case 9: {
                return pSWXAccountBase.getPSSysSFPluginId() == null;
            }
            case 10: {
                return pSWXAccountBase.getPSSysSFPluginName() == null;
            }
            case 11: {
                return pSWXAccountBase.getPSSystemId() == null;
            }
            case 12: {
                return pSWXAccountBase.getPSSystemName() == null;
            }
            case 13: {
                return pSWXAccountBase.getPSWXAccountId() == null;
            }
            case 14: {
                return pSWXAccountBase.getPSWXAccountName() == null;
            }
            case 15: {
                return pSWXAccountBase.getPSWXEntAppsCnt() == null;
            }
            case 16: {
                return pSWXAccountBase.getPSWXLogicsCnt() == null;
            }
            case 17: {
                return pSWXAccountBase.getPSWXMenuFuncsCnt() == null;
            }
            case 18: {
                return pSWXAccountBase.getPSWXMenusCnt() == null;
            }
            case 19: {
                return pSWXAccountBase.getUpdateDate() == null;
            }
            case 20: {
                return pSWXAccountBase.getUpdateMan() == null;
            }
            case 21: {
                return pSWXAccountBase.getUserCat() == null;
            }
            case 22: {
                return pSWXAccountBase.getUserTag() == null;
            }
            case 23: {
                return pSWXAccountBase.getUserTag2() == null;
            }
            case 24: {
                return pSWXAccountBase.getUserTag3() == null;
            }
            case 25: {
                return pSWXAccountBase.getUserTag4() == null;
            }
            case 26: {
                return pSWXAccountBase.getWXAccountParams() == null;
            }
            case 27: {
                return pSWXAccountBase.getWXAccountType() == null;
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
        return PSWXAccountBase.contains(this, n);
    }

    private static boolean contains(PSWXAccountBase pSWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXAccountBase.isCodeNameDirty();
            }
            case 1: {
                return pSWXAccountBase.isCreateDateDirty();
            }
            case 2: {
                return pSWXAccountBase.isCreateManDirty();
            }
            case 3: {
                return pSWXAccountBase.isLockFlagDirty();
            }
            case 4: {
                return pSWXAccountBase.isMemoDirty();
            }
            case 5: {
                return pSWXAccountBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSWXAccountBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSWXAccountBase.isPSSysResourceIdDirty();
            }
            case 8: {
                return pSWXAccountBase.isPSSysResourceNameDirty();
            }
            case 9: {
                return pSWXAccountBase.isPSSysSFPluginIdDirty();
            }
            case 10: {
                return pSWXAccountBase.isPSSysSFPluginNameDirty();
            }
            case 11: {
                return pSWXAccountBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSWXAccountBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSWXAccountBase.isPSWXAccountIdDirty();
            }
            case 14: {
                return pSWXAccountBase.isPSWXAccountNameDirty();
            }
            case 15: {
                return pSWXAccountBase.isPSWXEntAppsCntDirty();
            }
            case 16: {
                return pSWXAccountBase.isPSWXLogicsCntDirty();
            }
            case 17: {
                return pSWXAccountBase.isPSWXMenuFuncsCntDirty();
            }
            case 18: {
                return pSWXAccountBase.isPSWXMenusCntDirty();
            }
            case 19: {
                return pSWXAccountBase.isUpdateDateDirty();
            }
            case 20: {
                return pSWXAccountBase.isUpdateManDirty();
            }
            case 21: {
                return pSWXAccountBase.isUserCatDirty();
            }
            case 22: {
                return pSWXAccountBase.isUserTagDirty();
            }
            case 23: {
                return pSWXAccountBase.isUserTag2Dirty();
            }
            case 24: {
                return pSWXAccountBase.isUserTag3Dirty();
            }
            case 25: {
                return pSWXAccountBase.isUserTag4Dirty();
            }
            case 26: {
                return pSWXAccountBase.isWXAccountParamsDirty();
            }
            case 27: {
                return pSWXAccountBase.isWXAccountTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXAccountBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXAccountBase pSWXAccountBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXAccountBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXEntAppsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappscnt", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXEntAppsCnt()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXLogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxlogicscnt", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXLogicsCnt()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXMenuFuncsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncscnt", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXMenuFuncsCnt()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getPSWXMenusCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuscnt", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getPSWXMenusCnt()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getWXAccountParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxaccountparams", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getWXAccountParams()), (boolean)false);
        }
        if (bl || pSWXAccountBase.getWXAccountType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxaccounttype", (Object)PSWXAccountBase.getJSONValue((Object)pSWXAccountBase.getWXAccountType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXAccountBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXAccountBase pSWXAccountBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXAccountBase.getCodeName() != null) {
            object = pSWXAccountBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getCreateDate() != null) {
            object = pSWXAccountBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXAccountBase.getCreateMan() != null) {
            object = pSWXAccountBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getLockFlag() != null) {
            object = pSWXAccountBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXAccountBase.getMemo() != null) {
            object = pSWXAccountBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSModuleId() != null) {
            object = pSWXAccountBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSModuleName() != null) {
            object = pSWXAccountBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSysResourceId() != null) {
            object = pSWXAccountBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSysResourceName() != null) {
            object = pSWXAccountBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSysSFPluginId() != null) {
            object = pSWXAccountBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSysSFPluginName() != null) {
            object = pSWXAccountBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSystemId() != null) {
            object = pSWXAccountBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSSystemName() != null) {
            object = pSWXAccountBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSWXAccountId() != null) {
            object = pSWXAccountBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSWXAccountName() != null) {
            object = pSWXAccountBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getPSWXEntAppsCnt() != null) {
            object = pSWXAccountBase.getPSWXEntAppsCnt();
            xmlNode.setAttribute(FIELD_PSWXENTAPPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXAccountBase.getPSWXLogicsCnt() != null) {
            object = pSWXAccountBase.getPSWXLogicsCnt();
            xmlNode.setAttribute(FIELD_PSWXLOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXAccountBase.getPSWXMenuFuncsCnt() != null) {
            object = pSWXAccountBase.getPSWXMenuFuncsCnt();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXAccountBase.getPSWXMenusCnt() != null) {
            object = pSWXAccountBase.getPSWXMenusCnt();
            xmlNode.setAttribute(FIELD_PSWXMENUSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXAccountBase.getUpdateDate() != null) {
            object = pSWXAccountBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXAccountBase.getUpdateMan() != null) {
            object = pSWXAccountBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getUserCat() != null) {
            object = pSWXAccountBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getUserTag() != null) {
            object = pSWXAccountBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getUserTag2() != null) {
            object = pSWXAccountBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getUserTag3() != null) {
            object = pSWXAccountBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getUserTag4() != null) {
            object = pSWXAccountBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getWXAccountParams() != null) {
            object = pSWXAccountBase.getWXAccountParams();
            xmlNode.setAttribute(FIELD_WXACCOUNTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSWXAccountBase.getWXAccountType() != null) {
            object = pSWXAccountBase.getWXAccountType();
            xmlNode.setAttribute(FIELD_WXACCOUNTTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXAccountBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXAccountBase pSWXAccountBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXAccountBase.isCodeNameDirty() && (bl || pSWXAccountBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWXAccountBase.getCodeName());
        }
        if (pSWXAccountBase.isCreateDateDirty() && (bl || pSWXAccountBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXAccountBase.getCreateDate());
        }
        if (pSWXAccountBase.isCreateManDirty() && (bl || pSWXAccountBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXAccountBase.getCreateMan());
        }
        if (pSWXAccountBase.isLockFlagDirty() && (bl || pSWXAccountBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSWXAccountBase.getLockFlag());
        }
        if (pSWXAccountBase.isMemoDirty() && (bl || pSWXAccountBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXAccountBase.getMemo());
        }
        if (pSWXAccountBase.isPSModuleIdDirty() && (bl || pSWXAccountBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSWXAccountBase.getPSModuleId());
        }
        if (pSWXAccountBase.isPSModuleNameDirty() && (bl || pSWXAccountBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSWXAccountBase.getPSModuleName());
        }
        if (pSWXAccountBase.isPSSysResourceIdDirty() && (bl || pSWXAccountBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSWXAccountBase.getPSSysResourceId());
        }
        if (pSWXAccountBase.isPSSysResourceNameDirty() && (bl || pSWXAccountBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSWXAccountBase.getPSSysResourceName());
        }
        if (pSWXAccountBase.isPSSysSFPluginIdDirty() && (bl || pSWXAccountBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWXAccountBase.getPSSysSFPluginId());
        }
        if (pSWXAccountBase.isPSSysSFPluginNameDirty() && (bl || pSWXAccountBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWXAccountBase.getPSSysSFPluginName());
        }
        if (pSWXAccountBase.isPSSystemIdDirty() && (bl || pSWXAccountBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWXAccountBase.getPSSystemId());
        }
        if (pSWXAccountBase.isPSSystemNameDirty() && (bl || pSWXAccountBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSWXAccountBase.getPSSystemName());
        }
        if (pSWXAccountBase.isPSWXAccountIdDirty() && (bl || pSWXAccountBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWXAccountBase.getPSWXAccountId());
        }
        if (pSWXAccountBase.isPSWXAccountNameDirty() && (bl || pSWXAccountBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWXAccountBase.getPSWXAccountName());
        }
        if (pSWXAccountBase.isPSWXEntAppsCntDirty() && (bl || pSWXAccountBase.getPSWXEntAppsCnt() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPSCNT, (Object)pSWXAccountBase.getPSWXEntAppsCnt());
        }
        if (pSWXAccountBase.isPSWXLogicsCntDirty() && (bl || pSWXAccountBase.getPSWXLogicsCnt() != null)) {
            iDataObject.set(FIELD_PSWXLOGICSCNT, (Object)pSWXAccountBase.getPSWXLogicsCnt());
        }
        if (pSWXAccountBase.isPSWXMenuFuncsCntDirty() && (bl || pSWXAccountBase.getPSWXMenuFuncsCnt() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCSCNT, (Object)pSWXAccountBase.getPSWXMenuFuncsCnt());
        }
        if (pSWXAccountBase.isPSWXMenusCntDirty() && (bl || pSWXAccountBase.getPSWXMenusCnt() != null)) {
            iDataObject.set(FIELD_PSWXMENUSCNT, (Object)pSWXAccountBase.getPSWXMenusCnt());
        }
        if (pSWXAccountBase.isUpdateDateDirty() && (bl || pSWXAccountBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXAccountBase.getUpdateDate());
        }
        if (pSWXAccountBase.isUpdateManDirty() && (bl || pSWXAccountBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXAccountBase.getUpdateMan());
        }
        if (pSWXAccountBase.isUserCatDirty() && (bl || pSWXAccountBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXAccountBase.getUserCat());
        }
        if (pSWXAccountBase.isUserTagDirty() && (bl || pSWXAccountBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXAccountBase.getUserTag());
        }
        if (pSWXAccountBase.isUserTag2Dirty() && (bl || pSWXAccountBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXAccountBase.getUserTag2());
        }
        if (pSWXAccountBase.isUserTag3Dirty() && (bl || pSWXAccountBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXAccountBase.getUserTag3());
        }
        if (pSWXAccountBase.isUserTag4Dirty() && (bl || pSWXAccountBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXAccountBase.getUserTag4());
        }
        if (pSWXAccountBase.isWXAccountParamsDirty() && (bl || pSWXAccountBase.getWXAccountParams() != null)) {
            iDataObject.set(FIELD_WXACCOUNTPARAMS, (Object)pSWXAccountBase.getWXAccountParams());
        }
        if (pSWXAccountBase.isWXAccountTypeDirty() && (bl || pSWXAccountBase.getWXAccountType() != null)) {
            iDataObject.set(FIELD_WXACCOUNTTYPE, (Object)pSWXAccountBase.getWXAccountType());
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
        return PSWXAccountBase.remove(this, n);
    }

    private static boolean remove(PSWXAccountBase pSWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXAccountBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWXAccountBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWXAccountBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWXAccountBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSWXAccountBase.resetMemo();
                return true;
            }
            case 5: {
                pSWXAccountBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSWXAccountBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSWXAccountBase.resetPSSysResourceId();
                return true;
            }
            case 8: {
                pSWXAccountBase.resetPSSysResourceName();
                return true;
            }
            case 9: {
                pSWXAccountBase.resetPSSysSFPluginId();
                return true;
            }
            case 10: {
                pSWXAccountBase.resetPSSysSFPluginName();
                return true;
            }
            case 11: {
                pSWXAccountBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSWXAccountBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSWXAccountBase.resetPSWXAccountId();
                return true;
            }
            case 14: {
                pSWXAccountBase.resetPSWXAccountName();
                return true;
            }
            case 15: {
                pSWXAccountBase.resetPSWXEntAppsCnt();
                return true;
            }
            case 16: {
                pSWXAccountBase.resetPSWXLogicsCnt();
                return true;
            }
            case 17: {
                pSWXAccountBase.resetPSWXMenuFuncsCnt();
                return true;
            }
            case 18: {
                pSWXAccountBase.resetPSWXMenusCnt();
                return true;
            }
            case 19: {
                pSWXAccountBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSWXAccountBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSWXAccountBase.resetUserCat();
                return true;
            }
            case 22: {
                pSWXAccountBase.resetUserTag();
                return true;
            }
            case 23: {
                pSWXAccountBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSWXAccountBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSWXAccountBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSWXAccountBase.resetWXAccountParams();
                return true;
            }
            case 27: {
                pSWXAccountBase.resetWXAccountType();
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
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet(pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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
    public ArrayList<PSWXEntApp> getPSWXEntApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntApps();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        PSWXEntAppService pSWXEntAppService = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXEntAppsLock;
        synchronized (n) {
            if (this.pswxentapps == null) {
                this.pswxentapps = pSWXEntAppService.selectByPSWXAccount(this);
            }
            return this.pswxentapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXLogic> getPSWXLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogics();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        PSWXLogicService pSWXLogicService = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXLogicsLock;
        synchronized (n) {
            if (this.pswxlogics == null) {
                this.pswxlogics = pSWXLogicService.selectByPSWXAccount(this);
            }
            return this.pswxlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXMenuFunc> getPSWXMenuFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncs();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXMenuFuncsLock;
        synchronized (n) {
            if (this.pswxmenufuncs == null) {
                this.pswxmenufuncs = pSWXMenuFuncService.selectByPSWXAccount(this);
            }
            return this.pswxmenufuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXMenu> getPSWXMenus() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenus();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        PSWXMenuService pSWXMenuService = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXMenusLock;
        synchronized (n) {
            if (this.pswxmenus == null) {
                this.pswxmenus = pSWXMenuService.selectByPSWXAccount(this);
            }
            return this.pswxmenus;
        }
    }

    private PSWXAccountBase getProxyEntity() {
        return this.proxyPSWXAccountBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXAccountBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXAccountBase) {
            this.proxyPSWXAccountBase = (PSWXAccountBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 7);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 9);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 13);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 14);
        fieldIndexMap.put(FIELD_PSWXENTAPPSCNT, 15);
        fieldIndexMap.put(FIELD_PSWXLOGICSCNT, 16);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCSCNT, 17);
        fieldIndexMap.put(FIELD_PSWXMENUSCNT, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_WXACCOUNTPARAMS, 26);
        fieldIndexMap.put(FIELD_WXACCOUNTTYPE, 27);
    }
}

