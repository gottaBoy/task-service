/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 */
package net.ibizsys.model.codelist;

import java.util.Iterator;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.codelist.ICodeItem;

public interface IPSCodeItem
extends IPSModelObject,
ICodeItem,
IPSModelJsonExporter {
    public Iterator<IPSCodeItem> getPSCodeItems() throws Exception;

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSLanguageRes getTextPSLanguageRes();

    public boolean isShowAsEmtpy();
}

