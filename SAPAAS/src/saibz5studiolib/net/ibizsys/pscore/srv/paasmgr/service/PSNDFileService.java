/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.codec.digest.DigestUtils
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.service.PSNDFileServiceBase;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSNDFileService
extends PSNDFileServiceBase {
    private static final Log log = LogFactory.getLog(PSNDFileService.class);

    public static String getNDFilePath(String string) {
        String string2 = "";
        while (string.length() > 0) {
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string2 = string2 + "/";
            }
            if (string.length() > 2) {
                string2 = string2 + string.substring(0, 2);
                string = string.substring(2);
                continue;
            }
            string2 = string2 + string;
            break;
        }
        return string2 + ".dat";
    }

    public static void putContentToRemote(PSNDFile pSNDFile) throws Exception {
        String string = pSNDFile.getFilePath();
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5185\u5bb9\u4e3a\u7a7a");
        }
        File file = File.createTempFile("ibiz", ".dat");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(file), "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(string);
        bufferedWriter.flush();
        bufferedWriter.close();
        pSNDFile.setFilePath(file.getCanonicalPath());
        PSNDFileService.putToRemote(pSNDFile);
    }

    public static void putToRemote(PSNDFile pSNDFile) throws Exception {
        Object object;
        String string = pSNDFile.getFilePath();
        File file = new File(string);
        if (!file.exists()) {
            throw new Exception("\u76ee\u6807\u6587\u4ef6\u4e0d\u5b58\u5728");
        }
        String string2 = DigestUtils.md5Hex((InputStream)new FileInputStream(string));
        pSNDFile.setFileObjSize(Double.valueOf(file.length() / 1024L));
        pSNDFile.setFileHashCode(string2);
        pSNDFile.setPSNDFileId(string2);
        String string3 = PSNDFileService.getNDFilePath(string2);
        String string4 = PSStudioEnvHelper.getCurrent().getNDCacheFolder();
        String string5 = string4 + File.separator + string3;
        String string6 = "";
        string6 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python3 %1$s%2$spyutils%2$sremotefileput.py %3$s %4$s %5$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string, (Object)string5, (Object)string3) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sremotefileput.py %3$s %4$s %5$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string, (Object)string5, (Object)string3);
        try {
            object = PSStudioEnvHelper.getCurrent().executeBat(string6);
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
        pSNDFile.setFilePath(string5);
        object = new File(string5);
        if (!((File)object).exists()) {
            throw new Exception("\u7f13\u5b58\u6587\u4ef6\u4e0d\u5b58\u5728");
        }
    }

    public static void getContentFromRemote(PSNDFile pSNDFile) throws Exception {
        PSNDFileService.getFromRemote(pSNDFile);
    }

    public static void getFromRemote(PSNDFile pSNDFile) throws Exception {
        String string = PSStudioEnvHelper.getCurrent().getNDCacheFolder();
        String string2 = PSNDFileService.getNDFilePath(pSNDFile.getPSNDFileId());
        String string3 = string + File.separator + string2;
        pSNDFile.setFilePath(string3);
        File file = new File(string3);
        if (file.exists()) {
            if (file.length() > 0L) {
                return;
            }
            file.delete();
        }
        String string4 = "";
        string4 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python3 %1$s%2$spyutils%2$sremotefileget.py %3$s %4$s ", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)string2) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sremotefileget.py %3$s %4$s ", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)string2);
        try {
            PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string4);
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
        if (!file.exists()) {
            throw new Exception("\u7f13\u5b58\u6587\u4ef6\u4e0d\u5b58\u5728");
        }
    }
}

