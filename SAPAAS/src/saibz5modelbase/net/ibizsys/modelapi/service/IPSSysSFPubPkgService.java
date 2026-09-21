/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysSFPub;
import net.ibizsys.modelapi.domain.PSSysSFPubPkg;
import net.ibizsys.modelapi.dto.PSSysSFPubPkgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSFPubPkgService
extends IPSModelService<PSSysSFPubPkg, PSSysSFPubPkgDTO> {
    public List<PSSysSFPubPkg> listByPSSysSFPub(PSSysSFPub var1) throws Exception;

    public PSSysSFPubPkg get(PSSysSFPub var1, String var2, boolean var3) throws Exception;

    public List<PSSysSFPubPkgDTO> listDTOByPSSysSFPub(String var1) throws Exception;
}

