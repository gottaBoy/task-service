/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IExpBarModel
 */
package net.ibizsys.pswf.ctrlhandler;

import java.util.HashMap;
import net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.pswf.ctrlhandler.IWFExpBarHandler;
import net.ibizsys.pswf.ctrlmodel.IWFExpBarModel;

public abstract class WFExpBarHandlerBase
extends ExpBarHandlerBase
implements IWFExpBarHandler {
    private HashMap<String, String> extCntStateMap = new HashMap();

    protected abstract IWFExpBarModel getWFExpBarModel();

    protected IExpBarModel getExpBarModel() {
        return this.getWFExpBarModel();
    }
}

