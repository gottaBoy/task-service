/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCodeItem;
import net.ibizsys.modelapi.domain.PSCodeList;
import net.ibizsys.modelapi.dto.PSCodeItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCodeItemService
extends IPSModelService<PSCodeItem, PSCodeItemDTO> {
    public List<PSCodeItem> listByPSCodeItem(PSCodeItem var1) throws Exception;

    public PSCodeItem get(PSCodeItem var1, String var2, boolean var3) throws Exception;

    public List<PSCodeItemDTO> listDTOByPSCodeItem(String var1) throws Exception;

    public List<PSCodeItem> listByPSCodeList(PSCodeList var1) throws Exception;

    public PSCodeItem get(PSCodeList var1, String var2, boolean var3) throws Exception;

    public List<PSCodeItemDTO> listDTOByPSCodeList(String var1) throws Exception;

    public List<PSCodeItem> listAllChild(PSCodeItem var1) throws Exception;

    public List<PSCodeItem> listAllByPSCodeList(PSCodeList var1) throws Exception;

    public List<PSCodeItemDTO> listAllDTOByPSCodeList(String var1) throws Exception;
}

