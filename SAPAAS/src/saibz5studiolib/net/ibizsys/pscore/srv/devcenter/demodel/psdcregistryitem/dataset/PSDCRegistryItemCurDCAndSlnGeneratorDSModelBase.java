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

@DEDataSet(id="92A1AF1A-E85E-42D4-89FB-D7A490388DB7", name="CurDCAndSlnGenerator", queries={@DEDataSetQuery(queryid="C27C36FC-9BE7-4667-9D3E-C815705199D9", queryname="CurDCGenerator2"), @DEDataSetQuery(queryid="3AE84384-B2D7-4F75-97C0-B35F0CCD9869", queryname="CurSlnGenerator")})
public abstract class PSDCRegistryItemCurDCAndSlnGeneratorDSModelBase
extends DEDataSetModelBase {
    public PSDCRegistryItemCurDCAndSlnGeneratorDSModelBase() {
        this.initAnnotation(PSDCRegistryItemCurDCAndSlnGeneratorDSModelBase.class);
    }
}

