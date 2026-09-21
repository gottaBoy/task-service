/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class FileHelper {
    public static String getTmpFileName(IWebContext iWebContext, String strFileName, String strFileExt) throws Exception {
        if (StringHelper.isNullOrEmpty(strFileName)) {
            strFileName = KeyValueHelper.genGuidEx();
        }
        if (iWebContext == null) {
            return StringHelper.format("%1$s%2$s%3$s", WebConfig.getCurrent().getTempPath(), strFileName, strFileExt);
        }
        String strFolder = StringHelper.format("%1$s%2$s%3$s", WebConfig.getCurrent().getTempPath(), iWebContext.getSessionId(), File.separator);
        File file = new File(strFolder);
        file.mkdirs();
        return StringHelper.format("%1$s%2$s%3$s%4$s%5$s", WebConfig.getCurrent().getTempPath(), iWebContext.getSessionId(), File.separator, strFileName, strFileExt);
    }

    public static net.ibizsys.psrt.srv.common.entity.File[] getFileList(String strFileList, SessionFactory sessionFactory) throws Exception {
        if (StringHelper.isNullOrEmpty(strFileList)) {
            return null;
        }
        ArrayList<net.ibizsys.psrt.srv.common.entity.File> fileList = new ArrayList<net.ibizsys.psrt.srv.common.entity.File>();
        FileService fileService = (FileService)ServiceGlobal.getService(FileService.class, sessionFactory);
        JSONArray ja = JSONArray.fromString((String)strFileList);
        int i = 0;
        while (i < ja.length()) {
            JSONObject jo = ja.getJSONObject(i);
            String strId = jo.optString("id");
            if (!StringHelper.isNullOrEmpty(strId)) {
                net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
                file.setFileId(strId);
                fileService.get(file);
                fileList.add(file);
            }
            ++i;
        }
        return fileList.toArray(new net.ibizsys.psrt.srv.common.entity.File[fileList.size()]);
    }

    public static String readFile(InputStream input) throws Exception {
        return FileHelper.readFile(input, null);
    }

    public static String readFile(InputStream input, String strEncoding) throws Exception {
        if (input == null) {
            throw new Exception("\u65e0\u6548\u8f93\u5165");
        }
        if (StringHelper.isNullOrEmpty(strEncoding)) {
            strEncoding = "UTF-8";
        }
        byte[] bcache = new byte[4096];
        int readSize = 0;
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            try {
                while ((readSize = input.read(bcache)) > 0) {
                    infoStream.write(bcache, 0, readSize);
                }
            }
            catch (IOException e1) {
                throw new Exception(e1);
            }
        }
        finally {
            try {
                input.close();
            }
            catch (IOException e) {
                throw new Exception(e);
            }
        }
        try {
            return infoStream.toString(strEncoding);
        }
        catch (UnsupportedEncodingException e) {
            throw new Exception(e);
        }
    }
}

