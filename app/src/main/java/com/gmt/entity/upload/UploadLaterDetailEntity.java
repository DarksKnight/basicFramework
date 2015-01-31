package com.gmt.entity.upload;

/**
 * Created by apple on 1/25/15.
 */
public class UploadLaterDetailEntity {
    private String result;
    private String imgBigSize;
    private String imgNormalSize;
    private String imgSmallSize;
    private String fileAttachId;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImgBigSize() {
        return imgBigSize;
    }

    public void setImgBigSize(String imgBigSize) {
        this.imgBigSize = imgBigSize;
    }

    public String getImgNormalSize() {
        return imgNormalSize;
    }

    public void setImgNormalSize(String imgNormalSize) {
        this.imgNormalSize = imgNormalSize;
    }

    public String getImgSmallSize() {
        return imgSmallSize;
    }

    public void setImgSmallSize(String imgSmallSize) {
        this.imgSmallSize = imgSmallSize;
    }

    public String getFileAttachId() {
        return fileAttachId;
    }

    public void setFileAttachId(String fileAttachId) {
        this.fileAttachId = fileAttachId;
    }
}
