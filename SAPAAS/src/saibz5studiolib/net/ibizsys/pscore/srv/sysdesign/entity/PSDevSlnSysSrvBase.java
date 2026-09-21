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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysSrvBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysSrvBase.class);
    public static final String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGCODENAME = "PKGCODENAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String FIELD_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PUBTAG = "PUBTAG";
    public static final String FIELD_PUBTAG2 = "PUBTAG2";
    public static final String FIELD_PUBTAG3 = "PUBTAG3";
    public static final String FIELD_PUBTAG4 = "PUBTAG4";
    public static final String FIELD_SYSCODENAME = "SYSCODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACCESSTOKEN = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTENTTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENABLELINK = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PKGCODENAME = 7;
    private static final int INDEX_PSDEVSLNID = 8;
    private static final int INDEX_PSDEVSLNSYSID = 9;
    private static final int INDEX_PSDEVSLNSYSNAME = 10;
    private static final int INDEX_PSDEVSLNSYSSRVID = 11;
    private static final int INDEX_PSDEVSLNSYSSRVNAME = 12;
    private static final int INDEX_PSSFSTYLEID = 13;
    private static final int INDEX_PSSFSTYLENAME = 14;
    private static final int INDEX_PSSFSTYLEVERID = 15;
    private static final int INDEX_PSSFSTYLEVERNAME = 16;
    private static final int INDEX_PSSYSSFPUBID = 17;
    private static final int INDEX_PSSYSSFPUBNAME = 18;
    private static final int INDEX_PUBTAG = 19;
    private static final int INDEX_PUBTAG2 = 20;
    private static final int INDEX_PUBTAG3 = 21;
    private static final int INDEX_PUBTAG4 = 22;
    private static final int INDEX_SYSCODENAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysSrvBase proxyPSDevSlnSysSrvBase = null;
    private boolean accesstokenDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgcodenameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyssrvidDirtyFlag = false;
    private boolean psdevslnsyssrvnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleveridDirtyFlag = false;
    private boolean pssfstylevernameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pubtagDirtyFlag = false;
    private boolean pubtag2DirtyFlag = false;
    private boolean pubtag3DirtyFlag = false;
    private boolean pubtag4DirtyFlag = false;
    private boolean syscodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="accesstoken")
    private String accesstoken;
    @Column(name="codename")
    private String codename;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablelink")
    private Integer enablelink;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgcodename")
    private String pkgcodename;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyssrvid")
    private String psdevslnsyssrvid;
    @Column(name="psdevslnsyssrvname")
    private String psdevslnsyssrvname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleverid")
    private String pssfstyleverid;
    @Column(name="pssfstylevername")
    private String pssfstylevername;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pubtag")
    private String pubtag;
    @Column(name="pubtag2")
    private String pubtag2;
    @Column(name="pubtag3")
    private String pubtag3;
    @Column(name="pubtag4")
    private String pubtag4;
    @Column(name="syscodename")
    private String syscodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSFStyleVerLock = new Integer(1);
    private PSSFStyleVer pssfstylever = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSDevSlnPipelineStepsLock = new Integer(1);
    private ArrayList<PSDevSlnPipelineStep> psdevslnpipelinesteps = null;
    private Integer objPSDevSlnSysRefLinksLock = new Integer(1);
    private ArrayList<PSDevSlnSysRefLink> psdevslnsysreflinks = null;
    private Integer objPSDevSlnSysRefsLock = new Integer(1);
    private ArrayList<PSDevSlnSysRef> psdevslnsysrefs = null;
    private Integer objPSDevSlnTemplsLock = new Integer(1);
    private ArrayList<PSDevSlnTempl> psdevslntempls = null;
    private Integer objPSSysRefsLock = new Integer(1);
    private ArrayList<PSSysRef> pssysrefs = null;

    public void setAccessToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccessToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.accesstoken = string;
        this.accesstokenDirtyFlag = true;
    }

    public String getAccessToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccessToken();
        }
        return this.accesstoken;
    }

    public boolean isAccessTokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccessTokenDirty();
        }
        return this.accesstokenDirtyFlag;
    }

    public void resetAccessToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccessToken();
            return;
        }
        this.accesstokenDirtyFlag = false;
        this.accesstoken = null;
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

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgcodename = string;
        this.pkgcodenameDirtyFlag = true;
    }

    public String getPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGCodeName();
        }
        return this.pkgcodename;
    }

    public boolean isPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGCodeNameDirty();
        }
        return this.pkgcodenameDirtyFlag;
    }

    public void resetPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGCodeName();
            return;
        }
        this.pkgcodenameDirtyFlag = false;
        this.pkgcodename = null;
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

    public void setPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvid = string;
        this.psdevslnsyssrvidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvId();
        }
        return this.psdevslnsyssrvid;
    }

    public boolean isPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvIdDirty();
        }
        return this.psdevslnsyssrvidDirtyFlag;
    }

    public void resetPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvId();
            return;
        }
        this.psdevslnsyssrvidDirtyFlag = false;
        this.psdevslnsyssrvid = null;
    }

    public void setPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvname = string;
        this.psdevslnsyssrvnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvName();
        }
        return this.psdevslnsyssrvname;
    }

    public boolean isPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvNameDirty();
        }
        return this.psdevslnsyssrvnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvName();
            return;
        }
        this.psdevslnsyssrvnameDirtyFlag = false;
        this.psdevslnsyssrvname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSFStyleVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleverid = string;
        this.pssfstyleveridDirtyFlag = true;
    }

    public String getPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerId();
        }
        return this.pssfstyleverid;
    }

    public boolean isPSSFStyleVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerIdDirty();
        }
        return this.pssfstyleveridDirtyFlag;
    }

    public void resetPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerId();
            return;
        }
        this.pssfstyleveridDirtyFlag = false;
        this.pssfstyleverid = null;
    }

    public void setPSSFStyleVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylevername = string;
        this.pssfstylevernameDirtyFlag = true;
    }

    public String getPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerName();
        }
        return this.pssfstylevername;
    }

    public boolean isPSSFStyleVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerNameDirty();
        }
        return this.pssfstylevernameDirtyFlag;
    }

    public void resetPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerName();
            return;
        }
        this.pssfstylevernameDirtyFlag = false;
        this.pssfstylevername = null;
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

    public void setPubTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag = string;
        this.pubtagDirtyFlag = true;
    }

    public String getPubTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag();
        }
        return this.pubtag;
    }

    public boolean isPubTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTagDirty();
        }
        return this.pubtagDirtyFlag;
    }

    public void resetPubTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag();
            return;
        }
        this.pubtagDirtyFlag = false;
        this.pubtag = null;
    }

    public void setPubTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag2 = string;
        this.pubtag2DirtyFlag = true;
    }

    public String getPubTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag2();
        }
        return this.pubtag2;
    }

    public boolean isPubTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag2Dirty();
        }
        return this.pubtag2DirtyFlag;
    }

    public void resetPubTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag2();
            return;
        }
        this.pubtag2DirtyFlag = false;
        this.pubtag2 = null;
    }

    public void setPubTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag3 = string;
        this.pubtag3DirtyFlag = true;
    }

    public String getPubTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag3();
        }
        return this.pubtag3;
    }

    public boolean isPubTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag3Dirty();
        }
        return this.pubtag3DirtyFlag;
    }

    public void resetPubTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag3();
            return;
        }
        this.pubtag3DirtyFlag = false;
        this.pubtag3 = null;
    }

    public void setPubTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag4 = string;
        this.pubtag4DirtyFlag = true;
    }

    public String getPubTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag4();
        }
        return this.pubtag4;
    }

    public boolean isPubTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag4Dirty();
        }
        return this.pubtag4DirtyFlag;
    }

    public void resetPubTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag4();
            return;
        }
        this.pubtag4DirtyFlag = false;
        this.pubtag4 = null;
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

    protected void onReset() {
        PSDevSlnSysSrvBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysSrvBase pSDevSlnSysSrvBase) {
        pSDevSlnSysSrvBase.resetAccessToken();
        pSDevSlnSysSrvBase.resetCodeName();
        pSDevSlnSysSrvBase.resetContentType();
        pSDevSlnSysSrvBase.resetCreateDate();
        pSDevSlnSysSrvBase.resetCreateMan();
        pSDevSlnSysSrvBase.resetEnableLink();
        pSDevSlnSysSrvBase.resetMemo();
        pSDevSlnSysSrvBase.resetPKGCodeName();
        pSDevSlnSysSrvBase.resetPSDevSlnId();
        pSDevSlnSysSrvBase.resetPSDevSlnSysId();
        pSDevSlnSysSrvBase.resetPSDevSlnSysName();
        pSDevSlnSysSrvBase.resetPSDevSlnSysSrvId();
        pSDevSlnSysSrvBase.resetPSDevSlnSysSrvName();
        pSDevSlnSysSrvBase.resetPSSFStyleId();
        pSDevSlnSysSrvBase.resetPSSFStyleName();
        pSDevSlnSysSrvBase.resetPSSFStyleVerId();
        pSDevSlnSysSrvBase.resetPSSFStyleVerName();
        pSDevSlnSysSrvBase.resetPSSysSFPubId();
        pSDevSlnSysSrvBase.resetPSSysSFPubName();
        pSDevSlnSysSrvBase.resetPubTag();
        pSDevSlnSysSrvBase.resetPubTag2();
        pSDevSlnSysSrvBase.resetPubTag3();
        pSDevSlnSysSrvBase.resetPubTag4();
        pSDevSlnSysSrvBase.resetSysCodeName();
        pSDevSlnSysSrvBase.resetUpdateDate();
        pSDevSlnSysSrvBase.resetUpdateMan();
        pSDevSlnSysSrvBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccessTokenDirty()) {
            hashMap.put(FIELD_ACCESSTOKEN, this.getAccessToken());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableLinkDirty()) {
            hashMap.put(FIELD_ENABLELINK, this.getEnableLink());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPKGCodeNameDirty()) {
            hashMap.put(FIELD_PKGCODENAME, this.getPKGCodeName());
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
        if (!bl || this.isPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVID, this.getPSDevSlnSysSrvId());
        }
        if (!bl || this.isPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVNAME, this.getPSDevSlnSysSrvName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStyleVerIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERID, this.getPSSFStyleVerId());
        }
        if (!bl || this.isPSSFStyleVerNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERNAME, this.getPSSFStyleVerName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPubTagDirty()) {
            hashMap.put(FIELD_PUBTAG, this.getPubTag());
        }
        if (!bl || this.isPubTag2Dirty()) {
            hashMap.put(FIELD_PUBTAG2, this.getPubTag2());
        }
        if (!bl || this.isPubTag3Dirty()) {
            hashMap.put(FIELD_PUBTAG3, this.getPubTag3());
        }
        if (!bl || this.isPubTag4Dirty()) {
            hashMap.put(FIELD_PUBTAG4, this.getPubTag4());
        }
        if (!bl || this.isSysCodeNameDirty()) {
            hashMap.put(FIELD_SYSCODENAME, this.getSysCodeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDevSlnSysSrvBase.get(this, n);
    }

    private static Object get(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrvBase.getAccessToken();
            }
            case 1: {
                return pSDevSlnSysSrvBase.getCodeName();
            }
            case 2: {
                return pSDevSlnSysSrvBase.getContentType();
            }
            case 3: {
                return pSDevSlnSysSrvBase.getCreateDate();
            }
            case 4: {
                return pSDevSlnSysSrvBase.getCreateMan();
            }
            case 5: {
                return pSDevSlnSysSrvBase.getEnableLink();
            }
            case 6: {
                return pSDevSlnSysSrvBase.getMemo();
            }
            case 7: {
                return pSDevSlnSysSrvBase.getPKGCodeName();
            }
            case 8: {
                return pSDevSlnSysSrvBase.getPSDevSlnId();
            }
            case 9: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysId();
            }
            case 10: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysName();
            }
            case 11: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysSrvId();
            }
            case 12: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysSrvName();
            }
            case 13: {
                return pSDevSlnSysSrvBase.getPSSFStyleId();
            }
            case 14: {
                return pSDevSlnSysSrvBase.getPSSFStyleName();
            }
            case 15: {
                return pSDevSlnSysSrvBase.getPSSFStyleVerId();
            }
            case 16: {
                return pSDevSlnSysSrvBase.getPSSFStyleVerName();
            }
            case 17: {
                return pSDevSlnSysSrvBase.getPSSysSFPubId();
            }
            case 18: {
                return pSDevSlnSysSrvBase.getPSSysSFPubName();
            }
            case 19: {
                return pSDevSlnSysSrvBase.getPubTag();
            }
            case 20: {
                return pSDevSlnSysSrvBase.getPubTag2();
            }
            case 21: {
                return pSDevSlnSysSrvBase.getPubTag3();
            }
            case 22: {
                return pSDevSlnSysSrvBase.getPubTag4();
            }
            case 23: {
                return pSDevSlnSysSrvBase.getSysCodeName();
            }
            case 24: {
                return pSDevSlnSysSrvBase.getUpdateDate();
            }
            case 25: {
                return pSDevSlnSysSrvBase.getUpdateMan();
            }
            case 26: {
                return pSDevSlnSysSrvBase.getValidFlag();
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
        PSDevSlnSysSrvBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysSrvBase.setAccessToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysSrvBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysSrvBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysSrvBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysSrvBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysSrvBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysSrvBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysSrvBase.setPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysSrvBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysSrvBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysSrvBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysSrvBase.setPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysSrvBase.setPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysSrvBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysSrvBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysSrvBase.setPSSFStyleVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysSrvBase.setPSSFStyleVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysSrvBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysSrvBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysSrvBase.setPubTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysSrvBase.setPubTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysSrvBase.setPubTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysSrvBase.setPubTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysSrvBase.setSysCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysSrvBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysSrvBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysSrvBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysSrvBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrvBase.getAccessToken() == null;
            }
            case 1: {
                return pSDevSlnSysSrvBase.getCodeName() == null;
            }
            case 2: {
                return pSDevSlnSysSrvBase.getContentType() == null;
            }
            case 3: {
                return pSDevSlnSysSrvBase.getCreateDate() == null;
            }
            case 4: {
                return pSDevSlnSysSrvBase.getCreateMan() == null;
            }
            case 5: {
                return pSDevSlnSysSrvBase.getEnableLink() == null;
            }
            case 6: {
                return pSDevSlnSysSrvBase.getMemo() == null;
            }
            case 7: {
                return pSDevSlnSysSrvBase.getPKGCodeName() == null;
            }
            case 8: {
                return pSDevSlnSysSrvBase.getPSDevSlnId() == null;
            }
            case 9: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysId() == null;
            }
            case 10: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysName() == null;
            }
            case 11: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysSrvId() == null;
            }
            case 12: {
                return pSDevSlnSysSrvBase.getPSDevSlnSysSrvName() == null;
            }
            case 13: {
                return pSDevSlnSysSrvBase.getPSSFStyleId() == null;
            }
            case 14: {
                return pSDevSlnSysSrvBase.getPSSFStyleName() == null;
            }
            case 15: {
                return pSDevSlnSysSrvBase.getPSSFStyleVerId() == null;
            }
            case 16: {
                return pSDevSlnSysSrvBase.getPSSFStyleVerName() == null;
            }
            case 17: {
                return pSDevSlnSysSrvBase.getPSSysSFPubId() == null;
            }
            case 18: {
                return pSDevSlnSysSrvBase.getPSSysSFPubName() == null;
            }
            case 19: {
                return pSDevSlnSysSrvBase.getPubTag() == null;
            }
            case 20: {
                return pSDevSlnSysSrvBase.getPubTag2() == null;
            }
            case 21: {
                return pSDevSlnSysSrvBase.getPubTag3() == null;
            }
            case 22: {
                return pSDevSlnSysSrvBase.getPubTag4() == null;
            }
            case 23: {
                return pSDevSlnSysSrvBase.getSysCodeName() == null;
            }
            case 24: {
                return pSDevSlnSysSrvBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDevSlnSysSrvBase.getUpdateMan() == null;
            }
            case 26: {
                return pSDevSlnSysSrvBase.getValidFlag() == null;
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
        return PSDevSlnSysSrvBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrvBase.isAccessTokenDirty();
            }
            case 1: {
                return pSDevSlnSysSrvBase.isCodeNameDirty();
            }
            case 2: {
                return pSDevSlnSysSrvBase.isContentTypeDirty();
            }
            case 3: {
                return pSDevSlnSysSrvBase.isCreateDateDirty();
            }
            case 4: {
                return pSDevSlnSysSrvBase.isCreateManDirty();
            }
            case 5: {
                return pSDevSlnSysSrvBase.isEnableLinkDirty();
            }
            case 6: {
                return pSDevSlnSysSrvBase.isMemoDirty();
            }
            case 7: {
                return pSDevSlnSysSrvBase.isPKGCodeNameDirty();
            }
            case 8: {
                return pSDevSlnSysSrvBase.isPSDevSlnIdDirty();
            }
            case 9: {
                return pSDevSlnSysSrvBase.isPSDevSlnSysIdDirty();
            }
            case 10: {
                return pSDevSlnSysSrvBase.isPSDevSlnSysNameDirty();
            }
            case 11: {
                return pSDevSlnSysSrvBase.isPSDevSlnSysSrvIdDirty();
            }
            case 12: {
                return pSDevSlnSysSrvBase.isPSDevSlnSysSrvNameDirty();
            }
            case 13: {
                return pSDevSlnSysSrvBase.isPSSFStyleIdDirty();
            }
            case 14: {
                return pSDevSlnSysSrvBase.isPSSFStyleNameDirty();
            }
            case 15: {
                return pSDevSlnSysSrvBase.isPSSFStyleVerIdDirty();
            }
            case 16: {
                return pSDevSlnSysSrvBase.isPSSFStyleVerNameDirty();
            }
            case 17: {
                return pSDevSlnSysSrvBase.isPSSysSFPubIdDirty();
            }
            case 18: {
                return pSDevSlnSysSrvBase.isPSSysSFPubNameDirty();
            }
            case 19: {
                return pSDevSlnSysSrvBase.isPubTagDirty();
            }
            case 20: {
                return pSDevSlnSysSrvBase.isPubTag2Dirty();
            }
            case 21: {
                return pSDevSlnSysSrvBase.isPubTag3Dirty();
            }
            case 22: {
                return pSDevSlnSysSrvBase.isPubTag4Dirty();
            }
            case 23: {
                return pSDevSlnSysSrvBase.isSysCodeNameDirty();
            }
            case 24: {
                return pSDevSlnSysSrvBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDevSlnSysSrvBase.isUpdateManDirty();
            }
            case 26: {
                return pSDevSlnSysSrvBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysSrvBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysSrvBase.getAccessToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accesstoken", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getAccessToken()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getContentType()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgcodename", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPKGCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvname", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleverid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSFStyleVerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylevername", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSFStyleVerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPubTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag2", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPubTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag3", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPubTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag4", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getPubTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getSysCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syscodename", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getSysCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrvBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysSrvBase.getJSONValue((Object)pSDevSlnSysSrvBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysSrvBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysSrvBase.getAccessToken() != null) {
            object = pSDevSlnSysSrvBase.getAccessToken();
            xmlNode.setAttribute(FIELD_ACCESSTOKEN, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysSrvBase.getCodeName() != null) {
            object = pSDevSlnSysSrvBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysSrvBase.getContentType() != null) {
            object = pSDevSlnSysSrvBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getCreateDate() != null) {
            object = pSDevSlnSysSrvBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysSrvBase.getCreateMan() != null) {
            object = pSDevSlnSysSrvBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getEnableLink() != null) {
            object = pSDevSlnSysSrvBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysSrvBase.getMemo() != null) {
            object = pSDevSlnSysSrvBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPKGCodeName() != null) {
            object = pSDevSlnSysSrvBase.getPKGCodeName();
            xmlNode.setAttribute(FIELD_PKGCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysSrvBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysSrvBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysSrvBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvId() != null) {
            object = pSDevSlnSysSrvBase.getPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvName() != null) {
            object = pSDevSlnSysSrvBase.getPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleId() != null) {
            object = pSDevSlnSysSrvBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleName() != null) {
            object = pSDevSlnSysSrvBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleVerId() != null) {
            object = pSDevSlnSysSrvBase.getPSSFStyleVerId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSFStyleVerName() != null) {
            object = pSDevSlnSysSrvBase.getPSSFStyleVerName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSysSFPubId() != null) {
            object = pSDevSlnSysSrvBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPSSysSFPubName() != null) {
            object = pSDevSlnSysSrvBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag() != null) {
            object = pSDevSlnSysSrvBase.getPubTag();
            xmlNode.setAttribute(FIELD_PUBTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag2() != null) {
            object = pSDevSlnSysSrvBase.getPubTag2();
            xmlNode.setAttribute(FIELD_PUBTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag3() != null) {
            object = pSDevSlnSysSrvBase.getPubTag3();
            xmlNode.setAttribute(FIELD_PUBTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getPubTag4() != null) {
            object = pSDevSlnSysSrvBase.getPubTag4();
            xmlNode.setAttribute(FIELD_PUBTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getSysCodeName() != null) {
            object = pSDevSlnSysSrvBase.getSysCodeName();
            xmlNode.setAttribute(FIELD_SYSCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getUpdateDate() != null) {
            object = pSDevSlnSysSrvBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysSrvBase.getUpdateMan() != null) {
            object = pSDevSlnSysSrvBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrvBase.getValidFlag() != null) {
            object = pSDevSlnSysSrvBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysSrvBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysSrvBase.isAccessTokenDirty() && (bl || pSDevSlnSysSrvBase.getAccessToken() != null)) {
            iDataObject.set(FIELD_ACCESSTOKEN, (Object)pSDevSlnSysSrvBase.getAccessToken());
        }
        if (pSDevSlnSysSrvBase.isCodeNameDirty() && (bl || pSDevSlnSysSrvBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnSysSrvBase.getCodeName());
        }
        if (pSDevSlnSysSrvBase.isContentTypeDirty() && (bl || pSDevSlnSysSrvBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDevSlnSysSrvBase.getContentType());
        }
        if (pSDevSlnSysSrvBase.isCreateDateDirty() && (bl || pSDevSlnSysSrvBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysSrvBase.getCreateDate());
        }
        if (pSDevSlnSysSrvBase.isCreateManDirty() && (bl || pSDevSlnSysSrvBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysSrvBase.getCreateMan());
        }
        if (pSDevSlnSysSrvBase.isEnableLinkDirty() && (bl || pSDevSlnSysSrvBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDevSlnSysSrvBase.getEnableLink());
        }
        if (pSDevSlnSysSrvBase.isMemoDirty() && (bl || pSDevSlnSysSrvBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysSrvBase.getMemo());
        }
        if (pSDevSlnSysSrvBase.isPKGCodeNameDirty() && (bl || pSDevSlnSysSrvBase.getPKGCodeName() != null)) {
            iDataObject.set(FIELD_PKGCODENAME, (Object)pSDevSlnSysSrvBase.getPKGCodeName());
        }
        if (pSDevSlnSysSrvBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysSrvBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysSrvBase.getPSDevSlnId());
        }
        if (pSDevSlnSysSrvBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysSrvBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysSrvBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysSrvBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysSrvBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysSrvBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysSrvBase.isPSDevSlnSysSrvIdDirty() && (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVID, (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId());
        }
        if (pSDevSlnSysSrvBase.isPSDevSlnSysSrvNameDirty() && (bl || pSDevSlnSysSrvBase.getPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVNAME, (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvName());
        }
        if (pSDevSlnSysSrvBase.isPSSFStyleIdDirty() && (bl || pSDevSlnSysSrvBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSDevSlnSysSrvBase.getPSSFStyleId());
        }
        if (pSDevSlnSysSrvBase.isPSSFStyleNameDirty() && (bl || pSDevSlnSysSrvBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSDevSlnSysSrvBase.getPSSFStyleName());
        }
        if (pSDevSlnSysSrvBase.isPSSFStyleVerIdDirty() && (bl || pSDevSlnSysSrvBase.getPSSFStyleVerId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERID, (Object)pSDevSlnSysSrvBase.getPSSFStyleVerId());
        }
        if (pSDevSlnSysSrvBase.isPSSFStyleVerNameDirty() && (bl || pSDevSlnSysSrvBase.getPSSFStyleVerName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERNAME, (Object)pSDevSlnSysSrvBase.getPSSFStyleVerName());
        }
        if (pSDevSlnSysSrvBase.isPSSysSFPubIdDirty() && (bl || pSDevSlnSysSrvBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSDevSlnSysSrvBase.getPSSysSFPubId());
        }
        if (pSDevSlnSysSrvBase.isPSSysSFPubNameDirty() && (bl || pSDevSlnSysSrvBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSDevSlnSysSrvBase.getPSSysSFPubName());
        }
        if (pSDevSlnSysSrvBase.isPubTagDirty() && (bl || pSDevSlnSysSrvBase.getPubTag() != null)) {
            iDataObject.set(FIELD_PUBTAG, (Object)pSDevSlnSysSrvBase.getPubTag());
        }
        if (pSDevSlnSysSrvBase.isPubTag2Dirty() && (bl || pSDevSlnSysSrvBase.getPubTag2() != null)) {
            iDataObject.set(FIELD_PUBTAG2, (Object)pSDevSlnSysSrvBase.getPubTag2());
        }
        if (pSDevSlnSysSrvBase.isPubTag3Dirty() && (bl || pSDevSlnSysSrvBase.getPubTag3() != null)) {
            iDataObject.set(FIELD_PUBTAG3, (Object)pSDevSlnSysSrvBase.getPubTag3());
        }
        if (pSDevSlnSysSrvBase.isPubTag4Dirty() && (bl || pSDevSlnSysSrvBase.getPubTag4() != null)) {
            iDataObject.set(FIELD_PUBTAG4, (Object)pSDevSlnSysSrvBase.getPubTag4());
        }
        if (pSDevSlnSysSrvBase.isSysCodeNameDirty() && (bl || pSDevSlnSysSrvBase.getSysCodeName() != null)) {
            iDataObject.set(FIELD_SYSCODENAME, (Object)pSDevSlnSysSrvBase.getSysCodeName());
        }
        if (pSDevSlnSysSrvBase.isUpdateDateDirty() && (bl || pSDevSlnSysSrvBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysSrvBase.getUpdateDate());
        }
        if (pSDevSlnSysSrvBase.isUpdateManDirty() && (bl || pSDevSlnSysSrvBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysSrvBase.getUpdateMan());
        }
        if (pSDevSlnSysSrvBase.isValidFlagDirty() && (bl || pSDevSlnSysSrvBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysSrvBase.getValidFlag());
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
        return PSDevSlnSysSrvBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysSrvBase.resetAccessToken();
                return true;
            }
            case 1: {
                pSDevSlnSysSrvBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDevSlnSysSrvBase.resetContentType();
                return true;
            }
            case 3: {
                pSDevSlnSysSrvBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDevSlnSysSrvBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDevSlnSysSrvBase.resetEnableLink();
                return true;
            }
            case 6: {
                pSDevSlnSysSrvBase.resetMemo();
                return true;
            }
            case 7: {
                pSDevSlnSysSrvBase.resetPKGCodeName();
                return true;
            }
            case 8: {
                pSDevSlnSysSrvBase.resetPSDevSlnId();
                return true;
            }
            case 9: {
                pSDevSlnSysSrvBase.resetPSDevSlnSysId();
                return true;
            }
            case 10: {
                pSDevSlnSysSrvBase.resetPSDevSlnSysName();
                return true;
            }
            case 11: {
                pSDevSlnSysSrvBase.resetPSDevSlnSysSrvId();
                return true;
            }
            case 12: {
                pSDevSlnSysSrvBase.resetPSDevSlnSysSrvName();
                return true;
            }
            case 13: {
                pSDevSlnSysSrvBase.resetPSSFStyleId();
                return true;
            }
            case 14: {
                pSDevSlnSysSrvBase.resetPSSFStyleName();
                return true;
            }
            case 15: {
                pSDevSlnSysSrvBase.resetPSSFStyleVerId();
                return true;
            }
            case 16: {
                pSDevSlnSysSrvBase.resetPSSFStyleVerName();
                return true;
            }
            case 17: {
                pSDevSlnSysSrvBase.resetPSSysSFPubId();
                return true;
            }
            case 18: {
                pSDevSlnSysSrvBase.resetPSSysSFPubName();
                return true;
            }
            case 19: {
                pSDevSlnSysSrvBase.resetPubTag();
                return true;
            }
            case 20: {
                pSDevSlnSysSrvBase.resetPubTag2();
                return true;
            }
            case 21: {
                pSDevSlnSysSrvBase.resetPubTag3();
                return true;
            }
            case 22: {
                pSDevSlnSysSrvBase.resetPubTag4();
                return true;
            }
            case 23: {
                pSDevSlnSysSrvBase.resetSysCodeName();
                return true;
            }
            case 24: {
                pSDevSlnSysSrvBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDevSlnSysSrvBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSDevSlnSysSrvBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSFStyleVer getPSSFStyleVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVer();
        }
        if (this.getPSSFStyleVerId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleVerLock;
        synchronized (n) {
            if (this.pssfstylever != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleVerId(), (Object)this.pssfstylever.getPSSFStyleVerId()) != 0L) {
                this.pssfstylever = null;
            }
            if (this.pssfstylever == null) {
                PSSFStyleVer pSSFStyleVer = new PSSFStyleVer();
                pSSFStyleVer.setPSSFStyleVerId(this.getPSSFStyleVerId());
                PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleVerService.autoGet((IEntity)pSSFStyleVer);
                this.pssfstylever = pSSFStyleVer;
            }
            return this.pssfstylever;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnPipelineStep> getPSDevSlnPipelineSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineSteps();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelineStepsLock;
        synchronized (n) {
            if (this.psdevslnpipelinesteps == null) {
                this.psdevslnpipelinesteps = pSDevSlnPipelineStepService.selectByPSDevSlnSysSrv(this);
            }
            return this.psdevslnpipelinesteps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysRefLink> getPSDevSlnSysRefLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefLinks();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        PSDevSlnSysRefLinkService pSDevSlnSysRefLinkService = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysRefLinksLock;
        synchronized (n) {
            if (this.psdevslnsysreflinks == null) {
                this.psdevslnsysreflinks = pSDevSlnSysRefLinkService.selectByPSDevSlnSysSrv(this);
            }
            return this.psdevslnsysreflinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysRef> getPSDevSlnSysRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefs();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysRefsLock;
        synchronized (n) {
            if (this.psdevslnsysrefs == null) {
                this.psdevslnsysrefs = pSDevSlnSysRefService.selectByRefPSDevSlnSysSrv(this);
            }
            return this.psdevslnsysrefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnTempl> getPSDevSlnTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempls();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnTemplsLock;
        synchronized (n) {
            if (this.psdevslntempls == null) {
                this.psdevslntempls = pSDevSlnTemplService.selectByPSDevSlnSysSrv(this);
            }
            return this.psdevslntempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysRef> getPSSysRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefs();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        PSSysRefService pSSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysRefsLock;
        synchronized (n) {
            if (this.pssysrefs == null) {
                this.pssysrefs = pSSysRefService.selectByPSDevSlnSysSrv(this);
            }
            return this.pssysrefs;
        }
    }

    private PSDevSlnSysSrvBase getProxyEntity() {
        return this.proxyPSDevSlnSysSrvBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysSrvBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysSrvBase) {
            this.proxyPSDevSlnSysSrvBase = (PSDevSlnSysSrvBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSTOKEN, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENABLELINK, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PKGCODENAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVNAME, 12);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 13);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 14);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERID, 15);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 17);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 18);
        fieldIndexMap.put(FIELD_PUBTAG, 19);
        fieldIndexMap.put(FIELD_PUBTAG2, 20);
        fieldIndexMap.put(FIELD_PUBTAG3, 21);
        fieldIndexMap.put(FIELD_PUBTAG4, 22);
        fieldIndexMap.put(FIELD_SYSCODENAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

