/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDevSysDiffItem;
import java.util.ArrayList;
import net.ibizsys.paas.data.IDEFieldDiffItem;

@PSModelIgnoreMeta
public interface IPSModelDiffActionContext {
    public void addDiffItem(PSDevSysDiffItem var1, IPSModelDiffable var2) throws Exception;

    public void addDiffItem(PSDevSysDiffItem var1, IPSModelDiffable var2, ArrayList<IDEFieldDiffItem> var3) throws Exception;
}

