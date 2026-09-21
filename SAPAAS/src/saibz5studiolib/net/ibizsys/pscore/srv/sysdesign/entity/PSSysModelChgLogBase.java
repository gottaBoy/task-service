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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelChgLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelChgLogBase.class);
    public static final String FIELD_CHGTYPE = "CHGTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURDATA = "CURDATA";
    public static final String FIELD_LASTDATA = "LASTDATA";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJTYPE = "OBJTYPE";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERNAME = "OWNERNAME";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTAG = "PSOBJTAG";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSMODELCHGLOGID = "PSSYSDBCHGLOGID";
    public static final String FIELD_PSSYSMODELCHGLOGNAME = "PSSYSDBCHGLOGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PUBLISHFLAG = "PUBLISHFLAG";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CHGTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CURDATA = 3;
    private static final int INDEX_LASTDATA = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_OBJTYPE = 6;
    private static final int INDEX_OWNERID = 7;
    private static final int INDEX_OWNERNAME = 8;
    private static final int INDEX_OWNERTYPE = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_PSOBJID = 12;
    private static final int INDEX_PSOBJNAME = 13;
    private static final int INDEX_PSOBJTAG = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_PSSYSMODELCHGLOGID = 17;
    private static final int INDEX_PSSYSMODELCHGLOGNAME = 18;
    private static final int INDEX_PSSYSTEMID = 19;
    private static final int INDEX_PSSYSTEMNAME = 20;
    private static final int INDEX_PUBLISHFLAG = 21;
    private static final int INDEX_REMOTEADDR = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_VERSION = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelChgLogBase proxyPSSysModelChgLogBase = null;
    private boolean chgtypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curdataDirtyFlag = false;
    private boolean lastdataDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objtypeDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownernameDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtagDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysmodelchglogidDirtyFlag = false;
    private boolean pssysmodelchglognameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean publishflagDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="chgtype")
    private String chgtype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curdata")
    private String curdata;
    @Column(name="lastdata")
    private String lastdata;
    @Column(name="memo")
    private String memo;
    @Column(name="objtype")
    private String objtype;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownername")
    private String ownername;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtag")
    private String psobjtag;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysmodelchglogid")
    private String pssysmodelchglogid;
    @Column(name="pssysmodelchglogname")
    private String pssysmodelchglogname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="publishflag")
    private Integer publishflag;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="version")
    private Integer version;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCHGType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCHGType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.chgtype = string;
        this.chgtypeDirtyFlag = true;
    }

    public String getCHGType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCHGType();
        }
        return this.chgtype;
    }

    public boolean isCHGTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCHGTypeDirty();
        }
        return this.chgtypeDirtyFlag;
    }

    public void resetCHGType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCHGType();
            return;
        }
        this.chgtypeDirtyFlag = false;
        this.chgtype = null;
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

    public void setCurData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curdata = string;
        this.curdataDirtyFlag = true;
    }

    public String getCurData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurData();
        }
        return this.curdata;
    }

    public boolean isCurDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurDataDirty();
        }
        return this.curdataDirtyFlag;
    }

    public void resetCurData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurData();
            return;
        }
        this.curdataDirtyFlag = false;
        this.curdata = null;
    }

    public void setLastData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lastdata = string;
        this.lastdataDirtyFlag = true;
    }

    public String getLastData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastData();
        }
        return this.lastdata;
    }

    public boolean isLastDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastDataDirty();
        }
        return this.lastdataDirtyFlag;
    }

    public void resetLastData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastData();
            return;
        }
        this.lastdataDirtyFlag = false;
        this.lastdata = null;
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

    public void setObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objtype = string;
        this.objtypeDirtyFlag = true;
    }

    public String getObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjType();
        }
        return this.objtype;
    }

    public boolean isObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjTypeDirty();
        }
        return this.objtypeDirtyFlag;
    }

    public void resetObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjType();
            return;
        }
        this.objtypeDirtyFlag = false;
        this.objtype = null;
    }

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownername = string;
        this.ownernameDirtyFlag = true;
    }

    public String getOwnerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerName();
        }
        return this.ownername;
    }

    public boolean isOwnerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerNameDirty();
        }
        return this.ownernameDirtyFlag;
    }

    public void resetOwnerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerName();
            return;
        }
        this.ownernameDirtyFlag = false;
        this.ownername = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
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

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtag = string;
        this.psobjtagDirtyFlag = true;
    }

    public String getPSObjTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTag();
        }
        return this.psobjtag;
    }

    public boolean isPSObjTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTagDirty();
        }
        return this.psobjtagDirtyFlag;
    }

    public void resetPSObjTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTag();
            return;
        }
        this.psobjtagDirtyFlag = false;
        this.psobjtag = null;
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

    public void setPSSysModelChgLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelChgLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelchglogid = string;
        this.pssysmodelchglogidDirtyFlag = true;
    }

    public String getPSSysModelChgLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelChgLogId();
        }
        return this.pssysmodelchglogid;
    }

    public boolean isPSSysModelChgLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelChgLogIdDirty();
        }
        return this.pssysmodelchglogidDirtyFlag;
    }

    public void resetPSSysModelChgLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelChgLogId();
            return;
        }
        this.pssysmodelchglogidDirtyFlag = false;
        this.pssysmodelchglogid = null;
    }

    public void setPSSysModelChgLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelChgLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelchglogname = string;
        this.pssysmodelchglognameDirtyFlag = true;
    }

    public String getPSSysModelChgLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelChgLogName();
        }
        return this.pssysmodelchglogname;
    }

    public boolean isPSSysModelChgLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelChgLogNameDirty();
        }
        return this.pssysmodelchglognameDirtyFlag;
    }

    public void resetPSSysModelChgLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelChgLogName();
            return;
        }
        this.pssysmodelchglognameDirtyFlag = false;
        this.pssysmodelchglogname = null;
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

    public void setPublishFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPublishFlag(n);
            return;
        }
        this.publishflag = n;
        this.publishflagDirtyFlag = true;
    }

    public Integer getPublishFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPublishFlag();
        }
        return this.publishflag;
    }

    public boolean isPublishFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPublishFlagDirty();
        }
        return this.publishflagDirtyFlag;
    }

    public void resetPublishFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPublishFlag();
            return;
        }
        this.publishflagDirtyFlag = false;
        this.publishflag = null;
    }

    public void setRemoteAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoteAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.remoteaddr = string;
        this.remoteaddrDirtyFlag = true;
    }

    public String getRemoteAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoteAddr();
        }
        return this.remoteaddr;
    }

    public boolean isRemoteAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoteAddrDirty();
        }
        return this.remoteaddrDirtyFlag;
    }

    public void resetRemoteAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoteAddr();
            return;
        }
        this.remoteaddrDirtyFlag = false;
        this.remoteaddr = null;
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

    public void setVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(n);
            return;
        }
        this.version = n;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSSysModelChgLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelChgLogBase pSSysModelChgLogBase) {
        pSSysModelChgLogBase.resetCHGType();
        pSSysModelChgLogBase.resetCreateDate();
        pSSysModelChgLogBase.resetCreateMan();
        pSSysModelChgLogBase.resetCurData();
        pSSysModelChgLogBase.resetLastData();
        pSSysModelChgLogBase.resetMemo();
        pSSysModelChgLogBase.resetObjType();
        pSSysModelChgLogBase.resetOwnerId();
        pSSysModelChgLogBase.resetOwnerName();
        pSSysModelChgLogBase.resetOwnerType();
        pSSysModelChgLogBase.resetPSDEId();
        pSSysModelChgLogBase.resetPSDEName();
        pSSysModelChgLogBase.resetPSObjId();
        pSSysModelChgLogBase.resetPSObjName();
        pSSysModelChgLogBase.resetPSObjTag();
        pSSysModelChgLogBase.resetPSSysAppId();
        pSSysModelChgLogBase.resetPSSysAppName();
        pSSysModelChgLogBase.resetPSSysModelChgLogId();
        pSSysModelChgLogBase.resetPSSysModelChgLogName();
        pSSysModelChgLogBase.resetPSSystemId();
        pSSysModelChgLogBase.resetPSSystemName();
        pSSysModelChgLogBase.resetPublishFlag();
        pSSysModelChgLogBase.resetRemoteAddr();
        pSSysModelChgLogBase.resetUpdateDate();
        pSSysModelChgLogBase.resetUpdateMan();
        pSSysModelChgLogBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCHGTypeDirty()) {
            hashMap.put(FIELD_CHGTYPE, this.getCHGType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurDataDirty()) {
            hashMap.put(FIELD_CURDATA, this.getCurData());
        }
        if (!bl || this.isLastDataDirty()) {
            hashMap.put(FIELD_LASTDATA, this.getLastData());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isObjTypeDirty()) {
            hashMap.put(FIELD_OBJTYPE, this.getObjType());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerNameDirty()) {
            hashMap.put(FIELD_OWNERNAME, this.getOwnerName());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTagDirty()) {
            hashMap.put(FIELD_PSOBJTAG, this.getPSObjTag());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysModelChgLogIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELCHGLOGID, this.getPSSysModelChgLogId());
        }
        if (!bl || this.isPSSysModelChgLogNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELCHGLOGNAME, this.getPSSysModelChgLogName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPublishFlagDirty()) {
            hashMap.put(FIELD_PUBLISHFLAG, this.getPublishFlag());
        }
        if (!bl || this.isRemoteAddrDirty()) {
            hashMap.put(FIELD_REMOTEADDR, this.getRemoteAddr());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSSysModelChgLogBase.get(this, n);
    }

    private static Object get(PSSysModelChgLogBase pSSysModelChgLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelChgLogBase.getCHGType();
            }
            case 1: {
                return pSSysModelChgLogBase.getCreateDate();
            }
            case 2: {
                return pSSysModelChgLogBase.getCreateMan();
            }
            case 3: {
                return pSSysModelChgLogBase.getCurData();
            }
            case 4: {
                return pSSysModelChgLogBase.getLastData();
            }
            case 5: {
                return pSSysModelChgLogBase.getMemo();
            }
            case 6: {
                return pSSysModelChgLogBase.getObjType();
            }
            case 7: {
                return pSSysModelChgLogBase.getOwnerId();
            }
            case 8: {
                return pSSysModelChgLogBase.getOwnerName();
            }
            case 9: {
                return pSSysModelChgLogBase.getOwnerType();
            }
            case 10: {
                return pSSysModelChgLogBase.getPSDEId();
            }
            case 11: {
                return pSSysModelChgLogBase.getPSDEName();
            }
            case 12: {
                return pSSysModelChgLogBase.getPSObjId();
            }
            case 13: {
                return pSSysModelChgLogBase.getPSObjName();
            }
            case 14: {
                return pSSysModelChgLogBase.getPSObjTag();
            }
            case 15: {
                return pSSysModelChgLogBase.getPSSysAppId();
            }
            case 16: {
                return pSSysModelChgLogBase.getPSSysAppName();
            }
            case 17: {
                return pSSysModelChgLogBase.getPSSysModelChgLogId();
            }
            case 18: {
                return pSSysModelChgLogBase.getPSSysModelChgLogName();
            }
            case 19: {
                return pSSysModelChgLogBase.getPSSystemId();
            }
            case 20: {
                return pSSysModelChgLogBase.getPSSystemName();
            }
            case 21: {
                return pSSysModelChgLogBase.getPublishFlag();
            }
            case 22: {
                return pSSysModelChgLogBase.getRemoteAddr();
            }
            case 23: {
                return pSSysModelChgLogBase.getUpdateDate();
            }
            case 24: {
                return pSSysModelChgLogBase.getUpdateMan();
            }
            case 25: {
                return pSSysModelChgLogBase.getVersion();
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
        PSSysModelChgLogBase.set(this, n, object);
    }

    private static void set(PSSysModelChgLogBase pSSysModelChgLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelChgLogBase.setCHGType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelChgLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelChgLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelChgLogBase.setCurData(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelChgLogBase.setLastData(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelChgLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelChgLogBase.setObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelChgLogBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelChgLogBase.setOwnerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelChgLogBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelChgLogBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelChgLogBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelChgLogBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelChgLogBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelChgLogBase.setPSObjTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelChgLogBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelChgLogBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelChgLogBase.setPSSysModelChgLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelChgLogBase.setPSSysModelChgLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelChgLogBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysModelChgLogBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysModelChgLogBase.setPublishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysModelChgLogBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysModelChgLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysModelChgLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysModelChgLogBase.setVersion(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelChgLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelChgLogBase pSSysModelChgLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelChgLogBase.getCHGType() == null;
            }
            case 1: {
                return pSSysModelChgLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelChgLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelChgLogBase.getCurData() == null;
            }
            case 4: {
                return pSSysModelChgLogBase.getLastData() == null;
            }
            case 5: {
                return pSSysModelChgLogBase.getMemo() == null;
            }
            case 6: {
                return pSSysModelChgLogBase.getObjType() == null;
            }
            case 7: {
                return pSSysModelChgLogBase.getOwnerId() == null;
            }
            case 8: {
                return pSSysModelChgLogBase.getOwnerName() == null;
            }
            case 9: {
                return pSSysModelChgLogBase.getOwnerType() == null;
            }
            case 10: {
                return pSSysModelChgLogBase.getPSDEId() == null;
            }
            case 11: {
                return pSSysModelChgLogBase.getPSDEName() == null;
            }
            case 12: {
                return pSSysModelChgLogBase.getPSObjId() == null;
            }
            case 13: {
                return pSSysModelChgLogBase.getPSObjName() == null;
            }
            case 14: {
                return pSSysModelChgLogBase.getPSObjTag() == null;
            }
            case 15: {
                return pSSysModelChgLogBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSSysModelChgLogBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSSysModelChgLogBase.getPSSysModelChgLogId() == null;
            }
            case 18: {
                return pSSysModelChgLogBase.getPSSysModelChgLogName() == null;
            }
            case 19: {
                return pSSysModelChgLogBase.getPSSystemId() == null;
            }
            case 20: {
                return pSSysModelChgLogBase.getPSSystemName() == null;
            }
            case 21: {
                return pSSysModelChgLogBase.getPublishFlag() == null;
            }
            case 22: {
                return pSSysModelChgLogBase.getRemoteAddr() == null;
            }
            case 23: {
                return pSSysModelChgLogBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysModelChgLogBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysModelChgLogBase.getVersion() == null;
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
        return PSSysModelChgLogBase.contains(this, n);
    }

    private static boolean contains(PSSysModelChgLogBase pSSysModelChgLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelChgLogBase.isCHGTypeDirty();
            }
            case 1: {
                return pSSysModelChgLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelChgLogBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelChgLogBase.isCurDataDirty();
            }
            case 4: {
                return pSSysModelChgLogBase.isLastDataDirty();
            }
            case 5: {
                return pSSysModelChgLogBase.isMemoDirty();
            }
            case 6: {
                return pSSysModelChgLogBase.isObjTypeDirty();
            }
            case 7: {
                return pSSysModelChgLogBase.isOwnerIdDirty();
            }
            case 8: {
                return pSSysModelChgLogBase.isOwnerNameDirty();
            }
            case 9: {
                return pSSysModelChgLogBase.isOwnerTypeDirty();
            }
            case 10: {
                return pSSysModelChgLogBase.isPSDEIdDirty();
            }
            case 11: {
                return pSSysModelChgLogBase.isPSDENameDirty();
            }
            case 12: {
                return pSSysModelChgLogBase.isPSObjIdDirty();
            }
            case 13: {
                return pSSysModelChgLogBase.isPSObjNameDirty();
            }
            case 14: {
                return pSSysModelChgLogBase.isPSObjTagDirty();
            }
            case 15: {
                return pSSysModelChgLogBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSSysModelChgLogBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSSysModelChgLogBase.isPSSysModelChgLogIdDirty();
            }
            case 18: {
                return pSSysModelChgLogBase.isPSSysModelChgLogNameDirty();
            }
            case 19: {
                return pSSysModelChgLogBase.isPSSystemIdDirty();
            }
            case 20: {
                return pSSysModelChgLogBase.isPSSystemNameDirty();
            }
            case 21: {
                return pSSysModelChgLogBase.isPublishFlagDirty();
            }
            case 22: {
                return pSSysModelChgLogBase.isRemoteAddrDirty();
            }
            case 23: {
                return pSSysModelChgLogBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysModelChgLogBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysModelChgLogBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelChgLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelChgLogBase pSSysModelChgLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelChgLogBase.getCHGType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"chgtype", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getCHGType()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getCurData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curdata", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getCurData()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getLastData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastdata", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getLastData()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objtype", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getObjType()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getOwnerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownername", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getOwnerName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSObjTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtag", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSObjTag()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSysModelChgLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbchglogid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSysModelChgLogId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSysModelChgLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbchglogname", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSysModelChgLogName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getPublishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"publishflag", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getPublishFlag()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelChgLogBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSysModelChgLogBase.getJSONValue((Object)pSSysModelChgLogBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelChgLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelChgLogBase pSSysModelChgLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelChgLogBase.getCHGType() != null) {
            object = pSSysModelChgLogBase.getCHGType();
            xmlNode.setAttribute(FIELD_CHGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getCreateDate() != null) {
            object = pSSysModelChgLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelChgLogBase.getCreateMan() != null) {
            object = pSSysModelChgLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getCurData() != null) {
            object = pSSysModelChgLogBase.getCurData();
            xmlNode.setAttribute(FIELD_CURDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getLastData() != null) {
            object = pSSysModelChgLogBase.getLastData();
            xmlNode.setAttribute(FIELD_LASTDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getMemo() != null) {
            object = pSSysModelChgLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getObjType() != null) {
            object = pSSysModelChgLogBase.getObjType();
            xmlNode.setAttribute(FIELD_OBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getOwnerId() != null) {
            object = pSSysModelChgLogBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getOwnerName() != null) {
            object = pSSysModelChgLogBase.getOwnerName();
            xmlNode.setAttribute(FIELD_OWNERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getOwnerType() != null) {
            object = pSSysModelChgLogBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSDEId() != null) {
            object = pSSysModelChgLogBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSDEName() != null) {
            object = pSSysModelChgLogBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSObjId() != null) {
            object = pSSysModelChgLogBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSObjName() != null) {
            object = pSSysModelChgLogBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSObjTag() != null) {
            object = pSSysModelChgLogBase.getPSObjTag();
            xmlNode.setAttribute(FIELD_PSOBJTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSysAppId() != null) {
            object = pSSysModelChgLogBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSysAppName() != null) {
            object = pSSysModelChgLogBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSysModelChgLogId() != null) {
            object = pSSysModelChgLogBase.getPSSysModelChgLogId();
            xmlNode.setAttribute("PSSYSMODELCHGLOGID", object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSysModelChgLogName() != null) {
            object = pSSysModelChgLogBase.getPSSysModelChgLogName();
            xmlNode.setAttribute("PSSYSMODELCHGLOGNAME", object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSystemId() != null) {
            object = pSSysModelChgLogBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPSSystemName() != null) {
            object = pSSysModelChgLogBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getPublishFlag() != null) {
            object = pSSysModelChgLogBase.getPublishFlag();
            xmlNode.setAttribute(FIELD_PUBLISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelChgLogBase.getRemoteAddr() != null) {
            object = pSSysModelChgLogBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getUpdateDate() != null) {
            object = pSSysModelChgLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelChgLogBase.getUpdateMan() != null) {
            object = pSSysModelChgLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelChgLogBase.getVersion() != null) {
            object = pSSysModelChgLogBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelChgLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelChgLogBase pSSysModelChgLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelChgLogBase.isCHGTypeDirty() && (bl || pSSysModelChgLogBase.getCHGType() != null)) {
            iDataObject.set(FIELD_CHGTYPE, (Object)pSSysModelChgLogBase.getCHGType());
        }
        if (pSSysModelChgLogBase.isCreateDateDirty() && (bl || pSSysModelChgLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelChgLogBase.getCreateDate());
        }
        if (pSSysModelChgLogBase.isCreateManDirty() && (bl || pSSysModelChgLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelChgLogBase.getCreateMan());
        }
        if (pSSysModelChgLogBase.isCurDataDirty() && (bl || pSSysModelChgLogBase.getCurData() != null)) {
            iDataObject.set(FIELD_CURDATA, (Object)pSSysModelChgLogBase.getCurData());
        }
        if (pSSysModelChgLogBase.isLastDataDirty() && (bl || pSSysModelChgLogBase.getLastData() != null)) {
            iDataObject.set(FIELD_LASTDATA, (Object)pSSysModelChgLogBase.getLastData());
        }
        if (pSSysModelChgLogBase.isMemoDirty() && (bl || pSSysModelChgLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelChgLogBase.getMemo());
        }
        if (pSSysModelChgLogBase.isObjTypeDirty() && (bl || pSSysModelChgLogBase.getObjType() != null)) {
            iDataObject.set(FIELD_OBJTYPE, (Object)pSSysModelChgLogBase.getObjType());
        }
        if (pSSysModelChgLogBase.isOwnerIdDirty() && (bl || pSSysModelChgLogBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSSysModelChgLogBase.getOwnerId());
        }
        if (pSSysModelChgLogBase.isOwnerNameDirty() && (bl || pSSysModelChgLogBase.getOwnerName() != null)) {
            iDataObject.set(FIELD_OWNERNAME, (Object)pSSysModelChgLogBase.getOwnerName());
        }
        if (pSSysModelChgLogBase.isOwnerTypeDirty() && (bl || pSSysModelChgLogBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSSysModelChgLogBase.getOwnerType());
        }
        if (pSSysModelChgLogBase.isPSDEIdDirty() && (bl || pSSysModelChgLogBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysModelChgLogBase.getPSDEId());
        }
        if (pSSysModelChgLogBase.isPSDENameDirty() && (bl || pSSysModelChgLogBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysModelChgLogBase.getPSDEName());
        }
        if (pSSysModelChgLogBase.isPSObjIdDirty() && (bl || pSSysModelChgLogBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysModelChgLogBase.getPSObjId());
        }
        if (pSSysModelChgLogBase.isPSObjNameDirty() && (bl || pSSysModelChgLogBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysModelChgLogBase.getPSObjName());
        }
        if (pSSysModelChgLogBase.isPSObjTagDirty() && (bl || pSSysModelChgLogBase.getPSObjTag() != null)) {
            iDataObject.set(FIELD_PSOBJTAG, (Object)pSSysModelChgLogBase.getPSObjTag());
        }
        if (pSSysModelChgLogBase.isPSSysAppIdDirty() && (bl || pSSysModelChgLogBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysModelChgLogBase.getPSSysAppId());
        }
        if (pSSysModelChgLogBase.isPSSysAppNameDirty() && (bl || pSSysModelChgLogBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysModelChgLogBase.getPSSysAppName());
        }
        if (pSSysModelChgLogBase.isPSSysModelChgLogIdDirty() && (bl || pSSysModelChgLogBase.getPSSysModelChgLogId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELCHGLOGID, (Object)pSSysModelChgLogBase.getPSSysModelChgLogId());
        }
        if (pSSysModelChgLogBase.isPSSysModelChgLogNameDirty() && (bl || pSSysModelChgLogBase.getPSSysModelChgLogName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELCHGLOGNAME, (Object)pSSysModelChgLogBase.getPSSysModelChgLogName());
        }
        if (pSSysModelChgLogBase.isPSSystemIdDirty() && (bl || pSSysModelChgLogBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelChgLogBase.getPSSystemId());
        }
        if (pSSysModelChgLogBase.isPSSystemNameDirty() && (bl || pSSysModelChgLogBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelChgLogBase.getPSSystemName());
        }
        if (pSSysModelChgLogBase.isPublishFlagDirty() && (bl || pSSysModelChgLogBase.getPublishFlag() != null)) {
            iDataObject.set(FIELD_PUBLISHFLAG, (Object)pSSysModelChgLogBase.getPublishFlag());
        }
        if (pSSysModelChgLogBase.isRemoteAddrDirty() && (bl || pSSysModelChgLogBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSSysModelChgLogBase.getRemoteAddr());
        }
        if (pSSysModelChgLogBase.isUpdateDateDirty() && (bl || pSSysModelChgLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelChgLogBase.getUpdateDate());
        }
        if (pSSysModelChgLogBase.isUpdateManDirty() && (bl || pSSysModelChgLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelChgLogBase.getUpdateMan());
        }
        if (pSSysModelChgLogBase.isVersionDirty() && (bl || pSSysModelChgLogBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSysModelChgLogBase.getVersion());
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
        return PSSysModelChgLogBase.remove(this, n);
    }

    private static boolean remove(PSSysModelChgLogBase pSSysModelChgLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelChgLogBase.resetCHGType();
                return true;
            }
            case 1: {
                pSSysModelChgLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelChgLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelChgLogBase.resetCurData();
                return true;
            }
            case 4: {
                pSSysModelChgLogBase.resetLastData();
                return true;
            }
            case 5: {
                pSSysModelChgLogBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysModelChgLogBase.resetObjType();
                return true;
            }
            case 7: {
                pSSysModelChgLogBase.resetOwnerId();
                return true;
            }
            case 8: {
                pSSysModelChgLogBase.resetOwnerName();
                return true;
            }
            case 9: {
                pSSysModelChgLogBase.resetOwnerType();
                return true;
            }
            case 10: {
                pSSysModelChgLogBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSSysModelChgLogBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSSysModelChgLogBase.resetPSObjId();
                return true;
            }
            case 13: {
                pSSysModelChgLogBase.resetPSObjName();
                return true;
            }
            case 14: {
                pSSysModelChgLogBase.resetPSObjTag();
                return true;
            }
            case 15: {
                pSSysModelChgLogBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSSysModelChgLogBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSSysModelChgLogBase.resetPSSysModelChgLogId();
                return true;
            }
            case 18: {
                pSSysModelChgLogBase.resetPSSysModelChgLogName();
                return true;
            }
            case 19: {
                pSSysModelChgLogBase.resetPSSystemId();
                return true;
            }
            case 20: {
                pSSysModelChgLogBase.resetPSSystemName();
                return true;
            }
            case 21: {
                pSSysModelChgLogBase.resetPublishFlag();
                return true;
            }
            case 22: {
                pSSysModelChgLogBase.resetRemoteAddr();
                return true;
            }
            case 23: {
                pSSysModelChgLogBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysModelChgLogBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysModelChgLogBase.resetVersion();
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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

    private PSSysModelChgLogBase getProxyEntity() {
        return this.proxyPSSysModelChgLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelChgLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelChgLogBase) {
            this.proxyPSSysModelChgLogBase = (PSSysModelChgLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHGTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CURDATA, 3);
        fieldIndexMap.put(FIELD_LASTDATA, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_OBJTYPE, 6);
        fieldIndexMap.put(FIELD_OWNERID, 7);
        fieldIndexMap.put(FIELD_OWNERNAME, 8);
        fieldIndexMap.put(FIELD_OWNERTYPE, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_PSOBJID, 12);
        fieldIndexMap.put(FIELD_PSOBJNAME, 13);
        fieldIndexMap.put(FIELD_PSOBJTAG, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSMODELCHGLOGID, 17);
        fieldIndexMap.put(FIELD_PSSYSMODELCHGLOGNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 20);
        fieldIndexMap.put(FIELD_PUBLISHFLAG, 21);
        fieldIndexMap.put(FIELD_REMOTEADDR, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_VERSION, 25);
    }
}

