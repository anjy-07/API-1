/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO.List;

import com.mycompany.DTO.Address;
import java.util.List;
/**
 *
 * @author shivangi
 */
public class Addresses
{
    private List<Address> addressList;
 
    public List<Address> getAddressList() {
        return addressList;
    }
 
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}