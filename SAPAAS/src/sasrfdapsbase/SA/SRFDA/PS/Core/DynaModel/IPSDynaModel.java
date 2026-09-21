/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u52a8\u6001\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysDynaModelImpl")
public interface IPSDynaModel
extends IPSModelObject {
    public Iterator<? extends IPSDynaModelAttr> getPSDynaModelAttrs();

    public int getPSDynaModelAttrCount();

    public IPSDynaModelAttr getPSDynaModelAttr(String var1, boolean var2) throws Exception;

    public Object get(String var1, Object var2) throws Exception;

    public Object get(String var1) throws Exception;

    public boolean has(String var1) throws Exception;
}

