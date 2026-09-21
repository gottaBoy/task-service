/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeHierarchy;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBICubeDimension")
public interface IPSAppBICubeDimension
extends IPSModelObject {
    public IPSAppBICube getPSAppBICube();

    public IPSSysBICubeDimension getPSSysBICubeDimension();

    @Override
    public String getCodeName();

    public IPSAppDEField getPSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public String getDimensionTag();

    public String getDimensionTag2();

    public Iterator<IPSAppBICubeHierarchy> getPSAppBICubeHierarchies() throws Exception;

    public IPSAppCodeList getPSAppCodeList();

    public String getDimensionType();

    public String getDimensionFormula();

    public IPSAppDEUIAction getParamPSAppDEUIAction();

    public String getTextTemplate();

    public String getTipTemplate();

    public int getStdDataType();
}

