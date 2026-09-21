/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSBISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBIDimension
extends IPSBISchemeObject {
    @Override
    public String getCodeName();

    public String getDimensionTag();

    public String getDimensionTag2();

    public Iterator<? extends IPSBIHierarchy> getAllPSBIHierarchies() throws Exception;

    public IPSBIHierarchy getPSBIHierarchy(String var1) throws Exception;

    public IPSBIHierarchy getPSBIHierarchy(String var1, boolean var2) throws Exception;
}

