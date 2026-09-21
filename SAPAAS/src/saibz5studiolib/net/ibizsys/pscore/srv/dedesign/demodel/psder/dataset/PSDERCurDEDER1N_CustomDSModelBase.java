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

@DEDataSet(id="FD5276B2-7C86-43A7-BEDB-68CC470AB76C", name="CurDEDER1N_Custom", queries={@DEDataSetQuery(queryid="FFD9F8C6-2F17-40F8-805C-355B1FFE69EA", queryname="CurDEDER1N"), @DEDataSetQuery(queryid="03D0BF49-0585-48AE-8E20-41FCD6351277", queryname="CurDEDERCustom")})
public abstract class PSDERCurDEDER1N_CustomDSModelBase
extends DEDataSetModelBase {
    public PSDERCurDEDER1N_CustomDSModelBase() {
        this.initAnnotation(PSDERCurDEDER1N_CustomDSModelBase.class);
    }
}

