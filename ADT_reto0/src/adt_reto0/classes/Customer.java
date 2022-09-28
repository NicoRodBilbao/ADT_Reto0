/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.classes;

import java.io.Serializable;

public class Customer implements Serializable, Comparable<Customer>{

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private String email;
    private Integer zip;
    private Integer phone;

    public Customer() {
    }
    
    public Customer(Integer id) {
        this.id = id;
    }
    
    public Customer(Integer id, String firstName, String lastName, String middleInitial, String street, String city, String state, String email, Integer zip, Integer phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zip = zip;
        this.phone = phone;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", street=" + street + ", city=" + city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phone=" + phone + '}';
    }

    @Override
    public int compareTo(Customer o) {
        return id.compareTo(o.getId());
    }

}
