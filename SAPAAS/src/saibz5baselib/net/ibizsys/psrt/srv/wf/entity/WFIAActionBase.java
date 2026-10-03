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
 * 实体[WFIAAction] 数据对象基类
 */
public abstract class WFIAActionBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFIAActionBase.class);
    /**
     * 属性[ACTIONCOUNT]
     */
    public final static String FIELD_ACTIONCOUNT = "ACTIONCOUNT";
    /**
     * 属性[ACTIONLOGICNAME]
     */
    public final static String FIELD_ACTIONLOGICNAME = "ACTIONLOGICNAME";
    /**
     * 属性[ACTIONNAME]
     */
    public final static String FIELD_ACTIONNAME = "ACTIONNAME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[FAHELPER]
     */
    public final static String FIELD_FAHELPER = "FAHELPER";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[NEXTCONDITION]
     */
    public final static String FIELD_NEXTCONDITION = "NEXTCONDITION";
    /**
     * 属性[NEXTTO]
     */
    public final static String FIELD_NEXTTO = "NEXTTO";
    /**
     * 属性[ORDERFLAG]
     */
    public final static String FIELD_ORDERFLAG = "ORDERFLAG";
    /**
     * 属性[PAGEPATH]
     */
    public final static String FIELD_PAGEPATH = "PAGEPATH";
    /**
     * 属性[PANELID]
     */
    public final static String FIELD_PANELID = "PANELID";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[工作流交互操作标识]
     */
    public final static String FIELD_WFIAACTIONID = "WFIAACTIONID";
    /**
     * 属性[工作流交互操作名称]
     */
    public final static String FIELD_WFIAACTIONNAME = "WFIAACTIONNAME";
    /**
     * 属性[互动操作_相关步骤]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[WFSTEPNAME]
     */
    public final static String FIELD_WFSTEPNAME = "WFSTEPNAME";

    private final static int INDEX_ACTIONCOUNT = 0;
    private final static int INDEX_ACTIONLOGICNAME = 1;
    private final static int INDEX_ACTIONNAME = 2;
    private final static int INDEX_CREATEDATE = 3;
    private final static int INDEX_CREATEMAN = 4;
    private final static int INDEX_FAHELPER = 5;
    private final static int INDEX_MEMO = 6;
    private final static int INDEX_NEXTCONDITION = 7;
    private final static int INDEX_NEXTTO = 8;
    private final static int INDEX_ORDERFLAG = 9;
    private final static int INDEX_PAGEPATH = 10;
    private final static int INDEX_PANELID = 11;
    private final static int INDEX_UPDATEDATE = 12;
    private final static int INDEX_UPDATEMAN = 13;
    private final static int INDEX_WFIAACTIONID = 14;
    private final static int INDEX_WFIAACTIONNAME = 15;
    private final static int INDEX_WFSTEPID = 16;
    private final static int INDEX_WFSTEPNAME = 17;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTIONCOUNT, INDEX_ACTIONCOUNT);
        fieldIndexMap.put( FIELD_ACTIONLOGICNAME, INDEX_ACTIONLOGICNAME);
        fieldIndexMap.put( FIELD_ACTIONNAME, INDEX_ACTIONNAME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_FAHELPER, INDEX_FAHELPER);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_NEXTCONDITION, INDEX_NEXTCONDITION);
        fieldIndexMap.put( FIELD_NEXTTO, INDEX_NEXTTO);
        fieldIndexMap.put( FIELD_ORDERFLAG, INDEX_ORDERFLAG);
        fieldIndexMap.put( FIELD_PAGEPATH, INDEX_PAGEPATH);
        fieldIndexMap.put( FIELD_PANELID, INDEX_PANELID);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFIAACTIONID, INDEX_WFIAACTIONID);
        fieldIndexMap.put( FIELD_WFIAACTIONNAME, INDEX_WFIAACTIONNAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFSTEPNAME, INDEX_WFSTEPNAME);
    }

    private WFIAActionBase proxyWFIAActionBase = null;
    public WFIAActionBase() {
        super();
    }
    private boolean actioncountDirtyFlag = false;
    private boolean actionlogicnameDirtyFlag = false;
    private boolean actionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fahelperDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nextconditionDirtyFlag = false;
    private boolean nexttoDirtyFlag = false;
    private boolean orderflagDirtyFlag = false;
    private boolean pagepathDirtyFlag = false;
    private boolean panelidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfiaactionidDirtyFlag = false;
    private boolean wfiaactionnameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;

    @Column(name="actioncount")
    private Integer actioncount;
    @Column(name="actionlogicname")
    private String actionlogicname;
    @Column(name="actionname")
    private String actionname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fahelper")
    private String fahelper;
    @Column(name="memo")
    private String memo;
    @Column(name="nextcondition")
    private String nextcondition;
    @Column(name="nextto")
    private String nextto;
    @Column(name="orderflag")
    private Integer orderflag;
    @Column(name="pagepath")
    private String pagepath;
    @Column(name="panelid")
    private String panelid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfiaactionid")
    private String wfiaactionid;
    @Column(name="wfiaactionname")
    private String wfiaactionname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfstepname")
    private String wfstepname;


    /**
     *  设置属性值[ACTIONCOUNT]
     *  @param actioncount
     */
    public void setActionCount(Integer actioncount) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionCount(actioncount);
            return;
        }
        this.actioncount = actioncount;
        this.actioncountDirtyFlag  = true;
    }

    /**
     *  获取属性值[ACTIONCOUNT]
     */
    public Integer getActionCount() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionCount();
        }
        return this.actioncount;
    }

    /**
     *  获取属性值[ACTIONCOUNT]是否修改
     */
    public boolean isActionCountDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionCountDirty();
        }
        return this.actioncountDirtyFlag;
    }

    /**
     *  重置属性值[ACTIONCOUNT]
     */
    public void resetActionCount() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionCount();
            return;
        }

        this.actioncountDirtyFlag = false;
        this.actioncount = null;
    }
    /**
     *  设置属性值[ACTIONLOGICNAME]
     *  @param actionlogicname
     */
    public void setActionLogicName(String actionlogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionLogicName(actionlogicname);
            return;
        }
        if(actionlogicname!=null) {
            actionlogicname = StringHelper.trimRight(actionlogicname);
            if(actionlogicname.length()==0) {
                actionlogicname = null;
            }
        }
        this.actionlogicname = actionlogicname;
        this.actionlogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[ACTIONLOGICNAME]
     */
    public String getActionLogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionLogicName();
        }
        return this.actionlogicname;
    }

    /**
     *  获取属性值[ACTIONLOGICNAME]是否修改
     */
    public boolean isActionLogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionLogicNameDirty();
        }
        return this.actionlogicnameDirtyFlag;
    }

    /**
     *  重置属性值[ACTIONLOGICNAME]
     */
    public void resetActionLogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionLogicName();
            return;
        }

        this.actionlogicnameDirtyFlag = false;
        this.actionlogicname = null;
    }
    /**
     *  设置属性值[ACTIONNAME]
     *  @param actionname
     */
    public void setActionName(String actionname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActionName(actionname);
            return;
        }
        if(actionname!=null) {
            actionname = StringHelper.trimRight(actionname);
            if(actionname.length()==0) {
                actionname = null;
            }
        }
        this.actionname = actionname;
        this.actionnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[ACTIONNAME]
     */
    public String getActionName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActionName();
        }
        return this.actionname;
    }

    /**
     *  获取属性值[ACTIONNAME]是否修改
     */
    public boolean isActionNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActionNameDirty();
        }
        return this.actionnameDirtyFlag;
    }

    /**
     *  重置属性值[ACTIONNAME]
     */
    public void resetActionName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActionName();
            return;
        }

        this.actionnameDirtyFlag = false;
        this.actionname = null;
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
     *  设置属性值[FAHELPER]
     *  @param fahelper
     */
    public void setFAHelper(String fahelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFAHelper(fahelper);
            return;
        }
        if(fahelper!=null) {
            fahelper = StringHelper.trimRight(fahelper);
            if(fahelper.length()==0) {
                fahelper = null;
            }
        }
        this.fahelper = fahelper;
        this.fahelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[FAHELPER]
     */
    public String getFAHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFAHelper();
        }
        return this.fahelper;
    }

    /**
     *  获取属性值[FAHELPER]是否修改
     */
    public boolean isFAHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFAHelperDirty();
        }
        return this.fahelperDirtyFlag;
    }

    /**
     *  重置属性值[FAHELPER]
     */
    public void resetFAHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFAHelper();
            return;
        }

        this.fahelperDirtyFlag = false;
        this.fahelper = null;
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
     *  设置属性值[NEXTCONDITION]
     *  @param nextcondition
     */
    public void setNextCondition(String nextcondition) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNextCondition(nextcondition);
            return;
        }
        if(nextcondition!=null) {
            nextcondition = StringHelper.trimRight(nextcondition);
            if(nextcondition.length()==0) {
                nextcondition = null;
            }
        }
        this.nextcondition = nextcondition;
        this.nextconditionDirtyFlag  = true;
    }

    /**
     *  获取属性值[NEXTCONDITION]
     */
    public String getNextCondition() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNextCondition();
        }
        return this.nextcondition;
    }

    /**
     *  获取属性值[NEXTCONDITION]是否修改
     */
    public boolean isNextConditionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNextConditionDirty();
        }
        return this.nextconditionDirtyFlag;
    }

    /**
     *  重置属性值[NEXTCONDITION]
     */
    public void resetNextCondition() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNextCondition();
            return;
        }

        this.nextconditionDirtyFlag = false;
        this.nextcondition = null;
    }
    /**
     *  设置属性值[NEXTTO]
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
     *  获取属性值[NEXTTO]
     */
    public String getNextTo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNextTo();
        }
        return this.nextto;
    }

    /**
     *  获取属性值[NEXTTO]是否修改
     */
    public boolean isNextToDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNextToDirty();
        }
        return this.nexttoDirtyFlag;
    }

    /**
     *  重置属性值[NEXTTO]
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
     *  设置属性值[ORDERFLAG]
     *  @param orderflag
     */
    public void setOrderFlag(Integer orderflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrderFlag(orderflag);
            return;
        }
        this.orderflag = orderflag;
        this.orderflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[ORDERFLAG]
     */
    public Integer getOrderFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrderFlag();
        }
        return this.orderflag;
    }

    /**
     *  获取属性值[ORDERFLAG]是否修改
     */
    public boolean isOrderFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrderFlagDirty();
        }
        return this.orderflagDirtyFlag;
    }

    /**
     *  重置属性值[ORDERFLAG]
     */
    public void resetOrderFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrderFlag();
            return;
        }

        this.orderflagDirtyFlag = false;
        this.orderflag = null;
    }
    /**
     *  设置属性值[PAGEPATH]
     *  @param pagepath
     */
    public void setPagePath(String pagepath) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPagePath(pagepath);
            return;
        }
        if(pagepath!=null) {
            pagepath = StringHelper.trimRight(pagepath);
            if(pagepath.length()==0) {
                pagepath = null;
            }
        }
        this.pagepath = pagepath;
        this.pagepathDirtyFlag  = true;
    }

    /**
     *  获取属性值[PAGEPATH]
     */
    public String getPagePath() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPagePath();
        }
        return this.pagepath;
    }

    /**
     *  获取属性值[PAGEPATH]是否修改
     */
    public boolean isPagePathDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPagePathDirty();
        }
        return this.pagepathDirtyFlag;
    }

    /**
     *  重置属性值[PAGEPATH]
     */
    public void resetPagePath() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPagePath();
            return;
        }

        this.pagepathDirtyFlag = false;
        this.pagepath = null;
    }
    /**
     *  设置属性值[PANELID]
     *  @param panelid
     */
    public void setPanelId(String panelid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPanelId(panelid);
            return;
        }
        if(panelid!=null) {
            panelid = StringHelper.trimRight(panelid);
            if(panelid.length()==0) {
                panelid = null;
            }
        }
        this.panelid = panelid;
        this.panelidDirtyFlag  = true;
    }

    /**
     *  获取属性值[PANELID]
     */
    public String getPanelId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPanelId();
        }
        return this.panelid;
    }

    /**
     *  获取属性值[PANELID]是否修改
     */
    public boolean isPanelIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPanelIdDirty();
        }
        return this.panelidDirtyFlag;
    }

    /**
     *  重置属性值[PANELID]
     */
    public void resetPanelId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPanelId();
            return;
        }

        this.panelidDirtyFlag = false;
        this.panelid = null;
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
     *  设置属性值[工作流交互操作标识]
     *  @param wfiaactionid
     */
    public void setWFIAActionId(String wfiaactionid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFIAActionId(wfiaactionid);
            return;
        }
        if(wfiaactionid!=null) {
            wfiaactionid = StringHelper.trimRight(wfiaactionid);
            if(wfiaactionid.length()==0) {
                wfiaactionid = null;
            }
        }
        this.wfiaactionid = wfiaactionid;
        this.wfiaactionidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流交互操作标识]
     */
    public String getWFIAActionId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFIAActionId();
        }
        return this.wfiaactionid;
    }

    /**
     *  获取属性值[工作流交互操作标识]是否修改
     */
    public boolean isWFIAActionIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFIAActionIdDirty();
        }
        return this.wfiaactionidDirtyFlag;
    }

    /**
     *  重置属性值[工作流交互操作标识]
     */
    public void resetWFIAActionId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFIAActionId();
            return;
        }

        this.wfiaactionidDirtyFlag = false;
        this.wfiaactionid = null;
    }
    /**
     *  设置属性值[工作流交互操作名称]
     *  @param wfiaactionname
     */
    public void setWFIAActionName(String wfiaactionname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFIAActionName(wfiaactionname);
            return;
        }
        if(wfiaactionname!=null) {
            wfiaactionname = StringHelper.trimRight(wfiaactionname);
            if(wfiaactionname.length()==0) {
                wfiaactionname = null;
            }
        }
        this.wfiaactionname = wfiaactionname;
        this.wfiaactionnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流交互操作名称]
     */
    public String getWFIAActionName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFIAActionName();
        }
        return this.wfiaactionname;
    }

    /**
     *  获取属性值[工作流交互操作名称]是否修改
     */
    public boolean isWFIAActionNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFIAActionNameDirty();
        }
        return this.wfiaactionnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流交互操作名称]
     */
    public void resetWFIAActionName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFIAActionName();
            return;
        }

        this.wfiaactionnameDirtyFlag = false;
        this.wfiaactionname = null;
    }
    /**
     *  设置属性值[互动操作_相关步骤]
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
     *  获取属性值[互动操作_相关步骤]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[互动操作_相关步骤]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[互动操作_相关步骤]
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
     *  设置属性值[WFSTEPNAME]
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
     *  获取属性值[WFSTEPNAME]
     */
    public String getWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    /**
     *  获取属性值[WFSTEPNAME]是否修改
     */
    public boolean isWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[WFSTEPNAME]
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
        WFIAActionBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFIAActionBase et) {
        et.resetActionCount();
        et.resetActionLogicName();
        et.resetActionName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetFAHelper();
        et.resetMemo();
        et.resetNextCondition();
        et.resetNextTo();
        et.resetOrderFlag();
        et.resetPagePath();
        et.resetPanelId();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFIAActionId();
        et.resetWFIAActionName();
        et.resetWFStepId();
        et.resetWFStepName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActionCountDirty()) {
            params.put(FIELD_ACTIONCOUNT,getActionCount());
        }
        if(!bDirtyOnly || isActionLogicNameDirty()) {
            params.put(FIELD_ACTIONLOGICNAME,getActionLogicName());
        }
        if(!bDirtyOnly || isActionNameDirty()) {
            params.put(FIELD_ACTIONNAME,getActionName());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isFAHelperDirty()) {
            params.put(FIELD_FAHELPER,getFAHelper());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isNextConditionDirty()) {
            params.put(FIELD_NEXTCONDITION,getNextCondition());
        }
        if(!bDirtyOnly || isNextToDirty()) {
            params.put(FIELD_NEXTTO,getNextTo());
        }
        if(!bDirtyOnly || isOrderFlagDirty()) {
            params.put(FIELD_ORDERFLAG,getOrderFlag());
        }
        if(!bDirtyOnly || isPagePathDirty()) {
            params.put(FIELD_PAGEPATH,getPagePath());
        }
        if(!bDirtyOnly || isPanelIdDirty()) {
            params.put(FIELD_PANELID,getPanelId());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFIAActionIdDirty()) {
            params.put(FIELD_WFIAACTIONID,getWFIAActionId());
        }
        if(!bDirtyOnly || isWFIAActionNameDirty()) {
            params.put(FIELD_WFIAACTIONNAME,getWFIAActionName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
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

        return  WFIAActionBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFIAActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONCOUNT:
            return et.getActionCount();
        case INDEX_ACTIONLOGICNAME:
            return et.getActionLogicName();
        case INDEX_ACTIONNAME:
            return et.getActionName();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_FAHELPER:
            return et.getFAHelper();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_NEXTCONDITION:
            return et.getNextCondition();
        case INDEX_NEXTTO:
            return et.getNextTo();
        case INDEX_ORDERFLAG:
            return et.getOrderFlag();
        case INDEX_PAGEPATH:
            return et.getPagePath();
        case INDEX_PANELID:
            return et.getPanelId();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFIAACTIONID:
            return et.getWFIAActionId();
        case INDEX_WFIAACTIONNAME:
            return et.getWFIAActionName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
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

        WFIAActionBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFIAActionBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTIONCOUNT:
            et.setActionCount(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ACTIONLOGICNAME:
            et.setActionLogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTIONNAME:
            et.setActionName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_FAHELPER:
            et.setFAHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_NEXTCONDITION:
            et.setNextCondition(DataObject.getStringValue(obj));
            return ;
        case INDEX_NEXTTO:
            et.setNextTo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORDERFLAG:
            et.setOrderFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_PAGEPATH:
            et.setPagePath(DataObject.getStringValue(obj));
            return ;
        case INDEX_PANELID:
            et.setPanelId(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFIAACTIONID:
            et.setWFIAActionId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFIAACTIONNAME:
            et.setWFIAActionName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
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

        return  WFIAActionBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFIAActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONCOUNT:
            return et.getActionCount()==null;
        case INDEX_ACTIONLOGICNAME:
            return et.getActionLogicName()==null;
        case INDEX_ACTIONNAME:
            return et.getActionName()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_FAHELPER:
            return et.getFAHelper()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_NEXTCONDITION:
            return et.getNextCondition()==null;
        case INDEX_NEXTTO:
            return et.getNextTo()==null;
        case INDEX_ORDERFLAG:
            return et.getOrderFlag()==null;
        case INDEX_PAGEPATH:
            return et.getPagePath()==null;
        case INDEX_PANELID:
            return et.getPanelId()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFIAACTIONID:
            return et.getWFIAActionId()==null;
        case INDEX_WFIAACTIONNAME:
            return et.getWFIAActionName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
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
        return  WFIAActionBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFIAActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIONCOUNT:
            return et.isActionCountDirty();
        case INDEX_ACTIONLOGICNAME:
            return et.isActionLogicNameDirty();
        case INDEX_ACTIONNAME:
            return et.isActionNameDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_FAHELPER:
            return et.isFAHelperDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_NEXTCONDITION:
            return et.isNextConditionDirty();
        case INDEX_NEXTTO:
            return et.isNextToDirty();
        case INDEX_ORDERFLAG:
            return et.isOrderFlagDirty();
        case INDEX_PAGEPATH:
            return et.isPagePathDirty();
        case INDEX_PANELID:
            return et.isPanelIdDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFIAACTIONID:
            return et.isWFIAActionIdDirty();
        case INDEX_WFIAACTIONNAME:
            return et.isWFIAActionNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
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
    private static  void fillJSONObject(WFIAActionBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionCount()!=null) {
            JSONObjectHelper.put(json,"actioncount",getJSONValue(et.getActionCount()),false);
        }
        if(bIncEmpty||et.getActionLogicName()!=null) {
            JSONObjectHelper.put(json,"actionlogicname",getJSONValue(et.getActionLogicName()),false);
        }
        if(bIncEmpty||et.getActionName()!=null) {
            JSONObjectHelper.put(json,"actionname",getJSONValue(et.getActionName()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getFAHelper()!=null) {
            JSONObjectHelper.put(json,"fahelper",getJSONValue(et.getFAHelper()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getNextCondition()!=null) {
            JSONObjectHelper.put(json,"nextcondition",getJSONValue(et.getNextCondition()),false);
        }
        if(bIncEmpty||et.getNextTo()!=null) {
            JSONObjectHelper.put(json,"nextto",getJSONValue(et.getNextTo()),false);
        }
        if(bIncEmpty||et.getOrderFlag()!=null) {
            JSONObjectHelper.put(json,"orderflag",getJSONValue(et.getOrderFlag()),false);
        }
        if(bIncEmpty||et.getPagePath()!=null) {
            JSONObjectHelper.put(json,"pagepath",getJSONValue(et.getPagePath()),false);
        }
        if(bIncEmpty||et.getPanelId()!=null) {
            JSONObjectHelper.put(json,"panelid",getJSONValue(et.getPanelId()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFIAActionId()!=null) {
            JSONObjectHelper.put(json,"wfiaactionid",getJSONValue(et.getWFIAActionId()),false);
        }
        if(bIncEmpty||et.getWFIAActionName()!=null) {
            JSONObjectHelper.put(json,"wfiaactionname",getJSONValue(et.getWFIAActionName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
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
    private static void fillXmlNode(WFIAActionBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActionCount()!=null) {
            Object obj = et.getActionCount();
            node.setAttribute("ACTIONCOUNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getActionLogicName()!=null) {
            Object obj = et.getActionLogicName();
            node.setAttribute("ACTIONLOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActionName()!=null) {
            Object obj = et.getActionName();
            node.setAttribute("ACTIONNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFAHelper()!=null) {
            Object obj = et.getFAHelper();
            node.setAttribute("FAHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getNextCondition()!=null) {
            Object obj = et.getNextCondition();
            node.setAttribute("NEXTCONDITION",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getNextTo()!=null) {
            Object obj = et.getNextTo();
            node.setAttribute("NEXTTO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrderFlag()!=null) {
            Object obj = et.getOrderFlag();
            node.setAttribute("ORDERFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getPagePath()!=null) {
            Object obj = et.getPagePath();
            node.setAttribute("PAGEPATH",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPanelId()!=null) {
            Object obj = et.getPanelId();
            node.setAttribute("PANELID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFIAActionId()!=null) {
            Object obj = et.getWFIAActionId();
            node.setAttribute("WFIAACTIONID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFIAActionName()!=null) {
            Object obj = et.getWFIAActionName();
            node.setAttribute("WFIAACTIONNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
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
        WFIAActionBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFIAActionBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActionCountDirty() && (bIncEmpty||et.getActionCount()!=null)) {
            dst.set(FIELD_ACTIONCOUNT,et.getActionCount());
        }
        if(et.isActionLogicNameDirty() && (bIncEmpty||et.getActionLogicName()!=null)) {
            dst.set(FIELD_ACTIONLOGICNAME,et.getActionLogicName());
        }
        if(et.isActionNameDirty() && (bIncEmpty||et.getActionName()!=null)) {
            dst.set(FIELD_ACTIONNAME,et.getActionName());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isFAHelperDirty() && (bIncEmpty||et.getFAHelper()!=null)) {
            dst.set(FIELD_FAHELPER,et.getFAHelper());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isNextConditionDirty() && (bIncEmpty||et.getNextCondition()!=null)) {
            dst.set(FIELD_NEXTCONDITION,et.getNextCondition());
        }
        if(et.isNextToDirty() && (bIncEmpty||et.getNextTo()!=null)) {
            dst.set(FIELD_NEXTTO,et.getNextTo());
        }
        if(et.isOrderFlagDirty() && (bIncEmpty||et.getOrderFlag()!=null)) {
            dst.set(FIELD_ORDERFLAG,et.getOrderFlag());
        }
        if(et.isPagePathDirty() && (bIncEmpty||et.getPagePath()!=null)) {
            dst.set(FIELD_PAGEPATH,et.getPagePath());
        }
        if(et.isPanelIdDirty() && (bIncEmpty||et.getPanelId()!=null)) {
            dst.set(FIELD_PANELID,et.getPanelId());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFIAActionIdDirty() && (bIncEmpty||et.getWFIAActionId()!=null)) {
            dst.set(FIELD_WFIAACTIONID,et.getWFIAActionId());
        }
        if(et.isWFIAActionNameDirty() && (bIncEmpty||et.getWFIAActionName()!=null)) {
            dst.set(FIELD_WFIAACTIONNAME,et.getWFIAActionName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
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
        return  WFIAActionBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFIAActionBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTIONCOUNT:
            et.resetActionCount();
            return true;
        case INDEX_ACTIONLOGICNAME:
            et.resetActionLogicName();
            return true;
        case INDEX_ACTIONNAME:
            et.resetActionName();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_FAHELPER:
            et.resetFAHelper();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_NEXTCONDITION:
            et.resetNextCondition();
            return true;
        case INDEX_NEXTTO:
            et.resetNextTo();
            return true;
        case INDEX_ORDERFLAG:
            et.resetOrderFlag();
            return true;
        case INDEX_PAGEPATH:
            et.resetPagePath();
            return true;
        case INDEX_PANELID:
            et.resetPanelId();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFIAACTIONID:
            et.resetWFIAActionId();
            return true;
        case INDEX_WFIAACTIONNAME:
            et.resetWFIAActionName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
            return true;
        case INDEX_WFSTEPNAME:
            et.resetWFStepName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWfstepLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = null;
    /**
    * 获取父数据 工作流步骤
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStep getWfstep() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWfstep();
        }

        if(this.getWFStepId()==null)
            return null;
        synchronized(this.objWfstepLock) {
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



    /**
     *  获取代理的数据对象
     */
    private WFIAActionBase getProxyEntity() {
        return this.proxyWFIAActionBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFIAActionBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFIAActionBase) {
            this.proxyWFIAActionBase = (WFIAActionBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFIAActionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}