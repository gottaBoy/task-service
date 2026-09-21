/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFRoleModelBase;
import net.ibizsys.pswf.core.WFRoleUser;

public abstract class WFDEDataSetRoleModelBase
extends WFRoleModelBase {
    private String strDEName = null;
    private String strDEDataSetName = null;
    private String strWFUserIdField = null;
    private String strWFUserNameField = null;

    public String getWFRoleType() {
        return "DEDATASET";
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        try {
            if (StringHelper.isNullOrEmpty((String)this.getDEName())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5b9e\u4f53\u540d\u79f0");
            }
            if (StringHelper.isNullOrEmpty((String)this.getDEDataSetName())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u96c6\u5408\u540d\u79f0");
            }
            if (StringHelper.isNullOrEmpty((String)this.getWFUserIdField())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u7528\u6237\u6807\u8bc6\u5c5e\u6027");
            }
            if (StringHelper.isNullOrEmpty((String)this.getWFUserNameField())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u7528\u6237\u540d\u79f0\u5c5e\u6027");
            }
            ArrayList<WFRoleUser> wfRoleUserList = new ArrayList<WFRoleUser>();
            DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
            deDataSetFetchContextImpl.setActiveDataObject((ISimpleDataObject)iWFActionContext.getActiveEntity());
            IService iService = this.getSystemModel().getDataEntityModel(this.getDEName()).getService();
            DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), (IDEDataSetFetchContext)deDataSetFetchContextImpl);
            ArrayList list = ServiceBase.fromDBFetchResult((IDataEntityModel)iService.getDEModel(), (DBFetchResult)fetchResult);
            for (IEntity iEntity : list) {
                WFRoleUser wfRoleUser = new WFRoleUser();
                wfRoleUser.setWFUserId(DataObject.getStringValue((Object)iEntity.get(this.getWFUserIdField())));
                wfRoleUser.setWFUserName(DataObject.getStringValue((Object)iEntity.get(this.getWFUserNameField())));
                wfRoleUser.setWFRoleModel(this);
                wfRoleUserList.add(wfRoleUser);
            }
            return wfRoleUserList.iterator();
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6d41\u7a0b\u89d2\u8272[%1$s]\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), ex);
        }
    }

    protected String getDEName() {
        return this.strDEName;
    }

    protected void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    protected String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    protected void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    protected String getWFUserIdField() {
        return this.strWFUserIdField;
    }

    protected void setWFUserIdField(String strWFUserIdField) {
        this.strWFUserIdField = strWFUserIdField;
    }

    protected String getWFUserNameField() {
        return this.strWFUserNameField;
    }

    protected void setWFUserNameField(String strWFUserNameField) {
        this.strWFUserNameField = strWFUserNameField;
    }
}

