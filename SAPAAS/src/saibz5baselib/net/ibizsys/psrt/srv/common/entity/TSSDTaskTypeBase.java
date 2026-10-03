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
 * 实体[TSSDTaskType] 数据对象基类
 */
public abstract class TSSDTaskTypeBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskTypeBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[保留字段3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[保留字段4]
     */
    public final static String FIELD_RESERVER4 = "RESERVER4";
    /**
     * 属性[任务对象]
     */
    public final static String FIELD_TASKOBJECT = "TASKOBJECT";
    /**
     * 属性[任务类型参数]
     */
    public final static String FIELD_TASKTYPEPARAM = "TASKTYPEPARAM";
    /**
     * 属性[任务调度任务类型标识]
     */
    public final static String FIELD_TSSDTASKTYPEID = "TSSDTASKTYPEID";
    /**
     * 属性[任务类型名称]
     */
    public final static String FIELD_TSSDTASKTYPENAME = "TSSDTASKTYPENAME";
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
    private final static int INDEX_RESERVER = 2;
    private final static int INDEX_RESERVER2 = 3;
    private final static int INDEX_RESERVER3 = 4;
    private final static int INDEX_RESERVER4 = 5;
    private final static int INDEX_TASKOBJECT = 6;
    private final static int INDEX_TASKTYPEPARAM = 7;
    private final static int INDEX_TSSDTASKTYPEID = 8;
    private final static int INDEX_TSSDTASKTYPENAME = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_TASKOBJECT, INDEX_TASKOBJECT);
        fieldIndexMap.put( FIELD_TASKTYPEPARAM, INDEX_TASKTYPEPARAM);
        fieldIndexMap.put( FIELD_TSSDTASKTYPEID, INDEX_TSSDTASKTYPEID);
        fieldIndexMap.put( FIELD_TSSDTASKTYPENAME, INDEX_TSSDTASKTYPENAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private TSSDTaskTypeBase proxyTSSDTaskTypeBase = null;
    public TSSDTaskTypeBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean taskobjectDirtyFlag = false;
    private boolean tasktypeparamDirtyFlag = false;
    private boolean tssdtasktypeidDirtyFlag = false;
    private boolean tssdtasktypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="taskobject")
    private String taskobject;
    @Column(name="tasktypeparam")
    private String tasktypeparam;
    @Column(name="tssdtasktypeid")
    private String tssdtasktypeid;
    @Column(name="tssdtasktypename")
    private String tssdtasktypename;
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
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[保留字段3]
     *  @param reserver3
     */
    public void setReserver3(String reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if(reserver3!=null) {
            reserver3 = StringHelper.trimRight(reserver3);
            if(reserver3.length()==0) {
                reserver3 = null;
            }
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public String getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[保留字段3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[保留字段3]
     */
    public void resetReserver3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver3();
            return;
        }

        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }
    /**
     *  设置属性值[保留字段4]
     *  @param reserver4
     */
    public void setReserver4(String reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if(reserver4!=null) {
            reserver4 = StringHelper.trimRight(reserver4);
            if(reserver4.length()==0) {
                reserver4 = null;
            }
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public String getReserver4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    /**
     *  获取属性值[保留字段4]是否修改
     */
    public boolean isReserver4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    /**
     *  重置属性值[保留字段4]
     */
    public void resetReserver4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver4();
            return;
        }

        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }
    /**
     *  设置属性值[任务对象]
     *  @param taskobject
     */
    public void setTaskObject(String taskobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTaskObject(taskobject);
            return;
        }
        if(taskobject!=null) {
            taskobject = StringHelper.trimRight(taskobject);
            if(taskobject.length()==0) {
                taskobject = null;
            }
        }
        this.taskobject = taskobject;
        this.taskobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务对象]
     */
    public String getTaskObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTaskObject();
        }
        return this.taskobject;
    }

    /**
     *  获取属性值[任务对象]是否修改
     */
    public boolean isTaskObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTaskObjectDirty();
        }
        return this.taskobjectDirtyFlag;
    }

    /**
     *  重置属性值[任务对象]
     */
    public void resetTaskObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTaskObject();
            return;
        }

        this.taskobjectDirtyFlag = false;
        this.taskobject = null;
    }
    /**
     *  设置属性值[任务类型参数]
     *  @param tasktypeparam
     */
    public void setTaskTypeParam(String tasktypeparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTaskTypeParam(tasktypeparam);
            return;
        }
        if(tasktypeparam!=null) {
            tasktypeparam = StringHelper.trimRight(tasktypeparam);
            if(tasktypeparam.length()==0) {
                tasktypeparam = null;
            }
        }
        this.tasktypeparam = tasktypeparam;
        this.tasktypeparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务类型参数]
     */
    public String getTaskTypeParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTaskTypeParam();
        }
        return this.tasktypeparam;
    }

    /**
     *  获取属性值[任务类型参数]是否修改
     */
    public boolean isTaskTypeParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTaskTypeParamDirty();
        }
        return this.tasktypeparamDirtyFlag;
    }

    /**
     *  重置属性值[任务类型参数]
     */
    public void resetTaskTypeParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTaskTypeParam();
            return;
        }

        this.tasktypeparamDirtyFlag = false;
        this.tasktypeparam = null;
    }
    /**
     *  设置属性值[任务调度任务类型标识]
     *  @param tssdtasktypeid
     */
    public void setTSSDTaskTypeId(String tssdtasktypeid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskTypeId(tssdtasktypeid);
            return;
        }
        if(tssdtasktypeid!=null) {
            tssdtasktypeid = StringHelper.trimRight(tssdtasktypeid);
            if(tssdtasktypeid.length()==0) {
                tssdtasktypeid = null;
            }
        }
        this.tssdtasktypeid = tssdtasktypeid;
        this.tssdtasktypeidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度任务类型标识]
     */
    public String getTSSDTaskTypeId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskTypeId();
        }
        return this.tssdtasktypeid;
    }

    /**
     *  获取属性值[任务调度任务类型标识]是否修改
     */
    public boolean isTSSDTaskTypeIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskTypeIdDirty();
        }
        return this.tssdtasktypeidDirtyFlag;
    }

    /**
     *  重置属性值[任务调度任务类型标识]
     */
    public void resetTSSDTaskTypeId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskTypeId();
            return;
        }

        this.tssdtasktypeidDirtyFlag = false;
        this.tssdtasktypeid = null;
    }
    /**
     *  设置属性值[任务类型名称]
     *  @param tssdtasktypename
     */
    public void setTSSDTaskTypeName(String tssdtasktypename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskTypeName(tssdtasktypename);
            return;
        }
        if(tssdtasktypename!=null) {
            tssdtasktypename = StringHelper.trimRight(tssdtasktypename);
            if(tssdtasktypename.length()==0) {
                tssdtasktypename = null;
            }
        }
        this.tssdtasktypename = tssdtasktypename;
        this.tssdtasktypenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务类型名称]
     */
    public String getTSSDTaskTypeName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskTypeName();
        }
        return this.tssdtasktypename;
    }

    /**
     *  获取属性值[任务类型名称]是否修改
     */
    public boolean isTSSDTaskTypeNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskTypeNameDirty();
        }
        return this.tssdtasktypenameDirtyFlag;
    }

    /**
     *  重置属性值[任务类型名称]
     */
    public void resetTSSDTaskTypeName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskTypeName();
            return;
        }

        this.tssdtasktypenameDirtyFlag = false;
        this.tssdtasktypename = null;
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
        TSSDTaskTypeBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(TSSDTaskTypeBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTaskObject();
        et.resetTaskTypeParam();
        et.resetTSSDTaskTypeId();
        et.resetTSSDTaskTypeName();
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
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isReserver3Dirty()) {
            params.put(FIELD_RESERVER3,getReserver3());
        }
        if(!bDirtyOnly || isReserver4Dirty()) {
            params.put(FIELD_RESERVER4,getReserver4());
        }
        if(!bDirtyOnly || isTaskObjectDirty()) {
            params.put(FIELD_TASKOBJECT,getTaskObject());
        }
        if(!bDirtyOnly || isTaskTypeParamDirty()) {
            params.put(FIELD_TASKTYPEPARAM,getTaskTypeParam());
        }
        if(!bDirtyOnly || isTSSDTaskTypeIdDirty()) {
            params.put(FIELD_TSSDTASKTYPEID,getTSSDTaskTypeId());
        }
        if(!bDirtyOnly || isTSSDTaskTypeNameDirty()) {
            params.put(FIELD_TSSDTASKTYPENAME,getTSSDTaskTypeName());
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

        return  TSSDTaskTypeBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDTaskTypeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_TASKOBJECT:
            return et.getTaskObject();
        case INDEX_TASKTYPEPARAM:
            return et.getTaskTypeParam();
        case INDEX_TSSDTASKTYPEID:
            return et.getTSSDTaskTypeId();
        case INDEX_TSSDTASKTYPENAME:
            return et.getTSSDTaskTypeName();
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

        TSSDTaskTypeBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDTaskTypeBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getStringValue(obj));
            return ;
        case INDEX_TASKOBJECT:
            et.setTaskObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_TASKTYPEPARAM:
            et.setTaskTypeParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKTYPEID:
            et.setTSSDTaskTypeId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKTYPENAME:
            et.setTSSDTaskTypeName(DataObject.getStringValue(obj));
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

        return  TSSDTaskTypeBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDTaskTypeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_TASKOBJECT:
            return et.getTaskObject()==null;
        case INDEX_TASKTYPEPARAM:
            return et.getTaskTypeParam()==null;
        case INDEX_TSSDTASKTYPEID:
            return et.getTSSDTaskTypeId()==null;
        case INDEX_TSSDTASKTYPENAME:
            return et.getTSSDTaskTypeName()==null;
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
        return  TSSDTaskTypeBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDTaskTypeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_TASKOBJECT:
            return et.isTaskObjectDirty();
        case INDEX_TASKTYPEPARAM:
            return et.isTaskTypeParamDirty();
        case INDEX_TSSDTASKTYPEID:
            return et.isTSSDTaskTypeIdDirty();
        case INDEX_TSSDTASKTYPENAME:
            return et.isTSSDTaskTypeNameDirty();
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
    private static  void fillJSONObject(TSSDTaskTypeBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            JSONObjectHelper.put(json,"reserver3",getJSONValue(et.getReserver3()),false);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            JSONObjectHelper.put(json,"reserver4",getJSONValue(et.getReserver4()),false);
        }
        if(bIncEmpty||et.getTaskObject()!=null) {
            JSONObjectHelper.put(json,"taskobject",getJSONValue(et.getTaskObject()),false);
        }
        if(bIncEmpty||et.getTaskTypeParam()!=null) {
            JSONObjectHelper.put(json,"tasktypeparam",getJSONValue(et.getTaskTypeParam()),false);
        }
        if(bIncEmpty||et.getTSSDTaskTypeId()!=null) {
            JSONObjectHelper.put(json,"tssdtasktypeid",getJSONValue(et.getTSSDTaskTypeId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskTypeName()!=null) {
            JSONObjectHelper.put(json,"tssdtasktypename",getJSONValue(et.getTSSDTaskTypeName()),false);
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
    private static void fillXmlNode(TSSDTaskTypeBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            Object obj = et.getReserver3();
            node.setAttribute("RESERVER3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTaskObject()!=null) {
            Object obj = et.getTaskObject();
            node.setAttribute("TASKOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTaskTypeParam()!=null) {
            Object obj = et.getTaskTypeParam();
            node.setAttribute("TASKTYPEPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskTypeId()!=null) {
            Object obj = et.getTSSDTaskTypeId();
            node.setAttribute("TSSDTASKTYPEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskTypeName()!=null) {
            Object obj = et.getTSSDTaskTypeName();
            node.setAttribute("TSSDTASKTYPENAME",(obj==null)?"":(String)obj);
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
        TSSDTaskTypeBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDTaskTypeBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isReserver3Dirty() && (bIncEmpty||et.getReserver3()!=null)) {
            dst.set(FIELD_RESERVER3,et.getReserver3());
        }
        if(et.isReserver4Dirty() && (bIncEmpty||et.getReserver4()!=null)) {
            dst.set(FIELD_RESERVER4,et.getReserver4());
        }
        if(et.isTaskObjectDirty() && (bIncEmpty||et.getTaskObject()!=null)) {
            dst.set(FIELD_TASKOBJECT,et.getTaskObject());
        }
        if(et.isTaskTypeParamDirty() && (bIncEmpty||et.getTaskTypeParam()!=null)) {
            dst.set(FIELD_TASKTYPEPARAM,et.getTaskTypeParam());
        }
        if(et.isTSSDTaskTypeIdDirty() && (bIncEmpty||et.getTSSDTaskTypeId()!=null)) {
            dst.set(FIELD_TSSDTASKTYPEID,et.getTSSDTaskTypeId());
        }
        if(et.isTSSDTaskTypeNameDirty() && (bIncEmpty||et.getTSSDTaskTypeName()!=null)) {
            dst.set(FIELD_TSSDTASKTYPENAME,et.getTSSDTaskTypeName());
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
        return  TSSDTaskTypeBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDTaskTypeBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_RESERVER3:
            et.resetReserver3();
            return true;
        case INDEX_RESERVER4:
            et.resetReserver4();
            return true;
        case INDEX_TASKOBJECT:
            et.resetTaskObject();
            return true;
        case INDEX_TASKTYPEPARAM:
            et.resetTaskTypeParam();
            return true;
        case INDEX_TSSDTASKTYPEID:
            et.resetTSSDTaskTypeId();
            return true;
        case INDEX_TSSDTASKTYPENAME:
            et.resetTSSDTaskTypeName();
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




    /**
     *  获取代理的数据对象
     */
    private TSSDTaskTypeBase getProxyEntity() {
        return this.proxyTSSDTaskTypeBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskTypeBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDTaskTypeBase) {
            this.proxyTSSDTaskTypeBase = (TSSDTaskTypeBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskTypeService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}