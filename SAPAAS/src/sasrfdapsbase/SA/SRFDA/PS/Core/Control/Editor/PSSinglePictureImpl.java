/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.PSPictureImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSSinglePictureImpl
extends PSPictureImpl {
    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6587\u4ef6\u6570\u91cf")
    public int getMaxFileCount() {
        return 1;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u5b58\u50a8[RAWCONTENT]", ignoredumpvalues="false")
    public boolean isRawContent() {
        return this.getEditorParam("RAWCONTENT", false);
    }
}

