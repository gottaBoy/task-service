/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormLogic;
import net.ibizsys.modelapi.dto.PSDEFormLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFormLogicService
extends IPSModelService<PSDEFormLogic, PSDEFormLogicDTO> {
    public List<PSDEFormLogic> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFormLogic get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFormLogicDTO> listDTOByPSDEForm(String var1) throws Exception;
}

