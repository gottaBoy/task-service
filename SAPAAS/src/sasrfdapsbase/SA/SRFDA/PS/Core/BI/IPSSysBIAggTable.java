/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u805a\u5408\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIAggTable")
public interface IPSSysBIAggTable
extends IPSBIAggTable,
IPSSysBISchemeObject {
    public IPSSysBICube getPSSysBICube();

    public Iterator<? extends IPSSysBIAggColumn> getAllPSSysBIAggColumns() throws Exception;

    public IPSSysBIAggColumn getPSSysBIAggColumn(String var1) throws Exception;

    public IPSSysBIAggColumn getPSSysBIAggColumn(String var1, boolean var2) throws Exception;
}

