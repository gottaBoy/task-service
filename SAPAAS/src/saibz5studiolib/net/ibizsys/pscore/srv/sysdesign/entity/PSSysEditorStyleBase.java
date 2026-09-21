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
import net.ibizsys.pscore.srv.config.entity.PSEditorStyle;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSEditorStyleService;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEditorStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEditorStyleBase.class);
    public static final String FIELD_AJAXHANDLER = "AJAXHANDLER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARAM = "CTRLPARAM";
    public static final String FIELD_CTRLPARAM10 = "CTRLPARAM10";
    public static final String FIELD_CTRLPARAM11 = "CTRLPARAM11";
    public static final String FIELD_CTRLPARAM12 = "CTRLPARAM12";
    public static final String FIELD_CTRLPARAM2 = "CTRLPARAM2";
    public static final String FIELD_CTRLPARAM3 = "CTRLPARAM3";
    public static final String FIELD_CTRLPARAM4 = "CTRLPARAM4";
    public static final String FIELD_CTRLPARAM5 = "CTRLPARAM5";
    public static final String FIELD_CTRLPARAM6 = "CTRLPARAM6";
    public static final String FIELD_CTRLPARAM7 = "CTRLPARAM7";
    public static final String FIELD_CTRLPARAM8 = "CTRLPARAM8";
    public static final String FIELD_CTRLPARAM9 = "CTRLPARAM9";
    public static final String FIELD_CTRLPARAMS = "CTRLPARAMS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EXTENDSTYLEONLY = "EXTENDSTYLEONLY";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSEDITORSTYLEID = "PSEDITORSTYLEID";
    public static final String FIELD_PSEDITORSTYLENAME = "PSEDITORSTYLENAME";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String FIELD_REPDEFAULT = "REPDEFAULT";
    public static final String FIELD_STUDIOICON = "STUDIOICON";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_AJAXHANDLER = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTAINERTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CTRLPARAM = 5;
    private static final int INDEX_CTRLPARAM10 = 6;
    private static final int INDEX_CTRLPARAM11 = 7;
    private static final int INDEX_CTRLPARAM12 = 8;
    private static final int INDEX_CTRLPARAM2 = 9;
    private static final int INDEX_CTRLPARAM3 = 10;
    private static final int INDEX_CTRLPARAM4 = 11;
    private static final int INDEX_CTRLPARAM5 = 12;
    private static final int INDEX_CTRLPARAM6 = 13;
    private static final int INDEX_CTRLPARAM7 = 14;
    private static final int INDEX_CTRLPARAM8 = 15;
    private static final int INDEX_CTRLPARAM9 = 16;
    private static final int INDEX_CTRLPARAMS = 17;
    private static final int INDEX_DYNAMODELFLAG = 18;
    private static final int INDEX_EXTENDSTYLEONLY = 19;
    private static final int INDEX_HEIGHT = 20;
    private static final int INDEX_LINKVIEWSHOWMODE = 21;
    private static final int INDEX_LOCKFLAG = 22;
    private static final int INDEX_MEMO = 23;
    private static final int INDEX_PREVIEWHTML = 24;
    private static final int INDEX_PSACHANDLERID = 25;
    private static final int INDEX_PSACHANDLERNAME = 26;
    private static final int INDEX_PSDYNAINSTID = 27;
    private static final int INDEX_PSEDITORSTYLEID = 28;
    private static final int INDEX_PSEDITORSTYLENAME = 29;
    private static final int INDEX_PSEDITORTYPEID = 30;
    private static final int INDEX_PSEDITORTYPENAME = 31;
    private static final int INDEX_PSMODULEID = 32;
    private static final int INDEX_PSMODULENAME = 33;
    private static final int INDEX_PSSYSCSSID = 34;
    private static final int INDEX_PSSYSCSSNAME = 35;
    private static final int INDEX_PSSYSEDITORSTYLEID = 36;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 37;
    private static final int INDEX_PSSYSPFPLUGINID = 38;
    private static final int INDEX_PSSYSPFPLUGINNAME = 39;
    private static final int INDEX_PSSYSTEMID = 40;
    private static final int INDEX_PSSYSTEMNAME = 41;
    private static final int INDEX_REFVIEWSHOWMODE = 42;
    private static final int INDEX_REPDEFAULT = 43;
    private static final int INDEX_STUDIOICON = 44;
    private static final int INDEX_UPDATEDATE = 45;
    private static final int INDEX_UPDATEMAN = 46;
    private static final int INDEX_USERCAT = 47;
    private static final int INDEX_USERTAG = 48;
    private static final int INDEX_USERTAG2 = 49;
    private static final int INDEX_USERTAG3 = 50;
    private static final int INDEX_USERTAG4 = 51;
    private static final int INDEX_VALIDFLAG = 52;
    private static final int INDEX_WIDTH = 53;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEditorStyleBase proxyPSSysEditorStyleBase = null;
    private boolean ajaxhandlerDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean containertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlparamDirtyFlag = false;
    private boolean ctrlparam10DirtyFlag = false;
    private boolean ctrlparam11DirtyFlag = false;
    private boolean ctrlparam12DirtyFlag = false;
    private boolean ctrlparam2DirtyFlag = false;
    private boolean ctrlparam3DirtyFlag = false;
    private boolean ctrlparam4DirtyFlag = false;
    private boolean ctrlparam5DirtyFlag = false;
    private boolean ctrlparam6DirtyFlag = false;
    private boolean ctrlparam7DirtyFlag = false;
    private boolean ctrlparam8DirtyFlag = false;
    private boolean ctrlparam9DirtyFlag = false;
    private boolean ctrlparamsDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean extendstyleonlyDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean linkviewshowmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pseditorstyleidDirtyFlag = false;
    private boolean pseditorstylenameDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean refviewshowmodeDirtyFlag = false;
    private boolean repdefaultDirtyFlag = false;
    private boolean studioiconDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="ajaxhandler")
    private String ajaxhandler;
    @Column(name="codename")
    private String codename;
    @Column(name="containertype")
    private String containertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlparam")
    private String ctrlparam;
    @Column(name="ctrlparam10")
    private Double ctrlparam10;
    @Column(name="ctrlparam11")
    private Integer ctrlparam11;
    @Column(name="ctrlparam12")
    private Integer ctrlparam12;
    @Column(name="ctrlparam2")
    private String ctrlparam2;
    @Column(name="ctrlparam3")
    private String ctrlparam3;
    @Column(name="ctrlparam4")
    private String ctrlparam4;
    @Column(name="ctrlparam5")
    private Integer ctrlparam5;
    @Column(name="ctrlparam6")
    private Integer ctrlparam6;
    @Column(name="ctrlparam7")
    private Integer ctrlparam7;
    @Column(name="ctrlparam8")
    private Integer ctrlparam8;
    @Column(name="ctrlparam9")
    private Double ctrlparam9;
    @Column(name="ctrlparams")
    private String ctrlparams;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="extendstyleonly")
    private Integer extendstyleonly;
    @Column(name="height")
    private Integer height;
    @Column(name="linkviewshowmode")
    private String linkviewshowmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pseditorstyleid")
    private String pseditorstyleid;
    @Column(name="pseditorstylename")
    private String pseditorstylename;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="refviewshowmode")
    private String refviewshowmode;
    @Column(name="repdefault")
    private Integer repdefault;
    @Column(name="studioicon")
    private String studioicon;
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
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="width")
    private Integer width;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSEditorStyleLock = new Integer(1);
    private PSEditorStyle pseditorstyle = null;
    private Integer objPSEditorTypeLock = new Integer(1);
    private PSEditorType pseditortype = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setAjaxHandler(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAjaxHandler(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ajaxhandler = string;
        this.ajaxhandlerDirtyFlag = true;
    }

    public String getAjaxHandler() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAjaxHandler();
        }
        return this.ajaxhandler;
    }

    public boolean isAjaxHandlerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAjaxHandlerDirty();
        }
        return this.ajaxhandlerDirtyFlag;
    }

    public void resetAjaxHandler() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAjaxHandler();
            return;
        }
        this.ajaxhandlerDirtyFlag = false;
        this.ajaxhandler = null;
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

    public void setContainerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containertype = string;
        this.containertypeDirtyFlag = true;
    }

    public String getContainerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerType();
        }
        return this.containertype;
    }

    public boolean isContainerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerTypeDirty();
        }
        return this.containertypeDirtyFlag;
    }

    public void resetContainerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerType();
            return;
        }
        this.containertypeDirtyFlag = false;
        this.containertype = null;
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

    public void setCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam = string;
        this.ctrlparamDirtyFlag = true;
    }

    public String getCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam();
        }
        return this.ctrlparam;
    }

    public boolean isCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamDirty();
        }
        return this.ctrlparamDirtyFlag;
    }

    public void resetCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam();
            return;
        }
        this.ctrlparamDirtyFlag = false;
        this.ctrlparam = null;
    }

    public void setCtrlParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam10(d);
            return;
        }
        this.ctrlparam10 = d;
        this.ctrlparam10DirtyFlag = true;
    }

    public Double getCtrlParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam10();
        }
        return this.ctrlparam10;
    }

    public boolean isCtrlParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam10Dirty();
        }
        return this.ctrlparam10DirtyFlag;
    }

    public void resetCtrlParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam10();
            return;
        }
        this.ctrlparam10DirtyFlag = false;
        this.ctrlparam10 = null;
    }

    public void setCtrlParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam11(n);
            return;
        }
        this.ctrlparam11 = n;
        this.ctrlparam11DirtyFlag = true;
    }

    public Integer getCtrlParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam11();
        }
        return this.ctrlparam11;
    }

    public boolean isCtrlParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam11Dirty();
        }
        return this.ctrlparam11DirtyFlag;
    }

    public void resetCtrlParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam11();
            return;
        }
        this.ctrlparam11DirtyFlag = false;
        this.ctrlparam11 = null;
    }

    public void setCtrlParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam12(n);
            return;
        }
        this.ctrlparam12 = n;
        this.ctrlparam12DirtyFlag = true;
    }

    public Integer getCtrlParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam12();
        }
        return this.ctrlparam12;
    }

    public boolean isCtrlParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam12Dirty();
        }
        return this.ctrlparam12DirtyFlag;
    }

    public void resetCtrlParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam12();
            return;
        }
        this.ctrlparam12DirtyFlag = false;
        this.ctrlparam12 = null;
    }

    public void setCtrlParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam2 = string;
        this.ctrlparam2DirtyFlag = true;
    }

    public String getCtrlParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam2();
        }
        return this.ctrlparam2;
    }

    public boolean isCtrlParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam2Dirty();
        }
        return this.ctrlparam2DirtyFlag;
    }

    public void resetCtrlParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam2();
            return;
        }
        this.ctrlparam2DirtyFlag = false;
        this.ctrlparam2 = null;
    }

    public void setCtrlParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam3 = string;
        this.ctrlparam3DirtyFlag = true;
    }

    public String getCtrlParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam3();
        }
        return this.ctrlparam3;
    }

    public boolean isCtrlParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam3Dirty();
        }
        return this.ctrlparam3DirtyFlag;
    }

    public void resetCtrlParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam3();
            return;
        }
        this.ctrlparam3DirtyFlag = false;
        this.ctrlparam3 = null;
    }

    public void setCtrlParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam4 = string;
        this.ctrlparam4DirtyFlag = true;
    }

    public String getCtrlParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam4();
        }
        return this.ctrlparam4;
    }

    public boolean isCtrlParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam4Dirty();
        }
        return this.ctrlparam4DirtyFlag;
    }

    public void resetCtrlParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam4();
            return;
        }
        this.ctrlparam4DirtyFlag = false;
        this.ctrlparam4 = null;
    }

    public void setCtrlParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam5(n);
            return;
        }
        this.ctrlparam5 = n;
        this.ctrlparam5DirtyFlag = true;
    }

    public Integer getCtrlParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam5();
        }
        return this.ctrlparam5;
    }

    public boolean isCtrlParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam5Dirty();
        }
        return this.ctrlparam5DirtyFlag;
    }

    public void resetCtrlParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam5();
            return;
        }
        this.ctrlparam5DirtyFlag = false;
        this.ctrlparam5 = null;
    }

    public void setCtrlParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam6(n);
            return;
        }
        this.ctrlparam6 = n;
        this.ctrlparam6DirtyFlag = true;
    }

    public Integer getCtrlParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam6();
        }
        return this.ctrlparam6;
    }

    public boolean isCtrlParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam6Dirty();
        }
        return this.ctrlparam6DirtyFlag;
    }

    public void resetCtrlParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam6();
            return;
        }
        this.ctrlparam6DirtyFlag = false;
        this.ctrlparam6 = null;
    }

    public void setCtrlParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam7(n);
            return;
        }
        this.ctrlparam7 = n;
        this.ctrlparam7DirtyFlag = true;
    }

    public Integer getCtrlParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam7();
        }
        return this.ctrlparam7;
    }

    public boolean isCtrlParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam7Dirty();
        }
        return this.ctrlparam7DirtyFlag;
    }

    public void resetCtrlParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam7();
            return;
        }
        this.ctrlparam7DirtyFlag = false;
        this.ctrlparam7 = null;
    }

    public void setCtrlParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam8(n);
            return;
        }
        this.ctrlparam8 = n;
        this.ctrlparam8DirtyFlag = true;
    }

    public Integer getCtrlParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam8();
        }
        return this.ctrlparam8;
    }

    public boolean isCtrlParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam8Dirty();
        }
        return this.ctrlparam8DirtyFlag;
    }

    public void resetCtrlParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam8();
            return;
        }
        this.ctrlparam8DirtyFlag = false;
        this.ctrlparam8 = null;
    }

    public void setCtrlParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam9(d);
            return;
        }
        this.ctrlparam9 = d;
        this.ctrlparam9DirtyFlag = true;
    }

    public Double getCtrlParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam9();
        }
        return this.ctrlparam9;
    }

    public boolean isCtrlParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam9Dirty();
        }
        return this.ctrlparam9DirtyFlag;
    }

    public void resetCtrlParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam9();
            return;
        }
        this.ctrlparam9DirtyFlag = false;
        this.ctrlparam9 = null;
    }

    public void setCtrlParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparams = string;
        this.ctrlparamsDirtyFlag = true;
    }

    public String getCtrlParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParams();
        }
        return this.ctrlparams;
    }

    public boolean isCtrlParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamsDirty();
        }
        return this.ctrlparamsDirtyFlag;
    }

    public void resetCtrlParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParams();
            return;
        }
        this.ctrlparamsDirtyFlag = false;
        this.ctrlparams = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setExtendStyleOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendStyleOnly(n);
            return;
        }
        this.extendstyleonly = n;
        this.extendstyleonlyDirtyFlag = true;
    }

    public Integer getExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendStyleOnly();
        }
        return this.extendstyleonly;
    }

    public boolean isExtendStyleOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendStyleOnlyDirty();
        }
        return this.extendstyleonlyDirtyFlag;
    }

    public void resetExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendStyleOnly();
            return;
        }
        this.extendstyleonlyDirtyFlag = false;
        this.extendstyleonly = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setLinkViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkviewshowmode = string;
        this.linkviewshowmodeDirtyFlag = true;
    }

    public String getLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkViewShowMode();
        }
        return this.linkviewshowmode;
    }

    public boolean isLinkViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkViewShowModeDirty();
        }
        return this.linkviewshowmodeDirtyFlag;
    }

    public void resetLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkViewShowMode();
            return;
        }
        this.linkviewshowmodeDirtyFlag = false;
        this.linkviewshowmode = null;
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

    public void setPreviewHtml(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewHtml(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewhtml = string;
        this.previewhtmlDirtyFlag = true;
    }

    public String getPreviewHtml() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewHtml();
        }
        return this.previewhtml;
    }

    public boolean isPreviewHtmlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewHtmlDirty();
        }
        return this.previewhtmlDirtyFlag;
    }

    public void resetPreviewHtml() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewHtml();
            return;
        }
        this.previewhtmlDirtyFlag = false;
        this.previewhtml = null;
    }

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
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

    public void setPSEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditorstyleid = string;
        this.pseditorstyleidDirtyFlag = true;
    }

    public String getPSEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorStyleId();
        }
        return this.pseditorstyleid;
    }

    public boolean isPSEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorStyleIdDirty();
        }
        return this.pseditorstyleidDirtyFlag;
    }

    public void resetPSEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorStyleId();
            return;
        }
        this.pseditorstyleidDirtyFlag = false;
        this.pseditorstyleid = null;
    }

    public void setPSEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditorstylename = string;
        this.pseditorstylenameDirtyFlag = true;
    }

    public String getPSEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorStyleName();
        }
        return this.pseditorstylename;
    }

    public boolean isPSEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorStyleNameDirty();
        }
        return this.pseditorstylenameDirtyFlag;
    }

    public void resetPSEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorStyleName();
            return;
        }
        this.pseditorstylenameDirtyFlag = false;
        this.pseditorstylename = null;
    }

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
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

    public void setPSSysEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstyleid = string;
        this.pssyseditorstyleidDirtyFlag = true;
    }

    public String getPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleId();
        }
        return this.pssyseditorstyleid;
    }

    public boolean isPSSysEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleIdDirty();
        }
        return this.pssyseditorstyleidDirtyFlag;
    }

    public void resetPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleId();
            return;
        }
        this.pssyseditorstyleidDirtyFlag = false;
        this.pssyseditorstyleid = null;
    }

    public void setPSSysEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstylename = string;
        this.pssyseditorstylenameDirtyFlag = true;
    }

    public String getPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleName();
        }
        return this.pssyseditorstylename;
    }

    public boolean isPSSysEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleNameDirty();
        }
        return this.pssyseditorstylenameDirtyFlag;
    }

    public void resetPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleName();
            return;
        }
        this.pssyseditorstylenameDirtyFlag = false;
        this.pssyseditorstylename = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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

    public void setRefViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refviewshowmode = string;
        this.refviewshowmodeDirtyFlag = true;
    }

    public String getRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefViewShowMode();
        }
        return this.refviewshowmode;
    }

    public boolean isRefViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefViewShowModeDirty();
        }
        return this.refviewshowmodeDirtyFlag;
    }

    public void resetRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefViewShowMode();
            return;
        }
        this.refviewshowmodeDirtyFlag = false;
        this.refviewshowmode = null;
    }

    public void setRepDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepDefault(n);
            return;
        }
        this.repdefault = n;
        this.repdefaultDirtyFlag = true;
    }

    public Integer getRepDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepDefault();
        }
        return this.repdefault;
    }

    public boolean isRepDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepDefaultDirty();
        }
        return this.repdefaultDirtyFlag;
    }

    public void resetRepDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepDefault();
            return;
        }
        this.repdefaultDirtyFlag = false;
        this.repdefault = null;
    }

    public void setStudioIcon(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioIcon(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studioicon = string;
        this.studioiconDirtyFlag = true;
    }

    public String getStudioIcon() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioIcon();
        }
        return this.studioicon;
    }

    public boolean isStudioIconDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioIconDirty();
        }
        return this.studioiconDirtyFlag;
    }

    public void resetStudioIcon() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioIcon();
            return;
        }
        this.studioiconDirtyFlag = false;
        this.studioicon = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSSysEditorStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEditorStyleBase pSSysEditorStyleBase) {
        pSSysEditorStyleBase.resetAjaxHandler();
        pSSysEditorStyleBase.resetCodeName();
        pSSysEditorStyleBase.resetContainerType();
        pSSysEditorStyleBase.resetCreateDate();
        pSSysEditorStyleBase.resetCreateMan();
        pSSysEditorStyleBase.resetCtrlParam();
        pSSysEditorStyleBase.resetCtrlParam10();
        pSSysEditorStyleBase.resetCtrlParam11();
        pSSysEditorStyleBase.resetCtrlParam12();
        pSSysEditorStyleBase.resetCtrlParam2();
        pSSysEditorStyleBase.resetCtrlParam3();
        pSSysEditorStyleBase.resetCtrlParam4();
        pSSysEditorStyleBase.resetCtrlParam5();
        pSSysEditorStyleBase.resetCtrlParam6();
        pSSysEditorStyleBase.resetCtrlParam7();
        pSSysEditorStyleBase.resetCtrlParam8();
        pSSysEditorStyleBase.resetCtrlParam9();
        pSSysEditorStyleBase.resetCtrlParams();
        pSSysEditorStyleBase.resetDynaModelFlag();
        pSSysEditorStyleBase.resetExtendStyleOnly();
        pSSysEditorStyleBase.resetHeight();
        pSSysEditorStyleBase.resetLinkViewShowMode();
        pSSysEditorStyleBase.resetLockFlag();
        pSSysEditorStyleBase.resetMemo();
        pSSysEditorStyleBase.resetPreviewHtml();
        pSSysEditorStyleBase.resetPSACHandlerId();
        pSSysEditorStyleBase.resetPSACHandlerName();
        pSSysEditorStyleBase.resetPSDynaInstId();
        pSSysEditorStyleBase.resetPSEditorStyleId();
        pSSysEditorStyleBase.resetPSEditorStyleName();
        pSSysEditorStyleBase.resetPSEditorTypeId();
        pSSysEditorStyleBase.resetPSEditorTypeName();
        pSSysEditorStyleBase.resetPSModuleId();
        pSSysEditorStyleBase.resetPSModuleName();
        pSSysEditorStyleBase.resetPSSysCssId();
        pSSysEditorStyleBase.resetPSSysCssName();
        pSSysEditorStyleBase.resetPSSysEditorStyleId();
        pSSysEditorStyleBase.resetPSSysEditorStyleName();
        pSSysEditorStyleBase.resetPSSysPFPluginId();
        pSSysEditorStyleBase.resetPSSysPFPluginName();
        pSSysEditorStyleBase.resetPSSystemId();
        pSSysEditorStyleBase.resetPSSystemName();
        pSSysEditorStyleBase.resetRefViewShowMode();
        pSSysEditorStyleBase.resetRepDefault();
        pSSysEditorStyleBase.resetStudioIcon();
        pSSysEditorStyleBase.resetUpdateDate();
        pSSysEditorStyleBase.resetUpdateMan();
        pSSysEditorStyleBase.resetUserCat();
        pSSysEditorStyleBase.resetUserTag();
        pSSysEditorStyleBase.resetUserTag2();
        pSSysEditorStyleBase.resetUserTag3();
        pSSysEditorStyleBase.resetUserTag4();
        pSSysEditorStyleBase.resetValidFlag();
        pSSysEditorStyleBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAjaxHandlerDirty()) {
            hashMap.put(FIELD_AJAXHANDLER, this.getAjaxHandler());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContainerTypeDirty()) {
            hashMap.put(FIELD_CONTAINERTYPE, this.getContainerType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlParamDirty()) {
            hashMap.put(FIELD_CTRLPARAM, this.getCtrlParam());
        }
        if (!bl || this.isCtrlParam10Dirty()) {
            hashMap.put(FIELD_CTRLPARAM10, this.getCtrlParam10());
        }
        if (!bl || this.isCtrlParam11Dirty()) {
            hashMap.put(FIELD_CTRLPARAM11, this.getCtrlParam11());
        }
        if (!bl || this.isCtrlParam12Dirty()) {
            hashMap.put(FIELD_CTRLPARAM12, this.getCtrlParam12());
        }
        if (!bl || this.isCtrlParam2Dirty()) {
            hashMap.put(FIELD_CTRLPARAM2, this.getCtrlParam2());
        }
        if (!bl || this.isCtrlParam3Dirty()) {
            hashMap.put(FIELD_CTRLPARAM3, this.getCtrlParam3());
        }
        if (!bl || this.isCtrlParam4Dirty()) {
            hashMap.put(FIELD_CTRLPARAM4, this.getCtrlParam4());
        }
        if (!bl || this.isCtrlParam5Dirty()) {
            hashMap.put(FIELD_CTRLPARAM5, this.getCtrlParam5());
        }
        if (!bl || this.isCtrlParam6Dirty()) {
            hashMap.put(FIELD_CTRLPARAM6, this.getCtrlParam6());
        }
        if (!bl || this.isCtrlParam7Dirty()) {
            hashMap.put(FIELD_CTRLPARAM7, this.getCtrlParam7());
        }
        if (!bl || this.isCtrlParam8Dirty()) {
            hashMap.put(FIELD_CTRLPARAM8, this.getCtrlParam8());
        }
        if (!bl || this.isCtrlParam9Dirty()) {
            hashMap.put(FIELD_CTRLPARAM9, this.getCtrlParam9());
        }
        if (!bl || this.isCtrlParamsDirty()) {
            hashMap.put(FIELD_CTRLPARAMS, this.getCtrlParams());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isExtendStyleOnlyDirty()) {
            hashMap.put(FIELD_EXTENDSTYLEONLY, this.getExtendStyleOnly());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isLinkViewShowModeDirty()) {
            hashMap.put(FIELD_LINKVIEWSHOWMODE, this.getLinkViewShowMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSEDITORSTYLEID, this.getPSEditorStyleId());
        }
        if (!bl || this.isPSEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSEDITORSTYLENAME, this.getPSEditorStyleName());
        }
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLEID, this.getPSSysEditorStyleId());
        }
        if (!bl || this.isPSSysEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLENAME, this.getPSSysEditorStyleName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRefViewShowModeDirty()) {
            hashMap.put(FIELD_REFVIEWSHOWMODE, this.getRefViewShowMode());
        }
        if (!bl || this.isRepDefaultDirty()) {
            hashMap.put(FIELD_REPDEFAULT, this.getRepDefault());
        }
        if (!bl || this.isStudioIconDirty()) {
            hashMap.put(FIELD_STUDIOICON, this.getStudioIcon());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSSysEditorStyleBase.get(this, n);
    }

    private static Object get(PSSysEditorStyleBase pSSysEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEditorStyleBase.getAjaxHandler();
            }
            case 1: {
                return pSSysEditorStyleBase.getCodeName();
            }
            case 2: {
                return pSSysEditorStyleBase.getContainerType();
            }
            case 3: {
                return pSSysEditorStyleBase.getCreateDate();
            }
            case 4: {
                return pSSysEditorStyleBase.getCreateMan();
            }
            case 5: {
                return pSSysEditorStyleBase.getCtrlParam();
            }
            case 6: {
                return pSSysEditorStyleBase.getCtrlParam10();
            }
            case 7: {
                return pSSysEditorStyleBase.getCtrlParam11();
            }
            case 8: {
                return pSSysEditorStyleBase.getCtrlParam12();
            }
            case 9: {
                return pSSysEditorStyleBase.getCtrlParam2();
            }
            case 10: {
                return pSSysEditorStyleBase.getCtrlParam3();
            }
            case 11: {
                return pSSysEditorStyleBase.getCtrlParam4();
            }
            case 12: {
                return pSSysEditorStyleBase.getCtrlParam5();
            }
            case 13: {
                return pSSysEditorStyleBase.getCtrlParam6();
            }
            case 14: {
                return pSSysEditorStyleBase.getCtrlParam7();
            }
            case 15: {
                return pSSysEditorStyleBase.getCtrlParam8();
            }
            case 16: {
                return pSSysEditorStyleBase.getCtrlParam9();
            }
            case 17: {
                return pSSysEditorStyleBase.getCtrlParams();
            }
            case 18: {
                return pSSysEditorStyleBase.getDynaModelFlag();
            }
            case 19: {
                return pSSysEditorStyleBase.getExtendStyleOnly();
            }
            case 20: {
                return pSSysEditorStyleBase.getHeight();
            }
            case 21: {
                return pSSysEditorStyleBase.getLinkViewShowMode();
            }
            case 22: {
                return pSSysEditorStyleBase.getLockFlag();
            }
            case 23: {
                return pSSysEditorStyleBase.getMemo();
            }
            case 24: {
                return pSSysEditorStyleBase.getPreviewHtml();
            }
            case 25: {
                return pSSysEditorStyleBase.getPSACHandlerId();
            }
            case 26: {
                return pSSysEditorStyleBase.getPSACHandlerName();
            }
            case 27: {
                return pSSysEditorStyleBase.getPSDynaInstId();
            }
            case 28: {
                return pSSysEditorStyleBase.getPSEditorStyleId();
            }
            case 29: {
                return pSSysEditorStyleBase.getPSEditorStyleName();
            }
            case 30: {
                return pSSysEditorStyleBase.getPSEditorTypeId();
            }
            case 31: {
                return pSSysEditorStyleBase.getPSEditorTypeName();
            }
            case 32: {
                return pSSysEditorStyleBase.getPSModuleId();
            }
            case 33: {
                return pSSysEditorStyleBase.getPSModuleName();
            }
            case 34: {
                return pSSysEditorStyleBase.getPSSysCssId();
            }
            case 35: {
                return pSSysEditorStyleBase.getPSSysCssName();
            }
            case 36: {
                return pSSysEditorStyleBase.getPSSysEditorStyleId();
            }
            case 37: {
                return pSSysEditorStyleBase.getPSSysEditorStyleName();
            }
            case 38: {
                return pSSysEditorStyleBase.getPSSysPFPluginId();
            }
            case 39: {
                return pSSysEditorStyleBase.getPSSysPFPluginName();
            }
            case 40: {
                return pSSysEditorStyleBase.getPSSystemId();
            }
            case 41: {
                return pSSysEditorStyleBase.getPSSystemName();
            }
            case 42: {
                return pSSysEditorStyleBase.getRefViewShowMode();
            }
            case 43: {
                return pSSysEditorStyleBase.getRepDefault();
            }
            case 44: {
                return pSSysEditorStyleBase.getStudioIcon();
            }
            case 45: {
                return pSSysEditorStyleBase.getUpdateDate();
            }
            case 46: {
                return pSSysEditorStyleBase.getUpdateMan();
            }
            case 47: {
                return pSSysEditorStyleBase.getUserCat();
            }
            case 48: {
                return pSSysEditorStyleBase.getUserTag();
            }
            case 49: {
                return pSSysEditorStyleBase.getUserTag2();
            }
            case 50: {
                return pSSysEditorStyleBase.getUserTag3();
            }
            case 51: {
                return pSSysEditorStyleBase.getUserTag4();
            }
            case 52: {
                return pSSysEditorStyleBase.getValidFlag();
            }
            case 53: {
                return pSSysEditorStyleBase.getWidth();
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
        PSSysEditorStyleBase.set(this, n, object);
    }

    private static void set(PSSysEditorStyleBase pSSysEditorStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEditorStyleBase.setAjaxHandler(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEditorStyleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysEditorStyleBase.setContainerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEditorStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysEditorStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEditorStyleBase.setCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEditorStyleBase.setCtrlParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 7: {
                pSSysEditorStyleBase.setCtrlParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysEditorStyleBase.setCtrlParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysEditorStyleBase.setCtrlParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEditorStyleBase.setCtrlParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEditorStyleBase.setCtrlParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEditorStyleBase.setCtrlParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysEditorStyleBase.setCtrlParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysEditorStyleBase.setCtrlParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysEditorStyleBase.setCtrlParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysEditorStyleBase.setCtrlParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 17: {
                pSSysEditorStyleBase.setCtrlParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEditorStyleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysEditorStyleBase.setExtendStyleOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysEditorStyleBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysEditorStyleBase.setLinkViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEditorStyleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysEditorStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEditorStyleBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEditorStyleBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEditorStyleBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysEditorStyleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysEditorStyleBase.setPSEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysEditorStyleBase.setPSEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysEditorStyleBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysEditorStyleBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysEditorStyleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysEditorStyleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysEditorStyleBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysEditorStyleBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysEditorStyleBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysEditorStyleBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysEditorStyleBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysEditorStyleBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysEditorStyleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysEditorStyleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysEditorStyleBase.setRefViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysEditorStyleBase.setRepDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSysEditorStyleBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysEditorStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 46: {
                pSSysEditorStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysEditorStyleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysEditorStyleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysEditorStyleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysEditorStyleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysEditorStyleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysEditorStyleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSSysEditorStyleBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSSysEditorStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEditorStyleBase pSSysEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEditorStyleBase.getAjaxHandler() == null;
            }
            case 1: {
                return pSSysEditorStyleBase.getCodeName() == null;
            }
            case 2: {
                return pSSysEditorStyleBase.getContainerType() == null;
            }
            case 3: {
                return pSSysEditorStyleBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysEditorStyleBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysEditorStyleBase.getCtrlParam() == null;
            }
            case 6: {
                return pSSysEditorStyleBase.getCtrlParam10() == null;
            }
            case 7: {
                return pSSysEditorStyleBase.getCtrlParam11() == null;
            }
            case 8: {
                return pSSysEditorStyleBase.getCtrlParam12() == null;
            }
            case 9: {
                return pSSysEditorStyleBase.getCtrlParam2() == null;
            }
            case 10: {
                return pSSysEditorStyleBase.getCtrlParam3() == null;
            }
            case 11: {
                return pSSysEditorStyleBase.getCtrlParam4() == null;
            }
            case 12: {
                return pSSysEditorStyleBase.getCtrlParam5() == null;
            }
            case 13: {
                return pSSysEditorStyleBase.getCtrlParam6() == null;
            }
            case 14: {
                return pSSysEditorStyleBase.getCtrlParam7() == null;
            }
            case 15: {
                return pSSysEditorStyleBase.getCtrlParam8() == null;
            }
            case 16: {
                return pSSysEditorStyleBase.getCtrlParam9() == null;
            }
            case 17: {
                return pSSysEditorStyleBase.getCtrlParams() == null;
            }
            case 18: {
                return pSSysEditorStyleBase.getDynaModelFlag() == null;
            }
            case 19: {
                return pSSysEditorStyleBase.getExtendStyleOnly() == null;
            }
            case 20: {
                return pSSysEditorStyleBase.getHeight() == null;
            }
            case 21: {
                return pSSysEditorStyleBase.getLinkViewShowMode() == null;
            }
            case 22: {
                return pSSysEditorStyleBase.getLockFlag() == null;
            }
            case 23: {
                return pSSysEditorStyleBase.getMemo() == null;
            }
            case 24: {
                return pSSysEditorStyleBase.getPreviewHtml() == null;
            }
            case 25: {
                return pSSysEditorStyleBase.getPSACHandlerId() == null;
            }
            case 26: {
                return pSSysEditorStyleBase.getPSACHandlerName() == null;
            }
            case 27: {
                return pSSysEditorStyleBase.getPSDynaInstId() == null;
            }
            case 28: {
                return pSSysEditorStyleBase.getPSEditorStyleId() == null;
            }
            case 29: {
                return pSSysEditorStyleBase.getPSEditorStyleName() == null;
            }
            case 30: {
                return pSSysEditorStyleBase.getPSEditorTypeId() == null;
            }
            case 31: {
                return pSSysEditorStyleBase.getPSEditorTypeName() == null;
            }
            case 32: {
                return pSSysEditorStyleBase.getPSModuleId() == null;
            }
            case 33: {
                return pSSysEditorStyleBase.getPSModuleName() == null;
            }
            case 34: {
                return pSSysEditorStyleBase.getPSSysCssId() == null;
            }
            case 35: {
                return pSSysEditorStyleBase.getPSSysCssName() == null;
            }
            case 36: {
                return pSSysEditorStyleBase.getPSSysEditorStyleId() == null;
            }
            case 37: {
                return pSSysEditorStyleBase.getPSSysEditorStyleName() == null;
            }
            case 38: {
                return pSSysEditorStyleBase.getPSSysPFPluginId() == null;
            }
            case 39: {
                return pSSysEditorStyleBase.getPSSysPFPluginName() == null;
            }
            case 40: {
                return pSSysEditorStyleBase.getPSSystemId() == null;
            }
            case 41: {
                return pSSysEditorStyleBase.getPSSystemName() == null;
            }
            case 42: {
                return pSSysEditorStyleBase.getRefViewShowMode() == null;
            }
            case 43: {
                return pSSysEditorStyleBase.getRepDefault() == null;
            }
            case 44: {
                return pSSysEditorStyleBase.getStudioIcon() == null;
            }
            case 45: {
                return pSSysEditorStyleBase.getUpdateDate() == null;
            }
            case 46: {
                return pSSysEditorStyleBase.getUpdateMan() == null;
            }
            case 47: {
                return pSSysEditorStyleBase.getUserCat() == null;
            }
            case 48: {
                return pSSysEditorStyleBase.getUserTag() == null;
            }
            case 49: {
                return pSSysEditorStyleBase.getUserTag2() == null;
            }
            case 50: {
                return pSSysEditorStyleBase.getUserTag3() == null;
            }
            case 51: {
                return pSSysEditorStyleBase.getUserTag4() == null;
            }
            case 52: {
                return pSSysEditorStyleBase.getValidFlag() == null;
            }
            case 53: {
                return pSSysEditorStyleBase.getWidth() == null;
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
        return PSSysEditorStyleBase.contains(this, n);
    }

    private static boolean contains(PSSysEditorStyleBase pSSysEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEditorStyleBase.isAjaxHandlerDirty();
            }
            case 1: {
                return pSSysEditorStyleBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysEditorStyleBase.isContainerTypeDirty();
            }
            case 3: {
                return pSSysEditorStyleBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysEditorStyleBase.isCreateManDirty();
            }
            case 5: {
                return pSSysEditorStyleBase.isCtrlParamDirty();
            }
            case 6: {
                return pSSysEditorStyleBase.isCtrlParam10Dirty();
            }
            case 7: {
                return pSSysEditorStyleBase.isCtrlParam11Dirty();
            }
            case 8: {
                return pSSysEditorStyleBase.isCtrlParam12Dirty();
            }
            case 9: {
                return pSSysEditorStyleBase.isCtrlParam2Dirty();
            }
            case 10: {
                return pSSysEditorStyleBase.isCtrlParam3Dirty();
            }
            case 11: {
                return pSSysEditorStyleBase.isCtrlParam4Dirty();
            }
            case 12: {
                return pSSysEditorStyleBase.isCtrlParam5Dirty();
            }
            case 13: {
                return pSSysEditorStyleBase.isCtrlParam6Dirty();
            }
            case 14: {
                return pSSysEditorStyleBase.isCtrlParam7Dirty();
            }
            case 15: {
                return pSSysEditorStyleBase.isCtrlParam8Dirty();
            }
            case 16: {
                return pSSysEditorStyleBase.isCtrlParam9Dirty();
            }
            case 17: {
                return pSSysEditorStyleBase.isCtrlParamsDirty();
            }
            case 18: {
                return pSSysEditorStyleBase.isDynaModelFlagDirty();
            }
            case 19: {
                return pSSysEditorStyleBase.isExtendStyleOnlyDirty();
            }
            case 20: {
                return pSSysEditorStyleBase.isHeightDirty();
            }
            case 21: {
                return pSSysEditorStyleBase.isLinkViewShowModeDirty();
            }
            case 22: {
                return pSSysEditorStyleBase.isLockFlagDirty();
            }
            case 23: {
                return pSSysEditorStyleBase.isMemoDirty();
            }
            case 24: {
                return pSSysEditorStyleBase.isPreviewHtmlDirty();
            }
            case 25: {
                return pSSysEditorStyleBase.isPSACHandlerIdDirty();
            }
            case 26: {
                return pSSysEditorStyleBase.isPSACHandlerNameDirty();
            }
            case 27: {
                return pSSysEditorStyleBase.isPSDynaInstIdDirty();
            }
            case 28: {
                return pSSysEditorStyleBase.isPSEditorStyleIdDirty();
            }
            case 29: {
                return pSSysEditorStyleBase.isPSEditorStyleNameDirty();
            }
            case 30: {
                return pSSysEditorStyleBase.isPSEditorTypeIdDirty();
            }
            case 31: {
                return pSSysEditorStyleBase.isPSEditorTypeNameDirty();
            }
            case 32: {
                return pSSysEditorStyleBase.isPSModuleIdDirty();
            }
            case 33: {
                return pSSysEditorStyleBase.isPSModuleNameDirty();
            }
            case 34: {
                return pSSysEditorStyleBase.isPSSysCssIdDirty();
            }
            case 35: {
                return pSSysEditorStyleBase.isPSSysCssNameDirty();
            }
            case 36: {
                return pSSysEditorStyleBase.isPSSysEditorStyleIdDirty();
            }
            case 37: {
                return pSSysEditorStyleBase.isPSSysEditorStyleNameDirty();
            }
            case 38: {
                return pSSysEditorStyleBase.isPSSysPFPluginIdDirty();
            }
            case 39: {
                return pSSysEditorStyleBase.isPSSysPFPluginNameDirty();
            }
            case 40: {
                return pSSysEditorStyleBase.isPSSystemIdDirty();
            }
            case 41: {
                return pSSysEditorStyleBase.isPSSystemNameDirty();
            }
            case 42: {
                return pSSysEditorStyleBase.isRefViewShowModeDirty();
            }
            case 43: {
                return pSSysEditorStyleBase.isRepDefaultDirty();
            }
            case 44: {
                return pSSysEditorStyleBase.isStudioIconDirty();
            }
            case 45: {
                return pSSysEditorStyleBase.isUpdateDateDirty();
            }
            case 46: {
                return pSSysEditorStyleBase.isUpdateManDirty();
            }
            case 47: {
                return pSSysEditorStyleBase.isUserCatDirty();
            }
            case 48: {
                return pSSysEditorStyleBase.isUserTagDirty();
            }
            case 49: {
                return pSSysEditorStyleBase.isUserTag2Dirty();
            }
            case 50: {
                return pSSysEditorStyleBase.isUserTag3Dirty();
            }
            case 51: {
                return pSSysEditorStyleBase.isUserTag4Dirty();
            }
            case 52: {
                return pSSysEditorStyleBase.isValidFlagDirty();
            }
            case 53: {
                return pSSysEditorStyleBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEditorStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEditorStyleBase pSSysEditorStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEditorStyleBase.getAjaxHandler() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ajaxhandler", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getAjaxHandler()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getContainerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containertype", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getContainerType()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam10", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam10()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam11", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam11()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam12", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam12()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam2", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam2()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam3", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam3()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam4", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam4()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam5", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam5()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam6", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam6()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam7", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam7()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam8", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam8()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam9", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParam9()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparams", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getCtrlParams()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getExtendStyleOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendstyleonly", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getExtendStyleOnly()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getLinkViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkviewshowmode", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getLinkViewShowMode()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditorstyleid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSEditorStyleId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditorstylename", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSEditorStyleName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getRefViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refviewshowmode", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getRefViewShowMode()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getRepDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repdefault", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getRepDefault()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysEditorStyleBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysEditorStyleBase.getJSONValue((Object)pSSysEditorStyleBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEditorStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEditorStyleBase pSSysEditorStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEditorStyleBase.getAjaxHandler() != null) {
            object = pSSysEditorStyleBase.getAjaxHandler();
            xmlNode.setAttribute(FIELD_AJAXHANDLER, (String)(object == null ? "" : object));
        }
        if (bl || pSSysEditorStyleBase.getCodeName() != null) {
            object = pSSysEditorStyleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysEditorStyleBase.getContainerType() != null) {
            object = pSSysEditorStyleBase.getContainerType();
            xmlNode.setAttribute(FIELD_CONTAINERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCreateDate() != null) {
            object = pSSysEditorStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCreateMan() != null) {
            object = pSSysEditorStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam() != null) {
            object = pSSysEditorStyleBase.getCtrlParam();
            xmlNode.setAttribute(FIELD_CTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam10() != null) {
            object = pSSysEditorStyleBase.getCtrlParam10();
            xmlNode.setAttribute(FIELD_CTRLPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam11() != null) {
            object = pSSysEditorStyleBase.getCtrlParam11();
            xmlNode.setAttribute(FIELD_CTRLPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam12() != null) {
            object = pSSysEditorStyleBase.getCtrlParam12();
            xmlNode.setAttribute(FIELD_CTRLPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam2() != null) {
            object = pSSysEditorStyleBase.getCtrlParam2();
            xmlNode.setAttribute(FIELD_CTRLPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam3() != null) {
            object = pSSysEditorStyleBase.getCtrlParam3();
            xmlNode.setAttribute(FIELD_CTRLPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam4() != null) {
            object = pSSysEditorStyleBase.getCtrlParam4();
            xmlNode.setAttribute(FIELD_CTRLPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam5() != null) {
            object = pSSysEditorStyleBase.getCtrlParam5();
            xmlNode.setAttribute(FIELD_CTRLPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam6() != null) {
            object = pSSysEditorStyleBase.getCtrlParam6();
            xmlNode.setAttribute(FIELD_CTRLPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam7() != null) {
            object = pSSysEditorStyleBase.getCtrlParam7();
            xmlNode.setAttribute(FIELD_CTRLPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam8() != null) {
            object = pSSysEditorStyleBase.getCtrlParam8();
            xmlNode.setAttribute(FIELD_CTRLPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParam9() != null) {
            object = pSSysEditorStyleBase.getCtrlParam9();
            xmlNode.setAttribute(FIELD_CTRLPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getCtrlParams() != null) {
            object = pSSysEditorStyleBase.getCtrlParams();
            xmlNode.setAttribute(FIELD_CTRLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getDynaModelFlag() != null) {
            object = pSSysEditorStyleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getExtendStyleOnly() != null) {
            object = pSSysEditorStyleBase.getExtendStyleOnly();
            xmlNode.setAttribute(FIELD_EXTENDSTYLEONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getHeight() != null) {
            object = pSSysEditorStyleBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getLinkViewShowMode() != null) {
            object = pSSysEditorStyleBase.getLinkViewShowMode();
            xmlNode.setAttribute(FIELD_LINKVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getLockFlag() != null) {
            object = pSSysEditorStyleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getMemo() != null) {
            object = pSSysEditorStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPreviewHtml() != null) {
            object = pSSysEditorStyleBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSACHandlerId() != null) {
            object = pSSysEditorStyleBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSACHandlerName() != null) {
            object = pSSysEditorStyleBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSDynaInstId() != null) {
            object = pSSysEditorStyleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorStyleId() != null) {
            object = pSSysEditorStyleBase.getPSEditorStyleId();
            xmlNode.setAttribute(FIELD_PSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorStyleName() != null) {
            object = pSSysEditorStyleBase.getPSEditorStyleName();
            xmlNode.setAttribute(FIELD_PSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorTypeId() != null) {
            object = pSSysEditorStyleBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSEditorTypeName() != null) {
            object = pSSysEditorStyleBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSModuleId() != null) {
            object = pSSysEditorStyleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSModuleName() != null) {
            object = pSSysEditorStyleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysCssId() != null) {
            object = pSSysEditorStyleBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysCssName() != null) {
            object = pSSysEditorStyleBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysEditorStyleId() != null) {
            object = pSSysEditorStyleBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysEditorStyleName() != null) {
            object = pSSysEditorStyleBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysPFPluginId() != null) {
            object = pSSysEditorStyleBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSysPFPluginName() != null) {
            object = pSSysEditorStyleBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSystemId() != null) {
            object = pSSysEditorStyleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getPSSystemName() != null) {
            object = pSSysEditorStyleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getRefViewShowMode() != null) {
            object = pSSysEditorStyleBase.getRefViewShowMode();
            xmlNode.setAttribute(FIELD_REFVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getRepDefault() != null) {
            object = pSSysEditorStyleBase.getRepDefault();
            xmlNode.setAttribute(FIELD_REPDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getStudioIcon() != null) {
            object = pSSysEditorStyleBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUpdateDate() != null) {
            object = pSSysEditorStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getUpdateMan() != null) {
            object = pSSysEditorStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUserCat() != null) {
            object = pSSysEditorStyleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUserTag() != null) {
            object = pSSysEditorStyleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUserTag2() != null) {
            object = pSSysEditorStyleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUserTag3() != null) {
            object = pSSysEditorStyleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getUserTag4() != null) {
            object = pSSysEditorStyleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEditorStyleBase.getValidFlag() != null) {
            object = pSSysEditorStyleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEditorStyleBase.getWidth() != null) {
            object = pSSysEditorStyleBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEditorStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEditorStyleBase pSSysEditorStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEditorStyleBase.isAjaxHandlerDirty() && (bl || pSSysEditorStyleBase.getAjaxHandler() != null)) {
            iDataObject.set(FIELD_AJAXHANDLER, (Object)pSSysEditorStyleBase.getAjaxHandler());
        }
        if (pSSysEditorStyleBase.isCodeNameDirty() && (bl || pSSysEditorStyleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEditorStyleBase.getCodeName());
        }
        if (pSSysEditorStyleBase.isContainerTypeDirty() && (bl || pSSysEditorStyleBase.getContainerType() != null)) {
            iDataObject.set(FIELD_CONTAINERTYPE, (Object)pSSysEditorStyleBase.getContainerType());
        }
        if (pSSysEditorStyleBase.isCreateDateDirty() && (bl || pSSysEditorStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEditorStyleBase.getCreateDate());
        }
        if (pSSysEditorStyleBase.isCreateManDirty() && (bl || pSSysEditorStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEditorStyleBase.getCreateMan());
        }
        if (pSSysEditorStyleBase.isCtrlParamDirty() && (bl || pSSysEditorStyleBase.getCtrlParam() != null)) {
            iDataObject.set(FIELD_CTRLPARAM, (Object)pSSysEditorStyleBase.getCtrlParam());
        }
        if (pSSysEditorStyleBase.isCtrlParam10Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam10() != null)) {
            iDataObject.set(FIELD_CTRLPARAM10, (Object)pSSysEditorStyleBase.getCtrlParam10());
        }
        if (pSSysEditorStyleBase.isCtrlParam11Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam11() != null)) {
            iDataObject.set(FIELD_CTRLPARAM11, (Object)pSSysEditorStyleBase.getCtrlParam11());
        }
        if (pSSysEditorStyleBase.isCtrlParam12Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam12() != null)) {
            iDataObject.set(FIELD_CTRLPARAM12, (Object)pSSysEditorStyleBase.getCtrlParam12());
        }
        if (pSSysEditorStyleBase.isCtrlParam2Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam2() != null)) {
            iDataObject.set(FIELD_CTRLPARAM2, (Object)pSSysEditorStyleBase.getCtrlParam2());
        }
        if (pSSysEditorStyleBase.isCtrlParam3Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam3() != null)) {
            iDataObject.set(FIELD_CTRLPARAM3, (Object)pSSysEditorStyleBase.getCtrlParam3());
        }
        if (pSSysEditorStyleBase.isCtrlParam4Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam4() != null)) {
            iDataObject.set(FIELD_CTRLPARAM4, (Object)pSSysEditorStyleBase.getCtrlParam4());
        }
        if (pSSysEditorStyleBase.isCtrlParam5Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam5() != null)) {
            iDataObject.set(FIELD_CTRLPARAM5, (Object)pSSysEditorStyleBase.getCtrlParam5());
        }
        if (pSSysEditorStyleBase.isCtrlParam6Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam6() != null)) {
            iDataObject.set(FIELD_CTRLPARAM6, (Object)pSSysEditorStyleBase.getCtrlParam6());
        }
        if (pSSysEditorStyleBase.isCtrlParam7Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam7() != null)) {
            iDataObject.set(FIELD_CTRLPARAM7, (Object)pSSysEditorStyleBase.getCtrlParam7());
        }
        if (pSSysEditorStyleBase.isCtrlParam8Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam8() != null)) {
            iDataObject.set(FIELD_CTRLPARAM8, (Object)pSSysEditorStyleBase.getCtrlParam8());
        }
        if (pSSysEditorStyleBase.isCtrlParam9Dirty() && (bl || pSSysEditorStyleBase.getCtrlParam9() != null)) {
            iDataObject.set(FIELD_CTRLPARAM9, (Object)pSSysEditorStyleBase.getCtrlParam9());
        }
        if (pSSysEditorStyleBase.isCtrlParamsDirty() && (bl || pSSysEditorStyleBase.getCtrlParams() != null)) {
            iDataObject.set(FIELD_CTRLPARAMS, (Object)pSSysEditorStyleBase.getCtrlParams());
        }
        if (pSSysEditorStyleBase.isDynaModelFlagDirty() && (bl || pSSysEditorStyleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysEditorStyleBase.getDynaModelFlag());
        }
        if (pSSysEditorStyleBase.isExtendStyleOnlyDirty() && (bl || pSSysEditorStyleBase.getExtendStyleOnly() != null)) {
            iDataObject.set(FIELD_EXTENDSTYLEONLY, (Object)pSSysEditorStyleBase.getExtendStyleOnly());
        }
        if (pSSysEditorStyleBase.isHeightDirty() && (bl || pSSysEditorStyleBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysEditorStyleBase.getHeight());
        }
        if (pSSysEditorStyleBase.isLinkViewShowModeDirty() && (bl || pSSysEditorStyleBase.getLinkViewShowMode() != null)) {
            iDataObject.set(FIELD_LINKVIEWSHOWMODE, (Object)pSSysEditorStyleBase.getLinkViewShowMode());
        }
        if (pSSysEditorStyleBase.isLockFlagDirty() && (bl || pSSysEditorStyleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysEditorStyleBase.getLockFlag());
        }
        if (pSSysEditorStyleBase.isMemoDirty() && (bl || pSSysEditorStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEditorStyleBase.getMemo());
        }
        if (pSSysEditorStyleBase.isPreviewHtmlDirty() && (bl || pSSysEditorStyleBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSysEditorStyleBase.getPreviewHtml());
        }
        if (pSSysEditorStyleBase.isPSACHandlerIdDirty() && (bl || pSSysEditorStyleBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSSysEditorStyleBase.getPSACHandlerId());
        }
        if (pSSysEditorStyleBase.isPSACHandlerNameDirty() && (bl || pSSysEditorStyleBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSSysEditorStyleBase.getPSACHandlerName());
        }
        if (pSSysEditorStyleBase.isPSDynaInstIdDirty() && (bl || pSSysEditorStyleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysEditorStyleBase.getPSDynaInstId());
        }
        if (pSSysEditorStyleBase.isPSEditorStyleIdDirty() && (bl || pSSysEditorStyleBase.getPSEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSEDITORSTYLEID, (Object)pSSysEditorStyleBase.getPSEditorStyleId());
        }
        if (pSSysEditorStyleBase.isPSEditorStyleNameDirty() && (bl || pSSysEditorStyleBase.getPSEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSEDITORSTYLENAME, (Object)pSSysEditorStyleBase.getPSEditorStyleName());
        }
        if (pSSysEditorStyleBase.isPSEditorTypeIdDirty() && (bl || pSSysEditorStyleBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSSysEditorStyleBase.getPSEditorTypeId());
        }
        if (pSSysEditorStyleBase.isPSEditorTypeNameDirty() && (bl || pSSysEditorStyleBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSSysEditorStyleBase.getPSEditorTypeName());
        }
        if (pSSysEditorStyleBase.isPSModuleIdDirty() && (bl || pSSysEditorStyleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysEditorStyleBase.getPSModuleId());
        }
        if (pSSysEditorStyleBase.isPSModuleNameDirty() && (bl || pSSysEditorStyleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysEditorStyleBase.getPSModuleName());
        }
        if (pSSysEditorStyleBase.isPSSysCssIdDirty() && (bl || pSSysEditorStyleBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysEditorStyleBase.getPSSysCssId());
        }
        if (pSSysEditorStyleBase.isPSSysCssNameDirty() && (bl || pSSysEditorStyleBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysEditorStyleBase.getPSSysCssName());
        }
        if (pSSysEditorStyleBase.isPSSysEditorStyleIdDirty() && (bl || pSSysEditorStyleBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        }
        if (pSSysEditorStyleBase.isPSSysEditorStyleNameDirty() && (bl || pSSysEditorStyleBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSSysEditorStyleBase.getPSSysEditorStyleName());
        }
        if (pSSysEditorStyleBase.isPSSysPFPluginIdDirty() && (bl || pSSysEditorStyleBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysEditorStyleBase.getPSSysPFPluginId());
        }
        if (pSSysEditorStyleBase.isPSSysPFPluginNameDirty() && (bl || pSSysEditorStyleBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysEditorStyleBase.getPSSysPFPluginName());
        }
        if (pSSysEditorStyleBase.isPSSystemIdDirty() && (bl || pSSysEditorStyleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysEditorStyleBase.getPSSystemId());
        }
        if (pSSysEditorStyleBase.isPSSystemNameDirty() && (bl || pSSysEditorStyleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysEditorStyleBase.getPSSystemName());
        }
        if (pSSysEditorStyleBase.isRefViewShowModeDirty() && (bl || pSSysEditorStyleBase.getRefViewShowMode() != null)) {
            iDataObject.set(FIELD_REFVIEWSHOWMODE, (Object)pSSysEditorStyleBase.getRefViewShowMode());
        }
        if (pSSysEditorStyleBase.isRepDefaultDirty() && (bl || pSSysEditorStyleBase.getRepDefault() != null)) {
            iDataObject.set(FIELD_REPDEFAULT, (Object)pSSysEditorStyleBase.getRepDefault());
        }
        if (pSSysEditorStyleBase.isStudioIconDirty() && (bl || pSSysEditorStyleBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSSysEditorStyleBase.getStudioIcon());
        }
        if (pSSysEditorStyleBase.isUpdateDateDirty() && (bl || pSSysEditorStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEditorStyleBase.getUpdateDate());
        }
        if (pSSysEditorStyleBase.isUpdateManDirty() && (bl || pSSysEditorStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEditorStyleBase.getUpdateMan());
        }
        if (pSSysEditorStyleBase.isUserCatDirty() && (bl || pSSysEditorStyleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEditorStyleBase.getUserCat());
        }
        if (pSSysEditorStyleBase.isUserTagDirty() && (bl || pSSysEditorStyleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEditorStyleBase.getUserTag());
        }
        if (pSSysEditorStyleBase.isUserTag2Dirty() && (bl || pSSysEditorStyleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEditorStyleBase.getUserTag2());
        }
        if (pSSysEditorStyleBase.isUserTag3Dirty() && (bl || pSSysEditorStyleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEditorStyleBase.getUserTag3());
        }
        if (pSSysEditorStyleBase.isUserTag4Dirty() && (bl || pSSysEditorStyleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEditorStyleBase.getUserTag4());
        }
        if (pSSysEditorStyleBase.isValidFlagDirty() && (bl || pSSysEditorStyleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEditorStyleBase.getValidFlag());
        }
        if (pSSysEditorStyleBase.isWidthDirty() && (bl || pSSysEditorStyleBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysEditorStyleBase.getWidth());
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
        return PSSysEditorStyleBase.remove(this, n);
    }

    private static boolean remove(PSSysEditorStyleBase pSSysEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEditorStyleBase.resetAjaxHandler();
                return true;
            }
            case 1: {
                pSSysEditorStyleBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysEditorStyleBase.resetContainerType();
                return true;
            }
            case 3: {
                pSSysEditorStyleBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysEditorStyleBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysEditorStyleBase.resetCtrlParam();
                return true;
            }
            case 6: {
                pSSysEditorStyleBase.resetCtrlParam10();
                return true;
            }
            case 7: {
                pSSysEditorStyleBase.resetCtrlParam11();
                return true;
            }
            case 8: {
                pSSysEditorStyleBase.resetCtrlParam12();
                return true;
            }
            case 9: {
                pSSysEditorStyleBase.resetCtrlParam2();
                return true;
            }
            case 10: {
                pSSysEditorStyleBase.resetCtrlParam3();
                return true;
            }
            case 11: {
                pSSysEditorStyleBase.resetCtrlParam4();
                return true;
            }
            case 12: {
                pSSysEditorStyleBase.resetCtrlParam5();
                return true;
            }
            case 13: {
                pSSysEditorStyleBase.resetCtrlParam6();
                return true;
            }
            case 14: {
                pSSysEditorStyleBase.resetCtrlParam7();
                return true;
            }
            case 15: {
                pSSysEditorStyleBase.resetCtrlParam8();
                return true;
            }
            case 16: {
                pSSysEditorStyleBase.resetCtrlParam9();
                return true;
            }
            case 17: {
                pSSysEditorStyleBase.resetCtrlParams();
                return true;
            }
            case 18: {
                pSSysEditorStyleBase.resetDynaModelFlag();
                return true;
            }
            case 19: {
                pSSysEditorStyleBase.resetExtendStyleOnly();
                return true;
            }
            case 20: {
                pSSysEditorStyleBase.resetHeight();
                return true;
            }
            case 21: {
                pSSysEditorStyleBase.resetLinkViewShowMode();
                return true;
            }
            case 22: {
                pSSysEditorStyleBase.resetLockFlag();
                return true;
            }
            case 23: {
                pSSysEditorStyleBase.resetMemo();
                return true;
            }
            case 24: {
                pSSysEditorStyleBase.resetPreviewHtml();
                return true;
            }
            case 25: {
                pSSysEditorStyleBase.resetPSACHandlerId();
                return true;
            }
            case 26: {
                pSSysEditorStyleBase.resetPSACHandlerName();
                return true;
            }
            case 27: {
                pSSysEditorStyleBase.resetPSDynaInstId();
                return true;
            }
            case 28: {
                pSSysEditorStyleBase.resetPSEditorStyleId();
                return true;
            }
            case 29: {
                pSSysEditorStyleBase.resetPSEditorStyleName();
                return true;
            }
            case 30: {
                pSSysEditorStyleBase.resetPSEditorTypeId();
                return true;
            }
            case 31: {
                pSSysEditorStyleBase.resetPSEditorTypeName();
                return true;
            }
            case 32: {
                pSSysEditorStyleBase.resetPSModuleId();
                return true;
            }
            case 33: {
                pSSysEditorStyleBase.resetPSModuleName();
                return true;
            }
            case 34: {
                pSSysEditorStyleBase.resetPSSysCssId();
                return true;
            }
            case 35: {
                pSSysEditorStyleBase.resetPSSysCssName();
                return true;
            }
            case 36: {
                pSSysEditorStyleBase.resetPSSysEditorStyleId();
                return true;
            }
            case 37: {
                pSSysEditorStyleBase.resetPSSysEditorStyleName();
                return true;
            }
            case 38: {
                pSSysEditorStyleBase.resetPSSysPFPluginId();
                return true;
            }
            case 39: {
                pSSysEditorStyleBase.resetPSSysPFPluginName();
                return true;
            }
            case 40: {
                pSSysEditorStyleBase.resetPSSystemId();
                return true;
            }
            case 41: {
                pSSysEditorStyleBase.resetPSSystemName();
                return true;
            }
            case 42: {
                pSSysEditorStyleBase.resetRefViewShowMode();
                return true;
            }
            case 43: {
                pSSysEditorStyleBase.resetRepDefault();
                return true;
            }
            case 44: {
                pSSysEditorStyleBase.resetStudioIcon();
                return true;
            }
            case 45: {
                pSSysEditorStyleBase.resetUpdateDate();
                return true;
            }
            case 46: {
                pSSysEditorStyleBase.resetUpdateMan();
                return true;
            }
            case 47: {
                pSSysEditorStyleBase.resetUserCat();
                return true;
            }
            case 48: {
                pSSysEditorStyleBase.resetUserTag();
                return true;
            }
            case 49: {
                pSSysEditorStyleBase.resetUserTag2();
                return true;
            }
            case 50: {
                pSSysEditorStyleBase.resetUserTag3();
                return true;
            }
            case 51: {
                pSSysEditorStyleBase.resetUserTag4();
                return true;
            }
            case 52: {
                pSSysEditorStyleBase.resetValidFlag();
                return true;
            }
            case 53: {
                pSSysEditorStyleBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandler();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSACHandlerLock;
        synchronized (n) {
            if (this.psachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSACHandlerId(), (Object)this.psachandler.getPSACHandlerId()) != 0L) {
                this.psachandler = null;
            }
            if (this.psachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorStyle getPSEditorStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorStyle();
        }
        if (this.getPSEditorStyleId() == null) {
            return null;
        }
        Integer n = this.objPSEditorStyleLock;
        synchronized (n) {
            if (this.pseditorstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorStyleId(), (Object)this.pseditorstyle.getPSEditorStyleId()) != 0L) {
                this.pseditorstyle = null;
            }
            if (this.pseditorstyle == null) {
                PSEditorStyle pSEditorStyle = new PSEditorStyle();
                pSEditorStyle.setPSEditorStyleId(this.getPSEditorStyleId());
                PSEditorStyleService pSEditorStyleService = (PSEditorStyleService)ServiceGlobal.getService(PSEditorStyleService.class, (SessionFactory)this.getSessionFactory());
                pSEditorStyleService.autoGet((IEntity)pSEditorStyle);
                this.pseditorstyle = pSEditorStyle;
            }
            return this.pseditorstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorType getPSEditorType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorType();
        }
        if (this.getPSEditorTypeId() == null) {
            return null;
        }
        Integer n = this.objPSEditorTypeLock;
        synchronized (n) {
            if (this.pseditortype != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorTypeId(), (Object)this.pseditortype.getPSEditorTypeId()) != 0L) {
                this.pseditortype = null;
            }
            if (this.pseditortype == null) {
                PSEditorType pSEditorType = new PSEditorType();
                pSEditorType.setPSEditorTypeId(this.getPSEditorTypeId());
                PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
                pSEditorTypeService.autoGet((IEntity)pSEditorType);
                this.pseditortype = pSEditorType;
            }
            return this.pseditortype;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysEditorStyleBase getProxyEntity() {
        return this.proxyPSSysEditorStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEditorStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEditorStyleBase) {
            this.proxyPSSysEditorStyleBase = (PSSysEditorStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AJAXHANDLER, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTAINERTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CTRLPARAM, 5);
        fieldIndexMap.put(FIELD_CTRLPARAM10, 6);
        fieldIndexMap.put(FIELD_CTRLPARAM11, 7);
        fieldIndexMap.put(FIELD_CTRLPARAM12, 8);
        fieldIndexMap.put(FIELD_CTRLPARAM2, 9);
        fieldIndexMap.put(FIELD_CTRLPARAM3, 10);
        fieldIndexMap.put(FIELD_CTRLPARAM4, 11);
        fieldIndexMap.put(FIELD_CTRLPARAM5, 12);
        fieldIndexMap.put(FIELD_CTRLPARAM6, 13);
        fieldIndexMap.put(FIELD_CTRLPARAM7, 14);
        fieldIndexMap.put(FIELD_CTRLPARAM8, 15);
        fieldIndexMap.put(FIELD_CTRLPARAM9, 16);
        fieldIndexMap.put(FIELD_CTRLPARAMS, 17);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 18);
        fieldIndexMap.put(FIELD_EXTENDSTYLEONLY, 19);
        fieldIndexMap.put(FIELD_HEIGHT, 20);
        fieldIndexMap.put(FIELD_LINKVIEWSHOWMODE, 21);
        fieldIndexMap.put(FIELD_LOCKFLAG, 22);
        fieldIndexMap.put(FIELD_MEMO, 23);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 24);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 25);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 26);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 27);
        fieldIndexMap.put(FIELD_PSEDITORSTYLEID, 28);
        fieldIndexMap.put(FIELD_PSEDITORSTYLENAME, 29);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 30);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 31);
        fieldIndexMap.put(FIELD_PSMODULEID, 32);
        fieldIndexMap.put(FIELD_PSMODULENAME, 33);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 34);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 36);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 37);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 38);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 40);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 41);
        fieldIndexMap.put(FIELD_REFVIEWSHOWMODE, 42);
        fieldIndexMap.put(FIELD_REPDEFAULT, 43);
        fieldIndexMap.put(FIELD_STUDIOICON, 44);
        fieldIndexMap.put(FIELD_UPDATEDATE, 45);
        fieldIndexMap.put(FIELD_UPDATEMAN, 46);
        fieldIndexMap.put(FIELD_USERCAT, 47);
        fieldIndexMap.put(FIELD_USERTAG, 48);
        fieldIndexMap.put(FIELD_USERTAG2, 49);
        fieldIndexMap.put(FIELD_USERTAG3, 50);
        fieldIndexMap.put(FIELD_USERTAG4, 51);
        fieldIndexMap.put(FIELD_VALIDFLAG, 52);
        fieldIndexMap.put(FIELD_WIDTH, 53);
    }
}

