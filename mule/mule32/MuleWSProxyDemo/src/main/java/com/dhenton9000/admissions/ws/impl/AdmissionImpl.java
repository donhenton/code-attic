/**
 * Please modify this class to meet your needs This class is not complete
 */
package com.dhenton9000.admissions.ws.impl;

import com.dhenton9000.admissions.components.ws.AdmissionType;
import com.dhenton9000.admissions.components.ws.AdmitSubject;
import org.slf4j.Logger;
import com.dhenton9000.admissions.components.ws.AdmitSubjectResponse;
import com.dhenton9000.admissions.components.ws.BillType;
import com.dhenton9000.admissions.components.ws.CareType;
import com.dhenton9000.admissions.components.ws.EpisodeType;
import java.util.Calendar;
import org.slf4j.LoggerFactory;

/**
 * This class was generated by Apache CXF 2.5.1 2012-12-12T15:22:32.800-06:00
 * Generated source version: 2.5.1
 *
 */
@javax.jws.WebService(
                      serviceName = "AdmissionService",
portName = "AdmissionPort",
targetNamespace = "http://www.mule-health.com/SOA/service/admission/1.0",
wsdlLocation = "src/main/resources/AdmissionService.wsdl",
endpointInterface = "com.dhenton9000.admissions.ws.impl.Admission")
public class AdmissionImpl implements Admission {

    private static final Logger logger = LoggerFactory.getLogger(AdmissionImpl.class.getName());

    /* (non-Javadoc)
     * @see com.dhenton9000.admissions.components.ws.Admission#admitSubject(com.dhenton9000.admissions.components.ws.AdmitSubject  parameters )*
     */
    @Override
    public AdmitSubjectResponse admitSubject(AdmitSubject parameters) {


        AdmitSubjectResponse _return = new AdmitSubjectResponse();
        String clientId = parameters.getReferer().getClientId();
        logger.debug("client id is "+clientId);
        BillType billItem = new BillType();
        billItem.setCostPerNight("29.95");
        billItem.setRunningTotal("99.99");
        billItem.setInitialStayEstimate("10");
        billItem.setStatus("Pending");
         
        EpisodeType episode = new EpisodeType();
        episode.setAdmission(AdmissionType.ELECTIVE);
        episode.setCare(CareType.PUBLIC);
        Calendar c = Calendar.getInstance();
        c.set(2012, Calendar.OCTOBER, 10);
        episode.setStartDate(c);
        Calendar c2 = Calendar.getInstance();
        c2.set(2012, Calendar.OCTOBER, 20);
        episode.setEndDate(c2);
        episode.setPatientId("2343434");
        episode.setEpisodeId(parameters.getSubject().getAddress2());
          
        _return.setBill(billItem);
        _return.setInsuranceCaseNumber("client id: "+clientId);
      //  _return.setInsuranceCoverStatus("cover status");
        _return.setEpisode(episode);
        
        
        
        logger.debug("zzz client cost is "+_return.getBill().getCostPerNight());
        return _return;
    }
}


/*
  
  
   <ns1:Episode>
         <episodeId>fred</episodeId>
            <ns1:PatientId>ted</ns1:PatientId>
            <admission>Emergency</admission>
            <startDate>2012-10-12</startDate>
            <endDate>2012-10-22</endDate>
            <care>Private</care>
         </ns1:Episode>


 <ns1:Bill>
            <costPerNight>29.99</costPerNight>
            <initialStayEstimate>10</initialStayEstimate>
            <runningTotal>49.99</runningTotal>
            <status>Pending</status>
         </ns1:Bill>

<ns1:InsuranceCaseNumber>stuff</ns1:InsuranceCaseNumber>
 
 
 
 */