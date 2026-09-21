/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.ConfigPublisher;
import SA.SRFDA.Ctrl.IDAConfigHelperContext;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFramework.XML.XMLNode;

public interface IDAConfigPublisher<T extends IDAConfigPublishContext> {
    public void Init(IDAConfigHelperContext var1, ConfigPublisher var2) throws Exception;

    public String GetConfigId(T var1) throws Exception;

    public String GetConfigFilePath(String var1) throws Exception;

    public XMLNode Publish(T var1) throws Exception;
}

