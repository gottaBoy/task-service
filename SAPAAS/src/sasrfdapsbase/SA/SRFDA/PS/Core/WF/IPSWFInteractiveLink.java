/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFInteractiveLinkModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkRole;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u4ea4\u4e92\u5904\u7406\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"IAACTION"})
@PSModelPFIgnoreMeta
public interface IPSWFInteractiveLink
extends IPSWFLink,
IWFInteractiveLinkModel {
    public String getPSDEFormId();

    public String getFormCodeName();

    public String getFormName();

    public String getMobPSDEFormId();

    public String getMobFormCodeName();

    public String getMobFormName();

    public String getPSDEViewId();

    public String getMobPSDEViewId();

    public String getViewCodeName();

    public String getMobViewCodeName();

    public String getViewName();

    public String getMobViewName();

    public Iterator<IPSWFLinkRole> getPSWFLinkRoles();

    @Override
    public IPSWFInteractiveProcess getFromPSWFProcess() throws Exception;
}

