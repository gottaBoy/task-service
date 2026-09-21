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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlMsgBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGMODEL = "MSGMODEL";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWCTRLTYPE = "PSDEVIEWCTRLTYPE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
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
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MSGMODEL = 5;
    private static final int INDEX_PSCTRLMSGID = 6;
    private static final int INDEX_PSCTRLMSGNAME = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSDEVIEWCTRLTYPE = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSYSDYNAMODELID = 13;
    private static final int INDEX_PSSYSDYNAMODELNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlMsgBase proxyPSCtrlMsgBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msgmodelDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewctrltypeDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
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
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="msgmodel")
    private String msgmodel;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewctrltype")
    private String psdeviewctrltype;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSCtrlMsgItemsLock = new Integer(1);
    private ArrayList<PSCtrlMsgItem> psctrlmsgitems = null;

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

    public void setMsgModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgmodel = string;
        this.msgmodelDirtyFlag = true;
    }

    public String getMsgModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgModel();
        }
        return this.msgmodel;
    }

    public boolean isMsgModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgModelDirty();
        }
        return this.msgmodelDirtyFlag;
    }

    public void resetMsgModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgModel();
            return;
        }
        this.msgmodelDirtyFlag = false;
        this.msgmodel = null;
    }

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
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

    public void setPSDEViewCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrltype = string;
        this.psdeviewctrltypeDirtyFlag = true;
    }

    public String getPSDEViewCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlType();
        }
        return this.psdeviewctrltype;
    }

    public boolean isPSDEViewCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlTypeDirty();
        }
        return this.psdeviewctrltypeDirtyFlag;
    }

    public void resetPSDEViewCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlType();
            return;
        }
        this.psdeviewctrltypeDirtyFlag = false;
        this.psdeviewctrltype = null;
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

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
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
        PSCtrlMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlMsgBase pSCtrlMsgBase) {
        pSCtrlMsgBase.resetCodeName();
        pSCtrlMsgBase.resetCreateDate();
        pSCtrlMsgBase.resetCreateMan();
        pSCtrlMsgBase.resetLockFlag();
        pSCtrlMsgBase.resetMemo();
        pSCtrlMsgBase.resetMsgModel();
        pSCtrlMsgBase.resetPSCtrlMsgId();
        pSCtrlMsgBase.resetPSCtrlMsgName();
        pSCtrlMsgBase.resetPSDEId();
        pSCtrlMsgBase.resetPSDEName();
        pSCtrlMsgBase.resetPSDEViewCtrlType();
        pSCtrlMsgBase.resetPSModuleId();
        pSCtrlMsgBase.resetPSModuleName();
        pSCtrlMsgBase.resetPSSysDynaModelId();
        pSCtrlMsgBase.resetPSSysDynaModelName();
        pSCtrlMsgBase.resetPSSystemId();
        pSCtrlMsgBase.resetPSSystemName();
        pSCtrlMsgBase.resetUpdateDate();
        pSCtrlMsgBase.resetUpdateMan();
        pSCtrlMsgBase.resetUserCat();
        pSCtrlMsgBase.resetUserTag();
        pSCtrlMsgBase.resetUserTag2();
        pSCtrlMsgBase.resetUserTag3();
        pSCtrlMsgBase.resetUserTag4();
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
        if (!bl || this.isMsgModelDirty()) {
            hashMap.put(FIELD_MSGMODEL, this.getMsgModel());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewCtrlTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLTYPE, this.getPSDEViewCtrlType());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        return PSCtrlMsgBase.get(this, n);
    }

    private static Object get(PSCtrlMsgBase pSCtrlMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgBase.getCodeName();
            }
            case 1: {
                return pSCtrlMsgBase.getCreateDate();
            }
            case 2: {
                return pSCtrlMsgBase.getCreateMan();
            }
            case 3: {
                return pSCtrlMsgBase.getLockFlag();
            }
            case 4: {
                return pSCtrlMsgBase.getMemo();
            }
            case 5: {
                return pSCtrlMsgBase.getMsgModel();
            }
            case 6: {
                return pSCtrlMsgBase.getPSCtrlMsgId();
            }
            case 7: {
                return pSCtrlMsgBase.getPSCtrlMsgName();
            }
            case 8: {
                return pSCtrlMsgBase.getPSDEId();
            }
            case 9: {
                return pSCtrlMsgBase.getPSDEName();
            }
            case 10: {
                return pSCtrlMsgBase.getPSDEViewCtrlType();
            }
            case 11: {
                return pSCtrlMsgBase.getPSModuleId();
            }
            case 12: {
                return pSCtrlMsgBase.getPSModuleName();
            }
            case 13: {
                return pSCtrlMsgBase.getPSSysDynaModelId();
            }
            case 14: {
                return pSCtrlMsgBase.getPSSysDynaModelName();
            }
            case 15: {
                return pSCtrlMsgBase.getPSSystemId();
            }
            case 16: {
                return pSCtrlMsgBase.getPSSystemName();
            }
            case 17: {
                return pSCtrlMsgBase.getUpdateDate();
            }
            case 18: {
                return pSCtrlMsgBase.getUpdateMan();
            }
            case 19: {
                return pSCtrlMsgBase.getUserCat();
            }
            case 20: {
                return pSCtrlMsgBase.getUserTag();
            }
            case 21: {
                return pSCtrlMsgBase.getUserTag2();
            }
            case 22: {
                return pSCtrlMsgBase.getUserTag3();
            }
            case 23: {
                return pSCtrlMsgBase.getUserTag4();
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
        PSCtrlMsgBase.set(this, n, object);
    }

    private static void set(PSCtrlMsgBase pSCtrlMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlMsgBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlMsgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlMsgBase.setMsgModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlMsgBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlMsgBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlMsgBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlMsgBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlMsgBase.setPSDEViewCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlMsgBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlMsgBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlMsgBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlMsgBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCtrlMsgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCtrlMsgBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCtrlMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSCtrlMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCtrlMsgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCtrlMsgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCtrlMsgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCtrlMsgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCtrlMsgBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSCtrlMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlMsgBase pSCtrlMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgBase.getCodeName() == null;
            }
            case 1: {
                return pSCtrlMsgBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlMsgBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlMsgBase.getLockFlag() == null;
            }
            case 4: {
                return pSCtrlMsgBase.getMemo() == null;
            }
            case 5: {
                return pSCtrlMsgBase.getMsgModel() == null;
            }
            case 6: {
                return pSCtrlMsgBase.getPSCtrlMsgId() == null;
            }
            case 7: {
                return pSCtrlMsgBase.getPSCtrlMsgName() == null;
            }
            case 8: {
                return pSCtrlMsgBase.getPSDEId() == null;
            }
            case 9: {
                return pSCtrlMsgBase.getPSDEName() == null;
            }
            case 10: {
                return pSCtrlMsgBase.getPSDEViewCtrlType() == null;
            }
            case 11: {
                return pSCtrlMsgBase.getPSModuleId() == null;
            }
            case 12: {
                return pSCtrlMsgBase.getPSModuleName() == null;
            }
            case 13: {
                return pSCtrlMsgBase.getPSSysDynaModelId() == null;
            }
            case 14: {
                return pSCtrlMsgBase.getPSSysDynaModelName() == null;
            }
            case 15: {
                return pSCtrlMsgBase.getPSSystemId() == null;
            }
            case 16: {
                return pSCtrlMsgBase.getPSSystemName() == null;
            }
            case 17: {
                return pSCtrlMsgBase.getUpdateDate() == null;
            }
            case 18: {
                return pSCtrlMsgBase.getUpdateMan() == null;
            }
            case 19: {
                return pSCtrlMsgBase.getUserCat() == null;
            }
            case 20: {
                return pSCtrlMsgBase.getUserTag() == null;
            }
            case 21: {
                return pSCtrlMsgBase.getUserTag2() == null;
            }
            case 22: {
                return pSCtrlMsgBase.getUserTag3() == null;
            }
            case 23: {
                return pSCtrlMsgBase.getUserTag4() == null;
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
        return PSCtrlMsgBase.contains(this, n);
    }

    private static boolean contains(PSCtrlMsgBase pSCtrlMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgBase.isCodeNameDirty();
            }
            case 1: {
                return pSCtrlMsgBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlMsgBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlMsgBase.isLockFlagDirty();
            }
            case 4: {
                return pSCtrlMsgBase.isMemoDirty();
            }
            case 5: {
                return pSCtrlMsgBase.isMsgModelDirty();
            }
            case 6: {
                return pSCtrlMsgBase.isPSCtrlMsgIdDirty();
            }
            case 7: {
                return pSCtrlMsgBase.isPSCtrlMsgNameDirty();
            }
            case 8: {
                return pSCtrlMsgBase.isPSDEIdDirty();
            }
            case 9: {
                return pSCtrlMsgBase.isPSDENameDirty();
            }
            case 10: {
                return pSCtrlMsgBase.isPSDEViewCtrlTypeDirty();
            }
            case 11: {
                return pSCtrlMsgBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSCtrlMsgBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSCtrlMsgBase.isPSSysDynaModelIdDirty();
            }
            case 14: {
                return pSCtrlMsgBase.isPSSysDynaModelNameDirty();
            }
            case 15: {
                return pSCtrlMsgBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSCtrlMsgBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSCtrlMsgBase.isUpdateDateDirty();
            }
            case 18: {
                return pSCtrlMsgBase.isUpdateManDirty();
            }
            case 19: {
                return pSCtrlMsgBase.isUserCatDirty();
            }
            case 20: {
                return pSCtrlMsgBase.isUserTagDirty();
            }
            case 21: {
                return pSCtrlMsgBase.isUserTag2Dirty();
            }
            case 22: {
                return pSCtrlMsgBase.isUserTag3Dirty();
            }
            case 23: {
                return pSCtrlMsgBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlMsgBase pSCtrlMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlMsgBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getMsgModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgmodel", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getMsgModel()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSDEViewCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrltype", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSDEViewCtrlType()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCtrlMsgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCtrlMsgBase.getJSONValue((Object)pSCtrlMsgBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlMsgBase pSCtrlMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlMsgBase.getCodeName() != null) {
            object = pSCtrlMsgBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getCreateDate() != null) {
            object = pSCtrlMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgBase.getCreateMan() != null) {
            object = pSCtrlMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getLockFlag() != null) {
            object = pSCtrlMsgBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlMsgBase.getMemo() != null) {
            object = pSCtrlMsgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getMsgModel() != null) {
            object = pSCtrlMsgBase.getMsgModel();
            xmlNode.setAttribute(FIELD_MSGMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSCtrlMsgId() != null) {
            object = pSCtrlMsgBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSCtrlMsgName() != null) {
            object = pSCtrlMsgBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSDEId() != null) {
            object = pSCtrlMsgBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSDEName() != null) {
            object = pSCtrlMsgBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSDEViewCtrlType() != null) {
            object = pSCtrlMsgBase.getPSDEViewCtrlType();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSModuleId() != null) {
            object = pSCtrlMsgBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSModuleName() != null) {
            object = pSCtrlMsgBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSSysDynaModelId() != null) {
            object = pSCtrlMsgBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSSysDynaModelName() != null) {
            object = pSCtrlMsgBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSSystemId() != null) {
            object = pSCtrlMsgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getPSSystemName() != null) {
            object = pSCtrlMsgBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUpdateDate() != null) {
            object = pSCtrlMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgBase.getUpdateMan() != null) {
            object = pSCtrlMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUserCat() != null) {
            object = pSCtrlMsgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUserTag() != null) {
            object = pSCtrlMsgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUserTag2() != null) {
            object = pSCtrlMsgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUserTag3() != null) {
            object = pSCtrlMsgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgBase.getUserTag4() != null) {
            object = pSCtrlMsgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlMsgBase pSCtrlMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlMsgBase.isCodeNameDirty() && (bl || pSCtrlMsgBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCtrlMsgBase.getCodeName());
        }
        if (pSCtrlMsgBase.isCreateDateDirty() && (bl || pSCtrlMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlMsgBase.getCreateDate());
        }
        if (pSCtrlMsgBase.isCreateManDirty() && (bl || pSCtrlMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlMsgBase.getCreateMan());
        }
        if (pSCtrlMsgBase.isLockFlagDirty() && (bl || pSCtrlMsgBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSCtrlMsgBase.getLockFlag());
        }
        if (pSCtrlMsgBase.isMemoDirty() && (bl || pSCtrlMsgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlMsgBase.getMemo());
        }
        if (pSCtrlMsgBase.isMsgModelDirty() && (bl || pSCtrlMsgBase.getMsgModel() != null)) {
            iDataObject.set(FIELD_MSGMODEL, (Object)pSCtrlMsgBase.getMsgModel());
        }
        if (pSCtrlMsgBase.isPSCtrlMsgIdDirty() && (bl || pSCtrlMsgBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        }
        if (pSCtrlMsgBase.isPSCtrlMsgNameDirty() && (bl || pSCtrlMsgBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSCtrlMsgBase.getPSCtrlMsgName());
        }
        if (pSCtrlMsgBase.isPSDEIdDirty() && (bl || pSCtrlMsgBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSCtrlMsgBase.getPSDEId());
        }
        if (pSCtrlMsgBase.isPSDENameDirty() && (bl || pSCtrlMsgBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSCtrlMsgBase.getPSDEName());
        }
        if (pSCtrlMsgBase.isPSDEViewCtrlTypeDirty() && (bl || pSCtrlMsgBase.getPSDEViewCtrlType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLTYPE, (Object)pSCtrlMsgBase.getPSDEViewCtrlType());
        }
        if (pSCtrlMsgBase.isPSModuleIdDirty() && (bl || pSCtrlMsgBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSCtrlMsgBase.getPSModuleId());
        }
        if (pSCtrlMsgBase.isPSModuleNameDirty() && (bl || pSCtrlMsgBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSCtrlMsgBase.getPSModuleName());
        }
        if (pSCtrlMsgBase.isPSSysDynaModelIdDirty() && (bl || pSCtrlMsgBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSCtrlMsgBase.getPSSysDynaModelId());
        }
        if (pSCtrlMsgBase.isPSSysDynaModelNameDirty() && (bl || pSCtrlMsgBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSCtrlMsgBase.getPSSysDynaModelName());
        }
        if (pSCtrlMsgBase.isPSSystemIdDirty() && (bl || pSCtrlMsgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSCtrlMsgBase.getPSSystemId());
        }
        if (pSCtrlMsgBase.isPSSystemNameDirty() && (bl || pSCtrlMsgBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSCtrlMsgBase.getPSSystemName());
        }
        if (pSCtrlMsgBase.isUpdateDateDirty() && (bl || pSCtrlMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlMsgBase.getUpdateDate());
        }
        if (pSCtrlMsgBase.isUpdateManDirty() && (bl || pSCtrlMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlMsgBase.getUpdateMan());
        }
        if (pSCtrlMsgBase.isUserCatDirty() && (bl || pSCtrlMsgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCtrlMsgBase.getUserCat());
        }
        if (pSCtrlMsgBase.isUserTagDirty() && (bl || pSCtrlMsgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCtrlMsgBase.getUserTag());
        }
        if (pSCtrlMsgBase.isUserTag2Dirty() && (bl || pSCtrlMsgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCtrlMsgBase.getUserTag2());
        }
        if (pSCtrlMsgBase.isUserTag3Dirty() && (bl || pSCtrlMsgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCtrlMsgBase.getUserTag3());
        }
        if (pSCtrlMsgBase.isUserTag4Dirty() && (bl || pSCtrlMsgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCtrlMsgBase.getUserTag4());
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
        return PSCtrlMsgBase.remove(this, n);
    }

    private static boolean remove(PSCtrlMsgBase pSCtrlMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgBase.resetCodeName();
                return true;
            }
            case 1: {
                pSCtrlMsgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlMsgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlMsgBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSCtrlMsgBase.resetMemo();
                return true;
            }
            case 5: {
                pSCtrlMsgBase.resetMsgModel();
                return true;
            }
            case 6: {
                pSCtrlMsgBase.resetPSCtrlMsgId();
                return true;
            }
            case 7: {
                pSCtrlMsgBase.resetPSCtrlMsgName();
                return true;
            }
            case 8: {
                pSCtrlMsgBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSCtrlMsgBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSCtrlMsgBase.resetPSDEViewCtrlType();
                return true;
            }
            case 11: {
                pSCtrlMsgBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSCtrlMsgBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSCtrlMsgBase.resetPSSysDynaModelId();
                return true;
            }
            case 14: {
                pSCtrlMsgBase.resetPSSysDynaModelName();
                return true;
            }
            case 15: {
                pSCtrlMsgBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSCtrlMsgBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSCtrlMsgBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSCtrlMsgBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSCtrlMsgBase.resetUserCat();
                return true;
            }
            case 20: {
                pSCtrlMsgBase.resetUserTag();
                return true;
            }
            case 21: {
                pSCtrlMsgBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSCtrlMsgBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSCtrlMsgBase.resetUserTag4();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
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
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlMsgItem> getPSCtrlMsgItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgItems();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlMsgItemsLock;
        synchronized (n) {
            if (this.psctrlmsgitems == null) {
                this.psctrlmsgitems = pSCtrlMsgService.isTempData((IEntity)this) ? pSCtrlMsgItemService.selectTempByPSCtrlMsg(this) : pSCtrlMsgItemService.selectByPSCtrlMsg(this);
            }
            return this.psctrlmsgitems;
        }
    }

    private PSCtrlMsgBase getProxyEntity() {
        return this.proxyPSCtrlMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlMsgBase) {
            this.proxyPSCtrlMsgBase = (PSCtrlMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MSGMODEL, 5);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 6);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLTYPE, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 13);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
    }
}

