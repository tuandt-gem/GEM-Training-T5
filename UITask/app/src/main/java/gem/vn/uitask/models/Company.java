package gem.vn.uitask.models;

/**
 * Created by Lush on 5/17/2017.
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
            new Company("KMS", "+84838486888", "http://www.kms-technology.com", "http://geothermalexpo.org/wp-content/uploads/kms-technologies-logo.jpg"),
            new Company("FPT Software", "0473007575", "https://www.fpt-software.com", "http://img.giaoduc.net.vn/Uploaded/quynhtien/2014_03_25/LogoFPT2.jpg"),
            new Company("BraveBits", " +84463260066", "http://www.bravebits.vn", "https://yt3.ggpht.com/-rYFRVCdakU8/AAAAAAAAAAI/AAAAAAAAAAA/k4g-PQGow-4/s900-c-k-no-mo-rj-c0xffffff/photo.jpg"),
            new Company("TechKids", "+841653005670", "http://techkids.vn", "https://static.topcv.vn/company_logos/techkids-coding-school-5839bff44088b.jpg")
    };

}
