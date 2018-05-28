package in.dux.p013ab.websites;

/**
 * Created by root on 5/28/18.
 */

public class WebsiteDataModel {
    private String websiteName;
    private String websiteUrl;
    private String imageUrl;

    public WebsiteDataModel(String webName,String webUrl,String imgUrl) {
        websiteName = webName;
        websiteUrl = webUrl;
        imageUrl = imgUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
}
