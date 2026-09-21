/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.expbar.IPSTreeExpBar
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.expbar.IPSTreeExpBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQExpBarControllerCodePublisherImpl;

public class PSJQTreeExpBarControllerCodePublisherImpl
extends PSJQExpBarControllerCodePublisherImpl {
    protected IPSTreeExpBar iPSTreeExpBar = null;

    @Override
    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSTreeExpBar = (IPSTreeExpBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

