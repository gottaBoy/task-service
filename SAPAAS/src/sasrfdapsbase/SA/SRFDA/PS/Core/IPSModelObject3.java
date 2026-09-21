/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSModelObject3 {
    public void registerRefPSModelObject(IPSModelObject var1);

    public Iterator<IPSModelObject> getRefPSModelObjects();
}

