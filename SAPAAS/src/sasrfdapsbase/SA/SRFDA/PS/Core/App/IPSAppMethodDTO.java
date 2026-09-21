/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppMethodDTOField;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u65b9\u6cd5DTO\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppMethodDTO
extends IPSModelObject,
IPSApplicationObject {
    public Iterator<? extends IPSAppMethodDTOField> getPSAppMethodDTOFields();

    @Override
    public String getCodeName();

    public String getSourceType();

    public String getType();

    public IPSSysMethodDTO getPSSysMethodDTO();

    public String getTag();

    public String getTag2();
}

