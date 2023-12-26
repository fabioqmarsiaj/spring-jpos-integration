package com.fabioqmarsiaj.springjposintegration;

import org.jpos.iso.IFB_NUMERIC;
import org.jpos.iso.ISOBasePackager;
import org.jpos.iso.ISOFieldPackager;

public class CustomPackager extends ISOBasePackager {
	protected ISOFieldPackager[] fields = {
			/*000*/ new IFB_NUMERIC(4, "Message Type Indicator", false),
			/*001*/ new IFB_NUMERIC(16, "Credit Card Number", false),

	};

	public CustomPackager() {
		super();
		setFieldPackager(fields);
	}
}
