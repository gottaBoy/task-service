/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u9644\u52a0\u903b\u8f91\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethodLogic
extends IPSModelObject,
IPSAppDataEntityObject {
    public static final int ACTIONLOGICTYPE_SCRIPT = 2;

    public IPSAppDEMethod getPSAppDEMethod();

    public int getActionLogicType();

    public String getAttachMode();

    public String getScriptCode();

    public boolean isIgnoreException();
}

