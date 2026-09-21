/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBICube")
public interface IPSAppBICube
extends IPSModelObject {
    public IPSAppBIScheme getPSAppBIScheme();

    public IPSSysBICube getPSSysBICube();

    public IPSAppDataEntity getPSAppDataEntity();

    public Iterator<IPSAppBICubeDimension> getPSAppBICubeDimensions();

    public Iterator<IPSAppBICubeMeasure> getPSAppBICubeMeasures();

    public String getAccessKey();

    public IPSAppBICubeDimension getPSAppBICubeDimension(IPSSysBICubeDimension var1) throws Exception;

    public IPSAppBICubeMeasure getPSAppBICubeMeasure(IPSSysBICubeMeasure var1) throws Exception;

    public IPSUIActionGroup getPorletPSUIActionGroup();

    public IPSAppView getDrillDetailPSAppView();
}

