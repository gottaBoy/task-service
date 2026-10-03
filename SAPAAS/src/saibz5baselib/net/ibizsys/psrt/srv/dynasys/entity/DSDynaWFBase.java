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
 * 实体[DSDynaWF] 数据对象基类
 */
public abstract class DSDynaWFBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaWFBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[动态工作流标识]
     */
    public final static String FIELD_DSDYNAWFID = "DSDYNAWFID";
    /**
     * 属性[动态工作流名称]
     */
    public final static String FIELD_DSDYNAWFNAME = "DSDYNAWFNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[工作流标识]
     */
    public final static String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    /**
     * 属性[工作流名称]
     */
    public final static String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DSDYNAWFID = 2;
    private final static int INDEX_DSDYNAWFNAME = 3;
    private final static int INDEX_UPDATEDATE = 4;
    private final static int INDEX_UPDATEMAN = 5;
    private final static int INDEX_WFWORKFLOWID = 6;
    private final static int INDEX_WFWORKFLOWNAME = 7;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DSDYNAWFID, INDEX_DSDYNAWFID);
        fieldIndexMap.put( FIELD_DSDYNAWFNAME, INDEX_DSDYNAWFNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFWORKFLOWID, INDEX_WFWORKFLOWID);
        fieldIndexMap.put( FIELD_WFWORKFLOWNAME, INDEX_WFWORKFLOWNAME);
    }

    private DSDynaWFBase proxyDSDynaWFBase = null;
    public DSDynaWFBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynawfidDirtyFlag = false;
    private boolean dsdynawfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynawfid")
    private String dsdynawfid;
    @Column(name="dsdynawfname")
    private String dsdynawfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
     *  设置属性值[动态工作流标识]
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
     *  获取属性值[动态工作流标识]
     */
    public String getDSDynaWFId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFId();
        }
        return this.dsdynawfid;
    }

    /**
     *  获取属性值[动态工作流标识]是否修改
     */
    public boolean isDSDynaWFIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFIdDirty();
        }
        return this.dsdynawfidDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流标识]
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
     *  设置属性值[动态工作流名称]
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
     *  获取属性值[动态工作流名称]
     */
    public String getDSDynaWFName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFName();
        }
        return this.dsdynawfname;
    }

    /**
     *  获取属性值[动态工作流名称]是否修改
     */
    public boolean isDSDynaWFNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaWFNameDirty();
        }
        return this.dsdynawfnameDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流名称]
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
     *  设置属性值[工作流标识]
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
     *  获取属性值[工作流标识]
     */
    public String getWFWorkflowId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    /**
     *  获取属性值[工作流标识]是否修改
     */
    public boolean isWFWorkflowIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    /**
     *  重置属性值[工作流标识]
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
     *  设置属性值[工作流名称]
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
     *  获取属性值[工作流名称]
     */
    public String getWFWorkflowName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    /**
     *  获取属性值[工作流名称]是否修改
     */
    public boolean isWFWorkflowNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    /**
     *  重置属性值[工作流名称]
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
        DSDynaWFBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DSDynaWFBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaWFId();
        et.resetDSDynaWFName();
        et.resetUpdateDate();
        et.resetUpdateMan();
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
        if(!bDirtyOnly || isDSDynaWFIdDirty()) {
            params.put(FIELD_DSDYNAWFID,getDSDynaWFId());
        }
        if(!bDirtyOnly || isDSDynaWFNameDirty()) {
            params.put(FIELD_DSDYNAWFNAME,getDSDynaWFName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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

        return  DSDynaWFBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DSDynaWFBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DSDYNAWFID:
            return et.getDSDynaWFId();
        case INDEX_DSDYNAWFNAME:
            return et.getDSDynaWFName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
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

        DSDynaWFBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DSDynaWFBase et,int index,Object obj) throws Exception {
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
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
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

        return  DSDynaWFBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DSDynaWFBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DSDYNAWFID:
            return et.getDSDynaWFId()==null;
        case INDEX_DSDYNAWFNAME:
            return et.getDSDynaWFName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
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
        return  DSDynaWFBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DSDynaWFBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DSDYNAWFID:
            return et.isDSDynaWFIdDirty();
        case INDEX_DSDYNAWFNAME:
            return et.isDSDynaWFNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
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
    private static  void fillJSONObject(DSDynaWFBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
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
    private static void fillXmlNode(DSDynaWFBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
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
        DSDynaWFBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DSDynaWFBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
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
        return  DSDynaWFBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DSDynaWFBase et,int index) throws Exception {
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
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
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




    private Integer objDSDynaWFVersLock = new Integer(1);
    private ArrayList<net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer> dsdynawfvers = null;

    /**
    * 获取子数据 动态工作流版本
     * @throws Exception
    */
    public ArrayList<net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer> getDSDynaWFVers() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaWFVers();
        }
        if(this.getDSDynaWFId()==null)
            return null;
        net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService service = (net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService)ServiceGlobal.getService(net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService.class,this.getSessionFactory());
        synchronized(objDSDynaWFVersLock) {
            if(dsdynawfvers==null) {
                dsdynawfvers =  service.selectByDSDynaWF(this);
            }
            return dsdynawfvers;
        }
    }

    /**
     *  获取代理的数据对象
     */
    private DSDynaWFBase getProxyEntity() {
        return this.proxyDSDynaWFBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaWFBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DSDynaWFBase) {
            this.proxyDSDynaWFBase = (DSDynaWFBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}