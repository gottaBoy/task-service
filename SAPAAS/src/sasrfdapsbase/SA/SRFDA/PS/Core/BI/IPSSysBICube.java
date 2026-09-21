/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBICube")
public interface IPSSysBICube
extends IPSSysBISchemeObject,
IPSBICube {
    public Iterator<? extends IPSSysBICubeDimension> getAllPSSysBICubeDimensions() throws Exception;

    public IPSSysBICubeDimension getPSSysBICubeDimension(String var1) throws Exception;

    public IPSSysBICubeDimension getPSSysBICubeDimension(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysBICubeMeasure> getAllPSSysBICubeMeasures() throws Exception;

    public IPSSysBICubeMeasure getPSSysBICubeMeasure(String var1) throws Exception;

    public IPSSysBICubeMeasure getPSSysBICubeMeasure(String var1, boolean var2) throws Exception;
}

