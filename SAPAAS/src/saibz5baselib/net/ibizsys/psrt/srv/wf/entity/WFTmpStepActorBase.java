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
 * 实体[WFTmpStepActor] 数据对象基类
 */
public abstract class WFTmpStepActorBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFTmpStepActorBase.class);
    /**
     * 属性[操作连接]
     */
    public final static String FIELD_CONNECTION = "CONNECTION";
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
     * 属性[上一个处理]
     */
    public final static String FIELD_PREVPROCESS = "PREVPROCESS";
    /**
     * 属性[工作流临时步骤操作者（上一步骤）]
     */
    public final static String FIELD_PREVWFSTEPID = "PREVWFSTEPID";
    /**
     * 属性[工作流临时步骤操作者（上一步骤）]
     */
    public final static String FIELD_PREVWFSTEPNAME = "PREVWFSTEPNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[工作流临时步骤操作者_工作流操作者]
     */
    public final static String FIELD_WFACTORID = "WFACTORID";
    /**
     * 属性[工作流临时步骤操作者_工作流操作者]
     */
    public final static String FIELD_WFACTORNAME = "WFACTORNAME";
    /**
     * 属性[工作流步骤操作者（临时）标识]
     */
    public final static String FIELD_WFTMPSTEPACTORID = "WFTMPSTEPACTORID";
    /**
     * 属性[工作流步骤操作者（临时）名称]
     */
    public final static String FIELD_WFTMPSTEPACTORNAME = "WFTMPSTEPACTORNAME";

    private final static int INDEX_CONNECTION = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_PREVPROCESS = 4;
    private final static int INDEX_PREVWFSTEPID = 5;
    private final static int INDEX_PREVWFSTEPNAME = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_WFACTORID = 9;
    private final static int INDEX_WFACTORNAME = 10;
    private final static int INDEX_WFTMPSTEPACTORID = 11;
    private final static int INDEX_WFTMPSTEPACTORNAME = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CONNECTION, INDEX_CONNECTION);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PREVPROCESS, INDEX_PREVPROCESS);
        fieldIndexMap.put( FIELD_PREVWFSTEPID, INDEX_PREVWFSTEPID);
        fieldIndexMap.put( FIELD_PREVWFSTEPNAME, INDEX_PREVWFSTEPNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFACTORID, INDEX_WFACTORID);
        fieldIndexMap.put( FIELD_WFACTORNAME, INDEX_WFACTORNAME);
        fieldIndexMap.put( FIELD_WFTMPSTEPACTORID, INDEX_WFTMPSTEPACTORID);
        fieldIndexMap.put( FIELD_WFTMPSTEPACTORNAME, INDEX_WFTMPSTEPACTORNAME);
    }

    private WFTmpStepActorBase proxyWFTmpStepActorBase = null;
    public WFTmpStepActorBase() {
        super();
    }
    private boolean connectionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prevprocessDirtyFlag = false;
    private boolean prevwfstepidDirtyFlag = false;
    private boolean prevwfstepnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfactoridDirtyFlag = false;
    private boolean wfactornameDirtyFlag = false;
    private boolean wftmpstepactoridDirtyFlag = false;
    private boolean wftmpstepactornameDirtyFlag = false;

    @Column(name="connection")
    private String connection;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="prevprocess")
    private String prevprocess;
    @Column(name="prevwfstepid")
    private String prevwfstepid;
    @Column(name="prevwfstepname")
    private String prevwfstepname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfactorid")
    private String wfactorid;
    @Column(name="wfactorname")
    private String wfactorname;
    @Column(name="wftmpstepactorid")
    private String wftmpstepactorid;
    @Column(name="wftmpstepactorname")
    private String wftmpstepactorname;


    /**
     *  设置属性值[操作连接]
     *  @param connection
     */
    public void setConnection(String connection) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setConnection(connection);
            return;
        }
        if(connection!=null) {
            connection = StringHelper.trimRight(connection);
            if(connection.length()==0) {
                connection = null;
            }
        }
        this.connection = connection;
        this.connectionDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作连接]
     */
    public String getConnection() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getConnection();
        }
        return this.connection;
    }

    /**
     *  获取属性值[操作连接]是否修改
     */
    public boolean isConnectionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isConnectionDirty();
        }
        return this.connectionDirtyFlag;
    }

    /**
     *  重置属性值[操作连接]
     */
    public void resetConnection() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetConnection();
            return;
        }

        this.connectionDirtyFlag = false;
        this.connection = null;
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
     *  设置属性值[上一个处理]
     *  @param prevprocess
     */
    public void setPrevProcess(String prevprocess) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPrevProcess(prevprocess);
            return;
        }
        if(prevprocess!=null) {
            prevprocess = StringHelper.trimRight(prevprocess);
            if(prevprocess.length()==0) {
                prevprocess = null;
            }
        }
        this.prevprocess = prevprocess;
        this.prevprocessDirtyFlag  = true;
    }

    /**
     *  获取属性值[上一个处理]
     */
    public String getPrevProcess() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPrevProcess();
        }
        return this.prevprocess;
    }

    /**
     *  获取属性值[上一个处理]是否修改
     */
    public boolean isPrevProcessDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPrevProcessDirty();
        }
        return this.prevprocessDirtyFlag;
    }

    /**
     *  重置属性值[上一个处理]
     */
    public void resetPrevProcess() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPrevProcess();
            return;
        }

        this.prevprocessDirtyFlag = false;
        this.prevprocess = null;
    }
    /**
     *  设置属性值[工作流临时步骤操作者（上一步骤）]
     *  @param prevwfstepid
     */
    public void setPrevWFStepId(String prevwfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPrevWFStepId(prevwfstepid);
            return;
        }
        if(prevwfstepid!=null) {
            prevwfstepid = StringHelper.trimRight(prevwfstepid);
            if(prevwfstepid.length()==0) {
                prevwfstepid = null;
            }
        }
        this.prevwfstepid = prevwfstepid;
        this.prevwfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流临时步骤操作者（上一步骤）]
     */
    public String getPrevWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPrevWFStepId();
        }
        return this.prevwfstepid;
    }

    /**
     *  获取属性值[工作流临时步骤操作者（上一步骤）]是否修改
     */
    public boolean isPrevWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPrevWFStepIdDirty();
        }
        return this.prevwfstepidDirtyFlag;
    }

    /**
     *  重置属性值[工作流临时步骤操作者（上一步骤）]
     */
    public void resetPrevWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPrevWFStepId();
            return;
        }

        this.prevwfstepidDirtyFlag = false;
        this.prevwfstepid = null;
    }
    /**
     *  设置属性值[工作流临时步骤操作者（上一步骤）]
     *  @param prevwfstepname
     */
    public void setPrevWFStepName(String prevwfstepname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPrevWFStepName(prevwfstepname);
            return;
        }
        if(prevwfstepname!=null) {
            prevwfstepname = StringHelper.trimRight(prevwfstepname);
            if(prevwfstepname.length()==0) {
                prevwfstepname = null;
            }
        }
        this.prevwfstepname = prevwfstepname;
        this.prevwfstepnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流临时步骤操作者（上一步骤）]
     */
    public String getPrevWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPrevWFStepName();
        }
        return this.prevwfstepname;
    }

    /**
     *  获取属性值[工作流临时步骤操作者（上一步骤）]是否修改
     */
    public boolean isPrevWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPrevWFStepNameDirty();
        }
        return this.prevwfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流临时步骤操作者（上一步骤）]
     */
    public void resetPrevWFStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPrevWFStepName();
            return;
        }

        this.prevwfstepnameDirtyFlag = false;
        this.prevwfstepname = null;
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
     *  设置属性值[工作流临时步骤操作者_工作流操作者]
     *  @param wfactorid
     */
    public void setWFActorId(String wfactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorId(wfactorid);
            return;
        }
        if(wfactorid!=null) {
            wfactorid = StringHelper.trimRight(wfactorid);
            if(wfactorid.length()==0) {
                wfactorid = null;
            }
        }
        this.wfactorid = wfactorid;
        this.wfactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流临时步骤操作者_工作流操作者]
     */
    public String getWFActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorId();
        }
        return this.wfactorid;
    }

    /**
     *  获取属性值[工作流临时步骤操作者_工作流操作者]是否修改
     */
    public boolean isWFActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorIdDirty();
        }
        return this.wfactoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流临时步骤操作者_工作流操作者]
     */
    public void resetWFActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorId();
            return;
        }

        this.wfactoridDirtyFlag = false;
        this.wfactorid = null;
    }
    /**
     *  设置属性值[工作流临时步骤操作者_工作流操作者]
     *  @param wfactorname
     */
    public void setWFActorName(String wfactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorName(wfactorname);
            return;
        }
        if(wfactorname!=null) {
            wfactorname = StringHelper.trimRight(wfactorname);
            if(wfactorname.length()==0) {
                wfactorname = null;
            }
        }
        this.wfactorname = wfactorname;
        this.wfactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流临时步骤操作者_工作流操作者]
     */
    public String getWFActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorName();
        }
        return this.wfactorname;
    }

    /**
     *  获取属性值[工作流临时步骤操作者_工作流操作者]是否修改
     */
    public boolean isWFActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorNameDirty();
        }
        return this.wfactornameDirtyFlag;
    }

    /**
     *  重置属性值[工作流临时步骤操作者_工作流操作者]
     */
    public void resetWFActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorName();
            return;
        }

        this.wfactornameDirtyFlag = false;
        this.wfactorname = null;
    }
    /**
     *  设置属性值[工作流步骤操作者（临时）标识]
     *  @param wftmpstepactorid
     */
    public void setWFTmpStepActorId(String wftmpstepactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFTmpStepActorId(wftmpstepactorid);
            return;
        }
        if(wftmpstepactorid!=null) {
            wftmpstepactorid = StringHelper.trimRight(wftmpstepactorid);
            if(wftmpstepactorid.length()==0) {
                wftmpstepactorid = null;
            }
        }
        this.wftmpstepactorid = wftmpstepactorid;
        this.wftmpstepactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤操作者（临时）标识]
     */
    public String getWFTmpStepActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFTmpStepActorId();
        }
        return this.wftmpstepactorid;
    }

    /**
     *  获取属性值[工作流步骤操作者（临时）标识]是否修改
     */
    public boolean isWFTmpStepActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFTmpStepActorIdDirty();
        }
        return this.wftmpstepactoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤操作者（临时）标识]
     */
    public void resetWFTmpStepActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFTmpStepActorId();
            return;
        }

        this.wftmpstepactoridDirtyFlag = false;
        this.wftmpstepactorid = null;
    }
    /**
     *  设置属性值[工作流步骤操作者（临时）名称]
     *  @param wftmpstepactorname
     */
    public void setWFTmpStepActorName(String wftmpstepactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFTmpStepActorName(wftmpstepactorname);
            return;
        }
        if(wftmpstepactorname!=null) {
            wftmpstepactorname = StringHelper.trimRight(wftmpstepactorname);
            if(wftmpstepactorname.length()==0) {
                wftmpstepactorname = null;
            }
        }
        this.wftmpstepactorname = wftmpstepactorname;
        this.wftmpstepactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤操作者（临时）名称]
     */
    public String getWFTmpStepActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFTmpStepActorName();
        }
        return this.wftmpstepactorname;
    }

    /**
     *  获取属性值[工作流步骤操作者（临时）名称]是否修改
     */
    public boolean isWFTmpStepActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFTmpStepActorNameDirty();
        }
        return this.wftmpstepactornameDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤操作者（临时）名称]
     */
    public void resetWFTmpStepActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFTmpStepActorName();
            return;
        }

        this.wftmpstepactornameDirtyFlag = false;
        this.wftmpstepactorname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFTmpStepActorBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFTmpStepActorBase et) {
        et.resetConnection();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetPrevProcess();
        et.resetPrevWFStepId();
        et.resetPrevWFStepName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFActorId();
        et.resetWFActorName();
        et.resetWFTmpStepActorId();
        et.resetWFTmpStepActorName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isConnectionDirty()) {
            params.put(FIELD_CONNECTION,getConnection());
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
        if(!bDirtyOnly || isPrevProcessDirty()) {
            params.put(FIELD_PREVPROCESS,getPrevProcess());
        }
        if(!bDirtyOnly || isPrevWFStepIdDirty()) {
            params.put(FIELD_PREVWFSTEPID,getPrevWFStepId());
        }
        if(!bDirtyOnly || isPrevWFStepNameDirty()) {
            params.put(FIELD_PREVWFSTEPNAME,getPrevWFStepName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFActorIdDirty()) {
            params.put(FIELD_WFACTORID,getWFActorId());
        }
        if(!bDirtyOnly || isWFActorNameDirty()) {
            params.put(FIELD_WFACTORNAME,getWFActorName());
        }
        if(!bDirtyOnly || isWFTmpStepActorIdDirty()) {
            params.put(FIELD_WFTMPSTEPACTORID,getWFTmpStepActorId());
        }
        if(!bDirtyOnly || isWFTmpStepActorNameDirty()) {
            params.put(FIELD_WFTMPSTEPACTORNAME,getWFTmpStepActorName());
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

        return  WFTmpStepActorBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFTmpStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONNECTION:
            return et.getConnection();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PREVPROCESS:
            return et.getPrevProcess();
        case INDEX_PREVWFSTEPID:
            return et.getPrevWFStepId();
        case INDEX_PREVWFSTEPNAME:
            return et.getPrevWFStepName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFACTORID:
            return et.getWFActorId();
        case INDEX_WFACTORNAME:
            return et.getWFActorName();
        case INDEX_WFTMPSTEPACTORID:
            return et.getWFTmpStepActorId();
        case INDEX_WFTMPSTEPACTORNAME:
            return et.getWFTmpStepActorName();
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

        WFTmpStepActorBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFTmpStepActorBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CONNECTION:
            et.setConnection(DataObject.getStringValue(obj));
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
        case INDEX_PREVPROCESS:
            et.setPrevProcess(DataObject.getStringValue(obj));
            return ;
        case INDEX_PREVWFSTEPID:
            et.setPrevWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PREVWFSTEPNAME:
            et.setPrevWFStepName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORID:
            et.setWFActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORNAME:
            et.setWFActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFTMPSTEPACTORID:
            et.setWFTmpStepActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFTMPSTEPACTORNAME:
            et.setWFTmpStepActorName(DataObject.getStringValue(obj));
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

        return  WFTmpStepActorBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFTmpStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONNECTION:
            return et.getConnection()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PREVPROCESS:
            return et.getPrevProcess()==null;
        case INDEX_PREVWFSTEPID:
            return et.getPrevWFStepId()==null;
        case INDEX_PREVWFSTEPNAME:
            return et.getPrevWFStepName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFACTORID:
            return et.getWFActorId()==null;
        case INDEX_WFACTORNAME:
            return et.getWFActorName()==null;
        case INDEX_WFTMPSTEPACTORID:
            return et.getWFTmpStepActorId()==null;
        case INDEX_WFTMPSTEPACTORNAME:
            return et.getWFTmpStepActorName()==null;
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
        return  WFTmpStepActorBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFTmpStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONNECTION:
            return et.isConnectionDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PREVPROCESS:
            return et.isPrevProcessDirty();
        case INDEX_PREVWFSTEPID:
            return et.isPrevWFStepIdDirty();
        case INDEX_PREVWFSTEPNAME:
            return et.isPrevWFStepNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFACTORID:
            return et.isWFActorIdDirty();
        case INDEX_WFACTORNAME:
            return et.isWFActorNameDirty();
        case INDEX_WFTMPSTEPACTORID:
            return et.isWFTmpStepActorIdDirty();
        case INDEX_WFTMPSTEPACTORNAME:
            return et.isWFTmpStepActorNameDirty();
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
    private static  void fillJSONObject(WFTmpStepActorBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getConnection()!=null) {
            JSONObjectHelper.put(json,"connection",getJSONValue(et.getConnection()),false);
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
        if(bIncEmpty||et.getPrevProcess()!=null) {
            JSONObjectHelper.put(json,"prevprocess",getJSONValue(et.getPrevProcess()),false);
        }
        if(bIncEmpty||et.getPrevWFStepId()!=null) {
            JSONObjectHelper.put(json,"prevwfstepid",getJSONValue(et.getPrevWFStepId()),false);
        }
        if(bIncEmpty||et.getPrevWFStepName()!=null) {
            JSONObjectHelper.put(json,"prevwfstepname",getJSONValue(et.getPrevWFStepName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFActorId()!=null) {
            JSONObjectHelper.put(json,"wfactorid",getJSONValue(et.getWFActorId()),false);
        }
        if(bIncEmpty||et.getWFActorName()!=null) {
            JSONObjectHelper.put(json,"wfactorname",getJSONValue(et.getWFActorName()),false);
        }
        if(bIncEmpty||et.getWFTmpStepActorId()!=null) {
            JSONObjectHelper.put(json,"wftmpstepactorid",getJSONValue(et.getWFTmpStepActorId()),false);
        }
        if(bIncEmpty||et.getWFTmpStepActorName()!=null) {
            JSONObjectHelper.put(json,"wftmpstepactorname",getJSONValue(et.getWFTmpStepActorName()),false);
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
    private static void fillXmlNode(WFTmpStepActorBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getConnection()!=null) {
            Object obj = et.getConnection();
            node.setAttribute("CONNECTION",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getPrevProcess()!=null) {
            Object obj = et.getPrevProcess();
            node.setAttribute("PREVPROCESS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPrevWFStepId()!=null) {
            Object obj = et.getPrevWFStepId();
            node.setAttribute("PREVWFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPrevWFStepName()!=null) {
            Object obj = et.getPrevWFStepName();
            node.setAttribute("PREVWFSTEPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorId()!=null) {
            Object obj = et.getWFActorId();
            node.setAttribute("WFACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorName()!=null) {
            Object obj = et.getWFActorName();
            node.setAttribute("WFACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFTmpStepActorId()!=null) {
            Object obj = et.getWFTmpStepActorId();
            node.setAttribute("WFTMPSTEPACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFTmpStepActorName()!=null) {
            Object obj = et.getWFTmpStepActorName();
            node.setAttribute("WFTMPSTEPACTORNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFTmpStepActorBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFTmpStepActorBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isConnectionDirty() && (bIncEmpty||et.getConnection()!=null)) {
            dst.set(FIELD_CONNECTION,et.getConnection());
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
        if(et.isPrevProcessDirty() && (bIncEmpty||et.getPrevProcess()!=null)) {
            dst.set(FIELD_PREVPROCESS,et.getPrevProcess());
        }
        if(et.isPrevWFStepIdDirty() && (bIncEmpty||et.getPrevWFStepId()!=null)) {
            dst.set(FIELD_PREVWFSTEPID,et.getPrevWFStepId());
        }
        if(et.isPrevWFStepNameDirty() && (bIncEmpty||et.getPrevWFStepName()!=null)) {
            dst.set(FIELD_PREVWFSTEPNAME,et.getPrevWFStepName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFActorIdDirty() && (bIncEmpty||et.getWFActorId()!=null)) {
            dst.set(FIELD_WFACTORID,et.getWFActorId());
        }
        if(et.isWFActorNameDirty() && (bIncEmpty||et.getWFActorName()!=null)) {
            dst.set(FIELD_WFACTORNAME,et.getWFActorName());
        }
        if(et.isWFTmpStepActorIdDirty() && (bIncEmpty||et.getWFTmpStepActorId()!=null)) {
            dst.set(FIELD_WFTMPSTEPACTORID,et.getWFTmpStepActorId());
        }
        if(et.isWFTmpStepActorNameDirty() && (bIncEmpty||et.getWFTmpStepActorName()!=null)) {
            dst.set(FIELD_WFTMPSTEPACTORNAME,et.getWFTmpStepActorName());
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
        return  WFTmpStepActorBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFTmpStepActorBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CONNECTION:
            et.resetConnection();
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
        case INDEX_PREVPROCESS:
            et.resetPrevProcess();
            return true;
        case INDEX_PREVWFSTEPID:
            et.resetPrevWFStepId();
            return true;
        case INDEX_PREVWFSTEPNAME:
            et.resetPrevWFStepName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFACTORID:
            et.resetWFActorId();
            return true;
        case INDEX_WFACTORNAME:
            et.resetWFActorName();
            return true;
        case INDEX_WFTMPSTEPACTORID:
            et.resetWFTmpStepActorId();
            return true;
        case INDEX_WFTMPSTEPACTORNAME:
            et.resetWFTmpStepActorName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFActorLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFActor wfactor = null;
    /**
    * 获取父数据 工作流操作者
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFActor getWFActor() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActor();
        }

        if(this.getWFActorId()==null)
            return null;
        synchronized(this.objWFActorLock) {
            if(this.wfactor!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFActorId(),wfactor.getWFActorId())!=0) {
                    this.wfactor = null;
                }
            }


            if(this.wfactor==null) {
                net.ibizsys.psrt.srv.wf.entity.WFActor wfactor = new net.ibizsys.psrt.srv.wf.entity.WFActor();
                wfactor.setWFActorId(this.getWFActorId());
                net.ibizsys.psrt.srv.wf.service.WFActorService service = (net.ibizsys.psrt.srv.wf.service.WFActorService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFActorService.class,this.getSessionFactory());
                service.autoGet(wfactor);
                this.wfactor = wfactor;
            }
            return this.wfactor;
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

        if(this.getPrevWFStepId()==null)
            return null;
        synchronized(this.objWFStepLock) {
            if(this.wfstep!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getPrevWFStepId(),wfstep.getWFStepId())!=0) {
                    this.wfstep = null;
                }
            }


            if(this.wfstep==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = new net.ibizsys.psrt.srv.wf.entity.WFStep();
                wfstep.setWFStepId(this.getPrevWFStepId());
                net.ibizsys.psrt.srv.wf.service.WFStepService service = (net.ibizsys.psrt.srv.wf.service.WFStepService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepService.class,this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFTmpStepActorBase getProxyEntity() {
        return this.proxyWFTmpStepActorBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFTmpStepActorBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFTmpStepActorBase) {
            this.proxyWFTmpStepActorBase = (WFTmpStepActorBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}