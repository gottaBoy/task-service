package com.jspsmart.upload;

import java.util.ArrayList;
import java.util.List;

/**
 * Indexed file collection exposed by the legacy SmartUpload API.
 */
public class Files {
    private final List<SmartFile> files = new ArrayList<SmartFile>();

    void add(SmartFile file) {
        files.add(file);
    }

    public int getCount() {
        return files.size();
    }

    public SmartFile getFile(int index) {
        return files.get(index);
    }
}
