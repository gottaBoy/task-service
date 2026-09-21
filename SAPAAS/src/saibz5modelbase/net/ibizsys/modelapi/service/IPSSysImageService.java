/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysImage;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysImageService
extends IPSModelService<PSSysImage, PSSysImageDTO> {
    public List<PSSysImage> listByPSModule(PSModule var1) throws Exception;

    public PSSysImage get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysImageDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysImage> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysImage get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysImageDTO> listDTOByPSSystem(String var1) throws Exception;
}

