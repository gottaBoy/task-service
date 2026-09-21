/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysWFSetting;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysWFSettingDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysWFSettingService
extends IPSModelService<PSSysWFSetting, PSSysWFSettingDTO> {
    public List<PSSysWFSetting> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysWFSetting get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysWFSettingDTO> listDTOByPSSystem(String var1) throws Exception;
}

