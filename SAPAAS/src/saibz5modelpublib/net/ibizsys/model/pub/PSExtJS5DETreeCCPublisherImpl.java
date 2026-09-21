/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.tree.IPSDETree
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.pub.PSExtJS5CtrlCodePublisherImpl;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

public class PSExtJS5DETreeCCPublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSDETree iPSDETree = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDETree = (IPSDETree)this.iPSControl;
        return super.onGenerateCode();
    }
}

