/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSSysBDTableDE;
import net.ibizsys.modelapi.service.impl.PSSysBDTableDEServiceImpl;
import org.springframework.util.StringUtils;

public class PSSysBDTableDEServiceImplEx
extends PSSysBDTableDEServiceImpl {
    @Override
    public String getModelTag(PSSysBDTableDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEName())) {
            if (et.getDefaultFlag() != null && et.getDefaultFlag() == 1) {
                return et.getPSDEName();
            }
            return String.format("%1$s#%2$s", et.getPSDEName(), et.getDefaultFlag());
        }
        return super.getModelTag(et);
    }
}

