/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeLevel;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u4f53\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBICubeHierarchy
extends IPSModelObject {
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSSysBIHierarchy getPSSysBIHierarchy();

    public IPSAppBICubeDimension getPSAppBICubeDimension();

    public String getHierarchyTag();

    public String getHierarchyTag2();

    public Iterator<IPSAppBICubeLevel> getPSAppBICubeLevels() throws Exception;

    public boolean hasAll();

    public String getAllCaption();
}

