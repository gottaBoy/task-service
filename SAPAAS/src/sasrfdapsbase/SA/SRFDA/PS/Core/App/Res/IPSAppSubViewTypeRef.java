/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.Control.Panel.IPSViewLayoutPanel;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import com.fasterxml.jackson.databind.node.ObjectNode;

@PSModelInterfaceMeta(title="\u5e94\u7528\u524d\u7aef\u89c6\u56fe\u5b50\u6837\u5f0f\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9a\u4e49\u524d\u7aef\u5e94\u7528\u5bf9\u89c6\u56fe\u5b50\u6837\u5f0f\u7684\u5f15\u7528\uff0c\u6839\u636e\u4f7f\u7528\u81ea\u52a8\u8ba1\u7b97")
public interface IPSAppSubViewTypeRef
extends IPSApplicationObject,
IPSModelSortable {
    public IPSSubViewType getPSSubViewType();

    public String getRefTag();

    public String getViewType();

    public IPSPFXCodeObject getRender();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getPluginCode();

    public boolean isExtendStyleOnly();

    public ObjectNode getViewModel();

    public boolean isReplaceDefault();

    public String getTypeCode();

    public IPSViewLayoutPanel getPSViewLayoutPanel();
}

