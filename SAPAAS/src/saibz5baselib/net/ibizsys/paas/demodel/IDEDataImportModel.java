/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.io.File;
import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataImportResult;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.demodel.IDataEntityModel;
import org.hibernate.SessionFactory;

public interface IDEDataImportModel
extends IDEDataImport,
IModelBase3 {
    public static final String FILETYPE_EXCEL = "EXCEL";
    public static final String FILETYPE_ACCESS = "ACCESS";

    public boolean importFile(File var1, String var2, ArrayList<IDEDataImportResult> var3) throws Exception;

    public boolean importFile(File var1, String var2, SessionFactory var3, ArrayList<IDEDataImportResult> var4) throws Exception;

    public IDataEntityModel getDEModel();
}

