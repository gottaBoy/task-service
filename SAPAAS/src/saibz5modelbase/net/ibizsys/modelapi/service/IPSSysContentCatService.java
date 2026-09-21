/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysContentCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysContentCatService
extends IPSModelService<PSSysContentCat, PSSysContentCatDTO> {
    public List<PSSysContentCat> listByPSSysContentCat(PSSysContentCat var1) throws Exception;

    public PSSysContentCat get(PSSysContentCat var1, String var2, boolean var3) throws Exception;

    public List<PSSysContentCatDTO> listDTOByPSSysContentCat(String var1) throws Exception;

    public List<PSSysContentCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysContentCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysContentCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysContentCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysContentCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysContentCatDTO> listDTOByPSSystem(String var1) throws Exception;

    public List<PSSysContentCat> listAllChild(PSSysContentCat var1) throws Exception;

    public List<PSSysContentCat> listAllByPSModule(PSModule var1) throws Exception;

    public List<PSSysContentCatDTO> listAllDTOByPSModule(String var1) throws Exception;

    public List<PSSysContentCat> listAllByPSSystem(PSSystem var1) throws Exception;

    public List<PSSysContentCatDTO> listAllDTOByPSSystem(String var1) throws Exception;
}

