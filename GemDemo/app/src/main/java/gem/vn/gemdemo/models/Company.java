package gem.vn.gemdemo.models;

/**
 * Created by Lush on 5/15/2017.
 */

public class Company {
    private String name;
    private String phone;
    private String websiteUrl;
    private String logoUrl;

    public Company(String name, String phone, String websiteUrl, String logoUrl) {
        this.name = name;
        this.phone = phone;
        this.websiteUrl = websiteUrl;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public static final Company[] COMPANIES = new Company[] {
            new Company("FPT Software", "0473007575", "https://www.fpt-software.com", "http://img.giaoduc.net.vn/Uploaded/quynhtien/2014_03_25/LogoFPT2.jpg")
            , new Company("KMS", "+84838486888", "http://www.kms-technology.com", "http://www.iujobhub.com/wp-content/uploads/2015/01/KMS-logo.png")
            , new Company("BraveBits", " +84463260066", "http://www.bravebits.vn", "http://i.imgur.com/8ONaQnl.png")
            , new Company("TechKids", "+841653005670", "http://techkids.vn", "http://codinginspiration.com/img/logos/Techkids.png")
    };

}
