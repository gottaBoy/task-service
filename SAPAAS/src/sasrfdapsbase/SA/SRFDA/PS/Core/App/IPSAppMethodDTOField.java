/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;

@PSModelInterfaceMeta(title="\u5e94\u7528\u65b9\u6cd5DTO\u5c5e\u6027\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppMethodDTOField
extends IPSModelObject,
IPSModelSortable {
    public IPSAppMethodDTO getPSAppMethodDTO();

    public IPSSysMethodDTOField getPSSysMethodDTOField();

    public String getType();

    public int getStdDataType();

    @Override
    public String getCodeName();

    public IPSAppDataEntity getRefPSAppDataEntity() throws Exception;

    public IPSAppDEMethodDTO getRefPSAppDEMethodDTO() throws Exception;

    public IPSAppMethodDTO getRefPSAppMethodDTO() throws Exception;

    public String getSourceType();

    public boolean isAllowEmpty();

    public String getLogicName();

    public String getJsonFormat();
}

