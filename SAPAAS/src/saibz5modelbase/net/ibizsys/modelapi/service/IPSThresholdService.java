/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSThreshold;
import net.ibizsys.modelapi.domain.PSThresholdGroup;
import net.ibizsys.modelapi.dto.PSThresholdDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSThresholdService
extends IPSModelService<PSThreshold, PSThresholdDTO> {
    public List<PSThreshold> listByPSThresholdGroup(PSThresholdGroup var1) throws Exception;

    public PSThreshold get(PSThresholdGroup var1, String var2, boolean var3) throws Exception;

    public List<PSThresholdDTO> listDTOByPSThresholdGroup(String var1) throws Exception;
}

