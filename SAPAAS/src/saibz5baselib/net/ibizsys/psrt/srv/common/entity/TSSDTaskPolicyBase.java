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
 * 实体[TSSDTaskPolicy] 数据对象基类
 */
public abstract class TSSDTaskPolicyBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskPolicyBase.class);
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
     * 属性[任务运行策略]
     */
    public final static String FIELD_TSSDPOLICYID = "TSSDPOLICYID";
    /**
     * 属性[任务运行策略]
     */
    public final static String FIELD_TSSDPOLICYNAME = "TSSDPOLICYNAME";
    /**
     * 属性[调度任务]
     */
    public final static String FIELD_TSSDTASKID = "TSSDTASKID";
    /**
     * 属性[调度任务]
     */
    public final static String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
    /**
     * 属性[调度任务项策略标识]
     */
    public final static String FIELD_TSSDTASKPOLICYID = "TSSDTASKPOLICYID";
    /**
     * 属性[调度任务项策略名称]
     */
    public final static String FIELD_TSSDTASKPOLICYNAME = "TSSDTASKPOLICYNAME";
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
    private final static int INDEX_TSSDPOLICYID = 6;
    private final static int INDEX_TSSDPOLICYNAME = 7;
    private final static int INDEX_TSSDTASKID = 8;
    private final static int INDEX_TSSDTASKNAME = 9;
    private final static int INDEX_TSSDTASKPOLICYID = 10;
    private final static int INDEX_TSSDTASKPOLICYNAME = 11;
    private final static int INDEX_UPDATEDATE = 12;
    private final static int INDEX_UPDATEMAN = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_TSSDPOLICYID, INDEX_TSSDPOLICYID);
        fieldIndexMap.put( FIELD_TSSDPOLICYNAME, INDEX_TSSDPOLICYNAME);
        fieldIndexMap.put( FIELD_TSSDTASKID, INDEX_TSSDTASKID);
        fieldIndexMap.put( FIELD_TSSDTASKNAME, INDEX_TSSDTASKNAME);
        fieldIndexMap.put( FIELD_TSSDTASKPOLICYID, INDEX_TSSDTASKPOLICYID);
        fieldIndexMap.put( FIELD_TSSDTASKPOLICYNAME, INDEX_TSSDTASKPOLICYNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private TSSDTaskPolicyBase proxyTSSDTaskPolicyBase = null;
    public TSSDTaskPolicyBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean tssdpolicyidDirtyFlag = false;
    private boolean tssdpolicynameDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean tssdtaskpolicyidDirtyFlag = false;
    private boolean tssdtaskpolicynameDirtyFlag = false;
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
    @Column(name="tssdpolicyid")
    private String tssdpolicyid;
    @Column(name="tssdpolicyname")
    private String tssdpolicyname;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
    @Column(name="tssdtaskpolicyid")
    private String tssdtaskpolicyid;
    @Column(name="tssdtaskpolicyname")
    private String tssdtaskpolicyname;
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
     *  设置属性值[任务运行策略]
     *  @param tssdpolicyid
     */
    public void setTSSDPolicyId(String tssdpolicyid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDPolicyId(tssdpolicyid);
            return;
        }
        if(tssdpolicyid!=null) {
            tssdpolicyid = StringHelper.trimRight(tssdpolicyid);
            if(tssdpolicyid.length()==0) {
                tssdpolicyid = null;
            }
        }
        this.tssdpolicyid = tssdpolicyid;
        this.tssdpolicyidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务运行策略]
     */
    public String getTSSDPolicyId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDPolicyId();
        }
        return this.tssdpolicyid;
    }

    /**
     *  获取属性值[任务运行策略]是否修改
     */
    public boolean isTSSDPolicyIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDPolicyIdDirty();
        }
        return this.tssdpolicyidDirtyFlag;
    }

    /**
     *  重置属性值[任务运行策略]
     */
    public void resetTSSDPolicyId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDPolicyId();
            return;
        }

        this.tssdpolicyidDirtyFlag = false;
        this.tssdpolicyid = null;
    }
    /**
     *  设置属性值[任务运行策略]
     *  @param tssdpolicyname
     */
    public void setTSSDPolicyName(String tssdpolicyname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDPolicyName(tssdpolicyname);
            return;
        }
        if(tssdpolicyname!=null) {
            tssdpolicyname = StringHelper.trimRight(tssdpolicyname);
            if(tssdpolicyname.length()==0) {
                tssdpolicyname = null;
            }
        }
        this.tssdpolicyname = tssdpolicyname;
        this.tssdpolicynameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务运行策略]
     */
    public String getTSSDPolicyName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDPolicyName();
        }
        return this.tssdpolicyname;
    }

    /**
     *  获取属性值[任务运行策略]是否修改
     */
    public boolean isTSSDPolicyNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDPolicyNameDirty();
        }
        return this.tssdpolicynameDirtyFlag;
    }

    /**
     *  重置属性值[任务运行策略]
     */
    public void resetTSSDPolicyName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDPolicyName();
            return;
        }

        this.tssdpolicynameDirtyFlag = false;
        this.tssdpolicyname = null;
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
     *  设置属性值[调度任务项策略标识]
     *  @param tssdtaskpolicyid
     */
    public void setTSSDTaskPolicyId(String tssdtaskpolicyid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskPolicyId(tssdtaskpolicyid);
            return;
        }
        if(tssdtaskpolicyid!=null) {
            tssdtaskpolicyid = StringHelper.trimRight(tssdtaskpolicyid);
            if(tssdtaskpolicyid.length()==0) {
                tssdtaskpolicyid = null;
            }
        }
        this.tssdtaskpolicyid = tssdtaskpolicyid;
        this.tssdtaskpolicyidDirtyFlag  = true;
    }

    /**
     *  获取属性值[调度任务项策略标识]
     */
    public String getTSSDTaskPolicyId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskPolicyId();
        }
        return this.tssdtaskpolicyid;
    }

    /**
     *  获取属性值[调度任务项策略标识]是否修改
     */
    public boolean isTSSDTaskPolicyIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskPolicyIdDirty();
        }
        return this.tssdtaskpolicyidDirtyFlag;
    }

    /**
     *  重置属性值[调度任务项策略标识]
     */
    public void resetTSSDTaskPolicyId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskPolicyId();
            return;
        }

        this.tssdtaskpolicyidDirtyFlag = false;
        this.tssdtaskpolicyid = null;
    }
    /**
     *  设置属性值[调度任务项策略名称]
     *  @param tssdtaskpolicyname
     */
    public void setTSSDTaskPolicyName(String tssdtaskpolicyname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDTaskPolicyName(tssdtaskpolicyname);
            return;
        }
        if(tssdtaskpolicyname!=null) {
            tssdtaskpolicyname = StringHelper.trimRight(tssdtaskpolicyname);
            if(tssdtaskpolicyname.length()==0) {
                tssdtaskpolicyname = null;
            }
        }
        this.tssdtaskpolicyname = tssdtaskpolicyname;
        this.tssdtaskpolicynameDirtyFlag  = true;
    }

    /**
     *  获取属性值[调度任务项策略名称]
     */
    public String getTSSDTaskPolicyName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDTaskPolicyName();
        }
        return this.tssdtaskpolicyname;
    }

    /**
     *  获取属性值[调度任务项策略名称]是否修改
     */
    public boolean isTSSDTaskPolicyNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDTaskPolicyNameDirty();
        }
        return this.tssdtaskpolicynameDirtyFlag;
    }

    /**
     *  重置属性值[调度任务项策略名称]
     */
    public void resetTSSDTaskPolicyName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDTaskPolicyName();
            return;
        }

        this.tssdtaskpolicynameDirtyFlag = false;
        this.tssdtaskpolicyname = null;
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
        TSSDTaskPolicyBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(TSSDTaskPolicyBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTSSDPolicyId();
        et.resetTSSDPolicyName();
        et.resetTSSDTaskId();
        et.resetTSSDTaskName();
        et.resetTSSDTaskPolicyId();
        et.resetTSSDTaskPolicyName();
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
        if(!bDirtyOnly || isTSSDPolicyIdDirty()) {
            params.put(FIELD_TSSDPOLICYID,getTSSDPolicyId());
        }
        if(!bDirtyOnly || isTSSDPolicyNameDirty()) {
            params.put(FIELD_TSSDPOLICYNAME,getTSSDPolicyName());
        }
        if(!bDirtyOnly || isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID,getTSSDTaskId());
        }
        if(!bDirtyOnly || isTSSDTaskNameDirty()) {
            params.put(FIELD_TSSDTASKNAME,getTSSDTaskName());
        }
        if(!bDirtyOnly || isTSSDTaskPolicyIdDirty()) {
            params.put(FIELD_TSSDTASKPOLICYID,getTSSDTaskPolicyId());
        }
        if(!bDirtyOnly || isTSSDTaskPolicyNameDirty()) {
            params.put(FIELD_TSSDTASKPOLICYNAME,getTSSDTaskPolicyName());
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

        return  TSSDTaskPolicyBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDTaskPolicyBase et,int index) throws Exception {

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
        case INDEX_TSSDPOLICYID:
            return et.getTSSDPolicyId();
        case INDEX_TSSDPOLICYNAME:
            return et.getTSSDPolicyName();
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId();
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName();
        case INDEX_TSSDTASKPOLICYID:
            return et.getTSSDTaskPolicyId();
        case INDEX_TSSDTASKPOLICYNAME:
            return et.getTSSDTaskPolicyName();
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

        TSSDTaskPolicyBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDTaskPolicyBase et,int index,Object obj) throws Exception {
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
        case INDEX_TSSDPOLICYID:
            et.setTSSDPolicyId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDPOLICYNAME:
            et.setTSSDPolicyName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKID:
            et.setTSSDTaskId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKNAME:
            et.setTSSDTaskName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKPOLICYID:
            et.setTSSDTaskPolicyId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDTASKPOLICYNAME:
            et.setTSSDTaskPolicyName(DataObject.getStringValue(obj));
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

        return  TSSDTaskPolicyBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDTaskPolicyBase et,int index) throws Exception {

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
        case INDEX_TSSDPOLICYID:
            return et.getTSSDPolicyId()==null;
        case INDEX_TSSDPOLICYNAME:
            return et.getTSSDPolicyName()==null;
        case INDEX_TSSDTASKID:
            return et.getTSSDTaskId()==null;
        case INDEX_TSSDTASKNAME:
            return et.getTSSDTaskName()==null;
        case INDEX_TSSDTASKPOLICYID:
            return et.getTSSDTaskPolicyId()==null;
        case INDEX_TSSDTASKPOLICYNAME:
            return et.getTSSDTaskPolicyName()==null;
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
        return  TSSDTaskPolicyBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDTaskPolicyBase et,int index) throws Exception {

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
        case INDEX_TSSDPOLICYID:
            return et.isTSSDPolicyIdDirty();
        case INDEX_TSSDPOLICYNAME:
            return et.isTSSDPolicyNameDirty();
        case INDEX_TSSDTASKID:
            return et.isTSSDTaskIdDirty();
        case INDEX_TSSDTASKNAME:
            return et.isTSSDTaskNameDirty();
        case INDEX_TSSDTASKPOLICYID:
            return et.isTSSDTaskPolicyIdDirty();
        case INDEX_TSSDTASKPOLICYNAME:
            return et.isTSSDTaskPolicyNameDirty();
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
    private static  void fillJSONObject(TSSDTaskPolicyBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getTSSDPolicyId()!=null) {
            JSONObjectHelper.put(json,"tssdpolicyid",getJSONValue(et.getTSSDPolicyId()),false);
        }
        if(bIncEmpty||et.getTSSDPolicyName()!=null) {
            JSONObjectHelper.put(json,"tssdpolicyname",getJSONValue(et.getTSSDPolicyName()),false);
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            JSONObjectHelper.put(json,"tssdtaskid",getJSONValue(et.getTSSDTaskId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            JSONObjectHelper.put(json,"tssdtaskname",getJSONValue(et.getTSSDTaskName()),false);
        }
        if(bIncEmpty||et.getTSSDTaskPolicyId()!=null) {
            JSONObjectHelper.put(json,"tssdtaskpolicyid",getJSONValue(et.getTSSDTaskPolicyId()),false);
        }
        if(bIncEmpty||et.getTSSDTaskPolicyName()!=null) {
            JSONObjectHelper.put(json,"tssdtaskpolicyname",getJSONValue(et.getTSSDTaskPolicyName()),false);
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
    private static void fillXmlNode(TSSDTaskPolicyBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getTSSDPolicyId()!=null) {
            Object obj = et.getTSSDPolicyId();
            node.setAttribute("TSSDPOLICYID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDPolicyName()!=null) {
            Object obj = et.getTSSDPolicyName();
            node.setAttribute("TSSDPOLICYNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskId()!=null) {
            Object obj = et.getTSSDTaskId();
            node.setAttribute("TSSDTASKID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskName()!=null) {
            Object obj = et.getTSSDTaskName();
            node.setAttribute("TSSDTASKNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskPolicyId()!=null) {
            Object obj = et.getTSSDTaskPolicyId();
            node.setAttribute("TSSDTASKPOLICYID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDTaskPolicyName()!=null) {
            Object obj = et.getTSSDTaskPolicyName();
            node.setAttribute("TSSDTASKPOLICYNAME",(obj==null)?"":(String)obj);
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
        TSSDTaskPolicyBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDTaskPolicyBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isTSSDPolicyIdDirty() && (bIncEmpty||et.getTSSDPolicyId()!=null)) {
            dst.set(FIELD_TSSDPOLICYID,et.getTSSDPolicyId());
        }
        if(et.isTSSDPolicyNameDirty() && (bIncEmpty||et.getTSSDPolicyName()!=null)) {
            dst.set(FIELD_TSSDPOLICYNAME,et.getTSSDPolicyName());
        }
        if(et.isTSSDTaskIdDirty() && (bIncEmpty||et.getTSSDTaskId()!=null)) {
            dst.set(FIELD_TSSDTASKID,et.getTSSDTaskId());
        }
        if(et.isTSSDTaskNameDirty() && (bIncEmpty||et.getTSSDTaskName()!=null)) {
            dst.set(FIELD_TSSDTASKNAME,et.getTSSDTaskName());
        }
        if(et.isTSSDTaskPolicyIdDirty() && (bIncEmpty||et.getTSSDTaskPolicyId()!=null)) {
            dst.set(FIELD_TSSDTASKPOLICYID,et.getTSSDTaskPolicyId());
        }
        if(et.isTSSDTaskPolicyNameDirty() && (bIncEmpty||et.getTSSDTaskPolicyName()!=null)) {
            dst.set(FIELD_TSSDTASKPOLICYNAME,et.getTSSDTaskPolicyName());
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
        return  TSSDTaskPolicyBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDTaskPolicyBase et,int index) throws Exception {
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
        case INDEX_TSSDPOLICYID:
            et.resetTSSDPolicyId();
            return true;
        case INDEX_TSSDPOLICYNAME:
            et.resetTSSDPolicyName();
            return true;
        case INDEX_TSSDTASKID:
            et.resetTSSDTaskId();
            return true;
        case INDEX_TSSDTASKNAME:
            et.resetTSSDTaskName();
            return true;
        case INDEX_TSSDTASKPOLICYID:
            et.resetTSSDTaskPolicyId();
            return true;
        case INDEX_TSSDTASKPOLICYNAME:
            et.resetTSSDTaskPolicyName();
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


    private Integer objTSSDPolicyLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.TSSDPolicy tssdpolicy = null;
    /**
    * 获取父数据 任务时刻策略
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.TSSDPolicy getTSSDPolicy() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDPolicy();
        }

        if(this.getTSSDPolicyId()==null)
            return null;
        synchronized(this.objTSSDPolicyLock) {
            if(this.tssdpolicy!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getTSSDPolicyId(),tssdpolicy.getTSSDPolicyId())!=0) {
                    this.tssdpolicy = null;
                }
            }


            if(this.tssdpolicy==null) {
                net.ibizsys.psrt.srv.common.entity.TSSDPolicy tssdpolicy = new net.ibizsys.psrt.srv.common.entity.TSSDPolicy();
                tssdpolicy.setTSSDPolicyId(this.getTSSDPolicyId());
                net.ibizsys.psrt.srv.common.service.TSSDPolicyService service = (net.ibizsys.psrt.srv.common.service.TSSDPolicyService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.TSSDPolicyService.class,this.getSessionFactory());
                service.autoGet(tssdpolicy);
                this.tssdpolicy = tssdpolicy;
            }
            return this.tssdpolicy;
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
    private TSSDTaskPolicyBase getProxyEntity() {
        return this.proxyTSSDTaskPolicyBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskPolicyBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDTaskPolicyBase) {
            this.proxyTSSDTaskPolicyBase = (TSSDTaskPolicyBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}