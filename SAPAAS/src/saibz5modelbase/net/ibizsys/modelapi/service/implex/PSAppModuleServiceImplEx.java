/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.service.impl.PSAppModuleServiceImpl;
import org.springframework.util.StringUtils;

public class PSAppModuleServiceImplEx
extends PSAppModuleServiceImpl {
    @Override
    public String getModelTag(PSAppModule et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName()) && StringUtils.hasLength((String)et.getPSAppModuleName())) {
            if (!StringUtils.hasLength((String)et.getPSModuleId())) {
                return String.format("%1$s(%2$s)", et.getPSAppModuleName(), et.getCodeName());
            }
            return String.format("%1$s[M](%2$s)", et.getPSAppModuleName(), et.getCodeName());
        }
        return super.getModelTag(et);
    }
}

