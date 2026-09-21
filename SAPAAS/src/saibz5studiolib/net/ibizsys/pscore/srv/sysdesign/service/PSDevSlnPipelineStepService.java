/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnPipelineStepService
extends PSDevSlnPipelineStepServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineStepService.class);

    @Override
    public void getDraft(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        super.getDraft(pSDevSlnPipelineStep);
        if (pSDevSlnPipelineStep.getPSDevSlnPipeline() != null) {
            pSDevSlnPipelineStep.setPSDevSlnId(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnId());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnPipelineStep.getPSDevSlnSysId())) {
                pSDevSlnPipelineStep.setPSDevSlnSysId(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnSysId());
                pSDevSlnPipelineStep.setPSDevSlnSysName(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnSysName());
            }
        }
    }

    @Override
    public void getDraftTemp(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        super.getDraftTemp(pSDevSlnPipelineStep);
        if (pSDevSlnPipelineStep.getPSDevSlnPipeline() != null) {
            pSDevSlnPipelineStep.setPSDevSlnId(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnId());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnPipelineStep.getPSDevSlnSysId())) {
                pSDevSlnPipelineStep.setPSDevSlnSysId(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnSysId());
                pSDevSlnPipelineStep.setPSDevSlnSysName(pSDevSlnPipelineStep.getPSDevSlnPipeline().getPSDevSlnSysName());
            }
        }
    }
}

