/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5d4c\u5165\u6d41\u7a0b\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSWFEmbedWFProcessBase
extends IPSWFProcess,
IWFEmbedWFProcessModelBase {
    public Iterator<IPSWFProcessSubWF> getPSWFProcessSubWFs();

    public int getPSWFProcessSubWFCount();

    public String getMultiInstMode();
}

