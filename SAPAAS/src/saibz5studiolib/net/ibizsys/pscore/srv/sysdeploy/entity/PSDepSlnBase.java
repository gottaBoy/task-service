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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBDInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnFile;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPack;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnParam;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnUser;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnBase.class);
    public static final String FIELD_ADMINPSDEVUSERID = "ADMINPSDEVUSERID";
    public static final String FIELD_ADMINPSDEVUSERNAME = "ADMINPSDEVUSERNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOMAINNAME = "DOMAINNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_SLNMDURL = "SLNMDURL";
    public static final String FIELD_SLNSN = "SLNSN";
    public static final String FIELD_SLNTAG = "SLNTAG";
    public static final String FIELD_SLNTAG2 = "SLNTAG2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ADMINPSDEVUSERID = 0;
    private static final int INDEX_ADMINPSDEVUSERNAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DOMAINNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDCCLUSTERID = 7;
    private static final int INDEX_PSDCCLUSTERNAME = 8;
    private static final int INDEX_PSDCMSPLATFORMID = 9;
    private static final int INDEX_PSDCMSPLATFORMNAME = 10;
    private static final int INDEX_PSDEPSLNID = 11;
    private static final int INDEX_PSDEPSLNNAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_SLNMDURL = 15;
    private static final int INDEX_SLNSN = 16;
    private static final int INDEX_SLNTAG = 17;
    private static final int INDEX_SLNTAG2 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnBase proxyPSDepSlnBase = null;
    private boolean adminpsdevuseridDirtyFlag = false;
    private boolean adminpsdevusernameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean domainnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean slnmdurlDirtyFlag = false;
    private boolean slnsnDirtyFlag = false;
    private boolean slntagDirtyFlag = false;
    private boolean slntag2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="adminpsdevuserid")
    private String adminpsdevuserid;
    @Column(name="adminpsdevusername")
    private String adminpsdevusername;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="domainname")
    private String domainname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="slnmdurl")
    private String slnmdurl;
    @Column(name="slnsn")
    private String slnsn;
    @Column(name="slntag")
    private String slntag;
    @Column(name="slntag2")
    private String slntag2;
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
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private PSDCMSPlatform psdcmsplatform = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objAdminPSDevUserLock = new Integer(1);
    private PSDevUser adminpsdevuser = null;
    private Integer objPSDepSlnDBInstsLock = new Integer(1);
    private ArrayList<PSDepSlnBDInst> psdepslndbinsts = null;
    private Integer objPSDepSlnFilesLock = new Integer(1);
    private ArrayList<PSDepSlnFile> psdepslnfiles = null;
    private Integer objPSDepSlnPacksLock = new Integer(1);
    private ArrayList<PSDepSlnPack> psdepslnpacks = null;
    private Integer objPSDepSlnParamsLock = new Integer(1);
    private ArrayList<PSDepSlnParam> psdepslnparams = null;
    private Integer objPSDepSlnsLock = new Integer(1);
    private ArrayList<PSDepSlnPrd> psdepslns = null;
    private Integer objPSDepSlnUsersLock = new Integer(1);
    private ArrayList<PSDepSlnUser> psdepslnusers = null;

    public void setAdminPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpsdevuserid = string;
        this.adminpsdevuseridDirtyFlag = true;
    }

    public String getAdminPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUserId();
        }
        return this.adminpsdevuserid;
    }

    public boolean isAdminPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPSDevUserIdDirty();
        }
        return this.adminpsdevuseridDirtyFlag;
    }

    public void resetAdminPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPSDevUserId();
            return;
        }
        this.adminpsdevuseridDirtyFlag = false;
        this.adminpsdevuserid = null;
    }

    public void setAdminPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpsdevusername = string;
        this.adminpsdevusernameDirtyFlag = true;
    }

    public String getAdminPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUserName();
        }
        return this.adminpsdevusername;
    }

    public boolean isAdminPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPSDevUserNameDirty();
        }
        return this.adminpsdevusernameDirtyFlag;
    }

    public void resetAdminPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPSDevUserName();
            return;
        }
        this.adminpsdevusernameDirtyFlag = false;
        this.adminpsdevusername = null;
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

    public void setDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainname = string;
        this.domainnameDirtyFlag = true;
    }

    public String getDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainName();
        }
        return this.domainname;
    }

    public boolean isDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainNameDirty();
        }
        return this.domainnameDirtyFlag;
    }

    public void resetDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainName();
            return;
        }
        this.domainnameDirtyFlag = false;
        this.domainname = null;
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

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
    }

    public void setPSDCMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformid = string;
        this.psdcmsplatformidDirtyFlag = true;
    }

    public String getPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformId();
        }
        return this.psdcmsplatformid;
    }

    public boolean isPSDCMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformIdDirty();
        }
        return this.psdcmsplatformidDirtyFlag;
    }

    public void resetPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformId();
            return;
        }
        this.psdcmsplatformidDirtyFlag = false;
        this.psdcmsplatformid = null;
    }

    public void setPSDCMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformname = string;
        this.psdcmsplatformnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformName();
        }
        return this.psdcmsplatformname;
    }

    public boolean isPSDCMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNameDirty();
        }
        return this.psdcmsplatformnameDirtyFlag;
    }

    public void resetPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformName();
            return;
        }
        this.psdcmsplatformnameDirtyFlag = false;
        this.psdcmsplatformname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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

    public void setSlnMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slnmdurl = string;
        this.slnmdurlDirtyFlag = true;
    }

    public String getSlnMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnMDUrl();
        }
        return this.slnmdurl;
    }

    public boolean isSlnMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnMDUrlDirty();
        }
        return this.slnmdurlDirtyFlag;
    }

    public void resetSlnMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnMDUrl();
            return;
        }
        this.slnmdurlDirtyFlag = false;
        this.slnmdurl = null;
    }

    public void setSLNSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSLNSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slnsn = string;
        this.slnsnDirtyFlag = true;
    }

    public String getSLNSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSLNSN();
        }
        return this.slnsn;
    }

    public boolean isSLNSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSLNSNDirty();
        }
        return this.slnsnDirtyFlag;
    }

    public void resetSLNSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSLNSN();
            return;
        }
        this.slnsnDirtyFlag = false;
        this.slnsn = null;
    }

    public void setSlnTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slntag = string;
        this.slntagDirtyFlag = true;
    }

    public String getSlnTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnTag();
        }
        return this.slntag;
    }

    public boolean isSlnTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnTagDirty();
        }
        return this.slntagDirtyFlag;
    }

    public void resetSlnTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnTag();
            return;
        }
        this.slntagDirtyFlag = false;
        this.slntag = null;
    }

    public void setSlnTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slntag2 = string;
        this.slntag2DirtyFlag = true;
    }

    public String getSlnTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnTag2();
        }
        return this.slntag2;
    }

    public boolean isSlnTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnTag2Dirty();
        }
        return this.slntag2DirtyFlag;
    }

    public void resetSlnTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnTag2();
            return;
        }
        this.slntag2DirtyFlag = false;
        this.slntag2 = null;
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

    protected void onReset() {
        PSDepSlnBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnBase pSDepSlnBase) {
        pSDepSlnBase.resetAdminPSDevUserId();
        pSDepSlnBase.resetAdminPSDevUserName();
        pSDepSlnBase.resetCodeName();
        pSDepSlnBase.resetCreateDate();
        pSDepSlnBase.resetCreateMan();
        pSDepSlnBase.resetDomainName();
        pSDepSlnBase.resetMemo();
        pSDepSlnBase.resetPSDCClusterId();
        pSDepSlnBase.resetPSDCClusterName();
        pSDepSlnBase.resetPSDCMSPlatformId();
        pSDepSlnBase.resetPSDCMSPlatformName();
        pSDepSlnBase.resetPSDepSlnId();
        pSDepSlnBase.resetPSDepSlnName();
        pSDepSlnBase.resetPSDevCenterId();
        pSDepSlnBase.resetPSDevCenterName();
        pSDepSlnBase.resetSlnMDUrl();
        pSDepSlnBase.resetSLNSN();
        pSDepSlnBase.resetSlnTag();
        pSDepSlnBase.resetSlnTag2();
        pSDepSlnBase.resetUpdateDate();
        pSDepSlnBase.resetUpdateMan();
        pSDepSlnBase.resetUserCat();
        pSDepSlnBase.resetUserTag();
        pSDepSlnBase.resetUserTag2();
        pSDepSlnBase.resetUserTag3();
        pSDepSlnBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPSDevUserIdDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERID, this.getAdminPSDevUserId());
        }
        if (!bl || this.isAdminPSDevUserNameDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERNAME, this.getAdminPSDevUserName());
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
        if (!bl || this.isDomainNameDirty()) {
            hashMap.put(FIELD_DOMAINNAME, this.getDomainName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isSlnMDUrlDirty()) {
            hashMap.put(FIELD_SLNMDURL, this.getSlnMDUrl());
        }
        if (!bl || this.isSLNSNDirty()) {
            hashMap.put(FIELD_SLNSN, this.getSLNSN());
        }
        if (!bl || this.isSlnTagDirty()) {
            hashMap.put(FIELD_SLNTAG, this.getSlnTag());
        }
        if (!bl || this.isSlnTag2Dirty()) {
            hashMap.put(FIELD_SLNTAG2, this.getSlnTag2());
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
        return PSDepSlnBase.get(this, n);
    }

    private static Object get(PSDepSlnBase pSDepSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBase.getAdminPSDevUserId();
            }
            case 1: {
                return pSDepSlnBase.getAdminPSDevUserName();
            }
            case 2: {
                return pSDepSlnBase.getCodeName();
            }
            case 3: {
                return pSDepSlnBase.getCreateDate();
            }
            case 4: {
                return pSDepSlnBase.getCreateMan();
            }
            case 5: {
                return pSDepSlnBase.getDomainName();
            }
            case 6: {
                return pSDepSlnBase.getMemo();
            }
            case 7: {
                return pSDepSlnBase.getPSDCClusterId();
            }
            case 8: {
                return pSDepSlnBase.getPSDCClusterName();
            }
            case 9: {
                return pSDepSlnBase.getPSDCMSPlatformId();
            }
            case 10: {
                return pSDepSlnBase.getPSDCMSPlatformName();
            }
            case 11: {
                return pSDepSlnBase.getPSDepSlnId();
            }
            case 12: {
                return pSDepSlnBase.getPSDepSlnName();
            }
            case 13: {
                return pSDepSlnBase.getPSDevCenterId();
            }
            case 14: {
                return pSDepSlnBase.getPSDevCenterName();
            }
            case 15: {
                return pSDepSlnBase.getSlnMDUrl();
            }
            case 16: {
                return pSDepSlnBase.getSLNSN();
            }
            case 17: {
                return pSDepSlnBase.getSlnTag();
            }
            case 18: {
                return pSDepSlnBase.getSlnTag2();
            }
            case 19: {
                return pSDepSlnBase.getUpdateDate();
            }
            case 20: {
                return pSDepSlnBase.getUpdateMan();
            }
            case 21: {
                return pSDepSlnBase.getUserCat();
            }
            case 22: {
                return pSDepSlnBase.getUserTag();
            }
            case 23: {
                return pSDepSlnBase.getUserTag2();
            }
            case 24: {
                return pSDepSlnBase.getUserTag3();
            }
            case 25: {
                return pSDepSlnBase.getUserTag4();
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
        PSDepSlnBase.set(this, n, object);
    }

    private static void set(PSDepSlnBase pSDepSlnBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnBase.setAdminPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnBase.setAdminPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnBase.setDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnBase.setSlnMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnBase.setSLNSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnBase.setSlnTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnBase.setSlnTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSlnBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDepSlnBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDepSlnBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDepSlnBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDepSlnBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDepSlnBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDepSlnBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDepSlnBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnBase pSDepSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBase.getAdminPSDevUserId() == null;
            }
            case 1: {
                return pSDepSlnBase.getAdminPSDevUserName() == null;
            }
            case 2: {
                return pSDepSlnBase.getCodeName() == null;
            }
            case 3: {
                return pSDepSlnBase.getCreateDate() == null;
            }
            case 4: {
                return pSDepSlnBase.getCreateMan() == null;
            }
            case 5: {
                return pSDepSlnBase.getDomainName() == null;
            }
            case 6: {
                return pSDepSlnBase.getMemo() == null;
            }
            case 7: {
                return pSDepSlnBase.getPSDCClusterId() == null;
            }
            case 8: {
                return pSDepSlnBase.getPSDCClusterName() == null;
            }
            case 9: {
                return pSDepSlnBase.getPSDCMSPlatformId() == null;
            }
            case 10: {
                return pSDepSlnBase.getPSDCMSPlatformName() == null;
            }
            case 11: {
                return pSDepSlnBase.getPSDepSlnId() == null;
            }
            case 12: {
                return pSDepSlnBase.getPSDepSlnName() == null;
            }
            case 13: {
                return pSDepSlnBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDepSlnBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDepSlnBase.getSlnMDUrl() == null;
            }
            case 16: {
                return pSDepSlnBase.getSLNSN() == null;
            }
            case 17: {
                return pSDepSlnBase.getSlnTag() == null;
            }
            case 18: {
                return pSDepSlnBase.getSlnTag2() == null;
            }
            case 19: {
                return pSDepSlnBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDepSlnBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDepSlnBase.getUserCat() == null;
            }
            case 22: {
                return pSDepSlnBase.getUserTag() == null;
            }
            case 23: {
                return pSDepSlnBase.getUserTag2() == null;
            }
            case 24: {
                return pSDepSlnBase.getUserTag3() == null;
            }
            case 25: {
                return pSDepSlnBase.getUserTag4() == null;
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
        return PSDepSlnBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnBase pSDepSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBase.isAdminPSDevUserIdDirty();
            }
            case 1: {
                return pSDepSlnBase.isAdminPSDevUserNameDirty();
            }
            case 2: {
                return pSDepSlnBase.isCodeNameDirty();
            }
            case 3: {
                return pSDepSlnBase.isCreateDateDirty();
            }
            case 4: {
                return pSDepSlnBase.isCreateManDirty();
            }
            case 5: {
                return pSDepSlnBase.isDomainNameDirty();
            }
            case 6: {
                return pSDepSlnBase.isMemoDirty();
            }
            case 7: {
                return pSDepSlnBase.isPSDCClusterIdDirty();
            }
            case 8: {
                return pSDepSlnBase.isPSDCClusterNameDirty();
            }
            case 9: {
                return pSDepSlnBase.isPSDCMSPlatformIdDirty();
            }
            case 10: {
                return pSDepSlnBase.isPSDCMSPlatformNameDirty();
            }
            case 11: {
                return pSDepSlnBase.isPSDepSlnIdDirty();
            }
            case 12: {
                return pSDepSlnBase.isPSDepSlnNameDirty();
            }
            case 13: {
                return pSDepSlnBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDepSlnBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDepSlnBase.isSlnMDUrlDirty();
            }
            case 16: {
                return pSDepSlnBase.isSLNSNDirty();
            }
            case 17: {
                return pSDepSlnBase.isSlnTagDirty();
            }
            case 18: {
                return pSDepSlnBase.isSlnTag2Dirty();
            }
            case 19: {
                return pSDepSlnBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDepSlnBase.isUpdateManDirty();
            }
            case 21: {
                return pSDepSlnBase.isUserCatDirty();
            }
            case 22: {
                return pSDepSlnBase.isUserTagDirty();
            }
            case 23: {
                return pSDepSlnBase.isUserTag2Dirty();
            }
            case 24: {
                return pSDepSlnBase.isUserTag3Dirty();
            }
            case 25: {
                return pSDepSlnBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnBase pSDepSlnBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnBase.getAdminPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevuserid", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getAdminPSDevUserId()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getAdminPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevusername", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getAdminPSDevUserName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainname", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getDomainName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getSlnMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnmdurl", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getSlnMDUrl()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getSLNSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnsn", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getSLNSN()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getSlnTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slntag", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getSlnTag()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getSlnTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slntag2", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getSlnTag2()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDepSlnBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDepSlnBase.getJSONValue((Object)pSDepSlnBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnBase pSDepSlnBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnBase.getAdminPSDevUserId() != null) {
            object = pSDepSlnBase.getAdminPSDevUserId();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERID, (String)(object == null ? "" : object));
        }
        if (bl || pSDepSlnBase.getAdminPSDevUserName() != null) {
            object = pSDepSlnBase.getAdminPSDevUserName();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDepSlnBase.getCodeName() != null) {
            object = pSDepSlnBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getCreateDate() != null) {
            object = pSDepSlnBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnBase.getCreateMan() != null) {
            object = pSDepSlnBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getDomainName() != null) {
            object = pSDepSlnBase.getDomainName();
            xmlNode.setAttribute(FIELD_DOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getMemo() != null) {
            object = pSDepSlnBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDCClusterId() != null) {
            object = pSDepSlnBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDCClusterName() != null) {
            object = pSDepSlnBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDCMSPlatformId() != null) {
            object = pSDepSlnBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDCMSPlatformName() != null) {
            object = pSDepSlnBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDepSlnId() != null) {
            object = pSDepSlnBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDepSlnName() != null) {
            object = pSDepSlnBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDevCenterId() != null) {
            object = pSDepSlnBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getPSDevCenterName() != null) {
            object = pSDepSlnBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getSlnMDUrl() != null) {
            object = pSDepSlnBase.getSlnMDUrl();
            xmlNode.setAttribute(FIELD_SLNMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getSLNSN() != null) {
            object = pSDepSlnBase.getSLNSN();
            xmlNode.setAttribute(FIELD_SLNSN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getSlnTag() != null) {
            object = pSDepSlnBase.getSlnTag();
            xmlNode.setAttribute(FIELD_SLNTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getSlnTag2() != null) {
            object = pSDepSlnBase.getSlnTag2();
            xmlNode.setAttribute(FIELD_SLNTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUpdateDate() != null) {
            object = pSDepSlnBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnBase.getUpdateMan() != null) {
            object = pSDepSlnBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUserCat() != null) {
            object = pSDepSlnBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUserTag() != null) {
            object = pSDepSlnBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUserTag2() != null) {
            object = pSDepSlnBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUserTag3() != null) {
            object = pSDepSlnBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBase.getUserTag4() != null) {
            object = pSDepSlnBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnBase pSDepSlnBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnBase.isAdminPSDevUserIdDirty() && (bl || pSDepSlnBase.getAdminPSDevUserId() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERID, (Object)pSDepSlnBase.getAdminPSDevUserId());
        }
        if (pSDepSlnBase.isAdminPSDevUserNameDirty() && (bl || pSDepSlnBase.getAdminPSDevUserName() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERNAME, (Object)pSDepSlnBase.getAdminPSDevUserName());
        }
        if (pSDepSlnBase.isCodeNameDirty() && (bl || pSDepSlnBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDepSlnBase.getCodeName());
        }
        if (pSDepSlnBase.isCreateDateDirty() && (bl || pSDepSlnBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnBase.getCreateDate());
        }
        if (pSDepSlnBase.isCreateManDirty() && (bl || pSDepSlnBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnBase.getCreateMan());
        }
        if (pSDepSlnBase.isDomainNameDirty() && (bl || pSDepSlnBase.getDomainName() != null)) {
            iDataObject.set(FIELD_DOMAINNAME, (Object)pSDepSlnBase.getDomainName());
        }
        if (pSDepSlnBase.isMemoDirty() && (bl || pSDepSlnBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnBase.getMemo());
        }
        if (pSDepSlnBase.isPSDCClusterIdDirty() && (bl || pSDepSlnBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDepSlnBase.getPSDCClusterId());
        }
        if (pSDepSlnBase.isPSDCClusterNameDirty() && (bl || pSDepSlnBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDepSlnBase.getPSDCClusterName());
        }
        if (pSDepSlnBase.isPSDCMSPlatformIdDirty() && (bl || pSDepSlnBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDepSlnBase.getPSDCMSPlatformId());
        }
        if (pSDepSlnBase.isPSDCMSPlatformNameDirty() && (bl || pSDepSlnBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDepSlnBase.getPSDCMSPlatformName());
        }
        if (pSDepSlnBase.isPSDepSlnIdDirty() && (bl || pSDepSlnBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnBase.getPSDepSlnId());
        }
        if (pSDepSlnBase.isPSDepSlnNameDirty() && (bl || pSDepSlnBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnBase.getPSDepSlnName());
        }
        if (pSDepSlnBase.isPSDevCenterIdDirty() && (bl || pSDepSlnBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDepSlnBase.getPSDevCenterId());
        }
        if (pSDepSlnBase.isPSDevCenterNameDirty() && (bl || pSDepSlnBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDepSlnBase.getPSDevCenterName());
        }
        if (pSDepSlnBase.isSlnMDUrlDirty() && (bl || pSDepSlnBase.getSlnMDUrl() != null)) {
            iDataObject.set(FIELD_SLNMDURL, (Object)pSDepSlnBase.getSlnMDUrl());
        }
        if (pSDepSlnBase.isSLNSNDirty() && (bl || pSDepSlnBase.getSLNSN() != null)) {
            iDataObject.set(FIELD_SLNSN, (Object)pSDepSlnBase.getSLNSN());
        }
        if (pSDepSlnBase.isSlnTagDirty() && (bl || pSDepSlnBase.getSlnTag() != null)) {
            iDataObject.set(FIELD_SLNTAG, (Object)pSDepSlnBase.getSlnTag());
        }
        if (pSDepSlnBase.isSlnTag2Dirty() && (bl || pSDepSlnBase.getSlnTag2() != null)) {
            iDataObject.set(FIELD_SLNTAG2, (Object)pSDepSlnBase.getSlnTag2());
        }
        if (pSDepSlnBase.isUpdateDateDirty() && (bl || pSDepSlnBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnBase.getUpdateDate());
        }
        if (pSDepSlnBase.isUpdateManDirty() && (bl || pSDepSlnBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnBase.getUpdateMan());
        }
        if (pSDepSlnBase.isUserCatDirty() && (bl || pSDepSlnBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDepSlnBase.getUserCat());
        }
        if (pSDepSlnBase.isUserTagDirty() && (bl || pSDepSlnBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSlnBase.getUserTag());
        }
        if (pSDepSlnBase.isUserTag2Dirty() && (bl || pSDepSlnBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSlnBase.getUserTag2());
        }
        if (pSDepSlnBase.isUserTag3Dirty() && (bl || pSDepSlnBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDepSlnBase.getUserTag3());
        }
        if (pSDepSlnBase.isUserTag4Dirty() && (bl || pSDepSlnBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDepSlnBase.getUserTag4());
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
        return PSDepSlnBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnBase pSDepSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnBase.resetAdminPSDevUserId();
                return true;
            }
            case 1: {
                pSDepSlnBase.resetAdminPSDevUserName();
                return true;
            }
            case 2: {
                pSDepSlnBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDepSlnBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDepSlnBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDepSlnBase.resetDomainName();
                return true;
            }
            case 6: {
                pSDepSlnBase.resetMemo();
                return true;
            }
            case 7: {
                pSDepSlnBase.resetPSDCClusterId();
                return true;
            }
            case 8: {
                pSDepSlnBase.resetPSDCClusterName();
                return true;
            }
            case 9: {
                pSDepSlnBase.resetPSDCMSPlatformId();
                return true;
            }
            case 10: {
                pSDepSlnBase.resetPSDCMSPlatformName();
                return true;
            }
            case 11: {
                pSDepSlnBase.resetPSDepSlnId();
                return true;
            }
            case 12: {
                pSDepSlnBase.resetPSDepSlnName();
                return true;
            }
            case 13: {
                pSDepSlnBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDepSlnBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDepSlnBase.resetSlnMDUrl();
                return true;
            }
            case 16: {
                pSDepSlnBase.resetSLNSN();
                return true;
            }
            case 17: {
                pSDepSlnBase.resetSlnTag();
                return true;
            }
            case 18: {
                pSDepSlnBase.resetSlnTag2();
                return true;
            }
            case 19: {
                pSDepSlnBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDepSlnBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDepSlnBase.resetUserCat();
                return true;
            }
            case 22: {
                pSDepSlnBase.resetUserTag();
                return true;
            }
            case 23: {
                pSDepSlnBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSDepSlnBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSDepSlnBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet((IEntity)pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatform getPSDCMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatform();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformLock;
        synchronized (n) {
            if (this.psdcmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformId(), (Object)this.psdcmsplatform.getPSDCMSPlatformId()) != 0L) {
                this.psdcmsplatform = null;
            }
            if (this.psdcmsplatform == null) {
                PSDCMSPlatform pSDCMSPlatform = new PSDCMSPlatform();
                pSDCMSPlatform.setPSDCMSPlatformId(this.getPSDCMSPlatformId());
                PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformService.autoGet((IEntity)pSDCMSPlatform);
                this.psdcmsplatform = pSDCMSPlatform;
            }
            return this.psdcmsplatform;
        }
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
    public PSDevUser getAdminPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUser();
        }
        if (this.getAdminPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objAdminPSDevUserLock;
        synchronized (n) {
            if (this.adminpsdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getAdminPSDevUserId(), (Object)this.adminpsdevuser.getPSDevUserId()) != 0L) {
                this.adminpsdevuser = null;
            }
            if (this.adminpsdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getAdminPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet((IEntity)pSDevUser);
                this.adminpsdevuser = pSDevUser;
            }
            return this.adminpsdevuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnBDInst> getPSDepSlnDBInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInsts();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnBDInstService pSDepSlnBDInstService = (PSDepSlnBDInstService)ServiceGlobal.getService(PSDepSlnBDInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnDBInstsLock;
        synchronized (n) {
            if (this.psdepslndbinsts == null) {
                this.psdepslndbinsts = pSDepSlnBDInstService.selectByPSDepSln(this);
            }
            return this.psdepslndbinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnFile> getPSDepSlnFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnFiles();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnFileService pSDepSlnFileService = (PSDepSlnFileService)ServiceGlobal.getService(PSDepSlnFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnFilesLock;
        synchronized (n) {
            if (this.psdepslnfiles == null) {
                this.psdepslnfiles = pSDepSlnFileService.selectByPSDepSln(this);
            }
            return this.psdepslnfiles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnPack> getPSDepSlnPacks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPacks();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnPackService pSDepSlnPackService = (PSDepSlnPackService)ServiceGlobal.getService(PSDepSlnPackService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnPacksLock;
        synchronized (n) {
            if (this.psdepslnpacks == null) {
                this.psdepslnpacks = pSDepSlnPackService.selectByPSDepSln(this);
            }
            return this.psdepslnpacks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnParam> getPSDepSlnParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnParams();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnParamService pSDepSlnParamService = (PSDepSlnParamService)ServiceGlobal.getService(PSDepSlnParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnParamsLock;
        synchronized (n) {
            if (this.psdepslnparams == null) {
                this.psdepslnparams = pSDepSlnParamService.selectByPSDepSln(this);
            }
            return this.psdepslnparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnPrd> getPSDepSlns() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlns();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnPrdService pSDepSlnPrdService = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnsLock;
        synchronized (n) {
            if (this.psdepslns == null) {
                this.psdepslns = pSDepSlnPrdService.selectByPSDepSln(this);
            }
            return this.psdepslns;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnUser> getPSDepSlnUsers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnUsers();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        PSDepSlnUserService pSDepSlnUserService = (PSDepSlnUserService)ServiceGlobal.getService(PSDepSlnUserService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnUsersLock;
        synchronized (n) {
            if (this.psdepslnusers == null) {
                this.psdepslnusers = pSDepSlnUserService.selectByPSDepSln(this);
            }
            return this.psdepslnusers;
        }
    }

    private PSDepSlnBase getProxyEntity() {
        return this.proxyPSDepSlnBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnBase) {
            this.proxyPSDepSlnBase = (PSDepSlnBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERID, 0);
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERNAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DOMAINNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 7);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 8);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 9);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_SLNMDURL, 15);
        fieldIndexMap.put(FIELD_SLNSN, 16);
        fieldIndexMap.put(FIELD_SLNTAG, 17);
        fieldIndexMap.put(FIELD_SLNTAG2, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

