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
 * 实体[WFUIWizard] 数据对象基类
 */
public abstract class WFUIWizardBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUIWizardBase.class);
    /**
     * 属性[操作模式]
     */
    public final static String FIELD_ACTIONMODE = "ACTIONMODE";
    /**
     * 属性[操作参数]
     */
    public final static String FIELD_ACTIONPARAM = "ACTIONPARAM";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[操作数据信息]
     */
    public final static String FIELD_DATAINFO = "DATAINFO";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[调整步骤值]
     */
    public final static String FIELD_WFSTEPVALUE = "WFSTEPVALUE";
    /**
     * 属性[工作流操作界面标识]
     */
    public final static String FIELD_WFUIWIZARDID = "WFUIWIZARDID";
    /**
     * 属性[工作流操作界面名称]
     */
    public final static String FIELD_WFUIWIZARDNAME = "WFUIWIZARDNAME";

    private final static int INDEX_ACTIONMODE = 0;
    private final static int INDEX_ACTIONPARAM = 1;
    private final static int INDEX_CREATEDATE = 2;
    private final static int INDEX_CREATEMAN = 3;
    private final static int INDEX_DATAINFO = 4;
    private final static int INDEX_UPDATEDATE = 5;
    private final static int INDEX_UPDATEMAN = 6;
    private final static int INDEX_WFSTEPVALUE = 7;
    private final static int INDEX_WFUIWIZARDID = 8;
    private final static int INDEX_WFUIWIZARDNAME = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTIONMODE, INDEX_ACTIONMODE);
        fieldIndexMap.put( FIELD_ACTIONPARAM, INDEX_ACTIONPARAM);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATAINFO, INDEX_DATAINFO);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFSTEPVALUE, INDEX_WFSTEPVALUE);
        fieldIndexMap.put( FIELD_WFUIWIZARDID, INDEX_WFUIWIZARDID);
        fieldIndexMap.put( FIELD_WFUIWIZARDNAME, INDEX_WFUIWIZARDNAME);
    }

    private WFUIWizardBase proxyWFUIWizardBase = null;
    public WFUIWizardBase() {
        super();
    }
    private boolean actionmodeDirtyFlag = false;
    private boolean actionparamDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datainfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfstepvalueDirtyFlag = false;
    private boolean wfuiwizardidDirtyFlag = false;
    private boolean wfuiwizardnameDirtyFlag = false;

    @Column(name="actionmode")
    private String actionmode;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datainfo")
    private String datainfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfstepvalue")
    private String wfstepvalue;
    @Column(name="wfuiwizardid")
    private String wfuiwizardid;
    @Column(name="wfuiwizardname")
    private String wfuiwizardname;


    /**
     *  设置属性值[操作模式]
     *  @param actionmode
     */
    public void setActionMode(String actionmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionMode(actionmode);
            return;
        }
        if(actionmode!=null) {
            actionmode = StringHelper.trimRight(actionmode);
            if(actionmode.length()==0) {
                actionmode = null;
            }
        }
        this.actionmode = actionmode;
        this.actionmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作模式]
     */
    public String getActionMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionMode();
        }
        return this.actionmode;
    }

    /**
     *  获取属性值[操作模式]是否修改
     */
    public boolean isActionModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionModeDirty();
        }
        return this.actionmodeDirtyFlag;
    }

    /**
     *  重置属性值[操作模式]
     */
    public void resetActionMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionMode();
            return;
        }

        this.actionmodeDirtyFlag = false;
        this.actionmode = null;
    }
    /**
     *  设置属性值[操作参数]
     *  @param actionparam
     */
    public void setActionParam(String actionparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionParam(actionparam);
            return;
        }
        if(actionparam!=null) {
            actionparam = StringHelper.trimRight(actionparam);
            if(actionparam.length()==0) {
                actionparam = null;
            }
        }
        this.actionparam = actionparam;
        this.actionparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作参数]
     */
    public String getActionParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    /**
     *  获取属性值[操作参数]是否修改
     */
    public boolean isActionParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    /**
     *  重置属性值[操作参数]
     */
    public void resetActionParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionParam();
            return;
        }

        this.actionparamDirtyFlag = false;
        this.actionparam = null;
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
     *  设置属性值[操作数据信息]
     *  @param datainfo
     */
    public void setDataInfo(String datainfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataInfo(datainfo);
            return;
        }
        if(datainfo!=null) {
            datainfo = StringHelper.trimRight(datainfo);
            if(datainfo.length()==0) {
                datainfo = null;
            }
        }
        this.datainfo = datainfo;
        this.datainfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作数据信息]
     */
    public String getDataInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataInfo();
        }
        return this.datainfo;
    }

    /**
     *  获取属性值[操作数据信息]是否修改
     */
    public boolean isDataInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataInfoDirty();
        }
        return this.datainfoDirtyFlag;
    }

    /**
     *  重置属性值[操作数据信息]
     */
    public void resetDataInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataInfo();
            return;
        }

        this.datainfoDirtyFlag = false;
        this.datainfo = null;
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
     *  设置属性值[调整步骤值]代码表：net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel
     *  @param wfstepvalue
     */
    public void setWFStepValue(String wfstepvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepValue(wfstepvalue);
            return;
        }
        if(wfstepvalue!=null) {
            wfstepvalue = StringHelper.trimRight(wfstepvalue);
            if(wfstepvalue.length()==0) {
                wfstepvalue = null;
            }
        }
        this.wfstepvalue = wfstepvalue;
        this.wfstepvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[调整步骤值]代码表：net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel
     */
    public String getWFStepValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepValue();
        }
        return this.wfstepvalue;
    }

    /**
     *  获取属性值[调整步骤值]是否修改
     */
    public boolean isWFStepValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepValueDirty();
        }
        return this.wfstepvalueDirtyFlag;
    }

    /**
     *  重置属性值[调整步骤值]
     */
    public void resetWFStepValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepValue();
            return;
        }

        this.wfstepvalueDirtyFlag = false;
        this.wfstepvalue = null;
    }
    /**
     *  设置属性值[工作流操作界面标识]
     *  @param wfuiwizardid
     */
    public void setWFUIWizardId(String wfuiwizardid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUIWizardId(wfuiwizardid);
            return;
        }
        if(wfuiwizardid!=null) {
            wfuiwizardid = StringHelper.trimRight(wfuiwizardid);
            if(wfuiwizardid.length()==0) {
                wfuiwizardid = null;
            }
        }
        this.wfuiwizardid = wfuiwizardid;
        this.wfuiwizardidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流操作界面标识]
     */
    public String getWFUIWizardId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUIWizardId();
        }
        return this.wfuiwizardid;
    }

    /**
     *  获取属性值[工作流操作界面标识]是否修改
     */
    public boolean isWFUIWizardIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUIWizardIdDirty();
        }
        return this.wfuiwizardidDirtyFlag;
    }

    /**
     *  重置属性值[工作流操作界面标识]
     */
    public void resetWFUIWizardId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUIWizardId();
            return;
        }

        this.wfuiwizardidDirtyFlag = false;
        this.wfuiwizardid = null;
    }
    /**
     *  设置属性值[工作流操作界面名称]
     *  @param wfuiwizardname
     */
    public void setWFUIWizardName(String wfuiwizardname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUIWizardName(wfuiwizardname);
            return;
        }
        if(wfuiwizardname!=null) {
            wfuiwizardname = StringHelper.trimRight(wfuiwizardname);
            if(wfuiwizardname.length()==0) {
                wfuiwizardname = null;
            }
        }
        this.wfuiwizardname = wfuiwizardname;
        this.wfuiwizardnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流操作界面名称]
     */
    public String getWFUIWizardName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUIWizardName();
        }
        return this.wfuiwizardname;
    }

    /**
     *  获取属性值[工作流操作界面名称]是否修改
     */
    public boolean isWFUIWizardNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUIWizardNameDirty();
        }
        return this.wfuiwizardnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流操作界面名称]
     */
    public void resetWFUIWizardName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUIWizardName();
            return;
        }

        this.wfuiwizardnameDirtyFlag = false;
        this.wfuiwizardname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFUIWizardBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUIWizardBase et) {
        et.resetActionMode();
        et.resetActionParam();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataInfo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFStepValue();
        et.resetWFUIWizardId();
        et.resetWFUIWizardName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActionModeDirty()) {
            params.put(FIELD_ACTIONMODE,getActionMode());
        }
        if(!bDirtyOnly || isActionParamDirty()) {
            params.put(FIELD_ACTIONPARAM,getActionParam());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDataInfoDirty()) {
            params.put(FIELD_DATAINFO,getDataInfo());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFStepValueDirty()) {
            params.put(FIELD_WFSTEPVALUE,getWFStepValue());
        }
        if(!bDirtyOnly || isWFUIWizardIdDirty()) {
            params.put(FIELD_WFUIWIZARDID,getWFUIWizardId());
        }
        if(!bDirtyOnly || isWFUIWizardNameDirty()) {
            params.put(FIELD_WFUIWIZARDNAME,getWFUIWizardName());
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

        return  WFUIWizardBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUIWizardBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONMODE:
            return et.getActionMode();
        case INDEX_ACTIONPARAM:
            return et.getActionParam();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATAINFO:
            return et.getDataInfo();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFSTEPVALUE:
            return et.getWFStepValue();
        case INDEX_WFUIWIZARDID:
            return et.getWFUIWizardId();
        case INDEX_WFUIWIZARDNAME:
            return et.getWFUIWizardName();
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

        WFUIWizardBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUIWizardBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTIONMODE:
            et.setActionMode(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTIONPARAM:
            et.setActionParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAINFO:
            et.setDataInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPVALUE:
            et.setWFStepValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUIWIZARDID:
            et.setWFUIWizardId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUIWIZARDNAME:
            et.setWFUIWizardName(DataObject.getStringValue(obj));
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

        return  WFUIWizardBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUIWizardBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONMODE:
            return et.getActionMode()==null;
        case INDEX_ACTIONPARAM:
            return et.getActionParam()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATAINFO:
            return et.getDataInfo()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFSTEPVALUE:
            return et.getWFStepValue()==null;
        case INDEX_WFUIWIZARDID:
            return et.getWFUIWizardId()==null;
        case INDEX_WFUIWIZARDNAME:
            return et.getWFUIWizardName()==null;
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
        return  WFUIWizardBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUIWizardBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONMODE:
            return et.isActionModeDirty();
        case INDEX_ACTIONPARAM:
            return et.isActionParamDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATAINFO:
            return et.isDataInfoDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFSTEPVALUE:
            return et.isWFStepValueDirty();
        case INDEX_WFUIWIZARDID:
            return et.isWFUIWizardIdDirty();
        case INDEX_WFUIWIZARDNAME:
            return et.isWFUIWizardNameDirty();
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
    private static  void fillJSONObject(WFUIWizardBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionMode()!=null) {
            JSONObjectHelper.put(json,"actionmode",getJSONValue(et.getActionMode()),false);
        }
        if(bIncEmpty||et.getActionParam()!=null) {
            JSONObjectHelper.put(json,"actionparam",getJSONValue(et.getActionParam()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataInfo()!=null) {
            JSONObjectHelper.put(json,"datainfo",getJSONValue(et.getDataInfo()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFStepValue()!=null) {
            JSONObjectHelper.put(json,"wfstepvalue",getJSONValue(et.getWFStepValue()),false);
        }
        if(bIncEmpty||et.getWFUIWizardId()!=null) {
            JSONObjectHelper.put(json,"wfuiwizardid",getJSONValue(et.getWFUIWizardId()),false);
        }
        if(bIncEmpty||et.getWFUIWizardName()!=null) {
            JSONObjectHelper.put(json,"wfuiwizardname",getJSONValue(et.getWFUIWizardName()),false);
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
    private static void fillXmlNode(WFUIWizardBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionMode()!=null) {
            Object obj = et.getActionMode();
            node.setAttribute("ACTIONMODE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActionParam()!=null) {
            Object obj = et.getActionParam();
            node.setAttribute("ACTIONPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataInfo()!=null) {
            Object obj = et.getDataInfo();
            node.setAttribute("DATAINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepValue()!=null) {
            Object obj = et.getWFStepValue();
            node.setAttribute("WFSTEPVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUIWizardId()!=null) {
            Object obj = et.getWFUIWizardId();
            node.setAttribute("WFUIWIZARDID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUIWizardName()!=null) {
            Object obj = et.getWFUIWizardName();
            node.setAttribute("WFUIWIZARDNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUIWizardBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUIWizardBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActionModeDirty() && (bIncEmpty||et.getActionMode()!=null)) {
            dst.set(FIELD_ACTIONMODE,et.getActionMode());
        }
        if(et.isActionParamDirty() && (bIncEmpty||et.getActionParam()!=null)) {
            dst.set(FIELD_ACTIONPARAM,et.getActionParam());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataInfoDirty() && (bIncEmpty||et.getDataInfo()!=null)) {
            dst.set(FIELD_DATAINFO,et.getDataInfo());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFStepValueDirty() && (bIncEmpty||et.getWFStepValue()!=null)) {
            dst.set(FIELD_WFSTEPVALUE,et.getWFStepValue());
        }
        if(et.isWFUIWizardIdDirty() && (bIncEmpty||et.getWFUIWizardId()!=null)) {
            dst.set(FIELD_WFUIWIZARDID,et.getWFUIWizardId());
        }
        if(et.isWFUIWizardNameDirty() && (bIncEmpty||et.getWFUIWizardName()!=null)) {
            dst.set(FIELD_WFUIWIZARDNAME,et.getWFUIWizardName());
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
        return  WFUIWizardBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUIWizardBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTIONMODE:
            et.resetActionMode();
            return true;
        case INDEX_ACTIONPARAM:
            et.resetActionParam();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATAINFO:
            et.resetDataInfo();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFSTEPVALUE:
            et.resetWFStepValue();
            return true;
        case INDEX_WFUIWIZARDID:
            et.resetWFUIWizardId();
            return true;
        case INDEX_WFUIWIZARDNAME:
            et.resetWFUIWizardName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private WFUIWizardBase getProxyEntity() {
        return this.proxyWFUIWizardBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUIWizardBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUIWizardBase) {
            this.proxyWFUIWizardBase = (WFUIWizardBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUIWizardService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}