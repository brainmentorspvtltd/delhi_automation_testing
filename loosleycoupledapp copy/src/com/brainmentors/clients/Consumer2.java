package com.brainmentors.clients;

import com.brainmentors.apps.Factory;
import com.brainmentors.apps.IProducer;
import com.brainmentors.apps.Producer;

public class Consumer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProducer pr = Factory.getInstance();
		//IProducer pr = new Producer();
//		pr.doNotShow();
		pr.show();
		pr.print();
	}

}
