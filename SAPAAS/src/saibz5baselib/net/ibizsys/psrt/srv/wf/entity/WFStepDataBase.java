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
 * 实体[WFStepData] 数据对象基类
 */
public abstract class WFStepDataBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepDataBase.class);
    /**
     * 属性[操作时间]
     */
    public final static String FIELD_ACTIONTIME = "ACTIONTIME";
    /**
     * 属性[操作人]
     */
    public final static String FIELD_ACTORID = "ACTORID";
    /**
     * 属性[操作人名称]
     */
    public final static String FIELD_ACTORNAME = "ACTORNAME";
    /**
     * 属性[代办人名称]
     */
    public final static String FIELD_ACTORNAME2 = "ACTORNAME2";
    /**
     * 属性[连接名称]
     */
    public final static String FIELD_CONNECTIONNAME = "CONNECTIONNAME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[内容]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[下一步]
     */
    public final static String FIELD_NEXTTO = "NEXTTO";
    /**
     * 属性[源流程用户]
     */
    public final static String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
    /**
     * 属性[源流程用户]
     */
    public final static String FIELD_ORIGINALWFUSERNAME = "ORIGINALWFUSERNAME";
    /**
     * 属性[SDPARAM]
     */
    public final static String FIELD_SDPARAM = "SDPARAM";
    /**
     * 属性[代办人]
     */
    public final static String FIELD_SDPARAM2 = "SDPARAM2";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户数据标识]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[用户数据]
     */
    public final static String FIELD_USERDATADESC = "USERDATADESC";
    /**
     * 属性[操作类型语言资源]
     */
    public final static String FIELD_WFACTIONLANRESTAG = "WFACTIONLANRESTAG";
    /**
     * 属性[WFInstanceId]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[流程实例]
     */
    public final static String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    /**
     * 属性[执行步骤]
     */
    public final static String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    /**
     * 属性[工作流步骤数据标识]
     */
    public final static String FIELD_WFSTEPDATAID = "WFSTEPDATAID";
    /**
     * 属性[流程操作]
     */
    public final static String FIELD_WFSTEPDATANAME = "WFSTEPDATANAME";
    /**
     * 属性[步骤数据_相关步骤]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[步骤语言资源]
     */
    public final static String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    /**
     * 属性[步骤名称]
     */
    public final static String FIELD_WFSTEPNAME = "WFSTEPNAME";

    private final static int INDEX_ACTIONTIME = 0;
    private final static int INDEX_ACTORID = 1;
    private final static int INDEX_ACTORNAME = 2;
    private final static int INDEX_ACTORNAME2 = 3;
    private final static int INDEX_CONNECTIONNAME = 4;
    private final static int INDEX_CREATEDATE = 5;
    private final static int INDEX_CREATEMAN = 6;
    private final static int INDEX_MEMO = 7;
    private final static int INDEX_NEXTTO = 8;
    private final static int INDEX_ORIGINALWFUSERID = 9;
    private final static int INDEX_ORIGINALWFUSERNAME = 10;
    private final static int INDEX_SDPARAM = 11;
    private final static int INDEX_SDPARAM2 = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;
    private final static int INDEX_USERDATA = 15;
    private final static int INDEX_USERDATADESC = 16;
    private final static int INDEX_WFACTIONLANRESTAG = 17;
    private final static int INDEX_WFINSTANCEID = 18;
    private final static int INDEX_WFINSTANCENAME = 19;
    private final static int INDEX_WFPLOGICNAME = 20;
    private final static int INDEX_WFSTEPDATAID = 21;
    private final static int INDEX_WFSTEPDATANAME = 22;
    private final static int INDEX_WFSTEPID = 23;
    private final static int INDEX_WFSTEPLANRESTAG = 24;
    private final static int INDEX_WFSTEPNAME = 25;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTIONTIME, INDEX_ACTIONTIME);
        fieldIndexMap.put( FIELD_ACTORID, INDEX_ACTORID);
        fieldIndexMap.put( FIELD_ACTORNAME, INDEX_ACTORNAME);
        fieldIndexMap.put( FIELD_ACTORNAME2, INDEX_ACTORNAME2);
        fieldIndexMap.put( FIELD_CONNECTIONNAME, INDEX_CONNECTIONNAME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_NEXTTO, INDEX_NEXTTO);
        fieldIndexMap.put( FIELD_ORIGINALWFUSERID, INDEX_ORIGINALWFUSERID);
        fieldIndexMap.put( FIELD_ORIGINALWFUSERNAME, INDEX_ORIGINALWFUSERNAME);
        fieldIndexMap.put( FIELD_SDPARAM, INDEX_SDPARAM);
        fieldIndexMap.put( FIELD_SDPARAM2, INDEX_SDPARAM2);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATADESC, INDEX_USERDATADESC);
        fieldIndexMap.put( FIELD_WFACTIONLANRESTAG, INDEX_WFACTIONLANRESTAG);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFINSTANCENAME, INDEX_WFINSTANCENAME);
        fieldIndexMap.put( FIELD_WFPLOGICNAME, INDEX_WFPLOGICNAME);
        fieldIndexMap.put( FIELD_WFSTEPDATAID, INDEX_WFSTEPDATAID);
        fieldIndexMap.put( FIELD_WFSTEPDATANAME, INDEX_WFSTEPDATANAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFSTEPLANRESTAG, INDEX_WFSTEPLANRESTAG);
        fieldIndexMap.put( FIELD_WFSTEPNAME, INDEX_WFSTEPNAME);
    }

    private WFStepDataBase proxyWFStepDataBase = null;
    public WFStepDataBase() {
        super();
    }
    private boolean actiontimeDirtyFlag = false;
    private boolean actoridDirtyFlag = false;
    private boolean actornameDirtyFlag = false;
    private boolean actorname2DirtyFlag = false;
    private boolean connectionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nexttoDirtyFlag = false;
    private boolean originalwfuseridDirtyFlag = false;
    private boolean originalwfusernameDirtyFlag = false;
    private boolean sdparamDirtyFlag = false;
    private boolean sdparam2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdatadescDirtyFlag = false;
    private boolean wfactionlanrestagDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfplogicnameDirtyFlag = false;
    private boolean wfstepdataidDirtyFlag = false;
    private boolean wfstepdatanameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;

    @Column(name="actiontime")
    private Timestamp actiontime;
    @Column(name="actorid")
    private String actorid;
    @Column(name="actorname")
    private String actorname;
    @Column(name="actorname2")
    private String actorname2;
    @Column(name="connectionname")
    private String connectionname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="nextto")
    private String nextto;
    @Column(name="originalwfuserid")
    private String originalwfuserid;
    @Column(name="originalwfusername")
    private String originalwfusername;
    @Column(name="sdparam")
    private String sdparam;
    @Column(name="sdparam2")
    private String sdparam2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdatadesc")
    private String userdatadesc;
    @Column(name="wfactionlanrestag")
    private String wfactionlanrestag;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfplogicname")
    private String wfplogicname;
    @Column(name="wfstepdataid")
    private String wfstepdataid;
    @Column(name="wfstepdataname")
    private String wfstepdataname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;


    /**
     *  设置属性值[操作时间]
     *  @param actiontime
     */
    public void setActionTime(Timestamp actiontime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionTime(actiontime);
            return;
        }
        this.actiontime = actiontime;
        this.actiontimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作时间]
     */
    public Timestamp getActionTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionTime();
        }
        return this.actiontime;
    }

    /**
     *  获取属性值[操作时间]是否修改
     */
    public boolean isActionTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionTimeDirty();
        }
        return this.actiontimeDirtyFlag;
    }

    /**
     *  重置属性值[操作时间]
     */
    public void resetActionTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionTime();
            return;
        }

        this.actiontimeDirtyFlag = false;
        this.actiontime = null;
    }
    /**
     *  设置属性值[操作人]
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
     *  获取属性值[操作人]
     */
    public String getActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorId();
        }
        return this.actorid;
    }

    /**
     *  获取属性值[操作人]是否修改
     */
    public boolean isActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorIdDirty();
        }
        return this.actoridDirtyFlag;
    }

    /**
     *  重置属性值[操作人]
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
     *  设置属性值[操作人名称]
     *  @param actorname
     */
    public void setActorName(String actorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActorName(actorname);
            return;
        }
        if(actorname!=null) {
            actorname = StringHelper.trimRight(actorname);
            if(actorname.length()==0) {
                actorname = null;
            }
        }
        this.actorname = actorname;
        this.actornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作人名称]
     */
    public String getActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorName();
        }
        return this.actorname;
    }

    /**
     *  获取属性值[操作人名称]是否修改
     */
    public boolean isActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorNameDirty();
        }
        return this.actornameDirtyFlag;
    }

    /**
     *  重置属性值[操作人名称]
     */
    public void resetActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActorName();
            return;
        }

        this.actornameDirtyFlag = false;
        this.actorname = null;
    }
    /**
     *  设置属性值[代办人名称]
     *  @param actorname2
     */
    public void setActorName2(String actorname2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActorName2(actorname2);
            return;
        }
        if(actorname2!=null) {
            actorname2 = StringHelper.trimRight(actorname2);
            if(actorname2.length()==0) {
                actorname2 = null;
            }
        }
        this.actorname2 = actorname2;
        this.actorname2DirtyFlag  = true;
    }

    /**
     *  获取属性值[代办人名称]
     */
    public String getActorName2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorName2();
        }
        return this.actorname2;
    }

    /**
     *  获取属性值[代办人名称]是否修改
     */
    public boolean isActorName2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorName2Dirty();
        }
        return this.actorname2DirtyFlag;
    }

    /**
     *  重置属性值[代办人名称]
     */
    public void resetActorName2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActorName2();
            return;
        }

        this.actorname2DirtyFlag = false;
        this.actorname2 = null;
    }
    /**
     *  设置属性值[连接名称]
     *  @param connectionname
     */
    public void setConnectionName(String connectionname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setConnectionName(connectionname);
            return;
        }
        if(connectionname!=null) {
            connectionname = StringHelper.trimRight(connectionname);
            if(connectionname.length()==0) {
                connectionname = null;
            }
        }
        this.connectionname = connectionname;
        this.connectionnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[连接名称]
     */
    public String getConnectionName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getConnectionName();
        }
        return this.connectionname;
    }

    /**
     *  获取属性值[连接名称]是否修改
     */
    public boolean isConnectionNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isConnectionNameDirty();
        }
        return this.connectionnameDirtyFlag;
    }

    /**
     *  重置属性值[连接名称]
     */
    public void resetConnectionName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetConnectionName();
            return;
        }

        this.connectionnameDirtyFlag = false;
        this.connectionname = null;
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
     *  设置属性值[内容]
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
     *  获取属性值[内容]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[内容]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[内容]
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
     *  设置属性值[下一步]
     *  @param nextto
     */
    public void setNextTo(String nextto) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNextTo(nextto);
            return;
        }
        if(nextto!=null) {
            nextto = StringHelper.trimRight(nextto);
            if(nextto.length()==0) {
                nextto = null;
            }
        }
        this.nextto = nextto;
        this.nexttoDirtyFlag  = true;
    }

    /**
     *  获取属性值[下一步]
     */
    public String getNextTo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNextTo();
        }
        return this.nextto;
    }

    /**
     *  获取属性值[下一步]是否修改
     */
    public boolean isNextToDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNextToDirty();
        }
        return this.nexttoDirtyFlag;
    }

    /**
     *  重置属性值[下一步]
     */
    public void resetNextTo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNextTo();
            return;
        }

        this.nexttoDirtyFlag = false;
        this.nextto = null;
    }
    /**
     *  设置属性值[源流程用户]
     *  @param originalwfuserid
     */
    public void setOriginalWFUserId(String originalwfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOriginalWFUserId(originalwfuserid);
            return;
        }
        if(originalwfuserid!=null) {
            originalwfuserid = StringHelper.trimRight(originalwfuserid);
            if(originalwfuserid.length()==0) {
                originalwfuserid = null;
            }
        }
        this.originalwfuserid = originalwfuserid;
        this.originalwfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[源流程用户]
     */
    public String getOriginalWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUserId();
        }
        return this.originalwfuserid;
    }

    /**
     *  获取属性值[源流程用户]是否修改
     */
    public boolean isOriginalWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOriginalWFUserIdDirty();
        }
        return this.originalwfuseridDirtyFlag;
    }

    /**
     *  重置属性值[源流程用户]
     */
    public void resetOriginalWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOriginalWFUserId();
            return;
        }

        this.originalwfuseridDirtyFlag = false;
        this.originalwfuserid = null;
    }
    /**
     *  设置属性值[源流程用户]
     *  @param originalwfusername
     */
    public void setOriginalWFUserName(String originalwfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOriginalWFUserName(originalwfusername);
            return;
        }
        if(originalwfusername!=null) {
            originalwfusername = StringHelper.trimRight(originalwfusername);
            if(originalwfusername.length()==0) {
                originalwfusername = null;
            }
        }
        this.originalwfusername = originalwfusername;
        this.originalwfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[源流程用户]
     */
    public String getOriginalWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUserName();
        }
        return this.originalwfusername;
    }

    /**
     *  获取属性值[源流程用户]是否修改
     */
    public boolean isOriginalWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOriginalWFUserNameDirty();
        }
        return this.originalwfusernameDirtyFlag;
    }

    /**
     *  重置属性值[源流程用户]
     */
    public void resetOriginalWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOriginalWFUserName();
            return;
        }

        this.originalwfusernameDirtyFlag = false;
        this.originalwfusername = null;
    }
    /**
     *  设置属性值[SDPARAM]
     *  @param sdparam
     */
    public void setSDParam(String sdparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSDParam(sdparam);
            return;
        }
        if(sdparam!=null) {
            sdparam = StringHelper.trimRight(sdparam);
            if(sdparam.length()==0) {
                sdparam = null;
            }
        }
        this.sdparam = sdparam;
        this.sdparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[SDPARAM]
     */
    public String getSDParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSDParam();
        }
        return this.sdparam;
    }

    /**
     *  获取属性值[SDPARAM]是否修改
     */
    public boolean isSDParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSDParamDirty();
        }
        return this.sdparamDirtyFlag;
    }

    /**
     *  重置属性值[SDPARAM]
     */
    public void resetSDParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSDParam();
            return;
        }

        this.sdparamDirtyFlag = false;
        this.sdparam = null;
    }
    /**
     *  设置属性值[代办人]
     *  @param sdparam2
     */
    public void setSDParam2(String sdparam2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSDParam2(sdparam2);
            return;
        }
        if(sdparam2!=null) {
            sdparam2 = StringHelper.trimRight(sdparam2);
            if(sdparam2.length()==0) {
                sdparam2 = null;
            }
        }
        this.sdparam2 = sdparam2;
        this.sdparam2DirtyFlag  = true;
    }

    /**
     *  获取属性值[代办人]
     */
    public String getSDParam2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSDParam2();
        }
        return this.sdparam2;
    }

    /**
     *  获取属性值[代办人]是否修改
     */
    public boolean isSDParam2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSDParam2Dirty();
        }
        return this.sdparam2DirtyFlag;
    }

    /**
     *  重置属性值[代办人]
     */
    public void resetSDParam2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSDParam2();
            return;
        }

        this.sdparam2DirtyFlag = false;
        this.sdparam2 = null;
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
     *  设置属性值[用户数据标识]
     *  @param userdata
     */
    public void setUserData(String userdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if(userdata!=null) {
            userdata = StringHelper.trimRight(userdata);
            if(userdata.length()==0) {
                userdata = null;
            }
        }
        this.userdata = userdata;
        this.userdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据标识]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[用户数据标识]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[用户数据标识]
     */
    public void resetUserData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData();
            return;
        }

        this.userdataDirtyFlag = false;
        this.userdata = null;
    }
    /**
     *  设置属性值[用户数据]
     *  @param userdatadesc
     */
    public void setUserDataDesc(String userdatadesc) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataDesc(userdatadesc);
            return;
        }
        if(userdatadesc!=null) {
            userdatadesc = StringHelper.trimRight(userdatadesc);
            if(userdatadesc.length()==0) {
                userdatadesc = null;
            }
        }
        this.userdatadesc = userdatadesc;
        this.userdatadescDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据]
     */
    public String getUserDataDesc() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataDesc();
        }
        return this.userdatadesc;
    }

    /**
     *  获取属性值[用户数据]是否修改
     */
    public boolean isUserDataDescDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDescDirty();
        }
        return this.userdatadescDirtyFlag;
    }

    /**
     *  重置属性值[用户数据]
     */
    public void resetUserDataDesc() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataDesc();
            return;
        }

        this.userdatadescDirtyFlag = false;
        this.userdatadesc = null;
    }
    /**
     *  设置属性值[操作类型语言资源]
     *  @param wfactionlanrestag
     */
    public void setWFActionLanResTag(String wfactionlanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActionLanResTag(wfactionlanrestag);
            return;
        }
        if(wfactionlanrestag!=null) {
            wfactionlanrestag = StringHelper.trimRight(wfactionlanrestag);
            if(wfactionlanrestag.length()==0) {
                wfactionlanrestag = null;
            }
        }
        this.wfactionlanrestag = wfactionlanrestag;
        this.wfactionlanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作类型语言资源]
     */
    public String getWFActionLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActionLanResTag();
        }
        return this.wfactionlanrestag;
    }

    /**
     *  获取属性值[操作类型语言资源]是否修改
     */
    public boolean isWFActionLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActionLanResTagDirty();
        }
        return this.wfactionlanrestagDirtyFlag;
    }

    /**
     *  重置属性值[操作类型语言资源]
     */
    public void resetWFActionLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActionLanResTag();
            return;
        }

        this.wfactionlanrestagDirtyFlag = false;
        this.wfactionlanrestag = null;
    }
    /**
     *  设置属性值[WFInstanceId]
     *  @param wfinstanceid
     */
    public void setWFInstanceId(String wfinstanceid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if(wfinstanceid!=null) {
            wfinstanceid = StringHelper.trimRight(wfinstanceid);
            if(wfinstanceid.length()==0) {
                wfinstanceid = null;
            }
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag  = true;
    }

    /**
     *  获取属性值[WFInstanceId]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[WFInstanceId]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[WFInstanceId]
     */
    public void resetWFInstanceId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }

        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }
    /**
     *  设置属性值[流程实例]
     *  @param wfinstancename
     */
    public void setWFInstanceName(String wfinstancename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if(wfinstancename!=null) {
            wfinstancename = StringHelper.trimRight(wfinstancename);
            if(wfinstancename.length()==0) {
                wfinstancename = null;
            }
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程实例]
     */
    public String getWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    /**
     *  获取属性值[流程实例]是否修改
     */
    public boolean isWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[流程实例]
     */
    public void resetWFInstanceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }

        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }
    /**
     *  设置属性值[执行步骤]
     *  @param wfplogicname
     */
    public void setWFPLogicName(String wfplogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFPLogicName(wfplogicname);
            return;
        }
        if(wfplogicname!=null) {
            wfplogicname = StringHelper.trimRight(wfplogicname);
            if(wfplogicname.length()==0) {
                wfplogicname = null;
            }
        }
        this.wfplogicname = wfplogicname;
        this.wfplogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[执行步骤]
     */
    public String getWFPLogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFPLogicName();
        }
        return this.wfplogicname;
    }

    /**
     *  获取属性值[执行步骤]是否修改
     */
    public boolean isWFPLogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFPLogicNameDirty();
        }
        return this.wfplogicnameDirtyFlag;
    }

    /**
     *  重置属性值[执行步骤]
     */
    public void resetWFPLogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFPLogicName();
            return;
        }

        this.wfplogicnameDirtyFlag = false;
        this.wfplogicname = null;
    }
    /**
     *  设置属性值[工作流步骤数据标识]
     *  @param wfstepdataid
     */
    public void setWFStepDataId(String wfstepdataid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepDataId(wfstepdataid);
            return;
        }
        if(wfstepdataid!=null) {
            wfstepdataid = StringHelper.trimRight(wfstepdataid);
            if(wfstepdataid.length()==0) {
                wfstepdataid = null;
            }
        }
        this.wfstepdataid = wfstepdataid;
        this.wfstepdataidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤数据标识]
     */
    public String getWFStepDataId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepDataId();
        }
        return this.wfstepdataid;
    }

    /**
     *  获取属性值[工作流步骤数据标识]是否修改
     */
    public boolean isWFStepDataIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepDataIdDirty();
        }
        return this.wfstepdataidDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤数据标识]
     */
    public void resetWFStepDataId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepDataId();
            return;
        }

        this.wfstepdataidDirtyFlag = false;
        this.wfstepdataid = null;
    }
    /**
     *  设置属性值[流程操作]
     *  @param wfstepdataname
     */
    public void setWFStepDataName(String wfstepdataname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepDataName(wfstepdataname);
            return;
        }
        if(wfstepdataname!=null) {
            wfstepdataname = StringHelper.trimRight(wfstepdataname);
            if(wfstepdataname.length()==0) {
                wfstepdataname = null;
            }
        }
        this.wfstepdataname = wfstepdataname;
        this.wfstepdatanameDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程操作]
     */
    public String getWFStepDataName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepDataName();
        }
        return this.wfstepdataname;
    }

    /**
     *  获取属性值[流程操作]是否修改
     */
    public boolean isWFStepDataNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepDataNameDirty();
        }
        return this.wfstepdatanameDirtyFlag;
    }

    /**
     *  重置属性值[流程操作]
     */
    public void resetWFStepDataName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepDataName();
            return;
        }

        this.wfstepdatanameDirtyFlag = false;
        this.wfstepdataname = null;
    }
    /**
     *  设置属性值[步骤数据_相关步骤]
     *  @param wfstepid
     */
    public void setWFStepId(String wfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if(wfstepid!=null) {
            wfstepid = StringHelper.trimRight(wfstepid);
            if(wfstepid.length()==0) {
                wfstepid = null;
            }
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤数据_相关步骤]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[步骤数据_相关步骤]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[步骤数据_相关步骤]
     */
    public void resetWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }

        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }
    /**
     *  设置属性值[步骤语言资源]
     *  @param wfsteplanrestag
     */
    public void setWFStepLanResTag(String wfsteplanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if(wfsteplanrestag!=null) {
            wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag);
            if(wfsteplanrestag.length()==0) {
                wfsteplanrestag = null;
            }
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤语言资源]
     */
    public String getWFStepLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    /**
     *  获取属性值[步骤语言资源]是否修改
     */
    public boolean isWFStepLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    /**
     *  重置属性值[步骤语言资源]
     */
    public void resetWFStepLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }

        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }
    /**
     *  设置属性值[步骤名称]
     *  @param wfstepname
     */
    public void setWFStepName(String wfstepname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if(wfstepname!=null) {
            wfstepname = StringHelper.trimRight(wfstepname);
            if(wfstepname.length()==0) {
                wfstepname = null;
            }
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤名称]
     */
    public String getWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    /**
     *  获取属性值[步骤名称]是否修改
     */
    public boolean isWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[步骤名称]
     */
    public void resetWFStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }

        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFStepDataBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFStepDataBase et) {
        et.resetActionTime();
        et.resetActorId();
        et.resetActorName();
        et.resetActorName2();
        et.resetConnectionName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetNextTo();
        et.resetOriginalWFUserId();
        et.resetOriginalWFUserName();
        et.resetSDParam();
        et.resetSDParam2();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserDataDesc();
        et.resetWFActionLanResTag();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFPLogicName();
        et.resetWFStepDataId();
        et.resetWFStepDataName();
        et.resetWFStepId();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActionTimeDirty()) {
            params.put(FIELD_ACTIONTIME,getActionTime());
        }
        if(!bDirtyOnly || isActorIdDirty()) {
            params.put(FIELD_ACTORID,getActorId());
        }
        if(!bDirtyOnly || isActorNameDirty()) {
            params.put(FIELD_ACTORNAME,getActorName());
        }
        if(!bDirtyOnly || isActorName2Dirty()) {
            params.put(FIELD_ACTORNAME2,getActorName2());
        }
        if(!bDirtyOnly || isConnectionNameDirty()) {
            params.put(FIELD_CONNECTIONNAME,getConnectionName());
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
        if(!bDirtyOnly || isNextToDirty()) {
            params.put(FIELD_NEXTTO,getNextTo());
        }
        if(!bDirtyOnly || isOriginalWFUserIdDirty()) {
            params.put(FIELD_ORIGINALWFUSERID,getOriginalWFUserId());
        }
        if(!bDirtyOnly || isOriginalWFUserNameDirty()) {
            params.put(FIELD_ORIGINALWFUSERNAME,getOriginalWFUserName());
        }
        if(!bDirtyOnly || isSDParamDirty()) {
            params.put(FIELD_SDPARAM,getSDParam());
        }
        if(!bDirtyOnly || isSDParam2Dirty()) {
            params.put(FIELD_SDPARAM2,getSDParam2());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDataDirty()) {
            params.put(FIELD_USERDATA,getUserData());
        }
        if(!bDirtyOnly || isUserDataDescDirty()) {
            params.put(FIELD_USERDATADESC,getUserDataDesc());
        }
        if(!bDirtyOnly || isWFActionLanResTagDirty()) {
            params.put(FIELD_WFACTIONLANRESTAG,getWFActionLanResTag());
        }
        if(!bDirtyOnly || isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID,getWFInstanceId());
        }
        if(!bDirtyOnly || isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME,getWFInstanceName());
        }
        if(!bDirtyOnly || isWFPLogicNameDirty()) {
            params.put(FIELD_WFPLOGICNAME,getWFPLogicName());
        }
        if(!bDirtyOnly || isWFStepDataIdDirty()) {
            params.put(FIELD_WFSTEPDATAID,getWFStepDataId());
        }
        if(!bDirtyOnly || isWFStepDataNameDirty()) {
            params.put(FIELD_WFSTEPDATANAME,getWFStepDataName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
        }
        if(!bDirtyOnly || isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG,getWFStepLanResTag());
        }
        if(!bDirtyOnly || isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME,getWFStepName());
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

        return  WFStepDataBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFStepDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONTIME:
            return et.getActionTime();
        case INDEX_ACTORID:
            return et.getActorId();
        case INDEX_ACTORNAME:
            return et.getActorName();
        case INDEX_ACTORNAME2:
            return et.getActorName2();
        case INDEX_CONNECTIONNAME:
            return et.getConnectionName();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_NEXTTO:
            return et.getNextTo();
        case INDEX_ORIGINALWFUSERID:
            return et.getOriginalWFUserId();
        case INDEX_ORIGINALWFUSERNAME:
            return et.getOriginalWFUserName();
        case INDEX_SDPARAM:
            return et.getSDParam();
        case INDEX_SDPARAM2:
            return et.getSDParam2();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATADESC:
            return et.getUserDataDesc();
        case INDEX_WFACTIONLANRESTAG:
            return et.getWFActionLanResTag();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName();
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName();
        case INDEX_WFSTEPDATAID:
            return et.getWFStepDataId();
        case INDEX_WFSTEPDATANAME:
            return et.getWFStepDataName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag();
        case INDEX_WFSTEPNAME:
            return et.getWFStepName();
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

        WFStepDataBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFStepDataBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTIONTIME:
            et.setActionTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_ACTORID:
            et.setActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTORNAME:
            et.setActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTORNAME2:
            et.setActorName2(DataObject.getStringValue(obj));
            return ;
        case INDEX_CONNECTIONNAME:
            et.setConnectionName(DataObject.getStringValue(obj));
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
        case INDEX_NEXTTO:
            et.setNextTo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORIGINALWFUSERID:
            et.setOriginalWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORIGINALWFUSERNAME:
            et.setOriginalWFUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SDPARAM:
            et.setSDParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_SDPARAM2:
            et.setSDParam2(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA:
            et.setUserData(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATADESC:
            et.setUserDataDesc(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTIONLANRESTAG:
            et.setWFActionLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCEID:
            et.setWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCENAME:
            et.setWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFPLOGICNAME:
            et.setWFPLogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPDATAID:
            et.setWFStepDataId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPDATANAME:
            et.setWFStepDataName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPLANRESTAG:
            et.setWFStepLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPNAME:
            et.setWFStepName(DataObject.getStringValue(obj));
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

        return  WFStepDataBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFStepDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONTIME:
            return et.getActionTime()==null;
        case INDEX_ACTORID:
            return et.getActorId()==null;
        case INDEX_ACTORNAME:
            return et.getActorName()==null;
        case INDEX_ACTORNAME2:
            return et.getActorName2()==null;
        case INDEX_CONNECTIONNAME:
            return et.getConnectionName()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_NEXTTO:
            return et.getNextTo()==null;
        case INDEX_ORIGINALWFUSERID:
            return et.getOriginalWFUserId()==null;
        case INDEX_ORIGINALWFUSERNAME:
            return et.getOriginalWFUserName()==null;
        case INDEX_SDPARAM:
            return et.getSDParam()==null;
        case INDEX_SDPARAM2:
            return et.getSDParam2()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATADESC:
            return et.getUserDataDesc()==null;
        case INDEX_WFACTIONLANRESTAG:
            return et.getWFActionLanResTag()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName()==null;
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName()==null;
        case INDEX_WFSTEPDATAID:
            return et.getWFStepDataId()==null;
        case INDEX_WFSTEPDATANAME:
            return et.getWFStepDataName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag()==null;
        case INDEX_WFSTEPNAME:
            return et.getWFStepName()==null;
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
        return  WFStepDataBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFStepDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONTIME:
            return et.isActionTimeDirty();
        case INDEX_ACTORID:
            return et.isActorIdDirty();
        case INDEX_ACTORNAME:
            return et.isActorNameDirty();
        case INDEX_ACTORNAME2:
            return et.isActorName2Dirty();
        case INDEX_CONNECTIONNAME:
            return et.isConnectionNameDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_NEXTTO:
            return et.isNextToDirty();
        case INDEX_ORIGINALWFUSERID:
            return et.isOriginalWFUserIdDirty();
        case INDEX_ORIGINALWFUSERNAME:
            return et.isOriginalWFUserNameDirty();
        case INDEX_SDPARAM:
            return et.isSDParamDirty();
        case INDEX_SDPARAM2:
            return et.isSDParam2Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATADESC:
            return et.isUserDataDescDirty();
        case INDEX_WFACTIONLANRESTAG:
            return et.isWFActionLanResTagDirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFINSTANCENAME:
            return et.isWFInstanceNameDirty();
        case INDEX_WFPLOGICNAME:
            return et.isWFPLogicNameDirty();
        case INDEX_WFSTEPDATAID:
            return et.isWFStepDataIdDirty();
        case INDEX_WFSTEPDATANAME:
            return et.isWFStepDataNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
        case INDEX_WFSTEPLANRESTAG:
            return et.isWFStepLanResTagDirty();
        case INDEX_WFSTEPNAME:
            return et.isWFStepNameDirty();
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
    private static  void fillJSONObject(WFStepDataBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionTime()!=null) {
            JSONObjectHelper.put(json,"actiontime",getJSONValue(et.getActionTime()),false);
        }
        if(bIncEmpty||et.getActorId()!=null) {
            JSONObjectHelper.put(json,"actorid",getJSONValue(et.getActorId()),false);
        }
        if(bIncEmpty||et.getActorName()!=null) {
            JSONObjectHelper.put(json,"actorname",getJSONValue(et.getActorName()),false);
        }
        if(bIncEmpty||et.getActorName2()!=null) {
            JSONObjectHelper.put(json,"actorname2",getJSONValue(et.getActorName2()),false);
        }
        if(bIncEmpty||et.getConnectionName()!=null) {
            JSONObjectHelper.put(json,"connectionname",getJSONValue(et.getConnectionName()),false);
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
        if(bIncEmpty||et.getNextTo()!=null) {
            JSONObjectHelper.put(json,"nextto",getJSONValue(et.getNextTo()),false);
        }
        if(bIncEmpty||et.getOriginalWFUserId()!=null) {
            JSONObjectHelper.put(json,"originalwfuserid",getJSONValue(et.getOriginalWFUserId()),false);
        }
        if(bIncEmpty||et.getOriginalWFUserName()!=null) {
            JSONObjectHelper.put(json,"originalwfusername",getJSONValue(et.getOriginalWFUserName()),false);
        }
        if(bIncEmpty||et.getSDParam()!=null) {
            JSONObjectHelper.put(json,"sdparam",getJSONValue(et.getSDParam()),false);
        }
        if(bIncEmpty||et.getSDParam2()!=null) {
            JSONObjectHelper.put(json,"sdparam2",getJSONValue(et.getSDParam2()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            JSONObjectHelper.put(json,"userdata",getJSONValue(et.getUserData()),false);
        }
        if(bIncEmpty||et.getUserDataDesc()!=null) {
            JSONObjectHelper.put(json,"userdatadesc",getJSONValue(et.getUserDataDesc()),false);
        }
        if(bIncEmpty||et.getWFActionLanResTag()!=null) {
            JSONObjectHelper.put(json,"wfactionlanrestag",getJSONValue(et.getWFActionLanResTag()),false);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"wfinstanceid",getJSONValue(et.getWFInstanceId()),false);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"wfinstancename",getJSONValue(et.getWFInstanceName()),false);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            JSONObjectHelper.put(json,"wfplogicname",getJSONValue(et.getWFPLogicName()),false);
        }
        if(bIncEmpty||et.getWFStepDataId()!=null) {
            JSONObjectHelper.put(json,"wfstepdataid",getJSONValue(et.getWFStepDataId()),false);
        }
        if(bIncEmpty||et.getWFStepDataName()!=null) {
            JSONObjectHelper.put(json,"wfstepdataname",getJSONValue(et.getWFStepDataName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            JSONObjectHelper.put(json,"wfsteplanrestag",getJSONValue(et.getWFStepLanResTag()),false);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            JSONObjectHelper.put(json,"wfstepname",getJSONValue(et.getWFStepName()),false);
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
    private static void fillXmlNode(WFStepDataBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionTime()!=null) {
            Object obj = et.getActionTime();
            node.setAttribute("ACTIONTIME",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getActorId()!=null) {
            Object obj = et.getActorId();
            node.setAttribute("ACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActorName()!=null) {
            Object obj = et.getActorName();
            node.setAttribute("ACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActorName2()!=null) {
            Object obj = et.getActorName2();
            node.setAttribute("ACTORNAME2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getConnectionName()!=null) {
            Object obj = et.getConnectionName();
            node.setAttribute("CONNECTIONNAME",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getNextTo()!=null) {
            Object obj = et.getNextTo();
            node.setAttribute("NEXTTO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOriginalWFUserId()!=null) {
            Object obj = et.getOriginalWFUserId();
            node.setAttribute("ORIGINALWFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOriginalWFUserName()!=null) {
            Object obj = et.getOriginalWFUserName();
            node.setAttribute("ORIGINALWFUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSDParam()!=null) {
            Object obj = et.getSDParam();
            node.setAttribute("SDPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSDParam2()!=null) {
            Object obj = et.getSDParam2();
            node.setAttribute("SDPARAM2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            Object obj = et.getUserData();
            node.setAttribute("USERDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataDesc()!=null) {
            Object obj = et.getUserDataDesc();
            node.setAttribute("USERDATADESC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActionLanResTag()!=null) {
            Object obj = et.getWFActionLanResTag();
            node.setAttribute("WFACTIONLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            Object obj = et.getWFInstanceId();
            node.setAttribute("WFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            Object obj = et.getWFInstanceName();
            node.setAttribute("WFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            Object obj = et.getWFPLogicName();
            node.setAttribute("WFPLOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepDataId()!=null) {
            Object obj = et.getWFStepDataId();
            node.setAttribute("WFSTEPDATAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepDataName()!=null) {
            Object obj = et.getWFStepDataName();
            node.setAttribute("WFSTEPDATANAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            Object obj = et.getWFStepLanResTag();
            node.setAttribute("WFSTEPLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            Object obj = et.getWFStepName();
            node.setAttribute("WFSTEPNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepDataBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFStepDataBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActionTimeDirty() && (bIncEmpty||et.getActionTime()!=null)) {
            dst.set(FIELD_ACTIONTIME,et.getActionTime());
        }
        if(et.isActorIdDirty() && (bIncEmpty||et.getActorId()!=null)) {
            dst.set(FIELD_ACTORID,et.getActorId());
        }
        if(et.isActorNameDirty() && (bIncEmpty||et.getActorName()!=null)) {
            dst.set(FIELD_ACTORNAME,et.getActorName());
        }
        if(et.isActorName2Dirty() && (bIncEmpty||et.getActorName2()!=null)) {
            dst.set(FIELD_ACTORNAME2,et.getActorName2());
        }
        if(et.isConnectionNameDirty() && (bIncEmpty||et.getConnectionName()!=null)) {
            dst.set(FIELD_CONNECTIONNAME,et.getConnectionName());
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
        if(et.isNextToDirty() && (bIncEmpty||et.getNextTo()!=null)) {
            dst.set(FIELD_NEXTTO,et.getNextTo());
        }
        if(et.isOriginalWFUserIdDirty() && (bIncEmpty||et.getOriginalWFUserId()!=null)) {
            dst.set(FIELD_ORIGINALWFUSERID,et.getOriginalWFUserId());
        }
        if(et.isOriginalWFUserNameDirty() && (bIncEmpty||et.getOriginalWFUserName()!=null)) {
            dst.set(FIELD_ORIGINALWFUSERNAME,et.getOriginalWFUserName());
        }
        if(et.isSDParamDirty() && (bIncEmpty||et.getSDParam()!=null)) {
            dst.set(FIELD_SDPARAM,et.getSDParam());
        }
        if(et.isSDParam2Dirty() && (bIncEmpty||et.getSDParam2()!=null)) {
            dst.set(FIELD_SDPARAM2,et.getSDParam2());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDataDirty() && (bIncEmpty||et.getUserData()!=null)) {
            dst.set(FIELD_USERDATA,et.getUserData());
        }
        if(et.isUserDataDescDirty() && (bIncEmpty||et.getUserDataDesc()!=null)) {
            dst.set(FIELD_USERDATADESC,et.getUserDataDesc());
        }
        if(et.isWFActionLanResTagDirty() && (bIncEmpty||et.getWFActionLanResTag()!=null)) {
            dst.set(FIELD_WFACTIONLANRESTAG,et.getWFActionLanResTag());
        }
        if(et.isWFInstanceIdDirty() && (bIncEmpty||et.getWFInstanceId()!=null)) {
            dst.set(FIELD_WFINSTANCEID,et.getWFInstanceId());
        }
        if(et.isWFInstanceNameDirty() && (bIncEmpty||et.getWFInstanceName()!=null)) {
            dst.set(FIELD_WFINSTANCENAME,et.getWFInstanceName());
        }
        if(et.isWFPLogicNameDirty() && (bIncEmpty||et.getWFPLogicName()!=null)) {
            dst.set(FIELD_WFPLOGICNAME,et.getWFPLogicName());
        }
        if(et.isWFStepDataIdDirty() && (bIncEmpty||et.getWFStepDataId()!=null)) {
            dst.set(FIELD_WFSTEPDATAID,et.getWFStepDataId());
        }
        if(et.isWFStepDataNameDirty() && (bIncEmpty||et.getWFStepDataName()!=null)) {
            dst.set(FIELD_WFSTEPDATANAME,et.getWFStepDataName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
        }
        if(et.isWFStepLanResTagDirty() && (bIncEmpty||et.getWFStepLanResTag()!=null)) {
            dst.set(FIELD_WFSTEPLANRESTAG,et.getWFStepLanResTag());
        }
        if(et.isWFStepNameDirty() && (bIncEmpty||et.getWFStepName()!=null)) {
            dst.set(FIELD_WFSTEPNAME,et.getWFStepName());
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
        return  WFStepDataBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFStepDataBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTIONTIME:
            et.resetActionTime();
            return true;
        case INDEX_ACTORID:
            et.resetActorId();
            return true;
        case INDEX_ACTORNAME:
            et.resetActorName();
            return true;
        case INDEX_ACTORNAME2:
            et.resetActorName2();
            return true;
        case INDEX_CONNECTIONNAME:
            et.resetConnectionName();
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
        case INDEX_NEXTTO:
            et.resetNextTo();
            return true;
        case INDEX_ORIGINALWFUSERID:
            et.resetOriginalWFUserId();
            return true;
        case INDEX_ORIGINALWFUSERNAME:
            et.resetOriginalWFUserName();
            return true;
        case INDEX_SDPARAM:
            et.resetSDParam();
            return true;
        case INDEX_SDPARAM2:
            et.resetSDParam2();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDATA:
            et.resetUserData();
            return true;
        case INDEX_USERDATADESC:
            et.resetUserDataDesc();
            return true;
        case INDEX_WFACTIONLANRESTAG:
            et.resetWFActionLanResTag();
            return true;
        case INDEX_WFINSTANCEID:
            et.resetWFInstanceId();
            return true;
        case INDEX_WFINSTANCENAME:
            et.resetWFInstanceName();
            return true;
        case INDEX_WFPLOGICNAME:
            et.resetWFPLogicName();
            return true;
        case INDEX_WFSTEPDATAID:
            et.resetWFStepDataId();
            return true;
        case INDEX_WFSTEPDATANAME:
            et.resetWFStepDataName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
            return true;
        case INDEX_WFSTEPLANRESTAG:
            et.resetWFStepLanResTag();
            return true;
        case INDEX_WFSTEPNAME:
            et.resetWFStepName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFInstanceLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = null;
    /**
    * 获取父数据 工作流实例
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFInstance getWFInstance() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstance();
        }

        if(this.getWFInstanceId()==null)
            return null;
        synchronized(this.objWFInstanceLock) {
            if(this.wfinstance!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFInstanceId(),wfinstance.getWFInstanceId())!=0) {
                    this.wfinstance = null;
                }
            }


            if(this.wfinstance==null) {
                net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = new net.ibizsys.psrt.srv.wf.entity.WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                net.ibizsys.psrt.srv.wf.service.WFInstanceService service = (net.ibizsys.psrt.srv.wf.service.WFInstanceService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFInstanceService.class,this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }

    private Integer objWFStepLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = null;
    /**
    * 获取父数据 工作流步骤
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStep getWFStep() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStep();
        }

        if(this.getWFStepId()==null)
            return null;
        synchronized(this.objWFStepLock) {
            if(this.wfstep!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFStepId(),wfstep.getWFStepId())!=0) {
                    this.wfstep = null;
                }
            }


            if(this.wfstep==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = new net.ibizsys.psrt.srv.wf.entity.WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                net.ibizsys.psrt.srv.wf.service.WFStepService service = (net.ibizsys.psrt.srv.wf.service.WFStepService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepService.class,this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    private Integer objOriginalWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser originalwfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getOriginalWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUser();
        }

        if(this.getOriginalWFUserId()==null)
            return null;
        synchronized(this.objOriginalWFUserLock) {
            if(this.originalwfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getOriginalWFUserId(),originalwfuser.getWFUserId())!=0) {
                    this.originalwfuser = null;
                }
            }


            if(this.originalwfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser originalwfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                originalwfuser.setWFUserId(this.getOriginalWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(originalwfuser);
                this.originalwfuser = originalwfuser;
            }
            return this.originalwfuser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFStepDataBase getProxyEntity() {
        return this.proxyWFStepDataBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepDataBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFStepDataBase) {
            this.proxyWFStepDataBase = (WFStepDataBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepDataService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}