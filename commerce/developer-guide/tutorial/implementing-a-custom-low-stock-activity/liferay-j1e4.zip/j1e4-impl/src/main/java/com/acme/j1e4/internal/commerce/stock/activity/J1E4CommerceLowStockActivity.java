package com.acme.j1e4.internal.commerce.stock.activity;

import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.stock.activity.CommerceLowStockActivity;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
	immediate = true,
	property = {
		"commerce.low.stock.activity.key=" + ExampleLowStockActivity.KEY,
		"commerce.low.stock.activity.priority:Integer=9"
	},
	service = CommerceLowStockActivity.class
)
public class J1E4CommerceLowStockActivity implements CommerceLowStockActivity {

	public static final String KEY = "example";

	@Override
	public void execute(CPInstance cpInstance) throws PortalException {
		if (_log.isWarnEnabled()) {
			_log.warn("Low stock for SKU: " + cpInstance.getSku());
		}
	}

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "add-warning-message");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		J1E4CommerceLowStockActivity.class);
}
