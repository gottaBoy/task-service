/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6a21\u578b\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysModelGroup")
public interface IPSSysModelGroup
extends IPSSystemObject {
    @Override
    public String getCodeName();

    public String getGroupTag();

    public String getGroupTag2();

    public String getGroupTag3();

    public String getGroupTag4();

    public Iterator<IPSSystemModule> getPSSystemModules() throws Exception;

    public String getSFRTObjectRepo();

    public String getPFRTObjectRepo();

    public String getPKGCodeName();

    public String getDTOCodeNameFormat();

    public String getAPICodeNameMode();

    public boolean isEnablePQL();

    public String getRuntimeType();
}

