/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

import java.util.List;
import java.util.Map;
import net.ibizsys.modelapi.util.IEntity;

public interface IPSModel
extends IEntity {
    public static final int DTO_DEFAULT = 0;
    public static final int DTO_MODE2 = 2;
    public static final int DTO_MODE3 = 3;
    public static final int DTO_MODE4 = 4;

    public IPSModel getSrfParent();

    public String getSrfFilePath();

    public String getSrfType();

    public String getSrfTag();

    public String getSrfDynaInstId();

    public boolean isFromDynaInst();

    public void init() throws Exception;

    public void reset();

    public Object get(String var1);

    public void set(String var1, Object var2);

    public boolean containsPSModels(String var1, boolean var2);

    public List<? extends IPSModel> getPSModels(String var1) throws Exception;

    public String getId();

    public void to(IPSModel var1, boolean var2, boolean var3) throws Exception;

    public void from(IPSModel var1, boolean var2, boolean var3) throws Exception;

    public Map<String, Object> any();
}

