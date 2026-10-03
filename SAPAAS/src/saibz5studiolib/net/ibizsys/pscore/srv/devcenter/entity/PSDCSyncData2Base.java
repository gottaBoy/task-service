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
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSyncData2Base
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSyncData2Base.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCALPSOBJID = "LOCALPSOBJID";
    public static final String FIELD_LOCALPSOBJNAME = "LOCALPSOBJNAME";
    public static final String FIELD_LOCALPSOBJSTATE = "LOCALPSOBJSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYNCDATA2ID = "PSDCSYNCDATA2ID";
    public static final String FIELD_PSDCSYNCDATA2NAME = "PSDCSYNCDATA2NAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_STATEINFO = "STATEINFO";
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
    private static final int INDEX_LOCALPSOBJID = 2;
    private static final int INDEX_LOCALPSOBJNAME = 3;
    private static final int INDEX_LOCALPSOBJSTATE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCSYNCDATA2ID = 6;
    private static final int INDEX_PSDCSYNCDATA2NAME = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_PSOBJID = 10;
    private static final int INDEX_PSOBJNAME = 11;
    private static final int INDEX_PSOBJTYPE = 12;
    private static final int INDEX_STATEINFO = 13;
    private static final int INDEX_SYNCAGENT = 14;
    private static final int INDEX_SYNCPARAM = 15;
    private static final int INDEX_SYNCPARAM2 = 16;
    private static final int INDEX_SYNCPARAM3 = 17;
    private static final int INDEX_SYNCPARAM4 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSyncData2Base proxyPSDCSyncData2Base = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean localpsobjidDirtyFlag = false;
    private boolean localpsobjnameDirtyFlag = false;
    private boolean localpsobjstateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsyncdata2idDirtyFlag = false;
    private boolean psdcsyncdata2nameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean stateinfoDirtyFlag = false;
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
    @Column(name="localpsobjid")
    private String localpsobjid;
    @Column(name="localpsobjname")
    private String localpsobjname;
    @Column(name="localpsobjstate")
    private Integer localpsobjstate;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsyncdata2id")
    private String psdcsyncdata2id;
    @Column(name="psdcsyncdata2name")
    private String psdcsyncdata2name;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="stateinfo")
    private String stateinfo;
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
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setLocalPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.localpsobjid = string;
        this.localpsobjidDirtyFlag = true;
    }

    public String getLocalPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalPSObjId();
        }
        return this.localpsobjid;
    }

    public boolean isLocalPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalPSObjIdDirty();
        }
        return this.localpsobjidDirtyFlag;
    }

    public void resetLocalPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalPSObjId();
            return;
        }
        this.localpsobjidDirtyFlag = false;
        this.localpsobjid = null;
    }

    public void setLocalPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.localpsobjname = string;
        this.localpsobjnameDirtyFlag = true;
    }

    public String getLocalPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalPSObjName();
        }
        return this.localpsobjname;
    }

    public boolean isLocalPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalPSObjNameDirty();
        }
        return this.localpsobjnameDirtyFlag;
    }

    public void resetLocalPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalPSObjName();
            return;
        }
        this.localpsobjnameDirtyFlag = false;
        this.localpsobjname = null;
    }

    public void setLocalPSObjState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalPSObjState(n);
            return;
        }
        this.localpsobjstate = n;
        this.localpsobjstateDirtyFlag = true;
    }

    public Integer getLocalPSObjState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalPSObjState();
        }
        return this.localpsobjstate;
    }

    public boolean isLocalPSObjStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalPSObjStateDirty();
        }
        return this.localpsobjstateDirtyFlag;
    }

    public void resetLocalPSObjState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalPSObjState();
            return;
        }
        this.localpsobjstateDirtyFlag = false;
        this.localpsobjstate = null;
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

    public void setPSDCSyncData2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncData2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdata2id = string;
        this.psdcsyncdata2idDirtyFlag = true;
    }

    public String getPSDCSyncData2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncData2Id();
        }
        return this.psdcsyncdata2id;
    }

    public boolean isPSDCSyncData2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncData2IdDirty();
        }
        return this.psdcsyncdata2idDirtyFlag;
    }

    public void resetPSDCSyncData2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncData2Id();
            return;
        }
        this.psdcsyncdata2idDirtyFlag = false;
        this.psdcsyncdata2id = null;
    }

    public void setPSDCSyncData2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncData2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdata2name = string;
        this.psdcsyncdata2nameDirtyFlag = true;
    }

    public String getPSDCSyncData2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncData2Name();
        }
        return this.psdcsyncdata2name;
    }

    public boolean isPSDCSyncData2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncData2NameDirty();
        }
        return this.psdcsyncdata2nameDirtyFlag;
    }

    public void resetPSDCSyncData2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncData2Name();
            return;
        }
        this.psdcsyncdata2nameDirtyFlag = false;
        this.psdcsyncdata2name = null;
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

    public void setStateInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stateinfo = string;
        this.stateinfoDirtyFlag = true;
    }

    public String getStateInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateInfo();
        }
        return this.stateinfo;
    }

    public boolean isStateInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateInfoDirty();
        }
        return this.stateinfoDirtyFlag;
    }

    public void resetStateInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateInfo();
            return;
        }
        this.stateinfoDirtyFlag = false;
        this.stateinfo = null;
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
        PSDCSyncData2Base.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSyncData2Base pSDCSyncData2Base) {
        pSDCSyncData2Base.resetCreateDate();
        pSDCSyncData2Base.resetCreateMan();
        pSDCSyncData2Base.resetLocalPSObjId();
        pSDCSyncData2Base.resetLocalPSObjName();
        pSDCSyncData2Base.resetLocalPSObjState();
        pSDCSyncData2Base.resetMemo();
        pSDCSyncData2Base.resetPSDCSyncData2Id();
        pSDCSyncData2Base.resetPSDCSyncData2Name();
        pSDCSyncData2Base.resetPSDevCenterId();
        pSDCSyncData2Base.resetPSDevCenterName();
        pSDCSyncData2Base.resetPSObjId();
        pSDCSyncData2Base.resetPSObjName();
        pSDCSyncData2Base.resetPSObjType();
        pSDCSyncData2Base.resetStateInfo();
        pSDCSyncData2Base.resetSyncAgent();
        pSDCSyncData2Base.resetSyncParam();
        pSDCSyncData2Base.resetSyncParam2();
        pSDCSyncData2Base.resetSyncParam3();
        pSDCSyncData2Base.resetSyncParam4();
        pSDCSyncData2Base.resetUpdateDate();
        pSDCSyncData2Base.resetUpdateMan();
        pSDCSyncData2Base.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLocalPSObjIdDirty()) {
            hashMap.put(FIELD_LOCALPSOBJID, this.getLocalPSObjId());
        }
        if (!bl || this.isLocalPSObjNameDirty()) {
            hashMap.put(FIELD_LOCALPSOBJNAME, this.getLocalPSObjName());
        }
        if (!bl || this.isLocalPSObjStateDirty()) {
            hashMap.put(FIELD_LOCALPSOBJSTATE, this.getLocalPSObjState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSyncData2IdDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATA2ID, this.getPSDCSyncData2Id());
        }
        if (!bl || this.isPSDCSyncData2NameDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATA2NAME, this.getPSDCSyncData2Name());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        if (!bl || this.isStateInfoDirty()) {
            hashMap.put(FIELD_STATEINFO, this.getStateInfo());
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
        return PSDCSyncData2Base.get(this, n);
    }

    private static Object get(PSDCSyncData2Base pSDCSyncData2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncData2Base.getCreateDate();
            }
            case 1: {
                return pSDCSyncData2Base.getCreateMan();
            }
            case 2: {
                return pSDCSyncData2Base.getLocalPSObjId();
            }
            case 3: {
                return pSDCSyncData2Base.getLocalPSObjName();
            }
            case 4: {
                return pSDCSyncData2Base.getLocalPSObjState();
            }
            case 5: {
                return pSDCSyncData2Base.getMemo();
            }
            case 6: {
                return pSDCSyncData2Base.getPSDCSyncData2Id();
            }
            case 7: {
                return pSDCSyncData2Base.getPSDCSyncData2Name();
            }
            case 8: {
                return pSDCSyncData2Base.getPSDevCenterId();
            }
            case 9: {
                return pSDCSyncData2Base.getPSDevCenterName();
            }
            case 10: {
                return pSDCSyncData2Base.getPSObjId();
            }
            case 11: {
                return pSDCSyncData2Base.getPSObjName();
            }
            case 12: {
                return pSDCSyncData2Base.getPSObjType();
            }
            case 13: {
                return pSDCSyncData2Base.getStateInfo();
            }
            case 14: {
                return pSDCSyncData2Base.getSyncAgent();
            }
            case 15: {
                return pSDCSyncData2Base.getSyncParam();
            }
            case 16: {
                return pSDCSyncData2Base.getSyncParam2();
            }
            case 17: {
                return pSDCSyncData2Base.getSyncParam3();
            }
            case 18: {
                return pSDCSyncData2Base.getSyncParam4();
            }
            case 19: {
                return pSDCSyncData2Base.getUpdateDate();
            }
            case 20: {
                return pSDCSyncData2Base.getUpdateMan();
            }
            case 21: {
                return pSDCSyncData2Base.getValidFlag();
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
        PSDCSyncData2Base.set(this, n, object);
    }

    private static void set(PSDCSyncData2Base pSDCSyncData2Base, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncData2Base.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSyncData2Base.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSyncData2Base.setLocalPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSyncData2Base.setLocalPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSyncData2Base.setLocalPSObjState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCSyncData2Base.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSyncData2Base.setPSDCSyncData2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSyncData2Base.setPSDCSyncData2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSyncData2Base.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSyncData2Base.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSyncData2Base.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSyncData2Base.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSyncData2Base.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSyncData2Base.setStateInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSyncData2Base.setSyncAgent(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCSyncData2Base.setSyncParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSyncData2Base.setSyncParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSyncData2Base.setSyncParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCSyncData2Base.setSyncParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSyncData2Base.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDCSyncData2Base.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCSyncData2Base.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCSyncData2Base.isNull(this, n);
    }

    private static boolean isNull(PSDCSyncData2Base pSDCSyncData2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncData2Base.getCreateDate() == null;
            }
            case 1: {
                return pSDCSyncData2Base.getCreateMan() == null;
            }
            case 2: {
                return pSDCSyncData2Base.getLocalPSObjId() == null;
            }
            case 3: {
                return pSDCSyncData2Base.getLocalPSObjName() == null;
            }
            case 4: {
                return pSDCSyncData2Base.getLocalPSObjState() == null;
            }
            case 5: {
                return pSDCSyncData2Base.getMemo() == null;
            }
            case 6: {
                return pSDCSyncData2Base.getPSDCSyncData2Id() == null;
            }
            case 7: {
                return pSDCSyncData2Base.getPSDCSyncData2Name() == null;
            }
            case 8: {
                return pSDCSyncData2Base.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCSyncData2Base.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCSyncData2Base.getPSObjId() == null;
            }
            case 11: {
                return pSDCSyncData2Base.getPSObjName() == null;
            }
            case 12: {
                return pSDCSyncData2Base.getPSObjType() == null;
            }
            case 13: {
                return pSDCSyncData2Base.getStateInfo() == null;
            }
            case 14: {
                return pSDCSyncData2Base.getSyncAgent() == null;
            }
            case 15: {
                return pSDCSyncData2Base.getSyncParam() == null;
            }
            case 16: {
                return pSDCSyncData2Base.getSyncParam2() == null;
            }
            case 17: {
                return pSDCSyncData2Base.getSyncParam3() == null;
            }
            case 18: {
                return pSDCSyncData2Base.getSyncParam4() == null;
            }
            case 19: {
                return pSDCSyncData2Base.getUpdateDate() == null;
            }
            case 20: {
                return pSDCSyncData2Base.getUpdateMan() == null;
            }
            case 21: {
                return pSDCSyncData2Base.getValidFlag() == null;
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
        return PSDCSyncData2Base.contains(this, n);
    }

    private static boolean contains(PSDCSyncData2Base pSDCSyncData2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncData2Base.isCreateDateDirty();
            }
            case 1: {
                return pSDCSyncData2Base.isCreateManDirty();
            }
            case 2: {
                return pSDCSyncData2Base.isLocalPSObjIdDirty();
            }
            case 3: {
                return pSDCSyncData2Base.isLocalPSObjNameDirty();
            }
            case 4: {
                return pSDCSyncData2Base.isLocalPSObjStateDirty();
            }
            case 5: {
                return pSDCSyncData2Base.isMemoDirty();
            }
            case 6: {
                return pSDCSyncData2Base.isPSDCSyncData2IdDirty();
            }
            case 7: {
                return pSDCSyncData2Base.isPSDCSyncData2NameDirty();
            }
            case 8: {
                return pSDCSyncData2Base.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCSyncData2Base.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCSyncData2Base.isPSObjIdDirty();
            }
            case 11: {
                return pSDCSyncData2Base.isPSObjNameDirty();
            }
            case 12: {
                return pSDCSyncData2Base.isPSObjTypeDirty();
            }
            case 13: {
                return pSDCSyncData2Base.isStateInfoDirty();
            }
            case 14: {
                return pSDCSyncData2Base.isSyncAgentDirty();
            }
            case 15: {
                return pSDCSyncData2Base.isSyncParamDirty();
            }
            case 16: {
                return pSDCSyncData2Base.isSyncParam2Dirty();
            }
            case 17: {
                return pSDCSyncData2Base.isSyncParam3Dirty();
            }
            case 18: {
                return pSDCSyncData2Base.isSyncParam4Dirty();
            }
            case 19: {
                return pSDCSyncData2Base.isUpdateDateDirty();
            }
            case 20: {
                return pSDCSyncData2Base.isUpdateManDirty();
            }
            case 21: {
                return pSDCSyncData2Base.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSyncData2Base.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSyncData2Base pSDCSyncData2Base, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSyncData2Base.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localpsobjid", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getLocalPSObjId()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localpsobjname", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getLocalPSObjName()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localpsobjstate", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getLocalPSObjState()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getMemo()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSDCSyncData2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdata2id", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSDCSyncData2Id()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSDCSyncData2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdata2name", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSDCSyncData2Name()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSObjId()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSObjName()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getPSObjType()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getStateInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stateinfo", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getStateInfo()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getSyncAgent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncagent", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getSyncAgent()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getSyncParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getSyncParam()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getSyncParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam2", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getSyncParam2()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getSyncParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam3", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getSyncParam3()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getSyncParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam4", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getSyncParam4()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSyncData2Base.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCSyncData2Base.getJSONValue((Object)pSDCSyncData2Base.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSyncData2Base.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSyncData2Base pSDCSyncData2Base, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSyncData2Base.getCreateDate() != null) {
            object = pSDCSyncData2Base.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncData2Base.getCreateMan() != null) {
            object = pSDCSyncData2Base.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjId() != null) {
            object = pSDCSyncData2Base.getLocalPSObjId();
            xmlNode.setAttribute(FIELD_LOCALPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjName() != null) {
            object = pSDCSyncData2Base.getLocalPSObjName();
            xmlNode.setAttribute(FIELD_LOCALPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getLocalPSObjState() != null) {
            object = pSDCSyncData2Base.getLocalPSObjState();
            xmlNode.setAttribute(FIELD_LOCALPSOBJSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSyncData2Base.getMemo() != null) {
            object = pSDCSyncData2Base.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSDCSyncData2Id() != null) {
            object = pSDCSyncData2Base.getPSDCSyncData2Id();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATA2ID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSDCSyncData2Name() != null) {
            object = pSDCSyncData2Base.getPSDCSyncData2Name();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATA2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSDevCenterId() != null) {
            object = pSDCSyncData2Base.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSDevCenterName() != null) {
            object = pSDCSyncData2Base.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSObjId() != null) {
            object = pSDCSyncData2Base.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSObjName() != null) {
            object = pSDCSyncData2Base.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getPSObjType() != null) {
            object = pSDCSyncData2Base.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getStateInfo() != null) {
            object = pSDCSyncData2Base.getStateInfo();
            xmlNode.setAttribute(FIELD_STATEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getSyncAgent() != null) {
            object = pSDCSyncData2Base.getSyncAgent();
            xmlNode.setAttribute(FIELD_SYNCAGENT, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getSyncParam() != null) {
            object = pSDCSyncData2Base.getSyncParam();
            xmlNode.setAttribute(FIELD_SYNCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getSyncParam2() != null) {
            object = pSDCSyncData2Base.getSyncParam2();
            xmlNode.setAttribute(FIELD_SYNCPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getSyncParam3() != null) {
            object = pSDCSyncData2Base.getSyncParam3();
            xmlNode.setAttribute(FIELD_SYNCPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getSyncParam4() != null) {
            object = pSDCSyncData2Base.getSyncParam4();
            xmlNode.setAttribute(FIELD_SYNCPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getUpdateDate() != null) {
            object = pSDCSyncData2Base.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncData2Base.getUpdateMan() != null) {
            object = pSDCSyncData2Base.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncData2Base.getValidFlag() != null) {
            object = pSDCSyncData2Base.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSyncData2Base.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSyncData2Base pSDCSyncData2Base, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSyncData2Base.isCreateDateDirty() && (bl || pSDCSyncData2Base.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSyncData2Base.getCreateDate());
        }
        if (pSDCSyncData2Base.isCreateManDirty() && (bl || pSDCSyncData2Base.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSyncData2Base.getCreateMan());
        }
        if (pSDCSyncData2Base.isLocalPSObjIdDirty() && (bl || pSDCSyncData2Base.getLocalPSObjId() != null)) {
            iDataObject.set(FIELD_LOCALPSOBJID, (Object)pSDCSyncData2Base.getLocalPSObjId());
        }
        if (pSDCSyncData2Base.isLocalPSObjNameDirty() && (bl || pSDCSyncData2Base.getLocalPSObjName() != null)) {
            iDataObject.set(FIELD_LOCALPSOBJNAME, (Object)pSDCSyncData2Base.getLocalPSObjName());
        }
        if (pSDCSyncData2Base.isLocalPSObjStateDirty() && (bl || pSDCSyncData2Base.getLocalPSObjState() != null)) {
            iDataObject.set(FIELD_LOCALPSOBJSTATE, (Object)pSDCSyncData2Base.getLocalPSObjState());
        }
        if (pSDCSyncData2Base.isMemoDirty() && (bl || pSDCSyncData2Base.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSyncData2Base.getMemo());
        }
        if (pSDCSyncData2Base.isPSDCSyncData2IdDirty() && (bl || pSDCSyncData2Base.getPSDCSyncData2Id() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATA2ID, (Object)pSDCSyncData2Base.getPSDCSyncData2Id());
        }
        if (pSDCSyncData2Base.isPSDCSyncData2NameDirty() && (bl || pSDCSyncData2Base.getPSDCSyncData2Name() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATA2NAME, (Object)pSDCSyncData2Base.getPSDCSyncData2Name());
        }
        if (pSDCSyncData2Base.isPSDevCenterIdDirty() && (bl || pSDCSyncData2Base.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSyncData2Base.getPSDevCenterId());
        }
        if (pSDCSyncData2Base.isPSDevCenterNameDirty() && (bl || pSDCSyncData2Base.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSyncData2Base.getPSDevCenterName());
        }
        if (pSDCSyncData2Base.isPSObjIdDirty() && (bl || pSDCSyncData2Base.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDCSyncData2Base.getPSObjId());
        }
        if (pSDCSyncData2Base.isPSObjNameDirty() && (bl || pSDCSyncData2Base.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDCSyncData2Base.getPSObjName());
        }
        if (pSDCSyncData2Base.isPSObjTypeDirty() && (bl || pSDCSyncData2Base.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSDCSyncData2Base.getPSObjType());
        }
        if (pSDCSyncData2Base.isStateInfoDirty() && (bl || pSDCSyncData2Base.getStateInfo() != null)) {
            iDataObject.set(FIELD_STATEINFO, (Object)pSDCSyncData2Base.getStateInfo());
        }
        if (pSDCSyncData2Base.isSyncAgentDirty() && (bl || pSDCSyncData2Base.getSyncAgent() != null)) {
            iDataObject.set(FIELD_SYNCAGENT, (Object)pSDCSyncData2Base.getSyncAgent());
        }
        if (pSDCSyncData2Base.isSyncParamDirty() && (bl || pSDCSyncData2Base.getSyncParam() != null)) {
            iDataObject.set(FIELD_SYNCPARAM, (Object)pSDCSyncData2Base.getSyncParam());
        }
        if (pSDCSyncData2Base.isSyncParam2Dirty() && (bl || pSDCSyncData2Base.getSyncParam2() != null)) {
            iDataObject.set(FIELD_SYNCPARAM2, (Object)pSDCSyncData2Base.getSyncParam2());
        }
        if (pSDCSyncData2Base.isSyncParam3Dirty() && (bl || pSDCSyncData2Base.getSyncParam3() != null)) {
            iDataObject.set(FIELD_SYNCPARAM3, (Object)pSDCSyncData2Base.getSyncParam3());
        }
        if (pSDCSyncData2Base.isSyncParam4Dirty() && (bl || pSDCSyncData2Base.getSyncParam4() != null)) {
            iDataObject.set(FIELD_SYNCPARAM4, (Object)pSDCSyncData2Base.getSyncParam4());
        }
        if (pSDCSyncData2Base.isUpdateDateDirty() && (bl || pSDCSyncData2Base.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSyncData2Base.getUpdateDate());
        }
        if (pSDCSyncData2Base.isUpdateManDirty() && (bl || pSDCSyncData2Base.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSyncData2Base.getUpdateMan());
        }
        if (pSDCSyncData2Base.isValidFlagDirty() && (bl || pSDCSyncData2Base.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCSyncData2Base.getValidFlag());
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
        return PSDCSyncData2Base.remove(this, n);
    }

    private static boolean remove(PSDCSyncData2Base pSDCSyncData2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncData2Base.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSyncData2Base.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSyncData2Base.resetLocalPSObjId();
                return true;
            }
            case 3: {
                pSDCSyncData2Base.resetLocalPSObjName();
                return true;
            }
            case 4: {
                pSDCSyncData2Base.resetLocalPSObjState();
                return true;
            }
            case 5: {
                pSDCSyncData2Base.resetMemo();
                return true;
            }
            case 6: {
                pSDCSyncData2Base.resetPSDCSyncData2Id();
                return true;
            }
            case 7: {
                pSDCSyncData2Base.resetPSDCSyncData2Name();
                return true;
            }
            case 8: {
                pSDCSyncData2Base.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCSyncData2Base.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCSyncData2Base.resetPSObjId();
                return true;
            }
            case 11: {
                pSDCSyncData2Base.resetPSObjName();
                return true;
            }
            case 12: {
                pSDCSyncData2Base.resetPSObjType();
                return true;
            }
            case 13: {
                pSDCSyncData2Base.resetStateInfo();
                return true;
            }
            case 14: {
                pSDCSyncData2Base.resetSyncAgent();
                return true;
            }
            case 15: {
                pSDCSyncData2Base.resetSyncParam();
                return true;
            }
            case 16: {
                pSDCSyncData2Base.resetSyncParam2();
                return true;
            }
            case 17: {
                pSDCSyncData2Base.resetSyncParam3();
                return true;
            }
            case 18: {
                pSDCSyncData2Base.resetSyncParam4();
                return true;
            }
            case 19: {
                pSDCSyncData2Base.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDCSyncData2Base.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDCSyncData2Base.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCSyncData2Base getProxyEntity() {
        return this.proxyPSDCSyncData2Base;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSyncData2Base = null;
        if (iDataObject != null && iDataObject instanceof PSDCSyncData2Base) {
            this.proxyPSDCSyncData2Base = (PSDCSyncData2Base)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSyncData2Service", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOCALPSOBJID, 2);
        fieldIndexMap.put(FIELD_LOCALPSOBJNAME, 3);
        fieldIndexMap.put(FIELD_LOCALPSOBJSTATE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCSYNCDATA2ID, 6);
        fieldIndexMap.put(FIELD_PSDCSYNCDATA2NAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_PSOBJID, 10);
        fieldIndexMap.put(FIELD_PSOBJNAME, 11);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 12);
        fieldIndexMap.put(FIELD_STATEINFO, 13);
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

