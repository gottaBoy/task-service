/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSXmlNode;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodeOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSXmlNodes<T extends IPSXmlNode>
extends IPSXmlNodeOwner {
    public Iterator<T> getItems();
}

