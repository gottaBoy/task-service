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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNMSDEPRESID = "PSDEVSLNMSDEPRESID";
    public static final String FIELD_PSDEVSLNMSDEPRESNAME = "PSDEVSLNMSDEPRESNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNRESID = "PSDEVSLNRESID";
    public static final String FIELD_PSDEVSLNRESNAME = "PSDEVSLNRESNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_RESPARAMS = "RESPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNID = 3;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 4;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 5;
    private static final int INDEX_PSDEVSLNMSDEPRESID = 6;
    private static final int INDEX_PSDEVSLNMSDEPRESNAME = 7;
    private static final int INDEX_PSDEVSLNNAME = 8;
    private static final int INDEX_PSDEVSLNRESID = 9;
    private static final int INDEX_PSDEVSLNRESNAME = 10;
    private static final int INDEX_PSDEVSLNSYSID = 11;
    private static final int INDEX_PSDEVSLNSYSNAME = 12;
    private static final int INDEX_RESPARAMS = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDepResBase proxyPSDevSlnMSDepResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnmsdepresidDirtyFlag = false;
    private boolean psdevslnmsdepresnameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnresidDirtyFlag = false;
    private boolean psdevslnresnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean resparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnmsdepresid")
    private String psdevslnmsdepresid;
    @Column(name="psdevslnmsdepresname")
    private String psdevslnmsdepresname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnresid")
    private String psdevslnresid;
    @Column(name="psdevslnresname")
    private String psdevslnresname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="resparams")
    private String resparams;
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
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnResLock = new Integer(1);
    private PSDevSlnRes psdevslnres = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setPSDevSlnMSDepResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepresid = string;
        this.psdevslnmsdepresidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepResId();
        }
        return this.psdevslnmsdepresid;
    }

    public boolean isPSDevSlnMSDepResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepResIdDirty();
        }
        return this.psdevslnmsdepresidDirtyFlag;
    }

    public void resetPSDevSlnMSDepResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepResId();
            return;
        }
        this.psdevslnmsdepresidDirtyFlag = false;
        this.psdevslnmsdepresid = null;
    }

    public void setPSDevSlnMSDepResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepresname = string;
        this.psdevslnmsdepresnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepResName();
        }
        return this.psdevslnmsdepresname;
    }

    public boolean isPSDevSlnMSDepResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepResNameDirty();
        }
        return this.psdevslnmsdepresnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepResName();
            return;
        }
        this.psdevslnmsdepresnameDirtyFlag = false;
        this.psdevslnmsdepresname = null;
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

    public void setPSDevSlnResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnresid = string;
        this.psdevslnresidDirtyFlag = true;
    }

    public String getPSDevSlnResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnResId();
        }
        return this.psdevslnresid;
    }

    public boolean isPSDevSlnResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnResIdDirty();
        }
        return this.psdevslnresidDirtyFlag;
    }

    public void resetPSDevSlnResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnResId();
            return;
        }
        this.psdevslnresidDirtyFlag = false;
        this.psdevslnresid = null;
    }

    public void setPSDevSlnResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnresname = string;
        this.psdevslnresnameDirtyFlag = true;
    }

    public String getPSDevSlnResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnResName();
        }
        return this.psdevslnresname;
    }

    public boolean isPSDevSlnResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnResNameDirty();
        }
        return this.psdevslnresnameDirtyFlag;
    }

    public void resetPSDevSlnResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnResName();
            return;
        }
        this.psdevslnresnameDirtyFlag = false;
        this.psdevslnresname = null;
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

    public void setResParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resparams = string;
        this.resparamsDirtyFlag = true;
    }

    public String getResParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResParams();
        }
        return this.resparams;
    }

    public boolean isResParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResParamsDirty();
        }
        return this.resparamsDirtyFlag;
    }

    public void resetResParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResParams();
            return;
        }
        this.resparamsDirtyFlag = false;
        this.resparams = null;
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
        PSDevSlnMSDepResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDepResBase pSDevSlnMSDepResBase) {
        pSDevSlnMSDepResBase.resetCreateDate();
        pSDevSlnMSDepResBase.resetCreateMan();
        pSDevSlnMSDepResBase.resetMemo();
        pSDevSlnMSDepResBase.resetPSDevSlnId();
        pSDevSlnMSDepResBase.resetPSDevSlnMSDeployId();
        pSDevSlnMSDepResBase.resetPSDevSlnMSDeployName();
        pSDevSlnMSDepResBase.resetPSDevSlnMSDepResId();
        pSDevSlnMSDepResBase.resetPSDevSlnMSDepResName();
        pSDevSlnMSDepResBase.resetPSDevSlnName();
        pSDevSlnMSDepResBase.resetPSDevSlnResId();
        pSDevSlnMSDepResBase.resetPSDevSlnResName();
        pSDevSlnMSDepResBase.resetPSDevSlnSysId();
        pSDevSlnMSDepResBase.resetPSDevSlnSysName();
        pSDevSlnMSDepResBase.resetResParams();
        pSDevSlnMSDepResBase.resetUpdateDate();
        pSDevSlnMSDepResBase.resetUpdateMan();
        pSDevSlnMSDepResBase.resetUserCat();
        pSDevSlnMSDepResBase.resetUserTag();
        pSDevSlnMSDepResBase.resetUserTag2();
        pSDevSlnMSDepResBase.resetUserTag3();
        pSDevSlnMSDepResBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
        }
        if (!bl || this.isPSDevSlnMSDepResIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPRESID, this.getPSDevSlnMSDepResId());
        }
        if (!bl || this.isPSDevSlnMSDepResNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPRESNAME, this.getPSDevSlnMSDepResName());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnResIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNRESID, this.getPSDevSlnResId());
        }
        if (!bl || this.isPSDevSlnResNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNRESNAME, this.getPSDevSlnResName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isResParamsDirty()) {
            hashMap.put(FIELD_RESPARAMS, this.getResParams());
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
        return PSDevSlnMSDepResBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepResBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnMSDepResBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnMSDepResBase.getMemo();
            }
            case 3: {
                return pSDevSlnMSDepResBase.getPSDevSlnId();
            }
            case 4: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDeployId();
            }
            case 5: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDeployName();
            }
            case 6: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDepResId();
            }
            case 7: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDepResName();
            }
            case 8: {
                return pSDevSlnMSDepResBase.getPSDevSlnName();
            }
            case 9: {
                return pSDevSlnMSDepResBase.getPSDevSlnResId();
            }
            case 10: {
                return pSDevSlnMSDepResBase.getPSDevSlnResName();
            }
            case 11: {
                return pSDevSlnMSDepResBase.getPSDevSlnSysId();
            }
            case 12: {
                return pSDevSlnMSDepResBase.getPSDevSlnSysName();
            }
            case 13: {
                return pSDevSlnMSDepResBase.getResParams();
            }
            case 14: {
                return pSDevSlnMSDepResBase.getUpdateDate();
            }
            case 15: {
                return pSDevSlnMSDepResBase.getUpdateMan();
            }
            case 16: {
                return pSDevSlnMSDepResBase.getUserCat();
            }
            case 17: {
                return pSDevSlnMSDepResBase.getUserTag();
            }
            case 18: {
                return pSDevSlnMSDepResBase.getUserTag2();
            }
            case 19: {
                return pSDevSlnMSDepResBase.getUserTag3();
            }
            case 20: {
                return pSDevSlnMSDepResBase.getUserTag4();
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
        PSDevSlnMSDepResBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDepResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDepResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDepResBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDepResBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDepResBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDepResBase.setPSDevSlnMSDepResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDepResBase.setPSDevSlnMSDepResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDepResBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDepResBase.setPSDevSlnResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDepResBase.setPSDevSlnResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDepResBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDepResBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDepResBase.setResParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDepResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDepResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDepResBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDepResBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnMSDepResBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnMSDepResBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnMSDepResBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevSlnMSDepResBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepResBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnMSDepResBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnMSDepResBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnMSDepResBase.getPSDevSlnId() == null;
            }
            case 4: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDeployId() == null;
            }
            case 5: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDeployName() == null;
            }
            case 6: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDepResId() == null;
            }
            case 7: {
                return pSDevSlnMSDepResBase.getPSDevSlnMSDepResName() == null;
            }
            case 8: {
                return pSDevSlnMSDepResBase.getPSDevSlnName() == null;
            }
            case 9: {
                return pSDevSlnMSDepResBase.getPSDevSlnResId() == null;
            }
            case 10: {
                return pSDevSlnMSDepResBase.getPSDevSlnResName() == null;
            }
            case 11: {
                return pSDevSlnMSDepResBase.getPSDevSlnSysId() == null;
            }
            case 12: {
                return pSDevSlnMSDepResBase.getPSDevSlnSysName() == null;
            }
            case 13: {
                return pSDevSlnMSDepResBase.getResParams() == null;
            }
            case 14: {
                return pSDevSlnMSDepResBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevSlnMSDepResBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDevSlnMSDepResBase.getUserCat() == null;
            }
            case 17: {
                return pSDevSlnMSDepResBase.getUserTag() == null;
            }
            case 18: {
                return pSDevSlnMSDepResBase.getUserTag2() == null;
            }
            case 19: {
                return pSDevSlnMSDepResBase.getUserTag3() == null;
            }
            case 20: {
                return pSDevSlnMSDepResBase.getUserTag4() == null;
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
        return PSDevSlnMSDepResBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepResBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnMSDepResBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnMSDepResBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnMSDepResBase.isPSDevSlnIdDirty();
            }
            case 4: {
                return pSDevSlnMSDepResBase.isPSDevSlnMSDeployIdDirty();
            }
            case 5: {
                return pSDevSlnMSDepResBase.isPSDevSlnMSDeployNameDirty();
            }
            case 6: {
                return pSDevSlnMSDepResBase.isPSDevSlnMSDepResIdDirty();
            }
            case 7: {
                return pSDevSlnMSDepResBase.isPSDevSlnMSDepResNameDirty();
            }
            case 8: {
                return pSDevSlnMSDepResBase.isPSDevSlnNameDirty();
            }
            case 9: {
                return pSDevSlnMSDepResBase.isPSDevSlnResIdDirty();
            }
            case 10: {
                return pSDevSlnMSDepResBase.isPSDevSlnResNameDirty();
            }
            case 11: {
                return pSDevSlnMSDepResBase.isPSDevSlnSysIdDirty();
            }
            case 12: {
                return pSDevSlnMSDepResBase.isPSDevSlnSysNameDirty();
            }
            case 13: {
                return pSDevSlnMSDepResBase.isResParamsDirty();
            }
            case 14: {
                return pSDevSlnMSDepResBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevSlnMSDepResBase.isUpdateManDirty();
            }
            case 16: {
                return pSDevSlnMSDepResBase.isUserCatDirty();
            }
            case 17: {
                return pSDevSlnMSDepResBase.isUserTagDirty();
            }
            case 18: {
                return pSDevSlnMSDepResBase.isUserTag2Dirty();
            }
            case 19: {
                return pSDevSlnMSDepResBase.isUserTag3Dirty();
            }
            case 20: {
                return pSDevSlnMSDepResBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDepResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDepResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepresid", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnMSDepResId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepresname", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnMSDepResName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnresid", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnResId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnresname", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnResName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getResParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resparams", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getResParams()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnMSDepResBase.getJSONValue((Object)pSDevSlnMSDepResBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDepResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDepResBase.getCreateDate() != null) {
            object = pSDevSlnMSDepResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepResBase.getCreateMan() != null) {
            object = pSDevSlnMSDepResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getMemo() != null) {
            object = pSDevSlnMSDepResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnId() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResId() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnMSDepResId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResName() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnMSDepResName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnName() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnResId() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnResId();
            xmlNode.setAttribute(FIELD_PSDEVSLNRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnResName() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnResName();
            xmlNode.setAttribute(FIELD_PSDEVSLNRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnMSDepResBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getResParams() != null) {
            object = pSDevSlnMSDepResBase.getResParams();
            xmlNode.setAttribute(FIELD_RESPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUpdateDate() != null) {
            object = pSDevSlnMSDepResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepResBase.getUpdateMan() != null) {
            object = pSDevSlnMSDepResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUserCat() != null) {
            object = pSDevSlnMSDepResBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag() != null) {
            object = pSDevSlnMSDepResBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag2() != null) {
            object = pSDevSlnMSDepResBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag3() != null) {
            object = pSDevSlnMSDepResBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepResBase.getUserTag4() != null) {
            object = pSDevSlnMSDepResBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDepResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDepResBase.isCreateDateDirty() && (bl || pSDevSlnMSDepResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDepResBase.getCreateDate());
        }
        if (pSDevSlnMSDepResBase.isCreateManDirty() && (bl || pSDevSlnMSDepResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDepResBase.getCreateMan());
        }
        if (pSDevSlnMSDepResBase.isMemoDirty() && (bl || pSDevSlnMSDepResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDepResBase.getMemo());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnIdDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnMSDepResBase.getPSDevSlnId());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnMSDepResBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnMSDepResBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnMSDepResIdDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPRESID, (Object)pSDevSlnMSDepResBase.getPSDevSlnMSDepResId());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnMSDepResNameDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnMSDepResName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPRESNAME, (Object)pSDevSlnMSDepResBase.getPSDevSlnMSDepResName());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnNameDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnMSDepResBase.getPSDevSlnName());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnResIdDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnResId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRESID, (Object)pSDevSlnMSDepResBase.getPSDevSlnResId());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnResNameDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnResName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRESNAME, (Object)pSDevSlnMSDepResBase.getPSDevSlnResName());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnMSDepResBase.getPSDevSlnSysId());
        }
        if (pSDevSlnMSDepResBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnMSDepResBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnMSDepResBase.getPSDevSlnSysName());
        }
        if (pSDevSlnMSDepResBase.isResParamsDirty() && (bl || pSDevSlnMSDepResBase.getResParams() != null)) {
            iDataObject.set(FIELD_RESPARAMS, (Object)pSDevSlnMSDepResBase.getResParams());
        }
        if (pSDevSlnMSDepResBase.isUpdateDateDirty() && (bl || pSDevSlnMSDepResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDepResBase.getUpdateDate());
        }
        if (pSDevSlnMSDepResBase.isUpdateManDirty() && (bl || pSDevSlnMSDepResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDepResBase.getUpdateMan());
        }
        if (pSDevSlnMSDepResBase.isUserCatDirty() && (bl || pSDevSlnMSDepResBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnMSDepResBase.getUserCat());
        }
        if (pSDevSlnMSDepResBase.isUserTagDirty() && (bl || pSDevSlnMSDepResBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnMSDepResBase.getUserTag());
        }
        if (pSDevSlnMSDepResBase.isUserTag2Dirty() && (bl || pSDevSlnMSDepResBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnMSDepResBase.getUserTag2());
        }
        if (pSDevSlnMSDepResBase.isUserTag3Dirty() && (bl || pSDevSlnMSDepResBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnMSDepResBase.getUserTag3());
        }
        if (pSDevSlnMSDepResBase.isUserTag4Dirty() && (bl || pSDevSlnMSDepResBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnMSDepResBase.getUserTag4());
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
        return PSDevSlnMSDepResBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDepResBase pSDevSlnMSDepResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnMSDepResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnMSDepResBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnMSDepResBase.resetPSDevSlnId();
                return true;
            }
            case 4: {
                pSDevSlnMSDepResBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 5: {
                pSDevSlnMSDepResBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 6: {
                pSDevSlnMSDepResBase.resetPSDevSlnMSDepResId();
                return true;
            }
            case 7: {
                pSDevSlnMSDepResBase.resetPSDevSlnMSDepResName();
                return true;
            }
            case 8: {
                pSDevSlnMSDepResBase.resetPSDevSlnName();
                return true;
            }
            case 9: {
                pSDevSlnMSDepResBase.resetPSDevSlnResId();
                return true;
            }
            case 10: {
                pSDevSlnMSDepResBase.resetPSDevSlnResName();
                return true;
            }
            case 11: {
                pSDevSlnMSDepResBase.resetPSDevSlnSysId();
                return true;
            }
            case 12: {
                pSDevSlnMSDepResBase.resetPSDevSlnSysName();
                return true;
            }
            case 13: {
                pSDevSlnMSDepResBase.resetResParams();
                return true;
            }
            case 14: {
                pSDevSlnMSDepResBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevSlnMSDepResBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDevSlnMSDepResBase.resetUserCat();
                return true;
            }
            case 17: {
                pSDevSlnMSDepResBase.resetUserTag();
                return true;
            }
            case 18: {
                pSDevSlnMSDepResBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSDevSlnMSDepResBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSDevSlnMSDepResBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDeploy getPSDevSlnMSDeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploy();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDeployLock;
        synchronized (n) {
            if (this.psdevslnmsdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDeployId(), (Object)this.psdevslnmsdeploy.getPSDevSlnMSDeployId()) != 0L) {
                this.psdevslnmsdeploy = null;
            }
            if (this.psdevslnmsdeploy == null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy = new PSDevSlnMSDeploy();
                pSDevSlnMSDeploy.setPSDevSlnMSDeployId(this.getPSDevSlnMSDeployId());
                PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDeployService.autoGet((IEntity)pSDevSlnMSDeploy);
                this.psdevslnmsdeploy = pSDevSlnMSDeploy;
            }
            return this.psdevslnmsdeploy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnRes getPSDevSlnRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnRes();
        }
        if (this.getPSDevSlnResId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnResLock;
        synchronized (n) {
            if (this.psdevslnres != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnResId(), (Object)this.psdevslnres.getPSDevSlnResId()) != 0L) {
                this.psdevslnres = null;
            }
            if (this.psdevslnres == null) {
                PSDevSlnRes pSDevSlnRes = new PSDevSlnRes();
                pSDevSlnRes.setPSDevSlnResId(this.getPSDevSlnResId());
                PSDevSlnResService pSDevSlnResService = (PSDevSlnResService)ServiceGlobal.getService(PSDevSlnResService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnResService.autoGet((IEntity)pSDevSlnRes);
                this.psdevslnres = pSDevSlnRes;
            }
            return this.psdevslnres;
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
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnMSDepResBase getProxyEntity() {
        return this.proxyPSDevSlnMSDepResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDepResBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDepResBase) {
            this.proxyPSDevSlnMSDepResBase = (PSDevSlnMSDepResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPRESID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPRESNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNRESID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNRESNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 12);
        fieldIndexMap.put(FIELD_RESPARAMS, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
    }
}

