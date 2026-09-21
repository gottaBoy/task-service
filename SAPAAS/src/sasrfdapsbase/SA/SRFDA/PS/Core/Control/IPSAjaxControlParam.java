/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IAjaxControlHandlerParam
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.control.IAjaxControlHandlerParam;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u754c\u9762\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewCtrl")
@PSModelRTIgnoreMeta
public interface IPSAjaxControlParam
extends IPSControlParam,
IAjaxControlHandlerParam {
    public Boolean isEnableItemPrivilege();

    public Integer getRecvAjaxActionMode();

    public String getPSAjaxControlHandlerId();

    public boolean isAutoLoad();

    public Boolean isShowBusyIndicator();

    public Boolean isLocalMode();
}

