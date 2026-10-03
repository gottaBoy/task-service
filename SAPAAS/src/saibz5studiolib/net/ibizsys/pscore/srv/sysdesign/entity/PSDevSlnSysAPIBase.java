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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysAPIBase.class);
    public static final String FIELD_APILEVEL = "APILEVEL";
    public static final String FIELD_APIMDURL = "APIMDURL";
    public static final String FIELD_APIMODE = "APIMODE";
    public static final String FIELD_APITAG = "APITAG";
    public static final String FIELD_APITAG2 = "APITAG2";
    public static final String FIELD_APITYPE = "APITYPE";
    public static final String FIELD_CFGMODEL = "CFGMODEL";
    public static final String FIELD_CLIENT2PSDEVSLNSYSID = "CLIENT2PSDEVSLNSYSID";
    public static final String FIELD_CLIENT2PSDEVSLNSYSNAME = "CLIENT2PSDEVSLNSYSNAME";
    public static final String FIELD_CLIENTPSDEVSLNSYSID = "CLIENTPSDEVSLNSYSID";
    public static final String FIELD_CLIENTPSDEVSLNSYSNAME = "CLIENTPSDEVSLNSYSNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVSYSSTATE = "DEVSYSSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_APILEVEL = 0;
    private static final int INDEX_APIMDURL = 1;
    private static final int INDEX_APIMODE = 2;
    private static final int INDEX_APITAG = 3;
    private static final int INDEX_APITAG2 = 4;
    private static final int INDEX_APITYPE = 5;
    private static final int INDEX_CFGMODEL = 6;
    private static final int INDEX_CLIENT2PSDEVSLNSYSID = 7;
    private static final int INDEX_CLIENT2PSDEVSLNSYSNAME = 8;
    private static final int INDEX_CLIENTPSDEVSLNSYSID = 9;
    private static final int INDEX_CLIENTPSDEVSLNSYSNAME = 10;
    private static final int INDEX_CODENAME = 11;
    private static final int INDEX_CREATEDATE = 12;
    private static final int INDEX_CREATEMAN = 13;
    private static final int INDEX_DEVSYSSTATE = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PSDEVSLNID = 16;
    private static final int INDEX_PSDEVSLNSYSAPIID = 17;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 18;
    private static final int INDEX_PSDEVSLNSYSID = 19;
    private static final int INDEX_PSDEVSLNSYSNAME = 20;
    private static final int INDEX_PSSYSSERVICEAPIID = 21;
    private static final int INDEX_PSSYSSERVICEAPINAME = 22;
    private static final int INDEX_SERVICECODENAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final int INDEX_VER = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysAPIBase proxyPSDevSlnSysAPIBase = null;
    private boolean apilevelDirtyFlag = false;
    private boolean apimdurlDirtyFlag = false;
    private boolean apimodeDirtyFlag = false;
    private boolean apitagDirtyFlag = false;
    private boolean apitag2DirtyFlag = false;
    private boolean apitypeDirtyFlag = false;
    private boolean cfgmodelDirtyFlag = false;
    private boolean client2psdevslnsysidDirtyFlag = false;
    private boolean client2psdevslnsysnameDirtyFlag = false;
    private boolean clientpsdevslnsysidDirtyFlag = false;
    private boolean clientpsdevslnsysnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devsysstateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="apilevel")
    private Integer apilevel;
    @Column(name="apimdurl")
    private String apimdurl;
    @Column(name="apimode")
    private Integer apimode;
    @Column(name="apitag")
    private String apitag;
    @Column(name="apitag2")
    private String apitag2;
    @Column(name="apitype")
    private String apitype;
    @Column(name="cfgmodel")
    private String cfgmodel;
    @Column(name="client2psdevslnsysid")
    private String client2psdevslnsysid;
    @Column(name="client2psdevslnsysname")
    private String client2psdevslnsysname;
    @Column(name="clientpsdevslnsysid")
    private String clientpsdevslnsysid;
    @Column(name="clientpsdevslnsysname")
    private String clientpsdevslnsysname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devsysstate")
    private Integer devsysstate;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="ver")
    private Integer ver;
    private Integer objClient2PSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys client2psdevslnsys = null;
    private Integer objClientPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys clientpsdevslnsys = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSDevSlnMSDepAPIsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepAPI> psdevslnmsdepapis = null;
    private Integer objPSDevSlnMSDepFuncItemsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepFuncItem> psdevslnmsdepfuncitems = null;
    private Integer objPSDevSlnPipelineStepsLock = new Integer(1);
    private ArrayList<PSDevSlnPipelineStep> psdevslnpipelinesteps = null;
    private Integer objPSDevSlnSysRefsLock = new Integer(1);
    private ArrayList<PSDevSlnSysRef> psdevslnsysrefs = null;
    private Integer objPSSubSysServiceAPIsLock = new Integer(1);
    private ArrayList<PSSubSysServiceAPI> pssubsysserviceapis = null;

    public void setAPILevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPILevel(n);
            return;
        }
        this.apilevel = n;
        this.apilevelDirtyFlag = true;
    }

    public Integer getAPILevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPILevel();
        }
        return this.apilevel;
    }

    public boolean isAPILevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPILevelDirty();
        }
        return this.apilevelDirtyFlag;
    }

    public void resetAPILevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPILevel();
            return;
        }
        this.apilevelDirtyFlag = false;
        this.apilevel = null;
    }

    public void setAPIMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apimdurl = string;
        this.apimdurlDirtyFlag = true;
    }

    public String getAPIMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIMDUrl();
        }
        return this.apimdurl;
    }

    public boolean isAPIMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIMDUrlDirty();
        }
        return this.apimdurlDirtyFlag;
    }

    public void resetAPIMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIMDUrl();
            return;
        }
        this.apimdurlDirtyFlag = false;
        this.apimdurl = null;
    }

    public void setAPIMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIMode(n);
            return;
        }
        this.apimode = n;
        this.apimodeDirtyFlag = true;
    }

    public Integer getAPIMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIMode();
        }
        return this.apimode;
    }

    public boolean isAPIModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIModeDirty();
        }
        return this.apimodeDirtyFlag;
    }

    public void resetAPIMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIMode();
            return;
        }
        this.apimodeDirtyFlag = false;
        this.apimode = null;
    }

    public void setAPITag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag = string;
        this.apitagDirtyFlag = true;
    }

    public String getAPITag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag();
        }
        return this.apitag;
    }

    public boolean isAPITagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITagDirty();
        }
        return this.apitagDirtyFlag;
    }

    public void resetAPITag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag();
            return;
        }
        this.apitagDirtyFlag = false;
        this.apitag = null;
    }

    public void setAPITag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag2 = string;
        this.apitag2DirtyFlag = true;
    }

    public String getAPITag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag2();
        }
        return this.apitag2;
    }

    public boolean isAPITag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITag2Dirty();
        }
        return this.apitag2DirtyFlag;
    }

    public void resetAPITag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag2();
            return;
        }
        this.apitag2DirtyFlag = false;
        this.apitag2 = null;
    }

    public void setAPIType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitype = string;
        this.apitypeDirtyFlag = true;
    }

    public String getAPIType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIType();
        }
        return this.apitype;
    }

    public boolean isAPITypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITypeDirty();
        }
        return this.apitypeDirtyFlag;
    }

    public void resetAPIType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIType();
            return;
        }
        this.apitypeDirtyFlag = false;
        this.apitype = null;
    }

    public void setCfgModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgmodel = string;
        this.cfgmodelDirtyFlag = true;
    }

    public String getCfgModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgModel();
        }
        return this.cfgmodel;
    }

    public boolean isCfgModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgModelDirty();
        }
        return this.cfgmodelDirtyFlag;
    }

    public void resetCfgModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgModel();
            return;
        }
        this.cfgmodelDirtyFlag = false;
        this.cfgmodel = null;
    }

    public void setClient2PSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClient2PSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.client2psdevslnsysid = string;
        this.client2psdevslnsysidDirtyFlag = true;
    }

    public String getClient2PSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClient2PSDevSlnSysId();
        }
        return this.client2psdevslnsysid;
    }

    public boolean isClient2PSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClient2PSDevSlnSysIdDirty();
        }
        return this.client2psdevslnsysidDirtyFlag;
    }

    public void resetClient2PSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClient2PSDevSlnSysId();
            return;
        }
        this.client2psdevslnsysidDirtyFlag = false;
        this.client2psdevslnsysid = null;
    }

    public void setClient2PSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClient2PSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.client2psdevslnsysname = string;
        this.client2psdevslnsysnameDirtyFlag = true;
    }

    public String getClient2PSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClient2PSDevSlnSysName();
        }
        return this.client2psdevslnsysname;
    }

    public boolean isClient2PSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClient2PSDevSlnSysNameDirty();
        }
        return this.client2psdevslnsysnameDirtyFlag;
    }

    public void resetClient2PSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClient2PSDevSlnSysName();
            return;
        }
        this.client2psdevslnsysnameDirtyFlag = false;
        this.client2psdevslnsysname = null;
    }

    public void setClientPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clientpsdevslnsysid = string;
        this.clientpsdevslnsysidDirtyFlag = true;
    }

    public String getClientPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientPSDevSlnSysId();
        }
        return this.clientpsdevslnsysid;
    }

    public boolean isClientPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientPSDevSlnSysIdDirty();
        }
        return this.clientpsdevslnsysidDirtyFlag;
    }

    public void resetClientPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientPSDevSlnSysId();
            return;
        }
        this.clientpsdevslnsysidDirtyFlag = false;
        this.clientpsdevslnsysid = null;
    }

    public void setClientPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clientpsdevslnsysname = string;
        this.clientpsdevslnsysnameDirtyFlag = true;
    }

    public String getClientPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientPSDevSlnSysName();
        }
        return this.clientpsdevslnsysname;
    }

    public boolean isClientPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientPSDevSlnSysNameDirty();
        }
        return this.clientpsdevslnsysnameDirtyFlag;
    }

    public void resetClientPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientPSDevSlnSysName();
            return;
        }
        this.clientpsdevslnsysnameDirtyFlag = false;
        this.clientpsdevslnsysname = null;
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

    public void setDevSysState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSysState(n);
            return;
        }
        this.devsysstate = n;
        this.devsysstateDirtyFlag = true;
    }

    public Integer getDevSysState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSysState();
        }
        return this.devsysstate;
    }

    public boolean isDevSysStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSysStateDirty();
        }
        return this.devsysstateDirtyFlag;
    }

    public void resetDevSysState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSysState();
            return;
        }
        this.devsysstateDirtyFlag = false;
        this.devsysstate = null;
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

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
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

    public void setVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVer(n);
            return;
        }
        this.ver = n;
        this.verDirtyFlag = true;
    }

    public Integer getVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVer();
        }
        return this.ver;
    }

    public boolean isVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDirty();
        }
        return this.verDirtyFlag;
    }

    public void resetVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVer();
            return;
        }
        this.verDirtyFlag = false;
        this.ver = null;
    }

    protected void onReset() {
        PSDevSlnSysAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) {
        pSDevSlnSysAPIBase.resetAPILevel();
        pSDevSlnSysAPIBase.resetAPIMDUrl();
        pSDevSlnSysAPIBase.resetAPIMode();
        pSDevSlnSysAPIBase.resetAPITag();
        pSDevSlnSysAPIBase.resetAPITag2();
        pSDevSlnSysAPIBase.resetAPIType();
        pSDevSlnSysAPIBase.resetCfgModel();
        pSDevSlnSysAPIBase.resetClient2PSDevSlnSysId();
        pSDevSlnSysAPIBase.resetClient2PSDevSlnSysName();
        pSDevSlnSysAPIBase.resetClientPSDevSlnSysId();
        pSDevSlnSysAPIBase.resetClientPSDevSlnSysName();
        pSDevSlnSysAPIBase.resetCodeName();
        pSDevSlnSysAPIBase.resetCreateDate();
        pSDevSlnSysAPIBase.resetCreateMan();
        pSDevSlnSysAPIBase.resetDevSysState();
        pSDevSlnSysAPIBase.resetMemo();
        pSDevSlnSysAPIBase.resetPSDevSlnId();
        pSDevSlnSysAPIBase.resetPSDevSlnSysAPIId();
        pSDevSlnSysAPIBase.resetPSDevSlnSysAPIName();
        pSDevSlnSysAPIBase.resetPSDevSlnSysId();
        pSDevSlnSysAPIBase.resetPSDevSlnSysName();
        pSDevSlnSysAPIBase.resetPSSysServiceAPIId();
        pSDevSlnSysAPIBase.resetPSSysServiceAPIName();
        pSDevSlnSysAPIBase.resetServiceCodeName();
        pSDevSlnSysAPIBase.resetUpdateDate();
        pSDevSlnSysAPIBase.resetUpdateMan();
        pSDevSlnSysAPIBase.resetValidFlag();
        pSDevSlnSysAPIBase.resetVer();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPILevelDirty()) {
            hashMap.put(FIELD_APILEVEL, this.getAPILevel());
        }
        if (!bl || this.isAPIMDUrlDirty()) {
            hashMap.put(FIELD_APIMDURL, this.getAPIMDUrl());
        }
        if (!bl || this.isAPIModeDirty()) {
            hashMap.put(FIELD_APIMODE, this.getAPIMode());
        }
        if (!bl || this.isAPITagDirty()) {
            hashMap.put(FIELD_APITAG, this.getAPITag());
        }
        if (!bl || this.isAPITag2Dirty()) {
            hashMap.put(FIELD_APITAG2, this.getAPITag2());
        }
        if (!bl || this.isAPITypeDirty()) {
            hashMap.put(FIELD_APITYPE, this.getAPIType());
        }
        if (!bl || this.isCfgModelDirty()) {
            hashMap.put(FIELD_CFGMODEL, this.getCfgModel());
        }
        if (!bl || this.isClient2PSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_CLIENT2PSDEVSLNSYSID, this.getClient2PSDevSlnSysId());
        }
        if (!bl || this.isClient2PSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_CLIENT2PSDEVSLNSYSNAME, this.getClient2PSDevSlnSysName());
        }
        if (!bl || this.isClientPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_CLIENTPSDEVSLNSYSID, this.getClientPSDevSlnSysId());
        }
        if (!bl || this.isClientPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_CLIENTPSDEVSLNSYSNAME, this.getClientPSDevSlnSysName());
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
        if (!bl || this.isDevSysStateDirty()) {
            hashMap.put(FIELD_DEVSYSSTATE, this.getDevSysState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
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
        if (!bl || this.isVerDirty()) {
            hashMap.put(FIELD_VER, this.getVer());
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
        return PSDevSlnSysAPIBase.get(this, n);
    }

    private static Object get(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAPIBase.getAPILevel();
            }
            case 1: {
                return pSDevSlnSysAPIBase.getAPIMDUrl();
            }
            case 2: {
                return pSDevSlnSysAPIBase.getAPIMode();
            }
            case 3: {
                return pSDevSlnSysAPIBase.getAPITag();
            }
            case 4: {
                return pSDevSlnSysAPIBase.getAPITag2();
            }
            case 5: {
                return pSDevSlnSysAPIBase.getAPIType();
            }
            case 6: {
                return pSDevSlnSysAPIBase.getCfgModel();
            }
            case 7: {
                return pSDevSlnSysAPIBase.getClient2PSDevSlnSysId();
            }
            case 8: {
                return pSDevSlnSysAPIBase.getClient2PSDevSlnSysName();
            }
            case 9: {
                return pSDevSlnSysAPIBase.getClientPSDevSlnSysId();
            }
            case 10: {
                return pSDevSlnSysAPIBase.getClientPSDevSlnSysName();
            }
            case 11: {
                return pSDevSlnSysAPIBase.getCodeName();
            }
            case 12: {
                return pSDevSlnSysAPIBase.getCreateDate();
            }
            case 13: {
                return pSDevSlnSysAPIBase.getCreateMan();
            }
            case 14: {
                return pSDevSlnSysAPIBase.getDevSysState();
            }
            case 15: {
                return pSDevSlnSysAPIBase.getMemo();
            }
            case 16: {
                return pSDevSlnSysAPIBase.getPSDevSlnId();
            }
            case 17: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysAPIId();
            }
            case 18: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysAPIName();
            }
            case 19: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysId();
            }
            case 20: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysName();
            }
            case 21: {
                return pSDevSlnSysAPIBase.getPSSysServiceAPIId();
            }
            case 22: {
                return pSDevSlnSysAPIBase.getPSSysServiceAPIName();
            }
            case 23: {
                return pSDevSlnSysAPIBase.getServiceCodeName();
            }
            case 24: {
                return pSDevSlnSysAPIBase.getUpdateDate();
            }
            case 25: {
                return pSDevSlnSysAPIBase.getUpdateMan();
            }
            case 26: {
                return pSDevSlnSysAPIBase.getValidFlag();
            }
            case 27: {
                return pSDevSlnSysAPIBase.getVer();
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
        PSDevSlnSysAPIBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysAPIBase.setAPILevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysAPIBase.setAPIMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysAPIBase.setAPIMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysAPIBase.setAPITag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysAPIBase.setAPITag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysAPIBase.setAPIType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysAPIBase.setCfgModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysAPIBase.setClient2PSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysAPIBase.setClient2PSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysAPIBase.setClientPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysAPIBase.setClientPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysAPIBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysAPIBase.setDevSysState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysAPIBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysAPIBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysAPIBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysAPIBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysAPIBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysAPIBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysAPIBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysAPIBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysAPIBase.setVer(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAPIBase.getAPILevel() == null;
            }
            case 1: {
                return pSDevSlnSysAPIBase.getAPIMDUrl() == null;
            }
            case 2: {
                return pSDevSlnSysAPIBase.getAPIMode() == null;
            }
            case 3: {
                return pSDevSlnSysAPIBase.getAPITag() == null;
            }
            case 4: {
                return pSDevSlnSysAPIBase.getAPITag2() == null;
            }
            case 5: {
                return pSDevSlnSysAPIBase.getAPIType() == null;
            }
            case 6: {
                return pSDevSlnSysAPIBase.getCfgModel() == null;
            }
            case 7: {
                return pSDevSlnSysAPIBase.getClient2PSDevSlnSysId() == null;
            }
            case 8: {
                return pSDevSlnSysAPIBase.getClient2PSDevSlnSysName() == null;
            }
            case 9: {
                return pSDevSlnSysAPIBase.getClientPSDevSlnSysId() == null;
            }
            case 10: {
                return pSDevSlnSysAPIBase.getClientPSDevSlnSysName() == null;
            }
            case 11: {
                return pSDevSlnSysAPIBase.getCodeName() == null;
            }
            case 12: {
                return pSDevSlnSysAPIBase.getCreateDate() == null;
            }
            case 13: {
                return pSDevSlnSysAPIBase.getCreateMan() == null;
            }
            case 14: {
                return pSDevSlnSysAPIBase.getDevSysState() == null;
            }
            case 15: {
                return pSDevSlnSysAPIBase.getMemo() == null;
            }
            case 16: {
                return pSDevSlnSysAPIBase.getPSDevSlnId() == null;
            }
            case 17: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysAPIId() == null;
            }
            case 18: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysAPIName() == null;
            }
            case 19: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysId() == null;
            }
            case 20: {
                return pSDevSlnSysAPIBase.getPSDevSlnSysName() == null;
            }
            case 21: {
                return pSDevSlnSysAPIBase.getPSSysServiceAPIId() == null;
            }
            case 22: {
                return pSDevSlnSysAPIBase.getPSSysServiceAPIName() == null;
            }
            case 23: {
                return pSDevSlnSysAPIBase.getServiceCodeName() == null;
            }
            case 24: {
                return pSDevSlnSysAPIBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDevSlnSysAPIBase.getUpdateMan() == null;
            }
            case 26: {
                return pSDevSlnSysAPIBase.getValidFlag() == null;
            }
            case 27: {
                return pSDevSlnSysAPIBase.getVer() == null;
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
        return PSDevSlnSysAPIBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAPIBase.isAPILevelDirty();
            }
            case 1: {
                return pSDevSlnSysAPIBase.isAPIMDUrlDirty();
            }
            case 2: {
                return pSDevSlnSysAPIBase.isAPIModeDirty();
            }
            case 3: {
                return pSDevSlnSysAPIBase.isAPITagDirty();
            }
            case 4: {
                return pSDevSlnSysAPIBase.isAPITag2Dirty();
            }
            case 5: {
                return pSDevSlnSysAPIBase.isAPITypeDirty();
            }
            case 6: {
                return pSDevSlnSysAPIBase.isCfgModelDirty();
            }
            case 7: {
                return pSDevSlnSysAPIBase.isClient2PSDevSlnSysIdDirty();
            }
            case 8: {
                return pSDevSlnSysAPIBase.isClient2PSDevSlnSysNameDirty();
            }
            case 9: {
                return pSDevSlnSysAPIBase.isClientPSDevSlnSysIdDirty();
            }
            case 10: {
                return pSDevSlnSysAPIBase.isClientPSDevSlnSysNameDirty();
            }
            case 11: {
                return pSDevSlnSysAPIBase.isCodeNameDirty();
            }
            case 12: {
                return pSDevSlnSysAPIBase.isCreateDateDirty();
            }
            case 13: {
                return pSDevSlnSysAPIBase.isCreateManDirty();
            }
            case 14: {
                return pSDevSlnSysAPIBase.isDevSysStateDirty();
            }
            case 15: {
                return pSDevSlnSysAPIBase.isMemoDirty();
            }
            case 16: {
                return pSDevSlnSysAPIBase.isPSDevSlnIdDirty();
            }
            case 17: {
                return pSDevSlnSysAPIBase.isPSDevSlnSysAPIIdDirty();
            }
            case 18: {
                return pSDevSlnSysAPIBase.isPSDevSlnSysAPINameDirty();
            }
            case 19: {
                return pSDevSlnSysAPIBase.isPSDevSlnSysIdDirty();
            }
            case 20: {
                return pSDevSlnSysAPIBase.isPSDevSlnSysNameDirty();
            }
            case 21: {
                return pSDevSlnSysAPIBase.isPSSysServiceAPIIdDirty();
            }
            case 22: {
                return pSDevSlnSysAPIBase.isPSSysServiceAPINameDirty();
            }
            case 23: {
                return pSDevSlnSysAPIBase.isServiceCodeNameDirty();
            }
            case 24: {
                return pSDevSlnSysAPIBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDevSlnSysAPIBase.isUpdateManDirty();
            }
            case 26: {
                return pSDevSlnSysAPIBase.isValidFlagDirty();
            }
            case 27: {
                return pSDevSlnSysAPIBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysAPIBase.getAPILevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apilevel", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPILevel()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getAPIMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apimdurl", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPIMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getAPIMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apimode", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPIMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getAPITag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPITag()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getAPITag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag2", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPITag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getAPIType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitype", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getAPIType()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getCfgModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgmodel", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getCfgModel()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"client2psdevslnsysid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getClient2PSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"client2psdevslnsysname", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getClient2PSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clientpsdevslnsysid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getClientPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clientpsdevslnsysname", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getClientPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getDevSysState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsysstate", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getDevSysState()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysAPIBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSDevSlnSysAPIBase.getJSONValue((Object)pSDevSlnSysAPIBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysAPIBase.getAPILevel() != null) {
            object = pSDevSlnSysAPIBase.getAPILevel();
            xmlNode.setAttribute(FIELD_APILEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getAPIMDUrl() != null) {
            object = pSDevSlnSysAPIBase.getAPIMDUrl();
            xmlNode.setAttribute(FIELD_APIMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getAPIMode() != null) {
            object = pSDevSlnSysAPIBase.getAPIMode();
            xmlNode.setAttribute(FIELD_APIMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getAPITag() != null) {
            object = pSDevSlnSysAPIBase.getAPITag();
            xmlNode.setAttribute(FIELD_APITAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getAPITag2() != null) {
            object = pSDevSlnSysAPIBase.getAPITag2();
            xmlNode.setAttribute(FIELD_APITAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getAPIType() != null) {
            object = pSDevSlnSysAPIBase.getAPIType();
            xmlNode.setAttribute(FIELD_APITYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getCfgModel() != null) {
            object = pSDevSlnSysAPIBase.getCfgModel();
            xmlNode.setAttribute(FIELD_CFGMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysId() != null) {
            object = pSDevSlnSysAPIBase.getClient2PSDevSlnSysId();
            xmlNode.setAttribute(FIELD_CLIENT2PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysName() != null) {
            object = pSDevSlnSysAPIBase.getClient2PSDevSlnSysName();
            xmlNode.setAttribute(FIELD_CLIENT2PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysId() != null) {
            object = pSDevSlnSysAPIBase.getClientPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_CLIENTPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysName() != null) {
            object = pSDevSlnSysAPIBase.getClientPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_CLIENTPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getCodeName() != null) {
            object = pSDevSlnSysAPIBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getCreateDate() != null) {
            object = pSDevSlnSysAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getCreateMan() != null) {
            object = pSDevSlnSysAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getDevSysState() != null) {
            object = pSDevSlnSysAPIBase.getDevSysState();
            xmlNode.setAttribute(FIELD_DEVSYSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getMemo() != null) {
            object = pSDevSlnSysAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysAPIBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIId() != null) {
            object = pSDevSlnSysAPIBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIName() != null) {
            object = pSDevSlnSysAPIBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysAPIBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysAPIBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIId() != null) {
            object = pSDevSlnSysAPIBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIName() != null) {
            object = pSDevSlnSysAPIBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getServiceCodeName() != null) {
            object = pSDevSlnSysAPIBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getUpdateDate() != null) {
            object = pSDevSlnSysAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getUpdateMan() != null) {
            object = pSDevSlnSysAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAPIBase.getValidFlag() != null) {
            object = pSDevSlnSysAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysAPIBase.getVer() != null) {
            object = pSDevSlnSysAPIBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysAPIBase.isAPILevelDirty() && (bl || pSDevSlnSysAPIBase.getAPILevel() != null)) {
            iDataObject.set(FIELD_APILEVEL, (Object)pSDevSlnSysAPIBase.getAPILevel());
        }
        if (pSDevSlnSysAPIBase.isAPIMDUrlDirty() && (bl || pSDevSlnSysAPIBase.getAPIMDUrl() != null)) {
            iDataObject.set(FIELD_APIMDURL, (Object)pSDevSlnSysAPIBase.getAPIMDUrl());
        }
        if (pSDevSlnSysAPIBase.isAPIModeDirty() && (bl || pSDevSlnSysAPIBase.getAPIMode() != null)) {
            iDataObject.set(FIELD_APIMODE, (Object)pSDevSlnSysAPIBase.getAPIMode());
        }
        if (pSDevSlnSysAPIBase.isAPITagDirty() && (bl || pSDevSlnSysAPIBase.getAPITag() != null)) {
            iDataObject.set(FIELD_APITAG, (Object)pSDevSlnSysAPIBase.getAPITag());
        }
        if (pSDevSlnSysAPIBase.isAPITag2Dirty() && (bl || pSDevSlnSysAPIBase.getAPITag2() != null)) {
            iDataObject.set(FIELD_APITAG2, (Object)pSDevSlnSysAPIBase.getAPITag2());
        }
        if (pSDevSlnSysAPIBase.isAPITypeDirty() && (bl || pSDevSlnSysAPIBase.getAPIType() != null)) {
            iDataObject.set(FIELD_APITYPE, (Object)pSDevSlnSysAPIBase.getAPIType());
        }
        if (pSDevSlnSysAPIBase.isCfgModelDirty() && (bl || pSDevSlnSysAPIBase.getCfgModel() != null)) {
            iDataObject.set(FIELD_CFGMODEL, (Object)pSDevSlnSysAPIBase.getCfgModel());
        }
        if (pSDevSlnSysAPIBase.isClient2PSDevSlnSysIdDirty() && (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_CLIENT2PSDEVSLNSYSID, (Object)pSDevSlnSysAPIBase.getClient2PSDevSlnSysId());
        }
        if (pSDevSlnSysAPIBase.isClient2PSDevSlnSysNameDirty() && (bl || pSDevSlnSysAPIBase.getClient2PSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_CLIENT2PSDEVSLNSYSNAME, (Object)pSDevSlnSysAPIBase.getClient2PSDevSlnSysName());
        }
        if (pSDevSlnSysAPIBase.isClientPSDevSlnSysIdDirty() && (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_CLIENTPSDEVSLNSYSID, (Object)pSDevSlnSysAPIBase.getClientPSDevSlnSysId());
        }
        if (pSDevSlnSysAPIBase.isClientPSDevSlnSysNameDirty() && (bl || pSDevSlnSysAPIBase.getClientPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_CLIENTPSDEVSLNSYSNAME, (Object)pSDevSlnSysAPIBase.getClientPSDevSlnSysName());
        }
        if (pSDevSlnSysAPIBase.isCodeNameDirty() && (bl || pSDevSlnSysAPIBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnSysAPIBase.getCodeName());
        }
        if (pSDevSlnSysAPIBase.isCreateDateDirty() && (bl || pSDevSlnSysAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysAPIBase.getCreateDate());
        }
        if (pSDevSlnSysAPIBase.isCreateManDirty() && (bl || pSDevSlnSysAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysAPIBase.getCreateMan());
        }
        if (pSDevSlnSysAPIBase.isDevSysStateDirty() && (bl || pSDevSlnSysAPIBase.getDevSysState() != null)) {
            iDataObject.set(FIELD_DEVSYSSTATE, (Object)pSDevSlnSysAPIBase.getDevSysState());
        }
        if (pSDevSlnSysAPIBase.isMemoDirty() && (bl || pSDevSlnSysAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysAPIBase.getMemo());
        }
        if (pSDevSlnSysAPIBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysAPIBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysAPIBase.getPSDevSlnId());
        }
        if (pSDevSlnSysAPIBase.isPSDevSlnSysAPIIdDirty() && (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        }
        if (pSDevSlnSysAPIBase.isPSDevSlnSysAPINameDirty() && (bl || pSDevSlnSysAPIBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIName());
        }
        if (pSDevSlnSysAPIBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysAPIBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysAPIBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysAPIBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysAPIBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysAPIBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysAPIBase.isPSSysServiceAPIIdDirty() && (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDevSlnSysAPIBase.getPSSysServiceAPIId());
        }
        if (pSDevSlnSysAPIBase.isPSSysServiceAPINameDirty() && (bl || pSDevSlnSysAPIBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSDevSlnSysAPIBase.getPSSysServiceAPIName());
        }
        if (pSDevSlnSysAPIBase.isServiceCodeNameDirty() && (bl || pSDevSlnSysAPIBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDevSlnSysAPIBase.getServiceCodeName());
        }
        if (pSDevSlnSysAPIBase.isUpdateDateDirty() && (bl || pSDevSlnSysAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysAPIBase.getUpdateDate());
        }
        if (pSDevSlnSysAPIBase.isUpdateManDirty() && (bl || pSDevSlnSysAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysAPIBase.getUpdateMan());
        }
        if (pSDevSlnSysAPIBase.isValidFlagDirty() && (bl || pSDevSlnSysAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysAPIBase.getValidFlag());
        }
        if (pSDevSlnSysAPIBase.isVerDirty() && (bl || pSDevSlnSysAPIBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSDevSlnSysAPIBase.getVer());
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
        return PSDevSlnSysAPIBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysAPIBase.resetAPILevel();
                return true;
            }
            case 1: {
                pSDevSlnSysAPIBase.resetAPIMDUrl();
                return true;
            }
            case 2: {
                pSDevSlnSysAPIBase.resetAPIMode();
                return true;
            }
            case 3: {
                pSDevSlnSysAPIBase.resetAPITag();
                return true;
            }
            case 4: {
                pSDevSlnSysAPIBase.resetAPITag2();
                return true;
            }
            case 5: {
                pSDevSlnSysAPIBase.resetAPIType();
                return true;
            }
            case 6: {
                pSDevSlnSysAPIBase.resetCfgModel();
                return true;
            }
            case 7: {
                pSDevSlnSysAPIBase.resetClient2PSDevSlnSysId();
                return true;
            }
            case 8: {
                pSDevSlnSysAPIBase.resetClient2PSDevSlnSysName();
                return true;
            }
            case 9: {
                pSDevSlnSysAPIBase.resetClientPSDevSlnSysId();
                return true;
            }
            case 10: {
                pSDevSlnSysAPIBase.resetClientPSDevSlnSysName();
                return true;
            }
            case 11: {
                pSDevSlnSysAPIBase.resetCodeName();
                return true;
            }
            case 12: {
                pSDevSlnSysAPIBase.resetCreateDate();
                return true;
            }
            case 13: {
                pSDevSlnSysAPIBase.resetCreateMan();
                return true;
            }
            case 14: {
                pSDevSlnSysAPIBase.resetDevSysState();
                return true;
            }
            case 15: {
                pSDevSlnSysAPIBase.resetMemo();
                return true;
            }
            case 16: {
                pSDevSlnSysAPIBase.resetPSDevSlnId();
                return true;
            }
            case 17: {
                pSDevSlnSysAPIBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 18: {
                pSDevSlnSysAPIBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 19: {
                pSDevSlnSysAPIBase.resetPSDevSlnSysId();
                return true;
            }
            case 20: {
                pSDevSlnSysAPIBase.resetPSDevSlnSysName();
                return true;
            }
            case 21: {
                pSDevSlnSysAPIBase.resetPSSysServiceAPIId();
                return true;
            }
            case 22: {
                pSDevSlnSysAPIBase.resetPSSysServiceAPIName();
                return true;
            }
            case 23: {
                pSDevSlnSysAPIBase.resetServiceCodeName();
                return true;
            }
            case 24: {
                pSDevSlnSysAPIBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDevSlnSysAPIBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSDevSlnSysAPIBase.resetValidFlag();
                return true;
            }
            case 27: {
                pSDevSlnSysAPIBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getClient2PSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClient2PSDevSlnSys();
        }
        if (this.getClient2PSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objClient2PSDevSlnSysLock;
        synchronized (n) {
            if (this.client2psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getClient2PSDevSlnSysId(), (Object)this.client2psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.client2psdevslnsys = null;
            }
            if (this.client2psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getClient2PSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.client2psdevslnsys = pSDevSlnSys;
            }
            return this.client2psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getClientPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientPSDevSlnSys();
        }
        if (this.getClientPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objClientPSDevSlnSysLock;
        synchronized (n) {
            if (this.clientpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getClientPSDevSlnSysId(), (Object)this.clientpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.clientpsdevslnsys = null;
            }
            if (this.clientpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getClientPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.clientpsdevslnsys = pSDevSlnSys;
            }
            return this.clientpsdevslnsys;
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
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
    public ArrayList<PSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIs();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepAPIsLock;
        synchronized (n) {
            if (this.psdevslnmsdepapis == null) {
                this.psdevslnmsdepapis = pSDevSlnMSDepAPIService.selectByPSDevSlnSysAPI(this);
            }
            return this.psdevslnmsdepapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepFuncItem> getPSDevSlnMSDepFuncItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncItems();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepFuncItemsLock;
        synchronized (n) {
            if (this.psdevslnmsdepfuncitems == null) {
                this.psdevslnmsdepfuncitems = pSDevSlnMSDepFuncItemService.selectByPSDevSlnSysAPI(this);
            }
            return this.psdevslnmsdepfuncitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnPipelineStep> getPSDevSlnPipelineSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineSteps();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelineStepsLock;
        synchronized (n) {
            if (this.psdevslnpipelinesteps == null) {
                this.psdevslnpipelinesteps = pSDevSlnPipelineStepService.selectByPSDevSlnSysAPI(this);
            }
            return this.psdevslnpipelinesteps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysRef> getPSDevSlnSysRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefs();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysRefsLock;
        synchronized (n) {
            if (this.psdevslnsysrefs == null) {
                this.psdevslnsysrefs = pSDevSlnSysRefService.selectByRefPSDevSlnSysAPI(this);
            }
            return this.psdevslnsysrefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysServiceAPI> getPSSubSysServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIs();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysServiceAPIsLock;
        synchronized (n) {
            if (this.pssubsysserviceapis == null) {
                this.pssubsysserviceapis = pSSubSysServiceAPIService.selectByPSDevSlnSysAPI(this);
            }
            return this.pssubsysserviceapis;
        }
    }

    private PSDevSlnSysAPIBase getProxyEntity() {
        return this.proxyPSDevSlnSysAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysAPIBase) {
            this.proxyPSDevSlnSysAPIBase = (PSDevSlnSysAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APILEVEL, 0);
        fieldIndexMap.put(FIELD_APIMDURL, 1);
        fieldIndexMap.put(FIELD_APIMODE, 2);
        fieldIndexMap.put(FIELD_APITAG, 3);
        fieldIndexMap.put(FIELD_APITAG2, 4);
        fieldIndexMap.put(FIELD_APITYPE, 5);
        fieldIndexMap.put(FIELD_CFGMODEL, 6);
        fieldIndexMap.put(FIELD_CLIENT2PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_CLIENT2PSDEVSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_CLIENTPSDEVSLNSYSID, 9);
        fieldIndexMap.put(FIELD_CLIENTPSDEVSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_CODENAME, 11);
        fieldIndexMap.put(FIELD_CREATEDATE, 12);
        fieldIndexMap.put(FIELD_CREATEMAN, 13);
        fieldIndexMap.put(FIELD_DEVSYSSTATE, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 21);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 22);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
        fieldIndexMap.put(FIELD_VER, 27);
    }
}

