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
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFWorkflowBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFWorkflowBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_REMINDMSGTEMPLID = "REMINDMSGTEMPLID";
    public static final String FIELD_REMINDMSGTEMPLNAME = "REMINDMSGTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATACMD = "USERDATACMD";
    public static final String FIELD_USERDATACMD10 = "USERDATACMD10";
    public static final String FIELD_USERDATACMD2 = "USERDATACMD2";
    public static final String FIELD_USERDATACMD3 = "USERDATACMD3";
    public static final String FIELD_USERDATACMD4 = "USERDATACMD4";
    public static final String FIELD_USERDATACMD5 = "USERDATACMD5";
    public static final String FIELD_USERDATACMD6 = "USERDATACMD6";
    public static final String FIELD_USERDATACMD7 = "USERDATACMD7";
    public static final String FIELD_USERDATACMD8 = "USERDATACMD8";
    public static final String FIELD_USERDATACMD9 = "USERDATACMD9";
    public static final String FIELD_USERDATANAME = "USERDATANAME";
    public static final String FIELD_WFHELPER = "WFHELPER";
    public static final String FIELD_WFHELPERPARAM = "WFHELPERPARAM";
    public static final String FIELD_WFLANRESTAG = "WFLANRESTAG";
    public static final String FIELD_WFLOGICNAME = "WFLOGICNAME";
    public static final String FIELD_WFMODEL = "WFMODEL";
    public static final String FIELD_WFSTATE = "WFSTATE";
    public static final String FIELD_WFTYPE = "WFTYPE";
    public static final String FIELD_WFVERSION = "WFVERSION";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_REMINDMSGTEMPLID = 4;
    private static final int INDEX_REMINDMSGTEMPLNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USERDATACMD = 8;
    private static final int INDEX_USERDATACMD10 = 9;
    private static final int INDEX_USERDATACMD2 = 10;
    private static final int INDEX_USERDATACMD3 = 11;
    private static final int INDEX_USERDATACMD4 = 12;
    private static final int INDEX_USERDATACMD5 = 13;
    private static final int INDEX_USERDATACMD6 = 14;
    private static final int INDEX_USERDATACMD7 = 15;
    private static final int INDEX_USERDATACMD8 = 16;
    private static final int INDEX_USERDATACMD9 = 17;
    private static final int INDEX_USERDATANAME = 18;
    private static final int INDEX_WFHELPER = 19;
    private static final int INDEX_WFHELPERPARAM = 20;
    private static final int INDEX_WFLANRESTAG = 21;
    private static final int INDEX_WFLOGICNAME = 22;
    private static final int INDEX_WFMODEL = 23;
    private static final int INDEX_WFSTATE = 24;
    private static final int INDEX_WFTYPE = 25;
    private static final int INDEX_WFVERSION = 26;
    private static final int INDEX_WFWORKFLOWID = 27;
    private static final int INDEX_WFWORKFLOWNAME = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFWorkflowBase proxyWFWorkflowBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean remindmsgtemplidDirtyFlag = false;
    private boolean remindmsgtemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdatacmdDirtyFlag = false;
    private boolean userdatacmd10DirtyFlag = false;
    private boolean userdatacmd2DirtyFlag = false;
    private boolean userdatacmd3DirtyFlag = false;
    private boolean userdatacmd4DirtyFlag = false;
    private boolean userdatacmd5DirtyFlag = false;
    private boolean userdatacmd6DirtyFlag = false;
    private boolean userdatacmd7DirtyFlag = false;
    private boolean userdatacmd8DirtyFlag = false;
    private boolean userdatacmd9DirtyFlag = false;
    private boolean userdatanameDirtyFlag = false;
    private boolean wfhelperDirtyFlag = false;
    private boolean wfhelperparamDirtyFlag = false;
    private boolean wflanrestagDirtyFlag = false;
    private boolean wflogicnameDirtyFlag = false;
    private boolean wfmodelDirtyFlag = false;
    private boolean wfstateDirtyFlag = false;
    private boolean wftypeDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="remindmsgtemplid")
    private String remindmsgtemplid;
    @Column(name="remindmsgtemplname")
    private String remindmsgtemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdatacmd")
    private String userdatacmd;
    @Column(name="userdatacmd10")
    private String userdatacmd10;
    @Column(name="userdatacmd2")
    private String userdatacmd2;
    @Column(name="userdatacmd3")
    private String userdatacmd3;
    @Column(name="userdatacmd4")
    private String userdatacmd4;
    @Column(name="userdatacmd5")
    private String userdatacmd5;
    @Column(name="userdatacmd6")
    private String userdatacmd6;
    @Column(name="userdatacmd7")
    private String userdatacmd7;
    @Column(name="userdatacmd8")
    private String userdatacmd8;
    @Column(name="userdatacmd9")
    private String userdatacmd9;
    @Column(name="userdataname")
    private String userdataname;
    @Column(name="wfhelper")
    private String wfhelper;
    @Column(name="wfhelperparam")
    private String wfhelperparam;
    @Column(name="wflanrestag")
    private String wflanrestag;
    @Column(name="wflogicname")
    private String wflogicname;
    @Column(name="wfmodel")
    private String wfmodel;
    @Column(name="wfstate")
    private Integer wfstate;
    @Column(name="wftype")
    private String wftype;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    private Integer objRemindMsgTemplLock = new Integer(1);
    private MsgTemplate remindmsgtempl = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_REMINDMSGTEMPLID, 4);
        fieldIndexMap.put(FIELD_REMINDMSGTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USERDATACMD, 8);
        fieldIndexMap.put(FIELD_USERDATACMD10, 9);
        fieldIndexMap.put(FIELD_USERDATACMD2, 10);
        fieldIndexMap.put(FIELD_USERDATACMD3, 11);
        fieldIndexMap.put(FIELD_USERDATACMD4, 12);
        fieldIndexMap.put(FIELD_USERDATACMD5, 13);
        fieldIndexMap.put(FIELD_USERDATACMD6, 14);
        fieldIndexMap.put(FIELD_USERDATACMD7, 15);
        fieldIndexMap.put(FIELD_USERDATACMD8, 16);
        fieldIndexMap.put(FIELD_USERDATACMD9, 17);
        fieldIndexMap.put(FIELD_USERDATANAME, 18);
        fieldIndexMap.put(FIELD_WFHELPER, 19);
        fieldIndexMap.put(FIELD_WFHELPERPARAM, 20);
        fieldIndexMap.put(FIELD_WFLANRESTAG, 21);
        fieldIndexMap.put(FIELD_WFLOGICNAME, 22);
        fieldIndexMap.put(FIELD_WFMODEL, 23);
        fieldIndexMap.put(FIELD_WFSTATE, 24);
        fieldIndexMap.put(FIELD_WFTYPE, 25);
        fieldIndexMap.put(FIELD_WFVERSION, 26);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 27);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 28);
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

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setRemindMsgTemplId(String remindmsgtemplid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindMsgTemplId(remindmsgtemplid);
            return;
        }
        if (remindmsgtemplid != null && (remindmsgtemplid = StringHelper.trimRight(remindmsgtemplid)).length() == 0) {
            remindmsgtemplid = null;
        }
        this.remindmsgtemplid = remindmsgtemplid;
        this.remindmsgtemplidDirtyFlag = true;
    }

    public String getRemindMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTemplId();
        }
        return this.remindmsgtemplid;
    }

    public boolean isRemindMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindMsgTemplIdDirty();
        }
        return this.remindmsgtemplidDirtyFlag;
    }

    public void resetRemindMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindMsgTemplId();
            return;
        }
        this.remindmsgtemplidDirtyFlag = false;
        this.remindmsgtemplid = null;
    }

    public void setRemindMsgTemplName(String remindmsgtemplname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindMsgTemplName(remindmsgtemplname);
            return;
        }
        if (remindmsgtemplname != null && (remindmsgtemplname = StringHelper.trimRight(remindmsgtemplname)).length() == 0) {
            remindmsgtemplname = null;
        }
        this.remindmsgtemplname = remindmsgtemplname;
        this.remindmsgtemplnameDirtyFlag = true;
    }

    public String getRemindMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTemplName();
        }
        return this.remindmsgtemplname;
    }

    public boolean isRemindMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindMsgTemplNameDirty();
        }
        return this.remindmsgtemplnameDirtyFlag;
    }

    public void resetRemindMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindMsgTemplName();
            return;
        }
        this.remindmsgtemplnameDirtyFlag = false;
        this.remindmsgtemplname = null;
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

    public void setUserDataCmd(String userdatacmd) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd(userdatacmd);
            return;
        }
        if (userdatacmd != null && (userdatacmd = StringHelper.trimRight(userdatacmd)).length() == 0) {
            userdatacmd = null;
        }
        this.userdatacmd = userdatacmd;
        this.userdatacmdDirtyFlag = true;
    }

    public String getUserDataCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd();
        }
        return this.userdatacmd;
    }

    public boolean isUserDataCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmdDirty();
        }
        return this.userdatacmdDirtyFlag;
    }

    public void resetUserDataCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd();
            return;
        }
        this.userdatacmdDirtyFlag = false;
        this.userdatacmd = null;
    }

    public void setUserDataCmd10(String userdatacmd10) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd10(userdatacmd10);
            return;
        }
        if (userdatacmd10 != null && (userdatacmd10 = StringHelper.trimRight(userdatacmd10)).length() == 0) {
            userdatacmd10 = null;
        }
        this.userdatacmd10 = userdatacmd10;
        this.userdatacmd10DirtyFlag = true;
    }

    public String getUserDataCmd10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd10();
        }
        return this.userdatacmd10;
    }

    public boolean isUserDataCmd10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd10Dirty();
        }
        return this.userdatacmd10DirtyFlag;
    }

    public void resetUserDataCmd10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd10();
            return;
        }
        this.userdatacmd10DirtyFlag = false;
        this.userdatacmd10 = null;
    }

    public void setUserDataCmd2(String userdatacmd2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd2(userdatacmd2);
            return;
        }
        if (userdatacmd2 != null && (userdatacmd2 = StringHelper.trimRight(userdatacmd2)).length() == 0) {
            userdatacmd2 = null;
        }
        this.userdatacmd2 = userdatacmd2;
        this.userdatacmd2DirtyFlag = true;
    }

    public String getUserDataCmd2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd2();
        }
        return this.userdatacmd2;
    }

    public boolean isUserDataCmd2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd2Dirty();
        }
        return this.userdatacmd2DirtyFlag;
    }

    public void resetUserDataCmd2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd2();
            return;
        }
        this.userdatacmd2DirtyFlag = false;
        this.userdatacmd2 = null;
    }

    public void setUserDataCmd3(String userdatacmd3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd3(userdatacmd3);
            return;
        }
        if (userdatacmd3 != null && (userdatacmd3 = StringHelper.trimRight(userdatacmd3)).length() == 0) {
            userdatacmd3 = null;
        }
        this.userdatacmd3 = userdatacmd3;
        this.userdatacmd3DirtyFlag = true;
    }

    public String getUserDataCmd3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd3();
        }
        return this.userdatacmd3;
    }

    public boolean isUserDataCmd3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd3Dirty();
        }
        return this.userdatacmd3DirtyFlag;
    }

    public void resetUserDataCmd3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd3();
            return;
        }
        this.userdatacmd3DirtyFlag = false;
        this.userdatacmd3 = null;
    }

    public void setUserDataCmd4(String userdatacmd4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd4(userdatacmd4);
            return;
        }
        if (userdatacmd4 != null && (userdatacmd4 = StringHelper.trimRight(userdatacmd4)).length() == 0) {
            userdatacmd4 = null;
        }
        this.userdatacmd4 = userdatacmd4;
        this.userdatacmd4DirtyFlag = true;
    }

    public String getUserDataCmd4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd4();
        }
        return this.userdatacmd4;
    }

    public boolean isUserDataCmd4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd4Dirty();
        }
        return this.userdatacmd4DirtyFlag;
    }

    public void resetUserDataCmd4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd4();
            return;
        }
        this.userdatacmd4DirtyFlag = false;
        this.userdatacmd4 = null;
    }

    public void setUserDataCmd5(String userdatacmd5) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd5(userdatacmd5);
            return;
        }
        if (userdatacmd5 != null && (userdatacmd5 = StringHelper.trimRight(userdatacmd5)).length() == 0) {
            userdatacmd5 = null;
        }
        this.userdatacmd5 = userdatacmd5;
        this.userdatacmd5DirtyFlag = true;
    }

    public String getUserDataCmd5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd5();
        }
        return this.userdatacmd5;
    }

    public boolean isUserDataCmd5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd5Dirty();
        }
        return this.userdatacmd5DirtyFlag;
    }

    public void resetUserDataCmd5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd5();
            return;
        }
        this.userdatacmd5DirtyFlag = false;
        this.userdatacmd5 = null;
    }

    public void setUserDataCmd6(String userdatacmd6) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd6(userdatacmd6);
            return;
        }
        if (userdatacmd6 != null && (userdatacmd6 = StringHelper.trimRight(userdatacmd6)).length() == 0) {
            userdatacmd6 = null;
        }
        this.userdatacmd6 = userdatacmd6;
        this.userdatacmd6DirtyFlag = true;
    }

    public String getUserDataCmd6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd6();
        }
        return this.userdatacmd6;
    }

    public boolean isUserDataCmd6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd6Dirty();
        }
        return this.userdatacmd6DirtyFlag;
    }

    public void resetUserDataCmd6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd6();
            return;
        }
        this.userdatacmd6DirtyFlag = false;
        this.userdatacmd6 = null;
    }

    public void setUserDataCmd7(String userdatacmd7) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd7(userdatacmd7);
            return;
        }
        if (userdatacmd7 != null && (userdatacmd7 = StringHelper.trimRight(userdatacmd7)).length() == 0) {
            userdatacmd7 = null;
        }
        this.userdatacmd7 = userdatacmd7;
        this.userdatacmd7DirtyFlag = true;
    }

    public String getUserDataCmd7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd7();
        }
        return this.userdatacmd7;
    }

    public boolean isUserDataCmd7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd7Dirty();
        }
        return this.userdatacmd7DirtyFlag;
    }

    public void resetUserDataCmd7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd7();
            return;
        }
        this.userdatacmd7DirtyFlag = false;
        this.userdatacmd7 = null;
    }

    public void setUserDataCmd8(String userdatacmd8) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd8(userdatacmd8);
            return;
        }
        if (userdatacmd8 != null && (userdatacmd8 = StringHelper.trimRight(userdatacmd8)).length() == 0) {
            userdatacmd8 = null;
        }
        this.userdatacmd8 = userdatacmd8;
        this.userdatacmd8DirtyFlag = true;
    }

    public String getUserDataCmd8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd8();
        }
        return this.userdatacmd8;
    }

    public boolean isUserDataCmd8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd8Dirty();
        }
        return this.userdatacmd8DirtyFlag;
    }

    public void resetUserDataCmd8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd8();
            return;
        }
        this.userdatacmd8DirtyFlag = false;
        this.userdatacmd8 = null;
    }

    public void setUserDataCmd9(String userdatacmd9) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataCmd9(userdatacmd9);
            return;
        }
        if (userdatacmd9 != null && (userdatacmd9 = StringHelper.trimRight(userdatacmd9)).length() == 0) {
            userdatacmd9 = null;
        }
        this.userdatacmd9 = userdatacmd9;
        this.userdatacmd9DirtyFlag = true;
    }

    public String getUserDataCmd9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataCmd9();
        }
        return this.userdatacmd9;
    }

    public boolean isUserDataCmd9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataCmd9Dirty();
        }
        return this.userdatacmd9DirtyFlag;
    }

    public void resetUserDataCmd9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataCmd9();
            return;
        }
        this.userdatacmd9DirtyFlag = false;
        this.userdatacmd9 = null;
    }

    public void setUserDataName(String userdataname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataName(userdataname);
            return;
        }
        if (userdataname != null && (userdataname = StringHelper.trimRight(userdataname)).length() == 0) {
            userdataname = null;
        }
        this.userdataname = userdataname;
        this.userdatanameDirtyFlag = true;
    }

    public String getUserDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataName();
        }
        return this.userdataname;
    }

    public boolean isUserDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataNameDirty();
        }
        return this.userdatanameDirtyFlag;
    }

    public void resetUserDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataName();
            return;
        }
        this.userdatanameDirtyFlag = false;
        this.userdataname = null;
    }

    public void setWFHelper(String wfhelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFHelper(wfhelper);
            return;
        }
        if (wfhelper != null && (wfhelper = StringHelper.trimRight(wfhelper)).length() == 0) {
            wfhelper = null;
        }
        this.wfhelper = wfhelper;
        this.wfhelperDirtyFlag = true;
    }

    public String getWFHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFHelper();
        }
        return this.wfhelper;
    }

    public boolean isWFHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFHelperDirty();
        }
        return this.wfhelperDirtyFlag;
    }

    public void resetWFHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFHelper();
            return;
        }
        this.wfhelperDirtyFlag = false;
        this.wfhelper = null;
    }

    public void setWFHelperParam(String wfhelperparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFHelperParam(wfhelperparam);
            return;
        }
        if (wfhelperparam != null && (wfhelperparam = StringHelper.trimRight(wfhelperparam)).length() == 0) {
            wfhelperparam = null;
        }
        this.wfhelperparam = wfhelperparam;
        this.wfhelperparamDirtyFlag = true;
    }

    public String getWFHelperParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFHelperParam();
        }
        return this.wfhelperparam;
    }

    public boolean isWFHelperParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFHelperParamDirty();
        }
        return this.wfhelperparamDirtyFlag;
    }

    public void resetWFHelperParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFHelperParam();
            return;
        }
        this.wfhelperparamDirtyFlag = false;
        this.wfhelperparam = null;
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

    public void setWFLogicName(String wflogicname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFLogicName(wflogicname);
            return;
        }
        if (wflogicname != null && (wflogicname = StringHelper.trimRight(wflogicname)).length() == 0) {
            wflogicname = null;
        }
        this.wflogicname = wflogicname;
        this.wflogicnameDirtyFlag = true;
    }

    public String getWFLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFLogicName();
        }
        return this.wflogicname;
    }

    public boolean isWFLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFLogicNameDirty();
        }
        return this.wflogicnameDirtyFlag;
    }

    public void resetWFLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFLogicName();
            return;
        }
        this.wflogicnameDirtyFlag = false;
        this.wflogicname = null;
    }

    public void setWFModel(String wfmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFModel(wfmodel);
            return;
        }
        if (wfmodel != null && (wfmodel = StringHelper.trimRight(wfmodel)).length() == 0) {
            wfmodel = null;
        }
        this.wfmodel = wfmodel;
        this.wfmodelDirtyFlag = true;
    }

    public String getWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    public boolean isWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    public void resetWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFModel();
            return;
        }
        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
    }

    public void setWFState(Integer wfstate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFState(wfstate);
            return;
        }
        this.wfstate = wfstate;
        this.wfstateDirtyFlag = true;
    }

    public Integer getWFState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFState();
        }
        return this.wfstate;
    }

    public boolean isWFStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStateDirty();
        }
        return this.wfstateDirtyFlag;
    }

    public void resetWFState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFState();
            return;
        }
        this.wfstateDirtyFlag = false;
        this.wfstate = null;
    }

    public void setWFType(String wftype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFType(wftype);
            return;
        }
        if (wftype != null && (wftype = StringHelper.trimRight(wftype)).length() == 0) {
            wftype = null;
        }
        this.wftype = wftype;
        this.wftypeDirtyFlag = true;
    }

    public String getWFType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFType();
        }
        return this.wftype;
    }

    public boolean isWFTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTypeDirty();
        }
        return this.wftypeDirtyFlag;
    }

    public void resetWFType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFType();
            return;
        }
        this.wftypeDirtyFlag = false;
        this.wftype = null;
    }

    public void setWFVersion(Integer wfversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
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

    @Override
    protected void onReset() {
        WFWorkflowBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFWorkflowBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetMemo();
        et.resetRemindMsgTemplId();
        et.resetRemindMsgTemplName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDataCmd();
        et.resetUserDataCmd10();
        et.resetUserDataCmd2();
        et.resetUserDataCmd3();
        et.resetUserDataCmd4();
        et.resetUserDataCmd5();
        et.resetUserDataCmd6();
        et.resetUserDataCmd7();
        et.resetUserDataCmd8();
        et.resetUserDataCmd9();
        et.resetUserDataName();
        et.resetWFHelper();
        et.resetWFHelperParam();
        et.resetWFLanResTag();
        et.resetWFLogicName();
        et.resetWFModel();
        et.resetWFState();
        et.resetWFType();
        et.resetWFVersion();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isRemindMsgTemplIdDirty()) {
            params.put(FIELD_REMINDMSGTEMPLID, this.getRemindMsgTemplId());
        }
        if (!bDirtyOnly || this.isRemindMsgTemplNameDirty()) {
            params.put(FIELD_REMINDMSGTEMPLNAME, this.getRemindMsgTemplName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataCmdDirty()) {
            params.put(FIELD_USERDATACMD, this.getUserDataCmd());
        }
        if (!bDirtyOnly || this.isUserDataCmd10Dirty()) {
            params.put(FIELD_USERDATACMD10, this.getUserDataCmd10());
        }
        if (!bDirtyOnly || this.isUserDataCmd2Dirty()) {
            params.put(FIELD_USERDATACMD2, this.getUserDataCmd2());
        }
        if (!bDirtyOnly || this.isUserDataCmd3Dirty()) {
            params.put(FIELD_USERDATACMD3, this.getUserDataCmd3());
        }
        if (!bDirtyOnly || this.isUserDataCmd4Dirty()) {
            params.put(FIELD_USERDATACMD4, this.getUserDataCmd4());
        }
        if (!bDirtyOnly || this.isUserDataCmd5Dirty()) {
            params.put(FIELD_USERDATACMD5, this.getUserDataCmd5());
        }
        if (!bDirtyOnly || this.isUserDataCmd6Dirty()) {
            params.put(FIELD_USERDATACMD6, this.getUserDataCmd6());
        }
        if (!bDirtyOnly || this.isUserDataCmd7Dirty()) {
            params.put(FIELD_USERDATACMD7, this.getUserDataCmd7());
        }
        if (!bDirtyOnly || this.isUserDataCmd8Dirty()) {
            params.put(FIELD_USERDATACMD8, this.getUserDataCmd8());
        }
        if (!bDirtyOnly || this.isUserDataCmd9Dirty()) {
            params.put(FIELD_USERDATACMD9, this.getUserDataCmd9());
        }
        if (!bDirtyOnly || this.isUserDataNameDirty()) {
            params.put(FIELD_USERDATANAME, this.getUserDataName());
        }
        if (!bDirtyOnly || this.isWFHelperDirty()) {
            params.put(FIELD_WFHELPER, this.getWFHelper());
        }
        if (!bDirtyOnly || this.isWFHelperParamDirty()) {
            params.put(FIELD_WFHELPERPARAM, this.getWFHelperParam());
        }
        if (!bDirtyOnly || this.isWFLanResTagDirty()) {
            params.put(FIELD_WFLANRESTAG, this.getWFLanResTag());
        }
        if (!bDirtyOnly || this.isWFLogicNameDirty()) {
            params.put(FIELD_WFLOGICNAME, this.getWFLogicName());
        }
        if (!bDirtyOnly || this.isWFModelDirty()) {
            params.put(FIELD_WFMODEL, this.getWFModel());
        }
        if (!bDirtyOnly || this.isWFStateDirty()) {
            params.put(FIELD_WFSTATE, this.getWFState());
        }
        if (!bDirtyOnly || this.isWFTypeDirty()) {
            params.put(FIELD_WFTYPE, this.getWFType());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        if (!bDirtyOnly || this.isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID, this.getWFWorkflowId());
        }
        if (!bDirtyOnly || this.isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME, this.getWFWorkflowName());
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
        return WFWorkflowBase.get(this, index);
    }

    private static Object get(WFWorkflowBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnable();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getRemindMsgTemplId();
            }
            case 5: {
                return et.getRemindMsgTemplName();
            }
            case 6: {
                return et.getUpdateDate();
            }
            case 7: {
                return et.getUpdateMan();
            }
            case 8: {
                return et.getUserDataCmd();
            }
            case 9: {
                return et.getUserDataCmd10();
            }
            case 10: {
                return et.getUserDataCmd2();
            }
            case 11: {
                return et.getUserDataCmd3();
            }
            case 12: {
                return et.getUserDataCmd4();
            }
            case 13: {
                return et.getUserDataCmd5();
            }
            case 14: {
                return et.getUserDataCmd6();
            }
            case 15: {
                return et.getUserDataCmd7();
            }
            case 16: {
                return et.getUserDataCmd8();
            }
            case 17: {
                return et.getUserDataCmd9();
            }
            case 18: {
                return et.getUserDataName();
            }
            case 19: {
                return et.getWFHelper();
            }
            case 20: {
                return et.getWFHelperParam();
            }
            case 21: {
                return et.getWFLanResTag();
            }
            case 22: {
                return et.getWFLogicName();
            }
            case 23: {
                return et.getWFModel();
            }
            case 24: {
                return et.getWFState();
            }
            case 25: {
                return et.getWFType();
            }
            case 26: {
                return et.getWFVersion();
            }
            case 27: {
                return et.getWFWorkflowId();
            }
            case 28: {
                return et.getWFWorkflowName();
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
        WFWorkflowBase.set(this, index, objValue);
    }

    private static void set(WFWorkflowBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setRemindMsgTemplId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setRemindMsgTemplName(DataObject.getStringValue(obj));
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
                et.setUserDataCmd(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUserDataCmd10(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserDataCmd2(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserDataCmd3(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserDataCmd4(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserDataCmd5(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserDataCmd6(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserDataCmd7(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUserDataCmd8(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setUserDataCmd9(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setUserDataName(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setWFHelper(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWFHelperParam(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWFLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setWFLogicName(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setWFModel(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setWFState(DataObject.getIntegerValue(obj));
                return;
            }
            case 25: {
                et.setWFType(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setWFVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 27: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 28: {
                et.setWFWorkflowName(DataObject.getStringValue(obj));
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
        return WFWorkflowBase.isNull(this, index);
    }

    private static boolean isNull(WFWorkflowBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnable() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getRemindMsgTemplId() == null;
            }
            case 5: {
                return et.getRemindMsgTemplName() == null;
            }
            case 6: {
                return et.getUpdateDate() == null;
            }
            case 7: {
                return et.getUpdateMan() == null;
            }
            case 8: {
                return et.getUserDataCmd() == null;
            }
            case 9: {
                return et.getUserDataCmd10() == null;
            }
            case 10: {
                return et.getUserDataCmd2() == null;
            }
            case 11: {
                return et.getUserDataCmd3() == null;
            }
            case 12: {
                return et.getUserDataCmd4() == null;
            }
            case 13: {
                return et.getUserDataCmd5() == null;
            }
            case 14: {
                return et.getUserDataCmd6() == null;
            }
            case 15: {
                return et.getUserDataCmd7() == null;
            }
            case 16: {
                return et.getUserDataCmd8() == null;
            }
            case 17: {
                return et.getUserDataCmd9() == null;
            }
            case 18: {
                return et.getUserDataName() == null;
            }
            case 19: {
                return et.getWFHelper() == null;
            }
            case 20: {
                return et.getWFHelperParam() == null;
            }
            case 21: {
                return et.getWFLanResTag() == null;
            }
            case 22: {
                return et.getWFLogicName() == null;
            }
            case 23: {
                return et.getWFModel() == null;
            }
            case 24: {
                return et.getWFState() == null;
            }
            case 25: {
                return et.getWFType() == null;
            }
            case 26: {
                return et.getWFVersion() == null;
            }
            case 27: {
                return et.getWFWorkflowId() == null;
            }
            case 28: {
                return et.getWFWorkflowName() == null;
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
        return WFWorkflowBase.contains(this, index);
    }

    private static boolean contains(WFWorkflowBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isRemindMsgTemplIdDirty();
            }
            case 5: {
                return et.isRemindMsgTemplNameDirty();
            }
            case 6: {
                return et.isUpdateDateDirty();
            }
            case 7: {
                return et.isUpdateManDirty();
            }
            case 8: {
                return et.isUserDataCmdDirty();
            }
            case 9: {
                return et.isUserDataCmd10Dirty();
            }
            case 10: {
                return et.isUserDataCmd2Dirty();
            }
            case 11: {
                return et.isUserDataCmd3Dirty();
            }
            case 12: {
                return et.isUserDataCmd4Dirty();
            }
            case 13: {
                return et.isUserDataCmd5Dirty();
            }
            case 14: {
                return et.isUserDataCmd6Dirty();
            }
            case 15: {
                return et.isUserDataCmd7Dirty();
            }
            case 16: {
                return et.isUserDataCmd8Dirty();
            }
            case 17: {
                return et.isUserDataCmd9Dirty();
            }
            case 18: {
                return et.isUserDataNameDirty();
            }
            case 19: {
                return et.isWFHelperDirty();
            }
            case 20: {
                return et.isWFHelperParamDirty();
            }
            case 21: {
                return et.isWFLanResTagDirty();
            }
            case 22: {
                return et.isWFLogicNameDirty();
            }
            case 23: {
                return et.isWFModelDirty();
            }
            case 24: {
                return et.isWFStateDirty();
            }
            case 25: {
                return et.isWFTypeDirty();
            }
            case 26: {
                return et.isWFVersionDirty();
            }
            case 27: {
                return et.isWFWorkflowIdDirty();
            }
            case 28: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFWorkflowBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFWorkflowBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFWorkflowBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFWorkflowBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", WFWorkflowBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFWorkflowBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getRemindMsgTemplId() != null) {
            JSONObjectHelper.put(json, "remindmsgtemplid", WFWorkflowBase.getJSONValue(et.getRemindMsgTemplId()), false);
        }
        if (bIncEmpty || et.getRemindMsgTemplName() != null) {
            JSONObjectHelper.put(json, "remindmsgtemplname", WFWorkflowBase.getJSONValue(et.getRemindMsgTemplName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFWorkflowBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFWorkflowBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserDataCmd() != null) {
            JSONObjectHelper.put(json, "userdatacmd", WFWorkflowBase.getJSONValue(et.getUserDataCmd()), false);
        }
        if (bIncEmpty || et.getUserDataCmd10() != null) {
            JSONObjectHelper.put(json, "userdatacmd10", WFWorkflowBase.getJSONValue(et.getUserDataCmd10()), false);
        }
        if (bIncEmpty || et.getUserDataCmd2() != null) {
            JSONObjectHelper.put(json, "userdatacmd2", WFWorkflowBase.getJSONValue(et.getUserDataCmd2()), false);
        }
        if (bIncEmpty || et.getUserDataCmd3() != null) {
            JSONObjectHelper.put(json, "userdatacmd3", WFWorkflowBase.getJSONValue(et.getUserDataCmd3()), false);
        }
        if (bIncEmpty || et.getUserDataCmd4() != null) {
            JSONObjectHelper.put(json, "userdatacmd4", WFWorkflowBase.getJSONValue(et.getUserDataCmd4()), false);
        }
        if (bIncEmpty || et.getUserDataCmd5() != null) {
            JSONObjectHelper.put(json, "userdatacmd5", WFWorkflowBase.getJSONValue(et.getUserDataCmd5()), false);
        }
        if (bIncEmpty || et.getUserDataCmd6() != null) {
            JSONObjectHelper.put(json, "userdatacmd6", WFWorkflowBase.getJSONValue(et.getUserDataCmd6()), false);
        }
        if (bIncEmpty || et.getUserDataCmd7() != null) {
            JSONObjectHelper.put(json, "userdatacmd7", WFWorkflowBase.getJSONValue(et.getUserDataCmd7()), false);
        }
        if (bIncEmpty || et.getUserDataCmd8() != null) {
            JSONObjectHelper.put(json, "userdatacmd8", WFWorkflowBase.getJSONValue(et.getUserDataCmd8()), false);
        }
        if (bIncEmpty || et.getUserDataCmd9() != null) {
            JSONObjectHelper.put(json, "userdatacmd9", WFWorkflowBase.getJSONValue(et.getUserDataCmd9()), false);
        }
        if (bIncEmpty || et.getUserDataName() != null) {
            JSONObjectHelper.put(json, "userdataname", WFWorkflowBase.getJSONValue(et.getUserDataName()), false);
        }
        if (bIncEmpty || et.getWFHelper() != null) {
            JSONObjectHelper.put(json, "wfhelper", WFWorkflowBase.getJSONValue(et.getWFHelper()), false);
        }
        if (bIncEmpty || et.getWFHelperParam() != null) {
            JSONObjectHelper.put(json, "wfhelperparam", WFWorkflowBase.getJSONValue(et.getWFHelperParam()), false);
        }
        if (bIncEmpty || et.getWFLanResTag() != null) {
            JSONObjectHelper.put(json, "wflanrestag", WFWorkflowBase.getJSONValue(et.getWFLanResTag()), false);
        }
        if (bIncEmpty || et.getWFLogicName() != null) {
            JSONObjectHelper.put(json, "wflogicname", WFWorkflowBase.getJSONValue(et.getWFLogicName()), false);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            JSONObjectHelper.put(json, "wfmodel", WFWorkflowBase.getJSONValue(et.getWFModel()), false);
        }
        if (bIncEmpty || et.getWFState() != null) {
            JSONObjectHelper.put(json, "wfstate", WFWorkflowBase.getJSONValue(et.getWFState()), false);
        }
        if (bIncEmpty || et.getWFType() != null) {
            JSONObjectHelper.put(json, "wftype", WFWorkflowBase.getJSONValue(et.getWFType()), false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put(json, "wfversion", WFWorkflowBase.getJSONValue(et.getWFVersion()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFWorkflowBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFWorkflowBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFWorkflowBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFWorkflowBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRemindMsgTemplId() != null) {
            obj = et.getRemindMsgTemplId();
            node.setAttribute(FIELD_REMINDMSGTEMPLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRemindMsgTemplName() != null) {
            obj = et.getRemindMsgTemplName();
            node.setAttribute(FIELD_REMINDMSGTEMPLNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd() != null) {
            obj = et.getUserDataCmd();
            node.setAttribute(FIELD_USERDATACMD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd10() != null) {
            obj = et.getUserDataCmd10();
            node.setAttribute(FIELD_USERDATACMD10, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd2() != null) {
            obj = et.getUserDataCmd2();
            node.setAttribute(FIELD_USERDATACMD2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd3() != null) {
            obj = et.getUserDataCmd3();
            node.setAttribute(FIELD_USERDATACMD3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd4() != null) {
            obj = et.getUserDataCmd4();
            node.setAttribute(FIELD_USERDATACMD4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd5() != null) {
            obj = et.getUserDataCmd5();
            node.setAttribute(FIELD_USERDATACMD5, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd6() != null) {
            obj = et.getUserDataCmd6();
            node.setAttribute(FIELD_USERDATACMD6, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd7() != null) {
            obj = et.getUserDataCmd7();
            node.setAttribute(FIELD_USERDATACMD7, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd8() != null) {
            obj = et.getUserDataCmd8();
            node.setAttribute(FIELD_USERDATACMD8, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataCmd9() != null) {
            obj = et.getUserDataCmd9();
            node.setAttribute(FIELD_USERDATACMD9, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataName() != null) {
            obj = et.getUserDataName();
            node.setAttribute(FIELD_USERDATANAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFHelper() != null) {
            obj = et.getWFHelper();
            node.setAttribute(FIELD_WFHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFHelperParam() != null) {
            obj = et.getWFHelperParam();
            node.setAttribute(FIELD_WFHELPERPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFLanResTag() != null) {
            obj = et.getWFLanResTag();
            node.setAttribute(FIELD_WFLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFLogicName() != null) {
            obj = et.getWFLogicName();
            node.setAttribute(FIELD_WFLOGICNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            obj = et.getWFModel();
            node.setAttribute(FIELD_WFMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFState() != null) {
            obj = et.getWFState();
            node.setAttribute(FIELD_WFSTATE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFType() != null) {
            obj = et.getWFType();
            node.setAttribute(FIELD_WFTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            obj = et.getWFWorkflowId();
            node.setAttribute(FIELD_WFWORKFLOWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            obj = et.getWFWorkflowName();
            node.setAttribute(FIELD_WFWORKFLOWNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFWorkflowBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFWorkflowBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isRemindMsgTemplIdDirty() && (bIncEmpty || et.getRemindMsgTemplId() != null)) {
            dst.set(FIELD_REMINDMSGTEMPLID, et.getRemindMsgTemplId());
        }
        if (et.isRemindMsgTemplNameDirty() && (bIncEmpty || et.getRemindMsgTemplName() != null)) {
            dst.set(FIELD_REMINDMSGTEMPLNAME, et.getRemindMsgTemplName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataCmdDirty() && (bIncEmpty || et.getUserDataCmd() != null)) {
            dst.set(FIELD_USERDATACMD, et.getUserDataCmd());
        }
        if (et.isUserDataCmd10Dirty() && (bIncEmpty || et.getUserDataCmd10() != null)) {
            dst.set(FIELD_USERDATACMD10, et.getUserDataCmd10());
        }
        if (et.isUserDataCmd2Dirty() && (bIncEmpty || et.getUserDataCmd2() != null)) {
            dst.set(FIELD_USERDATACMD2, et.getUserDataCmd2());
        }
        if (et.isUserDataCmd3Dirty() && (bIncEmpty || et.getUserDataCmd3() != null)) {
            dst.set(FIELD_USERDATACMD3, et.getUserDataCmd3());
        }
        if (et.isUserDataCmd4Dirty() && (bIncEmpty || et.getUserDataCmd4() != null)) {
            dst.set(FIELD_USERDATACMD4, et.getUserDataCmd4());
        }
        if (et.isUserDataCmd5Dirty() && (bIncEmpty || et.getUserDataCmd5() != null)) {
            dst.set(FIELD_USERDATACMD5, et.getUserDataCmd5());
        }
        if (et.isUserDataCmd6Dirty() && (bIncEmpty || et.getUserDataCmd6() != null)) {
            dst.set(FIELD_USERDATACMD6, et.getUserDataCmd6());
        }
        if (et.isUserDataCmd7Dirty() && (bIncEmpty || et.getUserDataCmd7() != null)) {
            dst.set(FIELD_USERDATACMD7, et.getUserDataCmd7());
        }
        if (et.isUserDataCmd8Dirty() && (bIncEmpty || et.getUserDataCmd8() != null)) {
            dst.set(FIELD_USERDATACMD8, et.getUserDataCmd8());
        }
        if (et.isUserDataCmd9Dirty() && (bIncEmpty || et.getUserDataCmd9() != null)) {
            dst.set(FIELD_USERDATACMD9, et.getUserDataCmd9());
        }
        if (et.isUserDataNameDirty() && (bIncEmpty || et.getUserDataName() != null)) {
            dst.set(FIELD_USERDATANAME, et.getUserDataName());
        }
        if (et.isWFHelperDirty() && (bIncEmpty || et.getWFHelper() != null)) {
            dst.set(FIELD_WFHELPER, et.getWFHelper());
        }
        if (et.isWFHelperParamDirty() && (bIncEmpty || et.getWFHelperParam() != null)) {
            dst.set(FIELD_WFHELPERPARAM, et.getWFHelperParam());
        }
        if (et.isWFLanResTagDirty() && (bIncEmpty || et.getWFLanResTag() != null)) {
            dst.set(FIELD_WFLANRESTAG, et.getWFLanResTag());
        }
        if (et.isWFLogicNameDirty() && (bIncEmpty || et.getWFLogicName() != null)) {
            dst.set(FIELD_WFLOGICNAME, et.getWFLogicName());
        }
        if (et.isWFModelDirty() && (bIncEmpty || et.getWFModel() != null)) {
            dst.set(FIELD_WFMODEL, et.getWFModel());
        }
        if (et.isWFStateDirty() && (bIncEmpty || et.getWFState() != null)) {
            dst.set(FIELD_WFSTATE, et.getWFState());
        }
        if (et.isWFTypeDirty() && (bIncEmpty || et.getWFType() != null)) {
            dst.set(FIELD_WFTYPE, et.getWFType());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, et.getWFVersion());
        }
        if (et.isWFWorkflowIdDirty() && (bIncEmpty || et.getWFWorkflowId() != null)) {
            dst.set(FIELD_WFWORKFLOWID, et.getWFWorkflowId());
        }
        if (et.isWFWorkflowNameDirty() && (bIncEmpty || et.getWFWorkflowName() != null)) {
            dst.set(FIELD_WFWORKFLOWNAME, et.getWFWorkflowName());
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
        return WFWorkflowBase.remove(this, index);
    }

    private static boolean remove(WFWorkflowBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetEnable();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetRemindMsgTemplId();
                return true;
            }
            case 5: {
                et.resetRemindMsgTemplName();
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
                et.resetUserDataCmd();
                return true;
            }
            case 9: {
                et.resetUserDataCmd10();
                return true;
            }
            case 10: {
                et.resetUserDataCmd2();
                return true;
            }
            case 11: {
                et.resetUserDataCmd3();
                return true;
            }
            case 12: {
                et.resetUserDataCmd4();
                return true;
            }
            case 13: {
                et.resetUserDataCmd5();
                return true;
            }
            case 14: {
                et.resetUserDataCmd6();
                return true;
            }
            case 15: {
                et.resetUserDataCmd7();
                return true;
            }
            case 16: {
                et.resetUserDataCmd8();
                return true;
            }
            case 17: {
                et.resetUserDataCmd9();
                return true;
            }
            case 18: {
                et.resetUserDataName();
                return true;
            }
            case 19: {
                et.resetWFHelper();
                return true;
            }
            case 20: {
                et.resetWFHelperParam();
                return true;
            }
            case 21: {
                et.resetWFLanResTag();
                return true;
            }
            case 22: {
                et.resetWFLogicName();
                return true;
            }
            case 23: {
                et.resetWFModel();
                return true;
            }
            case 24: {
                et.resetWFState();
                return true;
            }
            case 25: {
                et.resetWFType();
                return true;
            }
            case 26: {
                et.resetWFVersion();
                return true;
            }
            case 27: {
                et.resetWFWorkflowId();
                return true;
            }
            case 28: {
                et.resetWFWorkflowName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MsgTemplate getRemindMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTempl();
        }
        if (this.getRemindMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objRemindMsgTemplLock;
        synchronized (n) {
            if (this.remindmsgtempl != null && DataTypeHelper.compare(25, (Object)this.getRemindMsgTemplId(), (Object)this.remindmsgtempl.getMsgTemplateId()) != 0L) {
                this.remindmsgtempl = null;
            }
            if (this.remindmsgtempl == null) {
                MsgTemplate remindmsgtempl = new MsgTemplate();
                remindmsgtempl.setMsgTemplateId(this.getRemindMsgTemplId());
                MsgTemplateService service = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class, this.getSessionFactory());
                service.autoGet(remindmsgtempl);
                this.remindmsgtempl = remindmsgtempl;
            }
            return this.remindmsgtempl;
        }
    }

    private WFWorkflowBase getProxyEntity() {
        return this.proxyWFWorkflowBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFWorkflowBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFWorkflowBase) {
            this.proxyWFWorkflowBase = (WFWorkflowBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFWorkflowService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

