/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFValueRule;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFValueRuleService
extends IPSModelService<PSDEFValueRule, PSDEFValueRuleDTO> {
    public List<PSDEFValueRule> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEFValueRule get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEFValueRuleDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

