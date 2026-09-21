/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrl
 *  net.ibizsys.model.control.drctrl.IPSDEDRTab
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.model.control.drctrl.IPSDEDRTabPageRuntime;
import net.ibizsys.model.control.drctrl.PSDEDRCtrlItemImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRTabPageImpl
extends PSDEDRCtrlItemImpl
implements IPSDEDRTabPageRuntime {
    private static final Log log = LogFactory.getLog(PSDEDRTabPageImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDRTab iPSDEDRTab, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        super.init(iPSModelStorageContext, (IPSDEDRCtrl)iPSDEDRTab, iPSDEDRDetail);
    }
}

