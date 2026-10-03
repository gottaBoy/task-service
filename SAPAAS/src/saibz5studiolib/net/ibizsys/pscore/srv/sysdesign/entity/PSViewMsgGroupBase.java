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
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGrpDetail;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewMsgGroupBase.class);
    public static final String FIELD_BODYMSGPSSYSCSSID = "BODYMSGPSSYSCSSID";
    public static final String FIELD_BODYMSGPSSYSCSSNAME = "BODYMSGPSSYSCSSNAME";
    public static final String FIELD_BODYMSGSTYLE = "BODYMSGSTYLE";
    public static final String FIELD_BOTTOMMSGPSSYSCSSID = "BOTTOMMSGPSSYSCSSID";
    public static final String FIELD_BOTTOMMSGPSSYSCSSNAME = "BOTTOMMSGPSSYSCSSNAME";
    public static final String FIELD_BOTTOMMSGSTYLE = "BOTTOMMSGSTYLE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMICMODE = "DYNAMICMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_TOPMSGPSSYSCSSID = "TOPMSGPSSYSCSSID";
    public static final String FIELD_TOPMSGPSSYSCSSNAME = "TOPMSGPSSYSCSSNAME";
    public static final String FIELD_TOPMSGSTYLE = "TOPMSGSTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BODYMSGPSSYSCSSID = 0;
    private static final int INDEX_BODYMSGPSSYSCSSNAME = 1;
    private static final int INDEX_BODYMSGSTYLE = 2;
    private static final int INDEX_BOTTOMMSGPSSYSCSSID = 3;
    private static final int INDEX_BOTTOMMSGPSSYSCSSNAME = 4;
    private static final int INDEX_BOTTOMMSGSTYLE = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_DYNAMICMODE = 9;
    private static final int INDEX_LOCKFLAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSTEMID = 18;
    private static final int INDEX_PSSYSTEMNAME = 19;
    private static final int INDEX_PSVIEWMSGGROUPID = 20;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 21;
    private static final int INDEX_TOPMSGPSSYSCSSID = 22;
    private static final int INDEX_TOPMSGPSSYSCSSNAME = 23;
    private static final int INDEX_TOPMSGSTYLE = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USERCAT = 27;
    private static final int INDEX_USERPARAMS = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewMsgGroupBase proxyPSViewMsgGroupBase = null;
    private boolean bodymsgpssyscssidDirtyFlag = false;
    private boolean bodymsgpssyscssnameDirtyFlag = false;
    private boolean bodymsgstyleDirtyFlag = false;
    private boolean bottommsgpssyscssidDirtyFlag = false;
    private boolean bottommsgpssyscssnameDirtyFlag = false;
    private boolean bottommsgstyleDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamicmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean topmsgpssyscssidDirtyFlag = false;
    private boolean topmsgpssyscssnameDirtyFlag = false;
    private boolean topmsgstyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="bodymsgpssyscssid")
    private String bodymsgpssyscssid;
    @Column(name="bodymsgpssyscssname")
    private String bodymsgpssyscssname;
    @Column(name="bodymsgstyle")
    private String bodymsgstyle;
    @Column(name="bottommsgpssyscssid")
    private String bottommsgpssyscssid;
    @Column(name="bottommsgpssyscssname")
    private String bottommsgpssyscssname;
    @Column(name="bottommsgstyle")
    private String bottommsgstyle;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamicmode")
    private Integer dynamicmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="topmsgpssyscssid")
    private String topmsgpssyscssid;
    @Column(name="topmsgpssyscssname")
    private String topmsgpssyscssname;
    @Column(name="topmsgstyle")
    private String topmsgstyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objBodyMsgPSSysCssLock = new Integer(1);
    private PSSysCss bodymsgpssyscss = null;
    private Integer objBottomMsgPSSysCssLock = new Integer(1);
    private PSSysCss bottommsgpssyscss = null;
    private Integer objTopMsgPSSysCssLock = new Integer(1);
    private PSSysCss topmsgpssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGrpDetailsLock = new Integer(1);
    private ArrayList<PSViewMsgGrpDetail> psviewmsggrpdetails = null;

    public void setBodyMsgPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBodyMsgPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bodymsgpssyscssid = string;
        this.bodymsgpssyscssidDirtyFlag = true;
    }

    public String getBodyMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBodyMsgPSSysCssId();
        }
        return this.bodymsgpssyscssid;
    }

    public boolean isBodyMsgPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBodyMsgPSSysCssIdDirty();
        }
        return this.bodymsgpssyscssidDirtyFlag;
    }

    public void resetBodyMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBodyMsgPSSysCssId();
            return;
        }
        this.bodymsgpssyscssidDirtyFlag = false;
        this.bodymsgpssyscssid = null;
    }

    public void setBodyMsgPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBodyMsgPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bodymsgpssyscssname = string;
        this.bodymsgpssyscssnameDirtyFlag = true;
    }

    public String getBodyMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBodyMsgPSSysCssName();
        }
        return this.bodymsgpssyscssname;
    }

    public boolean isBodyMsgPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBodyMsgPSSysCssNameDirty();
        }
        return this.bodymsgpssyscssnameDirtyFlag;
    }

    public void resetBodyMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBodyMsgPSSysCssName();
            return;
        }
        this.bodymsgpssyscssnameDirtyFlag = false;
        this.bodymsgpssyscssname = null;
    }

    public void setBodyMsgStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBodyMsgStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bodymsgstyle = string;
        this.bodymsgstyleDirtyFlag = true;
    }

    public String getBodyMsgStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBodyMsgStyle();
        }
        return this.bodymsgstyle;
    }

    public boolean isBodyMsgStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBodyMsgStyleDirty();
        }
        return this.bodymsgstyleDirtyFlag;
    }

    public void resetBodyMsgStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBodyMsgStyle();
            return;
        }
        this.bodymsgstyleDirtyFlag = false;
        this.bodymsgstyle = null;
    }

    public void setBottomMsgPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomMsgPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottommsgpssyscssid = string;
        this.bottommsgpssyscssidDirtyFlag = true;
    }

    public String getBottomMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomMsgPSSysCssId();
        }
        return this.bottommsgpssyscssid;
    }

    public boolean isBottomMsgPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomMsgPSSysCssIdDirty();
        }
        return this.bottommsgpssyscssidDirtyFlag;
    }

    public void resetBottomMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomMsgPSSysCssId();
            return;
        }
        this.bottommsgpssyscssidDirtyFlag = false;
        this.bottommsgpssyscssid = null;
    }

    public void setBottomMsgPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomMsgPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottommsgpssyscssname = string;
        this.bottommsgpssyscssnameDirtyFlag = true;
    }

    public String getBottomMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomMsgPSSysCssName();
        }
        return this.bottommsgpssyscssname;
    }

    public boolean isBottomMsgPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomMsgPSSysCssNameDirty();
        }
        return this.bottommsgpssyscssnameDirtyFlag;
    }

    public void resetBottomMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomMsgPSSysCssName();
            return;
        }
        this.bottommsgpssyscssnameDirtyFlag = false;
        this.bottommsgpssyscssname = null;
    }

    public void setBottomMsgStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomMsgStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottommsgstyle = string;
        this.bottommsgstyleDirtyFlag = true;
    }

    public String getBottomMsgStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomMsgStyle();
        }
        return this.bottommsgstyle;
    }

    public boolean isBottomMsgStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomMsgStyleDirty();
        }
        return this.bottommsgstyleDirtyFlag;
    }

    public void resetBottomMsgStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomMsgStyle();
            return;
        }
        this.bottommsgstyleDirtyFlag = false;
        this.bottommsgstyle = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicMode(n);
            return;
        }
        this.dynamicmode = n;
        this.dynamicmodeDirtyFlag = true;
    }

    public Integer getDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicMode();
        }
        return this.dynamicmode;
    }

    public boolean isDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicModeDirty();
        }
        return this.dynamicmodeDirtyFlag;
    }

    public void resetDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicMode();
            return;
        }
        this.dynamicmodeDirtyFlag = false;
        this.dynamicmode = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setTopMsgPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopMsgPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topmsgpssyscssid = string;
        this.topmsgpssyscssidDirtyFlag = true;
    }

    public String getTopMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopMsgPSSysCssId();
        }
        return this.topmsgpssyscssid;
    }

    public boolean isTopMsgPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopMsgPSSysCssIdDirty();
        }
        return this.topmsgpssyscssidDirtyFlag;
    }

    public void resetTopMsgPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopMsgPSSysCssId();
            return;
        }
        this.topmsgpssyscssidDirtyFlag = false;
        this.topmsgpssyscssid = null;
    }

    public void setTopMsgPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopMsgPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topmsgpssyscssname = string;
        this.topmsgpssyscssnameDirtyFlag = true;
    }

    public String getTopMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopMsgPSSysCssName();
        }
        return this.topmsgpssyscssname;
    }

    public boolean isTopMsgPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopMsgPSSysCssNameDirty();
        }
        return this.topmsgpssyscssnameDirtyFlag;
    }

    public void resetTopMsgPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopMsgPSSysCssName();
            return;
        }
        this.topmsgpssyscssnameDirtyFlag = false;
        this.topmsgpssyscssname = null;
    }

    public void setTopMsgStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopMsgStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topmsgstyle = string;
        this.topmsgstyleDirtyFlag = true;
    }

    public String getTopMsgStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopMsgStyle();
        }
        return this.topmsgstyle;
    }

    public boolean isTopMsgStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopMsgStyleDirty();
        }
        return this.topmsgstyleDirtyFlag;
    }

    public void resetTopMsgStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopMsgStyle();
            return;
        }
        this.topmsgstyleDirtyFlag = false;
        this.topmsgstyle = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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

    protected void onReset() {
        PSViewMsgGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewMsgGroupBase pSViewMsgGroupBase) {
        pSViewMsgGroupBase.resetBodyMsgPSSysCssId();
        pSViewMsgGroupBase.resetBodyMsgPSSysCssName();
        pSViewMsgGroupBase.resetBodyMsgStyle();
        pSViewMsgGroupBase.resetBottomMsgPSSysCssId();
        pSViewMsgGroupBase.resetBottomMsgPSSysCssName();
        pSViewMsgGroupBase.resetBottomMsgStyle();
        pSViewMsgGroupBase.resetCodeName();
        pSViewMsgGroupBase.resetCreateDate();
        pSViewMsgGroupBase.resetCreateMan();
        pSViewMsgGroupBase.resetDynamicMode();
        pSViewMsgGroupBase.resetLockFlag();
        pSViewMsgGroupBase.resetMemo();
        pSViewMsgGroupBase.resetPSDEId();
        pSViewMsgGroupBase.resetPSDEName();
        pSViewMsgGroupBase.resetPSModuleId();
        pSViewMsgGroupBase.resetPSModuleName();
        pSViewMsgGroupBase.resetPSSysDynaModelId();
        pSViewMsgGroupBase.resetPSSysDynaModelName();
        pSViewMsgGroupBase.resetPSSystemId();
        pSViewMsgGroupBase.resetPSSystemName();
        pSViewMsgGroupBase.resetPSViewMsgGroupId();
        pSViewMsgGroupBase.resetPSViewMsgGroupName();
        pSViewMsgGroupBase.resetTopMsgPSSysCssId();
        pSViewMsgGroupBase.resetTopMsgPSSysCssName();
        pSViewMsgGroupBase.resetTopMsgStyle();
        pSViewMsgGroupBase.resetUpdateDate();
        pSViewMsgGroupBase.resetUpdateMan();
        pSViewMsgGroupBase.resetUserCat();
        pSViewMsgGroupBase.resetUserParams();
        pSViewMsgGroupBase.resetUserTag();
        pSViewMsgGroupBase.resetUserTag2();
        pSViewMsgGroupBase.resetUserTag3();
        pSViewMsgGroupBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBodyMsgPSSysCssIdDirty()) {
            hashMap.put(FIELD_BODYMSGPSSYSCSSID, this.getBodyMsgPSSysCssId());
        }
        if (!bl || this.isBodyMsgPSSysCssNameDirty()) {
            hashMap.put(FIELD_BODYMSGPSSYSCSSNAME, this.getBodyMsgPSSysCssName());
        }
        if (!bl || this.isBodyMsgStyleDirty()) {
            hashMap.put(FIELD_BODYMSGSTYLE, this.getBodyMsgStyle());
        }
        if (!bl || this.isBottomMsgPSSysCssIdDirty()) {
            hashMap.put(FIELD_BOTTOMMSGPSSYSCSSID, this.getBottomMsgPSSysCssId());
        }
        if (!bl || this.isBottomMsgPSSysCssNameDirty()) {
            hashMap.put(FIELD_BOTTOMMSGPSSYSCSSNAME, this.getBottomMsgPSSysCssName());
        }
        if (!bl || this.isBottomMsgStyleDirty()) {
            hashMap.put(FIELD_BOTTOMMSGSTYLE, this.getBottomMsgStyle());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynamicModeDirty()) {
            hashMap.put(FIELD_DYNAMICMODE, this.getDynamicMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isTopMsgPSSysCssIdDirty()) {
            hashMap.put(FIELD_TOPMSGPSSYSCSSID, this.getTopMsgPSSysCssId());
        }
        if (!bl || this.isTopMsgPSSysCssNameDirty()) {
            hashMap.put(FIELD_TOPMSGPSSYSCSSNAME, this.getTopMsgPSSysCssName());
        }
        if (!bl || this.isTopMsgStyleDirty()) {
            hashMap.put(FIELD_TOPMSGSTYLE, this.getTopMsgStyle());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSViewMsgGroupBase.get(this, n);
    }

    private static Object get(PSViewMsgGroupBase pSViewMsgGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGroupBase.getBodyMsgPSSysCssId();
            }
            case 1: {
                return pSViewMsgGroupBase.getBodyMsgPSSysCssName();
            }
            case 2: {
                return pSViewMsgGroupBase.getBodyMsgStyle();
            }
            case 3: {
                return pSViewMsgGroupBase.getBottomMsgPSSysCssId();
            }
            case 4: {
                return pSViewMsgGroupBase.getBottomMsgPSSysCssName();
            }
            case 5: {
                return pSViewMsgGroupBase.getBottomMsgStyle();
            }
            case 6: {
                return pSViewMsgGroupBase.getCodeName();
            }
            case 7: {
                return pSViewMsgGroupBase.getCreateDate();
            }
            case 8: {
                return pSViewMsgGroupBase.getCreateMan();
            }
            case 9: {
                return pSViewMsgGroupBase.getDynamicMode();
            }
            case 10: {
                return pSViewMsgGroupBase.getLockFlag();
            }
            case 11: {
                return pSViewMsgGroupBase.getMemo();
            }
            case 12: {
                return pSViewMsgGroupBase.getPSDEId();
            }
            case 13: {
                return pSViewMsgGroupBase.getPSDEName();
            }
            case 14: {
                return pSViewMsgGroupBase.getPSModuleId();
            }
            case 15: {
                return pSViewMsgGroupBase.getPSModuleName();
            }
            case 16: {
                return pSViewMsgGroupBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSViewMsgGroupBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSViewMsgGroupBase.getPSSystemId();
            }
            case 19: {
                return pSViewMsgGroupBase.getPSSystemName();
            }
            case 20: {
                return pSViewMsgGroupBase.getPSViewMsgGroupId();
            }
            case 21: {
                return pSViewMsgGroupBase.getPSViewMsgGroupName();
            }
            case 22: {
                return pSViewMsgGroupBase.getTopMsgPSSysCssId();
            }
            case 23: {
                return pSViewMsgGroupBase.getTopMsgPSSysCssName();
            }
            case 24: {
                return pSViewMsgGroupBase.getTopMsgStyle();
            }
            case 25: {
                return pSViewMsgGroupBase.getUpdateDate();
            }
            case 26: {
                return pSViewMsgGroupBase.getUpdateMan();
            }
            case 27: {
                return pSViewMsgGroupBase.getUserCat();
            }
            case 28: {
                return pSViewMsgGroupBase.getUserParams();
            }
            case 29: {
                return pSViewMsgGroupBase.getUserTag();
            }
            case 30: {
                return pSViewMsgGroupBase.getUserTag2();
            }
            case 31: {
                return pSViewMsgGroupBase.getUserTag3();
            }
            case 32: {
                return pSViewMsgGroupBase.getUserTag4();
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
        PSViewMsgGroupBase.set(this, n, object);
    }

    private static void set(PSViewMsgGroupBase pSViewMsgGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgGroupBase.setBodyMsgPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewMsgGroupBase.setBodyMsgPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewMsgGroupBase.setBodyMsgStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewMsgGroupBase.setBottomMsgPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewMsgGroupBase.setBottomMsgPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewMsgGroupBase.setBottomMsgStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewMsgGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewMsgGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSViewMsgGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewMsgGroupBase.setDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSViewMsgGroupBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSViewMsgGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewMsgGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewMsgGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSViewMsgGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewMsgGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewMsgGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewMsgGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSViewMsgGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewMsgGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSViewMsgGroupBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSViewMsgGroupBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSViewMsgGroupBase.setTopMsgPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSViewMsgGroupBase.setTopMsgPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSViewMsgGroupBase.setTopMsgStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSViewMsgGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSViewMsgGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSViewMsgGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSViewMsgGroupBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSViewMsgGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSViewMsgGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSViewMsgGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSViewMsgGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSViewMsgGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSViewMsgGroupBase pSViewMsgGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGroupBase.getBodyMsgPSSysCssId() == null;
            }
            case 1: {
                return pSViewMsgGroupBase.getBodyMsgPSSysCssName() == null;
            }
            case 2: {
                return pSViewMsgGroupBase.getBodyMsgStyle() == null;
            }
            case 3: {
                return pSViewMsgGroupBase.getBottomMsgPSSysCssId() == null;
            }
            case 4: {
                return pSViewMsgGroupBase.getBottomMsgPSSysCssName() == null;
            }
            case 5: {
                return pSViewMsgGroupBase.getBottomMsgStyle() == null;
            }
            case 6: {
                return pSViewMsgGroupBase.getCodeName() == null;
            }
            case 7: {
                return pSViewMsgGroupBase.getCreateDate() == null;
            }
            case 8: {
                return pSViewMsgGroupBase.getCreateMan() == null;
            }
            case 9: {
                return pSViewMsgGroupBase.getDynamicMode() == null;
            }
            case 10: {
                return pSViewMsgGroupBase.getLockFlag() == null;
            }
            case 11: {
                return pSViewMsgGroupBase.getMemo() == null;
            }
            case 12: {
                return pSViewMsgGroupBase.getPSDEId() == null;
            }
            case 13: {
                return pSViewMsgGroupBase.getPSDEName() == null;
            }
            case 14: {
                return pSViewMsgGroupBase.getPSModuleId() == null;
            }
            case 15: {
                return pSViewMsgGroupBase.getPSModuleName() == null;
            }
            case 16: {
                return pSViewMsgGroupBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSViewMsgGroupBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSViewMsgGroupBase.getPSSystemId() == null;
            }
            case 19: {
                return pSViewMsgGroupBase.getPSSystemName() == null;
            }
            case 20: {
                return pSViewMsgGroupBase.getPSViewMsgGroupId() == null;
            }
            case 21: {
                return pSViewMsgGroupBase.getPSViewMsgGroupName() == null;
            }
            case 22: {
                return pSViewMsgGroupBase.getTopMsgPSSysCssId() == null;
            }
            case 23: {
                return pSViewMsgGroupBase.getTopMsgPSSysCssName() == null;
            }
            case 24: {
                return pSViewMsgGroupBase.getTopMsgStyle() == null;
            }
            case 25: {
                return pSViewMsgGroupBase.getUpdateDate() == null;
            }
            case 26: {
                return pSViewMsgGroupBase.getUpdateMan() == null;
            }
            case 27: {
                return pSViewMsgGroupBase.getUserCat() == null;
            }
            case 28: {
                return pSViewMsgGroupBase.getUserParams() == null;
            }
            case 29: {
                return pSViewMsgGroupBase.getUserTag() == null;
            }
            case 30: {
                return pSViewMsgGroupBase.getUserTag2() == null;
            }
            case 31: {
                return pSViewMsgGroupBase.getUserTag3() == null;
            }
            case 32: {
                return pSViewMsgGroupBase.getUserTag4() == null;
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
        return PSViewMsgGroupBase.contains(this, n);
    }

    private static boolean contains(PSViewMsgGroupBase pSViewMsgGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGroupBase.isBodyMsgPSSysCssIdDirty();
            }
            case 1: {
                return pSViewMsgGroupBase.isBodyMsgPSSysCssNameDirty();
            }
            case 2: {
                return pSViewMsgGroupBase.isBodyMsgStyleDirty();
            }
            case 3: {
                return pSViewMsgGroupBase.isBottomMsgPSSysCssIdDirty();
            }
            case 4: {
                return pSViewMsgGroupBase.isBottomMsgPSSysCssNameDirty();
            }
            case 5: {
                return pSViewMsgGroupBase.isBottomMsgStyleDirty();
            }
            case 6: {
                return pSViewMsgGroupBase.isCodeNameDirty();
            }
            case 7: {
                return pSViewMsgGroupBase.isCreateDateDirty();
            }
            case 8: {
                return pSViewMsgGroupBase.isCreateManDirty();
            }
            case 9: {
                return pSViewMsgGroupBase.isDynamicModeDirty();
            }
            case 10: {
                return pSViewMsgGroupBase.isLockFlagDirty();
            }
            case 11: {
                return pSViewMsgGroupBase.isMemoDirty();
            }
            case 12: {
                return pSViewMsgGroupBase.isPSDEIdDirty();
            }
            case 13: {
                return pSViewMsgGroupBase.isPSDENameDirty();
            }
            case 14: {
                return pSViewMsgGroupBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSViewMsgGroupBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSViewMsgGroupBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSViewMsgGroupBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSViewMsgGroupBase.isPSSystemIdDirty();
            }
            case 19: {
                return pSViewMsgGroupBase.isPSSystemNameDirty();
            }
            case 20: {
                return pSViewMsgGroupBase.isPSViewMsgGroupIdDirty();
            }
            case 21: {
                return pSViewMsgGroupBase.isPSViewMsgGroupNameDirty();
            }
            case 22: {
                return pSViewMsgGroupBase.isTopMsgPSSysCssIdDirty();
            }
            case 23: {
                return pSViewMsgGroupBase.isTopMsgPSSysCssNameDirty();
            }
            case 24: {
                return pSViewMsgGroupBase.isTopMsgStyleDirty();
            }
            case 25: {
                return pSViewMsgGroupBase.isUpdateDateDirty();
            }
            case 26: {
                return pSViewMsgGroupBase.isUpdateManDirty();
            }
            case 27: {
                return pSViewMsgGroupBase.isUserCatDirty();
            }
            case 28: {
                return pSViewMsgGroupBase.isUserParamsDirty();
            }
            case 29: {
                return pSViewMsgGroupBase.isUserTagDirty();
            }
            case 30: {
                return pSViewMsgGroupBase.isUserTag2Dirty();
            }
            case 31: {
                return pSViewMsgGroupBase.isUserTag3Dirty();
            }
            case 32: {
                return pSViewMsgGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewMsgGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewMsgGroupBase pSViewMsgGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bodymsgpssyscssid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBodyMsgPSSysCssId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bodymsgpssyscssname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBodyMsgPSSysCssName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getBodyMsgStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bodymsgstyle", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBodyMsgStyle()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottommsgpssyscssid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBottomMsgPSSysCssId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottommsgpssyscssname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBottomMsgPSSysCssName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottommsgstyle", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getBottomMsgStyle()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamicmode", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getDynamicMode()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topmsgpssyscssid", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getTopMsgPSSysCssId()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topmsgpssyscssname", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getTopMsgPSSysCssName()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topmsgstyle", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getTopMsgStyle()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserParams()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewMsgGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewMsgGroupBase.getJSONValue((Object)pSViewMsgGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewMsgGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewMsgGroupBase pSViewMsgGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssId() != null) {
            object = pSViewMsgGroupBase.getBodyMsgPSSysCssId();
            xmlNode.setAttribute(FIELD_BODYMSGPSSYSCSSID, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssName() != null) {
            object = pSViewMsgGroupBase.getBodyMsgPSSysCssName();
            xmlNode.setAttribute(FIELD_BODYMSGPSSYSCSSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getBodyMsgStyle() != null) {
            object = pSViewMsgGroupBase.getBodyMsgStyle();
            xmlNode.setAttribute(FIELD_BODYMSGSTYLE, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssId() != null) {
            object = pSViewMsgGroupBase.getBottomMsgPSSysCssId();
            xmlNode.setAttribute(FIELD_BOTTOMMSGPSSYSCSSID, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssName() != null) {
            object = pSViewMsgGroupBase.getBottomMsgPSSysCssName();
            xmlNode.setAttribute(FIELD_BOTTOMMSGPSSYSCSSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getBottomMsgStyle() != null) {
            object = pSViewMsgGroupBase.getBottomMsgStyle();
            xmlNode.setAttribute(FIELD_BOTTOMMSGSTYLE, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgGroupBase.getCodeName() != null) {
            object = pSViewMsgGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getCreateDate() != null) {
            object = pSViewMsgGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgGroupBase.getCreateMan() != null) {
            object = pSViewMsgGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getDynamicMode() != null) {
            object = pSViewMsgGroupBase.getDynamicMode();
            xmlNode.setAttribute(FIELD_DYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgGroupBase.getLockFlag() != null) {
            object = pSViewMsgGroupBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgGroupBase.getMemo() != null) {
            object = pSViewMsgGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSDEId() != null) {
            object = pSViewMsgGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSDEName() != null) {
            object = pSViewMsgGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSModuleId() != null) {
            object = pSViewMsgGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSModuleName() != null) {
            object = pSViewMsgGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSSysDynaModelId() != null) {
            object = pSViewMsgGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSSysDynaModelName() != null) {
            object = pSViewMsgGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSSystemId() != null) {
            object = pSViewMsgGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSSystemName() != null) {
            object = pSViewMsgGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSViewMsgGroupId() != null) {
            object = pSViewMsgGroupBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getPSViewMsgGroupName() != null) {
            object = pSViewMsgGroupBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgPSSysCssId() != null) {
            object = pSViewMsgGroupBase.getTopMsgPSSysCssId();
            xmlNode.setAttribute(FIELD_TOPMSGPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgPSSysCssName() != null) {
            object = pSViewMsgGroupBase.getTopMsgPSSysCssName();
            xmlNode.setAttribute(FIELD_TOPMSGPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getTopMsgStyle() != null) {
            object = pSViewMsgGroupBase.getTopMsgStyle();
            xmlNode.setAttribute(FIELD_TOPMSGSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUpdateDate() != null) {
            object = pSViewMsgGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgGroupBase.getUpdateMan() != null) {
            object = pSViewMsgGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserCat() != null) {
            object = pSViewMsgGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserParams() != null) {
            object = pSViewMsgGroupBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserTag() != null) {
            object = pSViewMsgGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserTag2() != null) {
            object = pSViewMsgGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserTag3() != null) {
            object = pSViewMsgGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGroupBase.getUserTag4() != null) {
            object = pSViewMsgGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewMsgGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewMsgGroupBase pSViewMsgGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewMsgGroupBase.isBodyMsgPSSysCssIdDirty() && (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssId() != null)) {
            iDataObject.set(FIELD_BODYMSGPSSYSCSSID, (Object)pSViewMsgGroupBase.getBodyMsgPSSysCssId());
        }
        if (pSViewMsgGroupBase.isBodyMsgPSSysCssNameDirty() && (bl || pSViewMsgGroupBase.getBodyMsgPSSysCssName() != null)) {
            iDataObject.set(FIELD_BODYMSGPSSYSCSSNAME, (Object)pSViewMsgGroupBase.getBodyMsgPSSysCssName());
        }
        if (pSViewMsgGroupBase.isBodyMsgStyleDirty() && (bl || pSViewMsgGroupBase.getBodyMsgStyle() != null)) {
            iDataObject.set(FIELD_BODYMSGSTYLE, (Object)pSViewMsgGroupBase.getBodyMsgStyle());
        }
        if (pSViewMsgGroupBase.isBottomMsgPSSysCssIdDirty() && (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssId() != null)) {
            iDataObject.set(FIELD_BOTTOMMSGPSSYSCSSID, (Object)pSViewMsgGroupBase.getBottomMsgPSSysCssId());
        }
        if (pSViewMsgGroupBase.isBottomMsgPSSysCssNameDirty() && (bl || pSViewMsgGroupBase.getBottomMsgPSSysCssName() != null)) {
            iDataObject.set(FIELD_BOTTOMMSGPSSYSCSSNAME, (Object)pSViewMsgGroupBase.getBottomMsgPSSysCssName());
        }
        if (pSViewMsgGroupBase.isBottomMsgStyleDirty() && (bl || pSViewMsgGroupBase.getBottomMsgStyle() != null)) {
            iDataObject.set(FIELD_BOTTOMMSGSTYLE, (Object)pSViewMsgGroupBase.getBottomMsgStyle());
        }
        if (pSViewMsgGroupBase.isCodeNameDirty() && (bl || pSViewMsgGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSViewMsgGroupBase.getCodeName());
        }
        if (pSViewMsgGroupBase.isCreateDateDirty() && (bl || pSViewMsgGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewMsgGroupBase.getCreateDate());
        }
        if (pSViewMsgGroupBase.isCreateManDirty() && (bl || pSViewMsgGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewMsgGroupBase.getCreateMan());
        }
        if (pSViewMsgGroupBase.isDynamicModeDirty() && (bl || pSViewMsgGroupBase.getDynamicMode() != null)) {
            iDataObject.set(FIELD_DYNAMICMODE, (Object)pSViewMsgGroupBase.getDynamicMode());
        }
        if (pSViewMsgGroupBase.isLockFlagDirty() && (bl || pSViewMsgGroupBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSViewMsgGroupBase.getLockFlag());
        }
        if (pSViewMsgGroupBase.isMemoDirty() && (bl || pSViewMsgGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewMsgGroupBase.getMemo());
        }
        if (pSViewMsgGroupBase.isPSDEIdDirty() && (bl || pSViewMsgGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSViewMsgGroupBase.getPSDEId());
        }
        if (pSViewMsgGroupBase.isPSDENameDirty() && (bl || pSViewMsgGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSViewMsgGroupBase.getPSDEName());
        }
        if (pSViewMsgGroupBase.isPSModuleIdDirty() && (bl || pSViewMsgGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSViewMsgGroupBase.getPSModuleId());
        }
        if (pSViewMsgGroupBase.isPSModuleNameDirty() && (bl || pSViewMsgGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSViewMsgGroupBase.getPSModuleName());
        }
        if (pSViewMsgGroupBase.isPSSysDynaModelIdDirty() && (bl || pSViewMsgGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSViewMsgGroupBase.getPSSysDynaModelId());
        }
        if (pSViewMsgGroupBase.isPSSysDynaModelNameDirty() && (bl || pSViewMsgGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSViewMsgGroupBase.getPSSysDynaModelName());
        }
        if (pSViewMsgGroupBase.isPSSystemIdDirty() && (bl || pSViewMsgGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSViewMsgGroupBase.getPSSystemId());
        }
        if (pSViewMsgGroupBase.isPSSystemNameDirty() && (bl || pSViewMsgGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSViewMsgGroupBase.getPSSystemName());
        }
        if (pSViewMsgGroupBase.isPSViewMsgGroupIdDirty() && (bl || pSViewMsgGroupBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        }
        if (pSViewMsgGroupBase.isPSViewMsgGroupNameDirty() && (bl || pSViewMsgGroupBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSViewMsgGroupBase.getPSViewMsgGroupName());
        }
        if (pSViewMsgGroupBase.isTopMsgPSSysCssIdDirty() && (bl || pSViewMsgGroupBase.getTopMsgPSSysCssId() != null)) {
            iDataObject.set(FIELD_TOPMSGPSSYSCSSID, (Object)pSViewMsgGroupBase.getTopMsgPSSysCssId());
        }
        if (pSViewMsgGroupBase.isTopMsgPSSysCssNameDirty() && (bl || pSViewMsgGroupBase.getTopMsgPSSysCssName() != null)) {
            iDataObject.set(FIELD_TOPMSGPSSYSCSSNAME, (Object)pSViewMsgGroupBase.getTopMsgPSSysCssName());
        }
        if (pSViewMsgGroupBase.isTopMsgStyleDirty() && (bl || pSViewMsgGroupBase.getTopMsgStyle() != null)) {
            iDataObject.set(FIELD_TOPMSGSTYLE, (Object)pSViewMsgGroupBase.getTopMsgStyle());
        }
        if (pSViewMsgGroupBase.isUpdateDateDirty() && (bl || pSViewMsgGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewMsgGroupBase.getUpdateDate());
        }
        if (pSViewMsgGroupBase.isUpdateManDirty() && (bl || pSViewMsgGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewMsgGroupBase.getUpdateMan());
        }
        if (pSViewMsgGroupBase.isUserCatDirty() && (bl || pSViewMsgGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewMsgGroupBase.getUserCat());
        }
        if (pSViewMsgGroupBase.isUserParamsDirty() && (bl || pSViewMsgGroupBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSViewMsgGroupBase.getUserParams());
        }
        if (pSViewMsgGroupBase.isUserTagDirty() && (bl || pSViewMsgGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewMsgGroupBase.getUserTag());
        }
        if (pSViewMsgGroupBase.isUserTag2Dirty() && (bl || pSViewMsgGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewMsgGroupBase.getUserTag2());
        }
        if (pSViewMsgGroupBase.isUserTag3Dirty() && (bl || pSViewMsgGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewMsgGroupBase.getUserTag3());
        }
        if (pSViewMsgGroupBase.isUserTag4Dirty() && (bl || pSViewMsgGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewMsgGroupBase.getUserTag4());
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
        return PSViewMsgGroupBase.remove(this, n);
    }

    private static boolean remove(PSViewMsgGroupBase pSViewMsgGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgGroupBase.resetBodyMsgPSSysCssId();
                return true;
            }
            case 1: {
                pSViewMsgGroupBase.resetBodyMsgPSSysCssName();
                return true;
            }
            case 2: {
                pSViewMsgGroupBase.resetBodyMsgStyle();
                return true;
            }
            case 3: {
                pSViewMsgGroupBase.resetBottomMsgPSSysCssId();
                return true;
            }
            case 4: {
                pSViewMsgGroupBase.resetBottomMsgPSSysCssName();
                return true;
            }
            case 5: {
                pSViewMsgGroupBase.resetBottomMsgStyle();
                return true;
            }
            case 6: {
                pSViewMsgGroupBase.resetCodeName();
                return true;
            }
            case 7: {
                pSViewMsgGroupBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSViewMsgGroupBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSViewMsgGroupBase.resetDynamicMode();
                return true;
            }
            case 10: {
                pSViewMsgGroupBase.resetLockFlag();
                return true;
            }
            case 11: {
                pSViewMsgGroupBase.resetMemo();
                return true;
            }
            case 12: {
                pSViewMsgGroupBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSViewMsgGroupBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSViewMsgGroupBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSViewMsgGroupBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSViewMsgGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSViewMsgGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSViewMsgGroupBase.resetPSSystemId();
                return true;
            }
            case 19: {
                pSViewMsgGroupBase.resetPSSystemName();
                return true;
            }
            case 20: {
                pSViewMsgGroupBase.resetPSViewMsgGroupId();
                return true;
            }
            case 21: {
                pSViewMsgGroupBase.resetPSViewMsgGroupName();
                return true;
            }
            case 22: {
                pSViewMsgGroupBase.resetTopMsgPSSysCssId();
                return true;
            }
            case 23: {
                pSViewMsgGroupBase.resetTopMsgPSSysCssName();
                return true;
            }
            case 24: {
                pSViewMsgGroupBase.resetTopMsgStyle();
                return true;
            }
            case 25: {
                pSViewMsgGroupBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSViewMsgGroupBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSViewMsgGroupBase.resetUserCat();
                return true;
            }
            case 28: {
                pSViewMsgGroupBase.resetUserParams();
                return true;
            }
            case 29: {
                pSViewMsgGroupBase.resetUserTag();
                return true;
            }
            case 30: {
                pSViewMsgGroupBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSViewMsgGroupBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSViewMsgGroupBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getBodyMsgPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBodyMsgPSSysCss();
        }
        if (this.getBodyMsgPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objBodyMsgPSSysCssLock;
        synchronized (n) {
            if (this.bodymsgpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getBodyMsgPSSysCssId(), (Object)this.bodymsgpssyscss.getPSSysCssId()) != 0L) {
                this.bodymsgpssyscss = null;
            }
            if (this.bodymsgpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getBodyMsgPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.bodymsgpssyscss = pSSysCss;
            }
            return this.bodymsgpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getBottomMsgPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomMsgPSSysCss();
        }
        if (this.getBottomMsgPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objBottomMsgPSSysCssLock;
        synchronized (n) {
            if (this.bottommsgpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getBottomMsgPSSysCssId(), (Object)this.bottommsgpssyscss.getPSSysCssId()) != 0L) {
                this.bottommsgpssyscss = null;
            }
            if (this.bottommsgpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getBottomMsgPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.bottommsgpssyscss = pSSysCss;
            }
            return this.bottommsgpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getTopMsgPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopMsgPSSysCss();
        }
        if (this.getTopMsgPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objTopMsgPSSysCssLock;
        synchronized (n) {
            if (this.topmsgpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getTopMsgPSSysCssId(), (Object)this.topmsgpssyscss.getPSSysCssId()) != 0L) {
                this.topmsgpssyscss = null;
            }
            if (this.topmsgpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getTopMsgPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.topmsgpssyscss = pSSysCss;
            }
            return this.topmsgpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewMsgGrpDetail> getPSViewMsgGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGrpDetails();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewMsgGrpDetailsLock;
        synchronized (n) {
            if (this.psviewmsggrpdetails == null) {
                this.psviewmsggrpdetails = pSViewMsgGroupService.isTempData(this) ? pSViewMsgGrpDetailService.selectTempByPSViewMsgGroup(this) : pSViewMsgGrpDetailService.selectByPSViewMsgGroup(this);
            }
            return this.psviewmsggrpdetails;
        }
    }

    private PSViewMsgGroupBase getProxyEntity() {
        return this.proxyPSViewMsgGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewMsgGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewMsgGroupBase) {
            this.proxyPSViewMsgGroupBase = (PSViewMsgGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BODYMSGPSSYSCSSID, 0);
        fieldIndexMap.put(FIELD_BODYMSGPSSYSCSSNAME, 1);
        fieldIndexMap.put(FIELD_BODYMSGSTYLE, 2);
        fieldIndexMap.put(FIELD_BOTTOMMSGPSSYSCSSID, 3);
        fieldIndexMap.put(FIELD_BOTTOMMSGPSSYSCSSNAME, 4);
        fieldIndexMap.put(FIELD_BOTTOMMSGSTYLE, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_DYNAMICMODE, 9);
        fieldIndexMap.put(FIELD_LOCKFLAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 19);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 20);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 21);
        fieldIndexMap.put(FIELD_TOPMSGPSSYSCSSID, 22);
        fieldIndexMap.put(FIELD_TOPMSGPSSYSCSSNAME, 23);
        fieldIndexMap.put(FIELD_TOPMSGSTYLE, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USERCAT, 27);
        fieldIndexMap.put(FIELD_USERPARAMS, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
    }
}

