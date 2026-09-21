/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSValueItemEditor;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSValueItemEditorImpl
extends PSEditorImpl
implements IPSValueItemEditor {
    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0")
    public String getValueItemName() {
        return this.getPSEditorContainer().getValueItemName();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0\u96c6\u5408")
    public String[] getValueItemNames() {
        return this.getPSEditorContainer().getValueItemNames();
    }

    @Override
    protected boolean isEditorItemSimpleMode() {
        return true;
    }
}

