/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfde.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8BE85397-2C20-4D2D-B664-772C2EDE3F95", name="CurWF", queries={@DEDataSetQuery(queryid="1D23FA7B-CD2A-49EA-A4E2-C631F478787C", queryname="CurWF")})
public abstract class PSWFDECurWFDSModelBase
extends DEDataSetModelBase {
    public PSWFDECurWFDSModelBase() {
        this.initAnnotation(PSWFDECurWFDSModelBase.class);
    }
}

