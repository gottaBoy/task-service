/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFStepDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepDataBase.class);
    public static final String FIELD_ACTIONTIME = "ACTIONTIME";
    public static final String FIELD_ACTORID = "ACTORID";
    public static final String FIELD_ACTORNAME = "ACTORNAME";
    public static final String FIELD_ACTORNAME2 = "ACTORNAME2";
    public static final String FIELD_CONNECTIONNAME = "CONNECTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEXTTO = "NEXTTO";
    public static final String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
    public static final String FIELD_ORIGINALWFUSERNAME = "ORIGINALWFUSERNAME";
    public static final String FIELD_SDPARAM = "SDPARAM";
    public static final String FIELD_SDPARAM2 = "SDPARAM2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATADESC = "USERDATADESC";
    public static final String FIELD_WFACTIONLANRESTAG = "WFACTIONLANRESTAG";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    public static final String FIELD_WFSTEPDATAID = "WFSTEPDATAID";
    public static final String FIELD_WFSTEPDATANAME = "WFSTEPDATANAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    private static final int INDEX_ACTIONTIME = 0;
    private static final int INDEX_ACTORID = 1;
    private static final int INDEX_ACTORNAME = 2;
    private static final int INDEX_ACTORNAME2 = 3;
    private static final int INDEX_CONNECTIONNAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_NEXTTO = 8;
    private static final int INDEX_ORIGINALWFUSERID = 9;
    private static final int INDEX_ORIGINALWFUSERNAME = 10;
    private static final int INDEX_SDPARAM = 11;
    private static final int INDEX_SDPARAM2 = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERDATA = 15;
    private static final int INDEX_USERDATADESC = 16;
    private static final int INDEX_WFACTIONLANRESTAG = 17;
    private static final int INDEX_WFINSTANCEID = 18;
    private static final int INDEX_WFINSTANCENAME = 19;
    private static final int INDEX_WFPLOGICNAME = 20;
    private static final int INDEX_WFSTEPDATAID = 21;
    private static final int INDEX_WFSTEPDATANAME = 22;
    private static final int INDEX_WFSTEPID = 23;
    private static final int INDEX_WFSTEPLANRESTAG = 24;
    private static final int INDEX_WFSTEPNAME = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFStepDataBase proxyWFStepDataBase = null;
    private boolean actiontimeDirtyFlag = false;
    private boolean actoridDirtyFlag = false;
    private boolean actornameDirtyFlag = false;
    private boolean actorname2DirtyFlag = false;
    private boolean connectionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nexttoDirtyFlag = false;
    private boolean originalwfuseridDirtyFlag = false;
    private boolean originalwfusernameDirtyFlag = false;
    private boolean sdparamDirtyFlag = false;
    private boolean sdparam2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdatadescDirtyFlag = false;
    private boolean wfactionlanrestagDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfplogicnameDirtyFlag = false;
    private boolean wfstepdataidDirtyFlag = false;
    private boolean wfstepdatanameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;
    @Column(name="actiontime")
    private Timestamp actiontime;
    @Column(name="actorid")
    private String actorid;
    @Column(name="actorname")
    private String actorname;
    @Column(name="actorname2")
    private String actorname2;
    @Column(name="connectionname")
    private String connectionname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="nextto")
    private String nextto;
    @Column(name="originalwfuserid")
    private String originalwfuserid;
    @Column(name="originalwfusername")
    private String originalwfusername;
    @Column(name="sdparam")
    private String sdparam;
    @Column(name="sdparam2")
    private String sdparam2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdatadesc")
    private String userdatadesc;
    @Column(name="wfactionlanrestag")
    private String wfactionlanrestag;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfplogicname")
    private String wfplogicname;
    @Column(name="wfstepdataid")
    private String wfstepdataid;
    @Column(name="wfstepdataname")
    private String wfstepdataname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;
    private Integer objWFInstanceLock = new Integer(1);
    private WFInstance wfinstance = null;
    private Integer objWFStepLock = new Integer(1);
    private WFStep wfstep = null;
    private Integer objOriginalWFUserLock = new Integer(1);
    private WFUser originalwfuser = null;

    static {
        fieldIndexMap.put(FIELD_ACTIONTIME, 0);
        fieldIndexMap.put(FIELD_ACTORID, 1);
        fieldIndexMap.put(FIELD_ACTORNAME, 2);
        fieldIndexMap.put(FIELD_ACTORNAME2, 3);
        fieldIndexMap.put(FIELD_CONNECTIONNAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_NEXTTO, 8);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERID, 9);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERNAME, 10);
        fieldIndexMap.put(FIELD_SDPARAM, 11);
        fieldIndexMap.put(FIELD_SDPARAM2, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERDATA, 15);
        fieldIndexMap.put(FIELD_USERDATADESC, 16);
        fieldIndexMap.put(FIELD_WFACTIONLANRESTAG, 17);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 18);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 19);
        fieldIndexMap.put(FIELD_WFPLOGICNAME, 20);
        fieldIndexMap.put(FIELD_WFSTEPDATAID, 21);
        fieldIndexMap.put(FIELD_WFSTEPDATANAME, 22);
        fieldIndexMap.put(FIELD_WFSTEPID, 23);
        fieldIndexMap.put(FIELD_WFSTEPLANRESTAG, 24);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 25);
    }

    public void setActionTime(Timestamp actiontime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTime(actiontime);
            return;
        }
        this.actiontime = actiontime;
        this.actiontimeDirtyFlag = true;
    }

    public Timestamp getActionTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTime();
        }
        return this.actiontime;
    }

    public boolean isActionTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTimeDirty();
        }
        return this.actiontimeDirtyFlag;
    }

    public void resetActionTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTime();
            return;
        }
        this.actiontimeDirtyFlag = false;
        this.actiontime = null;
    }

    public void setActorId(String actorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorId(actorid);
            return;
        }
        if (actorid != null && (actorid = StringHelper.trimRight(actorid)).length() == 0) {
            actorid = null;
        }
        this.actorid = actorid;
        this.actoridDirtyFlag = true;
    }

    public String getActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorId();
        }
        return this.actorid;
    }

    public boolean isActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorIdDirty();
        }
        return this.actoridDirtyFlag;
    }

    public void resetActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorId();
            return;
        }
        this.actoridDirtyFlag = false;
        this.actorid = null;
    }

    public void setActorName(String actorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorName(actorname);
            return;
        }
        if (actorname != null && (actorname = StringHelper.trimRight(actorname)).length() == 0) {
            actorname = null;
        }
        this.actorname = actorname;
        this.actornameDirtyFlag = true;
    }

    public String getActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorName();
        }
        return this.actorname;
    }

    public boolean isActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorNameDirty();
        }
        return this.actornameDirtyFlag;
    }

    public void resetActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorName();
            return;
        }
        this.actornameDirtyFlag = false;
        this.actorname = null;
    }

    public void setActorName2(String actorname2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorName2(actorname2);
            return;
        }
        if (actorname2 != null && (actorname2 = StringHelper.trimRight(actorname2)).length() == 0) {
            actorname2 = null;
        }
        this.actorname2 = actorname2;
        this.actorname2DirtyFlag = true;
    }

    public String getActorName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorName2();
        }
        return this.actorname2;
    }

    public boolean isActorName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorName2Dirty();
        }
        return this.actorname2DirtyFlag;
    }

    public void resetActorName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorName2();
            return;
        }
        this.actorname2DirtyFlag = false;
        this.actorname2 = null;
    }

    public void setConnectionName(String connectionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnectionName(connectionname);
            return;
        }
        if (connectionname != null && (connectionname = StringHelper.trimRight(connectionname)).length() == 0) {
            connectionname = null;
        }
        this.connectionname = connectionname;
        this.connectionnameDirtyFlag = true;
    }

    public String getConnectionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnectionName();
        }
        return this.connectionname;
    }

    public boolean isConnectionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnectionNameDirty();
        }
        return this.connectionnameDirtyFlag;
    }

    public void resetConnectionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnectionName();
            return;
        }
        this.connectionnameDirtyFlag = false;
        this.connectionname = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setNextTo(String nextto) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextTo(nextto);
            return;
        }
        if (nextto != null && (nextto = StringHelper.trimRight(nextto)).length() == 0) {
            nextto = null;
        }
        this.nextto = nextto;
        this.nexttoDirtyFlag = true;
    }

    public String getNextTo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextTo();
        }
        return this.nextto;
    }

    public boolean isNextToDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextToDirty();
        }
        return this.nexttoDirtyFlag;
    }

    public void resetNextTo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextTo();
            return;
        }
        this.nexttoDirtyFlag = false;
        this.nextto = null;
    }

    public void setOriginalWFUserId(String originalwfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriginalWFUserId(originalwfuserid);
            return;
        }
        if (originalwfuserid != null && (originalwfuserid = StringHelper.trimRight(originalwfuserid)).length() == 0) {
            originalwfuserid = null;
        }
        this.originalwfuserid = originalwfuserid;
        this.originalwfuseridDirtyFlag = true;
    }

    public String getOriginalWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUserId();
        }
        return this.originalwfuserid;
    }

    public boolean isOriginalWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriginalWFUserIdDirty();
        }
        return this.originalwfuseridDirtyFlag;
    }

    public void resetOriginalWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriginalWFUserId();
            return;
        }
        this.originalwfuseridDirtyFlag = false;
        this.originalwfuserid = null;
    }

    public void setOriginalWFUserName(String originalwfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriginalWFUserName(originalwfusername);
            return;
        }
        if (originalwfusername != null && (originalwfusername = StringHelper.trimRight(originalwfusername)).length() == 0) {
            originalwfusername = null;
        }
        this.originalwfusername = originalwfusername;
        this.originalwfusernameDirtyFlag = true;
    }

    public String getOriginalWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUserName();
        }
        return this.originalwfusername;
    }

    public boolean isOriginalWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriginalWFUserNameDirty();
        }
        return this.originalwfusernameDirtyFlag;
    }

    public void resetOriginalWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriginalWFUserName();
            return;
        }
        this.originalwfusernameDirtyFlag = false;
        this.originalwfusername = null;
    }

    public void setSDParam(String sdparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDParam(sdparam);
            return;
        }
        if (sdparam != null && (sdparam = StringHelper.trimRight(sdparam)).length() == 0) {
            sdparam = null;
        }
        this.sdparam = sdparam;
        this.sdparamDirtyFlag = true;
    }

    public String getSDParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDParam();
        }
        return this.sdparam;
    }

    public boolean isSDParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDParamDirty();
        }
        return this.sdparamDirtyFlag;
    }

    public void resetSDParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDParam();
            return;
        }
        this.sdparamDirtyFlag = false;
        this.sdparam = null;
    }

    public void setSDParam2(String sdparam2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDParam2(sdparam2);
            return;
        }
        if (sdparam2 != null && (sdparam2 = StringHelper.trimRight(sdparam2)).length() == 0) {
            sdparam2 = null;
        }
        this.sdparam2 = sdparam2;
        this.sdparam2DirtyFlag = true;
    }

    public String getSDParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDParam2();
        }
        return this.sdparam2;
    }

    public boolean isSDParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDParam2Dirty();
        }
        return this.sdparam2DirtyFlag;
    }

    public void resetSDParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDParam2();
            return;
        }
        this.sdparam2DirtyFlag = false;
        this.sdparam2 = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserDataDesc(String userdatadesc) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataDesc(userdatadesc);
            return;
        }
        if (userdatadesc != null && (userdatadesc = StringHelper.trimRight(userdatadesc)).length() == 0) {
            userdatadesc = null;
        }
        this.userdatadesc = userdatadesc;
        this.userdatadescDirtyFlag = true;
    }

    public String getUserDataDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataDesc();
        }
        return this.userdatadesc;
    }

    public boolean isUserDataDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDescDirty();
        }
        return this.userdatadescDirtyFlag;
    }

    public void resetUserDataDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataDesc();
            return;
        }
        this.userdatadescDirtyFlag = false;
        this.userdatadesc = null;
    }

    public void setWFActionLanResTag(String wfactionlanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActionLanResTag(wfactionlanrestag);
            return;
        }
        if (wfactionlanrestag != null && (wfactionlanrestag = StringHelper.trimRight(wfactionlanrestag)).length() == 0) {
            wfactionlanrestag = null;
        }
        this.wfactionlanrestag = wfactionlanrestag;
        this.wfactionlanrestagDirtyFlag = true;
    }

    public String getWFActionLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActionLanResTag();
        }
        return this.wfactionlanrestag;
    }

    public boolean isWFActionLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActionLanResTagDirty();
        }
        return this.wfactionlanrestagDirtyFlag;
    }

    public void resetWFActionLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActionLanResTag();
            return;
        }
        this.wfactionlanrestagDirtyFlag = false;
        this.wfactionlanrestag = null;
    }

    public void setWFInstanceId(String wfinstanceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if (wfinstanceid != null && (wfinstanceid = StringHelper.trimRight(wfinstanceid)).length() == 0) {
            wfinstanceid = null;
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag = true;
    }

    public String getWFInstanceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    public boolean isWFInstanceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    public void resetWFInstanceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }
        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }

    public void setWFInstanceName(String wfinstancename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if (wfinstancename != null && (wfinstancename = StringHelper.trimRight(wfinstancename)).length() == 0) {
            wfinstancename = null;
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag = true;
    }

    public String getWFInstanceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    public boolean isWFInstanceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    public void resetWFInstanceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }
        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }

    public void setWFPLogicName(String wfplogicname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFPLogicName(wfplogicname);
            return;
        }
        if (wfplogicname != null && (wfplogicname = StringHelper.trimRight(wfplogicname)).length() == 0) {
            wfplogicname = null;
        }
        this.wfplogicname = wfplogicname;
        this.wfplogicnameDirtyFlag = true;
    }

    public String getWFPLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFPLogicName();
        }
        return this.wfplogicname;
    }

    public boolean isWFPLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFPLogicNameDirty();
        }
        return this.wfplogicnameDirtyFlag;
    }

    public void resetWFPLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFPLogicName();
            return;
        }
        this.wfplogicnameDirtyFlag = false;
        this.wfplogicname = null;
    }

    public void setWFStepDataId(String wfstepdataid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepDataId(wfstepdataid);
            return;
        }
        if (wfstepdataid != null && (wfstepdataid = StringHelper.trimRight(wfstepdataid)).length() == 0) {
            wfstepdataid = null;
        }
        this.wfstepdataid = wfstepdataid;
        this.wfstepdataidDirtyFlag = true;
    }

    public String getWFStepDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepDataId();
        }
        return this.wfstepdataid;
    }

    public boolean isWFStepDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepDataIdDirty();
        }
        return this.wfstepdataidDirtyFlag;
    }

    public void resetWFStepDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepDataId();
            return;
        }
        this.wfstepdataidDirtyFlag = false;
        this.wfstepdataid = null;
    }

    public void setWFStepDataName(String wfstepdataname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepDataName(wfstepdataname);
            return;
        }
        if (wfstepdataname != null && (wfstepdataname = StringHelper.trimRight(wfstepdataname)).length() == 0) {
            wfstepdataname = null;
        }
        this.wfstepdataname = wfstepdataname;
        this.wfstepdatanameDirtyFlag = true;
    }

    public String getWFStepDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepDataName();
        }
        return this.wfstepdataname;
    }

    public boolean isWFStepDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepDataNameDirty();
        }
        return this.wfstepdatanameDirtyFlag;
    }

    public void resetWFStepDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepDataName();
            return;
        }
        this.wfstepdatanameDirtyFlag = false;
        this.wfstepdataname = null;
    }

    public void setWFStepId(String wfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if (wfstepid != null && (wfstepid = StringHelper.trimRight(wfstepid)).length() == 0) {
            wfstepid = null;
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag = true;
    }

    public String getWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    public boolean isWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    public void resetWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }
        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }

    public void setWFStepLanResTag(String wfsteplanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if (wfsteplanrestag != null && (wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag)).length() == 0) {
            wfsteplanrestag = null;
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag = true;
    }

    public String getWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    public boolean isWFStepLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    public void resetWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }
        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }

    public void setWFStepName(String wfstepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if (wfstepname != null && (wfstepname = StringHelper.trimRight(wfstepname)).length() == 0) {
            wfstepname = null;
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag = true;
    }

    public String getWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    public boolean isWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    public void resetWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }
        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    @Override
    protected void onReset() {
        WFStepDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFStepDataBase et) {
        et.resetActionTime();
        et.resetActorId();
        et.resetActorName();
        et.resetActorName2();
        et.resetConnectionName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetNextTo();
        et.resetOriginalWFUserId();
        et.resetOriginalWFUserName();
        et.resetSDParam();
        et.resetSDParam2();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserDataDesc();
        et.resetWFActionLanResTag();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFPLogicName();
        et.resetWFStepDataId();
        et.resetWFStepDataName();
        et.resetWFStepId();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActionTimeDirty()) {
            params.put(FIELD_ACTIONTIME, this.getActionTime());
        }
        if (!bDirtyOnly || this.isActorIdDirty()) {
            params.put(FIELD_ACTORID, this.getActorId());
        }
        if (!bDirtyOnly || this.isActorNameDirty()) {
            params.put(FIELD_ACTORNAME, this.getActorName());
        }
        if (!bDirtyOnly || this.isActorName2Dirty()) {
            params.put(FIELD_ACTORNAME2, this.getActorName2());
        }
        if (!bDirtyOnly || this.isConnectionNameDirty()) {
            params.put(FIELD_CONNECTIONNAME, this.getConnectionName());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isNextToDirty()) {
            params.put(FIELD_NEXTTO, this.getNextTo());
        }
        if (!bDirtyOnly || this.isOriginalWFUserIdDirty()) {
            params.put(FIELD_ORIGINALWFUSERID, this.getOriginalWFUserId());
        }
        if (!bDirtyOnly || this.isOriginalWFUserNameDirty()) {
            params.put(FIELD_ORIGINALWFUSERNAME, this.getOriginalWFUserName());
        }
        if (!bDirtyOnly || this.isSDParamDirty()) {
            params.put(FIELD_SDPARAM, this.getSDParam());
        }
        if (!bDirtyOnly || this.isSDParam2Dirty()) {
            params.put(FIELD_SDPARAM2, this.getSDParam2());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserDataDescDirty()) {
            params.put(FIELD_USERDATADESC, this.getUserDataDesc());
        }
        if (!bDirtyOnly || this.isWFActionLanResTagDirty()) {
            params.put(FIELD_WFACTIONLANRESTAG, this.getWFActionLanResTag());
        }
        if (!bDirtyOnly || this.isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID, this.getWFInstanceId());
        }
        if (!bDirtyOnly || this.isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME, this.getWFInstanceName());
        }
        if (!bDirtyOnly || this.isWFPLogicNameDirty()) {
            params.put(FIELD_WFPLOGICNAME, this.getWFPLogicName());
        }
        if (!bDirtyOnly || this.isWFStepDataIdDirty()) {
            params.put(FIELD_WFSTEPDATAID, this.getWFStepDataId());
        }
        if (!bDirtyOnly || this.isWFStepDataNameDirty()) {
            params.put(FIELD_WFSTEPDATANAME, this.getWFStepDataName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
        }
        if (!bDirtyOnly || this.isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG, this.getWFStepLanResTag());
        }
        if (!bDirtyOnly || this.isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME, this.getWFStepName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFStepDataBase.get(this, index);
    }

    private static Object get(WFStepDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionTime();
            }
            case 1: {
                return et.getActorId();
            }
            case 2: {
                return et.getActorName();
            }
            case 3: {
                return et.getActorName2();
            }
            case 4: {
                return et.getConnectionName();
            }
            case 5: {
                return et.getCreateDate();
            }
            case 6: {
                return et.getCreateMan();
            }
            case 7: {
                return et.getMemo();
            }
            case 8: {
                return et.getNextTo();
            }
            case 9: {
                return et.getOriginalWFUserId();
            }
            case 10: {
                return et.getOriginalWFUserName();
            }
            case 11: {
                return et.getSDParam();
            }
            case 12: {
                return et.getSDParam2();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
                return et.getUpdateMan();
            }
            case 15: {
                return et.getUserData();
            }
            case 16: {
                return et.getUserDataDesc();
            }
            case 17: {
                return et.getWFActionLanResTag();
            }
            case 18: {
                return et.getWFInstanceId();
            }
            case 19: {
                return et.getWFInstanceName();
            }
            case 20: {
                return et.getWFPLogicName();
            }
            case 21: {
                return et.getWFStepDataId();
            }
            case 22: {
                return et.getWFStepDataName();
            }
            case 23: {
                return et.getWFStepId();
            }
            case 24: {
                return et.getWFStepLanResTag();
            }
            case 25: {
                return et.getWFStepName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFStepDataBase.set(this, index, objValue);
    }

    private static void set(WFStepDataBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActionTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setActorId(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setActorName(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setActorName2(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setConnectionName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setNextTo(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setOriginalWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setOriginalWFUserName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setSDParam(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setSDParam2(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 14: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUserDataDesc(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWFActionLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWFPLogicName(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWFStepDataId(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setWFStepDataName(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setWFStepLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setWFStepName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFStepDataBase.isNull(this, index);
    }

    private static boolean isNull(WFStepDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionTime() == null;
            }
            case 1: {
                return et.getActorId() == null;
            }
            case 2: {
                return et.getActorName() == null;
            }
            case 3: {
                return et.getActorName2() == null;
            }
            case 4: {
                return et.getConnectionName() == null;
            }
            case 5: {
                return et.getCreateDate() == null;
            }
            case 6: {
                return et.getCreateMan() == null;
            }
            case 7: {
                return et.getMemo() == null;
            }
            case 8: {
                return et.getNextTo() == null;
            }
            case 9: {
                return et.getOriginalWFUserId() == null;
            }
            case 10: {
                return et.getOriginalWFUserName() == null;
            }
            case 11: {
                return et.getSDParam() == null;
            }
            case 12: {
                return et.getSDParam2() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
                return et.getUpdateMan() == null;
            }
            case 15: {
                return et.getUserData() == null;
            }
            case 16: {
                return et.getUserDataDesc() == null;
            }
            case 17: {
                return et.getWFActionLanResTag() == null;
            }
            case 18: {
                return et.getWFInstanceId() == null;
            }
            case 19: {
                return et.getWFInstanceName() == null;
            }
            case 20: {
                return et.getWFPLogicName() == null;
            }
            case 21: {
                return et.getWFStepDataId() == null;
            }
            case 22: {
                return et.getWFStepDataName() == null;
            }
            case 23: {
                return et.getWFStepId() == null;
            }
            case 24: {
                return et.getWFStepLanResTag() == null;
            }
            case 25: {
                return et.getWFStepName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFStepDataBase.contains(this, index);
    }

    private static boolean contains(WFStepDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActionTimeDirty();
            }
            case 1: {
                return et.isActorIdDirty();
            }
            case 2: {
                return et.isActorNameDirty();
            }
            case 3: {
                return et.isActorName2Dirty();
            }
            case 4: {
                return et.isConnectionNameDirty();
            }
            case 5: {
                return et.isCreateDateDirty();
            }
            case 6: {
                return et.isCreateManDirty();
            }
            case 7: {
                return et.isMemoDirty();
            }
            case 8: {
                return et.isNextToDirty();
            }
            case 9: {
                return et.isOriginalWFUserIdDirty();
            }
            case 10: {
                return et.isOriginalWFUserNameDirty();
            }
            case 11: {
                return et.isSDParamDirty();
            }
            case 12: {
                return et.isSDParam2Dirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
            case 15: {
                return et.isUserDataDirty();
            }
            case 16: {
                return et.isUserDataDescDirty();
            }
            case 17: {
                return et.isWFActionLanResTagDirty();
            }
            case 18: {
                return et.isWFInstanceIdDirty();
            }
            case 19: {
                return et.isWFInstanceNameDirty();
            }
            case 20: {
                return et.isWFPLogicNameDirty();
            }
            case 21: {
                return et.isWFStepDataIdDirty();
            }
            case 22: {
                return et.isWFStepDataNameDirty();
            }
            case 23: {
                return et.isWFStepIdDirty();
            }
            case 24: {
                return et.isWFStepLanResTagDirty();
            }
            case 25: {
                return et.isWFStepNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFStepDataBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFStepDataBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActionTime() != null) {
            JSONObjectHelper.put(json, "actiontime", WFStepDataBase.getJSONValue(et.getActionTime()), false);
        }
        if (bIncEmpty || et.getActorId() != null) {
            JSONObjectHelper.put(json, "actorid", WFStepDataBase.getJSONValue(et.getActorId()), false);
        }
        if (bIncEmpty || et.getActorName() != null) {
            JSONObjectHelper.put(json, "actorname", WFStepDataBase.getJSONValue(et.getActorName()), false);
        }
        if (bIncEmpty || et.getActorName2() != null) {
            JSONObjectHelper.put(json, "actorname2", WFStepDataBase.getJSONValue(et.getActorName2()), false);
        }
        if (bIncEmpty || et.getConnectionName() != null) {
            JSONObjectHelper.put(json, "connectionname", WFStepDataBase.getJSONValue(et.getConnectionName()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFStepDataBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFStepDataBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFStepDataBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getNextTo() != null) {
            JSONObjectHelper.put(json, "nextto", WFStepDataBase.getJSONValue(et.getNextTo()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            JSONObjectHelper.put(json, "originalwfuserid", WFStepDataBase.getJSONValue(et.getOriginalWFUserId()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            JSONObjectHelper.put(json, "originalwfusername", WFStepDataBase.getJSONValue(et.getOriginalWFUserName()), false);
        }
        if (bIncEmpty || et.getSDParam() != null) {
            JSONObjectHelper.put(json, "sdparam", WFStepDataBase.getJSONValue(et.getSDParam()), false);
        }
        if (bIncEmpty || et.getSDParam2() != null) {
            JSONObjectHelper.put(json, "sdparam2", WFStepDataBase.getJSONValue(et.getSDParam2()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFStepDataBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFStepDataBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFStepDataBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserDataDesc() != null) {
            JSONObjectHelper.put(json, "userdatadesc", WFStepDataBase.getJSONValue(et.getUserDataDesc()), false);
        }
        if (bIncEmpty || et.getWFActionLanResTag() != null) {
            JSONObjectHelper.put(json, "wfactionlanrestag", WFStepDataBase.getJSONValue(et.getWFActionLanResTag()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFStepDataBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFStepDataBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFPLogicName() != null) {
            JSONObjectHelper.put(json, "wfplogicname", WFStepDataBase.getJSONValue(et.getWFPLogicName()), false);
        }
        if (bIncEmpty || et.getWFStepDataId() != null) {
            JSONObjectHelper.put(json, "wfstepdataid", WFStepDataBase.getJSONValue(et.getWFStepDataId()), false);
        }
        if (bIncEmpty || et.getWFStepDataName() != null) {
            JSONObjectHelper.put(json, "wfstepdataname", WFStepDataBase.getJSONValue(et.getWFStepDataName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFStepDataBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            JSONObjectHelper.put(json, "wfsteplanrestag", WFStepDataBase.getJSONValue(et.getWFStepLanResTag()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFStepDataBase.getJSONValue(et.getWFStepName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFStepDataBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFStepDataBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActionTime() != null) {
            obj = et.getActionTime();
            node.setAttribute(FIELD_ACTIONTIME, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getActorId() != null) {
            obj = et.getActorId();
            node.setAttribute(FIELD_ACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getActorName() != null) {
            obj = et.getActorName();
            node.setAttribute(FIELD_ACTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getActorName2() != null) {
            obj = et.getActorName2();
            node.setAttribute(FIELD_ACTORNAME2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getConnectionName() != null) {
            obj = et.getConnectionName();
            node.setAttribute(FIELD_CONNECTIONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNextTo() != null) {
            obj = et.getNextTo();
            node.setAttribute(FIELD_NEXTTO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            obj = et.getOriginalWFUserId();
            node.setAttribute(FIELD_ORIGINALWFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            obj = et.getOriginalWFUserName();
            node.setAttribute(FIELD_ORIGINALWFUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSDParam() != null) {
            obj = et.getSDParam();
            node.setAttribute(FIELD_SDPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSDParam2() != null) {
            obj = et.getSDParam2();
            node.setAttribute(FIELD_SDPARAM2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataDesc() != null) {
            obj = et.getUserDataDesc();
            node.setAttribute(FIELD_USERDATADESC, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActionLanResTag() != null) {
            obj = et.getWFActionLanResTag();
            node.setAttribute(FIELD_WFACTIONLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            obj = et.getWFInstanceId();
            node.setAttribute(FIELD_WFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            obj = et.getWFInstanceName();
            node.setAttribute(FIELD_WFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFPLogicName() != null) {
            obj = et.getWFPLogicName();
            node.setAttribute(FIELD_WFPLOGICNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepDataId() != null) {
            obj = et.getWFStepDataId();
            node.setAttribute(FIELD_WFSTEPDATAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepDataName() != null) {
            obj = et.getWFStepDataName();
            node.setAttribute(FIELD_WFSTEPDATANAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            obj = et.getWFStepId();
            node.setAttribute(FIELD_WFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            obj = et.getWFStepLanResTag();
            node.setAttribute(FIELD_WFSTEPLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            obj = et.getWFStepName();
            node.setAttribute(FIELD_WFSTEPNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepDataBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFStepDataBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActionTimeDirty() && (bIncEmpty || et.getActionTime() != null)) {
            dst.set(FIELD_ACTIONTIME, et.getActionTime());
        }
        if (et.isActorIdDirty() && (bIncEmpty || et.getActorId() != null)) {
            dst.set(FIELD_ACTORID, et.getActorId());
        }
        if (et.isActorNameDirty() && (bIncEmpty || et.getActorName() != null)) {
            dst.set(FIELD_ACTORNAME, et.getActorName());
        }
        if (et.isActorName2Dirty() && (bIncEmpty || et.getActorName2() != null)) {
            dst.set(FIELD_ACTORNAME2, et.getActorName2());
        }
        if (et.isConnectionNameDirty() && (bIncEmpty || et.getConnectionName() != null)) {
            dst.set(FIELD_CONNECTIONNAME, et.getConnectionName());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isNextToDirty() && (bIncEmpty || et.getNextTo() != null)) {
            dst.set(FIELD_NEXTTO, et.getNextTo());
        }
        if (et.isOriginalWFUserIdDirty() && (bIncEmpty || et.getOriginalWFUserId() != null)) {
            dst.set(FIELD_ORIGINALWFUSERID, et.getOriginalWFUserId());
        }
        if (et.isOriginalWFUserNameDirty() && (bIncEmpty || et.getOriginalWFUserName() != null)) {
            dst.set(FIELD_ORIGINALWFUSERNAME, et.getOriginalWFUserName());
        }
        if (et.isSDParamDirty() && (bIncEmpty || et.getSDParam() != null)) {
            dst.set(FIELD_SDPARAM, et.getSDParam());
        }
        if (et.isSDParam2Dirty() && (bIncEmpty || et.getSDParam2() != null)) {
            dst.set(FIELD_SDPARAM2, et.getSDParam2());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserDataDescDirty() && (bIncEmpty || et.getUserDataDesc() != null)) {
            dst.set(FIELD_USERDATADESC, et.getUserDataDesc());
        }
        if (et.isWFActionLanResTagDirty() && (bIncEmpty || et.getWFActionLanResTag() != null)) {
            dst.set(FIELD_WFACTIONLANRESTAG, et.getWFActionLanResTag());
        }
        if (et.isWFInstanceIdDirty() && (bIncEmpty || et.getWFInstanceId() != null)) {
            dst.set(FIELD_WFINSTANCEID, et.getWFInstanceId());
        }
        if (et.isWFInstanceNameDirty() && (bIncEmpty || et.getWFInstanceName() != null)) {
            dst.set(FIELD_WFINSTANCENAME, et.getWFInstanceName());
        }
        if (et.isWFPLogicNameDirty() && (bIncEmpty || et.getWFPLogicName() != null)) {
            dst.set(FIELD_WFPLOGICNAME, et.getWFPLogicName());
        }
        if (et.isWFStepDataIdDirty() && (bIncEmpty || et.getWFStepDataId() != null)) {
            dst.set(FIELD_WFSTEPDATAID, et.getWFStepDataId());
        }
        if (et.isWFStepDataNameDirty() && (bIncEmpty || et.getWFStepDataName() != null)) {
            dst.set(FIELD_WFSTEPDATANAME, et.getWFStepDataName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
        }
        if (et.isWFStepLanResTagDirty() && (bIncEmpty || et.getWFStepLanResTag() != null)) {
            dst.set(FIELD_WFSTEPLANRESTAG, et.getWFStepLanResTag());
        }
        if (et.isWFStepNameDirty() && (bIncEmpty || et.getWFStepName() != null)) {
            dst.set(FIELD_WFSTEPNAME, et.getWFStepName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFStepDataBase.remove(this, index);
    }

    private static boolean remove(WFStepDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActionTime();
                return true;
            }
            case 1: {
                et.resetActorId();
                return true;
            }
            case 2: {
                et.resetActorName();
                return true;
            }
            case 3: {
                et.resetActorName2();
                return true;
            }
            case 4: {
                et.resetConnectionName();
                return true;
            }
            case 5: {
                et.resetCreateDate();
                return true;
            }
            case 6: {
                et.resetCreateMan();
                return true;
            }
            case 7: {
                et.resetMemo();
                return true;
            }
            case 8: {
                et.resetNextTo();
                return true;
            }
            case 9: {
                et.resetOriginalWFUserId();
                return true;
            }
            case 10: {
                et.resetOriginalWFUserName();
                return true;
            }
            case 11: {
                et.resetSDParam();
                return true;
            }
            case 12: {
                et.resetSDParam2();
                return true;
            }
            case 13: {
                et.resetUpdateDate();
                return true;
            }
            case 14: {
                et.resetUpdateMan();
                return true;
            }
            case 15: {
                et.resetUserData();
                return true;
            }
            case 16: {
                et.resetUserDataDesc();
                return true;
            }
            case 17: {
                et.resetWFActionLanResTag();
                return true;
            }
            case 18: {
                et.resetWFInstanceId();
                return true;
            }
            case 19: {
                et.resetWFInstanceName();
                return true;
            }
            case 20: {
                et.resetWFPLogicName();
                return true;
            }
            case 21: {
                et.resetWFStepDataId();
                return true;
            }
            case 22: {
                et.resetWFStepDataName();
                return true;
            }
            case 23: {
                et.resetWFStepId();
                return true;
            }
            case 24: {
                et.resetWFStepLanResTag();
                return true;
            }
            case 25: {
                et.resetWFStepName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFInstance getWFInstance() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstance();
        }
        if (this.getWFInstanceId() == null) {
            return null;
        }
        Integer n = this.objWFInstanceLock;
        synchronized (n) {
            if (this.wfinstance != null && DataTypeHelper.compare(25, (Object)this.getWFInstanceId(), (Object)this.wfinstance.getWFInstanceId()) != 0L) {
                this.wfinstance = null;
            }
            if (this.wfinstance == null) {
                WFInstance wfinstance = new WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                WFInstanceService service = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStep getWFStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStep();
        }
        if (this.getWFStepId() == null) {
            return null;
        }
        Integer n = this.objWFStepLock;
        synchronized (n) {
            if (this.wfstep != null && DataTypeHelper.compare(25, (Object)this.getWFStepId(), (Object)this.wfstep.getWFStepId()) != 0L) {
                this.wfstep = null;
            }
            if (this.wfstep == null) {
                WFStep wfstep = new WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getOriginalWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUser();
        }
        if (this.getOriginalWFUserId() == null) {
            return null;
        }
        Integer n = this.objOriginalWFUserLock;
        synchronized (n) {
            if (this.originalwfuser != null && DataTypeHelper.compare(25, (Object)this.getOriginalWFUserId(), (Object)this.originalwfuser.getWFUserId()) != 0L) {
                this.originalwfuser = null;
            }
            if (this.originalwfuser == null) {
                WFUser originalwfuser = new WFUser();
                originalwfuser.setWFUserId(this.getOriginalWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(originalwfuser);
                this.originalwfuser = originalwfuser;
            }
            return this.originalwfuser;
        }
    }

    private WFStepDataBase getProxyEntity() {
        return this.proxyWFStepDataBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepDataBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFStepDataBase) {
            this.proxyWFStepDataBase = (WFStepDataBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepDataService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

