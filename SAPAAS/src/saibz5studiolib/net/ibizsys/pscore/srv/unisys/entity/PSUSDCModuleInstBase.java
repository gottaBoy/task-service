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
package net.ibizsys.pscore.srv.unisys.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModule;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstRef;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstRefService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstBase.class);
    public static final String FIELD_ADMINPSDEVUSERID = "ADMINPSDEVUSERID";
    public static final String FIELD_ADMINPSDEVUSERNAME = "ADMINPSDEVUSERNAME";
    public static final String FIELD_ADMINSERVICEURL = "ADMINSERVICEURL";
    public static final String FIELD_ADMINURL = "ADMINURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTTYPE = "INSTTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSUSDCMODULEID = "PSUSDCMODULEID";
    public static final String FIELD_PSUSDCMODULEINSTID = "PSUSDCMODULEINSTID";
    public static final String FIELD_PSUSDCMODULEINSTNAME = "PSUSDCMODULEINSTNAME";
    public static final String FIELD_PSUSDCMODULENAME = "PSUSDCMODULENAME";
    public static final String FIELD_PSUSMODULEINSTID = "PSUSMODULEINSTID";
    public static final String FIELD_PSUSMODULEINSTNAME = "PSUSMODULEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ADMINPSDEVUSERID = 0;
    private static final int INDEX_ADMINPSDEVUSERNAME = 1;
    private static final int INDEX_ADMINSERVICEURL = 2;
    private static final int INDEX_ADMINURL = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_INSTTYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_PSUSDCMODULEID = 10;
    private static final int INDEX_PSUSDCMODULEINSTID = 11;
    private static final int INDEX_PSUSDCMODULEINSTNAME = 12;
    private static final int INDEX_PSUSDCMODULENAME = 13;
    private static final int INDEX_PSUSMODULEINSTID = 14;
    private static final int INDEX_PSUSMODULEINSTNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSDCModuleInstBase proxyPSUSDCModuleInstBase = null;
    private boolean adminpsdevuseridDirtyFlag = false;
    private boolean adminpsdevusernameDirtyFlag = false;
    private boolean adminserviceurlDirtyFlag = false;
    private boolean adminurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean insttypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psusdcmoduleidDirtyFlag = false;
    private boolean psusdcmoduleinstidDirtyFlag = false;
    private boolean psusdcmoduleinstnameDirtyFlag = false;
    private boolean psusdcmodulenameDirtyFlag = false;
    private boolean psusmoduleinstidDirtyFlag = false;
    private boolean psusmoduleinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="adminpsdevuserid")
    private String adminpsdevuserid;
    @Column(name="adminpsdevusername")
    private String adminpsdevusername;
    @Column(name="adminserviceurl")
    private String adminserviceurl;
    @Column(name="adminurl")
    private String adminurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="insttype")
    private String insttype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psusdcmoduleid")
    private String psusdcmoduleid;
    @Column(name="psusdcmoduleinstid")
    private String psusdcmoduleinstid;
    @Column(name="psusdcmoduleinstname")
    private String psusdcmoduleinstname;
    @Column(name="psusdcmodulename")
    private String psusdcmodulename;
    @Column(name="psusmoduleinstid")
    private String psusmoduleinstid;
    @Column(name="psusmoduleinstname")
    private String psusmoduleinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objAdminpsdevuserLock = new Integer(1);
    private PSDevUser adminpsdevuser = null;
    private Integer objPSUSDCModuleLock = new Integer(1);
    private PSUSDCModule psusdcmodule = null;
    private Integer objPSUSModuleInstLock = new Integer(1);
    private PSUSModuleInst psusmoduleinst = null;
    private Integer objPSDSDCModuleInstFuncsLock = new Integer(1);
    private ArrayList<PSUSDCModuleInstFunc> psdsdcmoduleinstfuncs = null;
    private Integer objPSUSDCModuleInstRefsLock = new Integer(1);
    private ArrayList<PSUSDCModuleInstRef> psusdcmoduleinstrefs = null;

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

    public void setAdminServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminserviceurl = string;
        this.adminserviceurlDirtyFlag = true;
    }

    public String getAdminServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminServiceUrl();
        }
        return this.adminserviceurl;
    }

    public boolean isAdminServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminServiceUrlDirty();
        }
        return this.adminserviceurlDirtyFlag;
    }

    public void resetAdminServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminServiceUrl();
            return;
        }
        this.adminserviceurlDirtyFlag = false;
        this.adminserviceurl = null;
    }

    public void setAdminUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminurl = string;
        this.adminurlDirtyFlag = true;
    }

    public String getAdminUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminUrl();
        }
        return this.adminurl;
    }

    public boolean isAdminUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminUrlDirty();
        }
        return this.adminurlDirtyFlag;
    }

    public void resetAdminUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminUrl();
            return;
        }
        this.adminurlDirtyFlag = false;
        this.adminurl = null;
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

    public void setInstType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttype = string;
        this.insttypeDirtyFlag = true;
    }

    public String getInstType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstType();
        }
        return this.insttype;
    }

    public boolean isInstTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTypeDirty();
        }
        return this.insttypeDirtyFlag;
    }

    public void resetInstType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstType();
            return;
        }
        this.insttypeDirtyFlag = false;
        this.insttype = null;
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

    public void setPSUSDCModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleid = string;
        this.psusdcmoduleidDirtyFlag = true;
    }

    public String getPSUSDCModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleId();
        }
        return this.psusdcmoduleid;
    }

    public boolean isPSUSDCModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleIdDirty();
        }
        return this.psusdcmoduleidDirtyFlag;
    }

    public void resetPSUSDCModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleId();
            return;
        }
        this.psusdcmoduleidDirtyFlag = false;
        this.psusdcmoduleid = null;
    }

    public void setPSUSDCModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstid = string;
        this.psusdcmoduleinstidDirtyFlag = true;
    }

    public String getPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstId();
        }
        return this.psusdcmoduleinstid;
    }

    public boolean isPSUSDCModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstIdDirty();
        }
        return this.psusdcmoduleinstidDirtyFlag;
    }

    public void resetPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstId();
            return;
        }
        this.psusdcmoduleinstidDirtyFlag = false;
        this.psusdcmoduleinstid = null;
    }

    public void setPSUSDCModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstname = string;
        this.psusdcmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstName();
        }
        return this.psusdcmoduleinstname;
    }

    public boolean isPSUSDCModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstNameDirty();
        }
        return this.psusdcmoduleinstnameDirtyFlag;
    }

    public void resetPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstName();
            return;
        }
        this.psusdcmoduleinstnameDirtyFlag = false;
        this.psusdcmoduleinstname = null;
    }

    public void setPSUSDCModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmodulename = string;
        this.psusdcmodulenameDirtyFlag = true;
    }

    public String getPSUSDCModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleName();
        }
        return this.psusdcmodulename;
    }

    public boolean isPSUSDCModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleNameDirty();
        }
        return this.psusdcmodulenameDirtyFlag;
    }

    public void resetPSUSDCModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleName();
            return;
        }
        this.psusdcmodulenameDirtyFlag = false;
        this.psusdcmodulename = null;
    }

    public void setPSUSModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstid = string;
        this.psusmoduleinstidDirtyFlag = true;
    }

    public String getPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstId();
        }
        return this.psusmoduleinstid;
    }

    public boolean isPSUSModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstIdDirty();
        }
        return this.psusmoduleinstidDirtyFlag;
    }

    public void resetPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstId();
            return;
        }
        this.psusmoduleinstidDirtyFlag = false;
        this.psusmoduleinstid = null;
    }

    public void setPSUSModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstname = string;
        this.psusmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstName();
        }
        return this.psusmoduleinstname;
    }

    public boolean isPSUSModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstNameDirty();
        }
        return this.psusmoduleinstnameDirtyFlag;
    }

    public void resetPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstName();
            return;
        }
        this.psusmoduleinstnameDirtyFlag = false;
        this.psusmoduleinstname = null;
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
        PSUSDCModuleInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSDCModuleInstBase pSUSDCModuleInstBase) {
        pSUSDCModuleInstBase.resetAdminPSDevUserId();
        pSUSDCModuleInstBase.resetAdminPSDevUserName();
        pSUSDCModuleInstBase.resetAdminServiceUrl();
        pSUSDCModuleInstBase.resetAdminUrl();
        pSUSDCModuleInstBase.resetCreateDate();
        pSUSDCModuleInstBase.resetCreateMan();
        pSUSDCModuleInstBase.resetInstType();
        pSUSDCModuleInstBase.resetMemo();
        pSUSDCModuleInstBase.resetPSDevCenterId();
        pSUSDCModuleInstBase.resetPSDevCenterName();
        pSUSDCModuleInstBase.resetPSUSDCModuleId();
        pSUSDCModuleInstBase.resetPSUSDCModuleInstId();
        pSUSDCModuleInstBase.resetPSUSDCModuleInstName();
        pSUSDCModuleInstBase.resetPSUSDCModuleName();
        pSUSDCModuleInstBase.resetPSUSModuleInstId();
        pSUSDCModuleInstBase.resetPSUSModuleInstName();
        pSUSDCModuleInstBase.resetUpdateDate();
        pSUSDCModuleInstBase.resetUpdateMan();
        pSUSDCModuleInstBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPSDevUserIdDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERID, this.getAdminPSDevUserId());
        }
        if (!bl || this.isAdminPSDevUserNameDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERNAME, this.getAdminPSDevUserName());
        }
        if (!bl || this.isAdminServiceUrlDirty()) {
            hashMap.put(FIELD_ADMINSERVICEURL, this.getAdminServiceUrl());
        }
        if (!bl || this.isAdminUrlDirty()) {
            hashMap.put(FIELD_ADMINURL, this.getAdminUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInstTypeDirty()) {
            hashMap.put(FIELD_INSTTYPE, this.getInstType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSUSDCModuleIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEID, this.getPSUSDCModuleId());
        }
        if (!bl || this.isPSUSDCModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTID, this.getPSUSDCModuleInstId());
        }
        if (!bl || this.isPSUSDCModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTNAME, this.getPSUSDCModuleInstName());
        }
        if (!bl || this.isPSUSDCModuleNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULENAME, this.getPSUSDCModuleName());
        }
        if (!bl || this.isPSUSModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTID, this.getPSUSModuleInstId());
        }
        if (!bl || this.isPSUSModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTNAME, this.getPSUSModuleInstName());
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
        return PSUSDCModuleInstBase.get(this, n);
    }

    private static Object get(PSUSDCModuleInstBase pSUSDCModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstBase.getAdminPSDevUserId();
            }
            case 1: {
                return pSUSDCModuleInstBase.getAdminPSDevUserName();
            }
            case 2: {
                return pSUSDCModuleInstBase.getAdminServiceUrl();
            }
            case 3: {
                return pSUSDCModuleInstBase.getAdminUrl();
            }
            case 4: {
                return pSUSDCModuleInstBase.getCreateDate();
            }
            case 5: {
                return pSUSDCModuleInstBase.getCreateMan();
            }
            case 6: {
                return pSUSDCModuleInstBase.getInstType();
            }
            case 7: {
                return pSUSDCModuleInstBase.getMemo();
            }
            case 8: {
                return pSUSDCModuleInstBase.getPSDevCenterId();
            }
            case 9: {
                return pSUSDCModuleInstBase.getPSDevCenterName();
            }
            case 10: {
                return pSUSDCModuleInstBase.getPSUSDCModuleId();
            }
            case 11: {
                return pSUSDCModuleInstBase.getPSUSDCModuleInstId();
            }
            case 12: {
                return pSUSDCModuleInstBase.getPSUSDCModuleInstName();
            }
            case 13: {
                return pSUSDCModuleInstBase.getPSUSDCModuleName();
            }
            case 14: {
                return pSUSDCModuleInstBase.getPSUSModuleInstId();
            }
            case 15: {
                return pSUSDCModuleInstBase.getPSUSModuleInstName();
            }
            case 16: {
                return pSUSDCModuleInstBase.getUpdateDate();
            }
            case 17: {
                return pSUSDCModuleInstBase.getUpdateMan();
            }
            case 18: {
                return pSUSDCModuleInstBase.getValidFlag();
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
        PSUSDCModuleInstBase.set(this, n, object);
    }

    private static void set(PSUSDCModuleInstBase pSUSDCModuleInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstBase.setAdminPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUSDCModuleInstBase.setAdminPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSDCModuleInstBase.setAdminServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSDCModuleInstBase.setAdminUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSDCModuleInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSUSDCModuleInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSDCModuleInstBase.setInstType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSDCModuleInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSDCModuleInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSDCModuleInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUSDCModuleInstBase.setPSUSDCModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUSDCModuleInstBase.setPSUSDCModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUSDCModuleInstBase.setPSUSDCModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUSDCModuleInstBase.setPSUSDCModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUSDCModuleInstBase.setPSUSModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUSDCModuleInstBase.setPSUSModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUSDCModuleInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSUSDCModuleInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUSDCModuleInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUSDCModuleInstBase.isNull(this, n);
    }

    private static boolean isNull(PSUSDCModuleInstBase pSUSDCModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstBase.getAdminPSDevUserId() == null;
            }
            case 1: {
                return pSUSDCModuleInstBase.getAdminPSDevUserName() == null;
            }
            case 2: {
                return pSUSDCModuleInstBase.getAdminServiceUrl() == null;
            }
            case 3: {
                return pSUSDCModuleInstBase.getAdminUrl() == null;
            }
            case 4: {
                return pSUSDCModuleInstBase.getCreateDate() == null;
            }
            case 5: {
                return pSUSDCModuleInstBase.getCreateMan() == null;
            }
            case 6: {
                return pSUSDCModuleInstBase.getInstType() == null;
            }
            case 7: {
                return pSUSDCModuleInstBase.getMemo() == null;
            }
            case 8: {
                return pSUSDCModuleInstBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSUSDCModuleInstBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSUSDCModuleInstBase.getPSUSDCModuleId() == null;
            }
            case 11: {
                return pSUSDCModuleInstBase.getPSUSDCModuleInstId() == null;
            }
            case 12: {
                return pSUSDCModuleInstBase.getPSUSDCModuleInstName() == null;
            }
            case 13: {
                return pSUSDCModuleInstBase.getPSUSDCModuleName() == null;
            }
            case 14: {
                return pSUSDCModuleInstBase.getPSUSModuleInstId() == null;
            }
            case 15: {
                return pSUSDCModuleInstBase.getPSUSModuleInstName() == null;
            }
            case 16: {
                return pSUSDCModuleInstBase.getUpdateDate() == null;
            }
            case 17: {
                return pSUSDCModuleInstBase.getUpdateMan() == null;
            }
            case 18: {
                return pSUSDCModuleInstBase.getValidFlag() == null;
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
        return PSUSDCModuleInstBase.contains(this, n);
    }

    private static boolean contains(PSUSDCModuleInstBase pSUSDCModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstBase.isAdminPSDevUserIdDirty();
            }
            case 1: {
                return pSUSDCModuleInstBase.isAdminPSDevUserNameDirty();
            }
            case 2: {
                return pSUSDCModuleInstBase.isAdminServiceUrlDirty();
            }
            case 3: {
                return pSUSDCModuleInstBase.isAdminUrlDirty();
            }
            case 4: {
                return pSUSDCModuleInstBase.isCreateDateDirty();
            }
            case 5: {
                return pSUSDCModuleInstBase.isCreateManDirty();
            }
            case 6: {
                return pSUSDCModuleInstBase.isInstTypeDirty();
            }
            case 7: {
                return pSUSDCModuleInstBase.isMemoDirty();
            }
            case 8: {
                return pSUSDCModuleInstBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSUSDCModuleInstBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSUSDCModuleInstBase.isPSUSDCModuleIdDirty();
            }
            case 11: {
                return pSUSDCModuleInstBase.isPSUSDCModuleInstIdDirty();
            }
            case 12: {
                return pSUSDCModuleInstBase.isPSUSDCModuleInstNameDirty();
            }
            case 13: {
                return pSUSDCModuleInstBase.isPSUSDCModuleNameDirty();
            }
            case 14: {
                return pSUSDCModuleInstBase.isPSUSModuleInstIdDirty();
            }
            case 15: {
                return pSUSDCModuleInstBase.isPSUSModuleInstNameDirty();
            }
            case 16: {
                return pSUSDCModuleInstBase.isUpdateDateDirty();
            }
            case 17: {
                return pSUSDCModuleInstBase.isUpdateManDirty();
            }
            case 18: {
                return pSUSDCModuleInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSDCModuleInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSDCModuleInstBase pSUSDCModuleInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSDCModuleInstBase.getAdminPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevuserid", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getAdminPSDevUserId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getAdminPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevusername", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getAdminPSDevUserName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getAdminServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminserviceurl", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getAdminServiceUrl()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getAdminUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminurl", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getAdminUrl()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getInstType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttype", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getInstType()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleid", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSDCModuleId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstid", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSDCModuleInstId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstname", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSDCModuleInstName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmodulename", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSDCModuleName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstid", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSModuleInstId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstname", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getPSUSModuleInstName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUSDCModuleInstBase.getJSONValue((Object)pSUSDCModuleInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSDCModuleInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSDCModuleInstBase pSUSDCModuleInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSDCModuleInstBase.getAdminPSDevUserId() != null) {
            object = pSUSDCModuleInstBase.getAdminPSDevUserId();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERID, (String)(object == null ? "" : object));
        }
        if (bl || pSUSDCModuleInstBase.getAdminPSDevUserName() != null) {
            object = pSUSDCModuleInstBase.getAdminPSDevUserName();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSUSDCModuleInstBase.getAdminServiceUrl() != null) {
            object = pSUSDCModuleInstBase.getAdminServiceUrl();
            xmlNode.setAttribute(FIELD_ADMINSERVICEURL, (String)(object == null ? "" : object));
        }
        if (bl || pSUSDCModuleInstBase.getAdminUrl() != null) {
            object = pSUSDCModuleInstBase.getAdminUrl();
            xmlNode.setAttribute(FIELD_ADMINURL, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getCreateDate() != null) {
            object = pSUSDCModuleInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstBase.getCreateMan() != null) {
            object = pSUSDCModuleInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getInstType() != null) {
            object = pSUSDCModuleInstBase.getInstType();
            xmlNode.setAttribute(FIELD_INSTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getMemo() != null) {
            object = pSUSDCModuleInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSDevCenterId() != null) {
            object = pSUSDCModuleInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSDevCenterName() != null) {
            object = pSUSDCModuleInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleId() != null) {
            object = pSUSDCModuleInstBase.getPSUSDCModuleId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstId() != null) {
            object = pSUSDCModuleInstBase.getPSUSDCModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstName() != null) {
            object = pSUSDCModuleInstBase.getPSUSDCModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSDCModuleName() != null) {
            object = pSUSDCModuleInstBase.getPSUSDCModuleName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSModuleInstId() != null) {
            object = pSUSDCModuleInstBase.getPSUSModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getPSUSModuleInstName() != null) {
            object = pSUSDCModuleInstBase.getPSUSModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getUpdateDate() != null) {
            object = pSUSDCModuleInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstBase.getUpdateMan() != null) {
            object = pSUSDCModuleInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstBase.getValidFlag() != null) {
            object = pSUSDCModuleInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSDCModuleInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSDCModuleInstBase pSUSDCModuleInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSDCModuleInstBase.isAdminPSDevUserIdDirty() && (bl || pSUSDCModuleInstBase.getAdminPSDevUserId() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERID, (Object)pSUSDCModuleInstBase.getAdminPSDevUserId());
        }
        if (pSUSDCModuleInstBase.isAdminPSDevUserNameDirty() && (bl || pSUSDCModuleInstBase.getAdminPSDevUserName() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERNAME, (Object)pSUSDCModuleInstBase.getAdminPSDevUserName());
        }
        if (pSUSDCModuleInstBase.isAdminServiceUrlDirty() && (bl || pSUSDCModuleInstBase.getAdminServiceUrl() != null)) {
            iDataObject.set(FIELD_ADMINSERVICEURL, (Object)pSUSDCModuleInstBase.getAdminServiceUrl());
        }
        if (pSUSDCModuleInstBase.isAdminUrlDirty() && (bl || pSUSDCModuleInstBase.getAdminUrl() != null)) {
            iDataObject.set(FIELD_ADMINURL, (Object)pSUSDCModuleInstBase.getAdminUrl());
        }
        if (pSUSDCModuleInstBase.isCreateDateDirty() && (bl || pSUSDCModuleInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSDCModuleInstBase.getCreateDate());
        }
        if (pSUSDCModuleInstBase.isCreateManDirty() && (bl || pSUSDCModuleInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSDCModuleInstBase.getCreateMan());
        }
        if (pSUSDCModuleInstBase.isInstTypeDirty() && (bl || pSUSDCModuleInstBase.getInstType() != null)) {
            iDataObject.set(FIELD_INSTTYPE, (Object)pSUSDCModuleInstBase.getInstType());
        }
        if (pSUSDCModuleInstBase.isMemoDirty() && (bl || pSUSDCModuleInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSDCModuleInstBase.getMemo());
        }
        if (pSUSDCModuleInstBase.isPSDevCenterIdDirty() && (bl || pSUSDCModuleInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSUSDCModuleInstBase.getPSDevCenterId());
        }
        if (pSUSDCModuleInstBase.isPSDevCenterNameDirty() && (bl || pSUSDCModuleInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSUSDCModuleInstBase.getPSDevCenterName());
        }
        if (pSUSDCModuleInstBase.isPSUSDCModuleIdDirty() && (bl || pSUSDCModuleInstBase.getPSUSDCModuleId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEID, (Object)pSUSDCModuleInstBase.getPSUSDCModuleId());
        }
        if (pSUSDCModuleInstBase.isPSUSDCModuleInstIdDirty() && (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTID, (Object)pSUSDCModuleInstBase.getPSUSDCModuleInstId());
        }
        if (pSUSDCModuleInstBase.isPSUSDCModuleInstNameDirty() && (bl || pSUSDCModuleInstBase.getPSUSDCModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTNAME, (Object)pSUSDCModuleInstBase.getPSUSDCModuleInstName());
        }
        if (pSUSDCModuleInstBase.isPSUSDCModuleNameDirty() && (bl || pSUSDCModuleInstBase.getPSUSDCModuleName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULENAME, (Object)pSUSDCModuleInstBase.getPSUSDCModuleName());
        }
        if (pSUSDCModuleInstBase.isPSUSModuleInstIdDirty() && (bl || pSUSDCModuleInstBase.getPSUSModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTID, (Object)pSUSDCModuleInstBase.getPSUSModuleInstId());
        }
        if (pSUSDCModuleInstBase.isPSUSModuleInstNameDirty() && (bl || pSUSDCModuleInstBase.getPSUSModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTNAME, (Object)pSUSDCModuleInstBase.getPSUSModuleInstName());
        }
        if (pSUSDCModuleInstBase.isUpdateDateDirty() && (bl || pSUSDCModuleInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSDCModuleInstBase.getUpdateDate());
        }
        if (pSUSDCModuleInstBase.isUpdateManDirty() && (bl || pSUSDCModuleInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSDCModuleInstBase.getUpdateMan());
        }
        if (pSUSDCModuleInstBase.isValidFlagDirty() && (bl || pSUSDCModuleInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUSDCModuleInstBase.getValidFlag());
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
        return PSUSDCModuleInstBase.remove(this, n);
    }

    private static boolean remove(PSUSDCModuleInstBase pSUSDCModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstBase.resetAdminPSDevUserId();
                return true;
            }
            case 1: {
                pSUSDCModuleInstBase.resetAdminPSDevUserName();
                return true;
            }
            case 2: {
                pSUSDCModuleInstBase.resetAdminServiceUrl();
                return true;
            }
            case 3: {
                pSUSDCModuleInstBase.resetAdminUrl();
                return true;
            }
            case 4: {
                pSUSDCModuleInstBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSUSDCModuleInstBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSUSDCModuleInstBase.resetInstType();
                return true;
            }
            case 7: {
                pSUSDCModuleInstBase.resetMemo();
                return true;
            }
            case 8: {
                pSUSDCModuleInstBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSUSDCModuleInstBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSUSDCModuleInstBase.resetPSUSDCModuleId();
                return true;
            }
            case 11: {
                pSUSDCModuleInstBase.resetPSUSDCModuleInstId();
                return true;
            }
            case 12: {
                pSUSDCModuleInstBase.resetPSUSDCModuleInstName();
                return true;
            }
            case 13: {
                pSUSDCModuleInstBase.resetPSUSDCModuleName();
                return true;
            }
            case 14: {
                pSUSDCModuleInstBase.resetPSUSModuleInstId();
                return true;
            }
            case 15: {
                pSUSDCModuleInstBase.resetPSUSModuleInstName();
                return true;
            }
            case 16: {
                pSUSDCModuleInstBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSUSDCModuleInstBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSUSDCModuleInstBase.resetValidFlag();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getAdminpsdevuser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminpsdevuser();
        }
        if (this.getAdminPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objAdminpsdevuserLock;
        synchronized (n) {
            if (this.adminpsdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getAdminPSDevUserId(), (Object)this.adminpsdevuser.getPSDevUserId()) != 0L) {
                this.adminpsdevuser = null;
            }
            if (this.adminpsdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getAdminPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.adminpsdevuser = pSDevUser;
            }
            return this.adminpsdevuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSDCModule getPSUSDCModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModule();
        }
        if (this.getPSUSDCModuleId() == null) {
            return null;
        }
        Integer n = this.objPSUSDCModuleLock;
        synchronized (n) {
            if (this.psusdcmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSDCModuleId(), (Object)this.psusdcmodule.getPSUSDCModuleId()) != 0L) {
                this.psusdcmodule = null;
            }
            if (this.psusdcmodule == null) {
                PSUSDCModule pSUSDCModule = new PSUSDCModule();
                pSUSDCModule.setPSUSDCModuleId(this.getPSUSDCModuleId());
                PSUSDCModuleService pSUSDCModuleService = (PSUSDCModuleService)ServiceGlobal.getService(PSUSDCModuleService.class, (SessionFactory)this.getSessionFactory());
                pSUSDCModuleService.autoGet(pSUSDCModule);
                this.psusdcmodule = pSUSDCModule;
            }
            return this.psusdcmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModuleInst getPSUSModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInst();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        Integer n = this.objPSUSModuleInstLock;
        synchronized (n) {
            if (this.psusmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSModuleInstId(), (Object)this.psusmoduleinst.getPSUSModuleInstId()) != 0L) {
                this.psusmoduleinst = null;
            }
            if (this.psusmoduleinst == null) {
                PSUSModuleInst pSUSModuleInst = new PSUSModuleInst();
                pSUSModuleInst.setPSUSModuleInstId(this.getPSUSModuleInstId());
                PSUSModuleInstService pSUSModuleInstService = (PSUSModuleInstService)ServiceGlobal.getService(PSUSModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleInstService.autoGet(pSUSModuleInst);
                this.psusmoduleinst = pSUSModuleInst;
            }
            return this.psusmoduleinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSDCModuleInstFunc> getPSDSDCModuleInstFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSDCModuleInstFuncs();
        }
        if (this.getPSUSDCModuleInstId() == null) {
            return null;
        }
        PSUSDCModuleInstFuncService pSUSDCModuleInstFuncService = (PSUSDCModuleInstFuncService)ServiceGlobal.getService(PSUSDCModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDSDCModuleInstFuncsLock;
        synchronized (n) {
            if (this.psdsdcmoduleinstfuncs == null) {
                this.psdsdcmoduleinstfuncs = pSUSDCModuleInstFuncService.selectByPSUSDCModuleInst(this);
            }
            return this.psdsdcmoduleinstfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSDCModuleInstRef> getPSUSDCModuleInstRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstRefs();
        }
        if (this.getPSUSDCModuleInstId() == null) {
            return null;
        }
        PSUSDCModuleInstRefService pSUSDCModuleInstRefService = (PSUSDCModuleInstRefService)ServiceGlobal.getService(PSUSDCModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSDCModuleInstRefsLock;
        synchronized (n) {
            if (this.psusdcmoduleinstrefs == null) {
                this.psusdcmoduleinstrefs = pSUSDCModuleInstRefService.selectByPSUSDCModuleInst(this);
            }
            return this.psusdcmoduleinstrefs;
        }
    }

    private PSUSDCModuleInstBase getProxyEntity() {
        return this.proxyPSUSDCModuleInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSDCModuleInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSDCModuleInstBase) {
            this.proxyPSUSDCModuleInstBase = (PSUSDCModuleInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERID, 0);
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERNAME, 1);
        fieldIndexMap.put(FIELD_ADMINSERVICEURL, 2);
        fieldIndexMap.put(FIELD_ADMINURL, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_INSTTYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_PSUSDCMODULEID, 10);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTID, 11);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTNAME, 12);
        fieldIndexMap.put(FIELD_PSUSDCMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTID, 14);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

