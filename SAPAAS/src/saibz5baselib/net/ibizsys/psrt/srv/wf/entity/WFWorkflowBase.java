/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[WFWorkflow] 数据对象基类
 */
public abstract class WFWorkflowBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFWorkflowBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[工作流说明]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[催办消息模板]
     */
    public final static String FIELD_REMINDMSGTEMPLID = "REMINDMSGTEMPLID";
    /**
     * 属性[催办消息模板]
     */
    public final static String FIELD_REMINDMSGTEMPLNAME = "REMINDMSGTEMPLNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[USERDATACMD]
     */
    public final static String FIELD_USERDATACMD = "USERDATACMD";
    /**
     * 属性[USERDATACMD10]
     */
    public final static String FIELD_USERDATACMD10 = "USERDATACMD10";
    /**
     * 属性[USERDATACMD2]
     */
    public final static String FIELD_USERDATACMD2 = "USERDATACMD2";
    /**
     * 属性[USERDATACMD3]
     */
    public final static String FIELD_USERDATACMD3 = "USERDATACMD3";
    /**
     * 属性[USERDATACMD4]
     */
    public final static String FIELD_USERDATACMD4 = "USERDATACMD4";
    /**
     * 属性[USERDATACMD5]
     */
    public final static String FIELD_USERDATACMD5 = "USERDATACMD5";
    /**
     * 属性[USERDATACMD6]
     */
    public final static String FIELD_USERDATACMD6 = "USERDATACMD6";
    /**
     * 属性[USERDATACMD7]
     */
    public final static String FIELD_USERDATACMD7 = "USERDATACMD7";
    /**
     * 属性[USERDATACMD8]
     */
    public final static String FIELD_USERDATACMD8 = "USERDATACMD8";
    /**
     * 属性[USERDATACMD9]
     */
    public final static String FIELD_USERDATACMD9 = "USERDATACMD9";
    /**
     * 属性[USERDATANAME]
     */
    public final static String FIELD_USERDATANAME = "USERDATANAME";
    /**
     * 属性[流程辅助对象]
     */
    public final static String FIELD_WFHELPER = "WFHELPER";
    /**
     * 属性[辅助对象参数]
     */
    public final static String FIELD_WFHELPERPARAM = "WFHELPERPARAM";
    /**
     * 属性[流程语言资源]
     */
    public final static String FIELD_WFLANRESTAG = "WFLANRESTAG";
    /**
     * 属性[逻辑名称]
     */
    public final static String FIELD_WFLOGICNAME = "WFLOGICNAME";
    /**
     * 属性[配置]
     */
    public final static String FIELD_WFMODEL = "WFMODEL";
    /**
     * 属性[工作流状态]
     */
    public final static String FIELD_WFSTATE = "WFSTATE";
    /**
     * 属性[流程类型]
     */
    public final static String FIELD_WFTYPE = "WFTYPE";
    /**
     * 属性[版本]
     */
    public final static String FIELD_WFVERSION = "WFVERSION";
    /**
     * 属性[工作流配置标识]
     */
    public final static String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    /**
     * 属性[工作流配置名称]
     */
    public final static String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ENABLE = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_REMINDMSGTEMPLID = 4;
    private final static int INDEX_REMINDMSGTEMPLNAME = 5;
    private final static int INDEX_UPDATEDATE = 6;
    private final static int INDEX_UPDATEMAN = 7;
    private final static int INDEX_USERDATACMD = 8;
    private final static int INDEX_USERDATACMD10 = 9;
    private final static int INDEX_USERDATACMD2 = 10;
    private final static int INDEX_USERDATACMD3 = 11;
    private final static int INDEX_USERDATACMD4 = 12;
    private final static int INDEX_USERDATACMD5 = 13;
    private final static int INDEX_USERDATACMD6 = 14;
    private final static int INDEX_USERDATACMD7 = 15;
    private final static int INDEX_USERDATACMD8 = 16;
    private final static int INDEX_USERDATACMD9 = 17;
    private final static int INDEX_USERDATANAME = 18;
    private final static int INDEX_WFHELPER = 19;
    private final static int INDEX_WFHELPERPARAM = 20;
    private final static int INDEX_WFLANRESTAG = 21;
    private final static int INDEX_WFLOGICNAME = 22;
    private final static int INDEX_WFMODEL = 23;
    private final static int INDEX_WFSTATE = 24;
    private final static int INDEX_WFTYPE = 25;
    private final static int INDEX_WFVERSION = 26;
    private final static int INDEX_WFWORKFLOWID = 27;
    private final static int INDEX_WFWORKFLOWNAME = 28;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_REMINDMSGTEMPLID, INDEX_REMINDMSGTEMPLID);
        fieldIndexMap.put( FIELD_REMINDMSGTEMPLNAME, INDEX_REMINDMSGTEMPLNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATACMD, INDEX_USERDATACMD);
        fieldIndexMap.put( FIELD_USERDATACMD10, INDEX_USERDATACMD10);
        fieldIndexMap.put( FIELD_USERDATACMD2, INDEX_USERDATACMD2);
        fieldIndexMap.put( FIELD_USERDATACMD3, INDEX_USERDATACMD3);
        fieldIndexMap.put( FIELD_USERDATACMD4, INDEX_USERDATACMD4);
        fieldIndexMap.put( FIELD_USERDATACMD5, INDEX_USERDATACMD5);
        fieldIndexMap.put( FIELD_USERDATACMD6, INDEX_USERDATACMD6);
        fieldIndexMap.put( FIELD_USERDATACMD7, INDEX_USERDATACMD7);
        fieldIndexMap.put( FIELD_USERDATACMD8, INDEX_USERDATACMD8);
        fieldIndexMap.put( FIELD_USERDATACMD9, INDEX_USERDATACMD9);
        fieldIndexMap.put( FIELD_USERDATANAME, INDEX_USERDATANAME);
        fieldIndexMap.put( FIELD_WFHELPER, INDEX_WFHELPER);
        fieldIndexMap.put( FIELD_WFHELPERPARAM, INDEX_WFHELPERPARAM);
        fieldIndexMap.put( FIELD_WFLANRESTAG, INDEX_WFLANRESTAG);
        fieldIndexMap.put( FIELD_WFLOGICNAME, INDEX_WFLOGICNAME);
        fieldIndexMap.put( FIELD_WFMODEL, INDEX_WFMODEL);
        fieldIndexMap.put( FIELD_WFSTATE, INDEX_WFSTATE);
        fieldIndexMap.put( FIELD_WFTYPE, INDEX_WFTYPE);
        fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
        fieldIndexMap.put( FIELD_WFWORKFLOWID, INDEX_WFWORKFLOWID);
        fieldIndexMap.put( FIELD_WFWORKFLOWNAME, INDEX_WFWORKFLOWNAME);
    }

    private WFWorkflowBase proxyWFWorkflowBase = null;
    public WFWorkflowBase() {
        super();
    }
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


    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[逻辑有效标志]
     *  @param enable
     */
    public void setEnable(Integer enable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑有效标志]
     */
    public Integer getEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    /**
     *  获取属性值[逻辑有效标志]是否修改
     */
    public boolean isEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    /**
     *  重置属性值[逻辑有效标志]
     */
    public void resetEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnable();
            return;
        }

        this.enableDirtyFlag = false;
        this.enable = null;
    }
    /**
     *  设置属性值[工作流说明]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流说明]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[工作流说明]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[工作流说明]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[催办消息模板]
     *  @param remindmsgtemplid
     */
    public void setRemindMsgTemplId(String remindmsgtemplid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRemindMsgTemplId(remindmsgtemplid);
            return;
        }
        if(remindmsgtemplid!=null) {
            remindmsgtemplid = StringHelper.trimRight(remindmsgtemplid);
            if(remindmsgtemplid.length()==0) {
                remindmsgtemplid = null;
            }
        }
        this.remindmsgtemplid = remindmsgtemplid;
        this.remindmsgtemplidDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办消息模板]
     */
    public String getRemindMsgTemplId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTemplId();
        }
        return this.remindmsgtemplid;
    }

    /**
     *  获取属性值[催办消息模板]是否修改
     */
    public boolean isRemindMsgTemplIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRemindMsgTemplIdDirty();
        }
        return this.remindmsgtemplidDirtyFlag;
    }

    /**
     *  重置属性值[催办消息模板]
     */
    public void resetRemindMsgTemplId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRemindMsgTemplId();
            return;
        }

        this.remindmsgtemplidDirtyFlag = false;
        this.remindmsgtemplid = null;
    }
    /**
     *  设置属性值[催办消息模板]
     *  @param remindmsgtemplname
     */
    public void setRemindMsgTemplName(String remindmsgtemplname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRemindMsgTemplName(remindmsgtemplname);
            return;
        }
        if(remindmsgtemplname!=null) {
            remindmsgtemplname = StringHelper.trimRight(remindmsgtemplname);
            if(remindmsgtemplname.length()==0) {
                remindmsgtemplname = null;
            }
        }
        this.remindmsgtemplname = remindmsgtemplname;
        this.remindmsgtemplnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办消息模板]
     */
    public String getRemindMsgTemplName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTemplName();
        }
        return this.remindmsgtemplname;
    }

    /**
     *  获取属性值[催办消息模板]是否修改
     */
    public boolean isRemindMsgTemplNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRemindMsgTemplNameDirty();
        }
        return this.remindmsgtemplnameDirtyFlag;
    }

    /**
     *  重置属性值[催办消息模板]
     */
    public void resetRemindMsgTemplName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRemindMsgTemplName();
            return;
        }

        this.remindmsgtemplnameDirtyFlag = false;
        this.remindmsgtemplname = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[USERDATACMD]
     *  @param userdatacmd
     */
    public void setUserDataCmd(String userdatacmd) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd(userdatacmd);
            return;
        }
        if(userdatacmd!=null) {
            userdatacmd = StringHelper.trimRight(userdatacmd);
            if(userdatacmd.length()==0) {
                userdatacmd = null;
            }
        }
        this.userdatacmd = userdatacmd;
        this.userdatacmdDirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD]
     */
    public String getUserDataCmd() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd();
        }
        return this.userdatacmd;
    }

    /**
     *  获取属性值[USERDATACMD]是否修改
     */
    public boolean isUserDataCmdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmdDirty();
        }
        return this.userdatacmdDirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD]
     */
    public void resetUserDataCmd() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd();
            return;
        }

        this.userdatacmdDirtyFlag = false;
        this.userdatacmd = null;
    }
    /**
     *  设置属性值[USERDATACMD10]
     *  @param userdatacmd10
     */
    public void setUserDataCmd10(String userdatacmd10) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd10(userdatacmd10);
            return;
        }
        if(userdatacmd10!=null) {
            userdatacmd10 = StringHelper.trimRight(userdatacmd10);
            if(userdatacmd10.length()==0) {
                userdatacmd10 = null;
            }
        }
        this.userdatacmd10 = userdatacmd10;
        this.userdatacmd10DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD10]
     */
    public String getUserDataCmd10() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd10();
        }
        return this.userdatacmd10;
    }

    /**
     *  获取属性值[USERDATACMD10]是否修改
     */
    public boolean isUserDataCmd10Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd10Dirty();
        }
        return this.userdatacmd10DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD10]
     */
    public void resetUserDataCmd10() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd10();
            return;
        }

        this.userdatacmd10DirtyFlag = false;
        this.userdatacmd10 = null;
    }
    /**
     *  设置属性值[USERDATACMD2]
     *  @param userdatacmd2
     */
    public void setUserDataCmd2(String userdatacmd2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd2(userdatacmd2);
            return;
        }
        if(userdatacmd2!=null) {
            userdatacmd2 = StringHelper.trimRight(userdatacmd2);
            if(userdatacmd2.length()==0) {
                userdatacmd2 = null;
            }
        }
        this.userdatacmd2 = userdatacmd2;
        this.userdatacmd2DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD2]
     */
    public String getUserDataCmd2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd2();
        }
        return this.userdatacmd2;
    }

    /**
     *  获取属性值[USERDATACMD2]是否修改
     */
    public boolean isUserDataCmd2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd2Dirty();
        }
        return this.userdatacmd2DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD2]
     */
    public void resetUserDataCmd2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd2();
            return;
        }

        this.userdatacmd2DirtyFlag = false;
        this.userdatacmd2 = null;
    }
    /**
     *  设置属性值[USERDATACMD3]
     *  @param userdatacmd3
     */
    public void setUserDataCmd3(String userdatacmd3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd3(userdatacmd3);
            return;
        }
        if(userdatacmd3!=null) {
            userdatacmd3 = StringHelper.trimRight(userdatacmd3);
            if(userdatacmd3.length()==0) {
                userdatacmd3 = null;
            }
        }
        this.userdatacmd3 = userdatacmd3;
        this.userdatacmd3DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD3]
     */
    public String getUserDataCmd3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd3();
        }
        return this.userdatacmd3;
    }

    /**
     *  获取属性值[USERDATACMD3]是否修改
     */
    public boolean isUserDataCmd3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd3Dirty();
        }
        return this.userdatacmd3DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD3]
     */
    public void resetUserDataCmd3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd3();
            return;
        }

        this.userdatacmd3DirtyFlag = false;
        this.userdatacmd3 = null;
    }
    /**
     *  设置属性值[USERDATACMD4]
     *  @param userdatacmd4
     */
    public void setUserDataCmd4(String userdatacmd4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd4(userdatacmd4);
            return;
        }
        if(userdatacmd4!=null) {
            userdatacmd4 = StringHelper.trimRight(userdatacmd4);
            if(userdatacmd4.length()==0) {
                userdatacmd4 = null;
            }
        }
        this.userdatacmd4 = userdatacmd4;
        this.userdatacmd4DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD4]
     */
    public String getUserDataCmd4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd4();
        }
        return this.userdatacmd4;
    }

    /**
     *  获取属性值[USERDATACMD4]是否修改
     */
    public boolean isUserDataCmd4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd4Dirty();
        }
        return this.userdatacmd4DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD4]
     */
    public void resetUserDataCmd4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd4();
            return;
        }

        this.userdatacmd4DirtyFlag = false;
        this.userdatacmd4 = null;
    }
    /**
     *  设置属性值[USERDATACMD5]
     *  @param userdatacmd5
     */
    public void setUserDataCmd5(String userdatacmd5) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd5(userdatacmd5);
            return;
        }
        if(userdatacmd5!=null) {
            userdatacmd5 = StringHelper.trimRight(userdatacmd5);
            if(userdatacmd5.length()==0) {
                userdatacmd5 = null;
            }
        }
        this.userdatacmd5 = userdatacmd5;
        this.userdatacmd5DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD5]
     */
    public String getUserDataCmd5() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd5();
        }
        return this.userdatacmd5;
    }

    /**
     *  获取属性值[USERDATACMD5]是否修改
     */
    public boolean isUserDataCmd5Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd5Dirty();
        }
        return this.userdatacmd5DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD5]
     */
    public void resetUserDataCmd5() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd5();
            return;
        }

        this.userdatacmd5DirtyFlag = false;
        this.userdatacmd5 = null;
    }
    /**
     *  设置属性值[USERDATACMD6]
     *  @param userdatacmd6
     */
    public void setUserDataCmd6(String userdatacmd6) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd6(userdatacmd6);
            return;
        }
        if(userdatacmd6!=null) {
            userdatacmd6 = StringHelper.trimRight(userdatacmd6);
            if(userdatacmd6.length()==0) {
                userdatacmd6 = null;
            }
        }
        this.userdatacmd6 = userdatacmd6;
        this.userdatacmd6DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD6]
     */
    public String getUserDataCmd6() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd6();
        }
        return this.userdatacmd6;
    }

    /**
     *  获取属性值[USERDATACMD6]是否修改
     */
    public boolean isUserDataCmd6Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd6Dirty();
        }
        return this.userdatacmd6DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD6]
     */
    public void resetUserDataCmd6() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd6();
            return;
        }

        this.userdatacmd6DirtyFlag = false;
        this.userdatacmd6 = null;
    }
    /**
     *  设置属性值[USERDATACMD7]
     *  @param userdatacmd7
     */
    public void setUserDataCmd7(String userdatacmd7) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd7(userdatacmd7);
            return;
        }
        if(userdatacmd7!=null) {
            userdatacmd7 = StringHelper.trimRight(userdatacmd7);
            if(userdatacmd7.length()==0) {
                userdatacmd7 = null;
            }
        }
        this.userdatacmd7 = userdatacmd7;
        this.userdatacmd7DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD7]
     */
    public String getUserDataCmd7() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd7();
        }
        return this.userdatacmd7;
    }

    /**
     *  获取属性值[USERDATACMD7]是否修改
     */
    public boolean isUserDataCmd7Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd7Dirty();
        }
        return this.userdatacmd7DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD7]
     */
    public void resetUserDataCmd7() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd7();
            return;
        }

        this.userdatacmd7DirtyFlag = false;
        this.userdatacmd7 = null;
    }
    /**
     *  设置属性值[USERDATACMD8]
     *  @param userdatacmd8
     */
    public void setUserDataCmd8(String userdatacmd8) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd8(userdatacmd8);
            return;
        }
        if(userdatacmd8!=null) {
            userdatacmd8 = StringHelper.trimRight(userdatacmd8);
            if(userdatacmd8.length()==0) {
                userdatacmd8 = null;
            }
        }
        this.userdatacmd8 = userdatacmd8;
        this.userdatacmd8DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD8]
     */
    public String getUserDataCmd8() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd8();
        }
        return this.userdatacmd8;
    }

    /**
     *  获取属性值[USERDATACMD8]是否修改
     */
    public boolean isUserDataCmd8Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd8Dirty();
        }
        return this.userdatacmd8DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD8]
     */
    public void resetUserDataCmd8() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd8();
            return;
        }

        this.userdatacmd8DirtyFlag = false;
        this.userdatacmd8 = null;
    }
    /**
     *  设置属性值[USERDATACMD9]
     *  @param userdatacmd9
     */
    public void setUserDataCmd9(String userdatacmd9) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataCmd9(userdatacmd9);
            return;
        }
        if(userdatacmd9!=null) {
            userdatacmd9 = StringHelper.trimRight(userdatacmd9);
            if(userdatacmd9.length()==0) {
                userdatacmd9 = null;
            }
        }
        this.userdatacmd9 = userdatacmd9;
        this.userdatacmd9DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATACMD9]
     */
    public String getUserDataCmd9() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataCmd9();
        }
        return this.userdatacmd9;
    }

    /**
     *  获取属性值[USERDATACMD9]是否修改
     */
    public boolean isUserDataCmd9Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataCmd9Dirty();
        }
        return this.userdatacmd9DirtyFlag;
    }

    /**
     *  重置属性值[USERDATACMD9]
     */
    public void resetUserDataCmd9() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataCmd9();
            return;
        }

        this.userdatacmd9DirtyFlag = false;
        this.userdatacmd9 = null;
    }
    /**
     *  设置属性值[USERDATANAME]
     *  @param userdataname
     */
    public void setUserDataName(String userdataname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataName(userdataname);
            return;
        }
        if(userdataname!=null) {
            userdataname = StringHelper.trimRight(userdataname);
            if(userdataname.length()==0) {
                userdataname = null;
            }
        }
        this.userdataname = userdataname;
        this.userdatanameDirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATANAME]
     */
    public String getUserDataName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataName();
        }
        return this.userdataname;
    }

    /**
     *  获取属性值[USERDATANAME]是否修改
     */
    public boolean isUserDataNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataNameDirty();
        }
        return this.userdatanameDirtyFlag;
    }

    /**
     *  重置属性值[USERDATANAME]
     */
    public void resetUserDataName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataName();
            return;
        }

        this.userdatanameDirtyFlag = false;
        this.userdataname = null;
    }
    /**
     *  设置属性值[流程辅助对象]
     *  @param wfhelper
     */
    public void setWFHelper(String wfhelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFHelper(wfhelper);
            return;
        }
        if(wfhelper!=null) {
            wfhelper = StringHelper.trimRight(wfhelper);
            if(wfhelper.length()==0) {
                wfhelper = null;
            }
        }
        this.wfhelper = wfhelper;
        this.wfhelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程辅助对象]
     */
    public String getWFHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFHelper();
        }
        return this.wfhelper;
    }

    /**
     *  获取属性值[流程辅助对象]是否修改
     */
    public boolean isWFHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFHelperDirty();
        }
        return this.wfhelperDirtyFlag;
    }

    /**
     *  重置属性值[流程辅助对象]
     */
    public void resetWFHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFHelper();
            return;
        }

        this.wfhelperDirtyFlag = false;
        this.wfhelper = null;
    }
    /**
     *  设置属性值[辅助对象参数]
     *  @param wfhelperparam
     */
    public void setWFHelperParam(String wfhelperparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFHelperParam(wfhelperparam);
            return;
        }
        if(wfhelperparam!=null) {
            wfhelperparam = StringHelper.trimRight(wfhelperparam);
            if(wfhelperparam.length()==0) {
                wfhelperparam = null;
            }
        }
        this.wfhelperparam = wfhelperparam;
        this.wfhelperparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[辅助对象参数]
     */
    public String getWFHelperParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFHelperParam();
        }
        return this.wfhelperparam;
    }

    /**
     *  获取属性值[辅助对象参数]是否修改
     */
    public boolean isWFHelperParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFHelperParamDirty();
        }
        return this.wfhelperparamDirtyFlag;
    }

    /**
     *  重置属性值[辅助对象参数]
     */
    public void resetWFHelperParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFHelperParam();
            return;
        }

        this.wfhelperparamDirtyFlag = false;
        this.wfhelperparam = null;
    }
    /**
     *  设置属性值[流程语言资源]
     *  @param wflanrestag
     */
    public void setWFLanResTag(String wflanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFLanResTag(wflanrestag);
            return;
        }
        if(wflanrestag!=null) {
            wflanrestag = StringHelper.trimRight(wflanrestag);
            if(wflanrestag.length()==0) {
                wflanrestag = null;
            }
        }
        this.wflanrestag = wflanrestag;
        this.wflanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程语言资源]
     */
    public String getWFLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFLanResTag();
        }
        return this.wflanrestag;
    }

    /**
     *  获取属性值[流程语言资源]是否修改
     */
    public boolean isWFLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFLanResTagDirty();
        }
        return this.wflanrestagDirtyFlag;
    }

    /**
     *  重置属性值[流程语言资源]
     */
    public void resetWFLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFLanResTag();
            return;
        }

        this.wflanrestagDirtyFlag = false;
        this.wflanrestag = null;
    }
    /**
     *  设置属性值[逻辑名称]
     *  @param wflogicname
     */
    public void setWFLogicName(String wflogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFLogicName(wflogicname);
            return;
        }
        if(wflogicname!=null) {
            wflogicname = StringHelper.trimRight(wflogicname);
            if(wflogicname.length()==0) {
                wflogicname = null;
            }
        }
        this.wflogicname = wflogicname;
        this.wflogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑名称]
     */
    public String getWFLogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFLogicName();
        }
        return this.wflogicname;
    }

    /**
     *  获取属性值[逻辑名称]是否修改
     */
    public boolean isWFLogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFLogicNameDirty();
        }
        return this.wflogicnameDirtyFlag;
    }

    /**
     *  重置属性值[逻辑名称]
     */
    public void resetWFLogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFLogicName();
            return;
        }

        this.wflogicnameDirtyFlag = false;
        this.wflogicname = null;
    }
    /**
     *  设置属性值[配置]
     *  @param wfmodel
     */
    public void setWFModel(String wfmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFModel(wfmodel);
            return;
        }
        if(wfmodel!=null) {
            wfmodel = StringHelper.trimRight(wfmodel);
            if(wfmodel.length()==0) {
                wfmodel = null;
            }
        }
        this.wfmodel = wfmodel;
        this.wfmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[配置]
     */
    public String getWFModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    /**
     *  获取属性值[配置]是否修改
     */
    public boolean isWFModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    /**
     *  重置属性值[配置]
     */
    public void resetWFModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFModel();
            return;
        }

        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
    }
    /**
     *  设置属性值[工作流状态]代码表：net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel
     *  @param wfstate
     */
    public void setWFState(Integer wfstate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFState(wfstate);
            return;
        }
        this.wfstate = wfstate;
        this.wfstateDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流状态]代码表：net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel
     */
    public Integer getWFState() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFState();
        }
        return this.wfstate;
    }

    /**
     *  获取属性值[工作流状态]是否修改
     */
    public boolean isWFStateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStateDirty();
        }
        return this.wfstateDirtyFlag;
    }

    /**
     *  重置属性值[工作流状态]
     */
    public void resetWFState() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFState();
            return;
        }

        this.wfstateDirtyFlag = false;
        this.wfstate = null;
    }
    /**
     *  设置属性值[流程类型]代码表：net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel
     *  @param wftype
     */
    public void setWFType(String wftype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFType(wftype);
            return;
        }
        if(wftype!=null) {
            wftype = StringHelper.trimRight(wftype);
            if(wftype.length()==0) {
                wftype = null;
            }
        }
        this.wftype = wftype;
        this.wftypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程类型]代码表：net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel
     */
    public String getWFType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFType();
        }
        return this.wftype;
    }

    /**
     *  获取属性值[流程类型]是否修改
     */
    public boolean isWFTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFTypeDirty();
        }
        return this.wftypeDirtyFlag;
    }

    /**
     *  重置属性值[流程类型]
     */
    public void resetWFType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFType();
            return;
        }

        this.wftypeDirtyFlag = false;
        this.wftype = null;
    }
    /**
     *  设置属性值[版本]
     *  @param wfversion
     */
    public void setWFVersion(Integer wfversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getWFVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isWFVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetWFVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }

        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }
    /**
     *  设置属性值[工作流配置标识]
     *  @param wfworkflowid
     */
    public void setWFWorkflowId(String wfworkflowid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if(wfworkflowid!=null) {
            wfworkflowid = StringHelper.trimRight(wfworkflowid);
            if(wfworkflowid.length()==0) {
                wfworkflowid = null;
            }
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置标识]
     */
    public String getWFWorkflowId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    /**
     *  获取属性值[工作流配置标识]是否修改
     */
    public boolean isWFWorkflowIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置标识]
     */
    public void resetWFWorkflowId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }

        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }
    /**
     *  设置属性值[工作流配置名称]
     *  @param wfworkflowname
     */
    public void setWFWorkflowName(String wfworkflowname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if(wfworkflowname!=null) {
            wfworkflowname = StringHelper.trimRight(wfworkflowname);
            if(wfworkflowname.length()==0) {
                wfworkflowname = null;
            }
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置名称]
     */
    public String getWFWorkflowName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    /**
     *  获取属性值[工作流配置名称]是否修改
     */
    public boolean isWFWorkflowNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置名称]
     */
    public void resetWFWorkflowName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }

        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFWorkflowBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isRemindMsgTemplIdDirty()) {
            params.put(FIELD_REMINDMSGTEMPLID,getRemindMsgTemplId());
        }
        if(!bDirtyOnly || isRemindMsgTemplNameDirty()) {
            params.put(FIELD_REMINDMSGTEMPLNAME,getRemindMsgTemplName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDataCmdDirty()) {
            params.put(FIELD_USERDATACMD,getUserDataCmd());
        }
        if(!bDirtyOnly || isUserDataCmd10Dirty()) {
            params.put(FIELD_USERDATACMD10,getUserDataCmd10());
        }
        if(!bDirtyOnly || isUserDataCmd2Dirty()) {
            params.put(FIELD_USERDATACMD2,getUserDataCmd2());
        }
        if(!bDirtyOnly || isUserDataCmd3Dirty()) {
            params.put(FIELD_USERDATACMD3,getUserDataCmd3());
        }
        if(!bDirtyOnly || isUserDataCmd4Dirty()) {
            params.put(FIELD_USERDATACMD4,getUserDataCmd4());
        }
        if(!bDirtyOnly || isUserDataCmd5Dirty()) {
            params.put(FIELD_USERDATACMD5,getUserDataCmd5());
        }
        if(!bDirtyOnly || isUserDataCmd6Dirty()) {
            params.put(FIELD_USERDATACMD6,getUserDataCmd6());
        }
        if(!bDirtyOnly || isUserDataCmd7Dirty()) {
            params.put(FIELD_USERDATACMD7,getUserDataCmd7());
        }
        if(!bDirtyOnly || isUserDataCmd8Dirty()) {
            params.put(FIELD_USERDATACMD8,getUserDataCmd8());
        }
        if(!bDirtyOnly || isUserDataCmd9Dirty()) {
            params.put(FIELD_USERDATACMD9,getUserDataCmd9());
        }
        if(!bDirtyOnly || isUserDataNameDirty()) {
            params.put(FIELD_USERDATANAME,getUserDataName());
        }
        if(!bDirtyOnly || isWFHelperDirty()) {
            params.put(FIELD_WFHELPER,getWFHelper());
        }
        if(!bDirtyOnly || isWFHelperParamDirty()) {
            params.put(FIELD_WFHELPERPARAM,getWFHelperParam());
        }
        if(!bDirtyOnly || isWFLanResTagDirty()) {
            params.put(FIELD_WFLANRESTAG,getWFLanResTag());
        }
        if(!bDirtyOnly || isWFLogicNameDirty()) {
            params.put(FIELD_WFLOGICNAME,getWFLogicName());
        }
        if(!bDirtyOnly || isWFModelDirty()) {
            params.put(FIELD_WFMODEL,getWFModel());
        }
        if(!bDirtyOnly || isWFStateDirty()) {
            params.put(FIELD_WFSTATE,getWFState());
        }
        if(!bDirtyOnly || isWFTypeDirty()) {
            params.put(FIELD_WFTYPE,getWFType());
        }
        if(!bDirtyOnly || isWFVersionDirty()) {
            params.put(FIELD_WFVERSION,getWFVersion());
        }
        if(!bDirtyOnly || isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID,getWFWorkflowId());
        }
        if(!bDirtyOnly || isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME,getWFWorkflowName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  WFWorkflowBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFWorkflowBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_REMINDMSGTEMPLID:
            return et.getRemindMsgTemplId();
        case INDEX_REMINDMSGTEMPLNAME:
            return et.getRemindMsgTemplName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATACMD:
            return et.getUserDataCmd();
        case INDEX_USERDATACMD10:
            return et.getUserDataCmd10();
        case INDEX_USERDATACMD2:
            return et.getUserDataCmd2();
        case INDEX_USERDATACMD3:
            return et.getUserDataCmd3();
        case INDEX_USERDATACMD4:
            return et.getUserDataCmd4();
        case INDEX_USERDATACMD5:
            return et.getUserDataCmd5();
        case INDEX_USERDATACMD6:
            return et.getUserDataCmd6();
        case INDEX_USERDATACMD7:
            return et.getUserDataCmd7();
        case INDEX_USERDATACMD8:
            return et.getUserDataCmd8();
        case INDEX_USERDATACMD9:
            return et.getUserDataCmd9();
        case INDEX_USERDATANAME:
            return et.getUserDataName();
        case INDEX_WFHELPER:
            return et.getWFHelper();
        case INDEX_WFHELPERPARAM:
            return et.getWFHelperParam();
        case INDEX_WFLANRESTAG:
            return et.getWFLanResTag();
        case INDEX_WFLOGICNAME:
            return et.getWFLogicName();
        case INDEX_WFMODEL:
            return et.getWFModel();
        case INDEX_WFSTATE:
            return et.getWFState();
        case INDEX_WFTYPE:
            return et.getWFType();
        case INDEX_WFVERSION:
            return et.getWFVersion();
        case INDEX_WFWORKFLOWID:
            return et.getWFWorkflowId();
        case INDEX_WFWORKFLOWNAME:
            return et.getWFWorkflowName();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        WFWorkflowBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFWorkflowBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_REMINDMSGTEMPLID:
            et.setRemindMsgTemplId(DataObject.getStringValue(obj));
            return ;
        case INDEX_REMINDMSGTEMPLNAME:
            et.setRemindMsgTemplName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD:
            et.setUserDataCmd(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD10:
            et.setUserDataCmd10(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD2:
            et.setUserDataCmd2(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD3:
            et.setUserDataCmd3(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD4:
            et.setUserDataCmd4(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD5:
            et.setUserDataCmd5(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD6:
            et.setUserDataCmd6(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD7:
            et.setUserDataCmd7(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD8:
            et.setUserDataCmd8(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATACMD9:
            et.setUserDataCmd9(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATANAME:
            et.setUserDataName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFHELPER:
            et.setWFHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFHELPERPARAM:
            et.setWFHelperParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFLANRESTAG:
            et.setWFLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFLOGICNAME:
            et.setWFLogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFMODEL:
            et.setWFModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTATE:
            et.setWFState(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WFTYPE:
            et.setWFType(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSION:
            et.setWFVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WFWORKFLOWID:
            et.setWFWorkflowId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFWORKFLOWNAME:
            et.setWFWorkflowName(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  WFWorkflowBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFWorkflowBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_REMINDMSGTEMPLID:
            return et.getRemindMsgTemplId()==null;
        case INDEX_REMINDMSGTEMPLNAME:
            return et.getRemindMsgTemplName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATACMD:
            return et.getUserDataCmd()==null;
        case INDEX_USERDATACMD10:
            return et.getUserDataCmd10()==null;
        case INDEX_USERDATACMD2:
            return et.getUserDataCmd2()==null;
        case INDEX_USERDATACMD3:
            return et.getUserDataCmd3()==null;
        case INDEX_USERDATACMD4:
            return et.getUserDataCmd4()==null;
        case INDEX_USERDATACMD5:
            return et.getUserDataCmd5()==null;
        case INDEX_USERDATACMD6:
            return et.getUserDataCmd6()==null;
        case INDEX_USERDATACMD7:
            return et.getUserDataCmd7()==null;
        case INDEX_USERDATACMD8:
            return et.getUserDataCmd8()==null;
        case INDEX_USERDATACMD9:
            return et.getUserDataCmd9()==null;
        case INDEX_USERDATANAME:
            return et.getUserDataName()==null;
        case INDEX_WFHELPER:
            return et.getWFHelper()==null;
        case INDEX_WFHELPERPARAM:
            return et.getWFHelperParam()==null;
        case INDEX_WFLANRESTAG:
            return et.getWFLanResTag()==null;
        case INDEX_WFLOGICNAME:
            return et.getWFLogicName()==null;
        case INDEX_WFMODEL:
            return et.getWFModel()==null;
        case INDEX_WFSTATE:
            return et.getWFState()==null;
        case INDEX_WFTYPE:
            return et.getWFType()==null;
        case INDEX_WFVERSION:
            return et.getWFVersion()==null;
        case INDEX_WFWORKFLOWID:
            return et.getWFWorkflowId()==null;
        case INDEX_WFWORKFLOWNAME:
            return et.getWFWorkflowName()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  WFWorkflowBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFWorkflowBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_REMINDMSGTEMPLID:
            return et.isRemindMsgTemplIdDirty();
        case INDEX_REMINDMSGTEMPLNAME:
            return et.isRemindMsgTemplNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATACMD:
            return et.isUserDataCmdDirty();
        case INDEX_USERDATACMD10:
            return et.isUserDataCmd10Dirty();
        case INDEX_USERDATACMD2:
            return et.isUserDataCmd2Dirty();
        case INDEX_USERDATACMD3:
            return et.isUserDataCmd3Dirty();
        case INDEX_USERDATACMD4:
            return et.isUserDataCmd4Dirty();
        case INDEX_USERDATACMD5:
            return et.isUserDataCmd5Dirty();
        case INDEX_USERDATACMD6:
            return et.isUserDataCmd6Dirty();
        case INDEX_USERDATACMD7:
            return et.isUserDataCmd7Dirty();
        case INDEX_USERDATACMD8:
            return et.isUserDataCmd8Dirty();
        case INDEX_USERDATACMD9:
            return et.isUserDataCmd9Dirty();
        case INDEX_USERDATANAME:
            return et.isUserDataNameDirty();
        case INDEX_WFHELPER:
            return et.isWFHelperDirty();
        case INDEX_WFHELPERPARAM:
            return et.isWFHelperParamDirty();
        case INDEX_WFLANRESTAG:
            return et.isWFLanResTagDirty();
        case INDEX_WFLOGICNAME:
            return et.isWFLogicNameDirty();
        case INDEX_WFMODEL:
            return et.isWFModelDirty();
        case INDEX_WFSTATE:
            return et.isWFStateDirty();
        case INDEX_WFTYPE:
            return et.isWFTypeDirty();
        case INDEX_WFVERSION:
            return et.isWFVersionDirty();
        case INDEX_WFWORKFLOWID:
            return et.isWFWorkflowIdDirty();
        case INDEX_WFWORKFLOWNAME:
            return et.isWFWorkflowNameDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(WFWorkflowBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getRemindMsgTemplId()!=null) {
            JSONObjectHelper.put(json,"remindmsgtemplid",getJSONValue(et.getRemindMsgTemplId()),false);
        }
        if(bIncEmpty||et.getRemindMsgTemplName()!=null) {
            JSONObjectHelper.put(json,"remindmsgtemplname",getJSONValue(et.getRemindMsgTemplName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserDataCmd()!=null) {
            JSONObjectHelper.put(json,"userdatacmd",getJSONValue(et.getUserDataCmd()),false);
        }
        if(bIncEmpty||et.getUserDataCmd10()!=null) {
            JSONObjectHelper.put(json,"userdatacmd10",getJSONValue(et.getUserDataCmd10()),false);
        }
        if(bIncEmpty||et.getUserDataCmd2()!=null) {
            JSONObjectHelper.put(json,"userdatacmd2",getJSONValue(et.getUserDataCmd2()),false);
        }
        if(bIncEmpty||et.getUserDataCmd3()!=null) {
            JSONObjectHelper.put(json,"userdatacmd3",getJSONValue(et.getUserDataCmd3()),false);
        }
        if(bIncEmpty||et.getUserDataCmd4()!=null) {
            JSONObjectHelper.put(json,"userdatacmd4",getJSONValue(et.getUserDataCmd4()),false);
        }
        if(bIncEmpty||et.getUserDataCmd5()!=null) {
            JSONObjectHelper.put(json,"userdatacmd5",getJSONValue(et.getUserDataCmd5()),false);
        }
        if(bIncEmpty||et.getUserDataCmd6()!=null) {
            JSONObjectHelper.put(json,"userdatacmd6",getJSONValue(et.getUserDataCmd6()),false);
        }
        if(bIncEmpty||et.getUserDataCmd7()!=null) {
            JSONObjectHelper.put(json,"userdatacmd7",getJSONValue(et.getUserDataCmd7()),false);
        }
        if(bIncEmpty||et.getUserDataCmd8()!=null) {
            JSONObjectHelper.put(json,"userdatacmd8",getJSONValue(et.getUserDataCmd8()),false);
        }
        if(bIncEmpty||et.getUserDataCmd9()!=null) {
            JSONObjectHelper.put(json,"userdatacmd9",getJSONValue(et.getUserDataCmd9()),false);
        }
        if(bIncEmpty||et.getUserDataName()!=null) {
            JSONObjectHelper.put(json,"userdataname",getJSONValue(et.getUserDataName()),false);
        }
        if(bIncEmpty||et.getWFHelper()!=null) {
            JSONObjectHelper.put(json,"wfhelper",getJSONValue(et.getWFHelper()),false);
        }
        if(bIncEmpty||et.getWFHelperParam()!=null) {
            JSONObjectHelper.put(json,"wfhelperparam",getJSONValue(et.getWFHelperParam()),false);
        }
        if(bIncEmpty||et.getWFLanResTag()!=null) {
            JSONObjectHelper.put(json,"wflanrestag",getJSONValue(et.getWFLanResTag()),false);
        }
        if(bIncEmpty||et.getWFLogicName()!=null) {
            JSONObjectHelper.put(json,"wflogicname",getJSONValue(et.getWFLogicName()),false);
        }
        if(bIncEmpty||et.getWFModel()!=null) {
            JSONObjectHelper.put(json,"wfmodel",getJSONValue(et.getWFModel()),false);
        }
        if(bIncEmpty||et.getWFState()!=null) {
            JSONObjectHelper.put(json,"wfstate",getJSONValue(et.getWFState()),false);
        }
        if(bIncEmpty||et.getWFType()!=null) {
            JSONObjectHelper.put(json,"wftype",getJSONValue(et.getWFType()),false);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
        }
        if(bIncEmpty||et.getWFWorkflowId()!=null) {
            JSONObjectHelper.put(json,"wfworkflowid",getJSONValue(et.getWFWorkflowId()),false);
        }
        if(bIncEmpty||et.getWFWorkflowName()!=null) {
            JSONObjectHelper.put(json,"wfworkflowname",getJSONValue(et.getWFWorkflowName()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(WFWorkflowBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRemindMsgTemplId()!=null) {
            Object obj = et.getRemindMsgTemplId();
            node.setAttribute("REMINDMSGTEMPLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRemindMsgTemplName()!=null) {
            Object obj = et.getRemindMsgTemplName();
            node.setAttribute("REMINDMSGTEMPLNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd()!=null) {
            Object obj = et.getUserDataCmd();
            node.setAttribute("USERDATACMD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd10()!=null) {
            Object obj = et.getUserDataCmd10();
            node.setAttribute("USERDATACMD10",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd2()!=null) {
            Object obj = et.getUserDataCmd2();
            node.setAttribute("USERDATACMD2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd3()!=null) {
            Object obj = et.getUserDataCmd3();
            node.setAttribute("USERDATACMD3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd4()!=null) {
            Object obj = et.getUserDataCmd4();
            node.setAttribute("USERDATACMD4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd5()!=null) {
            Object obj = et.getUserDataCmd5();
            node.setAttribute("USERDATACMD5",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd6()!=null) {
            Object obj = et.getUserDataCmd6();
            node.setAttribute("USERDATACMD6",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd7()!=null) {
            Object obj = et.getUserDataCmd7();
            node.setAttribute("USERDATACMD7",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd8()!=null) {
            Object obj = et.getUserDataCmd8();
            node.setAttribute("USERDATACMD8",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataCmd9()!=null) {
            Object obj = et.getUserDataCmd9();
            node.setAttribute("USERDATACMD9",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataName()!=null) {
            Object obj = et.getUserDataName();
            node.setAttribute("USERDATANAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFHelper()!=null) {
            Object obj = et.getWFHelper();
            node.setAttribute("WFHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFHelperParam()!=null) {
            Object obj = et.getWFHelperParam();
            node.setAttribute("WFHELPERPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFLanResTag()!=null) {
            Object obj = et.getWFLanResTag();
            node.setAttribute("WFLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFLogicName()!=null) {
            Object obj = et.getWFLogicName();
            node.setAttribute("WFLOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFModel()!=null) {
            Object obj = et.getWFModel();
            node.setAttribute("WFMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFState()!=null) {
            Object obj = et.getWFState();
            node.setAttribute("WFSTATE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWFType()!=null) {
            Object obj = et.getWFType();
            node.setAttribute("WFTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            Object obj = et.getWFVersion();
            node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWFWorkflowId()!=null) {
            Object obj = et.getWFWorkflowId();
            node.setAttribute("WFWORKFLOWID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFWorkflowName()!=null) {
            Object obj = et.getWFWorkflowName();
            node.setAttribute("WFWORKFLOWNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFWorkflowBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFWorkflowBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isRemindMsgTemplIdDirty() && (bIncEmpty||et.getRemindMsgTemplId()!=null)) {
            dst.set(FIELD_REMINDMSGTEMPLID,et.getRemindMsgTemplId());
        }
        if(et.isRemindMsgTemplNameDirty() && (bIncEmpty||et.getRemindMsgTemplName()!=null)) {
            dst.set(FIELD_REMINDMSGTEMPLNAME,et.getRemindMsgTemplName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDataCmdDirty() && (bIncEmpty||et.getUserDataCmd()!=null)) {
            dst.set(FIELD_USERDATACMD,et.getUserDataCmd());
        }
        if(et.isUserDataCmd10Dirty() && (bIncEmpty||et.getUserDataCmd10()!=null)) {
            dst.set(FIELD_USERDATACMD10,et.getUserDataCmd10());
        }
        if(et.isUserDataCmd2Dirty() && (bIncEmpty||et.getUserDataCmd2()!=null)) {
            dst.set(FIELD_USERDATACMD2,et.getUserDataCmd2());
        }
        if(et.isUserDataCmd3Dirty() && (bIncEmpty||et.getUserDataCmd3()!=null)) {
            dst.set(FIELD_USERDATACMD3,et.getUserDataCmd3());
        }
        if(et.isUserDataCmd4Dirty() && (bIncEmpty||et.getUserDataCmd4()!=null)) {
            dst.set(FIELD_USERDATACMD4,et.getUserDataCmd4());
        }
        if(et.isUserDataCmd5Dirty() && (bIncEmpty||et.getUserDataCmd5()!=null)) {
            dst.set(FIELD_USERDATACMD5,et.getUserDataCmd5());
        }
        if(et.isUserDataCmd6Dirty() && (bIncEmpty||et.getUserDataCmd6()!=null)) {
            dst.set(FIELD_USERDATACMD6,et.getUserDataCmd6());
        }
        if(et.isUserDataCmd7Dirty() && (bIncEmpty||et.getUserDataCmd7()!=null)) {
            dst.set(FIELD_USERDATACMD7,et.getUserDataCmd7());
        }
        if(et.isUserDataCmd8Dirty() && (bIncEmpty||et.getUserDataCmd8()!=null)) {
            dst.set(FIELD_USERDATACMD8,et.getUserDataCmd8());
        }
        if(et.isUserDataCmd9Dirty() && (bIncEmpty||et.getUserDataCmd9()!=null)) {
            dst.set(FIELD_USERDATACMD9,et.getUserDataCmd9());
        }
        if(et.isUserDataNameDirty() && (bIncEmpty||et.getUserDataName()!=null)) {
            dst.set(FIELD_USERDATANAME,et.getUserDataName());
        }
        if(et.isWFHelperDirty() && (bIncEmpty||et.getWFHelper()!=null)) {
            dst.set(FIELD_WFHELPER,et.getWFHelper());
        }
        if(et.isWFHelperParamDirty() && (bIncEmpty||et.getWFHelperParam()!=null)) {
            dst.set(FIELD_WFHELPERPARAM,et.getWFHelperParam());
        }
        if(et.isWFLanResTagDirty() && (bIncEmpty||et.getWFLanResTag()!=null)) {
            dst.set(FIELD_WFLANRESTAG,et.getWFLanResTag());
        }
        if(et.isWFLogicNameDirty() && (bIncEmpty||et.getWFLogicName()!=null)) {
            dst.set(FIELD_WFLOGICNAME,et.getWFLogicName());
        }
        if(et.isWFModelDirty() && (bIncEmpty||et.getWFModel()!=null)) {
            dst.set(FIELD_WFMODEL,et.getWFModel());
        }
        if(et.isWFStateDirty() && (bIncEmpty||et.getWFState()!=null)) {
            dst.set(FIELD_WFSTATE,et.getWFState());
        }
        if(et.isWFTypeDirty() && (bIncEmpty||et.getWFType()!=null)) {
            dst.set(FIELD_WFTYPE,et.getWFType());
        }
        if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null)) {
            dst.set(FIELD_WFVERSION,et.getWFVersion());
        }
        if(et.isWFWorkflowIdDirty() && (bIncEmpty||et.getWFWorkflowId()!=null)) {
            dst.set(FIELD_WFWORKFLOWID,et.getWFWorkflowId());
        }
        if(et.isWFWorkflowNameDirty() && (bIncEmpty||et.getWFWorkflowName()!=null)) {
            dst.set(FIELD_WFWORKFLOWNAME,et.getWFWorkflowName());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  WFWorkflowBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFWorkflowBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_REMINDMSGTEMPLID:
            et.resetRemindMsgTemplId();
            return true;
        case INDEX_REMINDMSGTEMPLNAME:
            et.resetRemindMsgTemplName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDATACMD:
            et.resetUserDataCmd();
            return true;
        case INDEX_USERDATACMD10:
            et.resetUserDataCmd10();
            return true;
        case INDEX_USERDATACMD2:
            et.resetUserDataCmd2();
            return true;
        case INDEX_USERDATACMD3:
            et.resetUserDataCmd3();
            return true;
        case INDEX_USERDATACMD4:
            et.resetUserDataCmd4();
            return true;
        case INDEX_USERDATACMD5:
            et.resetUserDataCmd5();
            return true;
        case INDEX_USERDATACMD6:
            et.resetUserDataCmd6();
            return true;
        case INDEX_USERDATACMD7:
            et.resetUserDataCmd7();
            return true;
        case INDEX_USERDATACMD8:
            et.resetUserDataCmd8();
            return true;
        case INDEX_USERDATACMD9:
            et.resetUserDataCmd9();
            return true;
        case INDEX_USERDATANAME:
            et.resetUserDataName();
            return true;
        case INDEX_WFHELPER:
            et.resetWFHelper();
            return true;
        case INDEX_WFHELPERPARAM:
            et.resetWFHelperParam();
            return true;
        case INDEX_WFLANRESTAG:
            et.resetWFLanResTag();
            return true;
        case INDEX_WFLOGICNAME:
            et.resetWFLogicName();
            return true;
        case INDEX_WFMODEL:
            et.resetWFModel();
            return true;
        case INDEX_WFSTATE:
            et.resetWFState();
            return true;
        case INDEX_WFTYPE:
            et.resetWFType();
            return true;
        case INDEX_WFVERSION:
            et.resetWFVersion();
            return true;
        case INDEX_WFWORKFLOWID:
            et.resetWFWorkflowId();
            return true;
        case INDEX_WFWORKFLOWNAME:
            et.resetWFWorkflowName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objRemindMsgTemplLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.MsgTemplate remindmsgtempl = null;
    /**
    * 获取父数据 消息模板
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.MsgTemplate getRemindMsgTempl() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTempl();
        }

        if(this.getRemindMsgTemplId()==null)
            return null;
        synchronized(this.objRemindMsgTemplLock) {
            if(this.remindmsgtempl!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getRemindMsgTemplId(),remindmsgtempl.getMsgTemplateId())!=0) {
                    this.remindmsgtempl = null;
                }
            }


            if(this.remindmsgtempl==null) {
                net.ibizsys.psrt.srv.common.entity.MsgTemplate remindmsgtempl = new net.ibizsys.psrt.srv.common.entity.MsgTemplate();
                remindmsgtempl.setMsgTemplateId(this.getRemindMsgTemplId());
                net.ibizsys.psrt.srv.common.service.MsgTemplateService service = (net.ibizsys.psrt.srv.common.service.MsgTemplateService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgTemplateService.class,this.getSessionFactory());
                service.autoGet(remindmsgtempl);
                this.remindmsgtempl = remindmsgtempl;
            }
            return this.remindmsgtempl;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFWorkflowBase getProxyEntity() {
        return this.proxyWFWorkflowBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFWorkflowBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFWorkflowBase) {
            this.proxyWFWorkflowBase = (WFWorkflowBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFWorkflowService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}