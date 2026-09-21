/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppSBItemRS;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.dto.PSAppSBItemRSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppSBItemRSService
extends IPSModelService<PSAppSBItemRS, PSAppSBItemRSDTO> {
    public List<PSAppSBItemRS> listByPSAppStoryBoard(PSAppStoryBoard var1) throws Exception;

    public PSAppSBItemRS get(PSAppStoryBoard var1, String var2, boolean var3) throws Exception;

    public List<PSAppSBItemRSDTO> listDTOByPSAppStoryBoard(String var1) throws Exception;
}

