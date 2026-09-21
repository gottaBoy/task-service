/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u540e\u53f0\u63d2\u4ef6\u652f\u6301\u63a5\u53e3", util=true)
public interface IPSSysSFPluginSupportable
extends IPSModelObject {
    public IPSSysSFPlugin getPSSysSFPlugin();
}

