/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrlBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppDEViewService
extends PSAppDEViewServiceBase {
    public static final String DEVIEW_SUBSYSDEVIEW = "SUBSYSDEVIEW";
    private static final Log log = LogFactory.getLog(PSAppDEViewService.class);

    @Override
    protected void onBeforeCreate(PSAppDEView pSAppDEView) throws Exception {
        Object object;
        PSDEViewBase pSDEViewBase;
        if (StringHelper.isNullOrEmpty((String)pSAppDEView.getPSAppDEViewName())) {
            pSDEViewBase = pSAppDEView.getPSDEViewBase();
            object = pSDEViewBase.getPSDE().getCodeName() + pSDEViewBase.getCodeName();
            pSAppDEView.setPSAppDEViewName((String)object);
        }
        if (StringHelper.isNullOrEmpty((String)pSAppDEView.getPSAppLocalDEId())) {
            pSDEViewBase = pSAppDEView.getPSDEViewBase();
            SelectCond viewCond = new SelectCond();
            viewCond.set("PSSYSAPPID", (Object)pSAppDEView.getPSSysAppId());
            viewCond.set("PSDEID", (Object)pSDEViewBase.getPSDEId());
            String string = KeyValueHelper.genUniqueId((String)pSAppDEView.getPSSysAppId(), (String)pSDEViewBase.getPSDEId());
            PSAppLocalDE pSAppLocalDEBase = null;
            PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSAppLocalDE> arrayList = pSAppLocalDEService.select(viewCond);
            if (arrayList != null) {
                for (PSAppLocalDE pSAppLocalDE : arrayList) {
                    if (!DataObject.getBoolValue((Integer)pSAppLocalDE.getDefaultFlag(), (boolean)true)) continue;
                    pSAppLocalDEBase = pSAppLocalDE;
                    break;
                }
                if (pSAppLocalDEBase == null) {
                    for (PSAppLocalDE pSAppLocalDE : arrayList) {
                        if (StringHelper.compare((String)pSAppLocalDE.getPSAppLocalDEId(), (String)string, (boolean)false) != 0) continue;
                        pSAppLocalDEBase = pSAppLocalDE;
                        break;
                    }
                }
            }
            if (pSAppLocalDEBase == null) {
                pSAppLocalDEBase = new PSAppLocalDE();
                pSAppLocalDEBase.setPSAppLocalDEId(string);
                if (!pSAppLocalDEService.get(pSAppLocalDEBase, true)) {
                    pSAppLocalDEBase.setPSSysAppId(pSAppDEView.getPSSysAppId());
                    pSAppLocalDEBase.setPSSysAppName(pSAppDEView.getPSSysAppName());
                    pSAppLocalDEBase.setPSDEId(pSDEViewBase.getPSDEId());
                    pSAppLocalDEBase.setPSDEName(pSDEViewBase.getPSDEName());
                    pSAppLocalDEBase.setPSAppLocalDEName(pSDEViewBase.getPSDEName());
                    pSAppLocalDEService.create(pSAppLocalDEBase);
                }
            }
            pSAppDEView.setPSAppLocalDEId(pSAppLocalDEBase.getPSAppLocalDEId());
            pSAppDEView.setPSAppLocalDEName(pSAppLocalDEBase.getPSAppLocalDEName());
        }
        super.onBeforeCreate(pSAppDEView);
    }

    @Override
    protected boolean onFillEntityKeyValue(PSAppDEView pSAppDEView, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSAppDEView.get("PSSYSAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSAppDEView.get("PSDEVIEWBASEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSAppDEView.set(this.getDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    @Override
    protected void onInitDynaView(PSAppDEView pSAppDEView) throws Exception {
        if (!pSAppDEView.isDyncModeDirty() || pSAppDEView.getPSSysApp() == null || pSAppDEView.getPSDEViewBase() == null) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSAppDEView.getPSDEViewBase().getDyncMode(), (boolean)false)) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSAppDEView.getPSSysApp().getEnableDynaSys(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528[%1$s]\u6ca1\u6709\u542f\u7528\u52a8\u6001\u5e94\u7528\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u89c6\u56fe\u7684\u52a8\u6001\u529f\u80fd", (Object)pSAppDEView.getPSSysApp().getPSSysAppName()));
        }
        PSDynaAppViewService pSDynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        PSDynaAppViewCtrlService pSDynaAppViewCtrlService = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        PSDynaDEService pSDynaDEService = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
        PSDynaDEFormService pSDynaDEFormService = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDynaAppView pSDynaAppView = new PSDynaAppView();
        pSDynaAppView.setPSDynaAppViewId(pSAppDEView.getPSAppDEViewId());
        pSDynaAppView.setPSDynaAppViewName(pSAppDEView.getPSAppDEViewName());
        pSDynaAppView.setTitle(pSAppDEView.getTitle());
        pSDynaAppView.setCaption(pSAppDEView.getCaption());
        pSDynaAppView.setPSDynaAppId(pSAppDEView.getPSSysApp().getPSSysAppId());
        pSDynaAppView.setPSDynaAppName(pSAppDEView.getPSSysApp().getPSSysAppName());
        pSDynaAppView.setViewType(pSAppDEView.getPSDEViewType());
        if (pSAppDEView.getPSDEViewBase().getPSDE() != null) {
            PSDynaDE dynaDE = new PSDynaDE();
            dynaDE.setPSDynaDEId(pSAppDEView.getPSDEViewBase().getPSDE().getPSDataEntityId());
            dynaDE.setPSDynaDEName(pSAppDEView.getPSDEViewBase().getPSDE().getPSDataEntityName());
            dynaDE.setLogicName(pSAppDEView.getPSDEViewBase().getPSDE().getLogicName());
            dynaDE.setPSDynaSysId(pSAppDEView.getPSDEViewBase().getPSDE().getPSSystem().getPSSystemId());
            dynaDE.setPSDynaSysName(pSAppDEView.getPSDEViewBase().getPSDE().getPSSystem().getPSSystemName());
            pSDynaDEService.save(dynaDE, false);
            pSDynaAppView.setPSDynaDEId(dynaDE.getPSDynaDEId());
            pSDynaAppView.setPSDynaDEName(dynaDE.getPSDynaDEName());
        }
        pSDynaAppView.setPSWFDEId(pSAppDEView.getPSDEViewBase().getPSWFDEId());
        pSDynaAppView.setPSWFDEName(pSAppDEView.getPSDEViewBase().getPSWFDEName());
        pSDynaAppView.setPredefinedViewType(pSAppDEView.getPSDEViewBase().getPredefinedViewType());
        pSDynaAppView.setPDVTParam(pSAppDEView.getPSDEViewBase().getPDVTParam());
        pSDynaAppViewService.save(pSDynaAppView, false);
        HashMap<String, PSDynaAppViewCtrl> hashMap = new HashMap<String, PSDynaAppViewCtrl>();
        for (PSDynaAppViewCtrl ctrl : pSDynaAppView.getPSDynaAppViewCtrls()) {
            hashMap.put(ctrl.getPSDynaAppViewCtrlId(), ctrl);
        }
        for (PSDEViewCtrl entityBase : pSAppDEView.getPSDEViewBase().getPSDEViewCtrls()) {
            PSDynaAppViewCtrl pSDynaAppViewCtrl = new PSDynaAppViewCtrl();
            pSDynaAppViewCtrl.setPSDynaAppViewCtrlId(entityBase.getPSDEViewCtrlId());
            pSDynaAppViewCtrl.setPSDynaAppViewCtrlName(entityBase.getPSDEViewCtrlName());
            pSDynaAppViewCtrl.setCtrlType(entityBase.getPSDEViewCtrlType());
            pSDynaAppViewCtrl.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
            pSDynaAppViewCtrl.setPSDynaAppViewName(pSDynaAppView.getPSDynaAppViewName());
            if (entityBase.getPSDEForm() != null && entityBase.getPSDEForm().getPSDE() != null) {
                if (StringHelper.compare((String)entityBase.getPSDEForm().getFormType(), (String)"EDITFORM", (boolean)true) != 0) continue;
                PSDynaDE pSDynaDE = new PSDynaDE();
                pSDynaDE.setPSDynaDEId(entityBase.getPSDEForm().getPSDE().getPSDataEntityId());
                pSDynaDE.setPSDynaDEName(entityBase.getPSDEForm().getPSDE().getPSDataEntityName());
                pSDynaDE.setLogicName(entityBase.getPSDEForm().getPSDE().getLogicName());
                pSDynaDE.setPSDynaSysId(entityBase.getPSDEForm().getPSDE().getPSSystem().getPSSystemId());
                pSDynaDE.setPSDynaSysName(entityBase.getPSDEForm().getPSDE().getPSSystem().getPSSystemName());
                pSDynaDEService.save(pSDynaDE, false);
                PSDynaDEForm pSDynaDEForm = new PSDynaDEForm();
                pSDynaDEForm.setPSDynaDEFormId(entityBase.getPSDEForm().getPSDEFormId());
                pSDynaDEForm.setPSDynaDEFormName(entityBase.getPSDEForm().getPSDEFormName());
                pSDynaDEForm.setPSDynaDEId(pSDynaDE.getPSDynaDEId());
                pSDynaDEForm.setPSDynaDEName(pSDynaDE.getPSDynaDEName());
                pSDynaDEForm.setPSDEFormId(entityBase.getPSDEForm().getPSDEFormId());
                pSDynaDEForm.setPSDEFormName(entityBase.getPSDEForm().getPSDEFormName());
                pSDynaDEFormService.save(pSDynaDEForm, false);
                pSDynaAppViewCtrl.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
                pSDynaAppViewCtrl.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEFormName());
            }
            pSDynaAppViewCtrlService.save(pSDynaAppViewCtrl, false);
            hashMap.remove(pSDynaAppViewCtrl.getPSDynaAppViewCtrlId());
        }
        for (PSDynaAppViewCtrl ctrl : hashMap.values()) {
            pSDynaAppViewCtrlService.remove(ctrl);
        }
    }

    @Override
    protected void onAfterCreate(PSAppDEView pSAppDEView) throws Exception {
        super.onAfterCreate(pSAppDEView);
    }
}
