/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeHierarchy;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u4f53\u7cfb\u5c42\u7ea7\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBICubeLevel
extends IPSModelObject {
    public IPSAppBICubeHierarchy getPSAppBICubeHierarchy();

    public IPSSysBICubeLevel getPSSysBICubeLevel();

    public IPSAppDEField getPSAppDEField();

    public String getLevelTag();

    public String getLevelTag2();

    public String getLevelType();

    public String getTextItemName();

    public boolean isUniqueMembers();

    public String getAggCaption();
}

