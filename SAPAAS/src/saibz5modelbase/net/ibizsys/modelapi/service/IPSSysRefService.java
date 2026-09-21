/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysRef;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysRefDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysRefService
extends IPSModelService<PSSysRef, PSSysRefDTO> {
    public List<PSSysRef> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysRef get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysRefDTO> listDTOByPSSystem(String var1) throws Exception;
}

