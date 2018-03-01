package com.example.junae.doctorpointnew.interfaces;

import com.example.junae.doctorpointnew.ambulance.AmbulanceModel;
import com.example.junae.doctorpointnew.livesupport.SupportModel;
import com.example.junae.doctorpointnew.medicine_department.models.AppointDoctor;
import com.example.junae.doctorpointnew.medicine_department.models.Doctorsinfo;
import com.example.junae.doctorpointnew.user_feedback.FeedbackModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by USER on 11/8/2017.
 */

public interface ApiInterface {

    @GET("/Final_Project/Ambulance/ambulance.php")
    Call<List<AmbulanceModel>> getAmbulance();

    @GET("/Final_Project/Medicine/Medicine.php")
    //Call<List<Doctorsinfo>> getMedicineDoctors();
    Call<List<Doctorsinfo>> getMedicineDoctors();


    @GET("/Final_Project/Cardiology/Cardiology.php")
    Call<List<Doctorsinfo>> getCardiologyDoctors();

    @GET("/Final_Project/Dental/Dental.php")
    Call<List<Doctorsinfo>> getDentalDoctors();

    @GET("/Final_Project/Dibetologist/Dibetologist.php")
    Call<List<Doctorsinfo>> getDiabetisDoctors();
    @GET("/Final_Project/Surgery/Surgery.php")
    Call<List<Doctorsinfo>> getSurgenDoctors();


    @GET("/Final_Project/Gynecology/Gynecology.php")
    Call<List<Doctorsinfo>> getGynecologyDoctors();

    @GET("/Final_Project/Neuromedicine/Neuromedicine.php")
    Call<List<Doctorsinfo>> getNeuromedicineDoctors();

    @GET("/Final_Project/Neuromedicine/Neuromedicine.php")
    Call<List<Doctorsinfo>> getOrthopedicDoctors();

    @GET("/Final_Project/Urologist/Urologist.php")
    Call<List<Doctorsinfo>> getUrologyDoctors();

    @GET("/Final_Project/ENT/ENT.php")
    Call<List<Doctorsinfo>> getEntDoctors();

    @GET("/Final_Project/Gastrologist/Gastrologist.php")
    Call<List<Doctorsinfo>> getGastologyDoctors();



    @GET("/Final_Project/User_feedback/Medicine.php")
    Call<List<FeedbackModel>> getUserFeedback();





    @FormUrlEncoded
    @POST("/Final_Project/Medicine/Medicine_doctor_ptient.php")
    Call<AppointDoctor> insertPatientInfo(@Field("doctor_id") String doctor_id,
                                          @Field("patent_serial") String patent_serial,
                                          @Field("appoint_date") String appoint_date,
                                          @Field("patent_name") String patent_name,
                                          @Field("patent_address") String patent_address,
                                          @Field("patent_number") String patent_number);
/*
    @FormUrlEncoded
    @POST("/Final_Project/Cardiology/Cardiology_doctor_ptient.php")
    Call<AppointDoctor> insertCardiologyPatient(@Field("doctor_id") String doctor_id,
                                          @Field("patent_serial") String patent_serial,
                                          @Field("appoint_date") String appoint_date,
                                          @Field("patent_name") String patent_name,
                                          @Field("patent_address") String patent_address,
                                          @Field("patent_number") String patent_number);*/

    @FormUrlEncoded
    @POST("/Final_Project/Cardiology/Cardiology_doctor_ptient.php")
    Call<AppointDoctor> insertCarddioPatient(@Field("doctor_id") String doctor_id,
                                          @Field("patent_serial") String patent_serial,
                                          @Field("appoint_date") String appoint_date,
                                          @Field("patent_name") String patent_name,
                                          @Field("patent_address") String patent_address,
                                          @Field("patent_number") String patent_number);

    @FormUrlEncoded
    @POST("/Final_Project/Dental/Dental_doctor_ptient.php")
    Call<AppointDoctor> insertDentalPatient(@Field("doctor_id") String doctor_id,
                                                @Field("patent_serial") String patent_serial,
                                                @Field("appoint_date") String appoint_date,
                                                @Field("patent_name") String patent_name,
                                                @Field("patent_address") String patent_address,
                                                @Field("patent_number") String patent_number);

    @FormUrlEncoded
    @POST("/Final_Project/Dibetologist/Dibetologist_doctor_ptient.php")
    Call<AppointDoctor> insertDaibetisPatient(@Field("doctor_id") String doctor_id,
                                          @Field("patent_serial") String patent_serial,
                                          @Field("appoint_date") String appoint_date,
                                          @Field("patent_name") String patent_name,
                                          @Field("patent_address") String patent_address,
                                          @Field("patent_number") String patent_number);


    @FormUrlEncoded
    @POST("/Final_Project/Surgery/Surgery_doctor_ptient.php")
    Call<AppointDoctor> insertSurgeryPatient(@Field("doctor_id") String doctor_id,
                                              @Field("patent_serial") String patent_serial,
                                              @Field("appoint_date") String appoint_date,
                                              @Field("patent_name") String patent_name,
                                              @Field("patent_address") String patent_address,
                                              @Field("patent_number") String patent_number);
    @FormUrlEncoded
    @POST("/Final_Project/Gynecology/Gynecology_doctor_ptient.php")
    Call<AppointDoctor> insertGynecologyPatient(@Field("doctor_id") String doctor_id,
                                             @Field("patent_serial") String patent_serial,
                                             @Field("appoint_date") String appoint_date,
                                             @Field("patent_name") String patent_name,
                                             @Field("patent_address") String patent_address,
                                             @Field("patent_number") String patent_number);


    @FormUrlEncoded
    @POST("/Final_Project/Neuromedicine/Neuromedicine_doctor_ptient.php")
    Call<AppointDoctor> insertNeuromedicinePatient(@Field("doctor_id") String doctor_id,
                                                @Field("patent_serial") String patent_serial,
                                                @Field("appoint_date") String appoint_date,
                                                @Field("patent_name") String patent_name,
                                                @Field("patent_address") String patent_address,
                                                @Field("patent_number") String patent_number);
    @FormUrlEncoded
    @POST("/Final_Project/Orthopedics/Orthopedics_doctor_ptient.php")
    Call<AppointDoctor> insertOrthopedicPatient(@Field("doctor_id") String doctor_id,
                                                   @Field("patent_serial") String patent_serial,
                                                   @Field("appoint_date") String appoint_date,
                                                   @Field("patent_name") String patent_name,
                                                   @Field("patent_address") String patent_address,
                                                   @Field("patent_number") String patent_number);

    @FormUrlEncoded
    @POST("/Final_Project/Urologist/Urologist_doctor_ptient.php")
    Call<AppointDoctor> insertUrologyPatient(@Field("doctor_id") String doctor_id,
                                             @Field("patent_serial") String patent_serial,
                                             @Field("appoint_date") String appoint_date,
                                             @Field("patent_name") String patent_name,
                                             @Field("patent_address") String patent_address,
                                             @Field("patent_number") String patent_number);

    @FormUrlEncoded
    @POST("/Final_Project/ENT/ENT_doctor_ptient.php")
    Call<AppointDoctor> insertEntPatient(@Field("doctor_id") String doctor_id,
                                             @Field("patent_serial") String patent_serial,
                                             @Field("appoint_date") String appoint_date,
                                             @Field("patent_name") String patent_name,
                                             @Field("patent_address") String patent_address,
                                             @Field("patent_number") String patent_number);


    @FormUrlEncoded
    @POST("/Final_Project/Gastrologist/Gastrologist_doctor_ptient.php")
    Call<AppointDoctor> insertGastologyPatient(@Field("doctor_id") String doctor_id,
                                         @Field("patent_serial") String patent_serial,
                                         @Field("appoint_date") String appoint_date,
                                         @Field("patent_name") String patent_name,
                                         @Field("patent_address") String patent_address,
                                         @Field("patent_number") String patent_number);


    @FormUrlEncoded
    @POST("/Final_Project/LiveSupport/patient_support.php")
    Call<SupportModel> insertPatientStatus(@Field("patientName") String patient_email,
                                              @Field("patientStatus") String patent_status
                                              );

}
