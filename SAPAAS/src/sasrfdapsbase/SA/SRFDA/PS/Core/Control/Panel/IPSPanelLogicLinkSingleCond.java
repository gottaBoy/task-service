/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSPanelLogicLinkSingleCond
extends IPSPanelLogicLinkCond {
    public IPSPanelLogicParam getDstPanelLogicParam() throws Exception;

    public String getDstFieldName() throws Exception;

    public String getCondOp();

    public String getValue();
}

