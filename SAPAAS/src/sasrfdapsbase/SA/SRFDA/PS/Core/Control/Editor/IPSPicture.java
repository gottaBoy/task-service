/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSValueItemEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u7247\u4e0a\u4f20\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"PICTURE", "MOBPICTURELIST", "MOBPICTURE", "PICTURE_ONE"})
public interface IPSPicture
extends IPSValueItemEditor {
    public static final String EDITORPARAM_RAWCONTENT = "RAWCONTENT";
    public static final String EDITORPARAM_OSSCAT = "OSSCAT";

    public boolean isRawContent();

    public String getOSSCat();
}

