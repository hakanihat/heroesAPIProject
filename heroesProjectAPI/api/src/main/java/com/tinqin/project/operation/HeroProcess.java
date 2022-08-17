package com.tinqin.project.operation;

import com.tinqin.project.generics.OperationProcessor;
import com.tinqin.project.model.HeroAppearanceRequest;
import com.tinqin.project.model.HeroAppearanceResponse;

public interface HeroProcess extends OperationProcessor <HeroAppearanceRequest, HeroAppearanceResponse> {
}
