package com.zabetan.behpardakht.ipg.springbootsoapclient;

import com.zabetan.behpardakht.ipg.schemas.BpPayRequest;
import com.zabetan.behpardakht.ipg.schemas.BpPayRequestResponse;
import com.zabetan.behpardakht.ipg.schemas.ObjectFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBElement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSoapClientApplicationTests {

	@Autowired
	private SOAPConnector soapConnector;

	@Test
	public void contextLoads() {
		BpPayRequest request = new BpPayRequest();
		request.setTerminalId(00000); //terminal ID
		request.setUserName("Username");
		request.setUserPassword("Password");
		request.setOrderId(13);
		request.setAmount(1000);
		request.setLocalDate("20170808");
		request.setLocalTime("101010");
		request.setAdditionalData("");
		request.setCallBackUrl("");
		request.setPayerId(0);
		ObjectFactory objectFactory = new ObjectFactory();
		objectFactory.createBpPayRequest(request);

		JAXBElement<BpPayRequestResponse> object = (JAXBElement<BpPayRequestResponse>) soapConnector.callWebService("https://bpm.shaparak.ir/pgwchannel/services/pgw", objectFactory.createBpPayRequest(request));
		BpPayRequestResponse bp = (BpPayRequestResponse)object.getValue();
		System.out.println("Got Response As below ========= : ");
		System.out.println("Return : "+bp.getReturn());
	}

}
