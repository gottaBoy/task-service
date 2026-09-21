/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFDataCtrl
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.WFServiceBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.pswf.core.IWFDataCtrl;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.WFServiceBase;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.DynaWFDataCtrl;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

public class DynaWFService
extends WFServiceBase {
    private IDynaSysModel iDynaSysModel = null;
    private IDynaWFModel iDynaWFModel = null;

    public void init(IDynaSysModel iDynaSysModel, IDynaWFModel iDynaWFModel) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.iDynaWFModel = iDynaWFModel;
        this.init((IWFModel)iDynaWFModel);
    }

    protected IWFDataCtrl createWFDataCtrl() throws Exception {
        DynaWFDataCtrl psJITWFDataCtrl = new DynaWFDataCtrl();
        psJITWFDataCtrl.init(this.iDynaSysModel, this.iDynaWFModel);
        return psJITWFDataCtrl;
    }
}

