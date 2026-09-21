/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.dataview.IPSDEDataView
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlCodePublisherImpl;

public class PSVueMobDEDataViewCodePublisherImpl
extends PSVueMobCtrlCodePublisherImpl {
    protected IPSDEDataView iPSDEDataView = null;
    public static final String CTRLPART_RECORD = "RECORD";
    public static final String CTRLPART_STORE = "STORE";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n");
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobDEDataViewCodePublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlCodePublisherImpl\n");
    }
}

