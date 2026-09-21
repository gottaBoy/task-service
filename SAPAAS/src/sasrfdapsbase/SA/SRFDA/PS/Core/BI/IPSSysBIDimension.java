/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u5168\u5c40\u7ef4\u5ea6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIDimension")
public interface IPSSysBIDimension
extends IPSSysBISchemeObject,
IPSBIDimension {
    public Iterator<? extends IPSSysBIHierarchy> getAllPSSysBIHierarchies() throws Exception;

    public IPSSysBIHierarchy getPSSysBIHierarchy(String var1) throws Exception;

    public IPSSysBIHierarchy getPSSysBIHierarchy(String var1, boolean var2) throws Exception;
}

