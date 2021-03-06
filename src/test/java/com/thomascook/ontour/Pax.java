package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder = {
        "name",
        "surname",
        "age",
        "sex",
        "just_married",
        "identifier",
        "language",
        "birth_date",
        "pax_remark"
})
public class Pax {
    private String name = ""; //NAME C 15 Name
    private String surname = ""; //SURNAME C 30 Surname
    private int age = 0; //AGE N Age
    private String sex = ""; //SEX C 1 M, F, C, I Passenger type: M -Male, F - Female, C -Child, I – Infant
    private String just_married = ""; //JUST_MARRIED C 1 Y, N Just married: Y - Yes N - no
    private int identifier = 0; //IDENTIFIER N Passenger unique identifier within the booking.
    private String language = ""; //LANGUAGE C 6 Language of the passenger
    private String birth_date = ""; //BIRTH_DATE C 8 DDMMYYYY Birth date
    private List<Pax_remark> Pax_remark; //PAX_REMARK (0..X) See corresponding tag

    public String getName() {
        return name;
    }

    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name = "SURNAME")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "AGE")
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    @XmlElement(name = "SEX")
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJust_married() {
        return just_married;
    }

    @XmlElement(name = "JUST_MARRIED")
    public void setJust_married(String just_married) {
        this.just_married = just_married;
    }

    public int getIdentifier() {
        return identifier;
    }

    @XmlElement(name = "IDENTIFIER")
    public void setIdentifier(int indentifier) {
        this.identifier = indentifier;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement(name = "LANGUAGE")
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBirth_date() {
        return birth_date;
    }

    @XmlElement(name = "BIRTH_DATE")
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public List<Pax_remark> getPax_remark() {
        return Pax_remark;
    }

    @XmlElement(name = "PAX_REMARK")
    public void setPax_remark(List<Pax_remark> pax_remark) {
        Pax_remark = pax_remark;
    }
}
