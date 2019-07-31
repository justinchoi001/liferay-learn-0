package com.acme.q4b9.internal.commerce.tax.engine;

import com.liferay.commerce.exception.CommerceTaxEngineException;
import com.liferay.commerce.tax.CommerceTaxCalculateRequest;
import com.liferay.commerce.tax.CommerceTaxEngine;
import com.liferay.commerce.tax.CommerceTaxValue;

import java.util.Locale;

public class Q4B9CommerceTaxEngine implements CommerceTaxEngine {

	@Override
	public CommerceTaxValue getCommerceTaxValue(CommerceTaxCalculateRequest commerceTaxCalculateRequest) throws CommerceTaxEngineException {
		return null;
	}

	@Override
	public String getDescription(Locale locale) {
		return null;
	}

	@Override
	public String getName(Locale locale) {
		return null;
	}
}
