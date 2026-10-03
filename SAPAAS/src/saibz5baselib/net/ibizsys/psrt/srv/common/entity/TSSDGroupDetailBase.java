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
 * 实体[TSSDGroupDetail] 数据对象基类
 */
public abstract class TSSDGroupDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDGroupDetailBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[任务时刻策略组明细标识]
     */
    public final static String FIELD_TSSDGROUPDETAILID = "TSSDGROUPDETAILID";
    /**
     * 属性[任务时刻策略组明细名称]
     */
    public final static String FIELD_TSSDGROUPDETAILNAME = "TSSDGROUPDETAILNAME";
    /**
     * 属性[任务时刻策略组]
     */
    public final static String FIELD_TSSDGROUPID = "TSSDGROUPID";
    /**
     * 属性[任务时刻策略组]
     */
    public final static String FIELD_TSSDGROUPNAME = "TSSDGROUPNAME";
    /**
     * 属性[任务时刻策略项]
     */
    public final static String FIELD_TSSDITEMID = "TSSDITEMID";
    /**
     * 属性[任务时刻策略项]
     */
    public final static String FIELD_TSSDITEMNAME = "TSSDITEMNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_TSSDGROUPDETAILID = 2;
    private final static int INDEX_TSSDGROUPDETAILNAME = 3;
    private final static int INDEX_TSSDGROUPID = 4;
    private final static int INDEX_TSSDGROUPNAME = 5;
    private final static int INDEX_TSSDITEMID = 6;
    private final static int INDEX_TSSDITEMNAME = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_TSSDGROUPDETAILID, INDEX_TSSDGROUPDETAILID);
        fieldIndexMap.put( FIELD_TSSDGROUPDETAILNAME, INDEX_TSSDGROUPDETAILNAME);
        fieldIndexMap.put( FIELD_TSSDGROUPID, INDEX_TSSDGROUPID);
        fieldIndexMap.put( FIELD_TSSDGROUPNAME, INDEX_TSSDGROUPNAME);
        fieldIndexMap.put( FIELD_TSSDITEMID, INDEX_TSSDITEMID);
        fieldIndexMap.put( FIELD_TSSDITEMNAME, INDEX_TSSDITEMNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private TSSDGroupDetailBase proxyTSSDGroupDetailBase = null;
    public TSSDGroupDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean tssdgroupdetailidDirtyFlag = false;
    private boolean tssdgroupdetailnameDirtyFlag = false;
    private boolean tssdgroupidDirtyFlag = false;
    private boolean tssdgroupnameDirtyFlag = false;
    private boolean tssditemidDirtyFlag = false;
    private boolean tssditemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="tssdgroupdetailid")
    private String tssdgroupdetailid;
    @Column(name="tssdgroupdetailname")
    private String tssdgroupdetailname;
    @Column(name="tssdgroupid")
    private String tssdgroupid;
    @Column(name="tssdgroupname")
    private String tssdgroupname;
    @Column(name="tssditemid")
    private String tssditemid;
    @Column(name="tssditemname")
    private String tssditemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


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
     *  设置属性值[任务时刻策略组明细标识]
     *  @param tssdgroupdetailid
     */
    public void setTSSDGroupDetailId(String tssdgroupdetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDGroupDetailId(tssdgroupdetailid);
            return;
        }
        if(tssdgroupdetailid!=null) {
            tssdgroupdetailid = StringHelper.trimRight(tssdgroupdetailid);
            if(tssdgroupdetailid.length()==0) {
                tssdgroupdetailid = null;
            }
        }
        this.tssdgroupdetailid = tssdgroupdetailid;
        this.tssdgroupdetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略组明细标识]
     */
    public String getTSSDGroupDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDGroupDetailId();
        }
        return this.tssdgroupdetailid;
    }

    /**
     *  获取属性值[任务时刻策略组明细标识]是否修改
     */
    public boolean isTSSDGroupDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDGroupDetailIdDirty();
        }
        return this.tssdgroupdetailidDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略组明细标识]
     */
    public void resetTSSDGroupDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDGroupDetailId();
            return;
        }

        this.tssdgroupdetailidDirtyFlag = false;
        this.tssdgroupdetailid = null;
    }
    /**
     *  设置属性值[任务时刻策略组明细名称]
     *  @param tssdgroupdetailname
     */
    public void setTSSDGroupDetailName(String tssdgroupdetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDGroupDetailName(tssdgroupdetailname);
            return;
        }
        if(tssdgroupdetailname!=null) {
            tssdgroupdetailname = StringHelper.trimRight(tssdgroupdetailname);
            if(tssdgroupdetailname.length()==0) {
                tssdgroupdetailname = null;
            }
        }
        this.tssdgroupdetailname = tssdgroupdetailname;
        this.tssdgroupdetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略组明细名称]
     */
    public String getTSSDGroupDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDGroupDetailName();
        }
        return this.tssdgroupdetailname;
    }

    /**
     *  获取属性值[任务时刻策略组明细名称]是否修改
     */
    public boolean isTSSDGroupDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDGroupDetailNameDirty();
        }
        return this.tssdgroupdetailnameDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略组明细名称]
     */
    public void resetTSSDGroupDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDGroupDetailName();
            return;
        }

        this.tssdgroupdetailnameDirtyFlag = false;
        this.tssdgroupdetailname = null;
    }
    /**
     *  设置属性值[任务时刻策略组]
     *  @param tssdgroupid
     */
    public void setTSSDGroupId(String tssdgroupid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDGroupId(tssdgroupid);
            return;
        }
        if(tssdgroupid!=null) {
            tssdgroupid = StringHelper.trimRight(tssdgroupid);
            if(tssdgroupid.length()==0) {
                tssdgroupid = null;
            }
        }
        this.tssdgroupid = tssdgroupid;
        this.tssdgroupidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略组]
     */
    public String getTSSDGroupId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDGroupId();
        }
        return this.tssdgroupid;
    }

    /**
     *  获取属性值[任务时刻策略组]是否修改
     */
    public boolean isTSSDGroupIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDGroupIdDirty();
        }
        return this.tssdgroupidDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略组]
     */
    public void resetTSSDGroupId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDGroupId();
            return;
        }

        this.tssdgroupidDirtyFlag = false;
        this.tssdgroupid = null;
    }
    /**
     *  设置属性值[任务时刻策略组]
     *  @param tssdgroupname
     */
    public void setTSSDGroupName(String tssdgroupname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDGroupName(tssdgroupname);
            return;
        }
        if(tssdgroupname!=null) {
            tssdgroupname = StringHelper.trimRight(tssdgroupname);
            if(tssdgroupname.length()==0) {
                tssdgroupname = null;
            }
        }
        this.tssdgroupname = tssdgroupname;
        this.tssdgroupnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略组]
     */
    public String getTSSDGroupName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDGroupName();
        }
        return this.tssdgroupname;
    }

    /**
     *  获取属性值[任务时刻策略组]是否修改
     */
    public boolean isTSSDGroupNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDGroupNameDirty();
        }
        return this.tssdgroupnameDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略组]
     */
    public void resetTSSDGroupName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDGroupName();
            return;
        }

        this.tssdgroupnameDirtyFlag = false;
        this.tssdgroupname = null;
    }
    /**
     *  设置属性值[任务时刻策略项]
     *  @param tssditemid
     */
    public void setTSSDItemId(String tssditemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDItemId(tssditemid);
            return;
        }
        if(tssditemid!=null) {
            tssditemid = StringHelper.trimRight(tssditemid);
            if(tssditemid.length()==0) {
                tssditemid = null;
            }
        }
        this.tssditemid = tssditemid;
        this.tssditemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略项]
     */
    public String getTSSDItemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDItemId();
        }
        return this.tssditemid;
    }

    /**
     *  获取属性值[任务时刻策略项]是否修改
     */
    public boolean isTSSDItemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDItemIdDirty();
        }
        return this.tssditemidDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略项]
     */
    public void resetTSSDItemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDItemId();
            return;
        }

        this.tssditemidDirtyFlag = false;
        this.tssditemid = null;
    }
    /**
     *  设置属性值[任务时刻策略项]
     *  @param tssditemname
     */
    public void setTSSDItemName(String tssditemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDItemName(tssditemname);
            return;
        }
        if(tssditemname!=null) {
            tssditemname = StringHelper.trimRight(tssditemname);
            if(tssditemname.length()==0) {
                tssditemname = null;
            }
        }
        this.tssditemname = tssditemname;
        this.tssditemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略项]
     */
    public String getTSSDItemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDItemName();
        }
        return this.tssditemname;
    }

    /**
     *  获取属性值[任务时刻策略项]是否修改
     */
    public boolean isTSSDItemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDItemNameDirty();
        }
        return this.tssditemnameDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略项]
     */
    public void resetTSSDItemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDItemName();
            return;
        }

        this.tssditemnameDirtyFlag = false;
        this.tssditemname = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        TSSDGroupDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(TSSDGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetTSSDGroupDetailId();
        et.resetTSSDGroupDetailName();
        et.resetTSSDGroupId();
        et.resetTSSDGroupName();
        et.resetTSSDItemId();
        et.resetTSSDItemName();
        et.resetUpdateDate();
        et.resetUpdateMan();
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
        if(!bDirtyOnly || isTSSDGroupDetailIdDirty()) {
            params.put(FIELD_TSSDGROUPDETAILID,getTSSDGroupDetailId());
        }
        if(!bDirtyOnly || isTSSDGroupDetailNameDirty()) {
            params.put(FIELD_TSSDGROUPDETAILNAME,getTSSDGroupDetailName());
        }
        if(!bDirtyOnly || isTSSDGroupIdDirty()) {
            params.put(FIELD_TSSDGROUPID,getTSSDGroupId());
        }
        if(!bDirtyOnly || isTSSDGroupNameDirty()) {
            params.put(FIELD_TSSDGROUPNAME,getTSSDGroupName());
        }
        if(!bDirtyOnly || isTSSDItemIdDirty()) {
            params.put(FIELD_TSSDITEMID,getTSSDItemId());
        }
        if(!bDirtyOnly || isTSSDItemNameDirty()) {
            params.put(FIELD_TSSDITEMNAME,getTSSDItemName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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

        return  TSSDGroupDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_TSSDGROUPDETAILID:
            return et.getTSSDGroupDetailId();
        case INDEX_TSSDGROUPDETAILNAME:
            return et.getTSSDGroupDetailName();
        case INDEX_TSSDGROUPID:
            return et.getTSSDGroupId();
        case INDEX_TSSDGROUPNAME:
            return et.getTSSDGroupName();
        case INDEX_TSSDITEMID:
            return et.getTSSDItemId();
        case INDEX_TSSDITEMNAME:
            return et.getTSSDItemName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
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

        TSSDGroupDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDGroupDetailBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDGROUPDETAILID:
            et.setTSSDGroupDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDGROUPDETAILNAME:
            et.setTSSDGroupDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDGROUPID:
            et.setTSSDGroupId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDGROUPNAME:
            et.setTSSDGroupName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDITEMID:
            et.setTSSDItemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDITEMNAME:
            et.setTSSDItemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
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

        return  TSSDGroupDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_TSSDGROUPDETAILID:
            return et.getTSSDGroupDetailId()==null;
        case INDEX_TSSDGROUPDETAILNAME:
            return et.getTSSDGroupDetailName()==null;
        case INDEX_TSSDGROUPID:
            return et.getTSSDGroupId()==null;
        case INDEX_TSSDGROUPNAME:
            return et.getTSSDGroupName()==null;
        case INDEX_TSSDITEMID:
            return et.getTSSDItemId()==null;
        case INDEX_TSSDITEMNAME:
            return et.getTSSDItemName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
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
        return  TSSDGroupDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_TSSDGROUPDETAILID:
            return et.isTSSDGroupDetailIdDirty();
        case INDEX_TSSDGROUPDETAILNAME:
            return et.isTSSDGroupDetailNameDirty();
        case INDEX_TSSDGROUPID:
            return et.isTSSDGroupIdDirty();
        case INDEX_TSSDGROUPNAME:
            return et.isTSSDGroupNameDirty();
        case INDEX_TSSDITEMID:
            return et.isTSSDItemIdDirty();
        case INDEX_TSSDITEMNAME:
            return et.isTSSDItemNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
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
    private static  void fillJSONObject(TSSDGroupDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getTSSDGroupDetailId()!=null) {
            JSONObjectHelper.put(json,"tssdgroupdetailid",getJSONValue(et.getTSSDGroupDetailId()),false);
        }
        if(bIncEmpty||et.getTSSDGroupDetailName()!=null) {
            JSONObjectHelper.put(json,"tssdgroupdetailname",getJSONValue(et.getTSSDGroupDetailName()),false);
        }
        if(bIncEmpty||et.getTSSDGroupId()!=null) {
            JSONObjectHelper.put(json,"tssdgroupid",getJSONValue(et.getTSSDGroupId()),false);
        }
        if(bIncEmpty||et.getTSSDGroupName()!=null) {
            JSONObjectHelper.put(json,"tssdgroupname",getJSONValue(et.getTSSDGroupName()),false);
        }
        if(bIncEmpty||et.getTSSDItemId()!=null) {
            JSONObjectHelper.put(json,"tssditemid",getJSONValue(et.getTSSDItemId()),false);
        }
        if(bIncEmpty||et.getTSSDItemName()!=null) {
            JSONObjectHelper.put(json,"tssditemname",getJSONValue(et.getTSSDItemName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
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
    private static void fillXmlNode(TSSDGroupDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDGroupDetailId()!=null) {
            Object obj = et.getTSSDGroupDetailId();
            node.setAttribute("TSSDGROUPDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDGroupDetailName()!=null) {
            Object obj = et.getTSSDGroupDetailName();
            node.setAttribute("TSSDGROUPDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDGroupId()!=null) {
            Object obj = et.getTSSDGroupId();
            node.setAttribute("TSSDGROUPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDGroupName()!=null) {
            Object obj = et.getTSSDGroupName();
            node.setAttribute("TSSDGROUPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDItemId()!=null) {
            Object obj = et.getTSSDItemId();
            node.setAttribute("TSSDITEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDItemName()!=null) {
            Object obj = et.getTSSDItemName();
            node.setAttribute("TSSDITEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDGroupDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDGroupDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isTSSDGroupDetailIdDirty() && (bIncEmpty||et.getTSSDGroupDetailId()!=null)) {
            dst.set(FIELD_TSSDGROUPDETAILID,et.getTSSDGroupDetailId());
        }
        if(et.isTSSDGroupDetailNameDirty() && (bIncEmpty||et.getTSSDGroupDetailName()!=null)) {
            dst.set(FIELD_TSSDGROUPDETAILNAME,et.getTSSDGroupDetailName());
        }
        if(et.isTSSDGroupIdDirty() && (bIncEmpty||et.getTSSDGroupId()!=null)) {
            dst.set(FIELD_TSSDGROUPID,et.getTSSDGroupId());
        }
        if(et.isTSSDGroupNameDirty() && (bIncEmpty||et.getTSSDGroupName()!=null)) {
            dst.set(FIELD_TSSDGROUPNAME,et.getTSSDGroupName());
        }
        if(et.isTSSDItemIdDirty() && (bIncEmpty||et.getTSSDItemId()!=null)) {
            dst.set(FIELD_TSSDITEMID,et.getTSSDItemId());
        }
        if(et.isTSSDItemNameDirty() && (bIncEmpty||et.getTSSDItemName()!=null)) {
            dst.set(FIELD_TSSDITEMNAME,et.getTSSDItemName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
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
        return  TSSDGroupDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDGroupDetailBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_TSSDGROUPDETAILID:
            et.resetTSSDGroupDetailId();
            return true;
        case INDEX_TSSDGROUPDETAILNAME:
            et.resetTSSDGroupDetailName();
            return true;
        case INDEX_TSSDGROUPID:
            et.resetTSSDGroupId();
            return true;
        case INDEX_TSSDGROUPNAME:
            et.resetTSSDGroupName();
            return true;
        case INDEX_TSSDITEMID:
            et.resetTSSDItemId();
            return true;
        case INDEX_TSSDITEMNAME:
            et.resetTSSDItemName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objTSSDGroupLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.TSSDGroup tssdgroup = null;
    /**
    * 获取父数据 任务时刻策略组
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.TSSDGroup getTSSDGroup() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDGroup();
        }

        if(this.getTSSDGroupId()==null)
            return null;
        synchronized(this.objTSSDGroupLock) {
            if(this.tssdgroup!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getTSSDGroupId(),tssdgroup.getTSSDGroupId())!=0) {
                    this.tssdgroup = null;
                }
            }


            if(this.tssdgroup==null) {
                net.ibizsys.psrt.srv.common.entity.TSSDGroup tssdgroup = new net.ibizsys.psrt.srv.common.entity.TSSDGroup();
                tssdgroup.setTSSDGroupId(this.getTSSDGroupId());
                net.ibizsys.psrt.srv.common.service.TSSDGroupService service = (net.ibizsys.psrt.srv.common.service.TSSDGroupService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.TSSDGroupService.class,this.getSessionFactory());
                service.autoGet(tssdgroup);
                this.tssdgroup = tssdgroup;
            }
            return this.tssdgroup;
        }
    }

    private Integer objTSSDItemLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.TSSDItem tssditem = null;
    /**
    * 获取父数据 任务时刻策略项
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.TSSDItem getTSSDItem() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDItem();
        }

        if(this.getTSSDItemId()==null)
            return null;
        synchronized(this.objTSSDItemLock) {
            if(this.tssditem!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getTSSDItemId(),tssditem.getTSSDItemId())!=0) {
                    this.tssditem = null;
                }
            }


            if(this.tssditem==null) {
                net.ibizsys.psrt.srv.common.entity.TSSDItem tssditem = new net.ibizsys.psrt.srv.common.entity.TSSDItem();
                tssditem.setTSSDItemId(this.getTSSDItemId());
                net.ibizsys.psrt.srv.common.service.TSSDItemService service = (net.ibizsys.psrt.srv.common.service.TSSDItemService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.TSSDItemService.class,this.getSessionFactory());
                service.autoGet(tssditem);
                this.tssditem = tssditem;
            }
            return this.tssditem;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private TSSDGroupDetailBase getProxyEntity() {
        return this.proxyTSSDGroupDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDGroupDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDGroupDetailBase) {
            this.proxyTSSDGroupDetailBase = (TSSDGroupDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}