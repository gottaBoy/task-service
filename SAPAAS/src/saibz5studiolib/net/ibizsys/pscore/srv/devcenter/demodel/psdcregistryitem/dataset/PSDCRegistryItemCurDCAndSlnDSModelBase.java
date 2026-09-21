/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="5F11E8B5-0BA7-454C-8D93-BD5CE0638DE1", name="CurDCAndSln", queries={@DEDataSetQuery(queryid="1DBA12A5-2BE8-4798-86B5-9C60411D6010", queryname="CurDC2"), @DEDataSetQuery(queryid="62110101-F600-4EE5-8FFF-180BA0238D01", queryname="CurSln")})
public abstract class PSDCRegistryItemCurDCAndSlnDSModelBase
extends DEDataSetModelBase {
    public PSDCRegistryItemCurDCAndSlnDSModelBase() {
        this.initAnnotation(PSDCRegistryItemCurDCAndSlnDSModelBase.class);
    }
}

