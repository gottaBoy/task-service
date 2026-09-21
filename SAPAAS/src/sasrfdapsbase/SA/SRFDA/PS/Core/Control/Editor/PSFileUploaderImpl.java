/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSFileUploader;
import SA.SRFDA.PS.Core.Control.Editor.PSValueItemEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"FILEUPLOADER", "MOBMULTIFILEUPLOAD", "MOBSINGLEFILEUPLOAD", "FILEUPLOADERONE"})
public class PSFileUploaderImpl
extends PSValueItemEditorImpl
implements IPSFileUploader {
    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u6587\u4ef6\u6570\u91cf[MINFILECNT]")
    public int getMinFileCount() {
        return this.getEditorParam("MINFILECNT", 0);
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u540e\u7f00[FILEEXTS]")
    public String getFileExts() {
        return this.getEditorParam("FILEEXTS");
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6587\u4ef6\u6570\u91cf[MAXFILECNT]")
    public int getMaxFileCount() {
        return this.getEditorParam("MAXFILECNT", -1);
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6587\u4ef6\u5927\u5c0f[MAXFILESIZE]")
    public int getMaxFileSize() {
        return this.getEditorParam("MAXFILESIZE", -1);
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u5b58\u50a8\u5206\u7c7b[OSSCAT]")
    public String getOSSCat() {
        return this.getEditorParam("OSSCAT");
    }
}

