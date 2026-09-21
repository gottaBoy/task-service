/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSValueItemEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6587\u4ef6\u4e0a\u4f20\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"FILEUPLOADER", "MOBMULTIFILEUPLOAD", "MOBSINGLEFILEUPLOAD", "FILEUPLOADERONE"})
public interface IPSFileUploader
extends IPSValueItemEditor {
    public static final String EDITORPARAM_MINFILECNT = "MINFILECNT";
    public static final String EDITORPARAM_FILEEXTS = "FILEEXTS";
    public static final String EDITORPARAM_MAXFILECNT = "MAXFILECNT";
    public static final String EDITORPARAM_MAXFILESIZE = "MAXFILESIZE";
    public static final String EDITORPARAM_OSSCAT = "OSSCAT";

    public int getMaxFileCount();

    public int getMinFileCount();

    public int getMaxFileSize();

    public String getFileExts();

    public String getOSSCat();
}

