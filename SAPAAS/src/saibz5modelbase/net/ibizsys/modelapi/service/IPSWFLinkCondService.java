/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkCond;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFLinkCondService
extends IPSModelService<PSWFLinkCond, PSWFLinkCondDTO> {
    public List<PSWFLinkCond> listByPSWFLinkCond(PSWFLinkCond var1) throws Exception;

    public PSWFLinkCond get(PSWFLinkCond var1, String var2, boolean var3) throws Exception;

    public List<PSWFLinkCondDTO> listDTOByPSWFLinkCond(String var1) throws Exception;

    public List<PSWFLinkCond> listByPSWFLink(PSWFLink var1) throws Exception;

    public PSWFLinkCond get(PSWFLink var1, String var2, boolean var3) throws Exception;

    public List<PSWFLinkCondDTO> listDTOByPSWFLink(String var1) throws Exception;

    public List<PSWFLinkCond> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSWFLinkCond get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSWFLinkCondDTO> listDTOByPSWFVersion(String var1) throws Exception;

    public List<PSWFLinkCond> listAllChild(PSWFLinkCond var1) throws Exception;

    public List<PSWFLinkCond> listAllByPSWFLink(PSWFLink var1) throws Exception;

    public List<PSWFLinkCondDTO> listAllDTOByPSWFLink(String var1) throws Exception;

    public List<PSWFLinkCond> listAllByPSWFVersion(PSWFVersion var1) throws Exception;

    public List<PSWFLinkCondDTO> listAllDTOByPSWFVersion(String var1) throws Exception;
}

