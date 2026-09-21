/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWXLogic;
import net.ibizsys.modelapi.dto.PSWXLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXLogicService
extends IPSModelService<PSWXLogic, PSWXLogicDTO> {
    public List<PSWXLogic> listByPSWXAccount(PSWXAccount var1) throws Exception;

    public PSWXLogic get(PSWXAccount var1, String var2, boolean var3) throws Exception;

    public List<PSWXLogicDTO> listDTOByPSWXAccount(String var1) throws Exception;
}

