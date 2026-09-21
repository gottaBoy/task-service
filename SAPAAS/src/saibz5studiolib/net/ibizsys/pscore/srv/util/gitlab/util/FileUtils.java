/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.Base64Helper
 */
package net.ibizsys.pscore.srv.util.gitlab.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Scanner;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.pscore.srv.util.gitlab.Constants;

public class FileUtils {
    public static File createUniqueFile(File file, String string) throws IOException {
        File file2 = new File(file, string);
        if (file2.createNewFile()) {
            return file2;
        }
        String string2 = "";
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            string2 = string.substring(n);
            string = string.substring(0, n);
        }
        int n2 = 0;
        while (!file2.createNewFile()) {
            String string3 = String.format("%s-%d%s", string, ++n2, string2);
            file2 = new File(file, string3);
        }
        return file2;
    }

    public static String readFileContents(File file) throws IOException {
        try (Scanner scanner = new Scanner(file);){
            scanner.useDelimiter("\\Z");
            String string = scanner.next();
            return string;
        }
    }

    public static String getReaderContentAsString(Reader reader) throws IOException {
        int n;
        char[] cArray = new char[2048];
        StringBuilder stringBuilder = new StringBuilder();
        while ((n = reader.read(cArray, 0, cArray.length)) >= 0) {
            stringBuilder.append(cArray, 0, n);
        }
        return stringBuilder.toString();
    }

    public static String getFileContentAsString(File file, Constants.Encoding encoding) throws IOException {
        if (encoding == Constants.Encoding.BASE64) {
            try (FileInputStream fileInputStream = new FileInputStream(file);){
                byte[] byArray = new byte[(int)file.length()];
                fileInputStream.read(byArray);
                String string = Base64Helper.encodeBytes((byte[])byArray);
                return string;
            }
        }
        return new String(Files.readAllBytes(file.toPath()));
    }
}

