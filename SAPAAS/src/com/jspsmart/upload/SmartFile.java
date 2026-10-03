package com.jspsmart.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.fileupload.FileItem;

/**
 * File facade compatible with the subset of JSP SmartUpload used by task7.
 */
public class SmartFile {
    private final FileItem fileItem;
    private final String fileName;

    SmartFile(FileItem fileItem) {
        this.fileItem = fileItem;
        this.fileName = normalizeFileName(fileItem == null ? null : fileItem.getName());
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExt() {
        if (fileName == null) {
            return "";
        }
        int dot = fileName.lastIndexOf('.');
        if (dot < 0 || dot == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(dot + 1);
    }

    public int getSize() {
        if (fileItem == null) {
            return 0;
        }
        long size = fileItem.getSize();
        return size > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) size;
    }

    public long getSizeLong() {
        return fileItem == null ? 0L : fileItem.getSize();
    }

    public String getContentType() {
        return fileItem == null ? null : fileItem.getContentType();
    }

    public boolean isMissing() {
        return fileItem == null || fileItem.getName() == null || fileItem.getName().length() == 0;
    }

    public void saveAs(String path) throws IOException {
        if (path == null) {
            throw new IOException("Upload destination is null");
        }
        File destination = new File(path);
        File parent = destination.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs() && !parent.exists()) {
            throw new IOException("Cannot create upload destination directory: " + parent);
        }
        try {
            fileItem.write(destination);
        } catch (Exception ex) {
            copyTo(destination);
        }
    }

    public void saveAs(String path, int permissions) throws IOException {
        saveAs(path);
    }

    private void copyTo(File destination) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = fileItem.getInputStream();
            output = new FileOutputStream(destination);
            byte[] buffer = new byte[8192];
            int count;
            while ((count = input.read(buffer)) != -1) {
                output.write(buffer, 0, count);
            }
        } finally {
            close(input);
            close(output);
        }
    }

    private static String normalizeFileName(String value) {
        if (value == null) {
            return "";
        }
        int slash = Math.max(value.lastIndexOf('/'), value.lastIndexOf('\\'));
        return slash >= 0 ? value.substring(slash + 1) : value;
    }

    private static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ignored) {
            }
        }
    }

    private static void close(OutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ignored) {
            }
        }
    }
}
