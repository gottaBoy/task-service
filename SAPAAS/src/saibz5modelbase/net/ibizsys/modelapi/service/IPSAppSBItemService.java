/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppSBItem;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.dto.PSAppSBItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppSBItemService
extends IPSModelService<PSAppSBItem, PSAppSBItemDTO> {
    public List<PSAppSBItem> listByPSAppStoryBoard(PSAppStoryBoard var1) throws Exception;

    public PSAppSBItem get(PSAppStoryBoard var1, String var2, boolean var3) throws Exception;

    public List<PSAppSBItemDTO> listDTOByPSAppStoryBoard(String var1) throws Exception;
}

