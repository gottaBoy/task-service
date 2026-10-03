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
 * 实体[WFUCPolicy] 数据对象基类
 */
public abstract class WFUCPolicyBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUCPolicyBase.class);
    /**
     * 属性[开始时间]
     */
    public final static String FIELD_BEGINTIME = "BEGINTIME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[结束时间]
     */
    public final static String FIELD_ENDTIME = "ENDTIME";
    /**
     * 属性[工作流用户]
     */
    public final static String FIELD_MAJORWFUSERID = "MAJORWFUSERID";
    /**
     * 属性[工作流用户]
     */
    public final static String FIELD_MAJORWFUSERNAME = "MAJORWFUSERNAME";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[候选用户]
     */
    public final static String FIELD_MINORWFUSERID = "MINORWFUSERID";
    /**
     * 属性[候选用户]
     */
    public final static String FIELD_MINORWFUSERNAME = "MINORWFUSERNAME";
    /**
     * 属性[策略状态]
     */
    public final static String FIELD_POLICYSTATE = "POLICYSTATE";
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
     * 属性[是否启用]
     */
    public final static String FIELD_VALIDFLAG = "VALIDFLAG";
    /**
     * 属性[工作流候选用户策略标识]
     */
    public final static String FIELD_WFUCPOLICYID = "WFUCPOLICYID";
    /**
     * 属性[工作流候选用户策略名称]
     */
    public final static String FIELD_WFUCPOLICYNAME = "WFUCPOLICYNAME";

    private final static int INDEX_BEGINTIME = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_ENDTIME = 3;
    private final static int INDEX_MAJORWFUSERID = 4;
    private final static int INDEX_MAJORWFUSERNAME = 5;
    private final static int INDEX_MEMO = 6;
    private final static int INDEX_MINORWFUSERID = 7;
    private final static int INDEX_MINORWFUSERNAME = 8;
    private final static int INDEX_POLICYSTATE = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;
    private final static int INDEX_USERDATA = 12;
    private final static int INDEX_USERDATA2 = 13;
    private final static int INDEX_VALIDFLAG = 14;
    private final static int INDEX_WFUCPOLICYID = 15;
    private final static int INDEX_WFUCPOLICYNAME = 16;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_BEGINTIME, INDEX_BEGINTIME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENDTIME, INDEX_ENDTIME);
        fieldIndexMap.put( FIELD_MAJORWFUSERID, INDEX_MAJORWFUSERID);
        fieldIndexMap.put( FIELD_MAJORWFUSERNAME, INDEX_MAJORWFUSERNAME);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_MINORWFUSERID, INDEX_MINORWFUSERID);
        fieldIndexMap.put( FIELD_MINORWFUSERNAME, INDEX_MINORWFUSERNAME);
        fieldIndexMap.put( FIELD_POLICYSTATE, INDEX_POLICYSTATE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_VALIDFLAG, INDEX_VALIDFLAG);
        fieldIndexMap.put( FIELD_WFUCPOLICYID, INDEX_WFUCPOLICYID);
        fieldIndexMap.put( FIELD_WFUCPOLICYNAME, INDEX_WFUCPOLICYNAME);
    }

    private WFUCPolicyBase proxyWFUCPolicyBase = null;
    public WFUCPolicyBase() {
        super();
    }
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean majorwfuseridDirtyFlag = false;
    private boolean majorwfusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorwfuseridDirtyFlag = false;
    private boolean minorwfusernameDirtyFlag = false;
    private boolean policystateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfucpolicyidDirtyFlag = false;
    private boolean wfucpolicynameDirtyFlag = false;

    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="majorwfuserid")
    private String majorwfuserid;
    @Column(name="majorwfusername")
    private String majorwfusername;
    @Column(name="memo")
    private String memo;
    @Column(name="minorwfuserid")
    private String minorwfuserid;
    @Column(name="minorwfusername")
    private String minorwfusername;
    @Column(name="policystate")
    private Integer policystate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfucpolicyid")
    private String wfucpolicyid;
    @Column(name="wfucpolicyname")
    private String wfucpolicyname;


    /**
     *  设置属性值[开始时间]
     *  @param begintime
     */
    public void setBeginTime(Timestamp begintime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setBeginTime(begintime);
            return;
        }
        this.begintime = begintime;
        this.begintimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[开始时间]
     */
    public Timestamp getBeginTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    /**
     *  获取属性值[开始时间]是否修改
     */
    public boolean isBeginTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    /**
     *  重置属性值[开始时间]
     */
    public void resetBeginTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }

        this.begintimeDirtyFlag = false;
        this.begintime = null;
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
     *  设置属性值[结束时间]
     *  @param endtime
     */
    public void setEndTime(Timestamp endtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEndTime(endtime);
            return;
        }
        this.endtime = endtime;
        this.endtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[结束时间]
     */
    public Timestamp getEndTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    /**
     *  获取属性值[结束时间]是否修改
     */
    public boolean isEndTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    /**
     *  重置属性值[结束时间]
     */
    public void resetEndTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEndTime();
            return;
        }

        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }
    /**
     *  设置属性值[工作流用户]
     *  @param majorwfuserid
     */
    public void setMajorWFUserId(String majorwfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMajorWFUserId(majorwfuserid);
            return;
        }
        if(majorwfuserid!=null) {
            majorwfuserid = StringHelper.trimRight(majorwfuserid);
            if(majorwfuserid.length()==0) {
                majorwfuserid = null;
            }
        }
        this.majorwfuserid = majorwfuserid;
        this.majorwfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户]
     */
    public String getMajorWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorWFUserId();
        }
        return this.majorwfuserid;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isMajorWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMajorWFUserIdDirty();
        }
        return this.majorwfuseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
     */
    public void resetMajorWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMajorWFUserId();
            return;
        }

        this.majorwfuseridDirtyFlag = false;
        this.majorwfuserid = null;
    }
    /**
     *  设置属性值[工作流用户]
     *  @param majorwfusername
     */
    public void setMajorWFUserName(String majorwfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMajorWFUserName(majorwfusername);
            return;
        }
        if(majorwfusername!=null) {
            majorwfusername = StringHelper.trimRight(majorwfusername);
            if(majorwfusername.length()==0) {
                majorwfusername = null;
            }
        }
        this.majorwfusername = majorwfusername;
        this.majorwfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户]
     */
    public String getMajorWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorWFUserName();
        }
        return this.majorwfusername;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isMajorWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMajorWFUserNameDirty();
        }
        return this.majorwfusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
     */
    public void resetMajorWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMajorWFUserName();
            return;
        }

        this.majorwfusernameDirtyFlag = false;
        this.majorwfusername = null;
    }
    /**
     *  设置属性值[备注]
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
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
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
     *  设置属性值[候选用户]
     *  @param minorwfuserid
     */
    public void setMinorWFUserId(String minorwfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorWFUserId(minorwfuserid);
            return;
        }
        if(minorwfuserid!=null) {
            minorwfuserid = StringHelper.trimRight(minorwfuserid);
            if(minorwfuserid.length()==0) {
                minorwfuserid = null;
            }
        }
        this.minorwfuserid = minorwfuserid;
        this.minorwfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[候选用户]
     */
    public String getMinorWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorWFUserId();
        }
        return this.minorwfuserid;
    }

    /**
     *  获取属性值[候选用户]是否修改
     */
    public boolean isMinorWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorWFUserIdDirty();
        }
        return this.minorwfuseridDirtyFlag;
    }

    /**
     *  重置属性值[候选用户]
     */
    public void resetMinorWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorWFUserId();
            return;
        }

        this.minorwfuseridDirtyFlag = false;
        this.minorwfuserid = null;
    }
    /**
     *  设置属性值[候选用户]
     *  @param minorwfusername
     */
    public void setMinorWFUserName(String minorwfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorWFUserName(minorwfusername);
            return;
        }
        if(minorwfusername!=null) {
            minorwfusername = StringHelper.trimRight(minorwfusername);
            if(minorwfusername.length()==0) {
                minorwfusername = null;
            }
        }
        this.minorwfusername = minorwfusername;
        this.minorwfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[候选用户]
     */
    public String getMinorWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorWFUserName();
        }
        return this.minorwfusername;
    }

    /**
     *  获取属性值[候选用户]是否修改
     */
    public boolean isMinorWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorWFUserNameDirty();
        }
        return this.minorwfusernameDirtyFlag;
    }

    /**
     *  重置属性值[候选用户]
     */
    public void resetMinorWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorWFUserName();
            return;
        }

        this.minorwfusernameDirtyFlag = false;
        this.minorwfusername = null;
    }
    /**
     *  设置属性值[策略状态]代码表：net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel
     *  @param policystate
     */
    public void setPolicyState(Integer policystate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPolicyState(policystate);
            return;
        }
        this.policystate = policystate;
        this.policystateDirtyFlag  = true;
    }

    /**
     *  获取属性值[策略状态]代码表：net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel
     */
    public Integer getPolicyState() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPolicyState();
        }
        return this.policystate;
    }

    /**
     *  获取属性值[策略状态]是否修改
     */
    public boolean isPolicyStateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPolicyStateDirty();
        }
        return this.policystateDirtyFlag;
    }

    /**
     *  重置属性值[策略状态]
     */
    public void resetPolicyState() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPolicyState();
            return;
        }

        this.policystateDirtyFlag = false;
        this.policystate = null;
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
     *  设置属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param validflag
     */
    public void setValidFlag(Integer validflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getValidFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    /**
     *  获取属性值[是否启用]是否修改
     */
    public boolean isValidFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    /**
     *  重置属性值[是否启用]
     */
    public void resetValidFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }

        this.validflagDirtyFlag = false;
        this.validflag = null;
    }
    /**
     *  设置属性值[工作流候选用户策略标识]
     *  @param wfucpolicyid
     */
    public void setWFUCPolicyId(String wfucpolicyid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUCPolicyId(wfucpolicyid);
            return;
        }
        if(wfucpolicyid!=null) {
            wfucpolicyid = StringHelper.trimRight(wfucpolicyid);
            if(wfucpolicyid.length()==0) {
                wfucpolicyid = null;
            }
        }
        this.wfucpolicyid = wfucpolicyid;
        this.wfucpolicyidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流候选用户策略标识]
     */
    public String getWFUCPolicyId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUCPolicyId();
        }
        return this.wfucpolicyid;
    }

    /**
     *  获取属性值[工作流候选用户策略标识]是否修改
     */
    public boolean isWFUCPolicyIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUCPolicyIdDirty();
        }
        return this.wfucpolicyidDirtyFlag;
    }

    /**
     *  重置属性值[工作流候选用户策略标识]
     */
    public void resetWFUCPolicyId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUCPolicyId();
            return;
        }

        this.wfucpolicyidDirtyFlag = false;
        this.wfucpolicyid = null;
    }
    /**
     *  设置属性值[工作流候选用户策略名称]
     *  @param wfucpolicyname
     */
    public void setWFUCPolicyName(String wfucpolicyname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUCPolicyName(wfucpolicyname);
            return;
        }
        if(wfucpolicyname!=null) {
            wfucpolicyname = StringHelper.trimRight(wfucpolicyname);
            if(wfucpolicyname.length()==0) {
                wfucpolicyname = null;
            }
        }
        this.wfucpolicyname = wfucpolicyname;
        this.wfucpolicynameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流候选用户策略名称]
     */
    public String getWFUCPolicyName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUCPolicyName();
        }
        return this.wfucpolicyname;
    }

    /**
     *  获取属性值[工作流候选用户策略名称]是否修改
     */
    public boolean isWFUCPolicyNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUCPolicyNameDirty();
        }
        return this.wfucpolicynameDirtyFlag;
    }

    /**
     *  重置属性值[工作流候选用户策略名称]
     */
    public void resetWFUCPolicyName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUCPolicyName();
            return;
        }

        this.wfucpolicynameDirtyFlag = false;
        this.wfucpolicyname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFUCPolicyBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUCPolicyBase et) {
        et.resetBeginTime();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEndTime();
        et.resetMajorWFUserId();
        et.resetMajorWFUserName();
        et.resetMemo();
        et.resetMinorWFUserId();
        et.resetMinorWFUserName();
        et.resetPolicyState();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetValidFlag();
        et.resetWFUCPolicyId();
        et.resetWFUCPolicyName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isBeginTimeDirty()) {
            params.put(FIELD_BEGINTIME,getBeginTime());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isEndTimeDirty()) {
            params.put(FIELD_ENDTIME,getEndTime());
        }
        if(!bDirtyOnly || isMajorWFUserIdDirty()) {
            params.put(FIELD_MAJORWFUSERID,getMajorWFUserId());
        }
        if(!bDirtyOnly || isMajorWFUserNameDirty()) {
            params.put(FIELD_MAJORWFUSERNAME,getMajorWFUserName());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isMinorWFUserIdDirty()) {
            params.put(FIELD_MINORWFUSERID,getMinorWFUserId());
        }
        if(!bDirtyOnly || isMinorWFUserNameDirty()) {
            params.put(FIELD_MINORWFUSERNAME,getMinorWFUserName());
        }
        if(!bDirtyOnly || isPolicyStateDirty()) {
            params.put(FIELD_POLICYSTATE,getPolicyState());
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
        if(!bDirtyOnly || isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG,getValidFlag());
        }
        if(!bDirtyOnly || isWFUCPolicyIdDirty()) {
            params.put(FIELD_WFUCPOLICYID,getWFUCPolicyId());
        }
        if(!bDirtyOnly || isWFUCPolicyNameDirty()) {
            params.put(FIELD_WFUCPOLICYNAME,getWFUCPolicyName());
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

        return  WFUCPolicyBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUCPolicyBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BEGINTIME:
            return et.getBeginTime();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENDTIME:
            return et.getEndTime();
        case INDEX_MAJORWFUSERID:
            return et.getMajorWFUserId();
        case INDEX_MAJORWFUSERNAME:
            return et.getMajorWFUserName();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_MINORWFUSERID:
            return et.getMinorWFUserId();
        case INDEX_MINORWFUSERNAME:
            return et.getMinorWFUserName();
        case INDEX_POLICYSTATE:
            return et.getPolicyState();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_VALIDFLAG:
            return et.getValidFlag();
        case INDEX_WFUCPOLICYID:
            return et.getWFUCPolicyId();
        case INDEX_WFUCPOLICYNAME:
            return et.getWFUCPolicyName();
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

        WFUCPolicyBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUCPolicyBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_BEGINTIME:
            et.setBeginTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENDTIME:
            et.setEndTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_MAJORWFUSERID:
            et.setMajorWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MAJORWFUSERNAME:
            et.setMajorWFUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORWFUSERID:
            et.setMinorWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORWFUSERNAME:
            et.setMinorWFUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_POLICYSTATE:
            et.setPolicyState(DataObject.getIntegerValue(obj));
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
        case INDEX_VALIDFLAG:
            et.setValidFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WFUCPOLICYID:
            et.setWFUCPolicyId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUCPOLICYNAME:
            et.setWFUCPolicyName(DataObject.getStringValue(obj));
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

        return  WFUCPolicyBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUCPolicyBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BEGINTIME:
            return et.getBeginTime()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENDTIME:
            return et.getEndTime()==null;
        case INDEX_MAJORWFUSERID:
            return et.getMajorWFUserId()==null;
        case INDEX_MAJORWFUSERNAME:
            return et.getMajorWFUserName()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_MINORWFUSERID:
            return et.getMinorWFUserId()==null;
        case INDEX_MINORWFUSERNAME:
            return et.getMinorWFUserName()==null;
        case INDEX_POLICYSTATE:
            return et.getPolicyState()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_VALIDFLAG:
            return et.getValidFlag()==null;
        case INDEX_WFUCPOLICYID:
            return et.getWFUCPolicyId()==null;
        case INDEX_WFUCPOLICYNAME:
            return et.getWFUCPolicyName()==null;
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
        return  WFUCPolicyBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUCPolicyBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BEGINTIME:
            return et.isBeginTimeDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENDTIME:
            return et.isEndTimeDirty();
        case INDEX_MAJORWFUSERID:
            return et.isMajorWFUserIdDirty();
        case INDEX_MAJORWFUSERNAME:
            return et.isMajorWFUserNameDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_MINORWFUSERID:
            return et.isMinorWFUserIdDirty();
        case INDEX_MINORWFUSERNAME:
            return et.isMinorWFUserNameDirty();
        case INDEX_POLICYSTATE:
            return et.isPolicyStateDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_VALIDFLAG:
            return et.isValidFlagDirty();
        case INDEX_WFUCPOLICYID:
            return et.isWFUCPolicyIdDirty();
        case INDEX_WFUCPOLICYNAME:
            return et.isWFUCPolicyNameDirty();
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
    private static  void fillJSONObject(WFUCPolicyBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getBeginTime()!=null) {
            JSONObjectHelper.put(json,"begintime",getJSONValue(et.getBeginTime()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            JSONObjectHelper.put(json,"endtime",getJSONValue(et.getEndTime()),false);
        }
        if(bIncEmpty||et.getMajorWFUserId()!=null) {
            JSONObjectHelper.put(json,"majorwfuserid",getJSONValue(et.getMajorWFUserId()),false);
        }
        if(bIncEmpty||et.getMajorWFUserName()!=null) {
            JSONObjectHelper.put(json,"majorwfusername",getJSONValue(et.getMajorWFUserName()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getMinorWFUserId()!=null) {
            JSONObjectHelper.put(json,"minorwfuserid",getJSONValue(et.getMinorWFUserId()),false);
        }
        if(bIncEmpty||et.getMinorWFUserName()!=null) {
            JSONObjectHelper.put(json,"minorwfusername",getJSONValue(et.getMinorWFUserName()),false);
        }
        if(bIncEmpty||et.getPolicyState()!=null) {
            JSONObjectHelper.put(json,"policystate",getJSONValue(et.getPolicyState()),false);
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
        if(bIncEmpty||et.getValidFlag()!=null) {
            JSONObjectHelper.put(json,"validflag",getJSONValue(et.getValidFlag()),false);
        }
        if(bIncEmpty||et.getWFUCPolicyId()!=null) {
            JSONObjectHelper.put(json,"wfucpolicyid",getJSONValue(et.getWFUCPolicyId()),false);
        }
        if(bIncEmpty||et.getWFUCPolicyName()!=null) {
            JSONObjectHelper.put(json,"wfucpolicyname",getJSONValue(et.getWFUCPolicyName()),false);
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
    private static void fillXmlNode(WFUCPolicyBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getBeginTime()!=null) {
            Object obj = et.getBeginTime();
            node.setAttribute("BEGINTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            Object obj = et.getEndTime();
            node.setAttribute("ENDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getMajorWFUserId()!=null) {
            Object obj = et.getMajorWFUserId();
            node.setAttribute("MAJORWFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMajorWFUserName()!=null) {
            Object obj = et.getMajorWFUserName();
            node.setAttribute("MAJORWFUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorWFUserId()!=null) {
            Object obj = et.getMinorWFUserId();
            node.setAttribute("MINORWFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorWFUserName()!=null) {
            Object obj = et.getMinorWFUserName();
            node.setAttribute("MINORWFUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPolicyState()!=null) {
            Object obj = et.getPolicyState();
            node.setAttribute("POLICYSTATE",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        if(bIncEmpty||et.getValidFlag()!=null) {
            Object obj = et.getValidFlag();
            node.setAttribute("VALIDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWFUCPolicyId()!=null) {
            Object obj = et.getWFUCPolicyId();
            node.setAttribute("WFUCPOLICYID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUCPolicyName()!=null) {
            Object obj = et.getWFUCPolicyName();
            node.setAttribute("WFUCPOLICYNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUCPolicyBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUCPolicyBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isBeginTimeDirty() && (bIncEmpty||et.getBeginTime()!=null)) {
            dst.set(FIELD_BEGINTIME,et.getBeginTime());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEndTimeDirty() && (bIncEmpty||et.getEndTime()!=null)) {
            dst.set(FIELD_ENDTIME,et.getEndTime());
        }
        if(et.isMajorWFUserIdDirty() && (bIncEmpty||et.getMajorWFUserId()!=null)) {
            dst.set(FIELD_MAJORWFUSERID,et.getMajorWFUserId());
        }
        if(et.isMajorWFUserNameDirty() && (bIncEmpty||et.getMajorWFUserName()!=null)) {
            dst.set(FIELD_MAJORWFUSERNAME,et.getMajorWFUserName());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isMinorWFUserIdDirty() && (bIncEmpty||et.getMinorWFUserId()!=null)) {
            dst.set(FIELD_MINORWFUSERID,et.getMinorWFUserId());
        }
        if(et.isMinorWFUserNameDirty() && (bIncEmpty||et.getMinorWFUserName()!=null)) {
            dst.set(FIELD_MINORWFUSERNAME,et.getMinorWFUserName());
        }
        if(et.isPolicyStateDirty() && (bIncEmpty||et.getPolicyState()!=null)) {
            dst.set(FIELD_POLICYSTATE,et.getPolicyState());
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
        if(et.isValidFlagDirty() && (bIncEmpty||et.getValidFlag()!=null)) {
            dst.set(FIELD_VALIDFLAG,et.getValidFlag());
        }
        if(et.isWFUCPolicyIdDirty() && (bIncEmpty||et.getWFUCPolicyId()!=null)) {
            dst.set(FIELD_WFUCPOLICYID,et.getWFUCPolicyId());
        }
        if(et.isWFUCPolicyNameDirty() && (bIncEmpty||et.getWFUCPolicyName()!=null)) {
            dst.set(FIELD_WFUCPOLICYNAME,et.getWFUCPolicyName());
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
        return  WFUCPolicyBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUCPolicyBase et,int index) throws Exception {
        switch(index) {
        case INDEX_BEGINTIME:
            et.resetBeginTime();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENDTIME:
            et.resetEndTime();
            return true;
        case INDEX_MAJORWFUSERID:
            et.resetMajorWFUserId();
            return true;
        case INDEX_MAJORWFUSERNAME:
            et.resetMajorWFUserName();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_MINORWFUSERID:
            et.resetMinorWFUserId();
            return true;
        case INDEX_MINORWFUSERNAME:
            et.resetMinorWFUserName();
            return true;
        case INDEX_POLICYSTATE:
            et.resetPolicyState();
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
        case INDEX_VALIDFLAG:
            et.resetValidFlag();
            return true;
        case INDEX_WFUCPOLICYID:
            et.resetWFUCPolicyId();
            return true;
        case INDEX_WFUCPOLICYNAME:
            et.resetWFUCPolicyName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objMajorWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser majorwfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getMajorWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorWFUser();
        }

        if(this.getMajorWFUserId()==null)
            return null;
        synchronized(this.objMajorWFUserLock) {
            if(this.majorwfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getMajorWFUserId(),majorwfuser.getWFUserId())!=0) {
                    this.majorwfuser = null;
                }
            }


            if(this.majorwfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser majorwfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                majorwfuser.setWFUserId(this.getMajorWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(majorwfuser);
                this.majorwfuser = majorwfuser;
            }
            return this.majorwfuser;
        }
    }

    private Integer objMinorWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser minorwfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getMinorWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorWFUser();
        }

        if(this.getMinorWFUserId()==null)
            return null;
        synchronized(this.objMinorWFUserLock) {
            if(this.minorwfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getMinorWFUserId(),minorwfuser.getWFUserId())!=0) {
                    this.minorwfuser = null;
                }
            }


            if(this.minorwfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser minorwfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                minorwfuser.setWFUserId(this.getMinorWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(minorwfuser);
                this.minorwfuser = minorwfuser;
            }
            return this.minorwfuser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFUCPolicyBase getProxyEntity() {
        return this.proxyWFUCPolicyBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUCPolicyBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUCPolicyBase) {
            this.proxyWFUCPolicyBase = (WFUCPolicyBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUCPolicyService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}