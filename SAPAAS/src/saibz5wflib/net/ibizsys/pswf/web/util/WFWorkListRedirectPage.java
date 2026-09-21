/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFWorkList
 *  net.ibizsys.psrt.srv.wf.service.WFWorkListService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.web.util;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.pswf.web.util.WFRedirectPage;
import org.hibernate.SessionFactory;

public class WFWorkListRedirectPage
extends WFRedirectPage {
    ThreadLocal<WFWorkList> glboalWFWorkList = new ThreadLocal();

    @Override
    protected void onInit() throws Exception {
        this.glboalWFWorkList.set(null);
        String strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().getPostOrParamValue("srfkeys");
        }
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6570\u636e\u4e3b\u952e"));
        }
        WFWorkListService wfWorkListService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class, (SessionFactory)this.getSessionFactory());
        WFWorkList wfWorkList = new WFWorkList();
        wfWorkList.set("WFWORKLISTID", (Object)strKeyValue);
        wfWorkListService.get((IEntity)wfWorkList);
        this.glboalWFWorkList.set(wfWorkList);
        super.onInit();
    }

    @Override
    protected String getDEId() throws Exception {
        return this.glboalWFWorkList.get().getUserData4();
    }

    @Override
    protected String getKeyValue() throws Exception {
        return this.glboalWFWorkList.get().getUserData();
    }
}

