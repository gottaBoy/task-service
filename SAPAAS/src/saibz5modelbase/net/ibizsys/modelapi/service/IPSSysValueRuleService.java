/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysValueRule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysValueRuleService
extends IPSModelService<PSSysValueRule, PSSysValueRuleDTO> {
    public List<PSSysValueRule> listByPSModule(PSModule var1) throws Exception;

    public PSSysValueRule get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysValueRuleDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysValueRule> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysValueRule get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysValueRuleDTO> listDTOByPSSystem(String var1) throws Exception;
}

