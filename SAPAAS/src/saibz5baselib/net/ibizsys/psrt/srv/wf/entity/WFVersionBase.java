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
 * 实体[WFVersion] 数据对象基类
 */
public abstract class WFVersionBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFVersionBase.class);
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
     * 属性[配置]
     */
    public final static String FIELD_WFMODEL = "WFMODEL";
    /**
     * 属性[流程版本语言资源]
     */
    public final static String FIELD_WFVERLANRESTAG = "WFVERLANRESTAG";
    /**
     * 属性[版本]
     */
    public final static String FIELD_WFVERSION = "WFVERSION";
    /**
     * 属性[工作流配置]
     */
    public final static String FIELD_WFWFID = "WFWFID";
    /**
     * 属性[工作流配置]
     */
    public final static String FIELD_WFWFNAME = "WFWFNAME";
    /**
     * 属性[工作流配置版本标识]
     */
    public final static String FIELD_WFVERSIONID = "WFWFVERSIONID";
    /**
     * 属性[工作流配置版本名称]
     */
    public final static String FIELD_WFVERSIONNAME = "WFWFVERSIONNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_UPDATEDATE = 2;
    private final static int INDEX_UPDATEMAN = 3;
    private final static int INDEX_WFMODEL = 4;
    private final static int INDEX_WFVERLANRESTAG = 5;
    private final static int INDEX_WFVERSION = 6;
    private final static int INDEX_WFWFID = 7;
    private final static int INDEX_WFWFNAME = 8;
    private final static int INDEX_WFVERSIONID = 9;
    private final static int INDEX_WFVERSIONNAME = 10;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFMODEL, INDEX_WFMODEL);
        fieldIndexMap.put( FIELD_WFVERLANRESTAG, INDEX_WFVERLANRESTAG);
        fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
        fieldIndexMap.put( FIELD_WFWFID, INDEX_WFWFID);
        fieldIndexMap.put( FIELD_WFWFNAME, INDEX_WFWFNAME);
        fieldIndexMap.put( FIELD_WFVERSIONID, INDEX_WFVERSIONID);
        fieldIndexMap.put( FIELD_WFVERSIONNAME, INDEX_WFVERSIONNAME);
    }

    private WFVersionBase proxyWFVersionBase = null;
    public WFVersionBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfmodelDirtyFlag = false;
    private boolean wfverlanrestagDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    private boolean wfwfidDirtyFlag = false;
    private boolean wfwfnameDirtyFlag = false;
    private boolean wfversionidDirtyFlag = false;
    private boolean wfversionnameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfmodel")
    private String wfmodel;
    @Column(name="wfverlanrestag")
    private String wfverlanrestag;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="wfwfid")
    private String wfwfid;
    @Column(name="wfwfname")
    private String wfwfname;
    @Column(name="wfversionid")
    private String wfversionid;
    @Column(name="wfversionname")
    private String wfversionname;


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
     *  设置属性值[流程版本语言资源]
     *  @param wfverlanrestag
     */
    public void setWFVerLanResTag(String wfverlanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFVerLanResTag(wfverlanrestag);
            return;
        }
        if(wfverlanrestag!=null) {
            wfverlanrestag = StringHelper.trimRight(wfverlanrestag);
            if(wfverlanrestag.length()==0) {
                wfverlanrestag = null;
            }
        }
        this.wfverlanrestag = wfverlanrestag;
        this.wfverlanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程版本语言资源]
     */
    public String getWFVerLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVerLanResTag();
        }
        return this.wfverlanrestag;
    }

    /**
     *  获取属性值[流程版本语言资源]是否修改
     */
    public boolean isWFVerLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVerLanResTagDirty();
        }
        return this.wfverlanrestagDirtyFlag;
    }

    /**
     *  重置属性值[流程版本语言资源]
     */
    public void resetWFVerLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVerLanResTag();
            return;
        }

        this.wfverlanrestagDirtyFlag = false;
        this.wfverlanrestag = null;
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
     *  设置属性值[工作流配置]
     *  @param wfwfid
     */
    public void setWFWFId(String wfwfid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWFId(wfwfid);
            return;
        }
        if(wfwfid!=null) {
            wfwfid = StringHelper.trimRight(wfwfid);
            if(wfwfid.length()==0) {
                wfwfid = null;
            }
        }
        this.wfwfid = wfwfid;
        this.wfwfidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置]
     */
    public String getWFWFId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWFId();
        }
        return this.wfwfid;
    }

    /**
     *  获取属性值[工作流配置]是否修改
     */
    public boolean isWFWFIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWFIdDirty();
        }
        return this.wfwfidDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置]
     */
    public void resetWFWFId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWFId();
            return;
        }

        this.wfwfidDirtyFlag = false;
        this.wfwfid = null;
    }
    /**
     *  设置属性值[工作流配置]
     *  @param wfwfname
     */
    public void setWFWFName(String wfwfname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWFName(wfwfname);
            return;
        }
        if(wfwfname!=null) {
            wfwfname = StringHelper.trimRight(wfwfname);
            if(wfwfname.length()==0) {
                wfwfname = null;
            }
        }
        this.wfwfname = wfwfname;
        this.wfwfnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置]
     */
    public String getWFWFName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWFName();
        }
        return this.wfwfname;
    }

    /**
     *  获取属性值[工作流配置]是否修改
     */
    public boolean isWFWFNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWFNameDirty();
        }
        return this.wfwfnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置]
     */
    public void resetWFWFName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWFName();
            return;
        }

        this.wfwfnameDirtyFlag = false;
        this.wfwfname = null;
    }
    /**
     *  设置属性值[工作流配置版本标识]
     *  @param wfversionid
     */
    public void setWFVersionId(String wfversionid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFVersionId(wfversionid);
            return;
        }
        if(wfversionid!=null) {
            wfversionid = StringHelper.trimRight(wfversionid);
            if(wfversionid.length()==0) {
                wfversionid = null;
            }
        }
        this.wfversionid = wfversionid;
        this.wfversionidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置版本标识]
     */
    public String getWFVersionId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVersionId();
        }
        return this.wfversionid;
    }

    /**
     *  获取属性值[工作流配置版本标识]是否修改
     */
    public boolean isWFVersionIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVersionIdDirty();
        }
        return this.wfversionidDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置版本标识]
     */
    public void resetWFVersionId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVersionId();
            return;
        }

        this.wfversionidDirtyFlag = false;
        this.wfversionid = null;
    }
    /**
     *  设置属性值[工作流配置版本名称]
     *  @param wfversionname
     */
    public void setWFVersionName(String wfversionname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFVersionName(wfversionname);
            return;
        }
        if(wfversionname!=null) {
            wfversionname = StringHelper.trimRight(wfversionname);
            if(wfversionname.length()==0) {
                wfversionname = null;
            }
        }
        this.wfversionname = wfversionname;
        this.wfversionnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流配置版本名称]
     */
    public String getWFVersionName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVersionName();
        }
        return this.wfversionname;
    }

    /**
     *  获取属性值[工作流配置版本名称]是否修改
     */
    public boolean isWFVersionNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVersionNameDirty();
        }
        return this.wfversionnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流配置版本名称]
     */
    public void resetWFVersionName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVersionName();
            return;
        }

        this.wfversionnameDirtyFlag = false;
        this.wfversionname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFVersionBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFVersionBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFModel();
        et.resetWFVerLanResTag();
        et.resetWFVersion();
        et.resetWFWFId();
        et.resetWFWFName();
        et.resetWFVersionId();
        et.resetWFVersionName();
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
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFModelDirty()) {
            params.put(FIELD_WFMODEL,getWFModel());
        }
        if(!bDirtyOnly || isWFVerLanResTagDirty()) {
            params.put(FIELD_WFVERLANRESTAG,getWFVerLanResTag());
        }
        if(!bDirtyOnly || isWFVersionDirty()) {
            params.put(FIELD_WFVERSION,getWFVersion());
        }
        if(!bDirtyOnly || isWFWFIdDirty()) {
            params.put(FIELD_WFWFID,getWFWFId());
        }
        if(!bDirtyOnly || isWFWFNameDirty()) {
            params.put(FIELD_WFWFNAME,getWFWFName());
        }
        if(!bDirtyOnly || isWFVersionIdDirty()) {
            params.put(FIELD_WFVERSIONID,getWFVersionId());
        }
        if(!bDirtyOnly || isWFVersionNameDirty()) {
            params.put(FIELD_WFVERSIONNAME,getWFVersionName());
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

        return  WFVersionBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFVersionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFMODEL:
            return et.getWFModel();
        case INDEX_WFVERLANRESTAG:
            return et.getWFVerLanResTag();
        case INDEX_WFVERSION:
            return et.getWFVersion();
        case INDEX_WFWFID:
            return et.getWFWFId();
        case INDEX_WFWFNAME:
            return et.getWFWFName();
        case INDEX_WFVERSIONID:
            return et.getWFVersionId();
        case INDEX_WFVERSIONNAME:
            return et.getWFVersionName();
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

        WFVersionBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFVersionBase et,int index,Object obj) throws Exception {
        switch(index) {
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
        case INDEX_WFMODEL:
            et.setWFModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERLANRESTAG:
            et.setWFVerLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSION:
            et.setWFVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WFWFID:
            et.setWFWFId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFWFNAME:
            et.setWFWFName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSIONID:
            et.setWFVersionId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSIONNAME:
            et.setWFVersionName(DataObject.getStringValue(obj));
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

        return  WFVersionBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFVersionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFMODEL:
            return et.getWFModel()==null;
        case INDEX_WFVERLANRESTAG:
            return et.getWFVerLanResTag()==null;
        case INDEX_WFVERSION:
            return et.getWFVersion()==null;
        case INDEX_WFWFID:
            return et.getWFWFId()==null;
        case INDEX_WFWFNAME:
            return et.getWFWFName()==null;
        case INDEX_WFVERSIONID:
            return et.getWFVersionId()==null;
        case INDEX_WFVERSIONNAME:
            return et.getWFVersionName()==null;
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
        return  WFVersionBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFVersionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFMODEL:
            return et.isWFModelDirty();
        case INDEX_WFVERLANRESTAG:
            return et.isWFVerLanResTagDirty();
        case INDEX_WFVERSION:
            return et.isWFVersionDirty();
        case INDEX_WFWFID:
            return et.isWFWFIdDirty();
        case INDEX_WFWFNAME:
            return et.isWFWFNameDirty();
        case INDEX_WFVERSIONID:
            return et.isWFVersionIdDirty();
        case INDEX_WFVERSIONNAME:
            return et.isWFVersionNameDirty();
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
    private static  void fillJSONObject(WFVersionBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFModel()!=null) {
            JSONObjectHelper.put(json,"wfmodel",getJSONValue(et.getWFModel()),false);
        }
        if(bIncEmpty||et.getWFVerLanResTag()!=null) {
            JSONObjectHelper.put(json,"wfverlanrestag",getJSONValue(et.getWFVerLanResTag()),false);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
        }
        if(bIncEmpty||et.getWFWFId()!=null) {
            JSONObjectHelper.put(json,"wfwfid",getJSONValue(et.getWFWFId()),false);
        }
        if(bIncEmpty||et.getWFWFName()!=null) {
            JSONObjectHelper.put(json,"wfwfname",getJSONValue(et.getWFWFName()),false);
        }
        if(bIncEmpty||et.getWFVersionId()!=null) {
            JSONObjectHelper.put(json,"wfwfversionid",getJSONValue(et.getWFVersionId()),false);
        }
        if(bIncEmpty||et.getWFVersionName()!=null) {
            JSONObjectHelper.put(json,"wfwfversionname",getJSONValue(et.getWFVersionName()),false);
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
    private static void fillXmlNode(WFVersionBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFModel()!=null) {
            Object obj = et.getWFModel();
            node.setAttribute("WFMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVerLanResTag()!=null) {
            Object obj = et.getWFVerLanResTag();
            node.setAttribute("WFVERLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            Object obj = et.getWFVersion();
            node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWFWFId()!=null) {
            Object obj = et.getWFWFId();
            node.setAttribute("WFWFID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFWFName()!=null) {
            Object obj = et.getWFWFName();
            node.setAttribute("WFWFNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersionId()!=null) {
            Object obj = et.getWFVersionId();
            node.setAttribute("WFVERSIONID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersionName()!=null) {
            Object obj = et.getWFVersionName();
            node.setAttribute("WFVERSIONNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFVersionBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFVersionBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isWFModelDirty() && (bIncEmpty||et.getWFModel()!=null)) {
            dst.set(FIELD_WFMODEL,et.getWFModel());
        }
        if(et.isWFVerLanResTagDirty() && (bIncEmpty||et.getWFVerLanResTag()!=null)) {
            dst.set(FIELD_WFVERLANRESTAG,et.getWFVerLanResTag());
        }
        if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null)) {
            dst.set(FIELD_WFVERSION,et.getWFVersion());
        }
        if(et.isWFWFIdDirty() && (bIncEmpty||et.getWFWFId()!=null)) {
            dst.set(FIELD_WFWFID,et.getWFWFId());
        }
        if(et.isWFWFNameDirty() && (bIncEmpty||et.getWFWFName()!=null)) {
            dst.set(FIELD_WFWFNAME,et.getWFWFName());
        }
        if(et.isWFVersionIdDirty() && (bIncEmpty||et.getWFVersionId()!=null)) {
            dst.set(FIELD_WFVERSIONID,et.getWFVersionId());
        }
        if(et.isWFVersionNameDirty() && (bIncEmpty||et.getWFVersionName()!=null)) {
            dst.set(FIELD_WFVERSIONNAME,et.getWFVersionName());
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
        return  WFVersionBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFVersionBase et,int index) throws Exception {
        switch(index) {
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
        case INDEX_WFMODEL:
            et.resetWFModel();
            return true;
        case INDEX_WFVERLANRESTAG:
            et.resetWFVerLanResTag();
            return true;
        case INDEX_WFVERSION:
            et.resetWFVersion();
            return true;
        case INDEX_WFWFID:
            et.resetWFWFId();
            return true;
        case INDEX_WFWFNAME:
            et.resetWFWFName();
            return true;
        case INDEX_WFVERSIONID:
            et.resetWFVersionId();
            return true;
        case INDEX_WFVERSIONNAME:
            et.resetWFVersionName();
            return true;
        default:
            throw new Exception("不明属性标识");
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

        if(this.getWFWFId()==null)
            return null;
        synchronized(this.objWFWorkflowLock) {
            if(this.wfworkflow!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFWFId(),wfworkflow.getWFWorkflowId())!=0) {
                    this.wfworkflow = null;
                }
            }


            if(this.wfworkflow==null) {
                net.ibizsys.psrt.srv.wf.entity.WFWorkflow wfworkflow = new net.ibizsys.psrt.srv.wf.entity.WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWFId());
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
    private WFVersionBase getProxyEntity() {
        return this.proxyWFVersionBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFVersionBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFVersionBase) {
            this.proxyWFVersionBase = (WFVersionBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFVersionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}