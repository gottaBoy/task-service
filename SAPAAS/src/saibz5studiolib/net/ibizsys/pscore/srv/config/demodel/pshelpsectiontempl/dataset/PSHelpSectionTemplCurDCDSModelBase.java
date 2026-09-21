/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpsectiontempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="79485D23-98F6-44E4-A9FB-C0F375552D0A", name="CurDC", queries={@DEDataSetQuery(queryid="B3735EBD-FBF5-48DE-B991-C69FBF50C4A8", queryname="CurDC"), @DEDataSetQuery(queryid="F0BF4186-F44C-4975-B16E-38E330AB51B7", queryname="Global")})
public abstract class PSHelpSectionTemplCurDCDSModelBase
extends DEDataSetModelBase {
    public PSHelpSectionTemplCurDCDSModelBase() {
        this.initAnnotation(PSHelpSectionTemplCurDCDSModelBase.class);
    }
}

