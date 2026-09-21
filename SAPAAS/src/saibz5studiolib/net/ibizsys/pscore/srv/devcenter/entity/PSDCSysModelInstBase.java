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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysModelInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysModelInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURDBACTION = "CURDBACTION";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYSMODELINSTID = "PSDCSYSMODELINSTID";
    public static final String FIELD_PSDCSYSMODELINSTNAME = "PSDCSYSMODELINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURDBACTION = 2;
    private static final int INDEX_EXPRIEDTIME = 3;
    private static final int INDEX_INSTSTATE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCSYSMODELINSTID = 6;
    private static final int INDEX_PSDCSYSMODELINSTNAME = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_PSDEVSLNID = 10;
    private static final int INDEX_PSDEVSLNNAME = 11;
    private static final int INDEX_PSSYSMODELINSTID = 12;
    private static final int INDEX_PSSYSMODELINSTNAME = 13;
    private static final int INDEX_REFOBJID = 14;
    private static final int INDEX_REFOBJNAME = 15;
    private static final int INDEX_REFOBJTYPE = 16;
    private static final int INDEX_RESREADYTIME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysModelInstBase proxyPSDCSysModelInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curdbactionDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsysmodelinstidDirtyFlag = false;
    private boolean psdcsysmodelinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curdbaction")
    private String curdbaction;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsysmodelinstid")
    private String psdcsysmodelinstid;
    @Column(name="psdcsysmodelinstname")
    private String psdcsysmodelinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

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

    public void setCurDBAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurDBAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curdbaction = string;
        this.curdbactionDirtyFlag = true;
    }

    public String getCurDBAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurDBAction();
        }
        return this.curdbaction;
    }

    public boolean isCurDBActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurDBActionDirty();
        }
        return this.curdbactionDirtyFlag;
    }

    public void resetCurDBAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurDBAction();
            return;
        }
        this.curdbactionDirtyFlag = false;
        this.curdbaction = null;
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

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
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

    public void setPSDCSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelinstid = string;
        this.psdcsysmodelinstidDirtyFlag = true;
    }

    public String getPSDCSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelInstId();
        }
        return this.psdcsysmodelinstid;
    }

    public boolean isPSDCSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelInstIdDirty();
        }
        return this.psdcsysmodelinstidDirtyFlag;
    }

    public void resetPSDCSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelInstId();
            return;
        }
        this.psdcsysmodelinstidDirtyFlag = false;
        this.psdcsysmodelinstid = null;
    }

    public void setPSDCSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelinstname = string;
        this.psdcsysmodelinstnameDirtyFlag = true;
    }

    public String getPSDCSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelInstName();
        }
        return this.psdcsysmodelinstname;
    }

    public boolean isPSDCSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelInstNameDirty();
        }
        return this.psdcsysmodelinstnameDirtyFlag;
    }

    public void resetPSDCSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelInstName();
            return;
        }
        this.psdcsysmodelinstnameDirtyFlag = false;
        this.psdcsysmodelinstname = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
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

    protected void onReset() {
        PSDCSysModelInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysModelInstBase pSDCSysModelInstBase) {
        pSDCSysModelInstBase.resetCreateDate();
        pSDCSysModelInstBase.resetCreateMan();
        pSDCSysModelInstBase.resetCurDBAction();
        pSDCSysModelInstBase.resetExpriedTime();
        pSDCSysModelInstBase.resetInstState();
        pSDCSysModelInstBase.resetMemo();
        pSDCSysModelInstBase.resetPSDCSysModelInstId();
        pSDCSysModelInstBase.resetPSDCSysModelInstName();
        pSDCSysModelInstBase.resetPSDevCenterId();
        pSDCSysModelInstBase.resetPSDevCenterName();
        pSDCSysModelInstBase.resetPSDevSlnId();
        pSDCSysModelInstBase.resetPSDevSlnName();
        pSDCSysModelInstBase.resetPSSysModelInstId();
        pSDCSysModelInstBase.resetPSSysModelInstName();
        pSDCSysModelInstBase.resetRefObjId();
        pSDCSysModelInstBase.resetRefObjName();
        pSDCSysModelInstBase.resetRefObjType();
        pSDCSysModelInstBase.resetResReadyTime();
        pSDCSysModelInstBase.resetUpdateDate();
        pSDCSysModelInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurDBActionDirty()) {
            hashMap.put(FIELD_CURDBACTION, this.getCurDBAction());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELINSTID, this.getPSDCSysModelInstId());
        }
        if (!bl || this.isPSDCSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELINSTNAME, this.getPSDCSysModelInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCSysModelInstBase.get(this, n);
    }

    private static Object get(PSDCSysModelInstBase pSDCSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelInstBase.getCreateDate();
            }
            case 1: {
                return pSDCSysModelInstBase.getCreateMan();
            }
            case 2: {
                return pSDCSysModelInstBase.getCurDBAction();
            }
            case 3: {
                return pSDCSysModelInstBase.getExpriedTime();
            }
            case 4: {
                return pSDCSysModelInstBase.getInstState();
            }
            case 5: {
                return pSDCSysModelInstBase.getMemo();
            }
            case 6: {
                return pSDCSysModelInstBase.getPSDCSysModelInstId();
            }
            case 7: {
                return pSDCSysModelInstBase.getPSDCSysModelInstName();
            }
            case 8: {
                return pSDCSysModelInstBase.getPSDevCenterId();
            }
            case 9: {
                return pSDCSysModelInstBase.getPSDevCenterName();
            }
            case 10: {
                return pSDCSysModelInstBase.getPSDevSlnId();
            }
            case 11: {
                return pSDCSysModelInstBase.getPSDevSlnName();
            }
            case 12: {
                return pSDCSysModelInstBase.getPSSysModelInstId();
            }
            case 13: {
                return pSDCSysModelInstBase.getPSSysModelInstName();
            }
            case 14: {
                return pSDCSysModelInstBase.getRefObjId();
            }
            case 15: {
                return pSDCSysModelInstBase.getRefObjName();
            }
            case 16: {
                return pSDCSysModelInstBase.getRefObjType();
            }
            case 17: {
                return pSDCSysModelInstBase.getResReadyTime();
            }
            case 18: {
                return pSDCSysModelInstBase.getUpdateDate();
            }
            case 19: {
                return pSDCSysModelInstBase.getUpdateMan();
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
        PSDCSysModelInstBase.set(this, n, object);
    }

    private static void set(PSDCSysModelInstBase pSDCSysModelInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysModelInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysModelInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysModelInstBase.setCurDBAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysModelInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysModelInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysModelInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysModelInstBase.setPSDCSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysModelInstBase.setPSDCSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysModelInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysModelInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysModelInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysModelInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSysModelInstBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSysModelInstBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSysModelInstBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCSysModelInstBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSysModelInstBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSysModelInstBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDCSysModelInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDCSysModelInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysModelInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysModelInstBase pSDCSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSysModelInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSysModelInstBase.getCurDBAction() == null;
            }
            case 3: {
                return pSDCSysModelInstBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDCSysModelInstBase.getInstState() == null;
            }
            case 5: {
                return pSDCSysModelInstBase.getMemo() == null;
            }
            case 6: {
                return pSDCSysModelInstBase.getPSDCSysModelInstId() == null;
            }
            case 7: {
                return pSDCSysModelInstBase.getPSDCSysModelInstName() == null;
            }
            case 8: {
                return pSDCSysModelInstBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCSysModelInstBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCSysModelInstBase.getPSDevSlnId() == null;
            }
            case 11: {
                return pSDCSysModelInstBase.getPSDevSlnName() == null;
            }
            case 12: {
                return pSDCSysModelInstBase.getPSSysModelInstId() == null;
            }
            case 13: {
                return pSDCSysModelInstBase.getPSSysModelInstName() == null;
            }
            case 14: {
                return pSDCSysModelInstBase.getRefObjId() == null;
            }
            case 15: {
                return pSDCSysModelInstBase.getRefObjName() == null;
            }
            case 16: {
                return pSDCSysModelInstBase.getRefObjType() == null;
            }
            case 17: {
                return pSDCSysModelInstBase.getResReadyTime() == null;
            }
            case 18: {
                return pSDCSysModelInstBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDCSysModelInstBase.getUpdateMan() == null;
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
        return PSDCSysModelInstBase.contains(this, n);
    }

    private static boolean contains(PSDCSysModelInstBase pSDCSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSysModelInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSysModelInstBase.isCurDBActionDirty();
            }
            case 3: {
                return pSDCSysModelInstBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDCSysModelInstBase.isInstStateDirty();
            }
            case 5: {
                return pSDCSysModelInstBase.isMemoDirty();
            }
            case 6: {
                return pSDCSysModelInstBase.isPSDCSysModelInstIdDirty();
            }
            case 7: {
                return pSDCSysModelInstBase.isPSDCSysModelInstNameDirty();
            }
            case 8: {
                return pSDCSysModelInstBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCSysModelInstBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCSysModelInstBase.isPSDevSlnIdDirty();
            }
            case 11: {
                return pSDCSysModelInstBase.isPSDevSlnNameDirty();
            }
            case 12: {
                return pSDCSysModelInstBase.isPSSysModelInstIdDirty();
            }
            case 13: {
                return pSDCSysModelInstBase.isPSSysModelInstNameDirty();
            }
            case 14: {
                return pSDCSysModelInstBase.isRefObjIdDirty();
            }
            case 15: {
                return pSDCSysModelInstBase.isRefObjNameDirty();
            }
            case 16: {
                return pSDCSysModelInstBase.isRefObjTypeDirty();
            }
            case 17: {
                return pSDCSysModelInstBase.isResReadyTimeDirty();
            }
            case 18: {
                return pSDCSysModelInstBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDCSysModelInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysModelInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysModelInstBase pSDCSysModelInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysModelInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getCurDBAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curdbaction", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getCurDBAction()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDCSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelinstid", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDCSysModelInstId()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDCSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelinstname", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDCSysModelInstName()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysModelInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysModelInstBase.getJSONValue((Object)pSDCSysModelInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysModelInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysModelInstBase pSDCSysModelInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysModelInstBase.getCreateDate() != null) {
            object = pSDCSysModelInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelInstBase.getCreateMan() != null) {
            object = pSDCSysModelInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getCurDBAction() != null) {
            object = pSDCSysModelInstBase.getCurDBAction();
            xmlNode.setAttribute(FIELD_CURDBACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getExpriedTime() != null) {
            object = pSDCSysModelInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelInstBase.getInstState() != null) {
            object = pSDCSysModelInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysModelInstBase.getMemo() != null) {
            object = pSDCSysModelInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDCSysModelInstId() != null) {
            object = pSDCSysModelInstBase.getPSDCSysModelInstId();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDCSysModelInstName() != null) {
            object = pSDCSysModelInstBase.getPSDCSysModelInstName();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDevCenterId() != null) {
            object = pSDCSysModelInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDevCenterName() != null) {
            object = pSDCSysModelInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDevSlnId() != null) {
            object = pSDCSysModelInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSDevSlnName() != null) {
            object = pSDCSysModelInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSSysModelInstId() != null) {
            object = pSDCSysModelInstBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getPSSysModelInstName() != null) {
            object = pSDCSysModelInstBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getRefObjId() != null) {
            object = pSDCSysModelInstBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getRefObjName() != null) {
            object = pSDCSysModelInstBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getRefObjType() != null) {
            object = pSDCSysModelInstBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelInstBase.getResReadyTime() != null) {
            object = pSDCSysModelInstBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelInstBase.getUpdateDate() != null) {
            object = pSDCSysModelInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelInstBase.getUpdateMan() != null) {
            object = pSDCSysModelInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysModelInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysModelInstBase pSDCSysModelInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysModelInstBase.isCreateDateDirty() && (bl || pSDCSysModelInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysModelInstBase.getCreateDate());
        }
        if (pSDCSysModelInstBase.isCreateManDirty() && (bl || pSDCSysModelInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysModelInstBase.getCreateMan());
        }
        if (pSDCSysModelInstBase.isCurDBActionDirty() && (bl || pSDCSysModelInstBase.getCurDBAction() != null)) {
            iDataObject.set(FIELD_CURDBACTION, (Object)pSDCSysModelInstBase.getCurDBAction());
        }
        if (pSDCSysModelInstBase.isExpriedTimeDirty() && (bl || pSDCSysModelInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCSysModelInstBase.getExpriedTime());
        }
        if (pSDCSysModelInstBase.isInstStateDirty() && (bl || pSDCSysModelInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSDCSysModelInstBase.getInstState());
        }
        if (pSDCSysModelInstBase.isMemoDirty() && (bl || pSDCSysModelInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSysModelInstBase.getMemo());
        }
        if (pSDCSysModelInstBase.isPSDCSysModelInstIdDirty() && (bl || pSDCSysModelInstBase.getPSDCSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELINSTID, (Object)pSDCSysModelInstBase.getPSDCSysModelInstId());
        }
        if (pSDCSysModelInstBase.isPSDCSysModelInstNameDirty() && (bl || pSDCSysModelInstBase.getPSDCSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELINSTNAME, (Object)pSDCSysModelInstBase.getPSDCSysModelInstName());
        }
        if (pSDCSysModelInstBase.isPSDevCenterIdDirty() && (bl || pSDCSysModelInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSysModelInstBase.getPSDevCenterId());
        }
        if (pSDCSysModelInstBase.isPSDevCenterNameDirty() && (bl || pSDCSysModelInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSysModelInstBase.getPSDevCenterName());
        }
        if (pSDCSysModelInstBase.isPSDevSlnIdDirty() && (bl || pSDCSysModelInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCSysModelInstBase.getPSDevSlnId());
        }
        if (pSDCSysModelInstBase.isPSDevSlnNameDirty() && (bl || pSDCSysModelInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCSysModelInstBase.getPSDevSlnName());
        }
        if (pSDCSysModelInstBase.isPSSysModelInstIdDirty() && (bl || pSDCSysModelInstBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDCSysModelInstBase.getPSSysModelInstId());
        }
        if (pSDCSysModelInstBase.isPSSysModelInstNameDirty() && (bl || pSDCSysModelInstBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDCSysModelInstBase.getPSSysModelInstName());
        }
        if (pSDCSysModelInstBase.isRefObjIdDirty() && (bl || pSDCSysModelInstBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDCSysModelInstBase.getRefObjId());
        }
        if (pSDCSysModelInstBase.isRefObjNameDirty() && (bl || pSDCSysModelInstBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDCSysModelInstBase.getRefObjName());
        }
        if (pSDCSysModelInstBase.isRefObjTypeDirty() && (bl || pSDCSysModelInstBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSDCSysModelInstBase.getRefObjType());
        }
        if (pSDCSysModelInstBase.isResReadyTimeDirty() && (bl || pSDCSysModelInstBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCSysModelInstBase.getResReadyTime());
        }
        if (pSDCSysModelInstBase.isUpdateDateDirty() && (bl || pSDCSysModelInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysModelInstBase.getUpdateDate());
        }
        if (pSDCSysModelInstBase.isUpdateManDirty() && (bl || pSDCSysModelInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysModelInstBase.getUpdateMan());
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
        return PSDCSysModelInstBase.remove(this, n);
    }

    private static boolean remove(PSDCSysModelInstBase pSDCSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysModelInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSysModelInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSysModelInstBase.resetCurDBAction();
                return true;
            }
            case 3: {
                pSDCSysModelInstBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDCSysModelInstBase.resetInstState();
                return true;
            }
            case 5: {
                pSDCSysModelInstBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCSysModelInstBase.resetPSDCSysModelInstId();
                return true;
            }
            case 7: {
                pSDCSysModelInstBase.resetPSDCSysModelInstName();
                return true;
            }
            case 8: {
                pSDCSysModelInstBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCSysModelInstBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCSysModelInstBase.resetPSDevSlnId();
                return true;
            }
            case 11: {
                pSDCSysModelInstBase.resetPSDevSlnName();
                return true;
            }
            case 12: {
                pSDCSysModelInstBase.resetPSSysModelInstId();
                return true;
            }
            case 13: {
                pSDCSysModelInstBase.resetPSSysModelInstName();
                return true;
            }
            case 14: {
                pSDCSysModelInstBase.resetRefObjId();
                return true;
            }
            case 15: {
                pSDCSysModelInstBase.resetRefObjName();
                return true;
            }
            case 16: {
                pSDCSysModelInstBase.resetRefObjType();
                return true;
            }
            case 17: {
                pSDCSysModelInstBase.resetResReadyTime();
                return true;
            }
            case 18: {
                pSDCSysModelInstBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDCSysModelInstBase.resetUpdateMan();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    private PSDCSysModelInstBase getProxyEntity() {
        return this.proxyPSDCSysModelInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysModelInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysModelInstBase) {
            this.proxyPSDCSysModelInstBase = (PSDCSysModelInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURDBACTION, 2);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 3);
        fieldIndexMap.put(FIELD_INSTSTATE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCSYSMODELINSTID, 6);
        fieldIndexMap.put(FIELD_PSDCSYSMODELINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 13);
        fieldIndexMap.put(FIELD_REFOBJID, 14);
        fieldIndexMap.put(FIELD_REFOBJNAME, 15);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 16);
        fieldIndexMap.put(FIELD_RESREADYTIME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

