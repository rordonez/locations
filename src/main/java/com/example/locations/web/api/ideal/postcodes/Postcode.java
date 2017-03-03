package com.example.locations.web.api.ideal.postcodes;

public class Postcode {
    private String postcode;
    private String postcode_inward;
    private String postcode_outward;
    private String post_town;
    private String dependant_locality;
    private String double_dependant_locality;
    private String thoroughfare;
    private String dependant_thoroughfare;
    private String building_number;
    private String building_name;
    private String sub_building_name;
    private String po_box;
    private String department_name;
    private String organisation_name;
    private long udprn;
    private String umprn;
    private String postcode_type;
    private String su_organisation_indicator;
    private String delivery_point_suffix;
    private String line_1;
    private String line_2;
    private String line_3;
    private String premise;
    private String country;
    private String county;
    private String administrative_county;
    private String postal_county;
    private String traditional_county;
    private String district;
    private String ward;
    private double longitude;
    private double latitude;
    private int eastings;
    private String northings;

    public String getBuildingName() {
        return building_name;
    }

    public String getLine1() {
        return line_1;
    }

    public String getLine2() {
        return line_2;
    }

    public String getLine3() {
        return line_3;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPostcode_inward() {
        return postcode_inward;
    }

    public String getPostcode_outward() {
        return postcode_outward;
    }

    public String getPost_town() {
        return post_town;
    }

    public String getDependant_locality() {
        return dependant_locality;
    }

    public String getDouble_dependant_locality() {
        return double_dependant_locality;
    }

    public String getThoroughfare() {
        return thoroughfare;
    }

    public String getDependant_thoroughfare() {
        return dependant_thoroughfare;
    }

    public String getBuilding_number() {
        return building_number;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public String getSub_building_name() {
        return sub_building_name;
    }

    public String getPo_box() {
        return po_box;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getOrganisation_name() {
        return organisation_name;
    }

    public long getUdprn() {
        return udprn;
    }

    public String getUmprn() {
        return umprn;
    }

    public String getPostcode_type() {
        return postcode_type;
    }

    public String getSu_organisation_indicator() {
        return su_organisation_indicator;
    }

    public String getDelivery_point_suffix() {
        return delivery_point_suffix;
    }

    public String getLine_1() {
        return line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public String getLine_3() {
        return line_3;
    }

    public String getPremise() {
        return premise;
    }

    public String getCountry() {
        return country;
    }

    public String getCounty() {
        return county;
    }

    public String getAdministrative_county() {
        return administrative_county;
    }

    public String getPostal_county() {
        return postal_county;
    }

    public String getTraditional_county() {
        return traditional_county;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getEastings() {
        return eastings;
    }

    public String getNorthings() {
        return northings;
    }

    public static class Builder {

        private String line1;
        private String line2;
        private String line3;
        private String buildingName;

        private Builder() {}

        public static Builder aPostcode() {
            return new Builder();
        }

        public Builder withLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public Builder withLine2(String line2) {
            this.line2 = line2;
            return this;
        }

        public Builder withLine3(String line3) {
            this.line3 = line3;
            return this;
        }

        public Builder withBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Postcode build() {
            Postcode postcode = new Postcode();
            postcode.line_1 = this.line1;
            postcode.line_2 = this.line2;
            postcode.line_3 = this.line3;
            postcode.building_name = this.buildingName;
            return postcode;
        }

    }
}
