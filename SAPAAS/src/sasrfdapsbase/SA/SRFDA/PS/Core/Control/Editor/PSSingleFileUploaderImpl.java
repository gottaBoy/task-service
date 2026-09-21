/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.PSFileUploaderImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSSingleFileUploaderImpl
extends PSFileUploaderImpl {
    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6587\u4ef6\u6570\u91cf")
    public int getMaxFileCount() {
        return 1;
    }
}

