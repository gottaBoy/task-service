/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarGroup
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrl
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.control.drctrl.IPSDEDRBarItemRuntime;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.PSDEDRCtrlItemImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRBarItemImpl
extends PSDEDRCtrlItemImpl
implements IPSDEDRBarItemRuntime {
    private static final Log log = LogFactory.getLog(PSDEDRBarItemImpl.class);
    protected IPSDEDRBarGroup iPSDEDRBarGroup;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDRBar iPSDEDRBar, IPSDEDRBarGroup iPSDEDRBarGroup, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        this.iPSDEDRBarGroup = iPSDEDRBarGroup;
        super.init(iPSModelStorageContext, (IPSDEDRCtrl)iPSDEDRBar, iPSDEDRDetail);
    }

    public IPSDEDRBarGroup getPSDEDRBarGroup() {
        return this.iPSDEDRBarGroup;
    }
}

