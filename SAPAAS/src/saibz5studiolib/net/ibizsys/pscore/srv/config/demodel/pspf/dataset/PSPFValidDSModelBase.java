/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="61FFD9C3-3DDB-4959-94AE-724278FDD6D2", name="Valid", queries={@DEDataSetQuery(queryid="61FFD9C3-3DDB-4959-94AE-724278FDD6D2", queryname="Valid")})
public abstract class PSPFValidDSModelBase
extends DEDataSetModelBase {
    public PSPFValidDSModelBase() {
        this.initAnnotation(PSPFValidDSModelBase.class);
    }
}

