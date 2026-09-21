/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.expbar.IPSExpBar
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.expbar.IPSExpBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQCtrlCodePublisherImpl;

public class PSJQExpBarControllerCodePublisherImpl
extends PSJQCtrlCodePublisherImpl {
    protected IPSExpBar iPSExpBar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSExpBar = (IPSExpBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

