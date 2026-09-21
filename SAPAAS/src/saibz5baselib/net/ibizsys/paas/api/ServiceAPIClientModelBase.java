/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.api;

import java.util.HashMap;
import java.util.Properties;
import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ServiceAPIClientModelBase
extends SystemModelObjectBase
implements IServiceAPIClientModel {
    private static final Log log = LogFactory.getLog(ServiceAPIClientModelBase.class);
    private HashMap<String, IServiceAPIAction> serviceAPIActionMap = new HashMap();
    private String strServicePath = null;
    private String strUniqueTag = null;
    private String strConfigFile = null;
    private String strGrantType = null;
    private String strClientId = null;
    private String strClientSecrect = null;
    private String strAccessTokenUri = null;
    private boolean bOauth = false;
    private String strClientModuleId = null;
    private String strSystemModuleId = null;
    private Properties cfg = new Properties();

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        if (this.getSystemModel() != null && this.getSystemModel() instanceof ISystemRuntime) {
            this.strSystemModuleId = ((ISystemRuntime)this.getSystemModel()).getModuleId();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.initConfig();
        super.onInit();
    }

    protected void initConfig() throws Exception {
        try {
            this.loadProperties();
            this.strServicePath = PropertiesHelper.getProperty(this.cfg, "servicepath");
            this.strGrantType = PropertiesHelper.getProperty(this.cfg, "granttype");
            this.strClientId = PropertiesHelper.getProperty(this.cfg, "clientid");
            this.strClientSecrect = PropertiesHelper.getProperty(this.cfg, "clientsecrect");
            this.strAccessTokenUri = PropertiesHelper.getProperty(this.cfg, "accesstokenuri");
            this.bOauth = PropertiesHelper.getProperty(this.cfg, "oauth", false);
            this.strClientModuleId = PropertiesHelper.getProperty(this.cfg, "clientmoduleid", this.strSystemModuleId);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void loadProperties() throws Exception {
        String strConfigFile = this.getConfigFile();
        if (StringHelper.isNullOrEmpty(strConfigFile)) {
            strConfigFile = StringHelper.format("serviceapi-%1$s.properties", this.getUniqueTag().toLowerCase());
        }
        this.cfg.load(ServiceAPIClientModelBase.class.getClassLoader().getResourceAsStream(strConfigFile));
    }

    protected void setServicePath(String strServicePath) {
        this.strServicePath = strServicePath;
    }

    protected Properties getProperties() {
        return this.cfg;
    }

    @Override
    public String getServicePath() {
        return this.strServicePath;
    }

    public boolean isOauth() {
        return this.bOauth;
    }

    public String getGrantType() {
        return this.strGrantType;
    }

    public String getAccessTokenUri() {
        return this.strAccessTokenUri;
    }

    public String getClientId() {
        return this.strClientId;
    }

    public String getClientSecrect() {
        return this.strClientSecrect;
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public String getConfigFile() {
        return this.strConfigFile;
    }

    protected void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }

    protected void setConfigFile(String strConfigFile) {
        this.strConfigFile = strConfigFile;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected IServiceAPIAction getServiceAPIAction(String strActionTag) throws Exception {
        IServiceAPIAction iServiceAPIAction = this.serviceAPIActionMap.get(strActionTag);
        if (iServiceAPIAction == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u63a5\u53e3\u64cd\u4f5c[%1$s]", strActionTag));
        }
        return iServiceAPIAction;
    }

    protected void registerServiceAPIAction(IServiceAPIAction iServiceAPIAction) {
        this.serviceAPIActionMap.put(iServiceAPIAction.getId(), iServiceAPIAction);
        if (!StringHelper.isNullOrEmpty(iServiceAPIAction.getUniqueTag())) {
            this.serviceAPIActionMap.put(iServiceAPIAction.getUniqueTag(), iServiceAPIAction);
        }
    }

    protected String getServicePath(IServiceAPIAction iServiceAPIAction, Object objActionParam) throws Exception {
        if (this.getSystemModel() == null) {
            return this.getServicePath();
        }
        return this.getSystemModel().getServicePath(this, iServiceAPIAction, objActionParam);
    }

    public String getClientModuleId() {
        return this.strClientModuleId;
    }

    protected void setClientModuleId(String strClientModuleId) {
        this.strClientModuleId = strClientModuleId;
    }
}

