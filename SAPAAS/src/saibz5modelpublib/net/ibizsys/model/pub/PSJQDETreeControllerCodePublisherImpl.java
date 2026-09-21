/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.tree.IPSDETree
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQCtrlCodePublisherImpl;

public class PSJQDETreeControllerCodePublisherImpl
extends PSJQCtrlCodePublisherImpl {
    protected IPSDETree iPSDETree = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDETree = (IPSDETree)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

