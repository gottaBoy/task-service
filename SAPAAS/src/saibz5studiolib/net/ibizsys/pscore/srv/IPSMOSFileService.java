/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 */
package net.ibizsys.pscore.srv;

import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;

public interface IPSMOSFileService<ET extends IEntity>
extends IPSCoreSysService<ET> {
    public static final String FILECAT_BOOKMARKS = "{BOOKMARKS}";
    public static final String FILECAT_RECENTS = "{RECENTS}";
    public static final String FILE_GROUP = "GROUP";
    public static final String FILE_DR = "DR";
    public static final String FILE_MODEL = "MODEL";
    public static final String FILE_LINK = "LINK";

    public PSMOSFile[] listFiles(PSMOSFile var1, String var2, IPSMOSFileFilter var3) throws Exception;

    public Map<String, String> getListDRDataFolderFields(Map<String, String> var1, PSMOSFile var2, IPSMOSFileFilter var3) throws Exception;

    public PSMOSFile getFile(PSMOSFile var1, String var2) throws Exception;

    public PSMOSFile getFile(IEntity var1) throws Exception;

    public PSMOSFile getFile(PSMOSFile var1, IEntity var2) throws Exception;

    public PSMOSFile getFile(PSMOSFile var1, IEntity var2, boolean var3) throws Exception;

    public PSMOSFile getFileSummary(PSMOSFile var1, String var2) throws Exception;

    public PSMOSFile getFileSummary(PSMOSFile var1, IEntity var2) throws Exception;

    public String getDRFolderPath(String var1, IEntity var2, String var3) throws Exception;

    public PSMOSFile[] pasteFiles(IEntity var1, PSMOSFile[] var2, String var3, IPSMOSFileAction var4) throws Exception;

    public String getFileName(IEntity var1) throws Exception;

    public PSHelpSection[] getPasteHelps(IEntity var1) throws Exception;

    public PSMOSFile createFile(PSMOSFile var1, String var2, Map<String, Object> var3) throws Exception;

    public void deleteFile(PSMOSFile var1, String var2) throws Exception;

    public void getDraftFile(IEntity var1, PSMOSFile var2, String var3) throws Exception;

    public String getFileWiki(PSMOSFile var1, String var2) throws Exception;

    public void updateFileWiki(PSMOSFile var1, String var2, String var3) throws Exception;

    public String getFileAutoWiki(PSMOSFile var1, String var2, String var3) throws Exception;

    public String getFileAutoWiki(IEntity var1, String var2) throws Exception;

    public String getFileAutoIssue(PSMOSFile var1, String var2, String var3) throws Exception;

    public String getFileAutoIssue(IEntity var1, String var2) throws Exception;
}

