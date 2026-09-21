/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysSearchBarLogic;
import net.ibizsys.modelapi.dto.PSSysSearchBarLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchBarLogicService
extends IPSModelService<PSSysSearchBarLogic, PSSysSearchBarLogicDTO> {
    public List<PSSysSearchBarLogic> listByPSSysSearchBar(PSSysSearchBar var1) throws Exception;

    public PSSysSearchBarLogic get(PSSysSearchBar var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchBarLogicDTO> listDTOByPSSysSearchBar(String var1) throws Exception;
}

