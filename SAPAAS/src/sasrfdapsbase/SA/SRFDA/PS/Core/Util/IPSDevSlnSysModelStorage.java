/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.IPSSystem;
import java.util.List;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;

public interface IPSDevSlnSysModelStorage {
    public PSDevSlnSys getPSDevSlnSys();

    public <T> List<T> select(String var1, ISelectCond var2, Class<T> var3) throws Exception;

    public <T> T selectOne(String var1, ISelectCond var2, Class<T> var3) throws Exception;

    public <T> T getByCodeName(String var1, ISelectCond var2, String var3, Class<T> var4) throws Exception;

    public <T> T getByName(String var1, ISelectCond var2, String var3, Class<T> var4) throws Exception;

    public <T> T getByTag(String var1, String var2, Class<T> var3) throws Exception;

    public void create(String var1, IEntity var2) throws Exception;

    public void update(String var1, IEntity var2) throws Exception;

    public void create(String var1, List<IEntity> var2) throws Exception;

    public void update(String var1, List<IEntity> var2) throws Exception;

    public IPSSystem getPSSystem() throws Exception;

    public String getLogInfo();
}

