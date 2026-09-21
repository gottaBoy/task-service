/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSSubSysServiceAPIBase
extends IPSModelObject {
    public String getServicePath();

    public String getServiceParam();

    public String getServiceParam2();

    public String getAuthMode();

    public String getAuthAccessTokenUrl();

    public String getAuthClientId();

    public String getAuthClientSecret();

    public String getAuthParam();

    public String getAuthParam2();

    public int getAuthTimeout();
}

