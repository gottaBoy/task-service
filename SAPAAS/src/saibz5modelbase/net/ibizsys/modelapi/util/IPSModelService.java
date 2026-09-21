/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

import java.util.List;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public interface IPSModelService<T extends PSModelBase, DTO extends PSModelDTOBase> {
    public List<T> listAll() throws Exception;

    public List<T> listAll(IPSModel var1) throws Exception;

    public List<T> listAll(IPSModel var1, boolean var2, boolean var3) throws Exception;

    public List<DTO> listAllDTO() throws Exception;

    public T createDomain();

    public DTO getDTO(String var1) throws Exception;

    public DTO getDTO(String var1, boolean var2) throws Exception;

    public T get(String var1) throws Exception;

    public String getModelTag(T var1) throws Exception;

    public T get(String var1, boolean var2) throws Exception;

    public DTO createDTO();

    public IPSModel getParentModel(DTO var1) throws Exception;

    public DTO toDTO(T var1) throws Exception;
}

