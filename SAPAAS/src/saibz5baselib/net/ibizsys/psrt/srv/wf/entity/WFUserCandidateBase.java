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
 * 实体[WFUserCandidate] 数据对象基类
 */
public abstract class WFUserCandidateBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserCandidateBase.class);
    /**
     * 属性[候选次序]
     */
    public final static String FIELD_CANDIDATEORDER = "CANDIDATEORDER";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
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
     * 属性[工作流主用户]
     */
    public final static String FIELD_WFMAJORUSERID = "WFMAJORUSERID";
    /**
     * 属性[工作流主用户]
     */
    public final static String FIELD_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    /**
     * 属性[工作流候选用户]
     */
    public final static String FIELD_WFMINORUSERID = "WFMINORUSERID";
    /**
     * 属性[工作流候选用户]
     */
    public final static String FIELD_WFMINORUSERNAME = "WFMINORUSERNAME";
    /**
     * 属性[工作流用户候选者标识]
     */
    public final static String FIELD_WFUSERCANDIDATEID = "WFUSERCANDIDATEID";
    /**
     * 属性[工作流用户候选者名称]
     */
    public final static String FIELD_WFUSERCANDIDATENAME = "WFUSERCANDIDATENAME";

    private final static int INDEX_CANDIDATEORDER = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_UPDATEDATE = 4;
    private final static int INDEX_UPDATEMAN = 5;
    private final static int INDEX_USERDATA = 6;
    private final static int INDEX_USERDATA2 = 7;
    private final static int INDEX_WFMAJORUSERID = 8;
    private final static int INDEX_WFMAJORUSERNAME = 9;
    private final static int INDEX_WFMINORUSERID = 10;
    private final static int INDEX_WFMINORUSERNAME = 11;
    private final static int INDEX_WFUSERCANDIDATEID = 12;
    private final static int INDEX_WFUSERCANDIDATENAME = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CANDIDATEORDER, INDEX_CANDIDATEORDER);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_WFMAJORUSERID, INDEX_WFMAJORUSERID);
        fieldIndexMap.put( FIELD_WFMAJORUSERNAME, INDEX_WFMAJORUSERNAME);
        fieldIndexMap.put( FIELD_WFMINORUSERID, INDEX_WFMINORUSERID);
        fieldIndexMap.put( FIELD_WFMINORUSERNAME, INDEX_WFMINORUSERNAME);
        fieldIndexMap.put( FIELD_WFUSERCANDIDATEID, INDEX_WFUSERCANDIDATEID);
        fieldIndexMap.put( FIELD_WFUSERCANDIDATENAME, INDEX_WFUSERCANDIDATENAME);
    }

    private WFUserCandidateBase proxyWFUserCandidateBase = null;
    public WFUserCandidateBase() {
        super();
    }
    private boolean candidateorderDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean wfmajoruseridDirtyFlag = false;
    private boolean wfmajorusernameDirtyFlag = false;
    private boolean wfminoruseridDirtyFlag = false;
    private boolean wfminorusernameDirtyFlag = false;
    private boolean wfusercandidateidDirtyFlag = false;
    private boolean wfusercandidatenameDirtyFlag = false;

    @Column(name="candidateorder")
    private Integer candidateorder;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="wfmajoruserid")
    private String wfmajoruserid;
    @Column(name="wfmajorusername")
    private String wfmajorusername;
    @Column(name="wfminoruserid")
    private String wfminoruserid;
    @Column(name="wfminorusername")
    private String wfminorusername;
    @Column(name="wfusercandidateid")
    private String wfusercandidateid;
    @Column(name="wfusercandidatename")
    private String wfusercandidatename;


    /**
     *  设置属性值[候选次序]
     *  @param candidateorder
     */
    public void setCandidateOrder(Integer candidateorder) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCandidateOrder(candidateorder);
            return;
        }
        this.candidateorder = candidateorder;
        this.candidateorderDirtyFlag  = true;
    }

    /**
     *  获取属性值[候选次序]
     */
    public Integer getCandidateOrder() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCandidateOrder();
        }
        return this.candidateorder;
    }

    /**
     *  获取属性值[候选次序]是否修改
     */
    public boolean isCandidateOrderDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCandidateOrderDirty();
        }
        return this.candidateorderDirtyFlag;
    }

    /**
     *  重置属性值[候选次序]
     */
    public void resetCandidateOrder() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCandidateOrder();
            return;
        }

        this.candidateorderDirtyFlag = false;
        this.candidateorder = null;
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
     *  设置属性值[工作流主用户]
     *  @param wfmajoruserid
     */
    public void setWFMajorUserId(String wfmajoruserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFMajorUserId(wfmajoruserid);
            return;
        }
        if(wfmajoruserid!=null) {
            wfmajoruserid = StringHelper.trimRight(wfmajoruserid);
            if(wfmajoruserid.length()==0) {
                wfmajoruserid = null;
            }
        }
        this.wfmajoruserid = wfmajoruserid;
        this.wfmajoruseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流主用户]
     */
    public String getWFMajorUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMajorUserId();
        }
        return this.wfmajoruserid;
    }

    /**
     *  获取属性值[工作流主用户]是否修改
     */
    public boolean isWFMajorUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMajorUserIdDirty();
        }
        return this.wfmajoruseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流主用户]
     */
    public void resetWFMajorUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFMajorUserId();
            return;
        }

        this.wfmajoruseridDirtyFlag = false;
        this.wfmajoruserid = null;
    }
    /**
     *  设置属性值[工作流主用户]
     *  @param wfmajorusername
     */
    public void setWFMajorUserName(String wfmajorusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFMajorUserName(wfmajorusername);
            return;
        }
        if(wfmajorusername!=null) {
            wfmajorusername = StringHelper.trimRight(wfmajorusername);
            if(wfmajorusername.length()==0) {
                wfmajorusername = null;
            }
        }
        this.wfmajorusername = wfmajorusername;
        this.wfmajorusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流主用户]
     */
    public String getWFMajorUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMajorUserName();
        }
        return this.wfmajorusername;
    }

    /**
     *  获取属性值[工作流主用户]是否修改
     */
    public boolean isWFMajorUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMajorUserNameDirty();
        }
        return this.wfmajorusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流主用户]
     */
    public void resetWFMajorUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFMajorUserName();
            return;
        }

        this.wfmajorusernameDirtyFlag = false;
        this.wfmajorusername = null;
    }
    /**
     *  设置属性值[工作流候选用户]
     *  @param wfminoruserid
     */
    public void setWFMinorUserId(String wfminoruserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFMinorUserId(wfminoruserid);
            return;
        }
        if(wfminoruserid!=null) {
            wfminoruserid = StringHelper.trimRight(wfminoruserid);
            if(wfminoruserid.length()==0) {
                wfminoruserid = null;
            }
        }
        this.wfminoruserid = wfminoruserid;
        this.wfminoruseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流候选用户]
     */
    public String getWFMinorUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMinorUserId();
        }
        return this.wfminoruserid;
    }

    /**
     *  获取属性值[工作流候选用户]是否修改
     */
    public boolean isWFMinorUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMinorUserIdDirty();
        }
        return this.wfminoruseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流候选用户]
     */
    public void resetWFMinorUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFMinorUserId();
            return;
        }

        this.wfminoruseridDirtyFlag = false;
        this.wfminoruserid = null;
    }
    /**
     *  设置属性值[工作流候选用户]
     *  @param wfminorusername
     */
    public void setWFMinorUserName(String wfminorusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFMinorUserName(wfminorusername);
            return;
        }
        if(wfminorusername!=null) {
            wfminorusername = StringHelper.trimRight(wfminorusername);
            if(wfminorusername.length()==0) {
                wfminorusername = null;
            }
        }
        this.wfminorusername = wfminorusername;
        this.wfminorusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流候选用户]
     */
    public String getWFMinorUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMinorUserName();
        }
        return this.wfminorusername;
    }

    /**
     *  获取属性值[工作流候选用户]是否修改
     */
    public boolean isWFMinorUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMinorUserNameDirty();
        }
        return this.wfminorusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流候选用户]
     */
    public void resetWFMinorUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFMinorUserName();
            return;
        }

        this.wfminorusernameDirtyFlag = false;
        this.wfminorusername = null;
    }
    /**
     *  设置属性值[工作流用户候选者标识]
     *  @param wfusercandidateid
     */
    public void setWFUserCandidateId(String wfusercandidateid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserCandidateId(wfusercandidateid);
            return;
        }
        if(wfusercandidateid!=null) {
            wfusercandidateid = StringHelper.trimRight(wfusercandidateid);
            if(wfusercandidateid.length()==0) {
                wfusercandidateid = null;
            }
        }
        this.wfusercandidateid = wfusercandidateid;
        this.wfusercandidateidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户候选者标识]
     */
    public String getWFUserCandidateId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserCandidateId();
        }
        return this.wfusercandidateid;
    }

    /**
     *  获取属性值[工作流用户候选者标识]是否修改
     */
    public boolean isWFUserCandidateIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserCandidateIdDirty();
        }
        return this.wfusercandidateidDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户候选者标识]
     */
    public void resetWFUserCandidateId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserCandidateId();
            return;
        }

        this.wfusercandidateidDirtyFlag = false;
        this.wfusercandidateid = null;
    }
    /**
     *  设置属性值[工作流用户候选者名称]
     *  @param wfusercandidatename
     */
    public void setWFUserCandidateName(String wfusercandidatename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserCandidateName(wfusercandidatename);
            return;
        }
        if(wfusercandidatename!=null) {
            wfusercandidatename = StringHelper.trimRight(wfusercandidatename);
            if(wfusercandidatename.length()==0) {
                wfusercandidatename = null;
            }
        }
        this.wfusercandidatename = wfusercandidatename;
        this.wfusercandidatenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户候选者名称]
     */
    public String getWFUserCandidateName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserCandidateName();
        }
        return this.wfusercandidatename;
    }

    /**
     *  获取属性值[工作流用户候选者名称]是否修改
     */
    public boolean isWFUserCandidateNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserCandidateNameDirty();
        }
        return this.wfusercandidatenameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户候选者名称]
     */
    public void resetWFUserCandidateName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserCandidateName();
            return;
        }

        this.wfusercandidatenameDirtyFlag = false;
        this.wfusercandidatename = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFUserCandidateBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUserCandidateBase et) {
        et.resetCandidateOrder();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetWFMajorUserId();
        et.resetWFMajorUserName();
        et.resetWFMinorUserId();
        et.resetWFMinorUserName();
        et.resetWFUserCandidateId();
        et.resetWFUserCandidateName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCandidateOrderDirty()) {
            params.put(FIELD_CANDIDATEORDER,getCandidateOrder());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
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
        if(!bDirtyOnly || isWFMajorUserIdDirty()) {
            params.put(FIELD_WFMAJORUSERID,getWFMajorUserId());
        }
        if(!bDirtyOnly || isWFMajorUserNameDirty()) {
            params.put(FIELD_WFMAJORUSERNAME,getWFMajorUserName());
        }
        if(!bDirtyOnly || isWFMinorUserIdDirty()) {
            params.put(FIELD_WFMINORUSERID,getWFMinorUserId());
        }
        if(!bDirtyOnly || isWFMinorUserNameDirty()) {
            params.put(FIELD_WFMINORUSERNAME,getWFMinorUserName());
        }
        if(!bDirtyOnly || isWFUserCandidateIdDirty()) {
            params.put(FIELD_WFUSERCANDIDATEID,getWFUserCandidateId());
        }
        if(!bDirtyOnly || isWFUserCandidateNameDirty()) {
            params.put(FIELD_WFUSERCANDIDATENAME,getWFUserCandidateName());
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

        return  WFUserCandidateBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUserCandidateBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CANDIDATEORDER:
            return et.getCandidateOrder();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_WFMAJORUSERID:
            return et.getWFMajorUserId();
        case INDEX_WFMAJORUSERNAME:
            return et.getWFMajorUserName();
        case INDEX_WFMINORUSERID:
            return et.getWFMinorUserId();
        case INDEX_WFMINORUSERNAME:
            return et.getWFMinorUserName();
        case INDEX_WFUSERCANDIDATEID:
            return et.getWFUserCandidateId();
        case INDEX_WFUSERCANDIDATENAME:
            return et.getWFUserCandidateName();
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

        WFUserCandidateBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUserCandidateBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CANDIDATEORDER:
            et.setCandidateOrder(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
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
        case INDEX_WFMAJORUSERID:
            et.setWFMajorUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFMAJORUSERNAME:
            et.setWFMajorUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFMINORUSERID:
            et.setWFMinorUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFMINORUSERNAME:
            et.setWFMinorUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERCANDIDATEID:
            et.setWFUserCandidateId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERCANDIDATENAME:
            et.setWFUserCandidateName(DataObject.getStringValue(obj));
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

        return  WFUserCandidateBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUserCandidateBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CANDIDATEORDER:
            return et.getCandidateOrder()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_WFMAJORUSERID:
            return et.getWFMajorUserId()==null;
        case INDEX_WFMAJORUSERNAME:
            return et.getWFMajorUserName()==null;
        case INDEX_WFMINORUSERID:
            return et.getWFMinorUserId()==null;
        case INDEX_WFMINORUSERNAME:
            return et.getWFMinorUserName()==null;
        case INDEX_WFUSERCANDIDATEID:
            return et.getWFUserCandidateId()==null;
        case INDEX_WFUSERCANDIDATENAME:
            return et.getWFUserCandidateName()==null;
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
        return  WFUserCandidateBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUserCandidateBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CANDIDATEORDER:
            return et.isCandidateOrderDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_WFMAJORUSERID:
            return et.isWFMajorUserIdDirty();
        case INDEX_WFMAJORUSERNAME:
            return et.isWFMajorUserNameDirty();
        case INDEX_WFMINORUSERID:
            return et.isWFMinorUserIdDirty();
        case INDEX_WFMINORUSERNAME:
            return et.isWFMinorUserNameDirty();
        case INDEX_WFUSERCANDIDATEID:
            return et.isWFUserCandidateIdDirty();
        case INDEX_WFUSERCANDIDATENAME:
            return et.isWFUserCandidateNameDirty();
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
    private static  void fillJSONObject(WFUserCandidateBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCandidateOrder()!=null) {
            JSONObjectHelper.put(json,"candidateorder",getJSONValue(et.getCandidateOrder()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
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
        if(bIncEmpty||et.getWFMajorUserId()!=null) {
            JSONObjectHelper.put(json,"wfmajoruserid",getJSONValue(et.getWFMajorUserId()),false);
        }
        if(bIncEmpty||et.getWFMajorUserName()!=null) {
            JSONObjectHelper.put(json,"wfmajorusername",getJSONValue(et.getWFMajorUserName()),false);
        }
        if(bIncEmpty||et.getWFMinorUserId()!=null) {
            JSONObjectHelper.put(json,"wfminoruserid",getJSONValue(et.getWFMinorUserId()),false);
        }
        if(bIncEmpty||et.getWFMinorUserName()!=null) {
            JSONObjectHelper.put(json,"wfminorusername",getJSONValue(et.getWFMinorUserName()),false);
        }
        if(bIncEmpty||et.getWFUserCandidateId()!=null) {
            JSONObjectHelper.put(json,"wfusercandidateid",getJSONValue(et.getWFUserCandidateId()),false);
        }
        if(bIncEmpty||et.getWFUserCandidateName()!=null) {
            JSONObjectHelper.put(json,"wfusercandidatename",getJSONValue(et.getWFUserCandidateName()),false);
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
    private static void fillXmlNode(WFUserCandidateBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCandidateOrder()!=null) {
            Object obj = et.getCandidateOrder();
            node.setAttribute("CANDIDATEORDER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getWFMajorUserId()!=null) {
            Object obj = et.getWFMajorUserId();
            node.setAttribute("WFMAJORUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFMajorUserName()!=null) {
            Object obj = et.getWFMajorUserName();
            node.setAttribute("WFMAJORUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFMinorUserId()!=null) {
            Object obj = et.getWFMinorUserId();
            node.setAttribute("WFMINORUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFMinorUserName()!=null) {
            Object obj = et.getWFMinorUserName();
            node.setAttribute("WFMINORUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserCandidateId()!=null) {
            Object obj = et.getWFUserCandidateId();
            node.setAttribute("WFUSERCANDIDATEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserCandidateName()!=null) {
            Object obj = et.getWFUserCandidateName();
            node.setAttribute("WFUSERCANDIDATENAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUserCandidateBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUserCandidateBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCandidateOrderDirty() && (bIncEmpty||et.getCandidateOrder()!=null)) {
            dst.set(FIELD_CANDIDATEORDER,et.getCandidateOrder());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
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
        if(et.isWFMajorUserIdDirty() && (bIncEmpty||et.getWFMajorUserId()!=null)) {
            dst.set(FIELD_WFMAJORUSERID,et.getWFMajorUserId());
        }
        if(et.isWFMajorUserNameDirty() && (bIncEmpty||et.getWFMajorUserName()!=null)) {
            dst.set(FIELD_WFMAJORUSERNAME,et.getWFMajorUserName());
        }
        if(et.isWFMinorUserIdDirty() && (bIncEmpty||et.getWFMinorUserId()!=null)) {
            dst.set(FIELD_WFMINORUSERID,et.getWFMinorUserId());
        }
        if(et.isWFMinorUserNameDirty() && (bIncEmpty||et.getWFMinorUserName()!=null)) {
            dst.set(FIELD_WFMINORUSERNAME,et.getWFMinorUserName());
        }
        if(et.isWFUserCandidateIdDirty() && (bIncEmpty||et.getWFUserCandidateId()!=null)) {
            dst.set(FIELD_WFUSERCANDIDATEID,et.getWFUserCandidateId());
        }
        if(et.isWFUserCandidateNameDirty() && (bIncEmpty||et.getWFUserCandidateName()!=null)) {
            dst.set(FIELD_WFUSERCANDIDATENAME,et.getWFUserCandidateName());
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
        return  WFUserCandidateBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUserCandidateBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CANDIDATEORDER:
            et.resetCandidateOrder();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
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
        case INDEX_WFMAJORUSERID:
            et.resetWFMajorUserId();
            return true;
        case INDEX_WFMAJORUSERNAME:
            et.resetWFMajorUserName();
            return true;
        case INDEX_WFMINORUSERID:
            et.resetWFMinorUserId();
            return true;
        case INDEX_WFMINORUSERNAME:
            et.resetWFMinorUserName();
            return true;
        case INDEX_WFUSERCANDIDATEID:
            et.resetWFUserCandidateId();
            return true;
        case INDEX_WFUSERCANDIDATENAME:
            et.resetWFUserCandidateName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFMajorUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser wfmajoruser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getWFMajorUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMajorUser();
        }

        if(this.getWFMajorUserId()==null)
            return null;
        synchronized(this.objWFMajorUserLock) {
            if(this.wfmajoruser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFMajorUserId(),wfmajoruser.getWFUserId())!=0) {
                    this.wfmajoruser = null;
                }
            }


            if(this.wfmajoruser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser wfmajoruser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                wfmajoruser.setWFUserId(this.getWFMajorUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(wfmajoruser);
                this.wfmajoruser = wfmajoruser;
            }
            return this.wfmajoruser;
        }
    }

    private Integer objWFMinorUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser wfminoruser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getWFMinorUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMinorUser();
        }

        if(this.getWFMinorUserId()==null)
            return null;
        synchronized(this.objWFMinorUserLock) {
            if(this.wfminoruser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFMinorUserId(),wfminoruser.getWFUserId())!=0) {
                    this.wfminoruser = null;
                }
            }


            if(this.wfminoruser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser wfminoruser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                wfminoruser.setWFUserId(this.getWFMinorUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(wfminoruser);
                this.wfminoruser = wfminoruser;
            }
            return this.wfminoruser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFUserCandidateBase getProxyEntity() {
        return this.proxyWFUserCandidateBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserCandidateBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUserCandidateBase) {
            this.proxyWFUserCandidateBase = (WFUserCandidateBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserCandidateService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}