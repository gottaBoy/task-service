/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u8f85\u52a9\u64cd\u4f5c\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFUtilUIAction")
public interface IPSWFUtilUIAction
extends IPSModelObject {
    public String getUtilType();

    public String getPSWorkflowId();

    public String getPSWFVersionId();

    public String getPSDEUIActionId();

    public IPSWorkflow getPSWorkflow() throws Exception;
}

