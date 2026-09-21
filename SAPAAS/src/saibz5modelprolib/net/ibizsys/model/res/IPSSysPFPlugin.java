/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystemObject
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.pf.IPSPFPlugin;
import net.ibizsys.model.pf.IPSPFPluginTempl;

public interface IPSSysPFPlugin
extends IPSSystemObject,
IPSPFPlugin {
    @Override
    public String getPFPluginTag();

    @Override
    public String getPFPluginType();

    @Override
    public String getCode(String var1, String var2, String var3, Object var4, Object var5, Object var6) throws Exception;

    @Override
    public String getCode(String var1, String var2, String var3, String var4, Object var5, Object var6, Object var7) throws Exception;

    @Override
    public String getCode(String var1) throws Exception;

    @Override
    public String getCode(String var1, String var2) throws Exception;

    @Override
    public boolean hasCode(String var1) throws Exception;

    @Override
    public boolean hasCode(String var1, String var2) throws Exception;

    @Override
    public boolean hasCode(String var1, String var2, String var3, String var4) throws Exception;

    @Override
    public boolean hasCode2(String var1) throws Exception;

    @Override
    public boolean hasCode3(String var1) throws Exception;

    @Override
    public boolean hasCode4(String var1) throws Exception;

    @Override
    public String getCode2(String var1) throws Exception;

    @Override
    public String getCode3(String var1) throws Exception;

    @Override
    public String getCode4(String var1) throws Exception;

    @Override
    public String getPSPFPluginId();

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String var1, String var2, boolean var3) throws Exception;
}

