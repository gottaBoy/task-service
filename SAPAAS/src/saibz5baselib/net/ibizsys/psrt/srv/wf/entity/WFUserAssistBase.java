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
 * 实体[WFUserAssist] 数据对象基类
 */
public abstract class WFUserAssistBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserAssistBase.class);
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
     * 属性[工作流用户]
     */
    public final static String FIELD_WFMAJORUSERID = "WFMAJORUSERID";
    /**
     * 属性[工作流用户]
     */
    public final static String FIELD_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    /**
     * 属性[工作流代办用户]
     */
    public final static String FIELD_WFMINORUSERID = "WFMINORUSERID";
    /**
     * 属性[工作流代办用户]
     */
    public final static String FIELD_WFMINORUSERNAME = "WFMINORUSERNAME";
    /**
     * 属性[代办步骤]
     */
    public final static String FIELD_WFSTEP = "WFSTEP";
    /**
     * 属性[工作流用户代办标识]
     */
    public final static String FIELD_WFUSERASSISTID = "WFUSERASSISTID";
    /**
     * 属性[工作流用户代办名称]
     */
    public final static String FIELD_WFUSERASSISTNAME = "WFUSERASSISTNAME";
    /**
     * 属性[工作流]
     */
    public final static String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    /**
     * 属性[工作流]
     */
    public final static String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MEMO = 2;
    private final static int INDEX_UPDATEDATE = 3;
    private final static int INDEX_UPDATEMAN = 4;
    private final static int INDEX_WFMAJORUSERID = 5;
    private final static int INDEX_WFMAJORUSERNAME = 6;
    private final static int INDEX_WFMINORUSERID = 7;
    private final static int INDEX_WFMINORUSERNAME = 8;
    private final static int INDEX_WFSTEP = 9;
    private final static int INDEX_WFUSERASSISTID = 10;
    private final static int INDEX_WFUSERASSISTNAME = 11;
    private final static int INDEX_WFWORKFLOWID = 12;
    private final static int INDEX_WFWORKFLOWNAME = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFMAJORUSERID, INDEX_WFMAJORUSERID);
        fieldIndexMap.put( FIELD_WFMAJORUSERNAME, INDEX_WFMAJORUSERNAME);
        fieldIndexMap.put( FIELD_WFMINORUSERID, INDEX_WFMINORUSERID);
        fieldIndexMap.put( FIELD_WFMINORUSERNAME, INDEX_WFMINORUSERNAME);
        fieldIndexMap.put( FIELD_WFSTEP, INDEX_WFSTEP);
        fieldIndexMap.put( FIELD_WFUSERASSISTID, INDEX_WFUSERASSISTID);
        fieldIndexMap.put( FIELD_WFUSERASSISTNAME, INDEX_WFUSERASSISTNAME);
        fieldIndexMap.put( FIELD_WFWORKFLOWID, INDEX_WFWORKFLOWID);
        fieldIndexMap.put( FIELD_WFWORKFLOWNAME, INDEX_WFWORKFLOWNAME);
    }

    private WFUserAssistBase proxyWFUserAssistBase = null;
    public WFUserAssistBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfmajoruseridDirtyFlag = false;
    private boolean wfmajorusernameDirtyFlag = false;
    private boolean wfminoruseridDirtyFlag = false;
    private boolean wfminorusernameDirtyFlag = false;
    private boolean wfstepDirtyFlag = false;
    private boolean wfuserassistidDirtyFlag = false;
    private boolean wfuserassistnameDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;

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
    @Column(name="wfmajoruserid")
    private String wfmajoruserid;
    @Column(name="wfmajorusername")
    private String wfmajorusername;
    @Column(name="wfminoruserid")
    private String wfminoruserid;
    @Column(name="wfminorusername")
    private String wfminorusername;
    @Column(name="wfstep")
    private String wfstep;
    @Column(name="wfuserassistid")
    private String wfuserassistid;
    @Column(name="wfuserassistname")
    private String wfuserassistname;
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
     *  设置属性值[工作流用户]
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
     *  获取属性值[工作流用户]
     */
    public String getWFMajorUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMajorUserId();
        }
        return this.wfmajoruserid;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isWFMajorUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMajorUserIdDirty();
        }
        return this.wfmajoruseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
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
     *  设置属性值[工作流用户]
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
     *  获取属性值[工作流用户]
     */
    public String getWFMajorUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMajorUserName();
        }
        return this.wfmajorusername;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isWFMajorUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMajorUserNameDirty();
        }
        return this.wfmajorusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
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
     *  设置属性值[工作流代办用户]
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
     *  获取属性值[工作流代办用户]
     */
    public String getWFMinorUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMinorUserId();
        }
        return this.wfminoruserid;
    }

    /**
     *  获取属性值[工作流代办用户]是否修改
     */
    public boolean isWFMinorUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMinorUserIdDirty();
        }
        return this.wfminoruseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流代办用户]
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
     *  设置属性值[工作流代办用户]
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
     *  获取属性值[工作流代办用户]
     */
    public String getWFMinorUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFMinorUserName();
        }
        return this.wfminorusername;
    }

    /**
     *  获取属性值[工作流代办用户]是否修改
     */
    public boolean isWFMinorUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFMinorUserNameDirty();
        }
        return this.wfminorusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流代办用户]
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
     *  设置属性值[代办步骤]
     *  @param wfstep
     */
    public void setWFStep(String wfstep) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStep(wfstep);
            return;
        }
        if(wfstep!=null) {
            wfstep = StringHelper.trimRight(wfstep);
            if(wfstep.length()==0) {
                wfstep = null;
            }
        }
        this.wfstep = wfstep;
        this.wfstepDirtyFlag  = true;
    }

    /**
     *  获取属性值[代办步骤]
     */
    public String getWFStep() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStep();
        }
        return this.wfstep;
    }

    /**
     *  获取属性值[代办步骤]是否修改
     */
    public boolean isWFStepDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepDirty();
        }
        return this.wfstepDirtyFlag;
    }

    /**
     *  重置属性值[代办步骤]
     */
    public void resetWFStep() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStep();
            return;
        }

        this.wfstepDirtyFlag = false;
        this.wfstep = null;
    }
    /**
     *  设置属性值[工作流用户代办标识]
     *  @param wfuserassistid
     */
    public void setWFUserAssistId(String wfuserassistid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserAssistId(wfuserassistid);
            return;
        }
        if(wfuserassistid!=null) {
            wfuserassistid = StringHelper.trimRight(wfuserassistid);
            if(wfuserassistid.length()==0) {
                wfuserassistid = null;
            }
        }
        this.wfuserassistid = wfuserassistid;
        this.wfuserassistidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户代办标识]
     */
    public String getWFUserAssistId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserAssistId();
        }
        return this.wfuserassistid;
    }

    /**
     *  获取属性值[工作流用户代办标识]是否修改
     */
    public boolean isWFUserAssistIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserAssistIdDirty();
        }
        return this.wfuserassistidDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户代办标识]
     */
    public void resetWFUserAssistId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserAssistId();
            return;
        }

        this.wfuserassistidDirtyFlag = false;
        this.wfuserassistid = null;
    }
    /**
     *  设置属性值[工作流用户代办名称]
     *  @param wfuserassistname
     */
    public void setWFUserAssistName(String wfuserassistname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserAssistName(wfuserassistname);
            return;
        }
        if(wfuserassistname!=null) {
            wfuserassistname = StringHelper.trimRight(wfuserassistname);
            if(wfuserassistname.length()==0) {
                wfuserassistname = null;
            }
        }
        this.wfuserassistname = wfuserassistname;
        this.wfuserassistnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户代办名称]
     */
    public String getWFUserAssistName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserAssistName();
        }
        return this.wfuserassistname;
    }

    /**
     *  获取属性值[工作流用户代办名称]是否修改
     */
    public boolean isWFUserAssistNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserAssistNameDirty();
        }
        return this.wfuserassistnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户代办名称]
     */
    public void resetWFUserAssistName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserAssistName();
            return;
        }

        this.wfuserassistnameDirtyFlag = false;
        this.wfuserassistname = null;
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
        WFUserAssistBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUserAssistBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFMajorUserId();
        et.resetWFMajorUserName();
        et.resetWFMinorUserId();
        et.resetWFMinorUserName();
        et.resetWFStep();
        et.resetWFUserAssistId();
        et.resetWFUserAssistName();
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
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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
        if(!bDirtyOnly || isWFStepDirty()) {
            params.put(FIELD_WFSTEP,getWFStep());
        }
        if(!bDirtyOnly || isWFUserAssistIdDirty()) {
            params.put(FIELD_WFUSERASSISTID,getWFUserAssistId());
        }
        if(!bDirtyOnly || isWFUserAssistNameDirty()) {
            params.put(FIELD_WFUSERASSISTNAME,getWFUserAssistName());
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

        return  WFUserAssistBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUserAssistBase et,int index) throws Exception {

        switch(index) {
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
        case INDEX_WFMAJORUSERID:
            return et.getWFMajorUserId();
        case INDEX_WFMAJORUSERNAME:
            return et.getWFMajorUserName();
        case INDEX_WFMINORUSERID:
            return et.getWFMinorUserId();
        case INDEX_WFMINORUSERNAME:
            return et.getWFMinorUserName();
        case INDEX_WFSTEP:
            return et.getWFStep();
        case INDEX_WFUSERASSISTID:
            return et.getWFUserAssistId();
        case INDEX_WFUSERASSISTNAME:
            return et.getWFUserAssistName();
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

        WFUserAssistBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUserAssistBase et,int index,Object obj) throws Exception {
        switch(index) {
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
        case INDEX_WFSTEP:
            et.setWFStep(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERASSISTID:
            et.setWFUserAssistId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERASSISTNAME:
            et.setWFUserAssistName(DataObject.getStringValue(obj));
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

        return  WFUserAssistBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUserAssistBase et,int index) throws Exception {

        switch(index) {
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
        case INDEX_WFMAJORUSERID:
            return et.getWFMajorUserId()==null;
        case INDEX_WFMAJORUSERNAME:
            return et.getWFMajorUserName()==null;
        case INDEX_WFMINORUSERID:
            return et.getWFMinorUserId()==null;
        case INDEX_WFMINORUSERNAME:
            return et.getWFMinorUserName()==null;
        case INDEX_WFSTEP:
            return et.getWFStep()==null;
        case INDEX_WFUSERASSISTID:
            return et.getWFUserAssistId()==null;
        case INDEX_WFUSERASSISTNAME:
            return et.getWFUserAssistName()==null;
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
        return  WFUserAssistBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUserAssistBase et,int index) throws Exception {

        switch(index) {
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
        case INDEX_WFMAJORUSERID:
            return et.isWFMajorUserIdDirty();
        case INDEX_WFMAJORUSERNAME:
            return et.isWFMajorUserNameDirty();
        case INDEX_WFMINORUSERID:
            return et.isWFMinorUserIdDirty();
        case INDEX_WFMINORUSERNAME:
            return et.isWFMinorUserNameDirty();
        case INDEX_WFSTEP:
            return et.isWFStepDirty();
        case INDEX_WFUSERASSISTID:
            return et.isWFUserAssistIdDirty();
        case INDEX_WFUSERASSISTNAME:
            return et.isWFUserAssistNameDirty();
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
    private static  void fillJSONObject(WFUserAssistBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFStep()!=null) {
            JSONObjectHelper.put(json,"wfstep",getJSONValue(et.getWFStep()),false);
        }
        if(bIncEmpty||et.getWFUserAssistId()!=null) {
            JSONObjectHelper.put(json,"wfuserassistid",getJSONValue(et.getWFUserAssistId()),false);
        }
        if(bIncEmpty||et.getWFUserAssistName()!=null) {
            JSONObjectHelper.put(json,"wfuserassistname",getJSONValue(et.getWFUserAssistName()),false);
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
    private static void fillXmlNode(WFUserAssistBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFStep()!=null) {
            Object obj = et.getWFStep();
            node.setAttribute("WFSTEP",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserAssistId()!=null) {
            Object obj = et.getWFUserAssistId();
            node.setAttribute("WFUSERASSISTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserAssistName()!=null) {
            Object obj = et.getWFUserAssistName();
            node.setAttribute("WFUSERASSISTNAME",(obj==null)?"":(String)obj);
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
        WFUserAssistBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUserAssistBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isWFStepDirty() && (bIncEmpty||et.getWFStep()!=null)) {
            dst.set(FIELD_WFSTEP,et.getWFStep());
        }
        if(et.isWFUserAssistIdDirty() && (bIncEmpty||et.getWFUserAssistId()!=null)) {
            dst.set(FIELD_WFUSERASSISTID,et.getWFUserAssistId());
        }
        if(et.isWFUserAssistNameDirty() && (bIncEmpty||et.getWFUserAssistName()!=null)) {
            dst.set(FIELD_WFUSERASSISTNAME,et.getWFUserAssistName());
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
        return  WFUserAssistBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUserAssistBase et,int index) throws Exception {
        switch(index) {
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
        case INDEX_WFSTEP:
            et.resetWFStep();
            return true;
        case INDEX_WFUSERASSISTID:
            et.resetWFUserAssistId();
            return true;
        case INDEX_WFUSERASSISTNAME:
            et.resetWFUserAssistName();
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
    private WFUserAssistBase getProxyEntity() {
        return this.proxyWFUserAssistBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserAssistBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUserAssistBase) {
            this.proxyWFUserAssistBase = (WFUserAssistBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserAssistService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}