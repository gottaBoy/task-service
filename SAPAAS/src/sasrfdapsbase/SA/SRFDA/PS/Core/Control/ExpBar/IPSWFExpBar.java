/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.control.expbar.IWFExpBar
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import net.ibizsys.pswf.control.expbar.IWFExpBar;

@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5bfc\u822a\u680f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSWFExpBar
extends IPSExpBar,
IWFExpBar {
    public IPSWorkflow getPSWorkflow();

    public IPSDEWF getPSDEWF();
}

