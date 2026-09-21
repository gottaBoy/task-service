/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicNodeBase
extends IPSModelObject {
    public String getLogicNodeType();

    @Override
    public String getCodeName();

    public boolean isParallelOutput();

    public Object getParam(String var1, Object var2);

    public int getLogicHolder();

    public int getLeftPos();

    public int getTopPos();

    public int getWidth();

    public int getHeight();
}

