/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class WikiAttachment {
    private String fileName;
    private String filePath;
    private String branch;
    private Link link;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String string) {
        this.filePath = string;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String string) {
        this.branch = string;
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static class Link {
        private String url;
        private String markdown;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String string) {
            this.url = string;
        }

        public String getMarkdown() {
            return this.markdown;
        }

        public void setMarkdown(String string) {
            this.markdown = string;
        }

        public String toString() {
            return JacksonJson.toJsonString(this);
        }
    }
}

