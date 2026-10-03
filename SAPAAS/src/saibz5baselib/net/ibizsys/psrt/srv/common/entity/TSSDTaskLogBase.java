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
 * 实体[TSSDTaskLog] 数据对象基类
 */
public abstract class TSSDTaskLogBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskLogBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[持续时间]
     */
    public final static String FIELD_DURATION = "DURATION";
    /**
     * 属性[结束时间]
     */
    public final static String FIELD_ENDTIME = "ENDTIME";
    /**
     * 属性[返回代码]
     */
    public final static String FIELD_RETCODE = "RETCODE";
    /**
     * 属性[返回信息]
     */
    public final static String FIELD_RETINFO = "RETINFO";
    /**
     * 属性[开始时间]
     */
    public final static String FIELD_STARTTIME = "STARTTIME";
    /**
     * 属性[调度任务]
     */
    public final static String FIELD_TSSDTASKID = "TSSDTASKID";
    /**
     * 属性[任务调度日志标识]
     */
    public final static String FIELD_TSSDTASKLOGID = "TSSDTASKLOGID";
    /**
     * 属性[任务调度日志名称]
     */
    public final static String FIELD_TSSDTASKLOGNAME = "TSSDTASKLOGNAME";
    /**
     * 属性[调度任务]
     */
    public final static String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
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
    private final static int INDEX_DURATION = 2;
    private final static int INDEX_ENDTIME = 3;
    private final static int INDEX_RETCODE = 4;
    private final static int INDEX_RETINFO = 5;
    private final static int INDEX_STARTTIME = 6;
    private final static int INDEX_TSSDTASKID = 7;
    private final static int INDEX_TSSDTASKLOGID = 8;
    private final static int INDEX_TSSDTASKLOGNAME = 9;
    private final static int INDEX_TSSDTASKNAME = 10;
    private final static int INDEX_UPDATEDATE = 11;
    private final static int INDEX_UPDATEMAN = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DURATION, INDEX_DURATION);
        fieldIndexMap.put( FIELD_ENDTIME, INDEX_ENDTIME);
        fieldIndexMap.put( FIELD_RETCODE, INDEX_RETCODE);
        fieldIndexMap.put( FIELD_RETINFO, INDEX_RETINFO);
        fieldIndexMap.put( FIELD_STARTTIME, INDEX_STARTTIME);
        fieldIndexMap.put( FIELD_TSSDTASKID, INDEX_TSSDTASKID);
        fieldIndexMap.put( FIELD_TSSDTASKLOGID, INDEX_TSSDTASKLOGID);
        fieldIndexMap.put( FIELD_TSSDTASKLOGNAME, INDEX_TSSDTASKLOGNAME);
        fieldIndexMap.put( FIELD_TSSDTASKNAME, INDEX_TSSDTASKNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private TSSDTaskLogBase proxyTSSDTaskLogBase = null;
    public TSSDTaskLogBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean durationDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean retcodeDirtyFlag = false;
    private boolean retinfoDirtyFlag = false;
    private boolean starttimeDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasklogidDirtyFlag = false;
    private boolean tssdtasklognameDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="duration")
    private Integer duration;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="retcode")
    private Integer retcode;
    @Column(name="retinfo")
    private String retinfo;
    @Column(name="starttime")
    private Timestamp starttime;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtasklogid")
    private String tssdtasklogid;
    @Column(name="tssdtasklogname")
    private String tssdtasklogname;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
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
     *  设置属性值[持续时间]
     *  @param duration
     */
    public void setDuration(Integer duration) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDuration(duration);
            return;
        }
        this.duration = duration;
        this.durationDirtyFlag  = true;
    }

    /**
     *  获取属性值[持续时间]
     */
    public Integer getDuration() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDuration();
        }
        return this.duration;
    }

    /**
     *  获取属性值[持续时间]是否修改
     */
    public boolean isDurationDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDurationDirty();
        }
        return this.durationDirtyFlag;
    }

    /**
     *  重置属性值[持续时间]
     */
    public void resetDuration() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDuration();
            return;
        }

        this.durationDirtyFlag = false;
        this.duration = null;
    }
    /**
     *  设置属性值[结束时间]
     *  @param endtime
     */
    public void setEndTime(Timestamp endtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEndTime(endtime);
            return;
        }
        this.endtime = endtime;
        this.endtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[结束时间]
     */
    public Timestamp getEndTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    /**
     *  获取属性值[结束时间]是否修改
     */
    public boolean isEndTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    /**
     *  重置属性值[结束时间]
     */
    public void resetEndTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEndTime();
            return;
        }

        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }
    /**
     *  设置属性值[返回代码]
     *  @param retcode
     */
    public void setRetCode(Integer retcode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRetCode(retcode);
            return;
        }
        this.retcode = retcode;
        this.retcodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[返回代码]
     */
    public Integer getRetCode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRetCode();
        }
        return this.retcode;
    }

    /**
     *  获取属性值[返回代码]是否修改
     */
    public boolean isRetCodeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRetCodeDirty();
        }
        return this.retcodeDirtyFlag;
    }

    /**
     *  重置属性值[返回代码]
     */
    public void resetRetCode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRetCode();
            return;
        }

        this.retcodeDirtyFlag = false;
        this.retcode = null;
    }
    /**
     *  设置属性值[返回信息]
     *  @param retinfo
     */
    public void setRetInfo(String retinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRetInfo(retinfo);
            return;
        }
        if(retinfo!=null) {
            retinfo = StringHelper.trimRight(retinfo);
            if(retinfo.length()==0) {
                retinfo = null;
            }
        }
        this.retinfo = retinfo;
        this.retinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[返回信息]
     */
    public String getRetInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRetInfo();
        }
        return this.retinfo;
    }

    /**
     *  获取属性值[返回信息]是否修改
     */
    public boolean isRetInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRetInfoDirty();
        }
        return this.retinfoDirtyFlag;
    }

    /**
     *  重置属性值[返回信息]
     */
    public void resetRetInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRetInfo();
            return;
        }

        this.retinfoDirtyFlag = false;
        this.retinfo = null;
    }
    /**
     *  设置属性值[开始时间]
     *  @param starttime
     */
    public void setStartTime(Timestamp starttime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setStartTime(starttime);
            return;
        }
        this.starttime = starttime;
        this.starttimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[开始时间]
     */
    public Timestamp getStartTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getStartTime();
        }
        return this.starttime;
    }

    /**
     *  获取属性值[开始时间]是否修改
     */
    public boolean isStartTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isStartTimeDirty();
        }
        return this.starttimeDirtyFlag;
    }

    /**
     *  重置属性值[开始时间]
     */
    public void resetStartTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetStartTime();
            return;
        }

        this.starttimeDirtyFlag = false;
        this.starttime = null;
    }
    /**
     *  设置属性值[调度任务]
     *  @param tssdtaskid
     */
    public void setTSSDTaskId(String tssdtaskid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskId(tssdtaskid);
            return;
        }
        if(tssdtaskid!=null) {
            tssdtaskid = StringHelper.trimRight(tssdtaskid);
            if(tssdtaskid.length()==0) {
                tssdtaskid = null;
            }
        }
        this.tssdtaskid = tssdtaskid;
        this.tssdtaskidDirtyFlag  = true;
    }

    /**
     *  获取属性值[调度任务]
     */
    public String getTSSDTaskId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskId();
        }
        return this.tssdtaskid;
    }

    /**
     *  获取属性值[调度任务]是否修改
     */
    public boolean isTSSDTaskIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskIdDirty();
        }
        return this.tssdtaskidDirtyFlag;
    }

    /**
     *  重置属性值[调度任务]
     */
    public void resetTSSDTaskId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskId();
            return;
        }

        this.tssdtaskidDirtyFlag = false;
        this.tssdtaskid = null;
    }
    /**
     *  设置属性值[任务调度日志标识]
     *  @param tssdtasklogid
     */
    public void setTSSDTaskLogId(String tssdtasklogid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskLogId(tssdtasklogid);
            return;
        }
        if(tssdtasklogid!=null) {
            tssdtasklogid = StringHelper.trimRight(tssdtasklogid);
            if(tssdtasklogid.length()==0) {
                tssdtasklogid = null;
            }
        }
        this.tssdtasklogid = tssdtasklogid;
        this.tssdtasklogidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度日志标识]
     */
    public String getTSSDTaskLogId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskLogId();
        }
        return this.tssdtasklogid;
    }

    /**
     *  获取属性值[任务调度日志标识]是否修改
     */
    public boolean isTSSDTaskLogIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskLogIdDirty();
        }
        return this.tssdtasklogidDirtyFlag;
    }

    /**
     *  重置属性值[任务调度日志标识]
     */
    public void resetTSSDTaskLogId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskLogId();
            return;
        }

        this.tssdtasklogidDirtyFlag = false;
        this.tssdtasklogid = null;
    }
    /**
     *  设置属性值[任务调度日志名称]
     *  @param tssdtasklogname
     */
    public void setTSSDTaskLogName(String tssdtasklogname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskLogName(tssdtasklogname);
            return;
        }
        if(tssdtasklogname!=null) {
            tssdtasklogname = StringHelper.trimRight(tssdtasklogname);
            if(tssdtasklogname.length()==0) {
                tssdtasklogname = null;
            }
        }
        this.tssdtasklogname = tssdtasklogname;
        this.tssdtasklognameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务调度日志名称]
     */
    public String getTSSDTaskLogName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskLogName();
        }
        return this.tssdtasklogname;
    }

    /**
     *  获取属性值[任务调度日志名称]是否修改
     */
    public boolean isTSSDTaskLogNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskLogNameDirty();
        }
        return this.tssdtasklognameDirtyFlag;
    }

    /**
     *  重置属性值[任务调度日志名称]
     */
    public void resetTSSDTaskLogName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskLogName();
            return;
        }

        this.tssdtasklognameDirtyFlag = false;
        this.tssdtasklogname = null;
    }
    /**
     *  设置属性值[调度任务]
     *  @param tssdtaskname
     */
    public void setTSSDTaskName(String tssdtaskname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskName(tssdtaskname);
            return;
        }
        if(tssdtaskname!=null) {
            tssdtaskname = StringHelper.trimRight(tssdtaskname);
            if(tssdtaskname.length()==0) {
                tssdtaskname = null;
            }
        }
        this.tssdtaskname = tssdtaskname;
        this.tssdtasknameDirtyFlag  = true;
    }

    /**
     *  获取属性值[调度任务]
     */
    public String getTSSDTaskName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskName();
        }
        return this.tssdtaskname;
    }

    /**
     *  获取属性值[调度任务]是否修改
     */
    public boolean isTSSDTaskNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskNameDirty();
        }
        return this.tssdtasknameDirtyFlag;
    }

    /**
     *  重置属性值[调度任务]
     */
    public void resetTSSDTaskName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskName();
            return;
        }

        this.tssdtasknameDirtyFlag = false;
        this.tssdtaskname = null;
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
        TSSDTaskLogBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(TSSDTaskLogBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDuration();
        et.resetEndTime();
        et.resetRetCode();
        et.resetRetInfo();
        et.resetStartTime();
        et.resetTSSDTaskId();
        et.resetTSSDTaskLogId();
        et.resetTSSDTaskLogName();
        et.resetTSSDTaskName();
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
        if(!bDirtyOnly || isDurationDirty()) {
            params.put(FIELD_DURATION,getDuration());
        }
        if(!bDirtyOnly || isEndTimeDirty()) {
            params.put(FIELD_ENDTIME,getEndTime());
        }
        if(!bDirtyOnly || isRetCodeDirty()) {
            params.put(FIELD_RETCODE,getRetCode());
        }
        if(!bDirtyOnly || isRetInfoDirty()) {
            params.put(FIELD_RETINFO,getRetInfo());
        }
        if(!bDirtyOnly || isStartTimeDirty()) {
            params.put(FIELD_STARTTIME,getStartTime());
        }
        if(!bDirtyOnly || isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID,getTSSDTaskId());
        }
        if(!bDirtyOnly || isTSSDTaskLogIdDirty()) {
            params.put(FIELD_TSSDTASKLOGID,getTSSDTaskLogId());
        }
        if(!bDirtyOnly || isTSSDTaskLogNameDirty()) {
            params.put(FIELD_TSSDTASKLOGNAME,getTSSDTaskLogName());
        }
        if(!bDirtyOnly || isTSSDTaskNameDirty()) {
            params.put(FIELD_TSSDTASKNAME,getTSSDTaskName());
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

        return  TSSDTaskLogBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDTaskLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DURATION:
            return et.getDuration();
        case INDEX_ENDTIME:
            return et.getEndTime();
        case INDEX_RETCODE:
            return et.getRetCode();
        case INDEX_RETINFO:
            return et.getRetInfo();
        case INDEX_STARTTIME:
            return et.getStartTime();
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId();
        case INDEX_TSSDTASKLOGID:
            return et.getTSSDTaskLogId();
        case INDEX_TSSDTASKLOGNAME:
            return et.getTSSDTaskLogName();
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName();
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

        TSSDTaskLogBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDTaskLogBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DURATION:
            et.setDuration(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ENDTIME:
            et.setEndTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_RETCODE:
            et.setRetCode(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RETINFO:
            et.setRetInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_STARTTIME:
            et.setStartTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_TSSDTASKID:
            et.setTSSDTaskId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKLOGID:
            et.setTSSDTaskLogId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKLOGNAME:
            et.setTSSDTaskLogName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKNAME:
            et.setTSSDTaskName(DataObject.getStringValue(obj));
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

        return  TSSDTaskLogBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDTaskLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DURATION:
            return et.getDuration()==null;
        case INDEX_ENDTIME:
            return et.getEndTime()==null;
        case INDEX_RETCODE:
            return et.getRetCode()==null;
        case INDEX_RETINFO:
            return et.getRetInfo()==null;
        case INDEX_STARTTIME:
            return et.getStartTime()==null;
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId()==null;
        case INDEX_TSSDTASKLOGID:
            return et.getTSSDTaskLogId()==null;
        case INDEX_TSSDTASKLOGNAME:
            return et.getTSSDTaskLogName()==null;
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName()==null;
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
        return  TSSDTaskLogBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDTaskLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DURATION:
            return et.isDurationDirty();
        case INDEX_ENDTIME:
            return et.isEndTimeDirty();
        case INDEX_RETCODE:
            return et.isRetCodeDirty();
        case INDEX_RETINFO:
            return et.isRetInfoDirty();
        case INDEX_STARTTIME:
            return et.isStartTimeDirty();
        case INDEX_TSSDTASKID:
            return et.isTSSDTaskIdDirty();
        case INDEX_TSSDTASKLOGID:
            return et.isTSSDTaskLogIdDirty();
        case INDEX_TSSDTASKLOGNAME:
            return et.isTSSDTaskLogNameDirty();
        case INDEX_TSSDTASKNAME:
            return et.isTSSDTaskNameDirty();
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
    private static  void fillJSONObject(TSSDTaskLogBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDuration()!=null) {
            JSONObjectHelper.put(json,"duration",getJSONValue(et.getDuration()),false);
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            JSONObjectHelper.put(json,"endtime",getJSONValue(et.getEndTime()),false);
        }
        if(bIncEmpty||et.getRetCode()!=null) {
            JSONObjectHelper.put(json,"retcode",getJSONValue(et.getRetCode()),false);
        }
        if(bIncEmpty||et.getRetInfo()!=null) {
            JSONObjectHelper.put(json,"retinfo",getJSONValue(et.getRetInfo()),false);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            JSONObjectHelper.put(json,"starttime",getJSONValue(et.getStartTime()),false);
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            JSONObjectHelper.put(json,"tssdtaskid",getJSONValue(et.getTSSDTaskId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskLogId()!=null) {
            JSONObjectHelper.put(json,"tssdtasklogid",getJSONValue(et.getTSSDTaskLogId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskLogName()!=null) {
            JSONObjectHelper.put(json,"tssdtasklogname",getJSONValue(et.getTSSDTaskLogName()),false);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            JSONObjectHelper.put(json,"tssdtaskname",getJSONValue(et.getTSSDTaskName()),false);
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
    private static void fillXmlNode(TSSDTaskLogBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDuration()!=null) {
            Object obj = et.getDuration();
            node.setAttribute("DURATION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            Object obj = et.getEndTime();
            node.setAttribute("ENDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getRetCode()!=null) {
            Object obj = et.getRetCode();
            node.setAttribute("RETCODE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getRetInfo()!=null) {
            Object obj = et.getRetInfo();
            node.setAttribute("RETINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            Object obj = et.getStartTime();
            node.setAttribute("STARTTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            Object obj = et.getTSSDTaskId();
            node.setAttribute("TSSDTASKID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskLogId()!=null) {
            Object obj = et.getTSSDTaskLogId();
            node.setAttribute("TSSDTASKLOGID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskLogName()!=null) {
            Object obj = et.getTSSDTaskLogName();
            node.setAttribute("TSSDTASKLOGNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            Object obj = et.getTSSDTaskName();
            node.setAttribute("TSSDTASKNAME",(obj==null)?"":(String)obj);
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
        TSSDTaskLogBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDTaskLogBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDurationDirty() && (bIncEmpty||et.getDuration()!=null)) {
            dst.set(FIELD_DURATION,et.getDuration());
        }
        if(et.isEndTimeDirty() && (bIncEmpty||et.getEndTime()!=null)) {
            dst.set(FIELD_ENDTIME,et.getEndTime());
        }
        if(et.isRetCodeDirty() && (bIncEmpty||et.getRetCode()!=null)) {
            dst.set(FIELD_RETCODE,et.getRetCode());
        }
        if(et.isRetInfoDirty() && (bIncEmpty||et.getRetInfo()!=null)) {
            dst.set(FIELD_RETINFO,et.getRetInfo());
        }
        if(et.isStartTimeDirty() && (bIncEmpty||et.getStartTime()!=null)) {
            dst.set(FIELD_STARTTIME,et.getStartTime());
        }
        if(et.isTSSDTaskIdDirty() && (bIncEmpty||et.getTSSDTaskId()!=null)) {
            dst.set(FIELD_TSSDTASKID,et.getTSSDTaskId());
        }
        if(et.isTSSDTaskLogIdDirty() && (bIncEmpty||et.getTSSDTaskLogId()!=null)) {
            dst.set(FIELD_TSSDTASKLOGID,et.getTSSDTaskLogId());
        }
        if(et.isTSSDTaskLogNameDirty() && (bIncEmpty||et.getTSSDTaskLogName()!=null)) {
            dst.set(FIELD_TSSDTASKLOGNAME,et.getTSSDTaskLogName());
        }
        if(et.isTSSDTaskNameDirty() && (bIncEmpty||et.getTSSDTaskName()!=null)) {
            dst.set(FIELD_TSSDTASKNAME,et.getTSSDTaskName());
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
        return  TSSDTaskLogBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDTaskLogBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DURATION:
            et.resetDuration();
            return true;
        case INDEX_ENDTIME:
            et.resetEndTime();
            return true;
        case INDEX_RETCODE:
            et.resetRetCode();
            return true;
        case INDEX_RETINFO:
            et.resetRetInfo();
            return true;
        case INDEX_STARTTIME:
            et.resetStartTime();
            return true;
        case INDEX_TSSDTASKID:
            et.resetTSSDTaskId();
            return true;
        case INDEX_TSSDTASKLOGID:
            et.resetTSSDTaskLogId();
            return true;
        case INDEX_TSSDTASKLOGNAME:
            et.resetTSSDTaskLogName();
            return true;
        case INDEX_TSSDTASKNAME:
            et.resetTSSDTaskName();
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


    private Integer objTSSDTaskLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.TSSDTask tssdtask = null;
    /**
    * 获取父数据 任务调度任务项
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.TSSDTask getTSSDTask() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTask();
        }

        if(this.getTSSDTaskId()==null)
            return null;
        synchronized(this.objTSSDTaskLock) {
            if(this.tssdtask!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getTSSDTaskId(),tssdtask.getTSSDTaskId())!=0) {
                    this.tssdtask = null;
                }
            }


            if(this.tssdtask==null) {
                net.ibizsys.psrt.srv.common.entity.TSSDTask tssdtask = new net.ibizsys.psrt.srv.common.entity.TSSDTask();
                tssdtask.setTSSDTaskId(this.getTSSDTaskId());
                net.ibizsys.psrt.srv.common.service.TSSDTaskService service = (net.ibizsys.psrt.srv.common.service.TSSDTaskService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.TSSDTaskService.class,this.getSessionFactory());
                service.autoGet(tssdtask);
                this.tssdtask = tssdtask;
            }
            return this.tssdtask;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private TSSDTaskLogBase getProxyEntity() {
        return this.proxyTSSDTaskLogBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskLogBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDTaskLogBase) {
            this.proxyTSSDTaskLogBase = (TSSDTaskLogBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskLogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}