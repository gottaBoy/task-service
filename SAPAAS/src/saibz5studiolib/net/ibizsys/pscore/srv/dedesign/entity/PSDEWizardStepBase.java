/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardStepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEWizardStepBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String FIELD_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEXTPSDEACTIONID = "NEXTPSDEACTIONID";
    public static final String FIELD_NEXTPSDEACTIONNAME = "NEXTPSDEACTIONNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSDEWIZARDSTEPID = "PSDEWIZARDSTEPID";
    public static final String FIELD_PSDEWIZARDSTEPNAME = "PSDEWIZARDSTEPNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_STEPACTION = "STEPACTION";
    public static final String FIELD_STEPTAG = "STEPTAG";
    public static final String FIELD_SUBTITLE = "SUBTITLE";
    public static final String FIELD_SUBTITLEPSLANRESID = "SUBTITLEPSLANRESID";
    public static final String FIELD_SUBTITLEPSLANRESNAME = "SUBTITLEPSLANRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLELINK = 2;
    private static final int INDEX_ENABLELOGIC = 3;
    private static final int INDEX_INITPSDEACTIONID = 4;
    private static final int INDEX_INITPSDEACTIONNAME = 5;
    private static final int INDEX_LNPSLANRESID = 6;
    private static final int INDEX_LNPSLANRESNAME = 7;
    private static final int INDEX_LOGICNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_NEXTPSDEACTIONID = 10;
    private static final int INDEX_NEXTPSDEACTIONNAME = 11;
    private static final int INDEX_ORDERVALUE = 12;
    private static final int INDEX_PSDEFORMID = 13;
    private static final int INDEX_PSDEFORMNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_PSDEWIZARDID = 16;
    private static final int INDEX_PSDEWIZARDNAME = 17;
    private static final int INDEX_PSDEWIZARDSTEPID = 18;
    private static final int INDEX_PSDEWIZARDSTEPNAME = 19;
    private static final int INDEX_PSSYSCSSID = 20;
    private static final int INDEX_PSSYSCSSNAME = 21;
    private static final int INDEX_PSSYSIMAGEID = 22;
    private static final int INDEX_PSSYSIMAGENAME = 23;
    private static final int INDEX_STEPACTION = 24;
    private static final int INDEX_STEPTAG = 25;
    private static final int INDEX_SUBTITLE = 26;
    private static final int INDEX_SUBTITLEPSLANRESID = 27;
    private static final int INDEX_SUBTITLEPSLANRESNAME = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final int INDEX_VISIBLELOGIC = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEWizardStepBase proxyPSDEWizardStepBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean initpsdeactionidDirtyFlag = false;
    private boolean initpsdeactionnameDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nextpsdeactionidDirtyFlag = false;
    private boolean nextpsdeactionnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean psdewizardstepidDirtyFlag = false;
    private boolean psdewizardstepnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean stepactionDirtyFlag = false;
    private boolean steptagDirtyFlag = false;
    private boolean subtitleDirtyFlag = false;
    private boolean subtitlepslanresidDirtyFlag = false;
    private boolean subtitlepslanresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablelink")
    private Integer enablelink;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="initpsdeactionid")
    private String initpsdeactionid;
    @Column(name="initpsdeactionname")
    private String initpsdeactionname;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="nextpsdeactionid")
    private String nextpsdeactionid;
    @Column(name="nextpsdeactionname")
    private String nextpsdeactionname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="psdewizardstepid")
    private String psdewizardstepid;
    @Column(name="psdewizardstepname")
    private String psdewizardstepname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="stepaction")
    private String stepaction;
    @Column(name="steptag")
    private String steptag;
    @Column(name="subtitle")
    private String subtitle;
    @Column(name="subtitlepslanresid")
    private String subtitlepslanresid;
    @Column(name="subtitlepslanresname")
    private String subtitlepslanresname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="visiblelogic")
    private String visiblelogic;
    private Integer objInitPSDEActionLock = new Integer(1);
    private PSDEAction initpsdeaction = null;
    private Integer objNextPSDEActionLock = new Integer(1);
    private PSDEAction nextpsdeaction = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEWizardLock = new Integer(1);
    private PSDEWizard psdewizard = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objSubTitlePSLanResLock = new Integer(1);
    private PSLanguageRes subtitlepslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
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

    public void setEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLink(n);
            return;
        }
        this.enablelink = n;
        this.enablelinkDirtyFlag = true;
    }

    public Integer getEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLink();
        }
        return this.enablelink;
    }

    public boolean isEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLinkDirty();
        }
        return this.enablelinkDirtyFlag;
    }

    public void resetEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLink();
            return;
        }
        this.enablelinkDirtyFlag = false;
        this.enablelink = null;
    }

    public void setEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablelogic = string;
        this.enablelogicDirtyFlag = true;
    }

    public String getEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLogic();
        }
        return this.enablelogic;
    }

    public boolean isEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogicDirty();
        }
        return this.enablelogicDirtyFlag;
    }

    public void resetEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLogic();
            return;
        }
        this.enablelogicDirtyFlag = false;
        this.enablelogic = null;
    }

    public void setInitPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionid = string;
        this.initpsdeactionidDirtyFlag = true;
    }

    public String getInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionId();
        }
        return this.initpsdeactionid;
    }

    public boolean isInitPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionIdDirty();
        }
        return this.initpsdeactionidDirtyFlag;
    }

    public void resetInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionId();
            return;
        }
        this.initpsdeactionidDirtyFlag = false;
        this.initpsdeactionid = null;
    }

    public void setInitPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionname = string;
        this.initpsdeactionnameDirtyFlag = true;
    }

    public String getInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionName();
        }
        return this.initpsdeactionname;
    }

    public boolean isInitPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionNameDirty();
        }
        return this.initpsdeactionnameDirtyFlag;
    }

    public void resetInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionName();
            return;
        }
        this.initpsdeactionnameDirtyFlag = false;
        this.initpsdeactionname = null;
    }

    public void setLNPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresid = string;
        this.lnpslanresidDirtyFlag = true;
    }

    public String getLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResId();
        }
        return this.lnpslanresid;
    }

    public boolean isLNPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResIdDirty();
        }
        return this.lnpslanresidDirtyFlag;
    }

    public void resetLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResId();
            return;
        }
        this.lnpslanresidDirtyFlag = false;
        this.lnpslanresid = null;
    }

    public void setLNPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresname = string;
        this.lnpslanresnameDirtyFlag = true;
    }

    public String getLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResName();
        }
        return this.lnpslanresname;
    }

    public boolean isLNPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResNameDirty();
        }
        return this.lnpslanresnameDirtyFlag;
    }

    public void resetLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResName();
            return;
        }
        this.lnpslanresnameDirtyFlag = false;
        this.lnpslanresname = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setNextPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdeactionid = string;
        this.nextpsdeactionidDirtyFlag = true;
    }

    public String getNextPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEActionId();
        }
        return this.nextpsdeactionid;
    }

    public boolean isNextPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEActionIdDirty();
        }
        return this.nextpsdeactionidDirtyFlag;
    }

    public void resetNextPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEActionId();
            return;
        }
        this.nextpsdeactionidDirtyFlag = false;
        this.nextpsdeactionid = null;
    }

    public void setNextPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdeactionname = string;
        this.nextpsdeactionnameDirtyFlag = true;
    }

    public String getNextPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEActionName();
        }
        return this.nextpsdeactionname;
    }

    public boolean isNextPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEActionNameDirty();
        }
        return this.nextpsdeactionnameDirtyFlag;
    }

    public void resetNextPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEActionName();
            return;
        }
        this.nextpsdeactionnameDirtyFlag = false;
        this.nextpsdeactionname = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardid = string;
        this.psdewizardidDirtyFlag = true;
    }

    public String getPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardId();
        }
        return this.psdewizardid;
    }

    public boolean isPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardIdDirty();
        }
        return this.psdewizardidDirtyFlag;
    }

    public void resetPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardId();
            return;
        }
        this.psdewizardidDirtyFlag = false;
        this.psdewizardid = null;
    }

    public void setPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardname = string;
        this.psdewizardnameDirtyFlag = true;
    }

    public String getPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardName();
        }
        return this.psdewizardname;
    }

    public boolean isPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardNameDirty();
        }
        return this.psdewizardnameDirtyFlag;
    }

    public void resetPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardName();
            return;
        }
        this.psdewizardnameDirtyFlag = false;
        this.psdewizardname = null;
    }

    public void setPSDEWizardStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepid = string;
        this.psdewizardstepidDirtyFlag = true;
    }

    public String getPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepId();
        }
        return this.psdewizardstepid;
    }

    public boolean isPSDEWizardStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepIdDirty();
        }
        return this.psdewizardstepidDirtyFlag;
    }

    public void resetPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepId();
            return;
        }
        this.psdewizardstepidDirtyFlag = false;
        this.psdewizardstepid = null;
    }

    public void setPSDEWizardStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepname = string;
        this.psdewizardstepnameDirtyFlag = true;
    }

    public String getPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepName();
        }
        return this.psdewizardstepname;
    }

    public boolean isPSDEWizardStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepNameDirty();
        }
        return this.psdewizardstepnameDirtyFlag;
    }

    public void resetPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepName();
            return;
        }
        this.psdewizardstepnameDirtyFlag = false;
        this.psdewizardstepname = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setStepAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stepaction = string;
        this.stepactionDirtyFlag = true;
    }

    public String getStepAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepAction();
        }
        return this.stepaction;
    }

    public boolean isStepActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepActionDirty();
        }
        return this.stepactionDirtyFlag;
    }

    public void resetStepAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepAction();
            return;
        }
        this.stepactionDirtyFlag = false;
        this.stepaction = null;
    }

    public void setStepTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steptag = string;
        this.steptagDirtyFlag = true;
    }

    public String getStepTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepTag();
        }
        return this.steptag;
    }

    public boolean isStepTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepTagDirty();
        }
        return this.steptagDirtyFlag;
    }

    public void resetStepTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepTag();
            return;
        }
        this.steptagDirtyFlag = false;
        this.steptag = null;
    }

    public void setSubTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitle = string;
        this.subtitleDirtyFlag = true;
    }

    public String getSubTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitle();
        }
        return this.subtitle;
    }

    public boolean isSubTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitleDirty();
        }
        return this.subtitleDirtyFlag;
    }

    public void resetSubTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitle();
            return;
        }
        this.subtitleDirtyFlag = false;
        this.subtitle = null;
    }

    public void setSubTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitlepslanresid = string;
        this.subtitlepslanresidDirtyFlag = true;
    }

    public String getSubTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanResId();
        }
        return this.subtitlepslanresid;
    }

    public boolean isSubTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitlePSLanResIdDirty();
        }
        return this.subtitlepslanresidDirtyFlag;
    }

    public void resetSubTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitlePSLanResId();
            return;
        }
        this.subtitlepslanresidDirtyFlag = false;
        this.subtitlepslanresid = null;
    }

    public void setSubTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitlepslanresname = string;
        this.subtitlepslanresnameDirtyFlag = true;
    }

    public String getSubTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanResName();
        }
        return this.subtitlepslanresname;
    }

    public boolean isSubTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitlePSLanResNameDirty();
        }
        return this.subtitlepslanresnameDirtyFlag;
    }

    public void resetSubTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitlePSLanResName();
            return;
        }
        this.subtitlepslanresnameDirtyFlag = false;
        this.subtitlepslanresname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setVisibleLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVisibleLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.visiblelogic = string;
        this.visiblelogicDirtyFlag = true;
    }

    public String getVisibleLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVisibleLogic();
        }
        return this.visiblelogic;
    }

    public boolean isVisibleLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVisibleLogicDirty();
        }
        return this.visiblelogicDirtyFlag;
    }

    public void resetVisibleLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVisibleLogic();
            return;
        }
        this.visiblelogicDirtyFlag = false;
        this.visiblelogic = null;
    }

    protected void onReset() {
        PSDEWizardStepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEWizardStepBase pSDEWizardStepBase) {
        pSDEWizardStepBase.resetCreateDate();
        pSDEWizardStepBase.resetCreateMan();
        pSDEWizardStepBase.resetEnableLink();
        pSDEWizardStepBase.resetEnableLogic();
        pSDEWizardStepBase.resetInitPSDEActionId();
        pSDEWizardStepBase.resetInitPSDEActionName();
        pSDEWizardStepBase.resetLNPSLanResId();
        pSDEWizardStepBase.resetLNPSLanResName();
        pSDEWizardStepBase.resetLogicName();
        pSDEWizardStepBase.resetMemo();
        pSDEWizardStepBase.resetNextPSDEActionId();
        pSDEWizardStepBase.resetNextPSDEActionName();
        pSDEWizardStepBase.resetOrderValue();
        pSDEWizardStepBase.resetPSDEFormId();
        pSDEWizardStepBase.resetPSDEFormName();
        pSDEWizardStepBase.resetPSDEId();
        pSDEWizardStepBase.resetPSDEWizardId();
        pSDEWizardStepBase.resetPSDEWizardName();
        pSDEWizardStepBase.resetPSDEWizardStepId();
        pSDEWizardStepBase.resetPSDEWizardStepName();
        pSDEWizardStepBase.resetPSSysCssId();
        pSDEWizardStepBase.resetPSSysCssName();
        pSDEWizardStepBase.resetPSSysImageId();
        pSDEWizardStepBase.resetPSSysImageName();
        pSDEWizardStepBase.resetStepAction();
        pSDEWizardStepBase.resetStepTag();
        pSDEWizardStepBase.resetSubTitle();
        pSDEWizardStepBase.resetSubTitlePSLanResId();
        pSDEWizardStepBase.resetSubTitlePSLanResName();
        pSDEWizardStepBase.resetUpdateDate();
        pSDEWizardStepBase.resetUpdateMan();
        pSDEWizardStepBase.resetUserCat();
        pSDEWizardStepBase.resetUserTag();
        pSDEWizardStepBase.resetUserTag2();
        pSDEWizardStepBase.resetUserTag3();
        pSDEWizardStepBase.resetUserTag4();
        pSDEWizardStepBase.resetVisibleLogic();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableLinkDirty()) {
            hashMap.put(FIELD_ENABLELINK, this.getEnableLink());
        }
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isInitPSDEActionIdDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONID, this.getInitPSDEActionId());
        }
        if (!bl || this.isInitPSDEActionNameDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONNAME, this.getInitPSDEActionName());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNextPSDEActionIdDirty()) {
            hashMap.put(FIELD_NEXTPSDEACTIONID, this.getNextPSDEActionId());
        }
        if (!bl || this.isNextPSDEActionNameDirty()) {
            hashMap.put(FIELD_NEXTPSDEACTIONNAME, this.getNextPSDEActionName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSDEWizardStepIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPID, this.getPSDEWizardStepId());
        }
        if (!bl || this.isPSDEWizardStepNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPNAME, this.getPSDEWizardStepName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isStepActionDirty()) {
            hashMap.put(FIELD_STEPACTION, this.getStepAction());
        }
        if (!bl || this.isStepTagDirty()) {
            hashMap.put(FIELD_STEPTAG, this.getStepTag());
        }
        if (!bl || this.isSubTitleDirty()) {
            hashMap.put(FIELD_SUBTITLE, this.getSubTitle());
        }
        if (!bl || this.isSubTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_SUBTITLEPSLANRESID, this.getSubTitlePSLanResId());
        }
        if (!bl || this.isSubTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_SUBTITLEPSLANRESNAME, this.getSubTitlePSLanResName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isVisibleLogicDirty()) {
            hashMap.put(FIELD_VISIBLELOGIC, this.getVisibleLogic());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDEWizardStepBase.get(this, n);
    }

    private static Object get(PSDEWizardStepBase pSDEWizardStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardStepBase.getCreateDate();
            }
            case 1: {
                return pSDEWizardStepBase.getCreateMan();
            }
            case 2: {
                return pSDEWizardStepBase.getEnableLink();
            }
            case 3: {
                return pSDEWizardStepBase.getEnableLogic();
            }
            case 4: {
                return pSDEWizardStepBase.getInitPSDEActionId();
            }
            case 5: {
                return pSDEWizardStepBase.getInitPSDEActionName();
            }
            case 6: {
                return pSDEWizardStepBase.getLNPSLanResId();
            }
            case 7: {
                return pSDEWizardStepBase.getLNPSLanResName();
            }
            case 8: {
                return pSDEWizardStepBase.getLogicName();
            }
            case 9: {
                return pSDEWizardStepBase.getMemo();
            }
            case 10: {
                return pSDEWizardStepBase.getNextPSDEActionId();
            }
            case 11: {
                return pSDEWizardStepBase.getNextPSDEActionName();
            }
            case 12: {
                return pSDEWizardStepBase.getOrderValue();
            }
            case 13: {
                return pSDEWizardStepBase.getPSDEFormId();
            }
            case 14: {
                return pSDEWizardStepBase.getPSDEFormName();
            }
            case 15: {
                return pSDEWizardStepBase.getPSDEId();
            }
            case 16: {
                return pSDEWizardStepBase.getPSDEWizardId();
            }
            case 17: {
                return pSDEWizardStepBase.getPSDEWizardName();
            }
            case 18: {
                return pSDEWizardStepBase.getPSDEWizardStepId();
            }
            case 19: {
                return pSDEWizardStepBase.getPSDEWizardStepName();
            }
            case 20: {
                return pSDEWizardStepBase.getPSSysCssId();
            }
            case 21: {
                return pSDEWizardStepBase.getPSSysCssName();
            }
            case 22: {
                return pSDEWizardStepBase.getPSSysImageId();
            }
            case 23: {
                return pSDEWizardStepBase.getPSSysImageName();
            }
            case 24: {
                return pSDEWizardStepBase.getStepAction();
            }
            case 25: {
                return pSDEWizardStepBase.getStepTag();
            }
            case 26: {
                return pSDEWizardStepBase.getSubTitle();
            }
            case 27: {
                return pSDEWizardStepBase.getSubTitlePSLanResId();
            }
            case 28: {
                return pSDEWizardStepBase.getSubTitlePSLanResName();
            }
            case 29: {
                return pSDEWizardStepBase.getUpdateDate();
            }
            case 30: {
                return pSDEWizardStepBase.getUpdateMan();
            }
            case 31: {
                return pSDEWizardStepBase.getUserCat();
            }
            case 32: {
                return pSDEWizardStepBase.getUserTag();
            }
            case 33: {
                return pSDEWizardStepBase.getUserTag2();
            }
            case 34: {
                return pSDEWizardStepBase.getUserTag3();
            }
            case 35: {
                return pSDEWizardStepBase.getUserTag4();
            }
            case 36: {
                return pSDEWizardStepBase.getVisibleLogic();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDEWizardStepBase.set(this, n, object);
    }

    private static void set(PSDEWizardStepBase pSDEWizardStepBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardStepBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEWizardStepBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEWizardStepBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEWizardStepBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEWizardStepBase.setInitPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEWizardStepBase.setInitPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEWizardStepBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEWizardStepBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEWizardStepBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEWizardStepBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEWizardStepBase.setNextPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEWizardStepBase.setNextPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEWizardStepBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEWizardStepBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEWizardStepBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEWizardStepBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEWizardStepBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEWizardStepBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEWizardStepBase.setPSDEWizardStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEWizardStepBase.setPSDEWizardStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEWizardStepBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEWizardStepBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEWizardStepBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEWizardStepBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEWizardStepBase.setStepAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEWizardStepBase.setStepTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEWizardStepBase.setSubTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEWizardStepBase.setSubTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEWizardStepBase.setSubTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEWizardStepBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDEWizardStepBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEWizardStepBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEWizardStepBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEWizardStepBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEWizardStepBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEWizardStepBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEWizardStepBase.setVisibleLogic(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDEWizardStepBase.isNull(this, n);
    }

    private static boolean isNull(PSDEWizardStepBase pSDEWizardStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardStepBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEWizardStepBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEWizardStepBase.getEnableLink() == null;
            }
            case 3: {
                return pSDEWizardStepBase.getEnableLogic() == null;
            }
            case 4: {
                return pSDEWizardStepBase.getInitPSDEActionId() == null;
            }
            case 5: {
                return pSDEWizardStepBase.getInitPSDEActionName() == null;
            }
            case 6: {
                return pSDEWizardStepBase.getLNPSLanResId() == null;
            }
            case 7: {
                return pSDEWizardStepBase.getLNPSLanResName() == null;
            }
            case 8: {
                return pSDEWizardStepBase.getLogicName() == null;
            }
            case 9: {
                return pSDEWizardStepBase.getMemo() == null;
            }
            case 10: {
                return pSDEWizardStepBase.getNextPSDEActionId() == null;
            }
            case 11: {
                return pSDEWizardStepBase.getNextPSDEActionName() == null;
            }
            case 12: {
                return pSDEWizardStepBase.getOrderValue() == null;
            }
            case 13: {
                return pSDEWizardStepBase.getPSDEFormId() == null;
            }
            case 14: {
                return pSDEWizardStepBase.getPSDEFormName() == null;
            }
            case 15: {
                return pSDEWizardStepBase.getPSDEId() == null;
            }
            case 16: {
                return pSDEWizardStepBase.getPSDEWizardId() == null;
            }
            case 17: {
                return pSDEWizardStepBase.getPSDEWizardName() == null;
            }
            case 18: {
                return pSDEWizardStepBase.getPSDEWizardStepId() == null;
            }
            case 19: {
                return pSDEWizardStepBase.getPSDEWizardStepName() == null;
            }
            case 20: {
                return pSDEWizardStepBase.getPSSysCssId() == null;
            }
            case 21: {
                return pSDEWizardStepBase.getPSSysCssName() == null;
            }
            case 22: {
                return pSDEWizardStepBase.getPSSysImageId() == null;
            }
            case 23: {
                return pSDEWizardStepBase.getPSSysImageName() == null;
            }
            case 24: {
                return pSDEWizardStepBase.getStepAction() == null;
            }
            case 25: {
                return pSDEWizardStepBase.getStepTag() == null;
            }
            case 26: {
                return pSDEWizardStepBase.getSubTitle() == null;
            }
            case 27: {
                return pSDEWizardStepBase.getSubTitlePSLanResId() == null;
            }
            case 28: {
                return pSDEWizardStepBase.getSubTitlePSLanResName() == null;
            }
            case 29: {
                return pSDEWizardStepBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDEWizardStepBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDEWizardStepBase.getUserCat() == null;
            }
            case 32: {
                return pSDEWizardStepBase.getUserTag() == null;
            }
            case 33: {
                return pSDEWizardStepBase.getUserTag2() == null;
            }
            case 34: {
                return pSDEWizardStepBase.getUserTag3() == null;
            }
            case 35: {
                return pSDEWizardStepBase.getUserTag4() == null;
            }
            case 36: {
                return pSDEWizardStepBase.getVisibleLogic() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDEWizardStepBase.contains(this, n);
    }

    private static boolean contains(PSDEWizardStepBase pSDEWizardStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardStepBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEWizardStepBase.isCreateManDirty();
            }
            case 2: {
                return pSDEWizardStepBase.isEnableLinkDirty();
            }
            case 3: {
                return pSDEWizardStepBase.isEnableLogicDirty();
            }
            case 4: {
                return pSDEWizardStepBase.isInitPSDEActionIdDirty();
            }
            case 5: {
                return pSDEWizardStepBase.isInitPSDEActionNameDirty();
            }
            case 6: {
                return pSDEWizardStepBase.isLNPSLanResIdDirty();
            }
            case 7: {
                return pSDEWizardStepBase.isLNPSLanResNameDirty();
            }
            case 8: {
                return pSDEWizardStepBase.isLogicNameDirty();
            }
            case 9: {
                return pSDEWizardStepBase.isMemoDirty();
            }
            case 10: {
                return pSDEWizardStepBase.isNextPSDEActionIdDirty();
            }
            case 11: {
                return pSDEWizardStepBase.isNextPSDEActionNameDirty();
            }
            case 12: {
                return pSDEWizardStepBase.isOrderValueDirty();
            }
            case 13: {
                return pSDEWizardStepBase.isPSDEFormIdDirty();
            }
            case 14: {
                return pSDEWizardStepBase.isPSDEFormNameDirty();
            }
            case 15: {
                return pSDEWizardStepBase.isPSDEIdDirty();
            }
            case 16: {
                return pSDEWizardStepBase.isPSDEWizardIdDirty();
            }
            case 17: {
                return pSDEWizardStepBase.isPSDEWizardNameDirty();
            }
            case 18: {
                return pSDEWizardStepBase.isPSDEWizardStepIdDirty();
            }
            case 19: {
                return pSDEWizardStepBase.isPSDEWizardStepNameDirty();
            }
            case 20: {
                return pSDEWizardStepBase.isPSSysCssIdDirty();
            }
            case 21: {
                return pSDEWizardStepBase.isPSSysCssNameDirty();
            }
            case 22: {
                return pSDEWizardStepBase.isPSSysImageIdDirty();
            }
            case 23: {
                return pSDEWizardStepBase.isPSSysImageNameDirty();
            }
            case 24: {
                return pSDEWizardStepBase.isStepActionDirty();
            }
            case 25: {
                return pSDEWizardStepBase.isStepTagDirty();
            }
            case 26: {
                return pSDEWizardStepBase.isSubTitleDirty();
            }
            case 27: {
                return pSDEWizardStepBase.isSubTitlePSLanResIdDirty();
            }
            case 28: {
                return pSDEWizardStepBase.isSubTitlePSLanResNameDirty();
            }
            case 29: {
                return pSDEWizardStepBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDEWizardStepBase.isUpdateManDirty();
            }
            case 31: {
                return pSDEWizardStepBase.isUserCatDirty();
            }
            case 32: {
                return pSDEWizardStepBase.isUserTagDirty();
            }
            case 33: {
                return pSDEWizardStepBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDEWizardStepBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDEWizardStepBase.isUserTag4Dirty();
            }
            case 36: {
                return pSDEWizardStepBase.isVisibleLogicDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEWizardStepBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEWizardStepBase pSDEWizardStepBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEWizardStepBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getInitPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getInitPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getInitPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getInitPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getNextPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdeactionid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getNextPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getNextPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdeactionname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getNextPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEWizardStepId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSDEWizardStepName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getStepAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stepaction", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getStepAction()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getStepTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steptag", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getStepTag()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getSubTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitle", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getSubTitle()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getSubTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitlepslanresid", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getSubTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getSubTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitlepslanresname", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getSubTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEWizardStepBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSDEWizardStepBase.getJSONValue((Object)pSDEWizardStepBase.getVisibleLogic()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEWizardStepBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEWizardStepBase pSDEWizardStepBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEWizardStepBase.getCreateDate() != null) {
            object = pSDEWizardStepBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardStepBase.getCreateMan() != null) {
            object = pSDEWizardStepBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getEnableLink() != null) {
            object = pSDEWizardStepBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardStepBase.getEnableLogic() != null) {
            object = pSDEWizardStepBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getInitPSDEActionId() != null) {
            object = pSDEWizardStepBase.getInitPSDEActionId();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getInitPSDEActionName() != null) {
            object = pSDEWizardStepBase.getInitPSDEActionName();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getLNPSLanResId() != null) {
            object = pSDEWizardStepBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getLNPSLanResName() != null) {
            object = pSDEWizardStepBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getLogicName() != null) {
            object = pSDEWizardStepBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getMemo() != null) {
            object = pSDEWizardStepBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getNextPSDEActionId() != null) {
            object = pSDEWizardStepBase.getNextPSDEActionId();
            xmlNode.setAttribute(FIELD_NEXTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getNextPSDEActionName() != null) {
            object = pSDEWizardStepBase.getNextPSDEActionName();
            xmlNode.setAttribute(FIELD_NEXTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getOrderValue() != null) {
            object = pSDEWizardStepBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardStepBase.getPSDEFormId() != null) {
            object = pSDEWizardStepBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEFormName() != null) {
            object = pSDEWizardStepBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEId() != null) {
            object = pSDEWizardStepBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardId() != null) {
            object = pSDEWizardStepBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardName() != null) {
            object = pSDEWizardStepBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardStepId() != null) {
            object = pSDEWizardStepBase.getPSDEWizardStepId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSDEWizardStepName() != null) {
            object = pSDEWizardStepBase.getPSDEWizardStepName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSSysCssId() != null) {
            object = pSDEWizardStepBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSSysCssName() != null) {
            object = pSDEWizardStepBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSSysImageId() != null) {
            object = pSDEWizardStepBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getPSSysImageName() != null) {
            object = pSDEWizardStepBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getStepAction() != null) {
            object = pSDEWizardStepBase.getStepAction();
            xmlNode.setAttribute(FIELD_STEPACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getStepTag() != null) {
            object = pSDEWizardStepBase.getStepTag();
            xmlNode.setAttribute(FIELD_STEPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getSubTitle() != null) {
            object = pSDEWizardStepBase.getSubTitle();
            xmlNode.setAttribute(FIELD_SUBTITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getSubTitlePSLanResId() != null) {
            object = pSDEWizardStepBase.getSubTitlePSLanResId();
            xmlNode.setAttribute(FIELD_SUBTITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getSubTitlePSLanResName() != null) {
            object = pSDEWizardStepBase.getSubTitlePSLanResName();
            xmlNode.setAttribute(FIELD_SUBTITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUpdateDate() != null) {
            object = pSDEWizardStepBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardStepBase.getUpdateMan() != null) {
            object = pSDEWizardStepBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUserCat() != null) {
            object = pSDEWizardStepBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUserTag() != null) {
            object = pSDEWizardStepBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUserTag2() != null) {
            object = pSDEWizardStepBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUserTag3() != null) {
            object = pSDEWizardStepBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getUserTag4() != null) {
            object = pSDEWizardStepBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardStepBase.getVisibleLogic() != null) {
            object = pSDEWizardStepBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEWizardStepBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEWizardStepBase pSDEWizardStepBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEWizardStepBase.isCreateDateDirty() && (bl || pSDEWizardStepBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEWizardStepBase.getCreateDate());
        }
        if (pSDEWizardStepBase.isCreateManDirty() && (bl || pSDEWizardStepBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEWizardStepBase.getCreateMan());
        }
        if (pSDEWizardStepBase.isEnableLinkDirty() && (bl || pSDEWizardStepBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDEWizardStepBase.getEnableLink());
        }
        if (pSDEWizardStepBase.isEnableLogicDirty() && (bl || pSDEWizardStepBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSDEWizardStepBase.getEnableLogic());
        }
        if (pSDEWizardStepBase.isInitPSDEActionIdDirty() && (bl || pSDEWizardStepBase.getInitPSDEActionId() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONID, (Object)pSDEWizardStepBase.getInitPSDEActionId());
        }
        if (pSDEWizardStepBase.isInitPSDEActionNameDirty() && (bl || pSDEWizardStepBase.getInitPSDEActionName() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONNAME, (Object)pSDEWizardStepBase.getInitPSDEActionName());
        }
        if (pSDEWizardStepBase.isLNPSLanResIdDirty() && (bl || pSDEWizardStepBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDEWizardStepBase.getLNPSLanResId());
        }
        if (pSDEWizardStepBase.isLNPSLanResNameDirty() && (bl || pSDEWizardStepBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDEWizardStepBase.getLNPSLanResName());
        }
        if (pSDEWizardStepBase.isLogicNameDirty() && (bl || pSDEWizardStepBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEWizardStepBase.getLogicName());
        }
        if (pSDEWizardStepBase.isMemoDirty() && (bl || pSDEWizardStepBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEWizardStepBase.getMemo());
        }
        if (pSDEWizardStepBase.isNextPSDEActionIdDirty() && (bl || pSDEWizardStepBase.getNextPSDEActionId() != null)) {
            iDataObject.set(FIELD_NEXTPSDEACTIONID, (Object)pSDEWizardStepBase.getNextPSDEActionId());
        }
        if (pSDEWizardStepBase.isNextPSDEActionNameDirty() && (bl || pSDEWizardStepBase.getNextPSDEActionName() != null)) {
            iDataObject.set(FIELD_NEXTPSDEACTIONNAME, (Object)pSDEWizardStepBase.getNextPSDEActionName());
        }
        if (pSDEWizardStepBase.isOrderValueDirty() && (bl || pSDEWizardStepBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEWizardStepBase.getOrderValue());
        }
        if (pSDEWizardStepBase.isPSDEFormIdDirty() && (bl || pSDEWizardStepBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEWizardStepBase.getPSDEFormId());
        }
        if (pSDEWizardStepBase.isPSDEFormNameDirty() && (bl || pSDEWizardStepBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEWizardStepBase.getPSDEFormName());
        }
        if (pSDEWizardStepBase.isPSDEIdDirty() && (bl || pSDEWizardStepBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEWizardStepBase.getPSDEId());
        }
        if (pSDEWizardStepBase.isPSDEWizardIdDirty() && (bl || pSDEWizardStepBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSDEWizardStepBase.getPSDEWizardId());
        }
        if (pSDEWizardStepBase.isPSDEWizardNameDirty() && (bl || pSDEWizardStepBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSDEWizardStepBase.getPSDEWizardName());
        }
        if (pSDEWizardStepBase.isPSDEWizardStepIdDirty() && (bl || pSDEWizardStepBase.getPSDEWizardStepId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPID, (Object)pSDEWizardStepBase.getPSDEWizardStepId());
        }
        if (pSDEWizardStepBase.isPSDEWizardStepNameDirty() && (bl || pSDEWizardStepBase.getPSDEWizardStepName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPNAME, (Object)pSDEWizardStepBase.getPSDEWizardStepName());
        }
        if (pSDEWizardStepBase.isPSSysCssIdDirty() && (bl || pSDEWizardStepBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEWizardStepBase.getPSSysCssId());
        }
        if (pSDEWizardStepBase.isPSSysCssNameDirty() && (bl || pSDEWizardStepBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEWizardStepBase.getPSSysCssName());
        }
        if (pSDEWizardStepBase.isPSSysImageIdDirty() && (bl || pSDEWizardStepBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEWizardStepBase.getPSSysImageId());
        }
        if (pSDEWizardStepBase.isPSSysImageNameDirty() && (bl || pSDEWizardStepBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEWizardStepBase.getPSSysImageName());
        }
        if (pSDEWizardStepBase.isStepActionDirty() && (bl || pSDEWizardStepBase.getStepAction() != null)) {
            iDataObject.set(FIELD_STEPACTION, (Object)pSDEWizardStepBase.getStepAction());
        }
        if (pSDEWizardStepBase.isStepTagDirty() && (bl || pSDEWizardStepBase.getStepTag() != null)) {
            iDataObject.set(FIELD_STEPTAG, (Object)pSDEWizardStepBase.getStepTag());
        }
        if (pSDEWizardStepBase.isSubTitleDirty() && (bl || pSDEWizardStepBase.getSubTitle() != null)) {
            iDataObject.set(FIELD_SUBTITLE, (Object)pSDEWizardStepBase.getSubTitle());
        }
        if (pSDEWizardStepBase.isSubTitlePSLanResIdDirty() && (bl || pSDEWizardStepBase.getSubTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_SUBTITLEPSLANRESID, (Object)pSDEWizardStepBase.getSubTitlePSLanResId());
        }
        if (pSDEWizardStepBase.isSubTitlePSLanResNameDirty() && (bl || pSDEWizardStepBase.getSubTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_SUBTITLEPSLANRESNAME, (Object)pSDEWizardStepBase.getSubTitlePSLanResName());
        }
        if (pSDEWizardStepBase.isUpdateDateDirty() && (bl || pSDEWizardStepBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEWizardStepBase.getUpdateDate());
        }
        if (pSDEWizardStepBase.isUpdateManDirty() && (bl || pSDEWizardStepBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEWizardStepBase.getUpdateMan());
        }
        if (pSDEWizardStepBase.isUserCatDirty() && (bl || pSDEWizardStepBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEWizardStepBase.getUserCat());
        }
        if (pSDEWizardStepBase.isUserTagDirty() && (bl || pSDEWizardStepBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEWizardStepBase.getUserTag());
        }
        if (pSDEWizardStepBase.isUserTag2Dirty() && (bl || pSDEWizardStepBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEWizardStepBase.getUserTag2());
        }
        if (pSDEWizardStepBase.isUserTag3Dirty() && (bl || pSDEWizardStepBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEWizardStepBase.getUserTag3());
        }
        if (pSDEWizardStepBase.isUserTag4Dirty() && (bl || pSDEWizardStepBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEWizardStepBase.getUserTag4());
        }
        if (pSDEWizardStepBase.isVisibleLogicDirty() && (bl || pSDEWizardStepBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSDEWizardStepBase.getVisibleLogic());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDEWizardStepBase.remove(this, n);
    }

    private static boolean remove(PSDEWizardStepBase pSDEWizardStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardStepBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEWizardStepBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEWizardStepBase.resetEnableLink();
                return true;
            }
            case 3: {
                pSDEWizardStepBase.resetEnableLogic();
                return true;
            }
            case 4: {
                pSDEWizardStepBase.resetInitPSDEActionId();
                return true;
            }
            case 5: {
                pSDEWizardStepBase.resetInitPSDEActionName();
                return true;
            }
            case 6: {
                pSDEWizardStepBase.resetLNPSLanResId();
                return true;
            }
            case 7: {
                pSDEWizardStepBase.resetLNPSLanResName();
                return true;
            }
            case 8: {
                pSDEWizardStepBase.resetLogicName();
                return true;
            }
            case 9: {
                pSDEWizardStepBase.resetMemo();
                return true;
            }
            case 10: {
                pSDEWizardStepBase.resetNextPSDEActionId();
                return true;
            }
            case 11: {
                pSDEWizardStepBase.resetNextPSDEActionName();
                return true;
            }
            case 12: {
                pSDEWizardStepBase.resetOrderValue();
                return true;
            }
            case 13: {
                pSDEWizardStepBase.resetPSDEFormId();
                return true;
            }
            case 14: {
                pSDEWizardStepBase.resetPSDEFormName();
                return true;
            }
            case 15: {
                pSDEWizardStepBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSDEWizardStepBase.resetPSDEWizardId();
                return true;
            }
            case 17: {
                pSDEWizardStepBase.resetPSDEWizardName();
                return true;
            }
            case 18: {
                pSDEWizardStepBase.resetPSDEWizardStepId();
                return true;
            }
            case 19: {
                pSDEWizardStepBase.resetPSDEWizardStepName();
                return true;
            }
            case 20: {
                pSDEWizardStepBase.resetPSSysCssId();
                return true;
            }
            case 21: {
                pSDEWizardStepBase.resetPSSysCssName();
                return true;
            }
            case 22: {
                pSDEWizardStepBase.resetPSSysImageId();
                return true;
            }
            case 23: {
                pSDEWizardStepBase.resetPSSysImageName();
                return true;
            }
            case 24: {
                pSDEWizardStepBase.resetStepAction();
                return true;
            }
            case 25: {
                pSDEWizardStepBase.resetStepTag();
                return true;
            }
            case 26: {
                pSDEWizardStepBase.resetSubTitle();
                return true;
            }
            case 27: {
                pSDEWizardStepBase.resetSubTitlePSLanResId();
                return true;
            }
            case 28: {
                pSDEWizardStepBase.resetSubTitlePSLanResName();
                return true;
            }
            case 29: {
                pSDEWizardStepBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDEWizardStepBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDEWizardStepBase.resetUserCat();
                return true;
            }
            case 32: {
                pSDEWizardStepBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDEWizardStepBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDEWizardStepBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDEWizardStepBase.resetUserTag4();
                return true;
            }
            case 36: {
                pSDEWizardStepBase.resetVisibleLogic();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getInitPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEAction();
        }
        if (this.getInitPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objInitPSDEActionLock;
        synchronized (n) {
            if (this.initpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getInitPSDEActionId(), (Object)this.initpsdeaction.getPSDEActionId()) != 0L) {
                this.initpsdeaction = null;
            }
            if (this.initpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getInitPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.initpsdeaction = pSDEAction;
            }
            return this.initpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getNextPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEAction();
        }
        if (this.getNextPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objNextPSDEActionLock;
        synchronized (n) {
            if (this.nextpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getNextPSDEActionId(), (Object)this.nextpsdeaction.getPSDEActionId()) != 0L) {
                this.nextpsdeaction = null;
            }
            if (this.nextpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getNextPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.nextpsdeaction = pSDEAction;
            }
            return this.nextpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizard();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardLock;
        synchronized (n) {
            if (this.psdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardId(), (Object)this.psdewizard.getPSDEWizardId()) != 0L) {
                this.psdewizard = null;
            }
            if (this.psdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet((IEntity)pSDEWizard);
                this.psdewizard = pSDEWizard;
            }
            return this.psdewizard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getLNPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanRes();
        }
        if (this.getLNPSLanResId() == null) {
            return null;
        }
        Integer n = this.objLNPSLanResLock;
        synchronized (n) {
            if (this.lnpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getLNPSLanResId(), (Object)this.lnpslanres.getPSLanguageResId()) != 0L) {
                this.lnpslanres = null;
            }
            if (this.lnpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getLNPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSubTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanRes();
        }
        if (this.getSubTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objSubTitlePSLanResLock;
        synchronized (n) {
            if (this.subtitlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSubTitlePSLanResId(), (Object)this.subtitlepslanres.getPSLanguageResId()) != 0L) {
                this.subtitlepslanres = null;
            }
            if (this.subtitlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSubTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.subtitlepslanres = pSLanguageRes;
            }
            return this.subtitlepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    private PSDEWizardStepBase getProxyEntity() {
        return this.proxyPSDEWizardStepBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEWizardStepBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEWizardStepBase) {
            this.proxyPSDEWizardStepBase = (PSDEWizardStepBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLELINK, 2);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 3);
        fieldIndexMap.put(FIELD_INITPSDEACTIONID, 4);
        fieldIndexMap.put(FIELD_INITPSDEACTIONNAME, 5);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 6);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 7);
        fieldIndexMap.put(FIELD_LOGICNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_NEXTPSDEACTIONID, 10);
        fieldIndexMap.put(FIELD_NEXTPSDEACTIONNAME, 11);
        fieldIndexMap.put(FIELD_ORDERVALUE, 12);
        fieldIndexMap.put(FIELD_PSDEFORMID, 13);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 16);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 17);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPID, 18);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 20);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 22);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 23);
        fieldIndexMap.put(FIELD_STEPACTION, 24);
        fieldIndexMap.put(FIELD_STEPTAG, 25);
        fieldIndexMap.put(FIELD_SUBTITLE, 26);
        fieldIndexMap.put(FIELD_SUBTITLEPSLANRESID, 27);
        fieldIndexMap.put(FIELD_SUBTITLEPSLANRESNAME, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 36);
    }
}

