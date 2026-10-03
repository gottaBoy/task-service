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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIUpdateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFIUpdateBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String FIELD_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_CUSTOMMODE = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MODELSTATE = 8;
    private static final int INDEX_PSACHANDLERID = 9;
    private static final int INDEX_PSACHANDLERNAME = 10;
    private static final int INDEX_PSDEACTIONID = 11;
    private static final int INDEX_PSDEACTIONNAME = 12;
    private static final int INDEX_PSDEFIUPDATEID = 13;
    private static final int INDEX_PSDEFIUPDATENAME = 14;
    private static final int INDEX_PSDEFORMID = 15;
    private static final int INDEX_PSDEFORMNAME = 16;
    private static final int INDEX_PSDEID = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFIUpdateBase proxyPSDEFIUpdateBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdefiupdateidDirtyFlag = false;
    private boolean psdefiupdatenameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
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
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdefiupdateid")
    private String psdefiupdateid;
    @Column(name="psdefiupdatename")
    private String psdefiupdatename;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEFIDetailsLock = new Integer(1);
    private ArrayList<PSDEFIUDetail> psdefidetails = null;

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
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

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
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

    public void setPSDEFIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdateid = string;
        this.psdefiupdateidDirtyFlag = true;
    }

    public String getPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateId();
        }
        return this.psdefiupdateid;
    }

    public boolean isPSDEFIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateIdDirty();
        }
        return this.psdefiupdateidDirtyFlag;
    }

    public void resetPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateId();
            return;
        }
        this.psdefiupdateidDirtyFlag = false;
        this.psdefiupdateid = null;
    }

    public void setPSDEFIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdatename = string;
        this.psdefiupdatenameDirtyFlag = true;
    }

    public String getPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateName();
        }
        return this.psdefiupdatename;
    }

    public boolean isPSDEFIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateNameDirty();
        }
        return this.psdefiupdatenameDirtyFlag;
    }

    public void resetPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateName();
            return;
        }
        this.psdefiupdatenameDirtyFlag = false;
        this.psdefiupdatename = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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

    protected void onReset() {
        PSDEFIUpdateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFIUpdateBase pSDEFIUpdateBase) {
        pSDEFIUpdateBase.resetBusyIndicator();
        pSDEFIUpdateBase.resetCodeName();
        pSDEFIUpdateBase.resetCreateDate();
        pSDEFIUpdateBase.resetCreateMan();
        pSDEFIUpdateBase.resetCustomCode();
        pSDEFIUpdateBase.resetCustomMode();
        pSDEFIUpdateBase.resetDynaModelFlag();
        pSDEFIUpdateBase.resetMemo();
        pSDEFIUpdateBase.resetModelState();
        pSDEFIUpdateBase.resetPSACHandlerId();
        pSDEFIUpdateBase.resetPSACHandlerName();
        pSDEFIUpdateBase.resetPSDEActionId();
        pSDEFIUpdateBase.resetPSDEActionName();
        pSDEFIUpdateBase.resetPSDEFIUpdateId();
        pSDEFIUpdateBase.resetPSDEFIUpdateName();
        pSDEFIUpdateBase.resetPSDEFormId();
        pSDEFIUpdateBase.resetPSDEFormName();
        pSDEFIUpdateBase.resetPSDEId();
        pSDEFIUpdateBase.resetPSDynaInstId();
        pSDEFIUpdateBase.resetUpdateDate();
        pSDEFIUpdateBase.resetUpdateMan();
        pSDEFIUpdateBase.resetUserTag();
        pSDEFIUpdateBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
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
        if (!bl || this.isPSDEFIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATEID, this.getPSDEFIUpdateId());
        }
        if (!bl || this.isPSDEFIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATENAME, this.getPSDEFIUpdateName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDEFIUpdateBase.get(this, n);
    }

    private static Object get(PSDEFIUpdateBase pSDEFIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUpdateBase.getBusyIndicator();
            }
            case 1: {
                return pSDEFIUpdateBase.getCodeName();
            }
            case 2: {
                return pSDEFIUpdateBase.getCreateDate();
            }
            case 3: {
                return pSDEFIUpdateBase.getCreateMan();
            }
            case 4: {
                return pSDEFIUpdateBase.getCustomCode();
            }
            case 5: {
                return pSDEFIUpdateBase.getCustomMode();
            }
            case 6: {
                return pSDEFIUpdateBase.getDynaModelFlag();
            }
            case 7: {
                return pSDEFIUpdateBase.getMemo();
            }
            case 8: {
                return pSDEFIUpdateBase.getModelState();
            }
            case 9: {
                return pSDEFIUpdateBase.getPSACHandlerId();
            }
            case 10: {
                return pSDEFIUpdateBase.getPSACHandlerName();
            }
            case 11: {
                return pSDEFIUpdateBase.getPSDEActionId();
            }
            case 12: {
                return pSDEFIUpdateBase.getPSDEActionName();
            }
            case 13: {
                return pSDEFIUpdateBase.getPSDEFIUpdateId();
            }
            case 14: {
                return pSDEFIUpdateBase.getPSDEFIUpdateName();
            }
            case 15: {
                return pSDEFIUpdateBase.getPSDEFormId();
            }
            case 16: {
                return pSDEFIUpdateBase.getPSDEFormName();
            }
            case 17: {
                return pSDEFIUpdateBase.getPSDEId();
            }
            case 18: {
                return pSDEFIUpdateBase.getPSDynaInstId();
            }
            case 19: {
                return pSDEFIUpdateBase.getUpdateDate();
            }
            case 20: {
                return pSDEFIUpdateBase.getUpdateMan();
            }
            case 21: {
                return pSDEFIUpdateBase.getUserTag();
            }
            case 22: {
                return pSDEFIUpdateBase.getUserTag2();
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
        PSDEFIUpdateBase.set(this, n, object);
    }

    private static void set(PSDEFIUpdateBase pSDEFIUpdateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIUpdateBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFIUpdateBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFIUpdateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEFIUpdateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFIUpdateBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFIUpdateBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFIUpdateBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFIUpdateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFIUpdateBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFIUpdateBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFIUpdateBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFIUpdateBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFIUpdateBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFIUpdateBase.setPSDEFIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFIUpdateBase.setPSDEFIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFIUpdateBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFIUpdateBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFIUpdateBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFIUpdateBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFIUpdateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDEFIUpdateBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFIUpdateBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFIUpdateBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEFIUpdateBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFIUpdateBase pSDEFIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUpdateBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSDEFIUpdateBase.getCodeName() == null;
            }
            case 2: {
                return pSDEFIUpdateBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEFIUpdateBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEFIUpdateBase.getCustomCode() == null;
            }
            case 5: {
                return pSDEFIUpdateBase.getCustomMode() == null;
            }
            case 6: {
                return pSDEFIUpdateBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSDEFIUpdateBase.getMemo() == null;
            }
            case 8: {
                return pSDEFIUpdateBase.getModelState() == null;
            }
            case 9: {
                return pSDEFIUpdateBase.getPSACHandlerId() == null;
            }
            case 10: {
                return pSDEFIUpdateBase.getPSACHandlerName() == null;
            }
            case 11: {
                return pSDEFIUpdateBase.getPSDEActionId() == null;
            }
            case 12: {
                return pSDEFIUpdateBase.getPSDEActionName() == null;
            }
            case 13: {
                return pSDEFIUpdateBase.getPSDEFIUpdateId() == null;
            }
            case 14: {
                return pSDEFIUpdateBase.getPSDEFIUpdateName() == null;
            }
            case 15: {
                return pSDEFIUpdateBase.getPSDEFormId() == null;
            }
            case 16: {
                return pSDEFIUpdateBase.getPSDEFormName() == null;
            }
            case 17: {
                return pSDEFIUpdateBase.getPSDEId() == null;
            }
            case 18: {
                return pSDEFIUpdateBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSDEFIUpdateBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDEFIUpdateBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDEFIUpdateBase.getUserTag() == null;
            }
            case 22: {
                return pSDEFIUpdateBase.getUserTag2() == null;
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
        return PSDEFIUpdateBase.contains(this, n);
    }

    private static boolean contains(PSDEFIUpdateBase pSDEFIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUpdateBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSDEFIUpdateBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEFIUpdateBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEFIUpdateBase.isCreateManDirty();
            }
            case 4: {
                return pSDEFIUpdateBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDEFIUpdateBase.isCustomModeDirty();
            }
            case 6: {
                return pSDEFIUpdateBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSDEFIUpdateBase.isMemoDirty();
            }
            case 8: {
                return pSDEFIUpdateBase.isModelStateDirty();
            }
            case 9: {
                return pSDEFIUpdateBase.isPSACHandlerIdDirty();
            }
            case 10: {
                return pSDEFIUpdateBase.isPSACHandlerNameDirty();
            }
            case 11: {
                return pSDEFIUpdateBase.isPSDEActionIdDirty();
            }
            case 12: {
                return pSDEFIUpdateBase.isPSDEActionNameDirty();
            }
            case 13: {
                return pSDEFIUpdateBase.isPSDEFIUpdateIdDirty();
            }
            case 14: {
                return pSDEFIUpdateBase.isPSDEFIUpdateNameDirty();
            }
            case 15: {
                return pSDEFIUpdateBase.isPSDEFormIdDirty();
            }
            case 16: {
                return pSDEFIUpdateBase.isPSDEFormNameDirty();
            }
            case 17: {
                return pSDEFIUpdateBase.isPSDEIdDirty();
            }
            case 18: {
                return pSDEFIUpdateBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSDEFIUpdateBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDEFIUpdateBase.isUpdateManDirty();
            }
            case 21: {
                return pSDEFIUpdateBase.isUserTagDirty();
            }
            case 22: {
                return pSDEFIUpdateBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFIUpdateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFIUpdateBase pSDEFIUpdateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFIUpdateBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdateid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEFIUpdateId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdatename", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEFIUpdateName()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFIUpdateBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFIUpdateBase.getJSONValue((Object)pSDEFIUpdateBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFIUpdateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFIUpdateBase pSDEFIUpdateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFIUpdateBase.getBusyIndicator() != null) {
            object = pSDEFIUpdateBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getCodeName() != null) {
            object = pSDEFIUpdateBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getCreateDate() != null) {
            object = pSDEFIUpdateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getCreateMan() != null) {
            object = pSDEFIUpdateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getCustomCode() != null) {
            object = pSDEFIUpdateBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getCustomMode() != null) {
            object = pSDEFIUpdateBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getDynaModelFlag() != null) {
            object = pSDEFIUpdateBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getMemo() != null) {
            object = pSDEFIUpdateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getModelState() != null) {
            object = pSDEFIUpdateBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getPSACHandlerId() != null) {
            object = pSDEFIUpdateBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSACHandlerName() != null) {
            object = pSDEFIUpdateBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEActionId() != null) {
            object = pSDEFIUpdateBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEActionName() != null) {
            object = pSDEFIUpdateBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFIUpdateId() != null) {
            object = pSDEFIUpdateBase.getPSDEFIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFIUpdateName() != null) {
            object = pSDEFIUpdateBase.getPSDEFIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFormId() != null) {
            object = pSDEFIUpdateBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEFormName() != null) {
            object = pSDEFIUpdateBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDEId() != null) {
            object = pSDEFIUpdateBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getPSDynaInstId() != null) {
            object = pSDEFIUpdateBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getUpdateDate() != null) {
            object = pSDEFIUpdateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIUpdateBase.getUpdateMan() != null) {
            object = pSDEFIUpdateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getUserTag() != null) {
            object = pSDEFIUpdateBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUpdateBase.getUserTag2() != null) {
            object = pSDEFIUpdateBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFIUpdateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFIUpdateBase pSDEFIUpdateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFIUpdateBase.isBusyIndicatorDirty() && (bl || pSDEFIUpdateBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEFIUpdateBase.getBusyIndicator());
        }
        if (pSDEFIUpdateBase.isCodeNameDirty() && (bl || pSDEFIUpdateBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFIUpdateBase.getCodeName());
        }
        if (pSDEFIUpdateBase.isCreateDateDirty() && (bl || pSDEFIUpdateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFIUpdateBase.getCreateDate());
        }
        if (pSDEFIUpdateBase.isCreateManDirty() && (bl || pSDEFIUpdateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFIUpdateBase.getCreateMan());
        }
        if (pSDEFIUpdateBase.isCustomCodeDirty() && (bl || pSDEFIUpdateBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFIUpdateBase.getCustomCode());
        }
        if (pSDEFIUpdateBase.isCustomModeDirty() && (bl || pSDEFIUpdateBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEFIUpdateBase.getCustomMode());
        }
        if (pSDEFIUpdateBase.isDynaModelFlagDirty() && (bl || pSDEFIUpdateBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFIUpdateBase.getDynaModelFlag());
        }
        if (pSDEFIUpdateBase.isMemoDirty() && (bl || pSDEFIUpdateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFIUpdateBase.getMemo());
        }
        if (pSDEFIUpdateBase.isModelStateDirty() && (bl || pSDEFIUpdateBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEFIUpdateBase.getModelState());
        }
        if (pSDEFIUpdateBase.isPSACHandlerIdDirty() && (bl || pSDEFIUpdateBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEFIUpdateBase.getPSACHandlerId());
        }
        if (pSDEFIUpdateBase.isPSACHandlerNameDirty() && (bl || pSDEFIUpdateBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEFIUpdateBase.getPSACHandlerName());
        }
        if (pSDEFIUpdateBase.isPSDEActionIdDirty() && (bl || pSDEFIUpdateBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEFIUpdateBase.getPSDEActionId());
        }
        if (pSDEFIUpdateBase.isPSDEActionNameDirty() && (bl || pSDEFIUpdateBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEFIUpdateBase.getPSDEActionName());
        }
        if (pSDEFIUpdateBase.isPSDEFIUpdateIdDirty() && (bl || pSDEFIUpdateBase.getPSDEFIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATEID, (Object)pSDEFIUpdateBase.getPSDEFIUpdateId());
        }
        if (pSDEFIUpdateBase.isPSDEFIUpdateNameDirty() && (bl || pSDEFIUpdateBase.getPSDEFIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATENAME, (Object)pSDEFIUpdateBase.getPSDEFIUpdateName());
        }
        if (pSDEFIUpdateBase.isPSDEFormIdDirty() && (bl || pSDEFIUpdateBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFIUpdateBase.getPSDEFormId());
        }
        if (pSDEFIUpdateBase.isPSDEFormNameDirty() && (bl || pSDEFIUpdateBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFIUpdateBase.getPSDEFormName());
        }
        if (pSDEFIUpdateBase.isPSDEIdDirty() && (bl || pSDEFIUpdateBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFIUpdateBase.getPSDEId());
        }
        if (pSDEFIUpdateBase.isPSDynaInstIdDirty() && (bl || pSDEFIUpdateBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFIUpdateBase.getPSDynaInstId());
        }
        if (pSDEFIUpdateBase.isUpdateDateDirty() && (bl || pSDEFIUpdateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFIUpdateBase.getUpdateDate());
        }
        if (pSDEFIUpdateBase.isUpdateManDirty() && (bl || pSDEFIUpdateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFIUpdateBase.getUpdateMan());
        }
        if (pSDEFIUpdateBase.isUserTagDirty() && (bl || pSDEFIUpdateBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFIUpdateBase.getUserTag());
        }
        if (pSDEFIUpdateBase.isUserTag2Dirty() && (bl || pSDEFIUpdateBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFIUpdateBase.getUserTag2());
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
        return PSDEFIUpdateBase.remove(this, n);
    }

    private static boolean remove(PSDEFIUpdateBase pSDEFIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIUpdateBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSDEFIUpdateBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEFIUpdateBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEFIUpdateBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEFIUpdateBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDEFIUpdateBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSDEFIUpdateBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSDEFIUpdateBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEFIUpdateBase.resetModelState();
                return true;
            }
            case 9: {
                pSDEFIUpdateBase.resetPSACHandlerId();
                return true;
            }
            case 10: {
                pSDEFIUpdateBase.resetPSACHandlerName();
                return true;
            }
            case 11: {
                pSDEFIUpdateBase.resetPSDEActionId();
                return true;
            }
            case 12: {
                pSDEFIUpdateBase.resetPSDEActionName();
                return true;
            }
            case 13: {
                pSDEFIUpdateBase.resetPSDEFIUpdateId();
                return true;
            }
            case 14: {
                pSDEFIUpdateBase.resetPSDEFIUpdateName();
                return true;
            }
            case 15: {
                pSDEFIUpdateBase.resetPSDEFormId();
                return true;
            }
            case 16: {
                pSDEFIUpdateBase.resetPSDEFormName();
                return true;
            }
            case 17: {
                pSDEFIUpdateBase.resetPSDEId();
                return true;
            }
            case 18: {
                pSDEFIUpdateBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSDEFIUpdateBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDEFIUpdateBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDEFIUpdateBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDEFIUpdateBase.resetUserTag2();
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
                pSACHandlerService.autoGet(pSACHandler);
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
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFIUDetail> getPSDEFIDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIDetails();
        }
        if (this.getPSDEFIUpdateId() == null) {
            return null;
        }
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFIDetailsLock;
        synchronized (n) {
            if (this.psdefidetails == null) {
                this.psdefidetails = pSDEFIUpdateService.isTempData(this) ? pSDEFIUDetailService.selectTempByPSDEFIUpdate(this) : pSDEFIUDetailService.selectByPSDEFIUpdate(this);
            }
            return this.psdefidetails;
        }
    }

    private PSDEFIUpdateBase getProxyEntity() {
        return this.proxyPSDEFIUpdateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFIUpdateBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFIUpdateBase) {
            this.proxyPSDEFIUpdateBase = (PSDEFIUpdateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MODELSTATE, 8);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 9);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 11);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 12);
        fieldIndexMap.put(FIELD_PSDEFIUPDATEID, 13);
        fieldIndexMap.put(FIELD_PSDEFIUPDATENAME, 14);
        fieldIndexMap.put(FIELD_PSDEFORMID, 15);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 16);
        fieldIndexMap.put(FIELD_PSDEID, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
    }
}

