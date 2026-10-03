/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


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
 * 实体[TSSDTask] 数据对象基类
 */
public abstract class TSSDTaskBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[启用标志]
     */
    public final static String FIELD_ENABLEFLAG = "ENABLEFLAG";
    /**
     * 属性[任务参数]
     */
    public final static String FIELD_TASKPARAM = "TASKPARAM";
    /**
     * 属性[任务调度引擎]
     */
    public final static String FIELD_TSSDENGINEID = "TSSDENGINEID";
    /**
     * 属性[任务调度引擎]
     */
    public final static String FIELD_TSSDENGINENAME = "TSSDENGINENAME";
    /**
     * 属性[任务调度任务项标识]
     */
    public final static String FIELD_TSSDTASKID = "TSSDTASKID";
    /**
     * 属性[调度任务项名称]
     */
    public final static String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户数据]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[用户数据2]
     */
    public final static String FIELD_USERDATA2 = "USERDATA2";
    /**
     * 属性[用户数据3]
     */
    public final static String FIELD_USERDATA3 = "USERDATA3";
    /**
     * 属性[用户数据4]
     */
    public final static String FIELD_USERDATA4 = "USERDATA4";
    /**
     * 属性[版本]
     */
    public final static String FIELD_VERSION = "VERSION";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ENABLEFLAG = 2;
    private final static int INDEX_TASKPARAM = 3;
    private final static int INDEX_TSSDENGINEID = 4;
    private final static int INDEX_TSSDENGINENAME = 5;
    private final static int INDEX_TSSDTASKID = 6;
    private final static int INDEX_TSSDTASKNAME = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;
    private final static int INDEX_USERDATA = 10;
    private final static int INDEX_USERDATA2 = 11;
    private final static int INDEX_USERDATA3 = 12;
    private final static int INDEX_USERDATA4 = 13;
    private final static int INDEX_VERSION = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLEFLAG, INDEX_ENABLEFLAG);
        fieldIndexMap.put( FIELD_TASKPARAM, INDEX_TASKPARAM);
        fieldIndexMap.put( FIELD_TSSDENGINEID, INDEX_TSSDENGINEID);
        fieldIndexMap.put( FIELD_TSSDENGINENAME, INDEX_TSSDENGINENAME);
        fieldIndexMap.put( FIELD_TSSDTASKID, INDEX_TSSDTASKID);
        fieldIndexMap.put( FIELD_TSSDTASKNAME, INDEX_TSSDTASKNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USERDATA3, INDEX_USERDATA3);
        fieldIndexMap.put( FIELD_USERDATA4, INDEX_USERDATA4);
        fieldIndexMap.put( FIELD_VERSION, INDEX_VERSION);
    }

    private TSSDTaskBase proxyTSSDTaskBase = null;
    public TSSDTaskBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableflagDirtyFlag = false;
    private boolean taskparamDirtyFlag = false;
    private boolean tssdengineidDirtyFlag = false;
    private boolean tssdenginenameDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean versionDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableflag")
    private Integer enableflag;
    @Column(name="taskparam")
    private String taskparam;
    @Column(name="tssdengineid")
    private String tssdengineid;
    @Column(name="tssdenginename")
    private String tssdenginename;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
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
    @Column(name="version")
    private Integer version;


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
     *  设置属性值[启用标志]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param enableflag
     */
    public void setEnableFlag(Integer enableflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnableFlag(enableflag);
            return;
        }
        this.enableflag = enableflag;
        this.enableflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用标志]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getEnableFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnableFlag();
        }
        return this.enableflag;
    }

    /**
     *  获取属性值[启用标志]是否修改
     */
    public boolean isEnableFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableFlagDirty();
        }
        return this.enableflagDirtyFlag;
    }

    /**
     *  重置属性值[启用标志]
     */
    public void resetEnableFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnableFlag();
            return;
        }

        this.enableflagDirtyFlag = false;
        this.enableflag = null;
    }
    /**
     *  设置属性值[任务参数]
     *  @param taskparam
     */
    public void setTaskParam(String taskparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTaskParam(taskparam);
            return;
        }
        if(taskparam!=null) {
            taskparam = StringHelper.trimRight(taskparam);
            if(taskparam.length()==0) {
                taskparam = null;
            }
        }
        this.taskparam = taskparam;
        this.taskparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务参数]
     */
    public String getTaskParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTaskParam();
        }
        return this.taskparam;
    }

    /**
     *  获取属性值[任务参数]是否修改
     */
    public boolean isTaskParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTaskParamDirty();
        }
        return this.taskparamDirtyFlag;
    }

    /**
     *  重置属性值[任务参数]
     */
    public void resetTaskParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTaskParam();
            return;
        }

        this.taskparamDirtyFlag = false;
        this.taskparam = null;
    }
    /**
     *  设置属性值[任务调度引擎]
     *  @param tssdengineid
     */
    public void setTSSDEngineId(String tssdengineid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDEngineId(tssdengineid);
            return;
        }
        if(tssdengineid!=null) {
            tssdengineid = StringHelper.trimRight(tssdengineid);
            if(tssdengineid.length()==0) {
                tssdengineid = null;
            }
        }
        this.tssdengineid = tssdengineid;
        this.tssdengineidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度引擎]
     */
    public String getTSSDEngineId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDEngineId();
        }
        return this.tssdengineid;
    }

    /**
     *  获取属性值[任务调度引擎]是否修改
     */
    public boolean isTSSDEngineIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDEngineIdDirty();
        }
        return this.tssdengineidDirtyFlag;
    }

    /**
     *  重置属性值[任务调度引擎]
     */
    public void resetTSSDEngineId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDEngineId();
            return;
        }

        this.tssdengineidDirtyFlag = false;
        this.tssdengineid = null;
    }
    /**
     *  设置属性值[任务调度引擎]
     *  @param tssdenginename
     */
    public void setTSSDEngineName(String tssdenginename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDEngineName(tssdenginename);
            return;
        }
        if(tssdenginename!=null) {
            tssdenginename = StringHelper.trimRight(tssdenginename);
            if(tssdenginename.length()==0) {
                tssdenginename = null;
            }
        }
        this.tssdenginename = tssdenginename;
        this.tssdenginenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度引擎]
     */
    public String getTSSDEngineName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDEngineName();
        }
        return this.tssdenginename;
    }

    /**
     *  获取属性值[任务调度引擎]是否修改
     */
    public boolean isTSSDEngineNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDEngineNameDirty();
        }
        return this.tssdenginenameDirtyFlag;
    }

    /**
     *  重置属性值[任务调度引擎]
     */
    public void resetTSSDEngineName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDEngineName();
            return;
        }

        this.tssdenginenameDirtyFlag = false;
        this.tssdenginename = null;
    }
    /**
     *  设置属性值[任务调度任务项标识]
     *  @param tssdtaskid
     */
    public void setTSSDTaskId(String tssdtaskid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskId(tssdtaskid);
            return;
        }
        if(tssdtaskid!=null) {
            tssdtaskid = StringHelper.trimRight(tssdtaskid);
            if(tssdtaskid.length()==0) {
                tssdtaskid = null;
            }
        }
        this.tssdtaskid = tssdtaskid;
        this.tssdtaskidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度任务项标识]
     */
    public String getTSSDTaskId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskId();
        }
        return this.tssdtaskid;
    }

    /**
     *  获取属性值[任务调度任务项标识]是否修改
     */
    public boolean isTSSDTaskIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskIdDirty();
        }
        return this.tssdtaskidDirtyFlag;
    }

    /**
     *  重置属性值[任务调度任务项标识]
     */
    public void resetTSSDTaskId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskId();
            return;
        }

        this.tssdtaskidDirtyFlag = false;
        this.tssdtaskid = null;
    }
    /**
     *  设置属性值[调度任务项名称]
     *  @param tssdtaskname
     */
    public void setTSSDTaskName(String tssdtaskname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskName(tssdtaskname);
            return;
        }
        if(tssdtaskname!=null) {
            tssdtaskname = StringHelper.trimRight(tssdtaskname);
            if(tssdtaskname.length()==0) {
                tssdtaskname = null;
            }
        }
        this.tssdtaskname = tssdtaskname;
        this.tssdtasknameDirtyFlag  = true;
    }

    /**
     *  获取属性值[调度任务项名称]
     */
    public String getTSSDTaskName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskName();
        }
        return this.tssdtaskname;
    }

    /**
     *  获取属性值[调度任务项名称]是否修改
     */
    public boolean isTSSDTaskNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskNameDirty();
        }
        return this.tssdtasknameDirtyFlag;
    }

    /**
     *  重置属性值[调度任务项名称]
     */
    public void resetTSSDTaskName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskName();
            return;
        }

        this.tssdtasknameDirtyFlag = false;
        this.tssdtaskname = null;
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
     *  设置属性值[用户数据]
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
     *  获取属性值[用户数据]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[用户数据]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[用户数据]
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
     *  设置属性值[用户数据2]
     *  @param userdata2
     */
    public void setUserData2(String userdata2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if(userdata2!=null) {
            userdata2 = StringHelper.trimRight(userdata2);
            if(userdata2.length()==0) {
                userdata2 = null;
            }
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据2]
     */
    public String getUserData2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    /**
     *  获取属性值[用户数据2]是否修改
     */
    public boolean isUserData2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    /**
     *  重置属性值[用户数据2]
     */
    public void resetUserData2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData2();
            return;
        }

        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }
    /**
     *  设置属性值[用户数据3]
     *  @param userdata3
     */
    public void setUserData3(String userdata3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if(userdata3!=null) {
            userdata3 = StringHelper.trimRight(userdata3);
            if(userdata3.length()==0) {
                userdata3 = null;
            }
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据3]
     */
    public String getUserData3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    /**
     *  获取属性值[用户数据3]是否修改
     */
    public boolean isUserData3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    /**
     *  重置属性值[用户数据3]
     */
    public void resetUserData3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData3();
            return;
        }

        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }
    /**
     *  设置属性值[用户数据4]
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
     *  获取属性值[用户数据4]
     */
    public String getUserData4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    /**
     *  获取属性值[用户数据4]是否修改
     */
    public boolean isUserData4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    /**
     *  重置属性值[用户数据4]
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
     *  设置属性值[版本]
     *  @param version
     */
    public void setVersion(Integer version) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        this.version = version;
        this.versionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVersion();
            return;
        }

        this.versionDirtyFlag = false;
        this.version = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        TSSDTaskBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(TSSDTaskBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnableFlag();
        et.resetTaskParam();
        et.resetTSSDEngineId();
        et.resetTSSDEngineName();
        et.resetTSSDTaskId();
        et.resetTSSDTaskName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
        et.resetVersion();
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
        if(!bDirtyOnly || isEnableFlagDirty()) {
            params.put(FIELD_ENABLEFLAG,getEnableFlag());
        }
        if(!bDirtyOnly || isTaskParamDirty()) {
            params.put(FIELD_TASKPARAM,getTaskParam());
        }
        if(!bDirtyOnly || isTSSDEngineIdDirty()) {
            params.put(FIELD_TSSDENGINEID,getTSSDEngineId());
        }
        if(!bDirtyOnly || isTSSDEngineNameDirty()) {
            params.put(FIELD_TSSDENGINENAME,getTSSDEngineName());
        }
        if(!bDirtyOnly || isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID,getTSSDTaskId());
        }
        if(!bDirtyOnly || isTSSDTaskNameDirty()) {
            params.put(FIELD_TSSDTASKNAME,getTSSDTaskName());
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
        if(!bDirtyOnly || isUserData2Dirty()) {
            params.put(FIELD_USERDATA2,getUserData2());
        }
        if(!bDirtyOnly || isUserData3Dirty()) {
            params.put(FIELD_USERDATA3,getUserData3());
        }
        if(!bDirtyOnly || isUserData4Dirty()) {
            params.put(FIELD_USERDATA4,getUserData4());
        }
        if(!bDirtyOnly || isVersionDirty()) {
            params.put(FIELD_VERSION,getVersion());
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

        return  TSSDTaskBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDTaskBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLEFLAG:
            return et.getEnableFlag();
        case INDEX_TASKPARAM:
            return et.getTaskParam();
        case INDEX_TSSDENGINEID:
            return et.getTSSDEngineId();
        case INDEX_TSSDENGINENAME:
            return et.getTSSDEngineName();
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId();
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_USERDATA3:
            return et.getUserData3();
        case INDEX_USERDATA4:
            return et.getUserData4();
        case INDEX_VERSION:
            return et.getVersion();
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

        TSSDTaskBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDTaskBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLEFLAG:
            et.setEnableFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_TASKPARAM:
            et.setTaskParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDENGINEID:
            et.setTSSDEngineId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDENGINENAME:
            et.setTSSDEngineName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKID:
            et.setTSSDTaskId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKNAME:
            et.setTSSDTaskName(DataObject.getStringValue(obj));
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
        case INDEX_USERDATA2:
            et.setUserData2(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA3:
            et.setUserData3(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA4:
            et.setUserData4(DataObject.getStringValue(obj));
            return ;
        case INDEX_VERSION:
            et.setVersion(DataObject.getIntegerValue(obj));
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

        return  TSSDTaskBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDTaskBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLEFLAG:
            return et.getEnableFlag()==null;
        case INDEX_TASKPARAM:
            return et.getTaskParam()==null;
        case INDEX_TSSDENGINEID:
            return et.getTSSDEngineId()==null;
        case INDEX_TSSDENGINENAME:
            return et.getTSSDEngineName()==null;
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId()==null;
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_USERDATA3:
            return et.getUserData3()==null;
        case INDEX_USERDATA4:
            return et.getUserData4()==null;
        case INDEX_VERSION:
            return et.getVersion()==null;
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
        return  TSSDTaskBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDTaskBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLEFLAG:
            return et.isEnableFlagDirty();
        case INDEX_TASKPARAM:
            return et.isTaskParamDirty();
        case INDEX_TSSDENGINEID:
            return et.isTSSDEngineIdDirty();
        case INDEX_TSSDENGINENAME:
            return et.isTSSDEngineNameDirty();
        case INDEX_TSSDTASKID:
            return et.isTSSDTaskIdDirty();
        case INDEX_TSSDTASKNAME:
            return et.isTSSDTaskNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_USERDATA3:
            return et.isUserData3Dirty();
        case INDEX_USERDATA4:
            return et.isUserData4Dirty();
        case INDEX_VERSION:
            return et.isVersionDirty();
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
    private static  void fillJSONObject(TSSDTaskBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnableFlag()!=null) {
            JSONObjectHelper.put(json,"enableflag",getJSONValue(et.getEnableFlag()),false);
        }
        if(bIncEmpty||et.getTaskParam()!=null) {
            JSONObjectHelper.put(json,"taskparam",getJSONValue(et.getTaskParam()),false);
        }
        if(bIncEmpty||et.getTSSDEngineId()!=null) {
            JSONObjectHelper.put(json,"tssdengineid",getJSONValue(et.getTSSDEngineId()),false);
        }
        if(bIncEmpty||et.getTSSDEngineName()!=null) {
            JSONObjectHelper.put(json,"tssdenginename",getJSONValue(et.getTSSDEngineName()),false);
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            JSONObjectHelper.put(json,"tssdtaskid",getJSONValue(et.getTSSDTaskId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            JSONObjectHelper.put(json,"tssdtaskname",getJSONValue(et.getTSSDTaskName()),false);
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
        if(bIncEmpty||et.getUserData2()!=null) {
            JSONObjectHelper.put(json,"userdata2",getJSONValue(et.getUserData2()),false);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            JSONObjectHelper.put(json,"userdata3",getJSONValue(et.getUserData3()),false);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            JSONObjectHelper.put(json,"userdata4",getJSONValue(et.getUserData4()),false);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            JSONObjectHelper.put(json,"version",getJSONValue(et.getVersion()),false);
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
    private static void fillXmlNode(TSSDTaskBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnableFlag()!=null) {
            Object obj = et.getEnableFlag();
            node.setAttribute("ENABLEFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getTaskParam()!=null) {
            Object obj = et.getTaskParam();
            node.setAttribute("TASKPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDEngineId()!=null) {
            Object obj = et.getTSSDEngineId();
            node.setAttribute("TSSDENGINEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDEngineName()!=null) {
            Object obj = et.getTSSDEngineName();
            node.setAttribute("TSSDENGINENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            Object obj = et.getTSSDTaskId();
            node.setAttribute("TSSDTASKID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            Object obj = et.getTSSDTaskName();
            node.setAttribute("TSSDTASKNAME",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getUserData2()!=null) {
            Object obj = et.getUserData2();
            node.setAttribute("USERDATA2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            Object obj = et.getUserData3();
            node.setAttribute("USERDATA3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            Object obj = et.getUserData4();
            node.setAttribute("USERDATA4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            Object obj = et.getVersion();
            node.setAttribute("VERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDTaskBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDTaskBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableFlagDirty() && (bIncEmpty||et.getEnableFlag()!=null)) {
            dst.set(FIELD_ENABLEFLAG,et.getEnableFlag());
        }
        if(et.isTaskParamDirty() && (bIncEmpty||et.getTaskParam()!=null)) {
            dst.set(FIELD_TASKPARAM,et.getTaskParam());
        }
        if(et.isTSSDEngineIdDirty() && (bIncEmpty||et.getTSSDEngineId()!=null)) {
            dst.set(FIELD_TSSDENGINEID,et.getTSSDEngineId());
        }
        if(et.isTSSDEngineNameDirty() && (bIncEmpty||et.getTSSDEngineName()!=null)) {
            dst.set(FIELD_TSSDENGINENAME,et.getTSSDEngineName());
        }
        if(et.isTSSDTaskIdDirty() && (bIncEmpty||et.getTSSDTaskId()!=null)) {
            dst.set(FIELD_TSSDTASKID,et.getTSSDTaskId());
        }
        if(et.isTSSDTaskNameDirty() && (bIncEmpty||et.getTSSDTaskName()!=null)) {
            dst.set(FIELD_TSSDTASKNAME,et.getTSSDTaskName());
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
        if(et.isUserData2Dirty() && (bIncEmpty||et.getUserData2()!=null)) {
            dst.set(FIELD_USERDATA2,et.getUserData2());
        }
        if(et.isUserData3Dirty() && (bIncEmpty||et.getUserData3()!=null)) {
            dst.set(FIELD_USERDATA3,et.getUserData3());
        }
        if(et.isUserData4Dirty() && (bIncEmpty||et.getUserData4()!=null)) {
            dst.set(FIELD_USERDATA4,et.getUserData4());
        }
        if(et.isVersionDirty() && (bIncEmpty||et.getVersion()!=null)) {
            dst.set(FIELD_VERSION,et.getVersion());
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
        return  TSSDTaskBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDTaskBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLEFLAG:
            et.resetEnableFlag();
            return true;
        case INDEX_TASKPARAM:
            et.resetTaskParam();
            return true;
        case INDEX_TSSDENGINEID:
            et.resetTSSDEngineId();
            return true;
        case INDEX_TSSDENGINENAME:
            et.resetTSSDEngineName();
            return true;
        case INDEX_TSSDTASKID:
            et.resetTSSDTaskId();
            return true;
        case INDEX_TSSDTASKNAME:
            et.resetTSSDTaskName();
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
        case INDEX_USERDATA2:
            et.resetUserData2();
            return true;
        case INDEX_USERDATA3:
            et.resetUserData3();
            return true;
        case INDEX_USERDATA4:
            et.resetUserData4();
            return true;
        case INDEX_VERSION:
            et.resetVersion();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objTSSDEngineLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.TSSDEngine tssdengine = null;
    /**
    * 获取父数据 任务调度引擎
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.TSSDEngine getTSSDEngine() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDEngine();
        }

        if(this.getTSSDEngineId()==null)
            return null;
        synchronized(this.objTSSDEngineLock) {
            if(this.tssdengine!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getTSSDEngineId(),tssdengine.getTSSDEngineId())!=0) {
                    this.tssdengine = null;
                }
            }


            if(this.tssdengine==null) {
                net.ibizsys.psrt.srv.common.entity.TSSDEngine tssdengine = new net.ibizsys.psrt.srv.common.entity.TSSDEngine();
                tssdengine.setTSSDEngineId(this.getTSSDEngineId());
                net.ibizsys.psrt.srv.common.service.TSSDEngineService service = (net.ibizsys.psrt.srv.common.service.TSSDEngineService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.TSSDEngineService.class,this.getSessionFactory());
                service.autoGet(tssdengine);
                this.tssdengine = tssdengine;
            }
            return this.tssdengine;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private TSSDTaskBase getProxyEntity() {
        return this.proxyTSSDTaskBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDTaskBase) {
            this.proxyTSSDTaskBase = (TSSDTaskBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}