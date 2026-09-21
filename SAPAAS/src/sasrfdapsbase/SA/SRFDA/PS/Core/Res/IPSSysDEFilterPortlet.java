/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysDEFilterPortlet
extends IPSSysPortlet {
    public String getFilterPSDEDataSetId();

    public IPSDEDataSet getFilterPSDEDataSet();

    public Iterator<IPSDEDQCondition> getFilterPSDEDQConditions();
}

