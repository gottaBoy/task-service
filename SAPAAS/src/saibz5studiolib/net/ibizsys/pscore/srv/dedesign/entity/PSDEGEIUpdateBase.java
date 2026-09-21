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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGEIUpdateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String FIELD_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
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
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELSTATE = 7;
    private static final int INDEX_PSACHANDLERID = 8;
    private static final int INDEX_PSACHANDLERNAME = 9;
    private static final int INDEX_PSDEACTIONID = 10;
    private static final int INDEX_PSDEACTIONNAME = 11;
    private static final int INDEX_PSDEGEIUPDATEID = 12;
    private static final int INDEX_PSDEGEIUPDATENAME = 13;
    private static final int INDEX_PSDEGRIDID = 14;
    private static final int INDEX_PSDEGRIDNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGEIUpdateBase proxyPSDEGEIUpdateBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdegeiupdateidDirtyFlag = false;
    private boolean psdegeiupdatenameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
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
    @Column(name="psdegeiupdateid")
    private String psdegeiupdateid;
    @Column(name="psdegeiupdatename")
    private String psdegeiupdatename;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
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
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSDEGEIDetailsLock = new Integer(1);
    private ArrayList<PSDEGEIUDetail> psdegeidetails = null;

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

    public void setPSDEGEIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdateid = string;
        this.psdegeiupdateidDirtyFlag = true;
    }

    public String getPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateId();
        }
        return this.psdegeiupdateid;
    }

    public boolean isPSDEGEIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateIdDirty();
        }
        return this.psdegeiupdateidDirtyFlag;
    }

    public void resetPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateId();
            return;
        }
        this.psdegeiupdateidDirtyFlag = false;
        this.psdegeiupdateid = null;
    }

    public void setPSDEGEIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdatename = string;
        this.psdegeiupdatenameDirtyFlag = true;
    }

    public String getPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateName();
        }
        return this.psdegeiupdatename;
    }

    public boolean isPSDEGEIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateNameDirty();
        }
        return this.psdegeiupdatenameDirtyFlag;
    }

    public void resetPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateName();
            return;
        }
        this.psdegeiupdatenameDirtyFlag = false;
        this.psdegeiupdatename = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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
        PSDEGEIUpdateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGEIUpdateBase pSDEGEIUpdateBase) {
        pSDEGEIUpdateBase.resetBusyIndicator();
        pSDEGEIUpdateBase.resetCodeName();
        pSDEGEIUpdateBase.resetCreateDate();
        pSDEGEIUpdateBase.resetCreateMan();
        pSDEGEIUpdateBase.resetCustomCode();
        pSDEGEIUpdateBase.resetCustomMode();
        pSDEGEIUpdateBase.resetMemo();
        pSDEGEIUpdateBase.resetModelState();
        pSDEGEIUpdateBase.resetPSACHandlerId();
        pSDEGEIUpdateBase.resetPSACHandlerName();
        pSDEGEIUpdateBase.resetPSDEActionId();
        pSDEGEIUpdateBase.resetPSDEActionName();
        pSDEGEIUpdateBase.resetPSDEGEIUpdateId();
        pSDEGEIUpdateBase.resetPSDEGEIUpdateName();
        pSDEGEIUpdateBase.resetPSDEGridId();
        pSDEGEIUpdateBase.resetPSDEGridName();
        pSDEGEIUpdateBase.resetUpdateDate();
        pSDEGEIUpdateBase.resetUpdateMan();
        pSDEGEIUpdateBase.resetUserTag();
        pSDEGEIUpdateBase.resetUserTag2();
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
        if (!bl || this.isPSDEGEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATEID, this.getPSDEGEIUpdateId());
        }
        if (!bl || this.isPSDEGEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATENAME, this.getPSDEGEIUpdateName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
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
        return PSDEGEIUpdateBase.get(this, n);
    }

    private static Object get(PSDEGEIUpdateBase pSDEGEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUpdateBase.getBusyIndicator();
            }
            case 1: {
                return pSDEGEIUpdateBase.getCodeName();
            }
            case 2: {
                return pSDEGEIUpdateBase.getCreateDate();
            }
            case 3: {
                return pSDEGEIUpdateBase.getCreateMan();
            }
            case 4: {
                return pSDEGEIUpdateBase.getCustomCode();
            }
            case 5: {
                return pSDEGEIUpdateBase.getCustomMode();
            }
            case 6: {
                return pSDEGEIUpdateBase.getMemo();
            }
            case 7: {
                return pSDEGEIUpdateBase.getModelState();
            }
            case 8: {
                return pSDEGEIUpdateBase.getPSACHandlerId();
            }
            case 9: {
                return pSDEGEIUpdateBase.getPSACHandlerName();
            }
            case 10: {
                return pSDEGEIUpdateBase.getPSDEActionId();
            }
            case 11: {
                return pSDEGEIUpdateBase.getPSDEActionName();
            }
            case 12: {
                return pSDEGEIUpdateBase.getPSDEGEIUpdateId();
            }
            case 13: {
                return pSDEGEIUpdateBase.getPSDEGEIUpdateName();
            }
            case 14: {
                return pSDEGEIUpdateBase.getPSDEGridId();
            }
            case 15: {
                return pSDEGEIUpdateBase.getPSDEGridName();
            }
            case 16: {
                return pSDEGEIUpdateBase.getUpdateDate();
            }
            case 17: {
                return pSDEGEIUpdateBase.getUpdateMan();
            }
            case 18: {
                return pSDEGEIUpdateBase.getUserTag();
            }
            case 19: {
                return pSDEGEIUpdateBase.getUserTag2();
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
        PSDEGEIUpdateBase.set(this, n, object);
    }

    private static void set(PSDEGEIUpdateBase pSDEGEIUpdateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIUpdateBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEGEIUpdateBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGEIUpdateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEGEIUpdateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGEIUpdateBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGEIUpdateBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEGEIUpdateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGEIUpdateBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEGEIUpdateBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGEIUpdateBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGEIUpdateBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGEIUpdateBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEGEIUpdateBase.setPSDEGEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGEIUpdateBase.setPSDEGEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEGEIUpdateBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGEIUpdateBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGEIUpdateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEGEIUpdateBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGEIUpdateBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGEIUpdateBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEGEIUpdateBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGEIUpdateBase pSDEGEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUpdateBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSDEGEIUpdateBase.getCodeName() == null;
            }
            case 2: {
                return pSDEGEIUpdateBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEGEIUpdateBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEGEIUpdateBase.getCustomCode() == null;
            }
            case 5: {
                return pSDEGEIUpdateBase.getCustomMode() == null;
            }
            case 6: {
                return pSDEGEIUpdateBase.getMemo() == null;
            }
            case 7: {
                return pSDEGEIUpdateBase.getModelState() == null;
            }
            case 8: {
                return pSDEGEIUpdateBase.getPSACHandlerId() == null;
            }
            case 9: {
                return pSDEGEIUpdateBase.getPSACHandlerName() == null;
            }
            case 10: {
                return pSDEGEIUpdateBase.getPSDEActionId() == null;
            }
            case 11: {
                return pSDEGEIUpdateBase.getPSDEActionName() == null;
            }
            case 12: {
                return pSDEGEIUpdateBase.getPSDEGEIUpdateId() == null;
            }
            case 13: {
                return pSDEGEIUpdateBase.getPSDEGEIUpdateName() == null;
            }
            case 14: {
                return pSDEGEIUpdateBase.getPSDEGridId() == null;
            }
            case 15: {
                return pSDEGEIUpdateBase.getPSDEGridName() == null;
            }
            case 16: {
                return pSDEGEIUpdateBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDEGEIUpdateBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDEGEIUpdateBase.getUserTag() == null;
            }
            case 19: {
                return pSDEGEIUpdateBase.getUserTag2() == null;
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
        return PSDEGEIUpdateBase.contains(this, n);
    }

    private static boolean contains(PSDEGEIUpdateBase pSDEGEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUpdateBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSDEGEIUpdateBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEGEIUpdateBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEGEIUpdateBase.isCreateManDirty();
            }
            case 4: {
                return pSDEGEIUpdateBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDEGEIUpdateBase.isCustomModeDirty();
            }
            case 6: {
                return pSDEGEIUpdateBase.isMemoDirty();
            }
            case 7: {
                return pSDEGEIUpdateBase.isModelStateDirty();
            }
            case 8: {
                return pSDEGEIUpdateBase.isPSACHandlerIdDirty();
            }
            case 9: {
                return pSDEGEIUpdateBase.isPSACHandlerNameDirty();
            }
            case 10: {
                return pSDEGEIUpdateBase.isPSDEActionIdDirty();
            }
            case 11: {
                return pSDEGEIUpdateBase.isPSDEActionNameDirty();
            }
            case 12: {
                return pSDEGEIUpdateBase.isPSDEGEIUpdateIdDirty();
            }
            case 13: {
                return pSDEGEIUpdateBase.isPSDEGEIUpdateNameDirty();
            }
            case 14: {
                return pSDEGEIUpdateBase.isPSDEGridIdDirty();
            }
            case 15: {
                return pSDEGEIUpdateBase.isPSDEGridNameDirty();
            }
            case 16: {
                return pSDEGEIUpdateBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDEGEIUpdateBase.isUpdateManDirty();
            }
            case 18: {
                return pSDEGEIUpdateBase.isUserTagDirty();
            }
            case 19: {
                return pSDEGEIUpdateBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGEIUpdateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGEIUpdateBase pSDEGEIUpdateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGEIUpdateBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdateid", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdatename", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEGEIUpdateName()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGEIUpdateBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGEIUpdateBase.getJSONValue((Object)pSDEGEIUpdateBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGEIUpdateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGEIUpdateBase pSDEGEIUpdateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGEIUpdateBase.getBusyIndicator() != null) {
            object = pSDEGEIUpdateBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIUpdateBase.getCodeName() != null) {
            object = pSDEGEIUpdateBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getCreateDate() != null) {
            object = pSDEGEIUpdateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIUpdateBase.getCreateMan() != null) {
            object = pSDEGEIUpdateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getCustomCode() != null) {
            object = pSDEGEIUpdateBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getCustomMode() != null) {
            object = pSDEGEIUpdateBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIUpdateBase.getMemo() != null) {
            object = pSDEGEIUpdateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getModelState() != null) {
            object = pSDEGEIUpdateBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIUpdateBase.getPSACHandlerId() != null) {
            object = pSDEGEIUpdateBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSACHandlerName() != null) {
            object = pSDEGEIUpdateBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEActionId() != null) {
            object = pSDEGEIUpdateBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEActionName() != null) {
            object = pSDEGEIUpdateBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateId() != null) {
            object = pSDEGEIUpdateBase.getPSDEGEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateName() != null) {
            object = pSDEGEIUpdateBase.getPSDEGEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGridId() != null) {
            object = pSDEGEIUpdateBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getPSDEGridName() != null) {
            object = pSDEGEIUpdateBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getUpdateDate() != null) {
            object = pSDEGEIUpdateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIUpdateBase.getUpdateMan() != null) {
            object = pSDEGEIUpdateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getUserTag() != null) {
            object = pSDEGEIUpdateBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUpdateBase.getUserTag2() != null) {
            object = pSDEGEIUpdateBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGEIUpdateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGEIUpdateBase pSDEGEIUpdateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGEIUpdateBase.isBusyIndicatorDirty() && (bl || pSDEGEIUpdateBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEGEIUpdateBase.getBusyIndicator());
        }
        if (pSDEGEIUpdateBase.isCodeNameDirty() && (bl || pSDEGEIUpdateBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEGEIUpdateBase.getCodeName());
        }
        if (pSDEGEIUpdateBase.isCreateDateDirty() && (bl || pSDEGEIUpdateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGEIUpdateBase.getCreateDate());
        }
        if (pSDEGEIUpdateBase.isCreateManDirty() && (bl || pSDEGEIUpdateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGEIUpdateBase.getCreateMan());
        }
        if (pSDEGEIUpdateBase.isCustomCodeDirty() && (bl || pSDEGEIUpdateBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEGEIUpdateBase.getCustomCode());
        }
        if (pSDEGEIUpdateBase.isCustomModeDirty() && (bl || pSDEGEIUpdateBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEGEIUpdateBase.getCustomMode());
        }
        if (pSDEGEIUpdateBase.isMemoDirty() && (bl || pSDEGEIUpdateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGEIUpdateBase.getMemo());
        }
        if (pSDEGEIUpdateBase.isModelStateDirty() && (bl || pSDEGEIUpdateBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEGEIUpdateBase.getModelState());
        }
        if (pSDEGEIUpdateBase.isPSACHandlerIdDirty() && (bl || pSDEGEIUpdateBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEGEIUpdateBase.getPSACHandlerId());
        }
        if (pSDEGEIUpdateBase.isPSACHandlerNameDirty() && (bl || pSDEGEIUpdateBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEGEIUpdateBase.getPSACHandlerName());
        }
        if (pSDEGEIUpdateBase.isPSDEActionIdDirty() && (bl || pSDEGEIUpdateBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEGEIUpdateBase.getPSDEActionId());
        }
        if (pSDEGEIUpdateBase.isPSDEActionNameDirty() && (bl || pSDEGEIUpdateBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEGEIUpdateBase.getPSDEActionName());
        }
        if (pSDEGEIUpdateBase.isPSDEGEIUpdateIdDirty() && (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATEID, (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId());
        }
        if (pSDEGEIUpdateBase.isPSDEGEIUpdateNameDirty() && (bl || pSDEGEIUpdateBase.getPSDEGEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATENAME, (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateName());
        }
        if (pSDEGEIUpdateBase.isPSDEGridIdDirty() && (bl || pSDEGEIUpdateBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGEIUpdateBase.getPSDEGridId());
        }
        if (pSDEGEIUpdateBase.isPSDEGridNameDirty() && (bl || pSDEGEIUpdateBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGEIUpdateBase.getPSDEGridName());
        }
        if (pSDEGEIUpdateBase.isUpdateDateDirty() && (bl || pSDEGEIUpdateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGEIUpdateBase.getUpdateDate());
        }
        if (pSDEGEIUpdateBase.isUpdateManDirty() && (bl || pSDEGEIUpdateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGEIUpdateBase.getUpdateMan());
        }
        if (pSDEGEIUpdateBase.isUserTagDirty() && (bl || pSDEGEIUpdateBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGEIUpdateBase.getUserTag());
        }
        if (pSDEGEIUpdateBase.isUserTag2Dirty() && (bl || pSDEGEIUpdateBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGEIUpdateBase.getUserTag2());
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
        return PSDEGEIUpdateBase.remove(this, n);
    }

    private static boolean remove(PSDEGEIUpdateBase pSDEGEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIUpdateBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSDEGEIUpdateBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEGEIUpdateBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEGEIUpdateBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEGEIUpdateBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDEGEIUpdateBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSDEGEIUpdateBase.resetMemo();
                return true;
            }
            case 7: {
                pSDEGEIUpdateBase.resetModelState();
                return true;
            }
            case 8: {
                pSDEGEIUpdateBase.resetPSACHandlerId();
                return true;
            }
            case 9: {
                pSDEGEIUpdateBase.resetPSACHandlerName();
                return true;
            }
            case 10: {
                pSDEGEIUpdateBase.resetPSDEActionId();
                return true;
            }
            case 11: {
                pSDEGEIUpdateBase.resetPSDEActionName();
                return true;
            }
            case 12: {
                pSDEGEIUpdateBase.resetPSDEGEIUpdateId();
                return true;
            }
            case 13: {
                pSDEGEIUpdateBase.resetPSDEGEIUpdateName();
                return true;
            }
            case 14: {
                pSDEGEIUpdateBase.resetPSDEGridId();
                return true;
            }
            case 15: {
                pSDEGEIUpdateBase.resetPSDEGridName();
                return true;
            }
            case 16: {
                pSDEGEIUpdateBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDEGEIUpdateBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDEGEIUpdateBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDEGEIUpdateBase.resetUserTag2();
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
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet((IEntity)pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGEIUDetail> getPSDEGEIDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIDetails();
        }
        if (this.getPSDEGEIUpdateId() == null) {
            return null;
        }
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGEIDetailsLock;
        synchronized (n) {
            if (this.psdegeidetails == null) {
                this.psdegeidetails = pSDEGEIUpdateService.isTempData((IEntity)this) ? pSDEGEIUDetailService.selectTempByPSDEGEIUpdate(this) : pSDEGEIUDetailService.selectByPSDEGEIUpdate(this);
            }
            return this.psdegeidetails;
        }
    }

    private PSDEGEIUpdateBase getProxyEntity() {
        return this.proxyPSDEGEIUpdateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGEIUpdateBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGEIUpdateBase) {
            this.proxyPSDEGEIUpdateBase = (PSDEGEIUpdateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELSTATE, 7);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 8);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 10);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 11);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATEID, 12);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATENAME, 13);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 14);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
    }
}

