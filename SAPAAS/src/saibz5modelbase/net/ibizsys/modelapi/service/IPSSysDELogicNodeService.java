/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDELogicNode;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDELogicNodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDELogicNodeService
extends IPSModelService<PSSysDELogicNode, PSSysDELogicNodeDTO> {
    public List<PSSysDELogicNode> listByPSModule(PSModule var1) throws Exception;

    public PSSysDELogicNode get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDELogicNodeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDELogicNode> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDELogicNode get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDELogicNodeDTO> listDTOByPSSystem(String var1) throws Exception;
}

