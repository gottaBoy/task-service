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

@DEDataSet(id="C81708AF-1C39-4781-9AB0-B3ECC9F132AD", name="CurPF", queries={@DEDataSetQuery(queryid="E1EC5858-775C-4173-955F-79C4DBC85CD7", queryname="CurPF")})
public abstract class PSPFPubCodeCurPFDSModelBase
extends DEDataSetModelBase {
    public PSPFPubCodeCurPFDSModelBase() {
        this.initAnnotation(PSPFPubCodeCurPFDSModelBase.class);
    }
}

