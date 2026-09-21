/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeObject;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u7ef4\u5ea6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBICubeDimension")
public interface IPSSysBICubeDimension
extends IPSBICubeDimension,
IPSSysBICubeObject {
    public IPSSysBIDimension getPSSysBIDimension();

    public Iterator<? extends IPSSysBICubeLevel> getAllPSSysBICubeLevels() throws Exception;

    public IPSSysBICubeLevel getPSSysBICubeLevel(String var1) throws Exception;

    public IPSSysBICubeLevel getPSSysBICubeLevel(String var1, boolean var2) throws Exception;
}

