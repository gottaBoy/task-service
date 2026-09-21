/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModelBase;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;

public class WFGotoStepActorCodeListModel
extends WFGotoStepActorCodeListModelBase {
    @Override
    public Iterator<ICodeItem> queryCodeItems(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
        String strActionParam = DataObject.getStringValue(iDataObject, "ACTIONPARAM", "");
        if (StringHelper.isNullOrEmpty(strActionParam)) {
            return this.getCodeItems();
        }
        String[] keys = strActionParam.split("[;]");
        WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
        WFStepActorService wfStepActorService = (WFStepActorService)ServiceGlobal.getService(WFStepActorService.class, this.getSessionFactory());
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(keys[0]);
        wfInstanceService.get(wfInstance);
        SelectCond selectCond = new SelectCond();
        selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
        ArrayList wfStepActorList = wfStepActorService.select(selectCond);
        ArrayList<CodeItemModel> codeItemList = new ArrayList<CodeItemModel>();
        for (WFStepActor wfStepActor : wfStepActorList) {
            CodeItemModel iCodeItemModel = new CodeItemModel();
            iCodeItemModel.setValue(wfStepActor.getActorId());
            iCodeItemModel.setText(wfStepActor.getWFStepActorName());
            codeItemList.add(iCodeItemModel);
        }
        return codeItemList.iterator();
    }
}

