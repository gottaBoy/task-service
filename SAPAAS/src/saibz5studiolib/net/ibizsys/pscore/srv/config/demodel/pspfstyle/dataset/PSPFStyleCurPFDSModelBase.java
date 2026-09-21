/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="19E62C90-40B2-4638-B4CA-937E71D72C46", name="CurPF", queries={@DEDataSetQuery(queryid="18FFD83F-88DA-49FF-8926-BE02D2B7F236", queryname="CurPF"), @DEDataSetQuery(queryid="943D7766-B836-4144-BB4A-F4804EFE6140", queryname="CurPF2")})
public abstract class PSPFStyleCurPFDSModelBase
extends DEDataSetModelBase {
    public PSPFStyleCurPFDSModelBase() {
        this.initAnnotation(PSPFStyleCurPFDSModelBase.class);
    }
}

