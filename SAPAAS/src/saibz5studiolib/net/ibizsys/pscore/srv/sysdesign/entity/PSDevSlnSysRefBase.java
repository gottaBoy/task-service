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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DENAMES = "DENAMES";
    public static final String FIELD_IGNOREIMPDBMODEL = "IGNOREIMPDBMODEL";
    public static final String FIELD_IGNOREIMPUIMODEL = "IGNOREIMPUIMODEL";
    public static final String FIELD_IGNOREIMPWFMODEL = "IGNOREIMPWFMODEL";
    public static final String FIELD_IMPCOREMODELONLY = "IMPCOREMODELONLY";
    public static final String FIELD_IMPMODE = "IMPMODE";
    public static final String FIELD_IMPUIMODEL = "IMPUIMODEL";
    public static final String FIELD_LINKCODE = "LINKCODE";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_LINKREPMSG = "LINKREPMSG";
    public static final String FIELD_LINKREQMSG = "LINKREQMSG";
    public static final String FIELD_LINKSTATE = "LINKSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULELIST = "MODULELIST";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSREFID = "PSDEVSLNSYSREFID";
    public static final String FIELD_PSDEVSLNSYSREFNAME = "PSDEVSLNSYSREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPARAM = "REFPARAM";
    public static final String FIELD_REFPARAM2 = "REFPARAM2";
    public static final String FIELD_REFPARAMS = "REFPARAMS";
    public static final String FIELD_REFPSDEVSLNID = "REFPSDEVSLNID";
    public static final String FIELD_REFPSDEVSLNNAME = "REFPSDEVSLNNAME";
    public static final String FIELD_REFPSDEVSLNSYSAPIID = "REFPSDEVSLNSYSAPIID";
    public static final String FIELD_REFPSDEVSLNSYSAPINAME = "REFPSDEVSLNSYSAPINAME";
    public static final String FIELD_REFPSDEVSLNSYSID = "REFPSDEVSLNSYSID";
    public static final String FIELD_REFPSDEVSLNSYSNAME = "REFPSDEVSLNSYSNAME";
    public static final String FIELD_REFPSDEVSLNSYSSRVID = "REFPSDEVSLNSYSSRVID";
    public static final String FIELD_REFPSDEVSLNSYSSRVNAME = "REFPSDEVSLNSYSSRVNAME";
    public static final String FIELD_SETDENAMESFLAG = "SETDENAMESFLAG";
    public static final String FIELD_SETMODULEFLAG = "SETMODULEFLAG";
    public static final String FIELD_SYSCODENAME = "SYSCODENAME";
    public static final String FIELD_SYSPKGNAME = "SYSPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGE = "USAGE";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DENAMES = 2;
    private static final int INDEX_IGNOREIMPDBMODEL = 3;
    private static final int INDEX_IGNOREIMPUIMODEL = 4;
    private static final int INDEX_IGNOREIMPWFMODEL = 5;
    private static final int INDEX_IMPCOREMODELONLY = 6;
    private static final int INDEX_IMPMODE = 7;
    private static final int INDEX_IMPUIMODEL = 8;
    private static final int INDEX_LINKCODE = 9;
    private static final int INDEX_LINKFLAG = 10;
    private static final int INDEX_LINKREPMSG = 11;
    private static final int INDEX_LINKREQMSG = 12;
    private static final int INDEX_LINKSTATE = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MODULELIST = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDEVSLNSYSID = 18;
    private static final int INDEX_PSDEVSLNSYSNAME = 19;
    private static final int INDEX_PSDEVSLNSYSREFID = 20;
    private static final int INDEX_PSDEVSLNSYSREFNAME = 21;
    private static final int INDEX_REFMODE = 22;
    private static final int INDEX_REFPARAM = 23;
    private static final int INDEX_REFPARAM2 = 24;
    private static final int INDEX_REFPARAMS = 25;
    private static final int INDEX_REFPSDEVSLNID = 26;
    private static final int INDEX_REFPSDEVSLNNAME = 27;
    private static final int INDEX_REFPSDEVSLNSYSAPIID = 28;
    private static final int INDEX_REFPSDEVSLNSYSAPINAME = 29;
    private static final int INDEX_REFPSDEVSLNSYSID = 30;
    private static final int INDEX_REFPSDEVSLNSYSNAME = 31;
    private static final int INDEX_REFPSDEVSLNSYSSRVID = 32;
    private static final int INDEX_REFPSDEVSLNSYSSRVNAME = 33;
    private static final int INDEX_SETDENAMESFLAG = 34;
    private static final int INDEX_SETMODULEFLAG = 35;
    private static final int INDEX_SYSCODENAME = 36;
    private static final int INDEX_SYSPKGNAME = 37;
    private static final int INDEX_UPDATEDATE = 38;
    private static final int INDEX_UPDATEMAN = 39;
    private static final int INDEX_USAGE = 40;
    private static final int INDEX_USERCAT = 41;
    private static final int INDEX_USERTAG = 42;
    private static final int INDEX_USERTAG2 = 43;
    private static final int INDEX_USERTAG3 = 44;
    private static final int INDEX_USERTAG4 = 45;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysRefBase proxyPSDevSlnSysRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean denamesDirtyFlag = false;
    private boolean ignoreimpdbmodelDirtyFlag = false;
    private boolean ignoreimpuimodelDirtyFlag = false;
    private boolean ignoreimpwfmodelDirtyFlag = false;
    private boolean impcoremodelonlyDirtyFlag = false;
    private boolean impmodeDirtyFlag = false;
    private boolean impuimodelDirtyFlag = false;
    private boolean linkcodeDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean linkrepmsgDirtyFlag = false;
    private boolean linkreqmsgDirtyFlag = false;
    private boolean linkstateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modulelistDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysrefidDirtyFlag = false;
    private boolean psdevslnsysrefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refparamDirtyFlag = false;
    private boolean refparam2DirtyFlag = false;
    private boolean refparamsDirtyFlag = false;
    private boolean refpsdevslnidDirtyFlag = false;
    private boolean refpsdevslnnameDirtyFlag = false;
    private boolean refpsdevslnsysapiidDirtyFlag = false;
    private boolean refpsdevslnsysapinameDirtyFlag = false;
    private boolean refpsdevslnsysidDirtyFlag = false;
    private boolean refpsdevslnsysnameDirtyFlag = false;
    private boolean refpsdevslnsyssrvidDirtyFlag = false;
    private boolean refpsdevslnsyssrvnameDirtyFlag = false;
    private boolean setdenamesflagDirtyFlag = false;
    private boolean setmoduleflagDirtyFlag = false;
    private boolean syscodenameDirtyFlag = false;
    private boolean syspkgnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usageDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="denames")
    private String denames;
    @Column(name="ignoreimpdbmodel")
    private Integer ignoreimpdbmodel;
    @Column(name="ignoreimpuimodel")
    private Integer ignoreimpuimodel;
    @Column(name="ignoreimpwfmodel")
    private Integer ignoreimpwfmodel;
    @Column(name="impcoremodelonly")
    private Integer impcoremodelonly;
    @Column(name="impmode")
    private String impmode;
    @Column(name="impuimodel")
    private Integer impuimodel;
    @Column(name="linkcode")
    private String linkcode;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="linkrepmsg")
    private String linkrepmsg;
    @Column(name="linkreqmsg")
    private String linkreqmsg;
    @Column(name="linkstate")
    private Integer linkstate;
    @Column(name="memo")
    private String memo;
    @Column(name="modulelist")
    private String modulelist;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysrefid")
    private String psdevslnsysrefid;
    @Column(name="psdevslnsysrefname")
    private String psdevslnsysrefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refparam")
    private String refparam;
    @Column(name="refparam2")
    private String refparam2;
    @Column(name="refparams")
    private String refparams;
    @Column(name="refpsdevslnid")
    private String refpsdevslnid;
    @Column(name="refpsdevslnname")
    private String refpsdevslnname;
    @Column(name="refpsdevslnsysapiid")
    private String refpsdevslnsysapiid;
    @Column(name="refpsdevslnsysapiname")
    private String refpsdevslnsysapiname;
    @Column(name="refpsdevslnsysid")
    private String refpsdevslnsysid;
    @Column(name="refpsdevslnsysname")
    private String refpsdevslnsysname;
    @Column(name="refpsdevslnsyssrvid")
    private String refpsdevslnsyssrvid;
    @Column(name="refpsdevslnsyssrvname")
    private String refpsdevslnsyssrvname;
    @Column(name="setdenamesflag")
    private Integer setdenamesflag;
    @Column(name="setmoduleflag")
    private Integer setmoduleflag;
    @Column(name="syscodename")
    private String syscodename;
    @Column(name="syspkgname")
    private String syspkgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usage")
    private String usage;
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
    private Integer objRefPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI refpsdevslnsysapi = null;
    private Integer objRefPSDevSlnSysSrvLock = new Integer(1);
    private PSDevSlnSysSrv refpsdevslnsyssrv = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objRefPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys refpsdevslnsys = null;
    private Integer objRefPSDevSlnLock = new Integer(1);
    private PSDevSln refpsdevsln = null;

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

    public void setDENames(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDENames(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.denames = string;
        this.denamesDirtyFlag = true;
    }

    public String getDENames() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDENames();
        }
        return this.denames;
    }

    public boolean isDENamesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENamesDirty();
        }
        return this.denamesDirtyFlag;
    }

    public void resetDENames() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDENames();
            return;
        }
        this.denamesDirtyFlag = false;
        this.denames = null;
    }

    public void setIgnoreImpDBModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreImpDBModel(n);
            return;
        }
        this.ignoreimpdbmodel = n;
        this.ignoreimpdbmodelDirtyFlag = true;
    }

    public Integer getIgnoreImpDBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreImpDBModel();
        }
        return this.ignoreimpdbmodel;
    }

    public boolean isIgnoreImpDBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreImpDBModelDirty();
        }
        return this.ignoreimpdbmodelDirtyFlag;
    }

    public void resetIgnoreImpDBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreImpDBModel();
            return;
        }
        this.ignoreimpdbmodelDirtyFlag = false;
        this.ignoreimpdbmodel = null;
    }

    public void setIgnoreImpUIModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreImpUIModel(n);
            return;
        }
        this.ignoreimpuimodel = n;
        this.ignoreimpuimodelDirtyFlag = true;
    }

    public Integer getIgnoreImpUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreImpUIModel();
        }
        return this.ignoreimpuimodel;
    }

    public boolean isIgnoreImpUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreImpUIModelDirty();
        }
        return this.ignoreimpuimodelDirtyFlag;
    }

    public void resetIgnoreImpUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreImpUIModel();
            return;
        }
        this.ignoreimpuimodelDirtyFlag = false;
        this.ignoreimpuimodel = null;
    }

    public void setIgnoreImpWFModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreImpWFModel(n);
            return;
        }
        this.ignoreimpwfmodel = n;
        this.ignoreimpwfmodelDirtyFlag = true;
    }

    public Integer getIgnoreImpWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreImpWFModel();
        }
        return this.ignoreimpwfmodel;
    }

    public boolean isIgnoreImpWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreImpWFModelDirty();
        }
        return this.ignoreimpwfmodelDirtyFlag;
    }

    public void resetIgnoreImpWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreImpWFModel();
            return;
        }
        this.ignoreimpwfmodelDirtyFlag = false;
        this.ignoreimpwfmodel = null;
    }

    public void setImpCoreModelOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpCoreModelOnly(n);
            return;
        }
        this.impcoremodelonly = n;
        this.impcoremodelonlyDirtyFlag = true;
    }

    public Integer getImpCoreModelOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpCoreModelOnly();
        }
        return this.impcoremodelonly;
    }

    public boolean isImpCoreModelOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpCoreModelOnlyDirty();
        }
        return this.impcoremodelonlyDirtyFlag;
    }

    public void resetImpCoreModelOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpCoreModelOnly();
            return;
        }
        this.impcoremodelonlyDirtyFlag = false;
        this.impcoremodelonly = null;
    }

    public void setImpMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.impmode = string;
        this.impmodeDirtyFlag = true;
    }

    public String getImpMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpMode();
        }
        return this.impmode;
    }

    public boolean isImpModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpModeDirty();
        }
        return this.impmodeDirtyFlag;
    }

    public void resetImpMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpMode();
            return;
        }
        this.impmodeDirtyFlag = false;
        this.impmode = null;
    }

    public void setImpUIModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpUIModel(n);
            return;
        }
        this.impuimodel = n;
        this.impuimodelDirtyFlag = true;
    }

    public Integer getImpUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpUIModel();
        }
        return this.impuimodel;
    }

    public boolean isImpUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpUIModelDirty();
        }
        return this.impuimodelDirtyFlag;
    }

    public void resetImpUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpUIModel();
            return;
        }
        this.impuimodelDirtyFlag = false;
        this.impuimodel = null;
    }

    public void setLinkCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkcode = string;
        this.linkcodeDirtyFlag = true;
    }

    public String getLinkCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkCode();
        }
        return this.linkcode;
    }

    public boolean isLinkCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkCodeDirty();
        }
        return this.linkcodeDirtyFlag;
    }

    public void resetLinkCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkCode();
            return;
        }
        this.linkcodeDirtyFlag = false;
        this.linkcode = null;
    }

    public void setLinkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkFlag(n);
            return;
        }
        this.linkflag = n;
        this.linkflagDirtyFlag = true;
    }

    public Integer getLinkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkFlag();
        }
        return this.linkflag;
    }

    public boolean isLinkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkFlagDirty();
        }
        return this.linkflagDirtyFlag;
    }

    public void resetLinkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkFlag();
            return;
        }
        this.linkflagDirtyFlag = false;
        this.linkflag = null;
    }

    public void setLinkRepMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkRepMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkrepmsg = string;
        this.linkrepmsgDirtyFlag = true;
    }

    public String getLinkRepMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkRepMsg();
        }
        return this.linkrepmsg;
    }

    public boolean isLinkRepMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkRepMsgDirty();
        }
        return this.linkrepmsgDirtyFlag;
    }

    public void resetLinkRepMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkRepMsg();
            return;
        }
        this.linkrepmsgDirtyFlag = false;
        this.linkrepmsg = null;
    }

    public void setLinkReqMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkReqMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkreqmsg = string;
        this.linkreqmsgDirtyFlag = true;
    }

    public String getLinkReqMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkReqMsg();
        }
        return this.linkreqmsg;
    }

    public boolean isLinkReqMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkReqMsgDirty();
        }
        return this.linkreqmsgDirtyFlag;
    }

    public void resetLinkReqMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkReqMsg();
            return;
        }
        this.linkreqmsgDirtyFlag = false;
        this.linkreqmsg = null;
    }

    public void setLinkState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkState(n);
            return;
        }
        this.linkstate = n;
        this.linkstateDirtyFlag = true;
    }

    public Integer getLinkState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkState();
        }
        return this.linkstate;
    }

    public boolean isLinkStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkStateDirty();
        }
        return this.linkstateDirtyFlag;
    }

    public void resetLinkState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkState();
            return;
        }
        this.linkstateDirtyFlag = false;
        this.linkstate = null;
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

    public void setModuleList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulelist = string;
        this.modulelistDirtyFlag = true;
    }

    public String getModuleList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleList();
        }
        return this.modulelist;
    }

    public boolean isModuleListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleListDirty();
        }
        return this.modulelistDirtyFlag;
    }

    public void resetModuleList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleList();
            return;
        }
        this.modulelistDirtyFlag = false;
        this.modulelist = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysrefid = string;
        this.psdevslnsysrefidDirtyFlag = true;
    }

    public String getPSDevSlnSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefId();
        }
        return this.psdevslnsysrefid;
    }

    public boolean isPSDevSlnSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefIdDirty();
        }
        return this.psdevslnsysrefidDirtyFlag;
    }

    public void resetPSDevSlnSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefId();
            return;
        }
        this.psdevslnsysrefidDirtyFlag = false;
        this.psdevslnsysrefid = null;
    }

    public void setPSDevSlnSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysrefname = string;
        this.psdevslnsysrefnameDirtyFlag = true;
    }

    public String getPSDevSlnSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefName();
        }
        return this.psdevslnsysrefname;
    }

    public boolean isPSDevSlnSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefNameDirty();
        }
        return this.psdevslnsysrefnameDirtyFlag;
    }

    public void resetPSDevSlnSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefName();
            return;
        }
        this.psdevslnsysrefnameDirtyFlag = false;
        this.psdevslnsysrefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam = string;
        this.refparamDirtyFlag = true;
    }

    public String getRefParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam();
        }
        return this.refparam;
    }

    public boolean isRefParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDirty();
        }
        return this.refparamDirtyFlag;
    }

    public void resetRefParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam();
            return;
        }
        this.refparamDirtyFlag = false;
        this.refparam = null;
    }

    public void setRefParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam2 = string;
        this.refparam2DirtyFlag = true;
    }

    public String getRefParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam2();
        }
        return this.refparam2;
    }

    public boolean isRefParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParam2Dirty();
        }
        return this.refparam2DirtyFlag;
    }

    public void resetRefParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam2();
            return;
        }
        this.refparam2DirtyFlag = false;
        this.refparam2 = null;
    }

    public void setRefParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparams = string;
        this.refparamsDirtyFlag = true;
    }

    public String getRefParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParams();
        }
        return this.refparams;
    }

    public boolean isRefParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamsDirty();
        }
        return this.refparamsDirtyFlag;
    }

    public void resetRefParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParams();
            return;
        }
        this.refparamsDirtyFlag = false;
        this.refparams = null;
    }

    public void setRefPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnid = string;
        this.refpsdevslnidDirtyFlag = true;
    }

    public String getRefPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnId();
        }
        return this.refpsdevslnid;
    }

    public boolean isRefPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnIdDirty();
        }
        return this.refpsdevslnidDirtyFlag;
    }

    public void resetRefPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnId();
            return;
        }
        this.refpsdevslnidDirtyFlag = false;
        this.refpsdevslnid = null;
    }

    public void setRefPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnname = string;
        this.refpsdevslnnameDirtyFlag = true;
    }

    public String getRefPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnName();
        }
        return this.refpsdevslnname;
    }

    public boolean isRefPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnNameDirty();
        }
        return this.refpsdevslnnameDirtyFlag;
    }

    public void resetRefPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnName();
            return;
        }
        this.refpsdevslnnameDirtyFlag = false;
        this.refpsdevslnname = null;
    }

    public void setRefPSDevSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysapiid = string;
        this.refpsdevslnsysapiidDirtyFlag = true;
    }

    public String getRefPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysAPIId();
        }
        return this.refpsdevslnsysapiid;
    }

    public boolean isRefPSDevSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysAPIIdDirty();
        }
        return this.refpsdevslnsysapiidDirtyFlag;
    }

    public void resetRefPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysAPIId();
            return;
        }
        this.refpsdevslnsysapiidDirtyFlag = false;
        this.refpsdevslnsysapiid = null;
    }

    public void setRefPSDevSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysapiname = string;
        this.refpsdevslnsysapinameDirtyFlag = true;
    }

    public String getRefPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysAPIName();
        }
        return this.refpsdevslnsysapiname;
    }

    public boolean isRefPSDevSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysAPINameDirty();
        }
        return this.refpsdevslnsysapinameDirtyFlag;
    }

    public void resetRefPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysAPIName();
            return;
        }
        this.refpsdevslnsysapinameDirtyFlag = false;
        this.refpsdevslnsysapiname = null;
    }

    public void setRefPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysid = string;
        this.refpsdevslnsysidDirtyFlag = true;
    }

    public String getRefPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysId();
        }
        return this.refpsdevslnsysid;
    }

    public boolean isRefPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysIdDirty();
        }
        return this.refpsdevslnsysidDirtyFlag;
    }

    public void resetRefPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysId();
            return;
        }
        this.refpsdevslnsysidDirtyFlag = false;
        this.refpsdevslnsysid = null;
    }

    public void setRefPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysname = string;
        this.refpsdevslnsysnameDirtyFlag = true;
    }

    public String getRefPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysName();
        }
        return this.refpsdevslnsysname;
    }

    public boolean isRefPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysNameDirty();
        }
        return this.refpsdevslnsysnameDirtyFlag;
    }

    public void resetRefPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysName();
            return;
        }
        this.refpsdevslnsysnameDirtyFlag = false;
        this.refpsdevslnsysname = null;
    }

    public void setRefPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsyssrvid = string;
        this.refpsdevslnsyssrvidDirtyFlag = true;
    }

    public String getRefPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysSrvId();
        }
        return this.refpsdevslnsyssrvid;
    }

    public boolean isRefPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysSrvIdDirty();
        }
        return this.refpsdevslnsyssrvidDirtyFlag;
    }

    public void resetRefPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysSrvId();
            return;
        }
        this.refpsdevslnsyssrvidDirtyFlag = false;
        this.refpsdevslnsyssrvid = null;
    }

    public void setRefPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsyssrvname = string;
        this.refpsdevslnsyssrvnameDirtyFlag = true;
    }

    public String getRefPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysSrvName();
        }
        return this.refpsdevslnsyssrvname;
    }

    public boolean isRefPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysSrvNameDirty();
        }
        return this.refpsdevslnsyssrvnameDirtyFlag;
    }

    public void resetRefPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysSrvName();
            return;
        }
        this.refpsdevslnsyssrvnameDirtyFlag = false;
        this.refpsdevslnsyssrvname = null;
    }

    public void setSetDENamesFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSetDENamesFlag(n);
            return;
        }
        this.setdenamesflag = n;
        this.setdenamesflagDirtyFlag = true;
    }

    public Integer getSetDENamesFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSetDENamesFlag();
        }
        return this.setdenamesflag;
    }

    public boolean isSetDENamesFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSetDENamesFlagDirty();
        }
        return this.setdenamesflagDirtyFlag;
    }

    public void resetSetDENamesFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSetDENamesFlag();
            return;
        }
        this.setdenamesflagDirtyFlag = false;
        this.setdenamesflag = null;
    }

    public void setSetModuleFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSetModuleFlag(n);
            return;
        }
        this.setmoduleflag = n;
        this.setmoduleflagDirtyFlag = true;
    }

    public Integer getSetModuleFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSetModuleFlag();
        }
        return this.setmoduleflag;
    }

    public boolean isSetModuleFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSetModuleFlagDirty();
        }
        return this.setmoduleflagDirtyFlag;
    }

    public void resetSetModuleFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSetModuleFlag();
            return;
        }
        this.setmoduleflagDirtyFlag = false;
        this.setmoduleflag = null;
    }

    public void setSysCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syscodename = string;
        this.syscodenameDirtyFlag = true;
    }

    public String getSysCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysCodeName();
        }
        return this.syscodename;
    }

    public boolean isSysCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysCodeNameDirty();
        }
        return this.syscodenameDirtyFlag;
    }

    public void resetSysCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysCodeName();
            return;
        }
        this.syscodenameDirtyFlag = false;
        this.syscodename = null;
    }

    public void setSysPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syspkgname = string;
        this.syspkgnameDirtyFlag = true;
    }

    public String getSysPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPkgName();
        }
        return this.syspkgname;
    }

    public boolean isSysPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPkgNameDirty();
        }
        return this.syspkgnameDirtyFlag;
    }

    public void resetSysPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPkgName();
            return;
        }
        this.syspkgnameDirtyFlag = false;
        this.syspkgname = null;
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

    public void setUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usage = string;
        this.usageDirtyFlag = true;
    }

    public String getUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsage();
        }
        return this.usage;
    }

    public boolean isUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageDirty();
        }
        return this.usageDirtyFlag;
    }

    public void resetUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsage();
            return;
        }
        this.usageDirtyFlag = false;
        this.usage = null;
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

    protected void onReset() {
        PSDevSlnSysRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysRefBase pSDevSlnSysRefBase) {
        pSDevSlnSysRefBase.resetCreateDate();
        pSDevSlnSysRefBase.resetCreateMan();
        pSDevSlnSysRefBase.resetDENames();
        pSDevSlnSysRefBase.resetIgnoreImpDBModel();
        pSDevSlnSysRefBase.resetIgnoreImpUIModel();
        pSDevSlnSysRefBase.resetIgnoreImpWFModel();
        pSDevSlnSysRefBase.resetImpCoreModelOnly();
        pSDevSlnSysRefBase.resetImpMode();
        pSDevSlnSysRefBase.resetImpUIModel();
        pSDevSlnSysRefBase.resetLinkCode();
        pSDevSlnSysRefBase.resetLinkFlag();
        pSDevSlnSysRefBase.resetLinkRepMsg();
        pSDevSlnSysRefBase.resetLinkReqMsg();
        pSDevSlnSysRefBase.resetLinkState();
        pSDevSlnSysRefBase.resetMemo();
        pSDevSlnSysRefBase.resetModuleList();
        pSDevSlnSysRefBase.resetOrderValue();
        pSDevSlnSysRefBase.resetPSDevSlnId();
        pSDevSlnSysRefBase.resetPSDevSlnSysId();
        pSDevSlnSysRefBase.resetPSDevSlnSysName();
        pSDevSlnSysRefBase.resetPSDevSlnSysRefId();
        pSDevSlnSysRefBase.resetPSDevSlnSysRefName();
        pSDevSlnSysRefBase.resetRefMode();
        pSDevSlnSysRefBase.resetRefParam();
        pSDevSlnSysRefBase.resetRefParam2();
        pSDevSlnSysRefBase.resetRefParams();
        pSDevSlnSysRefBase.resetRefPSDevSlnId();
        pSDevSlnSysRefBase.resetRefPSDevSlnName();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysAPIId();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysAPIName();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysId();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysName();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysSrvId();
        pSDevSlnSysRefBase.resetRefPSDevSlnSysSrvName();
        pSDevSlnSysRefBase.resetSetDENamesFlag();
        pSDevSlnSysRefBase.resetSetModuleFlag();
        pSDevSlnSysRefBase.resetSysCodeName();
        pSDevSlnSysRefBase.resetSysPkgName();
        pSDevSlnSysRefBase.resetUpdateDate();
        pSDevSlnSysRefBase.resetUpdateMan();
        pSDevSlnSysRefBase.resetUsage();
        pSDevSlnSysRefBase.resetUserCat();
        pSDevSlnSysRefBase.resetUserTag();
        pSDevSlnSysRefBase.resetUserTag2();
        pSDevSlnSysRefBase.resetUserTag3();
        pSDevSlnSysRefBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDENamesDirty()) {
            hashMap.put(FIELD_DENAMES, this.getDENames());
        }
        if (!bl || this.isIgnoreImpDBModelDirty()) {
            hashMap.put(FIELD_IGNOREIMPDBMODEL, this.getIgnoreImpDBModel());
        }
        if (!bl || this.isIgnoreImpUIModelDirty()) {
            hashMap.put(FIELD_IGNOREIMPUIMODEL, this.getIgnoreImpUIModel());
        }
        if (!bl || this.isIgnoreImpWFModelDirty()) {
            hashMap.put(FIELD_IGNOREIMPWFMODEL, this.getIgnoreImpWFModel());
        }
        if (!bl || this.isImpCoreModelOnlyDirty()) {
            hashMap.put(FIELD_IMPCOREMODELONLY, this.getImpCoreModelOnly());
        }
        if (!bl || this.isImpModeDirty()) {
            hashMap.put(FIELD_IMPMODE, this.getImpMode());
        }
        if (!bl || this.isImpUIModelDirty()) {
            hashMap.put(FIELD_IMPUIMODEL, this.getImpUIModel());
        }
        if (!bl || this.isLinkCodeDirty()) {
            hashMap.put(FIELD_LINKCODE, this.getLinkCode());
        }
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
        }
        if (!bl || this.isLinkRepMsgDirty()) {
            hashMap.put(FIELD_LINKREPMSG, this.getLinkRepMsg());
        }
        if (!bl || this.isLinkReqMsgDirty()) {
            hashMap.put(FIELD_LINKREQMSG, this.getLinkReqMsg());
        }
        if (!bl || this.isLinkStateDirty()) {
            hashMap.put(FIELD_LINKSTATE, this.getLinkState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModuleListDirty()) {
            hashMap.put(FIELD_MODULELIST, this.getModuleList());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFID, this.getPSDevSlnSysRefId());
        }
        if (!bl || this.isPSDevSlnSysRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFNAME, this.getPSDevSlnSysRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefParamDirty()) {
            hashMap.put(FIELD_REFPARAM, this.getRefParam());
        }
        if (!bl || this.isRefParam2Dirty()) {
            hashMap.put(FIELD_REFPARAM2, this.getRefParam2());
        }
        if (!bl || this.isRefParamsDirty()) {
            hashMap.put(FIELD_REFPARAMS, this.getRefParams());
        }
        if (!bl || this.isRefPSDevSlnIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNID, this.getRefPSDevSlnId());
        }
        if (!bl || this.isRefPSDevSlnNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNNAME, this.getRefPSDevSlnName());
        }
        if (!bl || this.isRefPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSAPIID, this.getRefPSDevSlnSysAPIId());
        }
        if (!bl || this.isRefPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSAPINAME, this.getRefPSDevSlnSysAPIName());
        }
        if (!bl || this.isRefPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSID, this.getRefPSDevSlnSysId());
        }
        if (!bl || this.isRefPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSNAME, this.getRefPSDevSlnSysName());
        }
        if (!bl || this.isRefPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSSRVID, this.getRefPSDevSlnSysSrvId());
        }
        if (!bl || this.isRefPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSSRVNAME, this.getRefPSDevSlnSysSrvName());
        }
        if (!bl || this.isSetDENamesFlagDirty()) {
            hashMap.put(FIELD_SETDENAMESFLAG, this.getSetDENamesFlag());
        }
        if (!bl || this.isSetModuleFlagDirty()) {
            hashMap.put(FIELD_SETMODULEFLAG, this.getSetModuleFlag());
        }
        if (!bl || this.isSysCodeNameDirty()) {
            hashMap.put(FIELD_SYSCODENAME, this.getSysCodeName());
        }
        if (!bl || this.isSysPkgNameDirty()) {
            hashMap.put(FIELD_SYSPKGNAME, this.getSysPkgName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageDirty()) {
            hashMap.put(FIELD_USAGE, this.getUsage());
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
        return PSDevSlnSysRefBase.get(this, n);
    }

    private static Object get(PSDevSlnSysRefBase pSDevSlnSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysRefBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysRefBase.getDENames();
            }
            case 3: {
                return pSDevSlnSysRefBase.getIgnoreImpDBModel();
            }
            case 4: {
                return pSDevSlnSysRefBase.getIgnoreImpUIModel();
            }
            case 5: {
                return pSDevSlnSysRefBase.getIgnoreImpWFModel();
            }
            case 6: {
                return pSDevSlnSysRefBase.getImpCoreModelOnly();
            }
            case 7: {
                return pSDevSlnSysRefBase.getImpMode();
            }
            case 8: {
                return pSDevSlnSysRefBase.getImpUIModel();
            }
            case 9: {
                return pSDevSlnSysRefBase.getLinkCode();
            }
            case 10: {
                return pSDevSlnSysRefBase.getLinkFlag();
            }
            case 11: {
                return pSDevSlnSysRefBase.getLinkRepMsg();
            }
            case 12: {
                return pSDevSlnSysRefBase.getLinkReqMsg();
            }
            case 13: {
                return pSDevSlnSysRefBase.getLinkState();
            }
            case 14: {
                return pSDevSlnSysRefBase.getMemo();
            }
            case 15: {
                return pSDevSlnSysRefBase.getModuleList();
            }
            case 16: {
                return pSDevSlnSysRefBase.getOrderValue();
            }
            case 17: {
                return pSDevSlnSysRefBase.getPSDevSlnId();
            }
            case 18: {
                return pSDevSlnSysRefBase.getPSDevSlnSysId();
            }
            case 19: {
                return pSDevSlnSysRefBase.getPSDevSlnSysName();
            }
            case 20: {
                return pSDevSlnSysRefBase.getPSDevSlnSysRefId();
            }
            case 21: {
                return pSDevSlnSysRefBase.getPSDevSlnSysRefName();
            }
            case 22: {
                return pSDevSlnSysRefBase.getRefMode();
            }
            case 23: {
                return pSDevSlnSysRefBase.getRefParam();
            }
            case 24: {
                return pSDevSlnSysRefBase.getRefParam2();
            }
            case 25: {
                return pSDevSlnSysRefBase.getRefParams();
            }
            case 26: {
                return pSDevSlnSysRefBase.getRefPSDevSlnId();
            }
            case 27: {
                return pSDevSlnSysRefBase.getRefPSDevSlnName();
            }
            case 28: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId();
            }
            case 29: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName();
            }
            case 30: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysId();
            }
            case 31: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysName();
            }
            case 32: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId();
            }
            case 33: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName();
            }
            case 34: {
                return pSDevSlnSysRefBase.getSetDENamesFlag();
            }
            case 35: {
                return pSDevSlnSysRefBase.getSetModuleFlag();
            }
            case 36: {
                return pSDevSlnSysRefBase.getSysCodeName();
            }
            case 37: {
                return pSDevSlnSysRefBase.getSysPkgName();
            }
            case 38: {
                return pSDevSlnSysRefBase.getUpdateDate();
            }
            case 39: {
                return pSDevSlnSysRefBase.getUpdateMan();
            }
            case 40: {
                return pSDevSlnSysRefBase.getUsage();
            }
            case 41: {
                return pSDevSlnSysRefBase.getUserCat();
            }
            case 42: {
                return pSDevSlnSysRefBase.getUserTag();
            }
            case 43: {
                return pSDevSlnSysRefBase.getUserTag2();
            }
            case 44: {
                return pSDevSlnSysRefBase.getUserTag3();
            }
            case 45: {
                return pSDevSlnSysRefBase.getUserTag4();
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
        PSDevSlnSysRefBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysRefBase pSDevSlnSysRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysRefBase.setDENames(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysRefBase.setIgnoreImpDBModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysRefBase.setIgnoreImpUIModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysRefBase.setIgnoreImpWFModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysRefBase.setImpCoreModelOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysRefBase.setImpMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysRefBase.setImpUIModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysRefBase.setLinkCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysRefBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysRefBase.setLinkRepMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysRefBase.setLinkReqMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysRefBase.setLinkState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysRefBase.setModuleList(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysRefBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysRefBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysRefBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysRefBase.setPSDevSlnSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysRefBase.setPSDevSlnSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysRefBase.setRefParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysRefBase.setRefParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysRefBase.setRefParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysRefBase.setRefPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysRefBase.setRefPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysRefBase.setRefPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysRefBase.setSetDENamesFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysRefBase.setSetModuleFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnSysRefBase.setSysCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnSysRefBase.setSysPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnSysRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnSysRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnSysRefBase.setUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnSysRefBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnSysRefBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnSysRefBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnSysRefBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnSysRefBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysRefBase pSDevSlnSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysRefBase.getDENames() == null;
            }
            case 3: {
                return pSDevSlnSysRefBase.getIgnoreImpDBModel() == null;
            }
            case 4: {
                return pSDevSlnSysRefBase.getIgnoreImpUIModel() == null;
            }
            case 5: {
                return pSDevSlnSysRefBase.getIgnoreImpWFModel() == null;
            }
            case 6: {
                return pSDevSlnSysRefBase.getImpCoreModelOnly() == null;
            }
            case 7: {
                return pSDevSlnSysRefBase.getImpMode() == null;
            }
            case 8: {
                return pSDevSlnSysRefBase.getImpUIModel() == null;
            }
            case 9: {
                return pSDevSlnSysRefBase.getLinkCode() == null;
            }
            case 10: {
                return pSDevSlnSysRefBase.getLinkFlag() == null;
            }
            case 11: {
                return pSDevSlnSysRefBase.getLinkRepMsg() == null;
            }
            case 12: {
                return pSDevSlnSysRefBase.getLinkReqMsg() == null;
            }
            case 13: {
                return pSDevSlnSysRefBase.getLinkState() == null;
            }
            case 14: {
                return pSDevSlnSysRefBase.getMemo() == null;
            }
            case 15: {
                return pSDevSlnSysRefBase.getModuleList() == null;
            }
            case 16: {
                return pSDevSlnSysRefBase.getOrderValue() == null;
            }
            case 17: {
                return pSDevSlnSysRefBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSDevSlnSysRefBase.getPSDevSlnSysId() == null;
            }
            case 19: {
                return pSDevSlnSysRefBase.getPSDevSlnSysName() == null;
            }
            case 20: {
                return pSDevSlnSysRefBase.getPSDevSlnSysRefId() == null;
            }
            case 21: {
                return pSDevSlnSysRefBase.getPSDevSlnSysRefName() == null;
            }
            case 22: {
                return pSDevSlnSysRefBase.getRefMode() == null;
            }
            case 23: {
                return pSDevSlnSysRefBase.getRefParam() == null;
            }
            case 24: {
                return pSDevSlnSysRefBase.getRefParam2() == null;
            }
            case 25: {
                return pSDevSlnSysRefBase.getRefParams() == null;
            }
            case 26: {
                return pSDevSlnSysRefBase.getRefPSDevSlnId() == null;
            }
            case 27: {
                return pSDevSlnSysRefBase.getRefPSDevSlnName() == null;
            }
            case 28: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId() == null;
            }
            case 29: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName() == null;
            }
            case 30: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysId() == null;
            }
            case 31: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysName() == null;
            }
            case 32: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId() == null;
            }
            case 33: {
                return pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName() == null;
            }
            case 34: {
                return pSDevSlnSysRefBase.getSetDENamesFlag() == null;
            }
            case 35: {
                return pSDevSlnSysRefBase.getSetModuleFlag() == null;
            }
            case 36: {
                return pSDevSlnSysRefBase.getSysCodeName() == null;
            }
            case 37: {
                return pSDevSlnSysRefBase.getSysPkgName() == null;
            }
            case 38: {
                return pSDevSlnSysRefBase.getUpdateDate() == null;
            }
            case 39: {
                return pSDevSlnSysRefBase.getUpdateMan() == null;
            }
            case 40: {
                return pSDevSlnSysRefBase.getUsage() == null;
            }
            case 41: {
                return pSDevSlnSysRefBase.getUserCat() == null;
            }
            case 42: {
                return pSDevSlnSysRefBase.getUserTag() == null;
            }
            case 43: {
                return pSDevSlnSysRefBase.getUserTag2() == null;
            }
            case 44: {
                return pSDevSlnSysRefBase.getUserTag3() == null;
            }
            case 45: {
                return pSDevSlnSysRefBase.getUserTag4() == null;
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
        return PSDevSlnSysRefBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysRefBase pSDevSlnSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysRefBase.isDENamesDirty();
            }
            case 3: {
                return pSDevSlnSysRefBase.isIgnoreImpDBModelDirty();
            }
            case 4: {
                return pSDevSlnSysRefBase.isIgnoreImpUIModelDirty();
            }
            case 5: {
                return pSDevSlnSysRefBase.isIgnoreImpWFModelDirty();
            }
            case 6: {
                return pSDevSlnSysRefBase.isImpCoreModelOnlyDirty();
            }
            case 7: {
                return pSDevSlnSysRefBase.isImpModeDirty();
            }
            case 8: {
                return pSDevSlnSysRefBase.isImpUIModelDirty();
            }
            case 9: {
                return pSDevSlnSysRefBase.isLinkCodeDirty();
            }
            case 10: {
                return pSDevSlnSysRefBase.isLinkFlagDirty();
            }
            case 11: {
                return pSDevSlnSysRefBase.isLinkRepMsgDirty();
            }
            case 12: {
                return pSDevSlnSysRefBase.isLinkReqMsgDirty();
            }
            case 13: {
                return pSDevSlnSysRefBase.isLinkStateDirty();
            }
            case 14: {
                return pSDevSlnSysRefBase.isMemoDirty();
            }
            case 15: {
                return pSDevSlnSysRefBase.isModuleListDirty();
            }
            case 16: {
                return pSDevSlnSysRefBase.isOrderValueDirty();
            }
            case 17: {
                return pSDevSlnSysRefBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSDevSlnSysRefBase.isPSDevSlnSysIdDirty();
            }
            case 19: {
                return pSDevSlnSysRefBase.isPSDevSlnSysNameDirty();
            }
            case 20: {
                return pSDevSlnSysRefBase.isPSDevSlnSysRefIdDirty();
            }
            case 21: {
                return pSDevSlnSysRefBase.isPSDevSlnSysRefNameDirty();
            }
            case 22: {
                return pSDevSlnSysRefBase.isRefModeDirty();
            }
            case 23: {
                return pSDevSlnSysRefBase.isRefParamDirty();
            }
            case 24: {
                return pSDevSlnSysRefBase.isRefParam2Dirty();
            }
            case 25: {
                return pSDevSlnSysRefBase.isRefParamsDirty();
            }
            case 26: {
                return pSDevSlnSysRefBase.isRefPSDevSlnIdDirty();
            }
            case 27: {
                return pSDevSlnSysRefBase.isRefPSDevSlnNameDirty();
            }
            case 28: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysAPIIdDirty();
            }
            case 29: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysAPINameDirty();
            }
            case 30: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysIdDirty();
            }
            case 31: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysNameDirty();
            }
            case 32: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysSrvIdDirty();
            }
            case 33: {
                return pSDevSlnSysRefBase.isRefPSDevSlnSysSrvNameDirty();
            }
            case 34: {
                return pSDevSlnSysRefBase.isSetDENamesFlagDirty();
            }
            case 35: {
                return pSDevSlnSysRefBase.isSetModuleFlagDirty();
            }
            case 36: {
                return pSDevSlnSysRefBase.isSysCodeNameDirty();
            }
            case 37: {
                return pSDevSlnSysRefBase.isSysPkgNameDirty();
            }
            case 38: {
                return pSDevSlnSysRefBase.isUpdateDateDirty();
            }
            case 39: {
                return pSDevSlnSysRefBase.isUpdateManDirty();
            }
            case 40: {
                return pSDevSlnSysRefBase.isUsageDirty();
            }
            case 41: {
                return pSDevSlnSysRefBase.isUserCatDirty();
            }
            case 42: {
                return pSDevSlnSysRefBase.isUserTagDirty();
            }
            case 43: {
                return pSDevSlnSysRefBase.isUserTag2Dirty();
            }
            case 44: {
                return pSDevSlnSysRefBase.isUserTag3Dirty();
            }
            case 45: {
                return pSDevSlnSysRefBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysRefBase pSDevSlnSysRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getDENames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"denames", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getDENames()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpDBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreimpdbmodel", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getIgnoreImpDBModel()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreimpuimodel", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getIgnoreImpUIModel()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpWFModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreimpwfmodel", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getIgnoreImpWFModel()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getImpCoreModelOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impcoremodelonly", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getImpCoreModelOnly()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getImpMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impmode", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getImpMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getImpUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impuimodel", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getImpUIModel()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getLinkCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkcode", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getLinkCode()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getLinkRepMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkrepmsg", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getLinkRepMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getLinkReqMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkreqmsg", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getLinkReqMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getLinkState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkstate", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getLinkState()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getModuleList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulelist", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getModuleList()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysrefid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getPSDevSlnSysRefId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysrefname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getPSDevSlnSysRefName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefParam()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam2", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefParam2()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparams", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefParams()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysapiid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysapiname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsyssrvid", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsyssrvname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getSetDENamesFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"setdenamesflag", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getSetDENamesFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getSetModuleFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"setmoduleflag", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getSetModuleFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getSysCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syscodename", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getSysCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getSysPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syspkgname", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getSysPkgName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usage", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUsage()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnSysRefBase.getJSONValue((Object)pSDevSlnSysRefBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysRefBase pSDevSlnSysRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysRefBase.getCreateDate() != null) {
            object = pSDevSlnSysRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getCreateMan() != null) {
            object = pSDevSlnSysRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getDENames() != null) {
            object = pSDevSlnSysRefBase.getDENames();
            xmlNode.setAttribute(FIELD_DENAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpDBModel() != null) {
            object = pSDevSlnSysRefBase.getIgnoreImpDBModel();
            xmlNode.setAttribute(FIELD_IGNOREIMPDBMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpUIModel() != null) {
            object = pSDevSlnSysRefBase.getIgnoreImpUIModel();
            xmlNode.setAttribute(FIELD_IGNOREIMPUIMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getIgnoreImpWFModel() != null) {
            object = pSDevSlnSysRefBase.getIgnoreImpWFModel();
            xmlNode.setAttribute(FIELD_IGNOREIMPWFMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getImpCoreModelOnly() != null) {
            object = pSDevSlnSysRefBase.getImpCoreModelOnly();
            xmlNode.setAttribute(FIELD_IMPCOREMODELONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getImpMode() != null) {
            object = pSDevSlnSysRefBase.getImpMode();
            xmlNode.setAttribute(FIELD_IMPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getImpUIModel() != null) {
            object = pSDevSlnSysRefBase.getImpUIModel();
            xmlNode.setAttribute(FIELD_IMPUIMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getLinkCode() != null) {
            object = pSDevSlnSysRefBase.getLinkCode();
            xmlNode.setAttribute(FIELD_LINKCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getLinkFlag() != null) {
            object = pSDevSlnSysRefBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getLinkRepMsg() != null) {
            object = pSDevSlnSysRefBase.getLinkRepMsg();
            xmlNode.setAttribute(FIELD_LINKREPMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getLinkReqMsg() != null) {
            object = pSDevSlnSysRefBase.getLinkReqMsg();
            xmlNode.setAttribute(FIELD_LINKREQMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getLinkState() != null) {
            object = pSDevSlnSysRefBase.getLinkState();
            xmlNode.setAttribute(FIELD_LINKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getMemo() != null) {
            object = pSDevSlnSysRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getModuleList() != null) {
            object = pSDevSlnSysRefBase.getModuleList();
            xmlNode.setAttribute(FIELD_MODULELIST, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getOrderValue() != null) {
            object = pSDevSlnSysRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysRefBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysRefBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysRefBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefId() != null) {
            object = pSDevSlnSysRefBase.getPSDevSlnSysRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefName() != null) {
            object = pSDevSlnSysRefBase.getPSDevSlnSysRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefMode() != null) {
            object = pSDevSlnSysRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefParam() != null) {
            object = pSDevSlnSysRefBase.getRefParam();
            xmlNode.setAttribute(FIELD_REFPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefParam2() != null) {
            object = pSDevSlnSysRefBase.getRefParam2();
            xmlNode.setAttribute(FIELD_REFPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefParams() != null) {
            object = pSDevSlnSysRefBase.getRefParams();
            xmlNode.setAttribute(FIELD_REFPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnId() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnName() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysId() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysName() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName() != null) {
            object = pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getSetDENamesFlag() != null) {
            object = pSDevSlnSysRefBase.getSetDENamesFlag();
            xmlNode.setAttribute(FIELD_SETDENAMESFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getSetModuleFlag() != null) {
            object = pSDevSlnSysRefBase.getSetModuleFlag();
            xmlNode.setAttribute(FIELD_SETMODULEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getSysCodeName() != null) {
            object = pSDevSlnSysRefBase.getSysCodeName();
            xmlNode.setAttribute(FIELD_SYSCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getSysPkgName() != null) {
            object = pSDevSlnSysRefBase.getSysPkgName();
            xmlNode.setAttribute(FIELD_SYSPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUpdateDate() != null) {
            object = pSDevSlnSysRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefBase.getUpdateMan() != null) {
            object = pSDevSlnSysRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUsage() != null) {
            object = pSDevSlnSysRefBase.getUsage();
            xmlNode.setAttribute(FIELD_USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUserCat() != null) {
            object = pSDevSlnSysRefBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag() != null) {
            object = pSDevSlnSysRefBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag2() != null) {
            object = pSDevSlnSysRefBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag3() != null) {
            object = pSDevSlnSysRefBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefBase.getUserTag4() != null) {
            object = pSDevSlnSysRefBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysRefBase pSDevSlnSysRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysRefBase.isCreateDateDirty() && (bl || pSDevSlnSysRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysRefBase.getCreateDate());
        }
        if (pSDevSlnSysRefBase.isCreateManDirty() && (bl || pSDevSlnSysRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysRefBase.getCreateMan());
        }
        if (pSDevSlnSysRefBase.isDENamesDirty() && (bl || pSDevSlnSysRefBase.getDENames() != null)) {
            iDataObject.set(FIELD_DENAMES, (Object)pSDevSlnSysRefBase.getDENames());
        }
        if (pSDevSlnSysRefBase.isIgnoreImpDBModelDirty() && (bl || pSDevSlnSysRefBase.getIgnoreImpDBModel() != null)) {
            iDataObject.set(FIELD_IGNOREIMPDBMODEL, (Object)pSDevSlnSysRefBase.getIgnoreImpDBModel());
        }
        if (pSDevSlnSysRefBase.isIgnoreImpUIModelDirty() && (bl || pSDevSlnSysRefBase.getIgnoreImpUIModel() != null)) {
            iDataObject.set(FIELD_IGNOREIMPUIMODEL, (Object)pSDevSlnSysRefBase.getIgnoreImpUIModel());
        }
        if (pSDevSlnSysRefBase.isIgnoreImpWFModelDirty() && (bl || pSDevSlnSysRefBase.getIgnoreImpWFModel() != null)) {
            iDataObject.set(FIELD_IGNOREIMPWFMODEL, (Object)pSDevSlnSysRefBase.getIgnoreImpWFModel());
        }
        if (pSDevSlnSysRefBase.isImpCoreModelOnlyDirty() && (bl || pSDevSlnSysRefBase.getImpCoreModelOnly() != null)) {
            iDataObject.set(FIELD_IMPCOREMODELONLY, (Object)pSDevSlnSysRefBase.getImpCoreModelOnly());
        }
        if (pSDevSlnSysRefBase.isImpModeDirty() && (bl || pSDevSlnSysRefBase.getImpMode() != null)) {
            iDataObject.set(FIELD_IMPMODE, (Object)pSDevSlnSysRefBase.getImpMode());
        }
        if (pSDevSlnSysRefBase.isImpUIModelDirty() && (bl || pSDevSlnSysRefBase.getImpUIModel() != null)) {
            iDataObject.set(FIELD_IMPUIMODEL, (Object)pSDevSlnSysRefBase.getImpUIModel());
        }
        if (pSDevSlnSysRefBase.isLinkCodeDirty() && (bl || pSDevSlnSysRefBase.getLinkCode() != null)) {
            iDataObject.set(FIELD_LINKCODE, (Object)pSDevSlnSysRefBase.getLinkCode());
        }
        if (pSDevSlnSysRefBase.isLinkFlagDirty() && (bl || pSDevSlnSysRefBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSDevSlnSysRefBase.getLinkFlag());
        }
        if (pSDevSlnSysRefBase.isLinkRepMsgDirty() && (bl || pSDevSlnSysRefBase.getLinkRepMsg() != null)) {
            iDataObject.set(FIELD_LINKREPMSG, (Object)pSDevSlnSysRefBase.getLinkRepMsg());
        }
        if (pSDevSlnSysRefBase.isLinkReqMsgDirty() && (bl || pSDevSlnSysRefBase.getLinkReqMsg() != null)) {
            iDataObject.set(FIELD_LINKREQMSG, (Object)pSDevSlnSysRefBase.getLinkReqMsg());
        }
        if (pSDevSlnSysRefBase.isLinkStateDirty() && (bl || pSDevSlnSysRefBase.getLinkState() != null)) {
            iDataObject.set(FIELD_LINKSTATE, (Object)pSDevSlnSysRefBase.getLinkState());
        }
        if (pSDevSlnSysRefBase.isMemoDirty() && (bl || pSDevSlnSysRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysRefBase.getMemo());
        }
        if (pSDevSlnSysRefBase.isModuleListDirty() && (bl || pSDevSlnSysRefBase.getModuleList() != null)) {
            iDataObject.set(FIELD_MODULELIST, (Object)pSDevSlnSysRefBase.getModuleList());
        }
        if (pSDevSlnSysRefBase.isOrderValueDirty() && (bl || pSDevSlnSysRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnSysRefBase.getOrderValue());
        }
        if (pSDevSlnSysRefBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysRefBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysRefBase.getPSDevSlnId());
        }
        if (pSDevSlnSysRefBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysRefBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysRefBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysRefBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysRefBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysRefBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysRefBase.isPSDevSlnSysRefIdDirty() && (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFID, (Object)pSDevSlnSysRefBase.getPSDevSlnSysRefId());
        }
        if (pSDevSlnSysRefBase.isPSDevSlnSysRefNameDirty() && (bl || pSDevSlnSysRefBase.getPSDevSlnSysRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFNAME, (Object)pSDevSlnSysRefBase.getPSDevSlnSysRefName());
        }
        if (pSDevSlnSysRefBase.isRefModeDirty() && (bl || pSDevSlnSysRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDevSlnSysRefBase.getRefMode());
        }
        if (pSDevSlnSysRefBase.isRefParamDirty() && (bl || pSDevSlnSysRefBase.getRefParam() != null)) {
            iDataObject.set(FIELD_REFPARAM, (Object)pSDevSlnSysRefBase.getRefParam());
        }
        if (pSDevSlnSysRefBase.isRefParam2Dirty() && (bl || pSDevSlnSysRefBase.getRefParam2() != null)) {
            iDataObject.set(FIELD_REFPARAM2, (Object)pSDevSlnSysRefBase.getRefParam2());
        }
        if (pSDevSlnSysRefBase.isRefParamsDirty() && (bl || pSDevSlnSysRefBase.getRefParams() != null)) {
            iDataObject.set(FIELD_REFPARAMS, (Object)pSDevSlnSysRefBase.getRefParams());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnIdDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNID, (Object)pSDevSlnSysRefBase.getRefPSDevSlnId());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnNameDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNNAME, (Object)pSDevSlnSysRefBase.getRefPSDevSlnName());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysAPIIdDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSAPIID, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysAPIId());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysAPINameDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSAPINAME, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysAPIName());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysIdDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSID, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysId());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysNameDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSNAME, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysName());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysSrvIdDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSSRVID, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysSrvId());
        }
        if (pSDevSlnSysRefBase.isRefPSDevSlnSysSrvNameDirty() && (bl || pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSSRVNAME, (Object)pSDevSlnSysRefBase.getRefPSDevSlnSysSrvName());
        }
        if (pSDevSlnSysRefBase.isSetDENamesFlagDirty() && (bl || pSDevSlnSysRefBase.getSetDENamesFlag() != null)) {
            iDataObject.set(FIELD_SETDENAMESFLAG, (Object)pSDevSlnSysRefBase.getSetDENamesFlag());
        }
        if (pSDevSlnSysRefBase.isSetModuleFlagDirty() && (bl || pSDevSlnSysRefBase.getSetModuleFlag() != null)) {
            iDataObject.set(FIELD_SETMODULEFLAG, (Object)pSDevSlnSysRefBase.getSetModuleFlag());
        }
        if (pSDevSlnSysRefBase.isSysCodeNameDirty() && (bl || pSDevSlnSysRefBase.getSysCodeName() != null)) {
            iDataObject.set(FIELD_SYSCODENAME, (Object)pSDevSlnSysRefBase.getSysCodeName());
        }
        if (pSDevSlnSysRefBase.isSysPkgNameDirty() && (bl || pSDevSlnSysRefBase.getSysPkgName() != null)) {
            iDataObject.set(FIELD_SYSPKGNAME, (Object)pSDevSlnSysRefBase.getSysPkgName());
        }
        if (pSDevSlnSysRefBase.isUpdateDateDirty() && (bl || pSDevSlnSysRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysRefBase.getUpdateDate());
        }
        if (pSDevSlnSysRefBase.isUpdateManDirty() && (bl || pSDevSlnSysRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysRefBase.getUpdateMan());
        }
        if (pSDevSlnSysRefBase.isUsageDirty() && (bl || pSDevSlnSysRefBase.getUsage() != null)) {
            iDataObject.set(FIELD_USAGE, (Object)pSDevSlnSysRefBase.getUsage());
        }
        if (pSDevSlnSysRefBase.isUserCatDirty() && (bl || pSDevSlnSysRefBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnSysRefBase.getUserCat());
        }
        if (pSDevSlnSysRefBase.isUserTagDirty() && (bl || pSDevSlnSysRefBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnSysRefBase.getUserTag());
        }
        if (pSDevSlnSysRefBase.isUserTag2Dirty() && (bl || pSDevSlnSysRefBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnSysRefBase.getUserTag2());
        }
        if (pSDevSlnSysRefBase.isUserTag3Dirty() && (bl || pSDevSlnSysRefBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnSysRefBase.getUserTag3());
        }
        if (pSDevSlnSysRefBase.isUserTag4Dirty() && (bl || pSDevSlnSysRefBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnSysRefBase.getUserTag4());
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
        return PSDevSlnSysRefBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysRefBase pSDevSlnSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysRefBase.resetDENames();
                return true;
            }
            case 3: {
                pSDevSlnSysRefBase.resetIgnoreImpDBModel();
                return true;
            }
            case 4: {
                pSDevSlnSysRefBase.resetIgnoreImpUIModel();
                return true;
            }
            case 5: {
                pSDevSlnSysRefBase.resetIgnoreImpWFModel();
                return true;
            }
            case 6: {
                pSDevSlnSysRefBase.resetImpCoreModelOnly();
                return true;
            }
            case 7: {
                pSDevSlnSysRefBase.resetImpMode();
                return true;
            }
            case 8: {
                pSDevSlnSysRefBase.resetImpUIModel();
                return true;
            }
            case 9: {
                pSDevSlnSysRefBase.resetLinkCode();
                return true;
            }
            case 10: {
                pSDevSlnSysRefBase.resetLinkFlag();
                return true;
            }
            case 11: {
                pSDevSlnSysRefBase.resetLinkRepMsg();
                return true;
            }
            case 12: {
                pSDevSlnSysRefBase.resetLinkReqMsg();
                return true;
            }
            case 13: {
                pSDevSlnSysRefBase.resetLinkState();
                return true;
            }
            case 14: {
                pSDevSlnSysRefBase.resetMemo();
                return true;
            }
            case 15: {
                pSDevSlnSysRefBase.resetModuleList();
                return true;
            }
            case 16: {
                pSDevSlnSysRefBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSDevSlnSysRefBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSDevSlnSysRefBase.resetPSDevSlnSysId();
                return true;
            }
            case 19: {
                pSDevSlnSysRefBase.resetPSDevSlnSysName();
                return true;
            }
            case 20: {
                pSDevSlnSysRefBase.resetPSDevSlnSysRefId();
                return true;
            }
            case 21: {
                pSDevSlnSysRefBase.resetPSDevSlnSysRefName();
                return true;
            }
            case 22: {
                pSDevSlnSysRefBase.resetRefMode();
                return true;
            }
            case 23: {
                pSDevSlnSysRefBase.resetRefParam();
                return true;
            }
            case 24: {
                pSDevSlnSysRefBase.resetRefParam2();
                return true;
            }
            case 25: {
                pSDevSlnSysRefBase.resetRefParams();
                return true;
            }
            case 26: {
                pSDevSlnSysRefBase.resetRefPSDevSlnId();
                return true;
            }
            case 27: {
                pSDevSlnSysRefBase.resetRefPSDevSlnName();
                return true;
            }
            case 28: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysAPIId();
                return true;
            }
            case 29: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysAPIName();
                return true;
            }
            case 30: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysId();
                return true;
            }
            case 31: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysName();
                return true;
            }
            case 32: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysSrvId();
                return true;
            }
            case 33: {
                pSDevSlnSysRefBase.resetRefPSDevSlnSysSrvName();
                return true;
            }
            case 34: {
                pSDevSlnSysRefBase.resetSetDENamesFlag();
                return true;
            }
            case 35: {
                pSDevSlnSysRefBase.resetSetModuleFlag();
                return true;
            }
            case 36: {
                pSDevSlnSysRefBase.resetSysCodeName();
                return true;
            }
            case 37: {
                pSDevSlnSysRefBase.resetSysPkgName();
                return true;
            }
            case 38: {
                pSDevSlnSysRefBase.resetUpdateDate();
                return true;
            }
            case 39: {
                pSDevSlnSysRefBase.resetUpdateMan();
                return true;
            }
            case 40: {
                pSDevSlnSysRefBase.resetUsage();
                return true;
            }
            case 41: {
                pSDevSlnSysRefBase.resetUserCat();
                return true;
            }
            case 42: {
                pSDevSlnSysRefBase.resetUserTag();
                return true;
            }
            case 43: {
                pSDevSlnSysRefBase.resetUserTag2();
                return true;
            }
            case 44: {
                pSDevSlnSysRefBase.resetUserTag3();
                return true;
            }
            case 45: {
                pSDevSlnSysRefBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysAPI getRefPSDevSlnSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysAPI();
        }
        if (this.getRefPSDevSlnSysAPIId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnSysAPILock;
        synchronized (n) {
            if (this.refpsdevslnsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnSysAPIId(), (Object)this.refpsdevslnsysapi.getPSDevSlnSysAPIId()) != 0L) {
                this.refpsdevslnsysapi = null;
            }
            if (this.refpsdevslnsysapi == null) {
                PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
                pSDevSlnSysAPI.setPSDevSlnSysAPIId(this.getRefPSDevSlnSysAPIId());
                PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAPIService.autoGet((IEntity)pSDevSlnSysAPI);
                this.refpsdevslnsysapi = pSDevSlnSysAPI;
            }
            return this.refpsdevslnsysapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysSrv getRefPSDevSlnSysSrv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysSrv();
        }
        if (this.getRefPSDevSlnSysSrvId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnSysSrvLock;
        synchronized (n) {
            if (this.refpsdevslnsyssrv != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnSysSrvId(), (Object)this.refpsdevslnsyssrv.getPSDevSlnSysSrvId()) != 0L) {
                this.refpsdevslnsyssrv = null;
            }
            if (this.refpsdevslnsyssrv == null) {
                PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
                pSDevSlnSysSrv.setPSDevSlnSysSrvId(this.getRefPSDevSlnSysSrvId());
                PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrvService.autoGet((IEntity)pSDevSlnSysSrv);
                this.refpsdevslnsyssrv = pSDevSlnSysSrv;
            }
            return this.refpsdevslnsyssrv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getRefPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSys();
        }
        if (this.getRefPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnSysLock;
        synchronized (n) {
            if (this.refpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnSysId(), (Object)this.refpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.refpsdevslnsys = null;
            }
            if (this.refpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getRefPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.refpsdevslnsys = pSDevSlnSys;
            }
            return this.refpsdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getRefPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSln();
        }
        if (this.getRefPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnLock;
        synchronized (n) {
            if (this.refpsdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnId(), (Object)this.refpsdevsln.getPSDevSlnId()) != 0L) {
                this.refpsdevsln = null;
            }
            if (this.refpsdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getRefPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.refpsdevsln = pSDevSln;
            }
            return this.refpsdevsln;
        }
    }

    private PSDevSlnSysRefBase getProxyEntity() {
        return this.proxyPSDevSlnSysRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysRefBase) {
            this.proxyPSDevSlnSysRefBase = (PSDevSlnSysRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DENAMES, 2);
        fieldIndexMap.put(FIELD_IGNOREIMPDBMODEL, 3);
        fieldIndexMap.put(FIELD_IGNOREIMPUIMODEL, 4);
        fieldIndexMap.put(FIELD_IGNOREIMPWFMODEL, 5);
        fieldIndexMap.put(FIELD_IMPCOREMODELONLY, 6);
        fieldIndexMap.put(FIELD_IMPMODE, 7);
        fieldIndexMap.put(FIELD_IMPUIMODEL, 8);
        fieldIndexMap.put(FIELD_LINKCODE, 9);
        fieldIndexMap.put(FIELD_LINKFLAG, 10);
        fieldIndexMap.put(FIELD_LINKREPMSG, 11);
        fieldIndexMap.put(FIELD_LINKREQMSG, 12);
        fieldIndexMap.put(FIELD_LINKSTATE, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MODULELIST, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFNAME, 21);
        fieldIndexMap.put(FIELD_REFMODE, 22);
        fieldIndexMap.put(FIELD_REFPARAM, 23);
        fieldIndexMap.put(FIELD_REFPARAM2, 24);
        fieldIndexMap.put(FIELD_REFPARAMS, 25);
        fieldIndexMap.put(FIELD_REFPSDEVSLNID, 26);
        fieldIndexMap.put(FIELD_REFPSDEVSLNNAME, 27);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSAPIID, 28);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSAPINAME, 29);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSID, 30);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSNAME, 31);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSSRVID, 32);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSSRVNAME, 33);
        fieldIndexMap.put(FIELD_SETDENAMESFLAG, 34);
        fieldIndexMap.put(FIELD_SETMODULEFLAG, 35);
        fieldIndexMap.put(FIELD_SYSCODENAME, 36);
        fieldIndexMap.put(FIELD_SYSPKGNAME, 37);
        fieldIndexMap.put(FIELD_UPDATEDATE, 38);
        fieldIndexMap.put(FIELD_UPDATEMAN, 39);
        fieldIndexMap.put(FIELD_USAGE, 40);
        fieldIndexMap.put(FIELD_USERCAT, 41);
        fieldIndexMap.put(FIELD_USERTAG, 42);
        fieldIndexMap.put(FIELD_USERTAG2, 43);
        fieldIndexMap.put(FIELD_USERTAG3, 44);
        fieldIndexMap.put(FIELD_USERTAG4, 45);
    }
}

