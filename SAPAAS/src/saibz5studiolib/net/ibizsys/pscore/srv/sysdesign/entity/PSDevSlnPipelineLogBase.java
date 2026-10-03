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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineLogBase.class);
    public static final String FIELD_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_BUILDNUMBER = "BUILDNUMBER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DURATION = "DURATION";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PPSDEVSLNPIPELINELOGID = "PPSDEVSLNPIPELINELOGID";
    public static final String FIELD_PPSDEVSLNPIPELINELOGNAME = "PPSDEVSLNPIPELINELOGNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINELOGID = "PSDEVSLNPIPELINELOGID";
    public static final String FIELD_PSDEVSLNPIPELINELOGNAME = "PSDEVSLNPIPELINELOGNAME";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNPIPELINEREFID = "PSDEVSLNPIPELINEREFID";
    public static final String FIELD_PSDEVSLNPIPELINEREFNAME = "PSDEVSLNPIPELINEREFNAME";
    public static final String FIELD_PSDEVSLNPIPELINESTAGEID = "PSDEVSLNPIPELINESTAGEID";
    public static final String FIELD_PSDEVSLNPIPELINESTAGENAME = "PSDEVSLNPIPELINESTAGENAME";
    public static final String FIELD_PSDEVSLNPIPELINESTEPID = "PSDEVSLNPIPELINESTEPID";
    public static final String FIELD_PSDEVSLNPIPELINESTEPNAME = "PSDEVSLNPIPELINESTEPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_QUEUEURL = "QUEUEURL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONPARAMS = 0;
    private static final int INDEX_ACTIONRESULT = 1;
    private static final int INDEX_ACTIONSTATE = 2;
    private static final int INDEX_BEGINTIME = 3;
    private static final int INDEX_BUILDNUMBER = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DURATION = 7;
    private static final int INDEX_ENDTIME = 8;
    private static final int INDEX_PPSDEVSLNPIPELINELOGID = 9;
    private static final int INDEX_PPSDEVSLNPIPELINELOGNAME = 10;
    private static final int INDEX_PSDEVCENTERID = 11;
    private static final int INDEX_PSDEVSLNID = 12;
    private static final int INDEX_PSDEVSLNNAME = 13;
    private static final int INDEX_PSDEVSLNPIPELINEID = 14;
    private static final int INDEX_PSDEVSLNPIPELINELOGID = 15;
    private static final int INDEX_PSDEVSLNPIPELINELOGNAME = 16;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 17;
    private static final int INDEX_PSDEVSLNPIPELINEREFID = 18;
    private static final int INDEX_PSDEVSLNPIPELINEREFNAME = 19;
    private static final int INDEX_PSDEVSLNPIPELINESTAGEID = 20;
    private static final int INDEX_PSDEVSLNPIPELINESTAGENAME = 21;
    private static final int INDEX_PSDEVSLNPIPELINESTEPID = 22;
    private static final int INDEX_PSDEVSLNPIPELINESTEPNAME = 23;
    private static final int INDEX_PSDEVSLNSYSID = 24;
    private static final int INDEX_PSDEVSLNSYSNAME = 25;
    private static final int INDEX_QUEUEURL = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnPipelineLogBase proxyPSDevSlnPipelineLogBase = null;
    private boolean actionparamsDirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean buildnumberDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean durationDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean ppsdevslnpipelinelogidDirtyFlag = false;
    private boolean ppsdevslnpipelinelognameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinelogidDirtyFlag = false;
    private boolean psdevslnpipelinelognameDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnpipelinerefidDirtyFlag = false;
    private boolean psdevslnpipelinerefnameDirtyFlag = false;
    private boolean psdevslnpipelinestageidDirtyFlag = false;
    private boolean psdevslnpipelinestagenameDirtyFlag = false;
    private boolean psdevslnpipelinestepidDirtyFlag = false;
    private boolean psdevslnpipelinestepnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean queueurlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actionparams")
    private String actionparams;
    @Column(name="actionresult")
    private String actionresult;
    @Column(name="actionstate")
    private Integer actionstate;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="buildnumber")
    private Integer buildnumber;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="duration")
    private Integer duration;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="ppsdevslnpipelinelogid")
    private String ppsdevslnpipelinelogid;
    @Column(name="ppsdevslnpipelinelogname")
    private String ppsdevslnpipelinelogname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinelogid")
    private String psdevslnpipelinelogid;
    @Column(name="psdevslnpipelinelogname")
    private String psdevslnpipelinelogname;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnpipelinerefid")
    private String psdevslnpipelinerefid;
    @Column(name="psdevslnpipelinerefname")
    private String psdevslnpipelinerefname;
    @Column(name="psdevslnpipelinestageid")
    private String psdevslnpipelinestageid;
    @Column(name="psdevslnpipelinestagename")
    private String psdevslnpipelinestagename;
    @Column(name="psdevslnpipelinestepid")
    private String psdevslnpipelinestepid;
    @Column(name="psdevslnpipelinestepname")
    private String psdevslnpipelinestepname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="queueurl")
    private String queueurl;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSDevSlnPipelineLogLock = new Integer(1);
    private PSDevSlnPipelineLog ppsdevslnpipelinelog = null;
    private Integer objPSDevSlnPipelineRefLock = new Integer(1);
    private PSDevSlnPipelineRef psdevslnpipelineref = null;
    private Integer objPSDevSlnPipelineStageLock = new Integer(1);
    private PSDevSlnPipelineStage psdevslnpipelinestage = null;
    private Integer objPSDevSlnPipelineStepLock = new Integer(1);
    private PSDevSlnPipelineStep psdevslnpipelinestep = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparams = string;
        this.actionparamsDirtyFlag = true;
    }

    public String getActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParams();
        }
        return this.actionparams;
    }

    public boolean isActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamsDirty();
        }
        return this.actionparamsDirtyFlag;
    }

    public void resetActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParams();
            return;
        }
        this.actionparamsDirtyFlag = false;
        this.actionparams = null;
    }

    public void setActionResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionresult = string;
        this.actionresultDirtyFlag = true;
    }

    public String getActionResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionResult();
        }
        return this.actionresult;
    }

    public boolean isActionResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionResultDirty();
        }
        return this.actionresultDirtyFlag;
    }

    public void resetActionResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionResult();
            return;
        }
        this.actionresultDirtyFlag = false;
        this.actionresult = null;
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

    public void setBuildNumber(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBuildNumber(n);
            return;
        }
        this.buildnumber = n;
        this.buildnumberDirtyFlag = true;
    }

    public Integer getBuildNumber() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBuildNumber();
        }
        return this.buildnumber;
    }

    public boolean isBuildNumberDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBuildNumberDirty();
        }
        return this.buildnumberDirtyFlag;
    }

    public void resetBuildNumber() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBuildNumber();
            return;
        }
        this.buildnumberDirtyFlag = false;
        this.buildnumber = null;
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

    public void setDuration(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDuration(n);
            return;
        }
        this.duration = n;
        this.durationDirtyFlag = true;
    }

    public Integer getDuration() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDuration();
        }
        return this.duration;
    }

    public boolean isDurationDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDurationDirty();
        }
        return this.durationDirtyFlag;
    }

    public void resetDuration() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDuration();
            return;
        }
        this.durationDirtyFlag = false;
        this.duration = null;
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

    public void setPPSDevSlnPipelineLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnPipelineLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnpipelinelogid = string;
        this.ppsdevslnpipelinelogidDirtyFlag = true;
    }

    public String getPPSDevSlnPipelineLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnPipelineLogId();
        }
        return this.ppsdevslnpipelinelogid;
    }

    public boolean isPPSDevSlnPipelineLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnPipelineLogIdDirty();
        }
        return this.ppsdevslnpipelinelogidDirtyFlag;
    }

    public void resetPPSDevSlnPipelineLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnPipelineLogId();
            return;
        }
        this.ppsdevslnpipelinelogidDirtyFlag = false;
        this.ppsdevslnpipelinelogid = null;
    }

    public void setPPSDevSlnPipelineLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnPipelineLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnpipelinelogname = string;
        this.ppsdevslnpipelinelognameDirtyFlag = true;
    }

    public String getPPSDevSlnPipelineLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnPipelineLogName();
        }
        return this.ppsdevslnpipelinelogname;
    }

    public boolean isPPSDevSlnPipelineLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnPipelineLogNameDirty();
        }
        return this.ppsdevslnpipelinelognameDirtyFlag;
    }

    public void resetPPSDevSlnPipelineLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnPipelineLogName();
            return;
        }
        this.ppsdevslnpipelinelognameDirtyFlag = false;
        this.ppsdevslnpipelinelogname = null;
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

    public void setPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelineid = string;
        this.psdevslnpipelineidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineId();
        }
        return this.psdevslnpipelineid;
    }

    public boolean isPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineIdDirty();
        }
        return this.psdevslnpipelineidDirtyFlag;
    }

    public void resetPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineId();
            return;
        }
        this.psdevslnpipelineidDirtyFlag = false;
        this.psdevslnpipelineid = null;
    }

    public void setPSDevSlnPipelineLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinelogid = string;
        this.psdevslnpipelinelogidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineLogId();
        }
        return this.psdevslnpipelinelogid;
    }

    public boolean isPSDevSlnPipelineLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineLogIdDirty();
        }
        return this.psdevslnpipelinelogidDirtyFlag;
    }

    public void resetPSDevSlnPipelineLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineLogId();
            return;
        }
        this.psdevslnpipelinelogidDirtyFlag = false;
        this.psdevslnpipelinelogid = null;
    }

    public void setPSDevSlnPipelineLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinelogname = string;
        this.psdevslnpipelinelognameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineLogName();
        }
        return this.psdevslnpipelinelogname;
    }

    public boolean isPSDevSlnPipelineLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineLogNameDirty();
        }
        return this.psdevslnpipelinelognameDirtyFlag;
    }

    public void resetPSDevSlnPipelineLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineLogName();
            return;
        }
        this.psdevslnpipelinelognameDirtyFlag = false;
        this.psdevslnpipelinelogname = null;
    }

    public void setPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinename = string;
        this.psdevslnpipelinenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineName();
        }
        return this.psdevslnpipelinename;
    }

    public boolean isPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineNameDirty();
        }
        return this.psdevslnpipelinenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineName();
            return;
        }
        this.psdevslnpipelinenameDirtyFlag = false;
        this.psdevslnpipelinename = null;
    }

    public void setPSDevSlnPipelineRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinerefid = string;
        this.psdevslnpipelinerefidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineRefId();
        }
        return this.psdevslnpipelinerefid;
    }

    public boolean isPSDevSlnPipelineRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineRefIdDirty();
        }
        return this.psdevslnpipelinerefidDirtyFlag;
    }

    public void resetPSDevSlnPipelineRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineRefId();
            return;
        }
        this.psdevslnpipelinerefidDirtyFlag = false;
        this.psdevslnpipelinerefid = null;
    }

    public void setPSDevSlnPipelineRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinerefname = string;
        this.psdevslnpipelinerefnameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineRefName();
        }
        return this.psdevslnpipelinerefname;
    }

    public boolean isPSDevSlnPipelineRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineRefNameDirty();
        }
        return this.psdevslnpipelinerefnameDirtyFlag;
    }

    public void resetPSDevSlnPipelineRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineRefName();
            return;
        }
        this.psdevslnpipelinerefnameDirtyFlag = false;
        this.psdevslnpipelinerefname = null;
    }

    public void setPSDevSlnPipelineStageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestageid = string;
        this.psdevslnpipelinestageidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageId();
        }
        return this.psdevslnpipelinestageid;
    }

    public boolean isPSDevSlnPipelineStageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageIdDirty();
        }
        return this.psdevslnpipelinestageidDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageId();
            return;
        }
        this.psdevslnpipelinestageidDirtyFlag = false;
        this.psdevslnpipelinestageid = null;
    }

    public void setPSDevSlnPipelineStageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestagename = string;
        this.psdevslnpipelinestagenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageName();
        }
        return this.psdevslnpipelinestagename;
    }

    public boolean isPSDevSlnPipelineStageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageNameDirty();
        }
        return this.psdevslnpipelinestagenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageName();
            return;
        }
        this.psdevslnpipelinestagenameDirtyFlag = false;
        this.psdevslnpipelinestagename = null;
    }

    public void setPSDevSlnPipelineStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestepid = string;
        this.psdevslnpipelinestepidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStepId();
        }
        return this.psdevslnpipelinestepid;
    }

    public boolean isPSDevSlnPipelineStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStepIdDirty();
        }
        return this.psdevslnpipelinestepidDirtyFlag;
    }

    public void resetPSDevSlnPipelineStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStepId();
            return;
        }
        this.psdevslnpipelinestepidDirtyFlag = false;
        this.psdevslnpipelinestepid = null;
    }

    public void setPSDevSlnPipelineStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestepname = string;
        this.psdevslnpipelinestepnameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStepName();
        }
        return this.psdevslnpipelinestepname;
    }

    public boolean isPSDevSlnPipelineStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStepNameDirty();
        }
        return this.psdevslnpipelinestepnameDirtyFlag;
    }

    public void resetPSDevSlnPipelineStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStepName();
            return;
        }
        this.psdevslnpipelinestepnameDirtyFlag = false;
        this.psdevslnpipelinestepname = null;
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

    public void setQueueUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueueUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.queueurl = string;
        this.queueurlDirtyFlag = true;
    }

    public String getQueueUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueueUrl();
        }
        return this.queueurl;
    }

    public boolean isQueueUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueueUrlDirty();
        }
        return this.queueurlDirtyFlag;
    }

    public void resetQueueUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueueUrl();
            return;
        }
        this.queueurlDirtyFlag = false;
        this.queueurl = null;
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
        PSDevSlnPipelineLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase) {
        pSDevSlnPipelineLogBase.resetActionParams();
        pSDevSlnPipelineLogBase.resetActionResult();
        pSDevSlnPipelineLogBase.resetActionState();
        pSDevSlnPipelineLogBase.resetBeginTime();
        pSDevSlnPipelineLogBase.resetBuildNumber();
        pSDevSlnPipelineLogBase.resetCreateDate();
        pSDevSlnPipelineLogBase.resetCreateMan();
        pSDevSlnPipelineLogBase.resetDuration();
        pSDevSlnPipelineLogBase.resetEndTime();
        pSDevSlnPipelineLogBase.resetPPSDevSlnPipelineLogId();
        pSDevSlnPipelineLogBase.resetPPSDevSlnPipelineLogName();
        pSDevSlnPipelineLogBase.resetPSDevCenterId();
        pSDevSlnPipelineLogBase.resetPSDevSlnId();
        pSDevSlnPipelineLogBase.resetPSDevSlnName();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineId();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineLogId();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineLogName();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineName();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineRefId();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineRefName();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStageId();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStageName();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStepId();
        pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStepName();
        pSDevSlnPipelineLogBase.resetPSDevSlnSysId();
        pSDevSlnPipelineLogBase.resetPSDevSlnSysName();
        pSDevSlnPipelineLogBase.resetQueueUrl();
        pSDevSlnPipelineLogBase.resetUpdateDate();
        pSDevSlnPipelineLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamsDirty()) {
            hashMap.put(FIELD_ACTIONPARAMS, this.getActionParams());
        }
        if (!bl || this.isActionResultDirty()) {
            hashMap.put(FIELD_ACTIONRESULT, this.getActionResult());
        }
        if (!bl || this.isActionStateDirty()) {
            hashMap.put(FIELD_ACTIONSTATE, this.getActionState());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isBuildNumberDirty()) {
            hashMap.put(FIELD_BUILDNUMBER, this.getBuildNumber());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDurationDirty()) {
            hashMap.put(FIELD_DURATION, this.getDuration());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isPPSDevSlnPipelineLogIdDirty()) {
            hashMap.put(FIELD_PPSDEVSLNPIPELINELOGID, this.getPPSDevSlnPipelineLogId());
        }
        if (!bl || this.isPPSDevSlnPipelineLogNameDirty()) {
            hashMap.put(FIELD_PPSDEVSLNPIPELINELOGNAME, this.getPPSDevSlnPipelineLogName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineLogIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINELOGID, this.getPSDevSlnPipelineLogId());
        }
        if (!bl || this.isPSDevSlnPipelineLogNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINELOGNAME, this.getPSDevSlnPipelineLogName());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnPipelineRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEREFID, this.getPSDevSlnPipelineRefId());
        }
        if (!bl || this.isPSDevSlnPipelineRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEREFNAME, this.getPSDevSlnPipelineRefName());
        }
        if (!bl || this.isPSDevSlnPipelineStageIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, this.getPSDevSlnPipelineStageId());
        }
        if (!bl || this.isPSDevSlnPipelineStageNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, this.getPSDevSlnPipelineStageName());
        }
        if (!bl || this.isPSDevSlnPipelineStepIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTEPID, this.getPSDevSlnPipelineStepId());
        }
        if (!bl || this.isPSDevSlnPipelineStepNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTEPNAME, this.getPSDevSlnPipelineStepName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isQueueUrlDirty()) {
            hashMap.put(FIELD_QUEUEURL, this.getQueueUrl());
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
        return PSDevSlnPipelineLogBase.get(this, n);
    }

    private static Object get(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineLogBase.getActionParams();
            }
            case 1: {
                return pSDevSlnPipelineLogBase.getActionResult();
            }
            case 2: {
                return pSDevSlnPipelineLogBase.getActionState();
            }
            case 3: {
                return pSDevSlnPipelineLogBase.getBeginTime();
            }
            case 4: {
                return pSDevSlnPipelineLogBase.getBuildNumber();
            }
            case 5: {
                return pSDevSlnPipelineLogBase.getCreateDate();
            }
            case 6: {
                return pSDevSlnPipelineLogBase.getCreateMan();
            }
            case 7: {
                return pSDevSlnPipelineLogBase.getDuration();
            }
            case 8: {
                return pSDevSlnPipelineLogBase.getEndTime();
            }
            case 9: {
                return pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId();
            }
            case 10: {
                return pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName();
            }
            case 11: {
                return pSDevSlnPipelineLogBase.getPSDevCenterId();
            }
            case 12: {
                return pSDevSlnPipelineLogBase.getPSDevSlnId();
            }
            case 13: {
                return pSDevSlnPipelineLogBase.getPSDevSlnName();
            }
            case 14: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineId();
            }
            case 15: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId();
            }
            case 16: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName();
            }
            case 17: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineName();
            }
            case 18: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId();
            }
            case 19: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName();
            }
            case 20: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId();
            }
            case 21: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName();
            }
            case 22: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId();
            }
            case 23: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName();
            }
            case 24: {
                return pSDevSlnPipelineLogBase.getPSDevSlnSysId();
            }
            case 25: {
                return pSDevSlnPipelineLogBase.getPSDevSlnSysName();
            }
            case 26: {
                return pSDevSlnPipelineLogBase.getQueueUrl();
            }
            case 27: {
                return pSDevSlnPipelineLogBase.getUpdateDate();
            }
            case 28: {
                return pSDevSlnPipelineLogBase.getUpdateMan();
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
        PSDevSlnPipelineLogBase.set(this, n, object);
    }

    private static void set(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineLogBase.setActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnPipelineLogBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnPipelineLogBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnPipelineLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnPipelineLogBase.setBuildNumber(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnPipelineLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnPipelineLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnPipelineLogBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnPipelineLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnPipelineLogBase.setPPSDevSlnPipelineLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnPipelineLogBase.setPPSDevSlnPipelineLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnPipelineLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnPipelineLogBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnPipelineLogBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineStageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineStageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnPipelineLogBase.setPSDevSlnPipelineStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnPipelineLogBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnPipelineLogBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnPipelineLogBase.setQueueUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnPipelineLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnPipelineLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnPipelineLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineLogBase.getActionParams() == null;
            }
            case 1: {
                return pSDevSlnPipelineLogBase.getActionResult() == null;
            }
            case 2: {
                return pSDevSlnPipelineLogBase.getActionState() == null;
            }
            case 3: {
                return pSDevSlnPipelineLogBase.getBeginTime() == null;
            }
            case 4: {
                return pSDevSlnPipelineLogBase.getBuildNumber() == null;
            }
            case 5: {
                return pSDevSlnPipelineLogBase.getCreateDate() == null;
            }
            case 6: {
                return pSDevSlnPipelineLogBase.getCreateMan() == null;
            }
            case 7: {
                return pSDevSlnPipelineLogBase.getDuration() == null;
            }
            case 8: {
                return pSDevSlnPipelineLogBase.getEndTime() == null;
            }
            case 9: {
                return pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId() == null;
            }
            case 10: {
                return pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName() == null;
            }
            case 11: {
                return pSDevSlnPipelineLogBase.getPSDevCenterId() == null;
            }
            case 12: {
                return pSDevSlnPipelineLogBase.getPSDevSlnId() == null;
            }
            case 13: {
                return pSDevSlnPipelineLogBase.getPSDevSlnName() == null;
            }
            case 14: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineId() == null;
            }
            case 15: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId() == null;
            }
            case 16: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName() == null;
            }
            case 17: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineName() == null;
            }
            case 18: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId() == null;
            }
            case 19: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName() == null;
            }
            case 20: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId() == null;
            }
            case 21: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName() == null;
            }
            case 22: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId() == null;
            }
            case 23: {
                return pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName() == null;
            }
            case 24: {
                return pSDevSlnPipelineLogBase.getPSDevSlnSysId() == null;
            }
            case 25: {
                return pSDevSlnPipelineLogBase.getPSDevSlnSysName() == null;
            }
            case 26: {
                return pSDevSlnPipelineLogBase.getQueueUrl() == null;
            }
            case 27: {
                return pSDevSlnPipelineLogBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDevSlnPipelineLogBase.getUpdateMan() == null;
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
        return PSDevSlnPipelineLogBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineLogBase.isActionParamsDirty();
            }
            case 1: {
                return pSDevSlnPipelineLogBase.isActionResultDirty();
            }
            case 2: {
                return pSDevSlnPipelineLogBase.isActionStateDirty();
            }
            case 3: {
                return pSDevSlnPipelineLogBase.isBeginTimeDirty();
            }
            case 4: {
                return pSDevSlnPipelineLogBase.isBuildNumberDirty();
            }
            case 5: {
                return pSDevSlnPipelineLogBase.isCreateDateDirty();
            }
            case 6: {
                return pSDevSlnPipelineLogBase.isCreateManDirty();
            }
            case 7: {
                return pSDevSlnPipelineLogBase.isDurationDirty();
            }
            case 8: {
                return pSDevSlnPipelineLogBase.isEndTimeDirty();
            }
            case 9: {
                return pSDevSlnPipelineLogBase.isPPSDevSlnPipelineLogIdDirty();
            }
            case 10: {
                return pSDevSlnPipelineLogBase.isPPSDevSlnPipelineLogNameDirty();
            }
            case 11: {
                return pSDevSlnPipelineLogBase.isPSDevCenterIdDirty();
            }
            case 12: {
                return pSDevSlnPipelineLogBase.isPSDevSlnIdDirty();
            }
            case 13: {
                return pSDevSlnPipelineLogBase.isPSDevSlnNameDirty();
            }
            case 14: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineIdDirty();
            }
            case 15: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineLogIdDirty();
            }
            case 16: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineLogNameDirty();
            }
            case 17: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineNameDirty();
            }
            case 18: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineRefIdDirty();
            }
            case 19: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineRefNameDirty();
            }
            case 20: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineStageIdDirty();
            }
            case 21: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineStageNameDirty();
            }
            case 22: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineStepIdDirty();
            }
            case 23: {
                return pSDevSlnPipelineLogBase.isPSDevSlnPipelineStepNameDirty();
            }
            case 24: {
                return pSDevSlnPipelineLogBase.isPSDevSlnSysIdDirty();
            }
            case 25: {
                return pSDevSlnPipelineLogBase.isPSDevSlnSysNameDirty();
            }
            case 26: {
                return pSDevSlnPipelineLogBase.isQueueUrlDirty();
            }
            case 27: {
                return pSDevSlnPipelineLogBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDevSlnPipelineLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnPipelineLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnPipelineLogBase.getActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparams", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getActionParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getActionResult()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getActionState()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getBuildNumber() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"buildnumber", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getBuildNumber()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getDuration()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnpipelinelogid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnpipelinelogname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinelogid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinelogname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinerefid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinerefname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestageid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestagename", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestepid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestepname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getQueueUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueurl", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getQueueUrl()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnPipelineLogBase.getJSONValue((Object)pSDevSlnPipelineLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnPipelineLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnPipelineLogBase.getActionParams() != null) {
            object = pSDevSlnPipelineLogBase.getActionParams();
            xmlNode.setAttribute(FIELD_ACTIONPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineLogBase.getActionResult() != null) {
            object = pSDevSlnPipelineLogBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getActionState() != null) {
            object = pSDevSlnPipelineLogBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getBeginTime() != null) {
            object = pSDevSlnPipelineLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getBuildNumber() != null) {
            object = pSDevSlnPipelineLogBase.getBuildNumber();
            xmlNode.setAttribute(FIELD_BUILDNUMBER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getCreateDate() != null) {
            object = pSDevSlnPipelineLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getCreateMan() != null) {
            object = pSDevSlnPipelineLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getDuration() != null) {
            object = pSDevSlnPipelineLogBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getEndTime() != null) {
            object = pSDevSlnPipelineLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId() != null) {
            object = pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId();
            xmlNode.setAttribute(FIELD_PPSDEVSLNPIPELINELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName() != null) {
            object = pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName();
            xmlNode.setAttribute(FIELD_PPSDEVSLNPIPELINELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevCenterId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnPipelineLogBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getQueueUrl() != null) {
            object = pSDevSlnPipelineLogBase.getQueueUrl();
            xmlNode.setAttribute(FIELD_QUEUEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineLogBase.getUpdateDate() != null) {
            object = pSDevSlnPipelineLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineLogBase.getUpdateMan() != null) {
            object = pSDevSlnPipelineLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnPipelineLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnPipelineLogBase.isActionParamsDirty() && (bl || pSDevSlnPipelineLogBase.getActionParams() != null)) {
            iDataObject.set(FIELD_ACTIONPARAMS, (Object)pSDevSlnPipelineLogBase.getActionParams());
        }
        if (pSDevSlnPipelineLogBase.isActionResultDirty() && (bl || pSDevSlnPipelineLogBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSDevSlnPipelineLogBase.getActionResult());
        }
        if (pSDevSlnPipelineLogBase.isActionStateDirty() && (bl || pSDevSlnPipelineLogBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSDevSlnPipelineLogBase.getActionState());
        }
        if (pSDevSlnPipelineLogBase.isBeginTimeDirty() && (bl || pSDevSlnPipelineLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSlnPipelineLogBase.getBeginTime());
        }
        if (pSDevSlnPipelineLogBase.isBuildNumberDirty() && (bl || pSDevSlnPipelineLogBase.getBuildNumber() != null)) {
            iDataObject.set(FIELD_BUILDNUMBER, (Object)pSDevSlnPipelineLogBase.getBuildNumber());
        }
        if (pSDevSlnPipelineLogBase.isCreateDateDirty() && (bl || pSDevSlnPipelineLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnPipelineLogBase.getCreateDate());
        }
        if (pSDevSlnPipelineLogBase.isCreateManDirty() && (bl || pSDevSlnPipelineLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnPipelineLogBase.getCreateMan());
        }
        if (pSDevSlnPipelineLogBase.isDurationDirty() && (bl || pSDevSlnPipelineLogBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSDevSlnPipelineLogBase.getDuration());
        }
        if (pSDevSlnPipelineLogBase.isEndTimeDirty() && (bl || pSDevSlnPipelineLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSlnPipelineLogBase.getEndTime());
        }
        if (pSDevSlnPipelineLogBase.isPPSDevSlnPipelineLogIdDirty() && (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNPIPELINELOGID, (Object)pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogId());
        }
        if (pSDevSlnPipelineLogBase.isPPSDevSlnPipelineLogNameDirty() && (bl || pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNPIPELINELOGNAME, (Object)pSDevSlnPipelineLogBase.getPPSDevSlnPipelineLogName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevCenterIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnPipelineLogBase.getPSDevCenterId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineLogIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINELOGID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineLogNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINELOGNAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineRefIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEREFID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineRefNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEREFNAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineRefName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineStageIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGEID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineStageNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGENAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStageName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineStepIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTEPID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnPipelineStepNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTEPNAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineStepName());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnPipelineLogBase.getPSDevSlnSysId());
        }
        if (pSDevSlnPipelineLogBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnPipelineLogBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnPipelineLogBase.getPSDevSlnSysName());
        }
        if (pSDevSlnPipelineLogBase.isQueueUrlDirty() && (bl || pSDevSlnPipelineLogBase.getQueueUrl() != null)) {
            iDataObject.set(FIELD_QUEUEURL, (Object)pSDevSlnPipelineLogBase.getQueueUrl());
        }
        if (pSDevSlnPipelineLogBase.isUpdateDateDirty() && (bl || pSDevSlnPipelineLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnPipelineLogBase.getUpdateDate());
        }
        if (pSDevSlnPipelineLogBase.isUpdateManDirty() && (bl || pSDevSlnPipelineLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnPipelineLogBase.getUpdateMan());
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
        return PSDevSlnPipelineLogBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineLogBase.resetActionParams();
                return true;
            }
            case 1: {
                pSDevSlnPipelineLogBase.resetActionResult();
                return true;
            }
            case 2: {
                pSDevSlnPipelineLogBase.resetActionState();
                return true;
            }
            case 3: {
                pSDevSlnPipelineLogBase.resetBeginTime();
                return true;
            }
            case 4: {
                pSDevSlnPipelineLogBase.resetBuildNumber();
                return true;
            }
            case 5: {
                pSDevSlnPipelineLogBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDevSlnPipelineLogBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDevSlnPipelineLogBase.resetDuration();
                return true;
            }
            case 8: {
                pSDevSlnPipelineLogBase.resetEndTime();
                return true;
            }
            case 9: {
                pSDevSlnPipelineLogBase.resetPPSDevSlnPipelineLogId();
                return true;
            }
            case 10: {
                pSDevSlnPipelineLogBase.resetPPSDevSlnPipelineLogName();
                return true;
            }
            case 11: {
                pSDevSlnPipelineLogBase.resetPSDevCenterId();
                return true;
            }
            case 12: {
                pSDevSlnPipelineLogBase.resetPSDevSlnId();
                return true;
            }
            case 13: {
                pSDevSlnPipelineLogBase.resetPSDevSlnName();
                return true;
            }
            case 14: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 15: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineLogId();
                return true;
            }
            case 16: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineLogName();
                return true;
            }
            case 17: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 18: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineRefId();
                return true;
            }
            case 19: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineRefName();
                return true;
            }
            case 20: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStageId();
                return true;
            }
            case 21: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStageName();
                return true;
            }
            case 22: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStepId();
                return true;
            }
            case 23: {
                pSDevSlnPipelineLogBase.resetPSDevSlnPipelineStepName();
                return true;
            }
            case 24: {
                pSDevSlnPipelineLogBase.resetPSDevSlnSysId();
                return true;
            }
            case 25: {
                pSDevSlnPipelineLogBase.resetPSDevSlnSysName();
                return true;
            }
            case 26: {
                pSDevSlnPipelineLogBase.resetQueueUrl();
                return true;
            }
            case 27: {
                pSDevSlnPipelineLogBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDevSlnPipelineLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipelineLog getPPSDevSlnPipelineLog() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnPipelineLog();
        }
        if (this.getPPSDevSlnPipelineLogId() == null) {
            return null;
        }
        Integer n = this.objPPSDevSlnPipelineLogLock;
        synchronized (n) {
            if (this.ppsdevslnpipelinelog != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevSlnPipelineLogId(), (Object)this.ppsdevslnpipelinelog.getPSDevSlnPipelineLogId()) != 0L) {
                this.ppsdevslnpipelinelog = null;
            }
            if (this.ppsdevslnpipelinelog == null) {
                PSDevSlnPipelineLog pSDevSlnPipelineLog = new PSDevSlnPipelineLog();
                pSDevSlnPipelineLog.setPSDevSlnPipelineLogId(this.getPPSDevSlnPipelineLogId());
                PSDevSlnPipelineLogService pSDevSlnPipelineLogService = (PSDevSlnPipelineLogService)ServiceGlobal.getService(PSDevSlnPipelineLogService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineLogService.autoGet(pSDevSlnPipelineLog);
                this.ppsdevslnpipelinelog = pSDevSlnPipelineLog;
            }
            return this.ppsdevslnpipelinelog;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipelineRef getPSDevSlnPipelineRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineRef();
        }
        if (this.getPSDevSlnPipelineRefId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineRefLock;
        synchronized (n) {
            if (this.psdevslnpipelineref != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineRefId(), (Object)this.psdevslnpipelineref.getPSDevSlnPipelineRefId()) != 0L) {
                this.psdevslnpipelineref = null;
            }
            if (this.psdevslnpipelineref == null) {
                PSDevSlnPipelineRef pSDevSlnPipelineRef = new PSDevSlnPipelineRef();
                pSDevSlnPipelineRef.setPSDevSlnPipelineRefId(this.getPSDevSlnPipelineRefId());
                PSDevSlnPipelineRefService pSDevSlnPipelineRefService = (PSDevSlnPipelineRefService)ServiceGlobal.getService(PSDevSlnPipelineRefService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineRefService.autoGet(pSDevSlnPipelineRef);
                this.psdevslnpipelineref = pSDevSlnPipelineRef;
            }
            return this.psdevslnpipelineref;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipelineStage getPSDevSlnPipelineStage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStage();
        }
        if (this.getPSDevSlnPipelineStageId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineStageLock;
        synchronized (n) {
            if (this.psdevslnpipelinestage != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineStageId(), (Object)this.psdevslnpipelinestage.getPSDevSlnPipelineStageId()) != 0L) {
                this.psdevslnpipelinestage = null;
            }
            if (this.psdevslnpipelinestage == null) {
                PSDevSlnPipelineStage pSDevSlnPipelineStage = new PSDevSlnPipelineStage();
                pSDevSlnPipelineStage.setPSDevSlnPipelineStageId(this.getPSDevSlnPipelineStageId());
                PSDevSlnPipelineStageService pSDevSlnPipelineStageService = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineStageService.autoGet(pSDevSlnPipelineStage);
                this.psdevslnpipelinestage = pSDevSlnPipelineStage;
            }
            return this.psdevslnpipelinestage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipelineStep getPSDevSlnPipelineStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStep();
        }
        if (this.getPSDevSlnPipelineStepId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineStepLock;
        synchronized (n) {
            if (this.psdevslnpipelinestep != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineStepId(), (Object)this.psdevslnpipelinestep.getPSDevSlnPipelineStepId()) != 0L) {
                this.psdevslnpipelinestep = null;
            }
            if (this.psdevslnpipelinestep == null) {
                PSDevSlnPipelineStep pSDevSlnPipelineStep = new PSDevSlnPipelineStep();
                pSDevSlnPipelineStep.setPSDevSlnPipelineStepId(this.getPSDevSlnPipelineStepId());
                PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineStepService.autoGet(pSDevSlnPipelineStep);
                this.psdevslnpipelinestep = pSDevSlnPipelineStep;
            }
            return this.psdevslnpipelinestep;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipeline();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.psdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineId(), (Object)this.psdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.psdevslnpipeline = null;
            }
            if (this.psdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet(pSDevSlnPipeline);
                this.psdevslnpipeline = pSDevSlnPipeline;
            }
            return this.psdevslnpipeline;
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnPipelineLogBase getProxyEntity() {
        return this.proxyPSDevSlnPipelineLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnPipelineLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnPipelineLogBase) {
            this.proxyPSDevSlnPipelineLogBase = (PSDevSlnPipelineLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAMS, 0);
        fieldIndexMap.put(FIELD_ACTIONRESULT, 1);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 2);
        fieldIndexMap.put(FIELD_BEGINTIME, 3);
        fieldIndexMap.put(FIELD_BUILDNUMBER, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DURATION, 7);
        fieldIndexMap.put(FIELD_ENDTIME, 8);
        fieldIndexMap.put(FIELD_PPSDEVSLNPIPELINELOGID, 9);
        fieldIndexMap.put(FIELD_PPSDEVSLNPIPELINELOGNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINELOGID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINELOGNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEREFID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEREFNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTEPID, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTEPNAME, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 25);
        fieldIndexMap.put(FIELD_QUEUEURL, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
    }
}

