/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDynaDEViewTemplService
extends PSDynaDEViewTemplServiceBase
implements IPSModelService<PSDynaDEViewTempl> {
    private static final Log log = LogFactory.getLog(PSDynaDEViewTemplService.class);
    private static String[] initViewTypes = new String[]{"DYNADEEDITVIEW", "DYNADEEDITVIEW2", "DYNADEGRIDVIEW", "DYNADEPICKUPGRIDVIEW", "DYNADEPICKUPVIEW", "DYNADEMPICKUPVIEW", "DYNADEREDIRECTVIEW"};
    private static String[] initMobViewTypes = new String[]{"DYNADEMOBEDITVIEW", "DYNADEMOBMDVIEW", "DYNADEMOBINDEXPICKUPMDVIEW", "DYNADEMOBFORMPICKUPMDVIEW", "DYNADEMOBPICKUPMDVIEW", "DYNADEMOBPICKUPVIEW", "DYNADEMOBMPICKUPVIEW"};
    private static String[] initWFViewTypes = new String[]{"DYNADEWFEXPVIEW", "DYNADEWFGRIDVIEW", "DYNADEWFEDITVIEW", "DYNADEWFEDITVIEW2", "DYNADEWFEDITVIEW3", "DYNADEWFSTARTVIEW", "DYNADEWFACTIONVIEW", "DYNADEWFDATAREDIRECTVIEW", "DYNADEWFPROXYDATAVIEW"};
    private static String[] initMobWFViewTypes = new String[]{"DYNADEMOBWFMDVIEW", "DYNADEMOBWFEDITVIEW"};
    private static String[] initMSViewTypes = new String[]{"DYNADEEDITVIEW3"};

    @Override
    protected void onAfterUpdate(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        String string = pSDynaDEViewTempl.getPSDynaDETempl().getTemplPSDE().getCodeName() + pSDynaDEViewTempl.getCodeName();
        PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSAppDynaDEViewService.selectByPSDynaDEViewTempl(pSDynaDEViewTempl);
        for (PSAppDynaDEView pSAppDynaDEView : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSAppDynaDEView.getSyncCodeName(), (boolean)true) || StringHelper.compare((String)pSAppDynaDEView.getPSAppDynaDEViewName(), (String)string, (boolean)false) == 0) continue;
            PSAppDynaDEView pSAppDynaDEView2 = new PSAppDynaDEView();
            pSAppDynaDEView2.setPSAppDynaDEViewId(pSAppDynaDEView.getPSAppDynaDEViewId());
            pSAppDynaDEView2.setPSAppDynaDEViewName(string);
            pSAppDynaDEViewService.update(pSAppDynaDEView2, false);
        }
        super.onAfterUpdate(pSDynaDEViewTempl);
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDYNADETEMPL", (boolean)true) == 0) {
            PSViewTypeStruct pSViewTypeStruct;
            PSDynaDETempl pSDynaDETempl = new PSDynaDETempl();
            pSDynaDETempl.proxy((IDataObject)iEntity);
            for (String string3 : initViewTypes) {
                pSViewTypeStruct = PSModelGlobal.getPSViewType(string3);
                if (StringHelper.isNullOrEmpty((Object)pSViewTypeStruct)) {
                    log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u7c7b\u578b[%1$s]", (Object)string3));
                    continue;
                }
                this.initDEView(pSDynaDETempl, pSViewTypeStruct);
            }
            if (pSDynaDETempl.getTemplPSDE() != null && pSDynaDETempl.getTemplPSDE().getPSWFDEs().size() > 0) {
                for (String string3 : initWFViewTypes) {
                    pSViewTypeStruct = PSModelGlobal.getPSViewType(string3);
                    if (StringHelper.isNullOrEmpty((Object)pSViewTypeStruct)) {
                        log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u7c7b\u578b[%1$s]", (Object)string3));
                        continue;
                    }
                    this.initDEView(pSDynaDETempl, pSViewTypeStruct);
                }
            }
            return;
        }
    }

    protected PSDynaDEViewTempl initDEView(PSDynaDETempl pSDynaDETempl, PSViewTypeStruct pSViewTypeStruct) throws Exception {
        PSDynaDEViewTempl pSDynaDEViewTempl = new PSDynaDEViewTempl();
        String string = "";
        string = KeyValueHelper.genUniqueId((String)pSDynaDETempl.getPSDynaDETemplId(), (String)pSViewTypeStruct.getPSViewTypeId());
        pSDynaDEViewTempl.setPSDynaDEViewTemplId(string);
        if (this.checkKey(pSDynaDEViewTempl) == 0) {
            PSDynaDEViewTempl pSDynaDEViewTempl2;
            pSDynaDEViewTempl.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
            pSDynaDEViewTempl.setPSDynaDETemplName(pSDynaDETempl.getPSDynaDETemplName());
            pSDynaDEViewTempl.setPSDynaDEViewTemplName(StringHelper.format((String)"%1$s%2$s", (Object)pSDynaDETempl.getPSDynaDETemplName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
            pSDynaDEViewTempl.setViewType(pSViewTypeStruct.getPSViewTypeId());
            pSDynaDEViewTempl.setCodeName(pSViewTypeStruct.getCodeName());
            String string2 = pSDynaDEViewTempl.getCodeName();
            int n = 1;
            do {
                if (n > 1) {
                    string2 = StringHelper.format((String)"Usr%1$s%2$s", (Object)(n == 1 ? "" : Integer.valueOf(n)), (Object)pSDynaDEViewTempl.getCodeName());
                }
                ++n;
                pSDynaDEViewTempl2 = new PSDynaDEViewTempl();
                pSDynaDEViewTempl2.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
                pSDynaDEViewTempl2.setCodeName(string2);
            } while (this.select(pSDynaDEViewTempl2, true));
            pSDynaDEViewTempl.setCodeName(string2);
            try {
                this.create(pSDynaDEViewTempl);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDynaDEViewTempl.getPSDynaDEViewTemplName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSDynaDEViewTempl;
    }
}

