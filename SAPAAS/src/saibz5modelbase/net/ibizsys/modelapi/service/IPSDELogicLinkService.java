/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicLink;
import net.ibizsys.modelapi.dto.PSDELogicLinkDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELogicLinkService
extends IPSModelService<PSDELogicLink, PSDELogicLinkDTO> {
    public List<PSDELogicLink> listByPSDELogic(PSDELogic var1) throws Exception;

    public PSDELogicLink get(PSDELogic var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicLinkDTO> listDTOByPSDELogic(String var1) throws Exception;
}

