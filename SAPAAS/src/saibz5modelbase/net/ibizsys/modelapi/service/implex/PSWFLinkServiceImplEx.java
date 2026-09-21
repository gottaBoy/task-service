/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.service.impl.PSWFLinkServiceImpl;
import org.springframework.util.StringUtils;

public class PSWFLinkServiceImplEx
extends PSWFLinkServiceImpl {
    @Override
    public String getModelTag(PSWFLink et) throws Exception {
        if (StringUtils.hasLength((String)et.getFromPSWFProcName())) {
            if (StringUtils.hasLength((String)et.getCodeName()) && StringUtils.hasLength((String)et.getPSWFLinkName())) {
                return String.format("%1$s[%2$s](%3$s)", et.getFromPSWFProcName(), et.getPSWFLinkName(), et.getCodeName());
            }
            if (StringUtils.hasLength((String)et.getCodeName())) {
                return String.format("%1$s(%2$s)", et.getFromPSWFProcName(), et.getCodeName());
            }
            if (StringUtils.hasLength((String)et.getPSWFLinkName())) {
                return String.format("%1$s[%2$s]", et.getFromPSWFProcName(), et.getPSWFLinkName());
            }
        }
        if (StringUtils.hasLength((String)et.getCodeName()) && StringUtils.hasLength((String)et.getPSWFLinkName())) {
            return String.format("%1$s(%2$s)", et.getPSWFLinkName(), et.getCodeName());
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSWFLinkName())) {
            return et.getPSWFLinkName();
        }
        return super.getModelTag(et);
    }
}

