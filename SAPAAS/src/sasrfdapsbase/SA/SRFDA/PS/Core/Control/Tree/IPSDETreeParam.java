/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITreeHandlerParam
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.control.tree.ITreeHandlerParam;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDETreeParam
extends IPSMDAjaxControlParam,
ITreeHandlerParam {
    public String getPSDETreeId();

    public String getPSSysCounterId();

    public Boolean isEnableEdit();
}

