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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDELogicNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDELogicNodeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_CUSTOMOBJ = "CUSTOMOBJ";
    public static final String FIELD_CUSTOMPARAMS = "CUSTOMPARAMS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICTAG = "LOGICTAG";
    public static final String FIELD_LOGICTAG2 = "LOGICTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDELOGICNODEID = "PSSYSDELOGICNODEID";
    public static final String FIELD_PSSYSDELOGICNODENAME = "PSSYSDELOGICNODENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
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
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_CUSTOMOBJ = 5;
    private static final int INDEX_CUSTOMPARAMS = 6;
    private static final int INDEX_LOCKFLAG = 7;
    private static final int INDEX_LOGICTAG = 8;
    private static final int INDEX_LOGICTAG2 = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSYSDELOGICNODEID = 13;
    private static final int INDEX_PSSYSDELOGICNODENAME = 14;
    private static final int INDEX_PSSYSDYNAMODELID = 15;
    private static final int INDEX_PSSYSDYNAMODELNAME = 16;
    private static final int INDEX_PSSYSREQITEMID = 17;
    private static final int INDEX_PSSYSREQITEMNAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDELogicNodeBase proxyPSSysDELogicNodeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean customobjDirtyFlag = false;
    private boolean customparamsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logictagDirtyFlag = false;
    private boolean logictag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdelogicnodeidDirtyFlag = false;
    private boolean pssysdelogicnodenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
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
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="customobj")
    private String customobj;
    @Column(name="customparams")
    private String customparams;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logictag")
    private String logictag;
    @Column(name="logictag2")
    private String logictag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdelogicnodeid")
    private String pssysdelogicnodeid;
    @Column(name="pssysdelogicnodename")
    private String pssysdelogicnodename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
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
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setCustomObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customobj = string;
        this.customobjDirtyFlag = true;
    }

    public String getCustomObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomObj();
        }
        return this.customobj;
    }

    public boolean isCustomObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomObjDirty();
        }
        return this.customobjDirtyFlag;
    }

    public void resetCustomObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomObj();
            return;
        }
        this.customobjDirtyFlag = false;
        this.customobj = null;
    }

    public void setCustomParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customparams = string;
        this.customparamsDirtyFlag = true;
    }

    public String getCustomParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomParams();
        }
        return this.customparams;
    }

    public boolean isCustomParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomParamsDirty();
        }
        return this.customparamsDirtyFlag;
    }

    public void resetCustomParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomParams();
            return;
        }
        this.customparamsDirtyFlag = false;
        this.customparams = null;
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

    public void setLogicTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag = string;
        this.logictagDirtyFlag = true;
    }

    public String getLogicTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag();
        }
        return this.logictag;
    }

    public boolean isLogicTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTagDirty();
        }
        return this.logictagDirtyFlag;
    }

    public void resetLogicTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag();
            return;
        }
        this.logictagDirtyFlag = false;
        this.logictag = null;
    }

    public void setLogicTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag2 = string;
        this.logictag2DirtyFlag = true;
    }

    public String getLogicTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag2();
        }
        return this.logictag2;
    }

    public boolean isLogicTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTag2Dirty();
        }
        return this.logictag2DirtyFlag;
    }

    public void resetLogicTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag2();
            return;
        }
        this.logictag2DirtyFlag = false;
        this.logictag2 = null;
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

    public void setPSSysDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodeid = string;
        this.pssysdelogicnodeidDirtyFlag = true;
    }

    public String getPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeId();
        }
        return this.pssysdelogicnodeid;
    }

    public boolean isPSSysDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeIdDirty();
        }
        return this.pssysdelogicnodeidDirtyFlag;
    }

    public void resetPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeId();
            return;
        }
        this.pssysdelogicnodeidDirtyFlag = false;
        this.pssysdelogicnodeid = null;
    }

    public void setPSSysDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodename = string;
        this.pssysdelogicnodenameDirtyFlag = true;
    }

    public String getPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeName();
        }
        return this.pssysdelogicnodename;
    }

    public boolean isPSSysDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeNameDirty();
        }
        return this.pssysdelogicnodenameDirtyFlag;
    }

    public void resetPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeName();
            return;
        }
        this.pssysdelogicnodenameDirtyFlag = false;
        this.pssysdelogicnodename = null;
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

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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
        PSSysDELogicNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDELogicNodeBase pSSysDELogicNodeBase) {
        pSSysDELogicNodeBase.resetCodeName();
        pSSysDELogicNodeBase.resetCreateDate();
        pSSysDELogicNodeBase.resetCreateMan();
        pSSysDELogicNodeBase.resetCustomCode();
        pSSysDELogicNodeBase.resetCustomMode();
        pSSysDELogicNodeBase.resetCustomObj();
        pSSysDELogicNodeBase.resetCustomParams();
        pSSysDELogicNodeBase.resetLockFlag();
        pSSysDELogicNodeBase.resetLogicTag();
        pSSysDELogicNodeBase.resetLogicTag2();
        pSSysDELogicNodeBase.resetMemo();
        pSSysDELogicNodeBase.resetPSModuleId();
        pSSysDELogicNodeBase.resetPSModuleName();
        pSSysDELogicNodeBase.resetPSSysDELogicNodeId();
        pSSysDELogicNodeBase.resetPSSysDELogicNodeName();
        pSSysDELogicNodeBase.resetPSSysDynaModelId();
        pSSysDELogicNodeBase.resetPSSysDynaModelName();
        pSSysDELogicNodeBase.resetPSSysReqItemId();
        pSSysDELogicNodeBase.resetPSSysReqItemName();
        pSSysDELogicNodeBase.resetPSSysSFPluginId();
        pSSysDELogicNodeBase.resetPSSysSFPluginName();
        pSSysDELogicNodeBase.resetPSSystemId();
        pSSysDELogicNodeBase.resetPSSystemName();
        pSSysDELogicNodeBase.resetUpdateDate();
        pSSysDELogicNodeBase.resetUpdateMan();
        pSSysDELogicNodeBase.resetUserCat();
        pSSysDELogicNodeBase.resetUserTag();
        pSSysDELogicNodeBase.resetUserTag2();
        pSSysDELogicNodeBase.resetUserTag3();
        pSSysDELogicNodeBase.resetUserTag4();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isCustomObjDirty()) {
            hashMap.put(FIELD_CUSTOMOBJ, this.getCustomObj());
        }
        if (!bl || this.isCustomParamsDirty()) {
            hashMap.put(FIELD_CUSTOMPARAMS, this.getCustomParams());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicTagDirty()) {
            hashMap.put(FIELD_LOGICTAG, this.getLogicTag());
        }
        if (!bl || this.isLogicTag2Dirty()) {
            hashMap.put(FIELD_LOGICTAG2, this.getLogicTag2());
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
        if (!bl || this.isPSSysDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODEID, this.getPSSysDELogicNodeId());
        }
        if (!bl || this.isPSSysDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODENAME, this.getPSSysDELogicNodeName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
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
        return PSSysDELogicNodeBase.get(this, n);
    }

    private static Object get(PSSysDELogicNodeBase pSSysDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDELogicNodeBase.getCodeName();
            }
            case 1: {
                return pSSysDELogicNodeBase.getCreateDate();
            }
            case 2: {
                return pSSysDELogicNodeBase.getCreateMan();
            }
            case 3: {
                return pSSysDELogicNodeBase.getCustomCode();
            }
            case 4: {
                return pSSysDELogicNodeBase.getCustomMode();
            }
            case 5: {
                return pSSysDELogicNodeBase.getCustomObj();
            }
            case 6: {
                return pSSysDELogicNodeBase.getCustomParams();
            }
            case 7: {
                return pSSysDELogicNodeBase.getLockFlag();
            }
            case 8: {
                return pSSysDELogicNodeBase.getLogicTag();
            }
            case 9: {
                return pSSysDELogicNodeBase.getLogicTag2();
            }
            case 10: {
                return pSSysDELogicNodeBase.getMemo();
            }
            case 11: {
                return pSSysDELogicNodeBase.getPSModuleId();
            }
            case 12: {
                return pSSysDELogicNodeBase.getPSModuleName();
            }
            case 13: {
                return pSSysDELogicNodeBase.getPSSysDELogicNodeId();
            }
            case 14: {
                return pSSysDELogicNodeBase.getPSSysDELogicNodeName();
            }
            case 15: {
                return pSSysDELogicNodeBase.getPSSysDynaModelId();
            }
            case 16: {
                return pSSysDELogicNodeBase.getPSSysDynaModelName();
            }
            case 17: {
                return pSSysDELogicNodeBase.getPSSysReqItemId();
            }
            case 18: {
                return pSSysDELogicNodeBase.getPSSysReqItemName();
            }
            case 19: {
                return pSSysDELogicNodeBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysDELogicNodeBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysDELogicNodeBase.getPSSystemId();
            }
            case 22: {
                return pSSysDELogicNodeBase.getPSSystemName();
            }
            case 23: {
                return pSSysDELogicNodeBase.getUpdateDate();
            }
            case 24: {
                return pSSysDELogicNodeBase.getUpdateMan();
            }
            case 25: {
                return pSSysDELogicNodeBase.getUserCat();
            }
            case 26: {
                return pSSysDELogicNodeBase.getUserTag();
            }
            case 27: {
                return pSSysDELogicNodeBase.getUserTag2();
            }
            case 28: {
                return pSSysDELogicNodeBase.getUserTag3();
            }
            case 29: {
                return pSSysDELogicNodeBase.getUserTag4();
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
        PSSysDELogicNodeBase.set(this, n, object);
    }

    private static void set(PSSysDELogicNodeBase pSSysDELogicNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDELogicNodeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDELogicNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDELogicNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDELogicNodeBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDELogicNodeBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysDELogicNodeBase.setCustomObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDELogicNodeBase.setCustomParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDELogicNodeBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysDELogicNodeBase.setLogicTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDELogicNodeBase.setLogicTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDELogicNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDELogicNodeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDELogicNodeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDELogicNodeBase.setPSSysDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDELogicNodeBase.setPSSysDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDELogicNodeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDELogicNodeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDELogicNodeBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDELogicNodeBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDELogicNodeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDELogicNodeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDELogicNodeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDELogicNodeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDELogicNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysDELogicNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDELogicNodeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDELogicNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDELogicNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDELogicNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDELogicNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDELogicNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDELogicNodeBase pSSysDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDELogicNodeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDELogicNodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDELogicNodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDELogicNodeBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysDELogicNodeBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysDELogicNodeBase.getCustomObj() == null;
            }
            case 6: {
                return pSSysDELogicNodeBase.getCustomParams() == null;
            }
            case 7: {
                return pSSysDELogicNodeBase.getLockFlag() == null;
            }
            case 8: {
                return pSSysDELogicNodeBase.getLogicTag() == null;
            }
            case 9: {
                return pSSysDELogicNodeBase.getLogicTag2() == null;
            }
            case 10: {
                return pSSysDELogicNodeBase.getMemo() == null;
            }
            case 11: {
                return pSSysDELogicNodeBase.getPSModuleId() == null;
            }
            case 12: {
                return pSSysDELogicNodeBase.getPSModuleName() == null;
            }
            case 13: {
                return pSSysDELogicNodeBase.getPSSysDELogicNodeId() == null;
            }
            case 14: {
                return pSSysDELogicNodeBase.getPSSysDELogicNodeName() == null;
            }
            case 15: {
                return pSSysDELogicNodeBase.getPSSysDynaModelId() == null;
            }
            case 16: {
                return pSSysDELogicNodeBase.getPSSysDynaModelName() == null;
            }
            case 17: {
                return pSSysDELogicNodeBase.getPSSysReqItemId() == null;
            }
            case 18: {
                return pSSysDELogicNodeBase.getPSSysReqItemName() == null;
            }
            case 19: {
                return pSSysDELogicNodeBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysDELogicNodeBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysDELogicNodeBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysDELogicNodeBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysDELogicNodeBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysDELogicNodeBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysDELogicNodeBase.getUserCat() == null;
            }
            case 26: {
                return pSSysDELogicNodeBase.getUserTag() == null;
            }
            case 27: {
                return pSSysDELogicNodeBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysDELogicNodeBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysDELogicNodeBase.getUserTag4() == null;
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
        return PSSysDELogicNodeBase.contains(this, n);
    }

    private static boolean contains(PSSysDELogicNodeBase pSSysDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDELogicNodeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDELogicNodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDELogicNodeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDELogicNodeBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysDELogicNodeBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysDELogicNodeBase.isCustomObjDirty();
            }
            case 6: {
                return pSSysDELogicNodeBase.isCustomParamsDirty();
            }
            case 7: {
                return pSSysDELogicNodeBase.isLockFlagDirty();
            }
            case 8: {
                return pSSysDELogicNodeBase.isLogicTagDirty();
            }
            case 9: {
                return pSSysDELogicNodeBase.isLogicTag2Dirty();
            }
            case 10: {
                return pSSysDELogicNodeBase.isMemoDirty();
            }
            case 11: {
                return pSSysDELogicNodeBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSSysDELogicNodeBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSSysDELogicNodeBase.isPSSysDELogicNodeIdDirty();
            }
            case 14: {
                return pSSysDELogicNodeBase.isPSSysDELogicNodeNameDirty();
            }
            case 15: {
                return pSSysDELogicNodeBase.isPSSysDynaModelIdDirty();
            }
            case 16: {
                return pSSysDELogicNodeBase.isPSSysDynaModelNameDirty();
            }
            case 17: {
                return pSSysDELogicNodeBase.isPSSysReqItemIdDirty();
            }
            case 18: {
                return pSSysDELogicNodeBase.isPSSysReqItemNameDirty();
            }
            case 19: {
                return pSSysDELogicNodeBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysDELogicNodeBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysDELogicNodeBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysDELogicNodeBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysDELogicNodeBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysDELogicNodeBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysDELogicNodeBase.isUserCatDirty();
            }
            case 26: {
                return pSSysDELogicNodeBase.isUserTagDirty();
            }
            case 27: {
                return pSSysDELogicNodeBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysDELogicNodeBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysDELogicNodeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDELogicNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDELogicNodeBase pSSysDELogicNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDELogicNodeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCustomObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customobj", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCustomObj()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getCustomParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customparams", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getCustomParams()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getLogicTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getLogicTag()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getLogicTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag2", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getLogicTag2()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodeid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysDELogicNodeId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodename", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysDELogicNodeName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDELogicNodeBase.getJSONValue((Object)pSSysDELogicNodeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDELogicNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDELogicNodeBase pSSysDELogicNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDELogicNodeBase.getCodeName() != null) {
            object = pSSysDELogicNodeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getCreateDate() != null) {
            object = pSSysDELogicNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDELogicNodeBase.getCreateMan() != null) {
            object = pSSysDELogicNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getCustomCode() != null) {
            object = pSSysDELogicNodeBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getCustomMode() != null) {
            object = pSSysDELogicNodeBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDELogicNodeBase.getCustomObj() != null) {
            object = pSSysDELogicNodeBase.getCustomObj();
            xmlNode.setAttribute(FIELD_CUSTOMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getCustomParams() != null) {
            object = pSSysDELogicNodeBase.getCustomParams();
            xmlNode.setAttribute(FIELD_CUSTOMPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getLockFlag() != null) {
            object = pSSysDELogicNodeBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDELogicNodeBase.getLogicTag() != null) {
            object = pSSysDELogicNodeBase.getLogicTag();
            xmlNode.setAttribute(FIELD_LOGICTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getLogicTag2() != null) {
            object = pSSysDELogicNodeBase.getLogicTag2();
            xmlNode.setAttribute(FIELD_LOGICTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getMemo() != null) {
            object = pSSysDELogicNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSModuleId() != null) {
            object = pSSysDELogicNodeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSModuleName() != null) {
            object = pSSysDELogicNodeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeId() != null) {
            object = pSSysDELogicNodeBase.getPSSysDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeName() != null) {
            object = pSSysDELogicNodeBase.getPSSysDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDynaModelId() != null) {
            object = pSSysDELogicNodeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysDynaModelName() != null) {
            object = pSSysDELogicNodeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysReqItemId() != null) {
            object = pSSysDELogicNodeBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysReqItemName() != null) {
            object = pSSysDELogicNodeBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysSFPluginId() != null) {
            object = pSSysDELogicNodeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSysSFPluginName() != null) {
            object = pSSysDELogicNodeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSystemId() != null) {
            object = pSSysDELogicNodeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getPSSystemName() != null) {
            object = pSSysDELogicNodeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUpdateDate() != null) {
            object = pSSysDELogicNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDELogicNodeBase.getUpdateMan() != null) {
            object = pSSysDELogicNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUserCat() != null) {
            object = pSSysDELogicNodeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag() != null) {
            object = pSSysDELogicNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag2() != null) {
            object = pSSysDELogicNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag3() != null) {
            object = pSSysDELogicNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDELogicNodeBase.getUserTag4() != null) {
            object = pSSysDELogicNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDELogicNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDELogicNodeBase pSSysDELogicNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDELogicNodeBase.isCodeNameDirty() && (bl || pSSysDELogicNodeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDELogicNodeBase.getCodeName());
        }
        if (pSSysDELogicNodeBase.isCreateDateDirty() && (bl || pSSysDELogicNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDELogicNodeBase.getCreateDate());
        }
        if (pSSysDELogicNodeBase.isCreateManDirty() && (bl || pSSysDELogicNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDELogicNodeBase.getCreateMan());
        }
        if (pSSysDELogicNodeBase.isCustomCodeDirty() && (bl || pSSysDELogicNodeBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysDELogicNodeBase.getCustomCode());
        }
        if (pSSysDELogicNodeBase.isCustomModeDirty() && (bl || pSSysDELogicNodeBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysDELogicNodeBase.getCustomMode());
        }
        if (pSSysDELogicNodeBase.isCustomObjDirty() && (bl || pSSysDELogicNodeBase.getCustomObj() != null)) {
            iDataObject.set(FIELD_CUSTOMOBJ, (Object)pSSysDELogicNodeBase.getCustomObj());
        }
        if (pSSysDELogicNodeBase.isCustomParamsDirty() && (bl || pSSysDELogicNodeBase.getCustomParams() != null)) {
            iDataObject.set(FIELD_CUSTOMPARAMS, (Object)pSSysDELogicNodeBase.getCustomParams());
        }
        if (pSSysDELogicNodeBase.isLockFlagDirty() && (bl || pSSysDELogicNodeBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysDELogicNodeBase.getLockFlag());
        }
        if (pSSysDELogicNodeBase.isLogicTagDirty() && (bl || pSSysDELogicNodeBase.getLogicTag() != null)) {
            iDataObject.set(FIELD_LOGICTAG, (Object)pSSysDELogicNodeBase.getLogicTag());
        }
        if (pSSysDELogicNodeBase.isLogicTag2Dirty() && (bl || pSSysDELogicNodeBase.getLogicTag2() != null)) {
            iDataObject.set(FIELD_LOGICTAG2, (Object)pSSysDELogicNodeBase.getLogicTag2());
        }
        if (pSSysDELogicNodeBase.isMemoDirty() && (bl || pSSysDELogicNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDELogicNodeBase.getMemo());
        }
        if (pSSysDELogicNodeBase.isPSModuleIdDirty() && (bl || pSSysDELogicNodeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDELogicNodeBase.getPSModuleId());
        }
        if (pSSysDELogicNodeBase.isPSModuleNameDirty() && (bl || pSSysDELogicNodeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDELogicNodeBase.getPSModuleName());
        }
        if (pSSysDELogicNodeBase.isPSSysDELogicNodeIdDirty() && (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODEID, (Object)pSSysDELogicNodeBase.getPSSysDELogicNodeId());
        }
        if (pSSysDELogicNodeBase.isPSSysDELogicNodeNameDirty() && (bl || pSSysDELogicNodeBase.getPSSysDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODENAME, (Object)pSSysDELogicNodeBase.getPSSysDELogicNodeName());
        }
        if (pSSysDELogicNodeBase.isPSSysDynaModelIdDirty() && (bl || pSSysDELogicNodeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDELogicNodeBase.getPSSysDynaModelId());
        }
        if (pSSysDELogicNodeBase.isPSSysDynaModelNameDirty() && (bl || pSSysDELogicNodeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDELogicNodeBase.getPSSysDynaModelName());
        }
        if (pSSysDELogicNodeBase.isPSSysReqItemIdDirty() && (bl || pSSysDELogicNodeBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysDELogicNodeBase.getPSSysReqItemId());
        }
        if (pSSysDELogicNodeBase.isPSSysReqItemNameDirty() && (bl || pSSysDELogicNodeBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysDELogicNodeBase.getPSSysReqItemName());
        }
        if (pSSysDELogicNodeBase.isPSSysSFPluginIdDirty() && (bl || pSSysDELogicNodeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysDELogicNodeBase.getPSSysSFPluginId());
        }
        if (pSSysDELogicNodeBase.isPSSysSFPluginNameDirty() && (bl || pSSysDELogicNodeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysDELogicNodeBase.getPSSysSFPluginName());
        }
        if (pSSysDELogicNodeBase.isPSSystemIdDirty() && (bl || pSSysDELogicNodeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDELogicNodeBase.getPSSystemId());
        }
        if (pSSysDELogicNodeBase.isPSSystemNameDirty() && (bl || pSSysDELogicNodeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDELogicNodeBase.getPSSystemName());
        }
        if (pSSysDELogicNodeBase.isUpdateDateDirty() && (bl || pSSysDELogicNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDELogicNodeBase.getUpdateDate());
        }
        if (pSSysDELogicNodeBase.isUpdateManDirty() && (bl || pSSysDELogicNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDELogicNodeBase.getUpdateMan());
        }
        if (pSSysDELogicNodeBase.isUserCatDirty() && (bl || pSSysDELogicNodeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDELogicNodeBase.getUserCat());
        }
        if (pSSysDELogicNodeBase.isUserTagDirty() && (bl || pSSysDELogicNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDELogicNodeBase.getUserTag());
        }
        if (pSSysDELogicNodeBase.isUserTag2Dirty() && (bl || pSSysDELogicNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDELogicNodeBase.getUserTag2());
        }
        if (pSSysDELogicNodeBase.isUserTag3Dirty() && (bl || pSSysDELogicNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDELogicNodeBase.getUserTag3());
        }
        if (pSSysDELogicNodeBase.isUserTag4Dirty() && (bl || pSSysDELogicNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDELogicNodeBase.getUserTag4());
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
        return PSSysDELogicNodeBase.remove(this, n);
    }

    private static boolean remove(PSSysDELogicNodeBase pSSysDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDELogicNodeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDELogicNodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDELogicNodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDELogicNodeBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysDELogicNodeBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysDELogicNodeBase.resetCustomObj();
                return true;
            }
            case 6: {
                pSSysDELogicNodeBase.resetCustomParams();
                return true;
            }
            case 7: {
                pSSysDELogicNodeBase.resetLockFlag();
                return true;
            }
            case 8: {
                pSSysDELogicNodeBase.resetLogicTag();
                return true;
            }
            case 9: {
                pSSysDELogicNodeBase.resetLogicTag2();
                return true;
            }
            case 10: {
                pSSysDELogicNodeBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysDELogicNodeBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSSysDELogicNodeBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSSysDELogicNodeBase.resetPSSysDELogicNodeId();
                return true;
            }
            case 14: {
                pSSysDELogicNodeBase.resetPSSysDELogicNodeName();
                return true;
            }
            case 15: {
                pSSysDELogicNodeBase.resetPSSysDynaModelId();
                return true;
            }
            case 16: {
                pSSysDELogicNodeBase.resetPSSysDynaModelName();
                return true;
            }
            case 17: {
                pSSysDELogicNodeBase.resetPSSysReqItemId();
                return true;
            }
            case 18: {
                pSSysDELogicNodeBase.resetPSSysReqItemName();
                return true;
            }
            case 19: {
                pSSysDELogicNodeBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysDELogicNodeBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysDELogicNodeBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysDELogicNodeBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysDELogicNodeBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysDELogicNodeBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysDELogicNodeBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysDELogicNodeBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysDELogicNodeBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysDELogicNodeBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysDELogicNodeBase.resetUserTag4();
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
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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

    private PSSysDELogicNodeBase getProxyEntity() {
        return this.proxyPSSysDELogicNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDELogicNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDELogicNodeBase) {
            this.proxyPSSysDELogicNodeBase = (PSSysDELogicNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMOBJ, 5);
        fieldIndexMap.put(FIELD_CUSTOMPARAMS, 6);
        fieldIndexMap.put(FIELD_LOCKFLAG, 7);
        fieldIndexMap.put(FIELD_LOGICTAG, 8);
        fieldIndexMap.put(FIELD_LOGICTAG2, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODEID, 13);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 17);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
    }
}

