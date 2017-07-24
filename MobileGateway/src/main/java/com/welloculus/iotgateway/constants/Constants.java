package com.welloculus.iotgateway.constants;

public final class Constants {

	private Constants() {
	}

	public static final String ERRORMESSAGE = "errorMessage";
	public static final String SUCCESS = "success";
	public static final String RESPONSE_CODE = "responseCode";
	public static final String SUCCESSCODE = "200";
	public static final String YES = "YES";
	public static final String NO = "N";

	public static final String JSON_CONTENT = "application/json";
	public static final String ACCEPT = "accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String RESPONSE_CONTENT = "responseContent";

	public static final class ApiPath {
		private ApiPath() {
		}

		public static final String DEVICE_ID = "deviceId";
		public static final String USER_ID = "userId";
		public static final String PATIENT_ID = "patientId";
		public static final String MESSAGE_TYPE = "messageType";
		public static final String ID = "id";
		public static final String HEALTH_RECORDS = "/iotGateway/healthRecords";
		public static final String GET_HEALTH_RECORDS = "/getHealthRecords";
		public static final String ADD_HEALTH_RECORDS = "/addHealthRecords";
		public static final String UPDATE_PATIENT_BY_ID = "/updatePatient/{id}";
		public static final String DELETE_PATIENT_BY_ID = "/deletePatient/{id}";
		public static final String CREATE_PATIENT = "/createPatient";
	}
}
