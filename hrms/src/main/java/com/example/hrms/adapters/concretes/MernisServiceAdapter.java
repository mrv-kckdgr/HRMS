package com.example.hrms.adapters.concretes;

import java.rmi.RemoteException;

import com.example.hrms.adapters.abstracts.CheckService;
import com.example.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CheckService{

	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
		boolean result;
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalNumber()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), 1997);
		}catch(RemoteException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}