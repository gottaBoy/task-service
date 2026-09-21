/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethodDTO
extends IPSModelObject,
IPSAppDataEntityObject,
IPSApplicationObject {
    public Iterator<? extends IPSAppDEMethodDTOField> getPSAppDEMethodDTOFields();

    @Override
    public String getCodeName();

    public String getSourceType();

    public String getType();

    public IPSDEMethodDTO getPSDEMethodDTO();

    public IPSAppDEMethodDTOField getPSAppDEMethodDTOField(IPSAppDEField var1, boolean var2) throws Exception;

    public IPSAppDataEntity getRefPSAppDataEntity() throws Exception;

    public IPSAppDEMethodDTO getRefPSAppDEMethodDTO() throws Exception;

    public IPSAppMethodDTO getSrcPSAppMethodDTO() throws Exception;
}

