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
 * 实体[WFStepInst] 数据对象基类
 */
public abstract class WFStepInstBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepInstBase.class);
    /**
     * 属性[实例关闭标志]
     */
    public final static String FIELD_CLOSEFLAG = "CLOSEFLAG";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[流程返回值]
     */
    public final static String FIELD_RETURNDATA = "RETURNDATA";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[子流程实例]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[子流程实例]
     */
    public final static String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    /**
     * 属性[工作流步骤]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[工作流步骤子实例标识]
     */
    public final static String FIELD_WFSTEPINSTID = "WFSTEPINSTID";
    /**
     * 属性[工作流步骤子实例名称]
     */
    public final static String FIELD_WFSTEPINSTNAME = "WFSTEPINSTNAME";
    /**
     * 属性[步骤语言资源]
     */
    public final static String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    /**
     * 属性[工作流步骤]
     */
    public final static String FIELD_WFSTEPNAME = "WFSTEPNAME";

    private final static int INDEX_CLOSEFLAG = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_RETURNDATA = 3;
    private final static int INDEX_UPDATEDATE = 4;
    private final static int INDEX_UPDATEMAN = 5;
    private final static int INDEX_WFINSTANCEID = 6;
    private final static int INDEX_WFINSTANCENAME = 7;
    private final static int INDEX_WFSTEPID = 8;
    private final static int INDEX_WFSTEPINSTID = 9;
    private final static int INDEX_WFSTEPINSTNAME = 10;
    private final static int INDEX_WFSTEPLANRESTAG = 11;
    private final static int INDEX_WFSTEPNAME = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CLOSEFLAG, INDEX_CLOSEFLAG);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_RETURNDATA, INDEX_RETURNDATA);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFINSTANCENAME, INDEX_WFINSTANCENAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFSTEPINSTID, INDEX_WFSTEPINSTID);
        fieldIndexMap.put( FIELD_WFSTEPINSTNAME, INDEX_WFSTEPINSTNAME);
        fieldIndexMap.put( FIELD_WFSTEPLANRESTAG, INDEX_WFSTEPLANRESTAG);
        fieldIndexMap.put( FIELD_WFSTEPNAME, INDEX_WFSTEPNAME);
    }

    private WFStepInstBase proxyWFStepInstBase = null;
    public WFStepInstBase() {
        super();
    }
    private boolean closeflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean returndataDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfstepinstidDirtyFlag = false;
    private boolean wfstepinstnameDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;

    @Column(name="closeflag")
    private Integer closeflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="returndata")
    private String returndata;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfstepinstid")
    private String wfstepinstid;
    @Column(name="wfstepinstname")
    private String wfstepinstname;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;


    /**
     *  设置属性值[实例关闭标志]
     *  @param closeflag
     */
    public void setCloseFlag(Integer closeflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCloseFlag(closeflag);
            return;
        }
        this.closeflag = closeflag;
        this.closeflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[实例关闭标志]
     */
    public Integer getCloseFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCloseFlag();
        }
        return this.closeflag;
    }

    /**
     *  获取属性值[实例关闭标志]是否修改
     */
    public boolean isCloseFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCloseFlagDirty();
        }
        return this.closeflagDirtyFlag;
    }

    /**
     *  重置属性值[实例关闭标志]
     */
    public void resetCloseFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCloseFlag();
            return;
        }

        this.closeflagDirtyFlag = false;
        this.closeflag = null;
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
     *  设置属性值[流程返回值]
     *  @param returndata
     */
    public void setReturnData(String returndata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReturnData(returndata);
            return;
        }
        if(returndata!=null) {
            returndata = StringHelper.trimRight(returndata);
            if(returndata.length()==0) {
                returndata = null;
            }
        }
        this.returndata = returndata;
        this.returndataDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程返回值]
     */
    public String getReturnData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReturnData();
        }
        return this.returndata;
    }

    /**
     *  获取属性值[流程返回值]是否修改
     */
    public boolean isReturnDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReturnDataDirty();
        }
        return this.returndataDirtyFlag;
    }

    /**
     *  重置属性值[流程返回值]
     */
    public void resetReturnData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReturnData();
            return;
        }

        this.returndataDirtyFlag = false;
        this.returndata = null;
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
     *  设置属性值[子流程实例]
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
     *  获取属性值[子流程实例]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[子流程实例]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[子流程实例]
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
     *  设置属性值[子流程实例]
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
     *  获取属性值[子流程实例]
     */
    public String getWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    /**
     *  获取属性值[子流程实例]是否修改
     */
    public boolean isWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[子流程实例]
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
     *  设置属性值[工作流步骤]
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
     *  获取属性值[工作流步骤]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[工作流步骤]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤]
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
     *  设置属性值[工作流步骤子实例标识]
     *  @param wfstepinstid
     */
    public void setWFStepInstId(String wfstepinstid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepInstId(wfstepinstid);
            return;
        }
        if(wfstepinstid!=null) {
            wfstepinstid = StringHelper.trimRight(wfstepinstid);
            if(wfstepinstid.length()==0) {
                wfstepinstid = null;
            }
        }
        this.wfstepinstid = wfstepinstid;
        this.wfstepinstidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤子实例标识]
     */
    public String getWFStepInstId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepInstId();
        }
        return this.wfstepinstid;
    }

    /**
     *  获取属性值[工作流步骤子实例标识]是否修改
     */
    public boolean isWFStepInstIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepInstIdDirty();
        }
        return this.wfstepinstidDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤子实例标识]
     */
    public void resetWFStepInstId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepInstId();
            return;
        }

        this.wfstepinstidDirtyFlag = false;
        this.wfstepinstid = null;
    }
    /**
     *  设置属性值[工作流步骤子实例名称]
     *  @param wfstepinstname
     */
    public void setWFStepInstName(String wfstepinstname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepInstName(wfstepinstname);
            return;
        }
        if(wfstepinstname!=null) {
            wfstepinstname = StringHelper.trimRight(wfstepinstname);
            if(wfstepinstname.length()==0) {
                wfstepinstname = null;
            }
        }
        this.wfstepinstname = wfstepinstname;
        this.wfstepinstnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤子实例名称]
     */
    public String getWFStepInstName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepInstName();
        }
        return this.wfstepinstname;
    }

    /**
     *  获取属性值[工作流步骤子实例名称]是否修改
     */
    public boolean isWFStepInstNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepInstNameDirty();
        }
        return this.wfstepinstnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤子实例名称]
     */
    public void resetWFStepInstName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepInstName();
            return;
        }

        this.wfstepinstnameDirtyFlag = false;
        this.wfstepinstname = null;
    }
    /**
     *  设置属性值[步骤语言资源]
     *  @param wfsteplanrestag
     */
    public void setWFStepLanResTag(String wfsteplanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if(wfsteplanrestag!=null) {
            wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag);
            if(wfsteplanrestag.length()==0) {
                wfsteplanrestag = null;
            }
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤语言资源]
     */
    public String getWFStepLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    /**
     *  获取属性值[步骤语言资源]是否修改
     */
    public boolean isWFStepLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    /**
     *  重置属性值[步骤语言资源]
     */
    public void resetWFStepLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }

        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }
    /**
     *  设置属性值[工作流步骤]
     *  @param wfstepname
     */
    public void setWFStepName(String wfstepname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if(wfstepname!=null) {
            wfstepname = StringHelper.trimRight(wfstepname);
            if(wfstepname.length()==0) {
                wfstepname = null;
            }
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤]
     */
    public String getWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    /**
     *  获取属性值[工作流步骤]是否修改
     */
    public boolean isWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤]
     */
    public void resetWFStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }

        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFStepInstBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFStepInstBase et) {
        et.resetCloseFlag();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReturnData();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFStepId();
        et.resetWFStepInstId();
        et.resetWFStepInstName();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCloseFlagDirty()) {
            params.put(FIELD_CLOSEFLAG,getCloseFlag());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isReturnDataDirty()) {
            params.put(FIELD_RETURNDATA,getReturnData());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID,getWFInstanceId());
        }
        if(!bDirtyOnly || isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME,getWFInstanceName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
        }
        if(!bDirtyOnly || isWFStepInstIdDirty()) {
            params.put(FIELD_WFSTEPINSTID,getWFStepInstId());
        }
        if(!bDirtyOnly || isWFStepInstNameDirty()) {
            params.put(FIELD_WFSTEPINSTNAME,getWFStepInstName());
        }
        if(!bDirtyOnly || isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG,getWFStepLanResTag());
        }
        if(!bDirtyOnly || isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME,getWFStepName());
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

        return  WFStepInstBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFStepInstBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLOSEFLAG:
            return et.getCloseFlag();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_RETURNDATA:
            return et.getReturnData();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
        case INDEX_WFSTEPINSTID:
            return et.getWFStepInstId();
        case INDEX_WFSTEPINSTNAME:
            return et.getWFStepInstName();
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag();
        case INDEX_WFSTEPNAME:
            return et.getWFStepName();
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

        WFStepInstBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFStepInstBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CLOSEFLAG:
            et.setCloseFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_RETURNDATA:
            et.setReturnData(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCEID:
            et.setWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCENAME:
            et.setWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPINSTID:
            et.setWFStepInstId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPINSTNAME:
            et.setWFStepInstName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPLANRESTAG:
            et.setWFStepLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPNAME:
            et.setWFStepName(DataObject.getStringValue(obj));
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

        return  WFStepInstBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFStepInstBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLOSEFLAG:
            return et.getCloseFlag()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_RETURNDATA:
            return et.getReturnData()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
        case INDEX_WFSTEPINSTID:
            return et.getWFStepInstId()==null;
        case INDEX_WFSTEPINSTNAME:
            return et.getWFStepInstName()==null;
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag()==null;
        case INDEX_WFSTEPNAME:
            return et.getWFStepName()==null;
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
        return  WFStepInstBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFStepInstBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLOSEFLAG:
            return et.isCloseFlagDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_RETURNDATA:
            return et.isReturnDataDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFINSTANCENAME:
            return et.isWFInstanceNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
        case INDEX_WFSTEPINSTID:
            return et.isWFStepInstIdDirty();
        case INDEX_WFSTEPINSTNAME:
            return et.isWFStepInstNameDirty();
        case INDEX_WFSTEPLANRESTAG:
            return et.isWFStepLanResTagDirty();
        case INDEX_WFSTEPNAME:
            return et.isWFStepNameDirty();
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
    private static  void fillJSONObject(WFStepInstBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCloseFlag()!=null) {
            JSONObjectHelper.put(json,"closeflag",getJSONValue(et.getCloseFlag()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getReturnData()!=null) {
            JSONObjectHelper.put(json,"returndata",getJSONValue(et.getReturnData()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"wfinstanceid",getJSONValue(et.getWFInstanceId()),false);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"wfinstancename",getJSONValue(et.getWFInstanceName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
        }
        if(bIncEmpty||et.getWFStepInstId()!=null) {
            JSONObjectHelper.put(json,"wfstepinstid",getJSONValue(et.getWFStepInstId()),false);
        }
        if(bIncEmpty||et.getWFStepInstName()!=null) {
            JSONObjectHelper.put(json,"wfstepinstname",getJSONValue(et.getWFStepInstName()),false);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            JSONObjectHelper.put(json,"wfsteplanrestag",getJSONValue(et.getWFStepLanResTag()),false);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            JSONObjectHelper.put(json,"wfstepname",getJSONValue(et.getWFStepName()),false);
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
    private static void fillXmlNode(WFStepInstBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCloseFlag()!=null) {
            Object obj = et.getCloseFlag();
            node.setAttribute("CLOSEFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReturnData()!=null) {
            Object obj = et.getReturnData();
            node.setAttribute("RETURNDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            Object obj = et.getWFInstanceId();
            node.setAttribute("WFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            Object obj = et.getWFInstanceName();
            node.setAttribute("WFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepInstId()!=null) {
            Object obj = et.getWFStepInstId();
            node.setAttribute("WFSTEPINSTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepInstName()!=null) {
            Object obj = et.getWFStepInstName();
            node.setAttribute("WFSTEPINSTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            Object obj = et.getWFStepLanResTag();
            node.setAttribute("WFSTEPLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            Object obj = et.getWFStepName();
            node.setAttribute("WFSTEPNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepInstBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFStepInstBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCloseFlagDirty() && (bIncEmpty||et.getCloseFlag()!=null)) {
            dst.set(FIELD_CLOSEFLAG,et.getCloseFlag());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isReturnDataDirty() && (bIncEmpty||et.getReturnData()!=null)) {
            dst.set(FIELD_RETURNDATA,et.getReturnData());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFInstanceIdDirty() && (bIncEmpty||et.getWFInstanceId()!=null)) {
            dst.set(FIELD_WFINSTANCEID,et.getWFInstanceId());
        }
        if(et.isWFInstanceNameDirty() && (bIncEmpty||et.getWFInstanceName()!=null)) {
            dst.set(FIELD_WFINSTANCENAME,et.getWFInstanceName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
        }
        if(et.isWFStepInstIdDirty() && (bIncEmpty||et.getWFStepInstId()!=null)) {
            dst.set(FIELD_WFSTEPINSTID,et.getWFStepInstId());
        }
        if(et.isWFStepInstNameDirty() && (bIncEmpty||et.getWFStepInstName()!=null)) {
            dst.set(FIELD_WFSTEPINSTNAME,et.getWFStepInstName());
        }
        if(et.isWFStepLanResTagDirty() && (bIncEmpty||et.getWFStepLanResTag()!=null)) {
            dst.set(FIELD_WFSTEPLANRESTAG,et.getWFStepLanResTag());
        }
        if(et.isWFStepNameDirty() && (bIncEmpty||et.getWFStepName()!=null)) {
            dst.set(FIELD_WFSTEPNAME,et.getWFStepName());
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
        return  WFStepInstBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFStepInstBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CLOSEFLAG:
            et.resetCloseFlag();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_RETURNDATA:
            et.resetReturnData();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFINSTANCEID:
            et.resetWFInstanceId();
            return true;
        case INDEX_WFINSTANCENAME:
            et.resetWFInstanceName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
            return true;
        case INDEX_WFSTEPINSTID:
            et.resetWFStepInstId();
            return true;
        case INDEX_WFSTEPINSTNAME:
            et.resetWFStepInstName();
            return true;
        case INDEX_WFSTEPLANRESTAG:
            et.resetWFStepLanResTag();
            return true;
        case INDEX_WFSTEPNAME:
            et.resetWFStepName();
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

    private Integer objWfstepLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = null;
    /**
    * 获取父数据 工作流步骤
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStep getWfstep() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWfstep();
        }

        if(this.getWFStepId()==null)
            return null;
        synchronized(this.objWfstepLock) {
            if(this.wfstep!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFStepId(),wfstep.getWFStepId())!=0) {
                    this.wfstep = null;
                }
            }


            if(this.wfstep==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = new net.ibizsys.psrt.srv.wf.entity.WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                net.ibizsys.psrt.srv.wf.service.WFStepService service = (net.ibizsys.psrt.srv.wf.service.WFStepService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepService.class,this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFStepInstBase getProxyEntity() {
        return this.proxyWFStepInstBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepInstBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFStepInstBase) {
            this.proxyWFStepInstBase = (WFStepInstBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepInstService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}