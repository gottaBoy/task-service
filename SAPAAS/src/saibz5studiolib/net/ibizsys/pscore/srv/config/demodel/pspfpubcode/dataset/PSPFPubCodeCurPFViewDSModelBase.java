/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpubcode.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="BF68899B-4DD6-44A3-A0BA-3D325472BF2F", name="CurPFView", queries={@DEDataSetQuery(queryid="E0788BF5-3255-4AE1-B6A0-13D65EF70385", queryname="CurPFView")})
public abstract class PSPFPubCodeCurPFViewDSModelBase
extends DEDataSetModelBase {
    public PSPFPubCodeCurPFViewDSModelBase() {
        this.initAnnotation(PSPFPubCodeCurPFViewDSModelBase.class);
    }
}

