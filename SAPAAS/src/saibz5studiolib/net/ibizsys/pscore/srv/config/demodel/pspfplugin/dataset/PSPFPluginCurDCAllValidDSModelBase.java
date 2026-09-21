/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="D55FC310-4535-43AF-9E22-F3C82E0296AF", name="CurDCAllValid", queries={@DEDataSetQuery(queryid="67152336-207B-4B7E-BCE2-6798DA438DF9", queryname="AllValid"), @DEDataSetQuery(queryid="6FD25B88-1A55-46CD-8F1B-3BE3C86CDF8C", queryname="DCValid")})
public abstract class PSPFPluginCurDCAllValidDSModelBase
extends DEDataSetModelBase {
    public PSPFPluginCurDCAllValidDSModelBase() {
        this.initAnnotation(PSPFPluginCurDCAllValidDSModelBase.class);
    }
}

