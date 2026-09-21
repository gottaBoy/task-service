/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSPicture;
import SA.SRFDA.PS.Core.Control.Editor.PSFileUploaderImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"PICTURE", "MOBPICTURELIST", "MOBPICTURE", "PICTURE_ONE"})
public class PSPictureImpl
extends PSFileUploaderImpl
implements IPSPicture {
    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6587\u4ef6\u6570\u91cf")
    public int getMaxFileCount() {
        int nMaxCount = this.getEditorParam("MAXCOUNT", -1);
        if (nMaxCount > 0) {
            return nMaxCount;
        }
        return this.getEditorParam("MAXFILECNT", -1);
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u5b58\u50a8", ignoredumpvalues="false")
    public boolean isRawContent() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u5b58\u50a8\u5206\u7c7b[OSSCAT]")
    public String getOSSCat() {
        return this.getEditorParam("OSSCAT");
    }
}

