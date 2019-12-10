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
class Product {
    private String productCode;
    private double listPrice;
    private double negotiatedPrice;  // Contract Price
    private double upcharge;
    private double clientSplit;
    private double clientCost;
    private double customerCost;
    private double netTotal;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getNegotiatedPrice() {
        return negotiatedPrice;
    }

    public void setNegotiatedPrice(double negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
    }

    public double getUpcharge() {
        return upcharge;
    }

    public void setUpcharge(double upcharge) {
        this.upcharge = upcharge;
    }

    public double getClientSplit() {
        return clientSplit;
    }

    public void setClientSplit(double clientSplit) {
        this.clientSplit = clientSplit;
    }

    public double getClientCost() {
        return clientCost;
    }

    public void setClientCost(double clientCost) {
        this.clientCost = clientCost;
    }

    public double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(double customerCost) {
        this.customerCost = customerCost;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }
    
    
}
