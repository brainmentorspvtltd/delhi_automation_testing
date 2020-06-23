package com.brainmentors.clients;

import com.brainmentors.apps.EnhanceProducer;
import com.brainmentors.apps.Factory;
import com.brainmentors.apps.IProducer;

public class Consumer1 {

	public static void main(String[] args) {
		IProducer pr = Factory.getInstance();
		//IProducer pr = new EnhanceProducer();
//		pr.doNotShow();
		pr.show();
		pr.print();
		

	}

}
