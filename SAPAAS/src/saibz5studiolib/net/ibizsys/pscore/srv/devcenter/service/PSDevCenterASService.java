/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.util.IPSDCASOwnerListener;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterASService
extends PSDevCenterASServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterASService.class);

    @Override
    protected void onAfterCreate(PSDevCenterAS pSDevCenterAS) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterCreate(pSDevCenterAS);
    }

    @Override
    protected void onAfterUpdate(PSDevCenterAS pSDevCenterAS) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && (pSDevCenterAS.isResStateDirty() || pSDevCenterAS.isExpriedTimeDirty() || pSDevCenterAS.isResReadyTimeDirty())) {
            PSDevCenterAS pSDevCenterAS2 = (PSDevCenterAS)this.getLast(pSDevCenterAS);
            if (pSDevCenterAS.isResStateDirty() && DataTypeHelper.compare((int)9, (Object)pSDevCenterAS.getResState(), (Object)pSDevCenterAS2.getResState()) != 0L || pSDevCenterAS.isExpriedTimeDirty() && DataTypeHelper.compare((int)5, (Object)pSDevCenterAS.getExpriedTime(), (Object)pSDevCenterAS2.getExpriedTime()) != 0L || pSDevCenterAS.isResReadyTimeDirty() && DataTypeHelper.compare((int)5, (Object)pSDevCenterAS.getResReadyTime(), (Object)pSDevCenterAS2.getResReadyTime()) != 0L) {
                boolean bl = DataObject.getBoolValue((Integer)pSDevCenterAS2.getRefFlag(), (boolean)false);
                if (pSDevCenterAS.isRefFlagDirty()) {
                    bl = DataObject.getBoolValue((Integer)pSDevCenterAS.getRefFlag(), (boolean)false);
                }
                if (bl) {
                    IService iService;
                    String string = pSDevCenterAS2.getRefObjType();
                    if (pSDevCenterAS.isRefObjTypeDirty()) {
                        string = pSDevCenterAS.getRefObjType();
                    }
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "PSDEVSLNSYS";
                    }
                    if ((iService = DEModelGlobal.getDEModel((String)string).getService(this.getSessionFactory())) instanceof IPSDCASOwnerListener) {
                        ((IPSDCASOwnerListener)iService).onPSDCASChanged(pSDevCenterAS, pSDevCenterAS2);
                    } else {
                        log.warn((Object)StringHelper.format((String)"\u8d44\u6e90\u5f15\u7528\u7c7b\u578b[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d44\u6e90\u53d8\u5316\u4fa6\u542c\u63a5\u53e3", (Object)string));
                    }
                }
            }
        }
        super.onAfterUpdate(pSDevCenterAS);
    }

    @Override
    protected void onAfterRemove(PSDevCenterAS pSDevCenterAS) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterRemove(pSDevCenterAS);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    public void calcPSDCDBListInfo(PSDevCenterAS pSDevCenterAS) throws Exception {
        if (!PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return;
        }
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterASService.this.onCalcPSDCDBListInfo(pSDevCenterAS2);
            }
        });
    }

    protected void onCalcPSDCDBListInfo(PSDevCenterAS pSDevCenterAS) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField field = new SelectField();
        field.setName("PSDEVCENTERDBINSTID");
        selectContext.addSelectField((ISelectField)field);
        field = new SelectField();
        field.setName("PSDEVCENTERDBINSTNAME");
        selectContext.addSelectField((ISelectField)field);
        field = new SelectField();
        field.setName("DBTYPE");
        selectContext.addSelectField((ISelectField)field);
        selectContext.set("PSDEVCENTERASID", (Object)pSDevCenterAS.getPSDevCenterASId());
        PSDevCenterDBInstService dbInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevCenterDBInst> arrayList = dbInstService.select((ISelectCond)selectContext);
        if (arrayList.size() > 0) {
            ArrayList<JSONObject> arrayList2 = new ArrayList<JSONObject>();
            for (PSDevCenterDBInst pSDevCenterDBInst : arrayList) {
                JSONObject jSONObject = PSDevCenterDBInst.toJSONObject((IDataObject)pSDevCenterDBInst, (boolean)false);
                arrayList2.add(jSONObject);
            }
            pSDevCenterAS.setPSDCDBLists(JSONArray.fromArray((Object[])arrayList2.toArray()).toString());
        } else {
            pSDevCenterAS.setPSDCDBLists(null);
        }
        this.update(pSDevCenterAS, true);
    }
}
