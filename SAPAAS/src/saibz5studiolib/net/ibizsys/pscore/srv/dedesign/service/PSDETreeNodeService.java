/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETreeNodeService
extends PSDETreeNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSDETreeNodeService.class);

    @Override
    protected void onBeforeRemoveTemp(PSDETreeNode pSDETreeNode) throws Exception {
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        pSDETreeNodeRSService.removeTempByCPSDETreeNode(pSDETreeNode);
        pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        pSDETreeNodeRSService.removeTempByPPSDETreeNode(pSDETreeNode);
        super.onBeforeRemoveTemp(pSDETreeNode);
    }

    @Override
    public String getModelV2Tag(PSDETreeNode pSDETreeNode) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNode.getNodeType())) {
            return pSDETreeNode.getNodeType();
        }
        return super.getModelV2Tag(pSDETreeNode);
    }
}

