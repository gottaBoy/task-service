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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXLogicBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EVENTTYPE = "EVENTTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String FIELD_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String FIELD_PSWXLOGICID = "PSWXLOGICID";
    public static final String FIELD_PSWXLOGICNAME = "PSWXLOGICNAME";
    public static final String FIELD_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String FIELD_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
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
    private static final int INDEX_EVENTTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEACTIONID = 5;
    private static final int INDEX_PSDEACTIONNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSSYSRESOURCEID = 9;
    private static final int INDEX_PSSYSRESOURCENAME = 10;
    private static final int INDEX_PSSYSSFPLUGINID = 11;
    private static final int INDEX_PSSYSSFPLUGINNAME = 12;
    private static final int INDEX_PSWXACCOUNTID = 13;
    private static final int INDEX_PSWXACCOUNTNAME = 14;
    private static final int INDEX_PSWXENTAPPID = 15;
    private static final int INDEX_PSWXENTAPPNAME = 16;
    private static final int INDEX_PSWXLOGICID = 17;
    private static final int INDEX_PSWXLOGICNAME = 18;
    private static final int INDEX_PSWXMENUFUNCID = 19;
    private static final int INDEX_PSWXMENUFUNCNAME = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXLogicBase proxyPSWXLogicBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappidDirtyFlag = false;
    private boolean pswxentappnameDirtyFlag = false;
    private boolean pswxlogicidDirtyFlag = false;
    private boolean pswxlogicnameDirtyFlag = false;
    private boolean pswxmenufuncidDirtyFlag = false;
    private boolean pswxmenufuncnameDirtyFlag = false;
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
    @Column(name="eventtype")
    private String eventtype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappid")
    private String pswxentappid;
    @Column(name="pswxentappname")
    private String pswxentappname;
    @Column(name="pswxlogicid")
    private String pswxlogicid;
    @Column(name="pswxlogicname")
    private String pswxlogicname;
    @Column(name="pswxmenufuncid")
    private String pswxmenufuncid;
    @Column(name="pswxmenufuncname")
    private String pswxmenufuncname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSWXAccountLock = new Integer(1);
    private PSWXAccount pswxaccount = null;
    private Integer objPSWXEntAppLock = new Integer(1);
    private PSWXEntApp pswxentapp = null;
    private Integer objPSWXMenuFuncLock = new Integer(1);
    private PSWXMenuFunc pswxmenufunc = null;

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

    public void setEventType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventtype = string;
        this.eventtypeDirtyFlag = true;
    }

    public String getEventType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventType();
        }
        return this.eventtype;
    }

    public boolean isEventTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventTypeDirty();
        }
        return this.eventtypeDirtyFlag;
    }

    public void resetEventType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventType();
            return;
        }
        this.eventtypeDirtyFlag = false;
        this.eventtype = null;
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

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setPSWXEntAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappid = string;
        this.pswxentappidDirtyFlag = true;
    }

    public String getPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppId();
        }
        return this.pswxentappid;
    }

    public boolean isPSWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppIdDirty();
        }
        return this.pswxentappidDirtyFlag;
    }

    public void resetPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppId();
            return;
        }
        this.pswxentappidDirtyFlag = false;
        this.pswxentappid = null;
    }

    public void setPSWXEntAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappname = string;
        this.pswxentappnameDirtyFlag = true;
    }

    public String getPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppName();
        }
        return this.pswxentappname;
    }

    public boolean isPSWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppNameDirty();
        }
        return this.pswxentappnameDirtyFlag;
    }

    public void resetPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppName();
            return;
        }
        this.pswxentappnameDirtyFlag = false;
        this.pswxentappname = null;
    }

    public void setPSWXLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxlogicid = string;
        this.pswxlogicidDirtyFlag = true;
    }

    public String getPSWXLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogicId();
        }
        return this.pswxlogicid;
    }

    public boolean isPSWXLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXLogicIdDirty();
        }
        return this.pswxlogicidDirtyFlag;
    }

    public void resetPSWXLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXLogicId();
            return;
        }
        this.pswxlogicidDirtyFlag = false;
        this.pswxlogicid = null;
    }

    public void setPSWXLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxlogicname = string;
        this.pswxlogicnameDirtyFlag = true;
    }

    public String getPSWXLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogicName();
        }
        return this.pswxlogicname;
    }

    public boolean isPSWXLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXLogicNameDirty();
        }
        return this.pswxlogicnameDirtyFlag;
    }

    public void resetPSWXLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXLogicName();
            return;
        }
        this.pswxlogicnameDirtyFlag = false;
        this.pswxlogicname = null;
    }

    public void setPSWXMenuFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncid = string;
        this.pswxmenufuncidDirtyFlag = true;
    }

    public String getPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncId();
        }
        return this.pswxmenufuncid;
    }

    public boolean isPSWXMenuFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncIdDirty();
        }
        return this.pswxmenufuncidDirtyFlag;
    }

    public void resetPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncId();
            return;
        }
        this.pswxmenufuncidDirtyFlag = false;
        this.pswxmenufuncid = null;
    }

    public void setPSWXMenuFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncname = string;
        this.pswxmenufuncnameDirtyFlag = true;
    }

    public String getPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncName();
        }
        return this.pswxmenufuncname;
    }

    public boolean isPSWXMenuFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncNameDirty();
        }
        return this.pswxmenufuncnameDirtyFlag;
    }

    public void resetPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncName();
            return;
        }
        this.pswxmenufuncnameDirtyFlag = false;
        this.pswxmenufuncname = null;
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
        PSWXLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXLogicBase pSWXLogicBase) {
        pSWXLogicBase.resetCodeName();
        pSWXLogicBase.resetCreateDate();
        pSWXLogicBase.resetCreateMan();
        pSWXLogicBase.resetEventType();
        pSWXLogicBase.resetMemo();
        pSWXLogicBase.resetPSDEActionId();
        pSWXLogicBase.resetPSDEActionName();
        pSWXLogicBase.resetPSDEId();
        pSWXLogicBase.resetPSDEName();
        pSWXLogicBase.resetPSSysResourceId();
        pSWXLogicBase.resetPSSysResourceName();
        pSWXLogicBase.resetPSSysSFPluginId();
        pSWXLogicBase.resetPSSysSFPluginName();
        pSWXLogicBase.resetPSWXAccountId();
        pSWXLogicBase.resetPSWXAccountName();
        pSWXLogicBase.resetPSWXEntAppId();
        pSWXLogicBase.resetPSWXEntAppName();
        pSWXLogicBase.resetPSWXLogicId();
        pSWXLogicBase.resetPSWXLogicName();
        pSWXLogicBase.resetPSWXMenuFuncId();
        pSWXLogicBase.resetPSWXMenuFuncName();
        pSWXLogicBase.resetUpdateDate();
        pSWXLogicBase.resetUpdateMan();
        pSWXLogicBase.resetUserCat();
        pSWXLogicBase.resetUserTag();
        pSWXLogicBase.resetUserTag2();
        pSWXLogicBase.resetUserTag3();
        pSWXLogicBase.resetUserTag4();
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
        if (!bl || this.isEventTypeDirty()) {
            hashMap.put(FIELD_EVENTTYPE, this.getEventType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        if (!bl || this.isPSWXAccountIdDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTID, this.getPSWXAccountId());
        }
        if (!bl || this.isPSWXAccountNameDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTNAME, this.getPSWXAccountName());
        }
        if (!bl || this.isPSWXEntAppIdDirty()) {
            hashMap.put(FIELD_PSWXENTAPPID, this.getPSWXEntAppId());
        }
        if (!bl || this.isPSWXEntAppNameDirty()) {
            hashMap.put(FIELD_PSWXENTAPPNAME, this.getPSWXEntAppName());
        }
        if (!bl || this.isPSWXLogicIdDirty()) {
            hashMap.put(FIELD_PSWXLOGICID, this.getPSWXLogicId());
        }
        if (!bl || this.isPSWXLogicNameDirty()) {
            hashMap.put(FIELD_PSWXLOGICNAME, this.getPSWXLogicName());
        }
        if (!bl || this.isPSWXMenuFuncIdDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCID, this.getPSWXMenuFuncId());
        }
        if (!bl || this.isPSWXMenuFuncNameDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCNAME, this.getPSWXMenuFuncName());
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
        return PSWXLogicBase.get(this, n);
    }

    private static Object get(PSWXLogicBase pSWXLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXLogicBase.getCodeName();
            }
            case 1: {
                return pSWXLogicBase.getCreateDate();
            }
            case 2: {
                return pSWXLogicBase.getCreateMan();
            }
            case 3: {
                return pSWXLogicBase.getEventType();
            }
            case 4: {
                return pSWXLogicBase.getMemo();
            }
            case 5: {
                return pSWXLogicBase.getPSDEActionId();
            }
            case 6: {
                return pSWXLogicBase.getPSDEActionName();
            }
            case 7: {
                return pSWXLogicBase.getPSDEId();
            }
            case 8: {
                return pSWXLogicBase.getPSDEName();
            }
            case 9: {
                return pSWXLogicBase.getPSSysResourceId();
            }
            case 10: {
                return pSWXLogicBase.getPSSysResourceName();
            }
            case 11: {
                return pSWXLogicBase.getPSSysSFPluginId();
            }
            case 12: {
                return pSWXLogicBase.getPSSysSFPluginName();
            }
            case 13: {
                return pSWXLogicBase.getPSWXAccountId();
            }
            case 14: {
                return pSWXLogicBase.getPSWXAccountName();
            }
            case 15: {
                return pSWXLogicBase.getPSWXEntAppId();
            }
            case 16: {
                return pSWXLogicBase.getPSWXEntAppName();
            }
            case 17: {
                return pSWXLogicBase.getPSWXLogicId();
            }
            case 18: {
                return pSWXLogicBase.getPSWXLogicName();
            }
            case 19: {
                return pSWXLogicBase.getPSWXMenuFuncId();
            }
            case 20: {
                return pSWXLogicBase.getPSWXMenuFuncName();
            }
            case 21: {
                return pSWXLogicBase.getUpdateDate();
            }
            case 22: {
                return pSWXLogicBase.getUpdateMan();
            }
            case 23: {
                return pSWXLogicBase.getUserCat();
            }
            case 24: {
                return pSWXLogicBase.getUserTag();
            }
            case 25: {
                return pSWXLogicBase.getUserTag2();
            }
            case 26: {
                return pSWXLogicBase.getUserTag3();
            }
            case 27: {
                return pSWXLogicBase.getUserTag4();
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
        PSWXLogicBase.set(this, n, object);
    }

    private static void set(PSWXLogicBase pSWXLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXLogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWXLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWXLogicBase.setEventType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWXLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWXLogicBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXLogicBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWXLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXLogicBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXLogicBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXLogicBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXLogicBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWXLogicBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWXLogicBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXLogicBase.setPSWXEntAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWXLogicBase.setPSWXEntAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWXLogicBase.setPSWXLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWXLogicBase.setPSWXLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWXLogicBase.setPSWXMenuFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWXLogicBase.setPSWXMenuFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWXLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSWXLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWXLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWXLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWXLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWXLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWXLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWXLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSWXLogicBase pSWXLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXLogicBase.getCodeName() == null;
            }
            case 1: {
                return pSWXLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSWXLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSWXLogicBase.getEventType() == null;
            }
            case 4: {
                return pSWXLogicBase.getMemo() == null;
            }
            case 5: {
                return pSWXLogicBase.getPSDEActionId() == null;
            }
            case 6: {
                return pSWXLogicBase.getPSDEActionName() == null;
            }
            case 7: {
                return pSWXLogicBase.getPSDEId() == null;
            }
            case 8: {
                return pSWXLogicBase.getPSDEName() == null;
            }
            case 9: {
                return pSWXLogicBase.getPSSysResourceId() == null;
            }
            case 10: {
                return pSWXLogicBase.getPSSysResourceName() == null;
            }
            case 11: {
                return pSWXLogicBase.getPSSysSFPluginId() == null;
            }
            case 12: {
                return pSWXLogicBase.getPSSysSFPluginName() == null;
            }
            case 13: {
                return pSWXLogicBase.getPSWXAccountId() == null;
            }
            case 14: {
                return pSWXLogicBase.getPSWXAccountName() == null;
            }
            case 15: {
                return pSWXLogicBase.getPSWXEntAppId() == null;
            }
            case 16: {
                return pSWXLogicBase.getPSWXEntAppName() == null;
            }
            case 17: {
                return pSWXLogicBase.getPSWXLogicId() == null;
            }
            case 18: {
                return pSWXLogicBase.getPSWXLogicName() == null;
            }
            case 19: {
                return pSWXLogicBase.getPSWXMenuFuncId() == null;
            }
            case 20: {
                return pSWXLogicBase.getPSWXMenuFuncName() == null;
            }
            case 21: {
                return pSWXLogicBase.getUpdateDate() == null;
            }
            case 22: {
                return pSWXLogicBase.getUpdateMan() == null;
            }
            case 23: {
                return pSWXLogicBase.getUserCat() == null;
            }
            case 24: {
                return pSWXLogicBase.getUserTag() == null;
            }
            case 25: {
                return pSWXLogicBase.getUserTag2() == null;
            }
            case 26: {
                return pSWXLogicBase.getUserTag3() == null;
            }
            case 27: {
                return pSWXLogicBase.getUserTag4() == null;
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
        return PSWXLogicBase.contains(this, n);
    }

    private static boolean contains(PSWXLogicBase pSWXLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXLogicBase.isCodeNameDirty();
            }
            case 1: {
                return pSWXLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSWXLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSWXLogicBase.isEventTypeDirty();
            }
            case 4: {
                return pSWXLogicBase.isMemoDirty();
            }
            case 5: {
                return pSWXLogicBase.isPSDEActionIdDirty();
            }
            case 6: {
                return pSWXLogicBase.isPSDEActionNameDirty();
            }
            case 7: {
                return pSWXLogicBase.isPSDEIdDirty();
            }
            case 8: {
                return pSWXLogicBase.isPSDENameDirty();
            }
            case 9: {
                return pSWXLogicBase.isPSSysResourceIdDirty();
            }
            case 10: {
                return pSWXLogicBase.isPSSysResourceNameDirty();
            }
            case 11: {
                return pSWXLogicBase.isPSSysSFPluginIdDirty();
            }
            case 12: {
                return pSWXLogicBase.isPSSysSFPluginNameDirty();
            }
            case 13: {
                return pSWXLogicBase.isPSWXAccountIdDirty();
            }
            case 14: {
                return pSWXLogicBase.isPSWXAccountNameDirty();
            }
            case 15: {
                return pSWXLogicBase.isPSWXEntAppIdDirty();
            }
            case 16: {
                return pSWXLogicBase.isPSWXEntAppNameDirty();
            }
            case 17: {
                return pSWXLogicBase.isPSWXLogicIdDirty();
            }
            case 18: {
                return pSWXLogicBase.isPSWXLogicNameDirty();
            }
            case 19: {
                return pSWXLogicBase.isPSWXMenuFuncIdDirty();
            }
            case 20: {
                return pSWXLogicBase.isPSWXMenuFuncNameDirty();
            }
            case 21: {
                return pSWXLogicBase.isUpdateDateDirty();
            }
            case 22: {
                return pSWXLogicBase.isUpdateManDirty();
            }
            case 23: {
                return pSWXLogicBase.isUserCatDirty();
            }
            case 24: {
                return pSWXLogicBase.isUserTagDirty();
            }
            case 25: {
                return pSWXLogicBase.isUserTag2Dirty();
            }
            case 26: {
                return pSWXLogicBase.isUserTag3Dirty();
            }
            case 27: {
                return pSWXLogicBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXLogicBase pSWXLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXLogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getEventType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventtype", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getEventType()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXEntAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXEntAppId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXEntAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXEntAppName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxlogicid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXLogicId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxlogicname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXLogicName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXMenuFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncid", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXMenuFuncId()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getPSWXMenuFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncname", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getPSWXMenuFuncName()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXLogicBase.getJSONValue((Object)pSWXLogicBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXLogicBase pSWXLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXLogicBase.getCodeName() != null) {
            object = pSWXLogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getCreateDate() != null) {
            object = pSWXLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXLogicBase.getCreateMan() != null) {
            object = pSWXLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getEventType() != null) {
            object = pSWXLogicBase.getEventType();
            xmlNode.setAttribute(FIELD_EVENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getMemo() != null) {
            object = pSWXLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSDEActionId() != null) {
            object = pSWXLogicBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSDEActionName() != null) {
            object = pSWXLogicBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSDEId() != null) {
            object = pSWXLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSDEName() != null) {
            object = pSWXLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSSysResourceId() != null) {
            object = pSWXLogicBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSSysResourceName() != null) {
            object = pSWXLogicBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSSysSFPluginId() != null) {
            object = pSWXLogicBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSSysSFPluginName() != null) {
            object = pSWXLogicBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXAccountId() != null) {
            object = pSWXLogicBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXAccountName() != null) {
            object = pSWXLogicBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXEntAppId() != null) {
            object = pSWXLogicBase.getPSWXEntAppId();
            xmlNode.setAttribute(FIELD_PSWXENTAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXEntAppName() != null) {
            object = pSWXLogicBase.getPSWXEntAppName();
            xmlNode.setAttribute(FIELD_PSWXENTAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXLogicId() != null) {
            object = pSWXLogicBase.getPSWXLogicId();
            xmlNode.setAttribute(FIELD_PSWXLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXLogicName() != null) {
            object = pSWXLogicBase.getPSWXLogicName();
            xmlNode.setAttribute(FIELD_PSWXLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXMenuFuncId() != null) {
            object = pSWXLogicBase.getPSWXMenuFuncId();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getPSWXMenuFuncName() != null) {
            object = pSWXLogicBase.getPSWXMenuFuncName();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUpdateDate() != null) {
            object = pSWXLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXLogicBase.getUpdateMan() != null) {
            object = pSWXLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUserCat() != null) {
            object = pSWXLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUserTag() != null) {
            object = pSWXLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUserTag2() != null) {
            object = pSWXLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUserTag3() != null) {
            object = pSWXLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXLogicBase.getUserTag4() != null) {
            object = pSWXLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXLogicBase pSWXLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXLogicBase.isCodeNameDirty() && (bl || pSWXLogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWXLogicBase.getCodeName());
        }
        if (pSWXLogicBase.isCreateDateDirty() && (bl || pSWXLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXLogicBase.getCreateDate());
        }
        if (pSWXLogicBase.isCreateManDirty() && (bl || pSWXLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXLogicBase.getCreateMan());
        }
        if (pSWXLogicBase.isEventTypeDirty() && (bl || pSWXLogicBase.getEventType() != null)) {
            iDataObject.set(FIELD_EVENTTYPE, (Object)pSWXLogicBase.getEventType());
        }
        if (pSWXLogicBase.isMemoDirty() && (bl || pSWXLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXLogicBase.getMemo());
        }
        if (pSWXLogicBase.isPSDEActionIdDirty() && (bl || pSWXLogicBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSWXLogicBase.getPSDEActionId());
        }
        if (pSWXLogicBase.isPSDEActionNameDirty() && (bl || pSWXLogicBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSWXLogicBase.getPSDEActionName());
        }
        if (pSWXLogicBase.isPSDEIdDirty() && (bl || pSWXLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWXLogicBase.getPSDEId());
        }
        if (pSWXLogicBase.isPSDENameDirty() && (bl || pSWXLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSWXLogicBase.getPSDEName());
        }
        if (pSWXLogicBase.isPSSysResourceIdDirty() && (bl || pSWXLogicBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSWXLogicBase.getPSSysResourceId());
        }
        if (pSWXLogicBase.isPSSysResourceNameDirty() && (bl || pSWXLogicBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSWXLogicBase.getPSSysResourceName());
        }
        if (pSWXLogicBase.isPSSysSFPluginIdDirty() && (bl || pSWXLogicBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWXLogicBase.getPSSysSFPluginId());
        }
        if (pSWXLogicBase.isPSSysSFPluginNameDirty() && (bl || pSWXLogicBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWXLogicBase.getPSSysSFPluginName());
        }
        if (pSWXLogicBase.isPSWXAccountIdDirty() && (bl || pSWXLogicBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWXLogicBase.getPSWXAccountId());
        }
        if (pSWXLogicBase.isPSWXAccountNameDirty() && (bl || pSWXLogicBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWXLogicBase.getPSWXAccountName());
        }
        if (pSWXLogicBase.isPSWXEntAppIdDirty() && (bl || pSWXLogicBase.getPSWXEntAppId() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPID, (Object)pSWXLogicBase.getPSWXEntAppId());
        }
        if (pSWXLogicBase.isPSWXEntAppNameDirty() && (bl || pSWXLogicBase.getPSWXEntAppName() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPNAME, (Object)pSWXLogicBase.getPSWXEntAppName());
        }
        if (pSWXLogicBase.isPSWXLogicIdDirty() && (bl || pSWXLogicBase.getPSWXLogicId() != null)) {
            iDataObject.set(FIELD_PSWXLOGICID, (Object)pSWXLogicBase.getPSWXLogicId());
        }
        if (pSWXLogicBase.isPSWXLogicNameDirty() && (bl || pSWXLogicBase.getPSWXLogicName() != null)) {
            iDataObject.set(FIELD_PSWXLOGICNAME, (Object)pSWXLogicBase.getPSWXLogicName());
        }
        if (pSWXLogicBase.isPSWXMenuFuncIdDirty() && (bl || pSWXLogicBase.getPSWXMenuFuncId() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCID, (Object)pSWXLogicBase.getPSWXMenuFuncId());
        }
        if (pSWXLogicBase.isPSWXMenuFuncNameDirty() && (bl || pSWXLogicBase.getPSWXMenuFuncName() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCNAME, (Object)pSWXLogicBase.getPSWXMenuFuncName());
        }
        if (pSWXLogicBase.isUpdateDateDirty() && (bl || pSWXLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXLogicBase.getUpdateDate());
        }
        if (pSWXLogicBase.isUpdateManDirty() && (bl || pSWXLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXLogicBase.getUpdateMan());
        }
        if (pSWXLogicBase.isUserCatDirty() && (bl || pSWXLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXLogicBase.getUserCat());
        }
        if (pSWXLogicBase.isUserTagDirty() && (bl || pSWXLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXLogicBase.getUserTag());
        }
        if (pSWXLogicBase.isUserTag2Dirty() && (bl || pSWXLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXLogicBase.getUserTag2());
        }
        if (pSWXLogicBase.isUserTag3Dirty() && (bl || pSWXLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXLogicBase.getUserTag3());
        }
        if (pSWXLogicBase.isUserTag4Dirty() && (bl || pSWXLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXLogicBase.getUserTag4());
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
        return PSWXLogicBase.remove(this, n);
    }

    private static boolean remove(PSWXLogicBase pSWXLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXLogicBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWXLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWXLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWXLogicBase.resetEventType();
                return true;
            }
            case 4: {
                pSWXLogicBase.resetMemo();
                return true;
            }
            case 5: {
                pSWXLogicBase.resetPSDEActionId();
                return true;
            }
            case 6: {
                pSWXLogicBase.resetPSDEActionName();
                return true;
            }
            case 7: {
                pSWXLogicBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSWXLogicBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSWXLogicBase.resetPSSysResourceId();
                return true;
            }
            case 10: {
                pSWXLogicBase.resetPSSysResourceName();
                return true;
            }
            case 11: {
                pSWXLogicBase.resetPSSysSFPluginId();
                return true;
            }
            case 12: {
                pSWXLogicBase.resetPSSysSFPluginName();
                return true;
            }
            case 13: {
                pSWXLogicBase.resetPSWXAccountId();
                return true;
            }
            case 14: {
                pSWXLogicBase.resetPSWXAccountName();
                return true;
            }
            case 15: {
                pSWXLogicBase.resetPSWXEntAppId();
                return true;
            }
            case 16: {
                pSWXLogicBase.resetPSWXEntAppName();
                return true;
            }
            case 17: {
                pSWXLogicBase.resetPSWXLogicId();
                return true;
            }
            case 18: {
                pSWXLogicBase.resetPSWXLogicName();
                return true;
            }
            case 19: {
                pSWXLogicBase.resetPSWXMenuFuncId();
                return true;
            }
            case 20: {
                pSWXLogicBase.resetPSWXMenuFuncName();
                return true;
            }
            case 21: {
                pSWXLogicBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSWXLogicBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSWXLogicBase.resetUserCat();
                return true;
            }
            case 24: {
                pSWXLogicBase.resetUserTag();
                return true;
            }
            case 25: {
                pSWXLogicBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSWXLogicBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSWXLogicBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
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
    public PSWXAccount getPSWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccount();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        Integer n = this.objPSWXAccountLock;
        synchronized (n) {
            if (this.pswxaccount != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXAccountId(), (Object)this.pswxaccount.getPSWXAccountId()) != 0L) {
                this.pswxaccount = null;
            }
            if (this.pswxaccount == null) {
                PSWXAccount pSWXAccount = new PSWXAccount();
                pSWXAccount.setPSWXAccountId(this.getPSWXAccountId());
                PSWXAccountService pSWXAccountService = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
                pSWXAccountService.autoGet(pSWXAccount);
                this.pswxaccount = pSWXAccount;
            }
            return this.pswxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXEntApp getPSWXEntApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntApp();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        Integer n = this.objPSWXEntAppLock;
        synchronized (n) {
            if (this.pswxentapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXEntAppId(), (Object)this.pswxentapp.getPSWXEntAppId()) != 0L) {
                this.pswxentapp = null;
            }
            if (this.pswxentapp == null) {
                PSWXEntApp pSWXEntApp = new PSWXEntApp();
                pSWXEntApp.setPSWXEntAppId(this.getPSWXEntAppId());
                PSWXEntAppService pSWXEntAppService = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
                pSWXEntAppService.autoGet(pSWXEntApp);
                this.pswxentapp = pSWXEntApp;
            }
            return this.pswxentapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXMenuFunc getPSWXMenuFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFunc();
        }
        if (this.getPSWXMenuFuncId() == null) {
            return null;
        }
        Integer n = this.objPSWXMenuFuncLock;
        synchronized (n) {
            if (this.pswxmenufunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXMenuFuncId(), (Object)this.pswxmenufunc.getPSWXMenuFuncId()) != 0L) {
                this.pswxmenufunc = null;
            }
            if (this.pswxmenufunc == null) {
                PSWXMenuFunc pSWXMenuFunc = new PSWXMenuFunc();
                pSWXMenuFunc.setPSWXMenuFuncId(this.getPSWXMenuFuncId());
                PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
                pSWXMenuFuncService.autoGet(pSWXMenuFunc);
                this.pswxmenufunc = pSWXMenuFunc;
            }
            return this.pswxmenufunc;
        }
    }

    private PSWXLogicBase getProxyEntity() {
        return this.proxyPSWXLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXLogicBase) {
            this.proxyPSWXLogicBase = (PSWXLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EVENTTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 5);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 9);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 12);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 13);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 14);
        fieldIndexMap.put(FIELD_PSWXENTAPPID, 15);
        fieldIndexMap.put(FIELD_PSWXENTAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSWXLOGICID, 17);
        fieldIndexMap.put(FIELD_PSWXLOGICNAME, 18);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCID, 19);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCNAME, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
    }
}

