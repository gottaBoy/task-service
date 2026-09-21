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
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFWorkListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFWorkListBase.class);
    public static final String FIELD_CANCELFLAG = "CANCELFLAG";
    public static final String FIELD_CANCELINFORM = "CANCELINFORM";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
    public static final String FIELD_ORIGINALWFUSERNAME = "ORIGINALWFUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_USERDATAINFO = "USERDATAINFO";
    public static final String FIELD_WFACTORID = "WFACTORID";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFLANRESTAG = "WFLANRESTAG";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    public static final String FIELD_WFWORKLISTID = "WFWORKLISTID";
    public static final String FIELD_WFWORKLISTNAME = "WFWORKLISTNAME";
    public static final String FIELD_WORKINFORM = "WORKINFORM";
    private static final int INDEX_CANCELFLAG = 0;
    private static final int INDEX_CANCELINFORM = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ORIGINALWFUSERID = 4;
    private static final int INDEX_ORIGINALWFUSERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USERDATA = 8;
    private static final int INDEX_USERDATA2 = 9;
    private static final int INDEX_USERDATA3 = 10;
    private static final int INDEX_USERDATA4 = 11;
    private static final int INDEX_USERDATAINFO = 12;
    private static final int INDEX_WFACTORID = 13;
    private static final int INDEX_WFINSTANCEID = 14;
    private static final int INDEX_WFINSTANCENAME = 15;
    private static final int INDEX_WFLANRESTAG = 16;
    private static final int INDEX_WFSTEPID = 17;
    private static final int INDEX_WFSTEPLANRESTAG = 18;
    private static final int INDEX_WFSTEPNAME = 19;
    private static final int INDEX_WFWORKFLOWID = 20;
    private static final int INDEX_WFWORKFLOWNAME = 21;
    private static final int INDEX_WFWORKLISTID = 22;
    private static final int INDEX_WFWORKLISTNAME = 23;
    private static final int INDEX_WORKINFORM = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFWorkListBase proxyWFWorkListBase = null;
    private boolean cancelflagDirtyFlag = false;
    private boolean cancelinformDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean originalwfuseridDirtyFlag = false;
    private boolean originalwfusernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean userdatainfoDirtyFlag = false;
    private boolean wfactoridDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wflanrestagDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    private boolean wfworklistidDirtyFlag = false;
    private boolean wfworklistnameDirtyFlag = false;
    private boolean workinformDirtyFlag = false;
    @Column(name="cancelflag")
    private Integer cancelflag;
    @Column(name="cancelinform")
    private Integer cancelinform;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="originalwfuserid")
    private String originalwfuserid;
    @Column(name="originalwfusername")
    private String originalwfusername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userdata3")
    private String userdata3;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="userdatainfo")
    private String userdatainfo;
    @Column(name="wfactorid")
    private String wfactorid;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wflanrestag")
    private String wflanrestag;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    @Column(name="wfworklistid")
    private String wfworklistid;
    @Column(name="wfworklistname")
    private String wfworklistname;
    @Column(name="workinform")
    private Integer workinform;
    private Integer objWFInstanceLock = new Integer(1);
    private WFInstance wfinstance = null;
    private Integer objOriginalWFUserLock = new Integer(1);
    private WFUser originalwfuser = null;

    static {
        fieldIndexMap.put(FIELD_CANCELFLAG, 0);
        fieldIndexMap.put(FIELD_CANCELINFORM, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERID, 4);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USERDATA, 8);
        fieldIndexMap.put(FIELD_USERDATA2, 9);
        fieldIndexMap.put(FIELD_USERDATA3, 10);
        fieldIndexMap.put(FIELD_USERDATA4, 11);
        fieldIndexMap.put(FIELD_USERDATAINFO, 12);
        fieldIndexMap.put(FIELD_WFACTORID, 13);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 14);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 15);
        fieldIndexMap.put(FIELD_WFLANRESTAG, 16);
        fieldIndexMap.put(FIELD_WFSTEPID, 17);
        fieldIndexMap.put(FIELD_WFSTEPLANRESTAG, 18);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 19);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 20);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 21);
        fieldIndexMap.put(FIELD_WFWORKLISTID, 22);
        fieldIndexMap.put(FIELD_WFWORKLISTNAME, 23);
        fieldIndexMap.put(FIELD_WORKINFORM, 24);
    }

    public void setCancelFlag(Integer cancelflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelFlag(cancelflag);
            return;
        }
        this.cancelflag = cancelflag;
        this.cancelflagDirtyFlag = true;
    }

    public Integer getCancelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelFlag();
        }
        return this.cancelflag;
    }

    public boolean isCancelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelFlagDirty();
        }
        return this.cancelflagDirtyFlag;
    }

    public void resetCancelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelFlag();
            return;
        }
        this.cancelflagDirtyFlag = false;
        this.cancelflag = null;
    }

    public void setCancelInform(Integer cancelinform) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelInform(cancelinform);
            return;
        }
        this.cancelinform = cancelinform;
        this.cancelinformDirtyFlag = true;
    }

    public Integer getCancelInform() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelInform();
        }
        return this.cancelinform;
    }

    public boolean isCancelInformDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelInformDirty();
        }
        return this.cancelinformDirtyFlag;
    }

    public void resetCancelInform() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelInform();
            return;
        }
        this.cancelinformDirtyFlag = false;
        this.cancelinform = null;
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

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserData3(String userdata3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if (userdata3 != null && (userdata3 = StringHelper.trimRight(userdata3)).length() == 0) {
            userdata3 = null;
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag = true;
    }

    public String getUserData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    public boolean isUserData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    public void resetUserData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData3();
            return;
        }
        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }

    public void setUserData4(String userdata4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if (userdata4 != null && (userdata4 = StringHelper.trimRight(userdata4)).length() == 0) {
            userdata4 = null;
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag = true;
    }

    public String getUserData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    public boolean isUserData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    public void resetUserData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData4();
            return;
        }
        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }

    public void setUserDataInfo(String userdatainfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataInfo(userdatainfo);
            return;
        }
        if (userdatainfo != null && (userdatainfo = StringHelper.trimRight(userdatainfo)).length() == 0) {
            userdatainfo = null;
        }
        this.userdatainfo = userdatainfo;
        this.userdatainfoDirtyFlag = true;
    }

    public String getUserDataInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataInfo();
        }
        return this.userdatainfo;
    }

    public boolean isUserDataInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataInfoDirty();
        }
        return this.userdatainfoDirtyFlag;
    }

    public void resetUserDataInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataInfo();
            return;
        }
        this.userdatainfoDirtyFlag = false;
        this.userdatainfo = null;
    }

    public void setWFActorId(String wfactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorId(wfactorid);
            return;
        }
        if (wfactorid != null && (wfactorid = StringHelper.trimRight(wfactorid)).length() == 0) {
            wfactorid = null;
        }
        this.wfactorid = wfactorid;
        this.wfactoridDirtyFlag = true;
    }

    public String getWFActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorId();
        }
        return this.wfactorid;
    }

    public boolean isWFActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorIdDirty();
        }
        return this.wfactoridDirtyFlag;
    }

    public void resetWFActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorId();
            return;
        }
        this.wfactoridDirtyFlag = false;
        this.wfactorid = null;
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

    public void setWFLanResTag(String wflanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFLanResTag(wflanrestag);
            return;
        }
        if (wflanrestag != null && (wflanrestag = StringHelper.trimRight(wflanrestag)).length() == 0) {
            wflanrestag = null;
        }
        this.wflanrestag = wflanrestag;
        this.wflanrestagDirtyFlag = true;
    }

    public String getWFLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFLanResTag();
        }
        return this.wflanrestag;
    }

    public boolean isWFLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFLanResTagDirty();
        }
        return this.wflanrestagDirtyFlag;
    }

    public void resetWFLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFLanResTag();
            return;
        }
        this.wflanrestagDirtyFlag = false;
        this.wflanrestag = null;
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

    public void setWFWorkflowId(String wfworkflowid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if (wfworkflowid != null && (wfworkflowid = StringHelper.trimRight(wfworkflowid)).length() == 0) {
            wfworkflowid = null;
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag = true;
    }

    public String getWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    public boolean isWFWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    public void resetWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }
        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }

    public void setWFWorkflowName(String wfworkflowname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if (wfworkflowname != null && (wfworkflowname = StringHelper.trimRight(wfworkflowname)).length() == 0) {
            wfworkflowname = null;
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag = true;
    }

    public String getWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    public boolean isWFWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    public void resetWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }
        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    public void setWFWorkListId(String wfworklistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkListId(wfworklistid);
            return;
        }
        if (wfworklistid != null && (wfworklistid = StringHelper.trimRight(wfworklistid)).length() == 0) {
            wfworklistid = null;
        }
        this.wfworklistid = wfworklistid;
        this.wfworklistidDirtyFlag = true;
    }

    public String getWFWorkListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkListId();
        }
        return this.wfworklistid;
    }

    public boolean isWFWorkListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkListIdDirty();
        }
        return this.wfworklistidDirtyFlag;
    }

    public void resetWFWorkListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkListId();
            return;
        }
        this.wfworklistidDirtyFlag = false;
        this.wfworklistid = null;
    }

    public void setWFWorkListName(String wfworklistname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkListName(wfworklistname);
            return;
        }
        if (wfworklistname != null && (wfworklistname = StringHelper.trimRight(wfworklistname)).length() == 0) {
            wfworklistname = null;
        }
        this.wfworklistname = wfworklistname;
        this.wfworklistnameDirtyFlag = true;
    }

    public String getWFWorkListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkListName();
        }
        return this.wfworklistname;
    }

    public boolean isWFWorkListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkListNameDirty();
        }
        return this.wfworklistnameDirtyFlag;
    }

    public void resetWFWorkListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkListName();
            return;
        }
        this.wfworklistnameDirtyFlag = false;
        this.wfworklistname = null;
    }

    public void setWorkInform(Integer workinform) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkInform(workinform);
            return;
        }
        this.workinform = workinform;
        this.workinformDirtyFlag = true;
    }

    public Integer getWorkInform() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkInform();
        }
        return this.workinform;
    }

    public boolean isWorkInformDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkInformDirty();
        }
        return this.workinformDirtyFlag;
    }

    public void resetWorkInform() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkInform();
            return;
        }
        this.workinformDirtyFlag = false;
        this.workinform = null;
    }

    @Override
    protected void onReset() {
        WFWorkListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFWorkListBase et) {
        et.resetCancelFlag();
        et.resetCancelInform();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetOriginalWFUserId();
        et.resetOriginalWFUserName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
        et.resetUserDataInfo();
        et.resetWFActorId();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFLanResTag();
        et.resetWFStepId();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
        et.resetWFWorkListId();
        et.resetWFWorkListName();
        et.resetWorkInform();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCancelFlagDirty()) {
            params.put(FIELD_CANCELFLAG, this.getCancelFlag());
        }
        if (!bDirtyOnly || this.isCancelInformDirty()) {
            params.put(FIELD_CANCELINFORM, this.getCancelInform());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isOriginalWFUserIdDirty()) {
            params.put(FIELD_ORIGINALWFUSERID, this.getOriginalWFUserId());
        }
        if (!bDirtyOnly || this.isOriginalWFUserNameDirty()) {
            params.put(FIELD_ORIGINALWFUSERNAME, this.getOriginalWFUserName());
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
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isUserData3Dirty()) {
            params.put(FIELD_USERDATA3, this.getUserData3());
        }
        if (!bDirtyOnly || this.isUserData4Dirty()) {
            params.put(FIELD_USERDATA4, this.getUserData4());
        }
        if (!bDirtyOnly || this.isUserDataInfoDirty()) {
            params.put(FIELD_USERDATAINFO, this.getUserDataInfo());
        }
        if (!bDirtyOnly || this.isWFActorIdDirty()) {
            params.put(FIELD_WFACTORID, this.getWFActorId());
        }
        if (!bDirtyOnly || this.isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID, this.getWFInstanceId());
        }
        if (!bDirtyOnly || this.isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME, this.getWFInstanceName());
        }
        if (!bDirtyOnly || this.isWFLanResTagDirty()) {
            params.put(FIELD_WFLANRESTAG, this.getWFLanResTag());
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
        if (!bDirtyOnly || this.isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID, this.getWFWorkflowId());
        }
        if (!bDirtyOnly || this.isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME, this.getWFWorkflowName());
        }
        if (!bDirtyOnly || this.isWFWorkListIdDirty()) {
            params.put(FIELD_WFWORKLISTID, this.getWFWorkListId());
        }
        if (!bDirtyOnly || this.isWFWorkListNameDirty()) {
            params.put(FIELD_WFWORKLISTNAME, this.getWFWorkListName());
        }
        if (!bDirtyOnly || this.isWorkInformDirty()) {
            params.put(FIELD_WORKINFORM, this.getWorkInform());
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
        return WFWorkListBase.get(this, index);
    }

    private static Object get(WFWorkListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCancelFlag();
            }
            case 1: {
                return et.getCancelInform();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getOriginalWFUserId();
            }
            case 5: {
                return et.getOriginalWFUserName();
            }
            case 6: {
                return et.getUpdateDate();
            }
            case 7: {
                return et.getUpdateMan();
            }
            case 8: {
                return et.getUserData();
            }
            case 9: {
                return et.getUserData2();
            }
            case 10: {
                return et.getUserData3();
            }
            case 11: {
                return et.getUserData4();
            }
            case 12: {
                return et.getUserDataInfo();
            }
            case 13: {
                return et.getWFActorId();
            }
            case 14: {
                return et.getWFInstanceId();
            }
            case 15: {
                return et.getWFInstanceName();
            }
            case 16: {
                return et.getWFLanResTag();
            }
            case 17: {
                return et.getWFStepId();
            }
            case 18: {
                return et.getWFStepLanResTag();
            }
            case 19: {
                return et.getWFStepName();
            }
            case 20: {
                return et.getWFWorkflowId();
            }
            case 21: {
                return et.getWFWorkflowName();
            }
            case 22: {
                return et.getWFWorkListId();
            }
            case 23: {
                return et.getWFWorkListName();
            }
            case 24: {
                return et.getWorkInform();
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
        WFWorkListBase.set(this, index, objValue);
    }

    private static void set(WFWorkListBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCancelFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setCancelInform(DataObject.getIntegerValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setOriginalWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setOriginalWFUserName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserData3(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserData4(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserDataInfo(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWFActorId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setWFLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setWFStepLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setWFStepName(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWFWorkflowName(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setWFWorkListId(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setWFWorkListName(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setWorkInform(DataObject.getIntegerValue(obj));
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
        return WFWorkListBase.isNull(this, index);
    }

    private static boolean isNull(WFWorkListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCancelFlag() == null;
            }
            case 1: {
                return et.getCancelInform() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getOriginalWFUserId() == null;
            }
            case 5: {
                return et.getOriginalWFUserName() == null;
            }
            case 6: {
                return et.getUpdateDate() == null;
            }
            case 7: {
                return et.getUpdateMan() == null;
            }
            case 8: {
                return et.getUserData() == null;
            }
            case 9: {
                return et.getUserData2() == null;
            }
            case 10: {
                return et.getUserData3() == null;
            }
            case 11: {
                return et.getUserData4() == null;
            }
            case 12: {
                return et.getUserDataInfo() == null;
            }
            case 13: {
                return et.getWFActorId() == null;
            }
            case 14: {
                return et.getWFInstanceId() == null;
            }
            case 15: {
                return et.getWFInstanceName() == null;
            }
            case 16: {
                return et.getWFLanResTag() == null;
            }
            case 17: {
                return et.getWFStepId() == null;
            }
            case 18: {
                return et.getWFStepLanResTag() == null;
            }
            case 19: {
                return et.getWFStepName() == null;
            }
            case 20: {
                return et.getWFWorkflowId() == null;
            }
            case 21: {
                return et.getWFWorkflowName() == null;
            }
            case 22: {
                return et.getWFWorkListId() == null;
            }
            case 23: {
                return et.getWFWorkListName() == null;
            }
            case 24: {
                return et.getWorkInform() == null;
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
        return WFWorkListBase.contains(this, index);
    }

    private static boolean contains(WFWorkListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCancelFlagDirty();
            }
            case 1: {
                return et.isCancelInformDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isOriginalWFUserIdDirty();
            }
            case 5: {
                return et.isOriginalWFUserNameDirty();
            }
            case 6: {
                return et.isUpdateDateDirty();
            }
            case 7: {
                return et.isUpdateManDirty();
            }
            case 8: {
                return et.isUserDataDirty();
            }
            case 9: {
                return et.isUserData2Dirty();
            }
            case 10: {
                return et.isUserData3Dirty();
            }
            case 11: {
                return et.isUserData4Dirty();
            }
            case 12: {
                return et.isUserDataInfoDirty();
            }
            case 13: {
                return et.isWFActorIdDirty();
            }
            case 14: {
                return et.isWFInstanceIdDirty();
            }
            case 15: {
                return et.isWFInstanceNameDirty();
            }
            case 16: {
                return et.isWFLanResTagDirty();
            }
            case 17: {
                return et.isWFStepIdDirty();
            }
            case 18: {
                return et.isWFStepLanResTagDirty();
            }
            case 19: {
                return et.isWFStepNameDirty();
            }
            case 20: {
                return et.isWFWorkflowIdDirty();
            }
            case 21: {
                return et.isWFWorkflowNameDirty();
            }
            case 22: {
                return et.isWFWorkListIdDirty();
            }
            case 23: {
                return et.isWFWorkListNameDirty();
            }
            case 24: {
                return et.isWorkInformDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFWorkListBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFWorkListBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCancelFlag() != null) {
            JSONObjectHelper.put(json, "cancelflag", WFWorkListBase.getJSONValue(et.getCancelFlag()), false);
        }
        if (bIncEmpty || et.getCancelInform() != null) {
            JSONObjectHelper.put(json, "cancelinform", WFWorkListBase.getJSONValue(et.getCancelInform()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFWorkListBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFWorkListBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            JSONObjectHelper.put(json, "originalwfuserid", WFWorkListBase.getJSONValue(et.getOriginalWFUserId()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            JSONObjectHelper.put(json, "originalwfusername", WFWorkListBase.getJSONValue(et.getOriginalWFUserName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFWorkListBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFWorkListBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFWorkListBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", WFWorkListBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            JSONObjectHelper.put(json, "userdata3", WFWorkListBase.getJSONValue(et.getUserData3()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", WFWorkListBase.getJSONValue(et.getUserData4()), false);
        }
        if (bIncEmpty || et.getUserDataInfo() != null) {
            JSONObjectHelper.put(json, "userdatainfo", WFWorkListBase.getJSONValue(et.getUserDataInfo()), false);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            JSONObjectHelper.put(json, "wfactorid", WFWorkListBase.getJSONValue(et.getWFActorId()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFWorkListBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFWorkListBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFLanResTag() != null) {
            JSONObjectHelper.put(json, "wflanrestag", WFWorkListBase.getJSONValue(et.getWFLanResTag()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFWorkListBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            JSONObjectHelper.put(json, "wfsteplanrestag", WFWorkListBase.getJSONValue(et.getWFStepLanResTag()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFWorkListBase.getJSONValue(et.getWFStepName()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFWorkListBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFWorkListBase.getJSONValue(et.getWFWorkflowName()), false);
        }
        if (bIncEmpty || et.getWFWorkListId() != null) {
            JSONObjectHelper.put(json, "wfworklistid", WFWorkListBase.getJSONValue(et.getWFWorkListId()), false);
        }
        if (bIncEmpty || et.getWFWorkListName() != null) {
            JSONObjectHelper.put(json, "wfworklistname", WFWorkListBase.getJSONValue(et.getWFWorkListName()), false);
        }
        if (bIncEmpty || et.getWorkInform() != null) {
            JSONObjectHelper.put(json, "workinform", WFWorkListBase.getJSONValue(et.getWorkInform()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFWorkListBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFWorkListBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCancelFlag() != null) {
            obj = et.getCancelFlag();
            node.setAttribute(FIELD_CANCELFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCancelInform() != null) {
            obj = et.getCancelInform();
            node.setAttribute(FIELD_CANCELINFORM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            obj = et.getOriginalWFUserId();
            node.setAttribute(FIELD_ORIGINALWFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            obj = et.getOriginalWFUserName();
            node.setAttribute(FIELD_ORIGINALWFUSERNAME, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            obj = et.getUserData3();
            node.setAttribute(FIELD_USERDATA3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            obj = et.getUserData4();
            node.setAttribute(FIELD_USERDATA4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataInfo() != null) {
            obj = et.getUserDataInfo();
            node.setAttribute(FIELD_USERDATAINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            obj = et.getWFActorId();
            node.setAttribute(FIELD_WFACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            obj = et.getWFInstanceId();
            node.setAttribute(FIELD_WFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            obj = et.getWFInstanceName();
            node.setAttribute(FIELD_WFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFLanResTag() != null) {
            obj = et.getWFLanResTag();
            node.setAttribute(FIELD_WFLANRESTAG, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            obj = et.getWFWorkflowId();
            node.setAttribute(FIELD_WFWORKFLOWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            obj = et.getWFWorkflowName();
            node.setAttribute(FIELD_WFWORKFLOWNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkListId() != null) {
            obj = et.getWFWorkListId();
            node.setAttribute(FIELD_WFWORKLISTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkListName() != null) {
            obj = et.getWFWorkListName();
            node.setAttribute(FIELD_WFWORKLISTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWorkInform() != null) {
            obj = et.getWorkInform();
            node.setAttribute(FIELD_WORKINFORM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFWorkListBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFWorkListBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCancelFlagDirty() && (bIncEmpty || et.getCancelFlag() != null)) {
            dst.set(FIELD_CANCELFLAG, et.getCancelFlag());
        }
        if (et.isCancelInformDirty() && (bIncEmpty || et.getCancelInform() != null)) {
            dst.set(FIELD_CANCELINFORM, et.getCancelInform());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isOriginalWFUserIdDirty() && (bIncEmpty || et.getOriginalWFUserId() != null)) {
            dst.set(FIELD_ORIGINALWFUSERID, et.getOriginalWFUserId());
        }
        if (et.isOriginalWFUserNameDirty() && (bIncEmpty || et.getOriginalWFUserName() != null)) {
            dst.set(FIELD_ORIGINALWFUSERNAME, et.getOriginalWFUserName());
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
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isUserData3Dirty() && (bIncEmpty || et.getUserData3() != null)) {
            dst.set(FIELD_USERDATA3, et.getUserData3());
        }
        if (et.isUserData4Dirty() && (bIncEmpty || et.getUserData4() != null)) {
            dst.set(FIELD_USERDATA4, et.getUserData4());
        }
        if (et.isUserDataInfoDirty() && (bIncEmpty || et.getUserDataInfo() != null)) {
            dst.set(FIELD_USERDATAINFO, et.getUserDataInfo());
        }
        if (et.isWFActorIdDirty() && (bIncEmpty || et.getWFActorId() != null)) {
            dst.set(FIELD_WFACTORID, et.getWFActorId());
        }
        if (et.isWFInstanceIdDirty() && (bIncEmpty || et.getWFInstanceId() != null)) {
            dst.set(FIELD_WFINSTANCEID, et.getWFInstanceId());
        }
        if (et.isWFInstanceNameDirty() && (bIncEmpty || et.getWFInstanceName() != null)) {
            dst.set(FIELD_WFINSTANCENAME, et.getWFInstanceName());
        }
        if (et.isWFLanResTagDirty() && (bIncEmpty || et.getWFLanResTag() != null)) {
            dst.set(FIELD_WFLANRESTAG, et.getWFLanResTag());
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
        if (et.isWFWorkflowIdDirty() && (bIncEmpty || et.getWFWorkflowId() != null)) {
            dst.set(FIELD_WFWORKFLOWID, et.getWFWorkflowId());
        }
        if (et.isWFWorkflowNameDirty() && (bIncEmpty || et.getWFWorkflowName() != null)) {
            dst.set(FIELD_WFWORKFLOWNAME, et.getWFWorkflowName());
        }
        if (et.isWFWorkListIdDirty() && (bIncEmpty || et.getWFWorkListId() != null)) {
            dst.set(FIELD_WFWORKLISTID, et.getWFWorkListId());
        }
        if (et.isWFWorkListNameDirty() && (bIncEmpty || et.getWFWorkListName() != null)) {
            dst.set(FIELD_WFWORKLISTNAME, et.getWFWorkListName());
        }
        if (et.isWorkInformDirty() && (bIncEmpty || et.getWorkInform() != null)) {
            dst.set(FIELD_WORKINFORM, et.getWorkInform());
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
        return WFWorkListBase.remove(this, index);
    }

    private static boolean remove(WFWorkListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCancelFlag();
                return true;
            }
            case 1: {
                et.resetCancelInform();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetOriginalWFUserId();
                return true;
            }
            case 5: {
                et.resetOriginalWFUserName();
                return true;
            }
            case 6: {
                et.resetUpdateDate();
                return true;
            }
            case 7: {
                et.resetUpdateMan();
                return true;
            }
            case 8: {
                et.resetUserData();
                return true;
            }
            case 9: {
                et.resetUserData2();
                return true;
            }
            case 10: {
                et.resetUserData3();
                return true;
            }
            case 11: {
                et.resetUserData4();
                return true;
            }
            case 12: {
                et.resetUserDataInfo();
                return true;
            }
            case 13: {
                et.resetWFActorId();
                return true;
            }
            case 14: {
                et.resetWFInstanceId();
                return true;
            }
            case 15: {
                et.resetWFInstanceName();
                return true;
            }
            case 16: {
                et.resetWFLanResTag();
                return true;
            }
            case 17: {
                et.resetWFStepId();
                return true;
            }
            case 18: {
                et.resetWFStepLanResTag();
                return true;
            }
            case 19: {
                et.resetWFStepName();
                return true;
            }
            case 20: {
                et.resetWFWorkflowId();
                return true;
            }
            case 21: {
                et.resetWFWorkflowName();
                return true;
            }
            case 22: {
                et.resetWFWorkListId();
                return true;
            }
            case 23: {
                et.resetWFWorkListName();
                return true;
            }
            case 24: {
                et.resetWorkInform();
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

    private WFWorkListBase getProxyEntity() {
        return this.proxyWFWorkListBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFWorkListBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFWorkListBase) {
            this.proxyWFWorkListBase = (WFWorkListBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFWorkListService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

