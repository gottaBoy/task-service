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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSASGroup;
import net.ibizsys.pscore.srv.config.service.PSASGroupService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCASGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCASGroupBase.class);
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSASGROUPID = "PSASGROUPID";
    public static final String FIELD_PSASGROUPNAME = "PSASGROUPNAME";
    public static final String FIELD_PSDCASGROUPID = "PSDCASGROUPID";
    public static final String FIELD_PSDCASGROUPNAME = "PSDCASGROUPNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REFFLAG = "REFFLAG";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    private static final int INDEX_ASTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXPRIEDTIME = 3;
    private static final int INDEX_HTTPPORT = 4;
    private static final int INDEX_HTTPSPORT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSASGROUPID = 7;
    private static final int INDEX_PSASGROUPNAME = 8;
    private static final int INDEX_PSDCASGROUPID = 9;
    private static final int INDEX_PSDCASGROUPNAME = 10;
    private static final int INDEX_PSDEVCENTERID = 11;
    private static final int INDEX_PSDEVCENTERNAME = 12;
    private static final int INDEX_REFFLAG = 13;
    private static final int INDEX_REFOBJID = 14;
    private static final int INDEX_REFOBJNAME = 15;
    private static final int INDEX_RESPOS = 16;
    private static final int INDEX_RESSTATE = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USAGEMODE = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCASGroupBase proxyPSDCASGroupBase = null;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psasgroupidDirtyFlag = false;
    private boolean psasgroupnameDirtyFlag = false;
    private boolean psdcasgroupidDirtyFlag = false;
    private boolean psdcasgroupnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean refflagDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    @Column(name="astype")
    private String astype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="memo")
    private String memo;
    @Column(name="psasgroupid")
    private String psasgroupid;
    @Column(name="psasgroupname")
    private String psasgroupname;
    @Column(name="psdcasgroupid")
    private String psdcasgroupid;
    @Column(name="psdcasgroupname")
    private String psdcasgroupname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="refflag")
    private Integer refflag;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    private Integer objPSASGroupLock = new Integer(1);
    private PSASGroup psasgroup = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setASType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.astype = string;
        this.astypeDirtyFlag = true;
    }

    public String getASType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASType();
        }
        return this.astype;
    }

    public boolean isASTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASTypeDirty();
        }
        return this.astypeDirtyFlag;
    }

    public void resetASType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASType();
            return;
        }
        this.astypeDirtyFlag = false;
        this.astype = null;
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

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
    }

    public void setHttpsPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpsPort(n);
            return;
        }
        this.httpsport = n;
        this.httpsportDirtyFlag = true;
    }

    public Integer getHttpsPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpsPort();
        }
        return this.httpsport;
    }

    public boolean isHttpsPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpsPortDirty();
        }
        return this.httpsportDirtyFlag;
    }

    public void resetHttpsPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpsPort();
            return;
        }
        this.httpsportDirtyFlag = false;
        this.httpsport = null;
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

    public void setPSASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasgroupid = string;
        this.psasgroupidDirtyFlag = true;
    }

    public String getPSASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASGroupId();
        }
        return this.psasgroupid;
    }

    public boolean isPSASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASGroupIdDirty();
        }
        return this.psasgroupidDirtyFlag;
    }

    public void resetPSASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASGroupId();
            return;
        }
        this.psasgroupidDirtyFlag = false;
        this.psasgroupid = null;
    }

    public void setPSASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasgroupname = string;
        this.psasgroupnameDirtyFlag = true;
    }

    public String getPSASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASGroupName();
        }
        return this.psasgroupname;
    }

    public boolean isPSASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASGroupNameDirty();
        }
        return this.psasgroupnameDirtyFlag;
    }

    public void resetPSASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASGroupName();
            return;
        }
        this.psasgroupnameDirtyFlag = false;
        this.psasgroupname = null;
    }

    public void setPSDCASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcasgroupid = string;
        this.psdcasgroupidDirtyFlag = true;
    }

    public String getPSDCASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCASGroupId();
        }
        return this.psdcasgroupid;
    }

    public boolean isPSDCASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCASGroupIdDirty();
        }
        return this.psdcasgroupidDirtyFlag;
    }

    public void resetPSDCASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCASGroupId();
            return;
        }
        this.psdcasgroupidDirtyFlag = false;
        this.psdcasgroupid = null;
    }

    public void setPSDCASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcasgroupname = string;
        this.psdcasgroupnameDirtyFlag = true;
    }

    public String getPSDCASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCASGroupName();
        }
        return this.psdcasgroupname;
    }

    public boolean isPSDCASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCASGroupNameDirty();
        }
        return this.psdcasgroupnameDirtyFlag;
    }

    public void resetPSDCASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCASGroupName();
            return;
        }
        this.psdcasgroupnameDirtyFlag = false;
        this.psdcasgroupname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFlag(n);
            return;
        }
        this.refflag = n;
        this.refflagDirtyFlag = true;
    }

    public Integer getRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFlag();
        }
        return this.refflag;
    }

    public boolean isRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFlagDirty();
        }
        return this.refflagDirtyFlag;
    }

    public void resetRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFlag();
            return;
        }
        this.refflagDirtyFlag = false;
        this.refflag = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
    }

    protected void onReset() {
        PSDCASGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCASGroupBase pSDCASGroupBase) {
        pSDCASGroupBase.resetASType();
        pSDCASGroupBase.resetCreateDate();
        pSDCASGroupBase.resetCreateMan();
        pSDCASGroupBase.resetExpriedTime();
        pSDCASGroupBase.resetHttpPort();
        pSDCASGroupBase.resetHttpsPort();
        pSDCASGroupBase.resetMemo();
        pSDCASGroupBase.resetPSASGroupId();
        pSDCASGroupBase.resetPSASGroupName();
        pSDCASGroupBase.resetPSDCASGroupId();
        pSDCASGroupBase.resetPSDCASGroupName();
        pSDCASGroupBase.resetPSDevCenterId();
        pSDCASGroupBase.resetPSDevCenterName();
        pSDCASGroupBase.resetRefFlag();
        pSDCASGroupBase.resetRefObjId();
        pSDCASGroupBase.resetRefObjName();
        pSDCASGroupBase.resetResPos();
        pSDCASGroupBase.resetResState();
        pSDCASGroupBase.resetUpdateDate();
        pSDCASGroupBase.resetUpdateMan();
        pSDCASGroupBase.resetUsageMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASTypeDirty()) {
            hashMap.put(FIELD_ASTYPE, this.getASType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSASGroupIdDirty()) {
            hashMap.put(FIELD_PSASGROUPID, this.getPSASGroupId());
        }
        if (!bl || this.isPSASGroupNameDirty()) {
            hashMap.put(FIELD_PSASGROUPNAME, this.getPSASGroupName());
        }
        if (!bl || this.isPSDCASGroupIdDirty()) {
            hashMap.put(FIELD_PSDCASGROUPID, this.getPSDCASGroupId());
        }
        if (!bl || this.isPSDCASGroupNameDirty()) {
            hashMap.put(FIELD_PSDCASGROUPNAME, this.getPSDCASGroupName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isRefFlagDirty()) {
            hashMap.put(FIELD_REFFLAG, this.getRefFlag());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
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
        return PSDCASGroupBase.get(this, n);
    }

    private static Object get(PSDCASGroupBase pSDCASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCASGroupBase.getASType();
            }
            case 1: {
                return pSDCASGroupBase.getCreateDate();
            }
            case 2: {
                return pSDCASGroupBase.getCreateMan();
            }
            case 3: {
                return pSDCASGroupBase.getExpriedTime();
            }
            case 4: {
                return pSDCASGroupBase.getHttpPort();
            }
            case 5: {
                return pSDCASGroupBase.getHttpsPort();
            }
            case 6: {
                return pSDCASGroupBase.getMemo();
            }
            case 7: {
                return pSDCASGroupBase.getPSASGroupId();
            }
            case 8: {
                return pSDCASGroupBase.getPSASGroupName();
            }
            case 9: {
                return pSDCASGroupBase.getPSDCASGroupId();
            }
            case 10: {
                return pSDCASGroupBase.getPSDCASGroupName();
            }
            case 11: {
                return pSDCASGroupBase.getPSDevCenterId();
            }
            case 12: {
                return pSDCASGroupBase.getPSDevCenterName();
            }
            case 13: {
                return pSDCASGroupBase.getRefFlag();
            }
            case 14: {
                return pSDCASGroupBase.getRefObjId();
            }
            case 15: {
                return pSDCASGroupBase.getRefObjName();
            }
            case 16: {
                return pSDCASGroupBase.getResPos();
            }
            case 17: {
                return pSDCASGroupBase.getResState();
            }
            case 18: {
                return pSDCASGroupBase.getUpdateDate();
            }
            case 19: {
                return pSDCASGroupBase.getUpdateMan();
            }
            case 20: {
                return pSDCASGroupBase.getUsageMode();
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
        PSDCASGroupBase.set(this, n, object);
    }

    private static void set(PSDCASGroupBase pSDCASGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCASGroupBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCASGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCASGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCASGroupBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCASGroupBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCASGroupBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCASGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCASGroupBase.setPSASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCASGroupBase.setPSASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCASGroupBase.setPSDCASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCASGroupBase.setPSDCASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCASGroupBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCASGroupBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCASGroupBase.setRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDCASGroupBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCASGroupBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCASGroupBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDCASGroupBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDCASGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDCASGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCASGroupBase.setUsageMode(DataObject.getStringValue((Object)object));
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
        return PSDCASGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDCASGroupBase pSDCASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCASGroupBase.getASType() == null;
            }
            case 1: {
                return pSDCASGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCASGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCASGroupBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDCASGroupBase.getHttpPort() == null;
            }
            case 5: {
                return pSDCASGroupBase.getHttpsPort() == null;
            }
            case 6: {
                return pSDCASGroupBase.getMemo() == null;
            }
            case 7: {
                return pSDCASGroupBase.getPSASGroupId() == null;
            }
            case 8: {
                return pSDCASGroupBase.getPSASGroupName() == null;
            }
            case 9: {
                return pSDCASGroupBase.getPSDCASGroupId() == null;
            }
            case 10: {
                return pSDCASGroupBase.getPSDCASGroupName() == null;
            }
            case 11: {
                return pSDCASGroupBase.getPSDevCenterId() == null;
            }
            case 12: {
                return pSDCASGroupBase.getPSDevCenterName() == null;
            }
            case 13: {
                return pSDCASGroupBase.getRefFlag() == null;
            }
            case 14: {
                return pSDCASGroupBase.getRefObjId() == null;
            }
            case 15: {
                return pSDCASGroupBase.getRefObjName() == null;
            }
            case 16: {
                return pSDCASGroupBase.getResPos() == null;
            }
            case 17: {
                return pSDCASGroupBase.getResState() == null;
            }
            case 18: {
                return pSDCASGroupBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDCASGroupBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDCASGroupBase.getUsageMode() == null;
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
        return PSDCASGroupBase.contains(this, n);
    }

    private static boolean contains(PSDCASGroupBase pSDCASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCASGroupBase.isASTypeDirty();
            }
            case 1: {
                return pSDCASGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCASGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSDCASGroupBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDCASGroupBase.isHttpPortDirty();
            }
            case 5: {
                return pSDCASGroupBase.isHttpsPortDirty();
            }
            case 6: {
                return pSDCASGroupBase.isMemoDirty();
            }
            case 7: {
                return pSDCASGroupBase.isPSASGroupIdDirty();
            }
            case 8: {
                return pSDCASGroupBase.isPSASGroupNameDirty();
            }
            case 9: {
                return pSDCASGroupBase.isPSDCASGroupIdDirty();
            }
            case 10: {
                return pSDCASGroupBase.isPSDCASGroupNameDirty();
            }
            case 11: {
                return pSDCASGroupBase.isPSDevCenterIdDirty();
            }
            case 12: {
                return pSDCASGroupBase.isPSDevCenterNameDirty();
            }
            case 13: {
                return pSDCASGroupBase.isRefFlagDirty();
            }
            case 14: {
                return pSDCASGroupBase.isRefObjIdDirty();
            }
            case 15: {
                return pSDCASGroupBase.isRefObjNameDirty();
            }
            case 16: {
                return pSDCASGroupBase.isResPosDirty();
            }
            case 17: {
                return pSDCASGroupBase.isResStateDirty();
            }
            case 18: {
                return pSDCASGroupBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDCASGroupBase.isUpdateManDirty();
            }
            case 20: {
                return pSDCASGroupBase.isUsageModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCASGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCASGroupBase pSDCASGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCASGroupBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getASType()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasgroupid", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSASGroupId()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasgroupname", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSASGroupName()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSDCASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcasgroupid", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSDCASGroupId()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSDCASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcasgroupname", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSDCASGroupName()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refflag", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getRefFlag()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getResState()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCASGroupBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDCASGroupBase.getJSONValue((Object)pSDCASGroupBase.getUsageMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCASGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCASGroupBase pSDCASGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCASGroupBase.getASType() != null) {
            object = pSDCASGroupBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getCreateDate() != null) {
            object = pSDCASGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCASGroupBase.getCreateMan() != null) {
            object = pSDCASGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getExpriedTime() != null) {
            object = pSDCASGroupBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCASGroupBase.getHttpPort() != null) {
            object = pSDCASGroupBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCASGroupBase.getHttpsPort() != null) {
            object = pSDCASGroupBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCASGroupBase.getMemo() != null) {
            object = pSDCASGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSASGroupId() != null) {
            object = pSDCASGroupBase.getPSASGroupId();
            xmlNode.setAttribute(FIELD_PSASGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSASGroupName() != null) {
            object = pSDCASGroupBase.getPSASGroupName();
            xmlNode.setAttribute(FIELD_PSASGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSDCASGroupId() != null) {
            object = pSDCASGroupBase.getPSDCASGroupId();
            xmlNode.setAttribute(FIELD_PSDCASGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSDCASGroupName() != null) {
            object = pSDCASGroupBase.getPSDCASGroupName();
            xmlNode.setAttribute(FIELD_PSDCASGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSDevCenterId() != null) {
            object = pSDCASGroupBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getPSDevCenterName() != null) {
            object = pSDCASGroupBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getRefFlag() != null) {
            object = pSDCASGroupBase.getRefFlag();
            xmlNode.setAttribute(FIELD_REFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCASGroupBase.getRefObjId() != null) {
            object = pSDCASGroupBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getRefObjName() != null) {
            object = pSDCASGroupBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getResPos() != null) {
            object = pSDCASGroupBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCASGroupBase.getResState() != null) {
            object = pSDCASGroupBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCASGroupBase.getUpdateDate() != null) {
            object = pSDCASGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCASGroupBase.getUpdateMan() != null) {
            object = pSDCASGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCASGroupBase.getUsageMode() != null) {
            object = pSDCASGroupBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCASGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCASGroupBase pSDCASGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCASGroupBase.isASTypeDirty() && (bl || pSDCASGroupBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSDCASGroupBase.getASType());
        }
        if (pSDCASGroupBase.isCreateDateDirty() && (bl || pSDCASGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCASGroupBase.getCreateDate());
        }
        if (pSDCASGroupBase.isCreateManDirty() && (bl || pSDCASGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCASGroupBase.getCreateMan());
        }
        if (pSDCASGroupBase.isExpriedTimeDirty() && (bl || pSDCASGroupBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCASGroupBase.getExpriedTime());
        }
        if (pSDCASGroupBase.isHttpPortDirty() && (bl || pSDCASGroupBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDCASGroupBase.getHttpPort());
        }
        if (pSDCASGroupBase.isHttpsPortDirty() && (bl || pSDCASGroupBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDCASGroupBase.getHttpsPort());
        }
        if (pSDCASGroupBase.isMemoDirty() && (bl || pSDCASGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCASGroupBase.getMemo());
        }
        if (pSDCASGroupBase.isPSASGroupIdDirty() && (bl || pSDCASGroupBase.getPSASGroupId() != null)) {
            iDataObject.set(FIELD_PSASGROUPID, (Object)pSDCASGroupBase.getPSASGroupId());
        }
        if (pSDCASGroupBase.isPSASGroupNameDirty() && (bl || pSDCASGroupBase.getPSASGroupName() != null)) {
            iDataObject.set(FIELD_PSASGROUPNAME, (Object)pSDCASGroupBase.getPSASGroupName());
        }
        if (pSDCASGroupBase.isPSDCASGroupIdDirty() && (bl || pSDCASGroupBase.getPSDCASGroupId() != null)) {
            iDataObject.set(FIELD_PSDCASGROUPID, (Object)pSDCASGroupBase.getPSDCASGroupId());
        }
        if (pSDCASGroupBase.isPSDCASGroupNameDirty() && (bl || pSDCASGroupBase.getPSDCASGroupName() != null)) {
            iDataObject.set(FIELD_PSDCASGROUPNAME, (Object)pSDCASGroupBase.getPSDCASGroupName());
        }
        if (pSDCASGroupBase.isPSDevCenterIdDirty() && (bl || pSDCASGroupBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCASGroupBase.getPSDevCenterId());
        }
        if (pSDCASGroupBase.isPSDevCenterNameDirty() && (bl || pSDCASGroupBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCASGroupBase.getPSDevCenterName());
        }
        if (pSDCASGroupBase.isRefFlagDirty() && (bl || pSDCASGroupBase.getRefFlag() != null)) {
            iDataObject.set(FIELD_REFFLAG, (Object)pSDCASGroupBase.getRefFlag());
        }
        if (pSDCASGroupBase.isRefObjIdDirty() && (bl || pSDCASGroupBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDCASGroupBase.getRefObjId());
        }
        if (pSDCASGroupBase.isRefObjNameDirty() && (bl || pSDCASGroupBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDCASGroupBase.getRefObjName());
        }
        if (pSDCASGroupBase.isResPosDirty() && (bl || pSDCASGroupBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCASGroupBase.getResPos());
        }
        if (pSDCASGroupBase.isResStateDirty() && (bl || pSDCASGroupBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCASGroupBase.getResState());
        }
        if (pSDCASGroupBase.isUpdateDateDirty() && (bl || pSDCASGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCASGroupBase.getUpdateDate());
        }
        if (pSDCASGroupBase.isUpdateManDirty() && (bl || pSDCASGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCASGroupBase.getUpdateMan());
        }
        if (pSDCASGroupBase.isUsageModeDirty() && (bl || pSDCASGroupBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDCASGroupBase.getUsageMode());
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
        return PSDCASGroupBase.remove(this, n);
    }

    private static boolean remove(PSDCASGroupBase pSDCASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCASGroupBase.resetASType();
                return true;
            }
            case 1: {
                pSDCASGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCASGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCASGroupBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDCASGroupBase.resetHttpPort();
                return true;
            }
            case 5: {
                pSDCASGroupBase.resetHttpsPort();
                return true;
            }
            case 6: {
                pSDCASGroupBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCASGroupBase.resetPSASGroupId();
                return true;
            }
            case 8: {
                pSDCASGroupBase.resetPSASGroupName();
                return true;
            }
            case 9: {
                pSDCASGroupBase.resetPSDCASGroupId();
                return true;
            }
            case 10: {
                pSDCASGroupBase.resetPSDCASGroupName();
                return true;
            }
            case 11: {
                pSDCASGroupBase.resetPSDevCenterId();
                return true;
            }
            case 12: {
                pSDCASGroupBase.resetPSDevCenterName();
                return true;
            }
            case 13: {
                pSDCASGroupBase.resetRefFlag();
                return true;
            }
            case 14: {
                pSDCASGroupBase.resetRefObjId();
                return true;
            }
            case 15: {
                pSDCASGroupBase.resetRefObjName();
                return true;
            }
            case 16: {
                pSDCASGroupBase.resetResPos();
                return true;
            }
            case 17: {
                pSDCASGroupBase.resetResState();
                return true;
            }
            case 18: {
                pSDCASGroupBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDCASGroupBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDCASGroupBase.resetUsageMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSASGroup getPSASGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASGroup();
        }
        if (this.getPSASGroupId() == null) {
            return null;
        }
        Integer n = this.objPSASGroupLock;
        synchronized (n) {
            if (this.psasgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSASGroupId(), (Object)this.psasgroup.getPSASGroupId()) != 0L) {
                this.psasgroup = null;
            }
            if (this.psasgroup == null) {
                PSASGroup pSASGroup = new PSASGroup();
                pSASGroup.setPSASGroupId(this.getPSASGroupId());
                PSASGroupService pSASGroupService = (PSASGroupService)ServiceGlobal.getService(PSASGroupService.class, (SessionFactory)this.getSessionFactory());
                pSASGroupService.autoGet((IEntity)pSASGroup);
                this.psasgroup = pSASGroup;
            }
            return this.psasgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCASGroupBase getProxyEntity() {
        return this.proxyPSDCASGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCASGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCASGroupBase) {
            this.proxyPSDCASGroupBase = (PSDCASGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCASGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 3);
        fieldIndexMap.put(FIELD_HTTPPORT, 4);
        fieldIndexMap.put(FIELD_HTTPSPORT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSASGROUPID, 7);
        fieldIndexMap.put(FIELD_PSASGROUPNAME, 8);
        fieldIndexMap.put(FIELD_PSDCASGROUPID, 9);
        fieldIndexMap.put(FIELD_PSDCASGROUPNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 12);
        fieldIndexMap.put(FIELD_REFFLAG, 13);
        fieldIndexMap.put(FIELD_REFOBJID, 14);
        fieldIndexMap.put(FIELD_REFOBJNAME, 15);
        fieldIndexMap.put(FIELD_RESPOS, 16);
        fieldIndexMap.put(FIELD_RESSTATE, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USAGEMODE, 20);
    }
}

