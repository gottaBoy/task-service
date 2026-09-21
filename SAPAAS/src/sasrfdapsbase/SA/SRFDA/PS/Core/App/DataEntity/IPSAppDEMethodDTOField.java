/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethodDTOField
extends IPSModelObject,
IPSModelSortable {
    public IPSAppDEMethodDTO getPSAppDEMethodDTO();

    public IPSDEMethodDTOField getPSDEMethodDTOField();

    public String getType();

    public int getStdDataType();

    @Override
    public String getCodeName();

    public IPSAppDEField getPSAppDEField();

    public IPSAppDEMethodDTO getRefPSAppDEMethodDTO() throws Exception;

    public IPSAppDataEntity getRefPSAppDataEntity() throws Exception;

    public IPSAppDEField getRefPickupPSAppDEField() throws Exception;

    public IPSAppDEDataSet getRefPSAppDEDataSet() throws Exception;

    public String getSourceType();

    public boolean isAllowEmpty();

    public String getLogicName();

    public String getJsonFormat();

    public boolean isListMap();
}

