/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFLinkService
extends IPSModelService<PSWFLink, PSWFLinkDTO> {
    public List<PSWFLink> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSWFLink get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSWFLinkDTO> listDTOByPSWFVersion(String var1) throws Exception;
}

