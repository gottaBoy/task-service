/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u542f\u52a8\u5904\u7406\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"START"})
public interface IPSWFStartProcess
extends IPSWFProcess {
    public String getStartPSDEViewId();

    public String getMobStartPSDEViewId();

    public String getStartViewCodeName();

    public String getStartViewName();

    public String getMobStartViewCodeName();

    public String getMobStartViewName();

    public String getStartPSDEViewUserData();

    public String getMobStartPSDEViewUserData();

    public String getPSDEFormId();

    public String getFormCodeName();

    public String getMobPSDEFormId();

    public String getMobFormCodeName();
}

