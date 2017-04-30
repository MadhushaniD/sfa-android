package com.example.ahmed.sfa.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DecimalFormat;

/**
 * Created by Ahmed on 3/19/2017.
 */


//same model will be used for sales return but order quantity will be return quantity;
public class SalesInvoiceModel implements Parcelable {
    //private Customer customer;
    private String id;
    private String Code;
    private String Product;
    private String BatchNumber;
    private String ExpiryDate;
    private double UnitPrice;
    private int stock;
    private int Shelf;
    private int Request;
    private int Order;
    private int Free;
    private double discountRate;
    private double LineValue;

    private double subtotalVal;
    private double discount;



    public SalesInvoiceModel(String id,String code, String product, String batchNumber, String expiryDate, double unitPrice,int Stock) {
        this.id = id;
        Code = code;
        Product = product;
        BatchNumber = batchNumber;
        ExpiryDate = expiryDate;
        UnitPrice = unitPrice;
        this.stock = Stock;
        Shelf=0;
        Request=0;
        Order=0;
        Free=0;
        discountRate=0;
        LineValue=0;
    }

    protected SalesInvoiceModel(Parcel in) {
        id = in.readString();
        Code = in.readString();
        Product = in.readString();
        BatchNumber = in.readString();
        ExpiryDate = in.readString();
        UnitPrice = in.readDouble();
        stock = in.readInt();
        Shelf = in.readInt();
        Request = in.readInt();
        Order = in.readInt();
        Free = in.readInt();
        discountRate = in.readDouble();
        LineValue = in.readDouble();
        subtotalVal = in.readDouble();
        discount = in.readDouble();
    }

    public static final Creator<SalesInvoiceModel> CREATOR = new Creator<SalesInvoiceModel>() {
        @Override
        public SalesInvoiceModel createFromParcel(Parcel in) {
            return new SalesInvoiceModel(in);
        }

        @Override
        public SalesInvoiceModel[] newArray(int size) {
            return new SalesInvoiceModel[size];
        }
    };

    private void calculateLineVal(){
        subtotalVal = ((Order)*UnitPrice);
        discount = (subtotalVal*discountRate/100);
        LineValue = subtotalVal - discount;
    }

    public String getCode() {
        return Code;
    }



    public void setCode(String code) {
        Code = code;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        BatchNumber = batchNumber;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
        calculateLineVal();
    }

    public int getShelf() {
        return Shelf;
    }

    public void setShelf(int shelf) {
        Shelf = shelf;
    }

    public int getRequest() {
        return Request;
    }

    public void setRequest(int request) {
        Request = request;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
        calculateLineVal();
    }

    public int getFree() {
        return Free;
    }

    public void setFree(int free) {
        Free = free;
        calculateLineVal();

    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
        calculateLineVal();
    }

    public Double getLineValue() {
        DecimalFormat format = new DecimalFormat("0.2f");
        return Double.parseDouble(format.format(LineValue));
    }

    public void setLineValue(double lineValue) {
        LineValue = lineValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof SalesInvoiceModel){
            if(this.getId().equals(((SalesInvoiceModel)obj).getId())){
                return true;
            }
        }
        return false;
    }

    public double getSubtotalVal() {
        return subtotalVal;
    }

    public double getDiscount() {
        return discount;
    }

    public int getInvoiceQuantity(){
        return getOrder()+getFree();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSubtotalVal(double subtotalVal) {
        this.subtotalVal = subtotalVal;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(Code);
        dest.writeString(Product);
        dest.writeString(BatchNumber);
        dest.writeString(ExpiryDate);
        dest.writeDouble(UnitPrice);
        dest.writeInt(stock);
        dest.writeInt(Shelf);
        dest.writeInt(Request);
        dest.writeInt(Order);
        dest.writeInt(Free);
        dest.writeDouble(discountRate);
        dest.writeDouble(LineValue);
        dest.writeDouble(subtotalVal);
        dest.writeDouble(discount);

    }
}