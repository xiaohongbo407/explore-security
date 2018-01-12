package com.explore.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by xiaohb on 2018/1/10.
 */
public class ImageCode extends VaildateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code,int expireIn) {
        super(code,expireIn);
        this.image = image;

    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
