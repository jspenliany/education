function ImgScale(ImgContent, maxWidth, maxHeight) {
    let image = new Image();
    image.src=ImgContent.src;

    let tmpXlen;
    let tmpYlen;

    if (image.width > 0 && image.height > 0){
        if (image.width/image.height >= maxWidth/maxHeight){
            if (image.width > maxWidth){
                tmpXlen = maxWidth;
                tmpYlen = (image.height * maxWidth) / image.width;
            } else {
                tmpYlen = image.height;
                tmpXlen = image.width;
            }
        } else {
            if (image.height >maxHeight){
                tmpYlen = maxHeight;
                tmpXlen = (image.width * maxHeight) / image.height;
            } else {
                tmpXlen = image.width;
                tmpYlen = image.height;
            }
        }

        ImgContent.height = tmpYlen;
        ImgContent.width = tmpXlen;
        ImgContent.alt = image.width + "*" + image.height;
    }
}