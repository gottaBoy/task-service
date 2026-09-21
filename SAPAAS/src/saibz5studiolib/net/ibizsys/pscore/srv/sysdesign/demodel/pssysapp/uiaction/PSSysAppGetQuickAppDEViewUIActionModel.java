/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysapp.uiaction;

import java.util.ArrayList;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysapp.uiaction.PSSysAppGetQuickAppDEViewUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysAppGetQuickAppDEViewUIActionModel
extends PSSysAppGetQuickAppDEViewUIActionModelBase {
    private static final Log log = LogFactory.getLog(PSSysAppGetQuickAppDEViewUIActionModel.class);

    protected void onExecute(ArrayList<PSSysApp> arrayList, SessionFactory sessionFactory) throws Exception {
        Object object;
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        PSSysApp pSSysApp = arrayList.get(0);
        PSAppDEView pSAppDEView = new PSAppDEView();
        String string = WebContext.getCurrent().getPostValue("PSDEVIEWBASEID");
        if (StringHelper.isNullOrEmpty((String)string)) {
            object = WebContext.getCurrent().getPostValue("PSAPPDEVIEWID");
            if (StringHelper.isNullOrEmpty((String)object)) {
                throw new ErrorException(5, "\u8c03\u7528\u53c2\u6570\u4e0d\u6b63\u786e");
            }
            pSAppDEView.setPSAppDEViewId((String)object);
            pSAppDEView.setSessionFactory(sessionFactory);
            if (!pSAppDEView.get(true)) {
                throw new ErrorException(5, "\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe");
            }
        } else {
            pSAppDEView.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppDEView.setPSDEViewBaseId(string);
            pSAppDEView.setSessionFactory(sessionFactory);
            if (!pSAppDEView.select(true)) {
                object = new PSDEViewBase();
                object.setSessionFactory(sessionFactory);
                ((PSDEViewBaseBase)object).setPSDEViewBaseId(string);
                if (!object.get(true)) {
                    throw new ErrorException(5, "\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe");
                }
                PSModule pSModule = ((PSDEViewBaseBase)object).getPSDE().getPSModule();
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)sessionFactory);
                PSAppModule pSAppModule = new PSAppModule();
                pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                pSAppModule.setPSModuleId(pSModule.getPSModuleId());
                if (!pSAppModuleService.select(pSAppModule, true)) {
                    pSAppModule.reset();
                    pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSAppModule.setCodeName(pSModule.getCodeName());
                    if (!pSAppModuleService.select(pSAppModule, true)) {
                        pSAppModule.reset();
                        pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSAppModule.setDefaultFlag(1);
                        if (!pSAppModuleService.select(pSAppModule, true)) {
                            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u6a21\u5757[%1$s]\u5bf9\u5e94\u7684\u5e94\u7528\u6a21\u5757\uff0c\u65e0\u6cd5\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u89c6\u56fe", (Object)pSModule.getPSModuleName()));
                        }
                    }
                }
                pSAppDEView.reset();
                pSAppDEView.setSessionFactory(sessionFactory);
                pSAppDEView.setPSDEViewBaseId(((PSDEViewBaseBase)object).getPSDEViewBaseId());
                pSAppDEView.setPSDEViewBaseName(((PSDEViewBaseBase)object).getPSDEViewBaseName());
                pSAppDEView.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                pSAppDEView.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                pSAppDEView.setPSSysAppId(pSAppModule.getPSSysAppId());
                pSAppDEView.setPSSysAppName(pSAppModule.getPSSysAppName());
                pSAppDEView.setPSAppViewType("APPDEVIEW");
                pSAppDEView.setMemo("\u7cfb\u7edf\u81ea\u52a8\u6dfb\u52a0");
                pSAppDEView.create();
            }
        }
        object = new JSONObject();
        object.put("psappdeviewid", (Object)pSAppDEView.getPSAppDEViewId());
        object.put("psdeviewbaseid", (Object)pSAppDEView.getPSDEViewBaseId());
        WebContext.getCurrent().getCurAjaxActionResult().setExtAttr("psappdeview", object);
    }
}

