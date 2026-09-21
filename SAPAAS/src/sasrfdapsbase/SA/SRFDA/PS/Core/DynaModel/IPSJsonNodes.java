/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNode;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSJsonNodes<T extends IPSJsonNode>
extends IPSJsonNode,
IPSJsonNodeOwner {
    public Iterator<String> getItemNames();

    public T getItem(String var1, boolean var2) throws Exception;

    public Iterator<T> getItems();
}

