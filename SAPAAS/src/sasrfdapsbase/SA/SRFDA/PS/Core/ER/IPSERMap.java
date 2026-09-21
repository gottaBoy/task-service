/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.ER.IPSERMapNode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSERMap
extends IPSModelObject {
    @Override
    public String getCodeName();

    public Iterator<? extends IPSERMapNode> getPSERMapNodes();

    public String getERMapSN();
}

