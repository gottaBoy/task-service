/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysmodelrepo.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="27B5F406-6975-4772-B094-EF3C8872A059", name="CurSlnAll", queries={@DEDataSetQuery(queryid="5920315F-313A-4DAD-A737-E6C39FFBC692", queryname="CurDCValid"), @DEDataSetQuery(queryid="1D5CC5BD-7D95-4633-85AD-8EF0B4DBA9FC", queryname="CurSlnValid")})
public abstract class PSDCSysModelRepoCurSlnAllDSModelBase
extends DEDataSetModelBase {
    public PSDCSysModelRepoCurSlnAllDSModelBase() {
        this.initAnnotation(PSDCSysModelRepoCurSlnAllDSModelBase.class);
    }
}

