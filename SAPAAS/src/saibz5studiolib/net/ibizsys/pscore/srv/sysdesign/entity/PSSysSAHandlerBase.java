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
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandler;
import net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService;
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

public abstract class PSSysSAHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSAHandlerBase.class);
    public static final String FIELD_CLIENTHANDLEROBJ = "CLIENTHANDLEROBJ";
    public static final String FIELD_CLIENTHANDLEROBJ2 = "CLIENTHANDLEROBJ2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_HANDLEROBJ = "HANDLEROBJ";
    public static final String FIELD_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String FIELD_HANDLERPARAMS = "HANDLERPARAMS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSFSAHANDLERID = "PSSFSAHANDLERID";
    public static final String FIELD_PSSFSAHANDLERNAME = "PSSFSAHANDLERNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSAHANDLERID = "PSSYSSAHANDLERID";
    public static final String FIELD_PSSYSSAHANDLERNAME = "PSSYSSAHANDLERNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SATYPE = "SATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CLIENTHANDLEROBJ = 0;
    private static final int INDEX_CLIENTHANDLEROBJ2 = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DYNAMODELFLAG = 5;
    private static final int INDEX_HANDLEROBJ = 6;
    private static final int INDEX_HANDLEROBJ2 = 7;
    private static final int INDEX_HANDLERPARAMS = 8;
    private static final int INDEX_LOCKFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSDYNAINSTID = 11;
    private static final int INDEX_PSMODULEID = 12;
    private static final int INDEX_PSMODULENAME = 13;
    private static final int INDEX_PSSFSAHANDLERID = 14;
    private static final int INDEX_PSSFSAHANDLERNAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSSAHANDLERID = 18;
    private static final int INDEX_PSSYSSAHANDLERNAME = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSSYSTEMNAME = 21;
    private static final int INDEX_SATYPE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSAHandlerBase proxyPSSysSAHandlerBase = null;
    private boolean clienthandlerobjDirtyFlag = false;
    private boolean clienthandlerobj2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean handlerobjDirtyFlag = false;
    private boolean handlerobj2DirtyFlag = false;
    private boolean handlerparamsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssfsahandleridDirtyFlag = false;
    private boolean pssfsahandlernameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssahandleridDirtyFlag = false;
    private boolean pssyssahandlernameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean satypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="clienthandlerobj")
    private String clienthandlerobj;
    @Column(name="clienthandlerobj2")
    private String clienthandlerobj2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="handlerobj")
    private String handlerobj;
    @Column(name="handlerobj2")
    private String handlerobj2;
    @Column(name="handlerparams")
    private String handlerparams;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssfsahandlerid")
    private String pssfsahandlerid;
    @Column(name="pssfsahandlername")
    private String pssfsahandlername;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssahandlerid")
    private String pssyssahandlerid;
    @Column(name="pssyssahandlername")
    private String pssyssahandlername;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="satype")
    private String satype;
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
    private Integer objPSSFSAHandlerLock = new Integer(1);
    private PSSFSAHandler pssfsahandler = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setClientHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clienthandlerobj = string;
        this.clienthandlerobjDirtyFlag = true;
    }

    public String getClientHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientHandlerObj();
        }
        return this.clienthandlerobj;
    }

    public boolean isClientHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientHandlerObjDirty();
        }
        return this.clienthandlerobjDirtyFlag;
    }

    public void resetClientHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientHandlerObj();
            return;
        }
        this.clienthandlerobjDirtyFlag = false;
        this.clienthandlerobj = null;
    }

    public void setClientHandlerObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientHandlerObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clienthandlerobj2 = string;
        this.clienthandlerobj2DirtyFlag = true;
    }

    public String getClientHandlerObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientHandlerObj2();
        }
        return this.clienthandlerobj2;
    }

    public boolean isClientHandlerObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientHandlerObj2Dirty();
        }
        return this.clienthandlerobj2DirtyFlag;
    }

    public void resetClientHandlerObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientHandlerObj2();
            return;
        }
        this.clienthandlerobj2DirtyFlag = false;
        this.clienthandlerobj2 = null;
    }

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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj = string;
        this.handlerobjDirtyFlag = true;
    }

    public String getHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj();
        }
        return this.handlerobj;
    }

    public boolean isHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObjDirty();
        }
        return this.handlerobjDirtyFlag;
    }

    public void resetHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj();
            return;
        }
        this.handlerobjDirtyFlag = false;
        this.handlerobj = null;
    }

    public void setHandlerObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj2 = string;
        this.handlerobj2DirtyFlag = true;
    }

    public String getHandlerObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj2();
        }
        return this.handlerobj2;
    }

    public boolean isHandlerObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObj2Dirty();
        }
        return this.handlerobj2DirtyFlag;
    }

    public void resetHandlerObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj2();
            return;
        }
        this.handlerobj2DirtyFlag = false;
        this.handlerobj2 = null;
    }

    public void setHandlerParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerparams = string;
        this.handlerparamsDirtyFlag = true;
    }

    public String getHandlerParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerParams();
        }
        return this.handlerparams;
    }

    public boolean isHandlerParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerParamsDirty();
        }
        return this.handlerparamsDirtyFlag;
    }

    public void resetHandlerParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerParams();
            return;
        }
        this.handlerparamsDirtyFlag = false;
        this.handlerparams = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setPSSFSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfsahandlerid = string;
        this.pssfsahandleridDirtyFlag = true;
    }

    public String getPSSFSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFSAHandlerId();
        }
        return this.pssfsahandlerid;
    }

    public boolean isPSSFSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFSAHandlerIdDirty();
        }
        return this.pssfsahandleridDirtyFlag;
    }

    public void resetPSSFSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFSAHandlerId();
            return;
        }
        this.pssfsahandleridDirtyFlag = false;
        this.pssfsahandlerid = null;
    }

    public void setPSSFSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfsahandlername = string;
        this.pssfsahandlernameDirtyFlag = true;
    }

    public String getPSSFSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFSAHandlerName();
        }
        return this.pssfsahandlername;
    }

    public boolean isPSSFSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFSAHandlerNameDirty();
        }
        return this.pssfsahandlernameDirtyFlag;
    }

    public void resetPSSFSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFSAHandlerName();
            return;
        }
        this.pssfsahandlernameDirtyFlag = false;
        this.pssfsahandlername = null;
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

    public void setPSSysSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssahandlerid = string;
        this.pssyssahandleridDirtyFlag = true;
    }

    public String getPSSysSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSAHandlerId();
        }
        return this.pssyssahandlerid;
    }

    public boolean isPSSysSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSAHandlerIdDirty();
        }
        return this.pssyssahandleridDirtyFlag;
    }

    public void resetPSSysSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSAHandlerId();
            return;
        }
        this.pssyssahandleridDirtyFlag = false;
        this.pssyssahandlerid = null;
    }

    public void setPSSysSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssahandlername = string;
        this.pssyssahandlernameDirtyFlag = true;
    }

    public String getPSSysSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSAHandlerName();
        }
        return this.pssyssahandlername;
    }

    public boolean isPSSysSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSAHandlerNameDirty();
        }
        return this.pssyssahandlernameDirtyFlag;
    }

    public void resetPSSysSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSAHandlerName();
            return;
        }
        this.pssyssahandlernameDirtyFlag = false;
        this.pssyssahandlername = null;
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

    public void setSAType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSAType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.satype = string;
        this.satypeDirtyFlag = true;
    }

    public String getSAType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSAType();
        }
        return this.satype;
    }

    public boolean isSATypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSATypeDirty();
        }
        return this.satypeDirtyFlag;
    }

    public void resetSAType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSAType();
            return;
        }
        this.satypeDirtyFlag = false;
        this.satype = null;
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
        PSSysSAHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSAHandlerBase pSSysSAHandlerBase) {
        pSSysSAHandlerBase.resetClientHandlerObj();
        pSSysSAHandlerBase.resetClientHandlerObj2();
        pSSysSAHandlerBase.resetCodeName();
        pSSysSAHandlerBase.resetCreateDate();
        pSSysSAHandlerBase.resetCreateMan();
        pSSysSAHandlerBase.resetDynaModelFlag();
        pSSysSAHandlerBase.resetHandlerObj();
        pSSysSAHandlerBase.resetHandlerObj2();
        pSSysSAHandlerBase.resetHandlerParams();
        pSSysSAHandlerBase.resetLockFlag();
        pSSysSAHandlerBase.resetMemo();
        pSSysSAHandlerBase.resetPSDynaInstId();
        pSSysSAHandlerBase.resetPSModuleId();
        pSSysSAHandlerBase.resetPSModuleName();
        pSSysSAHandlerBase.resetPSSFSAHandlerId();
        pSSysSAHandlerBase.resetPSSFSAHandlerName();
        pSSysSAHandlerBase.resetPSSysDynaModelId();
        pSSysSAHandlerBase.resetPSSysDynaModelName();
        pSSysSAHandlerBase.resetPSSysSAHandlerId();
        pSSysSAHandlerBase.resetPSSysSAHandlerName();
        pSSysSAHandlerBase.resetPSSystemId();
        pSSysSAHandlerBase.resetPSSystemName();
        pSSysSAHandlerBase.resetSAType();
        pSSysSAHandlerBase.resetUpdateDate();
        pSSysSAHandlerBase.resetUpdateMan();
        pSSysSAHandlerBase.resetUserCat();
        pSSysSAHandlerBase.resetUserTag();
        pSSysSAHandlerBase.resetUserTag2();
        pSSysSAHandlerBase.resetUserTag3();
        pSSysSAHandlerBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClientHandlerObjDirty()) {
            hashMap.put(FIELD_CLIENTHANDLEROBJ, this.getClientHandlerObj());
        }
        if (!bl || this.isClientHandlerObj2Dirty()) {
            hashMap.put(FIELD_CLIENTHANDLEROBJ2, this.getClientHandlerObj2());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isHandlerObjDirty()) {
            hashMap.put(FIELD_HANDLEROBJ, this.getHandlerObj());
        }
        if (!bl || this.isHandlerObj2Dirty()) {
            hashMap.put(FIELD_HANDLEROBJ2, this.getHandlerObj2());
        }
        if (!bl || this.isHandlerParamsDirty()) {
            hashMap.put(FIELD_HANDLERPARAMS, this.getHandlerParams());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSFSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSFSAHANDLERID, this.getPSSFSAHandlerId());
        }
        if (!bl || this.isPSSFSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSFSAHANDLERNAME, this.getPSSFSAHandlerName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSYSSAHANDLERID, this.getPSSysSAHandlerId());
        }
        if (!bl || this.isPSSysSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSYSSAHANDLERNAME, this.getPSSysSAHandlerName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSATypeDirty()) {
            hashMap.put(FIELD_SATYPE, this.getSAType());
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
        return PSSysSAHandlerBase.get(this, n);
    }

    private static Object get(PSSysSAHandlerBase pSSysSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSAHandlerBase.getClientHandlerObj();
            }
            case 1: {
                return pSSysSAHandlerBase.getClientHandlerObj2();
            }
            case 2: {
                return pSSysSAHandlerBase.getCodeName();
            }
            case 3: {
                return pSSysSAHandlerBase.getCreateDate();
            }
            case 4: {
                return pSSysSAHandlerBase.getCreateMan();
            }
            case 5: {
                return pSSysSAHandlerBase.getDynaModelFlag();
            }
            case 6: {
                return pSSysSAHandlerBase.getHandlerObj();
            }
            case 7: {
                return pSSysSAHandlerBase.getHandlerObj2();
            }
            case 8: {
                return pSSysSAHandlerBase.getHandlerParams();
            }
            case 9: {
                return pSSysSAHandlerBase.getLockFlag();
            }
            case 10: {
                return pSSysSAHandlerBase.getMemo();
            }
            case 11: {
                return pSSysSAHandlerBase.getPSDynaInstId();
            }
            case 12: {
                return pSSysSAHandlerBase.getPSModuleId();
            }
            case 13: {
                return pSSysSAHandlerBase.getPSModuleName();
            }
            case 14: {
                return pSSysSAHandlerBase.getPSSFSAHandlerId();
            }
            case 15: {
                return pSSysSAHandlerBase.getPSSFSAHandlerName();
            }
            case 16: {
                return pSSysSAHandlerBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSSysSAHandlerBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSSysSAHandlerBase.getPSSysSAHandlerId();
            }
            case 19: {
                return pSSysSAHandlerBase.getPSSysSAHandlerName();
            }
            case 20: {
                return pSSysSAHandlerBase.getPSSystemId();
            }
            case 21: {
                return pSSysSAHandlerBase.getPSSystemName();
            }
            case 22: {
                return pSSysSAHandlerBase.getSAType();
            }
            case 23: {
                return pSSysSAHandlerBase.getUpdateDate();
            }
            case 24: {
                return pSSysSAHandlerBase.getUpdateMan();
            }
            case 25: {
                return pSSysSAHandlerBase.getUserCat();
            }
            case 26: {
                return pSSysSAHandlerBase.getUserTag();
            }
            case 27: {
                return pSSysSAHandlerBase.getUserTag2();
            }
            case 28: {
                return pSSysSAHandlerBase.getUserTag3();
            }
            case 29: {
                return pSSysSAHandlerBase.getUserTag4();
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
        PSSysSAHandlerBase.set(this, n, object);
    }

    private static void set(PSSysSAHandlerBase pSSysSAHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSAHandlerBase.setClientHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSAHandlerBase.setClientHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSAHandlerBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSAHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysSAHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSAHandlerBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysSAHandlerBase.setHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSAHandlerBase.setHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSAHandlerBase.setHandlerParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSAHandlerBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysSAHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSAHandlerBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSAHandlerBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSAHandlerBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSAHandlerBase.setPSSFSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSAHandlerBase.setPSSFSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSAHandlerBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSAHandlerBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSAHandlerBase.setPSSysSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSAHandlerBase.setPSSysSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSAHandlerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSAHandlerBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSAHandlerBase.setSAType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSAHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysSAHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSAHandlerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSAHandlerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSAHandlerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSAHandlerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSAHandlerBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSAHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSAHandlerBase pSSysSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSAHandlerBase.getClientHandlerObj() == null;
            }
            case 1: {
                return pSSysSAHandlerBase.getClientHandlerObj2() == null;
            }
            case 2: {
                return pSSysSAHandlerBase.getCodeName() == null;
            }
            case 3: {
                return pSSysSAHandlerBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysSAHandlerBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysSAHandlerBase.getDynaModelFlag() == null;
            }
            case 6: {
                return pSSysSAHandlerBase.getHandlerObj() == null;
            }
            case 7: {
                return pSSysSAHandlerBase.getHandlerObj2() == null;
            }
            case 8: {
                return pSSysSAHandlerBase.getHandlerParams() == null;
            }
            case 9: {
                return pSSysSAHandlerBase.getLockFlag() == null;
            }
            case 10: {
                return pSSysSAHandlerBase.getMemo() == null;
            }
            case 11: {
                return pSSysSAHandlerBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSSysSAHandlerBase.getPSModuleId() == null;
            }
            case 13: {
                return pSSysSAHandlerBase.getPSModuleName() == null;
            }
            case 14: {
                return pSSysSAHandlerBase.getPSSFSAHandlerId() == null;
            }
            case 15: {
                return pSSysSAHandlerBase.getPSSFSAHandlerName() == null;
            }
            case 16: {
                return pSSysSAHandlerBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSysSAHandlerBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSysSAHandlerBase.getPSSysSAHandlerId() == null;
            }
            case 19: {
                return pSSysSAHandlerBase.getPSSysSAHandlerName() == null;
            }
            case 20: {
                return pSSysSAHandlerBase.getPSSystemId() == null;
            }
            case 21: {
                return pSSysSAHandlerBase.getPSSystemName() == null;
            }
            case 22: {
                return pSSysSAHandlerBase.getSAType() == null;
            }
            case 23: {
                return pSSysSAHandlerBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysSAHandlerBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysSAHandlerBase.getUserCat() == null;
            }
            case 26: {
                return pSSysSAHandlerBase.getUserTag() == null;
            }
            case 27: {
                return pSSysSAHandlerBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysSAHandlerBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysSAHandlerBase.getUserTag4() == null;
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
        return PSSysSAHandlerBase.contains(this, n);
    }

    private static boolean contains(PSSysSAHandlerBase pSSysSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSAHandlerBase.isClientHandlerObjDirty();
            }
            case 1: {
                return pSSysSAHandlerBase.isClientHandlerObj2Dirty();
            }
            case 2: {
                return pSSysSAHandlerBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysSAHandlerBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysSAHandlerBase.isCreateManDirty();
            }
            case 5: {
                return pSSysSAHandlerBase.isDynaModelFlagDirty();
            }
            case 6: {
                return pSSysSAHandlerBase.isHandlerObjDirty();
            }
            case 7: {
                return pSSysSAHandlerBase.isHandlerObj2Dirty();
            }
            case 8: {
                return pSSysSAHandlerBase.isHandlerParamsDirty();
            }
            case 9: {
                return pSSysSAHandlerBase.isLockFlagDirty();
            }
            case 10: {
                return pSSysSAHandlerBase.isMemoDirty();
            }
            case 11: {
                return pSSysSAHandlerBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSSysSAHandlerBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSSysSAHandlerBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSSysSAHandlerBase.isPSSFSAHandlerIdDirty();
            }
            case 15: {
                return pSSysSAHandlerBase.isPSSFSAHandlerNameDirty();
            }
            case 16: {
                return pSSysSAHandlerBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSysSAHandlerBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSysSAHandlerBase.isPSSysSAHandlerIdDirty();
            }
            case 19: {
                return pSSysSAHandlerBase.isPSSysSAHandlerNameDirty();
            }
            case 20: {
                return pSSysSAHandlerBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSSysSAHandlerBase.isPSSystemNameDirty();
            }
            case 22: {
                return pSSysSAHandlerBase.isSATypeDirty();
            }
            case 23: {
                return pSSysSAHandlerBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysSAHandlerBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysSAHandlerBase.isUserCatDirty();
            }
            case 26: {
                return pSSysSAHandlerBase.isUserTagDirty();
            }
            case 27: {
                return pSSysSAHandlerBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysSAHandlerBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysSAHandlerBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSAHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSAHandlerBase pSSysSAHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSAHandlerBase.getClientHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clienthandlerobj", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getClientHandlerObj()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getClientHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clienthandlerobj2", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getClientHandlerObj2()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getHandlerObj()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj2", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getHandlerObj2()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getHandlerParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerparams", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getHandlerParams()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSFSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfsahandlerid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSFSAHandlerId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSFSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfsahandlername", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSFSAHandlerName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSysSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlerid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSysSAHandlerId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSysSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlername", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSysSAHandlerName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getSAType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"satype", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getSAType()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSAHandlerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSAHandlerBase.getJSONValue((Object)pSSysSAHandlerBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSAHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSAHandlerBase pSSysSAHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSAHandlerBase.getClientHandlerObj() != null) {
            object = pSSysSAHandlerBase.getClientHandlerObj();
            xmlNode.setAttribute(FIELD_CLIENTHANDLEROBJ, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSAHandlerBase.getClientHandlerObj2() != null) {
            object = pSSysSAHandlerBase.getClientHandlerObj2();
            xmlNode.setAttribute(FIELD_CLIENTHANDLEROBJ2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSAHandlerBase.getCodeName() != null) {
            object = pSSysSAHandlerBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getCreateDate() != null) {
            object = pSSysSAHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSAHandlerBase.getCreateMan() != null) {
            object = pSSysSAHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getDynaModelFlag() != null) {
            object = pSSysSAHandlerBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSAHandlerBase.getHandlerObj() != null) {
            object = pSSysSAHandlerBase.getHandlerObj();
            xmlNode.setAttribute(FIELD_HANDLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getHandlerObj2() != null) {
            object = pSSysSAHandlerBase.getHandlerObj2();
            xmlNode.setAttribute(FIELD_HANDLEROBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getHandlerParams() != null) {
            object = pSSysSAHandlerBase.getHandlerParams();
            xmlNode.setAttribute(FIELD_HANDLERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getLockFlag() != null) {
            object = pSSysSAHandlerBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSAHandlerBase.getMemo() != null) {
            object = pSSysSAHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSDynaInstId() != null) {
            object = pSSysSAHandlerBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSModuleId() != null) {
            object = pSSysSAHandlerBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSModuleName() != null) {
            object = pSSysSAHandlerBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSFSAHandlerId() != null) {
            object = pSSysSAHandlerBase.getPSSFSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSFSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSFSAHandlerName() != null) {
            object = pSSysSAHandlerBase.getPSSFSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSFSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSysDynaModelId() != null) {
            object = pSSysSAHandlerBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSysDynaModelName() != null) {
            object = pSSysSAHandlerBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSysSAHandlerId() != null) {
            object = pSSysSAHandlerBase.getPSSysSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSysSAHandlerName() != null) {
            object = pSSysSAHandlerBase.getPSSysSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSystemId() != null) {
            object = pSSysSAHandlerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getPSSystemName() != null) {
            object = pSSysSAHandlerBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getSAType() != null) {
            object = pSSysSAHandlerBase.getSAType();
            xmlNode.setAttribute(FIELD_SATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUpdateDate() != null) {
            object = pSSysSAHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSAHandlerBase.getUpdateMan() != null) {
            object = pSSysSAHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUserCat() != null) {
            object = pSSysSAHandlerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUserTag() != null) {
            object = pSSysSAHandlerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUserTag2() != null) {
            object = pSSysSAHandlerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUserTag3() != null) {
            object = pSSysSAHandlerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSAHandlerBase.getUserTag4() != null) {
            object = pSSysSAHandlerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSAHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSAHandlerBase pSSysSAHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSAHandlerBase.isClientHandlerObjDirty() && (bl || pSSysSAHandlerBase.getClientHandlerObj() != null)) {
            iDataObject.set(FIELD_CLIENTHANDLEROBJ, (Object)pSSysSAHandlerBase.getClientHandlerObj());
        }
        if (pSSysSAHandlerBase.isClientHandlerObj2Dirty() && (bl || pSSysSAHandlerBase.getClientHandlerObj2() != null)) {
            iDataObject.set(FIELD_CLIENTHANDLEROBJ2, (Object)pSSysSAHandlerBase.getClientHandlerObj2());
        }
        if (pSSysSAHandlerBase.isCodeNameDirty() && (bl || pSSysSAHandlerBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSAHandlerBase.getCodeName());
        }
        if (pSSysSAHandlerBase.isCreateDateDirty() && (bl || pSSysSAHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSAHandlerBase.getCreateDate());
        }
        if (pSSysSAHandlerBase.isCreateManDirty() && (bl || pSSysSAHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSAHandlerBase.getCreateMan());
        }
        if (pSSysSAHandlerBase.isDynaModelFlagDirty() && (bl || pSSysSAHandlerBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysSAHandlerBase.getDynaModelFlag());
        }
        if (pSSysSAHandlerBase.isHandlerObjDirty() && (bl || pSSysSAHandlerBase.getHandlerObj() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ, (Object)pSSysSAHandlerBase.getHandlerObj());
        }
        if (pSSysSAHandlerBase.isHandlerObj2Dirty() && (bl || pSSysSAHandlerBase.getHandlerObj2() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ2, (Object)pSSysSAHandlerBase.getHandlerObj2());
        }
        if (pSSysSAHandlerBase.isHandlerParamsDirty() && (bl || pSSysSAHandlerBase.getHandlerParams() != null)) {
            iDataObject.set(FIELD_HANDLERPARAMS, (Object)pSSysSAHandlerBase.getHandlerParams());
        }
        if (pSSysSAHandlerBase.isLockFlagDirty() && (bl || pSSysSAHandlerBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysSAHandlerBase.getLockFlag());
        }
        if (pSSysSAHandlerBase.isMemoDirty() && (bl || pSSysSAHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSAHandlerBase.getMemo());
        }
        if (pSSysSAHandlerBase.isPSDynaInstIdDirty() && (bl || pSSysSAHandlerBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysSAHandlerBase.getPSDynaInstId());
        }
        if (pSSysSAHandlerBase.isPSModuleIdDirty() && (bl || pSSysSAHandlerBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSAHandlerBase.getPSModuleId());
        }
        if (pSSysSAHandlerBase.isPSModuleNameDirty() && (bl || pSSysSAHandlerBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSAHandlerBase.getPSModuleName());
        }
        if (pSSysSAHandlerBase.isPSSFSAHandlerIdDirty() && (bl || pSSysSAHandlerBase.getPSSFSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSFSAHANDLERID, (Object)pSSysSAHandlerBase.getPSSFSAHandlerId());
        }
        if (pSSysSAHandlerBase.isPSSFSAHandlerNameDirty() && (bl || pSSysSAHandlerBase.getPSSFSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSFSAHANDLERNAME, (Object)pSSysSAHandlerBase.getPSSFSAHandlerName());
        }
        if (pSSysSAHandlerBase.isPSSysDynaModelIdDirty() && (bl || pSSysSAHandlerBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysSAHandlerBase.getPSSysDynaModelId());
        }
        if (pSSysSAHandlerBase.isPSSysDynaModelNameDirty() && (bl || pSSysSAHandlerBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysSAHandlerBase.getPSSysDynaModelName());
        }
        if (pSSysSAHandlerBase.isPSSysSAHandlerIdDirty() && (bl || pSSysSAHandlerBase.getPSSysSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERID, (Object)pSSysSAHandlerBase.getPSSysSAHandlerId());
        }
        if (pSSysSAHandlerBase.isPSSysSAHandlerNameDirty() && (bl || pSSysSAHandlerBase.getPSSysSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERNAME, (Object)pSSysSAHandlerBase.getPSSysSAHandlerName());
        }
        if (pSSysSAHandlerBase.isPSSystemIdDirty() && (bl || pSSysSAHandlerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSAHandlerBase.getPSSystemId());
        }
        if (pSSysSAHandlerBase.isPSSystemNameDirty() && (bl || pSSysSAHandlerBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSAHandlerBase.getPSSystemName());
        }
        if (pSSysSAHandlerBase.isSATypeDirty() && (bl || pSSysSAHandlerBase.getSAType() != null)) {
            iDataObject.set(FIELD_SATYPE, (Object)pSSysSAHandlerBase.getSAType());
        }
        if (pSSysSAHandlerBase.isUpdateDateDirty() && (bl || pSSysSAHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSAHandlerBase.getUpdateDate());
        }
        if (pSSysSAHandlerBase.isUpdateManDirty() && (bl || pSSysSAHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSAHandlerBase.getUpdateMan());
        }
        if (pSSysSAHandlerBase.isUserCatDirty() && (bl || pSSysSAHandlerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSAHandlerBase.getUserCat());
        }
        if (pSSysSAHandlerBase.isUserTagDirty() && (bl || pSSysSAHandlerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSAHandlerBase.getUserTag());
        }
        if (pSSysSAHandlerBase.isUserTag2Dirty() && (bl || pSSysSAHandlerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSAHandlerBase.getUserTag2());
        }
        if (pSSysSAHandlerBase.isUserTag3Dirty() && (bl || pSSysSAHandlerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSAHandlerBase.getUserTag3());
        }
        if (pSSysSAHandlerBase.isUserTag4Dirty() && (bl || pSSysSAHandlerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSAHandlerBase.getUserTag4());
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
        return PSSysSAHandlerBase.remove(this, n);
    }

    private static boolean remove(PSSysSAHandlerBase pSSysSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSAHandlerBase.resetClientHandlerObj();
                return true;
            }
            case 1: {
                pSSysSAHandlerBase.resetClientHandlerObj2();
                return true;
            }
            case 2: {
                pSSysSAHandlerBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysSAHandlerBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysSAHandlerBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysSAHandlerBase.resetDynaModelFlag();
                return true;
            }
            case 6: {
                pSSysSAHandlerBase.resetHandlerObj();
                return true;
            }
            case 7: {
                pSSysSAHandlerBase.resetHandlerObj2();
                return true;
            }
            case 8: {
                pSSysSAHandlerBase.resetHandlerParams();
                return true;
            }
            case 9: {
                pSSysSAHandlerBase.resetLockFlag();
                return true;
            }
            case 10: {
                pSSysSAHandlerBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysSAHandlerBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSSysSAHandlerBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSSysSAHandlerBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSSysSAHandlerBase.resetPSSFSAHandlerId();
                return true;
            }
            case 15: {
                pSSysSAHandlerBase.resetPSSFSAHandlerName();
                return true;
            }
            case 16: {
                pSSysSAHandlerBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSysSAHandlerBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSysSAHandlerBase.resetPSSysSAHandlerId();
                return true;
            }
            case 19: {
                pSSysSAHandlerBase.resetPSSysSAHandlerName();
                return true;
            }
            case 20: {
                pSSysSAHandlerBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSSysSAHandlerBase.resetPSSystemName();
                return true;
            }
            case 22: {
                pSSysSAHandlerBase.resetSAType();
                return true;
            }
            case 23: {
                pSSysSAHandlerBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysSAHandlerBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysSAHandlerBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysSAHandlerBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysSAHandlerBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysSAHandlerBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysSAHandlerBase.resetUserTag4();
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
    public PSSFSAHandler getPSSFSAHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFSAHandler();
        }
        if (this.getPSSFSAHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSSFSAHandlerLock;
        synchronized (n) {
            if (this.pssfsahandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFSAHandlerId(), (Object)this.pssfsahandler.getPSSFSAHandlerId()) != 0L) {
                this.pssfsahandler = null;
            }
            if (this.pssfsahandler == null) {
                PSSFSAHandler pSSFSAHandler = new PSSFSAHandler();
                pSSFSAHandler.setPSSFSAHandlerId(this.getPSSFSAHandlerId());
                PSSFSAHandlerService pSSFSAHandlerService = (PSSFSAHandlerService)ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSFSAHandlerService.autoGet((IEntity)pSSFSAHandler);
                this.pssfsahandler = pSSFSAHandler;
            }
            return this.pssfsahandler;
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

    private PSSysSAHandlerBase getProxyEntity() {
        return this.proxyPSSysSAHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSAHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSAHandlerBase) {
            this.proxyPSSysSAHandlerBase = (PSSysSAHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLIENTHANDLEROBJ, 0);
        fieldIndexMap.put(FIELD_CLIENTHANDLEROBJ2, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 5);
        fieldIndexMap.put(FIELD_HANDLEROBJ, 6);
        fieldIndexMap.put(FIELD_HANDLEROBJ2, 7);
        fieldIndexMap.put(FIELD_HANDLERPARAMS, 8);
        fieldIndexMap.put(FIELD_LOCKFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 11);
        fieldIndexMap.put(FIELD_PSMODULEID, 12);
        fieldIndexMap.put(FIELD_PSMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSSFSAHANDLERID, 14);
        fieldIndexMap.put(FIELD_PSSFSAHANDLERNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERID, 18);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 21);
        fieldIndexMap.put(FIELD_SATYPE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
    }
}

