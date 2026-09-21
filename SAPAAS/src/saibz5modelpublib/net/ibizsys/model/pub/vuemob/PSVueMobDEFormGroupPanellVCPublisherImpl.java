/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSPublisherContext
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.vuemob;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.vuemob.PSVueMobDEFormDetailVCPublisherImpl;

public class PSVueMobDEFormGroupPanellVCPublisherImpl
extends PSVueMobDEFormDetailVCPublisherImpl {
    protected IPSDEFormGroupPanel iPSDEFormGroupPanel = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tIPSPublisherContext cannot be resolved to a type\n");
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tThe method Compare(String, String, boolean) is undefined for the type StringHelper\n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n");
    }

    @Override
    protected void onClose() {
        this.iPSDEFormGroupPanel = null;
        super.onClose();
    }

    public class ColumnLayoutGroup {
        private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList();

        public ArrayList<IPSGenerateCodeResult> getItems() {
            return this.itemCodeList;
        }
    }
}

