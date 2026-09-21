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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSyncDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSyncDataBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYNCDATAID = "PSDCSYNCDATAID";
    public static final String FIELD_PSDCSYNCDATANAME = "PSDCSYNCDATANAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_SYNCAGENT = "SYNCAGENT";
    public static final String FIELD_SYNCPARAM = "SYNCPARAM";
    public static final String FIELD_SYNCPARAM2 = "SYNCPARAM2";
    public static final String FIELD_SYNCPARAM3 = "SYNCPARAM3";
    public static final String FIELD_SYNCPARAM4 = "SYNCPARAM4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCSYNCDATAID = 3;
    private static final int INDEX_PSDCSYNCDATANAME = 4;
    private static final int INDEX_PSDEVCENTERDBINSTID = 5;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_PSDEVSLNSYSID = 9;
    private static final int INDEX_PSDEVSLNSYSNAME = 10;
    private static final int INDEX_PSOBJID = 11;
    private static final int INDEX_PSOBJNAME = 12;
    private static final int INDEX_PSOBJTYPE = 13;
    private static final int INDEX_SYNCAGENT = 14;
    private static final int INDEX_SYNCPARAM = 15;
    private static final int INDEX_SYNCPARAM2 = 16;
    private static final int INDEX_SYNCPARAM3 = 17;
    private static final int INDEX_SYNCPARAM4 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSyncDataBase proxyPSDCSyncDataBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsyncdataidDirtyFlag = false;
    private boolean psdcsyncdatanameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean syncagentDirtyFlag = false;
    private boolean syncparamDirtyFlag = false;
    private boolean syncparam2DirtyFlag = false;
    private boolean syncparam3DirtyFlag = false;
    private boolean syncparam4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsyncdataid")
    private String psdcsyncdataid;
    @Column(name="psdcsyncdataname")
    private String psdcsyncdataname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="syncagent")
    private String syncagent;
    @Column(name="syncparam")
    private String syncparam;
    @Column(name="syncparam2")
    private String syncparam2;
    @Column(name="syncparam3")
    private String syncparam3;
    @Column(name="syncparam4")
    private String syncparam4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPsdevcenterdbinstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setPSDCSyncDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdataid = string;
        this.psdcsyncdataidDirtyFlag = true;
    }

    public String getPSDCSyncDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncDataId();
        }
        return this.psdcsyncdataid;
    }

    public boolean isPSDCSyncDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncDataIdDirty();
        }
        return this.psdcsyncdataidDirtyFlag;
    }

    public void resetPSDCSyncDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncDataId();
            return;
        }
        this.psdcsyncdataidDirtyFlag = false;
        this.psdcsyncdataid = null;
    }

    public void setPSDCSyncDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdataname = string;
        this.psdcsyncdatanameDirtyFlag = true;
    }

    public String getPSDCSyncDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncDataName();
        }
        return this.psdcsyncdataname;
    }

    public boolean isPSDCSyncDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncDataNameDirty();
        }
        return this.psdcsyncdatanameDirtyFlag;
    }

    public void resetPSDCSyncDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncDataName();
            return;
        }
        this.psdcsyncdatanameDirtyFlag = false;
        this.psdcsyncdataname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
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

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setSyncAgent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncAgent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncagent = string;
        this.syncagentDirtyFlag = true;
    }

    public String getSyncAgent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncAgent();
        }
        return this.syncagent;
    }

    public boolean isSyncAgentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncAgentDirty();
        }
        return this.syncagentDirtyFlag;
    }

    public void resetSyncAgent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncAgent();
            return;
        }
        this.syncagentDirtyFlag = false;
        this.syncagent = null;
    }

    public void setSyncParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam = string;
        this.syncparamDirtyFlag = true;
    }

    public String getSyncParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam();
        }
        return this.syncparam;
    }

    public boolean isSyncParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParamDirty();
        }
        return this.syncparamDirtyFlag;
    }

    public void resetSyncParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam();
            return;
        }
        this.syncparamDirtyFlag = false;
        this.syncparam = null;
    }

    public void setSyncParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam2 = string;
        this.syncparam2DirtyFlag = true;
    }

    public String getSyncParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam2();
        }
        return this.syncparam2;
    }

    public boolean isSyncParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam2Dirty();
        }
        return this.syncparam2DirtyFlag;
    }

    public void resetSyncParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam2();
            return;
        }
        this.syncparam2DirtyFlag = false;
        this.syncparam2 = null;
    }

    public void setSyncParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam3 = string;
        this.syncparam3DirtyFlag = true;
    }

    public String getSyncParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam3();
        }
        return this.syncparam3;
    }

    public boolean isSyncParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam3Dirty();
        }
        return this.syncparam3DirtyFlag;
    }

    public void resetSyncParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam3();
            return;
        }
        this.syncparam3DirtyFlag = false;
        this.syncparam3 = null;
    }

    public void setSyncParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam4 = string;
        this.syncparam4DirtyFlag = true;
    }

    public String getSyncParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam4();
        }
        return this.syncparam4;
    }

    public boolean isSyncParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam4Dirty();
        }
        return this.syncparam4DirtyFlag;
    }

    public void resetSyncParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam4();
            return;
        }
        this.syncparam4DirtyFlag = false;
        this.syncparam4 = null;
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
        PSDCSyncDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSyncDataBase pSDCSyncDataBase) {
        pSDCSyncDataBase.resetCreateDate();
        pSDCSyncDataBase.resetCreateMan();
        pSDCSyncDataBase.resetMemo();
        pSDCSyncDataBase.resetPSDCSyncDataId();
        pSDCSyncDataBase.resetPSDCSyncDataName();
        pSDCSyncDataBase.resetPSDevCenterDBInstId();
        pSDCSyncDataBase.resetPSDevCenterDBInstName();
        pSDCSyncDataBase.resetPSDevCenterId();
        pSDCSyncDataBase.resetPSDevCenterName();
        pSDCSyncDataBase.resetPSDevSlnSysId();
        pSDCSyncDataBase.resetPSDevSlnSysName();
        pSDCSyncDataBase.resetPSObjId();
        pSDCSyncDataBase.resetPSObjName();
        pSDCSyncDataBase.resetPSObjType();
        pSDCSyncDataBase.resetSyncAgent();
        pSDCSyncDataBase.resetSyncParam();
        pSDCSyncDataBase.resetSyncParam2();
        pSDCSyncDataBase.resetSyncParam3();
        pSDCSyncDataBase.resetSyncParam4();
        pSDCSyncDataBase.resetUpdateDate();
        pSDCSyncDataBase.resetUpdateMan();
        pSDCSyncDataBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSyncDataIdDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATAID, this.getPSDCSyncDataId());
        }
        if (!bl || this.isPSDCSyncDataNameDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATANAME, this.getPSDCSyncDataName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isSyncAgentDirty()) {
            hashMap.put(FIELD_SYNCAGENT, this.getSyncAgent());
        }
        if (!bl || this.isSyncParamDirty()) {
            hashMap.put(FIELD_SYNCPARAM, this.getSyncParam());
        }
        if (!bl || this.isSyncParam2Dirty()) {
            hashMap.put(FIELD_SYNCPARAM2, this.getSyncParam2());
        }
        if (!bl || this.isSyncParam3Dirty()) {
            hashMap.put(FIELD_SYNCPARAM3, this.getSyncParam3());
        }
        if (!bl || this.isSyncParam4Dirty()) {
            hashMap.put(FIELD_SYNCPARAM4, this.getSyncParam4());
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
        return PSDCSyncDataBase.get(this, n);
    }

    private static Object get(PSDCSyncDataBase pSDCSyncDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataBase.getCreateDate();
            }
            case 1: {
                return pSDCSyncDataBase.getCreateMan();
            }
            case 2: {
                return pSDCSyncDataBase.getMemo();
            }
            case 3: {
                return pSDCSyncDataBase.getPSDCSyncDataId();
            }
            case 4: {
                return pSDCSyncDataBase.getPSDCSyncDataName();
            }
            case 5: {
                return pSDCSyncDataBase.getPSDevCenterDBInstId();
            }
            case 6: {
                return pSDCSyncDataBase.getPSDevCenterDBInstName();
            }
            case 7: {
                return pSDCSyncDataBase.getPSDevCenterId();
            }
            case 8: {
                return pSDCSyncDataBase.getPSDevCenterName();
            }
            case 9: {
                return pSDCSyncDataBase.getPSDevSlnSysId();
            }
            case 10: {
                return pSDCSyncDataBase.getPSDevSlnSysName();
            }
            case 11: {
                return pSDCSyncDataBase.getPSObjId();
            }
            case 12: {
                return pSDCSyncDataBase.getPSObjName();
            }
            case 13: {
                return pSDCSyncDataBase.getPSObjType();
            }
            case 14: {
                return pSDCSyncDataBase.getSyncAgent();
            }
            case 15: {
                return pSDCSyncDataBase.getSyncParam();
            }
            case 16: {
                return pSDCSyncDataBase.getSyncParam2();
            }
            case 17: {
                return pSDCSyncDataBase.getSyncParam3();
            }
            case 18: {
                return pSDCSyncDataBase.getSyncParam4();
            }
            case 19: {
                return pSDCSyncDataBase.getUpdateDate();
            }
            case 20: {
                return pSDCSyncDataBase.getUpdateMan();
            }
            case 21: {
                return pSDCSyncDataBase.getValidFlag();
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
        PSDCSyncDataBase.set(this, n, object);
    }

    private static void set(PSDCSyncDataBase pSDCSyncDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSyncDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSyncDataBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSyncDataBase.setPSDCSyncDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSyncDataBase.setPSDCSyncDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSyncDataBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSyncDataBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSyncDataBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSyncDataBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSyncDataBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSyncDataBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSyncDataBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSyncDataBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSyncDataBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSyncDataBase.setSyncAgent(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCSyncDataBase.setSyncParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSyncDataBase.setSyncParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSyncDataBase.setSyncParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCSyncDataBase.setSyncParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSyncDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDCSyncDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCSyncDataBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCSyncDataBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSyncDataBase pSDCSyncDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSyncDataBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSyncDataBase.getMemo() == null;
            }
            case 3: {
                return pSDCSyncDataBase.getPSDCSyncDataId() == null;
            }
            case 4: {
                return pSDCSyncDataBase.getPSDCSyncDataName() == null;
            }
            case 5: {
                return pSDCSyncDataBase.getPSDevCenterDBInstId() == null;
            }
            case 6: {
                return pSDCSyncDataBase.getPSDevCenterDBInstName() == null;
            }
            case 7: {
                return pSDCSyncDataBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDCSyncDataBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSDCSyncDataBase.getPSDevSlnSysId() == null;
            }
            case 10: {
                return pSDCSyncDataBase.getPSDevSlnSysName() == null;
            }
            case 11: {
                return pSDCSyncDataBase.getPSObjId() == null;
            }
            case 12: {
                return pSDCSyncDataBase.getPSObjName() == null;
            }
            case 13: {
                return pSDCSyncDataBase.getPSObjType() == null;
            }
            case 14: {
                return pSDCSyncDataBase.getSyncAgent() == null;
            }
            case 15: {
                return pSDCSyncDataBase.getSyncParam() == null;
            }
            case 16: {
                return pSDCSyncDataBase.getSyncParam2() == null;
            }
            case 17: {
                return pSDCSyncDataBase.getSyncParam3() == null;
            }
            case 18: {
                return pSDCSyncDataBase.getSyncParam4() == null;
            }
            case 19: {
                return pSDCSyncDataBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDCSyncDataBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDCSyncDataBase.getValidFlag() == null;
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
        return PSDCSyncDataBase.contains(this, n);
    }

    private static boolean contains(PSDCSyncDataBase pSDCSyncDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSyncDataBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSyncDataBase.isMemoDirty();
            }
            case 3: {
                return pSDCSyncDataBase.isPSDCSyncDataIdDirty();
            }
            case 4: {
                return pSDCSyncDataBase.isPSDCSyncDataNameDirty();
            }
            case 5: {
                return pSDCSyncDataBase.isPSDevCenterDBInstIdDirty();
            }
            case 6: {
                return pSDCSyncDataBase.isPSDevCenterDBInstNameDirty();
            }
            case 7: {
                return pSDCSyncDataBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDCSyncDataBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSDCSyncDataBase.isPSDevSlnSysIdDirty();
            }
            case 10: {
                return pSDCSyncDataBase.isPSDevSlnSysNameDirty();
            }
            case 11: {
                return pSDCSyncDataBase.isPSObjIdDirty();
            }
            case 12: {
                return pSDCSyncDataBase.isPSObjNameDirty();
            }
            case 13: {
                return pSDCSyncDataBase.isPSObjTypeDirty();
            }
            case 14: {
                return pSDCSyncDataBase.isSyncAgentDirty();
            }
            case 15: {
                return pSDCSyncDataBase.isSyncParamDirty();
            }
            case 16: {
                return pSDCSyncDataBase.isSyncParam2Dirty();
            }
            case 17: {
                return pSDCSyncDataBase.isSyncParam3Dirty();
            }
            case 18: {
                return pSDCSyncDataBase.isSyncParam4Dirty();
            }
            case 19: {
                return pSDCSyncDataBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDCSyncDataBase.isUpdateManDirty();
            }
            case 21: {
                return pSDCSyncDataBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSyncDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSyncDataBase pSDCSyncDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSyncDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDCSyncDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdataid", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDCSyncDataId()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDCSyncDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdataname", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDCSyncDataName()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getSyncAgent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncagent", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getSyncAgent()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getSyncParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getSyncParam()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getSyncParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam2", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getSyncParam2()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getSyncParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam3", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getSyncParam3()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getSyncParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam4", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getSyncParam4()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSyncDataBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCSyncDataBase.getJSONValue((Object)pSDCSyncDataBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSyncDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSyncDataBase pSDCSyncDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSyncDataBase.getCreateDate() != null) {
            object = pSDCSyncDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncDataBase.getCreateMan() != null) {
            object = pSDCSyncDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getMemo() != null) {
            object = pSDCSyncDataBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDCSyncDataId() != null) {
            object = pSDCSyncDataBase.getPSDCSyncDataId();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDCSyncDataName() != null) {
            object = pSDCSyncDataBase.getPSDCSyncDataName();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterDBInstId() != null) {
            object = pSDCSyncDataBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterDBInstName() != null) {
            object = pSDCSyncDataBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterId() != null) {
            object = pSDCSyncDataBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevCenterName() != null) {
            object = pSDCSyncDataBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevSlnSysId() != null) {
            object = pSDCSyncDataBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSDevSlnSysName() != null) {
            object = pSDCSyncDataBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSObjId() != null) {
            object = pSDCSyncDataBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSObjName() != null) {
            object = pSDCSyncDataBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getPSObjType() != null) {
            object = pSDCSyncDataBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getSyncAgent() != null) {
            object = pSDCSyncDataBase.getSyncAgent();
            xmlNode.setAttribute(FIELD_SYNCAGENT, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getSyncParam() != null) {
            object = pSDCSyncDataBase.getSyncParam();
            xmlNode.setAttribute(FIELD_SYNCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getSyncParam2() != null) {
            object = pSDCSyncDataBase.getSyncParam2();
            xmlNode.setAttribute(FIELD_SYNCPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getSyncParam3() != null) {
            object = pSDCSyncDataBase.getSyncParam3();
            xmlNode.setAttribute(FIELD_SYNCPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getSyncParam4() != null) {
            object = pSDCSyncDataBase.getSyncParam4();
            xmlNode.setAttribute(FIELD_SYNCPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getUpdateDate() != null) {
            object = pSDCSyncDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncDataBase.getUpdateMan() != null) {
            object = pSDCSyncDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataBase.getValidFlag() != null) {
            object = pSDCSyncDataBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSyncDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSyncDataBase pSDCSyncDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSyncDataBase.isCreateDateDirty() && (bl || pSDCSyncDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSyncDataBase.getCreateDate());
        }
        if (pSDCSyncDataBase.isCreateManDirty() && (bl || pSDCSyncDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSyncDataBase.getCreateMan());
        }
        if (pSDCSyncDataBase.isMemoDirty() && (bl || pSDCSyncDataBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSyncDataBase.getMemo());
        }
        if (pSDCSyncDataBase.isPSDCSyncDataIdDirty() && (bl || pSDCSyncDataBase.getPSDCSyncDataId() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATAID, (Object)pSDCSyncDataBase.getPSDCSyncDataId());
        }
        if (pSDCSyncDataBase.isPSDCSyncDataNameDirty() && (bl || pSDCSyncDataBase.getPSDCSyncDataName() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATANAME, (Object)pSDCSyncDataBase.getPSDCSyncDataName());
        }
        if (pSDCSyncDataBase.isPSDevCenterDBInstIdDirty() && (bl || pSDCSyncDataBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDCSyncDataBase.getPSDevCenterDBInstId());
        }
        if (pSDCSyncDataBase.isPSDevCenterDBInstNameDirty() && (bl || pSDCSyncDataBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDCSyncDataBase.getPSDevCenterDBInstName());
        }
        if (pSDCSyncDataBase.isPSDevCenterIdDirty() && (bl || pSDCSyncDataBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSyncDataBase.getPSDevCenterId());
        }
        if (pSDCSyncDataBase.isPSDevCenterNameDirty() && (bl || pSDCSyncDataBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSyncDataBase.getPSDevCenterName());
        }
        if (pSDCSyncDataBase.isPSDevSlnSysIdDirty() && (bl || pSDCSyncDataBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCSyncDataBase.getPSDevSlnSysId());
        }
        if (pSDCSyncDataBase.isPSDevSlnSysNameDirty() && (bl || pSDCSyncDataBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCSyncDataBase.getPSDevSlnSysName());
        }
        if (pSDCSyncDataBase.isPSObjIdDirty() && (bl || pSDCSyncDataBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDCSyncDataBase.getPSObjId());
        }
        if (pSDCSyncDataBase.isPSObjNameDirty() && (bl || pSDCSyncDataBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDCSyncDataBase.getPSObjName());
        }
        if (pSDCSyncDataBase.isPSObjTypeDirty() && (bl || pSDCSyncDataBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSDCSyncDataBase.getPSObjType());
        }
        if (pSDCSyncDataBase.isSyncAgentDirty() && (bl || pSDCSyncDataBase.getSyncAgent() != null)) {
            iDataObject.set(FIELD_SYNCAGENT, (Object)pSDCSyncDataBase.getSyncAgent());
        }
        if (pSDCSyncDataBase.isSyncParamDirty() && (bl || pSDCSyncDataBase.getSyncParam() != null)) {
            iDataObject.set(FIELD_SYNCPARAM, (Object)pSDCSyncDataBase.getSyncParam());
        }
        if (pSDCSyncDataBase.isSyncParam2Dirty() && (bl || pSDCSyncDataBase.getSyncParam2() != null)) {
            iDataObject.set(FIELD_SYNCPARAM2, (Object)pSDCSyncDataBase.getSyncParam2());
        }
        if (pSDCSyncDataBase.isSyncParam3Dirty() && (bl || pSDCSyncDataBase.getSyncParam3() != null)) {
            iDataObject.set(FIELD_SYNCPARAM3, (Object)pSDCSyncDataBase.getSyncParam3());
        }
        if (pSDCSyncDataBase.isSyncParam4Dirty() && (bl || pSDCSyncDataBase.getSyncParam4() != null)) {
            iDataObject.set(FIELD_SYNCPARAM4, (Object)pSDCSyncDataBase.getSyncParam4());
        }
        if (pSDCSyncDataBase.isUpdateDateDirty() && (bl || pSDCSyncDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSyncDataBase.getUpdateDate());
        }
        if (pSDCSyncDataBase.isUpdateManDirty() && (bl || pSDCSyncDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSyncDataBase.getUpdateMan());
        }
        if (pSDCSyncDataBase.isValidFlagDirty() && (bl || pSDCSyncDataBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCSyncDataBase.getValidFlag());
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
        return PSDCSyncDataBase.remove(this, n);
    }

    private static boolean remove(PSDCSyncDataBase pSDCSyncDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncDataBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSyncDataBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSyncDataBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSyncDataBase.resetPSDCSyncDataId();
                return true;
            }
            case 4: {
                pSDCSyncDataBase.resetPSDCSyncDataName();
                return true;
            }
            case 5: {
                pSDCSyncDataBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 6: {
                pSDCSyncDataBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 7: {
                pSDCSyncDataBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDCSyncDataBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSDCSyncDataBase.resetPSDevSlnSysId();
                return true;
            }
            case 10: {
                pSDCSyncDataBase.resetPSDevSlnSysName();
                return true;
            }
            case 11: {
                pSDCSyncDataBase.resetPSObjId();
                return true;
            }
            case 12: {
                pSDCSyncDataBase.resetPSObjName();
                return true;
            }
            case 13: {
                pSDCSyncDataBase.resetPSObjType();
                return true;
            }
            case 14: {
                pSDCSyncDataBase.resetSyncAgent();
                return true;
            }
            case 15: {
                pSDCSyncDataBase.resetSyncParam();
                return true;
            }
            case 16: {
                pSDCSyncDataBase.resetSyncParam2();
                return true;
            }
            case 17: {
                pSDCSyncDataBase.resetSyncParam3();
                return true;
            }
            case 18: {
                pSDCSyncDataBase.resetSyncParam4();
                return true;
            }
            case 19: {
                pSDCSyncDataBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDCSyncDataBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDCSyncDataBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPsdevcenterdbinst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdevcenterdbinst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPsdevcenterdbinstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDCSyncDataBase getProxyEntity() {
        return this.proxyPSDCSyncDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSyncDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSyncDataBase) {
            this.proxyPSDCSyncDataBase = (PSDCSyncDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCSYNCDATAID, 3);
        fieldIndexMap.put(FIELD_PSDCSYNCDATANAME, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_PSOBJID, 11);
        fieldIndexMap.put(FIELD_PSOBJNAME, 12);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 13);
        fieldIndexMap.put(FIELD_SYNCAGENT, 14);
        fieldIndexMap.put(FIELD_SYNCPARAM, 15);
        fieldIndexMap.put(FIELD_SYNCPARAM2, 16);
        fieldIndexMap.put(FIELD_SYNCPARAM3, 17);
        fieldIndexMap.put(FIELD_SYNCPARAM4, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

