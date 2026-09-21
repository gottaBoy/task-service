/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFIAActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFIAActionBase.class);
    public static final String FIELD_ACTIONCOUNT = "ACTIONCOUNT";
    public static final String FIELD_ACTIONLOGICNAME = "ACTIONLOGICNAME";
    public static final String FIELD_ACTIONNAME = "ACTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FAHELPER = "FAHELPER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEXTCONDITION = "NEXTCONDITION";
    public static final String FIELD_NEXTTO = "NEXTTO";
    public static final String FIELD_ORDERFLAG = "ORDERFLAG";
    public static final String FIELD_PAGEPATH = "PAGEPATH";
    public static final String FIELD_PANELID = "PANELID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFIAACTIONID = "WFIAACTIONID";
    public static final String FIELD_WFIAACTIONNAME = "WFIAACTIONNAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    private static final int INDEX_ACTIONCOUNT = 0;
    private static final int INDEX_ACTIONLOGICNAME = 1;
    private static final int INDEX_ACTIONNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_FAHELPER = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_NEXTCONDITION = 7;
    private static final int INDEX_NEXTTO = 8;
    private static final int INDEX_ORDERFLAG = 9;
    private static final int INDEX_PAGEPATH = 10;
    private static final int INDEX_PANELID = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_WFIAACTIONID = 14;
    private static final int INDEX_WFIAACTIONNAME = 15;
    private static final int INDEX_WFSTEPID = 16;
    private static final int INDEX_WFSTEPNAME = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFIAActionBase proxyWFIAActionBase = null;
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
    private Integer objWfstepLock = new Integer(1);
    private WFStep wfstep = null;

    static {
        fieldIndexMap.put(FIELD_ACTIONCOUNT, 0);
        fieldIndexMap.put(FIELD_ACTIONLOGICNAME, 1);
        fieldIndexMap.put(FIELD_ACTIONNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_FAHELPER, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_NEXTCONDITION, 7);
        fieldIndexMap.put(FIELD_NEXTTO, 8);
        fieldIndexMap.put(FIELD_ORDERFLAG, 9);
        fieldIndexMap.put(FIELD_PAGEPATH, 10);
        fieldIndexMap.put(FIELD_PANELID, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_WFIAACTIONID, 14);
        fieldIndexMap.put(FIELD_WFIAACTIONNAME, 15);
        fieldIndexMap.put(FIELD_WFSTEPID, 16);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 17);
    }

    public void setActionCount(Integer actioncount) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionCount(actioncount);
            return;
        }
        this.actioncount = actioncount;
        this.actioncountDirtyFlag = true;
    }

    public Integer getActionCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionCount();
        }
        return this.actioncount;
    }

    public boolean isActionCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionCountDirty();
        }
        return this.actioncountDirtyFlag;
    }

    public void resetActionCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionCount();
            return;
        }
        this.actioncountDirtyFlag = false;
        this.actioncount = null;
    }

    public void setActionLogicName(String actionlogicname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionLogicName(actionlogicname);
            return;
        }
        if (actionlogicname != null && (actionlogicname = StringHelper.trimRight(actionlogicname)).length() == 0) {
            actionlogicname = null;
        }
        this.actionlogicname = actionlogicname;
        this.actionlogicnameDirtyFlag = true;
    }

    public String getActionLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionLogicName();
        }
        return this.actionlogicname;
    }

    public boolean isActionLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionLogicNameDirty();
        }
        return this.actionlogicnameDirtyFlag;
    }

    public void resetActionLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionLogicName();
            return;
        }
        this.actionlogicnameDirtyFlag = false;
        this.actionlogicname = null;
    }

    public void setActionName(String actionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionName(actionname);
            return;
        }
        if (actionname != null && (actionname = StringHelper.trimRight(actionname)).length() == 0) {
            actionname = null;
        }
        this.actionname = actionname;
        this.actionnameDirtyFlag = true;
    }

    public String getActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionName();
        }
        return this.actionname;
    }

    public boolean isActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionNameDirty();
        }
        return this.actionnameDirtyFlag;
    }

    public void resetActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionName();
            return;
        }
        this.actionnameDirtyFlag = false;
        this.actionname = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setFAHelper(String fahelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFAHelper(fahelper);
            return;
        }
        if (fahelper != null && (fahelper = StringHelper.trimRight(fahelper)).length() == 0) {
            fahelper = null;
        }
        this.fahelper = fahelper;
        this.fahelperDirtyFlag = true;
    }

    public String getFAHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFAHelper();
        }
        return this.fahelper;
    }

    public boolean isFAHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFAHelperDirty();
        }
        return this.fahelperDirtyFlag;
    }

    public void resetFAHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFAHelper();
            return;
        }
        this.fahelperDirtyFlag = false;
        this.fahelper = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setNextCondition(String nextcondition) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextCondition(nextcondition);
            return;
        }
        if (nextcondition != null && (nextcondition = StringHelper.trimRight(nextcondition)).length() == 0) {
            nextcondition = null;
        }
        this.nextcondition = nextcondition;
        this.nextconditionDirtyFlag = true;
    }

    public String getNextCondition() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextCondition();
        }
        return this.nextcondition;
    }

    public boolean isNextConditionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextConditionDirty();
        }
        return this.nextconditionDirtyFlag;
    }

    public void resetNextCondition() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextCondition();
            return;
        }
        this.nextconditionDirtyFlag = false;
        this.nextcondition = null;
    }

    public void setNextTo(String nextto) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextTo(nextto);
            return;
        }
        if (nextto != null && (nextto = StringHelper.trimRight(nextto)).length() == 0) {
            nextto = null;
        }
        this.nextto = nextto;
        this.nexttoDirtyFlag = true;
    }

    public String getNextTo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextTo();
        }
        return this.nextto;
    }

    public boolean isNextToDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextToDirty();
        }
        return this.nexttoDirtyFlag;
    }

    public void resetNextTo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextTo();
            return;
        }
        this.nexttoDirtyFlag = false;
        this.nextto = null;
    }

    public void setOrderFlag(Integer orderflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderFlag(orderflag);
            return;
        }
        this.orderflag = orderflag;
        this.orderflagDirtyFlag = true;
    }

    public Integer getOrderFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderFlag();
        }
        return this.orderflag;
    }

    public boolean isOrderFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderFlagDirty();
        }
        return this.orderflagDirtyFlag;
    }

    public void resetOrderFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderFlag();
            return;
        }
        this.orderflagDirtyFlag = false;
        this.orderflag = null;
    }

    public void setPagePath(String pagepath) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPagePath(pagepath);
            return;
        }
        if (pagepath != null && (pagepath = StringHelper.trimRight(pagepath)).length() == 0) {
            pagepath = null;
        }
        this.pagepath = pagepath;
        this.pagepathDirtyFlag = true;
    }

    public String getPagePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPagePath();
        }
        return this.pagepath;
    }

    public boolean isPagePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPagePathDirty();
        }
        return this.pagepathDirtyFlag;
    }

    public void resetPagePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPagePath();
            return;
        }
        this.pagepathDirtyFlag = false;
        this.pagepath = null;
    }

    public void setPanelId(String panelid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelId(panelid);
            return;
        }
        if (panelid != null && (panelid = StringHelper.trimRight(panelid)).length() == 0) {
            panelid = null;
        }
        this.panelid = panelid;
        this.panelidDirtyFlag = true;
    }

    public String getPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelId();
        }
        return this.panelid;
    }

    public boolean isPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelIdDirty();
        }
        return this.panelidDirtyFlag;
    }

    public void resetPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelId();
            return;
        }
        this.panelidDirtyFlag = false;
        this.panelid = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setWFIAActionId(String wfiaactionid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFIAActionId(wfiaactionid);
            return;
        }
        if (wfiaactionid != null && (wfiaactionid = StringHelper.trimRight(wfiaactionid)).length() == 0) {
            wfiaactionid = null;
        }
        this.wfiaactionid = wfiaactionid;
        this.wfiaactionidDirtyFlag = true;
    }

    public String getWFIAActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFIAActionId();
        }
        return this.wfiaactionid;
    }

    public boolean isWFIAActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFIAActionIdDirty();
        }
        return this.wfiaactionidDirtyFlag;
    }

    public void resetWFIAActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFIAActionId();
            return;
        }
        this.wfiaactionidDirtyFlag = false;
        this.wfiaactionid = null;
    }

    public void setWFIAActionName(String wfiaactionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFIAActionName(wfiaactionname);
            return;
        }
        if (wfiaactionname != null && (wfiaactionname = StringHelper.trimRight(wfiaactionname)).length() == 0) {
            wfiaactionname = null;
        }
        this.wfiaactionname = wfiaactionname;
        this.wfiaactionnameDirtyFlag = true;
    }

    public String getWFIAActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFIAActionName();
        }
        return this.wfiaactionname;
    }

    public boolean isWFIAActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFIAActionNameDirty();
        }
        return this.wfiaactionnameDirtyFlag;
    }

    public void resetWFIAActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFIAActionName();
            return;
        }
        this.wfiaactionnameDirtyFlag = false;
        this.wfiaactionname = null;
    }

    public void setWFStepId(String wfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if (wfstepid != null && (wfstepid = StringHelper.trimRight(wfstepid)).length() == 0) {
            wfstepid = null;
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag = true;
    }

    public String getWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    public boolean isWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    public void resetWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }
        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }

    public void setWFStepName(String wfstepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if (wfstepname != null && (wfstepname = StringHelper.trimRight(wfstepname)).length() == 0) {
            wfstepname = null;
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag = true;
    }

    public String getWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    public boolean isWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    public void resetWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }
        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    @Override
    protected void onReset() {
        WFIAActionBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActionCountDirty()) {
            params.put(FIELD_ACTIONCOUNT, this.getActionCount());
        }
        if (!bDirtyOnly || this.isActionLogicNameDirty()) {
            params.put(FIELD_ACTIONLOGICNAME, this.getActionLogicName());
        }
        if (!bDirtyOnly || this.isActionNameDirty()) {
            params.put(FIELD_ACTIONNAME, this.getActionName());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isFAHelperDirty()) {
            params.put(FIELD_FAHELPER, this.getFAHelper());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isNextConditionDirty()) {
            params.put(FIELD_NEXTCONDITION, this.getNextCondition());
        }
        if (!bDirtyOnly || this.isNextToDirty()) {
            params.put(FIELD_NEXTTO, this.getNextTo());
        }
        if (!bDirtyOnly || this.isOrderFlagDirty()) {
            params.put(FIELD_ORDERFLAG, this.getOrderFlag());
        }
        if (!bDirtyOnly || this.isPagePathDirty()) {
            params.put(FIELD_PAGEPATH, this.getPagePath());
        }
        if (!bDirtyOnly || this.isPanelIdDirty()) {
            params.put(FIELD_PANELID, this.getPanelId());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFIAActionIdDirty()) {
            params.put(FIELD_WFIAACTIONID, this.getWFIAActionId());
        }
        if (!bDirtyOnly || this.isWFIAActionNameDirty()) {
            params.put(FIELD_WFIAACTIONNAME, this.getWFIAActionName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
        }
        if (!bDirtyOnly || this.isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME, this.getWFStepName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFIAActionBase.get(this, index);
    }

    private static Object get(WFIAActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionCount();
            }
            case 1: {
                return et.getActionLogicName();
            }
            case 2: {
                return et.getActionName();
            }
            case 3: {
                return et.getCreateDate();
            }
            case 4: {
                return et.getCreateMan();
            }
            case 5: {
                return et.getFAHelper();
            }
            case 6: {
                return et.getMemo();
            }
            case 7: {
                return et.getNextCondition();
            }
            case 8: {
                return et.getNextTo();
            }
            case 9: {
                return et.getOrderFlag();
            }
            case 10: {
                return et.getPagePath();
            }
            case 11: {
                return et.getPanelId();
            }
            case 12: {
                return et.getUpdateDate();
            }
            case 13: {
                return et.getUpdateMan();
            }
            case 14: {
                return et.getWFIAActionId();
            }
            case 15: {
                return et.getWFIAActionName();
            }
            case 16: {
                return et.getWFStepId();
            }
            case 17: {
                return et.getWFStepName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFIAActionBase.set(this, index, objValue);
    }

    private static void set(WFIAActionBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActionCount(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setActionLogicName(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setActionName(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setFAHelper(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setNextCondition(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setNextTo(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setOrderFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setPagePath(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setPanelId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWFIAActionId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setWFIAActionName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWFStepName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFIAActionBase.isNull(this, index);
    }

    private static boolean isNull(WFIAActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionCount() == null;
            }
            case 1: {
                return et.getActionLogicName() == null;
            }
            case 2: {
                return et.getActionName() == null;
            }
            case 3: {
                return et.getCreateDate() == null;
            }
            case 4: {
                return et.getCreateMan() == null;
            }
            case 5: {
                return et.getFAHelper() == null;
            }
            case 6: {
                return et.getMemo() == null;
            }
            case 7: {
                return et.getNextCondition() == null;
            }
            case 8: {
                return et.getNextTo() == null;
            }
            case 9: {
                return et.getOrderFlag() == null;
            }
            case 10: {
                return et.getPagePath() == null;
            }
            case 11: {
                return et.getPanelId() == null;
            }
            case 12: {
                return et.getUpdateDate() == null;
            }
            case 13: {
                return et.getUpdateMan() == null;
            }
            case 14: {
                return et.getWFIAActionId() == null;
            }
            case 15: {
                return et.getWFIAActionName() == null;
            }
            case 16: {
                return et.getWFStepId() == null;
            }
            case 17: {
                return et.getWFStepName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFIAActionBase.contains(this, index);
    }

    private static boolean contains(WFIAActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActionCountDirty();
            }
            case 1: {
                return et.isActionLogicNameDirty();
            }
            case 2: {
                return et.isActionNameDirty();
            }
            case 3: {
                return et.isCreateDateDirty();
            }
            case 4: {
                return et.isCreateManDirty();
            }
            case 5: {
                return et.isFAHelperDirty();
            }
            case 6: {
                return et.isMemoDirty();
            }
            case 7: {
                return et.isNextConditionDirty();
            }
            case 8: {
                return et.isNextToDirty();
            }
            case 9: {
                return et.isOrderFlagDirty();
            }
            case 10: {
                return et.isPagePathDirty();
            }
            case 11: {
                return et.isPanelIdDirty();
            }
            case 12: {
                return et.isUpdateDateDirty();
            }
            case 13: {
                return et.isUpdateManDirty();
            }
            case 14: {
                return et.isWFIAActionIdDirty();
            }
            case 15: {
                return et.isWFIAActionNameDirty();
            }
            case 16: {
                return et.isWFStepIdDirty();
            }
            case 17: {
                return et.isWFStepNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFIAActionBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFIAActionBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActionCount() != null) {
            JSONObjectHelper.put(json, "actioncount", WFIAActionBase.getJSONValue(et.getActionCount()), false);
        }
        if (bIncEmpty || et.getActionLogicName() != null) {
            JSONObjectHelper.put(json, "actionlogicname", WFIAActionBase.getJSONValue(et.getActionLogicName()), false);
        }
        if (bIncEmpty || et.getActionName() != null) {
            JSONObjectHelper.put(json, "actionname", WFIAActionBase.getJSONValue(et.getActionName()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFIAActionBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFIAActionBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getFAHelper() != null) {
            JSONObjectHelper.put(json, "fahelper", WFIAActionBase.getJSONValue(et.getFAHelper()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFIAActionBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getNextCondition() != null) {
            JSONObjectHelper.put(json, "nextcondition", WFIAActionBase.getJSONValue(et.getNextCondition()), false);
        }
        if (bIncEmpty || et.getNextTo() != null) {
            JSONObjectHelper.put(json, "nextto", WFIAActionBase.getJSONValue(et.getNextTo()), false);
        }
        if (bIncEmpty || et.getOrderFlag() != null) {
            JSONObjectHelper.put(json, "orderflag", WFIAActionBase.getJSONValue(et.getOrderFlag()), false);
        }
        if (bIncEmpty || et.getPagePath() != null) {
            JSONObjectHelper.put(json, "pagepath", WFIAActionBase.getJSONValue(et.getPagePath()), false);
        }
        if (bIncEmpty || et.getPanelId() != null) {
            JSONObjectHelper.put(json, "panelid", WFIAActionBase.getJSONValue(et.getPanelId()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFIAActionBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFIAActionBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFIAActionId() != null) {
            JSONObjectHelper.put(json, "wfiaactionid", WFIAActionBase.getJSONValue(et.getWFIAActionId()), false);
        }
        if (bIncEmpty || et.getWFIAActionName() != null) {
            JSONObjectHelper.put(json, "wfiaactionname", WFIAActionBase.getJSONValue(et.getWFIAActionName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFIAActionBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFIAActionBase.getJSONValue(et.getWFStepName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFIAActionBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFIAActionBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActionCount() != null) {
            obj = et.getActionCount();
            node.setAttribute(FIELD_ACTIONCOUNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getActionLogicName() != null) {
            obj = et.getActionLogicName();
            node.setAttribute(FIELD_ACTIONLOGICNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getActionName() != null) {
            obj = et.getActionName();
            node.setAttribute(FIELD_ACTIONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFAHelper() != null) {
            obj = et.getFAHelper();
            node.setAttribute(FIELD_FAHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNextCondition() != null) {
            obj = et.getNextCondition();
            node.setAttribute(FIELD_NEXTCONDITION, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNextTo() != null) {
            obj = et.getNextTo();
            node.setAttribute(FIELD_NEXTTO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrderFlag() != null) {
            obj = et.getOrderFlag();
            node.setAttribute(FIELD_ORDERFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPagePath() != null) {
            obj = et.getPagePath();
            node.setAttribute(FIELD_PAGEPATH, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPanelId() != null) {
            obj = et.getPanelId();
            node.setAttribute(FIELD_PANELID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFIAActionId() != null) {
            obj = et.getWFIAActionId();
            node.setAttribute(FIELD_WFIAACTIONID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFIAActionName() != null) {
            obj = et.getWFIAActionName();
            node.setAttribute(FIELD_WFIAACTIONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            obj = et.getWFStepId();
            node.setAttribute(FIELD_WFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            obj = et.getWFStepName();
            node.setAttribute(FIELD_WFSTEPNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFIAActionBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFIAActionBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActionCountDirty() && (bIncEmpty || et.getActionCount() != null)) {
            dst.set(FIELD_ACTIONCOUNT, et.getActionCount());
        }
        if (et.isActionLogicNameDirty() && (bIncEmpty || et.getActionLogicName() != null)) {
            dst.set(FIELD_ACTIONLOGICNAME, et.getActionLogicName());
        }
        if (et.isActionNameDirty() && (bIncEmpty || et.getActionName() != null)) {
            dst.set(FIELD_ACTIONNAME, et.getActionName());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isFAHelperDirty() && (bIncEmpty || et.getFAHelper() != null)) {
            dst.set(FIELD_FAHELPER, et.getFAHelper());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isNextConditionDirty() && (bIncEmpty || et.getNextCondition() != null)) {
            dst.set(FIELD_NEXTCONDITION, et.getNextCondition());
        }
        if (et.isNextToDirty() && (bIncEmpty || et.getNextTo() != null)) {
            dst.set(FIELD_NEXTTO, et.getNextTo());
        }
        if (et.isOrderFlagDirty() && (bIncEmpty || et.getOrderFlag() != null)) {
            dst.set(FIELD_ORDERFLAG, et.getOrderFlag());
        }
        if (et.isPagePathDirty() && (bIncEmpty || et.getPagePath() != null)) {
            dst.set(FIELD_PAGEPATH, et.getPagePath());
        }
        if (et.isPanelIdDirty() && (bIncEmpty || et.getPanelId() != null)) {
            dst.set(FIELD_PANELID, et.getPanelId());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFIAActionIdDirty() && (bIncEmpty || et.getWFIAActionId() != null)) {
            dst.set(FIELD_WFIAACTIONID, et.getWFIAActionId());
        }
        if (et.isWFIAActionNameDirty() && (bIncEmpty || et.getWFIAActionName() != null)) {
            dst.set(FIELD_WFIAACTIONNAME, et.getWFIAActionName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
        }
        if (et.isWFStepNameDirty() && (bIncEmpty || et.getWFStepName() != null)) {
            dst.set(FIELD_WFSTEPNAME, et.getWFStepName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFIAActionBase.remove(this, index);
    }

    private static boolean remove(WFIAActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActionCount();
                return true;
            }
            case 1: {
                et.resetActionLogicName();
                return true;
            }
            case 2: {
                et.resetActionName();
                return true;
            }
            case 3: {
                et.resetCreateDate();
                return true;
            }
            case 4: {
                et.resetCreateMan();
                return true;
            }
            case 5: {
                et.resetFAHelper();
                return true;
            }
            case 6: {
                et.resetMemo();
                return true;
            }
            case 7: {
                et.resetNextCondition();
                return true;
            }
            case 8: {
                et.resetNextTo();
                return true;
            }
            case 9: {
                et.resetOrderFlag();
                return true;
            }
            case 10: {
                et.resetPagePath();
                return true;
            }
            case 11: {
                et.resetPanelId();
                return true;
            }
            case 12: {
                et.resetUpdateDate();
                return true;
            }
            case 13: {
                et.resetUpdateMan();
                return true;
            }
            case 14: {
                et.resetWFIAActionId();
                return true;
            }
            case 15: {
                et.resetWFIAActionName();
                return true;
            }
            case 16: {
                et.resetWFStepId();
                return true;
            }
            case 17: {
                et.resetWFStepName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStep getWfstep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWfstep();
        }
        if (this.getWFStepId() == null) {
            return null;
        }
        Integer n = this.objWfstepLock;
        synchronized (n) {
            if (this.wfstep != null && DataTypeHelper.compare(25, (Object)this.getWFStepId(), (Object)this.wfstep.getWFStepId()) != 0L) {
                this.wfstep = null;
            }
            if (this.wfstep == null) {
                WFStep wfstep = new WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    private WFIAActionBase getProxyEntity() {
        return this.proxyWFIAActionBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFIAActionBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFIAActionBase) {
            this.proxyWFIAActionBase = (WFIAActionBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFIAActionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

