/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWAsyncActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWAsyncActionBase.class);
    public static final String FIELD_ACTIONINFO = "ACTIONINFO";
    public static final String FIELD_ACTIONOPTION = "ACTIONOPTION";
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FULLRESULTINFO = "FULLRESULTINFO";
    public static final String FIELD_LINKINFO = "LINKINFO";
    public static final String FIELD_MODELACTION = "MODELACTION";
    public static final String FIELD_MODELNAME = "MODELNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSUWASYNCACTIONID = "PSUWASYNCACTIONID";
    public static final String FIELD_PSUWASYNCACTIONNAME = "PSUWASYNCACTIONNAME";
    public static final String FIELD_QUEUEINFO = "QUEUEINFO";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONINFO = 0;
    private static final int INDEX_ACTIONOPTION = 1;
    private static final int INDEX_ACTIONPARAM = 2;
    private static final int INDEX_ACTIONPARAM2 = 3;
    private static final int INDEX_ACTIONPARAM3 = 4;
    private static final int INDEX_ACTIONPARAM4 = 5;
    private static final int INDEX_ACTIONRESULT = 6;
    private static final int INDEX_ACTIONSTATE = 7;
    private static final int INDEX_ACTIONTYPE = 8;
    private static final int INDEX_BEGINTIME = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_ENDTIME = 12;
    private static final int INDEX_FULLRESULTINFO = 13;
    private static final int INDEX_LINKINFO = 14;
    private static final int INDEX_MODELACTION = 15;
    private static final int INDEX_MODELNAME = 16;
    private static final int INDEX_PSDEVSLNSYSID = 17;
    private static final int INDEX_PSDSCONSOLEID = 18;
    private static final int INDEX_PSDYNAINSTID = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSUWASYNCACTIONID = 21;
    private static final int INDEX_PSUWASYNCACTIONNAME = 22;
    private static final int INDEX_QUEUEINFO = 23;
    private static final int INDEX_REMOTEADDR = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWAsyncActionBase proxyPSUWAsyncActionBase = null;
    private boolean actioninfoDirtyFlag = false;
    private boolean actionoptionDirtyFlag = false;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fullresultinfoDirtyFlag = false;
    private boolean linkinfoDirtyFlag = false;
    private boolean modelactionDirtyFlag = false;
    private boolean modelnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean psuwasyncactionidDirtyFlag = false;
    private boolean psuwasyncactionnameDirtyFlag = false;
    private boolean queueinfoDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actioninfo")
    private String actioninfo;
    @Column(name="actionoption")
    private String actionoption;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="actionparam2")
    private String actionparam2;
    @Column(name="actionparam3")
    private String actionparam3;
    @Column(name="actionparam4")
    private String actionparam4;
    @Column(name="actionresult")
    private String actionresult;
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
    @Column(name="fullresultinfo")
    private String fullresultinfo;
    @Column(name="linkinfo")
    private String linkinfo;
    @Column(name="modelaction")
    private String modelaction;
    @Column(name="modelname")
    private String modelname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="psuwasyncactionid")
    private String psuwasyncactionid;
    @Column(name="psuwasyncactionname")
    private String psuwasyncactionname;
    @Column(name="queueinfo")
    private String queueinfo;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setActionInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actioninfo = string;
        this.actioninfoDirtyFlag = true;
    }

    public String getActionInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionInfo();
        }
        return this.actioninfo;
    }

    public boolean isActionInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionInfoDirty();
        }
        return this.actioninfoDirtyFlag;
    }

    public void resetActionInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionInfo();
            return;
        }
        this.actioninfoDirtyFlag = false;
        this.actioninfo = null;
    }

    public void setActionOption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionoption = string;
        this.actionoptionDirtyFlag = true;
    }

    public String getActionOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOption();
        }
        return this.actionoption;
    }

    public boolean isActionOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOptionDirty();
        }
        return this.actionoptionDirtyFlag;
    }

    public void resetActionOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOption();
            return;
        }
        this.actionoptionDirtyFlag = false;
        this.actionoption = null;
    }

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

    public void setFullResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullresultinfo = string;
        this.fullresultinfoDirtyFlag = true;
    }

    public String getFullResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullResultInfo();
        }
        return this.fullresultinfo;
    }

    public boolean isFullResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullResultInfoDirty();
        }
        return this.fullresultinfoDirtyFlag;
    }

    public void resetFullResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullResultInfo();
            return;
        }
        this.fullresultinfoDirtyFlag = false;
        this.fullresultinfo = null;
    }

    public void setLinkInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkinfo = string;
        this.linkinfoDirtyFlag = true;
    }

    public String getLinkInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkInfo();
        }
        return this.linkinfo;
    }

    public boolean isLinkInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkInfoDirty();
        }
        return this.linkinfoDirtyFlag;
    }

    public void resetLinkInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkInfo();
            return;
        }
        this.linkinfoDirtyFlag = false;
        this.linkinfo = null;
    }

    public void setModelAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelaction = string;
        this.modelactionDirtyFlag = true;
    }

    public String getModelAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelAction();
        }
        return this.modelaction;
    }

    public boolean isModelActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelActionDirty();
        }
        return this.modelactionDirtyFlag;
    }

    public void resetModelAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelAction();
            return;
        }
        this.modelactionDirtyFlag = false;
        this.modelaction = null;
    }

    public void setModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelname = string;
        this.modelnameDirtyFlag = true;
    }

    public String getModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelName();
        }
        return this.modelname;
    }

    public boolean isModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelNameDirty();
        }
        return this.modelnameDirtyFlag;
    }

    public void resetModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelName();
            return;
        }
        this.modelnameDirtyFlag = false;
        this.modelname = null;
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

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
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

    public void setPSUWAsyncActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAsyncActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwasyncactionid = string;
        this.psuwasyncactionidDirtyFlag = true;
    }

    public String getPSUWAsyncActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAsyncActionId();
        }
        return this.psuwasyncactionid;
    }

    public boolean isPSUWAsyncActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAsyncActionIdDirty();
        }
        return this.psuwasyncactionidDirtyFlag;
    }

    public void resetPSUWAsyncActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAsyncActionId();
            return;
        }
        this.psuwasyncactionidDirtyFlag = false;
        this.psuwasyncactionid = null;
    }

    public void setPSUWAsyncActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAsyncActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwasyncactionname = string;
        this.psuwasyncactionnameDirtyFlag = true;
    }

    public String getPSUWAsyncActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAsyncActionName();
        }
        return this.psuwasyncactionname;
    }

    public boolean isPSUWAsyncActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAsyncActionNameDirty();
        }
        return this.psuwasyncactionnameDirtyFlag;
    }

    public void resetPSUWAsyncActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAsyncActionName();
            return;
        }
        this.psuwasyncactionnameDirtyFlag = false;
        this.psuwasyncactionname = null;
    }

    public void setQueueInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueueInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.queueinfo = string;
        this.queueinfoDirtyFlag = true;
    }

    public String getQueueInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueueInfo();
        }
        return this.queueinfo;
    }

    public boolean isQueueInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueueInfoDirty();
        }
        return this.queueinfoDirtyFlag;
    }

    public void resetQueueInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueueInfo();
            return;
        }
        this.queueinfoDirtyFlag = false;
        this.queueinfo = null;
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

    protected void onReset() {
        PSUWAsyncActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWAsyncActionBase pSUWAsyncActionBase) {
        pSUWAsyncActionBase.resetActionInfo();
        pSUWAsyncActionBase.resetActionOption();
        pSUWAsyncActionBase.resetActionParam();
        pSUWAsyncActionBase.resetActionParam2();
        pSUWAsyncActionBase.resetActionParam3();
        pSUWAsyncActionBase.resetActionParam4();
        pSUWAsyncActionBase.resetActionResult();
        pSUWAsyncActionBase.resetActionState();
        pSUWAsyncActionBase.resetActionType();
        pSUWAsyncActionBase.resetBeginTime();
        pSUWAsyncActionBase.resetCreateDate();
        pSUWAsyncActionBase.resetCreateMan();
        pSUWAsyncActionBase.resetEndTime();
        pSUWAsyncActionBase.resetFullResultInfo();
        pSUWAsyncActionBase.resetLinkInfo();
        pSUWAsyncActionBase.resetModelAction();
        pSUWAsyncActionBase.resetModelName();
        pSUWAsyncActionBase.resetPSDevSlnSysId();
        pSUWAsyncActionBase.resetPSDSConsoleId();
        pSUWAsyncActionBase.resetPSDynaInstId();
        pSUWAsyncActionBase.resetPSSystemId();
        pSUWAsyncActionBase.resetPSUWAsyncActionId();
        pSUWAsyncActionBase.resetPSUWAsyncActionName();
        pSUWAsyncActionBase.resetQueueInfo();
        pSUWAsyncActionBase.resetRemoteAddr();
        pSUWAsyncActionBase.resetUpdateDate();
        pSUWAsyncActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionInfoDirty()) {
            hashMap.put(FIELD_ACTIONINFO, this.getActionInfo());
        }
        if (!bl || this.isActionOptionDirty()) {
            hashMap.put(FIELD_ACTIONOPTION, this.getActionOption());
        }
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
        if (!bl || this.isActionResultDirty()) {
            hashMap.put(FIELD_ACTIONRESULT, this.getActionResult());
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
        if (!bl || this.isFullResultInfoDirty()) {
            hashMap.put(FIELD_FULLRESULTINFO, this.getFullResultInfo());
        }
        if (!bl || this.isLinkInfoDirty()) {
            hashMap.put(FIELD_LINKINFO, this.getLinkInfo());
        }
        if (!bl || this.isModelActionDirty()) {
            hashMap.put(FIELD_MODELACTION, this.getModelAction());
        }
        if (!bl || this.isModelNameDirty()) {
            hashMap.put(FIELD_MODELNAME, this.getModelName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSUWAsyncActionIdDirty()) {
            hashMap.put(FIELD_PSUWASYNCACTIONID, this.getPSUWAsyncActionId());
        }
        if (!bl || this.isPSUWAsyncActionNameDirty()) {
            hashMap.put(FIELD_PSUWASYNCACTIONNAME, this.getPSUWAsyncActionName());
        }
        if (!bl || this.isQueueInfoDirty()) {
            hashMap.put(FIELD_QUEUEINFO, this.getQueueInfo());
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
        return PSUWAsyncActionBase.get(this, n);
    }

    private static Object get(PSUWAsyncActionBase pSUWAsyncActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAsyncActionBase.getActionInfo();
            }
            case 1: {
                return pSUWAsyncActionBase.getActionOption();
            }
            case 2: {
                return pSUWAsyncActionBase.getActionParam();
            }
            case 3: {
                return pSUWAsyncActionBase.getActionParam2();
            }
            case 4: {
                return pSUWAsyncActionBase.getActionParam3();
            }
            case 5: {
                return pSUWAsyncActionBase.getActionParam4();
            }
            case 6: {
                return pSUWAsyncActionBase.getActionResult();
            }
            case 7: {
                return pSUWAsyncActionBase.getActionState();
            }
            case 8: {
                return pSUWAsyncActionBase.getActionType();
            }
            case 9: {
                return pSUWAsyncActionBase.getBeginTime();
            }
            case 10: {
                return pSUWAsyncActionBase.getCreateDate();
            }
            case 11: {
                return pSUWAsyncActionBase.getCreateMan();
            }
            case 12: {
                return pSUWAsyncActionBase.getEndTime();
            }
            case 13: {
                return pSUWAsyncActionBase.getFullResultInfo();
            }
            case 14: {
                return pSUWAsyncActionBase.getLinkInfo();
            }
            case 15: {
                return pSUWAsyncActionBase.getModelAction();
            }
            case 16: {
                return pSUWAsyncActionBase.getModelName();
            }
            case 17: {
                return pSUWAsyncActionBase.getPSDevSlnSysId();
            }
            case 18: {
                return pSUWAsyncActionBase.getPSDSConsoleId();
            }
            case 19: {
                return pSUWAsyncActionBase.getPSDynaInstId();
            }
            case 20: {
                return pSUWAsyncActionBase.getPSSystemId();
            }
            case 21: {
                return pSUWAsyncActionBase.getPSUWAsyncActionId();
            }
            case 22: {
                return pSUWAsyncActionBase.getPSUWAsyncActionName();
            }
            case 23: {
                return pSUWAsyncActionBase.getQueueInfo();
            }
            case 24: {
                return pSUWAsyncActionBase.getRemoteAddr();
            }
            case 25: {
                return pSUWAsyncActionBase.getUpdateDate();
            }
            case 26: {
                return pSUWAsyncActionBase.getUpdateMan();
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
        PSUWAsyncActionBase.set(this, n, object);
    }

    private static void set(PSUWAsyncActionBase pSUWAsyncActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWAsyncActionBase.setActionInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWAsyncActionBase.setActionOption(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWAsyncActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWAsyncActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWAsyncActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWAsyncActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWAsyncActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWAsyncActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSUWAsyncActionBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWAsyncActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSUWAsyncActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSUWAsyncActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWAsyncActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSUWAsyncActionBase.setFullResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWAsyncActionBase.setLinkInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWAsyncActionBase.setModelAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWAsyncActionBase.setModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWAsyncActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWAsyncActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWAsyncActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWAsyncActionBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSUWAsyncActionBase.setPSUWAsyncActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWAsyncActionBase.setPSUWAsyncActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWAsyncActionBase.setQueueInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWAsyncActionBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSUWAsyncActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSUWAsyncActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUWAsyncActionBase.isNull(this, n);
    }

    private static boolean isNull(PSUWAsyncActionBase pSUWAsyncActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAsyncActionBase.getActionInfo() == null;
            }
            case 1: {
                return pSUWAsyncActionBase.getActionOption() == null;
            }
            case 2: {
                return pSUWAsyncActionBase.getActionParam() == null;
            }
            case 3: {
                return pSUWAsyncActionBase.getActionParam2() == null;
            }
            case 4: {
                return pSUWAsyncActionBase.getActionParam3() == null;
            }
            case 5: {
                return pSUWAsyncActionBase.getActionParam4() == null;
            }
            case 6: {
                return pSUWAsyncActionBase.getActionResult() == null;
            }
            case 7: {
                return pSUWAsyncActionBase.getActionState() == null;
            }
            case 8: {
                return pSUWAsyncActionBase.getActionType() == null;
            }
            case 9: {
                return pSUWAsyncActionBase.getBeginTime() == null;
            }
            case 10: {
                return pSUWAsyncActionBase.getCreateDate() == null;
            }
            case 11: {
                return pSUWAsyncActionBase.getCreateMan() == null;
            }
            case 12: {
                return pSUWAsyncActionBase.getEndTime() == null;
            }
            case 13: {
                return pSUWAsyncActionBase.getFullResultInfo() == null;
            }
            case 14: {
                return pSUWAsyncActionBase.getLinkInfo() == null;
            }
            case 15: {
                return pSUWAsyncActionBase.getModelAction() == null;
            }
            case 16: {
                return pSUWAsyncActionBase.getModelName() == null;
            }
            case 17: {
                return pSUWAsyncActionBase.getPSDevSlnSysId() == null;
            }
            case 18: {
                return pSUWAsyncActionBase.getPSDSConsoleId() == null;
            }
            case 19: {
                return pSUWAsyncActionBase.getPSDynaInstId() == null;
            }
            case 20: {
                return pSUWAsyncActionBase.getPSSystemId() == null;
            }
            case 21: {
                return pSUWAsyncActionBase.getPSUWAsyncActionId() == null;
            }
            case 22: {
                return pSUWAsyncActionBase.getPSUWAsyncActionName() == null;
            }
            case 23: {
                return pSUWAsyncActionBase.getQueueInfo() == null;
            }
            case 24: {
                return pSUWAsyncActionBase.getRemoteAddr() == null;
            }
            case 25: {
                return pSUWAsyncActionBase.getUpdateDate() == null;
            }
            case 26: {
                return pSUWAsyncActionBase.getUpdateMan() == null;
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
        return PSUWAsyncActionBase.contains(this, n);
    }

    private static boolean contains(PSUWAsyncActionBase pSUWAsyncActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAsyncActionBase.isActionInfoDirty();
            }
            case 1: {
                return pSUWAsyncActionBase.isActionOptionDirty();
            }
            case 2: {
                return pSUWAsyncActionBase.isActionParamDirty();
            }
            case 3: {
                return pSUWAsyncActionBase.isActionParam2Dirty();
            }
            case 4: {
                return pSUWAsyncActionBase.isActionParam3Dirty();
            }
            case 5: {
                return pSUWAsyncActionBase.isActionParam4Dirty();
            }
            case 6: {
                return pSUWAsyncActionBase.isActionResultDirty();
            }
            case 7: {
                return pSUWAsyncActionBase.isActionStateDirty();
            }
            case 8: {
                return pSUWAsyncActionBase.isActionTypeDirty();
            }
            case 9: {
                return pSUWAsyncActionBase.isBeginTimeDirty();
            }
            case 10: {
                return pSUWAsyncActionBase.isCreateDateDirty();
            }
            case 11: {
                return pSUWAsyncActionBase.isCreateManDirty();
            }
            case 12: {
                return pSUWAsyncActionBase.isEndTimeDirty();
            }
            case 13: {
                return pSUWAsyncActionBase.isFullResultInfoDirty();
            }
            case 14: {
                return pSUWAsyncActionBase.isLinkInfoDirty();
            }
            case 15: {
                return pSUWAsyncActionBase.isModelActionDirty();
            }
            case 16: {
                return pSUWAsyncActionBase.isModelNameDirty();
            }
            case 17: {
                return pSUWAsyncActionBase.isPSDevSlnSysIdDirty();
            }
            case 18: {
                return pSUWAsyncActionBase.isPSDSConsoleIdDirty();
            }
            case 19: {
                return pSUWAsyncActionBase.isPSDynaInstIdDirty();
            }
            case 20: {
                return pSUWAsyncActionBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSUWAsyncActionBase.isPSUWAsyncActionIdDirty();
            }
            case 22: {
                return pSUWAsyncActionBase.isPSUWAsyncActionNameDirty();
            }
            case 23: {
                return pSUWAsyncActionBase.isQueueInfoDirty();
            }
            case 24: {
                return pSUWAsyncActionBase.isRemoteAddrDirty();
            }
            case 25: {
                return pSUWAsyncActionBase.isUpdateDateDirty();
            }
            case 26: {
                return pSUWAsyncActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWAsyncActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWAsyncActionBase pSUWAsyncActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWAsyncActionBase.getActionInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actioninfo", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionInfo()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionoption", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionOption()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getActionType()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getFullResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullresultinfo", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getFullResultInfo()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getLinkInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getLinkInfo()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getModelAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelaction", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getModelAction()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelname", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getModelName()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSUWAsyncActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwasyncactionid", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSUWAsyncActionId()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getPSUWAsyncActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwasyncactionname", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getPSUWAsyncActionName()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getQueueInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueinfo", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getQueueInfo()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWAsyncActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWAsyncActionBase.getJSONValue((Object)pSUWAsyncActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWAsyncActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWAsyncActionBase pSUWAsyncActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWAsyncActionBase.getActionInfo() != null) {
            object = pSUWAsyncActionBase.getActionInfo();
            xmlNode.setAttribute(FIELD_ACTIONINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionOption() != null) {
            object = pSUWAsyncActionBase.getActionOption();
            xmlNode.setAttribute(FIELD_ACTIONOPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionParam() != null) {
            object = pSUWAsyncActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionParam2() != null) {
            object = pSUWAsyncActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionParam3() != null) {
            object = pSUWAsyncActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionParam4() != null) {
            object = pSUWAsyncActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAsyncActionBase.getActionResult() != null) {
            object = pSUWAsyncActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getActionState() != null) {
            object = pSUWAsyncActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAsyncActionBase.getActionType() != null) {
            object = pSUWAsyncActionBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getBeginTime() != null) {
            object = pSUWAsyncActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAsyncActionBase.getCreateDate() != null) {
            object = pSUWAsyncActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAsyncActionBase.getCreateMan() != null) {
            object = pSUWAsyncActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getEndTime() != null) {
            object = pSUWAsyncActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAsyncActionBase.getFullResultInfo() != null) {
            object = pSUWAsyncActionBase.getFullResultInfo();
            xmlNode.setAttribute(FIELD_FULLRESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getLinkInfo() != null) {
            object = pSUWAsyncActionBase.getLinkInfo();
            xmlNode.setAttribute(FIELD_LINKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getModelAction() != null) {
            object = pSUWAsyncActionBase.getModelAction();
            xmlNode.setAttribute(FIELD_MODELACTION, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getModelName() != null) {
            object = pSUWAsyncActionBase.getModelName();
            xmlNode.setAttribute(FIELD_MODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSDevSlnSysId() != null) {
            object = pSUWAsyncActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSDSConsoleId() != null) {
            object = pSUWAsyncActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSDynaInstId() != null) {
            object = pSUWAsyncActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSSystemId() != null) {
            object = pSUWAsyncActionBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSUWAsyncActionId() != null) {
            object = pSUWAsyncActionBase.getPSUWAsyncActionId();
            xmlNode.setAttribute(FIELD_PSUWASYNCACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getPSUWAsyncActionName() != null) {
            object = pSUWAsyncActionBase.getPSUWAsyncActionName();
            xmlNode.setAttribute(FIELD_PSUWASYNCACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getQueueInfo() != null) {
            object = pSUWAsyncActionBase.getQueueInfo();
            xmlNode.setAttribute(FIELD_QUEUEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getRemoteAddr() != null) {
            object = pSUWAsyncActionBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSUWAsyncActionBase.getUpdateDate() != null) {
            object = pSUWAsyncActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAsyncActionBase.getUpdateMan() != null) {
            object = pSUWAsyncActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWAsyncActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWAsyncActionBase pSUWAsyncActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWAsyncActionBase.isActionInfoDirty() && (bl || pSUWAsyncActionBase.getActionInfo() != null)) {
            iDataObject.set(FIELD_ACTIONINFO, (Object)pSUWAsyncActionBase.getActionInfo());
        }
        if (pSUWAsyncActionBase.isActionOptionDirty() && (bl || pSUWAsyncActionBase.getActionOption() != null)) {
            iDataObject.set(FIELD_ACTIONOPTION, (Object)pSUWAsyncActionBase.getActionOption());
        }
        if (pSUWAsyncActionBase.isActionParamDirty() && (bl || pSUWAsyncActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSUWAsyncActionBase.getActionParam());
        }
        if (pSUWAsyncActionBase.isActionParam2Dirty() && (bl || pSUWAsyncActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSUWAsyncActionBase.getActionParam2());
        }
        if (pSUWAsyncActionBase.isActionParam3Dirty() && (bl || pSUWAsyncActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSUWAsyncActionBase.getActionParam3());
        }
        if (pSUWAsyncActionBase.isActionParam4Dirty() && (bl || pSUWAsyncActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSUWAsyncActionBase.getActionParam4());
        }
        if (pSUWAsyncActionBase.isActionResultDirty() && (bl || pSUWAsyncActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSUWAsyncActionBase.getActionResult());
        }
        if (pSUWAsyncActionBase.isActionStateDirty() && (bl || pSUWAsyncActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSUWAsyncActionBase.getActionState());
        }
        if (pSUWAsyncActionBase.isActionTypeDirty() && (bl || pSUWAsyncActionBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSUWAsyncActionBase.getActionType());
        }
        if (pSUWAsyncActionBase.isBeginTimeDirty() && (bl || pSUWAsyncActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSUWAsyncActionBase.getBeginTime());
        }
        if (pSUWAsyncActionBase.isCreateDateDirty() && (bl || pSUWAsyncActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWAsyncActionBase.getCreateDate());
        }
        if (pSUWAsyncActionBase.isCreateManDirty() && (bl || pSUWAsyncActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWAsyncActionBase.getCreateMan());
        }
        if (pSUWAsyncActionBase.isEndTimeDirty() && (bl || pSUWAsyncActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSUWAsyncActionBase.getEndTime());
        }
        if (pSUWAsyncActionBase.isFullResultInfoDirty() && (bl || pSUWAsyncActionBase.getFullResultInfo() != null)) {
            iDataObject.set(FIELD_FULLRESULTINFO, (Object)pSUWAsyncActionBase.getFullResultInfo());
        }
        if (pSUWAsyncActionBase.isLinkInfoDirty() && (bl || pSUWAsyncActionBase.getLinkInfo() != null)) {
            iDataObject.set(FIELD_LINKINFO, (Object)pSUWAsyncActionBase.getLinkInfo());
        }
        if (pSUWAsyncActionBase.isModelActionDirty() && (bl || pSUWAsyncActionBase.getModelAction() != null)) {
            iDataObject.set(FIELD_MODELACTION, (Object)pSUWAsyncActionBase.getModelAction());
        }
        if (pSUWAsyncActionBase.isModelNameDirty() && (bl || pSUWAsyncActionBase.getModelName() != null)) {
            iDataObject.set(FIELD_MODELNAME, (Object)pSUWAsyncActionBase.getModelName());
        }
        if (pSUWAsyncActionBase.isPSDevSlnSysIdDirty() && (bl || pSUWAsyncActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSUWAsyncActionBase.getPSDevSlnSysId());
        }
        if (pSUWAsyncActionBase.isPSDSConsoleIdDirty() && (bl || pSUWAsyncActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSUWAsyncActionBase.getPSDSConsoleId());
        }
        if (pSUWAsyncActionBase.isPSDynaInstIdDirty() && (bl || pSUWAsyncActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWAsyncActionBase.getPSDynaInstId());
        }
        if (pSUWAsyncActionBase.isPSSystemIdDirty() && (bl || pSUWAsyncActionBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSUWAsyncActionBase.getPSSystemId());
        }
        if (pSUWAsyncActionBase.isPSUWAsyncActionIdDirty() && (bl || pSUWAsyncActionBase.getPSUWAsyncActionId() != null)) {
            iDataObject.set(FIELD_PSUWASYNCACTIONID, (Object)pSUWAsyncActionBase.getPSUWAsyncActionId());
        }
        if (pSUWAsyncActionBase.isPSUWAsyncActionNameDirty() && (bl || pSUWAsyncActionBase.getPSUWAsyncActionName() != null)) {
            iDataObject.set(FIELD_PSUWASYNCACTIONNAME, (Object)pSUWAsyncActionBase.getPSUWAsyncActionName());
        }
        if (pSUWAsyncActionBase.isQueueInfoDirty() && (bl || pSUWAsyncActionBase.getQueueInfo() != null)) {
            iDataObject.set(FIELD_QUEUEINFO, (Object)pSUWAsyncActionBase.getQueueInfo());
        }
        if (pSUWAsyncActionBase.isRemoteAddrDirty() && (bl || pSUWAsyncActionBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSUWAsyncActionBase.getRemoteAddr());
        }
        if (pSUWAsyncActionBase.isUpdateDateDirty() && (bl || pSUWAsyncActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWAsyncActionBase.getUpdateDate());
        }
        if (pSUWAsyncActionBase.isUpdateManDirty() && (bl || pSUWAsyncActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWAsyncActionBase.getUpdateMan());
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
        return PSUWAsyncActionBase.remove(this, n);
    }

    private static boolean remove(PSUWAsyncActionBase pSUWAsyncActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWAsyncActionBase.resetActionInfo();
                return true;
            }
            case 1: {
                pSUWAsyncActionBase.resetActionOption();
                return true;
            }
            case 2: {
                pSUWAsyncActionBase.resetActionParam();
                return true;
            }
            case 3: {
                pSUWAsyncActionBase.resetActionParam2();
                return true;
            }
            case 4: {
                pSUWAsyncActionBase.resetActionParam3();
                return true;
            }
            case 5: {
                pSUWAsyncActionBase.resetActionParam4();
                return true;
            }
            case 6: {
                pSUWAsyncActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSUWAsyncActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSUWAsyncActionBase.resetActionType();
                return true;
            }
            case 9: {
                pSUWAsyncActionBase.resetBeginTime();
                return true;
            }
            case 10: {
                pSUWAsyncActionBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSUWAsyncActionBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSUWAsyncActionBase.resetEndTime();
                return true;
            }
            case 13: {
                pSUWAsyncActionBase.resetFullResultInfo();
                return true;
            }
            case 14: {
                pSUWAsyncActionBase.resetLinkInfo();
                return true;
            }
            case 15: {
                pSUWAsyncActionBase.resetModelAction();
                return true;
            }
            case 16: {
                pSUWAsyncActionBase.resetModelName();
                return true;
            }
            case 17: {
                pSUWAsyncActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 18: {
                pSUWAsyncActionBase.resetPSDSConsoleId();
                return true;
            }
            case 19: {
                pSUWAsyncActionBase.resetPSDynaInstId();
                return true;
            }
            case 20: {
                pSUWAsyncActionBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSUWAsyncActionBase.resetPSUWAsyncActionId();
                return true;
            }
            case 22: {
                pSUWAsyncActionBase.resetPSUWAsyncActionName();
                return true;
            }
            case 23: {
                pSUWAsyncActionBase.resetQueueInfo();
                return true;
            }
            case 24: {
                pSUWAsyncActionBase.resetRemoteAddr();
                return true;
            }
            case 25: {
                pSUWAsyncActionBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSUWAsyncActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWAsyncActionBase getProxyEntity() {
        return this.proxyPSUWAsyncActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWAsyncActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWAsyncActionBase) {
            this.proxyPSUWAsyncActionBase = (PSUWAsyncActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWAsyncActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONINFO, 0);
        fieldIndexMap.put(FIELD_ACTIONOPTION, 1);
        fieldIndexMap.put(FIELD_ACTIONPARAM, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAM2, 3);
        fieldIndexMap.put(FIELD_ACTIONPARAM3, 4);
        fieldIndexMap.put(FIELD_ACTIONPARAM4, 5);
        fieldIndexMap.put(FIELD_ACTIONRESULT, 6);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 7);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 8);
        fieldIndexMap.put(FIELD_BEGINTIME, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_ENDTIME, 12);
        fieldIndexMap.put(FIELD_FULLRESULTINFO, 13);
        fieldIndexMap.put(FIELD_LINKINFO, 14);
        fieldIndexMap.put(FIELD_MODELACTION, 15);
        fieldIndexMap.put(FIELD_MODELNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 17);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 18);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSUWASYNCACTIONID, 21);
        fieldIndexMap.put(FIELD_PSUWASYNCACTIONNAME, 22);
        fieldIndexMap.put(FIELD_QUEUEINFO, 23);
        fieldIndexMap.put(FIELD_REMOTEADDR, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
    }
}

