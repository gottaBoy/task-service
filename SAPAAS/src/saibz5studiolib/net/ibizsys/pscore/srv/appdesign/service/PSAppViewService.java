/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.net.URLEncoder;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewService<ET extends PSAppView>
extends PSAppViewServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSAppViewService.class);

    @Override
    protected void onBeforeCreate(ET ET) throws Exception {
        this.syncPSPFStyle(ET);
        super.onBeforeCreate(ET);
    }

    @Override
    protected void onBeforeCreateTemp(ET ET) throws Exception {
        this.syncPSPFStyle(ET);
        super.onBeforeCreateTemp(ET);
    }

    @Override
    protected void onBeforeUpdate(ET ET) throws Exception {
        this.syncPSPFStyle(ET);
        super.onBeforeUpdate(ET);
    }

    @Override
    protected void onBeforeUpdateTemp(ET ET) throws Exception {
        this.syncPSPFStyle(ET);
        super.onBeforeUpdateTemp(ET);
    }

    @Override
    protected void onJITPreview(ET ET) throws Exception {
        String string;
        int n;
        String string2;
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        JSONObject jSONObject = WebContext.getAppData((IWebContext)this.getWebContext());
        if (jSONObject == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        IPSSysDevUser iPSSysDevUser = null;
        try {
            string2 = jSONObject.optString("psdevslnsysid");
            iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUser(this.getWebContext(), string2, null);
            if (iPSSysDevUser.getAccMode() == 5) {
                throw new Exception("\u5171\u4eab\u8bbf\u95ee\u6a21\u5f0f\u4e0d\u652f\u6301JIT\u64cd\u4f5c");
            }
        }
        catch (ErrorException errorException) {
            throw errorException;
        }
        catch (Exception exception) {
            throw exception;
        }
        string2 = DataObject.getStringValue(ET, (String)this.getDEModel().getKeyDEField().getName(), (String)"");
        if (KeyValueHelper.isTempKey((String)string2)) {
            this.getTemp((IEntity)ET);
            string2 = (String)EntityBase.getOriginKey(ET);
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe\u8fd8\u672a\u4fdd\u5b58"));
            }
        }
        PSAppView pSAppView = (PSAppView)this.getDEModel().createEntity();
        pSAppView.set(this.getDEModel().getKeyDEField().getName(), string2);
        this.get((IEntity)pSAppView);
        PSSysApp pSSysApp = pSAppView.getPSSysApp();
        PSSystem pSSystem = pSSysApp.getPSSystem();
        String string3 = "";
        for (n = 1; n <= 9; ++n) {
            string3 = StringHelper.format((String)"JITApp%1$s", (Object)(n == 1 ? "" : Integer.valueOf(n)));
            string = (String)this.getWebContext().getSessionValue(StringHelper.format((String)"jit_%1$s_appid", (Object)string3));
            if (StringHelper.compare((String)pSSysApp.getPSSysAppId(), (String)string, (boolean)false) == 0) break;
            string3 = "";
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            for (n = 1; n <= 9; ++n) {
                string3 = StringHelper.format((String)"JITApp%1$s", (Object)(n == 1 ? "" : Integer.valueOf(n)));
                string = (String)this.getWebContext().getSessionValue(StringHelper.format((String)"jit_%1$s_appid", (Object)string3));
                if (StringHelper.isNullOrEmpty((String)string)) break;
                string3 = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            string3 = "JITApp";
        }
        if (StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_devslnsys", (Object)string3), (Object)"0");
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_sysid", (Object)string3), (Object)pSSystem.getPSSystemId());
        } else {
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_devslnsys", (Object)string3), (Object)"1");
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_sysid", (Object)string3), (Object)pSSystem.getPSDevSlnSysId());
        }
        this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_pfid", (Object)string3), (Object)pSSysApp.getPSPFId());
        this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_appid", (Object)string3), (Object)pSSysApp.getPSSysAppId());
        String string4 = this.getWebContext().getPostValue("srfactionparam");
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            string = JSONObject.fromString((String)string4);
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_userid", (Object)string3), string.opt("srfkey"));
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_username", (Object)string3), string.opt("srfmajortext"));
        } else {
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_userid", (Object)string3), (Object)"");
            this.getWebContext().setSessionValue(StringHelper.format((String)"jit_%1$s_username", (Object)string3), (Object)"");
        }
        this.getWebContext().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"window.open('../%1$s/jitview.jsp?PSAPPVIEWID=%2$s','_blank');", (Object)string3.toLowerCase(), (Object)URLEncoder.encode(string2, "UTF-8")));
    }

    @Override
    protected void onAfterCreate(ET ET) throws Exception {
        this.onInitDynaView(ET);
        super.onAfterCreate(ET);
    }

    @Override
    protected void onAfterUpdate(ET ET) throws Exception {
        this.onInitDynaView(ET);
        super.onAfterUpdate(ET);
    }

    @Override
    protected void onInitDynaView(ET ET) throws Exception {
        if (!((PSAppViewBase)ET).isDyncModeDirty() || ((PSAppViewBase)ET).getPSSysApp() == null) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)((PSAppViewBase)ET).getDyncMode(), (boolean)false)) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)((PSAppViewBase)ET).getPSSysApp().getEnableDynaSys(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528[%1$s]\u6ca1\u6709\u542f\u7528\u52a8\u6001\u5e94\u7528\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u89c6\u56fe\u7684\u52a8\u6001\u529f\u80fd", (Object)((PSAppViewBase)ET).getPSSysApp().getPSSysAppName()));
        }
        PSDynaAppViewService pSDynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        PSDynaAppView pSDynaAppView = new PSDynaAppView();
        pSDynaAppView.setPSDynaAppViewId(((PSAppViewBase)ET).getPSAppViewId());
        pSDynaAppView.setPSDynaAppViewName(((PSAppViewBase)ET).getPSAppViewName());
        if (((PSAppViewBase)ET).getTitle() != null) {
            pSDynaAppView.setTitle(((PSAppViewBase)ET).getTitle());
        }
        if (((PSAppViewBase)ET).getCaption() != null) {
            pSDynaAppView.setCaption(((PSAppViewBase)ET).getCaption());
        }
        pSDynaAppView.setPSDynaAppId(((PSAppViewBase)ET).getPSSysApp().getPSSysAppId());
        pSDynaAppView.setPSDynaAppName(((PSAppViewBase)ET).getPSSysApp().getPSSysAppName());
        if (((PSAppViewBase)ET).getPSAppViewType() != null) {
            pSDynaAppView.setViewType(((PSAppViewBase)ET).getPSAppViewType());
        }
        pSDynaAppViewService.save((IEntity)pSDynaAppView, false);
    }

    @Override
    protected String getEntityFolderKeyValue(ET ET, PSSystem pSSystem) throws Exception {
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "Z", this.getSessionFactory());
        }
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPDYNADEVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "Y", this.getSessionFactory());
        }
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "X", this.getSessionFactory());
        }
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "W", this.getSessionFactory());
        }
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "V", this.getSessionFactory());
        }
        if (StringHelper.compare((String)((PSAppViewBase)ET).getPSAppViewType(), (String)"APPUTILVIEW", (boolean)true) == 0) {
            return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, "PSAPPVIEW", "U", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(ET, pSSystem);
    }

    protected void syncPSPFStyle(ET ET) throws Exception {
        if (StringHelper.isNullOrEmpty((String)((PSAppViewBase)ET).getPSPFStyleId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        PSPFStyle pSPFStyle = new PSPFStyle();
        pSPFStyle.setPSPFStyleId(((PSAppViewBase)ET).getPSPFStyleId());
        if (pSPFStyleService.get((IEntity)pSPFStyle, true)) {
            return;
        }
        PSPFStyleService pSPFStyleService2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFStyle pSPFStyle2 = new PSPFStyle();
        pSPFStyle2.setPSPFStyleId(((PSAppViewBase)ET).getPSPFStyleId());
        if (!pSPFStyleService2.get((IEntity)pSPFStyle2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)((PSAppViewBase)ET).getPSPFStyleId()));
        }
        PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
        PSPF pSPF = new PSPF();
        pSPF.setPSPFId(pSPFStyle2.getPSPFId());
        if (!pSPFService.get((IEntity)pSPF, true)) {
            PSPFService pSPFService2 = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPF pSPF2 = new PSPF();
            pSPF2.setPSPFId(pSPFStyle2.getPSPFId());
            if (!pSPFService2.get((IEntity)pSPF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSAppType pSAppType = new PSAppType();
            pSAppType.setPSAppTypeId(pSPF2.getPSAppTypeId());
            if (!pSAppTypeService.get((IEntity)pSAppType, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService2 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
            pSAppTypeService2.save((IEntity)pSAppType, false);
            pSPF.setPSAppTypeId(pSAppType.getPSAppTypeId());
            pSPF.setPSAppTypeName(pSAppType.getPSAppTypeName());
            pSPF.setPSPFId(pSPF2.getPSPFId());
            pSPF.setPSPFName(pSPF2.getPSPFName());
            pSPF.setValidFlag(1);
            pSPFService.create(pSPF);
        }
        pSPFStyle.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
        pSPFStyle.setPSPFStyleName(pSPFStyle2.getPSPFStyleName());
        pSPFStyle.setPSPFId(pSPFStyle2.getPSPFId());
        pSPFStyle.setPSPFName(pSPFStyle2.getPSPFName());
        pSPFStyle.setStyleCode(pSPFStyle2.getStyleCode());
        pSPFStyle.setStyleEngine(pSPFStyle2.getStyleEngine());
        pSPFStyleService.create(pSPFStyle);
    }
}

