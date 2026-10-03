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
 * 实体[WFCustomProcess] 数据对象基类
 */
public abstract class WFCustomProcessBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFCustomProcessBase.class);
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
     * 属性[处理对象]
     */
    public final static String FIELD_PROCESSOBJECT = "PROCESSOBJECT";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[处理版本]
     */
    public final static String FIELD_VERSION = "VERSION";
    /**
     * 属性[工作流预定义处理标识]
     */
    public final static String FIELD_WFCUSTOMPROCESSID = "WFCUSTOMPROCESSID";
    /**
     * 属性[工作流预定义处理名称]
     */
    public final static String FIELD_WFCUSTOMPROCESSNAME = "WFCUSTOMPROCESSNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MEMO = 2;
    private final static int INDEX_PROCESSOBJECT = 3;
    private final static int INDEX_UPDATEDATE = 4;
    private final static int INDEX_UPDATEMAN = 5;
    private final static int INDEX_VERSION = 6;
    private final static int INDEX_WFCUSTOMPROCESSID = 7;
    private final static int INDEX_WFCUSTOMPROCESSNAME = 8;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PROCESSOBJECT, INDEX_PROCESSOBJECT);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VERSION, INDEX_VERSION);
        fieldIndexMap.put( FIELD_WFCUSTOMPROCESSID, INDEX_WFCUSTOMPROCESSID);
        fieldIndexMap.put( FIELD_WFCUSTOMPROCESSNAME, INDEX_WFCUSTOMPROCESSNAME);
    }

    private WFCustomProcessBase proxyWFCustomProcessBase = null;
    public WFCustomProcessBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processobjectDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    private boolean wfcustomprocessidDirtyFlag = false;
    private boolean wfcustomprocessnameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="processobject")
    private String processobject;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="version")
    private String version;
    @Column(name="wfcustomprocessid")
    private String wfcustomprocessid;
    @Column(name="wfcustomprocessname")
    private String wfcustomprocessname;


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
     *  设置属性值[处理对象]
     *  @param processobject
     */
    public void setProcessObject(String processobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setProcessObject(processobject);
            return;
        }
        if(processobject!=null) {
            processobject = StringHelper.trimRight(processobject);
            if(processobject.length()==0) {
                processobject = null;
            }
        }
        this.processobject = processobject;
        this.processobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[处理对象]
     */
    public String getProcessObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getProcessObject();
        }
        return this.processobject;
    }

    /**
     *  获取属性值[处理对象]是否修改
     */
    public boolean isProcessObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isProcessObjectDirty();
        }
        return this.processobjectDirtyFlag;
    }

    /**
     *  重置属性值[处理对象]
     */
    public void resetProcessObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetProcessObject();
            return;
        }

        this.processobjectDirtyFlag = false;
        this.processobject = null;
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
     *  设置属性值[处理版本]
     *  @param version
     */
    public void setVersion(String version) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        if(version!=null) {
            version = StringHelper.trimRight(version);
            if(version.length()==0) {
                version = null;
            }
        }
        this.version = version;
        this.versionDirtyFlag  = true;
    }

    /**
     *  获取属性值[处理版本]
     */
    public String getVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    /**
     *  获取属性值[处理版本]是否修改
     */
    public boolean isVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    /**
     *  重置属性值[处理版本]
     */
    public void resetVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVersion();
            return;
        }

        this.versionDirtyFlag = false;
        this.version = null;
    }
    /**
     *  设置属性值[工作流预定义处理标识]
     *  @param wfcustomprocessid
     */
    public void setWFCustomProcessId(String wfcustomprocessid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFCustomProcessId(wfcustomprocessid);
            return;
        }
        if(wfcustomprocessid!=null) {
            wfcustomprocessid = StringHelper.trimRight(wfcustomprocessid);
            if(wfcustomprocessid.length()==0) {
                wfcustomprocessid = null;
            }
        }
        this.wfcustomprocessid = wfcustomprocessid;
        this.wfcustomprocessidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流预定义处理标识]
     */
    public String getWFCustomProcessId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFCustomProcessId();
        }
        return this.wfcustomprocessid;
    }

    /**
     *  获取属性值[工作流预定义处理标识]是否修改
     */
    public boolean isWFCustomProcessIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFCustomProcessIdDirty();
        }
        return this.wfcustomprocessidDirtyFlag;
    }

    /**
     *  重置属性值[工作流预定义处理标识]
     */
    public void resetWFCustomProcessId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFCustomProcessId();
            return;
        }

        this.wfcustomprocessidDirtyFlag = false;
        this.wfcustomprocessid = null;
    }
    /**
     *  设置属性值[工作流预定义处理名称]
     *  @param wfcustomprocessname
     */
    public void setWFCustomProcessName(String wfcustomprocessname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFCustomProcessName(wfcustomprocessname);
            return;
        }
        if(wfcustomprocessname!=null) {
            wfcustomprocessname = StringHelper.trimRight(wfcustomprocessname);
            if(wfcustomprocessname.length()==0) {
                wfcustomprocessname = null;
            }
        }
        this.wfcustomprocessname = wfcustomprocessname;
        this.wfcustomprocessnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流预定义处理名称]
     */
    public String getWFCustomProcessName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFCustomProcessName();
        }
        return this.wfcustomprocessname;
    }

    /**
     *  获取属性值[工作流预定义处理名称]是否修改
     */
    public boolean isWFCustomProcessNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFCustomProcessNameDirty();
        }
        return this.wfcustomprocessnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流预定义处理名称]
     */
    public void resetWFCustomProcessName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFCustomProcessName();
            return;
        }

        this.wfcustomprocessnameDirtyFlag = false;
        this.wfcustomprocessname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFCustomProcessBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFCustomProcessBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetProcessObject();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetVersion();
        et.resetWFCustomProcessId();
        et.resetWFCustomProcessName();
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
        if(!bDirtyOnly || isProcessObjectDirty()) {
            params.put(FIELD_PROCESSOBJECT,getProcessObject());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isVersionDirty()) {
            params.put(FIELD_VERSION,getVersion());
        }
        if(!bDirtyOnly || isWFCustomProcessIdDirty()) {
            params.put(FIELD_WFCUSTOMPROCESSID,getWFCustomProcessId());
        }
        if(!bDirtyOnly || isWFCustomProcessNameDirty()) {
            params.put(FIELD_WFCUSTOMPROCESSNAME,getWFCustomProcessName());
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

        return  WFCustomProcessBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFCustomProcessBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PROCESSOBJECT:
            return et.getProcessObject();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VERSION:
            return et.getVersion();
        case INDEX_WFCUSTOMPROCESSID:
            return et.getWFCustomProcessId();
        case INDEX_WFCUSTOMPROCESSNAME:
            return et.getWFCustomProcessName();
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

        WFCustomProcessBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFCustomProcessBase et,int index,Object obj) throws Exception {
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
        case INDEX_PROCESSOBJECT:
            et.setProcessObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VERSION:
            et.setVersion(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFCUSTOMPROCESSID:
            et.setWFCustomProcessId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFCUSTOMPROCESSNAME:
            et.setWFCustomProcessName(DataObject.getStringValue(obj));
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

        return  WFCustomProcessBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFCustomProcessBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PROCESSOBJECT:
            return et.getProcessObject()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VERSION:
            return et.getVersion()==null;
        case INDEX_WFCUSTOMPROCESSID:
            return et.getWFCustomProcessId()==null;
        case INDEX_WFCUSTOMPROCESSNAME:
            return et.getWFCustomProcessName()==null;
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
        return  WFCustomProcessBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFCustomProcessBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PROCESSOBJECT:
            return et.isProcessObjectDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VERSION:
            return et.isVersionDirty();
        case INDEX_WFCUSTOMPROCESSID:
            return et.isWFCustomProcessIdDirty();
        case INDEX_WFCUSTOMPROCESSNAME:
            return et.isWFCustomProcessNameDirty();
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
    private static  void fillJSONObject(WFCustomProcessBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getProcessObject()!=null) {
            JSONObjectHelper.put(json,"processobject",getJSONValue(et.getProcessObject()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            JSONObjectHelper.put(json,"version",getJSONValue(et.getVersion()),false);
        }
        if(bIncEmpty||et.getWFCustomProcessId()!=null) {
            JSONObjectHelper.put(json,"wfcustomprocessid",getJSONValue(et.getWFCustomProcessId()),false);
        }
        if(bIncEmpty||et.getWFCustomProcessName()!=null) {
            JSONObjectHelper.put(json,"wfcustomprocessname",getJSONValue(et.getWFCustomProcessName()),false);
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
    private static void fillXmlNode(WFCustomProcessBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getProcessObject()!=null) {
            Object obj = et.getProcessObject();
            node.setAttribute("PROCESSOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            Object obj = et.getVersion();
            node.setAttribute("VERSION",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFCustomProcessId()!=null) {
            Object obj = et.getWFCustomProcessId();
            node.setAttribute("WFCUSTOMPROCESSID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFCustomProcessName()!=null) {
            Object obj = et.getWFCustomProcessName();
            node.setAttribute("WFCUSTOMPROCESSNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFCustomProcessBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFCustomProcessBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isProcessObjectDirty() && (bIncEmpty||et.getProcessObject()!=null)) {
            dst.set(FIELD_PROCESSOBJECT,et.getProcessObject());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isVersionDirty() && (bIncEmpty||et.getVersion()!=null)) {
            dst.set(FIELD_VERSION,et.getVersion());
        }
        if(et.isWFCustomProcessIdDirty() && (bIncEmpty||et.getWFCustomProcessId()!=null)) {
            dst.set(FIELD_WFCUSTOMPROCESSID,et.getWFCustomProcessId());
        }
        if(et.isWFCustomProcessNameDirty() && (bIncEmpty||et.getWFCustomProcessName()!=null)) {
            dst.set(FIELD_WFCUSTOMPROCESSNAME,et.getWFCustomProcessName());
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
        return  WFCustomProcessBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFCustomProcessBase et,int index) throws Exception {
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
        case INDEX_PROCESSOBJECT:
            et.resetProcessObject();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VERSION:
            et.resetVersion();
            return true;
        case INDEX_WFCUSTOMPROCESSID:
            et.resetWFCustomProcessId();
            return true;
        case INDEX_WFCUSTOMPROCESSNAME:
            et.resetWFCustomProcessName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private WFCustomProcessBase getProxyEntity() {
        return this.proxyWFCustomProcessBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFCustomProcessBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFCustomProcessBase) {
            this.proxyWFCustomProcessBase = (WFCustomProcessBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFCustomProcessService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}