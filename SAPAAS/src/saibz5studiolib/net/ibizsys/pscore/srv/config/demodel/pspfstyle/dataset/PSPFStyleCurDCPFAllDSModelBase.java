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

@DEDataSet(id="D01E5CA4-1B19-46EE-9288-FDB4A010DE82", name="CurDCPFAll", queries={@DEDataSetQuery(queryid="A71EFDE0-3731-4A2C-A807-65B5FFECEB4C", queryname="CurDCPF"), @DEDataSetQuery(queryid="34071F1E-28DF-4383-9CDC-E15DB82A9C5C", queryname="CurDCPF2")})
public abstract class PSPFStyleCurDCPFAllDSModelBase
extends DEDataSetModelBase {
    public PSPFStyleCurDCPFAllDSModelBase() {
        this.initAnnotation(PSPFStyleCurDCPFAllDSModelBase.class);
    }
}

