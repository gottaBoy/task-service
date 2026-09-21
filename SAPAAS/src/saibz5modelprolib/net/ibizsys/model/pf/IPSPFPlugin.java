/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.pf.IPSPFPluginTempl;

public interface IPSPFPlugin
extends IPSModelObject {
    public String getPFPluginTag();

    public String getPFPluginType();

    public String getCode(String var1, String var2, String var3, Object var4, Object var5, Object var6) throws Exception;

    public String getCode(String var1, String var2, String var3, String var4, Object var5, Object var6, Object var7) throws Exception;

    public String getCode(String var1) throws Exception;

    public String getCode(String var1, String var2) throws Exception;

    public boolean hasCode(String var1) throws Exception;

    public boolean hasCode(String var1, String var2) throws Exception;

    public boolean hasCode(String var1, String var2, String var3, String var4) throws Exception;

    public boolean hasCode2(String var1) throws Exception;

    public boolean hasCode3(String var1) throws Exception;

    public boolean hasCode4(String var1) throws Exception;

    public String getCode2(String var1) throws Exception;

    public String getCode3(String var1) throws Exception;

    public String getCode4(String var1) throws Exception;

    public String getPSPFPluginId();

    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    public IPSPFPluginTempl getPSPFPluginTempl(String var1, String var2, boolean var3) throws Exception;
}

