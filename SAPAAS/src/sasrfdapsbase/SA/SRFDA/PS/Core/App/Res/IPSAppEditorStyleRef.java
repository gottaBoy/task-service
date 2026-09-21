/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u7f16\u8f91\u5668\u6837\u5f0f\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9a\u4e49\u524d\u7aef\u5e94\u7528\u5bf9\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f\u7684\u5f15\u7528\uff0c\u6839\u636e\u4f7f\u7528\u81ea\u52a8\u8ba1\u7b97", model="PSSysEditorStyle")
public interface IPSAppEditorStyleRef
extends IPSApplicationObject,
IPSModelSortable {
    public IPSSysEditorStyle getPSSysEditorStyle();

    public String getRefTag();

    public String getContainerType();

    public IPSPFXCodeObject getRender();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getPluginCode();

    public boolean isExtendStyleOnly();

    public String getStyleCode();

    public String getEditorType();

    @Override
    public String getCodeName();
}

