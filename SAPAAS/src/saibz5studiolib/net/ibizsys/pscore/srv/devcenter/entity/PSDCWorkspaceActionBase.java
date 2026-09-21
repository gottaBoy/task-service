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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkspaceActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWorkspaceActionBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String FIELD_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PSDCWORKSPACEACTIONID = "PSDCWORKSPACEACTIONID";
    public static final String FIELD_PSDCWORKSPACEACTIONNAME = "PSDCWORKSPACEACTIONNAME";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ACTIONPARAM = 0;
    private static final int INDEX_ACTIONPARAM2 = 1;
    private static final int INDEX_ACTIONPARAM3 = 2;
    private static final int INDEX_ACTIONPARAM4 = 3;
    private static final int INDEX_ACTIONPARAM5 = 4;
    private static final int INDEX_ACTIONPARAM6 = 5;
    private static final int INDEX_ACTIONRESULT = 6;
    private static final int INDEX_ACTIONSTATE = 7;
    private static final int INDEX_ACTIONTYPE = 8;
    private static final int INDEX_BEGINTIME = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_ENDTIME = 12;
    private static final int INDEX_PSDCWORKSPACEACTIONID = 13;
    private static final int INDEX_PSDCWORKSPACEACTIONNAME = 14;
    private static final int INDEX_PSDCWORKSPACEID = 15;
    private static final int INDEX_PSDCWORKSPACENAME = 16;
    private static final int INDEX_PSDEVCENTERID = 17;
    private static final int INDEX_PSDEVCENTERNAME = 18;
    private static final int INDEX_PSDEVSLNID = 19;
    private static final int INDEX_PSDEVSLNSYSID = 20;
    private static final int INDEX_PSDSCONSOLEID = 21;
    private static final int INDEX_PSTASKSERVERID = 22;
    private static final int INDEX_PSTASKSERVERNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWorkspaceActionBase proxyPSDCWorkspaceActionBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionparam5DirtyFlag = false;
    private boolean actionparam6DirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean psdcworkspaceactionidDirtyFlag = false;
    private boolean psdcworkspaceactionnameDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
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
    @Column(name="psdcworkspaceactionid")
    private String psdcworkspaceactionid;
    @Column(name="psdcworkspaceactionname")
    private String psdcworkspaceactionname;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacename")
    private String psdcworkspacename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDCWorkspaceLock = new Integer(1);
    private PSDCWorkspace psdcworkspace = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setPSDCWorkspaceActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceactionid = string;
        this.psdcworkspaceactionidDirtyFlag = true;
    }

    public String getPSDCWorkspaceActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceActionId();
        }
        return this.psdcworkspaceactionid;
    }

    public boolean isPSDCWorkspaceActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceActionIdDirty();
        }
        return this.psdcworkspaceactionidDirtyFlag;
    }

    public void resetPSDCWorkspaceActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceActionId();
            return;
        }
        this.psdcworkspaceactionidDirtyFlag = false;
        this.psdcworkspaceactionid = null;
    }

    public void setPSDCWorkspaceActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceactionname = string;
        this.psdcworkspaceactionnameDirtyFlag = true;
    }

    public String getPSDCWorkspaceActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceActionName();
        }
        return this.psdcworkspaceactionname;
    }

    public boolean isPSDCWorkspaceActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceActionNameDirty();
        }
        return this.psdcworkspaceactionnameDirtyFlag;
    }

    public void resetPSDCWorkspaceActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceActionName();
            return;
        }
        this.psdcworkspaceactionnameDirtyFlag = false;
        this.psdcworkspaceactionname = null;
    }

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDCWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacename = string;
        this.psdcworkspacenameDirtyFlag = true;
    }

    public String getPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceName();
        }
        return this.psdcworkspacename;
    }

    public boolean isPSDCWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceNameDirty();
        }
        return this.psdcworkspacenameDirtyFlag;
    }

    public void resetPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceName();
            return;
        }
        this.psdcworkspacenameDirtyFlag = false;
        this.psdcworkspacename = null;
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

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
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
        PSDCWorkspaceActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWorkspaceActionBase pSDCWorkspaceActionBase) {
        pSDCWorkspaceActionBase.resetActionParam();
        pSDCWorkspaceActionBase.resetActionParam2();
        pSDCWorkspaceActionBase.resetActionParam3();
        pSDCWorkspaceActionBase.resetActionParam4();
        pSDCWorkspaceActionBase.resetActionParam5();
        pSDCWorkspaceActionBase.resetActionParam6();
        pSDCWorkspaceActionBase.resetActionResult();
        pSDCWorkspaceActionBase.resetActionState();
        pSDCWorkspaceActionBase.resetActionType();
        pSDCWorkspaceActionBase.resetBeginTime();
        pSDCWorkspaceActionBase.resetCreateDate();
        pSDCWorkspaceActionBase.resetCreateMan();
        pSDCWorkspaceActionBase.resetEndTime();
        pSDCWorkspaceActionBase.resetPSDCWorkspaceActionId();
        pSDCWorkspaceActionBase.resetPSDCWorkspaceActionName();
        pSDCWorkspaceActionBase.resetPSDCWorkspaceId();
        pSDCWorkspaceActionBase.resetPSDCWorkspaceName();
        pSDCWorkspaceActionBase.resetPSDevCenterId();
        pSDCWorkspaceActionBase.resetPSDevCenterName();
        pSDCWorkspaceActionBase.resetPSDevSlnId();
        pSDCWorkspaceActionBase.resetPSDevSlnSysId();
        pSDCWorkspaceActionBase.resetPSDSConsoleId();
        pSDCWorkspaceActionBase.resetPSTaskServerId();
        pSDCWorkspaceActionBase.resetPSTaskServerName();
        pSDCWorkspaceActionBase.resetUpdateDate();
        pSDCWorkspaceActionBase.resetUpdateMan();
        pSDCWorkspaceActionBase.resetUserTag();
        pSDCWorkspaceActionBase.resetUserTag2();
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
        if (!bl || this.isPSDCWorkspaceActionIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEACTIONID, this.getPSDCWorkspaceActionId());
        }
        if (!bl || this.isPSDCWorkspaceActionNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEACTIONNAME, this.getPSDCWorkspaceActionName());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACENAME, this.getPSDCWorkspaceName());
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
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        return PSDCWorkspaceActionBase.get(this, n);
    }

    private static Object get(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceActionBase.getActionParam();
            }
            case 1: {
                return pSDCWorkspaceActionBase.getActionParam2();
            }
            case 2: {
                return pSDCWorkspaceActionBase.getActionParam3();
            }
            case 3: {
                return pSDCWorkspaceActionBase.getActionParam4();
            }
            case 4: {
                return pSDCWorkspaceActionBase.getActionParam5();
            }
            case 5: {
                return pSDCWorkspaceActionBase.getActionParam6();
            }
            case 6: {
                return pSDCWorkspaceActionBase.getActionResult();
            }
            case 7: {
                return pSDCWorkspaceActionBase.getActionState();
            }
            case 8: {
                return pSDCWorkspaceActionBase.getActionType();
            }
            case 9: {
                return pSDCWorkspaceActionBase.getBeginTime();
            }
            case 10: {
                return pSDCWorkspaceActionBase.getCreateDate();
            }
            case 11: {
                return pSDCWorkspaceActionBase.getCreateMan();
            }
            case 12: {
                return pSDCWorkspaceActionBase.getEndTime();
            }
            case 13: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceActionId();
            }
            case 14: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceActionName();
            }
            case 15: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceId();
            }
            case 16: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceName();
            }
            case 17: {
                return pSDCWorkspaceActionBase.getPSDevCenterId();
            }
            case 18: {
                return pSDCWorkspaceActionBase.getPSDevCenterName();
            }
            case 19: {
                return pSDCWorkspaceActionBase.getPSDevSlnId();
            }
            case 20: {
                return pSDCWorkspaceActionBase.getPSDevSlnSysId();
            }
            case 21: {
                return pSDCWorkspaceActionBase.getPSDSConsoleId();
            }
            case 22: {
                return pSDCWorkspaceActionBase.getPSTaskServerId();
            }
            case 23: {
                return pSDCWorkspaceActionBase.getPSTaskServerName();
            }
            case 24: {
                return pSDCWorkspaceActionBase.getUpdateDate();
            }
            case 25: {
                return pSDCWorkspaceActionBase.getUpdateMan();
            }
            case 26: {
                return pSDCWorkspaceActionBase.getUserTag();
            }
            case 27: {
                return pSDCWorkspaceActionBase.getUserTag2();
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
        PSDCWorkspaceActionBase.set(this, n, object);
    }

    private static void set(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCWorkspaceActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCWorkspaceActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCWorkspaceActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCWorkspaceActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCWorkspaceActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCWorkspaceActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCWorkspaceActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCWorkspaceActionBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCWorkspaceActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCWorkspaceActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCWorkspaceActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCWorkspaceActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDCWorkspaceActionBase.setPSDCWorkspaceActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCWorkspaceActionBase.setPSDCWorkspaceActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCWorkspaceActionBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCWorkspaceActionBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCWorkspaceActionBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCWorkspaceActionBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCWorkspaceActionBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCWorkspaceActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCWorkspaceActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCWorkspaceActionBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCWorkspaceActionBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCWorkspaceActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDCWorkspaceActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCWorkspaceActionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCWorkspaceActionBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDCWorkspaceActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceActionBase.getActionParam() == null;
            }
            case 1: {
                return pSDCWorkspaceActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSDCWorkspaceActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSDCWorkspaceActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSDCWorkspaceActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSDCWorkspaceActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSDCWorkspaceActionBase.getActionResult() == null;
            }
            case 7: {
                return pSDCWorkspaceActionBase.getActionState() == null;
            }
            case 8: {
                return pSDCWorkspaceActionBase.getActionType() == null;
            }
            case 9: {
                return pSDCWorkspaceActionBase.getBeginTime() == null;
            }
            case 10: {
                return pSDCWorkspaceActionBase.getCreateDate() == null;
            }
            case 11: {
                return pSDCWorkspaceActionBase.getCreateMan() == null;
            }
            case 12: {
                return pSDCWorkspaceActionBase.getEndTime() == null;
            }
            case 13: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceActionId() == null;
            }
            case 14: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceActionName() == null;
            }
            case 15: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceId() == null;
            }
            case 16: {
                return pSDCWorkspaceActionBase.getPSDCWorkspaceName() == null;
            }
            case 17: {
                return pSDCWorkspaceActionBase.getPSDevCenterId() == null;
            }
            case 18: {
                return pSDCWorkspaceActionBase.getPSDevCenterName() == null;
            }
            case 19: {
                return pSDCWorkspaceActionBase.getPSDevSlnId() == null;
            }
            case 20: {
                return pSDCWorkspaceActionBase.getPSDevSlnSysId() == null;
            }
            case 21: {
                return pSDCWorkspaceActionBase.getPSDSConsoleId() == null;
            }
            case 22: {
                return pSDCWorkspaceActionBase.getPSTaskServerId() == null;
            }
            case 23: {
                return pSDCWorkspaceActionBase.getPSTaskServerName() == null;
            }
            case 24: {
                return pSDCWorkspaceActionBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDCWorkspaceActionBase.getUpdateMan() == null;
            }
            case 26: {
                return pSDCWorkspaceActionBase.getUserTag() == null;
            }
            case 27: {
                return pSDCWorkspaceActionBase.getUserTag2() == null;
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
        return PSDCWorkspaceActionBase.contains(this, n);
    }

    private static boolean contains(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceActionBase.isActionParamDirty();
            }
            case 1: {
                return pSDCWorkspaceActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSDCWorkspaceActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSDCWorkspaceActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSDCWorkspaceActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSDCWorkspaceActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSDCWorkspaceActionBase.isActionResultDirty();
            }
            case 7: {
                return pSDCWorkspaceActionBase.isActionStateDirty();
            }
            case 8: {
                return pSDCWorkspaceActionBase.isActionTypeDirty();
            }
            case 9: {
                return pSDCWorkspaceActionBase.isBeginTimeDirty();
            }
            case 10: {
                return pSDCWorkspaceActionBase.isCreateDateDirty();
            }
            case 11: {
                return pSDCWorkspaceActionBase.isCreateManDirty();
            }
            case 12: {
                return pSDCWorkspaceActionBase.isEndTimeDirty();
            }
            case 13: {
                return pSDCWorkspaceActionBase.isPSDCWorkspaceActionIdDirty();
            }
            case 14: {
                return pSDCWorkspaceActionBase.isPSDCWorkspaceActionNameDirty();
            }
            case 15: {
                return pSDCWorkspaceActionBase.isPSDCWorkspaceIdDirty();
            }
            case 16: {
                return pSDCWorkspaceActionBase.isPSDCWorkspaceNameDirty();
            }
            case 17: {
                return pSDCWorkspaceActionBase.isPSDevCenterIdDirty();
            }
            case 18: {
                return pSDCWorkspaceActionBase.isPSDevCenterNameDirty();
            }
            case 19: {
                return pSDCWorkspaceActionBase.isPSDevSlnIdDirty();
            }
            case 20: {
                return pSDCWorkspaceActionBase.isPSDevSlnSysIdDirty();
            }
            case 21: {
                return pSDCWorkspaceActionBase.isPSDSConsoleIdDirty();
            }
            case 22: {
                return pSDCWorkspaceActionBase.isPSTaskServerIdDirty();
            }
            case 23: {
                return pSDCWorkspaceActionBase.isPSTaskServerNameDirty();
            }
            case 24: {
                return pSDCWorkspaceActionBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDCWorkspaceActionBase.isUpdateManDirty();
            }
            case 26: {
                return pSDCWorkspaceActionBase.isUserTagDirty();
            }
            case 27: {
                return pSDCWorkspaceActionBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWorkspaceActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWorkspaceActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getActionType()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceactionid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDCWorkspaceActionId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceactionname", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDCWorkspaceActionName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCWorkspaceActionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCWorkspaceActionBase.getJSONValue((Object)pSDCWorkspaceActionBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWorkspaceActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWorkspaceActionBase.getActionParam() != null) {
            object = pSDCWorkspaceActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam2() != null) {
            object = pSDCWorkspaceActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam3() != null) {
            object = pSDCWorkspaceActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam4() != null) {
            object = pSDCWorkspaceActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam5() != null) {
            object = pSDCWorkspaceActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionParam6() != null) {
            object = pSDCWorkspaceActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionResult() != null) {
            object = pSDCWorkspaceActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getActionState() != null) {
            object = pSDCWorkspaceActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getActionType() != null) {
            object = pSDCWorkspaceActionBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getBeginTime() != null) {
            object = pSDCWorkspaceActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getCreateDate() != null) {
            object = pSDCWorkspaceActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getCreateMan() != null) {
            object = pSDCWorkspaceActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getEndTime() != null) {
            object = pSDCWorkspaceActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionId() != null) {
            object = pSDCWorkspaceActionBase.getPSDCWorkspaceActionId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionName() != null) {
            object = pSDCWorkspaceActionBase.getPSDCWorkspaceActionName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceId() != null) {
            object = pSDCWorkspaceActionBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceName() != null) {
            object = pSDCWorkspaceActionBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevCenterId() != null) {
            object = pSDCWorkspaceActionBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevCenterName() != null) {
            object = pSDCWorkspaceActionBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevSlnId() != null) {
            object = pSDCWorkspaceActionBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDevSlnSysId() != null) {
            object = pSDCWorkspaceActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSDSConsoleId() != null) {
            object = pSDCWorkspaceActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSTaskServerId() != null) {
            object = pSDCWorkspaceActionBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getPSTaskServerName() != null) {
            object = pSDCWorkspaceActionBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getUpdateDate() != null) {
            object = pSDCWorkspaceActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceActionBase.getUpdateMan() != null) {
            object = pSDCWorkspaceActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getUserTag() != null) {
            object = pSDCWorkspaceActionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceActionBase.getUserTag2() != null) {
            object = pSDCWorkspaceActionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWorkspaceActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWorkspaceActionBase.isActionParamDirty() && (bl || pSDCWorkspaceActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSDCWorkspaceActionBase.getActionParam());
        }
        if (pSDCWorkspaceActionBase.isActionParam2Dirty() && (bl || pSDCWorkspaceActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSDCWorkspaceActionBase.getActionParam2());
        }
        if (pSDCWorkspaceActionBase.isActionParam3Dirty() && (bl || pSDCWorkspaceActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSDCWorkspaceActionBase.getActionParam3());
        }
        if (pSDCWorkspaceActionBase.isActionParam4Dirty() && (bl || pSDCWorkspaceActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSDCWorkspaceActionBase.getActionParam4());
        }
        if (pSDCWorkspaceActionBase.isActionParam5Dirty() && (bl || pSDCWorkspaceActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSDCWorkspaceActionBase.getActionParam5());
        }
        if (pSDCWorkspaceActionBase.isActionParam6Dirty() && (bl || pSDCWorkspaceActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSDCWorkspaceActionBase.getActionParam6());
        }
        if (pSDCWorkspaceActionBase.isActionResultDirty() && (bl || pSDCWorkspaceActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSDCWorkspaceActionBase.getActionResult());
        }
        if (pSDCWorkspaceActionBase.isActionStateDirty() && (bl || pSDCWorkspaceActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSDCWorkspaceActionBase.getActionState());
        }
        if (pSDCWorkspaceActionBase.isActionTypeDirty() && (bl || pSDCWorkspaceActionBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSDCWorkspaceActionBase.getActionType());
        }
        if (pSDCWorkspaceActionBase.isBeginTimeDirty() && (bl || pSDCWorkspaceActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCWorkspaceActionBase.getBeginTime());
        }
        if (pSDCWorkspaceActionBase.isCreateDateDirty() && (bl || pSDCWorkspaceActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWorkspaceActionBase.getCreateDate());
        }
        if (pSDCWorkspaceActionBase.isCreateManDirty() && (bl || pSDCWorkspaceActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWorkspaceActionBase.getCreateMan());
        }
        if (pSDCWorkspaceActionBase.isEndTimeDirty() && (bl || pSDCWorkspaceActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCWorkspaceActionBase.getEndTime());
        }
        if (pSDCWorkspaceActionBase.isPSDCWorkspaceActionIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEACTIONID, (Object)pSDCWorkspaceActionBase.getPSDCWorkspaceActionId());
        }
        if (pSDCWorkspaceActionBase.isPSDCWorkspaceActionNameDirty() && (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceActionName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEACTIONNAME, (Object)pSDCWorkspaceActionBase.getPSDCWorkspaceActionName());
        }
        if (pSDCWorkspaceActionBase.isPSDCWorkspaceIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSDCWorkspaceActionBase.getPSDCWorkspaceId());
        }
        if (pSDCWorkspaceActionBase.isPSDCWorkspaceNameDirty() && (bl || pSDCWorkspaceActionBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSDCWorkspaceActionBase.getPSDCWorkspaceName());
        }
        if (pSDCWorkspaceActionBase.isPSDevCenterIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCWorkspaceActionBase.getPSDevCenterId());
        }
        if (pSDCWorkspaceActionBase.isPSDevCenterNameDirty() && (bl || pSDCWorkspaceActionBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCWorkspaceActionBase.getPSDevCenterName());
        }
        if (pSDCWorkspaceActionBase.isPSDevSlnIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCWorkspaceActionBase.getPSDevSlnId());
        }
        if (pSDCWorkspaceActionBase.isPSDevSlnSysIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCWorkspaceActionBase.getPSDevSlnSysId());
        }
        if (pSDCWorkspaceActionBase.isPSDSConsoleIdDirty() && (bl || pSDCWorkspaceActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSDCWorkspaceActionBase.getPSDSConsoleId());
        }
        if (pSDCWorkspaceActionBase.isPSTaskServerIdDirty() && (bl || pSDCWorkspaceActionBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDCWorkspaceActionBase.getPSTaskServerId());
        }
        if (pSDCWorkspaceActionBase.isPSTaskServerNameDirty() && (bl || pSDCWorkspaceActionBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDCWorkspaceActionBase.getPSTaskServerName());
        }
        if (pSDCWorkspaceActionBase.isUpdateDateDirty() && (bl || pSDCWorkspaceActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWorkspaceActionBase.getUpdateDate());
        }
        if (pSDCWorkspaceActionBase.isUpdateManDirty() && (bl || pSDCWorkspaceActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWorkspaceActionBase.getUpdateMan());
        }
        if (pSDCWorkspaceActionBase.isUserTagDirty() && (bl || pSDCWorkspaceActionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCWorkspaceActionBase.getUserTag());
        }
        if (pSDCWorkspaceActionBase.isUserTag2Dirty() && (bl || pSDCWorkspaceActionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCWorkspaceActionBase.getUserTag2());
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
        return PSDCWorkspaceActionBase.remove(this, n);
    }

    private static boolean remove(PSDCWorkspaceActionBase pSDCWorkspaceActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSDCWorkspaceActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSDCWorkspaceActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSDCWorkspaceActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSDCWorkspaceActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSDCWorkspaceActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSDCWorkspaceActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSDCWorkspaceActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSDCWorkspaceActionBase.resetActionType();
                return true;
            }
            case 9: {
                pSDCWorkspaceActionBase.resetBeginTime();
                return true;
            }
            case 10: {
                pSDCWorkspaceActionBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDCWorkspaceActionBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDCWorkspaceActionBase.resetEndTime();
                return true;
            }
            case 13: {
                pSDCWorkspaceActionBase.resetPSDCWorkspaceActionId();
                return true;
            }
            case 14: {
                pSDCWorkspaceActionBase.resetPSDCWorkspaceActionName();
                return true;
            }
            case 15: {
                pSDCWorkspaceActionBase.resetPSDCWorkspaceId();
                return true;
            }
            case 16: {
                pSDCWorkspaceActionBase.resetPSDCWorkspaceName();
                return true;
            }
            case 17: {
                pSDCWorkspaceActionBase.resetPSDevCenterId();
                return true;
            }
            case 18: {
                pSDCWorkspaceActionBase.resetPSDevCenterName();
                return true;
            }
            case 19: {
                pSDCWorkspaceActionBase.resetPSDevSlnId();
                return true;
            }
            case 20: {
                pSDCWorkspaceActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 21: {
                pSDCWorkspaceActionBase.resetPSDSConsoleId();
                return true;
            }
            case 22: {
                pSDCWorkspaceActionBase.resetPSTaskServerId();
                return true;
            }
            case 23: {
                pSDCWorkspaceActionBase.resetPSTaskServerName();
                return true;
            }
            case 24: {
                pSDCWorkspaceActionBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDCWorkspaceActionBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSDCWorkspaceActionBase.resetUserTag();
                return true;
            }
            case 27: {
                pSDCWorkspaceActionBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkspace getPSDCWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspace();
        }
        if (this.getPSDCWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkspaceLock;
        synchronized (n) {
            if (this.psdcworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkspaceId(), (Object)this.psdcworkspace.getPSDCWorkspaceId()) != 0L) {
                this.psdcworkspace = null;
            }
            if (this.psdcworkspace == null) {
                PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                pSDCWorkspace.setPSDCWorkspaceId(this.getPSDCWorkspaceId());
                PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkspaceService.autoGet((IEntity)pSDCWorkspace);
                this.psdcworkspace = pSDCWorkspace;
            }
            return this.psdcworkspace;
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
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDCWorkspaceActionBase getProxyEntity() {
        return this.proxyPSDCWorkspaceActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWorkspaceActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWorkspaceActionBase) {
            this.proxyPSDCWorkspaceActionBase = (PSDCWorkspaceActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_ACTIONRESULT, 6);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 7);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 8);
        fieldIndexMap.put(FIELD_BEGINTIME, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_ENDTIME, 12);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEACTIONID, 13);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEACTIONNAME, 14);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 15);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 20);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 21);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 22);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
    }
}

