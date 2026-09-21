/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="9F68C9F0-9F44-43BF-A889-50D03C126019", name="CurDEDER11_Custom", queries={@DEDataSetQuery(queryid="4F8043D6-416E-490A-940A-092A1D0952F6", queryname="CurDEDER11"), @DEDataSetQuery(queryid="03D0BF49-0585-48AE-8E20-41FCD6351277", queryname="CurDEDERCustom")})
public abstract class PSDERCurDEDER11_CustomDSModelBase
extends DEDataSetModelBase {
    public PSDERCurDEDER11_CustomDSModelBase() {
        this.initAnnotation(PSDERCurDEDER11_CustomDSModelBase.class);
    }
}

