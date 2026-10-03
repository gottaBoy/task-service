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
 * 实体[WFUser] 数据对象基类
 */
public abstract class WFUserBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[是否接收工作]
     */
    public final static String FIELD_ISRECVWORK = "ISRECVWORK";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[接收工作通知]
     */
    public final static String FIELD_RECVINFORM = "RECVINFORM";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[有效标志]
     */
    public final static String FIELD_VALIDFLAG = "VALIDFLAG";
    /**
     * 属性[工作流用户标识]
     */
    public final static String FIELD_WFUSERID = "WFUSERID";
    /**
     * 属性[工作流用户名称]
     */
    public final static String FIELD_WFUSERNAME = "WFUSERNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ISRECVWORK = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_RECVINFORM = 4;
    private final static int INDEX_RESERVER = 5;
    private final static int INDEX_RESERVER2 = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_VALIDFLAG = 9;
    private final static int INDEX_WFUSERID = 10;
    private final static int INDEX_WFUSERNAME = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ISRECVWORK, INDEX_ISRECVWORK);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_RECVINFORM, INDEX_RECVINFORM);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VALIDFLAG, INDEX_VALIDFLAG);
        fieldIndexMap.put( FIELD_WFUSERID, INDEX_WFUSERID);
        fieldIndexMap.put( FIELD_WFUSERNAME, INDEX_WFUSERNAME);
    }

    private WFUserBase proxyWFUserBase = null;
    public WFUserBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isrecvworkDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean recvinformDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="isrecvwork")
    private Integer isrecvwork;
    @Column(name="memo")
    private String memo;
    @Column(name="recvinform")
    private Integer recvinform;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;


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
     *  设置属性值[是否接收工作]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isrecvwork
     */
    public void setIsRecvWork(Integer isrecvwork) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsRecvWork(isrecvwork);
            return;
        }
        this.isrecvwork = isrecvwork;
        this.isrecvworkDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否接收工作]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsRecvWork() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsRecvWork();
        }
        return this.isrecvwork;
    }

    /**
     *  获取属性值[是否接收工作]是否修改
     */
    public boolean isIsRecvWorkDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsRecvWorkDirty();
        }
        return this.isrecvworkDirtyFlag;
    }

    /**
     *  重置属性值[是否接收工作]
     */
    public void resetIsRecvWork() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsRecvWork();
            return;
        }

        this.isrecvworkDirtyFlag = false;
        this.isrecvwork = null;
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
     *  设置属性值[接收工作通知]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param recvinform
     */
    public void setRecvInform(Integer recvinform) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRecvInform(recvinform);
            return;
        }
        this.recvinform = recvinform;
        this.recvinformDirtyFlag  = true;
    }

    /**
     *  获取属性值[接收工作通知]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getRecvInform() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRecvInform();
        }
        return this.recvinform;
    }

    /**
     *  获取属性值[接收工作通知]是否修改
     */
    public boolean isRecvInformDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRecvInformDirty();
        }
        return this.recvinformDirtyFlag;
    }

    /**
     *  重置属性值[接收工作通知]
     */
    public void resetRecvInform() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRecvInform();
            return;
        }

        this.recvinformDirtyFlag = false;
        this.recvinform = null;
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
     *  设置属性值[有效标志]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param validflag
     */
    public void setValidFlag(Integer validflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[有效标志]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getValidFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    /**
     *  获取属性值[有效标志]是否修改
     */
    public boolean isValidFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    /**
     *  重置属性值[有效标志]
     */
    public void resetValidFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }

        this.validflagDirtyFlag = false;
        this.validflag = null;
    }
    /**
     *  设置属性值[工作流用户标识]
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
     *  获取属性值[工作流用户标识]
     */
    public String getWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    /**
     *  获取属性值[工作流用户标识]是否修改
     */
    public boolean isWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户标识]
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
     *  设置属性值[工作流用户名称]
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
     *  获取属性值[工作流用户名称]
     */
    public String getWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    /**
     *  获取属性值[工作流用户名称]是否修改
     */
    public boolean isWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户名称]
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
        WFUserBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsRecvWork();
        et.resetMemo();
        et.resetRecvInform();
        et.resetReserver();
        et.resetReserver2();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
        et.resetWFUserId();
        et.resetWFUserName();
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
        if(!bDirtyOnly || isIsRecvWorkDirty()) {
            params.put(FIELD_ISRECVWORK,getIsRecvWork());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isRecvInformDirty()) {
            params.put(FIELD_RECVINFORM,getRecvInform());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG,getValidFlag());
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

        return  WFUserBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ISRECVWORK:
            return et.getIsRecvWork();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_RECVINFORM:
            return et.getRecvInform();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VALIDFLAG:
            return et.getValidFlag();
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

        WFUserBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUserBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISRECVWORK:
            et.setIsRecvWork(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_RECVINFORM:
            et.setRecvInform(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VALIDFLAG:
            et.setValidFlag(DataObject.getIntegerValue(obj));
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

        return  WFUserBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ISRECVWORK:
            return et.getIsRecvWork()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_RECVINFORM:
            return et.getRecvInform()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VALIDFLAG:
            return et.getValidFlag()==null;
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
        return  WFUserBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ISRECVWORK:
            return et.isIsRecvWorkDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_RECVINFORM:
            return et.isRecvInformDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VALIDFLAG:
            return et.isValidFlagDirty();
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
    private static  void fillJSONObject(WFUserBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getIsRecvWork()!=null) {
            JSONObjectHelper.put(json,"isrecvwork",getJSONValue(et.getIsRecvWork()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getRecvInform()!=null) {
            JSONObjectHelper.put(json,"recvinform",getJSONValue(et.getRecvInform()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            JSONObjectHelper.put(json,"validflag",getJSONValue(et.getValidFlag()),false);
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
    private static void fillXmlNode(WFUserBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsRecvWork()!=null) {
            Object obj = et.getIsRecvWork();
            node.setAttribute("ISRECVWORK",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRecvInform()!=null) {
            Object obj = et.getRecvInform();
            node.setAttribute("RECVINFORM",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            Object obj = et.getValidFlag();
            node.setAttribute("VALIDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        WFUserBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUserBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isIsRecvWorkDirty() && (bIncEmpty||et.getIsRecvWork()!=null)) {
            dst.set(FIELD_ISRECVWORK,et.getIsRecvWork());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isRecvInformDirty() && (bIncEmpty||et.getRecvInform()!=null)) {
            dst.set(FIELD_RECVINFORM,et.getRecvInform());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isValidFlagDirty() && (bIncEmpty||et.getValidFlag()!=null)) {
            dst.set(FIELD_VALIDFLAG,et.getValidFlag());
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
        return  WFUserBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUserBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ISRECVWORK:
            et.resetIsRecvWork();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_RECVINFORM:
            et.resetRecvInform();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VALIDFLAG:
            et.resetValidFlag();
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




    /**
     *  获取代理的数据对象
     */
    private WFUserBase getProxyEntity() {
        return this.proxyWFUserBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUserBase) {
            this.proxyWFUserBase = (WFUserBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}