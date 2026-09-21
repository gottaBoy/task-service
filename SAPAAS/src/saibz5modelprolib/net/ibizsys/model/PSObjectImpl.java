/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.IModelBase
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSObjectImpl
implements IModelBase,
IPSModelObject,
IPSModelObjectRuntime {
    private static final Log log = LogFactory.getLog(PSObjectImpl.class);
    private IPSModelStorageContext iPSModelStorageContext = null;
    private String strPSObjectId = "";
    private String strPSObjectName = "";
    private String strPSDynaInstId = null;
    private int nDynaModelType = 0;
    private BaseDataEntity dataEntity = null;
    private Properties userParams = null;

    protected void onInit() throws Exception {
        this.onCheckModel();
    }

    protected void onCheckModel() throws Exception {
    }

    public String getId() {
        return this.strPSObjectId;
    }

    public String getName() {
        return this.strPSObjectName;
    }

    protected void setId(String strPSObjectId) {
        this.strPSObjectId = strPSObjectId;
    }

    protected void setName(String strPSObjectName) {
        this.strPSObjectName = strPSObjectName;
    }

    @Override
    public final IPSModelStorageContext getPSModelStorageContext() {
        return this.iPSModelStorageContext;
    }

    public final void setPSModelStorageContext(IPSModelStorageContext iPSModelStorageContext) {
        this.iPSModelStorageContext = iPSModelStorageContext;
    }

    @Override
    public abstract String getPSSysModelInstId();

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity) {
        this.setPSObjectData(baseDataEntity, true);
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity, boolean bCache) {
        try {
            this.dataEntity = baseDataEntity;
            if (this.dataEntity != null) {
                this.nDynaModelType = this.dataEntity.getParamIntValue("DYNAMODELFLAG", 0);
                this.strPSDynaInstId = this.dataEntity.getParamStringValue("PSDYNAINSTID", null);
            } else {
                this.nDynaModelType = 0;
                this.strPSDynaInstId = null;
            }
            if (!bCache) {
                this.dataEntity = null;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected BaseDataEntity getPSObjectData() {
        return this.dataEntity;
    }

    public Object getUserParam(String strParamName) {
        if (this.userParams == null) {
            return null;
        }
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName);
    }

    public boolean containsUserParam(String strParamName) {
        if (this.userParams == null) {
            return false;
        }
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null) != null;
    }

    public String getUserParam(String strParamName, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (String)strDefault);
    }

    public boolean getUserParam(String strParamName, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (boolean)bDefault);
    }

    public int getUserParam(String strParamName, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (int)nDefault);
    }

    public Enumeration<Object> getUserParamNames() {
        if (this.userParams == null) {
            return null;
        }
        return this.userParams.keys();
    }

    public String getModelType() {
        return null;
    }

    @Override
    public int check() throws Exception {
        return 0;
    }

    protected void logPSModelInfo(int nLogLevel, String strInfo) {
    }

    public String getModelName() {
        return this.getName();
    }

    public String getFullModelName() {
        return this.getModelName();
    }

    protected IPSModelQueryHelper getPSModelQueryHelper() throws Exception {
        return PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId(), this.getPSDynaInstId());
    }

    protected String getPSSysModelInstId(IPSModelObject iPSModelObject) {
        return ((IPSModelObjectRuntime)iPSModelObject).getPSSysModelInstId();
    }

    @Override
    public void refreshModelVer() {
        this.onRefreshModelVer();
    }

    protected void onRefreshModelVer() {
    }

    @Override
    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    @Override
    public int getDynaModelType() {
        return this.nDynaModelType;
    }
}

