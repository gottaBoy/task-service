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

@DEDataSet(id="4556B3DF-CB5B-49A7-92C5-49D2B04A7401", name="CurAppType", queries={@DEDataSetQuery(queryid="BC011567-3AFF-455F-8D65-E8A619D4B456", queryname="CurAppType"), @DEDataSetQuery(queryid="2C3E6EF1-6D6A-4355-A87C-17B558D6B771", queryname="CurAppType2")})
public abstract class PSPFCurAppTypeDSModelBase
extends DEDataSetModelBase {
    public PSPFCurAppTypeDSModelBase() {
        this.initAnnotation(PSPFCurAppTypeDSModelBase.class);
    }
}

