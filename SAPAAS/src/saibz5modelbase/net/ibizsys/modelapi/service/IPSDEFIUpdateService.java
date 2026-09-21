/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFIUpdate;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFIUpdateService
extends IPSModelService<PSDEFIUpdate, PSDEFIUpdateDTO> {
    public List<PSDEFIUpdate> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFIUpdate get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFIUpdateDTO> listDTOByPSDEForm(String var1) throws Exception;
}

