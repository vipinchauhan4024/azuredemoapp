package com.hackathon.demoapp.model;

import lombok.Data;

@Data
public class ToBuildDeliveryPrecision {

    private String buildLocation;
    private String toId;
    private String toType;
    private String phaseName ;
    private String phasetype;
    private String physicalBuildMaturity; 
    private String responsibleDecisionForum;
    private String objectNo;
    private String targetDelivery;
    private String planedDelivery;
    private String deliveryDate;
    private String reasonForLateDelivery;
    private String lateDeliveryResponsibleForum;
    private int gapInDays;
    private int month;
    private int successFullDelivery;

}

