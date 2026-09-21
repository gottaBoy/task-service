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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysLicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysLicBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURACTIVESYSCNT = "CURACTIVESYSCNT";
    public static final String FIELD_CURSYSCNT = "CURSYSCNT";
    public static final String FIELD_CURTOTALENTITYCNT = "CURTOTALENTITYCNT";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MAXACTIVESYSCNT = "MAXACTIVESYSCNT";
    public static final String FIELD_MAXDEFCNTPERDE = "MAXDEFCNTPERDE";
    public static final String FIELD_MAXENTITYCNT = "MAXENTITYCNT";
    public static final String FIELD_MAXMOBAPPCNT = "MAXMOBAPPCNT";
    public static final String FIELD_MAXPROCCNTPERWF = "MAXPROCCNTPERWF";
    public static final String FIELD_MAXSFPUBCNT = "MAXSFPUBCNT";
    public static final String FIELD_MAXSYSCNT = "MAXSYSCNT";
    public static final String FIELD_MAXTOTALENTITYCNT = "MAXTOTALENTITYCNT";
    public static final String FIELD_MAXWEBAPPCNT = "MAXWEBAPPCNT";
    public static final String FIELD_MAXWFCNT = "MAXWFCNT";
    public static final String FIELD_PSDCSYSLICID = "PSDCSYSLICID";
    public static final String FIELD_PSDCSYSLICNAME = "PSDCSYSLICNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_TEMPLFLAG = "TEMPLFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CURACTIVESYSCNT = 3;
    private static final int INDEX_CURSYSCNT = 4;
    private static final int INDEX_CURTOTALENTITYCNT = 5;
    private static final int INDEX_DEFAULTFLAG = 6;
    private static final int INDEX_ENDTIME = 7;
    private static final int INDEX_MAXACTIVESYSCNT = 8;
    private static final int INDEX_MAXDEFCNTPERDE = 9;
    private static final int INDEX_MAXENTITYCNT = 10;
    private static final int INDEX_MAXMOBAPPCNT = 11;
    private static final int INDEX_MAXPROCCNTPERWF = 12;
    private static final int INDEX_MAXSFPUBCNT = 13;
    private static final int INDEX_MAXSYSCNT = 14;
    private static final int INDEX_MAXTOTALENTITYCNT = 15;
    private static final int INDEX_MAXWEBAPPCNT = 16;
    private static final int INDEX_MAXWFCNT = 17;
    private static final int INDEX_PSDCSYSLICID = 18;
    private static final int INDEX_PSDCSYSLICNAME = 19;
    private static final int INDEX_PSDEVCENTERID = 20;
    private static final int INDEX_PSDEVCENTERNAME = 21;
    private static final int INDEX_TEMPLFLAG = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysLicBase proxyPSDCSysLicBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curactivesyscntDirtyFlag = false;
    private boolean cursyscntDirtyFlag = false;
    private boolean curtotalentitycntDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean maxactivesyscntDirtyFlag = false;
    private boolean maxdefcntperdeDirtyFlag = false;
    private boolean maxentitycntDirtyFlag = false;
    private boolean maxmobappcntDirtyFlag = false;
    private boolean maxproccntperwfDirtyFlag = false;
    private boolean maxsfpubcntDirtyFlag = false;
    private boolean maxsyscntDirtyFlag = false;
    private boolean maxtotalentitycntDirtyFlag = false;
    private boolean maxwebappcntDirtyFlag = false;
    private boolean maxwfcntDirtyFlag = false;
    private boolean psdcsyslicidDirtyFlag = false;
    private boolean psdcsyslicnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean templflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curactivesyscnt")
    private Integer curactivesyscnt;
    @Column(name="cursyscnt")
    private Integer cursyscnt;
    @Column(name="curtotalentitycnt")
    private Integer curtotalentitycnt;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="maxactivesyscnt")
    private Integer maxactivesyscnt;
    @Column(name="maxdefcntperde")
    private Integer maxdefcntperde;
    @Column(name="maxentitycnt")
    private Integer maxentitycnt;
    @Column(name="maxmobappcnt")
    private Integer maxmobappcnt;
    @Column(name="maxproccntperwf")
    private Integer maxproccntperwf;
    @Column(name="maxsfpubcnt")
    private Integer maxsfpubcnt;
    @Column(name="maxsyscnt")
    private Integer maxsyscnt;
    @Column(name="maxtotalentitycnt")
    private Integer maxtotalentitycnt;
    @Column(name="maxwebappcnt")
    private Integer maxwebappcnt;
    @Column(name="maxwfcnt")
    private Integer maxwfcnt;
    @Column(name="psdcsyslicid")
    private String psdcsyslicid;
    @Column(name="psdcsyslicname")
    private String psdcsyslicname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="templflag")
    private Integer templflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysesLock = new Integer(1);
    private ArrayList<PSDevSlnSys> psdevslnsyses = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setCurActiveSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurActiveSysCnt(n);
            return;
        }
        this.curactivesyscnt = n;
        this.curactivesyscntDirtyFlag = true;
    }

    public Integer getCurActiveSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurActiveSysCnt();
        }
        return this.curactivesyscnt;
    }

    public boolean isCurActiveSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActiveSysCntDirty();
        }
        return this.curactivesyscntDirtyFlag;
    }

    public void resetCurActiveSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurActiveSysCnt();
            return;
        }
        this.curactivesyscntDirtyFlag = false;
        this.curactivesyscnt = null;
    }

    public void setCurSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurSysCnt(n);
            return;
        }
        this.cursyscnt = n;
        this.cursyscntDirtyFlag = true;
    }

    public Integer getCurSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurSysCnt();
        }
        return this.cursyscnt;
    }

    public boolean isCurSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurSysCntDirty();
        }
        return this.cursyscntDirtyFlag;
    }

    public void resetCurSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurSysCnt();
            return;
        }
        this.cursyscntDirtyFlag = false;
        this.cursyscnt = null;
    }

    public void setCurTotalEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurTotalEntityCnt(n);
            return;
        }
        this.curtotalentitycnt = n;
        this.curtotalentitycntDirtyFlag = true;
    }

    public Integer getCurTotalEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurTotalEntityCnt();
        }
        return this.curtotalentitycnt;
    }

    public boolean isCurTotalEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurTotalEntityCntDirty();
        }
        return this.curtotalentitycntDirtyFlag;
    }

    public void resetCurTotalEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurTotalEntityCnt();
            return;
        }
        this.curtotalentitycntDirtyFlag = false;
        this.curtotalentitycnt = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setMaxActiveSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxActiveSysCnt(n);
            return;
        }
        this.maxactivesyscnt = n;
        this.maxactivesyscntDirtyFlag = true;
    }

    public Integer getMaxActiveSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxActiveSysCnt();
        }
        return this.maxactivesyscnt;
    }

    public boolean isMaxActiveSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxActiveSysCntDirty();
        }
        return this.maxactivesyscntDirtyFlag;
    }

    public void resetMaxActiveSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxActiveSysCnt();
            return;
        }
        this.maxactivesyscntDirtyFlag = false;
        this.maxactivesyscnt = null;
    }

    public void setMaxDEFCntPerDE(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDEFCntPerDE(n);
            return;
        }
        this.maxdefcntperde = n;
        this.maxdefcntperdeDirtyFlag = true;
    }

    public Integer getMaxDEFCntPerDE() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDEFCntPerDE();
        }
        return this.maxdefcntperde;
    }

    public boolean isMaxDEFCntPerDEDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDEFCntPerDEDirty();
        }
        return this.maxdefcntperdeDirtyFlag;
    }

    public void resetMaxDEFCntPerDE() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDEFCntPerDE();
            return;
        }
        this.maxdefcntperdeDirtyFlag = false;
        this.maxdefcntperde = null;
    }

    public void setMaxEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEntityCnt(n);
            return;
        }
        this.maxentitycnt = n;
        this.maxentitycntDirtyFlag = true;
    }

    public Integer getMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEntityCnt();
        }
        return this.maxentitycnt;
    }

    public boolean isMaxEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEntityCntDirty();
        }
        return this.maxentitycntDirtyFlag;
    }

    public void resetMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEntityCnt();
            return;
        }
        this.maxentitycntDirtyFlag = false;
        this.maxentitycnt = null;
    }

    public void setMaxMobAppCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMobAppCnt(n);
            return;
        }
        this.maxmobappcnt = n;
        this.maxmobappcntDirtyFlag = true;
    }

    public Integer getMaxMobAppCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMobAppCnt();
        }
        return this.maxmobappcnt;
    }

    public boolean isMaxMobAppCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMobAppCntDirty();
        }
        return this.maxmobappcntDirtyFlag;
    }

    public void resetMaxMobAppCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMobAppCnt();
            return;
        }
        this.maxmobappcntDirtyFlag = false;
        this.maxmobappcnt = null;
    }

    public void setMaxProcCntPerWF(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxProcCntPerWF(n);
            return;
        }
        this.maxproccntperwf = n;
        this.maxproccntperwfDirtyFlag = true;
    }

    public Integer getMaxProcCntPerWF() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxProcCntPerWF();
        }
        return this.maxproccntperwf;
    }

    public boolean isMaxProcCntPerWFDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxProcCntPerWFDirty();
        }
        return this.maxproccntperwfDirtyFlag;
    }

    public void resetMaxProcCntPerWF() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxProcCntPerWF();
            return;
        }
        this.maxproccntperwfDirtyFlag = false;
        this.maxproccntperwf = null;
    }

    public void setMaxSFPubCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSFPubCnt(n);
            return;
        }
        this.maxsfpubcnt = n;
        this.maxsfpubcntDirtyFlag = true;
    }

    public Integer getMaxSFPubCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxSFPubCnt();
        }
        return this.maxsfpubcnt;
    }

    public boolean isMaxSFPubCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxSFPubCntDirty();
        }
        return this.maxsfpubcntDirtyFlag;
    }

    public void resetMaxSFPubCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxSFPubCnt();
            return;
        }
        this.maxsfpubcntDirtyFlag = false;
        this.maxsfpubcnt = null;
    }

    public void setMaxSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSysCnt(n);
            return;
        }
        this.maxsyscnt = n;
        this.maxsyscntDirtyFlag = true;
    }

    public Integer getMaxSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxSysCnt();
        }
        return this.maxsyscnt;
    }

    public boolean isMaxSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxSysCntDirty();
        }
        return this.maxsyscntDirtyFlag;
    }

    public void resetMaxSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxSysCnt();
            return;
        }
        this.maxsyscntDirtyFlag = false;
        this.maxsyscnt = null;
    }

    public void setMaxTotalEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxTotalEntityCnt(n);
            return;
        }
        this.maxtotalentitycnt = n;
        this.maxtotalentitycntDirtyFlag = true;
    }

    public Integer getMaxTotalEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxTotalEntityCnt();
        }
        return this.maxtotalentitycnt;
    }

    public boolean isMaxTotalEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxTotalEntityCntDirty();
        }
        return this.maxtotalentitycntDirtyFlag;
    }

    public void resetMaxTotalEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxTotalEntityCnt();
            return;
        }
        this.maxtotalentitycntDirtyFlag = false;
        this.maxtotalentitycnt = null;
    }

    public void setMaxWebAppCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxWebAppCnt(n);
            return;
        }
        this.maxwebappcnt = n;
        this.maxwebappcntDirtyFlag = true;
    }

    public Integer getMaxWebAppCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxWebAppCnt();
        }
        return this.maxwebappcnt;
    }

    public boolean isMaxWebAppCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxWebAppCntDirty();
        }
        return this.maxwebappcntDirtyFlag;
    }

    public void resetMaxWebAppCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxWebAppCnt();
            return;
        }
        this.maxwebappcntDirtyFlag = false;
        this.maxwebappcnt = null;
    }

    public void setMaxWFCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxWFCnt(n);
            return;
        }
        this.maxwfcnt = n;
        this.maxwfcntDirtyFlag = true;
    }

    public Integer getMaxWFCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxWFCnt();
        }
        return this.maxwfcnt;
    }

    public boolean isMaxWFCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxWFCntDirty();
        }
        return this.maxwfcntDirtyFlag;
    }

    public void resetMaxWFCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxWFCnt();
            return;
        }
        this.maxwfcntDirtyFlag = false;
        this.maxwfcnt = null;
    }

    public void setPSDCSysLicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysLicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyslicid = string;
        this.psdcsyslicidDirtyFlag = true;
    }

    public String getPSDCSysLicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysLicId();
        }
        return this.psdcsyslicid;
    }

    public boolean isPSDCSysLicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysLicIdDirty();
        }
        return this.psdcsyslicidDirtyFlag;
    }

    public void resetPSDCSysLicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysLicId();
            return;
        }
        this.psdcsyslicidDirtyFlag = false;
        this.psdcsyslicid = null;
    }

    public void setPSDCSysLicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysLicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyslicname = string;
        this.psdcsyslicnameDirtyFlag = true;
    }

    public String getPSDCSysLicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysLicName();
        }
        return this.psdcsyslicname;
    }

    public boolean isPSDCSysLicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysLicNameDirty();
        }
        return this.psdcsyslicnameDirtyFlag;
    }

    public void resetPSDCSysLicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysLicName();
            return;
        }
        this.psdcsyslicnameDirtyFlag = false;
        this.psdcsyslicname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setTemplFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplFlag(n);
            return;
        }
        this.templflag = n;
        this.templflagDirtyFlag = true;
    }

    public Integer getTemplFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplFlag();
        }
        return this.templflag;
    }

    public boolean isTemplFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplFlagDirty();
        }
        return this.templflagDirtyFlag;
    }

    public void resetTemplFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplFlag();
            return;
        }
        this.templflagDirtyFlag = false;
        this.templflag = null;
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

    protected void onReset() {
        PSDCSysLicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysLicBase pSDCSysLicBase) {
        pSDCSysLicBase.resetBeginTime();
        pSDCSysLicBase.resetCreateDate();
        pSDCSysLicBase.resetCreateMan();
        pSDCSysLicBase.resetCurActiveSysCnt();
        pSDCSysLicBase.resetCurSysCnt();
        pSDCSysLicBase.resetCurTotalEntityCnt();
        pSDCSysLicBase.resetDefaultFlag();
        pSDCSysLicBase.resetEndTime();
        pSDCSysLicBase.resetMaxActiveSysCnt();
        pSDCSysLicBase.resetMaxDEFCntPerDE();
        pSDCSysLicBase.resetMaxEntityCnt();
        pSDCSysLicBase.resetMaxMobAppCnt();
        pSDCSysLicBase.resetMaxProcCntPerWF();
        pSDCSysLicBase.resetMaxSFPubCnt();
        pSDCSysLicBase.resetMaxSysCnt();
        pSDCSysLicBase.resetMaxTotalEntityCnt();
        pSDCSysLicBase.resetMaxWebAppCnt();
        pSDCSysLicBase.resetMaxWFCnt();
        pSDCSysLicBase.resetPSDCSysLicId();
        pSDCSysLicBase.resetPSDCSysLicName();
        pSDCSysLicBase.resetPSDevCenterId();
        pSDCSysLicBase.resetPSDevCenterName();
        pSDCSysLicBase.resetTemplFlag();
        pSDCSysLicBase.resetUpdateDate();
        pSDCSysLicBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurActiveSysCntDirty()) {
            hashMap.put(FIELD_CURACTIVESYSCNT, this.getCurActiveSysCnt());
        }
        if (!bl || this.isCurSysCntDirty()) {
            hashMap.put(FIELD_CURSYSCNT, this.getCurSysCnt());
        }
        if (!bl || this.isCurTotalEntityCntDirty()) {
            hashMap.put(FIELD_CURTOTALENTITYCNT, this.getCurTotalEntityCnt());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMaxActiveSysCntDirty()) {
            hashMap.put(FIELD_MAXACTIVESYSCNT, this.getMaxActiveSysCnt());
        }
        if (!bl || this.isMaxDEFCntPerDEDirty()) {
            hashMap.put(FIELD_MAXDEFCNTPERDE, this.getMaxDEFCntPerDE());
        }
        if (!bl || this.isMaxEntityCntDirty()) {
            hashMap.put(FIELD_MAXENTITYCNT, this.getMaxEntityCnt());
        }
        if (!bl || this.isMaxMobAppCntDirty()) {
            hashMap.put(FIELD_MAXMOBAPPCNT, this.getMaxMobAppCnt());
        }
        if (!bl || this.isMaxProcCntPerWFDirty()) {
            hashMap.put(FIELD_MAXPROCCNTPERWF, this.getMaxProcCntPerWF());
        }
        if (!bl || this.isMaxSFPubCntDirty()) {
            hashMap.put(FIELD_MAXSFPUBCNT, this.getMaxSFPubCnt());
        }
        if (!bl || this.isMaxSysCntDirty()) {
            hashMap.put(FIELD_MAXSYSCNT, this.getMaxSysCnt());
        }
        if (!bl || this.isMaxTotalEntityCntDirty()) {
            hashMap.put(FIELD_MAXTOTALENTITYCNT, this.getMaxTotalEntityCnt());
        }
        if (!bl || this.isMaxWebAppCntDirty()) {
            hashMap.put(FIELD_MAXWEBAPPCNT, this.getMaxWebAppCnt());
        }
        if (!bl || this.isMaxWFCntDirty()) {
            hashMap.put(FIELD_MAXWFCNT, this.getMaxWFCnt());
        }
        if (!bl || this.isPSDCSysLicIdDirty()) {
            hashMap.put(FIELD_PSDCSYSLICID, this.getPSDCSysLicId());
        }
        if (!bl || this.isPSDCSysLicNameDirty()) {
            hashMap.put(FIELD_PSDCSYSLICNAME, this.getPSDCSysLicName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isTemplFlagDirty()) {
            hashMap.put(FIELD_TEMPLFLAG, this.getTemplFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCSysLicBase.get(this, n);
    }

    private static Object get(PSDCSysLicBase pSDCSysLicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysLicBase.getBeginTime();
            }
            case 1: {
                return pSDCSysLicBase.getCreateDate();
            }
            case 2: {
                return pSDCSysLicBase.getCreateMan();
            }
            case 3: {
                return pSDCSysLicBase.getCurActiveSysCnt();
            }
            case 4: {
                return pSDCSysLicBase.getCurSysCnt();
            }
            case 5: {
                return pSDCSysLicBase.getCurTotalEntityCnt();
            }
            case 6: {
                return pSDCSysLicBase.getDefaultFlag();
            }
            case 7: {
                return pSDCSysLicBase.getEndTime();
            }
            case 8: {
                return pSDCSysLicBase.getMaxActiveSysCnt();
            }
            case 9: {
                return pSDCSysLicBase.getMaxDEFCntPerDE();
            }
            case 10: {
                return pSDCSysLicBase.getMaxEntityCnt();
            }
            case 11: {
                return pSDCSysLicBase.getMaxMobAppCnt();
            }
            case 12: {
                return pSDCSysLicBase.getMaxProcCntPerWF();
            }
            case 13: {
                return pSDCSysLicBase.getMaxSFPubCnt();
            }
            case 14: {
                return pSDCSysLicBase.getMaxSysCnt();
            }
            case 15: {
                return pSDCSysLicBase.getMaxTotalEntityCnt();
            }
            case 16: {
                return pSDCSysLicBase.getMaxWebAppCnt();
            }
            case 17: {
                return pSDCSysLicBase.getMaxWFCnt();
            }
            case 18: {
                return pSDCSysLicBase.getPSDCSysLicId();
            }
            case 19: {
                return pSDCSysLicBase.getPSDCSysLicName();
            }
            case 20: {
                return pSDCSysLicBase.getPSDevCenterId();
            }
            case 21: {
                return pSDCSysLicBase.getPSDevCenterName();
            }
            case 22: {
                return pSDCSysLicBase.getTemplFlag();
            }
            case 23: {
                return pSDCSysLicBase.getUpdateDate();
            }
            case 24: {
                return pSDCSysLicBase.getUpdateMan();
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
        PSDCSysLicBase.set(this, n, object);
    }

    private static void set(PSDCSysLicBase pSDCSysLicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysLicBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysLicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysLicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysLicBase.setCurActiveSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysLicBase.setCurSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysLicBase.setCurTotalEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysLicBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysLicBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysLicBase.setMaxActiveSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysLicBase.setMaxDEFCntPerDE(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysLicBase.setMaxEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysLicBase.setMaxMobAppCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDCSysLicBase.setMaxProcCntPerWF(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDCSysLicBase.setMaxSFPubCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDCSysLicBase.setMaxSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDCSysLicBase.setMaxTotalEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCSysLicBase.setMaxWebAppCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDCSysLicBase.setMaxWFCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDCSysLicBase.setPSDCSysLicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSysLicBase.setPSDCSysLicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCSysLicBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCSysLicBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCSysLicBase.setTemplFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCSysLicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDCSysLicBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysLicBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysLicBase pSDCSysLicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysLicBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCSysLicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCSysLicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCSysLicBase.getCurActiveSysCnt() == null;
            }
            case 4: {
                return pSDCSysLicBase.getCurSysCnt() == null;
            }
            case 5: {
                return pSDCSysLicBase.getCurTotalEntityCnt() == null;
            }
            case 6: {
                return pSDCSysLicBase.getDefaultFlag() == null;
            }
            case 7: {
                return pSDCSysLicBase.getEndTime() == null;
            }
            case 8: {
                return pSDCSysLicBase.getMaxActiveSysCnt() == null;
            }
            case 9: {
                return pSDCSysLicBase.getMaxDEFCntPerDE() == null;
            }
            case 10: {
                return pSDCSysLicBase.getMaxEntityCnt() == null;
            }
            case 11: {
                return pSDCSysLicBase.getMaxMobAppCnt() == null;
            }
            case 12: {
                return pSDCSysLicBase.getMaxProcCntPerWF() == null;
            }
            case 13: {
                return pSDCSysLicBase.getMaxSFPubCnt() == null;
            }
            case 14: {
                return pSDCSysLicBase.getMaxSysCnt() == null;
            }
            case 15: {
                return pSDCSysLicBase.getMaxTotalEntityCnt() == null;
            }
            case 16: {
                return pSDCSysLicBase.getMaxWebAppCnt() == null;
            }
            case 17: {
                return pSDCSysLicBase.getMaxWFCnt() == null;
            }
            case 18: {
                return pSDCSysLicBase.getPSDCSysLicId() == null;
            }
            case 19: {
                return pSDCSysLicBase.getPSDCSysLicName() == null;
            }
            case 20: {
                return pSDCSysLicBase.getPSDevCenterId() == null;
            }
            case 21: {
                return pSDCSysLicBase.getPSDevCenterName() == null;
            }
            case 22: {
                return pSDCSysLicBase.getTemplFlag() == null;
            }
            case 23: {
                return pSDCSysLicBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDCSysLicBase.getUpdateMan() == null;
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
        return PSDCSysLicBase.contains(this, n);
    }

    private static boolean contains(PSDCSysLicBase pSDCSysLicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysLicBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCSysLicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCSysLicBase.isCreateManDirty();
            }
            case 3: {
                return pSDCSysLicBase.isCurActiveSysCntDirty();
            }
            case 4: {
                return pSDCSysLicBase.isCurSysCntDirty();
            }
            case 5: {
                return pSDCSysLicBase.isCurTotalEntityCntDirty();
            }
            case 6: {
                return pSDCSysLicBase.isDefaultFlagDirty();
            }
            case 7: {
                return pSDCSysLicBase.isEndTimeDirty();
            }
            case 8: {
                return pSDCSysLicBase.isMaxActiveSysCntDirty();
            }
            case 9: {
                return pSDCSysLicBase.isMaxDEFCntPerDEDirty();
            }
            case 10: {
                return pSDCSysLicBase.isMaxEntityCntDirty();
            }
            case 11: {
                return pSDCSysLicBase.isMaxMobAppCntDirty();
            }
            case 12: {
                return pSDCSysLicBase.isMaxProcCntPerWFDirty();
            }
            case 13: {
                return pSDCSysLicBase.isMaxSFPubCntDirty();
            }
            case 14: {
                return pSDCSysLicBase.isMaxSysCntDirty();
            }
            case 15: {
                return pSDCSysLicBase.isMaxTotalEntityCntDirty();
            }
            case 16: {
                return pSDCSysLicBase.isMaxWebAppCntDirty();
            }
            case 17: {
                return pSDCSysLicBase.isMaxWFCntDirty();
            }
            case 18: {
                return pSDCSysLicBase.isPSDCSysLicIdDirty();
            }
            case 19: {
                return pSDCSysLicBase.isPSDCSysLicNameDirty();
            }
            case 20: {
                return pSDCSysLicBase.isPSDevCenterIdDirty();
            }
            case 21: {
                return pSDCSysLicBase.isPSDevCenterNameDirty();
            }
            case 22: {
                return pSDCSysLicBase.isTemplFlagDirty();
            }
            case 23: {
                return pSDCSysLicBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDCSysLicBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysLicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysLicBase pSDCSysLicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysLicBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getCurActiveSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curactivesyscnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getCurActiveSysCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getCurSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cursyscnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getCurSysCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getCurTotalEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curtotalentitycnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getCurTotalEntityCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxActiveSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxactivesyscnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxActiveSysCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxDEFCntPerDE() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdefcntperde", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxDEFCntPerDE()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxentitycnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxEntityCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxMobAppCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmobappcnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxMobAppCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxProcCntPerWF() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxproccntperwf", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxProcCntPerWF()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxSFPubCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsfpubcnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxSFPubCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsyscnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxSysCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxTotalEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxtotalentitycnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxTotalEntityCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxWebAppCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxwebappcnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxWebAppCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getMaxWFCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxwfcnt", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getMaxWFCnt()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getPSDCSysLicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyslicid", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getPSDCSysLicId()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getPSDCSysLicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyslicname", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getPSDCSysLicName()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getTemplFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templflag", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getTemplFlag()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysLicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysLicBase.getJSONValue((Object)pSDCSysLicBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysLicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysLicBase pSDCSysLicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysLicBase.getBeginTime() != null) {
            object = pSDCSysLicBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysLicBase.getCreateDate() != null) {
            object = pSDCSysLicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysLicBase.getCreateMan() != null) {
            object = pSDCSysLicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysLicBase.getCurActiveSysCnt() != null) {
            object = pSDCSysLicBase.getCurActiveSysCnt();
            xmlNode.setAttribute(FIELD_CURACTIVESYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getCurSysCnt() != null) {
            object = pSDCSysLicBase.getCurSysCnt();
            xmlNode.setAttribute(FIELD_CURSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getCurTotalEntityCnt() != null) {
            object = pSDCSysLicBase.getCurTotalEntityCnt();
            xmlNode.setAttribute(FIELD_CURTOTALENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getDefaultFlag() != null) {
            object = pSDCSysLicBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getEndTime() != null) {
            object = pSDCSysLicBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxActiveSysCnt() != null) {
            object = pSDCSysLicBase.getMaxActiveSysCnt();
            xmlNode.setAttribute(FIELD_MAXACTIVESYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxDEFCntPerDE() != null) {
            object = pSDCSysLicBase.getMaxDEFCntPerDE();
            xmlNode.setAttribute(FIELD_MAXDEFCNTPERDE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxEntityCnt() != null) {
            object = pSDCSysLicBase.getMaxEntityCnt();
            xmlNode.setAttribute(FIELD_MAXENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxMobAppCnt() != null) {
            object = pSDCSysLicBase.getMaxMobAppCnt();
            xmlNode.setAttribute(FIELD_MAXMOBAPPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxProcCntPerWF() != null) {
            object = pSDCSysLicBase.getMaxProcCntPerWF();
            xmlNode.setAttribute(FIELD_MAXPROCCNTPERWF, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxSFPubCnt() != null) {
            object = pSDCSysLicBase.getMaxSFPubCnt();
            xmlNode.setAttribute(FIELD_MAXSFPUBCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxSysCnt() != null) {
            object = pSDCSysLicBase.getMaxSysCnt();
            xmlNode.setAttribute(FIELD_MAXSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxTotalEntityCnt() != null) {
            object = pSDCSysLicBase.getMaxTotalEntityCnt();
            xmlNode.setAttribute(FIELD_MAXTOTALENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxWebAppCnt() != null) {
            object = pSDCSysLicBase.getMaxWebAppCnt();
            xmlNode.setAttribute(FIELD_MAXWEBAPPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getMaxWFCnt() != null) {
            object = pSDCSysLicBase.getMaxWFCnt();
            xmlNode.setAttribute(FIELD_MAXWFCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getPSDCSysLicId() != null) {
            object = pSDCSysLicBase.getPSDCSysLicId();
            xmlNode.setAttribute(FIELD_PSDCSYSLICID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysLicBase.getPSDCSysLicName() != null) {
            object = pSDCSysLicBase.getPSDCSysLicName();
            xmlNode.setAttribute(FIELD_PSDCSYSLICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysLicBase.getPSDevCenterId() != null) {
            object = pSDCSysLicBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysLicBase.getPSDevCenterName() != null) {
            object = pSDCSysLicBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysLicBase.getTemplFlag() != null) {
            object = pSDCSysLicBase.getTemplFlag();
            xmlNode.setAttribute(FIELD_TEMPLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSysLicBase.getUpdateDate() != null) {
            object = pSDCSysLicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysLicBase.getUpdateMan() != null) {
            object = pSDCSysLicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysLicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysLicBase pSDCSysLicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysLicBase.isBeginTimeDirty() && (bl || pSDCSysLicBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCSysLicBase.getBeginTime());
        }
        if (pSDCSysLicBase.isCreateDateDirty() && (bl || pSDCSysLicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysLicBase.getCreateDate());
        }
        if (pSDCSysLicBase.isCreateManDirty() && (bl || pSDCSysLicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysLicBase.getCreateMan());
        }
        if (pSDCSysLicBase.isCurActiveSysCntDirty() && (bl || pSDCSysLicBase.getCurActiveSysCnt() != null)) {
            iDataObject.set(FIELD_CURACTIVESYSCNT, (Object)pSDCSysLicBase.getCurActiveSysCnt());
        }
        if (pSDCSysLicBase.isCurSysCntDirty() && (bl || pSDCSysLicBase.getCurSysCnt() != null)) {
            iDataObject.set(FIELD_CURSYSCNT, (Object)pSDCSysLicBase.getCurSysCnt());
        }
        if (pSDCSysLicBase.isCurTotalEntityCntDirty() && (bl || pSDCSysLicBase.getCurTotalEntityCnt() != null)) {
            iDataObject.set(FIELD_CURTOTALENTITYCNT, (Object)pSDCSysLicBase.getCurTotalEntityCnt());
        }
        if (pSDCSysLicBase.isDefaultFlagDirty() && (bl || pSDCSysLicBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCSysLicBase.getDefaultFlag());
        }
        if (pSDCSysLicBase.isEndTimeDirty() && (bl || pSDCSysLicBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCSysLicBase.getEndTime());
        }
        if (pSDCSysLicBase.isMaxActiveSysCntDirty() && (bl || pSDCSysLicBase.getMaxActiveSysCnt() != null)) {
            iDataObject.set(FIELD_MAXACTIVESYSCNT, (Object)pSDCSysLicBase.getMaxActiveSysCnt());
        }
        if (pSDCSysLicBase.isMaxDEFCntPerDEDirty() && (bl || pSDCSysLicBase.getMaxDEFCntPerDE() != null)) {
            iDataObject.set(FIELD_MAXDEFCNTPERDE, (Object)pSDCSysLicBase.getMaxDEFCntPerDE());
        }
        if (pSDCSysLicBase.isMaxEntityCntDirty() && (bl || pSDCSysLicBase.getMaxEntityCnt() != null)) {
            iDataObject.set(FIELD_MAXENTITYCNT, (Object)pSDCSysLicBase.getMaxEntityCnt());
        }
        if (pSDCSysLicBase.isMaxMobAppCntDirty() && (bl || pSDCSysLicBase.getMaxMobAppCnt() != null)) {
            iDataObject.set(FIELD_MAXMOBAPPCNT, (Object)pSDCSysLicBase.getMaxMobAppCnt());
        }
        if (pSDCSysLicBase.isMaxProcCntPerWFDirty() && (bl || pSDCSysLicBase.getMaxProcCntPerWF() != null)) {
            iDataObject.set(FIELD_MAXPROCCNTPERWF, (Object)pSDCSysLicBase.getMaxProcCntPerWF());
        }
        if (pSDCSysLicBase.isMaxSFPubCntDirty() && (bl || pSDCSysLicBase.getMaxSFPubCnt() != null)) {
            iDataObject.set(FIELD_MAXSFPUBCNT, (Object)pSDCSysLicBase.getMaxSFPubCnt());
        }
        if (pSDCSysLicBase.isMaxSysCntDirty() && (bl || pSDCSysLicBase.getMaxSysCnt() != null)) {
            iDataObject.set(FIELD_MAXSYSCNT, (Object)pSDCSysLicBase.getMaxSysCnt());
        }
        if (pSDCSysLicBase.isMaxTotalEntityCntDirty() && (bl || pSDCSysLicBase.getMaxTotalEntityCnt() != null)) {
            iDataObject.set(FIELD_MAXTOTALENTITYCNT, (Object)pSDCSysLicBase.getMaxTotalEntityCnt());
        }
        if (pSDCSysLicBase.isMaxWebAppCntDirty() && (bl || pSDCSysLicBase.getMaxWebAppCnt() != null)) {
            iDataObject.set(FIELD_MAXWEBAPPCNT, (Object)pSDCSysLicBase.getMaxWebAppCnt());
        }
        if (pSDCSysLicBase.isMaxWFCntDirty() && (bl || pSDCSysLicBase.getMaxWFCnt() != null)) {
            iDataObject.set(FIELD_MAXWFCNT, (Object)pSDCSysLicBase.getMaxWFCnt());
        }
        if (pSDCSysLicBase.isPSDCSysLicIdDirty() && (bl || pSDCSysLicBase.getPSDCSysLicId() != null)) {
            iDataObject.set(FIELD_PSDCSYSLICID, (Object)pSDCSysLicBase.getPSDCSysLicId());
        }
        if (pSDCSysLicBase.isPSDCSysLicNameDirty() && (bl || pSDCSysLicBase.getPSDCSysLicName() != null)) {
            iDataObject.set(FIELD_PSDCSYSLICNAME, (Object)pSDCSysLicBase.getPSDCSysLicName());
        }
        if (pSDCSysLicBase.isPSDevCenterIdDirty() && (bl || pSDCSysLicBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSysLicBase.getPSDevCenterId());
        }
        if (pSDCSysLicBase.isPSDevCenterNameDirty() && (bl || pSDCSysLicBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSysLicBase.getPSDevCenterName());
        }
        if (pSDCSysLicBase.isTemplFlagDirty() && (bl || pSDCSysLicBase.getTemplFlag() != null)) {
            iDataObject.set(FIELD_TEMPLFLAG, (Object)pSDCSysLicBase.getTemplFlag());
        }
        if (pSDCSysLicBase.isUpdateDateDirty() && (bl || pSDCSysLicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysLicBase.getUpdateDate());
        }
        if (pSDCSysLicBase.isUpdateManDirty() && (bl || pSDCSysLicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysLicBase.getUpdateMan());
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
        return PSDCSysLicBase.remove(this, n);
    }

    private static boolean remove(PSDCSysLicBase pSDCSysLicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysLicBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCSysLicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCSysLicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCSysLicBase.resetCurActiveSysCnt();
                return true;
            }
            case 4: {
                pSDCSysLicBase.resetCurSysCnt();
                return true;
            }
            case 5: {
                pSDCSysLicBase.resetCurTotalEntityCnt();
                return true;
            }
            case 6: {
                pSDCSysLicBase.resetDefaultFlag();
                return true;
            }
            case 7: {
                pSDCSysLicBase.resetEndTime();
                return true;
            }
            case 8: {
                pSDCSysLicBase.resetMaxActiveSysCnt();
                return true;
            }
            case 9: {
                pSDCSysLicBase.resetMaxDEFCntPerDE();
                return true;
            }
            case 10: {
                pSDCSysLicBase.resetMaxEntityCnt();
                return true;
            }
            case 11: {
                pSDCSysLicBase.resetMaxMobAppCnt();
                return true;
            }
            case 12: {
                pSDCSysLicBase.resetMaxProcCntPerWF();
                return true;
            }
            case 13: {
                pSDCSysLicBase.resetMaxSFPubCnt();
                return true;
            }
            case 14: {
                pSDCSysLicBase.resetMaxSysCnt();
                return true;
            }
            case 15: {
                pSDCSysLicBase.resetMaxTotalEntityCnt();
                return true;
            }
            case 16: {
                pSDCSysLicBase.resetMaxWebAppCnt();
                return true;
            }
            case 17: {
                pSDCSysLicBase.resetMaxWFCnt();
                return true;
            }
            case 18: {
                pSDCSysLicBase.resetPSDCSysLicId();
                return true;
            }
            case 19: {
                pSDCSysLicBase.resetPSDCSysLicName();
                return true;
            }
            case 20: {
                pSDCSysLicBase.resetPSDevCenterId();
                return true;
            }
            case 21: {
                pSDCSysLicBase.resetPSDevCenterName();
                return true;
            }
            case 22: {
                pSDCSysLicBase.resetTemplFlag();
                return true;
            }
            case 23: {
                pSDCSysLicBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDCSysLicBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSys> getPSDevSlnSyses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSyses();
        }
        if (this.getPSDCSysLicId() == null) {
            return null;
        }
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysesLock;
        synchronized (n) {
            if (this.psdevslnsyses == null) {
                this.psdevslnsyses = pSDevSlnSysService.selectByPSDCSysLic(this);
            }
            return this.psdevslnsyses;
        }
    }

    private PSDCSysLicBase getProxyEntity() {
        return this.proxyPSDCSysLicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysLicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysLicBase) {
            this.proxyPSDCSysLicBase = (PSDCSysLicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CURACTIVESYSCNT, 3);
        fieldIndexMap.put(FIELD_CURSYSCNT, 4);
        fieldIndexMap.put(FIELD_CURTOTALENTITYCNT, 5);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 6);
        fieldIndexMap.put(FIELD_ENDTIME, 7);
        fieldIndexMap.put(FIELD_MAXACTIVESYSCNT, 8);
        fieldIndexMap.put(FIELD_MAXDEFCNTPERDE, 9);
        fieldIndexMap.put(FIELD_MAXENTITYCNT, 10);
        fieldIndexMap.put(FIELD_MAXMOBAPPCNT, 11);
        fieldIndexMap.put(FIELD_MAXPROCCNTPERWF, 12);
        fieldIndexMap.put(FIELD_MAXSFPUBCNT, 13);
        fieldIndexMap.put(FIELD_MAXSYSCNT, 14);
        fieldIndexMap.put(FIELD_MAXTOTALENTITYCNT, 15);
        fieldIndexMap.put(FIELD_MAXWEBAPPCNT, 16);
        fieldIndexMap.put(FIELD_MAXWFCNT, 17);
        fieldIndexMap.put(FIELD_PSDCSYSLICID, 18);
        fieldIndexMap.put(FIELD_PSDCSYSLICNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 21);
        fieldIndexMap.put(FIELD_TEMPLFLAG, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
    }
}

