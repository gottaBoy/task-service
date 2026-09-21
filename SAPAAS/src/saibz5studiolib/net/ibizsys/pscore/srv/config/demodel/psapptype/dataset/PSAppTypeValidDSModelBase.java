/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psapptype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="021591DA-09D2-4E5B-ACBD-104512B44070", name="Valid", queries={@DEDataSetQuery(queryid="021591DA-09D2-4E5B-ACBD-104512B44070", queryname="Valid")})
public abstract class PSAppTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSAppTypeValidDSModelBase() {
        this.initAnnotation(PSAppTypeValidDSModelBase.class);
    }
}

