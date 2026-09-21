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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSACHandlerActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSACHandlerActionBase.class);
    public static final String FIELD_ACTIONDESC = "ACTIONDESC";
    public static final String FIELD_ACTIONTIMEOUT = "ACTIONTIMEOUT";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAACCACTION = "DATAACCACTION";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSACHANDLERACTIONID = "PSACHANDLERACTIONID";
    public static final String FIELD_PSACHANDLERACTIONNAME = "PSACHANDLERACTIONNAME";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONDESC = 0;
    private static final int INDEX_ACTIONTIMEOUT = 1;
    private static final int INDEX_ACTIONTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DATAACCACTION = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSACHANDLERACTIONID = 8;
    private static final int INDEX_PSACHANDLERACTIONNAME = 9;
    private static final int INDEX_PSACHANDLERID = 10;
    private static final int INDEX_PSACHANDLERNAME = 11;
    private static final int INDEX_PSDEACTIONID = 12;
    private static final int INDEX_PSDEACTIONNAME = 13;
    private static final int INDEX_PSDEOPPRIVID = 14;
    private static final int INDEX_PSDEOPPRIVNAME = 15;
    private static final int INDEX_PSDYNAINSTID = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSACHandlerActionBase proxyPSACHandlerActionBase = null;
    private boolean actiondescDirtyFlag = false;
    private boolean actiontimeoutDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataaccactionDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psachandleractionidDirtyFlag = false;
    private boolean psachandleractionnameDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actiondesc")
    private String actiondesc;
    @Column(name="actiontimeout")
    private Integer actiontimeout;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataaccaction")
    private String dataaccaction;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psachandleractionid")
    private String psachandleractionid;
    @Column(name="psachandleractionname")
    private String psachandleractionname;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;

    public void setActionDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiondesc = string;
        this.actiondescDirtyFlag = true;
    }

    public String getActionDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionDesc();
        }
        return this.actiondesc;
    }

    public boolean isActionDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionDescDirty();
        }
        return this.actiondescDirtyFlag;
    }

    public void resetActionDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionDesc();
            return;
        }
        this.actiondescDirtyFlag = false;
        this.actiondesc = null;
    }

    public void setActionTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTimeout(n);
            return;
        }
        this.actiontimeout = n;
        this.actiontimeoutDirtyFlag = true;
    }

    public Integer getActionTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTimeout();
        }
        return this.actiontimeout;
    }

    public boolean isActionTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTimeoutDirty();
        }
        return this.actiontimeoutDirtyFlag;
    }

    public void resetActionTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTimeout();
            return;
        }
        this.actiontimeoutDirtyFlag = false;
        this.actiontimeout = null;
    }

    public void setActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontype = string;
        this.actiontypeDirtyFlag = true;
    }

    public String getActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionType();
        }
        return this.actiontype;
    }

    public boolean isActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTypeDirty();
        }
        return this.actiontypeDirtyFlag;
    }

    public void resetActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionType();
            return;
        }
        this.actiontypeDirtyFlag = false;
        this.actiontype = null;
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

    public void setDataAccAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAccAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataaccaction = string;
        this.dataaccactionDirtyFlag = true;
    }

    public String getDataAccAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAccAction();
        }
        return this.dataaccaction;
    }

    public boolean isDataAccActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAccActionDirty();
        }
        return this.dataaccactionDirtyFlag;
    }

    public void resetDataAccAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAccAction();
            return;
        }
        this.dataaccactionDirtyFlag = false;
        this.dataaccaction = null;
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

    public void setPSACHandlerActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandleractionid = string;
        this.psachandleractionidDirtyFlag = true;
    }

    public String getPSACHandlerActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerActionId();
        }
        return this.psachandleractionid;
    }

    public boolean isPSACHandlerActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerActionIdDirty();
        }
        return this.psachandleractionidDirtyFlag;
    }

    public void resetPSACHandlerActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerActionId();
            return;
        }
        this.psachandleractionidDirtyFlag = false;
        this.psachandleractionid = null;
    }

    public void setPSACHandlerActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandleractionname = string;
        this.psachandleractionnameDirtyFlag = true;
    }

    public String getPSACHandlerActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerActionName();
        }
        return this.psachandleractionname;
    }

    public boolean isPSACHandlerActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerActionNameDirty();
        }
        return this.psachandleractionnameDirtyFlag;
    }

    public void resetPSACHandlerActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerActionName();
            return;
        }
        this.psachandleractionnameDirtyFlag = false;
        this.psachandleractionname = null;
    }

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
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
        PSACHandlerActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSACHandlerActionBase pSACHandlerActionBase) {
        pSACHandlerActionBase.resetActionDesc();
        pSACHandlerActionBase.resetActionTimeout();
        pSACHandlerActionBase.resetActionType();
        pSACHandlerActionBase.resetCreateDate();
        pSACHandlerActionBase.resetCreateMan();
        pSACHandlerActionBase.resetDataAccAction();
        pSACHandlerActionBase.resetDynaModelFlag();
        pSACHandlerActionBase.resetMemo();
        pSACHandlerActionBase.resetPSACHandlerActionId();
        pSACHandlerActionBase.resetPSACHandlerActionName();
        pSACHandlerActionBase.resetPSACHandlerId();
        pSACHandlerActionBase.resetPSACHandlerName();
        pSACHandlerActionBase.resetPSDEActionId();
        pSACHandlerActionBase.resetPSDEActionName();
        pSACHandlerActionBase.resetPSDEOPPrivId();
        pSACHandlerActionBase.resetPSDEOPPrivName();
        pSACHandlerActionBase.resetPSDynaInstId();
        pSACHandlerActionBase.resetUpdateDate();
        pSACHandlerActionBase.resetUpdateMan();
        pSACHandlerActionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionDescDirty()) {
            hashMap.put(FIELD_ACTIONDESC, this.getActionDesc());
        }
        if (!bl || this.isActionTimeoutDirty()) {
            hashMap.put(FIELD_ACTIONTIMEOUT, this.getActionTimeout());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataAccActionDirty()) {
            hashMap.put(FIELD_DATAACCACTION, this.getDataAccAction());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSACHandlerActionIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERACTIONID, this.getPSACHandlerActionId());
        }
        if (!bl || this.isPSACHandlerActionNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERACTIONNAME, this.getPSACHandlerActionName());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSACHandlerActionBase.get(this, n);
    }

    private static Object get(PSACHandlerActionBase pSACHandlerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerActionBase.getActionDesc();
            }
            case 1: {
                return pSACHandlerActionBase.getActionTimeout();
            }
            case 2: {
                return pSACHandlerActionBase.getActionType();
            }
            case 3: {
                return pSACHandlerActionBase.getCreateDate();
            }
            case 4: {
                return pSACHandlerActionBase.getCreateMan();
            }
            case 5: {
                return pSACHandlerActionBase.getDataAccAction();
            }
            case 6: {
                return pSACHandlerActionBase.getDynaModelFlag();
            }
            case 7: {
                return pSACHandlerActionBase.getMemo();
            }
            case 8: {
                return pSACHandlerActionBase.getPSACHandlerActionId();
            }
            case 9: {
                return pSACHandlerActionBase.getPSACHandlerActionName();
            }
            case 10: {
                return pSACHandlerActionBase.getPSACHandlerId();
            }
            case 11: {
                return pSACHandlerActionBase.getPSACHandlerName();
            }
            case 12: {
                return pSACHandlerActionBase.getPSDEActionId();
            }
            case 13: {
                return pSACHandlerActionBase.getPSDEActionName();
            }
            case 14: {
                return pSACHandlerActionBase.getPSDEOPPrivId();
            }
            case 15: {
                return pSACHandlerActionBase.getPSDEOPPrivName();
            }
            case 16: {
                return pSACHandlerActionBase.getPSDynaInstId();
            }
            case 17: {
                return pSACHandlerActionBase.getUpdateDate();
            }
            case 18: {
                return pSACHandlerActionBase.getUpdateMan();
            }
            case 19: {
                return pSACHandlerActionBase.getValidFlag();
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
        PSACHandlerActionBase.set(this, n, object);
    }

    private static void set(PSACHandlerActionBase pSACHandlerActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSACHandlerActionBase.setActionDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSACHandlerActionBase.setActionTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSACHandlerActionBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSACHandlerActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSACHandlerActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSACHandlerActionBase.setDataAccAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSACHandlerActionBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSACHandlerActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSACHandlerActionBase.setPSACHandlerActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSACHandlerActionBase.setPSACHandlerActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSACHandlerActionBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSACHandlerActionBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSACHandlerActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSACHandlerActionBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSACHandlerActionBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSACHandlerActionBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSACHandlerActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSACHandlerActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSACHandlerActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSACHandlerActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSACHandlerActionBase.isNull(this, n);
    }

    private static boolean isNull(PSACHandlerActionBase pSACHandlerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerActionBase.getActionDesc() == null;
            }
            case 1: {
                return pSACHandlerActionBase.getActionTimeout() == null;
            }
            case 2: {
                return pSACHandlerActionBase.getActionType() == null;
            }
            case 3: {
                return pSACHandlerActionBase.getCreateDate() == null;
            }
            case 4: {
                return pSACHandlerActionBase.getCreateMan() == null;
            }
            case 5: {
                return pSACHandlerActionBase.getDataAccAction() == null;
            }
            case 6: {
                return pSACHandlerActionBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSACHandlerActionBase.getMemo() == null;
            }
            case 8: {
                return pSACHandlerActionBase.getPSACHandlerActionId() == null;
            }
            case 9: {
                return pSACHandlerActionBase.getPSACHandlerActionName() == null;
            }
            case 10: {
                return pSACHandlerActionBase.getPSACHandlerId() == null;
            }
            case 11: {
                return pSACHandlerActionBase.getPSACHandlerName() == null;
            }
            case 12: {
                return pSACHandlerActionBase.getPSDEActionId() == null;
            }
            case 13: {
                return pSACHandlerActionBase.getPSDEActionName() == null;
            }
            case 14: {
                return pSACHandlerActionBase.getPSDEOPPrivId() == null;
            }
            case 15: {
                return pSACHandlerActionBase.getPSDEOPPrivName() == null;
            }
            case 16: {
                return pSACHandlerActionBase.getPSDynaInstId() == null;
            }
            case 17: {
                return pSACHandlerActionBase.getUpdateDate() == null;
            }
            case 18: {
                return pSACHandlerActionBase.getUpdateMan() == null;
            }
            case 19: {
                return pSACHandlerActionBase.getValidFlag() == null;
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
        return PSACHandlerActionBase.contains(this, n);
    }

    private static boolean contains(PSACHandlerActionBase pSACHandlerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerActionBase.isActionDescDirty();
            }
            case 1: {
                return pSACHandlerActionBase.isActionTimeoutDirty();
            }
            case 2: {
                return pSACHandlerActionBase.isActionTypeDirty();
            }
            case 3: {
                return pSACHandlerActionBase.isCreateDateDirty();
            }
            case 4: {
                return pSACHandlerActionBase.isCreateManDirty();
            }
            case 5: {
                return pSACHandlerActionBase.isDataAccActionDirty();
            }
            case 6: {
                return pSACHandlerActionBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSACHandlerActionBase.isMemoDirty();
            }
            case 8: {
                return pSACHandlerActionBase.isPSACHandlerActionIdDirty();
            }
            case 9: {
                return pSACHandlerActionBase.isPSACHandlerActionNameDirty();
            }
            case 10: {
                return pSACHandlerActionBase.isPSACHandlerIdDirty();
            }
            case 11: {
                return pSACHandlerActionBase.isPSACHandlerNameDirty();
            }
            case 12: {
                return pSACHandlerActionBase.isPSDEActionIdDirty();
            }
            case 13: {
                return pSACHandlerActionBase.isPSDEActionNameDirty();
            }
            case 14: {
                return pSACHandlerActionBase.isPSDEOPPrivIdDirty();
            }
            case 15: {
                return pSACHandlerActionBase.isPSDEOPPrivNameDirty();
            }
            case 16: {
                return pSACHandlerActionBase.isPSDynaInstIdDirty();
            }
            case 17: {
                return pSACHandlerActionBase.isUpdateDateDirty();
            }
            case 18: {
                return pSACHandlerActionBase.isUpdateManDirty();
            }
            case 19: {
                return pSACHandlerActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSACHandlerActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSACHandlerActionBase pSACHandlerActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSACHandlerActionBase.getActionDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiondesc", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getActionDesc()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getActionTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontimeout", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getActionTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getActionType()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getDataAccAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataaccaction", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getDataAccAction()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandleractionid", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSACHandlerActionId()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandleractionname", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSACHandlerActionName()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSACHandlerActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSACHandlerActionBase.getJSONValue((Object)pSACHandlerActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSACHandlerActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSACHandlerActionBase pSACHandlerActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSACHandlerActionBase.getActionDesc() != null) {
            object = pSACHandlerActionBase.getActionDesc();
            xmlNode.setAttribute(FIELD_ACTIONDESC, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getActionTimeout() != null) {
            object = pSACHandlerActionBase.getActionTimeout();
            xmlNode.setAttribute(FIELD_ACTIONTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerActionBase.getActionType() != null) {
            object = pSACHandlerActionBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getCreateDate() != null) {
            object = pSACHandlerActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSACHandlerActionBase.getCreateMan() != null) {
            object = pSACHandlerActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getDataAccAction() != null) {
            object = pSACHandlerActionBase.getDataAccAction();
            xmlNode.setAttribute(FIELD_DATAACCACTION, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getDynaModelFlag() != null) {
            object = pSACHandlerActionBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerActionBase.getMemo() != null) {
            object = pSACHandlerActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerActionId() != null) {
            object = pSACHandlerActionBase.getPSACHandlerActionId();
            xmlNode.setAttribute(FIELD_PSACHANDLERACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerActionName() != null) {
            object = pSACHandlerActionBase.getPSACHandlerActionName();
            xmlNode.setAttribute(FIELD_PSACHANDLERACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerId() != null) {
            object = pSACHandlerActionBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSACHandlerName() != null) {
            object = pSACHandlerActionBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSDEActionId() != null) {
            object = pSACHandlerActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSDEActionName() != null) {
            object = pSACHandlerActionBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSDEOPPrivId() != null) {
            object = pSACHandlerActionBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSDEOPPrivName() != null) {
            object = pSACHandlerActionBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getPSDynaInstId() != null) {
            object = pSACHandlerActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getUpdateDate() != null) {
            object = pSACHandlerActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSACHandlerActionBase.getUpdateMan() != null) {
            object = pSACHandlerActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerActionBase.getValidFlag() != null) {
            object = pSACHandlerActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSACHandlerActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSACHandlerActionBase pSACHandlerActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSACHandlerActionBase.isActionDescDirty() && (bl || pSACHandlerActionBase.getActionDesc() != null)) {
            iDataObject.set(FIELD_ACTIONDESC, (Object)pSACHandlerActionBase.getActionDesc());
        }
        if (pSACHandlerActionBase.isActionTimeoutDirty() && (bl || pSACHandlerActionBase.getActionTimeout() != null)) {
            iDataObject.set(FIELD_ACTIONTIMEOUT, (Object)pSACHandlerActionBase.getActionTimeout());
        }
        if (pSACHandlerActionBase.isActionTypeDirty() && (bl || pSACHandlerActionBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSACHandlerActionBase.getActionType());
        }
        if (pSACHandlerActionBase.isCreateDateDirty() && (bl || pSACHandlerActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSACHandlerActionBase.getCreateDate());
        }
        if (pSACHandlerActionBase.isCreateManDirty() && (bl || pSACHandlerActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSACHandlerActionBase.getCreateMan());
        }
        if (pSACHandlerActionBase.isDataAccActionDirty() && (bl || pSACHandlerActionBase.getDataAccAction() != null)) {
            iDataObject.set(FIELD_DATAACCACTION, (Object)pSACHandlerActionBase.getDataAccAction());
        }
        if (pSACHandlerActionBase.isDynaModelFlagDirty() && (bl || pSACHandlerActionBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSACHandlerActionBase.getDynaModelFlag());
        }
        if (pSACHandlerActionBase.isMemoDirty() && (bl || pSACHandlerActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSACHandlerActionBase.getMemo());
        }
        if (pSACHandlerActionBase.isPSACHandlerActionIdDirty() && (bl || pSACHandlerActionBase.getPSACHandlerActionId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERACTIONID, (Object)pSACHandlerActionBase.getPSACHandlerActionId());
        }
        if (pSACHandlerActionBase.isPSACHandlerActionNameDirty() && (bl || pSACHandlerActionBase.getPSACHandlerActionName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERACTIONNAME, (Object)pSACHandlerActionBase.getPSACHandlerActionName());
        }
        if (pSACHandlerActionBase.isPSACHandlerIdDirty() && (bl || pSACHandlerActionBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSACHandlerActionBase.getPSACHandlerId());
        }
        if (pSACHandlerActionBase.isPSACHandlerNameDirty() && (bl || pSACHandlerActionBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSACHandlerActionBase.getPSACHandlerName());
        }
        if (pSACHandlerActionBase.isPSDEActionIdDirty() && (bl || pSACHandlerActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSACHandlerActionBase.getPSDEActionId());
        }
        if (pSACHandlerActionBase.isPSDEActionNameDirty() && (bl || pSACHandlerActionBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSACHandlerActionBase.getPSDEActionName());
        }
        if (pSACHandlerActionBase.isPSDEOPPrivIdDirty() && (bl || pSACHandlerActionBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSACHandlerActionBase.getPSDEOPPrivId());
        }
        if (pSACHandlerActionBase.isPSDEOPPrivNameDirty() && (bl || pSACHandlerActionBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSACHandlerActionBase.getPSDEOPPrivName());
        }
        if (pSACHandlerActionBase.isPSDynaInstIdDirty() && (bl || pSACHandlerActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSACHandlerActionBase.getPSDynaInstId());
        }
        if (pSACHandlerActionBase.isUpdateDateDirty() && (bl || pSACHandlerActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSACHandlerActionBase.getUpdateDate());
        }
        if (pSACHandlerActionBase.isUpdateManDirty() && (bl || pSACHandlerActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSACHandlerActionBase.getUpdateMan());
        }
        if (pSACHandlerActionBase.isValidFlagDirty() && (bl || pSACHandlerActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSACHandlerActionBase.getValidFlag());
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
        return PSACHandlerActionBase.remove(this, n);
    }

    private static boolean remove(PSACHandlerActionBase pSACHandlerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSACHandlerActionBase.resetActionDesc();
                return true;
            }
            case 1: {
                pSACHandlerActionBase.resetActionTimeout();
                return true;
            }
            case 2: {
                pSACHandlerActionBase.resetActionType();
                return true;
            }
            case 3: {
                pSACHandlerActionBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSACHandlerActionBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSACHandlerActionBase.resetDataAccAction();
                return true;
            }
            case 6: {
                pSACHandlerActionBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSACHandlerActionBase.resetMemo();
                return true;
            }
            case 8: {
                pSACHandlerActionBase.resetPSACHandlerActionId();
                return true;
            }
            case 9: {
                pSACHandlerActionBase.resetPSACHandlerActionName();
                return true;
            }
            case 10: {
                pSACHandlerActionBase.resetPSACHandlerId();
                return true;
            }
            case 11: {
                pSACHandlerActionBase.resetPSACHandlerName();
                return true;
            }
            case 12: {
                pSACHandlerActionBase.resetPSDEActionId();
                return true;
            }
            case 13: {
                pSACHandlerActionBase.resetPSDEActionName();
                return true;
            }
            case 14: {
                pSACHandlerActionBase.resetPSDEOPPrivId();
                return true;
            }
            case 15: {
                pSACHandlerActionBase.resetPSDEOPPrivName();
                return true;
            }
            case 16: {
                pSACHandlerActionBase.resetPSDynaInstId();
                return true;
            }
            case 17: {
                pSACHandlerActionBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSACHandlerActionBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSACHandlerActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandler();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSACHandlerLock;
        synchronized (n) {
            if (this.psachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSACHandlerId(), (Object)this.psachandler.getPSACHandlerId()) != 0L) {
                this.psachandler = null;
            }
            if (this.psachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
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
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    private PSACHandlerActionBase getProxyEntity() {
        return this.proxyPSACHandlerActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSACHandlerActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSACHandlerActionBase) {
            this.proxyPSACHandlerActionBase = (PSACHandlerActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONDESC, 0);
        fieldIndexMap.put(FIELD_ACTIONTIMEOUT, 1);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DATAACCACTION, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSACHANDLERACTIONID, 8);
        fieldIndexMap.put(FIELD_PSACHANDLERACTIONNAME, 9);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 10);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 11);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 12);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 13);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 14);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 15);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

