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
 * 实体[WFReminder] 数据对象基类
 */
public abstract class WFReminderBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFReminderBase.class);
    /**
     * 属性[催办对象]
     */
    public final static String FIELD_ACTORID = "ACTORID";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[催办备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[已催次数]
     */
    public final static String FIELD_REMINDERCOUNT = "REMINDERCOUNT";
    /**
     * 属性[催办时间]
     */
    public final static String FIELD_REMINDERTIME = "REMINDERTIME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[送交时间]
     */
    public final static String FIELD_WFCREATEDATE = "WFCREATEDATE";
    /**
     * 属性[工作流工作催办标识]
     */
    public final static String FIELD_WFREMINDERID = "WFREMINDERID";
    /**
     * 属性[标题]
     */
    public final static String FIELD_WFREMINDERNAME = "WFREMINDERNAME";
    /**
     * 属性[工作流催办_操作者]
     */
    public final static String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    /**
     * 属性[工作操作者]
     */
    public final static String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    /**
     * 属性[催办者]
     */
    public final static String FIELD_WFUSERID = "WFUSERID";
    /**
     * 属性[催办者]
     */
    public final static String FIELD_WFUSERNAME = "WFUSERNAME";

    private final static int INDEX_ACTORID = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_REMINDERCOUNT = 4;
    private final static int INDEX_REMINDERTIME = 5;
    private final static int INDEX_UPDATEDATE = 6;
    private final static int INDEX_UPDATEMAN = 7;
    private final static int INDEX_WFCREATEDATE = 8;
    private final static int INDEX_WFREMINDERID = 9;
    private final static int INDEX_WFREMINDERNAME = 10;
    private final static int INDEX_WFSTEPACTORID = 11;
    private final static int INDEX_WFSTEPACTORNAME = 12;
    private final static int INDEX_WFUSERID = 13;
    private final static int INDEX_WFUSERNAME = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTORID, INDEX_ACTORID);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_REMINDERCOUNT, INDEX_REMINDERCOUNT);
        fieldIndexMap.put( FIELD_REMINDERTIME, INDEX_REMINDERTIME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFCREATEDATE, INDEX_WFCREATEDATE);
        fieldIndexMap.put( FIELD_WFREMINDERID, INDEX_WFREMINDERID);
        fieldIndexMap.put( FIELD_WFREMINDERNAME, INDEX_WFREMINDERNAME);
        fieldIndexMap.put( FIELD_WFSTEPACTORID, INDEX_WFSTEPACTORID);
        fieldIndexMap.put( FIELD_WFSTEPACTORNAME, INDEX_WFSTEPACTORNAME);
        fieldIndexMap.put( FIELD_WFUSERID, INDEX_WFUSERID);
        fieldIndexMap.put( FIELD_WFUSERNAME, INDEX_WFUSERNAME);
    }

    private WFReminderBase proxyWFReminderBase = null;
    public WFReminderBase() {
        super();
    }
    private boolean actoridDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean remindercountDirtyFlag = false;
    private boolean remindertimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfcreatedateDirtyFlag = false;
    private boolean wfreminderidDirtyFlag = false;
    private boolean wfremindernameDirtyFlag = false;
    private boolean wfstepactoridDirtyFlag = false;
    private boolean wfstepactornameDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;

    @Column(name="actorid")
    private String actorid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="remindercount")
    private Integer remindercount;
    @Column(name="remindertime")
    private Timestamp remindertime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfcreatedate")
    private Timestamp wfcreatedate;
    @Column(name="wfreminderid")
    private String wfreminderid;
    @Column(name="wfremindername")
    private String wfremindername;
    @Column(name="wfstepactorid")
    private String wfstepactorid;
    @Column(name="wfstepactorname")
    private String wfstepactorname;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;


    /**
     *  设置属性值[催办对象]
     *  @param actorid
     */
    public void setActorId(String actorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActorId(actorid);
            return;
        }
        if(actorid!=null) {
            actorid = StringHelper.trimRight(actorid);
            if(actorid.length()==0) {
                actorid = null;
            }
        }
        this.actorid = actorid;
        this.actoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办对象]
     */
    public String getActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorId();
        }
        return this.actorid;
    }

    /**
     *  获取属性值[催办对象]是否修改
     */
    public boolean isActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorIdDirty();
        }
        return this.actoridDirtyFlag;
    }

    /**
     *  重置属性值[催办对象]
     */
    public void resetActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActorId();
            return;
        }

        this.actoridDirtyFlag = false;
        this.actorid = null;
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
     *  设置属性值[催办备注]
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
     *  获取属性值[催办备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[催办备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[催办备注]
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
     *  设置属性值[已催次数]
     *  @param remindercount
     */
    public void setReminderCount(Integer remindercount) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReminderCount(remindercount);
            return;
        }
        this.remindercount = remindercount;
        this.remindercountDirtyFlag  = true;
    }

    /**
     *  获取属性值[已催次数]
     */
    public Integer getReminderCount() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReminderCount();
        }
        return this.remindercount;
    }

    /**
     *  获取属性值[已催次数]是否修改
     */
    public boolean isReminderCountDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReminderCountDirty();
        }
        return this.remindercountDirtyFlag;
    }

    /**
     *  重置属性值[已催次数]
     */
    public void resetReminderCount() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReminderCount();
            return;
        }

        this.remindercountDirtyFlag = false;
        this.remindercount = null;
    }
    /**
     *  设置属性值[催办时间]
     *  @param remindertime
     */
    public void setReminderTime(Timestamp remindertime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReminderTime(remindertime);
            return;
        }
        this.remindertime = remindertime;
        this.remindertimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办时间]
     */
    public Timestamp getReminderTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReminderTime();
        }
        return this.remindertime;
    }

    /**
     *  获取属性值[催办时间]是否修改
     */
    public boolean isReminderTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReminderTimeDirty();
        }
        return this.remindertimeDirtyFlag;
    }

    /**
     *  重置属性值[催办时间]
     */
    public void resetReminderTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReminderTime();
            return;
        }

        this.remindertimeDirtyFlag = false;
        this.remindertime = null;
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
     *  设置属性值[送交时间]
     *  @param wfcreatedate
     */
    public void setWFCreateDate(Timestamp wfcreatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFCreateDate(wfcreatedate);
            return;
        }
        this.wfcreatedate = wfcreatedate;
        this.wfcreatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[送交时间]
     */
    public Timestamp getWFCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFCreateDate();
        }
        return this.wfcreatedate;
    }

    /**
     *  获取属性值[送交时间]是否修改
     */
    public boolean isWFCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFCreateDateDirty();
        }
        return this.wfcreatedateDirtyFlag;
    }

    /**
     *  重置属性值[送交时间]
     */
    public void resetWFCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFCreateDate();
            return;
        }

        this.wfcreatedateDirtyFlag = false;
        this.wfcreatedate = null;
    }
    /**
     *  设置属性值[工作流工作催办标识]
     *  @param wfreminderid
     */
    public void setWFReminderId(String wfreminderid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFReminderId(wfreminderid);
            return;
        }
        if(wfreminderid!=null) {
            wfreminderid = StringHelper.trimRight(wfreminderid);
            if(wfreminderid.length()==0) {
                wfreminderid = null;
            }
        }
        this.wfreminderid = wfreminderid;
        this.wfreminderidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流工作催办标识]
     */
    public String getWFReminderId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFReminderId();
        }
        return this.wfreminderid;
    }

    /**
     *  获取属性值[工作流工作催办标识]是否修改
     */
    public boolean isWFReminderIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFReminderIdDirty();
        }
        return this.wfreminderidDirtyFlag;
    }

    /**
     *  重置属性值[工作流工作催办标识]
     */
    public void resetWFReminderId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFReminderId();
            return;
        }

        this.wfreminderidDirtyFlag = false;
        this.wfreminderid = null;
    }
    /**
     *  设置属性值[标题]
     *  @param wfremindername
     */
    public void setWFReminderName(String wfremindername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFReminderName(wfremindername);
            return;
        }
        if(wfremindername!=null) {
            wfremindername = StringHelper.trimRight(wfremindername);
            if(wfremindername.length()==0) {
                wfremindername = null;
            }
        }
        this.wfremindername = wfremindername;
        this.wfremindernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[标题]
     */
    public String getWFReminderName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFReminderName();
        }
        return this.wfremindername;
    }

    /**
     *  获取属性值[标题]是否修改
     */
    public boolean isWFReminderNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFReminderNameDirty();
        }
        return this.wfremindernameDirtyFlag;
    }

    /**
     *  重置属性值[标题]
     */
    public void resetWFReminderName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFReminderName();
            return;
        }

        this.wfremindernameDirtyFlag = false;
        this.wfremindername = null;
    }
    /**
     *  设置属性值[工作流催办_操作者]
     *  @param wfstepactorid
     */
    public void setWFStepActorId(String wfstepactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorId(wfstepactorid);
            return;
        }
        if(wfstepactorid!=null) {
            wfstepactorid = StringHelper.trimRight(wfstepactorid);
            if(wfstepactorid.length()==0) {
                wfstepactorid = null;
            }
        }
        this.wfstepactorid = wfstepactorid;
        this.wfstepactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流催办_操作者]
     */
    public String getWFStepActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorId();
        }
        return this.wfstepactorid;
    }

    /**
     *  获取属性值[工作流催办_操作者]是否修改
     */
    public boolean isWFStepActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorIdDirty();
        }
        return this.wfstepactoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流催办_操作者]
     */
    public void resetWFStepActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorId();
            return;
        }

        this.wfstepactoridDirtyFlag = false;
        this.wfstepactorid = null;
    }
    /**
     *  设置属性值[工作操作者]
     *  @param wfstepactorname
     */
    public void setWFStepActorName(String wfstepactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorName(wfstepactorname);
            return;
        }
        if(wfstepactorname!=null) {
            wfstepactorname = StringHelper.trimRight(wfstepactorname);
            if(wfstepactorname.length()==0) {
                wfstepactorname = null;
            }
        }
        this.wfstepactorname = wfstepactorname;
        this.wfstepactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作操作者]
     */
    public String getWFStepActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorName();
        }
        return this.wfstepactorname;
    }

    /**
     *  获取属性值[工作操作者]是否修改
     */
    public boolean isWFStepActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorNameDirty();
        }
        return this.wfstepactornameDirtyFlag;
    }

    /**
     *  重置属性值[工作操作者]
     */
    public void resetWFStepActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorName();
            return;
        }

        this.wfstepactornameDirtyFlag = false;
        this.wfstepactorname = null;
    }
    /**
     *  设置属性值[催办者]
     *  @param wfuserid
     */
    public void setWFUserId(String wfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserId(wfuserid);
            return;
        }
        if(wfuserid!=null) {
            wfuserid = StringHelper.trimRight(wfuserid);
            if(wfuserid.length()==0) {
                wfuserid = null;
            }
        }
        this.wfuserid = wfuserid;
        this.wfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办者]
     */
    public String getWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    /**
     *  获取属性值[催办者]是否修改
     */
    public boolean isWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    /**
     *  重置属性值[催办者]
     */
    public void resetWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserId();
            return;
        }

        this.wfuseridDirtyFlag = false;
        this.wfuserid = null;
    }
    /**
     *  设置属性值[催办者]
     *  @param wfusername
     */
    public void setWFUserName(String wfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserName(wfusername);
            return;
        }
        if(wfusername!=null) {
            wfusername = StringHelper.trimRight(wfusername);
            if(wfusername.length()==0) {
                wfusername = null;
            }
        }
        this.wfusername = wfusername;
        this.wfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办者]
     */
    public String getWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    /**
     *  获取属性值[催办者]是否修改
     */
    public boolean isWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    /**
     *  重置属性值[催办者]
     */
    public void resetWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserName();
            return;
        }

        this.wfusernameDirtyFlag = false;
        this.wfusername = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFReminderBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFReminderBase et) {
        et.resetActorId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReminderCount();
        et.resetReminderTime();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFCreateDate();
        et.resetWFReminderId();
        et.resetWFReminderName();
        et.resetWFStepActorId();
        et.resetWFStepActorName();
        et.resetWFUserId();
        et.resetWFUserName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActorIdDirty()) {
            params.put(FIELD_ACTORID,getActorId());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isReminderCountDirty()) {
            params.put(FIELD_REMINDERCOUNT,getReminderCount());
        }
        if(!bDirtyOnly || isReminderTimeDirty()) {
            params.put(FIELD_REMINDERTIME,getReminderTime());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFCreateDateDirty()) {
            params.put(FIELD_WFCREATEDATE,getWFCreateDate());
        }
        if(!bDirtyOnly || isWFReminderIdDirty()) {
            params.put(FIELD_WFREMINDERID,getWFReminderId());
        }
        if(!bDirtyOnly || isWFReminderNameDirty()) {
            params.put(FIELD_WFREMINDERNAME,getWFReminderName());
        }
        if(!bDirtyOnly || isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID,getWFStepActorId());
        }
        if(!bDirtyOnly || isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME,getWFStepActorName());
        }
        if(!bDirtyOnly || isWFUserIdDirty()) {
            params.put(FIELD_WFUSERID,getWFUserId());
        }
        if(!bDirtyOnly || isWFUserNameDirty()) {
            params.put(FIELD_WFUSERNAME,getWFUserName());
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

        return  WFReminderBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFReminderBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.getActorId();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_REMINDERCOUNT:
            return et.getReminderCount();
        case INDEX_REMINDERTIME:
            return et.getReminderTime();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFCREATEDATE:
            return et.getWFCreateDate();
        case INDEX_WFREMINDERID:
            return et.getWFReminderId();
        case INDEX_WFREMINDERNAME:
            return et.getWFReminderName();
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId();
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName();
        case INDEX_WFUSERID:
            return et.getWFUserId();
        case INDEX_WFUSERNAME:
            return et.getWFUserName();
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

        WFReminderBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFReminderBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTORID:
            et.setActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_REMINDERCOUNT:
            et.setReminderCount(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_REMINDERTIME:
            et.setReminderTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFCREATEDATE:
            et.setWFCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_WFREMINDERID:
            et.setWFReminderId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFREMINDERNAME:
            et.setWFReminderName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPACTORID:
            et.setWFStepActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPACTORNAME:
            et.setWFStepActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERID:
            et.setWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERNAME:
            et.setWFUserName(DataObject.getStringValue(obj));
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

        return  WFReminderBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFReminderBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.getActorId()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_REMINDERCOUNT:
            return et.getReminderCount()==null;
        case INDEX_REMINDERTIME:
            return et.getReminderTime()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFCREATEDATE:
            return et.getWFCreateDate()==null;
        case INDEX_WFREMINDERID:
            return et.getWFReminderId()==null;
        case INDEX_WFREMINDERNAME:
            return et.getWFReminderName()==null;
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId()==null;
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName()==null;
        case INDEX_WFUSERID:
            return et.getWFUserId()==null;
        case INDEX_WFUSERNAME:
            return et.getWFUserName()==null;
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
        return  WFReminderBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFReminderBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.isActorIdDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_REMINDERCOUNT:
            return et.isReminderCountDirty();
        case INDEX_REMINDERTIME:
            return et.isReminderTimeDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFCREATEDATE:
            return et.isWFCreateDateDirty();
        case INDEX_WFREMINDERID:
            return et.isWFReminderIdDirty();
        case INDEX_WFREMINDERNAME:
            return et.isWFReminderNameDirty();
        case INDEX_WFSTEPACTORID:
            return et.isWFStepActorIdDirty();
        case INDEX_WFSTEPACTORNAME:
            return et.isWFStepActorNameDirty();
        case INDEX_WFUSERID:
            return et.isWFUserIdDirty();
        case INDEX_WFUSERNAME:
            return et.isWFUserNameDirty();
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
    private static  void fillJSONObject(WFReminderBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActorId()!=null) {
            JSONObjectHelper.put(json,"actorid",getJSONValue(et.getActorId()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getReminderCount()!=null) {
            JSONObjectHelper.put(json,"remindercount",getJSONValue(et.getReminderCount()),false);
        }
        if(bIncEmpty||et.getReminderTime()!=null) {
            JSONObjectHelper.put(json,"remindertime",getJSONValue(et.getReminderTime()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFCreateDate()!=null) {
            JSONObjectHelper.put(json,"wfcreatedate",getJSONValue(et.getWFCreateDate()),false);
        }
        if(bIncEmpty||et.getWFReminderId()!=null) {
            JSONObjectHelper.put(json,"wfreminderid",getJSONValue(et.getWFReminderId()),false);
        }
        if(bIncEmpty||et.getWFReminderName()!=null) {
            JSONObjectHelper.put(json,"wfremindername",getJSONValue(et.getWFReminderName()),false);
        }
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            JSONObjectHelper.put(json,"wfstepactorid",getJSONValue(et.getWFStepActorId()),false);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            JSONObjectHelper.put(json,"wfstepactorname",getJSONValue(et.getWFStepActorName()),false);
        }
        if(bIncEmpty||et.getWFUserId()!=null) {
            JSONObjectHelper.put(json,"wfuserid",getJSONValue(et.getWFUserId()),false);
        }
        if(bIncEmpty||et.getWFUserName()!=null) {
            JSONObjectHelper.put(json,"wfusername",getJSONValue(et.getWFUserName()),false);
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
    private static void fillXmlNode(WFReminderBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActorId()!=null) {
            Object obj = et.getActorId();
            node.setAttribute("ACTORID",(obj==null)?"":(String)obj);
        }
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
        if(bIncEmpty||et.getReminderCount()!=null) {
            Object obj = et.getReminderCount();
            node.setAttribute("REMINDERCOUNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReminderTime()!=null) {
            Object obj = et.getReminderTime();
            node.setAttribute("REMINDERTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFCreateDate()!=null) {
            Object obj = et.getWFCreateDate();
            node.setAttribute("WFCREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getWFReminderId()!=null) {
            Object obj = et.getWFReminderId();
            node.setAttribute("WFREMINDERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFReminderName()!=null) {
            Object obj = et.getWFReminderName();
            node.setAttribute("WFREMINDERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            Object obj = et.getWFStepActorId();
            node.setAttribute("WFSTEPACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            Object obj = et.getWFStepActorName();
            node.setAttribute("WFSTEPACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserId()!=null) {
            Object obj = et.getWFUserId();
            node.setAttribute("WFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserName()!=null) {
            Object obj = et.getWFUserName();
            node.setAttribute("WFUSERNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFReminderBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFReminderBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActorIdDirty() && (bIncEmpty||et.getActorId()!=null)) {
            dst.set(FIELD_ACTORID,et.getActorId());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isReminderCountDirty() && (bIncEmpty||et.getReminderCount()!=null)) {
            dst.set(FIELD_REMINDERCOUNT,et.getReminderCount());
        }
        if(et.isReminderTimeDirty() && (bIncEmpty||et.getReminderTime()!=null)) {
            dst.set(FIELD_REMINDERTIME,et.getReminderTime());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFCreateDateDirty() && (bIncEmpty||et.getWFCreateDate()!=null)) {
            dst.set(FIELD_WFCREATEDATE,et.getWFCreateDate());
        }
        if(et.isWFReminderIdDirty() && (bIncEmpty||et.getWFReminderId()!=null)) {
            dst.set(FIELD_WFREMINDERID,et.getWFReminderId());
        }
        if(et.isWFReminderNameDirty() && (bIncEmpty||et.getWFReminderName()!=null)) {
            dst.set(FIELD_WFREMINDERNAME,et.getWFReminderName());
        }
        if(et.isWFStepActorIdDirty() && (bIncEmpty||et.getWFStepActorId()!=null)) {
            dst.set(FIELD_WFSTEPACTORID,et.getWFStepActorId());
        }
        if(et.isWFStepActorNameDirty() && (bIncEmpty||et.getWFStepActorName()!=null)) {
            dst.set(FIELD_WFSTEPACTORNAME,et.getWFStepActorName());
        }
        if(et.isWFUserIdDirty() && (bIncEmpty||et.getWFUserId()!=null)) {
            dst.set(FIELD_WFUSERID,et.getWFUserId());
        }
        if(et.isWFUserNameDirty() && (bIncEmpty||et.getWFUserName()!=null)) {
            dst.set(FIELD_WFUSERNAME,et.getWFUserName());
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
        return  WFReminderBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFReminderBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTORID:
            et.resetActorId();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_REMINDERCOUNT:
            et.resetReminderCount();
            return true;
        case INDEX_REMINDERTIME:
            et.resetReminderTime();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFCREATEDATE:
            et.resetWFCreateDate();
            return true;
        case INDEX_WFREMINDERID:
            et.resetWFReminderId();
            return true;
        case INDEX_WFREMINDERNAME:
            et.resetWFReminderName();
            return true;
        case INDEX_WFSTEPACTORID:
            et.resetWFStepActorId();
            return true;
        case INDEX_WFSTEPACTORNAME:
            et.resetWFStepActorName();
            return true;
        case INDEX_WFUSERID:
            et.resetWFUserId();
            return true;
        case INDEX_WFUSERNAME:
            et.resetWFUserName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFStepActorLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStepActor wfstepactor = null;
    /**
    * 获取父数据 工作流步骤操作者
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStepActor getWFStepActor() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActor();
        }

        if(this.getWFStepActorId()==null)
            return null;
        synchronized(this.objWFStepActorLock) {
            if(this.wfstepactor!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFStepActorId(),wfstepactor.getWFStepActorId())!=0) {
                    this.wfstepactor = null;
                }
            }


            if(this.wfstepactor==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStepActor wfstepactor = new net.ibizsys.psrt.srv.wf.entity.WFStepActor();
                wfstepactor.setWFStepActorId(this.getWFStepActorId());
                net.ibizsys.psrt.srv.wf.service.WFStepActorService service = (net.ibizsys.psrt.srv.wf.service.WFStepActorService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepActorService.class,this.getSessionFactory());
                service.autoGet(wfstepactor);
                this.wfstepactor = wfstepactor;
            }
            return this.wfstepactor;
        }
    }

    private Integer objWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser wfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUser();
        }

        if(this.getWFUserId()==null)
            return null;
        synchronized(this.objWFUserLock) {
            if(this.wfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFUserId(),wfuser.getWFUserId())!=0) {
                    this.wfuser = null;
                }
            }


            if(this.wfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser wfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                wfuser.setWFUserId(this.getWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(wfuser);
                this.wfuser = wfuser;
            }
            return this.wfuser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFReminderBase getProxyEntity() {
        return this.proxyWFReminderBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFReminderBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFReminderBase) {
            this.proxyWFReminderBase = (WFReminderBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFReminderService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}