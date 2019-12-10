/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceio;

/**
 *
 * @author root
 */
class PricedItem {
    double listprice;
    double negotiatedprice;
    double customercost;

    public double getListprice() {
        return listprice;
    }

    public void setListprice(double listprice) {
        this.listprice = listprice;
    }

    public double getNegotiatedprice() {
        return negotiatedprice;
    }

    public void setNegotiatedprice(double negotiatedprice) {
        this.negotiatedprice = negotiatedprice;
    }

    public double getCustomercost() {
        return customercost;
    }

    public void setCustomercost(double customercost) {
        this.customercost = customercost;
    }
    
    
    
    
}
