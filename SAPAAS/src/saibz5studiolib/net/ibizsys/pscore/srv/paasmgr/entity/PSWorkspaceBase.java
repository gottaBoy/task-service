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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspaceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkspaceBase.class);
    public static final String FIELD_ACTIONOWNER = "ACTIONOWNER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURACTION = "CURACTION";
    public static final String FIELD_CURACTIVETIME = "CURACTIVETIME";
    public static final String FIELD_CUREXPIREDTIME = "CUREXPIREDTIME";
    public static final String FIELD_EXP = "EXP";
    public static final String FIELD_EXP2 = "EXP2";
    public static final String FIELD_EXP3 = "EXP3";
    public static final String FIELD_EXP4 = "EXP4";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_MAXDEVUSER = "MAXDEVUSER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKSPACELEVEL = "WORKSPACELEVEL";
    public static final String FIELD_WORKSPACESTATE = "WORKSPACESTATE";
    public static final String FIELD_WORKSPACETYPE = "WORKSPACETYPE";
    public static final String FIELD_WORKSPACEUSAGE = "WORKSPACEUSAGE";
    private static final int INDEX_ACTIONOWNER = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CURACTION = 3;
    private static final int INDEX_CURACTIVETIME = 4;
    private static final int INDEX_CUREXPIREDTIME = 5;
    private static final int INDEX_EXP = 6;
    private static final int INDEX_EXP2 = 7;
    private static final int INDEX_EXP3 = 8;
    private static final int INDEX_EXP4 = 9;
    private static final int INDEX_EXPIREDTIME = 10;
    private static final int INDEX_MAXDEVUSER = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PARAM = 13;
    private static final int INDEX_PARAM2 = 14;
    private static final int INDEX_PARAM3 = 15;
    private static final int INDEX_PARAM4 = 16;
    private static final int INDEX_PARAM5 = 17;
    private static final int INDEX_PARAM6 = 18;
    private static final int INDEX_PARAM7 = 19;
    private static final int INDEX_PARAM8 = 20;
    private static final int INDEX_PSDCWORKSPACEID = 21;
    private static final int INDEX_PSDEVCENTERID = 22;
    private static final int INDEX_PSDEVCENTERNAME = 23;
    private static final int INDEX_PSSVRDOMAINID = 24;
    private static final int INDEX_PSSVRDOMAINNAME = 25;
    private static final int INDEX_PSWORKSPACEID = 26;
    private static final int INDEX_PSWORKSPACENAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final int INDEX_WORKSPACELEVEL = 31;
    private static final int INDEX_WORKSPACESTATE = 32;
    private static final int INDEX_WORKSPACETYPE = 33;
    private static final int INDEX_WORKSPACEUSAGE = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkspaceBase proxyPSWorkspaceBase = null;
    private boolean actionownerDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curactionDirtyFlag = false;
    private boolean curactivetimeDirtyFlag = false;
    private boolean curexpiredtimeDirtyFlag = false;
    private boolean expDirtyFlag = false;
    private boolean exp2DirtyFlag = false;
    private boolean exp3DirtyFlag = false;
    private boolean exp4DirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean maxdevuserDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workspacelevelDirtyFlag = false;
    private boolean workspacestateDirtyFlag = false;
    private boolean workspacetypeDirtyFlag = false;
    private boolean workspaceusageDirtyFlag = false;
    @Column(name="actionowner")
    private String actionowner;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curaction")
    private String curaction;
    @Column(name="curactivetime")
    private Timestamp curactivetime;
    @Column(name="curexpiredtime")
    private Timestamp curexpiredtime;
    @Column(name="exp")
    private Double exp;
    @Column(name="exp2")
    private Double exp2;
    @Column(name="exp3")
    private Double exp3;
    @Column(name="exp4")
    private Double exp4;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="maxdevuser")
    private Integer maxdevuser;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacename")
    private String psworkspacename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="workspacelevel")
    private Integer workspacelevel;
    @Column(name="workspacestate")
    private Integer workspacestate;
    @Column(name="workspacetype")
    private String workspacetype;
    @Column(name="workspaceusage")
    private String workspaceusage;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setActionOwner(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOwner(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionowner = string;
        this.actionownerDirtyFlag = true;
    }

    public String getActionOwner() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOwner();
        }
        return this.actionowner;
    }

    public boolean isActionOwnerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOwnerDirty();
        }
        return this.actionownerDirtyFlag;
    }

    public void resetActionOwner() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOwner();
            return;
        }
        this.actionownerDirtyFlag = false;
        this.actionowner = null;
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

    public void setCurAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curaction = string;
        this.curactionDirtyFlag = true;
    }

    public String getCurAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurAction();
        }
        return this.curaction;
    }

    public boolean isCurActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActionDirty();
        }
        return this.curactionDirtyFlag;
    }

    public void resetCurAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurAction();
            return;
        }
        this.curactionDirtyFlag = false;
        this.curaction = null;
    }

    public void setCurActiveTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurActiveTime(timestamp);
            return;
        }
        this.curactivetime = timestamp;
        this.curactivetimeDirtyFlag = true;
    }

    public Timestamp getCurActiveTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurActiveTime();
        }
        return this.curactivetime;
    }

    public boolean isCurActiveTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActiveTimeDirty();
        }
        return this.curactivetimeDirtyFlag;
    }

    public void resetCurActiveTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurActiveTime();
            return;
        }
        this.curactivetimeDirtyFlag = false;
        this.curactivetime = null;
    }

    public void setCurExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurExpiredTime(timestamp);
            return;
        }
        this.curexpiredtime = timestamp;
        this.curexpiredtimeDirtyFlag = true;
    }

    public Timestamp getCurExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurExpiredTime();
        }
        return this.curexpiredtime;
    }

    public boolean isCurExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurExpiredTimeDirty();
        }
        return this.curexpiredtimeDirtyFlag;
    }

    public void resetCurExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurExpiredTime();
            return;
        }
        this.curexpiredtimeDirtyFlag = false;
        this.curexpiredtime = null;
    }

    public void setExp(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp(d);
            return;
        }
        this.exp = d;
        this.expDirtyFlag = true;
    }

    public Double getExp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp();
        }
        return this.exp;
    }

    public boolean isExpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpDirty();
        }
        return this.expDirtyFlag;
    }

    public void resetExp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp();
            return;
        }
        this.expDirtyFlag = false;
        this.exp = null;
    }

    public void setExp2(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp2(d);
            return;
        }
        this.exp2 = d;
        this.exp2DirtyFlag = true;
    }

    public Double getExp2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp2();
        }
        return this.exp2;
    }

    public boolean isExp2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp2Dirty();
        }
        return this.exp2DirtyFlag;
    }

    public void resetExp2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp2();
            return;
        }
        this.exp2DirtyFlag = false;
        this.exp2 = null;
    }

    public void setExp3(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp3(d);
            return;
        }
        this.exp3 = d;
        this.exp3DirtyFlag = true;
    }

    public Double getExp3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp3();
        }
        return this.exp3;
    }

    public boolean isExp3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp3Dirty();
        }
        return this.exp3DirtyFlag;
    }

    public void resetExp3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp3();
            return;
        }
        this.exp3DirtyFlag = false;
        this.exp3 = null;
    }

    public void setExp4(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp4(d);
            return;
        }
        this.exp4 = d;
        this.exp4DirtyFlag = true;
    }

    public Double getExp4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp4();
        }
        return this.exp4;
    }

    public boolean isExp4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp4Dirty();
        }
        return this.exp4DirtyFlag;
    }

    public void resetExp4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp4();
            return;
        }
        this.exp4DirtyFlag = false;
        this.exp4 = null;
    }

    public void setExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(timestamp);
            return;
        }
        this.expiredtime = timestamp;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
    }

    public void setMaxDevUser(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevUser(n);
            return;
        }
        this.maxdevuser = n;
        this.maxdevuserDirtyFlag = true;
    }

    public Integer getMaxDevUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevUser();
        }
        return this.maxdevuser;
    }

    public boolean isMaxDevUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevUserDirty();
        }
        return this.maxdevuserDirtyFlag;
    }

    public void resetMaxDevUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevUser();
            return;
        }
        this.maxdevuserDirtyFlag = false;
        this.maxdevuser = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
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

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setPSWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspaceid = string;
        this.psworkspaceidDirtyFlag = true;
    }

    public String getPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceId();
        }
        return this.psworkspaceid;
    }

    public boolean isPSWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceIdDirty();
        }
        return this.psworkspaceidDirtyFlag;
    }

    public void resetPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceId();
            return;
        }
        this.psworkspaceidDirtyFlag = false;
        this.psworkspaceid = null;
    }

    public void setPSWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacename = string;
        this.psworkspacenameDirtyFlag = true;
    }

    public String getPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceName();
        }
        return this.psworkspacename;
    }

    public boolean isPSWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceNameDirty();
        }
        return this.psworkspacenameDirtyFlag;
    }

    public void resetPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceName();
            return;
        }
        this.psworkspacenameDirtyFlag = false;
        this.psworkspacename = null;
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

    public void setWorkspaceLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceLevel(n);
            return;
        }
        this.workspacelevel = n;
        this.workspacelevelDirtyFlag = true;
    }

    public Integer getWorkspaceLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceLevel();
        }
        return this.workspacelevel;
    }

    public boolean isWorkspaceLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceLevelDirty();
        }
        return this.workspacelevelDirtyFlag;
    }

    public void resetWorkspaceLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceLevel();
            return;
        }
        this.workspacelevelDirtyFlag = false;
        this.workspacelevel = null;
    }

    public void setWorkspaceState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceState(n);
            return;
        }
        this.workspacestate = n;
        this.workspacestateDirtyFlag = true;
    }

    public Integer getWorkspaceState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceState();
        }
        return this.workspacestate;
    }

    public boolean isWorkspaceStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceStateDirty();
        }
        return this.workspacestateDirtyFlag;
    }

    public void resetWorkspaceState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceState();
            return;
        }
        this.workspacestateDirtyFlag = false;
        this.workspacestate = null;
    }

    public void setWorkspaceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspacetype = string;
        this.workspacetypeDirtyFlag = true;
    }

    public String getWorkspaceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceType();
        }
        return this.workspacetype;
    }

    public boolean isWorkspaceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceTypeDirty();
        }
        return this.workspacetypeDirtyFlag;
    }

    public void resetWorkspaceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceType();
            return;
        }
        this.workspacetypeDirtyFlag = false;
        this.workspacetype = null;
    }

    public void setWorkspaceUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspaceusage = string;
        this.workspaceusageDirtyFlag = true;
    }

    public String getWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceUsage();
        }
        return this.workspaceusage;
    }

    public boolean isWorkspaceUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceUsageDirty();
        }
        return this.workspaceusageDirtyFlag;
    }

    public void resetWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceUsage();
            return;
        }
        this.workspaceusageDirtyFlag = false;
        this.workspaceusage = null;
    }

    protected void onReset() {
        PSWorkspaceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkspaceBase pSWorkspaceBase) {
        pSWorkspaceBase.resetActionOwner();
        pSWorkspaceBase.resetCreateDate();
        pSWorkspaceBase.resetCreateMan();
        pSWorkspaceBase.resetCurAction();
        pSWorkspaceBase.resetCurActiveTime();
        pSWorkspaceBase.resetCurExpiredTime();
        pSWorkspaceBase.resetExp();
        pSWorkspaceBase.resetExp2();
        pSWorkspaceBase.resetExp3();
        pSWorkspaceBase.resetExp4();
        pSWorkspaceBase.resetExpiredTime();
        pSWorkspaceBase.resetMaxDevUser();
        pSWorkspaceBase.resetMemo();
        pSWorkspaceBase.resetParam();
        pSWorkspaceBase.resetParam2();
        pSWorkspaceBase.resetParam3();
        pSWorkspaceBase.resetParam4();
        pSWorkspaceBase.resetParam5();
        pSWorkspaceBase.resetParam6();
        pSWorkspaceBase.resetParam7();
        pSWorkspaceBase.resetParam8();
        pSWorkspaceBase.resetPSDCWorkspaceId();
        pSWorkspaceBase.resetPSDevCenterId();
        pSWorkspaceBase.resetPSDevCenterName();
        pSWorkspaceBase.resetPSSvrDomainId();
        pSWorkspaceBase.resetPSSvrDomainName();
        pSWorkspaceBase.resetPSWorkspaceId();
        pSWorkspaceBase.resetPSWorkspaceName();
        pSWorkspaceBase.resetUpdateDate();
        pSWorkspaceBase.resetUpdateMan();
        pSWorkspaceBase.resetValidFlag();
        pSWorkspaceBase.resetWorkspaceLevel();
        pSWorkspaceBase.resetWorkspaceState();
        pSWorkspaceBase.resetWorkspaceType();
        pSWorkspaceBase.resetWorkspaceUsage();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionOwnerDirty()) {
            hashMap.put(FIELD_ACTIONOWNER, this.getActionOwner());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurActionDirty()) {
            hashMap.put(FIELD_CURACTION, this.getCurAction());
        }
        if (!bl || this.isCurActiveTimeDirty()) {
            hashMap.put(FIELD_CURACTIVETIME, this.getCurActiveTime());
        }
        if (!bl || this.isCurExpiredTimeDirty()) {
            hashMap.put(FIELD_CUREXPIREDTIME, this.getCurExpiredTime());
        }
        if (!bl || this.isExpDirty()) {
            hashMap.put(FIELD_EXP, this.getExp());
        }
        if (!bl || this.isExp2Dirty()) {
            hashMap.put(FIELD_EXP2, this.getExp2());
        }
        if (!bl || this.isExp3Dirty()) {
            hashMap.put(FIELD_EXP3, this.getExp3());
        }
        if (!bl || this.isExp4Dirty()) {
            hashMap.put(FIELD_EXP4, this.getExp4());
        }
        if (!bl || this.isExpiredTimeDirty()) {
            hashMap.put(FIELD_EXPIREDTIME, this.getExpiredTime());
        }
        if (!bl || this.isMaxDevUserDirty()) {
            hashMap.put(FIELD_MAXDEVUSER, this.getMaxDevUser());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEID, this.getPSWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACENAME, this.getPSWorkspaceName());
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
        if (!bl || this.isWorkspaceLevelDirty()) {
            hashMap.put(FIELD_WORKSPACELEVEL, this.getWorkspaceLevel());
        }
        if (!bl || this.isWorkspaceStateDirty()) {
            hashMap.put(FIELD_WORKSPACESTATE, this.getWorkspaceState());
        }
        if (!bl || this.isWorkspaceTypeDirty()) {
            hashMap.put(FIELD_WORKSPACETYPE, this.getWorkspaceType());
        }
        if (!bl || this.isWorkspaceUsageDirty()) {
            hashMap.put(FIELD_WORKSPACEUSAGE, this.getWorkspaceUsage());
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
        return PSWorkspaceBase.get(this, n);
    }

    private static Object get(PSWorkspaceBase pSWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceBase.getActionOwner();
            }
            case 1: {
                return pSWorkspaceBase.getCreateDate();
            }
            case 2: {
                return pSWorkspaceBase.getCreateMan();
            }
            case 3: {
                return pSWorkspaceBase.getCurAction();
            }
            case 4: {
                return pSWorkspaceBase.getCurActiveTime();
            }
            case 5: {
                return pSWorkspaceBase.getCurExpiredTime();
            }
            case 6: {
                return pSWorkspaceBase.getExp();
            }
            case 7: {
                return pSWorkspaceBase.getExp2();
            }
            case 8: {
                return pSWorkspaceBase.getExp3();
            }
            case 9: {
                return pSWorkspaceBase.getExp4();
            }
            case 10: {
                return pSWorkspaceBase.getExpiredTime();
            }
            case 11: {
                return pSWorkspaceBase.getMaxDevUser();
            }
            case 12: {
                return pSWorkspaceBase.getMemo();
            }
            case 13: {
                return pSWorkspaceBase.getParam();
            }
            case 14: {
                return pSWorkspaceBase.getParam2();
            }
            case 15: {
                return pSWorkspaceBase.getParam3();
            }
            case 16: {
                return pSWorkspaceBase.getParam4();
            }
            case 17: {
                return pSWorkspaceBase.getParam5();
            }
            case 18: {
                return pSWorkspaceBase.getParam6();
            }
            case 19: {
                return pSWorkspaceBase.getParam7();
            }
            case 20: {
                return pSWorkspaceBase.getParam8();
            }
            case 21: {
                return pSWorkspaceBase.getPSDCWorkspaceId();
            }
            case 22: {
                return pSWorkspaceBase.getPSDevCenterId();
            }
            case 23: {
                return pSWorkspaceBase.getPSDevCenterName();
            }
            case 24: {
                return pSWorkspaceBase.getPSSvrDomainId();
            }
            case 25: {
                return pSWorkspaceBase.getPSSvrDomainName();
            }
            case 26: {
                return pSWorkspaceBase.getPSWorkspaceId();
            }
            case 27: {
                return pSWorkspaceBase.getPSWorkspaceName();
            }
            case 28: {
                return pSWorkspaceBase.getUpdateDate();
            }
            case 29: {
                return pSWorkspaceBase.getUpdateMan();
            }
            case 30: {
                return pSWorkspaceBase.getValidFlag();
            }
            case 31: {
                return pSWorkspaceBase.getWorkspaceLevel();
            }
            case 32: {
                return pSWorkspaceBase.getWorkspaceState();
            }
            case 33: {
                return pSWorkspaceBase.getWorkspaceType();
            }
            case 34: {
                return pSWorkspaceBase.getWorkspaceUsage();
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
        PSWorkspaceBase.set(this, n, object);
    }

    private static void set(PSWorkspaceBase pSWorkspaceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceBase.setActionOwner(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWorkspaceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWorkspaceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkspaceBase.setCurAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWorkspaceBase.setCurActiveTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSWorkspaceBase.setCurExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSWorkspaceBase.setExp(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 7: {
                pSWorkspaceBase.setExp2(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 8: {
                pSWorkspaceBase.setExp3(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 9: {
                pSWorkspaceBase.setExp4(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 10: {
                pSWorkspaceBase.setExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSWorkspaceBase.setMaxDevUser(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSWorkspaceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWorkspaceBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWorkspaceBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWorkspaceBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWorkspaceBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWorkspaceBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSWorkspaceBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSWorkspaceBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSWorkspaceBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSWorkspaceBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWorkspaceBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWorkspaceBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWorkspaceBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWorkspaceBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWorkspaceBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWorkspaceBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWorkspaceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSWorkspaceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWorkspaceBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSWorkspaceBase.setWorkspaceLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSWorkspaceBase.setWorkspaceState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSWorkspaceBase.setWorkspaceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWorkspaceBase.setWorkspaceUsage(DataObject.getStringValue((Object)object));
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
        return PSWorkspaceBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkspaceBase pSWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceBase.getActionOwner() == null;
            }
            case 1: {
                return pSWorkspaceBase.getCreateDate() == null;
            }
            case 2: {
                return pSWorkspaceBase.getCreateMan() == null;
            }
            case 3: {
                return pSWorkspaceBase.getCurAction() == null;
            }
            case 4: {
                return pSWorkspaceBase.getCurActiveTime() == null;
            }
            case 5: {
                return pSWorkspaceBase.getCurExpiredTime() == null;
            }
            case 6: {
                return pSWorkspaceBase.getExp() == null;
            }
            case 7: {
                return pSWorkspaceBase.getExp2() == null;
            }
            case 8: {
                return pSWorkspaceBase.getExp3() == null;
            }
            case 9: {
                return pSWorkspaceBase.getExp4() == null;
            }
            case 10: {
                return pSWorkspaceBase.getExpiredTime() == null;
            }
            case 11: {
                return pSWorkspaceBase.getMaxDevUser() == null;
            }
            case 12: {
                return pSWorkspaceBase.getMemo() == null;
            }
            case 13: {
                return pSWorkspaceBase.getParam() == null;
            }
            case 14: {
                return pSWorkspaceBase.getParam2() == null;
            }
            case 15: {
                return pSWorkspaceBase.getParam3() == null;
            }
            case 16: {
                return pSWorkspaceBase.getParam4() == null;
            }
            case 17: {
                return pSWorkspaceBase.getParam5() == null;
            }
            case 18: {
                return pSWorkspaceBase.getParam6() == null;
            }
            case 19: {
                return pSWorkspaceBase.getParam7() == null;
            }
            case 20: {
                return pSWorkspaceBase.getParam8() == null;
            }
            case 21: {
                return pSWorkspaceBase.getPSDCWorkspaceId() == null;
            }
            case 22: {
                return pSWorkspaceBase.getPSDevCenterId() == null;
            }
            case 23: {
                return pSWorkspaceBase.getPSDevCenterName() == null;
            }
            case 24: {
                return pSWorkspaceBase.getPSSvrDomainId() == null;
            }
            case 25: {
                return pSWorkspaceBase.getPSSvrDomainName() == null;
            }
            case 26: {
                return pSWorkspaceBase.getPSWorkspaceId() == null;
            }
            case 27: {
                return pSWorkspaceBase.getPSWorkspaceName() == null;
            }
            case 28: {
                return pSWorkspaceBase.getUpdateDate() == null;
            }
            case 29: {
                return pSWorkspaceBase.getUpdateMan() == null;
            }
            case 30: {
                return pSWorkspaceBase.getValidFlag() == null;
            }
            case 31: {
                return pSWorkspaceBase.getWorkspaceLevel() == null;
            }
            case 32: {
                return pSWorkspaceBase.getWorkspaceState() == null;
            }
            case 33: {
                return pSWorkspaceBase.getWorkspaceType() == null;
            }
            case 34: {
                return pSWorkspaceBase.getWorkspaceUsage() == null;
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
        return PSWorkspaceBase.contains(this, n);
    }

    private static boolean contains(PSWorkspaceBase pSWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceBase.isActionOwnerDirty();
            }
            case 1: {
                return pSWorkspaceBase.isCreateDateDirty();
            }
            case 2: {
                return pSWorkspaceBase.isCreateManDirty();
            }
            case 3: {
                return pSWorkspaceBase.isCurActionDirty();
            }
            case 4: {
                return pSWorkspaceBase.isCurActiveTimeDirty();
            }
            case 5: {
                return pSWorkspaceBase.isCurExpiredTimeDirty();
            }
            case 6: {
                return pSWorkspaceBase.isExpDirty();
            }
            case 7: {
                return pSWorkspaceBase.isExp2Dirty();
            }
            case 8: {
                return pSWorkspaceBase.isExp3Dirty();
            }
            case 9: {
                return pSWorkspaceBase.isExp4Dirty();
            }
            case 10: {
                return pSWorkspaceBase.isExpiredTimeDirty();
            }
            case 11: {
                return pSWorkspaceBase.isMaxDevUserDirty();
            }
            case 12: {
                return pSWorkspaceBase.isMemoDirty();
            }
            case 13: {
                return pSWorkspaceBase.isParamDirty();
            }
            case 14: {
                return pSWorkspaceBase.isParam2Dirty();
            }
            case 15: {
                return pSWorkspaceBase.isParam3Dirty();
            }
            case 16: {
                return pSWorkspaceBase.isParam4Dirty();
            }
            case 17: {
                return pSWorkspaceBase.isParam5Dirty();
            }
            case 18: {
                return pSWorkspaceBase.isParam6Dirty();
            }
            case 19: {
                return pSWorkspaceBase.isParam7Dirty();
            }
            case 20: {
                return pSWorkspaceBase.isParam8Dirty();
            }
            case 21: {
                return pSWorkspaceBase.isPSDCWorkspaceIdDirty();
            }
            case 22: {
                return pSWorkspaceBase.isPSDevCenterIdDirty();
            }
            case 23: {
                return pSWorkspaceBase.isPSDevCenterNameDirty();
            }
            case 24: {
                return pSWorkspaceBase.isPSSvrDomainIdDirty();
            }
            case 25: {
                return pSWorkspaceBase.isPSSvrDomainNameDirty();
            }
            case 26: {
                return pSWorkspaceBase.isPSWorkspaceIdDirty();
            }
            case 27: {
                return pSWorkspaceBase.isPSWorkspaceNameDirty();
            }
            case 28: {
                return pSWorkspaceBase.isUpdateDateDirty();
            }
            case 29: {
                return pSWorkspaceBase.isUpdateManDirty();
            }
            case 30: {
                return pSWorkspaceBase.isValidFlagDirty();
            }
            case 31: {
                return pSWorkspaceBase.isWorkspaceLevelDirty();
            }
            case 32: {
                return pSWorkspaceBase.isWorkspaceStateDirty();
            }
            case 33: {
                return pSWorkspaceBase.isWorkspaceTypeDirty();
            }
            case 34: {
                return pSWorkspaceBase.isWorkspaceUsageDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkspaceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkspaceBase pSWorkspaceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkspaceBase.getActionOwner() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionowner", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getActionOwner()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getCurAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curaction", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getCurAction()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getCurActiveTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curactivetime", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getCurActiveTime()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getCurExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curexpiredtime", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getCurExpiredTime()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getExp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getExp()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getExp2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp2", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getExp2()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getExp3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp3", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getExp3()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getExp4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp4", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getExp4()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredtime", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getExpiredTime()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getMaxDevUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevuser", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getMaxDevUser()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getMemo()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam2()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam3()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam4()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam5()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam6()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam7()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getParam8()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getWorkspaceLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacelevel", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getWorkspaceLevel()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getWorkspaceState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacestate", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getWorkspaceState()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getWorkspaceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacetype", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getWorkspaceType()), (boolean)false);
        }
        if (bl || pSWorkspaceBase.getWorkspaceUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspaceusage", (Object)PSWorkspaceBase.getJSONValue((Object)pSWorkspaceBase.getWorkspaceUsage()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkspaceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkspaceBase pSWorkspaceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkspaceBase.getActionOwner() != null) {
            object = pSWorkspaceBase.getActionOwner();
            xmlNode.setAttribute(FIELD_ACTIONOWNER, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getCreateDate() != null) {
            object = pSWorkspaceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceBase.getCreateMan() != null) {
            object = pSWorkspaceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getCurAction() != null) {
            object = pSWorkspaceBase.getCurAction();
            xmlNode.setAttribute(FIELD_CURACTION, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getCurActiveTime() != null) {
            object = pSWorkspaceBase.getCurActiveTime();
            xmlNode.setAttribute(FIELD_CURACTIVETIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceBase.getCurExpiredTime() != null) {
            object = pSWorkspaceBase.getCurExpiredTime();
            xmlNode.setAttribute(FIELD_CUREXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceBase.getExp() != null) {
            object = pSWorkspaceBase.getExp();
            xmlNode.setAttribute(FIELD_EXP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getExp2() != null) {
            object = pSWorkspaceBase.getExp2();
            xmlNode.setAttribute(FIELD_EXP2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getExp3() != null) {
            object = pSWorkspaceBase.getExp3();
            xmlNode.setAttribute(FIELD_EXP3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getExp4() != null) {
            object = pSWorkspaceBase.getExp4();
            xmlNode.setAttribute(FIELD_EXP4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getExpiredTime() != null) {
            object = pSWorkspaceBase.getExpiredTime();
            xmlNode.setAttribute(FIELD_EXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceBase.getMaxDevUser() != null) {
            object = pSWorkspaceBase.getMaxDevUser();
            xmlNode.setAttribute(FIELD_MAXDEVUSER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getMemo() != null) {
            object = pSWorkspaceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getParam() != null) {
            object = pSWorkspaceBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getParam2() != null) {
            object = pSWorkspaceBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getParam3() != null) {
            object = pSWorkspaceBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getParam4() != null) {
            object = pSWorkspaceBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getParam5() != null) {
            object = pSWorkspaceBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getParam6() != null) {
            object = pSWorkspaceBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getParam7() != null) {
            object = pSWorkspaceBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getParam8() != null) {
            object = pSWorkspaceBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getPSDCWorkspaceId() != null) {
            object = pSWorkspaceBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSDevCenterId() != null) {
            object = pSWorkspaceBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSDevCenterName() != null) {
            object = pSWorkspaceBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSSvrDomainId() != null) {
            object = pSWorkspaceBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSSvrDomainName() != null) {
            object = pSWorkspaceBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSWorkspaceId() != null) {
            object = pSWorkspaceBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getPSWorkspaceName() != null) {
            object = pSWorkspaceBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getUpdateDate() != null) {
            object = pSWorkspaceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceBase.getUpdateMan() != null) {
            object = pSWorkspaceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getValidFlag() != null) {
            object = pSWorkspaceBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getWorkspaceLevel() != null) {
            object = pSWorkspaceBase.getWorkspaceLevel();
            xmlNode.setAttribute(FIELD_WORKSPACELEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getWorkspaceState() != null) {
            object = pSWorkspaceBase.getWorkspaceState();
            xmlNode.setAttribute(FIELD_WORKSPACESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceBase.getWorkspaceType() != null) {
            object = pSWorkspaceBase.getWorkspaceType();
            xmlNode.setAttribute(FIELD_WORKSPACETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceBase.getWorkspaceUsage() != null) {
            object = pSWorkspaceBase.getWorkspaceUsage();
            xmlNode.setAttribute(FIELD_WORKSPACEUSAGE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkspaceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkspaceBase pSWorkspaceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkspaceBase.isActionOwnerDirty() && (bl || pSWorkspaceBase.getActionOwner() != null)) {
            iDataObject.set(FIELD_ACTIONOWNER, (Object)pSWorkspaceBase.getActionOwner());
        }
        if (pSWorkspaceBase.isCreateDateDirty() && (bl || pSWorkspaceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkspaceBase.getCreateDate());
        }
        if (pSWorkspaceBase.isCreateManDirty() && (bl || pSWorkspaceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkspaceBase.getCreateMan());
        }
        if (pSWorkspaceBase.isCurActionDirty() && (bl || pSWorkspaceBase.getCurAction() != null)) {
            iDataObject.set(FIELD_CURACTION, (Object)pSWorkspaceBase.getCurAction());
        }
        if (pSWorkspaceBase.isCurActiveTimeDirty() && (bl || pSWorkspaceBase.getCurActiveTime() != null)) {
            iDataObject.set(FIELD_CURACTIVETIME, (Object)pSWorkspaceBase.getCurActiveTime());
        }
        if (pSWorkspaceBase.isCurExpiredTimeDirty() && (bl || pSWorkspaceBase.getCurExpiredTime() != null)) {
            iDataObject.set(FIELD_CUREXPIREDTIME, (Object)pSWorkspaceBase.getCurExpiredTime());
        }
        if (pSWorkspaceBase.isExpDirty() && (bl || pSWorkspaceBase.getExp() != null)) {
            iDataObject.set(FIELD_EXP, (Object)pSWorkspaceBase.getExp());
        }
        if (pSWorkspaceBase.isExp2Dirty() && (bl || pSWorkspaceBase.getExp2() != null)) {
            iDataObject.set(FIELD_EXP2, (Object)pSWorkspaceBase.getExp2());
        }
        if (pSWorkspaceBase.isExp3Dirty() && (bl || pSWorkspaceBase.getExp3() != null)) {
            iDataObject.set(FIELD_EXP3, (Object)pSWorkspaceBase.getExp3());
        }
        if (pSWorkspaceBase.isExp4Dirty() && (bl || pSWorkspaceBase.getExp4() != null)) {
            iDataObject.set(FIELD_EXP4, (Object)pSWorkspaceBase.getExp4());
        }
        if (pSWorkspaceBase.isExpiredTimeDirty() && (bl || pSWorkspaceBase.getExpiredTime() != null)) {
            iDataObject.set(FIELD_EXPIREDTIME, (Object)pSWorkspaceBase.getExpiredTime());
        }
        if (pSWorkspaceBase.isMaxDevUserDirty() && (bl || pSWorkspaceBase.getMaxDevUser() != null)) {
            iDataObject.set(FIELD_MAXDEVUSER, (Object)pSWorkspaceBase.getMaxDevUser());
        }
        if (pSWorkspaceBase.isMemoDirty() && (bl || pSWorkspaceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWorkspaceBase.getMemo());
        }
        if (pSWorkspaceBase.isParamDirty() && (bl || pSWorkspaceBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSWorkspaceBase.getParam());
        }
        if (pSWorkspaceBase.isParam2Dirty() && (bl || pSWorkspaceBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSWorkspaceBase.getParam2());
        }
        if (pSWorkspaceBase.isParam3Dirty() && (bl || pSWorkspaceBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSWorkspaceBase.getParam3());
        }
        if (pSWorkspaceBase.isParam4Dirty() && (bl || pSWorkspaceBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSWorkspaceBase.getParam4());
        }
        if (pSWorkspaceBase.isParam5Dirty() && (bl || pSWorkspaceBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSWorkspaceBase.getParam5());
        }
        if (pSWorkspaceBase.isParam6Dirty() && (bl || pSWorkspaceBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSWorkspaceBase.getParam6());
        }
        if (pSWorkspaceBase.isParam7Dirty() && (bl || pSWorkspaceBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSWorkspaceBase.getParam7());
        }
        if (pSWorkspaceBase.isParam8Dirty() && (bl || pSWorkspaceBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSWorkspaceBase.getParam8());
        }
        if (pSWorkspaceBase.isPSDCWorkspaceIdDirty() && (bl || pSWorkspaceBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSWorkspaceBase.getPSDCWorkspaceId());
        }
        if (pSWorkspaceBase.isPSDevCenterIdDirty() && (bl || pSWorkspaceBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWorkspaceBase.getPSDevCenterId());
        }
        if (pSWorkspaceBase.isPSDevCenterNameDirty() && (bl || pSWorkspaceBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWorkspaceBase.getPSDevCenterName());
        }
        if (pSWorkspaceBase.isPSSvrDomainIdDirty() && (bl || pSWorkspaceBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSWorkspaceBase.getPSSvrDomainId());
        }
        if (pSWorkspaceBase.isPSSvrDomainNameDirty() && (bl || pSWorkspaceBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSWorkspaceBase.getPSSvrDomainName());
        }
        if (pSWorkspaceBase.isPSWorkspaceIdDirty() && (bl || pSWorkspaceBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWorkspaceBase.getPSWorkspaceId());
        }
        if (pSWorkspaceBase.isPSWorkspaceNameDirty() && (bl || pSWorkspaceBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWorkspaceBase.getPSWorkspaceName());
        }
        if (pSWorkspaceBase.isUpdateDateDirty() && (bl || pSWorkspaceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkspaceBase.getUpdateDate());
        }
        if (pSWorkspaceBase.isUpdateManDirty() && (bl || pSWorkspaceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkspaceBase.getUpdateMan());
        }
        if (pSWorkspaceBase.isValidFlagDirty() && (bl || pSWorkspaceBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWorkspaceBase.getValidFlag());
        }
        if (pSWorkspaceBase.isWorkspaceLevelDirty() && (bl || pSWorkspaceBase.getWorkspaceLevel() != null)) {
            iDataObject.set(FIELD_WORKSPACELEVEL, (Object)pSWorkspaceBase.getWorkspaceLevel());
        }
        if (pSWorkspaceBase.isWorkspaceStateDirty() && (bl || pSWorkspaceBase.getWorkspaceState() != null)) {
            iDataObject.set(FIELD_WORKSPACESTATE, (Object)pSWorkspaceBase.getWorkspaceState());
        }
        if (pSWorkspaceBase.isWorkspaceTypeDirty() && (bl || pSWorkspaceBase.getWorkspaceType() != null)) {
            iDataObject.set(FIELD_WORKSPACETYPE, (Object)pSWorkspaceBase.getWorkspaceType());
        }
        if (pSWorkspaceBase.isWorkspaceUsageDirty() && (bl || pSWorkspaceBase.getWorkspaceUsage() != null)) {
            iDataObject.set(FIELD_WORKSPACEUSAGE, (Object)pSWorkspaceBase.getWorkspaceUsage());
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
        return PSWorkspaceBase.remove(this, n);
    }

    private static boolean remove(PSWorkspaceBase pSWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceBase.resetActionOwner();
                return true;
            }
            case 1: {
                pSWorkspaceBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWorkspaceBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWorkspaceBase.resetCurAction();
                return true;
            }
            case 4: {
                pSWorkspaceBase.resetCurActiveTime();
                return true;
            }
            case 5: {
                pSWorkspaceBase.resetCurExpiredTime();
                return true;
            }
            case 6: {
                pSWorkspaceBase.resetExp();
                return true;
            }
            case 7: {
                pSWorkspaceBase.resetExp2();
                return true;
            }
            case 8: {
                pSWorkspaceBase.resetExp3();
                return true;
            }
            case 9: {
                pSWorkspaceBase.resetExp4();
                return true;
            }
            case 10: {
                pSWorkspaceBase.resetExpiredTime();
                return true;
            }
            case 11: {
                pSWorkspaceBase.resetMaxDevUser();
                return true;
            }
            case 12: {
                pSWorkspaceBase.resetMemo();
                return true;
            }
            case 13: {
                pSWorkspaceBase.resetParam();
                return true;
            }
            case 14: {
                pSWorkspaceBase.resetParam2();
                return true;
            }
            case 15: {
                pSWorkspaceBase.resetParam3();
                return true;
            }
            case 16: {
                pSWorkspaceBase.resetParam4();
                return true;
            }
            case 17: {
                pSWorkspaceBase.resetParam5();
                return true;
            }
            case 18: {
                pSWorkspaceBase.resetParam6();
                return true;
            }
            case 19: {
                pSWorkspaceBase.resetParam7();
                return true;
            }
            case 20: {
                pSWorkspaceBase.resetParam8();
                return true;
            }
            case 21: {
                pSWorkspaceBase.resetPSDCWorkspaceId();
                return true;
            }
            case 22: {
                pSWorkspaceBase.resetPSDevCenterId();
                return true;
            }
            case 23: {
                pSWorkspaceBase.resetPSDevCenterName();
                return true;
            }
            case 24: {
                pSWorkspaceBase.resetPSSvrDomainId();
                return true;
            }
            case 25: {
                pSWorkspaceBase.resetPSSvrDomainName();
                return true;
            }
            case 26: {
                pSWorkspaceBase.resetPSWorkspaceId();
                return true;
            }
            case 27: {
                pSWorkspaceBase.resetPSWorkspaceName();
                return true;
            }
            case 28: {
                pSWorkspaceBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSWorkspaceBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSWorkspaceBase.resetValidFlag();
                return true;
            }
            case 31: {
                pSWorkspaceBase.resetWorkspaceLevel();
                return true;
            }
            case 32: {
                pSWorkspaceBase.resetWorkspaceState();
                return true;
            }
            case 33: {
                pSWorkspaceBase.resetWorkspaceType();
                return true;
            }
            case 34: {
                pSWorkspaceBase.resetWorkspaceUsage();
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
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSWorkspaceBase getProxyEntity() {
        return this.proxyPSWorkspaceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkspaceBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkspaceBase) {
            this.proxyPSWorkspaceBase = (PSWorkspaceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONOWNER, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CURACTION, 3);
        fieldIndexMap.put(FIELD_CURACTIVETIME, 4);
        fieldIndexMap.put(FIELD_CUREXPIREDTIME, 5);
        fieldIndexMap.put(FIELD_EXP, 6);
        fieldIndexMap.put(FIELD_EXP2, 7);
        fieldIndexMap.put(FIELD_EXP3, 8);
        fieldIndexMap.put(FIELD_EXP4, 9);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 10);
        fieldIndexMap.put(FIELD_MAXDEVUSER, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PARAM, 13);
        fieldIndexMap.put(FIELD_PARAM2, 14);
        fieldIndexMap.put(FIELD_PARAM3, 15);
        fieldIndexMap.put(FIELD_PARAM4, 16);
        fieldIndexMap.put(FIELD_PARAM5, 17);
        fieldIndexMap.put(FIELD_PARAM6, 18);
        fieldIndexMap.put(FIELD_PARAM7, 19);
        fieldIndexMap.put(FIELD_PARAM8, 20);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 23);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 24);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 25);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 26);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
        fieldIndexMap.put(FIELD_WORKSPACELEVEL, 31);
        fieldIndexMap.put(FIELD_WORKSPACESTATE, 32);
        fieldIndexMap.put(FIELD_WORKSPACETYPE, 33);
        fieldIndexMap.put(FIELD_WORKSPACEUSAGE, 34);
    }
}

