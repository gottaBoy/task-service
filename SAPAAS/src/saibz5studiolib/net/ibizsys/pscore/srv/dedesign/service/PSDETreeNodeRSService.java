/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRS;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETreeNodeRSService
extends PSDETreeNodeRSServiceBase {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRSService.class);

    @Override
    protected void onBeforeCreate(PSDETreeNodeRS pSDETreeNodeRS) throws Exception {
        String string = StringHelper.format((String)"%1$s - %2$s", (Object)pSDETreeNodeRS.getPPSDETreeNodeName(), (Object)pSDETreeNodeRS.getCPSDETreeNodeName());
        pSDETreeNodeRS.setPSDETreeNodeRSName(string);
        super.onBeforeCreate(pSDETreeNodeRS);
    }

    @Override
    protected void onBeforeCreateTemp(PSDETreeNodeRS pSDETreeNodeRS) throws Exception {
        String string = StringHelper.format((String)"%1$s - %2$s", (Object)pSDETreeNodeRS.getPPSDETreeNodeName(), (Object)pSDETreeNodeRS.getCPSDETreeNodeName());
        pSDETreeNodeRS.setPSDETreeNodeRSName(string);
        super.onBeforeCreateTemp(pSDETreeNodeRS);
    }
}

