/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFIVR;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSDEFIVRDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFIVRService
extends IPSModelService<PSDEFIVR, PSDEFIVRDTO> {
    public List<PSDEFIVR> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFIVR get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFIVRDTO> listDTOByPSDEForm(String var1) throws Exception;
}

