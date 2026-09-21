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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepFuncItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncItemBase.class);
    public static final String FIELD_AUTHCHECKTOKENURI = "AUTHCHECKTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCITEMID = "PSDEVSLNMSDEPFUNCITEMID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCITEMNAME = "PSDEVSLNMSDEPFUNCITEMNAME";
    public static final String FIELD_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AUTHCHECKTOKENURI = 0;
    private static final int INDEX_AUTHCLIENTID = 1;
    private static final int INDEX_AUTHCLIENTSECRET = 2;
    private static final int INDEX_AUTHMODE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_ITEMTYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEVSLNMSDEPFUNCID = 8;
    private static final int INDEX_PSDEVSLNMSDEPFUNCITEMID = 9;
    private static final int INDEX_PSDEVSLNMSDEPFUNCITEMNAME = 10;
    private static final int INDEX_PSDEVSLNMSDEPFUNCNAME = 11;
    private static final int INDEX_PSDEVSLNSYSAPIID = 12;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 13;
    private static final int INDEX_PSDEVSLNSYSAPPID = 14;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 15;
    private static final int INDEX_PSSYSAPPID = 16;
    private static final int INDEX_PSSYSSERVICEAPIID = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDepFuncItemBase proxyPSDevSlnMSDepFuncItemBase = null;
    private boolean authchecktokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnmsdepfuncidDirtyFlag = false;
    private boolean psdevslnmsdepfuncitemidDirtyFlag = false;
    private boolean psdevslnmsdepfuncitemnameDirtyFlag = false;
    private boolean psdevslnmsdepfuncnameDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="authchecktokenuri")
    private String authchecktokenuri;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authmode")
    private String authmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnmsdepfuncid")
    private String psdevslnmsdepfuncid;
    @Column(name="psdevslnmsdepfuncitemid")
    private String psdevslnmsdepfuncitemid;
    @Column(name="psdevslnmsdepfuncitemname")
    private String psdevslnmsdepfuncitemname;
    @Column(name="psdevslnmsdepfuncname")
    private String psdevslnmsdepfuncname;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevSlnMSDepFuncLock = new Integer(1);
    private PSDevSlnMSDepFunc psdevslnmsdepfunc = null;
    private Integer objPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI psdevslnsysapi = null;
    private Integer objPSDevSlnSysAppLock = new Integer(1);
    private PSDevSlnSysApp psdevslnsysapp = null;

    public void setAuthCheckTokenUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthCheckTokenUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authchecktokenuri = string;
        this.authchecktokenuriDirtyFlag = true;
    }

    public String getAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthCheckTokenUri();
        }
        return this.authchecktokenuri;
    }

    public boolean isAuthCheckTokenUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthCheckTokenUriDirty();
        }
        return this.authchecktokenuriDirtyFlag;
    }

    public void resetAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthCheckTokenUri();
            return;
        }
        this.authchecktokenuriDirtyFlag = false;
        this.authchecktokenuri = null;
    }

    public void setAuthClientId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientid = string;
        this.authclientidDirtyFlag = true;
    }

    public String getAuthClientId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientId();
        }
        return this.authclientid;
    }

    public boolean isAuthClientIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientIdDirty();
        }
        return this.authclientidDirtyFlag;
    }

    public void resetAuthClientId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientId();
            return;
        }
        this.authclientidDirtyFlag = false;
        this.authclientid = null;
    }

    public void setAuthClientSecret(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientSecret(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientsecret = string;
        this.authclientsecretDirtyFlag = true;
    }

    public String getAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientSecret();
        }
        return this.authclientsecret;
    }

    public boolean isAuthClientSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientSecretDirty();
        }
        return this.authclientsecretDirtyFlag;
    }

    public void resetAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientSecret();
            return;
        }
        this.authclientsecretDirtyFlag = false;
        this.authclientsecret = null;
    }

    public void setAuthMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authmode = string;
        this.authmodeDirtyFlag = true;
    }

    public String getAuthMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthMode();
        }
        return this.authmode;
    }

    public boolean isAuthModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthModeDirty();
        }
        return this.authmodeDirtyFlag;
    }

    public void resetAuthMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthMode();
            return;
        }
        this.authmodeDirtyFlag = false;
        this.authmode = null;
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

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
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

    public void setPSDevSlnMSDepFuncItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncitemid = string;
        this.psdevslnmsdepfuncitemidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncItemId();
        }
        return this.psdevslnmsdepfuncitemid;
    }

    public boolean isPSDevSlnMSDepFuncItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncItemIdDirty();
        }
        return this.psdevslnmsdepfuncitemidDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncItemId();
            return;
        }
        this.psdevslnmsdepfuncitemidDirtyFlag = false;
        this.psdevslnmsdepfuncitemid = null;
    }

    public void setPSDevSlnMSDepFuncItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncitemname = string;
        this.psdevslnmsdepfuncitemnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncItemName();
        }
        return this.psdevslnmsdepfuncitemname;
    }

    public boolean isPSDevSlnMSDepFuncItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncItemNameDirty();
        }
        return this.psdevslnmsdepfuncitemnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncItemName();
            return;
        }
        this.psdevslnmsdepfuncitemnameDirtyFlag = false;
        this.psdevslnmsdepfuncitemname = null;
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

    public void setPSDevSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiid = string;
        this.psdevslnsysapiidDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIId();
        }
        return this.psdevslnsysapiid;
    }

    public boolean isPSDevSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPIIdDirty();
        }
        return this.psdevslnsysapiidDirtyFlag;
    }

    public void resetPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIId();
            return;
        }
        this.psdevslnsysapiidDirtyFlag = false;
        this.psdevslnsysapiid = null;
    }

    public void setPSDevSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiname = string;
        this.psdevslnsysapinameDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIName();
        }
        return this.psdevslnsysapiname;
    }

    public boolean isPSDevSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPINameDirty();
        }
        return this.psdevslnsysapinameDirtyFlag;
    }

    public void resetPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIName();
            return;
        }
        this.psdevslnsysapinameDirtyFlag = false;
        this.psdevslnsysapiname = null;
    }

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSDevSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappname = string;
        this.psdevslnsysappnameDirtyFlag = true;
    }

    public String getPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppName();
        }
        return this.psdevslnsysappname;
    }

    public boolean isPSDevSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppNameDirty();
        }
        return this.psdevslnsysappnameDirtyFlag;
    }

    public void resetPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppName();
            return;
        }
        this.psdevslnsysappnameDirtyFlag = false;
        this.psdevslnsysappname = null;
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
        PSDevSlnMSDepFuncItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase) {
        pSDevSlnMSDepFuncItemBase.resetAuthCheckTokenUri();
        pSDevSlnMSDepFuncItemBase.resetAuthClientId();
        pSDevSlnMSDepFuncItemBase.resetAuthClientSecret();
        pSDevSlnMSDepFuncItemBase.resetAuthMode();
        pSDevSlnMSDepFuncItemBase.resetCreateDate();
        pSDevSlnMSDepFuncItemBase.resetCreateMan();
        pSDevSlnMSDepFuncItemBase.resetItemType();
        pSDevSlnMSDepFuncItemBase.resetMemo();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncId();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncItemId();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncItemName();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncName();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAPIId();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAPIName();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAppId();
        pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAppName();
        pSDevSlnMSDepFuncItemBase.resetPSSysAppId();
        pSDevSlnMSDepFuncItemBase.resetPSSysServiceAPIId();
        pSDevSlnMSDepFuncItemBase.resetUpdateDate();
        pSDevSlnMSDepFuncItemBase.resetUpdateMan();
        pSDevSlnMSDepFuncItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAuthCheckTokenUriDirty()) {
            hashMap.put(FIELD_AUTHCHECKTOKENURI, this.getAuthCheckTokenUri());
        }
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthModeDirty()) {
            hashMap.put(FIELD_AUTHMODE, this.getAuthMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnMSDepFuncIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCID, this.getPSDevSlnMSDepFuncId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncItemIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCITEMID, this.getPSDevSlnMSDepFuncItemId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncItemNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCITEMNAME, this.getPSDevSlnMSDepFuncItemName());
        }
        if (!bl || this.isPSDevSlnMSDepFuncNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, this.getPSDevSlnMSDepFuncName());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSDevSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPNAME, this.getPSDevSlnSysAppName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
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
        return PSDevSlnMSDepFuncItemBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri();
            }
            case 1: {
                return pSDevSlnMSDepFuncItemBase.getAuthClientId();
            }
            case 2: {
                return pSDevSlnMSDepFuncItemBase.getAuthClientSecret();
            }
            case 3: {
                return pSDevSlnMSDepFuncItemBase.getAuthMode();
            }
            case 4: {
                return pSDevSlnMSDepFuncItemBase.getCreateDate();
            }
            case 5: {
                return pSDevSlnMSDepFuncItemBase.getCreateMan();
            }
            case 6: {
                return pSDevSlnMSDepFuncItemBase.getItemType();
            }
            case 7: {
                return pSDevSlnMSDepFuncItemBase.getMemo();
            }
            case 8: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId();
            }
            case 9: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId();
            }
            case 10: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName();
            }
            case 11: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName();
            }
            case 12: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId();
            }
            case 13: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName();
            }
            case 14: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId();
            }
            case 15: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName();
            }
            case 16: {
                return pSDevSlnMSDepFuncItemBase.getPSSysAppId();
            }
            case 17: {
                return pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId();
            }
            case 18: {
                return pSDevSlnMSDepFuncItemBase.getUpdateDate();
            }
            case 19: {
                return pSDevSlnMSDepFuncItemBase.getUpdateMan();
            }
            case 20: {
                return pSDevSlnMSDepFuncItemBase.getValidFlag();
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
        PSDevSlnMSDepFuncItemBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepFuncItemBase.setAuthCheckTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDepFuncItemBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDepFuncItemBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDepFuncItemBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDepFuncItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDepFuncItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDepFuncItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDepFuncItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnMSDepFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnMSDepFuncItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnMSDepFuncItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnMSDepFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDepFuncItemBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDepFuncItemBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDepFuncItemBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnMSDepFuncItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnMSDepFuncItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnMSDepFuncItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnMSDepFuncItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri() == null;
            }
            case 1: {
                return pSDevSlnMSDepFuncItemBase.getAuthClientId() == null;
            }
            case 2: {
                return pSDevSlnMSDepFuncItemBase.getAuthClientSecret() == null;
            }
            case 3: {
                return pSDevSlnMSDepFuncItemBase.getAuthMode() == null;
            }
            case 4: {
                return pSDevSlnMSDepFuncItemBase.getCreateDate() == null;
            }
            case 5: {
                return pSDevSlnMSDepFuncItemBase.getCreateMan() == null;
            }
            case 6: {
                return pSDevSlnMSDepFuncItemBase.getItemType() == null;
            }
            case 7: {
                return pSDevSlnMSDepFuncItemBase.getMemo() == null;
            }
            case 8: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId() == null;
            }
            case 9: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId() == null;
            }
            case 10: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName() == null;
            }
            case 11: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName() == null;
            }
            case 12: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId() == null;
            }
            case 13: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName() == null;
            }
            case 14: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId() == null;
            }
            case 15: {
                return pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName() == null;
            }
            case 16: {
                return pSDevSlnMSDepFuncItemBase.getPSSysAppId() == null;
            }
            case 17: {
                return pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId() == null;
            }
            case 18: {
                return pSDevSlnMSDepFuncItemBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDevSlnMSDepFuncItemBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDevSlnMSDepFuncItemBase.getValidFlag() == null;
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
        return PSDevSlnMSDepFuncItemBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncItemBase.isAuthCheckTokenUriDirty();
            }
            case 1: {
                return pSDevSlnMSDepFuncItemBase.isAuthClientIdDirty();
            }
            case 2: {
                return pSDevSlnMSDepFuncItemBase.isAuthClientSecretDirty();
            }
            case 3: {
                return pSDevSlnMSDepFuncItemBase.isAuthModeDirty();
            }
            case 4: {
                return pSDevSlnMSDepFuncItemBase.isCreateDateDirty();
            }
            case 5: {
                return pSDevSlnMSDepFuncItemBase.isCreateManDirty();
            }
            case 6: {
                return pSDevSlnMSDepFuncItemBase.isItemTypeDirty();
            }
            case 7: {
                return pSDevSlnMSDepFuncItemBase.isMemoDirty();
            }
            case 8: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncIdDirty();
            }
            case 9: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncItemIdDirty();
            }
            case 10: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncItemNameDirty();
            }
            case 11: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncNameDirty();
            }
            case 12: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAPIIdDirty();
            }
            case 13: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAPINameDirty();
            }
            case 14: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAppIdDirty();
            }
            case 15: {
                return pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAppNameDirty();
            }
            case 16: {
                return pSDevSlnMSDepFuncItemBase.isPSSysAppIdDirty();
            }
            case 17: {
                return pSDevSlnMSDepFuncItemBase.isPSSysServiceAPIIdDirty();
            }
            case 18: {
                return pSDevSlnMSDepFuncItemBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDevSlnMSDepFuncItemBase.isUpdateManDirty();
            }
            case 20: {
                return pSDevSlnMSDepFuncItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDepFuncItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authchecktokenuri", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncitemid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncitemname", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncname", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnMSDepFuncItemBase.getJSONValue((Object)pSDevSlnMSDepFuncItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDepFuncItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri() != null) {
            object = pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri();
            xmlNode.setAttribute(FIELD_AUTHCHECKTOKENURI, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthClientId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthClientSecret() != null) {
            object = pSDevSlnMSDepFuncItemBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getAuthMode() != null) {
            object = pSDevSlnMSDepFuncItemBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getCreateDate() != null) {
            object = pSDevSlnMSDepFuncItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getCreateMan() != null) {
            object = pSDevSlnMSDepFuncItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getItemType() != null) {
            object = pSDevSlnMSDepFuncItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getMemo() != null) {
            object = pSDevSlnMSDepFuncItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSSysAppId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId() != null) {
            object = pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getUpdateDate() != null) {
            object = pSDevSlnMSDepFuncItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getUpdateMan() != null) {
            object = pSDevSlnMSDepFuncItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncItemBase.getValidFlag() != null) {
            object = pSDevSlnMSDepFuncItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDepFuncItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDepFuncItemBase.isAuthCheckTokenUriDirty() && (bl || pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHCHECKTOKENURI, (Object)pSDevSlnMSDepFuncItemBase.getAuthCheckTokenUri());
        }
        if (pSDevSlnMSDepFuncItemBase.isAuthClientIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSDevSlnMSDepFuncItemBase.getAuthClientId());
        }
        if (pSDevSlnMSDepFuncItemBase.isAuthClientSecretDirty() && (bl || pSDevSlnMSDepFuncItemBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSDevSlnMSDepFuncItemBase.getAuthClientSecret());
        }
        if (pSDevSlnMSDepFuncItemBase.isAuthModeDirty() && (bl || pSDevSlnMSDepFuncItemBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSDevSlnMSDepFuncItemBase.getAuthMode());
        }
        if (pSDevSlnMSDepFuncItemBase.isCreateDateDirty() && (bl || pSDevSlnMSDepFuncItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDepFuncItemBase.getCreateDate());
        }
        if (pSDevSlnMSDepFuncItemBase.isCreateManDirty() && (bl || pSDevSlnMSDepFuncItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDepFuncItemBase.getCreateMan());
        }
        if (pSDevSlnMSDepFuncItemBase.isItemTypeDirty() && (bl || pSDevSlnMSDepFuncItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSDevSlnMSDepFuncItemBase.getItemType());
        }
        if (pSDevSlnMSDepFuncItemBase.isMemoDirty() && (bl || pSDevSlnMSDepFuncItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDepFuncItemBase.getMemo());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCID, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncId());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncItemIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCITEMID, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemId());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncItemNameDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCITEMNAME, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncItemName());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnMSDepFuncNameDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCNAME, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnMSDepFuncName());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAPIIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIId());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAPINameDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAPIName());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAppIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppId());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSDevSlnSysAppNameDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDevSlnMSDepFuncItemBase.getPSDevSlnSysAppName());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSSysAppIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDevSlnMSDepFuncItemBase.getPSSysAppId());
        }
        if (pSDevSlnMSDepFuncItemBase.isPSSysServiceAPIIdDirty() && (bl || pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDevSlnMSDepFuncItemBase.getPSSysServiceAPIId());
        }
        if (pSDevSlnMSDepFuncItemBase.isUpdateDateDirty() && (bl || pSDevSlnMSDepFuncItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDepFuncItemBase.getUpdateDate());
        }
        if (pSDevSlnMSDepFuncItemBase.isUpdateManDirty() && (bl || pSDevSlnMSDepFuncItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDepFuncItemBase.getUpdateMan());
        }
        if (pSDevSlnMSDepFuncItemBase.isValidFlagDirty() && (bl || pSDevSlnMSDepFuncItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnMSDepFuncItemBase.getValidFlag());
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
        return PSDevSlnMSDepFuncItemBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDepFuncItemBase pSDevSlnMSDepFuncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepFuncItemBase.resetAuthCheckTokenUri();
                return true;
            }
            case 1: {
                pSDevSlnMSDepFuncItemBase.resetAuthClientId();
                return true;
            }
            case 2: {
                pSDevSlnMSDepFuncItemBase.resetAuthClientSecret();
                return true;
            }
            case 3: {
                pSDevSlnMSDepFuncItemBase.resetAuthMode();
                return true;
            }
            case 4: {
                pSDevSlnMSDepFuncItemBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDevSlnMSDepFuncItemBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDevSlnMSDepFuncItemBase.resetItemType();
                return true;
            }
            case 7: {
                pSDevSlnMSDepFuncItemBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncId();
                return true;
            }
            case 9: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncItemId();
                return true;
            }
            case 10: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncItemName();
                return true;
            }
            case 11: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnMSDepFuncName();
                return true;
            }
            case 12: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 13: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 14: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 15: {
                pSDevSlnMSDepFuncItemBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 16: {
                pSDevSlnMSDepFuncItemBase.resetPSSysAppId();
                return true;
            }
            case 17: {
                pSDevSlnMSDepFuncItemBase.resetPSSysServiceAPIId();
                return true;
            }
            case 18: {
                pSDevSlnMSDepFuncItemBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDevSlnMSDepFuncItemBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDevSlnMSDepFuncItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDevSlnMSDepFuncService.autoGet((IEntity)pSDevSlnMSDepFunc);
                this.psdevslnmsdepfunc = pSDevSlnMSDepFunc;
            }
            return this.psdevslnmsdepfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysAPI getPSDevSlnSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPI();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAPILock;
        synchronized (n) {
            if (this.psdevslnsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAPIId(), (Object)this.psdevslnsysapi.getPSDevSlnSysAPIId()) != 0L) {
                this.psdevslnsysapi = null;
            }
            if (this.psdevslnsysapi == null) {
                PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
                pSDevSlnSysAPI.setPSDevSlnSysAPIId(this.getPSDevSlnSysAPIId());
                PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAPIService.autoGet((IEntity)pSDevSlnSysAPI);
                this.psdevslnsysapi = pSDevSlnSysAPI;
            }
            return this.psdevslnsysapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysApp getPSDevSlnSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysApp();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAppLock;
        synchronized (n) {
            if (this.psdevslnsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAppId(), (Object)this.psdevslnsysapp.getPSDevSlnSysAppId()) != 0L) {
                this.psdevslnsysapp = null;
            }
            if (this.psdevslnsysapp == null) {
                PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
                pSDevSlnSysApp.setPSDevSlnSysAppId(this.getPSDevSlnSysAppId());
                PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAppService.autoGet((IEntity)pSDevSlnSysApp);
                this.psdevslnsysapp = pSDevSlnSysApp;
            }
            return this.psdevslnsysapp;
        }
    }

    private PSDevSlnMSDepFuncItemBase getProxyEntity() {
        return this.proxyPSDevSlnMSDepFuncItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDepFuncItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDepFuncItemBase) {
            this.proxyPSDevSlnMSDepFuncItemBase = (PSDevSlnMSDepFuncItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHCHECKTOKENURI, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 1);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 2);
        fieldIndexMap.put(FIELD_AUTHMODE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_ITEMTYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCITEMID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 16);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

