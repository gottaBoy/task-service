/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMavenRepoService
extends PSDCMavenRepoServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMavenRepoService.class);

    @Override
    protected void onInitDCDefault(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        PSDCMavenRepo pSDCMavenRepo2 = new PSDCMavenRepo();
        pSDCMavenRepo2.setPSDCMavenRepoId(this.getWebContext().getCurOrgId());
        if (this.get((IEntity)pSDCMavenRepo2, true)) {
            return;
        }
        pSDCMavenRepo2.setPSDevCenterId(this.getWebContext().getCurOrgId());
        pSDCMavenRepo2.setPSDevCenterName(this.getWebContext().getCurOrgName());
        pSDCMavenRepo2.setDefaultFlag(1);
        pSDCMavenRepo2.setConnStr("http://#");
        pSDCMavenRepo2.setValidFlag(1);
        pSDCMavenRepo2.setPSDCMavenRepoName("\u5e94\u7528\u4e2d\u5fc3\u9ed8\u8ba4Maven\u4ed3\u5e93");
        this.create(pSDCMavenRepo2);
    }
}

