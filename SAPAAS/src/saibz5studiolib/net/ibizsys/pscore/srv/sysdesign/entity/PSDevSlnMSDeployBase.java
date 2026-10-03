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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDeployBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDeployBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPLOYMDURL = "DEPLOYMDURL";
    public static final String FIELD_DEPLOYTAG = "DEPLOYTAG";
    public static final String FIELD_DEPLOYTAG2 = "DEPLOYTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPAPISCNT = "PSDEVSLNMSDEPAPISCNT";
    public static final String FIELD_PSDEVSLNMSDEPAPPSCNT = "PSDEVSLNMSDEPAPPSCNT";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEPLOYMDURL = 2;
    private static final int INDEX_DEPLOYTAG = 3;
    private static final int INDEX_DEPLOYTAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCMSPLATFORMID = 6;
    private static final int INDEX_PSDCMSPLATFORMNAME = 7;
    private static final int INDEX_PSDEVSLNID = 8;
    private static final int INDEX_PSDEVSLNMSDEPAPISCNT = 9;
    private static final int INDEX_PSDEVSLNMSDEPAPPSCNT = 10;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 11;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 12;
    private static final int INDEX_PSDEVSLNNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERPARAMS = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDeployBase proxyPSDevSlnMSDeployBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deploymdurlDirtyFlag = false;
    private boolean deploytagDirtyFlag = false;
    private boolean deploytag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdepapiscntDirtyFlag = false;
    private boolean psdevslnmsdepappscntDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deploymdurl")
    private String deploymdurl;
    @Column(name="deploytag")
    private String deploytag;
    @Column(name="deploytag2")
    private String deploytag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdepapiscnt")
    private Integer psdevslnmsdepapiscnt;
    @Column(name="psdevslnmsdepappscnt")
    private Integer psdevslnmsdepappscnt;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private PSDCMSPlatform psdcmsplatform = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevSlnMSDepAPIsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepAPI> psdevslnmsdepapis = null;
    private Integer objPSDevSlnMSDepAppsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepApp> psdevslnmsdepapps = null;
    private Integer objPSDevSlnMSDepFuncsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepFunc> psdevslnmsdepfuncs = null;
    private Integer objPSDevSlnMSDepResesLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepRes> psdevslnmsdepreses = null;

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

    public void setDeployMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploymdurl = string;
        this.deploymdurlDirtyFlag = true;
    }

    public String getDeployMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployMDUrl();
        }
        return this.deploymdurl;
    }

    public boolean isDeployMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployMDUrlDirty();
        }
        return this.deploymdurlDirtyFlag;
    }

    public void resetDeployMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployMDUrl();
            return;
        }
        this.deploymdurlDirtyFlag = false;
        this.deploymdurl = null;
    }

    public void setDeployTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag = string;
        this.deploytagDirtyFlag = true;
    }

    public String getDeployTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag();
        }
        return this.deploytag;
    }

    public boolean isDeployTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTagDirty();
        }
        return this.deploytagDirtyFlag;
    }

    public void resetDeployTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag();
            return;
        }
        this.deploytagDirtyFlag = false;
        this.deploytag = null;
    }

    public void setDeployTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag2 = string;
        this.deploytag2DirtyFlag = true;
    }

    public String getDeployTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag2();
        }
        return this.deploytag2;
    }

    public boolean isDeployTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag2Dirty();
        }
        return this.deploytag2DirtyFlag;
    }

    public void resetDeployTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag2();
            return;
        }
        this.deploytag2DirtyFlag = false;
        this.deploytag2 = null;
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

    public void setPSDevSlnMSDepAPIsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIsCnt(n);
            return;
        }
        this.psdevslnmsdepapiscnt = n;
        this.psdevslnmsdepapiscntDirtyFlag = true;
    }

    public Integer getPSDevSlnMSDepAPIsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIsCnt();
        }
        return this.psdevslnmsdepapiscnt;
    }

    public boolean isPSDevSlnMSDepAPIsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPIsCntDirty();
        }
        return this.psdevslnmsdepapiscntDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIsCnt();
            return;
        }
        this.psdevslnmsdepapiscntDirtyFlag = false;
        this.psdevslnmsdepapiscnt = null;
    }

    public void setPSDevSlnMSDepAppsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppsCnt(n);
            return;
        }
        this.psdevslnmsdepappscnt = n;
        this.psdevslnmsdepappscntDirtyFlag = true;
    }

    public Integer getPSDevSlnMSDepAppsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppsCnt();
        }
        return this.psdevslnmsdepappscnt;
    }

    public boolean isPSDevSlnMSDepAppsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppsCntDirty();
        }
        return this.psdevslnmsdepappscntDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppsCnt();
            return;
        }
        this.psdevslnmsdepappscntDirtyFlag = false;
        this.psdevslnmsdepappscnt = null;
    }

    public void setPSDevSlnMSDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployid = string;
        this.psdevslnmsdeployidDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployId();
        }
        return this.psdevslnmsdeployid;
    }

    public boolean isPSDevSlnMSDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployIdDirty();
        }
        return this.psdevslnmsdeployidDirtyFlag;
    }

    public void resetPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployId();
            return;
        }
        this.psdevslnmsdeployidDirtyFlag = false;
        this.psdevslnmsdeployid = null;
    }

    public void setPSDevSlnMSDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployname = string;
        this.psdevslnmsdeploynameDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployName();
        }
        return this.psdevslnmsdeployname;
    }

    public boolean isPSDevSlnMSDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployNameDirty();
        }
        return this.psdevslnmsdeploynameDirtyFlag;
    }

    public void resetPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployName();
            return;
        }
        this.psdevslnmsdeploynameDirtyFlag = false;
        this.psdevslnmsdeployname = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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
        PSDevSlnMSDeployBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) {
        pSDevSlnMSDeployBase.resetCreateDate();
        pSDevSlnMSDeployBase.resetCreateMan();
        pSDevSlnMSDeployBase.resetDeployMDUrl();
        pSDevSlnMSDeployBase.resetDeployTag();
        pSDevSlnMSDeployBase.resetDeployTag2();
        pSDevSlnMSDeployBase.resetMemo();
        pSDevSlnMSDeployBase.resetPSDCMSPlatformId();
        pSDevSlnMSDeployBase.resetPSDCMSPlatformName();
        pSDevSlnMSDeployBase.resetPSDevSlnId();
        pSDevSlnMSDeployBase.resetPSDevSlnMSDepAPIsCnt();
        pSDevSlnMSDeployBase.resetPSDevSlnMSDepAppsCnt();
        pSDevSlnMSDeployBase.resetPSDevSlnMSDeployId();
        pSDevSlnMSDeployBase.resetPSDevSlnMSDeployName();
        pSDevSlnMSDeployBase.resetPSDevSlnName();
        pSDevSlnMSDeployBase.resetUpdateDate();
        pSDevSlnMSDeployBase.resetUpdateMan();
        pSDevSlnMSDeployBase.resetUserParams();
        pSDevSlnMSDeployBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeployMDUrlDirty()) {
            hashMap.put(FIELD_DEPLOYMDURL, this.getDeployMDUrl());
        }
        if (!bl || this.isDeployTagDirty()) {
            hashMap.put(FIELD_DEPLOYTAG, this.getDeployTag());
        }
        if (!bl || this.isDeployTag2Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG2, this.getDeployTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDepAPIsCntDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPISCNT, this.getPSDevSlnMSDepAPIsCnt());
        }
        if (!bl || this.isPSDevSlnMSDepAppsCntDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPSCNT, this.getPSDevSlnMSDepAppsCnt());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDevSlnMSDeployBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDeployBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnMSDeployBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnMSDeployBase.getDeployMDUrl();
            }
            case 3: {
                return pSDevSlnMSDeployBase.getDeployTag();
            }
            case 4: {
                return pSDevSlnMSDeployBase.getDeployTag2();
            }
            case 5: {
                return pSDevSlnMSDeployBase.getMemo();
            }
            case 6: {
                return pSDevSlnMSDeployBase.getPSDCMSPlatformId();
            }
            case 7: {
                return pSDevSlnMSDeployBase.getPSDCMSPlatformName();
            }
            case 8: {
                return pSDevSlnMSDeployBase.getPSDevSlnId();
            }
            case 9: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt();
            }
            case 10: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt();
            }
            case 11: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDeployId();
            }
            case 12: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDeployName();
            }
            case 13: {
                return pSDevSlnMSDeployBase.getPSDevSlnName();
            }
            case 14: {
                return pSDevSlnMSDeployBase.getUpdateDate();
            }
            case 15: {
                return pSDevSlnMSDeployBase.getUpdateMan();
            }
            case 16: {
                return pSDevSlnMSDeployBase.getUserParams();
            }
            case 17: {
                return pSDevSlnMSDeployBase.getValidFlag();
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
        PSDevSlnMSDeployBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDeployBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDeployBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDeployBase.setDeployMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDeployBase.setDeployTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDeployBase.setDeployTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDeployBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDeployBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDeployBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDeployBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDeployBase.setPSDevSlnMSDepAPIsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDeployBase.setPSDevSlnMSDepAppsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDeployBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDeployBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDeployBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDeployBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDeployBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDeployBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDeployBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnMSDeployBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDeployBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnMSDeployBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnMSDeployBase.getDeployMDUrl() == null;
            }
            case 3: {
                return pSDevSlnMSDeployBase.getDeployTag() == null;
            }
            case 4: {
                return pSDevSlnMSDeployBase.getDeployTag2() == null;
            }
            case 5: {
                return pSDevSlnMSDeployBase.getMemo() == null;
            }
            case 6: {
                return pSDevSlnMSDeployBase.getPSDCMSPlatformId() == null;
            }
            case 7: {
                return pSDevSlnMSDeployBase.getPSDCMSPlatformName() == null;
            }
            case 8: {
                return pSDevSlnMSDeployBase.getPSDevSlnId() == null;
            }
            case 9: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt() == null;
            }
            case 10: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt() == null;
            }
            case 11: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDeployId() == null;
            }
            case 12: {
                return pSDevSlnMSDeployBase.getPSDevSlnMSDeployName() == null;
            }
            case 13: {
                return pSDevSlnMSDeployBase.getPSDevSlnName() == null;
            }
            case 14: {
                return pSDevSlnMSDeployBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevSlnMSDeployBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDevSlnMSDeployBase.getUserParams() == null;
            }
            case 17: {
                return pSDevSlnMSDeployBase.getValidFlag() == null;
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
        return PSDevSlnMSDeployBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDeployBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnMSDeployBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnMSDeployBase.isDeployMDUrlDirty();
            }
            case 3: {
                return pSDevSlnMSDeployBase.isDeployTagDirty();
            }
            case 4: {
                return pSDevSlnMSDeployBase.isDeployTag2Dirty();
            }
            case 5: {
                return pSDevSlnMSDeployBase.isMemoDirty();
            }
            case 6: {
                return pSDevSlnMSDeployBase.isPSDCMSPlatformIdDirty();
            }
            case 7: {
                return pSDevSlnMSDeployBase.isPSDCMSPlatformNameDirty();
            }
            case 8: {
                return pSDevSlnMSDeployBase.isPSDevSlnIdDirty();
            }
            case 9: {
                return pSDevSlnMSDeployBase.isPSDevSlnMSDepAPIsCntDirty();
            }
            case 10: {
                return pSDevSlnMSDeployBase.isPSDevSlnMSDepAppsCntDirty();
            }
            case 11: {
                return pSDevSlnMSDeployBase.isPSDevSlnMSDeployIdDirty();
            }
            case 12: {
                return pSDevSlnMSDeployBase.isPSDevSlnMSDeployNameDirty();
            }
            case 13: {
                return pSDevSlnMSDeployBase.isPSDevSlnNameDirty();
            }
            case 14: {
                return pSDevSlnMSDeployBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevSlnMSDeployBase.isUpdateManDirty();
            }
            case 16: {
                return pSDevSlnMSDeployBase.isUserParamsDirty();
            }
            case 17: {
                return pSDevSlnMSDeployBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDeployBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDeployBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploymdurl", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getDeployMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getDeployTag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag2", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getDeployTag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiscnt", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappscnt", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevSlnMSDeployBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnMSDeployBase.getJSONValue((Object)pSDevSlnMSDeployBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDeployBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDeployBase.getCreateDate() != null) {
            object = pSDevSlnMSDeployBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDeployBase.getCreateMan() != null) {
            object = pSDevSlnMSDeployBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployMDUrl() != null) {
            object = pSDevSlnMSDeployBase.getDeployMDUrl();
            xmlNode.setAttribute(FIELD_DEPLOYMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployTag() != null) {
            object = pSDevSlnMSDeployBase.getDeployTag();
            xmlNode.setAttribute(FIELD_DEPLOYTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getDeployTag2() != null) {
            object = pSDevSlnMSDeployBase.getDeployTag2();
            xmlNode.setAttribute(FIELD_DEPLOYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getMemo() != null) {
            object = pSDevSlnMSDeployBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformId() != null) {
            object = pSDevSlnMSDeployBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformName() != null) {
            object = pSDevSlnMSDeployBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnId() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPISCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getPSDevSlnName() != null) {
            object = pSDevSlnMSDeployBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getUpdateDate() != null) {
            object = pSDevSlnMSDeployBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDeployBase.getUpdateMan() != null) {
            object = pSDevSlnMSDeployBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getUserParams() != null) {
            object = pSDevSlnMSDeployBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDeployBase.getValidFlag() != null) {
            object = pSDevSlnMSDeployBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDeployBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDeployBase.isCreateDateDirty() && (bl || pSDevSlnMSDeployBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDeployBase.getCreateDate());
        }
        if (pSDevSlnMSDeployBase.isCreateManDirty() && (bl || pSDevSlnMSDeployBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDeployBase.getCreateMan());
        }
        if (pSDevSlnMSDeployBase.isDeployMDUrlDirty() && (bl || pSDevSlnMSDeployBase.getDeployMDUrl() != null)) {
            iDataObject.set(FIELD_DEPLOYMDURL, (Object)pSDevSlnMSDeployBase.getDeployMDUrl());
        }
        if (pSDevSlnMSDeployBase.isDeployTagDirty() && (bl || pSDevSlnMSDeployBase.getDeployTag() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG, (Object)pSDevSlnMSDeployBase.getDeployTag());
        }
        if (pSDevSlnMSDeployBase.isDeployTag2Dirty() && (bl || pSDevSlnMSDeployBase.getDeployTag2() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG2, (Object)pSDevSlnMSDeployBase.getDeployTag2());
        }
        if (pSDevSlnMSDeployBase.isMemoDirty() && (bl || pSDevSlnMSDeployBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDeployBase.getMemo());
        }
        if (pSDevSlnMSDeployBase.isPSDCMSPlatformIdDirty() && (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDevSlnMSDeployBase.getPSDCMSPlatformId());
        }
        if (pSDevSlnMSDeployBase.isPSDCMSPlatformNameDirty() && (bl || pSDevSlnMSDeployBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDevSlnMSDeployBase.getPSDCMSPlatformName());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnIdDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnMSDeployBase.getPSDevSlnId());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnMSDepAPIsCntDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPISCNT, (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDepAPIsCnt());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnMSDepAppsCntDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPSCNT, (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDepAppsCnt());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnMSDeployBase.isPSDevSlnNameDirty() && (bl || pSDevSlnMSDeployBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnMSDeployBase.getPSDevSlnName());
        }
        if (pSDevSlnMSDeployBase.isUpdateDateDirty() && (bl || pSDevSlnMSDeployBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDeployBase.getUpdateDate());
        }
        if (pSDevSlnMSDeployBase.isUpdateManDirty() && (bl || pSDevSlnMSDeployBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDeployBase.getUpdateMan());
        }
        if (pSDevSlnMSDeployBase.isUserParamsDirty() && (bl || pSDevSlnMSDeployBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevSlnMSDeployBase.getUserParams());
        }
        if (pSDevSlnMSDeployBase.isValidFlagDirty() && (bl || pSDevSlnMSDeployBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnMSDeployBase.getValidFlag());
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
        return PSDevSlnMSDeployBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDeployBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnMSDeployBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnMSDeployBase.resetDeployMDUrl();
                return true;
            }
            case 3: {
                pSDevSlnMSDeployBase.resetDeployTag();
                return true;
            }
            case 4: {
                pSDevSlnMSDeployBase.resetDeployTag2();
                return true;
            }
            case 5: {
                pSDevSlnMSDeployBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevSlnMSDeployBase.resetPSDCMSPlatformId();
                return true;
            }
            case 7: {
                pSDevSlnMSDeployBase.resetPSDCMSPlatformName();
                return true;
            }
            case 8: {
                pSDevSlnMSDeployBase.resetPSDevSlnId();
                return true;
            }
            case 9: {
                pSDevSlnMSDeployBase.resetPSDevSlnMSDepAPIsCnt();
                return true;
            }
            case 10: {
                pSDevSlnMSDeployBase.resetPSDevSlnMSDepAppsCnt();
                return true;
            }
            case 11: {
                pSDevSlnMSDeployBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 12: {
                pSDevSlnMSDeployBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 13: {
                pSDevSlnMSDeployBase.resetPSDevSlnName();
                return true;
            }
            case 14: {
                pSDevSlnMSDeployBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevSlnMSDeployBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDevSlnMSDeployBase.resetUserParams();
                return true;
            }
            case 17: {
                pSDevSlnMSDeployBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDCMSPlatformService.autoGet(pSDCMSPlatform);
                this.psdcmsplatform = pSDCMSPlatform;
            }
            return this.psdcmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIs();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepAPIsLock;
        synchronized (n) {
            if (this.psdevslnmsdepapis == null) {
                this.psdevslnmsdepapis = pSDevSlnMSDepAPIService.selectByPSDevSlnMSDeploy(this);
            }
            return this.psdevslnmsdepapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepApps();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepAppsLock;
        synchronized (n) {
            if (this.psdevslnmsdepapps == null) {
                this.psdevslnmsdepapps = pSDevSlnMSDepAppService.selectByPSDevSlnMSDeploy(this);
            }
            return this.psdevslnmsdepapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepFunc> getPSDevSlnMSDepFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncs();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepFuncsLock;
        synchronized (n) {
            if (this.psdevslnmsdepfuncs == null) {
                this.psdevslnmsdepfuncs = pSDevSlnMSDepFuncService.selectByPSDevSlnMSDeploy(this);
            }
            return this.psdevslnmsdepfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepRes> getPSDevSlnMSDepReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepReses();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        PSDevSlnMSDepResService pSDevSlnMSDepResService = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepResesLock;
        synchronized (n) {
            if (this.psdevslnmsdepreses == null) {
                this.psdevslnmsdepreses = pSDevSlnMSDepResService.selectByPSDevSlnMSDeploy(this);
            }
            return this.psdevslnmsdepreses;
        }
    }

    private PSDevSlnMSDeployBase getProxyEntity() {
        return this.proxyPSDevSlnMSDeployBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDeployBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDeployBase) {
            this.proxyPSDevSlnMSDeployBase = (PSDevSlnMSDeployBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEPLOYMDURL, 2);
        fieldIndexMap.put(FIELD_DEPLOYTAG, 3);
        fieldIndexMap.put(FIELD_DEPLOYTAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 6);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPISCNT, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPSCNT, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERPARAMS, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

