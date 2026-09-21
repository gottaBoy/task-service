/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormRF;
import net.ibizsys.modelapi.dto.PSDEFormRFDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFormRFService
extends IPSModelService<PSDEFormRF, PSDEFormRFDTO> {
    public List<PSDEFormRF> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFormRF get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFormRFDTO> listDTOByPSDEForm(String var1) throws Exception;
}

