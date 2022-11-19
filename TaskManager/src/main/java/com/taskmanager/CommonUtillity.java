package com.taskmanager;

import org.springframework.http.HttpStatus;

import com.taskmanager.model.ReturnMessage;

public class CommonUtillity {

	public static ReturnMessage getResponse(HttpStatus returnCode, String returnDesc, Object data) {
		ReturnMessage returnMessageDTO = new ReturnMessage();
		returnMessageDTO.setData(data);
		returnMessageDTO.setReturnCode(String.valueOf(returnCode.value()));
		returnMessageDTO.setReturnDescription(returnDesc);
		return returnMessageDTO;
	}
}
