/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimensionObject;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u5c42\u6b21\u4f53\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIHierarchy")
public interface IPSSysBIHierarchy
extends IPSBIHierarchy,
IPSSysBIDimensionObject {
    public Iterator<? extends IPSSysBILevel> getAllPSSysBILevels() throws Exception;

    public IPSSysBILevel getPSSysBILevel(String var1) throws Exception;

    public IPSSysBILevel getPSSysBILevel(String var1, boolean var2) throws Exception;

    public boolean hasAll();

    public String getAllCaption();
}

