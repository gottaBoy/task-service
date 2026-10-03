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
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRunSessionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRunSessionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEBUGMODE = "DEBUGMODE";
    public static final String FIELD_ENABLEVC = "ENABLEVC";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FIXDBMODEL = "FIXDBMODEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PACKMODE = "PACKMODE";
    public static final String FIELD_PSDEVSLNMSDEPAPIID = "PSDEVSLNMSDEPAPIID";
    public static final String FIELD_PSDEVSLNMSDEPAPINAME = "PSDEVSLNMSDEPAPINAME";
    public static final String FIELD_PSDEVSLNMSDEPAPPID = "PSDEVSLNMSDEPAPPID";
    public static final String FIELD_PSDEVSLNMSDEPAPPNAME = "PSDEVSLNMSDEPAPPNAME";
    public static final String FIELD_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String FIELD_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPID2 = "PSSYSAPPID2";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSAPPNAME2 = "PSSYSAPPNAME2";
    public static final String FIELD_PSSYSBDINSTCFGID = "PSSYSBDINSTCFGID";
    public static final String FIELD_PSSYSBDINSTCFGNAME = "PSSYSBDINSTCFGNAME";
    public static final String FIELD_PSSYSRUNSESSIONID = "PSSYSRUNSESSIONID";
    public static final String FIELD_PSSYSRUNSESSIONNAME = "PSSYSRUNSESSIONNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String FIELD_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_QUICKMODE = "QUICKMODE";
    public static final String FIELD_REBUILDMODE = "REBUILDMODE";
    public static final String FIELD_RUNMODE = "RUNMODE";
    public static final String FIELD_RUNPARAM = "RUNPARAM";
    public static final String FIELD_RUNPARAM10 = "RUNPARAM10";
    public static final String FIELD_RUNPARAM11 = "RUNPARAM11";
    public static final String FIELD_RUNPARAM12 = "RUNPARAM12";
    public static final String FIELD_RUNPARAM2 = "RUNPARAM2";
    public static final String FIELD_RUNPARAM3 = "RUNPARAM3";
    public static final String FIELD_RUNPARAM4 = "RUNPARAM4";
    public static final String FIELD_RUNPARAM5 = "RUNPARAM5";
    public static final String FIELD_RUNPARAM6 = "RUNPARAM6";
    public static final String FIELD_RUNPARAM7 = "RUNPARAM7";
    public static final String FIELD_RUNPARAM8 = "RUNPARAM8";
    public static final String FIELD_RUNPARAM9 = "RUNPARAM9";
    public static final String FIELD_RUNPSSYSDYNAMODELID = "RUNPSSYSDYNAMODELID";
    public static final String FIELD_RUNPSSYSDYNAMODELNAME = "RUNPSSYSDYNAMODELNAME";
    public static final String FIELD_RUNSTATE = "RUNSTATE";
    public static final String FIELD_SRCPSSYSDMVERID = "SRCPSSYSDMVERID";
    public static final String FIELD_SRCPSSYSDMVERNAME = "SRCPSSYSDMVERNAME";
    public static final String FIELD_STARTTIME = "STARTTIME";
    public static final String FIELD_STOPWHENTEMPLERROR = "STOPWHENTEMPLERROR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEBUGMODE = 2;
    private static final int INDEX_ENABLEVC = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_FIXDBMODEL = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PACKMODE = 7;
    private static final int INDEX_PSDEVSLNMSDEPAPIID = 8;
    private static final int INDEX_PSDEVSLNMSDEPAPINAME = 9;
    private static final int INDEX_PSDEVSLNMSDEPAPPID = 10;
    private static final int INDEX_PSDEVSLNMSDEPAPPNAME = 11;
    private static final int INDEX_PSDEVSLNMSDEPFUNCID = 12;
    private static final int INDEX_PSDEVSLNMSDEPFUNCNAME = 13;
    private static final int INDEX_PSDSCONSOLEID = 14;
    private static final int INDEX_PSDYNAINSTID = 15;
    private static final int INDEX_PSMOBAPPPACKID = 16;
    private static final int INDEX_PSMOBAPPPACKNAME = 17;
    private static final int INDEX_PSSYSAPPID = 18;
    private static final int INDEX_PSSYSAPPID2 = 19;
    private static final int INDEX_PSSYSAPPNAME = 20;
    private static final int INDEX_PSSYSAPPNAME2 = 21;
    private static final int INDEX_PSSYSBDINSTCFGID = 22;
    private static final int INDEX_PSSYSBDINSTCFGNAME = 23;
    private static final int INDEX_PSSYSRUNSESSIONID = 24;
    private static final int INDEX_PSSYSRUNSESSIONNAME = 25;
    private static final int INDEX_PSSYSSERVICEAPIID = 26;
    private static final int INDEX_PSSYSSERVICEAPINAME = 27;
    private static final int INDEX_PSSYSSFPUBID = 28;
    private static final int INDEX_PSSYSSFPUBNAME = 29;
    private static final int INDEX_PSSYSTEMASID = 30;
    private static final int INDEX_PSSYSTEMASNAME = 31;
    private static final int INDEX_PSSYSTEMDBCFGID = 32;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 33;
    private static final int INDEX_PSSYSTEMID = 34;
    private static final int INDEX_PSSYSTEMNAME = 35;
    private static final int INDEX_QUICKMODE = 36;
    private static final int INDEX_REBUILDMODE = 37;
    private static final int INDEX_RUNMODE = 38;
    private static final int INDEX_RUNPARAM = 39;
    private static final int INDEX_RUNPARAM10 = 40;
    private static final int INDEX_RUNPARAM11 = 41;
    private static final int INDEX_RUNPARAM12 = 42;
    private static final int INDEX_RUNPARAM2 = 43;
    private static final int INDEX_RUNPARAM3 = 44;
    private static final int INDEX_RUNPARAM4 = 45;
    private static final int INDEX_RUNPARAM5 = 46;
    private static final int INDEX_RUNPARAM6 = 47;
    private static final int INDEX_RUNPARAM7 = 48;
    private static final int INDEX_RUNPARAM8 = 49;
    private static final int INDEX_RUNPARAM9 = 50;
    private static final int INDEX_RUNPSSYSDYNAMODELID = 51;
    private static final int INDEX_RUNPSSYSDYNAMODELNAME = 52;
    private static final int INDEX_RUNSTATE = 53;
    private static final int INDEX_SRCPSSYSDMVERID = 54;
    private static final int INDEX_SRCPSSYSDMVERNAME = 55;
    private static final int INDEX_STARTTIME = 56;
    private static final int INDEX_STOPWHENTEMPLERROR = 57;
    private static final int INDEX_UPDATEDATE = 58;
    private static final int INDEX_UPDATEMAN = 59;
    private static final int INDEX_USERTAG = 60;
    private static final int INDEX_USERTAG2 = 61;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRunSessionBase proxyPSSysRunSessionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean debugmodeDirtyFlag = false;
    private boolean enablevcDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fixdbmodelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean packmodeDirtyFlag = false;
    private boolean psdevslnmsdepapiidDirtyFlag = false;
    private boolean psdevslnmsdepapinameDirtyFlag = false;
    private boolean psdevslnmsdepappidDirtyFlag = false;
    private boolean psdevslnmsdepappnameDirtyFlag = false;
    private boolean psdevslnmsdepfuncidDirtyFlag = false;
    private boolean psdevslnmsdepfuncnameDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmobapppackidDirtyFlag = false;
    private boolean psmobapppacknameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappid2DirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysappname2DirtyFlag = false;
    private boolean pssysbdinstcfgidDirtyFlag = false;
    private boolean pssysbdinstcfgnameDirtyFlag = false;
    private boolean pssysrunsessionidDirtyFlag = false;
    private boolean pssysrunsessionnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemasidDirtyFlag = false;
    private boolean pssystemasnameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean quickmodeDirtyFlag = false;
    private boolean rebuildmodeDirtyFlag = false;
    private boolean runmodeDirtyFlag = false;
    private boolean runparamDirtyFlag = false;
    private boolean runparam10DirtyFlag = false;
    private boolean runparam11DirtyFlag = false;
    private boolean runparam12DirtyFlag = false;
    private boolean runparam2DirtyFlag = false;
    private boolean runparam3DirtyFlag = false;
    private boolean runparam4DirtyFlag = false;
    private boolean runparam5DirtyFlag = false;
    private boolean runparam6DirtyFlag = false;
    private boolean runparam7DirtyFlag = false;
    private boolean runparam8DirtyFlag = false;
    private boolean runparam9DirtyFlag = false;
    private boolean runpssysdynamodelidDirtyFlag = false;
    private boolean runpssysdynamodelnameDirtyFlag = false;
    private boolean runstateDirtyFlag = false;
    private boolean srcpssysdmveridDirtyFlag = false;
    private boolean srcpssysdmvernameDirtyFlag = false;
    private boolean starttimeDirtyFlag = false;
    private boolean stopwhentemplerrorDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="debugmode")
    private Integer debugmode;
    @Column(name="enablevc")
    private Integer enablevc;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="fixdbmodel")
    private Integer fixdbmodel;
    @Column(name="memo")
    private String memo;
    @Column(name="packmode")
    private String packmode;
    @Column(name="psdevslnmsdepapiid")
    private String psdevslnmsdepapiid;
    @Column(name="psdevslnmsdepapiname")
    private String psdevslnmsdepapiname;
    @Column(name="psdevslnmsdepappid")
    private String psdevslnmsdepappid;
    @Column(name="psdevslnmsdepappname")
    private String psdevslnmsdepappname;
    @Column(name="psdevslnmsdepfuncid")
    private String psdevslnmsdepfuncid;
    @Column(name="psdevslnmsdepfuncname")
    private String psdevslnmsdepfuncname;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmobapppackid")
    private String psmobapppackid;
    @Column(name="psmobapppackname")
    private String psmobapppackname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappid2")
    private String pssysappid2;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysappname2")
    private String pssysappname2;
    @Column(name="pssysbdinstcfgid")
    private String pssysbdinstcfgid;
    @Column(name="pssysbdinstcfgname")
    private String pssysbdinstcfgname;
    @Column(name="pssysrunsessionid")
    private String pssysrunsessionid;
    @Column(name="pssysrunsessionname")
    private String pssysrunsessionname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemasid")
    private String pssystemasid;
    @Column(name="pssystemasname")
    private String pssystemasname;
    @Column(name="pssystemdbcfgid")
    private String pssystemdbcfgid;
    @Column(name="pssystemdbcfgname")
    private String pssystemdbcfgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="quickmode")
    private Integer quickmode;
    @Column(name="rebuildmode")
    private Integer rebuildmode;
    @Column(name="runmode")
    private String runmode;
    @Column(name="runparam")
    private String runparam;
    @Column(name="runparam10")
    private String runparam10;
    @Column(name="runparam11")
    private String runparam11;
    @Column(name="runparam12")
    private String runparam12;
    @Column(name="runparam2")
    private String runparam2;
    @Column(name="runparam3")
    private String runparam3;
    @Column(name="runparam4")
    private String runparam4;
    @Column(name="runparam5")
    private Integer runparam5;
    @Column(name="runparam6")
    private Integer runparam6;
    @Column(name="runparam7")
    private String runparam7;
    @Column(name="runparam8")
    private String runparam8;
    @Column(name="runparam9")
    private String runparam9;
    @Column(name="runpssysdynamodelid")
    private String runpssysdynamodelid;
    @Column(name="runpssysdynamodelname")
    private String runpssysdynamodelname;
    @Column(name="runstate")
    private Integer runstate;
    @Column(name="srcpssysdmverid")
    private String srcpssysdmverid;
    @Column(name="srcpssysdmvername")
    private String srcpssysdmvername;
    @Column(name="starttime")
    private Timestamp starttime;
    @Column(name="stopwhentemplerror")
    private Integer stopwhentemplerror;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDevSlnMSDepAPILock = new Integer(1);
    private PSDevSlnMSDepAPI psdevslnmsdepapi = null;
    private Integer objPSDevSlnMSDepAppLock = new Integer(1);
    private PSDevSlnMSDepApp psdevslnmsdepapp = null;
    private Integer objPSDevSlnMSDepFuncLock = new Integer(1);
    private PSDevSlnMSDepFunc psdevslnmsdepfunc = null;
    private Integer objPSMobAppPackLock = new Integer(1);
    private PSMobAppPack psmobapppack = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysApp2Lock = new Integer(1);
    private PSSysApp pssysapp2 = null;
    private Integer objPSSysBDInstCfgLock = new Integer(1);
    private PSSysBDInstCfg pssysbdinstcfg = null;
    private Integer objSrcPSSysDMVerLock = new Integer(1);
    private PSSysDMVer srcpssysdmver = null;
    private Integer objRunPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel runpssysdynamodel = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objPSSystemASLock = new Integer(1);
    private PSSystemAS pssystemas = null;
    private Integer objPSSystemDBCfgLock = new Integer(1);
    private PSSystemDBCfg pssystemdbcfg = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setDebugMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDebugMode(n);
            return;
        }
        this.debugmode = n;
        this.debugmodeDirtyFlag = true;
    }

    public Integer getDebugMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDebugMode();
        }
        return this.debugmode;
    }

    public boolean isDebugModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDebugModeDirty();
        }
        return this.debugmodeDirtyFlag;
    }

    public void resetDebugMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDebugMode();
            return;
        }
        this.debugmodeDirtyFlag = false;
        this.debugmode = null;
    }

    public void setEnableVC(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableVC(n);
            return;
        }
        this.enablevc = n;
        this.enablevcDirtyFlag = true;
    }

    public Integer getEnableVC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableVC();
        }
        return this.enablevc;
    }

    public boolean isEnableVCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableVCDirty();
        }
        return this.enablevcDirtyFlag;
    }

    public void resetEnableVC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableVC();
            return;
        }
        this.enablevcDirtyFlag = false;
        this.enablevc = null;
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

    public void setFixDBModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixDBModel(n);
            return;
        }
        this.fixdbmodel = n;
        this.fixdbmodelDirtyFlag = true;
    }

    public Integer getFixDBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixDBModel();
        }
        return this.fixdbmodel;
    }

    public boolean isFixDBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixDBModelDirty();
        }
        return this.fixdbmodelDirtyFlag;
    }

    public void resetFixDBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixDBModel();
            return;
        }
        this.fixdbmodelDirtyFlag = false;
        this.fixdbmodel = null;
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

    public void setPackMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.packmode = string;
        this.packmodeDirtyFlag = true;
    }

    public String getPackMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackMode();
        }
        return this.packmode;
    }

    public boolean isPackModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackModeDirty();
        }
        return this.packmodeDirtyFlag;
    }

    public void resetPackMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackMode();
            return;
        }
        this.packmodeDirtyFlag = false;
        this.packmode = null;
    }

    public void setPSDevSlnMSDepAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiid = string;
        this.psdevslnmsdepapiidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIId();
        }
        return this.psdevslnmsdepapiid;
    }

    public boolean isPSDevSlnMSDepAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPIIdDirty();
        }
        return this.psdevslnmsdepapiidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIId();
            return;
        }
        this.psdevslnmsdepapiidDirtyFlag = false;
        this.psdevslnmsdepapiid = null;
    }

    public void setPSDevSlnMSDepAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiname = string;
        this.psdevslnmsdepapinameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIName();
        }
        return this.psdevslnmsdepapiname;
    }

    public boolean isPSDevSlnMSDepAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPINameDirty();
        }
        return this.psdevslnmsdepapinameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIName();
            return;
        }
        this.psdevslnmsdepapinameDirtyFlag = false;
        this.psdevslnmsdepapiname = null;
    }

    public void setPSDevSlnMSDepAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappid = string;
        this.psdevslnmsdepappidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppId();
        }
        return this.psdevslnmsdepappid;
    }

    public boolean isPSDevSlnMSDepAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppIdDirty();
        }
        return this.psdevslnmsdepappidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppId();
            return;
        }
        this.psdevslnmsdepappidDirtyFlag = false;
        this.psdevslnmsdepappid = null;
    }

    public void setPSDevSlnMSDepAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappname = string;
        this.psdevslnmsdepappnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppName();
        }
        return this.psdevslnmsdepappname;
    }

    public boolean isPSDevSlnMSDepAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppNameDirty();
        }
        return this.psdevslnmsdepappnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppName();
            return;
        }
        this.psdevslnmsdepappnameDirtyFlag = false;
        this.psdevslnmsdepappname = null;
    }

    public void setPSDevSlnMSDepFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncid = string;
        this.psdevslnmsdepfuncidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncId();
        }
        return this.psdevslnmsdepfuncid;
    }

    public boolean isPSDevSlnMSDepFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncIdDirty();
        }
        return this.psdevslnmsdepfuncidDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncId();
            return;
        }
        this.psdevslnmsdepfuncidDirtyFlag = false;
        this.psdevslnmsdepfuncid = null;
    }

    public void setPSDevSlnMSDepFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncname = string;
        this.psdevslnmsdepfuncnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncName();
        }
        return this.psdevslnmsdepfuncname;
    }

    public boolean isPSDevSlnMSDepFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncNameDirty();
        }
        return this.psdevslnmsdepfuncnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncName();
            return;
        }
        this.psdevslnmsdepfuncnameDirtyFlag = false;
        this.psdevslnmsdepfuncname = null;
    }

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSMobAppPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackid = string;
        this.psmobapppackidDirtyFlag = true;
    }

    public String getPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackId();
        }
        return this.psmobapppackid;
    }

    public boolean isPSMobAppPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackIdDirty();
        }
        return this.psmobapppackidDirtyFlag;
    }

    public void resetPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackId();
            return;
        }
        this.psmobapppackidDirtyFlag = false;
        this.psmobapppackid = null;
    }

    public void setPSMobAppPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackname = string;
        this.psmobapppacknameDirtyFlag = true;
    }

    public String getPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackName();
        }
        return this.psmobapppackname;
    }

    public boolean isPSMobAppPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackNameDirty();
        }
        return this.psmobapppacknameDirtyFlag;
    }

    public void resetPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackName();
            return;
        }
        this.psmobapppacknameDirtyFlag = false;
        this.psmobapppackname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid2 = string;
        this.pssysappid2DirtyFlag = true;
    }

    public String getPSSysAppId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId2();
        }
        return this.pssysappid2;
    }

    public boolean isPSSysAppId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppId2Dirty();
        }
        return this.pssysappid2DirtyFlag;
    }

    public void resetPSSysAppId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId2();
            return;
        }
        this.pssysappid2DirtyFlag = false;
        this.pssysappid2 = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysAppName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname2 = string;
        this.pssysappname2DirtyFlag = true;
    }

    public String getPSSysAppName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName2();
        }
        return this.pssysappname2;
    }

    public boolean isPSSysAppName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppName2Dirty();
        }
        return this.pssysappname2DirtyFlag;
    }

    public void resetPSSysAppName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName2();
            return;
        }
        this.pssysappname2DirtyFlag = false;
        this.pssysappname2 = null;
    }

    public void setPSSysBDInstCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgid = string;
        this.pssysbdinstcfgidDirtyFlag = true;
    }

    public String getPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgId();
        }
        return this.pssysbdinstcfgid;
    }

    public boolean isPSSysBDInstCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgIdDirty();
        }
        return this.pssysbdinstcfgidDirtyFlag;
    }

    public void resetPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgId();
            return;
        }
        this.pssysbdinstcfgidDirtyFlag = false;
        this.pssysbdinstcfgid = null;
    }

    public void setPSSysBDInstCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgname = string;
        this.pssysbdinstcfgnameDirtyFlag = true;
    }

    public String getPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgName();
        }
        return this.pssysbdinstcfgname;
    }

    public boolean isPSSysBDInstCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgNameDirty();
        }
        return this.pssysbdinstcfgnameDirtyFlag;
    }

    public void resetPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgName();
            return;
        }
        this.pssysbdinstcfgnameDirtyFlag = false;
        this.pssysbdinstcfgname = null;
    }

    public void setPSSysRunSessionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunSessionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunsessionid = string;
        this.pssysrunsessionidDirtyFlag = true;
    }

    public String getPSSysRunSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunSessionId();
        }
        return this.pssysrunsessionid;
    }

    public boolean isPSSysRunSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunSessionIdDirty();
        }
        return this.pssysrunsessionidDirtyFlag;
    }

    public void resetPSSysRunSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunSessionId();
            return;
        }
        this.pssysrunsessionidDirtyFlag = false;
        this.pssysrunsessionid = null;
    }

    public void setPSSysRunSessionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunSessionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunsessionname = string;
        this.pssysrunsessionnameDirtyFlag = true;
    }

    public String getPSSysRunSessionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunSessionName();
        }
        return this.pssysrunsessionname;
    }

    public boolean isPSSysRunSessionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunSessionNameDirty();
        }
        return this.pssysrunsessionnameDirtyFlag;
    }

    public void resetPSSysRunSessionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunSessionName();
            return;
        }
        this.pssysrunsessionnameDirtyFlag = false;
        this.pssysrunsessionname = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
    }

    public void setPSSystemASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasid = string;
        this.pssystemasidDirtyFlag = true;
    }

    public String getPSSystemASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASId();
        }
        return this.pssystemasid;
    }

    public boolean isPSSystemASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASIdDirty();
        }
        return this.pssystemasidDirtyFlag;
    }

    public void resetPSSystemASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASId();
            return;
        }
        this.pssystemasidDirtyFlag = false;
        this.pssystemasid = null;
    }

    public void setPSSystemASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasname = string;
        this.pssystemasnameDirtyFlag = true;
    }

    public String getPSSystemASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASName();
        }
        return this.pssystemasname;
    }

    public boolean isPSSystemASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASNameDirty();
        }
        return this.pssystemasnameDirtyFlag;
    }

    public void resetPSSystemASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASName();
            return;
        }
        this.pssystemasnameDirtyFlag = false;
        this.pssystemasname = null;
    }

    public void setPSSystemDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgid = string;
        this.pssystemdbcfgidDirtyFlag = true;
    }

    public String getPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgId();
        }
        return this.pssystemdbcfgid;
    }

    public boolean isPSSystemDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgIdDirty();
        }
        return this.pssystemdbcfgidDirtyFlag;
    }

    public void resetPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgId();
            return;
        }
        this.pssystemdbcfgidDirtyFlag = false;
        this.pssystemdbcfgid = null;
    }

    public void setPSSystemDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgname = string;
        this.pssystemdbcfgnameDirtyFlag = true;
    }

    public String getPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgName();
        }
        return this.pssystemdbcfgname;
    }

    public boolean isPSSystemDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgNameDirty();
        }
        return this.pssystemdbcfgnameDirtyFlag;
    }

    public void resetPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgName();
            return;
        }
        this.pssystemdbcfgnameDirtyFlag = false;
        this.pssystemdbcfgname = null;
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

    public void setQuickMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickMode(n);
            return;
        }
        this.quickmode = n;
        this.quickmodeDirtyFlag = true;
    }

    public Integer getQuickMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickMode();
        }
        return this.quickmode;
    }

    public boolean isQuickModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickModeDirty();
        }
        return this.quickmodeDirtyFlag;
    }

    public void resetQuickMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickMode();
            return;
        }
        this.quickmodeDirtyFlag = false;
        this.quickmode = null;
    }

    public void setRebuildMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRebuildMode(n);
            return;
        }
        this.rebuildmode = n;
        this.rebuildmodeDirtyFlag = true;
    }

    public Integer getRebuildMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRebuildMode();
        }
        return this.rebuildmode;
    }

    public boolean isRebuildModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRebuildModeDirty();
        }
        return this.rebuildmodeDirtyFlag;
    }

    public void resetRebuildMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRebuildMode();
            return;
        }
        this.rebuildmodeDirtyFlag = false;
        this.rebuildmode = null;
    }

    public void setRunMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runmode = string;
        this.runmodeDirtyFlag = true;
    }

    public String getRunMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunMode();
        }
        return this.runmode;
    }

    public boolean isRunModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunModeDirty();
        }
        return this.runmodeDirtyFlag;
    }

    public void resetRunMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunMode();
            return;
        }
        this.runmodeDirtyFlag = false;
        this.runmode = null;
    }

    public void setRunParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam = string;
        this.runparamDirtyFlag = true;
    }

    public String getRunParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam();
        }
        return this.runparam;
    }

    public boolean isRunParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParamDirty();
        }
        return this.runparamDirtyFlag;
    }

    public void resetRunParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam();
            return;
        }
        this.runparamDirtyFlag = false;
        this.runparam = null;
    }

    public void setRunParam10(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam10(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam10 = string;
        this.runparam10DirtyFlag = true;
    }

    public String getRunParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam10();
        }
        return this.runparam10;
    }

    public boolean isRunParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam10Dirty();
        }
        return this.runparam10DirtyFlag;
    }

    public void resetRunParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam10();
            return;
        }
        this.runparam10DirtyFlag = false;
        this.runparam10 = null;
    }

    public void setRunParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam11 = string;
        this.runparam11DirtyFlag = true;
    }

    public String getRunParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam11();
        }
        return this.runparam11;
    }

    public boolean isRunParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam11Dirty();
        }
        return this.runparam11DirtyFlag;
    }

    public void resetRunParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam11();
            return;
        }
        this.runparam11DirtyFlag = false;
        this.runparam11 = null;
    }

    public void setRunParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam12 = string;
        this.runparam12DirtyFlag = true;
    }

    public String getRunParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam12();
        }
        return this.runparam12;
    }

    public boolean isRunParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam12Dirty();
        }
        return this.runparam12DirtyFlag;
    }

    public void resetRunParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam12();
            return;
        }
        this.runparam12DirtyFlag = false;
        this.runparam12 = null;
    }

    public void setRunParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam2 = string;
        this.runparam2DirtyFlag = true;
    }

    public String getRunParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam2();
        }
        return this.runparam2;
    }

    public boolean isRunParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam2Dirty();
        }
        return this.runparam2DirtyFlag;
    }

    public void resetRunParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam2();
            return;
        }
        this.runparam2DirtyFlag = false;
        this.runparam2 = null;
    }

    public void setRunParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam3 = string;
        this.runparam3DirtyFlag = true;
    }

    public String getRunParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam3();
        }
        return this.runparam3;
    }

    public boolean isRunParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam3Dirty();
        }
        return this.runparam3DirtyFlag;
    }

    public void resetRunParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam3();
            return;
        }
        this.runparam3DirtyFlag = false;
        this.runparam3 = null;
    }

    public void setRunParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam4 = string;
        this.runparam4DirtyFlag = true;
    }

    public String getRunParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam4();
        }
        return this.runparam4;
    }

    public boolean isRunParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam4Dirty();
        }
        return this.runparam4DirtyFlag;
    }

    public void resetRunParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam4();
            return;
        }
        this.runparam4DirtyFlag = false;
        this.runparam4 = null;
    }

    public void setRunParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam5(n);
            return;
        }
        this.runparam5 = n;
        this.runparam5DirtyFlag = true;
    }

    public Integer getRunParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam5();
        }
        return this.runparam5;
    }

    public boolean isRunParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam5Dirty();
        }
        return this.runparam5DirtyFlag;
    }

    public void resetRunParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam5();
            return;
        }
        this.runparam5DirtyFlag = false;
        this.runparam5 = null;
    }

    public void setRunParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam6(n);
            return;
        }
        this.runparam6 = n;
        this.runparam6DirtyFlag = true;
    }

    public Integer getRunParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam6();
        }
        return this.runparam6;
    }

    public boolean isRunParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam6Dirty();
        }
        return this.runparam6DirtyFlag;
    }

    public void resetRunParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam6();
            return;
        }
        this.runparam6DirtyFlag = false;
        this.runparam6 = null;
    }

    public void setRunParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam7 = string;
        this.runparam7DirtyFlag = true;
    }

    public String getRunParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam7();
        }
        return this.runparam7;
    }

    public boolean isRunParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam7Dirty();
        }
        return this.runparam7DirtyFlag;
    }

    public void resetRunParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam7();
            return;
        }
        this.runparam7DirtyFlag = false;
        this.runparam7 = null;
    }

    public void setRunParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam8 = string;
        this.runparam8DirtyFlag = true;
    }

    public String getRunParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam8();
        }
        return this.runparam8;
    }

    public boolean isRunParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam8Dirty();
        }
        return this.runparam8DirtyFlag;
    }

    public void resetRunParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam8();
            return;
        }
        this.runparam8DirtyFlag = false;
        this.runparam8 = null;
    }

    public void setRunParam9(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunParam9(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runparam9 = string;
        this.runparam9DirtyFlag = true;
    }

    public String getRunParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunParam9();
        }
        return this.runparam9;
    }

    public boolean isRunParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunParam9Dirty();
        }
        return this.runparam9DirtyFlag;
    }

    public void resetRunParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunParam9();
            return;
        }
        this.runparam9DirtyFlag = false;
        this.runparam9 = null;
    }

    public void setRunPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runpssysdynamodelid = string;
        this.runpssysdynamodelidDirtyFlag = true;
    }

    public String getRunPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModelId();
        }
        return this.runpssysdynamodelid;
    }

    public boolean isRunPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunPSSysDynaModelIdDirty();
        }
        return this.runpssysdynamodelidDirtyFlag;
    }

    public void resetRunPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunPSSysDynaModelId();
            return;
        }
        this.runpssysdynamodelidDirtyFlag = false;
        this.runpssysdynamodelid = null;
    }

    public void setRunPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runpssysdynamodelname = string;
        this.runpssysdynamodelnameDirtyFlag = true;
    }

    public String getRunPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModelName();
        }
        return this.runpssysdynamodelname;
    }

    public boolean isRunPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunPSSysDynaModelNameDirty();
        }
        return this.runpssysdynamodelnameDirtyFlag;
    }

    public void resetRunPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunPSSysDynaModelName();
            return;
        }
        this.runpssysdynamodelnameDirtyFlag = false;
        this.runpssysdynamodelname = null;
    }

    public void setRunState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunState(n);
            return;
        }
        this.runstate = n;
        this.runstateDirtyFlag = true;
    }

    public Integer getRunState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunState();
        }
        return this.runstate;
    }

    public boolean isRunStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunStateDirty();
        }
        return this.runstateDirtyFlag;
    }

    public void resetRunState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunState();
            return;
        }
        this.runstateDirtyFlag = false;
        this.runstate = null;
    }

    public void setSrcPSSysDMVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSysDMVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssysdmverid = string;
        this.srcpssysdmveridDirtyFlag = true;
    }

    public String getSrcPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysDMVerId();
        }
        return this.srcpssysdmverid;
    }

    public boolean isSrcPSSysDMVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSysDMVerIdDirty();
        }
        return this.srcpssysdmveridDirtyFlag;
    }

    public void resetSrcPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSysDMVerId();
            return;
        }
        this.srcpssysdmveridDirtyFlag = false;
        this.srcpssysdmverid = null;
    }

    public void setSrcPSSysDMVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSysDMVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssysdmvername = string;
        this.srcpssysdmvernameDirtyFlag = true;
    }

    public String getSrcPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysDMVerName();
        }
        return this.srcpssysdmvername;
    }

    public boolean isSrcPSSysDMVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSysDMVerNameDirty();
        }
        return this.srcpssysdmvernameDirtyFlag;
    }

    public void resetSrcPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSysDMVerName();
            return;
        }
        this.srcpssysdmvernameDirtyFlag = false;
        this.srcpssysdmvername = null;
    }

    public void setStartTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartTime(timestamp);
            return;
        }
        this.starttime = timestamp;
        this.starttimeDirtyFlag = true;
    }

    public Timestamp getStartTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartTime();
        }
        return this.starttime;
    }

    public boolean isStartTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartTimeDirty();
        }
        return this.starttimeDirtyFlag;
    }

    public void resetStartTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartTime();
            return;
        }
        this.starttimeDirtyFlag = false;
        this.starttime = null;
    }

    public void setStopWhenTemplError(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStopWhenTemplError(n);
            return;
        }
        this.stopwhentemplerror = n;
        this.stopwhentemplerrorDirtyFlag = true;
    }

    public Integer getStopWhenTemplError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStopWhenTemplError();
        }
        return this.stopwhentemplerror;
    }

    public boolean isStopWhenTemplErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStopWhenTemplErrorDirty();
        }
        return this.stopwhentemplerrorDirtyFlag;
    }

    public void resetStopWhenTemplError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStopWhenTemplError();
            return;
        }
        this.stopwhentemplerrorDirtyFlag = false;
        this.stopwhentemplerror = null;
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

    protected void onReset() {
        PSSysRunSessionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRunSessionBase pSSysRunSessionBase) {
        pSSysRunSessionBase.resetCreateDate();
        pSSysRunSessionBase.resetCreateMan();
        pSSysRunSessionBase.resetDebugMode();
        pSSysRunSessionBase.resetEnableVC();
        pSSysRunSessionBase.resetEndTime();
        pSSysRunSessionBase.resetFixDBModel();
        pSSysRunSessionBase.resetMemo();
        pSSysRunSessionBase.resetPackMode();
        pSSysRunSessionBase.resetPSDevSlnMSDepAPIId();
        pSSysRunSessionBase.resetPSDevSlnMSDepAPIName();
        pSSysRunSessionBase.resetPSDevSlnMSDepAppId();
        pSSysRunSessionBase.resetPSDevSlnMSDepAppName();
        pSSysRunSessionBase.resetPSDevSlnMSDepFuncId();
        pSSysRunSessionBase.resetPSDevSlnMSDepFuncName();
        pSSysRunSessionBase.resetPSDSConsoleId();
        pSSysRunSessionBase.resetPSDynaInstId();
        pSSysRunSessionBase.resetPSMobAppPackId();
        pSSysRunSessionBase.resetPSMobAppPackName();
        pSSysRunSessionBase.resetPSSysAppId();
        pSSysRunSessionBase.resetPSSysAppId2();
        pSSysRunSessionBase.resetPSSysAppName();
        pSSysRunSessionBase.resetPSSysAppName2();
        pSSysRunSessionBase.resetPSSysBDInstCfgId();
        pSSysRunSessionBase.resetPSSysBDInstCfgName();
        pSSysRunSessionBase.resetPSSysRunSessionId();
        pSSysRunSessionBase.resetPSSysRunSessionName();
        pSSysRunSessionBase.resetPSSysServiceAPIId();
        pSSysRunSessionBase.resetPSSysServiceAPIName();
        pSSysRunSessionBase.resetPSSysSFPubId();
        pSSysRunSessionBase.resetPSSysSFPubName();
        pSSysRunSessionBase.resetPSSystemASId();
        pSSysRunSessionBase.resetPSSystemASName();
        pSSysRunSessionBase.resetPSSystemDBCfgId();
        pSSysRunSessionBase.resetPSSystemDBCfgName();
        pSSysRunSessionBase.resetPSSystemId();
        pSSysRunSessionBase.resetPSSystemName();
        pSSysRunSessionBase.resetQuickMode();
        pSSysRunSessionBase.resetRebuildMode();
        pSSysRunSessionBase.resetRunMode();
        pSSysRunSessionBase.resetRunParam();
        pSSysRunSessionBase.resetRunParam10();
        pSSysRunSessionBase.resetRunParam11();
        pSSysRunSessionBase.resetRunParam12();
        pSSysRunSessionBase.resetRunParam2();
        pSSysRunSessionBase.resetRunParam3();
        pSSysRunSessionBase.resetRunParam4();
        pSSysRunSessionBase.resetRunParam5();
        pSSysRunSessionBase.resetRunParam6();
        pSSysRunSessionBase.resetRunParam7();
        pSSysRunSessionBase.resetRunParam8();
        pSSysRunSessionBase.resetRunParam9();
        pSSysRunSessionBase.resetRunPSSysDynaModelId();
        pSSysRunSessionBase.resetRunPSSysDynaModelName();
        pSSysRunSessionBase.resetRunState();
        pSSysRunSessionBase.resetSrcPSSysDMVerId();
        pSSysRunSessionBase.resetSrcPSSysDMVerName();
        pSSysRunSessionBase.resetStartTime();
        pSSysRunSessionBase.resetStopWhenTemplError();
        pSSysRunSessionBase.resetUpdateDate();
        pSSysRunSessionBase.resetUpdateMan();
        pSSysRunSessionBase.resetUserTag();
        pSSysRunSessionBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDebugModeDirty()) {
            hashMap.put(FIELD_DEBUGMODE, this.getDebugMode());
        }
        if (!bl || this.isEnableVCDirty()) {
            hashMap.put(FIELD_ENABLEVC, this.getEnableVC());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isFixDBModelDirty()) {
            hashMap.put(FIELD_FIXDBMODEL, this.getFixDBModel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPackModeDirty()) {
            hashMap.put(FIELD_PACKMODE, this.getPackMode());
        }
        if (!bl || this.isPSDevSlnMSDepAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPIID, this.getPSDevSlnMSDepAPIId());
        }
        if (!bl || this.isPSDevSlnMSDepAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPINAME, this.getPSDevSlnMSDepAPIName());
        }
        if (!bl || this.isPSDevSlnMSDepAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPID, this.getPSDevSlnMSDepAppId());
        }
        if (!bl || this.isPSDevSlnMSDepAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, this.getPSDevSlnMSDepAppName());
        }
        if (!bl || this.isPSDevSlnMSDepFuncIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCID, this.getPSDevSlnMSDepFuncId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, this.getPSDevSlnMSDepFuncName());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSMobAppPackIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKID, this.getPSMobAppPackId());
        }
        if (!bl || this.isPSMobAppPackNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKNAME, this.getPSMobAppPackName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppId2Dirty()) {
            hashMap.put(FIELD_PSSYSAPPID2, this.getPSSysAppId2());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysAppName2Dirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME2, this.getPSSysAppName2());
        }
        if (!bl || this.isPSSysBDInstCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGID, this.getPSSysBDInstCfgId());
        }
        if (!bl || this.isPSSysBDInstCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGNAME, this.getPSSysBDInstCfgName());
        }
        if (!bl || this.isPSSysRunSessionIdDirty()) {
            hashMap.put(FIELD_PSSYSRUNSESSIONID, this.getPSSysRunSessionId());
        }
        if (!bl || this.isPSSysRunSessionNameDirty()) {
            hashMap.put(FIELD_PSSYSRUNSESSIONNAME, this.getPSSysRunSessionName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSystemASIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMASID, this.getPSSystemASId());
        }
        if (!bl || this.isPSSystemASNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMASNAME, this.getPSSystemASName());
        }
        if (!bl || this.isPSSystemDBCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGID, this.getPSSystemDBCfgId());
        }
        if (!bl || this.isPSSystemDBCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGNAME, this.getPSSystemDBCfgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isQuickModeDirty()) {
            hashMap.put(FIELD_QUICKMODE, this.getQuickMode());
        }
        if (!bl || this.isRebuildModeDirty()) {
            hashMap.put(FIELD_REBUILDMODE, this.getRebuildMode());
        }
        if (!bl || this.isRunModeDirty()) {
            hashMap.put(FIELD_RUNMODE, this.getRunMode());
        }
        if (!bl || this.isRunParamDirty()) {
            hashMap.put(FIELD_RUNPARAM, this.getRunParam());
        }
        if (!bl || this.isRunParam10Dirty()) {
            hashMap.put(FIELD_RUNPARAM10, this.getRunParam10());
        }
        if (!bl || this.isRunParam11Dirty()) {
            hashMap.put(FIELD_RUNPARAM11, this.getRunParam11());
        }
        if (!bl || this.isRunParam12Dirty()) {
            hashMap.put(FIELD_RUNPARAM12, this.getRunParam12());
        }
        if (!bl || this.isRunParam2Dirty()) {
            hashMap.put(FIELD_RUNPARAM2, this.getRunParam2());
        }
        if (!bl || this.isRunParam3Dirty()) {
            hashMap.put(FIELD_RUNPARAM3, this.getRunParam3());
        }
        if (!bl || this.isRunParam4Dirty()) {
            hashMap.put(FIELD_RUNPARAM4, this.getRunParam4());
        }
        if (!bl || this.isRunParam5Dirty()) {
            hashMap.put(FIELD_RUNPARAM5, this.getRunParam5());
        }
        if (!bl || this.isRunParam6Dirty()) {
            hashMap.put(FIELD_RUNPARAM6, this.getRunParam6());
        }
        if (!bl || this.isRunParam7Dirty()) {
            hashMap.put(FIELD_RUNPARAM7, this.getRunParam7());
        }
        if (!bl || this.isRunParam8Dirty()) {
            hashMap.put(FIELD_RUNPARAM8, this.getRunParam8());
        }
        if (!bl || this.isRunParam9Dirty()) {
            hashMap.put(FIELD_RUNPARAM9, this.getRunParam9());
        }
        if (!bl || this.isRunPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_RUNPSSYSDYNAMODELID, this.getRunPSSysDynaModelId());
        }
        if (!bl || this.isRunPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_RUNPSSYSDYNAMODELNAME, this.getRunPSSysDynaModelName());
        }
        if (!bl || this.isRunStateDirty()) {
            hashMap.put(FIELD_RUNSTATE, this.getRunState());
        }
        if (!bl || this.isSrcPSSysDMVerIdDirty()) {
            hashMap.put(FIELD_SRCPSSYSDMVERID, this.getSrcPSSysDMVerId());
        }
        if (!bl || this.isSrcPSSysDMVerNameDirty()) {
            hashMap.put(FIELD_SRCPSSYSDMVERNAME, this.getSrcPSSysDMVerName());
        }
        if (!bl || this.isStartTimeDirty()) {
            hashMap.put(FIELD_STARTTIME, this.getStartTime());
        }
        if (!bl || this.isStopWhenTemplErrorDirty()) {
            hashMap.put(FIELD_STOPWHENTEMPLERROR, this.getStopWhenTemplError());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSSysRunSessionBase.get(this, n);
    }

    private static Object get(PSSysRunSessionBase pSSysRunSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunSessionBase.getCreateDate();
            }
            case 1: {
                return pSSysRunSessionBase.getCreateMan();
            }
            case 2: {
                return pSSysRunSessionBase.getDebugMode();
            }
            case 3: {
                return pSSysRunSessionBase.getEnableVC();
            }
            case 4: {
                return pSSysRunSessionBase.getEndTime();
            }
            case 5: {
                return pSSysRunSessionBase.getFixDBModel();
            }
            case 6: {
                return pSSysRunSessionBase.getMemo();
            }
            case 7: {
                return pSSysRunSessionBase.getPackMode();
            }
            case 8: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAPIId();
            }
            case 9: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAPIName();
            }
            case 10: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAppId();
            }
            case 11: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAppName();
            }
            case 12: {
                return pSSysRunSessionBase.getPSDevSlnMSDepFuncId();
            }
            case 13: {
                return pSSysRunSessionBase.getPSDevSlnMSDepFuncName();
            }
            case 14: {
                return pSSysRunSessionBase.getPSDSConsoleId();
            }
            case 15: {
                return pSSysRunSessionBase.getPSDynaInstId();
            }
            case 16: {
                return pSSysRunSessionBase.getPSMobAppPackId();
            }
            case 17: {
                return pSSysRunSessionBase.getPSMobAppPackName();
            }
            case 18: {
                return pSSysRunSessionBase.getPSSysAppId();
            }
            case 19: {
                return pSSysRunSessionBase.getPSSysAppId2();
            }
            case 20: {
                return pSSysRunSessionBase.getPSSysAppName();
            }
            case 21: {
                return pSSysRunSessionBase.getPSSysAppName2();
            }
            case 22: {
                return pSSysRunSessionBase.getPSSysBDInstCfgId();
            }
            case 23: {
                return pSSysRunSessionBase.getPSSysBDInstCfgName();
            }
            case 24: {
                return pSSysRunSessionBase.getPSSysRunSessionId();
            }
            case 25: {
                return pSSysRunSessionBase.getPSSysRunSessionName();
            }
            case 26: {
                return pSSysRunSessionBase.getPSSysServiceAPIId();
            }
            case 27: {
                return pSSysRunSessionBase.getPSSysServiceAPIName();
            }
            case 28: {
                return pSSysRunSessionBase.getPSSysSFPubId();
            }
            case 29: {
                return pSSysRunSessionBase.getPSSysSFPubName();
            }
            case 30: {
                return pSSysRunSessionBase.getPSSystemASId();
            }
            case 31: {
                return pSSysRunSessionBase.getPSSystemASName();
            }
            case 32: {
                return pSSysRunSessionBase.getPSSystemDBCfgId();
            }
            case 33: {
                return pSSysRunSessionBase.getPSSystemDBCfgName();
            }
            case 34: {
                return pSSysRunSessionBase.getPSSystemId();
            }
            case 35: {
                return pSSysRunSessionBase.getPSSystemName();
            }
            case 36: {
                return pSSysRunSessionBase.getQuickMode();
            }
            case 37: {
                return pSSysRunSessionBase.getRebuildMode();
            }
            case 38: {
                return pSSysRunSessionBase.getRunMode();
            }
            case 39: {
                return pSSysRunSessionBase.getRunParam();
            }
            case 40: {
                return pSSysRunSessionBase.getRunParam10();
            }
            case 41: {
                return pSSysRunSessionBase.getRunParam11();
            }
            case 42: {
                return pSSysRunSessionBase.getRunParam12();
            }
            case 43: {
                return pSSysRunSessionBase.getRunParam2();
            }
            case 44: {
                return pSSysRunSessionBase.getRunParam3();
            }
            case 45: {
                return pSSysRunSessionBase.getRunParam4();
            }
            case 46: {
                return pSSysRunSessionBase.getRunParam5();
            }
            case 47: {
                return pSSysRunSessionBase.getRunParam6();
            }
            case 48: {
                return pSSysRunSessionBase.getRunParam7();
            }
            case 49: {
                return pSSysRunSessionBase.getRunParam8();
            }
            case 50: {
                return pSSysRunSessionBase.getRunParam9();
            }
            case 51: {
                return pSSysRunSessionBase.getRunPSSysDynaModelId();
            }
            case 52: {
                return pSSysRunSessionBase.getRunPSSysDynaModelName();
            }
            case 53: {
                return pSSysRunSessionBase.getRunState();
            }
            case 54: {
                return pSSysRunSessionBase.getSrcPSSysDMVerId();
            }
            case 55: {
                return pSSysRunSessionBase.getSrcPSSysDMVerName();
            }
            case 56: {
                return pSSysRunSessionBase.getStartTime();
            }
            case 57: {
                return pSSysRunSessionBase.getStopWhenTemplError();
            }
            case 58: {
                return pSSysRunSessionBase.getUpdateDate();
            }
            case 59: {
                return pSSysRunSessionBase.getUpdateMan();
            }
            case 60: {
                return pSSysRunSessionBase.getUserTag();
            }
            case 61: {
                return pSSysRunSessionBase.getUserTag2();
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
        PSSysRunSessionBase.set(this, n, object);
    }

    private static void set(PSSysRunSessionBase pSSysRunSessionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRunSessionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysRunSessionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysRunSessionBase.setDebugMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysRunSessionBase.setEnableVC(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysRunSessionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysRunSessionBase.setFixDBModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysRunSessionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysRunSessionBase.setPackMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRunSessionBase.setPSDevSlnMSDepAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRunSessionBase.setPSDevSlnMSDepAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRunSessionBase.setPSDevSlnMSDepAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysRunSessionBase.setPSDevSlnMSDepAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysRunSessionBase.setPSDevSlnMSDepFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysRunSessionBase.setPSDevSlnMSDepFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysRunSessionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysRunSessionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysRunSessionBase.setPSMobAppPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysRunSessionBase.setPSMobAppPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysRunSessionBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysRunSessionBase.setPSSysAppId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysRunSessionBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysRunSessionBase.setPSSysAppName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysRunSessionBase.setPSSysBDInstCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysRunSessionBase.setPSSysBDInstCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysRunSessionBase.setPSSysRunSessionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysRunSessionBase.setPSSysRunSessionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysRunSessionBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysRunSessionBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysRunSessionBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysRunSessionBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysRunSessionBase.setPSSystemASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysRunSessionBase.setPSSystemASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysRunSessionBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysRunSessionBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysRunSessionBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysRunSessionBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysRunSessionBase.setQuickMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSysRunSessionBase.setRebuildMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysRunSessionBase.setRunMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysRunSessionBase.setRunParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysRunSessionBase.setRunParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysRunSessionBase.setRunParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysRunSessionBase.setRunParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysRunSessionBase.setRunParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysRunSessionBase.setRunParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysRunSessionBase.setRunParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysRunSessionBase.setRunParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSSysRunSessionBase.setRunParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSSysRunSessionBase.setRunParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysRunSessionBase.setRunParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysRunSessionBase.setRunParam9(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysRunSessionBase.setRunPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysRunSessionBase.setRunPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysRunSessionBase.setRunState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSSysRunSessionBase.setSrcPSSysDMVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysRunSessionBase.setSrcPSSysDMVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysRunSessionBase.setStartTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 57: {
                pSSysRunSessionBase.setStopWhenTemplError(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSSysRunSessionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 59: {
                pSSysRunSessionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysRunSessionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysRunSessionBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysRunSessionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRunSessionBase pSSysRunSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunSessionBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysRunSessionBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysRunSessionBase.getDebugMode() == null;
            }
            case 3: {
                return pSSysRunSessionBase.getEnableVC() == null;
            }
            case 4: {
                return pSSysRunSessionBase.getEndTime() == null;
            }
            case 5: {
                return pSSysRunSessionBase.getFixDBModel() == null;
            }
            case 6: {
                return pSSysRunSessionBase.getMemo() == null;
            }
            case 7: {
                return pSSysRunSessionBase.getPackMode() == null;
            }
            case 8: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAPIId() == null;
            }
            case 9: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAPIName() == null;
            }
            case 10: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAppId() == null;
            }
            case 11: {
                return pSSysRunSessionBase.getPSDevSlnMSDepAppName() == null;
            }
            case 12: {
                return pSSysRunSessionBase.getPSDevSlnMSDepFuncId() == null;
            }
            case 13: {
                return pSSysRunSessionBase.getPSDevSlnMSDepFuncName() == null;
            }
            case 14: {
                return pSSysRunSessionBase.getPSDSConsoleId() == null;
            }
            case 15: {
                return pSSysRunSessionBase.getPSDynaInstId() == null;
            }
            case 16: {
                return pSSysRunSessionBase.getPSMobAppPackId() == null;
            }
            case 17: {
                return pSSysRunSessionBase.getPSMobAppPackName() == null;
            }
            case 18: {
                return pSSysRunSessionBase.getPSSysAppId() == null;
            }
            case 19: {
                return pSSysRunSessionBase.getPSSysAppId2() == null;
            }
            case 20: {
                return pSSysRunSessionBase.getPSSysAppName() == null;
            }
            case 21: {
                return pSSysRunSessionBase.getPSSysAppName2() == null;
            }
            case 22: {
                return pSSysRunSessionBase.getPSSysBDInstCfgId() == null;
            }
            case 23: {
                return pSSysRunSessionBase.getPSSysBDInstCfgName() == null;
            }
            case 24: {
                return pSSysRunSessionBase.getPSSysRunSessionId() == null;
            }
            case 25: {
                return pSSysRunSessionBase.getPSSysRunSessionName() == null;
            }
            case 26: {
                return pSSysRunSessionBase.getPSSysServiceAPIId() == null;
            }
            case 27: {
                return pSSysRunSessionBase.getPSSysServiceAPIName() == null;
            }
            case 28: {
                return pSSysRunSessionBase.getPSSysSFPubId() == null;
            }
            case 29: {
                return pSSysRunSessionBase.getPSSysSFPubName() == null;
            }
            case 30: {
                return pSSysRunSessionBase.getPSSystemASId() == null;
            }
            case 31: {
                return pSSysRunSessionBase.getPSSystemASName() == null;
            }
            case 32: {
                return pSSysRunSessionBase.getPSSystemDBCfgId() == null;
            }
            case 33: {
                return pSSysRunSessionBase.getPSSystemDBCfgName() == null;
            }
            case 34: {
                return pSSysRunSessionBase.getPSSystemId() == null;
            }
            case 35: {
                return pSSysRunSessionBase.getPSSystemName() == null;
            }
            case 36: {
                return pSSysRunSessionBase.getQuickMode() == null;
            }
            case 37: {
                return pSSysRunSessionBase.getRebuildMode() == null;
            }
            case 38: {
                return pSSysRunSessionBase.getRunMode() == null;
            }
            case 39: {
                return pSSysRunSessionBase.getRunParam() == null;
            }
            case 40: {
                return pSSysRunSessionBase.getRunParam10() == null;
            }
            case 41: {
                return pSSysRunSessionBase.getRunParam11() == null;
            }
            case 42: {
                return pSSysRunSessionBase.getRunParam12() == null;
            }
            case 43: {
                return pSSysRunSessionBase.getRunParam2() == null;
            }
            case 44: {
                return pSSysRunSessionBase.getRunParam3() == null;
            }
            case 45: {
                return pSSysRunSessionBase.getRunParam4() == null;
            }
            case 46: {
                return pSSysRunSessionBase.getRunParam5() == null;
            }
            case 47: {
                return pSSysRunSessionBase.getRunParam6() == null;
            }
            case 48: {
                return pSSysRunSessionBase.getRunParam7() == null;
            }
            case 49: {
                return pSSysRunSessionBase.getRunParam8() == null;
            }
            case 50: {
                return pSSysRunSessionBase.getRunParam9() == null;
            }
            case 51: {
                return pSSysRunSessionBase.getRunPSSysDynaModelId() == null;
            }
            case 52: {
                return pSSysRunSessionBase.getRunPSSysDynaModelName() == null;
            }
            case 53: {
                return pSSysRunSessionBase.getRunState() == null;
            }
            case 54: {
                return pSSysRunSessionBase.getSrcPSSysDMVerId() == null;
            }
            case 55: {
                return pSSysRunSessionBase.getSrcPSSysDMVerName() == null;
            }
            case 56: {
                return pSSysRunSessionBase.getStartTime() == null;
            }
            case 57: {
                return pSSysRunSessionBase.getStopWhenTemplError() == null;
            }
            case 58: {
                return pSSysRunSessionBase.getUpdateDate() == null;
            }
            case 59: {
                return pSSysRunSessionBase.getUpdateMan() == null;
            }
            case 60: {
                return pSSysRunSessionBase.getUserTag() == null;
            }
            case 61: {
                return pSSysRunSessionBase.getUserTag2() == null;
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
        return PSSysRunSessionBase.contains(this, n);
    }

    private static boolean contains(PSSysRunSessionBase pSSysRunSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunSessionBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysRunSessionBase.isCreateManDirty();
            }
            case 2: {
                return pSSysRunSessionBase.isDebugModeDirty();
            }
            case 3: {
                return pSSysRunSessionBase.isEnableVCDirty();
            }
            case 4: {
                return pSSysRunSessionBase.isEndTimeDirty();
            }
            case 5: {
                return pSSysRunSessionBase.isFixDBModelDirty();
            }
            case 6: {
                return pSSysRunSessionBase.isMemoDirty();
            }
            case 7: {
                return pSSysRunSessionBase.isPackModeDirty();
            }
            case 8: {
                return pSSysRunSessionBase.isPSDevSlnMSDepAPIIdDirty();
            }
            case 9: {
                return pSSysRunSessionBase.isPSDevSlnMSDepAPINameDirty();
            }
            case 10: {
                return pSSysRunSessionBase.isPSDevSlnMSDepAppIdDirty();
            }
            case 11: {
                return pSSysRunSessionBase.isPSDevSlnMSDepAppNameDirty();
            }
            case 12: {
                return pSSysRunSessionBase.isPSDevSlnMSDepFuncIdDirty();
            }
            case 13: {
                return pSSysRunSessionBase.isPSDevSlnMSDepFuncNameDirty();
            }
            case 14: {
                return pSSysRunSessionBase.isPSDSConsoleIdDirty();
            }
            case 15: {
                return pSSysRunSessionBase.isPSDynaInstIdDirty();
            }
            case 16: {
                return pSSysRunSessionBase.isPSMobAppPackIdDirty();
            }
            case 17: {
                return pSSysRunSessionBase.isPSMobAppPackNameDirty();
            }
            case 18: {
                return pSSysRunSessionBase.isPSSysAppIdDirty();
            }
            case 19: {
                return pSSysRunSessionBase.isPSSysAppId2Dirty();
            }
            case 20: {
                return pSSysRunSessionBase.isPSSysAppNameDirty();
            }
            case 21: {
                return pSSysRunSessionBase.isPSSysAppName2Dirty();
            }
            case 22: {
                return pSSysRunSessionBase.isPSSysBDInstCfgIdDirty();
            }
            case 23: {
                return pSSysRunSessionBase.isPSSysBDInstCfgNameDirty();
            }
            case 24: {
                return pSSysRunSessionBase.isPSSysRunSessionIdDirty();
            }
            case 25: {
                return pSSysRunSessionBase.isPSSysRunSessionNameDirty();
            }
            case 26: {
                return pSSysRunSessionBase.isPSSysServiceAPIIdDirty();
            }
            case 27: {
                return pSSysRunSessionBase.isPSSysServiceAPINameDirty();
            }
            case 28: {
                return pSSysRunSessionBase.isPSSysSFPubIdDirty();
            }
            case 29: {
                return pSSysRunSessionBase.isPSSysSFPubNameDirty();
            }
            case 30: {
                return pSSysRunSessionBase.isPSSystemASIdDirty();
            }
            case 31: {
                return pSSysRunSessionBase.isPSSystemASNameDirty();
            }
            case 32: {
                return pSSysRunSessionBase.isPSSystemDBCfgIdDirty();
            }
            case 33: {
                return pSSysRunSessionBase.isPSSystemDBCfgNameDirty();
            }
            case 34: {
                return pSSysRunSessionBase.isPSSystemIdDirty();
            }
            case 35: {
                return pSSysRunSessionBase.isPSSystemNameDirty();
            }
            case 36: {
                return pSSysRunSessionBase.isQuickModeDirty();
            }
            case 37: {
                return pSSysRunSessionBase.isRebuildModeDirty();
            }
            case 38: {
                return pSSysRunSessionBase.isRunModeDirty();
            }
            case 39: {
                return pSSysRunSessionBase.isRunParamDirty();
            }
            case 40: {
                return pSSysRunSessionBase.isRunParam10Dirty();
            }
            case 41: {
                return pSSysRunSessionBase.isRunParam11Dirty();
            }
            case 42: {
                return pSSysRunSessionBase.isRunParam12Dirty();
            }
            case 43: {
                return pSSysRunSessionBase.isRunParam2Dirty();
            }
            case 44: {
                return pSSysRunSessionBase.isRunParam3Dirty();
            }
            case 45: {
                return pSSysRunSessionBase.isRunParam4Dirty();
            }
            case 46: {
                return pSSysRunSessionBase.isRunParam5Dirty();
            }
            case 47: {
                return pSSysRunSessionBase.isRunParam6Dirty();
            }
            case 48: {
                return pSSysRunSessionBase.isRunParam7Dirty();
            }
            case 49: {
                return pSSysRunSessionBase.isRunParam8Dirty();
            }
            case 50: {
                return pSSysRunSessionBase.isRunParam9Dirty();
            }
            case 51: {
                return pSSysRunSessionBase.isRunPSSysDynaModelIdDirty();
            }
            case 52: {
                return pSSysRunSessionBase.isRunPSSysDynaModelNameDirty();
            }
            case 53: {
                return pSSysRunSessionBase.isRunStateDirty();
            }
            case 54: {
                return pSSysRunSessionBase.isSrcPSSysDMVerIdDirty();
            }
            case 55: {
                return pSSysRunSessionBase.isSrcPSSysDMVerNameDirty();
            }
            case 56: {
                return pSSysRunSessionBase.isStartTimeDirty();
            }
            case 57: {
                return pSSysRunSessionBase.isStopWhenTemplErrorDirty();
            }
            case 58: {
                return pSSysRunSessionBase.isUpdateDateDirty();
            }
            case 59: {
                return pSSysRunSessionBase.isUpdateManDirty();
            }
            case 60: {
                return pSSysRunSessionBase.isUserTagDirty();
            }
            case 61: {
                return pSSysRunSessionBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRunSessionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRunSessionBase pSSysRunSessionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRunSessionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getDebugMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"debugmode", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getDebugMode()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getEnableVC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablevc", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getEnableVC()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getFixDBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixdbmodel", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getFixDBModel()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPackMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packmode", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPackMode()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepAPIId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepAPIName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepAppId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepAppName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepFuncId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDevSlnMSDepFuncName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSMobAppPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSMobAppPackId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSMobAppPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSMobAppPackName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid2", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysAppId2()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname2", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysAppName2()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysBDInstCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysBDInstCfgId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysBDInstCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysBDInstCfgName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysRunSessionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunsessionid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysRunSessionId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysRunSessionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunsessionname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysRunSessionName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemASId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemASName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getQuickMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickmode", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getQuickMode()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRebuildMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rebuildmode", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRebuildMode()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runmode", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunMode()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam10", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam10()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam11", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam11()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam12", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam12()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam2", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam2()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam3", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam3()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam4", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam4()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam5", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam5()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam6", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam6()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam7", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam7()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam8", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam8()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runparam9", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunParam9()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runpssysdynamodelid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runpssysdynamodelname", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getRunState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runstate", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getRunState()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getSrcPSSysDMVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssysdmverid", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getSrcPSSysDMVerId()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getSrcPSSysDMVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssysdmvername", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getSrcPSSysDMVerName()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getStartTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"starttime", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getStartTime()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getStopWhenTemplError() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopwhentemplerror", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getStopWhenTemplError()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysRunSessionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysRunSessionBase.getJSONValue((Object)pSSysRunSessionBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRunSessionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRunSessionBase pSSysRunSessionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRunSessionBase.getCreateDate() != null) {
            object = pSSysRunSessionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getCreateMan() != null) {
            object = pSSysRunSessionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getDebugMode() != null) {
            object = pSSysRunSessionBase.getDebugMode();
            xmlNode.setAttribute(FIELD_DEBUGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getEnableVC() != null) {
            object = pSSysRunSessionBase.getEnableVC();
            xmlNode.setAttribute(FIELD_ENABLEVC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getEndTime() != null) {
            object = pSSysRunSessionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getFixDBModel() != null) {
            object = pSSysRunSessionBase.getFixDBModel();
            xmlNode.setAttribute(FIELD_FIXDBMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getMemo() != null) {
            object = pSSysRunSessionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPackMode() != null) {
            object = pSSysRunSessionBase.getPackMode();
            xmlNode.setAttribute(FIELD_PACKMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIId() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIName() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppId() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppName() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncId() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepFuncId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncName() != null) {
            object = pSSysRunSessionBase.getPSDevSlnMSDepFuncName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDSConsoleId() != null) {
            object = pSSysRunSessionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSDynaInstId() != null) {
            object = pSSysRunSessionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSMobAppPackId() != null) {
            object = pSSysRunSessionBase.getPSMobAppPackId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSMobAppPackName() != null) {
            object = pSSysRunSessionBase.getPSMobAppPackName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppId() != null) {
            object = pSSysRunSessionBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppId2() != null) {
            object = pSSysRunSessionBase.getPSSysAppId2();
            xmlNode.setAttribute(FIELD_PSSYSAPPID2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppName() != null) {
            object = pSSysRunSessionBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysAppName2() != null) {
            object = pSSysRunSessionBase.getPSSysAppName2();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysBDInstCfgId() != null) {
            object = pSSysRunSessionBase.getPSSysBDInstCfgId();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysBDInstCfgName() != null) {
            object = pSSysRunSessionBase.getPSSysBDInstCfgName();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysRunSessionId() != null) {
            object = pSSysRunSessionBase.getPSSysRunSessionId();
            xmlNode.setAttribute(FIELD_PSSYSRUNSESSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysRunSessionName() != null) {
            object = pSSysRunSessionBase.getPSSysRunSessionName();
            xmlNode.setAttribute(FIELD_PSSYSRUNSESSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysServiceAPIId() != null) {
            object = pSSysRunSessionBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysServiceAPIName() != null) {
            object = pSSysRunSessionBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysSFPubId() != null) {
            object = pSSysRunSessionBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSysSFPubName() != null) {
            object = pSSysRunSessionBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemASId() != null) {
            object = pSSysRunSessionBase.getPSSystemASId();
            xmlNode.setAttribute(FIELD_PSSYSTEMASID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemASName() != null) {
            object = pSSysRunSessionBase.getPSSystemASName();
            xmlNode.setAttribute(FIELD_PSSYSTEMASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemDBCfgId() != null) {
            object = pSSysRunSessionBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemDBCfgName() != null) {
            object = pSSysRunSessionBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemId() != null) {
            object = pSSysRunSessionBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getPSSystemName() != null) {
            object = pSSysRunSessionBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getQuickMode() != null) {
            object = pSSysRunSessionBase.getQuickMode();
            xmlNode.setAttribute(FIELD_QUICKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getRebuildMode() != null) {
            object = pSSysRunSessionBase.getRebuildMode();
            xmlNode.setAttribute(FIELD_REBUILDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getRunMode() != null) {
            object = pSSysRunSessionBase.getRunMode();
            xmlNode.setAttribute(FIELD_RUNMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam() != null) {
            object = pSSysRunSessionBase.getRunParam();
            xmlNode.setAttribute(FIELD_RUNPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam10() != null) {
            object = pSSysRunSessionBase.getRunParam10();
            xmlNode.setAttribute(FIELD_RUNPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam11() != null) {
            object = pSSysRunSessionBase.getRunParam11();
            xmlNode.setAttribute(FIELD_RUNPARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam12() != null) {
            object = pSSysRunSessionBase.getRunParam12();
            xmlNode.setAttribute(FIELD_RUNPARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam2() != null) {
            object = pSSysRunSessionBase.getRunParam2();
            xmlNode.setAttribute(FIELD_RUNPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam3() != null) {
            object = pSSysRunSessionBase.getRunParam3();
            xmlNode.setAttribute(FIELD_RUNPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam4() != null) {
            object = pSSysRunSessionBase.getRunParam4();
            xmlNode.setAttribute(FIELD_RUNPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam5() != null) {
            object = pSSysRunSessionBase.getRunParam5();
            xmlNode.setAttribute(FIELD_RUNPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getRunParam6() != null) {
            object = pSSysRunSessionBase.getRunParam6();
            xmlNode.setAttribute(FIELD_RUNPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getRunParam7() != null) {
            object = pSSysRunSessionBase.getRunParam7();
            xmlNode.setAttribute(FIELD_RUNPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam8() != null) {
            object = pSSysRunSessionBase.getRunParam8();
            xmlNode.setAttribute(FIELD_RUNPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunParam9() != null) {
            object = pSSysRunSessionBase.getRunParam9();
            xmlNode.setAttribute(FIELD_RUNPARAM9, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunPSSysDynaModelId() != null) {
            object = pSSysRunSessionBase.getRunPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_RUNPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunPSSysDynaModelName() != null) {
            object = pSSysRunSessionBase.getRunPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_RUNPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getRunState() != null) {
            object = pSSysRunSessionBase.getRunState();
            xmlNode.setAttribute(FIELD_RUNSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getSrcPSSysDMVerId() != null) {
            object = pSSysRunSessionBase.getSrcPSSysDMVerId();
            xmlNode.setAttribute(FIELD_SRCPSSYSDMVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getSrcPSSysDMVerName() != null) {
            object = pSSysRunSessionBase.getSrcPSSysDMVerName();
            xmlNode.setAttribute(FIELD_SRCPSSYSDMVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getStartTime() != null) {
            object = pSSysRunSessionBase.getStartTime();
            xmlNode.setAttribute(FIELD_STARTTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getStopWhenTemplError() != null) {
            object = pSSysRunSessionBase.getStopWhenTemplError();
            xmlNode.setAttribute(FIELD_STOPWHENTEMPLERROR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getUpdateDate() != null) {
            object = pSSysRunSessionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunSessionBase.getUpdateMan() != null) {
            object = pSSysRunSessionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getUserTag() != null) {
            object = pSSysRunSessionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunSessionBase.getUserTag2() != null) {
            object = pSSysRunSessionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRunSessionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRunSessionBase pSSysRunSessionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRunSessionBase.isCreateDateDirty() && (bl || pSSysRunSessionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRunSessionBase.getCreateDate());
        }
        if (pSSysRunSessionBase.isCreateManDirty() && (bl || pSSysRunSessionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRunSessionBase.getCreateMan());
        }
        if (pSSysRunSessionBase.isDebugModeDirty() && (bl || pSSysRunSessionBase.getDebugMode() != null)) {
            iDataObject.set(FIELD_DEBUGMODE, (Object)pSSysRunSessionBase.getDebugMode());
        }
        if (pSSysRunSessionBase.isEnableVCDirty() && (bl || pSSysRunSessionBase.getEnableVC() != null)) {
            iDataObject.set(FIELD_ENABLEVC, (Object)pSSysRunSessionBase.getEnableVC());
        }
        if (pSSysRunSessionBase.isEndTimeDirty() && (bl || pSSysRunSessionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSSysRunSessionBase.getEndTime());
        }
        if (pSSysRunSessionBase.isFixDBModelDirty() && (bl || pSSysRunSessionBase.getFixDBModel() != null)) {
            iDataObject.set(FIELD_FIXDBMODEL, (Object)pSSysRunSessionBase.getFixDBModel());
        }
        if (pSSysRunSessionBase.isMemoDirty() && (bl || pSSysRunSessionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysRunSessionBase.getMemo());
        }
        if (pSSysRunSessionBase.isPackModeDirty() && (bl || pSSysRunSessionBase.getPackMode() != null)) {
            iDataObject.set(FIELD_PACKMODE, (Object)pSSysRunSessionBase.getPackMode());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepAPIIdDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPIID, (Object)pSSysRunSessionBase.getPSDevSlnMSDepAPIId());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepAPINameDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPINAME, (Object)pSSysRunSessionBase.getPSDevSlnMSDepAPIName());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepAppIdDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPID, (Object)pSSysRunSessionBase.getPSDevSlnMSDepAppId());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepAppNameDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPNAME, (Object)pSSysRunSessionBase.getPSDevSlnMSDepAppName());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepFuncIdDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCID, (Object)pSSysRunSessionBase.getPSDevSlnMSDepFuncId());
        }
        if (pSSysRunSessionBase.isPSDevSlnMSDepFuncNameDirty() && (bl || pSSysRunSessionBase.getPSDevSlnMSDepFuncName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCNAME, (Object)pSSysRunSessionBase.getPSDevSlnMSDepFuncName());
        }
        if (pSSysRunSessionBase.isPSDSConsoleIdDirty() && (bl || pSSysRunSessionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSSysRunSessionBase.getPSDSConsoleId());
        }
        if (pSSysRunSessionBase.isPSDynaInstIdDirty() && (bl || pSSysRunSessionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysRunSessionBase.getPSDynaInstId());
        }
        if (pSSysRunSessionBase.isPSMobAppPackIdDirty() && (bl || pSSysRunSessionBase.getPSMobAppPackId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKID, (Object)pSSysRunSessionBase.getPSMobAppPackId());
        }
        if (pSSysRunSessionBase.isPSMobAppPackNameDirty() && (bl || pSSysRunSessionBase.getPSMobAppPackName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKNAME, (Object)pSSysRunSessionBase.getPSMobAppPackName());
        }
        if (pSSysRunSessionBase.isPSSysAppIdDirty() && (bl || pSSysRunSessionBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysRunSessionBase.getPSSysAppId());
        }
        if (pSSysRunSessionBase.isPSSysAppId2Dirty() && (bl || pSSysRunSessionBase.getPSSysAppId2() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID2, (Object)pSSysRunSessionBase.getPSSysAppId2());
        }
        if (pSSysRunSessionBase.isPSSysAppNameDirty() && (bl || pSSysRunSessionBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysRunSessionBase.getPSSysAppName());
        }
        if (pSSysRunSessionBase.isPSSysAppName2Dirty() && (bl || pSSysRunSessionBase.getPSSysAppName2() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME2, (Object)pSSysRunSessionBase.getPSSysAppName2());
        }
        if (pSSysRunSessionBase.isPSSysBDInstCfgIdDirty() && (bl || pSSysRunSessionBase.getPSSysBDInstCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGID, (Object)pSSysRunSessionBase.getPSSysBDInstCfgId());
        }
        if (pSSysRunSessionBase.isPSSysBDInstCfgNameDirty() && (bl || pSSysRunSessionBase.getPSSysBDInstCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGNAME, (Object)pSSysRunSessionBase.getPSSysBDInstCfgName());
        }
        if (pSSysRunSessionBase.isPSSysRunSessionIdDirty() && (bl || pSSysRunSessionBase.getPSSysRunSessionId() != null)) {
            iDataObject.set(FIELD_PSSYSRUNSESSIONID, (Object)pSSysRunSessionBase.getPSSysRunSessionId());
        }
        if (pSSysRunSessionBase.isPSSysRunSessionNameDirty() && (bl || pSSysRunSessionBase.getPSSysRunSessionName() != null)) {
            iDataObject.set(FIELD_PSSYSRUNSESSIONNAME, (Object)pSSysRunSessionBase.getPSSysRunSessionName());
        }
        if (pSSysRunSessionBase.isPSSysServiceAPIIdDirty() && (bl || pSSysRunSessionBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysRunSessionBase.getPSSysServiceAPIId());
        }
        if (pSSysRunSessionBase.isPSSysServiceAPINameDirty() && (bl || pSSysRunSessionBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysRunSessionBase.getPSSysServiceAPIName());
        }
        if (pSSysRunSessionBase.isPSSysSFPubIdDirty() && (bl || pSSysRunSessionBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysRunSessionBase.getPSSysSFPubId());
        }
        if (pSSysRunSessionBase.isPSSysSFPubNameDirty() && (bl || pSSysRunSessionBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysRunSessionBase.getPSSysSFPubName());
        }
        if (pSSysRunSessionBase.isPSSystemASIdDirty() && (bl || pSSysRunSessionBase.getPSSystemASId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASID, (Object)pSSysRunSessionBase.getPSSystemASId());
        }
        if (pSSysRunSessionBase.isPSSystemASNameDirty() && (bl || pSSysRunSessionBase.getPSSystemASName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASNAME, (Object)pSSysRunSessionBase.getPSSystemASName());
        }
        if (pSSysRunSessionBase.isPSSystemDBCfgIdDirty() && (bl || pSSysRunSessionBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSysRunSessionBase.getPSSystemDBCfgId());
        }
        if (pSSysRunSessionBase.isPSSystemDBCfgNameDirty() && (bl || pSSysRunSessionBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSysRunSessionBase.getPSSystemDBCfgName());
        }
        if (pSSysRunSessionBase.isPSSystemIdDirty() && (bl || pSSysRunSessionBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysRunSessionBase.getPSSystemId());
        }
        if (pSSysRunSessionBase.isPSSystemNameDirty() && (bl || pSSysRunSessionBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysRunSessionBase.getPSSystemName());
        }
        if (pSSysRunSessionBase.isQuickModeDirty() && (bl || pSSysRunSessionBase.getQuickMode() != null)) {
            iDataObject.set(FIELD_QUICKMODE, (Object)pSSysRunSessionBase.getQuickMode());
        }
        if (pSSysRunSessionBase.isRebuildModeDirty() && (bl || pSSysRunSessionBase.getRebuildMode() != null)) {
            iDataObject.set(FIELD_REBUILDMODE, (Object)pSSysRunSessionBase.getRebuildMode());
        }
        if (pSSysRunSessionBase.isRunModeDirty() && (bl || pSSysRunSessionBase.getRunMode() != null)) {
            iDataObject.set(FIELD_RUNMODE, (Object)pSSysRunSessionBase.getRunMode());
        }
        if (pSSysRunSessionBase.isRunParamDirty() && (bl || pSSysRunSessionBase.getRunParam() != null)) {
            iDataObject.set(FIELD_RUNPARAM, (Object)pSSysRunSessionBase.getRunParam());
        }
        if (pSSysRunSessionBase.isRunParam10Dirty() && (bl || pSSysRunSessionBase.getRunParam10() != null)) {
            iDataObject.set(FIELD_RUNPARAM10, (Object)pSSysRunSessionBase.getRunParam10());
        }
        if (pSSysRunSessionBase.isRunParam11Dirty() && (bl || pSSysRunSessionBase.getRunParam11() != null)) {
            iDataObject.set(FIELD_RUNPARAM11, (Object)pSSysRunSessionBase.getRunParam11());
        }
        if (pSSysRunSessionBase.isRunParam12Dirty() && (bl || pSSysRunSessionBase.getRunParam12() != null)) {
            iDataObject.set(FIELD_RUNPARAM12, (Object)pSSysRunSessionBase.getRunParam12());
        }
        if (pSSysRunSessionBase.isRunParam2Dirty() && (bl || pSSysRunSessionBase.getRunParam2() != null)) {
            iDataObject.set(FIELD_RUNPARAM2, (Object)pSSysRunSessionBase.getRunParam2());
        }
        if (pSSysRunSessionBase.isRunParam3Dirty() && (bl || pSSysRunSessionBase.getRunParam3() != null)) {
            iDataObject.set(FIELD_RUNPARAM3, (Object)pSSysRunSessionBase.getRunParam3());
        }
        if (pSSysRunSessionBase.isRunParam4Dirty() && (bl || pSSysRunSessionBase.getRunParam4() != null)) {
            iDataObject.set(FIELD_RUNPARAM4, (Object)pSSysRunSessionBase.getRunParam4());
        }
        if (pSSysRunSessionBase.isRunParam5Dirty() && (bl || pSSysRunSessionBase.getRunParam5() != null)) {
            iDataObject.set(FIELD_RUNPARAM5, (Object)pSSysRunSessionBase.getRunParam5());
        }
        if (pSSysRunSessionBase.isRunParam6Dirty() && (bl || pSSysRunSessionBase.getRunParam6() != null)) {
            iDataObject.set(FIELD_RUNPARAM6, (Object)pSSysRunSessionBase.getRunParam6());
        }
        if (pSSysRunSessionBase.isRunParam7Dirty() && (bl || pSSysRunSessionBase.getRunParam7() != null)) {
            iDataObject.set(FIELD_RUNPARAM7, (Object)pSSysRunSessionBase.getRunParam7());
        }
        if (pSSysRunSessionBase.isRunParam8Dirty() && (bl || pSSysRunSessionBase.getRunParam8() != null)) {
            iDataObject.set(FIELD_RUNPARAM8, (Object)pSSysRunSessionBase.getRunParam8());
        }
        if (pSSysRunSessionBase.isRunParam9Dirty() && (bl || pSSysRunSessionBase.getRunParam9() != null)) {
            iDataObject.set(FIELD_RUNPARAM9, (Object)pSSysRunSessionBase.getRunParam9());
        }
        if (pSSysRunSessionBase.isRunPSSysDynaModelIdDirty() && (bl || pSSysRunSessionBase.getRunPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_RUNPSSYSDYNAMODELID, (Object)pSSysRunSessionBase.getRunPSSysDynaModelId());
        }
        if (pSSysRunSessionBase.isRunPSSysDynaModelNameDirty() && (bl || pSSysRunSessionBase.getRunPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_RUNPSSYSDYNAMODELNAME, (Object)pSSysRunSessionBase.getRunPSSysDynaModelName());
        }
        if (pSSysRunSessionBase.isRunStateDirty() && (bl || pSSysRunSessionBase.getRunState() != null)) {
            iDataObject.set(FIELD_RUNSTATE, (Object)pSSysRunSessionBase.getRunState());
        }
        if (pSSysRunSessionBase.isSrcPSSysDMVerIdDirty() && (bl || pSSysRunSessionBase.getSrcPSSysDMVerId() != null)) {
            iDataObject.set(FIELD_SRCPSSYSDMVERID, (Object)pSSysRunSessionBase.getSrcPSSysDMVerId());
        }
        if (pSSysRunSessionBase.isSrcPSSysDMVerNameDirty() && (bl || pSSysRunSessionBase.getSrcPSSysDMVerName() != null)) {
            iDataObject.set(FIELD_SRCPSSYSDMVERNAME, (Object)pSSysRunSessionBase.getSrcPSSysDMVerName());
        }
        if (pSSysRunSessionBase.isStartTimeDirty() && (bl || pSSysRunSessionBase.getStartTime() != null)) {
            iDataObject.set(FIELD_STARTTIME, (Object)pSSysRunSessionBase.getStartTime());
        }
        if (pSSysRunSessionBase.isStopWhenTemplErrorDirty() && (bl || pSSysRunSessionBase.getStopWhenTemplError() != null)) {
            iDataObject.set(FIELD_STOPWHENTEMPLERROR, (Object)pSSysRunSessionBase.getStopWhenTemplError());
        }
        if (pSSysRunSessionBase.isUpdateDateDirty() && (bl || pSSysRunSessionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRunSessionBase.getUpdateDate());
        }
        if (pSSysRunSessionBase.isUpdateManDirty() && (bl || pSSysRunSessionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRunSessionBase.getUpdateMan());
        }
        if (pSSysRunSessionBase.isUserTagDirty() && (bl || pSSysRunSessionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysRunSessionBase.getUserTag());
        }
        if (pSSysRunSessionBase.isUserTag2Dirty() && (bl || pSSysRunSessionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysRunSessionBase.getUserTag2());
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
        return PSSysRunSessionBase.remove(this, n);
    }

    private static boolean remove(PSSysRunSessionBase pSSysRunSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRunSessionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysRunSessionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysRunSessionBase.resetDebugMode();
                return true;
            }
            case 3: {
                pSSysRunSessionBase.resetEnableVC();
                return true;
            }
            case 4: {
                pSSysRunSessionBase.resetEndTime();
                return true;
            }
            case 5: {
                pSSysRunSessionBase.resetFixDBModel();
                return true;
            }
            case 6: {
                pSSysRunSessionBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysRunSessionBase.resetPackMode();
                return true;
            }
            case 8: {
                pSSysRunSessionBase.resetPSDevSlnMSDepAPIId();
                return true;
            }
            case 9: {
                pSSysRunSessionBase.resetPSDevSlnMSDepAPIName();
                return true;
            }
            case 10: {
                pSSysRunSessionBase.resetPSDevSlnMSDepAppId();
                return true;
            }
            case 11: {
                pSSysRunSessionBase.resetPSDevSlnMSDepAppName();
                return true;
            }
            case 12: {
                pSSysRunSessionBase.resetPSDevSlnMSDepFuncId();
                return true;
            }
            case 13: {
                pSSysRunSessionBase.resetPSDevSlnMSDepFuncName();
                return true;
            }
            case 14: {
                pSSysRunSessionBase.resetPSDSConsoleId();
                return true;
            }
            case 15: {
                pSSysRunSessionBase.resetPSDynaInstId();
                return true;
            }
            case 16: {
                pSSysRunSessionBase.resetPSMobAppPackId();
                return true;
            }
            case 17: {
                pSSysRunSessionBase.resetPSMobAppPackName();
                return true;
            }
            case 18: {
                pSSysRunSessionBase.resetPSSysAppId();
                return true;
            }
            case 19: {
                pSSysRunSessionBase.resetPSSysAppId2();
                return true;
            }
            case 20: {
                pSSysRunSessionBase.resetPSSysAppName();
                return true;
            }
            case 21: {
                pSSysRunSessionBase.resetPSSysAppName2();
                return true;
            }
            case 22: {
                pSSysRunSessionBase.resetPSSysBDInstCfgId();
                return true;
            }
            case 23: {
                pSSysRunSessionBase.resetPSSysBDInstCfgName();
                return true;
            }
            case 24: {
                pSSysRunSessionBase.resetPSSysRunSessionId();
                return true;
            }
            case 25: {
                pSSysRunSessionBase.resetPSSysRunSessionName();
                return true;
            }
            case 26: {
                pSSysRunSessionBase.resetPSSysServiceAPIId();
                return true;
            }
            case 27: {
                pSSysRunSessionBase.resetPSSysServiceAPIName();
                return true;
            }
            case 28: {
                pSSysRunSessionBase.resetPSSysSFPubId();
                return true;
            }
            case 29: {
                pSSysRunSessionBase.resetPSSysSFPubName();
                return true;
            }
            case 30: {
                pSSysRunSessionBase.resetPSSystemASId();
                return true;
            }
            case 31: {
                pSSysRunSessionBase.resetPSSystemASName();
                return true;
            }
            case 32: {
                pSSysRunSessionBase.resetPSSystemDBCfgId();
                return true;
            }
            case 33: {
                pSSysRunSessionBase.resetPSSystemDBCfgName();
                return true;
            }
            case 34: {
                pSSysRunSessionBase.resetPSSystemId();
                return true;
            }
            case 35: {
                pSSysRunSessionBase.resetPSSystemName();
                return true;
            }
            case 36: {
                pSSysRunSessionBase.resetQuickMode();
                return true;
            }
            case 37: {
                pSSysRunSessionBase.resetRebuildMode();
                return true;
            }
            case 38: {
                pSSysRunSessionBase.resetRunMode();
                return true;
            }
            case 39: {
                pSSysRunSessionBase.resetRunParam();
                return true;
            }
            case 40: {
                pSSysRunSessionBase.resetRunParam10();
                return true;
            }
            case 41: {
                pSSysRunSessionBase.resetRunParam11();
                return true;
            }
            case 42: {
                pSSysRunSessionBase.resetRunParam12();
                return true;
            }
            case 43: {
                pSSysRunSessionBase.resetRunParam2();
                return true;
            }
            case 44: {
                pSSysRunSessionBase.resetRunParam3();
                return true;
            }
            case 45: {
                pSSysRunSessionBase.resetRunParam4();
                return true;
            }
            case 46: {
                pSSysRunSessionBase.resetRunParam5();
                return true;
            }
            case 47: {
                pSSysRunSessionBase.resetRunParam6();
                return true;
            }
            case 48: {
                pSSysRunSessionBase.resetRunParam7();
                return true;
            }
            case 49: {
                pSSysRunSessionBase.resetRunParam8();
                return true;
            }
            case 50: {
                pSSysRunSessionBase.resetRunParam9();
                return true;
            }
            case 51: {
                pSSysRunSessionBase.resetRunPSSysDynaModelId();
                return true;
            }
            case 52: {
                pSSysRunSessionBase.resetRunPSSysDynaModelName();
                return true;
            }
            case 53: {
                pSSysRunSessionBase.resetRunState();
                return true;
            }
            case 54: {
                pSSysRunSessionBase.resetSrcPSSysDMVerId();
                return true;
            }
            case 55: {
                pSSysRunSessionBase.resetSrcPSSysDMVerName();
                return true;
            }
            case 56: {
                pSSysRunSessionBase.resetStartTime();
                return true;
            }
            case 57: {
                pSSysRunSessionBase.resetStopWhenTemplError();
                return true;
            }
            case 58: {
                pSSysRunSessionBase.resetUpdateDate();
                return true;
            }
            case 59: {
                pSSysRunSessionBase.resetUpdateMan();
                return true;
            }
            case 60: {
                pSSysRunSessionBase.resetUserTag();
                return true;
            }
            case 61: {
                pSSysRunSessionBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepAPI getPSDevSlnMSDepAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPI();
        }
        if (this.getPSDevSlnMSDepAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepAPILock;
        synchronized (n) {
            if (this.psdevslnmsdepapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepAPIId(), (Object)this.psdevslnmsdepapi.getPSDevSlnMSDepAPIId()) != 0L) {
                this.psdevslnmsdepapi = null;
            }
            if (this.psdevslnmsdepapi == null) {
                PSDevSlnMSDepAPI pSDevSlnMSDepAPI = new PSDevSlnMSDepAPI();
                pSDevSlnMSDepAPI.setPSDevSlnMSDepAPIId(this.getPSDevSlnMSDepAPIId());
                PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepAPIService.autoGet(pSDevSlnMSDepAPI);
                this.psdevslnmsdepapi = pSDevSlnMSDepAPI;
            }
            return this.psdevslnmsdepapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepApp getPSDevSlnMSDepApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepApp();
        }
        if (this.getPSDevSlnMSDepAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepAppLock;
        synchronized (n) {
            if (this.psdevslnmsdepapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepAppId(), (Object)this.psdevslnmsdepapp.getPSDevSlnMSDepAppId()) != 0L) {
                this.psdevslnmsdepapp = null;
            }
            if (this.psdevslnmsdepapp == null) {
                PSDevSlnMSDepApp pSDevSlnMSDepApp = new PSDevSlnMSDepApp();
                pSDevSlnMSDepApp.setPSDevSlnMSDepAppId(this.getPSDevSlnMSDepAppId());
                PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepAppService.autoGet(pSDevSlnMSDepApp);
                this.psdevslnmsdepapp = pSDevSlnMSDepApp;
            }
            return this.psdevslnmsdepapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepFunc getPSDevSlnMSDepFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFunc();
        }
        if (this.getPSDevSlnMSDepFuncId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepFuncLock;
        synchronized (n) {
            if (this.psdevslnmsdepfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepFuncId(), (Object)this.psdevslnmsdepfunc.getPSDevSlnMSDepFuncId()) != 0L) {
                this.psdevslnmsdepfunc = null;
            }
            if (this.psdevslnmsdepfunc == null) {
                PSDevSlnMSDepFunc pSDevSlnMSDepFunc = new PSDevSlnMSDepFunc();
                pSDevSlnMSDepFunc.setPSDevSlnMSDepFuncId(this.getPSDevSlnMSDepFuncId());
                PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepFuncService.autoGet(pSDevSlnMSDepFunc);
                this.psdevslnmsdepfunc = pSDevSlnMSDepFunc;
            }
            return this.psdevslnmsdepfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMobAppPack getPSMobAppPack() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPack();
        }
        if (this.getPSMobAppPackId() == null) {
            return null;
        }
        Integer n = this.objPSMobAppPackLock;
        synchronized (n) {
            if (this.psmobapppack != null && DataTypeHelper.compare((int)25, (Object)this.getPSMobAppPackId(), (Object)this.psmobapppack.getPSMobAppPackId()) != 0L) {
                this.psmobapppack = null;
            }
            if (this.psmobapppack == null) {
                PSMobAppPack pSMobAppPack = new PSMobAppPack();
                pSMobAppPack.setPSMobAppPackId(this.getPSMobAppPackId());
                PSMobAppPackService pSMobAppPackService = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
                pSMobAppPackService.autoGet(pSMobAppPack);
                this.psmobapppack = pSMobAppPack;
            }
            return this.psmobapppack;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp2();
        }
        if (this.getPSSysAppId2() == null) {
            return null;
        }
        Integer n = this.objPSSysApp2Lock;
        synchronized (n) {
            if (this.pssysapp2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId2(), (Object)this.pssysapp2.getPSSysAppId()) != 0L) {
                this.pssysapp2 = null;
            }
            if (this.pssysapp2 == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId2());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp2 = pSSysApp;
            }
            return this.pssysapp2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDInstCfg getPSSysBDInstCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfg();
        }
        if (this.getPSSysBDInstCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDInstCfgLock;
        synchronized (n) {
            if (this.pssysbdinstcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDInstCfgId(), (Object)this.pssysbdinstcfg.getPSSysBDInstCfgId()) != 0L) {
                this.pssysbdinstcfg = null;
            }
            if (this.pssysbdinstcfg == null) {
                PSSysBDInstCfg pSSysBDInstCfg = new PSSysBDInstCfg();
                pSSysBDInstCfg.setPSSysBDInstCfgId(this.getPSSysBDInstCfgId());
                PSSysBDInstCfgService pSSysBDInstCfgService = (PSSysBDInstCfgService)ServiceGlobal.getService(PSSysBDInstCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDInstCfgService.autoGet(pSSysBDInstCfg);
                this.pssysbdinstcfg = pSSysBDInstCfg;
            }
            return this.pssysbdinstcfg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDMVer getSrcPSSysDMVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysDMVer();
        }
        if (this.getSrcPSSysDMVerId() == null) {
            return null;
        }
        Integer n = this.objSrcPSSysDMVerLock;
        synchronized (n) {
            if (this.srcpssysdmver != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSSysDMVerId(), (Object)this.srcpssysdmver.getPSSysDMVerId()) != 0L) {
                this.srcpssysdmver = null;
            }
            if (this.srcpssysdmver == null) {
                PSSysDMVer pSSysDMVer = new PSSysDMVer();
                pSSysDMVer.setPSSysDMVerId(this.getSrcPSSysDMVerId());
                PSSysDMVerService pSSysDMVerService = (PSSysDMVerService)ServiceGlobal.getService(PSSysDMVerService.class, (SessionFactory)this.getSessionFactory());
                pSSysDMVerService.autoGet(pSSysDMVer);
                this.srcpssysdmver = pSSysDMVer;
            }
            return this.srcpssysdmver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getRunPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModel();
        }
        if (this.getRunPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objRunPSSysDynaModelLock;
        synchronized (n) {
            if (this.runpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getRunPSSysDynaModelId(), (Object)this.runpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.runpssysdynamodel = null;
            }
            if (this.runpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getRunPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.runpssysdynamodel = pSSysDynaModel;
            }
            return this.runpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPub();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPubLock;
        synchronized (n) {
            if (this.pssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPubId(), (Object)this.pssyssfpub.getPSSysSFPubId()) != 0L) {
                this.pssyssfpub = null;
            }
            if (this.pssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet(pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemAS getPSSystemAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemAS();
        }
        if (this.getPSSystemASId() == null) {
            return null;
        }
        Integer n = this.objPSSystemASLock;
        synchronized (n) {
            if (this.pssystemas != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemASId(), (Object)this.pssystemas.getPSSystemASId()) != 0L) {
                this.pssystemas = null;
            }
            if (this.pssystemas == null) {
                PSSystemAS pSSystemAS = new PSSystemAS();
                pSSystemAS.setPSSystemASId(this.getPSSystemASId());
                PSSystemASService pSSystemASService = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, (SessionFactory)this.getSessionFactory());
                pSSystemASService.autoGet(pSSystemAS);
                this.pssystemas = pSSystemAS;
            }
            return this.pssystemas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemDBCfg getPSSystemDBCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfg();
        }
        if (this.getPSSystemDBCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSystemDBCfgLock;
        synchronized (n) {
            if (this.pssystemdbcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemDBCfgId(), (Object)this.pssystemdbcfg.getPSSystemDBCfgId()) != 0L) {
                this.pssystemdbcfg = null;
            }
            if (this.pssystemdbcfg == null) {
                PSSystemDBCfg pSSystemDBCfg = new PSSystemDBCfg();
                pSSystemDBCfg.setPSSystemDBCfgId(this.getPSSystemDBCfgId());
                PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSystemDBCfgService.autoGet(pSSystemDBCfg);
                this.pssystemdbcfg = pSSystemDBCfg;
            }
            return this.pssystemdbcfg;
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

    private PSSysRunSessionBase getProxyEntity() {
        return this.proxyPSSysRunSessionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRunSessionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRunSessionBase) {
            this.proxyPSSysRunSessionBase = (PSSysRunSessionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEBUGMODE, 2);
        fieldIndexMap.put(FIELD_ENABLEVC, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_FIXDBMODEL, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PACKMODE, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPIID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPINAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, 13);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 14);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 15);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKID, 16);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 18);
        fieldIndexMap.put(FIELD_PSSYSAPPID2, 19);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME2, 21);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGID, 22);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSRUNSESSIONID, 24);
        fieldIndexMap.put(FIELD_PSSYSRUNSESSIONNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 26);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 27);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSTEMASID, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMASNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 35);
        fieldIndexMap.put(FIELD_QUICKMODE, 36);
        fieldIndexMap.put(FIELD_REBUILDMODE, 37);
        fieldIndexMap.put(FIELD_RUNMODE, 38);
        fieldIndexMap.put(FIELD_RUNPARAM, 39);
        fieldIndexMap.put(FIELD_RUNPARAM10, 40);
        fieldIndexMap.put(FIELD_RUNPARAM11, 41);
        fieldIndexMap.put(FIELD_RUNPARAM12, 42);
        fieldIndexMap.put(FIELD_RUNPARAM2, 43);
        fieldIndexMap.put(FIELD_RUNPARAM3, 44);
        fieldIndexMap.put(FIELD_RUNPARAM4, 45);
        fieldIndexMap.put(FIELD_RUNPARAM5, 46);
        fieldIndexMap.put(FIELD_RUNPARAM6, 47);
        fieldIndexMap.put(FIELD_RUNPARAM7, 48);
        fieldIndexMap.put(FIELD_RUNPARAM8, 49);
        fieldIndexMap.put(FIELD_RUNPARAM9, 50);
        fieldIndexMap.put(FIELD_RUNPSSYSDYNAMODELID, 51);
        fieldIndexMap.put(FIELD_RUNPSSYSDYNAMODELNAME, 52);
        fieldIndexMap.put(FIELD_RUNSTATE, 53);
        fieldIndexMap.put(FIELD_SRCPSSYSDMVERID, 54);
        fieldIndexMap.put(FIELD_SRCPSSYSDMVERNAME, 55);
        fieldIndexMap.put(FIELD_STARTTIME, 56);
        fieldIndexMap.put(FIELD_STOPWHENTEMPLERROR, 57);
        fieldIndexMap.put(FIELD_UPDATEDATE, 58);
        fieldIndexMap.put(FIELD_UPDATEMAN, 59);
        fieldIndexMap.put(FIELD_USERTAG, 60);
        fieldIndexMap.put(FIELD_USERTAG2, 61);
    }
}

