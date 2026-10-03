/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.entity;


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
 * 实体[DSDynaWFVer] 数据对象基类
 */
public abstract class DSDynaWFVerBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaWFVerBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[动态工作流]
     */
    public final static String FIELD_DSDYNAWFID = "DSDYNAWFID";
    /**
     * 属性[动态工作流]
     */
    public final static String FIELD_DSDYNAWFNAME = "DSDYNAWFNAME";
    /**
     * 属性[动态工作流版本标识]
     */
    public final static String FIELD_DSDYNAWFVERID = "DSDYNAWFVERID";
    /**
     * 属性[动态工作流版本名称]
     */
    public final static String FIELD_DSDYNAWFVERNAME = "DSDYNAWFVERNAME";
    /**
     * 属性[动态模型]
     */
    public final static String FIELD_DYNAMODEL = "DYNAMODEL";
    /**
     * 属性[动态实例标识]
     */
    public final static String FIELD_DYNASYSINSTID = "DYNASYSINSTID";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[版本号]
     */
    public final static String FIELD_WFVERSION = "WFVERSION";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DSDYNAWFID = 2;
    private final static int INDEX_DSDYNAWFNAME = 3;
    private final static int INDEX_DSDYNAWFVERID = 4;
    private final static int INDEX_DSDYNAWFVERNAME = 5;
    private final static int INDEX_DYNAMODEL = 6;
    private final static int INDEX_DYNASYSINSTID = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;
    private final static int INDEX_WFVERSION = 10;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DSDYNAWFID, INDEX_DSDYNAWFID);
        fieldIndexMap.put( FIELD_DSDYNAWFNAME, INDEX_DSDYNAWFNAME);
        fieldIndexMap.put( FIELD_DSDYNAWFVERID, INDEX_DSDYNAWFVERID);
        fieldIndexMap.put( FIELD_DSDYNAWFVERNAME, INDEX_DSDYNAWFVERNAME);
        fieldIndexMap.put( FIELD_DYNAMODEL, INDEX_DYNAMODEL);
        fieldIndexMap.put( FIELD_DYNASYSINSTID, INDEX_DYNASYSINSTID);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
    }

    private DSDynaWFVerBase proxyDSDynaWFVerBase = null;
    public DSDynaWFVerBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynawfidDirtyFlag = false;
    private boolean dsdynawfnameDirtyFlag = false;
    private boolean dsdynawfveridDirtyFlag = false;
    private boolean dsdynawfvernameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynasysinstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynawfid")
    private String dsdynawfid;
    @Column(name="dsdynawfname")
    private String dsdynawfname;
    @Column(name="dsdynawfverid")
    private String dsdynawfverid;
    @Column(name="dsdynawfvername")
    private String dsdynawfvername;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynasysinstid")
    private String dynasysinstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfversion")
    private Integer wfversion;


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
     *  设置属性值[动态工作流]
     *  @param dsdynawfid
     */
    public void setDSDynaWFId(String dsdynawfid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaWFId(dsdynawfid);
            return;
        }
        if(dsdynawfid!=null) {
            dsdynawfid = StringHelper.trimRight(dsdynawfid);
            if(dsdynawfid.length()==0) {
                dsdynawfid = null;
            }
        }
        this.dsdynawfid = dsdynawfid;
        this.dsdynawfidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态工作流]
     */
    public String getDSDynaWFId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFId();
        }
        return this.dsdynawfid;
    }

    /**
     *  获取属性值[动态工作流]是否修改
     */
    public boolean isDSDynaWFIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFIdDirty();
        }
        return this.dsdynawfidDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流]
     */
    public void resetDSDynaWFId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaWFId();
            return;
        }

        this.dsdynawfidDirtyFlag = false;
        this.dsdynawfid = null;
    }
    /**
     *  设置属性值[动态工作流]
     *  @param dsdynawfname
     */
    public void setDSDynaWFName(String dsdynawfname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaWFName(dsdynawfname);
            return;
        }
        if(dsdynawfname!=null) {
            dsdynawfname = StringHelper.trimRight(dsdynawfname);
            if(dsdynawfname.length()==0) {
                dsdynawfname = null;
            }
        }
        this.dsdynawfname = dsdynawfname;
        this.dsdynawfnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态工作流]
     */
    public String getDSDynaWFName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFName();
        }
        return this.dsdynawfname;
    }

    /**
     *  获取属性值[动态工作流]是否修改
     */
    public boolean isDSDynaWFNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFNameDirty();
        }
        return this.dsdynawfnameDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流]
     */
    public void resetDSDynaWFName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaWFName();
            return;
        }

        this.dsdynawfnameDirtyFlag = false;
        this.dsdynawfname = null;
    }
    /**
     *  设置属性值[动态工作流版本标识]
     *  @param dsdynawfverid
     */
    public void setDSDynaWFVerId(String dsdynawfverid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaWFVerId(dsdynawfverid);
            return;
        }
        if(dsdynawfverid!=null) {
            dsdynawfverid = StringHelper.trimRight(dsdynawfverid);
            if(dsdynawfverid.length()==0) {
                dsdynawfverid = null;
            }
        }
        this.dsdynawfverid = dsdynawfverid;
        this.dsdynawfveridDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态工作流版本标识]
     */
    public String getDSDynaWFVerId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFVerId();
        }
        return this.dsdynawfverid;
    }

    /**
     *  获取属性值[动态工作流版本标识]是否修改
     */
    public boolean isDSDynaWFVerIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFVerIdDirty();
        }
        return this.dsdynawfveridDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流版本标识]
     */
    public void resetDSDynaWFVerId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaWFVerId();
            return;
        }

        this.dsdynawfveridDirtyFlag = false;
        this.dsdynawfverid = null;
    }
    /**
     *  设置属性值[动态工作流版本名称]
     *  @param dsdynawfvername
     */
    public void setDSDynaWFVerName(String dsdynawfvername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaWFVerName(dsdynawfvername);
            return;
        }
        if(dsdynawfvername!=null) {
            dsdynawfvername = StringHelper.trimRight(dsdynawfvername);
            if(dsdynawfvername.length()==0) {
                dsdynawfvername = null;
            }
        }
        this.dsdynawfvername = dsdynawfvername;
        this.dsdynawfvernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态工作流版本名称]
     */
    public String getDSDynaWFVerName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFVerName();
        }
        return this.dsdynawfvername;
    }

    /**
     *  获取属性值[动态工作流版本名称]是否修改
     */
    public boolean isDSDynaWFVerNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFVerNameDirty();
        }
        return this.dsdynawfvernameDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流版本名称]
     */
    public void resetDSDynaWFVerName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaWFVerName();
            return;
        }

        this.dsdynawfvernameDirtyFlag = false;
        this.dsdynawfvername = null;
    }
    /**
     *  设置属性值[动态模型]
     *  @param dynamodel
     */
    public void setDynaModel(String dynamodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDynaModel(dynamodel);
            return;
        }
        if(dynamodel!=null) {
            dynamodel = StringHelper.trimRight(dynamodel);
            if(dynamodel.length()==0) {
                dynamodel = null;
            }
        }
        this.dynamodel = dynamodel;
        this.dynamodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态模型]
     */
    public String getDynaModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    /**
     *  获取属性值[动态模型]是否修改
     */
    public boolean isDynaModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    /**
     *  重置属性值[动态模型]
     */
    public void resetDynaModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }

        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }
    /**
     *  设置属性值[动态实例标识]
     *  @param dynasysinstid
     */
    public void setDynaSysInstId(String dynasysinstid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDynaSysInstId(dynasysinstid);
            return;
        }
        if(dynasysinstid!=null) {
            dynasysinstid = StringHelper.trimRight(dynasysinstid);
            if(dynasysinstid.length()==0) {
                dynasysinstid = null;
            }
        }
        this.dynasysinstid = dynasysinstid;
        this.dynasysinstidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态实例标识]
     */
    public String getDynaSysInstId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDynaSysInstId();
        }
        return this.dynasysinstid;
    }

    /**
     *  获取属性值[动态实例标识]是否修改
     */
    public boolean isDynaSysInstIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDynaSysInstIdDirty();
        }
        return this.dynasysinstidDirtyFlag;
    }

    /**
     *  重置属性值[动态实例标识]
     */
    public void resetDynaSysInstId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDynaSysInstId();
            return;
        }

        this.dynasysinstidDirtyFlag = false;
        this.dynasysinstid = null;
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
     *  设置属性值[版本号]
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
     *  获取属性值[版本号]
     */
    public Integer getWFVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    /**
     *  获取属性值[版本号]是否修改
     */
    public boolean isWFVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    /**
     *  重置属性值[版本号]
     */
    public void resetWFVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }

        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        DSDynaWFVerBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DSDynaWFVerBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaWFId();
        et.resetDSDynaWFName();
        et.resetDSDynaWFVerId();
        et.resetDSDynaWFVerName();
        et.resetDynaModel();
        et.resetDynaSysInstId();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFVersion();
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
        if(!bDirtyOnly || isDSDynaWFIdDirty()) {
            params.put(FIELD_DSDYNAWFID,getDSDynaWFId());
        }
        if(!bDirtyOnly || isDSDynaWFNameDirty()) {
            params.put(FIELD_DSDYNAWFNAME,getDSDynaWFName());
        }
        if(!bDirtyOnly || isDSDynaWFVerIdDirty()) {
            params.put(FIELD_DSDYNAWFVERID,getDSDynaWFVerId());
        }
        if(!bDirtyOnly || isDSDynaWFVerNameDirty()) {
            params.put(FIELD_DSDYNAWFVERNAME,getDSDynaWFVerName());
        }
        if(!bDirtyOnly || isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL,getDynaModel());
        }
        if(!bDirtyOnly || isDynaSysInstIdDirty()) {
            params.put(FIELD_DYNASYSINSTID,getDynaSysInstId());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFVersionDirty()) {
            params.put(FIELD_WFVERSION,getWFVersion());
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

        return  DSDynaWFVerBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DSDynaWFVerBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DSDYNAWFID:
            return et.getDSDynaWFId();
        case INDEX_DSDYNAWFNAME:
            return et.getDSDynaWFName();
        case INDEX_DSDYNAWFVERID:
            return et.getDSDynaWFVerId();
        case INDEX_DSDYNAWFVERNAME:
            return et.getDSDynaWFVerName();
        case INDEX_DYNAMODEL:
            return et.getDynaModel();
        case INDEX_DYNASYSINSTID:
            return et.getDynaSysInstId();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFVERSION:
            return et.getWFVersion();
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

        DSDynaWFVerBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DSDynaWFVerBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAWFID:
            et.setDSDynaWFId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAWFNAME:
            et.setDSDynaWFName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAWFVERID:
            et.setDSDynaWFVerId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAWFVERNAME:
            et.setDSDynaWFVerName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DYNAMODEL:
            et.setDynaModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_DYNASYSINSTID:
            et.setDynaSysInstId(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSION:
            et.setWFVersion(DataObject.getIntegerValue(obj));
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

        return  DSDynaWFVerBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DSDynaWFVerBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DSDYNAWFID:
            return et.getDSDynaWFId()==null;
        case INDEX_DSDYNAWFNAME:
            return et.getDSDynaWFName()==null;
        case INDEX_DSDYNAWFVERID:
            return et.getDSDynaWFVerId()==null;
        case INDEX_DSDYNAWFVERNAME:
            return et.getDSDynaWFVerName()==null;
        case INDEX_DYNAMODEL:
            return et.getDynaModel()==null;
        case INDEX_DYNASYSINSTID:
            return et.getDynaSysInstId()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFVERSION:
            return et.getWFVersion()==null;
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
        return  DSDynaWFVerBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DSDynaWFVerBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DSDYNAWFID:
            return et.isDSDynaWFIdDirty();
        case INDEX_DSDYNAWFNAME:
            return et.isDSDynaWFNameDirty();
        case INDEX_DSDYNAWFVERID:
            return et.isDSDynaWFVerIdDirty();
        case INDEX_DSDYNAWFVERNAME:
            return et.isDSDynaWFVerNameDirty();
        case INDEX_DYNAMODEL:
            return et.isDynaModelDirty();
        case INDEX_DYNASYSINSTID:
            return et.isDynaSysInstIdDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFVERSION:
            return et.isWFVersionDirty();
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
    private static  void fillJSONObject(DSDynaWFVerBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDSDynaWFId()!=null) {
            JSONObjectHelper.put(json,"dsdynawfid",getJSONValue(et.getDSDynaWFId()),false);
        }
        if(bIncEmpty||et.getDSDynaWFName()!=null) {
            JSONObjectHelper.put(json,"dsdynawfname",getJSONValue(et.getDSDynaWFName()),false);
        }
        if(bIncEmpty||et.getDSDynaWFVerId()!=null) {
            JSONObjectHelper.put(json,"dsdynawfverid",getJSONValue(et.getDSDynaWFVerId()),false);
        }
        if(bIncEmpty||et.getDSDynaWFVerName()!=null) {
            JSONObjectHelper.put(json,"dsdynawfvername",getJSONValue(et.getDSDynaWFVerName()),false);
        }
        if(bIncEmpty||et.getDynaModel()!=null) {
            JSONObjectHelper.put(json,"dynamodel",getJSONValue(et.getDynaModel()),false);
        }
        if(bIncEmpty||et.getDynaSysInstId()!=null) {
            JSONObjectHelper.put(json,"dynasysinstid",getJSONValue(et.getDynaSysInstId()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
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
    private static void fillXmlNode(DSDynaWFVerBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaWFId()!=null) {
            Object obj = et.getDSDynaWFId();
            node.setAttribute("DSDYNAWFID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaWFName()!=null) {
            Object obj = et.getDSDynaWFName();
            node.setAttribute("DSDYNAWFNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaWFVerId()!=null) {
            Object obj = et.getDSDynaWFVerId();
            node.setAttribute("DSDYNAWFVERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaWFVerName()!=null) {
            Object obj = et.getDSDynaWFVerName();
            node.setAttribute("DSDYNAWFVERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDynaModel()!=null) {
            Object obj = et.getDynaModel();
            node.setAttribute("DYNAMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDynaSysInstId()!=null) {
            Object obj = et.getDynaSysInstId();
            node.setAttribute("DYNASYSINSTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            Object obj = et.getWFVersion();
            node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaWFVerBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DSDynaWFVerBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDSDynaWFIdDirty() && (bIncEmpty||et.getDSDynaWFId()!=null)) {
            dst.set(FIELD_DSDYNAWFID,et.getDSDynaWFId());
        }
        if(et.isDSDynaWFNameDirty() && (bIncEmpty||et.getDSDynaWFName()!=null)) {
            dst.set(FIELD_DSDYNAWFNAME,et.getDSDynaWFName());
        }
        if(et.isDSDynaWFVerIdDirty() && (bIncEmpty||et.getDSDynaWFVerId()!=null)) {
            dst.set(FIELD_DSDYNAWFVERID,et.getDSDynaWFVerId());
        }
        if(et.isDSDynaWFVerNameDirty() && (bIncEmpty||et.getDSDynaWFVerName()!=null)) {
            dst.set(FIELD_DSDYNAWFVERNAME,et.getDSDynaWFVerName());
        }
        if(et.isDynaModelDirty() && (bIncEmpty||et.getDynaModel()!=null)) {
            dst.set(FIELD_DYNAMODEL,et.getDynaModel());
        }
        if(et.isDynaSysInstIdDirty() && (bIncEmpty||et.getDynaSysInstId()!=null)) {
            dst.set(FIELD_DYNASYSINSTID,et.getDynaSysInstId());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null)) {
            dst.set(FIELD_WFVERSION,et.getWFVersion());
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
        return  DSDynaWFVerBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DSDynaWFVerBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DSDYNAWFID:
            et.resetDSDynaWFId();
            return true;
        case INDEX_DSDYNAWFNAME:
            et.resetDSDynaWFName();
            return true;
        case INDEX_DSDYNAWFVERID:
            et.resetDSDynaWFVerId();
            return true;
        case INDEX_DSDYNAWFVERNAME:
            et.resetDSDynaWFVerName();
            return true;
        case INDEX_DYNAMODEL:
            et.resetDynaModel();
            return true;
        case INDEX_DYNASYSINSTID:
            et.resetDynaSysInstId();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFVERSION:
            et.resetWFVersion();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objDSDynaWFLock = new Integer(1);
    private net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF dsdynawf = null;
    /**
    * 获取父数据 动态工作流
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF getDSDynaWF() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWF();
        }

        if(this.getDSDynaWFId()==null)
            return null;
        synchronized(this.objDSDynaWFLock) {
            if(this.dsdynawf!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDSDynaWFId(),dsdynawf.getDSDynaWFId())!=0) {
                    this.dsdynawf = null;
                }
            }


            if(this.dsdynawf==null) {
                net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF dsdynawf = new net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF();
                dsdynawf.setDSDynaWFId(this.getDSDynaWFId());
                net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService service = (net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService)ServiceGlobal.getService(net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService.class,this.getSessionFactory());
                service.autoGet(dsdynawf);
                this.dsdynawf = dsdynawf;
            }
            return this.dsdynawf;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private DSDynaWFVerBase getProxyEntity() {
        return this.proxyDSDynaWFVerBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaWFVerBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DSDynaWFVerBase) {
            this.proxyDSDynaWFVerBase = (DSDynaWFVerBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}