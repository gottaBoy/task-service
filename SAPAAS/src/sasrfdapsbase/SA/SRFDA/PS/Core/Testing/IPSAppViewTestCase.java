/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase2;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5e94\u7528\u89c6\u56fe\u6d4b\u8bd5\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPVIEW"}, model="PSSysTestCase")
public interface IPSAppViewTestCase
extends IPSSysTestCase2 {
    public IPSAppView getPSAppView() throws Exception;
}

