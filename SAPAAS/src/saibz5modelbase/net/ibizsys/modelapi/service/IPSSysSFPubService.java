/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSFPub;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSFPubService
extends IPSModelService<PSSysSFPub, PSSysSFPubDTO> {
    public List<PSSysSFPub> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSFPub get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSFPubDTO> listDTOByPSSystem(String var1) throws Exception;
}

