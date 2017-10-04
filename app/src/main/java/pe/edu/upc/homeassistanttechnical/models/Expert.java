package pe.edu.upc.homeassistanttechnical.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jlosorio on 10/4/17.
 */

public class Expert {
    private Integer expertId;
    private String mail;
//    private String password;
    private String fname;
    private String lname;
    private String address;
    private String phone;
    private String gender;
    private String description;
    private Double latitude;
    private Double longitude;
    private String photo;
    private String birthday;

    public Expert(Integer expertId, String mail, String fname, String lname, String address, String phone, String gender, String description, Double latitude, Double longitude, String photo, String birthday) {
        this.expertId = expertId;
        this.mail = mail;
//        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photo = photo;
        this.birthday = birthday;
    }

    public Expert() {
    }

    public Integer getExpertId() {
        return expertId;
    }

    public Expert setExpertId(Integer expertId) {
        this.expertId = expertId;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Expert setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public Expert setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public Expert setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Expert setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Expert setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Expert setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Expert setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Expert setLatitude(Double lalitude) {
        this.latitude = lalitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Expert setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Expert setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public Expert setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putInt("expertId", expertId);
        bundle.putString("mail", mail);
//        bundle.putString("password", password);
        bundle.putString("fname", fname);
        bundle.putString("lname", lname);
        bundle.putString("address", address);
        bundle.putString("phone", phone);
        bundle.putString("gender", gender);
        bundle.putString("description", description);
        bundle.putDouble("latitude", latitude);
        bundle.putDouble("longitude", longitude);
        bundle.putString("photo", photo);
        bundle.putString("birthday", birthday.toString());

        return bundle;
    }

    public static Expert from(Bundle bundle){
        Expert expert = new Expert();

        expert.setExpertId(bundle.getInt("expertId"))
                .setMail(bundle.getString("mail"))
//                .setPassword(bundle.getString("password"))
                .setFname(bundle.getString("fname"))
                .setLname(bundle.getString("lname"))
                .setAddress(bundle.getString("address"))
                .setPhone(bundle.getString("phone"))
                .setGender(bundle.getString("gender"))
                .setDescription(bundle.getString("description"))
                .setLatitude(bundle.getDouble("latitude"))
                .setLongitude(bundle.getDouble("longitude"))
                .setPhoto(bundle.getString("photo"))
                .setBirthday(bundle.getString("birthday"));

        return expert;
    }

    public static Expert from(JSONObject jsonExpert) {
        Expert expert = new Expert();

        try {
            expert.setExpertId(jsonExpert.getInt("expertId"))
                    .setMail(jsonExpert.getString("email"))
//                    .setPassword(jsonExpert.getString("password"))
                    .setFname(jsonExpert.getString("fname"))
                    .setLname(jsonExpert.getString("lname"))
                    .setAddress(jsonExpert.getString("address"))
                    .setPhone(jsonExpert.getString("phone"))
                    .setGender(jsonExpert.getString("gender"))
                    .setDescription(jsonExpert.getString("description"))
                    .setLatitude(jsonExpert.isNull("latitude") ? 0 : jsonExpert.getDouble("latitude"))
                    .setLongitude(jsonExpert.isNull("longitude") ? 0 : jsonExpert.getDouble("longitude"))
                    .setPhoto(jsonExpert.getString("photo").equals(JSONObject.NULL.toString()) ? "" : jsonExpert.getString("photo"))
                    .setBirthday(jsonExpert.getString("birthday"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return expert;
    }

    public static List<Expert> from(JSONArray jsonExperts) {
        List<Expert> experts = new ArrayList<>();

        for (int i = 0; i <= jsonExperts.length(); i++) {
            try {
                experts.add(Expert.from(jsonExperts.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return experts;
    }

}
