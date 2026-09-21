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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysInstActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysInstActionBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String FIELD_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_LASTPSDEVSLNSYSID = "LASTPSDEVSLNSYSID";
    public static final String FIELD_LASTPSDEVSLNSYSNAME = "LASTPSDEVSLNSYSNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYSINSTACTIONID = "PSDCSYSINSTACTIONID";
    public static final String FIELD_PSDCSYSINSTACTIONNAME = "PSDCSYSINSTACTIONNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONPARAM = 0;
    private static final int INDEX_ACTIONPARAM2 = 1;
    private static final int INDEX_ACTIONPARAM3 = 2;
    private static final int INDEX_ACTIONPARAM4 = 3;
    private static final int INDEX_ACTIONPARAM5 = 4;
    private static final int INDEX_ACTIONPARAM6 = 5;
    private static final int INDEX_ACTIONSTATE = 6;
    private static final int INDEX_ACTIONTYPE = 7;
    private static final int INDEX_BEGINTIME = 8;
    private static final int INDEX_CREATEDATE = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_ENDTIME = 11;
    private static final int INDEX_LASTPSDEVSLNSYSID = 12;
    private static final int INDEX_LASTPSDEVSLNSYSNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_PSDCSYSINSTACTIONID = 15;
    private static final int INDEX_PSDCSYSINSTACTIONNAME = 16;
    private static final int INDEX_PSDEVCENTERID = 17;
    private static final int INDEX_PSDEVCENTERNAME = 18;
    private static final int INDEX_PSDEVSLNID = 19;
    private static final int INDEX_PSDEVSLNNAME = 20;
    private static final int INDEX_PSDEVSLNSYSID = 21;
    private static final int INDEX_PSDEVSLNSYSNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysInstActionBase proxyPSDCSysInstActionBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionparam5DirtyFlag = false;
    private boolean actionparam6DirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean lastpsdevslnsysidDirtyFlag = false;
    private boolean lastpsdevslnsysnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsysinstactionidDirtyFlag = false;
    private boolean psdcsysinstactionnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="actionparam2")
    private String actionparam2;
    @Column(name="actionparam3")
    private String actionparam3;
    @Column(name="actionparam4")
    private String actionparam4;
    @Column(name="actionparam5")
    private Integer actionparam5;
    @Column(name="actionparam6")
    private Integer actionparam6;
    @Column(name="actionstate")
    private Integer actionstate;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="lastpsdevslnsysid")
    private String lastpsdevslnsysid;
    @Column(name="lastpsdevslnsysname")
    private String lastpsdevslnsysname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsysinstactionid")
    private String psdcsysinstactionid;
    @Column(name="psdcsysinstactionname")
    private String psdcsysinstactionname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objLastPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys lastpsdevslnsys = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam = string;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
    }

    public void setActionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam2 = string;
        this.actionparam2DirtyFlag = true;
    }

    public String getActionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam2();
        }
        return this.actionparam2;
    }

    public boolean isActionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam2Dirty();
        }
        return this.actionparam2DirtyFlag;
    }

    public void resetActionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam2();
            return;
        }
        this.actionparam2DirtyFlag = false;
        this.actionparam2 = null;
    }

    public void setActionParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam3 = string;
        this.actionparam3DirtyFlag = true;
    }

    public String getActionParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam3();
        }
        return this.actionparam3;
    }

    public boolean isActionParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam3Dirty();
        }
        return this.actionparam3DirtyFlag;
    }

    public void resetActionParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam3();
            return;
        }
        this.actionparam3DirtyFlag = false;
        this.actionparam3 = null;
    }

    public void setActionParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam4 = string;
        this.actionparam4DirtyFlag = true;
    }

    public String getActionParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam4();
        }
        return this.actionparam4;
    }

    public boolean isActionParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam4Dirty();
        }
        return this.actionparam4DirtyFlag;
    }

    public void resetActionParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam4();
            return;
        }
        this.actionparam4DirtyFlag = false;
        this.actionparam4 = null;
    }

    public void setActionParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam5(n);
            return;
        }
        this.actionparam5 = n;
        this.actionparam5DirtyFlag = true;
    }

    public Integer getActionParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam5();
        }
        return this.actionparam5;
    }

    public boolean isActionParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam5Dirty();
        }
        return this.actionparam5DirtyFlag;
    }

    public void resetActionParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam5();
            return;
        }
        this.actionparam5DirtyFlag = false;
        this.actionparam5 = null;
    }

    public void setActionParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam6(n);
            return;
        }
        this.actionparam6 = n;
        this.actionparam6DirtyFlag = true;
    }

    public Integer getActionParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam6();
        }
        return this.actionparam6;
    }

    public boolean isActionParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam6Dirty();
        }
        return this.actionparam6DirtyFlag;
    }

    public void resetActionParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam6();
            return;
        }
        this.actionparam6DirtyFlag = false;
        this.actionparam6 = null;
    }

    public void setActionState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionState(n);
            return;
        }
        this.actionstate = n;
        this.actionstateDirtyFlag = true;
    }

    public Integer getActionState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionState();
        }
        return this.actionstate;
    }

    public boolean isActionStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionStateDirty();
        }
        return this.actionstateDirtyFlag;
    }

    public void resetActionState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionState();
            return;
        }
        this.actionstateDirtyFlag = false;
        this.actionstate = null;
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

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setLastPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lastpsdevslnsysid = string;
        this.lastpsdevslnsysidDirtyFlag = true;
    }

    public String getLastPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastPSDevSlnSysId();
        }
        return this.lastpsdevslnsysid;
    }

    public boolean isLastPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastPSDevSlnSysIdDirty();
        }
        return this.lastpsdevslnsysidDirtyFlag;
    }

    public void resetLastPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastPSDevSlnSysId();
            return;
        }
        this.lastpsdevslnsysidDirtyFlag = false;
        this.lastpsdevslnsysid = null;
    }

    public void setLastPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lastpsdevslnsysname = string;
        this.lastpsdevslnsysnameDirtyFlag = true;
    }

    public String getLastPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastPSDevSlnSysName();
        }
        return this.lastpsdevslnsysname;
    }

    public boolean isLastPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastPSDevSlnSysNameDirty();
        }
        return this.lastpsdevslnsysnameDirtyFlag;
    }

    public void resetLastPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastPSDevSlnSysName();
            return;
        }
        this.lastpsdevslnsysnameDirtyFlag = false;
        this.lastpsdevslnsysname = null;
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

    public void setPSDCSysInstActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysInstActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysinstactionid = string;
        this.psdcsysinstactionidDirtyFlag = true;
    }

    public String getPSDCSysInstActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysInstActionId();
        }
        return this.psdcsysinstactionid;
    }

    public boolean isPSDCSysInstActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysInstActionIdDirty();
        }
        return this.psdcsysinstactionidDirtyFlag;
    }

    public void resetPSDCSysInstActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysInstActionId();
            return;
        }
        this.psdcsysinstactionidDirtyFlag = false;
        this.psdcsysinstactionid = null;
    }

    public void setPSDCSysInstActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysInstActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysinstactionname = string;
        this.psdcsysinstactionnameDirtyFlag = true;
    }

    public String getPSDCSysInstActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysInstActionName();
        }
        return this.psdcsysinstactionname;
    }

    public boolean isPSDCSysInstActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysInstActionNameDirty();
        }
        return this.psdcsysinstactionnameDirtyFlag;
    }

    public void resetPSDCSysInstActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysInstActionName();
            return;
        }
        this.psdcsysinstactionnameDirtyFlag = false;
        this.psdcsysinstactionname = null;
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
        PSDCSysInstActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysInstActionBase pSDCSysInstActionBase) {
        pSDCSysInstActionBase.resetActionParam();
        pSDCSysInstActionBase.resetActionParam2();
        pSDCSysInstActionBase.resetActionParam3();
        pSDCSysInstActionBase.resetActionParam4();
        pSDCSysInstActionBase.resetActionParam5();
        pSDCSysInstActionBase.resetActionParam6();
        pSDCSysInstActionBase.resetActionState();
        pSDCSysInstActionBase.resetActionType();
        pSDCSysInstActionBase.resetBeginTime();
        pSDCSysInstActionBase.resetCreateDate();
        pSDCSysInstActionBase.resetCreateMan();
        pSDCSysInstActionBase.resetEndTime();
        pSDCSysInstActionBase.resetLastPSDevSlnSysId();
        pSDCSysInstActionBase.resetLastPSDevSlnSysName();
        pSDCSysInstActionBase.resetMemo();
        pSDCSysInstActionBase.resetPSDCSysInstActionId();
        pSDCSysInstActionBase.resetPSDCSysInstActionName();
        pSDCSysInstActionBase.resetPSDevCenterId();
        pSDCSysInstActionBase.resetPSDevCenterName();
        pSDCSysInstActionBase.resetPSDevSlnId();
        pSDCSysInstActionBase.resetPSDevSlnName();
        pSDCSysInstActionBase.resetPSDevSlnSysId();
        pSDCSysInstActionBase.resetPSDevSlnSysName();
        pSDCSysInstActionBase.resetUpdateDate();
        pSDCSysInstActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamDirty()) {
            hashMap.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bl || this.isActionParam2Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM2, this.getActionParam2());
        }
        if (!bl || this.isActionParam3Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM3, this.getActionParam3());
        }
        if (!bl || this.isActionParam4Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM4, this.getActionParam4());
        }
        if (!bl || this.isActionParam5Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM5, this.getActionParam5());
        }
        if (!bl || this.isActionParam6Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM6, this.getActionParam6());
        }
        if (!bl || this.isActionStateDirty()) {
            hashMap.put(FIELD_ACTIONSTATE, this.getActionState());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isLastPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_LASTPSDEVSLNSYSID, this.getLastPSDevSlnSysId());
        }
        if (!bl || this.isLastPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_LASTPSDEVSLNSYSNAME, this.getLastPSDevSlnSysName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSysInstActionIdDirty()) {
            hashMap.put(FIELD_PSDCSYSINSTACTIONID, this.getPSDCSysInstActionId());
        }
        if (!bl || this.isPSDCSysInstActionNameDirty()) {
            hashMap.put(FIELD_PSDCSYSINSTACTIONNAME, this.getPSDCSysInstActionName());
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
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
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
        return PSDCSysInstActionBase.get(this, n);
    }

    private static Object get(PSDCSysInstActionBase pSDCSysInstActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysInstActionBase.getActionParam();
            }
            case 1: {
                return pSDCSysInstActionBase.getActionParam2();
            }
            case 2: {
                return pSDCSysInstActionBase.getActionParam3();
            }
            case 3: {
                return pSDCSysInstActionBase.getActionParam4();
            }
            case 4: {
                return pSDCSysInstActionBase.getActionParam5();
            }
            case 5: {
                return pSDCSysInstActionBase.getActionParam6();
            }
            case 6: {
                return pSDCSysInstActionBase.getActionState();
            }
            case 7: {
                return pSDCSysInstActionBase.getActionType();
            }
            case 8: {
                return pSDCSysInstActionBase.getBeginTime();
            }
            case 9: {
                return pSDCSysInstActionBase.getCreateDate();
            }
            case 10: {
                return pSDCSysInstActionBase.getCreateMan();
            }
            case 11: {
                return pSDCSysInstActionBase.getEndTime();
            }
            case 12: {
                return pSDCSysInstActionBase.getLastPSDevSlnSysId();
            }
            case 13: {
                return pSDCSysInstActionBase.getLastPSDevSlnSysName();
            }
            case 14: {
                return pSDCSysInstActionBase.getMemo();
            }
            case 15: {
                return pSDCSysInstActionBase.getPSDCSysInstActionId();
            }
            case 16: {
                return pSDCSysInstActionBase.getPSDCSysInstActionName();
            }
            case 17: {
                return pSDCSysInstActionBase.getPSDevCenterId();
            }
            case 18: {
                return pSDCSysInstActionBase.getPSDevCenterName();
            }
            case 19: {
                return pSDCSysInstActionBase.getPSDevSlnId();
            }
            case 20: {
                return pSDCSysInstActionBase.getPSDevSlnName();
            }
            case 21: {
                return pSDCSysInstActionBase.getPSDevSlnSysId();
            }
            case 22: {
                return pSDCSysInstActionBase.getPSDevSlnSysName();
            }
            case 23: {
                return pSDCSysInstActionBase.getUpdateDate();
            }
            case 24: {
                return pSDCSysInstActionBase.getUpdateMan();
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
        PSDCSysInstActionBase.set(this, n, object);
    }

    private static void set(PSDCSysInstActionBase pSDCSysInstActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysInstActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysInstActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysInstActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysInstActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysInstActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysInstActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysInstActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysInstActionBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysInstActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysInstActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysInstActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysInstActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCSysInstActionBase.setLastPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSysInstActionBase.setLastPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSysInstActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCSysInstActionBase.setPSDCSysInstActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSysInstActionBase.setPSDCSysInstActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSysInstActionBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCSysInstActionBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSysInstActionBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCSysInstActionBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCSysInstActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCSysInstActionBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCSysInstActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDCSysInstActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysInstActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysInstActionBase pSDCSysInstActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysInstActionBase.getActionParam() == null;
            }
            case 1: {
                return pSDCSysInstActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSDCSysInstActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSDCSysInstActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSDCSysInstActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSDCSysInstActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSDCSysInstActionBase.getActionState() == null;
            }
            case 7: {
                return pSDCSysInstActionBase.getActionType() == null;
            }
            case 8: {
                return pSDCSysInstActionBase.getBeginTime() == null;
            }
            case 9: {
                return pSDCSysInstActionBase.getCreateDate() == null;
            }
            case 10: {
                return pSDCSysInstActionBase.getCreateMan() == null;
            }
            case 11: {
                return pSDCSysInstActionBase.getEndTime() == null;
            }
            case 12: {
                return pSDCSysInstActionBase.getLastPSDevSlnSysId() == null;
            }
            case 13: {
                return pSDCSysInstActionBase.getLastPSDevSlnSysName() == null;
            }
            case 14: {
                return pSDCSysInstActionBase.getMemo() == null;
            }
            case 15: {
                return pSDCSysInstActionBase.getPSDCSysInstActionId() == null;
            }
            case 16: {
                return pSDCSysInstActionBase.getPSDCSysInstActionName() == null;
            }
            case 17: {
                return pSDCSysInstActionBase.getPSDevCenterId() == null;
            }
            case 18: {
                return pSDCSysInstActionBase.getPSDevCenterName() == null;
            }
            case 19: {
                return pSDCSysInstActionBase.getPSDevSlnId() == null;
            }
            case 20: {
                return pSDCSysInstActionBase.getPSDevSlnName() == null;
            }
            case 21: {
                return pSDCSysInstActionBase.getPSDevSlnSysId() == null;
            }
            case 22: {
                return pSDCSysInstActionBase.getPSDevSlnSysName() == null;
            }
            case 23: {
                return pSDCSysInstActionBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDCSysInstActionBase.getUpdateMan() == null;
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
        return PSDCSysInstActionBase.contains(this, n);
    }

    private static boolean contains(PSDCSysInstActionBase pSDCSysInstActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysInstActionBase.isActionParamDirty();
            }
            case 1: {
                return pSDCSysInstActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSDCSysInstActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSDCSysInstActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSDCSysInstActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSDCSysInstActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSDCSysInstActionBase.isActionStateDirty();
            }
            case 7: {
                return pSDCSysInstActionBase.isActionTypeDirty();
            }
            case 8: {
                return pSDCSysInstActionBase.isBeginTimeDirty();
            }
            case 9: {
                return pSDCSysInstActionBase.isCreateDateDirty();
            }
            case 10: {
                return pSDCSysInstActionBase.isCreateManDirty();
            }
            case 11: {
                return pSDCSysInstActionBase.isEndTimeDirty();
            }
            case 12: {
                return pSDCSysInstActionBase.isLastPSDevSlnSysIdDirty();
            }
            case 13: {
                return pSDCSysInstActionBase.isLastPSDevSlnSysNameDirty();
            }
            case 14: {
                return pSDCSysInstActionBase.isMemoDirty();
            }
            case 15: {
                return pSDCSysInstActionBase.isPSDCSysInstActionIdDirty();
            }
            case 16: {
                return pSDCSysInstActionBase.isPSDCSysInstActionNameDirty();
            }
            case 17: {
                return pSDCSysInstActionBase.isPSDevCenterIdDirty();
            }
            case 18: {
                return pSDCSysInstActionBase.isPSDevCenterNameDirty();
            }
            case 19: {
                return pSDCSysInstActionBase.isPSDevSlnIdDirty();
            }
            case 20: {
                return pSDCSysInstActionBase.isPSDevSlnNameDirty();
            }
            case 21: {
                return pSDCSysInstActionBase.isPSDevSlnSysIdDirty();
            }
            case 22: {
                return pSDCSysInstActionBase.isPSDevSlnSysNameDirty();
            }
            case 23: {
                return pSDCSysInstActionBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDCSysInstActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysInstActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysInstActionBase pSDCSysInstActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysInstActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getActionType()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getLastPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastpsdevslnsysid", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getLastPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getLastPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastpsdevslnsysname", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getLastPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDCSysInstActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysinstactionid", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDCSysInstActionId()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDCSysInstActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysinstactionname", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDCSysInstActionName()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysInstActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysInstActionBase.getJSONValue((Object)pSDCSysInstActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysInstActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysInstActionBase pSDCSysInstActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysInstActionBase.getActionParam() != null) {
            object = pSDCSysInstActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSDCSysInstActionBase.getActionParam2() != null) {
            object = pSDCSysInstActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSDCSysInstActionBase.getActionParam3() != null) {
            object = pSDCSysInstActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSDCSysInstActionBase.getActionParam4() != null) {
            object = pSDCSysInstActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getActionParam5() != null) {
            object = pSDCSysInstActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getActionParam6() != null) {
            object = pSDCSysInstActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getActionState() != null) {
            object = pSDCSysInstActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getActionType() != null) {
            object = pSDCSysInstActionBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getBeginTime() != null) {
            object = pSDCSysInstActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getCreateDate() != null) {
            object = pSDCSysInstActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getCreateMan() != null) {
            object = pSDCSysInstActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getEndTime() != null) {
            object = pSDCSysInstActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getLastPSDevSlnSysId() != null) {
            object = pSDCSysInstActionBase.getLastPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_LASTPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getLastPSDevSlnSysName() != null) {
            object = pSDCSysInstActionBase.getLastPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_LASTPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getMemo() != null) {
            object = pSDCSysInstActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDCSysInstActionId() != null) {
            object = pSDCSysInstActionBase.getPSDCSysInstActionId();
            xmlNode.setAttribute(FIELD_PSDCSYSINSTACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDCSysInstActionName() != null) {
            object = pSDCSysInstActionBase.getPSDCSysInstActionName();
            xmlNode.setAttribute(FIELD_PSDCSYSINSTACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevCenterId() != null) {
            object = pSDCSysInstActionBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevCenterName() != null) {
            object = pSDCSysInstActionBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnId() != null) {
            object = pSDCSysInstActionBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnName() != null) {
            object = pSDCSysInstActionBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnSysId() != null) {
            object = pSDCSysInstActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getPSDevSlnSysName() != null) {
            object = pSDCSysInstActionBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysInstActionBase.getUpdateDate() != null) {
            object = pSDCSysInstActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysInstActionBase.getUpdateMan() != null) {
            object = pSDCSysInstActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysInstActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysInstActionBase pSDCSysInstActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysInstActionBase.isActionParamDirty() && (bl || pSDCSysInstActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSDCSysInstActionBase.getActionParam());
        }
        if (pSDCSysInstActionBase.isActionParam2Dirty() && (bl || pSDCSysInstActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSDCSysInstActionBase.getActionParam2());
        }
        if (pSDCSysInstActionBase.isActionParam3Dirty() && (bl || pSDCSysInstActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSDCSysInstActionBase.getActionParam3());
        }
        if (pSDCSysInstActionBase.isActionParam4Dirty() && (bl || pSDCSysInstActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSDCSysInstActionBase.getActionParam4());
        }
        if (pSDCSysInstActionBase.isActionParam5Dirty() && (bl || pSDCSysInstActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSDCSysInstActionBase.getActionParam5());
        }
        if (pSDCSysInstActionBase.isActionParam6Dirty() && (bl || pSDCSysInstActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSDCSysInstActionBase.getActionParam6());
        }
        if (pSDCSysInstActionBase.isActionStateDirty() && (bl || pSDCSysInstActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSDCSysInstActionBase.getActionState());
        }
        if (pSDCSysInstActionBase.isActionTypeDirty() && (bl || pSDCSysInstActionBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSDCSysInstActionBase.getActionType());
        }
        if (pSDCSysInstActionBase.isBeginTimeDirty() && (bl || pSDCSysInstActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCSysInstActionBase.getBeginTime());
        }
        if (pSDCSysInstActionBase.isCreateDateDirty() && (bl || pSDCSysInstActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysInstActionBase.getCreateDate());
        }
        if (pSDCSysInstActionBase.isCreateManDirty() && (bl || pSDCSysInstActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysInstActionBase.getCreateMan());
        }
        if (pSDCSysInstActionBase.isEndTimeDirty() && (bl || pSDCSysInstActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCSysInstActionBase.getEndTime());
        }
        if (pSDCSysInstActionBase.isLastPSDevSlnSysIdDirty() && (bl || pSDCSysInstActionBase.getLastPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_LASTPSDEVSLNSYSID, (Object)pSDCSysInstActionBase.getLastPSDevSlnSysId());
        }
        if (pSDCSysInstActionBase.isLastPSDevSlnSysNameDirty() && (bl || pSDCSysInstActionBase.getLastPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_LASTPSDEVSLNSYSNAME, (Object)pSDCSysInstActionBase.getLastPSDevSlnSysName());
        }
        if (pSDCSysInstActionBase.isMemoDirty() && (bl || pSDCSysInstActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSysInstActionBase.getMemo());
        }
        if (pSDCSysInstActionBase.isPSDCSysInstActionIdDirty() && (bl || pSDCSysInstActionBase.getPSDCSysInstActionId() != null)) {
            iDataObject.set(FIELD_PSDCSYSINSTACTIONID, (Object)pSDCSysInstActionBase.getPSDCSysInstActionId());
        }
        if (pSDCSysInstActionBase.isPSDCSysInstActionNameDirty() && (bl || pSDCSysInstActionBase.getPSDCSysInstActionName() != null)) {
            iDataObject.set(FIELD_PSDCSYSINSTACTIONNAME, (Object)pSDCSysInstActionBase.getPSDCSysInstActionName());
        }
        if (pSDCSysInstActionBase.isPSDevCenterIdDirty() && (bl || pSDCSysInstActionBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSysInstActionBase.getPSDevCenterId());
        }
        if (pSDCSysInstActionBase.isPSDevCenterNameDirty() && (bl || pSDCSysInstActionBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSysInstActionBase.getPSDevCenterName());
        }
        if (pSDCSysInstActionBase.isPSDevSlnIdDirty() && (bl || pSDCSysInstActionBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCSysInstActionBase.getPSDevSlnId());
        }
        if (pSDCSysInstActionBase.isPSDevSlnNameDirty() && (bl || pSDCSysInstActionBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCSysInstActionBase.getPSDevSlnName());
        }
        if (pSDCSysInstActionBase.isPSDevSlnSysIdDirty() && (bl || pSDCSysInstActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCSysInstActionBase.getPSDevSlnSysId());
        }
        if (pSDCSysInstActionBase.isPSDevSlnSysNameDirty() && (bl || pSDCSysInstActionBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCSysInstActionBase.getPSDevSlnSysName());
        }
        if (pSDCSysInstActionBase.isUpdateDateDirty() && (bl || pSDCSysInstActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysInstActionBase.getUpdateDate());
        }
        if (pSDCSysInstActionBase.isUpdateManDirty() && (bl || pSDCSysInstActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysInstActionBase.getUpdateMan());
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
        return PSDCSysInstActionBase.remove(this, n);
    }

    private static boolean remove(PSDCSysInstActionBase pSDCSysInstActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysInstActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSDCSysInstActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSDCSysInstActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSDCSysInstActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSDCSysInstActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSDCSysInstActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSDCSysInstActionBase.resetActionState();
                return true;
            }
            case 7: {
                pSDCSysInstActionBase.resetActionType();
                return true;
            }
            case 8: {
                pSDCSysInstActionBase.resetBeginTime();
                return true;
            }
            case 9: {
                pSDCSysInstActionBase.resetCreateDate();
                return true;
            }
            case 10: {
                pSDCSysInstActionBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSDCSysInstActionBase.resetEndTime();
                return true;
            }
            case 12: {
                pSDCSysInstActionBase.resetLastPSDevSlnSysId();
                return true;
            }
            case 13: {
                pSDCSysInstActionBase.resetLastPSDevSlnSysName();
                return true;
            }
            case 14: {
                pSDCSysInstActionBase.resetMemo();
                return true;
            }
            case 15: {
                pSDCSysInstActionBase.resetPSDCSysInstActionId();
                return true;
            }
            case 16: {
                pSDCSysInstActionBase.resetPSDCSysInstActionName();
                return true;
            }
            case 17: {
                pSDCSysInstActionBase.resetPSDevCenterId();
                return true;
            }
            case 18: {
                pSDCSysInstActionBase.resetPSDevCenterName();
                return true;
            }
            case 19: {
                pSDCSysInstActionBase.resetPSDevSlnId();
                return true;
            }
            case 20: {
                pSDCSysInstActionBase.resetPSDevSlnName();
                return true;
            }
            case 21: {
                pSDCSysInstActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 22: {
                pSDCSysInstActionBase.resetPSDevSlnSysName();
                return true;
            }
            case 23: {
                pSDCSysInstActionBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDCSysInstActionBase.resetUpdateMan();
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
    public PSDevSlnSys getLastPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastPSDevSlnSys();
        }
        if (this.getLastPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objLastPSDevSlnSysLock;
        synchronized (n) {
            if (this.lastpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getLastPSDevSlnSysId(), (Object)this.lastpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.lastpsdevslnsys = null;
            }
            if (this.lastpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getLastPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.lastpsdevslnsys = pSDevSlnSys;
            }
            return this.lastpsdevslnsys;
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

    private PSDCSysInstActionBase getProxyEntity() {
        return this.proxyPSDCSysInstActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysInstActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysInstActionBase) {
            this.proxyPSDCSysInstActionBase = (PSDCSysInstActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAM, 0);
        fieldIndexMap.put(FIELD_ACTIONPARAM2, 1);
        fieldIndexMap.put(FIELD_ACTIONPARAM3, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAM4, 3);
        fieldIndexMap.put(FIELD_ACTIONPARAM5, 4);
        fieldIndexMap.put(FIELD_ACTIONPARAM6, 5);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 6);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 7);
        fieldIndexMap.put(FIELD_BEGINTIME, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_ENDTIME, 11);
        fieldIndexMap.put(FIELD_LASTPSDEVSLNSYSID, 12);
        fieldIndexMap.put(FIELD_LASTPSDEVSLNSYSNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_PSDCSYSINSTACTIONID, 15);
        fieldIndexMap.put(FIELD_PSDCSYSINSTACTIONNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
    }
}

