/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDColumn;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBDColSet
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getLogicName();

    public boolean isDefault();

    public Iterator<? extends IPSBDColumn> getAllPSBDColumns();
}

