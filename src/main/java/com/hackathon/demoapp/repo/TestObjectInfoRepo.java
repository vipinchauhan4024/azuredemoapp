package com.hackathon.demoapp.repo;

import java.util.List;

import com.hackathon.demoapp.model.ToBuildDeliveryPrecision;

public interface TestObjectInfoRepo {

    void saveAll(List<ToBuildDeliveryPrecision> list);

}
