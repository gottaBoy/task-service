/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u90e8\u4ef6\u4f1a\u540c\u65f6\u7ed1\u5b9a\u591a\u4e2a\u754c\u9762\u884c\u4e3a\u7ec4\uff0c\u8fd9\u4e9b\u884c\u4e3a\u7ec4\u7528\u9014\u7531\u90e8\u4ef6\u89e3\u91ca\u4f7f\u7528\u7528\u9014\uff0c\u4f8b\u5982\u5de6\u4fa7\u6ed1\u52a8\u3001\u53f3\u4fa7\u6ed1\u52a8\u7b49")
public interface IPSDEMobMDCtrl
extends IPSDEList {
    @Override
    public String getControlSubType();

    public IPSDEUIActionGroup getPSDEUIActionGroup() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup2() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup3() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup4() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup5() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup6() throws Exception;
}

