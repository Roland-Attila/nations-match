package org.fasttrackit.nationsmatch.transfer;

public class GetUsersRequest {

    private String partialFirstName;
    private String partialLastName;
    private Integer age;
    private Integer ageBetween;
    private String sameNationality;

    public String getPartialFirstName() {
        return partialFirstName;
    }

    public void setPartialFirstName(String partialFirstName) {
        this.partialFirstName = partialFirstName;
    }

    public String getPartialLastName() {
        return partialLastName;
    }

    public void setPartialLastName(String partialLastName) {
        this.partialLastName = partialLastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeBetween() {
        return ageBetween;
    }

    public void setAgeBetween(Integer ageBetween) {
        this.ageBetween = ageBetween;
    }

    public String getSameNationality() {
        return sameNationality;
    }

    public void setSameNationality(String sameNationality) {
        this.sameNationality = sameNationality;
    }

    @Override
    public String toString() {
        return "GetUsersRequest{" +
                "partialFirstName='" + partialFirstName + '\'' +
                ", partialLastName='" + partialLastName + '\'' +
                ", age=" + age +
                ", ageBetween=" + ageBetween +
                ", sameNationality='" + sameNationality + '\'' +
                '}';
    }
}
