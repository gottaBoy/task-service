/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.paas.data.impl.DataItemImpl
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.data;

import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.paas.data.impl.DataItemImpl;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDataItemImpl
extends DataItemImpl
implements IPSDataItem {
    private IPSCodeList iPSCodeList = null;
    private int nPSObjVersion = 0;
    private IPSModelObjectRuntime iPSModelObjectRuntime = null;
    private BaseDataEntity dataEntity = null;
    private Properties userParams = null;
    private static final Log log = LogFactory.getLog(PSDataItemImpl.class);

    @Override
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    public void setPSCodeList(IPSCodeList iPSCodeList) {
        this.iPSCodeList = iPSCodeList;
    }

    @PSModelRTMeta(description="\u540d\u79f0", order=100)
    public String getName() {
        return super.getName();
    }

    protected void setId(String strPSObjectId) {
        this.strId = strPSObjectId;
    }

    protected void setVersion(int nPSObjVersion) {
        this.nPSObjVersion = nPSObjVersion;
    }

    public String getPSSysModelInstId() {
        return null;
    }

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity) {
        try {
            this.dataEntity = baseDataEntity;
            if (this.dataEntity == null) {
                this.userParams = null;
            } else {
                String strUserParams = this.dataEntity.getParamStringValue("USERPARAMS", "");
                if (!StringHelper.isNullOrEmpty((String)strUserParams)) {
                    this.userParams = PropertiesHelper.load((String)strUserParams);
                }
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

    public BaseDataEntity getModelData() {
        return this.getPSObjectData();
    }

    public String getModelType() {
        return null;
    }
}

