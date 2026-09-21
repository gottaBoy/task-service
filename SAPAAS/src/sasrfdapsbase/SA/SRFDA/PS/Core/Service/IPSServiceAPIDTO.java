/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTOField;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSServiceAPIDTO
extends IPSModelObject {
    public Iterator<? extends IPSServiceAPIDTOField> getPSServiceAPIDTOFields();

    public String getType();
}

