/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSAppViewHelpArticle
extends IPSHelpArticle {
    public IPSAppView getPSAppView();
}

