/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.FetchResult
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psrt.srv.demodel.entity.DataEntity
 */
package net.ibizsys.psportal.api;

import java.util.ArrayList;
import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psportal.api.PortalAPIClientModelBase;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

public class PortalAPIClientModel
extends PortalAPIClientModelBase {
    private static PortalAPIClientModel portalAPIClientModel = null;

    private PortalAPIClientModel() throws Exception {
    }

    public static PortalAPIClientModel getCurrent() {
        if (portalAPIClientModel == null) {
            try {
                portalAPIClientModel = new PortalAPIClientModel();
                portalAPIClientModel.init(null);
            }
            catch (Exception e) {
                return null;
            }
        }
        return portalAPIClientModel;
    }

    public FetchResult getTopMenu(IDEDataSetFetchContext iDEDataSetFetchContext) {
        try {
            return portalAPIClientModel.fetch("ACUSERFUNCGRPDETAIL__FETCH__TOPUSERGROUP", iDEDataSetFetchContext);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<IEntity> findLoginAccount(ISelectCond iSelectCond) {
        try {
            return portalAPIClientModel.select("ACLOGINACCOUNT__SELECT", iSelectCond);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public IEntity getDataSource(String strDataSourceId) {
        DataEntity dataEntity = new DataEntity();
        try {
            dataEntity.set("ACDATASOURCEID", (Object)strDataSourceId);
            portalAPIClientModel.execute("ACDATASOURCE__DEACTION__GET", (IEntity)dataEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dataEntity;
    }
}

