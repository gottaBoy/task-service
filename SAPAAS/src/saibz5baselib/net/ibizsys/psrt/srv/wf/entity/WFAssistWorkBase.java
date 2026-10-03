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
 * 实体[WFAssistWork] 数据对象基类
 */
public abstract class WFAssistWorkBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFAssistWorkBase.class);
    /**
     * 属性[ACTIVESTEPID]
     */
    public final static String FIELD_ACTIVESTEPID = "ACTIVESTEPID";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[USERDATA]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[USERDATA4]
     */
    public final static String FIELD_USERDATA4 = "USERDATA4";
    /**
     * 属性[工作流代办工作标识]
     */
    public final static String FIELD_WFASSISTWORKID = "WFASSISTWORKID";
    /**
     * 属性[工作流代办工作名称]
     */
    public final static String FIELD_WFASSISTWORKNAME = "WFASSISTWORKNAME";
    /**
     * 属性[流程实例]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[流程实例]
     */
    public final static String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    /**
     * 属性[流程步骤名称]
     */
    public final static String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    /**
     * 属性[步骤操作者]
     */
    public final static String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    /**
     * 属性[步骤操作者]
     */
    public final static String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    /**
     * 属性[流程步骤标识]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[工作流]
     */
    public final static String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    /**
     * 属性[工作流]
     */
    public final static String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";

    private final static int INDEX_ACTIVESTEPID = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_UPDATEDATE = 3;
    private final static int INDEX_UPDATEMAN = 4;
    private final static int INDEX_USERDATA = 5;
    private final static int INDEX_USERDATA4 = 6;
    private final static int INDEX_WFASSISTWORKID = 7;
    private final static int INDEX_WFASSISTWORKNAME = 8;
    private final static int INDEX_WFINSTANCEID = 9;
    private final static int INDEX_WFINSTANCENAME = 10;
    private final static int INDEX_WFPLOGICNAME = 11;
    private final static int INDEX_WFSTEPACTORID = 12;
    private final static int INDEX_WFSTEPACTORNAME = 13;
    private final static int INDEX_WFSTEPID = 14;
    private final static int INDEX_WFWORKFLOWID = 15;
    private final static int INDEX_WFWORKFLOWNAME = 16;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTIVESTEPID, INDEX_ACTIVESTEPID);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA4, INDEX_USERDATA4);
        fieldIndexMap.put( FIELD_WFASSISTWORKID, INDEX_WFASSISTWORKID);
        fieldIndexMap.put( FIELD_WFASSISTWORKNAME, INDEX_WFASSISTWORKNAME);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFINSTANCENAME, INDEX_WFINSTANCENAME);
        fieldIndexMap.put( FIELD_WFPLOGICNAME, INDEX_WFPLOGICNAME);
        fieldIndexMap.put( FIELD_WFSTEPACTORID, INDEX_WFSTEPACTORID);
        fieldIndexMap.put( FIELD_WFSTEPACTORNAME, INDEX_WFSTEPACTORNAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFWORKFLOWID, INDEX_WFWORKFLOWID);
        fieldIndexMap.put( FIELD_WFWORKFLOWNAME, INDEX_WFWORKFLOWNAME);
    }

    private WFAssistWorkBase proxyWFAssistWorkBase = null;
    public WFAssistWorkBase() {
        super();
    }
    private boolean activestepidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean wfassistworkidDirtyFlag = false;
    private boolean wfassistworknameDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfplogicnameDirtyFlag = false;
    private boolean wfstepactoridDirtyFlag = false;
    private boolean wfstepactornameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;

    @Column(name="activestepid")
    private String activestepid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="wfassistworkid")
    private String wfassistworkid;
    @Column(name="wfassistworkname")
    private String wfassistworkname;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfplogicname")
    private String wfplogicname;
    @Column(name="wfstepactorid")
    private String wfstepactorid;
    @Column(name="wfstepactorname")
    private String wfstepactorname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;


    /**
     *  设置属性值[ACTIVESTEPID]
     *  @param activestepid
     */
    public void setActiveStepId(String activestepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActiveStepId(activestepid);
            return;
        }
        if(activestepid!=null) {
            activestepid = StringHelper.trimRight(activestepid);
            if(activestepid.length()==0) {
                activestepid = null;
            }
        }
        this.activestepid = activestepid;
        this.activestepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[ACTIVESTEPID]
     */
    public String getActiveStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActiveStepId();
        }
        return this.activestepid;
    }

    /**
     *  获取属性值[ACTIVESTEPID]是否修改
     */
    public boolean isActiveStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActiveStepIdDirty();
        }
        return this.activestepidDirtyFlag;
    }

    /**
     *  重置属性值[ACTIVESTEPID]
     */
    public void resetActiveStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActiveStepId();
            return;
        }

        this.activestepidDirtyFlag = false;
        this.activestepid = null;
    }
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
     *  设置属性值[USERDATA]
     *  @param userdata
     */
    public void setUserData(String userdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if(userdata!=null) {
            userdata = StringHelper.trimRight(userdata);
            if(userdata.length()==0) {
                userdata = null;
            }
        }
        this.userdata = userdata;
        this.userdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[USERDATA]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[USERDATA]
     */
    public void resetUserData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData();
            return;
        }

        this.userdataDirtyFlag = false;
        this.userdata = null;
    }
    /**
     *  设置属性值[USERDATA4]
     *  @param userdata4
     */
    public void setUserData4(String userdata4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if(userdata4!=null) {
            userdata4 = StringHelper.trimRight(userdata4);
            if(userdata4.length()==0) {
                userdata4 = null;
            }
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA4]
     */
    public String getUserData4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    /**
     *  获取属性值[USERDATA4]是否修改
     */
    public boolean isUserData4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    /**
     *  重置属性值[USERDATA4]
     */
    public void resetUserData4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData4();
            return;
        }

        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }
    /**
     *  设置属性值[工作流代办工作标识]
     *  @param wfassistworkid
     */
    public void setWFAssistWorkId(String wfassistworkid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFAssistWorkId(wfassistworkid);
            return;
        }
        if(wfassistworkid!=null) {
            wfassistworkid = StringHelper.trimRight(wfassistworkid);
            if(wfassistworkid.length()==0) {
                wfassistworkid = null;
            }
        }
        this.wfassistworkid = wfassistworkid;
        this.wfassistworkidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流代办工作标识]
     */
    public String getWFAssistWorkId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFAssistWorkId();
        }
        return this.wfassistworkid;
    }

    /**
     *  获取属性值[工作流代办工作标识]是否修改
     */
    public boolean isWFAssistWorkIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFAssistWorkIdDirty();
        }
        return this.wfassistworkidDirtyFlag;
    }

    /**
     *  重置属性值[工作流代办工作标识]
     */
    public void resetWFAssistWorkId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFAssistWorkId();
            return;
        }

        this.wfassistworkidDirtyFlag = false;
        this.wfassistworkid = null;
    }
    /**
     *  设置属性值[工作流代办工作名称]
     *  @param wfassistworkname
     */
    public void setWFAssistWorkName(String wfassistworkname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFAssistWorkName(wfassistworkname);
            return;
        }
        if(wfassistworkname!=null) {
            wfassistworkname = StringHelper.trimRight(wfassistworkname);
            if(wfassistworkname.length()==0) {
                wfassistworkname = null;
            }
        }
        this.wfassistworkname = wfassistworkname;
        this.wfassistworknameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流代办工作名称]
     */
    public String getWFAssistWorkName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFAssistWorkName();
        }
        return this.wfassistworkname;
    }

    /**
     *  获取属性值[工作流代办工作名称]是否修改
     */
    public boolean isWFAssistWorkNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFAssistWorkNameDirty();
        }
        return this.wfassistworknameDirtyFlag;
    }

    /**
     *  重置属性值[工作流代办工作名称]
     */
    public void resetWFAssistWorkName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFAssistWorkName();
            return;
        }

        this.wfassistworknameDirtyFlag = false;
        this.wfassistworkname = null;
    }
    /**
     *  设置属性值[流程实例]
     *  @param wfinstanceid
     */
    public void setWFInstanceId(String wfinstanceid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if(wfinstanceid!=null) {
            wfinstanceid = StringHelper.trimRight(wfinstanceid);
            if(wfinstanceid.length()==0) {
                wfinstanceid = null;
            }
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程实例]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[流程实例]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[流程实例]
     */
    public void resetWFInstanceId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }

        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }
    /**
     *  设置属性值[流程实例]
     *  @param wfinstancename
     */
    public void setWFInstanceName(String wfinstancename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if(wfinstancename!=null) {
            wfinstancename = StringHelper.trimRight(wfinstancename);
            if(wfinstancename.length()==0) {
                wfinstancename = null;
            }
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程实例]
     */
    public String getWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    /**
     *  获取属性值[流程实例]是否修改
     */
    public boolean isWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[流程实例]
     */
    public void resetWFInstanceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }

        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }
    /**
     *  设置属性值[流程步骤名称]
     *  @param wfplogicname
     */
    public void setWFPLogicName(String wfplogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFPLogicName(wfplogicname);
            return;
        }
        if(wfplogicname!=null) {
            wfplogicname = StringHelper.trimRight(wfplogicname);
            if(wfplogicname.length()==0) {
                wfplogicname = null;
            }
        }
        this.wfplogicname = wfplogicname;
        this.wfplogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程步骤名称]
     */
    public String getWFPLogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFPLogicName();
        }
        return this.wfplogicname;
    }

    /**
     *  获取属性值[流程步骤名称]是否修改
     */
    public boolean isWFPLogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFPLogicNameDirty();
        }
        return this.wfplogicnameDirtyFlag;
    }

    /**
     *  重置属性值[流程步骤名称]
     */
    public void resetWFPLogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFPLogicName();
            return;
        }

        this.wfplogicnameDirtyFlag = false;
        this.wfplogicname = null;
    }
    /**
     *  设置属性值[步骤操作者]
     *  @param wfstepactorid
     */
    public void setWFStepActorId(String wfstepactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorId(wfstepactorid);
            return;
        }
        if(wfstepactorid!=null) {
            wfstepactorid = StringHelper.trimRight(wfstepactorid);
            if(wfstepactorid.length()==0) {
                wfstepactorid = null;
            }
        }
        this.wfstepactorid = wfstepactorid;
        this.wfstepactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤操作者]
     */
    public String getWFStepActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorId();
        }
        return this.wfstepactorid;
    }

    /**
     *  获取属性值[步骤操作者]是否修改
     */
    public boolean isWFStepActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorIdDirty();
        }
        return this.wfstepactoridDirtyFlag;
    }

    /**
     *  重置属性值[步骤操作者]
     */
    public void resetWFStepActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorId();
            return;
        }

        this.wfstepactoridDirtyFlag = false;
        this.wfstepactorid = null;
    }
    /**
     *  设置属性值[步骤操作者]
     *  @param wfstepactorname
     */
    public void setWFStepActorName(String wfstepactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorName(wfstepactorname);
            return;
        }
        if(wfstepactorname!=null) {
            wfstepactorname = StringHelper.trimRight(wfstepactorname);
            if(wfstepactorname.length()==0) {
                wfstepactorname = null;
            }
        }
        this.wfstepactorname = wfstepactorname;
        this.wfstepactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤操作者]
     */
    public String getWFStepActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorName();
        }
        return this.wfstepactorname;
    }

    /**
     *  获取属性值[步骤操作者]是否修改
     */
    public boolean isWFStepActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorNameDirty();
        }
        return this.wfstepactornameDirtyFlag;
    }

    /**
     *  重置属性值[步骤操作者]
     */
    public void resetWFStepActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorName();
            return;
        }

        this.wfstepactornameDirtyFlag = false;
        this.wfstepactorname = null;
    }
    /**
     *  设置属性值[流程步骤标识]
     *  @param wfstepid
     */
    public void setWFStepId(String wfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if(wfstepid!=null) {
            wfstepid = StringHelper.trimRight(wfstepid);
            if(wfstepid.length()==0) {
                wfstepid = null;
            }
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程步骤标识]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[流程步骤标识]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[流程步骤标识]
     */
    public void resetWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }

        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }
    /**
     *  设置属性值[工作流]
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
     *  获取属性值[工作流]
     */
    public String getWFWorkflowId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    /**
     *  获取属性值[工作流]是否修改
     */
    public boolean isWFWorkflowIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    /**
     *  重置属性值[工作流]
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
     *  设置属性值[工作流]
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
     *  获取属性值[工作流]
     */
    public String getWFWorkflowName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    /**
     *  获取属性值[工作流]是否修改
     */
    public boolean isWFWorkflowNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    /**
     *  重置属性值[工作流]
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
        WFAssistWorkBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFAssistWorkBase et) {
        et.resetActiveStepId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData4();
        et.resetWFAssistWorkId();
        et.resetWFAssistWorkName();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFPLogicName();
        et.resetWFStepActorId();
        et.resetWFStepActorName();
        et.resetWFStepId();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActiveStepIdDirty()) {
            params.put(FIELD_ACTIVESTEPID,getActiveStepId());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDataDirty()) {
            params.put(FIELD_USERDATA,getUserData());
        }
        if(!bDirtyOnly || isUserData4Dirty()) {
            params.put(FIELD_USERDATA4,getUserData4());
        }
        if(!bDirtyOnly || isWFAssistWorkIdDirty()) {
            params.put(FIELD_WFASSISTWORKID,getWFAssistWorkId());
        }
        if(!bDirtyOnly || isWFAssistWorkNameDirty()) {
            params.put(FIELD_WFASSISTWORKNAME,getWFAssistWorkName());
        }
        if(!bDirtyOnly || isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID,getWFInstanceId());
        }
        if(!bDirtyOnly || isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME,getWFInstanceName());
        }
        if(!bDirtyOnly || isWFPLogicNameDirty()) {
            params.put(FIELD_WFPLOGICNAME,getWFPLogicName());
        }
        if(!bDirtyOnly || isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID,getWFStepActorId());
        }
        if(!bDirtyOnly || isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME,getWFStepActorName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
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

        return  WFAssistWorkBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFAssistWorkBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.getActiveStepId();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA4:
            return et.getUserData4();
        case INDEX_WFASSISTWORKID:
            return et.getWFAssistWorkId();
        case INDEX_WFASSISTWORKNAME:
            return et.getWFAssistWorkName();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName();
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName();
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId();
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
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

        WFAssistWorkBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFAssistWorkBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTIVESTEPID:
            et.setActiveStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA:
            et.setUserData(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA4:
            et.setUserData4(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFASSISTWORKID:
            et.setWFAssistWorkId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFASSISTWORKNAME:
            et.setWFAssistWorkName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCEID:
            et.setWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCENAME:
            et.setWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFPLOGICNAME:
            et.setWFPLogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPACTORID:
            et.setWFStepActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPACTORNAME:
            et.setWFStepActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
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

        return  WFAssistWorkBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFAssistWorkBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.getActiveStepId()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA4:
            return et.getUserData4()==null;
        case INDEX_WFASSISTWORKID:
            return et.getWFAssistWorkId()==null;
        case INDEX_WFASSISTWORKNAME:
            return et.getWFAssistWorkName()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName()==null;
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName()==null;
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId()==null;
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
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
        return  WFAssistWorkBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFAssistWorkBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.isActiveStepIdDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA4:
            return et.isUserData4Dirty();
        case INDEX_WFASSISTWORKID:
            return et.isWFAssistWorkIdDirty();
        case INDEX_WFASSISTWORKNAME:
            return et.isWFAssistWorkNameDirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFINSTANCENAME:
            return et.isWFInstanceNameDirty();
        case INDEX_WFPLOGICNAME:
            return et.isWFPLogicNameDirty();
        case INDEX_WFSTEPACTORID:
            return et.isWFStepActorIdDirty();
        case INDEX_WFSTEPACTORNAME:
            return et.isWFStepActorNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
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
    private static  void fillJSONObject(WFAssistWorkBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActiveStepId()!=null) {
            JSONObjectHelper.put(json,"activestepid",getJSONValue(et.getActiveStepId()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            JSONObjectHelper.put(json,"userdata",getJSONValue(et.getUserData()),false);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            JSONObjectHelper.put(json,"userdata4",getJSONValue(et.getUserData4()),false);
        }
        if(bIncEmpty||et.getWFAssistWorkId()!=null) {
            JSONObjectHelper.put(json,"wfassistworkid",getJSONValue(et.getWFAssistWorkId()),false);
        }
        if(bIncEmpty||et.getWFAssistWorkName()!=null) {
            JSONObjectHelper.put(json,"wfassistworkname",getJSONValue(et.getWFAssistWorkName()),false);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"wfinstanceid",getJSONValue(et.getWFInstanceId()),false);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"wfinstancename",getJSONValue(et.getWFInstanceName()),false);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            JSONObjectHelper.put(json,"wfplogicname",getJSONValue(et.getWFPLogicName()),false);
        }
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            JSONObjectHelper.put(json,"wfstepactorid",getJSONValue(et.getWFStepActorId()),false);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            JSONObjectHelper.put(json,"wfstepactorname",getJSONValue(et.getWFStepActorName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
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
    private static void fillXmlNode(WFAssistWorkBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActiveStepId()!=null) {
            Object obj = et.getActiveStepId();
            node.setAttribute("ACTIVESTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            Object obj = et.getUserData();
            node.setAttribute("USERDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            Object obj = et.getUserData4();
            node.setAttribute("USERDATA4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFAssistWorkId()!=null) {
            Object obj = et.getWFAssistWorkId();
            node.setAttribute("WFASSISTWORKID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFAssistWorkName()!=null) {
            Object obj = et.getWFAssistWorkName();
            node.setAttribute("WFASSISTWORKNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            Object obj = et.getWFInstanceId();
            node.setAttribute("WFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            Object obj = et.getWFInstanceName();
            node.setAttribute("WFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            Object obj = et.getWFPLogicName();
            node.setAttribute("WFPLOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            Object obj = et.getWFStepActorId();
            node.setAttribute("WFSTEPACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            Object obj = et.getWFStepActorName();
            node.setAttribute("WFSTEPACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
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
        WFAssistWorkBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFAssistWorkBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActiveStepIdDirty() && (bIncEmpty||et.getActiveStepId()!=null)) {
            dst.set(FIELD_ACTIVESTEPID,et.getActiveStepId());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDataDirty() && (bIncEmpty||et.getUserData()!=null)) {
            dst.set(FIELD_USERDATA,et.getUserData());
        }
        if(et.isUserData4Dirty() && (bIncEmpty||et.getUserData4()!=null)) {
            dst.set(FIELD_USERDATA4,et.getUserData4());
        }
        if(et.isWFAssistWorkIdDirty() && (bIncEmpty||et.getWFAssistWorkId()!=null)) {
            dst.set(FIELD_WFASSISTWORKID,et.getWFAssistWorkId());
        }
        if(et.isWFAssistWorkNameDirty() && (bIncEmpty||et.getWFAssistWorkName()!=null)) {
            dst.set(FIELD_WFASSISTWORKNAME,et.getWFAssistWorkName());
        }
        if(et.isWFInstanceIdDirty() && (bIncEmpty||et.getWFInstanceId()!=null)) {
            dst.set(FIELD_WFINSTANCEID,et.getWFInstanceId());
        }
        if(et.isWFInstanceNameDirty() && (bIncEmpty||et.getWFInstanceName()!=null)) {
            dst.set(FIELD_WFINSTANCENAME,et.getWFInstanceName());
        }
        if(et.isWFPLogicNameDirty() && (bIncEmpty||et.getWFPLogicName()!=null)) {
            dst.set(FIELD_WFPLOGICNAME,et.getWFPLogicName());
        }
        if(et.isWFStepActorIdDirty() && (bIncEmpty||et.getWFStepActorId()!=null)) {
            dst.set(FIELD_WFSTEPACTORID,et.getWFStepActorId());
        }
        if(et.isWFStepActorNameDirty() && (bIncEmpty||et.getWFStepActorName()!=null)) {
            dst.set(FIELD_WFSTEPACTORNAME,et.getWFStepActorName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
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
        return  WFAssistWorkBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFAssistWorkBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTIVESTEPID:
            et.resetActiveStepId();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDATA:
            et.resetUserData();
            return true;
        case INDEX_USERDATA4:
            et.resetUserData4();
            return true;
        case INDEX_WFASSISTWORKID:
            et.resetWFAssistWorkId();
            return true;
        case INDEX_WFASSISTWORKNAME:
            et.resetWFAssistWorkName();
            return true;
        case INDEX_WFINSTANCEID:
            et.resetWFInstanceId();
            return true;
        case INDEX_WFINSTANCENAME:
            et.resetWFInstanceName();
            return true;
        case INDEX_WFPLOGICNAME:
            et.resetWFPLogicName();
            return true;
        case INDEX_WFSTEPACTORID:
            et.resetWFStepActorId();
            return true;
        case INDEX_WFSTEPACTORNAME:
            et.resetWFStepActorName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
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


    private Integer objWFInstanceLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = null;
    /**
    * 获取父数据 工作流实例
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFInstance getWFInstance() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstance();
        }

        if(this.getWFInstanceId()==null)
            return null;
        synchronized(this.objWFInstanceLock) {
            if(this.wfinstance!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFInstanceId(),wfinstance.getWFInstanceId())!=0) {
                    this.wfinstance = null;
                }
            }


            if(this.wfinstance==null) {
                net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = new net.ibizsys.psrt.srv.wf.entity.WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                net.ibizsys.psrt.srv.wf.service.WFInstanceService service = (net.ibizsys.psrt.srv.wf.service.WFInstanceService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFInstanceService.class,this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }

    private Integer objWFStepActorLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStepActor wfstepactor = null;
    /**
    * 获取父数据 工作流步骤操作者
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStepActor getWFStepActor() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActor();
        }

        if(this.getWFStepActorId()==null)
            return null;
        synchronized(this.objWFStepActorLock) {
            if(this.wfstepactor!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFStepActorId(),wfstepactor.getWFStepActorId())!=0) {
                    this.wfstepactor = null;
                }
            }


            if(this.wfstepactor==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStepActor wfstepactor = new net.ibizsys.psrt.srv.wf.entity.WFStepActor();
                wfstepactor.setWFStepActorId(this.getWFStepActorId());
                net.ibizsys.psrt.srv.wf.service.WFStepActorService service = (net.ibizsys.psrt.srv.wf.service.WFStepActorService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepActorService.class,this.getSessionFactory());
                service.autoGet(wfstepactor);
                this.wfstepactor = wfstepactor;
            }
            return this.wfstepactor;
        }
    }

    private Integer objWFWorkflowLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFWorkflow wfworkflow = null;
    /**
    * 获取父数据 工作流配置
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFWorkflow getWFWorkflow() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflow();
        }

        if(this.getWFWorkflowId()==null)
            return null;
        synchronized(this.objWFWorkflowLock) {
            if(this.wfworkflow!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFWorkflowId(),wfworkflow.getWFWorkflowId())!=0) {
                    this.wfworkflow = null;
                }
            }


            if(this.wfworkflow==null) {
                net.ibizsys.psrt.srv.wf.entity.WFWorkflow wfworkflow = new net.ibizsys.psrt.srv.wf.entity.WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWorkflowId());
                net.ibizsys.psrt.srv.wf.service.WFWorkflowService service = (net.ibizsys.psrt.srv.wf.service.WFWorkflowService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFWorkflowService.class,this.getSessionFactory());
                service.autoGet(wfworkflow);
                this.wfworkflow = wfworkflow;
            }
            return this.wfworkflow;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFAssistWorkBase getProxyEntity() {
        return this.proxyWFAssistWorkBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFAssistWorkBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFAssistWorkBase) {
            this.proxyWFAssistWorkBase = (WFAssistWorkBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFAssistWorkService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}