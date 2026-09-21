/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicBase
extends IPSDataEntityObject {
    public static final int LOGICHOLDER_NONE = 0;
    public static final int LOGICHOLDER_BACKEND = 1;
    public static final int LOGICHOLDER_FRONT = 2;
    public static final int LOGICHOLDER_BACKENDANDFRONT = 3;

    public String getDefaultParamName();

    @Override
    public String getCodeName();

    public String getLogicName();

    public String getLogicType();

    public int getLogicHolder();
}

