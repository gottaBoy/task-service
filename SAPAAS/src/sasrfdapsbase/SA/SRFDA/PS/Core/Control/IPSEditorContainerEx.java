/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7f16\u8f91\u5668\u5bb9\u5668\u6269\u5c55\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSEditorContainerEx
extends IPSModelObject {
    public Iterator<? extends IPSEditorContainer> getPSEditorContainers();
}

