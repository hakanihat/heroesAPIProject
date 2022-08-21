package com.tinqin.project.operation;

import com.tinqin.project.generics.OperationProcessor;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.model.biography.HeroBiographyRequest;
import com.tinqin.project.model.biography.HeroBiographyResponse;

public interface HeroBiographyProcess extends OperationProcessor<HeroBiographyRequest, HeroBiographyResponse> {
}
