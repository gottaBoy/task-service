/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewpanelitem.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="69E00286-51BB-4D6A-8F9E-F2EFC9086A5D", name="CurPanelAllControl", queries={@DEDataSetQuery(queryid="B64380A1-A98E-4FB4-9CB2-6FA593781D7E", queryname="CurPanelControl"), @DEDataSetQuery(queryid="C029CCD0-555F-49F1-911C-BA853673FD7B", queryname="CurPanelCtrlPos")})
public abstract class PSSysViewPanelItemCurPanelAllControlDSModelBase
extends DEDataSetModelBase {
    public PSSysViewPanelItemCurPanelAllControlDSModelBase() {
        this.initAnnotation(PSSysViewPanelItemCurPanelAllControlDSModelBase.class);
    }
}

